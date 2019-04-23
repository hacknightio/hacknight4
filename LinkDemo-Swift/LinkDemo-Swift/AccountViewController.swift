//
//  AccountViewController.swift
//  LinkDemo-Swift
//
//  Created by Eliott Moreno on 4/16/19.
//  Copyright © 2019 Plaid Inc. All rights reserved.
//

import UIKit
import AWSRekognition

class AccountViewController: UIViewController, UIImagePickerControllerDelegate, UINavigationControllerDelegate {
    
    var token:String?
    @IBOutlet weak var accountTypeLabel: UILabel!
    @IBOutlet weak var balanceLabel: UILabel!
    @IBOutlet weak var CelebImageView: UIImageView!
    @IBOutlet weak var celebNameLabel: UILabel!
    
    var infoLinksMap: [Int:String] = [1000:""]
    var rekognitionObject:AWSRekognition?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "Account"
        // Do any additional setup after loading the view.
        
        let celebImage:Data = CelebImageView.image!.jpegData(compressionQuality: 0.2)!
        sendImageToRekognition(celebImageData: celebImage)
        
        test() { data in
            self.someMethod(data: data)
        }
    }
    
    func someMethod(data: Data) {
        let jsonArray = try? JSONSerialization.jsonObject(with: data, options: []) as? [String:Any]
        let account = jsonArray?["accounts"] as? [Any]
        let firstAccount = account?[Int.random(in: 0 ..< 3)] as? [String:Any]
        let accountName = (firstAccount?["name"]) as? String
        let balances = firstAccount?["balances"] as? [String:Any]
        let currentBalance = balances?["current"] as? Int
        print(String(currentBalance!))
        DispatchQueue.main.async {
            self.balanceLabel.text = String(currentBalance!)
            self.accountTypeLabel.text = accountName ?? "account doesn't exist"
        }
    }
    
    func sendImageToRekognition(celebImageData: Data){
        
        //Delete older labels or buttons
        DispatchQueue.main.async {
            [weak self] in
            for subView in (self?.CelebImageView.subviews)! {
                subView.removeFromSuperview()
            }
        }
        
        rekognitionObject = AWSRekognition.default()
        let celebImageAWS = AWSRekognitionImage()
        celebImageAWS?.bytes = celebImageData
        let celebRequest = AWSRekognitionRecognizeCelebritiesRequest()
        celebRequest?.image = celebImageAWS
        
        rekognitionObject?.recognizeCelebrities(celebRequest!){
            (result, error) in
            if error != nil{
                print(error!)
                return
            }
            
            //1. First we check if there are any celebrities in the response
            if ((result!.celebrityFaces?.count)! > 0){
                
                //2. Celebrities were found. Lets iterate through all of them
                for (index, celebFace) in result!.celebrityFaces!.enumerated(){
                    
                    //Check the confidence value returned by the API for each celebirty identified
                    if(celebFace.matchConfidence!.intValue > 50){ //Adjust the confidence value to whatever you are comfortable with
                        
                        //We are confident this is celebrity. Lets point them out in the image using the main thread
                        DispatchQueue.main.async {
                            [weak self] in
                            
                            //Create an instance of Celebrity. This class is availabe with the starter application you downloaded
                            let celebrityInImage = Celebrity()
                            
                            celebrityInImage.scene = (self?.CelebImageView)!
                            
                            //Get the coordinates for where this celebrity face is in the image and pass them to the Celebrity instance
                            celebrityInImage.boundingBox = ["height":celebFace.face?.boundingBox?.height, "left":celebFace.face?.boundingBox?.left, "top":celebFace.face?.boundingBox?.top, "width":celebFace.face?.boundingBox?.width] as! [String : CGFloat]
                            
                            //Get the celebrity name and pass it along
                            celebrityInImage.name = celebFace.name!
                            //Get the first url returned by the API for this celebrity. This is going to be an IMDb profile link
                            if (celebFace.urls!.count > 0){
                                celebrityInImage.infoLink = celebFace.urls![0]
                            }
                                //If there are no links direct them to IMDB search page
                            else{
                                celebrityInImage.infoLink = "https://www.imdb.com/search/name-text?bio="+celebrityInImage.name
                            }
                            //Update the celebrity links map that we will use next to create buttons
                            self?.infoLinksMap[index] = "https://"+celebFace.urls![0]
                            self?.celebNameLabel.text = celebrityInImage.name
                            //Create a button that will take users to the IMDb link when tapped
                            let infoButton:UIButton = celebrityInImage.createInfoButton()
                            infoButton.tag = index
                        }
                    }
                    
                }
            }
                //If there were no celebrities in the image, lets check if there were any faces (who, granted, could one day become celebrities)
            else if ((result!.unrecognizedFaces?.count)! > 0){
                //Faces are present. Point them out in the Image (left as an exercise for the reader)
                /**/
            }
            else{
                //No faces were found (presumably no people were found either)
                print("No faces in this pic")
            }
        }
        
    }
    
    func test(completion: @escaping (Data) -> Void ) {
        let requestURL = URL(string: "https://sandbox.plaid.com/accounts/balance/get")
        var request = URLRequest(url: requestURL!)
        var body: [String: Any] = [:]
        body["client_id"] = "5cb6756cf9c7ee0012d5addd"
        body["secret"] = "ce2a2378b9c5d5562e18bd3a8fe0a9"
        body["access_token"] = "access-sandbox-13ced9fb-faf2-4587-8e9e-6a6e610216bc"

        request.httpMethod = "POST"
        request.setValue("Application/json", forHTTPHeaderField: "Content-Type")
        request.httpBody = try? JSONSerialization.data(withJSONObject: body, options: [])
        
        let requestTask = URLSession.shared.dataTask(with: request) {
            (data: Data?, response: URLResponse?, error: Error?) in
            
            if(error != nil) {
                print("Error: \(error)")
            } else {
                
                //send this block to required place
                completion(data!)
                }
            }
        requestTask.resume()
    }
    

    @IBAction func openCamera(_ sender: Any) {
        let pickerController = UIImagePickerController()
        pickerController.delegate = self
        pickerController.sourceType = .camera
        pickerController.cameraCaptureMode = .photo
        present(pickerController, animated: true)
    }
    
    func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
        
        dismiss(animated: true)
        
        guard let image = info[UIImagePickerController.InfoKey.originalImage] as? UIImage else {
            fatalError("couldn't load image from Photos")
        }
        
        CelebImageView.image = image
        let celebImage:Data = image.jpegData(compressionQuality: 0.2)!
        
        
        //Demo Line
        sendImageToRekognition(celebImageData: celebImage)
        test { data in
            self.someMethod(data: data)
        }
    }
    
}
