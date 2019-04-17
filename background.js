const numbers = [];

setInterval(() => {
    chrome.storage.sync.get(['trailing', 'symbol'], (result) => {
        if(result.symbol) {

            fetch('https://api.robinhood.com/quotes/?symbols=PS', {
                headers: {
                    Authorization: 'Bearer'
                }
                }).then((r) => {
                    return r.json();	
                })
                .then((data) => {
                    numbers.push(data.results[0]['bid_price']);
                    runCheck();
                    document.write(JSON.stringify(data));
                })
        }
    });
    
    console.log('running');

}, 1000)

chrome.runtime.onMessage.addListener((val) => {
    chrome.storage.sync.set({
        trailing: val.trailing,
        symbol: val.symbol
    });

    console.log('browser action clicked');
    console.log(val)
})

function runCheck() {
    if(numbers.length === 5) {
        chrome.notifications.create('123', {
            title: 'Sell',
            message: 'You should sell now!',
            priority: 2,
            requireInteraction: true,
            type: 'basic',
            iconUrl: '/images/robbinhoodbot-16.png'
        })
    }
}