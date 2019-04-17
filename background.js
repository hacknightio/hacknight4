const numbers = [];

// setThresholdFn((maxValue, value) => {
//     return (maxValue - value)/maxValue > .02
// });

setInterval(() => {
    chrome.storage.sync.get(['trailing', 'symbol'], (result) => {
        if(result.symbol) {
            var envUrl = chrome.runtime.getURL("env.json");
            fetch(envUrl).then(data=> {
                console.log(data);
                return data.json();
            }).then(data=> {
                fetch('https://api.robinhood.com/quotes/?symbols=PS', {
                    headers: {
                        Authorization: 'Bearer '+data.bearer
                    }
                    }).then((r) => {
                        return r.json();	
                    })
                    .then((data) => {
                        // appedEntry(result.symbol, data.results[0]['bid_price']);
    
                        numbers.push(data.results[0]['bid_price']);
                        runCheck();
                        document.write(JSON.stringify(data));
                    })
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
    if(numbers.length === 10) {
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