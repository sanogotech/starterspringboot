package com.macrosoft.starterjavaspringbootfull.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le nom ne peut pas être null")
    @NotEmpty(message = "Le nom ne peut pas être vide")
    @Size(min = 2, max = 100, message = "Le nom doit contenir entre 2 et 100 caractères")
    private String name;

    @NotNull(message = "L'heure de début ne peut pas être null")
    private Date startTime;

    @NotNull(message = "L'heure de fin ne peut pas être null")
    private Date endTime;

    @NotEmpty(message = "Le jour de la semaine ne peut pas être vide")
    @Size(min = 2, max = 20, message = "Le jour de la semaine doit contenir entre 2 et 20 caractères")
    private String dayOfWeek;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Classroom schoolClass;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

	public Classroom getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(Classroom schoolClass) {
		this.schoolClass = schoolClass;
	}
    
    

  
}
