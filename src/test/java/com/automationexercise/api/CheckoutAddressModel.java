package com.automationexercise.api;

public record CheckoutAddressModel(
        String fullName,
        String company,
        String address1,
        String address2,
        String cityStateZip,
        String country,
        String phone
) {}