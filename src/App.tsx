import React, { Component, ChangeEvent, FormEvent } from "react";
import "./App.css";
import { Burritos } from "./models/burrito";
import { BurritoDetails } from "./components/burrito-details";
import { TextField } from "@material-ui/core";

class App extends Component<{}, { value: string }> {
  constructor(props: {}) {
    super(props);
    this.state = { value: "100" };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleChange(event: ChangeEvent<HTMLInputElement>) {
    this.setState({ value: event.target.value });
  }

  handleSubmit(event: FormEvent<HTMLFormElement>) {
    alert("your amount is: " + this.state.value);
    event.preventDefault();
  }
  render() {
    const value = parseInt(this.state.value);
    const total = isNaN(value) ? 0 : value;
    return (
      <div className="App">
          <TextField
            id="outlined-email-input"
            label="Tax Refund Amount"
            type="amount"
            name="amount"
            margin="normal"
            variant="outlined"
            value={this.state.value}
            onChange={this.handleChange}
          />
        {Burritos.map(burrito => {
          return (
            <div className="Burrito-card" key={burrito.id}>
              <BurritoDetails burrito={burrito} total={total} />
            </div>
          );
        })}
      </div>
    );
  }
}

export default App;
