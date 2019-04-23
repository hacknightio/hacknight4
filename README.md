# hacknight4 - IRS Victim Support Group

## Financr Shame-a-tron

currently it uses stubbed out data to insult you on startup, on a web request, or on a schedule. It looks for the categories you have had the most transactions within.

ideas: 

1. schedule the system to tweet insults at you daily based on your spending habits that day. 
2. use this to augment your own Mint clone to decorate your dashboard with insults. 

work to be done:

1. add another form of delivering insults like for example tweets. 
2. finish implementing the Plad API for hooking up to your bank. we curerntly generate sample data that is pretty close to the type of data Plad will return.
3.  add more insults specific to type of categories
4.  introduce additional metrics to feed into your insults like frequent Vendors, or high dollar amounts. 

## The Secret Ingredient: Finance APIs

> Nothing can be said to be certain, except death and taxes.
> - Benjamin Franklin, 1789

Given we've all just been pick-pocketed by Big Brother, we figured it'd be fun to focus tonight's **SECRET INGREDIENT** on anything finance-related. 
`Stripe`, `Mint`, `TurboTax`, `CryptoCoins`, `Quickbooks`, you name it. Integrating with any and all of those could be neat. 

Or **building your own** Mint, Expensify, or other budget tool could also be interesting. Whatever tickles your fancy and does something "cool" (or something at all) is the major goal. 

If you want some inspiration, check out this "build your own mint" that gets finance data via Plaid and stores results in Google Sheets (and is based on Vue.js, the front end framework that's totally better than Angular & React). Check out [our forked repo](https://github.com/hacknightio/build-your-own-mint) here to get running quick. 


### Grading

Grading will incredibly biased and hardly scientific, but your best bet is to weigh priorities against the following list:

1) Can you checkout your repository and "run it" according to the `README`
2) Is whatever your project does reproducable? Smoke and mirrors is totally acceptable for parts that could be completed given more time, but if 
your demo scenario is the only thing your project can do, it might be a bit brittle for the judges taste
3) Did you integrate with any services? Have a mobile client? Did you do a cool thing? 
4) Code quality, meh. We're all working fast. 


### Format

The hackathon will begin at `6:30`, following the `Iron Chef` format where a _secret ingredient_ is revealed and you the hackers incorporate it into... something? 
A web app, a algorithm, a mobile app, all three, etc. Whatever your mind comes up with. 

**But Basil, what is a secret ingredient?** Simple: anything. Historically it's been things like some hardware / device (VR), a API / technology (AWS Alexa), or any other 
technology-related "thing". The only common thread is it's got to be immediately accessible to everyone equally (and free to hack at). 

**But I wanted to do XYZ instead!** Great, do it! If you build something awesome and totally unrelated, you *might* still win. But even better, _bake_ that secret ingredient in
to your solution and win on both fronts! 

- `5:30 - 6:15`: Introduction, food, team organization, Wifi, etc
- `6:15 - 6:30`: Secret Ingredient Revealed
- `6:30 - 9:00`: Hack! Welcome to come and go as you please, but if you'd like to submit for judging and prizes, make sure to demo and submit a PR on this repo! 
- `9:00 - Whenever`: Judgement, prizes, and all the glory
