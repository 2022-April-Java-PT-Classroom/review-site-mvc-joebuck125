package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;

import java.util.Collection;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewRepositoryTests {

        private EnergyDrinkRepository underTest;
        private EnergyDrink bang = new EnergyDrink(1L, "Bang", "Black Cherry Vanilla", "smooth and powerful","https://i5.walmartimages.com/asr/05d16891-35ba-4d03-b2ad-36ebc1ae4021.a0ee05ca5f0482c1f3bf7ec981f154fb.jpeg");
        private EnergyDrink redbull = new EnergyDrink(2L, "Redbull", "Peach Nectarine", "subtle yet fruity and sweet","https://i5.walmartimages.com/asr/86ecb058-f552-4fed-b14c-df756e2ae0b4.8340b56b636ab0a18230a8c41a86fa4a.jpeg?odnWidth=1000&odnHeight=1000&odnBg=ffffff");

    @Test
    public void shouldFindBang(){
        underTest = new EnergyDrinkRepository(bang);
        EnergyDrink foundEnergyDrink = underTest.findDrink(1L);
        assertEquals(bang, foundEnergyDrink);
    }

    @Test
    public void shouldFindBangAndRedbull(){
        underTest = new EnergyDrinkRepository(bang, redbull);
        Collection<EnergyDrink> foundEnergyDrinks = underTest.findAll();
        assertThat(foundEnergyDrinks).contains(bang, redbull);
    }
}
