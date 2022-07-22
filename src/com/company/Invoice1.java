package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Invoice1 {
    String supplier;
    String product;

    public String getSupplier() {
        return supplier;
    }

    public String getProduct() {
        return product;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setProduct(String product) {
        this.product = product;
    }


    public Invoice1(String supplier, String product) {
        this.supplier = supplier;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "supplier='" + supplier + '\'' +
                ", product='" + product + '\'' +
                '}';
    }

    public static class WarehouseAccountingProgram {
        private static Arrays collection;

        public static void main(String[] args) {
            ArrayList<Invoice1> invoiceList1 = new ArrayList<>();
            Invoice1 invoice1 = new Invoice1("Savushkin", "Cheese");
            Invoice1 invoice2 = new Invoice1("Coca-Cola Company", "Soft drinks");

            invoiceList1.add(invoice1);
            invoiceList1.add(invoice2);

            inputSuppliers(invoiceList1);
            getWarehouseProducts(invoiceList1);
        }

        public static void inputSuppliers(ArrayList<Invoice1> invoiceList1) {
            ArrayList<String> suppliers = new ArrayList<>();
            suppliers.add("Savushkin");
            suppliers.add("Coca-Cola Company");

            ArrayList<String> allGoods = new ArrayList<>();
            allGoods.add("Cheese");
            allGoods.add("Soft drinks");

            // программа ввода счет-фактуры
            Scanner in = new Scanner(System.in);
            System.out.println("Fill in the accounting. \n Supplier:");
            String supplier = in.nextLine();
            suppliers.add(supplier);
            System.out.println("Product:");
            String product = in.nextLine();
            allGoods.add(product);


            System.out.println("Invoice3 {" +
                    "supplier='" + supplier + '\'' +
                    ", product='" + product + '\'' +
                    '}' + "\n");

            Invoice1 invoice3 = new Invoice1(supplier, product);
            invoiceList1.add(invoice3);

            // вывод всех счет-фактур
            System.out.println("List of invoices: ");
            invoiceList1.forEach(System.out::println);

            // отображение всех товаров на складе
            System.out.println("List all products in the shop: " + allGoods);

            //отоображение всех поставщиков
            System.out.println("List of all suppliers: " + suppliers);
        }

        // ищем товар на складе по названию товара
        public static void getWarehouseProducts(ArrayList<Invoice1> invoiceList1) {
            Scanner in = new Scanner(System.in);
            System.out.println("Choose the name of the product:");
            String product = in.nextLine();

            ArrayList<Invoice1> WarehouseProducts = ((ArrayList<Invoice1>) invoiceList1
                    .stream().filter(s -> (s.getProduct().equalsIgnoreCase(product)) &&
                            (s.getSupplier().equalsIgnoreCase("Savushkin") ||
                                    s.getSupplier().equalsIgnoreCase("Coca-Cola Company"))).
                    collect(Collectors.toList()));

            System.out.println("Products in the warehouse: \n" + WarehouseProducts);
        }
    }
}
