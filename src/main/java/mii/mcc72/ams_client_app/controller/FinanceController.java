package mii.mcc72.ams_client_app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;


@Controller
@PreAuthorize("hasRole('FINANCE')")
@RequestMapping("finance")
@AllArgsConstructor
// @PreAuthorize("hasRole('ROLE_FINANCE')")
public class FinanceController {


    @GetMapping("/review-submission-finance")
    public String reviewPendingSubAssets(Authentication authentication , Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("isActive", "revSubAsset");
        return "finance/review-submission";
    }

    @GetMapping("/balance")
    public String balanceFinance(Authentication authentication , Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("isActive", "balDept");
        return "finance/balance";
    }

    @GetMapping("/recent-review-sub")
    public String recentReviewSubAsset(Authentication authentication , Model model) {
        model.addAttribute("user",authentication.getName());
        model.addAttribute("isActive", "recRevSubAsset");
        return "finance/recent-review-subasset";
    }
}