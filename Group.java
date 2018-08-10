package java_oop.firstYearStudends;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Group implements Iterable<Student>{

    private final List<Student> group = new ArrayList<>();

    public Group() {
    }

    public Group(List<Student> studentList) {
        this.group.addAll(studentList);
    }

    public void addStudent(Student student){
        group.add(student);
    }

    public List<Student> getGroup() {
        return group;
    }

    /**
     *  Searching for student with highest rating
     */
    public Student getGroupMonitor(){
        double bestRating = group.get(0).getRating();
        Student bestStudent = group.get(0);

        for(Student student: group){
            if (student.getRating() >= bestRating){
                bestRating = student.getRating();
                bestStudent = student;
            }
        }
        return bestStudent;
    }

    /**
     * Delegating List methods
     */
    public int size() {
        return group.size();
    }

    public Student get(int index) {
        return group.get(index);
    }

    public void forEach(Consumer<? super Student> action) {
        group.forEach(action);
    }

    /**
     * Iterator used in class Professor for forEach loop in method checkingList
     */
    @Override
    public Iterator<Student> iterator() {
        return group.iterator();
    }

    public Group filter(Predicate<Student> predicate){
        List<Student> studentList = Professor.studentSearch(group, predicate);
        return new Group(studentList);
    }

    @Override
    public String toString() {
        return "" + group;
    }
}
