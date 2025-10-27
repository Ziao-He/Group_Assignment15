# Digital University System \+ Access Control — Group Assignment 15

**Course:** INFO 5100 — Application Engineering & Development  
**Project Type:** Group Assignment (Access-Controlled Digital University)  
**Repo Folder:** `Group_Assignment15/University System`  
**Build Tool:** NetBeans Ant project (`build.xml`)  
**Main Window:** `Business/ProfileWorkAreaMainFrame.java`

---

## 1\) Project Title

**Digital University System with Role-Based Access Control**

---

## 2\) Team Information

Please replace the example below with your actual team information (members, roles, and NUIDs), ensuring consistency with your submission video/Canvas.

| Name | NUID | Role (Use Case Owner) | Main Responsibilities |
| :---- | :---- | :---- | :---- |
| Ziao He | 002539722 | **Administrator** | User account management, person registration (Student/Faculty/Registrar), student/faculty/registrar records management with 3 search methods each, admin profile management, and an analytics dashboard with 4 statistical reports. |
| Yujie Liang | 002085359 | **Faculty** | Course Management, Faculty Profile Management, Student Management, Performance Reporting, and Total Tuition collected |
| Yiyang Lin | 002565394 | **Student** | Student UseCase |
| Liyun Li | 002593949 | **Registrar** | Course Create and Management; Own Profile Management; Student Course Registration and Drop; Tuition & Financial Reconciliation; Reporting & Analytics |

---

## 3\) Project Overview

This project integrates the Digital University Model with an Access Control Layer (ACL) to implement role-based login and authorization. The system includes four main roles: Admin, Faculty, Student, and Registrar. Each role can only access the functional panels that are specifically authorized for it.

Key Objectives:

1. Login/Logout and Role Authentication: Each user logs in and is directed to their corresponding workspace (WorkArea) based on their role.

2. Complete Use Case Flow: Every team member must develop and demonstrate the full end-to-end functionality for their assigned role.

3. Preset Data Initialization: The method ConfigureABusiness.initialize() preloads personnel, courses, course offerings, and sample accounts.

4. UI Constraints: Use CardLayout for navigation, JTable for data display and filtering, with null-checking and input validation enforced.

---

## 4\) Installation & Setup

### **1\. Clone the Project Repository**

git clone https://github.com/Ziao-He/Group\_Assignment15.git

### **2\. Open the Project**

Open the project in your preferred IDE (for example, IntelliJ IDEA or NetBeans).

### **3\. Verify Dependencies**

Ensure that all required packages under the src directory are properly loaded.

### **4\. Run the Main Class**

Execute the following file to launch the system: ProfileWorkAreaMainFrame.java

### **5\. Default User Accounts for Testing**

| Role | Username | Password |
| ----- | ----- | ----- |
| Admin | admin | \*\*\*\* |
| Faculty | f | \*\*\*\* |
| Student | adam | \*\*\*\* |
| Registrar | Registrar | \*\*\*\* |

---

## 5\) Authentication & Access Control

### 

1\. Startup Window: Business/ProfileWorkAreaMainFrame

2\. Enter Username and Password, then click Login.

3\. The system calls Business.UserAccounts.UserAccountDirectory\#AuthenticateUser(un, pw)  
4\. To validate credentials: Upon successful authentication, the corresponding Profile is retrieved (StudentProfile, FacultyProfile, EmployeeProfile (Admin), or RegistrarProfile).  
5\. Based on the profile type or role, the user is directed to the corresponding WorkArea panel:  
	Admin → UserInterface.WorkAreas.AdminRole.AdminRoleWorkAreaJPanel  
	Faculty → UserInterface.WorkAreas.FacultyRole.FacultyWorkAreaJPanel  
	Student → UserInterface.WorkAreas.StudentRole.StudentWorkAreaJPanel

Registrar → UserInterface.WorkAreas.RegistrarRole.RegistrarWorkAreaJPanel

**Account Source**

