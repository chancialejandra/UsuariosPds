package com.co.pds.User.Persitence.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Task")
public class Task {

    @Id
    @Column (name = "id_task")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTask;

    private String TaskName;

    @OneToMany(mappedBy = "task",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Row> rows;
}
