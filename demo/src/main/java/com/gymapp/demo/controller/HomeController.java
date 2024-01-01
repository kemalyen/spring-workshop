package com.gymapp.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gymapp.demo.dto.HelloResponse;
import com.gymapp.demo.dto.InventoryResponse;
import com.gymapp.demo.service.InventoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    // create a new home controller with home page

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public HelloResponse home() {
        log.info("example response with response object");
        return HelloResponse.builder().message("Hello World!").build();
    }

    @GetMapping("/inventory")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> inventory(@RequestParam List<String> skuCode) {
        log.info("Received inventory check request for skuCode: {}", skuCode);
        return inventoryService.isInStock(skuCode);
    }

}
