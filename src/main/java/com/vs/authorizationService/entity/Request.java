package com.vs.authorizationService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 **Simpje JavaBean object that represents Message users
 *
 * @autor vladimir.s
 * @version 1.0
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_request")
    private Integer idRequest;

    @ManyToOne
    @JoinColumn(name="User_id_request", nullable=true)
    private User userRequest;

    @Column(name="Request_text")
    private String requestText;

    @Column(name="Created_date_request")
    private Date createdDateRequest;

    @OneToMany(mappedBy="request")
    private List<Message> respons;

    @Override
    public String toString() {
        return "Request{" +
                "userRequest=" + userRequest.getLogin() +
                ", requestText='" + requestText + '\'' +
                ", createdDateRequest=" + createdDateRequest.toString() +
                ", respons=" + respons.toString() +
                '}';
    }
}
