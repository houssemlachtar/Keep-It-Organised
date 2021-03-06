package core.enums;


public enum Semester {

    AUTUMN("Autumn"),
    SPRING("Spring"),
    ALL_YEAR("All Year");

    public final String VALUE;
    Semester(String value){
        VALUE = value;
    }

    @Override
    public String toString() {
        return VALUE;
    }

    /**
     * Method which takes a string and returns a corresponding Semester
     *
     * @param semesterString  Semester as a string
     * @return Semester which corresponds to a string
     * */
    public static Semester stringToSemester (String semesterString) {
        for (Semester semester : Semester.values()) {
            if(semesterString.equals(semester.VALUE)) return semester;
        }
        throw new IllegalArgumentException("Semester " + semesterString + " does not exist");
    }
}
