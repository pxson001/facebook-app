package com.facebook.graphql.enums;

/* compiled from: mediaContentType */
public enum GraphQLCommerceUIProductDetailSectionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ABOUT_THE_MERCHANT,
    CHECKOUT,
    DETAILS,
    INSIGHTS_AND_PROMOTION,
    MERCHANT_PAGE_INFO,
    MERCHANT_TERMS,
    MORE_FROM_SHOP,
    PHOTOS,
    POLICIES,
    PRODUCT_AND_PURCHASE_DETAILS,
    PRODUCT_NAME_AND_PRICE,
    RECOMMENDED_PRODUCTS_CAROUSEL_VIEW,
    RECOMMENDED_PRODUCTS_GRID_VIEW,
    RECOMMENDED_PRODUCTS_STACK_VIEW,
    USER_INTERACTIONS,
    SALES_POLICY,
    SHIPPING_AND_RETURNS,
    VARIANTS_PICKER;

    public static GraphQLCommerceUIProductDetailSectionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ABOUT_THE_MERCHANT")) {
            return ABOUT_THE_MERCHANT;
        }
        if (str.equalsIgnoreCase("CHECKOUT")) {
            return CHECKOUT;
        }
        if (str.equalsIgnoreCase("DETAILS")) {
            return DETAILS;
        }
        if (str.equalsIgnoreCase("INSIGHTS_AND_PROMOTION")) {
            return INSIGHTS_AND_PROMOTION;
        }
        if (str.equalsIgnoreCase("MERCHANT_PAGE_INFO")) {
            return MERCHANT_PAGE_INFO;
        }
        if (str.equalsIgnoreCase("MERCHANT_TERMS")) {
            return MERCHANT_TERMS;
        }
        if (str.equalsIgnoreCase("MORE_FROM_SHOP")) {
            return MORE_FROM_SHOP;
        }
        if (str.equalsIgnoreCase("PHOTOS")) {
            return PHOTOS;
        }
        if (str.equalsIgnoreCase("POLICIES")) {
            return POLICIES;
        }
        if (str.equalsIgnoreCase("PRODUCT_AND_PURCHASE_DETAILS")) {
            return PRODUCT_AND_PURCHASE_DETAILS;
        }
        if (str.equalsIgnoreCase("PRODUCT_NAME_AND_PRICE")) {
            return PRODUCT_NAME_AND_PRICE;
        }
        if (str.equalsIgnoreCase("RECOMMENDED_PRODUCTS_CAROUSEL_VIEW")) {
            return RECOMMENDED_PRODUCTS_CAROUSEL_VIEW;
        }
        if (str.equalsIgnoreCase("RECOMMENDED_PRODUCTS_GRID_VIEW")) {
            return RECOMMENDED_PRODUCTS_GRID_VIEW;
        }
        if (str.equalsIgnoreCase("RECOMMENDED_PRODUCTS_STACK_VIEW")) {
            return RECOMMENDED_PRODUCTS_STACK_VIEW;
        }
        if (str.equalsIgnoreCase("USER_INTERACTIONS")) {
            return USER_INTERACTIONS;
        }
        if (str.equalsIgnoreCase("SALES_POLICY")) {
            return SALES_POLICY;
        }
        if (str.equalsIgnoreCase("SHIPPING_AND_RETURNS")) {
            return SHIPPING_AND_RETURNS;
        }
        if (str.equalsIgnoreCase("VARIANTS_PICKER")) {
            return VARIANTS_PICKER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
