---

# 💰 Smart Expense Tracker

<img width="1536" height="1024" alt="Smart Expense Tracker Concept" src="https://github.com/user-attachments/assets/1cbd4d7f-1eb3-41bc-ad55-c9d0cd9f2c78" />

A **professional full-stack project** combining **Java (Spring Boot)** and **Python (FastAPI)** to track expenses and provide smart analytics.
This project demonstrates how two different languages/services can work together in a real-world microservices-style architecture.

---

## 📌 Features

✅ **User Expense Tracking** (Add, list, delete expenses via Spring Boot REST API)
✅ **Data Persistence** (MySQL Database with Spring Data JPA)
✅ **Analytics Engine** (Python FastAPI with Pandas for insights)
✅ **Cross-Service Communication** (Java calls Python service for insights)
✅ **Dockerized Setup** (Optional: Run both services + MySQL using Docker Compose)

---

## 🏗 Architecture

```
                        ┌────────────────────┐
                        │   React (Optional) │
                        └─────────┬──────────┘
                                  │
                        ┌─────────▼──────────┐
                        │  Java Spring Boot  │
                        │  (Expense Service) │
                        └─────────┬──────────┘
                                  │ REST API Call
                        ┌─────────▼──────────┐
                        │   Python FastAPI   │
                        │ (Analytics Engine) │
                        └─────────┬──────────┘
                                  │
                        ┌─────────▼──────────┐
                        │      MySQL DB      │
                        └────────────────────┘
```

---

## ⚙️ Tech Stack

### 🔹 Backend (Expense Service – Java)

* **Java 21**
* **Spring Boot 3.5**
* **Spring Data JPA (Hibernate)**
* **MySQL**
* **Lombok**
* **WebFlux (to call Python service)**

### 🔹 Analytics Service (Python)

* **Python 3.10+**
* **FastAPI**
* **Pandas**
* **Uvicorn**

### 🔹 Deployment

* **Docker & Docker Compose**

---

## 🚀 Getting Started

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/smart-expense-tracker.git
cd smart-expense-tracker
```

---

### 2️⃣ Setup Java Backend (Spring Boot)

Go to `java-backend/` and configure `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expenses
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```

Run with Maven:

```bash
cd java-backend
./mvnw spring-boot:run
```

---

### 3️⃣ Setup Python Analytics Service

Go to `python-analytics/` and install dependencies:

```bash
cd python-analytics
pip install -r requirements.txt
```

Run FastAPI service:

```bash
uvicorn main:app --reload --port 8001
```

---

### 4️⃣ (Optional) Run with Docker Compose

At the root directory:

```bash
docker-compose up --build
```

This will start:

* Java backend (port **8080**)
* Python analytics (port **8001**)
* MySQL database (port **3306**)

---

## 📌 API Endpoints

### Java Backend (Spring Boot) – `http://localhost:8080/api/expenses`

* `POST /api/expenses` → Add an expense
* `GET /api/expenses` → Get all expenses
* `GET /api/expenses/summary` → Get analytics from Python service

Example request:

```bash
curl -X POST http://localhost:8080/api/expenses \
  -H "Content-Type: application/json" \
  -d '{"category": "Food", "amount": 50.0, "date": "2025-08-20"}'
```

---

### Python Analytics (FastAPI) – `http://localhost:8001/analyze`

* `GET /analyze` → Returns spending summary grouped by category

Example response:

```json
{
  "Monthly Spending": {
    "Food": 80,
    "Transport": 20
  }
}
```

---

## 📸 Screenshots (Optional)

> You can add **Postman screenshots** or a small **React frontend UI** here later.

---

## 🛠 Future Improvements

* 🔐 Add user authentication (JWT / OAuth2)
* 📊 Frontend dashboard (React or Angular)
* 📈 Advanced ML-based predictions (Python)
* ☁ Deploy on Kubernetes or cloud provider (AWS/GCP/Azure)

---

## 👨‍💻 Author

**Ipaye Babatunde**

* [LinkedIn](https://linkedin.com/in/engripayebabatunde)
* [GitHub](https://github.com/engripaye)

---

Would you like me to **add GitHub Actions CI/CD workflow** (to auto-build + test both Java & Python services when you push code)? That will make the README even more **professional for recruiters**.
