package com.facebook.graphql.enums;

/* compiled from: m_pending_requests_promo */
public enum GraphQLGoodwillVideoCampaignTypeEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ANNIVERSARY,
    FRIENDS_DAY_2016,
    FRIENDVERSARY,
    ANNIVERSARY_VIDEO,
    BIRTHDAY;

    public static GraphQLGoodwillVideoCampaignTypeEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ANNIVERSARY")) {
            return ANNIVERSARY;
        }
        if (str.equalsIgnoreCase("ANNIVERSARY_VIDEO")) {
            return ANNIVERSARY_VIDEO;
        }
        if (str.equalsIgnoreCase("FRIENDS_DAY_2016")) {
            return FRIENDS_DAY_2016;
        }
        if (str.equalsIgnoreCase("FRIENDVERSARY")) {
            return FRIENDVERSARY;
        }
        if (str.equalsIgnoreCase("BIRTHDAY")) {
            return BIRTHDAY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
