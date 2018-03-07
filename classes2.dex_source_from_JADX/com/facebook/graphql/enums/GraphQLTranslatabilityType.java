package com.facebook.graphql.enums;

/* compiled from: hprof_dump_metadata */
public enum GraphQLTranslatabilityType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NO_TRANSLATION,
    SEE_TRANSLATION,
    AUTO_TRANSLATION,
    TRANSLATE_LINK,
    SEE_CONVERSION,
    HIDE_SEE_TRANSLATION_LINK,
    HIDE_AUTO_TRANSLATION,
    HIDE_SEE_CONVERSION_LINK;

    public static GraphQLTranslatabilityType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NO_TRANSLATION")) {
            return NO_TRANSLATION;
        }
        if (str.equalsIgnoreCase("SEE_TRANSLATION")) {
            return SEE_TRANSLATION;
        }
        if (str.equalsIgnoreCase("AUTO_TRANSLATION")) {
            return AUTO_TRANSLATION;
        }
        if (str.equalsIgnoreCase("TRANSLATE_LINK")) {
            return TRANSLATE_LINK;
        }
        if (str.equalsIgnoreCase("SEE_CONVERSION")) {
            return SEE_CONVERSION;
        }
        if (str.equalsIgnoreCase("HIDE_SEE_TRANSLATION_LINK")) {
            return HIDE_SEE_TRANSLATION_LINK;
        }
        if (str.equalsIgnoreCase("HIDE_AUTO_TRANSLATION")) {
            return HIDE_AUTO_TRANSLATION;
        }
        if (str.equalsIgnoreCase("HIDE_SEE_CONVERSION_LINK")) {
            return HIDE_SEE_CONVERSION_LINK;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
