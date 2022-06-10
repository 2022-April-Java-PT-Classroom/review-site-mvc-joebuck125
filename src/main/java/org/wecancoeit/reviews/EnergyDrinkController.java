package org.wecancoeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class EnergyDrinkController {

    @Resource
    private EnergyDrinkRepository energyDrinkRepo;

    @RequestMapping("/energyDrinks")
    public String findAllEnergyDrinks(Model model){
        model.addAttribute("energyDrinksModel", energyDrinkRepo.findAll());
        return "energyDrinksTemplate";
    }

    @RequestMapping("/energyDrink")
    public String findOneEnergyDrink(@RequestParam(value="id") Long id, Model model) throws EnergyDrinkNotFoundException {

        if(energyDrinkRepo.findDrink(id) == null){
            throw new EnergyDrinkNotFoundException();
        }

        model.addAttribute("energyDrinkModel", energyDrinkRepo.findDrink(id));
        return "energyDrinkTemplate";
    }
}
