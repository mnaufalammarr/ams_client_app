package mii.mcc72.ams_client_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;


@Controller
@RequestMapping("finance")
@AllArgsConstructor
// @PreAuthorize("hasRole('ROLE_FINANCE')")
public class FinanceController {


    @GetMapping("/review-submission-finance")
    public String reviewPendingSubAssets() {
        return "finance/review-submission";
    }

    @GetMapping("/balance")
    public String balanceFinance() {
        return "finance/balance";
    }
}