package com.facebook.graphql.enums;

/* compiled from: logo */
public enum GraphQLProfileWizardStepType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    COMPOSER,
    CORE_PROFILE_FIELD,
    COVER_PHOTO,
    PROFILE_PICTURE,
    INTRO_CARD_BIO,
    INTRO_CARD_FEATURED_PHOTOS;

    public static GraphQLProfileWizardStepType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("COMPOSER")) {
            return COMPOSER;
        }
        if (str.equalsIgnoreCase("CORE_PROFILE_FIELD")) {
            return CORE_PROFILE_FIELD;
        }
        if (str.equalsIgnoreCase("COVER_PHOTO")) {
            return COVER_PHOTO;
        }
        if (str.equalsIgnoreCase("PROFILE_PICTURE")) {
            return PROFILE_PICTURE;
        }
        if (str.equalsIgnoreCase("INTRO_CARD_BIO")) {
            return INTRO_CARD_BIO;
        }
        if (str.equalsIgnoreCase("INTRO_CARD_FEATURED_PHOTOS")) {
            return INTRO_CARD_FEATURED_PHOTOS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
