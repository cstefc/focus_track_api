package be.osse.focus_track_api.controller.projects;


import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.repository.projects.ProjectRepo;
import be.osse.focus_track_api.service.projects.project.ProjectService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    void testFindAll() throws Exception {
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
