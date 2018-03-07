package com.facebook.graphql.enums;

/* compiled from: list_items */
public enum GraphQLSuggestEditsFieldOptionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    HAS_VALUE,
    DOESNT_HAVE_VALUE,
    ADD_VALUE,
    LOCATED_INSIDE,
    ALWAYS_OPEN,
    PERMANENTLY_CLOSED;

    public static GraphQLSuggestEditsFieldOptionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("HAS_VALUE")) {
            return HAS_VALUE;
        }
        if (str.equalsIgnoreCase("DOESNT_HAVE_VALUE")) {
            return DOESNT_HAVE_VALUE;
        }
        if (str.equalsIgnoreCase("ADD_VALUE")) {
            return ADD_VALUE;
        }
        if (str.equalsIgnoreCase("LOCATED_INSIDE")) {
            return LOCATED_INSIDE;
        }
        if (str.equalsIgnoreCase("ALWAYS_OPEN")) {
            return ALWAYS_OPEN;
        }
        if (str.equalsIgnoreCase("PERMANENTLY_CLOSED")) {
            return PERMANENTLY_CLOSED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
