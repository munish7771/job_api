package com.tropogo.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name="`username`", length = 30)
    private String postedBy;

    @Column(length = 30, nullable = false)
    private String designation;

    @Min(1)
    @Max(99999999)
    @Column(nullable = false)
    private int compensation;

    @Column(length = 30, nullable = false)
    private String location;

    @Column(length = 100, nullable = false)
    private String skills;

    @Min(0)
    @Max(180)
    @Column(name="`notice_period`", nullable = false)
    private int noticePeriod;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getCompensation() {
        return compensation;
    }

    public void setCompensation(int compensation) {
        this.compensation = compensation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(int noticePeriod) {
        this.noticePeriod = noticePeriod;
    }

}
