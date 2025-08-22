import pandas as pd
from typing import List, Dict
from datetime import datetime

class AnalyticsService:

    @staticmethod
    def summarize_expenses(expenses: List[Dict]) -> Dict:
        """
        Summarize expenses by category and total spending
        :param expenses: list of dict objects {category, amount, date}
        :return: dict with summary
        """

        if not expenses:
            return {"message": "No expenses available for analysis."}

        # Convert to DataFrame
        df = pd.DataFrame(expenses)

        # Ensure correct data types
        df["amount"] = pd.to_numeric(df["amount"], errors="coerce")
        df["date"] = pd.to_datetime(df["date"], errors="coerce")

        # Group by category
        category_summary = df.groupby("category")["amount"].sum().to_dict()

        # Monthly spending trend
        df["month"] = df["date"].dt.to_period("M")
        monthly_summary = df.groupby("month")["amount"].sum().to_dict()

        # Total spent
        total_spent = df["amount"].sum()

        return {
            "total_spent": round(total_spent, 2),
            "spending_by_category": category_summary,
            "monthly_trend": {str(k): float(v) for k, v in monthly_summary.items()}
        }
