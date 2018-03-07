package com.facebook.graphql.enums;

/* compiled from: linkData */
public enum GraphQLWeatherTemperature {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CELSIUS,
    FAHRENHEIT;

    public static GraphQLWeatherTemperature fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CELSIUS")) {
            return CELSIUS;
        }
        if (str.equalsIgnoreCase("FAHRENHEIT")) {
            return FAHRENHEIT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
