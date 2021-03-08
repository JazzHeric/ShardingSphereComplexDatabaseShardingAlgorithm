package com.test.sharding.service;

/**
 * @author: chi.zhang
 * @date: created in 2021/1/6 10:30
 * @description:
 */
public class TestService {

    public static int judge2(int param) {
        int result = 0;
        if(param > 0) {
            result = ~(param - 1);
        } else {
            result = ~(param - 1);
        }
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(Long.valueOf("13133390516020198400"));
        System.out.println(TestService.judge2(-128));
    }
}
