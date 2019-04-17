export interface Burrito {
  id: number;
  name: string;
  cost: number;
  calories: number;
}

export const Burritos: Burrito[] = [
  {
    id: 1,
    name: "Cheesy Bean and Rice Burrito from Taco Bell",
    cost: 1,
    calories: 430
  },
  { id: 2, name: "Carnitas from Chipotle", cost: 10, calories: 1470 }
];
