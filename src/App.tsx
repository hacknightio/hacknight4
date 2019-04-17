import React, { Component, ChangeEvent, FormEvent } from 'react';
import logo from './logo.svg';
import './App.css';
import {Burritos, Burrito} from "./models/burrito";
import { BurritoDetails } from './components/burrito-details';
import Button from '@material-ui/core/Button';

class App extends Component <{},{value: number}>{
  constructor(props:{}) {
    super(props);
    this.state = {value: 100};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleChange(event: ChangeEvent<HTMLInputElement>) {
    this.setState({value: parseInt(event.target.value)});
  }

  handleSubmit(event: FormEvent<HTMLFormElement>) {
    alert('your amount is: ' + this.state.value);
    event.preventDefault();
  }
  render() {
    return (
      <div className="App">
        <form>
        <label>
          Money Amount:
          <input type="number" value={this.state.value} onChange={this.handleChange}/>
        </label>
      </form>
      <label>
        ${this.state.value}
      </label>
      {Burritos.map(burrito => {
        return (<div className="Burrito-card"><BurritoDetails burrito={burrito} total={this.state.value}/></div>)
      })}
      </div>
    );
  }
}

export default App;
