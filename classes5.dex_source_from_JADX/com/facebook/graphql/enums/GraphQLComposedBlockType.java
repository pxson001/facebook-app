package com.facebook.graphql.enums;

/* compiled from: mediaCaptions */
public enum GraphQLComposedBlockType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    UNSTYLED,
    PARAGRAPH,
    UNORDERED_LIST_ITEM,
    ORDERED_LIST_ITEM,
    BLOCKQUOTE,
    HEADER_ONE,
    HEADER_TWO,
    CODE,
    MEDIA,
    PULLQUOTE,
    HEADER_THREE,
    HEADER_FOUR,
    HEADER_FIVE,
    HEADER_SIX;

    public static GraphQLComposedBlockType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("UNSTYLED")) {
            return UNSTYLED;
        }
        if (str.equalsIgnoreCase("PARAGRAPH")) {
            return PARAGRAPH;
        }
        if (str.equalsIgnoreCase("UNORDERED_LIST_ITEM")) {
            return UNORDERED_LIST_ITEM;
        }
        if (str.equalsIgnoreCase("ORDERED_LIST_ITEM")) {
            return ORDERED_LIST_ITEM;
        }
        if (str.equalsIgnoreCase("BLOCKQUOTE")) {
            return BLOCKQUOTE;
        }
        if (str.equalsIgnoreCase("HEADER_ONE")) {
            return HEADER_ONE;
        }
        if (str.equalsIgnoreCase("HEADER_TWO")) {
            return HEADER_TWO;
        }
        if (str.equalsIgnoreCase("CODE")) {
            return CODE;
        }
        if (str.equalsIgnoreCase("MEDIA")) {
            return MEDIA;
        }
        if (str.equalsIgnoreCase("PULLQUOTE")) {
            return PULLQUOTE;
        }
        if (str.equalsIgnoreCase("HEADER_THREE")) {
            return HEADER_THREE;
        }
        if (str.equalsIgnoreCase("HEADER_FOUR")) {
            return HEADER_FOUR;
        }
        if (str.equalsIgnoreCase("HEADER_FIVE")) {
            return HEADER_FIVE;
        }
        if (str.equalsIgnoreCase("HEADER_SIX")) {
            return HEADER_SIX;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
