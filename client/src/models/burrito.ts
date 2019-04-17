export interface Burrito {
  name: string;
  cost: number;
  calories: number;
}

export const Burritos: Burrito[] = [
  {
    name: "Cheesy Bean and Rice Burrito from Taco Bell",
    cost: 1,
    calories: 430
  },
  { name: "Carnitas from Chipotle", cost: 10, calories: 1470 }
];
