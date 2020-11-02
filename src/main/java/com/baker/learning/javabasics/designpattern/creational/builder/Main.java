package com.baker.learning.javabasics.designpattern.creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 * 将复杂多变的对象按照复杂的步骤组装
 * 重点：对象--构成复杂多变
 * 步骤--复杂但是固定
 */
public class Main {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        final Meal prepareNonVegMeal = mealBuilder.prepareNonVegMeal();
        prepareNonVegMeal.showItems();
        System.out.println(prepareNonVegMeal.getCost());


        final Meal prepareVegMeal = mealBuilder.prepareVegMeal();
        prepareVegMeal.showItems();
        System.out.println(prepareVegMeal.getCost());
    }

    public static class MealBuilder {

        public Meal prepareVegMeal() {
            Meal meal = new Meal();
            meal.addItem(new VegBurgerItemImpl());
            meal.addItem(new CokeColdDrinkItemImpl());
            return meal;
        }

        public Meal prepareNonVegMeal() {
            Meal meal = new Meal();
            meal.addItem(new ChickenBurgerItemImpl());
            meal.addItem(new PepsiColdDrinkItemImpl());
            return meal;
        }
    }

    public static class Meal {
        private List<Item> items = new ArrayList<Item>();

        public void addItem(Item item) {
            items.add(item);
        }

        public float getCost() {
            float cost = 0.0f;
            for (Item item : items) {
                cost += item.price();
            }
            return cost;
        }

        public void showItems() {
            for (Item item : items) {
                System.out.print("Item : " + item.name());
                System.out.print(", Packing : " + item.packing().pack());
                System.out.println(", Price : " + item.price());
            }
        }
    }
}
