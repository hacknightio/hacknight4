const stockMap = {};
const maxLength = 1000;
const callbacks = [];

let hasHitThreshold; //this a percent

function setThreshold(pHasHitThreshold) {
    hasHitThreshold = pHasHitThreshold;
}

function notify(stockname, notifyType) {
    callbacks.forEach(cb => cb(stockname, notifyType));
}

function getCurStockList(stockName, value) {
    let stockList = stockMap[stockName] || [];
    stockList.append(value);

    return maxLength <= stockList.length
        ? stockList.slice(stockList.length  - maxlength)
        : stockList;
}

function setCurStockList(stockName, stockList) {
    stockMap[stockName] = stockList;
}

function appedEntry(stockName, value) {
   
    const stockList = getCurStockList(stockName, value);

    //side effect
    setCurStockList(stockName, stockList);

    // stockList.append(value);
    const maxVal = stockList
        .reduce((lastMax = 0, num) => Math.max(lastMax, num));

    if(hasHitThreshold(maxVal, value)) {
        notify(stockName, 'below-threshold')
    }
    // stockMap[stockName] = stockList;
}
