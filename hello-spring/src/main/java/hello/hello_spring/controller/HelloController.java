package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //정적 컨텐츠 - 데이터 직접 받음
    @GetMapping("hello")
    public String hello(Model model) {
        // hello.html 에서 data 값을 "hello!!"로 교체
        model.addAttribute("data","hello!!");
        //spring이 hello.html반환하도록 함
        return "hello";
    }

    // mvc - 모델에 담으면 뷰에서 렌더링해서 씀
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name,Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello "+ name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
