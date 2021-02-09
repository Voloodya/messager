package com.vs.authorizationService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 **Simpje JavaBean object that represents type of user
 *
 * @autor vladimir.s
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Type_subject")
public class TypeSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_type_subject")
    private int idTypeSubject;

    @Column(name="Name")
    private  String name;

    @OneToMany(mappedBy = "typeSubject")
    private List<UserData> userDataList;

    @Override
    public String toString() {
        return "TypeSubject{" +
                "name='" + name + '\'' +
                '}';
    }
}
