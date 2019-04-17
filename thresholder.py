stockmap = {}
maxlen = 1000
callbacks = []
threshold = 2 # percent

def subscribe(callback):
    '''
    Subscribe to notifications.
    Callback function has three arguments:
    - stockname
    - notification type
    - delta value (e.g., if too low, then how many percent it dropped)

    The notification type is one of:
    - 'below-threshold'
    '''
    callbacks.append(callback)

def notify(stockname, notif_type, delta):
    for callback in callbacks:
        callback(stockname, notif_type, delta)

def appendEntry(stockname, value):
    if stockname not in stockmap:
        stockmap[stockname] = []
    stocklist = stockmap[stockname]
    stocklist.append(value)

    # see if we want to throw away the first value
    if len(stocklist) > maxlen:
        stocklist[:] = stocklist[1:]

    # check to see if we want to notify
    maxval = max(stocklist)
    delta = maxval - value
    if 100*delta < threshold * maxval:
        notify(stockname, 'below-threshold', delta)

