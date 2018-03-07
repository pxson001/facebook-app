package com.facebook.timeline.widget.actionbar;

/* compiled from: f41d1b1b445dfb523afd183e8f5d7533 */
public class PersonActionBarItemsAnalytics {
    public static String m18806a(@PersonActionBarItems int i) {
        switch (i) {
            case 0:
                return "manage_friendship";
            case 1:
                return "follow";
            case 2:
                return "message";
            case 3:
                return "manage";
            case 4:
                return "poke";
            case 5:
                return "see_friendship";
            case 6:
                return "suggest_friends";
            case 7:
                return "block";
            case 8:
                return "report";
            case 9:
                return "update_info";
            case 10:
                return "change_profile_pic";
            case 11:
                return "change_cover_photo";
            case 12:
                return "privacy_shortcuts";
            case 13:
                return "activity_log";
            case 14:
                return "add_to_groups";
            default:
                throw new IllegalArgumentException("Unexpected item: " + i);
        }
    }
}
