package pe.isil.ExamenFinalDESAI.affiliate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/affiliate")
public class AffiliateController {
    @Autowired
    private AffiliateService affiliateService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listaffiliates", affiliateService.findAll());
        return "affiliate/index";
    }

    @GetMapping("/register")
    public String register() {
        return "affiliate/register";
    }

    @PostMapping("/register")
    public String registerAffiliate(Affiliate affiliate, Model model) {
        AffiliateDTO result = affiliateService.addAffiliate(affiliate);

        if (result.getCode().equals("200")) {
            return "redirect:/affiliate/";
        } else {
            model.addAttribute("resp", result.getMessage());
            return "/affiliate/response";
        }
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        model.addAttribute("affiliateToUpdate", affiliateService.findAffiliateById(id));
        return "affiliate/update";
    }

    @PostMapping("/update")
    public String updateAffiliate(Affiliate affiliate, Model model) {
        AffiliateDTO result = affiliateService.updateAffiliate(affiliate, affiliate.getId());

        if (result.getCode().equals("200")) {
            return "redirect:/affiliate/";
        } else {
            model.addAttribute("resp", "DNI ya está en uso, por favor probar con otro.");
            return "/affiliate/response";
        }
    }

    @DeleteMapping("/delete")
    public String deleteAffiliate(@RequestParam("id") Long id) {
        affiliateService.deleteAffiliate(id);
        return "redirect:/affiliate/";
    }
}
