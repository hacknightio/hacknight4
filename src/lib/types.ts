export interface Balance {
  account_id: string;
  balances: {
      available: number;
      current: number;
      iso_currency_code?: string;
      limit?: number;
      unofficial_currency_code: string;
  };
  mask: string;
  name: string;
  official_name: string;
  subtype: string;
  type: string;
};

