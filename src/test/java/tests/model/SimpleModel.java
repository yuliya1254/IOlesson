package tests.model;

public class SimpleModel {
    private String name;
    private int age;
    private boolean student;
    private Hobby hobby;

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public static class Hobby {
        private String sport;
        private String creation;

        public String getCreation() {
            return creation;
        }

        public void setCreation(String creation) {
            this.creation = creation;
        }

        public String getSport() {
            return sport;
        }

        public void setSport(String sport) {
            this.sport = sport;
        }
    }
}


