# OpenCart Hybrid Test Automation Framework (Qafox):

This project is a **Hybrid Test Automation Framework** designed to automate the **registration and login functionalities** of an OpenCart-based e-commerce website(Qafox).
The framework integrates **Selenium WebDriver**, **TestNG**, **Apache Maven**, **Log4j Logging**, and **Extent Reports** for efficient test execution and reporting.

---

## 🏗️ Framework Features

✅ **Hybrid Framework** - Combines **Data-Driven**, **Keyword-Driven**, and **Page Object Model (POM)**  
✅ **Selenium WebDriver** - Browser automation for login and registration tests  
✅ **TestNG** - Used for test execution, assertions, and parallel execution  
✅ **Apache Maven** - Dependency management and build automation  
✅ **Log4j** - Integrated logging for debugging and issue tracking  
✅ **Extent Reports** - Generates interactive and graphical test execution reports  
✅ **Batch Script Support** - Easily run tests using `run.bat` (Windows)  

---

## 📁 Project Structure

Opencart/ 
│-- .settings/ # IDE settings and configurations 
│-- reports/ # Extent Reports generated after test execution 
│-- src/ # Source code for automation scripts 
│ ├── test/ # Test cases for login and registration 
│ ├── main/ # Core framework files (POM, utility functions, etc.) 
│-- target/ # Compiled test files 
│-- test-output/ # TestNG reports 
│-- logs/ # Log4j-generated logs for debugging 
│-- .classpath # Eclipse-specific file 
│-- .project # Eclipse project configuration 
│-- master.xml # Maven configuration file 
│-- master2.xml # Alternative Maven configuration 
│-- pom.xml # Maven POM for dependencies and build management 
│-- run.bat # Windows batch file to execute tests

## 🛠 Prerequisites

Before running the tests, ensure you have the following installed:

- **Java 22** 
- **Apache Maven**
- **Eclipse** 
- **Google Chrome/Firefox** 
- **Selenium WebDriver**
- **TestNG Plugin** (for Eclipse )
- **Extent Reports (configured in the framework)**

## 🔍 Features & Highlights
- **Hybrid Framework Setup**  
  Combines Page Object Model (POM) with data-driven testing for clean, reusable, and maintainable test scripts.

- **Comprehensive Test Scenarios**  
  Automates user flows like product search, login, cart addition, checkout, and logout, covering various functional aspects.

- **Excel-Based Data Input**  
  Uses Apache POI to fetch test data—such as usernames, product IDs, and quantities—from Excel sheets for flexibility and scalability.

- **Detailed Test Reporting**  
  Generates rich HTML reports using ExtentReports, complete with step-level logs and failure screenshots.

- **Cross-Browser & Conditional Waits**  
  Implements dynamic waits and basic cross-browser capabilities for test stability across different environments.
