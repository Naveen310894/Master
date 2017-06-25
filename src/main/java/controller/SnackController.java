/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.SnackService;

/**
 *
 * @author 7ravis
 */
@Controller
public class SnackController {
    private SnackService snackService;
    
    @Inject
    public SnackController(SnackService snackService) {
        this.snackService = snackService;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("balance", snackService.getBalance());
        model.addAttribute("selection", snackService.getSelection());
        model.addAttribute("myChange", snackService.getMyChange());
        model.addAttribute("snacks", snackService.getSnacks());
        model.addAttribute("message", snackService.getMessage());
        return "index";
    }
    
    @RequestMapping(value="/addMoney/{amount}", method=RequestMethod.GET)
    public String addMoney(@PathVariable String amount) {
        snackService.addMoney(amount);
        return "redirect:/";
    }
    
    @RequestMapping(value="/makePurchase", method=RequestMethod.GET)
    public String makePurchase() {
        snackService.makePurchase();
        return "redirect:/";
    }
    
    @RequestMapping(value="/changeReturn", method=RequestMethod.GET)
    public String changeReturn() {
        snackService.changeReturn();
        return "redirect:/";
    }
    
    @RequestMapping(value="/makeSelection/{id}", method=RequestMethod.GET)
    public String makeSelection(@PathVariable("id") int id) {
        snackService.setSelection(id);
        return "redirect:/";
    }
}
