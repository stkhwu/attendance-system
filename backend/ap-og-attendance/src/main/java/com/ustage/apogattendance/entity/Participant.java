package com.ustage.apogattendance.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "participant")
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String name;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Participant) {
            return ((Participant) obj).getName().equals(this.getName());
        }
        return super.equals(obj);
    }
}
