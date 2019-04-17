export interface Burrito {
  id: number;
  name: string;
  restaraunt: string;
  cost: number;
  calories: number;
  image: string;
  logo: string;
}

export const Burritos: Burrito[] = [
  {
    id: 1,
    name: "Cheesy Bean and Rice Burrito",
    restaraunt: "Taco Bell",
    cost: 1.00,
    calories: 430,
    image: "/assets/taco-bell.jpg",
    logo: "/assets/taco-bell-logo.jpg"
  },
  {
    id: 2,
    name: "Carnitas & Guac Burrito",
    restaraunt: "Chipotle",
    cost: 10.80,
    calories: 1470,
    image: "/assets/chipotle.jpg",
    logo: "/assets/chipotle-logo.jpg"
  },
  {
    id: 3,
    name: "Epic Steak & Potato Burrito ",
    restaraunt: "Del Taco",
    cost: 5.29,
    calories: 1040,
    image: "/assets/del-taco.jpg",
    logo: "/assets/del-taco-logo.jpg"
  }
];
