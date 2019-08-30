package com.Windspinks.Classwork.Lesson_3;

public class Application {
    private String firstName;
    private String lastName;
    private Integer age;
    private Character gender;
    private String[] siblings;
    private String[] parents;

    public Application() {
    }

    public Application(String firstName, String lastName, Integer age, Character gender, String[] siblings, String[] parents) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.siblings = siblings;
        this.parents = parents;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getGender() {
        return gender;
    }

    public String getGenderFull() {
        switch (gender) {
            case 'M':
                return "Male";
            case 'F':
                return "Female";
            case 'N':
                return "Non-binary";
            default:
                return "Other";
        }
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String[] getSiblings() {
        return siblings;
    }

    public void setSiblings(String[] siblings) {
        this.siblings = siblings;
    }

    public String[] getParents() {
        return parents;
    }

    public void setParents(String[] parents) {
        this.parents = parents;
    }
}
