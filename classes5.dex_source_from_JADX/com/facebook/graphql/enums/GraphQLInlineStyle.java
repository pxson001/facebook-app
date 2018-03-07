package com.facebook.graphql.enums;

/* compiled from: mType */
public enum GraphQLInlineStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    BOLD,
    ITALIC,
    UNDERLINE,
    CODE,
    STRIKETHROUGH,
    SUBSCRIPT,
    SUPERSCRIPT;

    public static GraphQLInlineStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("BOLD")) {
            return BOLD;
        }
        if (str.equalsIgnoreCase("ITALIC")) {
            return ITALIC;
        }
        if (str.equalsIgnoreCase("UNDERLINE")) {
            return UNDERLINE;
        }
        if (str.equalsIgnoreCase("CODE")) {
            return CODE;
        }
        if (str.equalsIgnoreCase("STRIKETHROUGH")) {
            return STRIKETHROUGH;
        }
        if (str.equalsIgnoreCase("SUBSCRIPT")) {
            return SUBSCRIPT;
        }
        if (str.equalsIgnoreCase("SUPERSCRIPT")) {
            return SUPERSCRIPT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
