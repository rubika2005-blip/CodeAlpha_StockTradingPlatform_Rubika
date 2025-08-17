# 📈 CodeAlpha – Stock Trading Platform (Task 2)

This project is part of my **Java Internship at CodeAlpha**.  
The Stock Trading Platform is a **console-based simulation** that allows users to trade stocks, manage a portfolio, and track portfolio performance.

---

## 📌 Project Description

The program:
- Displays market stock data
- Allows buying and selling of stocks
- Tracks cash balance and holdings
- Refreshes prices dynamically (simulating market changes)
- Shows portfolio value in real-time

---

## 🛠 Technologies Used

- Java (JDK 17+)
- Visual Studio Code
- OOP Concepts (Classes, Objects, Methods)
- Collections Framework (HashMap)
- Java Scanner for input

---

## 🧠 How It Works

- Start the app → shows a **menu** of options
- Choose:
  - View Market
  - Buy/Sell stocks
  - View Portfolio
  - Refresh stock prices
  - View total portfolio value
  - Exit
- Program keeps running until user exits

---

## 🗂 Project Structure

```bash
|-- StockApp.java    # Main program with menu & input
|-- Portfolio.java   # Manages cash, holdings, portfolio value
|-- Market.java      # Holds sample market & simulates price changes
|-- Stock.java       # Stock model (symbol, name, price)
|-- README.md
