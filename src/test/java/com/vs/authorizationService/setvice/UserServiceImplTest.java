package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.Role;
import com.vs.authorizationService.entity.Status;
import com.vs.authorizationService.entity.User;
import com.vs.authorizationService.entity.UserData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDataService userDataService;
    @Autowired
    private TypeSubjectService typeSubjectService;
    @Autowired
    private OrganizationalFormService organizationalFormService;
    @Autowired
    private RoleService roleService;

    private static final Long id_user= 1L;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        UserData userData=UserData.builder().INN("123654789012").fullNameCompany("OAO Romashka").typeSubject(typeSubjectService.findByIdTypeSubject(1).get())
                .organizationalForm(organizationalFormService.findByIdOrganizationalForm(1).get()).build();
        userDataService.save(userData);
        Set<Role> roles=new HashSet<Role>();
        roles.add(roleService.findByIdRole(1).get());
        User user=User.builder().userData(userData).createdDate(new Date(2021,01,31)).email("ya@ru").firstName("incognito").lastName("xxxx")
                .userName("jbytctrc").password("kjyuvtvt").roles(roles).status(Status.ACTIVE).wordCoder("kjbtyctx5ex").build();
        userService.save(user);

        assertNotNull(user.getIdUser());
    }

    @Test
    void findById(){
        Optional<User> user=userService.findById(id_user);
        assertTrue(user.isPresent());
    }
    @Test
    void findByLogin() {
    }

    @Test
    void findAllBy() {
        List<User> users=userService.findAllBy();
        assertFalse(users.isEmpty());
    }

    @Test
    void findByUserData() {
    }

    @Test
    void findByStatus() {
        List<User> users=userService.findByStatus(Status.ACTIVE);
        assertTrue(!users.isEmpty());
        List<User> filterUsers=users.stream().filter((x)->x.getStatus().equals(Status.ACTIVE)).collect(Collectors.toList());
        assertTrue(users.size()==filterUsers.size());
    }

    @Test
    void findByStatusCustomQuery() {
    }

    @Test
    void greetUser() {
    }
}