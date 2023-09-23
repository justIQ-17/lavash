package iq.lavash.controller;

import iq.lavash.entity.LavashOrder;
import iq.lavash.repository.LavashOrderRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("lavashOrder")
@RequiredArgsConstructor
public class OrderController {
    private final LavashOrderRepository lavashOrderRepository;

    @GetMapping
    public String thanks(){
        return "thanks";
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid LavashOrder order,
                               Errors errors,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        lavashOrderRepository.save(order);
        sessionStatus.setComplete();

        return "redirect:/orders";
    }

}
