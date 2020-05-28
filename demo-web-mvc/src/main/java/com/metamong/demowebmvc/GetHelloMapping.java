package com.metamong.demowebmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;


/**
 * 강좌 Q. @Retention 의 기본 설정은 RetentionPolicy.CLASS 이다.
 * 그렇다면 언제 사용되는 것일까?
 *
 * 강사님 A: "애노테이션 정보를 class 까지 즉 바이트코드까지 유지 시켜놓으면
 * 바이트코드를 조작해서 뭔가를 해야 하는 작업에 유용하게 사용할 수 있습니다.
 * 바이트코드를 조작하는 방법으로 동작하는 AOP를 사용하는 경우에도 그렇구요.
 * CGLib이나 ByteBuddy 등의 유틸성 라이브러리를 사용하는 경우에도 유용할 거구요."
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(value = "/hello", method = RequestMethod.GET)
public @interface GetHelloMapping {

}
