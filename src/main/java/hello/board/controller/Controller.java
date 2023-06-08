package hello.board.controller;

import hello.board.user.User;
import hello.board.user.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Session;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/into")
    public String into() {
        log.info("get into");
        return "/into";
    }

    @PostMapping("/into")
    public String postInto(@RequestBody @Valid UserDTO userDTO, HttpSession session) {
        log.info("post into");
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setNickName(userDTO.getNickName());
        session.setAttribute("user", user);
        return "/hello";
    }
}