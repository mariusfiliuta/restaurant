//package tests;
//
//import main.App;
//import java.util.List;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.IntegrationTest;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//import services.UserService;
//
//import static org.assertj.core.api.Assertions.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
//@IntegrationTest
//@Transactional
//public class ServicesTests {
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void checkIfFindAllReturnsAnything(){
//        assertThat(userService.findAll().size() == 0);
//    }
//
//    @Test
//    public void checkIfFindAllReturnsAnythingAtAll(){
//        assertThat(userService.findAll().size() == 1);
//    }
//}
