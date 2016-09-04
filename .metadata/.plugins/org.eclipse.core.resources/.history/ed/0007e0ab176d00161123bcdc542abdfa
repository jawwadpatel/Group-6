
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {

    private SimpleStringProperty name;
    private SimpleIntegerProperty id;
    private SimpleIntegerProperty quiz;
    private SimpleIntegerProperty assig1, assig2;
    private SimpleIntegerProperty exam;
    private SimpleDoubleProperty result;
    private SimpleStringProperty grade;

    public Student(String name, int id, int quiz, int assig1, int assig2, int exam) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleIntegerProperty(id);
        this.quiz = new SimpleIntegerProperty(quiz);
        this.assig1 = new SimpleIntegerProperty(assig1);
        this.assig2 = new SimpleIntegerProperty(assig2);
        this.exam = new SimpleIntegerProperty(exam);
        setGrade();
    }

    /**
     * Calculate result and grade for student
     */
    private void setGrade() {
        //calculate result
        result = new SimpleDoubleProperty(quiz.get() * 0.05
                + assig1.get() * 0.2 + assig2.get() * 0.25 + exam.get() * 0.5);
        //set grade
        if (result.get() >= 85)
            grade = new SimpleStringProperty("HD");
        else if (result.get() >= 75)
            grade = new SimpleStringProperty("DI");
        else if (result.get() >= 65)
            grade = new SimpleStringProperty("CR");
        else if (result.get() >= 50)
            grade = new SimpleStringProperty("PS");
        else
            grade = new SimpleStringProperty("FL");
    }

    public String getName() {
        return name.get();
    }

    public int getId() {
        return id.get();
    }

    public int getQuiz() {
        return quiz.get();
    }

    public int getAssig1() {
        return assig1.get();
    }

    public int getAssig2() {
        return assig2.get();
    }

    public int getExam() {
        return exam.get();
    }

    public String getGrade() {
        return grade.get();
    }

    public double getResult() {
        return result.get();
    }

}
