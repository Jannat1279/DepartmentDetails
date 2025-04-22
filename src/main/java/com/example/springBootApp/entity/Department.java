package com.example.springBootApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok allows us to remove the boilerplate code from our Java application.

// Now, this class can interact with the database.
//@Entity: Marks this class as a JPA entity, meaning it will map to a table in the database.
@Entity
// Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsHashCode
@Data
@NoArgsConstructor
public class Department {
//    For primary key
//    @Id: Marks this field as the primary key.
//@GeneratedValue: Automatically generates the value (e.g., 1, 2, 3…) when inserting into DB.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Please add Department name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}

//All of this is reduced via the @Lombok.

//    public Long getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(Long departmentId) {
//        this.departmentId = departmentId;
//    }
//
//    public String getDepartmentCode() {
//        return departmentCode;
//    }
//
//    public void setDepartmentCode(String departmentCode) {
//        this.departmentCode = departmentCode;
//    }
//
//    public String getDepartmentName() {
//        return departmentName;
//    }
//
//    public void setDepartmentName(String departmentName) {
//        this.departmentName = departmentName;
//    }
//
//    public String getDepartmentAddress() {
//        return departmentAddress;
//    }
//
//    public void setDepartmentAddress(String departmentAddress) {
//        this.departmentAddress = departmentAddress;
//    }
//
//
//
//    public Department(Long departmentId, String departmentName, String departmentAddress,String departmentCode){
//        this.departmentId=departmentId;
//        this.departmentName=departmentName;
//        this.departmentAddress=departmentAddress;
//        this.departmentCode=departmentCode;
//    }
//
//    public Department() {
//    }
//
//    @Override
//    public String toString() {
//        return "Department{" +
//                "departmentId=" + departmentId +
//                ", departmentName='" + departmentName + '\'' +
//                ", departmentAddress='" + departmentAddress + '\'' +
//                ", departmentCode='" + departmentCode + '\'' +
//                '}';
//    }
