import React, { Component, ChangeEvent, FormEvent } from 'react';
import logo from './logo.svg';
import './App.css';

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
        <form onSubmit={this.handleSubmit}>
        <label>
          Money Amount:
          <input type="number" value={this.state.value} onChange={this.handleChange}/>
        </label>
        <input type="submit" value="Submit" />
      </form>
      <label>
        ${this.state.value}
      </label>
      </div>
    );
  }
}

export default App;
