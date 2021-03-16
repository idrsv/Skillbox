import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String password = "root";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select course_name, COUNT(subscription_date)/(MAX(MONTH(subscription_date))) AS count FROM purchaselist group by course_name;");
            while(resultSet.next()){
                String courseName = resultSet.getString("course_name");
                double count = resultSet.getDouble("count");
                System.out.println(courseName + '\n' + count);
            }
            connection.close();
            resultSet.close();
            statement.cancel();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
