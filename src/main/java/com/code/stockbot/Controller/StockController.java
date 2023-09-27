package com.code.stockbot.Controller;

import com.code.stockbot.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/consultarPrecio")
    public String consultarPrecio(@RequestParam String stockCode, Model model) {
        String precio = stockService.consultarPrecio(stockCode);
        model.addAttribute("stockCode", stockCode);
        model.addAttribute("precio", precio);
        return "result";
    }

    @GetMapping("/historial")
    public String mostrarHistorial(Model model) {
        List<String[]> historial = stockService.obtenerHistorial();
        model.addAttribute("historial", historial);
        return "historial";
    }
}

