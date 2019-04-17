const stockMap = {};
const maxLength = 1000;
const callbacks = [];

let hasHitThreshold; //this a percent

//API to set threshold Fn
function setThresholdFn(pHasHitThreshold) {
    hasHitThreshold = pHasHitThreshold;
}

//set functions to run once notification is needed
function notify(stockname, notifyType) {
    callbacks.forEach(cb => cb(stockname, notifyType));
}

//gets current stock list 
function getCurStockList(stockName, value) {
    let stockList = stockMap[stockName] || [];
    stockList.append(value);

    return maxLength <= stockList.length
        ? stockList.slice(stockList.length  - maxlength)
        : stockList;
}

//set tthe current stock list to the stockMap
function setCurStockList(stockName, stockList) {
    stockMap[stockName] = stockList;
}

//add in a stock name along with current value
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
