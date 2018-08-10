package java_oop.firstYearStudends;

public class Student {
    private final String firstName;
    private final String lastName;
    private final boolean sex;
    private final int birthYear;
    private final double academicPerformance;
    private final UniversityActivities activity;
    private final int id;

    public Student(String firstName, String lastName, boolean sex, int birthYear,
                   double academicPerformance, UniversityActivities activity, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthYear = birthYear;
        this.academicPerformance = academicPerformance;
        this.activity = activity;
        this.id = id;
    }

    public double getRating(){
        double rating = getAcademicPerformance();

        switch (Student.this.getActivity()){
            case SPORT_TEAM: rating += 1.0;
            break;
            case KVN_TEAM: rating += 1.0;
            break;
            case MUSIC_GROUP: rating +=1.0;
            break;
            case ACADEMIC_ACTIVITY: rating += 2.0;
            break;
            case NONE: rating += 0;
            break;
        }

        return rating;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isSex() {
        return sex;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getAcademicPerformance() {
        return academicPerformance;
    }

    public UniversityActivities getActivity() {
        return activity;
    }


    @Override
    public String toString() {
        return  firstName + " " + lastName +
                "; sex - " + (sex ? "man" : "woman") +
                "; birthYear - " + birthYear +
                "; academicPerformance: " + academicPerformance +
                "; activity: " + activity +
                "; id: " + id;
    }
}
