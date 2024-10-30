package com.vmoacademy.freshermanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="fresher")
public class Fresher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Integer id;
    @Column(name ="fresher_name")
    private String fresherName;
    @Column(name ="gender")
    private String gender;
    @Column(name ="email")
    private String email;
    @Column(name ="point_one")
    private Double point1;
    @Column(name ="point_two")
    private Double point2;
    @Column(name ="point_three")
    private Double point3;
    @Column(name ="avg_point")
    private Double avgPoint;
    @Column(name ="department_id")
    private Integer departmentId;

    public Fresher() {
    }

    public Fresher(String fresherName, String gender, String email, double point1, double point2, double point3, Double avgPoint, Integer departmentId) {
        this.fresherName = fresherName;
        this.gender = gender;
        this.email = email;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.avgPoint = avgPoint;
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Fresher{" +
                "id=" + id +
                ", fresherName='" + fresherName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3 +
                ", avgPoint=" + avgPoint +
                ", departmentId=" + departmentId +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFresherName() {
        return fresherName;
    }

    public void setFresherName(String fresherName) {
        this.fresherName = fresherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPoint1() {
        return point1;
    }

    public void setPoint1(Double point1) {
        this.point1 = point1;
    }

    public Double getPoint2() {
        return point2;
    }

    public void setPoint2(Double point2) {
        this.point2 = point2;
    }

    public Double getPoint3() {
        return point3;
    }

    public void setPoint3(Double point3) {
        this.point3 = point3;
    }

    public Double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(Double avgPoint) {
        this.avgPoint = avgPoint;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
