package com.itheima.pojo;

public class Chapter {
    public Chapter() {

    }


    private Integer id;
    private String course_name;
    private String unit;
    private String lesson;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
                ", unit='" + unit + '\'' +
                ", lesson='" + lesson + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Chapter(Integer id, String course_name, String unit, String lesson, String description) {
        this.id = id;
        this.course_name = course_name;
        this.unit = unit;
        this.lesson = lesson;
        this.description = description;
    }

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }
}
