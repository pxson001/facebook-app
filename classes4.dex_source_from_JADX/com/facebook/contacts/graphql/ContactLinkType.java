package com.facebook.contacts.graphql;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: reason_description */
public enum ContactLinkType {
    ME,
    FRIEND,
    USER_CONTACT,
    UNMATCHED,
    PAGE;
    
    public static final ImmutableList<ContactLinkType> ALL = null;
    public static final ImmutableList<ContactLinkType> CONNECTIONS = null;
    public static final ImmutableList<ContactLinkType> FRIENDS = null;
    public static final ImmutableList<ContactLinkType> FRIENDS_AND_ME = null;
    public static final ImmutableList<ContactLinkType> FRIENDS_AND_PAGES = null;
    public static final ImmutableList<ContactLinkType> MESSAGEABLES = null;
    public static final ImmutableList<ContactLinkType> PAGES = null;
    public static final ImmutableList<ContactLinkType> USERS = null;

    static {
        FRIENDS = ImmutableList.of(FRIEND);
        FRIENDS_AND_ME = ImmutableList.of(FRIEND, ME);
        FRIENDS_AND_PAGES = ImmutableList.of(FRIEND, PAGE);
        USERS = ImmutableList.of(ME, FRIEND, USER_CONTACT);
        CONNECTIONS = FRIENDS_AND_PAGES;
        MESSAGEABLES = ImmutableList.of(FRIEND, USER_CONTACT);
        PAGES = ImmutableList.of(PAGE);
        ALL = ImmutableList.copyOf(values());
    }

    public final int getDbValue() {
        switch (this) {
            case ME:
                return 1;
            case FRIEND:
                return 2;
            case USER_CONTACT:
                return 3;
            case PAGE:
                return 5;
            default:
                return 4;
        }
    }

    public static ContactLinkType getFromDbValue(int i) {
        switch (i) {
            case 1:
                return ME;
            case 2:
                return FRIEND;
            case 3:
                return USER_CONTACT;
            case 5:
                return PAGE;
            default:
                return UNMATCHED;
        }
    }

    public static ContactLinkType getFromContact(Contact contact, String str) {
        Preconditions.checkNotNull(str);
        switch (contact.m4053A()) {
            case PAGE:
                return PAGE;
            case USER:
                if (GraphQLFriendshipStatus.ARE_FRIENDS.equals(contact.m4089x())) {
                    return FRIEND;
                }
                if (str.equals(contact.m4068c())) {
                    return ME;
                }
                return USER_CONTACT;
            default:
                return UNMATCHED;
        }
    }
}
