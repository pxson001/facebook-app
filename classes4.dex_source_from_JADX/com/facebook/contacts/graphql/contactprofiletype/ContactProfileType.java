package com.facebook.contacts.graphql.contactprofiletype;

import com.google.common.collect.ImmutableList;

/* compiled from: getCachedMediaFromStrongAndWeakCaches( */
public enum ContactProfileType {
    USER("user"),
    UNMATCHED("unmatched"),
    PAGE("page");
    
    public static final ImmutableList<ContactProfileType> ALL_TYPES = null;
    public static final ImmutableList<ContactProfileType> FACEBOOK_FRIENDS_TYPES = null;
    public static final ImmutableList<ContactProfileType> MESSAGABLE_TYPES = null;
    public static final ImmutableList<ContactProfileType> PAGES_TYPES = null;
    private final String mGraphQlParamValue;

    static {
        ALL_TYPES = ImmutableList.of(USER, UNMATCHED, PAGE);
        MESSAGABLE_TYPES = ImmutableList.of(USER, UNMATCHED);
        FACEBOOK_FRIENDS_TYPES = ImmutableList.of(USER);
        PAGES_TYPES = ImmutableList.of(PAGE);
    }

    private ContactProfileType(String str) {
        this.mGraphQlParamValue = str;
    }

    public final int getDbValue() {
        switch (this) {
            case USER:
                return 1;
            case PAGE:
                return 3;
            default:
                return 2;
        }
    }

    public static ContactProfileType fromDbValue(int i) {
        switch (i) {
            case 1:
                return USER;
            case 3:
                return PAGE;
            default:
                return UNMATCHED;
        }
    }

    public final String getGraphQlParamValue() {
        return this.mGraphQlParamValue;
    }
}
