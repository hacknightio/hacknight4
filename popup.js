alert("this is the alert");

document.body.onload = function() {
    fetch('https://api.robinhood.com/quotes/?symbols=PS', {
        headers: {
            Authorization: ''
        }
    }).then((r) => {
        return r.json();	
    })
    .then((data) => {
        document.write(JSON.stringify(data));
    })
}