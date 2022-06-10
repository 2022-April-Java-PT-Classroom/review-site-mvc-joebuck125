package org.wecancoeit.reviews;


import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EnergyDrinkRepository {

    Map<Long, EnergyDrink> energyDrinkList = new HashMap<>();

    public EnergyDrinkRepository(){
        EnergyDrink bang = new EnergyDrink(1L, "Bang", "Black Cherry Vanilla", "smooth and powerful", "https://i5.walmartimages.com/asr/05d16891-35ba-4d03-b2ad-36ebc1ae4021.a0ee05ca5f0482c1f3bf7ec981f154fb.jpeg");
        EnergyDrink redbull = new EnergyDrink(2L, "Redbull", "Peach Nectarine", "subtle yet fruity and sweet", "https://i5.walmartimages.com/asr/86ecb058-f552-4fed-b14c-df756e2ae0b4.8340b56b636ab0a18230a8c41a86fa4a.jpeg?odnWidth=1000&odnHeight=1000&odnBg=ffffff");

        energyDrinkList.put(bang.getId(), bang);
        energyDrinkList.put(redbull.getId(), redbull);
    }

    public EnergyDrinkRepository(EnergyDrink ...drinksToAdd) {
        for(EnergyDrink energyDrink: drinksToAdd){
            energyDrinkList.put(energyDrink.getId(), energyDrink);
        }
    }

    public EnergyDrink findDrink(long id) {
        return energyDrinkList.get(id);
    }

    public Collection<EnergyDrink> findAll() {
        return energyDrinkList.values();
    }
}
