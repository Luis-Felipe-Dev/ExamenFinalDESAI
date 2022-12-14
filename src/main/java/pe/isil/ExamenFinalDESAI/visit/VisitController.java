package pe.isil.ExamenFinalDESAI.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.isil.ExamenFinalDESAI.affiliate.AffiliateService;

@Controller
@RequestMapping("/visit")
public class VisitController {
    @Autowired
    private VisitService visitService;
    @Autowired
    private AffiliateService affiliateService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listvisits", visitService.findAll());
        return "visit/index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("listaffiliates", affiliateService.findAll());
        return "visit/register";
    }

    @PostMapping("/register")
    public String registerVisit(Visit visit, Model model) {
        VisitDTO result = visitService.addVisit(visit);

        if (result.getCode().equals("200")) {
            return "redirect:/visit/";
        } else {
            model.addAttribute("resp", result.getMessage());
            return "/visit/response";
        }
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        model.addAttribute("listaffiliates", affiliateService.findAll());
        model.addAttribute("visitToUpdate", visitService.findVisitById(id));
        return "visit/update";
    }

    @PostMapping("/update")
    public String updateVisit(Visit visit, Model model) {
        VisitDTO result = visitService.updateVisit(visit, visit.getId());

        if (result.getCode().equals("200")) {
            return "redirect:/visit/";
        } else {
            model.addAttribute("resp", "DNI del afiliado no existe.");
            return "/visit/response";
        }
    }

    @DeleteMapping("/delete")
    public String deleteVisit(@RequestParam("id") Long id) {
        visitService.deleteVisit(id);
        return "redirect:/visit/";
    }
}
