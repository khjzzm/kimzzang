package kim.zzang.webservice.web;

import kim.zzang.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/web/list")
    public String list(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "list";
    }



}
