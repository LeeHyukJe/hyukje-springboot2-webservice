package com.hyukje.book.springboot.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;


//    public String getName() {
//        return name;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public HelloResponseDto(String name, int amount){
//        this.name = name;
//        this.amount = amount;
//    }
}
