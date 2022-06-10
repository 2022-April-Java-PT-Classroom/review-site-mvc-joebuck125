package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EnergyDrinkController.class)
public class EnergyDrinkControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnergyDrinkRepository energyDrinkRepo;

    @Mock
    private EnergyDrink bang;

    @Mock
    private EnergyDrink redbull;

    @Test
    public void shouldBeOkForAllEnergyDrinksInEnergyDrinksTemplate() throws Exception{
        mockMvc.perform(get("/energyDrinks")).andExpect(status().isOk())
                .andExpect(view().name("energyDrinksTemplate"));
    }

    @Test
    public void shouldFindAllEnergyDrinksInModel() throws Exception{
        Collection<EnergyDrink> allEnergyDrinksInModel = Arrays.asList(bang, redbull);
        when(energyDrinkRepo.findAll()).thenReturn(allEnergyDrinksInModel);
        mockMvc.perform(get("/energyDrinks")).andExpect(model().attribute("energyDrinksModel", allEnergyDrinksInModel));
    }

    @Test
    public void shouldBeOkForOneEnergyDrinkInEnergyDrinkTemplate() throws Exception {
        Long bangId = 1L;
        when(energyDrinkRepo.findDrink(bangId)).thenReturn(bang);
        mockMvc.perform(get("/energyDrink?id=1")).andExpect(status().isOk())
                .andExpect(view().name("energyDrinkTemplate"));
    }

    @Test
    public void shouldFindBangInModel() throws Exception{
        Long bangId = 1L;
        when(energyDrinkRepo.findDrink(bangId)).thenReturn(bang);
        mockMvc.perform(get("/energyDrink?id=1")).andExpect(model().attribute("energyDrinkModel", bang));
    }

    @Test
    public void shouldBeNotFoundForRequestNotInModel() throws Exception{
        Long redbullId = 2L;
        when(energyDrinkRepo.findDrink(redbullId)).thenReturn(redbull);
        mockMvc.perform(get("/energyDrink?id=3")).andExpect(status().isNotFound());
    }
}
