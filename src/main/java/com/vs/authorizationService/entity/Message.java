package com.vs.authorizationService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 **Simpje JavaBean object that represents user
 *
 * @autor vladimir.s
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_message")
    private Integer idMessage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Id_request", nullable=true)
    private Request request;

    @ManyToOne
    @JoinColumn(name="User_id_response", nullable=false)
    private User userResponse;

    @Column(name="Response_text")
    private String responseText;

    @Column(name="Created_date_response")
    private Date createdDateResponse;

    @Column(name="Updated_date_response")
    private Date updatedDateResponse;

    @Override
    public String toString() {
        return "Message{" +
                "request=" + request.getRequestText() +
                ", userResponse=" + userResponse.getLogin() +
                ", responseText='" + responseText + '\'' +
                ", createdDateResponse=" + createdDateResponse.toString() +
                ", updatedDateResponse=" + updatedDateResponse.toString() +
                '}';
    }
}
