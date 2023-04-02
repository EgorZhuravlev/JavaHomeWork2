import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Exercise1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        File file = new File("A:/Education/JavaCourse/Homework2/DataForExercise1.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String jsonString = br.readLine();
//            System.out.println(jsonString);
            String[] rows = jsonString.split("},");
            String[][] matrix = new String[rows.length][];
            int r = 0;
            for (String row : rows) {
                row = row.replace("{", "");
                row = row.replace("}", "");
                row = row.replace("[", "");
                row = row.replace("]", "");
                row = row.replace(":", ",");
                row = row.replace(" ", "");
                row = row.replace("\"", "");
                matrix[r++] = row.split(",");
            }
//            System.out.println(Arrays.deepToString(matrix));
            for (int i = 0; i < matrix.length; i++) {
                sb.append("Студент ");
                sb.append(matrix[i][1]);
                sb.append(" получил ");
                sb.append(matrix[i][3]);
                sb.append(" по предмету ");
                sb.append(matrix[i][5]);
                if (i != matrix.length - 1) {
                    sb.append("\n");
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        String resultString = new String(sb);
        System.out.println(resultString);
    }
}