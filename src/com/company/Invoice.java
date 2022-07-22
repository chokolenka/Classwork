package com.company;

import javax.management.StringValueExp;
import java.util.*;
import java.util.stream.Collectors;

public class Invoice {
    String supplier;
    String receiving;
    double order;
    int delivery;
    int invoice;
    String product;
    int QtyOrdered;
    int QtyReceived;
    String date;
    double cost;
    double value;
    double balance;

    public String getSupplier() {
        return supplier;
    }

    public String getReceiver() {
        return receiving;
    }

    public double getOrder() {
        return order;
    }

    public int getDelivery() {
        return delivery;
    }

    public int getInvoice() {
        return invoice;
    }

    public String getProduct() {
        return product;
    }

    public int QtyOrdered() {
        return QtyOrdered;
    }

    public int QtyReceived() { return QtyReceived; }

    public String getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public double getValue() {
        return value;
    }

    public double getBalance() {
        return balance;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setReceiver(String receiver) {
        this.receiving = receiver;
    }

    public void setOrder(double order) {
        this.order = order;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQtyOrdered(int QtyOrdered) {
        this.QtyOrdered = QtyOrdered;
    }

    public void setQtyReceived(int QtyReceived) {
        this.QtyReceived = QtyReceived;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Invoice (String supplier, String receiving, double order, int delivery,
                    int invoice, String product, int QtyOrdered, int QtyReceived, String date,
                    double cost, double value, double balance) {
        this.supplier = supplier;
        this.receiving = receiving;
        this.order = order;
        this.delivery = delivery;
        this.invoice = invoice;
        this.product = product;
        this.QtyOrdered = QtyOrdered;
        this.QtyReceived = QtyReceived;
        this.date = date;
        this.cost = cost;
        this.value = value;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "supplier='" + supplier + '\'' +
                ", receiving='" + receiving + '\'' +
                ", order=" + order +
                ", delivery=" + delivery +
                ", invoice=" + invoice +
                ", product='" + product + '\'' +
                ", QtyOrdered=" + QtyOrdered +
                ", QtyReceived=" + QtyReceived +
                ", date=" + date +
                ", cost=" + cost +
                ", value=" + value +
                ", balance=" + balance +
                '}';
    }

    public static class WarehouseAccountingProgram {
        private static Arrays collection;

        public static void main(String[] args) {
            ArrayList<Invoice> invoiceList = new ArrayList<>();
            Invoice invoice1 = new Invoice("Savushkin", "Mayyak", 3,
                    14, 1234, "Cheese", 12, 12, "2022-12-24", 140,
                    1680, 1100);
            Invoice invoice2 = new Invoice("Coca-Cola Company", "Mayyak", 5,
                    12, 1356, "Soft drinks", 15, 15, "2022-12-18", 2.5,
                    37.5, 100);

            invoiceList.add(invoice1);
            invoiceList.add(invoice2);

            inputSuppliers(invoiceList);
            getWarehouseProducts(invoiceList);
        }

        public static void inputSuppliers(ArrayList<Invoice> invoiceList) {
            ArrayList<String> suppliers = new ArrayList<>();
            suppliers.add("Savushkin");
            suppliers.add("Coca-Cola Company");

            ArrayList<String> QtyReceived1 = new ArrayList<>();
            QtyReceived1.add(String.valueOf(12));
            QtyReceived1.add(String.valueOf(15));

            ArrayList<String> allGoods = new ArrayList<>();
            allGoods.add("Cheese");
            allGoods.add("Soft drinks");

            // программа ввода счет-фактуры
            Scanner in = new Scanner(System.in);
            System.out.println("Fill in the accounting. \n Supplier:");
            String supplier = in.nextLine();
            suppliers.add(supplier);
            System.out.println("Receiving:");
            String receiving = in.nextLine();
            System.out.println("Input order: ");
            double order = in.nextDouble();
            in.nextLine();
            System.out.println("Input delivery number: ");
            int delivery = in.nextInt();
            in.nextLine();
            System.out.println("Input invoice number: ");
            int invoice = in.nextInt();
            in.nextLine();
            System.out.println("Product:");
            String product = in.nextLine();
            allGoods.add(product);
            System.out.println("Input QtyOrdered: ");
            int QtyOrdered = in.nextInt();
            in.nextLine();
            int QtyReceived = in.nextInt();
            in.nextLine();
            System.out.println("Input QtyReceived: ");
            QtyReceived1.add(String.valueOf(QtyReceived));
            System.out.println("Date (yyyy-MM-dd): ");
            String date = in.nextLine();
            System.out.println("Input cost: ");
            double cost = in.nextDouble();
            in.nextLine();
            System.out.println("Input value: ");
            double value = in.nextDouble();
            in.nextLine();
            System.out.println("Input balance: ");
            double balance = in.nextDouble();
            in.nextLine();

            System.out.println("Invoice3 {" +
                    "supplier='" + supplier + '\'' +
                    ", receiving='" + receiving + '\'' +
                    ", order='" + order + '\'' +
                    ", delivery='" + delivery + '\'' +
                    ", invoice='" + invoice + '\'' +
                    ", product='" + product + '\'' +
                    ", QtyOrdered='" + QtyOrdered + '\'' +
                    ", QtyReceived='" + QtyReceived + '\'' +
                    ", date='" + date + '\'' +
                    ", cost='" + cost + '\'' +
                    ", value='" + value + '\'' +
                    ", balance='" + balance + '\'' +
                    '}' + "\n");

            Invoice invoice3 = new Invoice(supplier, receiving, order, delivery, invoice,
                    product, QtyOrdered, QtyReceived, date, cost, value, balance);
            invoiceList.add(invoice3);

            // вывод всех счет-фактур
            System.out.println("List of invoices: ");
            invoiceList.forEach(System.out::println);

            // отображение всех товаров на складе
            System.out.println("List all products in the shop: " + allGoods);

            System.out.println("List all qtyReceived in the shop: " + QtyReceived1);

            //отоображение всех поставщиков
            System.out.println("List of all suppliers: " + suppliers);
        }
        // ищем товар на складе по названию товара
        public static void getWarehouseProducts(ArrayList<Invoice> invoiceList) {
            Scanner in = new Scanner(System.in);
            System.out.println("Choose the name of the product:");
            String product = in.nextLine();

            ArrayList<Invoice> WarehouseProducts = ((ArrayList <Invoice>) invoiceList
                    .stream().filter(s -> (s.getProduct().equalsIgnoreCase(product)) &&
                            (s.getSupplier().equalsIgnoreCase("Savushkin") ||
                                    s.getSupplier().equalsIgnoreCase("Coca-Cola Company"))).
                    collect(Collectors.toList()));

            System.out.println("Products in the warehouse: \n" + WarehouseProducts);
        }
    }
}
