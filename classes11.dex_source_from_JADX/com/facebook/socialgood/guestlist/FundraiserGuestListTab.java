package com.facebook.socialgood.guestlist;

/* compiled from: PAGES_LAUNCHPOINT_HOME_FRAGMENT */
public enum FundraiserGuestListTab {
    INVITED,
    SHARED,
    DONATED,
    NOT_DONATED;

    public static FundraiserGuestListTab fromString(String str) {
        if (str == null) {
            return null;
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case -1950547415:
                if (str.equals("NOT_DONATED")) {
                    obj = 3;
                    break;
                }
                break;
            case -1850236827:
                if (str.equals("SHARED")) {
                    obj = 1;
                    break;
                }
                break;
            case -1738502219:
                if (str.equals("DONATED")) {
                    obj = 2;
                    break;
                }
                break;
            case -1616953765:
                if (str.equals("INVITED")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return INVITED;
            case 1:
                return SHARED;
            case 2:
                return DONATED;
            case 3:
                return NOT_DONATED;
            default:
                return null;
        }
    }

    public final String toString() {
        return name();
    }
}
