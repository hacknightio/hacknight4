import React from "react";
import { Burrito } from "../models/burrito";

export const BurritoDetails = (props: {
    burrito: Burrito,
    total: number
  }) => {
    const {burrito, total} = props;
    const burritoNum = total / burrito.cost
    const burritoTotalCalories = burritoNum * burrito.calories
    const kidsToFeed = burritoTotalCalories / 2000
    return (
      <tr>
        <td className="Burrito-column">
          {burrito.name}
        </td>
        <td>
          {burritoNum}
        </td>
        <td>
          {burritoTotalCalories}
        </td>
        <td>
          {kidsToFeed}
        </td>
      </tr>
    );
  };