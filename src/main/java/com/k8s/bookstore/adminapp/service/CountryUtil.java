package com.k8s.bookstore.adminapp.service;

import java.util.Map;

public class CountryUtil {
    private static final Map<String, String> countryByCodes = Map.of(
        "ua", "Ukraine",
        "ru", "Russia",
        "by", "Belarus"
    );

    public static String getCountryByCode(String code) {
        return countryByCodes.get(code);
    }
}
