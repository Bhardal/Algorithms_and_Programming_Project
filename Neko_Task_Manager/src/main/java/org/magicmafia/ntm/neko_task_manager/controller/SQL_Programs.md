## pour créer un project :
String url = "jdbc:sqlite:mydatabase.db";
String sql = "INSERT INTO Projects(ProjectName, ProjectID, Deadline) VALUES(?, ?, ?, ?, ?)";
try (Connection conn = DriverManager.getConnection(url);
     PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setString(1, projectNameText);
    pstmt.setInt(2, projectIDInt);
    pstmt.setDate(3, deadlineDate);
    pstmt.executeUpdate();
    System.out.println("Data inserted.");
} catch (SQLException e) {
    System.out.println(e.getMessage());
}


## Pour delete un project :
String url = "jdbc:sqlite:mydatabase.db";
String sql = "DELETE FROM Projects WHERE ProjectID = (?);";
try (Connection conn = DriverManager.getConnection(url);
     PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setInt(1, projectIDInt);
    pstmt.executeUpdate();
    System.out.println("Project Deleted.");
} catch (SQLException e) {
    System.out.println(e.getMessage());
}


## Pour edit un project :
String url = "jdbc:sqlite:mydatabase.db";
String sql = "DELETE FROM Projects WHERE ProjectID = (?); INSERT INTO Projects (ProjectName, ProjectID, Employees, Tasks, Deadline) VALUES(?, ?, ?, ?, ?)";
try (Connection conn = DriverManager.getConnection(url);
     PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setInt(1, OldProjectIDInt);
    pstmt.setString(2, newProjectNameText);
    pstmt.setInt(3, OldProjectIDInt);
    pstmt.setString(4, EmployeesList);
    pstmt.setString(5, TasksList);
    pstmt.setDate(6, newDeadlineDate);
    pstmt.executeUpdate();
    System.out.println("Data updated.");
} catch (SQLException e) {
     System.out.println(e.getMessage());
}


## pour créer une task:
String url = "jdbc:sqlite:mydatabase.db";
String sql = "INSERT INTO Tasks(TaskName, TaskID, Priority, Status, Deadline, Comment, Description, ProjectID, EmployeeID) VALUES(?, ?, ?, ?, ?, ?, ?, (SELECT ProjectID FROM Projects WHERE ProjectID = ?), (SELECT EmployeeID FROM Employees WHERE EmployeeID = ?))";
try (Connection conn = DriverManager.getConnection(url);
     PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setString(1, taskNameText);
    pstmt.setInt(2, taskIDInt);
    pstmt.setInt(3, priorityInt);
    pstmt.setString(4, statusText);
    pstmt.setDate(5, deadlineDate);
    pstmt.setString(6, commentText);
    pstmt.setString(7, descriptionText);
    pstmt.setInt(8, thisProjectID);
    pstmt.setInt(9, selectedEmployeeIDInt)
    pstmt.executeUpdate();
    System.out.println("Data inserted.");
} catch (SQLException e) {
    System.out.println(e.getMessage());
}


## Pour delete une task :
String url = "jdbc:sqlite:mydatabase.db";
String sql = "DELETE FROM Tasks WHERE ProjectID = (?);";
try (Connection conn = DriverManager.getConnection(url);
     PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setInt(1, TaskIDInt);
    pstmt.executeUpdate();
    System.out.println("Task Deleted.");
} catch (SQLException e) {
    System.out.println(e.getMessage());
}


## Pour edit une task :
String url = "jdbc:sqlite:mydatabase.db";
String sql = "DELETE FROM Tasks WHERE TaskID = (?); INSERT INTO Tasks (TaskName, TaskID, Priority, Status, Deadline, Comment, Description, ProjectID, EmployeeID) VALUES(?, ?, ?, ?, ?, ?, ?, (SELECT ProjectID FROM Projects WHERE ProjectID = ?), (SELECT EmployeeID FROM Employees WHERE EmployeeID = ?))";
try (Connection conn = DriverManager.getConnection(url);
     PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setString(1, taskNameText);
    pstmt.setInt(2, taskIDInt);
    pstmt.setInt(3, priorityInt);
    pstmt.setString(4, statusText);
    pstmt.setDate(5, deadlineDate);
    pstmt.setString(6, commentText);
    pstmt.setString(7, descriptionText);
    pstmt.setInt(8, thisProjectID);
    pstmt.setInt(9, selectedEmployeeIDInt)
    pstmt.executeUpdate();
    System.out.println("Data updated.");
} catch (SQLException e) {
     System.out.println(e.getMessage());
}