
import java.util.HashMap;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Task_2 extends Application {

    //text feilds
    private TextField txt_id;
    private TextField txt_name;
    private TextField txt_quiz;
    private TextField txt_assig1;
    private TextField txt_assig2;
    private TextField txt_exam;
    private TextField txt_avg;

    //table
    private TableView<Student> table;
    private ObservableList<Student> data;

    //buttons
    private Button btn_avgMarks;
    private Button btn_addStudent;

    //students hash map
    private HashMap<Integer, Student> students = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        ///////////////////////////////////////////////////////////////
        //create top pane and components in it
        GridPane topPane = new GridPane();
        topPane.setAlignment(Pos.CENTER); //set pane at center
        topPane.setPadding(new Insets(5)); // set gap from sides
        topPane.setHgap(5); // set horizantal gap between components
        topPane.setVgap(5); // set vertical gap between components
        //
        //add components to top
        ////////////////////////////////////////////////////////
        //id
        ////////////////////////////////////////////////////////
        //id label
        Label lbl_id = new Label("Student ID (must be 8 digits)");
        GridPane.setHalignment(lbl_id, HPos.LEFT);
        topPane.add(lbl_id, 0, 0);
        //id text
        txt_id = new TextField();
        topPane.add(txt_id, 1, 0);
        ////////////////////////////////////////////////////////
        //name
        ////////////////////////////////////////////////////////
        //name label
        Label lbl_name = new Label("Student Name");
        GridPane.setHalignment(lbl_name, HPos.LEFT);
        topPane.add(lbl_name, 0, 1);
        //name text
        txt_name = new TextField();
        topPane.add(txt_name, 1, 1);
        ////////////////////////////////////////////////////////
        //quiz
        ////////////////////////////////////////////////////////
        //quiz label
        Label lbl_quiz = new Label("Quiz Marks (enter 0-100)");
        GridPane.setHalignment(lbl_quiz, HPos.LEFT);
        topPane.add(lbl_quiz, 0, 2);
        //quiz text
        txt_quiz = new TextField();
        topPane.add(txt_quiz, 1, 2);
        ////////////////////////////////////////////////////////
        //assignment1
        ////////////////////////////////////////////////////////
        //assignment1 label
        Label lbl_assig1 = new Label("Assignment 1 Marks (enter 0-100)");
        GridPane.setHalignment(lbl_assig1, HPos.LEFT);
        topPane.add(lbl_assig1, 0, 3);
        //assignment1 text
        txt_assig1 = new TextField();
        topPane.add(txt_assig1, 1, 3);
        ////////////////////////////////////////////////////////
        //assignment2
        ////////////////////////////////////////////////////////
        //assignment2 label
        Label lbl_assig2 = new Label("Assignment 2 Marks (enter 0-100)");
        GridPane.setHalignment(lbl_assig2, HPos.LEFT);
        topPane.add(lbl_assig2, 0, 4);
        //assignment2 text
        txt_assig2 = new TextField();
        topPane.add(txt_assig2, 1, 4);
        ////////////////////////////////////////////////////////
        //exam
        ////////////////////////////////////////////////////////
        //exam label
        Label lbl_exam = new Label("Exam Marks (enter 0-100)");
        GridPane.setHalignment(lbl_exam, HPos.LEFT);
        topPane.add(lbl_exam, 0, 5);
        //exam text
        txt_exam = new TextField();
        topPane.add(txt_exam, 1, 5);

        ////////////////////////////////////////////////////////////////
        //create center pane and add components to it
        BorderPane centerPane = new BorderPane();
        centerPane.setPadding(new Insets(5));

        //create columns names and values
        TableColumn nameC = new TableColumn("Name");
        nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn idC = new TableColumn("ID");
        idC.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn quizC = new TableColumn("Quiz");
        quizC.setCellValueFactory(new PropertyValueFactory<>("quiz"));
        TableColumn assig1C = new TableColumn("A1");
        assig1C.setCellValueFactory(new PropertyValueFactory<>("assig1"));
        TableColumn assig2C = new TableColumn("A2");
        assig2C.setCellValueFactory(new PropertyValueFactory<>("assig2"));
        TableColumn examC = new TableColumn("Exam");
        examC.setCellValueFactory(new PropertyValueFactory<>("exam"));
        TableColumn resultC = new TableColumn("Result");
        resultC.setCellValueFactory(new PropertyValueFactory<>("result"));
        TableColumn gradeC = new TableColumn("Grade");
        gradeC.setCellValueFactory(new PropertyValueFactory<>("grade"));
        //create table and add columns to it
        table = new TableView<>();
        table.getColumns().addAll(nameC, idC, quizC, assig1C, assig2C, examC, resultC, gradeC);
        //create data and add to table
        data = FXCollections.observableArrayList();
        table.setItems(data);
        //set table in center pane
        centerPane.setCenter(table);
        ////////////////////////////////////////////////////////////////
        //create and add components in bottom pane
        FlowPane bottomPane = new FlowPane();
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setPadding(new Insets(5));
        bottomPane.setHgap(5);
        //create txt average and close it
        txt_avg = new TextField();
        txt_avg.setEditable(false);
        //create button "Average Marks" and set action on click
        btn_avgMarks = new Button("Average Marks");
        btn_avgMarks.setOnAction(e -> {
            //get students score and count them
            double cnt = 0, totalScore = 0;
            for (Student student : students.values()) {
                totalScore += student.getResult();
                cnt++;
            }
            //get avg for all
            double avg = (int) (totalScore / cnt * 100) / 100.0;
            //display avg
            txt_avg.setText("" + avg);
        });
        //create button "Add Student" and set action on click
        btn_addStudent = new Button("Add Student");
        btn_addStudent.setOnAction(e -> {
            //check if fields not empty
            String name;
            int id, quiz, assig1, assig2, exam;
            try {
                //get components
                id = Integer.parseInt(txt_id.getText());
                name = txt_name.getText();
                quiz = Integer.parseInt(txt_quiz.getText());
                assig1 = Integer.parseInt(txt_assig1.getText());
                assig2 = Integer.parseInt(txt_assig2.getText());
                exam = Integer.parseInt(txt_exam.getText());
                //if name is empty
                if (name.isEmpty())
                    throw new NumberFormatException();
                //if id not 8 digits
                if (txt_id.getText().length() != 8)
                    throw new NumberFormatException();
                //if any grade below 0 or above 100
                if (quiz < 0 || quiz > 100 || assig1 < 0 || assig1 > 100 || exam < 0 || exam > 100 || assig2 < 0 || assig2 > 100)
                    throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                return;
            }
            //if all input valid
            Student student = new Student(name, id, quiz, assig1, assig2, exam);
            //add to hash map and to table then show success message
            students.put(id, student);
            data.add(student);
            //reset all fields
            txt_id.setText("");
            txt_name.setText("");
            txt_assig1.setText("");
            txt_assig2.setText("");
            txt_quiz.setText("");
            txt_exam.setText("");
        });
        //add all components in bottom to pane
        bottomPane.getChildren().addAll(new Label("Average Marks: "), txt_avg, btn_avgMarks, btn_addStudent);

        ////////////////////////////////////////////////////////////////
        //create window main scene and add components to it
        BorderPane root = new BorderPane();
        root.setTop(topPane);
        root.setCenter(centerPane);
        root.setBottom(bottomPane);

        Scene scene = new Scene(root, 650, 400);
        //set window title and show it
        primaryStage.setTitle("Grade Processing Programming in Java 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
