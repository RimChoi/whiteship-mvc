package com.metamong.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class SampleController {

    // method 를 지정하지 않으면, 모든 HTTP method 허용.
//    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.PUT})

    /**
     * 요청 식별자 맵핑하기 e.g.
     * @RequestMapping 는 다음을 지원한다.
     * ? : 한 글자 ("/hello/???" => "/hello/123")
     * * : 여러 글자 ("/hello/*" => "/hello/metamong")
     * **: 여러 패스 ("/hello/** => "/hello/metamong/pokemon")
     * @param name
     * @return
     */
    @RequestMapping("/{name:[a-z]+}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "hello " + name;
    }

    // 패턴이 중복되는 경우 더 적합한 핸들러를 호출한다.
    // URI 확장은 보안 이슈 때문에 사용하지 않는 것을 추천. 특정 컨텐츠 타입을 원한다면 accept header 를 이용하셔라.
    @RequestMapping({"/metamong", "/metamong/*"})
    @ResponseBody
    public String helloMetamong() {
        return "hello Metamong";
    }
}
