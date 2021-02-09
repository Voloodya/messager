package com.vs.authorizationService.entity;
/**
 **Simpje JavaBean object that represents user
 *
 * @autor vladimir.s
 * @version 1.0
 */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_user")
    private long idUser;
    @Column(name="User_name")
    private  String userName;
    @Column(name="Password")
    private String password;
    @Transient
    transient private String confirmPassword;
    @Column(name="Word_Coder")
    private String wordCoder;
    @Enumerated(value = EnumType.STRING)
    @Column(name="Status")
    private Status status;
    @Column(name="Email")
    private String email;
    @Column(name="First_name")
    private String firstName;
    @Column(name="Last_name")
    private String lastName;
    @Column(name="Created_date")
    private Date createdDate;
    @Column(name="Updated_date")
    private Date updatedDate;

    @OneToMany(mappedBy="userRequest", fetch = FetchType.EAGER)
    private List<Request> requests;

    @OneToMany(mappedBy="userResponse")
    private List<Message> messages;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "Data_user_id", referencedColumnName = "Id_data_user")
    private UserData userData;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "User_roles", joinColumns = {@JoinColumn(name="User_id")},
    inverseJoinColumns = {@JoinColumn(name = "Role_id")})
    private Set<Role> roles;

    public User(long id_User, String firstName, String lastName) {
        this.idUser = id_User;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getLogin() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getWordCoder() {
        return wordCoder;
    }

    public Status getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public List<Message> getRespons() {
        return messages;
    }

    public UserData getUserData() {
        return userData;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setLogin(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setWordCoder(String wordCoder) {
        this.wordCoder = wordCoder;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public void setRespons(List<Message> messages) {
        this.messages = messages;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", wordCoder='" + wordCoder + '\'' +
                ", status=" + status.toString() +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdDate=" + createdDate.toString() +
                ", updatedDate=" + updatedDate.toString() +
                ", requests=" + requests.toString() +
                ", messages=" + messages.toString() +
                ", userData=" + userData.toString() +
                ", roles=" + roles.toString() +
                '}';
    }
}
