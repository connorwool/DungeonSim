package org.connorwool.dungeonsim.frontend;

import java.util.logging.Logger;
import org.connorwool.dungeonsim.backend.Settlement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettlementPageController {

    Logger logger = Logger.getLogger(SettlementPageController.class.getName());

    @GetMapping("/settlement")
    public String settlementForm(Model model) {
        model.addAttribute("settlement", new Settlement());
        return "settlement";
    }

    @PostMapping("/settlement")
    public String settlementSubmit(@ModelAttribute Settlement settlement, Model model) {
        model.addAttribute("settlement", settlement);
        return "result";
    }
}
