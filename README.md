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
  - Referral Report API

## 🛠️ Tech Stack
- **Backend:** Java, Spring Boot, RESTful APIs
- **Database:** MySQL (SQL-based storage)
- **Version Control:** GitHub

## 🔗 API Endpoints

### 1️⃣ User Signup
**Endpoint:** `POST /api/signup`
**Request Body:**
```json
{
  "name": "Doe",
  "email": "doe@example.com",
  "password":doe234
}
```
**Response:**
```json
{
  "userId": 1, //according to the users in database 
  "name": "Doe",
  "email": "doe@example.com",
  "referralCode": "c2f264b7" // generated random
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
- **GitHub Repo:** [🔗(https://github.com/Akshita246/ReferralTrackingApi)]

## 📜 How to Run Locally
```bash
# Clone the repo
git clone https://github.com/Akshita246/ReferralTrackingApi.git
cd ReferralTrackingApi

# Run with Maven
mvn spring-boot:run
```

## 📡 cURL Requests
### Signup Example
```bash
  curl -X POST http://localhost:9090/api/signup -H "Content-Type: application/json" -d '{ "name": "Alice", "email": "alice@example.com" }'
```

### Profile Completion Example
```bash
curl -X POST http://localhost:9090/api/profile/complete -H "Content-Type: application/json" -d '{ "userId": 2 }'
```
### Get Referral Api
```bash
   curl -X GET http://localhost:9090/api/referrals/2  
```

## 🏆 Brownie Points Implemented
✅ CSV report generation for user referrals
✅ Clean, readable code
✅ Meaningful comments
✅ Comprehensive README

## 📩 Contact
For any issues, feel free to raise a GitHub issue or reach out via email.

