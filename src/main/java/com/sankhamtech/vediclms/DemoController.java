package com.sankhamtech.vediclms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.sql.DataSource;
import java.sql.Connection;

@RestController
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/db")
    public String testDb() {
        try (Connection conn = dataSource.getConnection()) {
            return "DB Connected: " + conn.getMetaData().getURL();
        } catch (Exception e) {
            return "DB Connection Failed: " + e.getMessage();
        }
    }
}