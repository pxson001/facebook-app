package com.facebook.graphql.enums;

/* compiled from: mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline. */
public enum GraphQLPhotosByCategoryEntryPoint {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    POPULAR_PHOTOS_OF_PLACE,
    FOOD_PHOTOS_OF_PLACE,
    PHOTOS_OF_NEXT_PLACE;

    public static GraphQLPhotosByCategoryEntryPoint fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("POPULAR_PHOTOS_OF_PLACE")) {
            return POPULAR_PHOTOS_OF_PLACE;
        }
        if (str.equalsIgnoreCase("FOOD_PHOTOS_OF_PLACE")) {
            return FOOD_PHOTOS_OF_PLACE;
        }
        if (str.equalsIgnoreCase("PHOTOS_OF_NEXT_PLACE")) {
            return PHOTOS_OF_NEXT_PLACE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
