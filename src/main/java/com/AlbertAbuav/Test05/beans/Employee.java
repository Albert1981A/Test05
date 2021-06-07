package com.AlbertAbuav.Test05.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double salary;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "EMPLOYEE_VS_JOBS", joinColumns = @JoinColumn(name = "THE_EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "THE_JOB_ID")
    )  // ==> Will define the names of the new Table: the Table named "employee_vs_jobs" with to columns: "the_employee_id" and "the_job_id"
    @Singular
    private List<Job> jobs;

}
