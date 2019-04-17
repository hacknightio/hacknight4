document.body.onload = function() {
    const button = document.querySelector('button')
    
    button.addEventListener('click', () => {
        const trailing = document.querySelector('#trailing');
        const symbol = document.querySelector('#symbol');
    
        chrome.runtime.sendMessage({
            trailing: trailing.value,
            symbol: symbol.value
        });
    });
}
