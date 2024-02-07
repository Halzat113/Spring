package com.example.entity;

import com.example.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Where(clause = "is_deleted=false")
@Setter
@Getter
@NoArgsConstructor
public class Task extends BaseEntity{
    private String taskSubject;
    private String taskDetail;
    @Enumerated(EnumType.STRING)
    private Status taskStatus;
    @Column(columnDefinition = "DATE")
    private LocalDate assignedDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private User assignedEmployee;
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

}
