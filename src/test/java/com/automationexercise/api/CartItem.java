package com.automationexercise.api;

public record CartItem(String name, int price, int quantity, int total) {

    public CartItem(String name, String price, String quantity, String total) {
        this(name, parsePrice(price), parsePrice(quantity), parsePrice(total));
    }

    private static int parsePrice(String rawPrice) {
        var digitsOnly = rawPrice.replaceAll("[^0-9]", "");

        return digitsOnly.isEmpty() ? 0 : Integer.parseInt(digitsOnly);
    }
}
