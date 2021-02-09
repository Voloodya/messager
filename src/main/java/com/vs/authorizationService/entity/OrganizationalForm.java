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
@Table(name="Organizational_form")
public class OrganizationalForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_organizational_form")
    private int idOrganizationalForm;

    @Column(name="Name")
    private  String name;

    @OneToMany(mappedBy = "organizationalForm")
    private List<UserData> userDataList;

    @Override
    public String toString() {
        return "OrganizationalForm{" +
                "name='" + name + '\'' +
                '}';
    }
}
