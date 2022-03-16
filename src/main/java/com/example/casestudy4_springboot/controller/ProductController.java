package com.example.casestudy4_springboot.controller;

import com.example.casestudy4_springboot.model.Category;
import com.example.casestudy4_springboot.model.Product;
import com.example.casestudy4_springboot.service.ICategoryService;
import com.example.casestudy4_springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @Value("${file-upload}")
    private String fileUpload;

    @ModelAttribute(value = "categories")
    private Iterable<Category> findAll() {
        return iCategoryService.findAll();
    }

    @GetMapping
    public ModelAndView showProduct(@PageableDefault(value = 10) Pageable pageable, @RequestParam Optional<String> search) {
        ModelAndView modelAndView = new ModelAndView("admin-product-manager");
        Page<Product> products;
        if (search.isPresent()) {
            products = iProductService.findAllByName(pageable, search.get());
            modelAndView.addObject("search", search.get());
        } else {
            products = iProductService.findAll(pageable);
        }
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PageableDefault(value = 10) Pageable pageable, @PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("admin-product-manager");
        iProductService.delete(id);
        Page<Product> products = iProductService.findAll(pageable);
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("admin-create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("product", product);
            return "redirect:/admin/create";
        }
        MultipartFile multipartFile = product.getFile();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(product.getFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        product.setImage("/imageUpload/" + fileName);
        iProductService.save(product);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("admin-edit");
        Optional<Product> product = iProductService.findOne(id);
        product.ifPresent(value -> modelAndView.addObject("product", value));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@Valid @ModelAttribute("product") Product product,
                              BindingResult bindingResult, Model model,
                              @PathVariable("id") Long id) throws IOException {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("product", product);
            return "redirect:/admin/edit";
        }
        MultipartFile multipartFile = product.getFile();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(product.getFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        product.setId(id);

        if(!fileName.equals("")) {
            product.setImage("/imageUpload/" + fileName);
            iProductService.save(product);
        } else {
            product.setImage(iProductService.findOne(id).get().getImage());
            iProductService.save(product);
        }
        return "redirect:/admin";
    }
}
