package be.osse.focus_track_api.controller.projects;


import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("it")
@Transactional
class ProjectControllerIT {

    private final MockMvc mvc;


    @Autowired
    ProjectControllerIT(MockMvc mvc) {
        this.mvc = mvc;
    }

    @BeforeEach
    public void setUp(){

    }

    @Test
    void testFindAll() {
        // GIVEN

        // WHEN
        //mvc.perform(get("/projects")
        //                .contentType(MediaType.APPLICATION_JSON))

        // THEN
        //       .andDo(System.out::println)
        //        .andExpect(status().isOk())
        //        .andExpect(jsonPath("$.[0].title").value("Project Alpha"))
        //        .andExpect(jsonPath("$.length()").value("1"));
    }
}
