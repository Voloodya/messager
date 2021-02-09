package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.UserData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserDataServiceImplTest {

    @Autowired
    private UserDataService userDataService;
    @Autowired
    private OrganizationalFormService organizationalFormService;
    @Autowired
    private TypeSubjectService typeSubjectService;

    private static final Long user_data_id=1L;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAllBy() {
        List<UserData> userData=userDataService.findAllBy();
        assertFalse(userData.isEmpty());
    }

    @Test
    void findByIdRUserData() {
        Optional<UserData> userData=userDataService.findByIdRUserData(user_data_id);
        assertTrue(userData.isPresent());
    }

    @Test
    void findByUser() {
    }

    @Test
    void save() {
        UserData userData=UserData.builder().INN("123654789012").fullNameCompany("OAO Romashka").typeSubject(typeSubjectService.findByIdTypeSubject(1).get())
                .organizationalForm(organizationalFormService.findByIdOrganizationalForm(1).get()).build();
        userDataService.save(userData);
        assertNotNull(userData.getIdRUserData());

    }

    @Test
    void dell() {
        List<UserData> userData=userDataService.findAllBy();
        userDataService.deleteById(user_data_id);
        List<UserData> userDataAfterDell=userDataService.findAllBy();
        int result=(userData.size()-userDataAfterDell.size());
        assertTrue(result==1);

    }

    @Test
    void testDell() {
    }
}