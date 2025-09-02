package com.example.demo.controller;

import com.example.demo.model.Subscriber;
import com.example.demo.service.SubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/")
    public String index(Model model) {
        // objeto para binding del formulario
        model.addAttribute("subscriber", new Subscriber());

        // snacks (checkboxes) pasados desde el controlador
        List<String> snacks = Arrays.asList("Pocky", "Senbei", "Mochi", "KitKat Japan", "Dorayaki");
        model.addAttribute("snacks", snacks);

        // opciones de "inquiry" para radio buttons (se muestran con un loop)
        List<String> inquiries = Arrays.asList("サポート", "コラボレーション", "フィードバック", "緊急対応");
        model.addAttribute("inquiries", inquiries);

        // menu del header (LinkedHashMap para mantener orden)
        Map<String, String> menuLinks = new LinkedHashMap<>();
        menuLinks.put("Top", "/");
        menuLinks.put("About", "/about"); 
        menuLinks.put("Contact", "/contact");
        model.addAttribute("menuLinks", menuLinks);

        // mensaje opcional
        model.addAttribute("message", "");

        return "index"; // src/main/resources/templates/index.html
    }

    @PostMapping("/subscribe")
    public String subscribe(Subscriber subscriber, Model model) {
        subscriptionService.save(subscriber);
        model.addAttribute("message", "登録ありがとうございます, " + subscriber.getName() + "!");
        // volver a preparar listas porque devolvemos la misma vista
        model.addAttribute("subscriber", new Subscriber());
        model.addAttribute("snacks", Arrays.asList("Pocky","Senbei","Mochi","KitKat Japan","Dorayaki"));
        model.addAttribute("inquiries", Arrays.asList("サポート", "コラボレーション", "フィードバック", "緊急対応"));
        Map<String,String> menuLinks = new LinkedHashMap<>();
        menuLinks.put("Top","/");
        menuLinks.put("About","/about");
        menuLinks.put("Contact","/contact");
        model.addAttribute("menuLinks", menuLinks);

        return "index";
    }

    // Opcional: evitar 404 si el profesor visita /about o /contact
    @GetMapping({"/about", "/contact"})
    public String placeholder() {
        return "index";
    }
}
