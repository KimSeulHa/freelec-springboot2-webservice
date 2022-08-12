package com.seulha.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
/*
  build.gradle에서 머스테치 스타터 의존성을 추가했기 때문에
  컨트럴러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정됨
  *앞의 경로: src/main/resources/templates
  *뒤의 확장자: .mustache
 */
