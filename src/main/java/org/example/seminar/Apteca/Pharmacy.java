package org.example.seminar.Apteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

//Лекарство
public class Pharmacy implements Iterable<PharmancyComponent>, Comparable<Pharmacy> {

    private List<PharmancyComponent> components = new ArrayList<>();
    private int index = 0;

    public Pharmacy addComponent(PharmancyComponent component){
        components.add(component);
        return this;
    }

    public List<PharmancyComponent> getComponents() {
        return components;
    }

    public void setComponents(List<PharmancyComponent> components) {
        this.components = components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pharmacy)) return false;
        return Objects.equals(getComponents(), ((Pharmacy)o).getComponents());
    }
// Это предложенный IDE вариант переопределения. Мне не понятно применение слова that.
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Pharmacy that)) return false;
//        return Objects.equals(getComponents(), that.getComponents());
//    }

    @Override
    public int hashCode() {
        return Objects.hash(getComponents());
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

//    @Override
//    public boolean hasNext() {
//        return index < components.size();
//    }
//
//    @Override
//    public PharmancyComponent next() {
//        return components.get(index++);
//    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "components=" + components +
                ", index=" + index +
                '}';
    }

    // вынесенный класс Iterable
//    @Override
//    public Iterator<PharmancyComponent> iterator() {
//        return new IteratorComponent(this);
//    }

    //анонимный класс Iterable
    @Override
    public Iterator<PharmancyComponent> iterator() {
        return new Iterator<PharmancyComponent>() {
            @Override
            public boolean hasNext() {
                return index < components.size();
            }

            @Override
            public PharmancyComponent next() {
                return components.get(index++);
            }
        };
    }


    @Override // Сравнение по коммулятивному power.
    public int compareTo(Pharmacy o) {
        int thisPower = 0;
        int thatPower = 0;

        for (int i=0; i<this.components.size(); i++) {
            thisPower += this.components.get(i).getPower();
        }
        for (int i=0; i<o.components.size(); i++) {
            thatPower += o.components.get(i).getPower();
        }

        return thisPower - thatPower;
    }
}
