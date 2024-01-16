package com.example.casemodule4.controller;

import com.example.casemodule4.model.CartDetail;
import com.example.casemodule4.model.Product;
import com.example.casemodule4.service.ICartService;
import com.example.casemodule4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICartService cartService;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("/cart/list");
        Iterable<CartDetail> cartDetails = cartService.findAllByStatus();
        modelAndView.addObject("carts", cartDetails);
        if (cartDetails.iterator().hasNext()) {
            modelAndView.addObject("cId", cartDetails.iterator().next().getCart().getId());
        } else {
            modelAndView.addObject("cId", 0);
        }
        return modelAndView;
    }

    @GetMapping("/{id}")
    public String addToCart(@PathVariable("id") Long pId) {
        Product product = productService.findById(pId);
        cartService.addToCart(product);
        return "redirect:/customer/home";
    }

    @GetMapping("/down/{id}")
    public String down(@PathVariable Long id) {
        cartService.down(id);
        return "redirect:/carts";
    }

    @GetMapping("/up/{id}")
    public String up(@PathVariable Long id) {
        cartService.up(id);
        return "redirect:/carts";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        cartService.delete(id);
        return "redirect:/carts";
    }

    @GetMapping("/delete-all")
    public String deleteAll() {
        cartService.deleteAll();
        return "redirect:/carts";
    }

    @GetMapping("/payment")
    public String payment(@RequestParam Long id) {
        cartService.payment(id);
        return "redirect:/carts";
    }
}
