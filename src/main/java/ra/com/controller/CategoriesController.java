package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.com.model.Categories;
import ra.com.service.CategoriesService;

import java.util.List;

@Controller
@RequestMapping("/categoriesController")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;
    @GetMapping("/findAll")
    public String findAllCategories(Model model) {
        model.addAttribute("listCategories",categoriesService.findAll());
        return "categories";
    }
    @GetMapping("/initCreate")
    public String initCreateCatalog(Model model){
        model.addAttribute("catalog",new Categories());
        return "newCategories";
    }
    @PostMapping("/create")
    public String createCatalog(Categories catalog){
        boolean result = categoriesService.save(catalog);
        if (result){
            return "redirect:findAll";
        }
        return "error";
    }
}
