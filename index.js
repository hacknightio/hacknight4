require('dotenv').config()
const http = require('http')
const app = require('./scripts/plaidServer')

const { fetchTransactions } = require('./lib/fetch')
const { transformTransactionsToUpdates } = require('./lib/transform')
const { updateSheet } = require('./lib/update')

;(async () => {
  const transactions = await fetchTransactions()
  const updates = transformTransactionsToUpdates(transactions)
  updateSheet(updates)
})()

const server = http.createServer(app)

server
  .listen(8081)
  .on('listening', () =>
    console.log(`Server listening on port 8081`)
  )