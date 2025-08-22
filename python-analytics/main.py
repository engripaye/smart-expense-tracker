from fastapi import FastAPI
from analytics_service import AnalyticsService

app = FastAPI()

# Mock data (in real case, Java backend could send data here)
mock_expenses = [
    {"category": "Food", "amount": 50, "date": "2025-08-01"},
    {"category": "Transport", "amount": 20, "date": "2025-08-02"},
    {"category": "Food", "amount": 30, "date": "2025-08-03"},
    {"category": "Shopping", "amount": 100, "date": "2025-08-05"},
]

@app.get("/analyze")
def analyze():
    summary = AnalyticsService.summarize_expenses(mock_expenses)
    return summary
