# Referral-Based User Signup API

## 📌 Project Overview
This project implements a referral-based user signup system where users can sign up with or without a referral code. A referral is considered successful only after the referred user completes their profile. The system tracks referrals and provides an API to fetch referral details.

## 🚀 Features
- **User Signup with Referral Tracking**
  - Users can sign up with or without a referral code.
  - Each user is assigned a unique referral code.
  - If a referral code is provided, the system links the referrer and referred user.
  
- **Referral Completion**
  - A referral is marked as successful only when the referred user completes their profile.
  
- **API Endpoints**
  - Signup API
  - Profile Completion API
  - Get Referrals API
  - Referral Report API (Bonus: CSV Report Generation)

## 🛠️ Tech Stack
- **Backend:** Java, Spring Boot, RESTful APIs
- **Database:** MySQL (SQL-based storage)
- **Deployment:** Railway.app
- **Version Control:** GitHub

## 🔗 API Endpoints

### 1️⃣ User Signup
**Endpoint:** `POST /api/signup`
**Request Body:**
```json
{
  "name": "Alice",
  "email": "alice@example.com",
  "referralCode": "0618ea66"  // Optional
}
```
**Response:**
```json
{
  "userId": 2,
  "name": "Alice",
  "email": "alice@example.com",
  "referralCode": "c2f264b7"
}
```

### 2️⃣ Profile Completion
**Endpoint:** `PUT /api/profile/{userId}`
**Response:** Referral status updated.

### 3️⃣ Get Referrals
**Endpoint:** `GET /api/referrals/{userId}`
**Response:** List of referrals.

### 4️⃣ Generate Referral Report (CSV)
**Endpoint:** `GET /api/referrals/report`
**Response:** CSV download link.

## 📌 Deployment
- **GitHub Repo:** [🔗 Link to Repository](https://github.com/yourusername/your-repo)
- **Live API on Railway:** [🔗 Deployed Link](https://your-deployment-url.railway.app)

## 📜 How to Run Locally
```bash
# Clone the repo
git clone https://github.com/yourusername/your-repo.git
cd your-repo

# Run with Maven
mvn spring-boot:run
```

## 📡 cURL Requests
### Signup Example
```bash
curl -X POST "https://your-deployment-url.railway.app/api/signup" -H "Content-Type: application/json" -d '{ "name": "Alice", "email": "alice@example.com" }'
```

### Profile Completion Example
```bash
curl -X PUT "https://your-deployment-url.railway.app/api/profile/2"
```

## 🏆 Brownie Points Implemented
✅ CSV report generation for user referrals
✅ Clean, readable code
✅ Meaningful comments
✅ Comprehensive README

## 📩 Contact
For any issues, feel free to raise a GitHub issue or reach out via email.

