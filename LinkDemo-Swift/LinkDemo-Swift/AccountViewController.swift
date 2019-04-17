//
//  AccountViewController.swift
//  LinkDemo-Swift
//
//  Created by Eliott Moreno on 4/16/19.
//  Copyright © 2019 Plaid Inc. All rights reserved.
//

import UIKit

class AccountViewController: UIViewController {
    
    var token:String?
    @IBOutlet weak var accountTypeLabel: UILabel!
    @IBOutlet weak var balanceLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "Account"
        // Do any additional setup after loading the view.
        
        test() { data in
            let jsonArray = try? JSONSerialization.jsonObject(with: data, options: []) as? [String:Any]
            let account = jsonArray?["accounts"] as? [Any]
            let firstAccount = account?[0] as? [String:Any]
            let accountName = (firstAccount?["name"]) as? String
            let balances = firstAccount?["balances"] as? [String:Any]
            let currentBalance = balances?["current"] as? Int
            print(String(currentBalance!))
            DispatchQueue.main.async {
                self.balanceLabel.text = String(currentBalance!)
                self.accountTypeLabel.text = accountName ?? "account doesn't exist"
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
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