Default demo accounts are typically initialized in Business/ConfigureABusiness.java using the newUserAccount(...) method. If default accounts are unavailable, you can create new users via the Admin panel (see the “Admin Functionality” section).

---

# 6\) Features Implemented（）

**WorkArea Entry:** AdminRoleWorkAreaJPanel

**Sub-panels:**

**User & Personnel Management:**

ManageUserAccountsJPanel(Create / Edit / Delete users, link to Profile)

AdminRegistrationJPanel (Person registration with role selection: Student/Faculty/Registrar)

AdminStudentJPanel (Student registration: auto-generated ID 0001-9999, Name, Email, Phone, Department)

AdminFacultyJPanel (Faculty registration: auto-generated ID 0001-9999, Name, Email, Phone, Department)

AdminRegisterJPanel (Registrar registration: auto-generated ID REG001-REG999, Name, Email, Phone, Office Hours, Office Location)

AdminManageStudentsJPanel (Student profiles: department, email, enrollment status, contact info)

AdminManageFacultyJPanel (Faculty profiles and department/course associations)

AdminManageRegisterJPanel (Registrar profile management)

**Search:** Supports three search types — by name, ID, or department/email — following the same design as course search, sharing a unified JTable for displaying results.

**Personal Profile:** AdminUserAccount (View and edit admin's own information: First Name, Last Name, Email, Phone, Department)

**University Analytics Dashboard:** AdminAnalyticsDashboardPanel

Active users by role (Students, Faculty, Admins, Registrars)

Number of courses offered per semester (Fall 2025, Spring 2025, etc.)

Enrollment counts per course (Course ID, Course Name, Semester, Enrolled, Capacity, % Full)

Tuition revenue summary (Total Revenue, Total Paid, Total Unpaid/Balance)

---

### **B. Faculty Use Case**

**WorkArea Entry:** FacultyWorkAreaJPanel  
**Sub-panels:**  
**Course Management:** ManageCourseJPanel

View / update course details (title, description, schedule, location, capacity)

Upload / update syllabus

Open / close course registration before the semester begins

**Student Management:** StudentManagementJPanel

View enrolled students for each course  
Assignment Grading: View and grade assignments; automatically calculate overall score and letter grade

View class ranking and course GPA

**Performance Report:** PerformanceReportJPanel

Generate course-level reports: average score, grade distribution, enrollment count

Filter by semester (dropdown synchronized with JTable)

**Tuition Insight:** FacultyWorkAreaJPanel  
Display total tuition associated with students enrolled in that course

---

### **C. Student Use Case**

WorkArea Entry: StudentWorkAreaJPanel

Course Search & Registration: StudentRegisterAreaJPanel

Supports at least three search options (by course ID, instructor, or keyword)

Results are displayed in a shared course JTable

Each semester’s enrollment limited to ≤ 8 credits

Coursework & Progress: StudentCourseworkManagementJPanel

Graduation Audit: StudentGraduateDialog

For MSIS, requires 32 credits total, including INFO 5100 (4 cr) as a core course

Automatically evaluates degree completion status and notifies the student

* **Transcript:**

  * View by semester; `JTable` supports dropdown filtering

  * Columns include: Term, Academic Standing (auto-evaluated based on Term / Overall GPA and 3.0 threshold), Course ID/Name, Grade, Term/Overall GPA Points

* **Financial:** `StudentFinancialJPanel`

  * **Pay Tuition:** Generate invoices based on enrolled courses (default balance \= 0\)

  * Students **cannot view transcripts** until outstanding balances are cleared

  * **Refund Policy:** Dropped courses automatically refund previously paid tuition

  * View **payment history**

**GPA Calculation & Standing:**  
 Follow assignment rules (A=4.0, A−=3.7, B+=3.3, ..., F=0.0).  
 Both term and overall GPAs are computed as the sum of quality points divided by total credits.

---

### **D. Registrar Use Case**

**WorkArea Entry:** `RegistrarWorkAreaJPanel`  
 **Sub-panels (examples):**

* **Course Offering Management:** `RegistrarCourseManagementJPanel`  
   (Create offerings, set capacity, schedule, room, assign instructors)

* **Student Registration (Admin-side):** `RegistrarStudentRegistrationJPanel`  
   (Register / drop students on their behalf)

* **Personal Profile:** `RegistrarProfileManagementJPanel`

* **Tuition & Reconciliation:** `RegistrarTuitionJPanel`  
   (Summarize total payments and outstanding balances per semester)

* **Reports & Analytics:** `RegistrarReportingJPanel`  
   (Display enrollment statistics by department/course and GPA distribution by program, presented in tables)

### 

---

## 7\) Usage Instructions（）

### **Scenario 1: Admin Creates a New Faculty Member and Assigns Courses**

1. Log in using the **Admin** account → Enter the **Admin WorkArea**.

2. Open **Manage User Accounts** to create a new user (enter username/password, link to `FacultyProfile`, and bind to a `Person`).

3. Open **Manage Faculty** to complete the faculty member’s information and **assign** them to an existing or newly created course/department.

4. Verify the faculty’s course assignment via the **Dashboard** or **Course Offering** panel.

---

### **Scenario 2: Faculty Publishes Syllabus, Grades Assignments, and Exports Reports**

1. Log in as Faculty → Enter ManageCourseJPanel to upload or update the Syllabus   
2. During the semester, review student submissions in the enrollment list and assign grades. The system automatically aggregates percentages and calculates letter grades.  
3. Open PerformanceReportJPanel to view average scores, grade distribution, and enrollment numbers, and export filtered reports by semester.

---

### **Scenario 3: Student Registers for Courses, Pays Tuition, and Views Transcript**

1. Log in as **Student** → In `StudentRegisterAreaJPanel`, search for courses (by course ID, instructor, or keyword) and register for up to **8 credits** per semester.

2. Go to `StudentFinancialJPanel` to **pay tuition**. If the balance ≤ 0, the system will display a popup message: *"No outstanding balance."*

3. After payment is completed, access the **Transcript** page to view grades by semester; **Academic Standing** is automatically calculated.  
    When a course is dropped, the system automatically **processes refunds**.

---

### **Scenario 4: Registrar Manages Course Offerings and Reconciles Accounts** 

1. Log in as **Registrar** → In RegistrarCourseManagementJPanel, configure **course offerings** (capacity, time, location, instructor).You can create new courses, as well as manage existing ones.

2. Use RegistrarStudentRegistrationJPanel to **register or drop courses on behalf of students**.Determine which student to add or remove courses for by searching the student ID.  
3. Use RegistrarProfileManagementJPanel to update registrar’s personal profile.

4. In RegistrarTuitionJPanel, review **total payments and outstanding balances**, and export summaries; Monitor the payment status of all students; by switching between different semesters, obtain the total income and expenditure for the corresponding semester, the unpaid amounts, and the income and expenditure situation of different departments.  
5. Use RegistrarReportingJPanel to generate reports including registration numbers for each department, GPA distribution for each program.

---

# **8\. Testing Guide**

## **Testing Procedure**

1\. Start the application and test login with all four user roles

2\. Attempt invalid credentials to verify error handling

3\. Test unauthorized access (e.g., ensuring students cannot access admin functions)

4\. Execute complete workflows for each role

5\. Monitor console for terminal errors throughout all tests

## **Sample Test Cases**

| Test ID | Scenario | Input | Expected Output |
| :---- | :---- | :---- | :---- |
| **TC01** | Admin login | Username: admin, Password: \*\*\*\* | Enter Admin work area successfully |
| **TC02** | Register new student | Name, Email, Phone | Student created with auto-generated ID (e.g., 0011\) |
| **TC03** | Duplicate email prevention | Existing email address | Error: "Email already exists" |
| **TC04** | Search students by name | "Lin" | Display matching students only |
| **TC05** | Student exceeds credit limit | Enroll in 9+ credits | Error: "Exceed 8 credit limit" |
| **TC06** | Faculty grades new student | Grade: 100 | New CourseGrade created, no NullPointerException |
| **TC07** | View Analytics Dashboard | N/A | All 4 reports display with accurate data |
| **TC08** | Student views transcript before paying | Balance \> 0 | Transcript locked or warning displayed |

 

## **Authentication & Authorization Verification**

1\.  Verify each role can only access their designated features

2\.  Attempt cross-role access and confirm denial

3\.  Ensure logout completely clears session data

4\.  Verify all CRUD operations are properly authorized

## 9\) Challenges & Solutions

- Admin Part: This is an Administrator module challenges and solutions document that records 5 major technical issues encountered during development and their resolutions: ID auto-generation skipping numbers was solved by scanning existing records and syncing the counter; unclear association between Admin objects and EmployeeProfile was resolved by establishing a clear data flow (Admin → EmployeeProfile → UserAccount); panel switching failures were fixed by ensuring proper layout initialization order; email duplicate validation requirements were addressed through centralized static validation methods; and course enrollment statistics challenges were solved by iterating through students' enrolled offerings lists—all issues were ultimately resolved through code refactoring, following existing design patterns, and implementing robust null-safety checks.  
- Faculty Part: In this assignment, I encountered some practical problems while learning Java Graphical Interface Programming (Swing). First, I wanted to add options in a JComboBox, but I found that the same content would repeatedly appear. So I learned how to determine if it exists before adding, using getIndexOf() or loop judgment to avoid repetition. Secondly, when I was writing the time format validation function, I could only recognize formats like "1:00 am". Later, I found out that the regular expression was too strict to match the case or the 24-hour system. By adjusting the regular expression, I enabled the program to recognize multiple formats such as "1:00 AM" and "23:45" simultaneously.  
- Studnet Part:By using GitHub in a team collaboration mode, we explored the workflow of iterative coding. After becoming familiar with it, we spent a significant amount of time on class instantiation and structural design, mainly due to the order of assignments and dependencies. During the UI implementation, a lot of effort was devoted to fine-tuning the display layout and formatting. Finally, when merging the code, cross-references and debugging between different parts of the project became a major challenge.  
- Registrar Part:The initial problem I encountered was that I had hardly ever used GitHub for group projects, and just resolving the conflicts between the main branch and my personal branch took a long time. Secondly, this project included many components; each functional panel was linked to numerous classes as well as related to the work of other team members. I spent a lot of time debugging to ensure these components could interact correctly. Lastly, regarding bug fixing, in the financial report section, initially the report could only correctly output the total value and unpaid amounts. Later, I discovered that there was a logical error—the retrieval target was incorrect. After making changes, the necessary values could be output correctly.

---

## 10\) Future Enhancements

- Students can select heavy training course (hidden GPA, etc.)  
- The number of possessions is increased and the number of connections is increased, which makes it more efficient.  
- A more attractive interface  
- Registrar has no way to directly contact students. After adding or dropping courses, students need to contact the administrator or teacher to notify them that they have or don't have the course. (In fact, this kind of issue also exists in reality; I often receive mass emails reminding me of things that actually have nothing to do with me.)

---

## 11\) Contribution Breakdown（）

### Ziao He— Administrator（25%）

- ：AdminRoleWorkAreaJPanel、ManageUserAccountsJPanel、AdminManageFacultyJPanel、AdminDashboardJPanel…


### Yujie Liang — Faculty（25%）

- ：FacultyWorkAreaJPanel、ManageCourseJPanel、PerformanceReportJPanel…

### Yiyang Lin — Student（25%）

- ：StudentWorkAreaJPanel、StudentRegisterAreaJPanel、StudentCourseworkManagementJPanel、StudentFinancialJPanel、StudentGraduateDialog…

### Liyun Li — Registrar（25%）

- ：`RegistrarWorkAreaJPanel`、`RegistrarCourseManagementJPanel`、`RegistrarStudentRegistrationJPanel`、`RegistrarTuitionJPanel`、`RegistrarReportingJPanel`

