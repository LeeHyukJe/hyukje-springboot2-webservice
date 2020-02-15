package com.hyukje.book.springboot.config.oauth;

import com.hyukje.book.springboot.config.oauth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isLoginUserAnnotation  = parameter.getParameterAnnotation(LoginUser.class) != null; // 생성한 LoginUser annotation Class가 존재하는지 여부확인
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType()); // Annotation으로 적용할 파라미터 타입이 SessionUser 인지 확인
        return isLoginUserAnnotation && isUserClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return httpSession.getAttribute("user"); // annotaion으로 적용한 파라미터에 넣을 변수
    }
}
