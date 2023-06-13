package hello.board.controller;

import hello.board.response.Response;
import hello.board.user.User;
import hello.board.user.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        log.info("로직이 실행되기 이전의 modelAndView = {}", modelAndView);
        modelAndView.setViewName("/index");
        User user = new User();
        user.setNickName("Hello World");
        modelAndView.addObject("user", user);
        log.info("로직이 실행된 이후의 modelAndView = {}", modelAndView);
        return modelAndView;
    }

    @GetMapping("/into")
    public ModelAndView into(ModelAndView modelAndView) {
        log.info("get into");
        log.info("로직이 실행되기 이전의 modelAndView = {}", modelAndView);
        modelAndView.setViewName("/into");
        log.info("로직이 실행된 이후의 modelAndView = {}", modelAndView);
        return modelAndView;
    }

    @PostMapping("/into")
    @ResponseBody
    public Response postInto(@RequestBody @Validated UserDTO userDTO, BindingResult result, ModelAndView modelAndView) {

        log.info("post into");
        log.info("로직이 실행되기 이전의 modelAndView = {}", modelAndView);

        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setNickName(userDTO.getNickName());

        if (result.hasErrors()) {
            log.info("로직이 실행된 이후의 modelAndView = {}", modelAndView);
            return Response.of(false, result.getAllErrors());
        }

        modelAndView.addObject("user", user);
        log.info("로직이 실행된 이후의 modelAndView = {}", modelAndView);
        return Response.of("/");
    }

}
