package com.vs.authorizationService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="data_user")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_data_user")
    private Long idRUserData;

    @Column(name="INN")
    private  String INN;

    @Column(name="Full_name_company")
    private  String fullNameCompany;

    @OneToOne(mappedBy = "userData")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_type_subject")
    private TypeSubject typeSubject;

    @ManyToOne
    @JoinColumn(name = "id_organizational_form")
    private OrganizationalForm organizationalForm;

    @Override
    public String toString() {
        return "UserData{" +
                "INN='" + INN + '\'' +
                ", fullNameCompany='" + fullNameCompany + '\'' +
                ", user=" + user.getLogin() +
                ", typeSubject=" + typeSubject.toString() +
                ", organizationalForm=" + organizationalForm.toString() +
                '}';
    }
}
