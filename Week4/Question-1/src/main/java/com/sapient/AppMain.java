package com.sapient;

import com.sapient.exceptions.CategoryNotAvailable;
import com.sapient.models.Category;
import com.sapient.models.Item;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class AppMain {
    public static void main(String[] args) {
        List<Item> list = List.of(new Item("1111","samsung",true, Category.MOBILE),
                new Item("1112","samsung",true, Category.TV),
                new Item("1113","LG",false, Category.LAPTOP),
                new Item("1114","samsung",true, Category.REFRIGERATOR),
                new Item("1115","Nokia",false, Category.REFRIGERATOR),
                new Item("1116","samsung",true, Category.MOBILE),
                new Item("1117","One plus",false, Category.TV),
                new Item("1118","samsung",true, Category.LAPTOP));



        System.out.println("1) Mobile 2) TV 3) Laptop 4) Refrigerator \nInput your category: ");
        Scanner in = new Scanner(System.in);
        String categoryIn = in.nextLine();

        try {
            boolean flag = false;
            for(Category c : Category.values()){
                if(c.toString().equalsIgnoreCase(categoryIn)){
                    flag = true;
                    break;
                }
            }
            if(!flag) throw new CategoryNotAvailable("Category Not found");

        } catch (CategoryNotAvailable e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        Predicate<Item> warranty = item -> item.getWarranty().equals(true);
        Predicate<Item> noWarranty = item -> item.getWarranty().equals(false);

        List<List<Item>> filtered = List.of(list.stream().filter(item -> warranty.test(item) && item.getCategory().toString().equalsIgnoreCase(categoryIn)).collect(Collectors.toList()),
                list.stream().filter(item ->noWarranty.test(item) && item.getCategory().toString().equalsIgnoreCase(categoryIn)).collect(Collectors.toList()) );
        if(filtered.get(0).isEmpty() && filtered.get(1).isEmpty()){
            System.out.println("No products found with category: " + categoryIn);
        }
        else {
            if(filtered.get(0).isEmpty()){
                System.out.println("No products found with warranty!!!");
                System.out.println(categoryIn+ " products without warranty : " + filtered.get(1));
            } else if (filtered.get(1).isEmpty()) {
                System.out.println(categoryIn+ " products with warranty : " + filtered.get(0));
                System.out.println("No products found without warranty!!!");
            }
            else {
                System.out.println(categoryIn+ " products with warranty : " + filtered.get(0));
                System.out.println(categoryIn+ " products without warranty : " + filtered.get(1));
            }
        }
    }
}
