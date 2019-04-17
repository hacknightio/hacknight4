import React, { Component, ChangeEvent, FormEvent } from 'react';
import './App.css';
import {Burritos, Burrito} from "./models/burrito";
import { BurritoDetails } from './components/burrito-details';
import Button from '@material-ui/core/Button';
import { Account } from 'plaid';

import plaid from 'plaid';

const plaidClient = new plaid.Client(
  process.env.REACT_APP_PLAID_CLIENT_ID || '5cb674e4f9c7ee0012d5add9',
  process.env.REACT_APP_PLAID_SECRET || 'd8135f4a532f539f10a18cdf0eedec',
  process.env.REACT_APP_PLAID_PUBLIC_KEY || 'a655d88a5db2677823edbe603db950',
  plaid.environments.sandbox,
  {
    version: '2018-05-22'
  }
);

class App extends Component <{},{ accounts: Account[], available: number, selectedAccount: number }> {
  constructor(props:{}) {
    super(props);
    this.state = { accounts: [], available: 0, selectedAccount: 0 };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async componentDidMount () {

    const res = await plaidClient.getBalance(process.env.REACT_APP_PLAID_TOKEN_BANK || 'access-sandbox-5e1d2363-fb6c-4ca8-9fa3-c04bf977751c');
    this.setState({ accounts: res.accounts });
  }

  handleChange(event: ChangeEvent<HTMLInputElement>) {
    // this.setState({ value: parseInt(event.target.value) });
  }

  handleSubmit(event: FormEvent<HTMLFormElement>) {
    alert('Your amount is: ' + this.state.accounts);
    event.preventDefault();
  }

  render() {
    return (
      <div className="App">
        <form>
        <label>
          Money Amount:
          {/* <input type="number" value={this.state.value} onChange={this.handleChange}/> */}
        </label>
      </form>
      <label>
        {/* ${this.state.value} */}
      </label>
      {Burritos.map(burrito => {
        // return (<div className="Burrito-card"><BurritoDetails burrito={burrito} total={this.state.value}/></div>)
      })}
      </div>
    );
  }
}

export default App;
