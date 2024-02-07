package com.example.entity;

import com.example.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
@NoArgsConstructor
@Table(name = "projects")
@Getter
@Setter
@Where(clause = "is_deleted=false")
@Entity
public class Project extends BaseEntity{
    private String projectName;
    @Column(unique = true)
    private String projectCode;
    @Column(columnDefinition = "DATE")
    private LocalDate startDate;
    @Column(columnDefinition = "DATE")

    private LocalDate endDate;
    private String projectDetail;
    @Enumerated(EnumType.STRING)
    private Status projectStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private User assignedManager;
}
