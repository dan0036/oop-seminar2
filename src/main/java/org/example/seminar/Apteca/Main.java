package org.example.seminar.Apteca;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        PharmancyComponent azitrometi = new Azitronit("Azitrometi", "10 Мг", 80);
        PharmancyComponent charcoal = new Azitronit("Charcoal", "10 Мг", 50);
        PharmancyComponent penecelini = new Pinicilin("Penecilini", "10 Мг", 120);
        PharmancyComponent water = new Water("Water", "10 Мг", 20);
        PharmancyComponent naCl = new Water("NaCl", "10 Мг", 22);

        List<PharmancyComponent> pharmancyComponents = new ArrayList<>();
        pharmancyComponents.add(azitrometi);
        pharmancyComponents.add(naCl);
        pharmancyComponents.add(water);
        pharmancyComponents.add(charcoal);

        Pharmacy pharmacy1 = new Pharmacy().addComponent(azitrometi).addComponent(water);
        Pharmacy pharmacy2 = new Pharmacy().addComponent(charcoal).addComponent(water);
        Pharmacy pharmacy3 = new Pharmacy().addComponent(charcoal).addComponent(water);
        Pharmacy pharmacy4 = new Pharmacy().addComponent(azitrometi).addComponent(naCl);

        List<Pharmacy> pharmacies = new ArrayList<>();
        pharmacies.add(pharmacy1);
        pharmacies.add(pharmacy2);
        pharmacies.add(pharmacy3);
        pharmacies.add(pharmacy4);

        Set<Pharmacy> result = new HashSet<>(pharmacies);
        result.add(pharmacy1);
        result.add(pharmacy2);
        result.add(pharmacy3);
        result.add(pharmacy4);
        System.out.println(result.size()); // тут вывод должен быть равен количеству УНИКАЛЬНЫХ экземпляров Pharmacy!

        //Collections.sort(pharmacies, new );


        //Iterator<PharmancyComponent> iterator = pharmacy1;

//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

//        while (((Iterator<PharmancyComponent>) pharmacy1).hasNext()) {
//            System.out.println(((Iterator<PharmancyComponent>) pharmacy1).next());
//        }

    }
}
