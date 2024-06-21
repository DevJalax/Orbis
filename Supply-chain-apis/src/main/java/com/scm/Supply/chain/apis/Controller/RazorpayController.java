package com.scm.Supply.chain.apis.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.DTO.OrderRequest;
import com.scm.Supply.chain.apis.DTO.PaymentRequest;
import com.scm.Supply.chain.apis.Service.RazorpayService;

@RestController
@RequestMapping("/payment/checkout")
public class RazorpayController {
    private final RazorpayService razorpayService;

    public RazorpayController(RazorpayService razorpayService) {
        this.razorpayService = razorpayService;
    }

    @PostMapping("/generate-order")
    public String generateOrder(@RequestBody OrderRequest orderRequest) {
        String amount = orderRequest.getAmount();
        String currency = orderRequest.getCurrency();
        String receipt = orderRequest.getReceipt();
        String order = razorpayService.generateOrder(amount, currency, receipt);
        return order;
    }

    @PostMapping("/verify-payment")
    public String verifyPayment(@RequestBody PaymentRequest paymentRequest) {
        String paymentId = paymentRequest.getPaymentId();
        String paymentStatus = paymentRequest.getPaymentStatus();
        paymentStatus = razorpayService.verifyPayment(paymentId, paymentStatus);
        return paymentStatus;
    }
}
