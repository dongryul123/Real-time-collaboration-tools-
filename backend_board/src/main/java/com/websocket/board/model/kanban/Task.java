package com.websocket.board.model.kanban;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Task implements Serializable {

    @Id
    @Column(nullable = false, name = "task_id")
    private String id;
    private String taskTitle;
    private String taskContents;
    private String taskAssigner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private State state;
}
