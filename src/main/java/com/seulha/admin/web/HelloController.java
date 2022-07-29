package com.seulha.admin.web;
import com.seulha.admin.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//JSON을 반환하는 컨트롤러로 만들어줌
public class HelloController {

    @GetMapping("/hello")
    /*
        HTTP 메소드 GET 요청을 받을 수 있는 API로 만들어줌
        @RequestMapping(method=RequestMethod=Get)과 같음
    */
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
