package com.fourones.simpleapiserver.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class SimpleRestController {

    @GetMapping("/board")
    public void findAllBoards() {

    }

    @GetMapping("/board/{id}")
    public void findByBoardId(@PathVariable("id") String id) {

    }

}
