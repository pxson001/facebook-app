package com.facebook.apptab.state;

import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.collect.Maps;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: total_time_spent */
public enum TabTag {
    Feed(FBLinks.bT, FragmentConstants$ContentFragmentType.NATIVE_NEWS_FEED_SWITCHER_FRAGMENT, 2130841533, true, "native_newsfeed", 6488078, 6488078, null, null, 2131232636, 2131558430),
    FriendRequests(FBLinks.ch, FragmentConstants$ContentFragmentType.FRIEND_REQUESTS_FRAGMENT, 2130841528, false, "friend_requests", 6488078, 6488078, null, null, 2131233203, 2131558431),
    RedSpace(FBLinks.eT, FragmentConstants$ContentFragmentType.REDSPACE_HOME_FRAGMENT, 2130839884, false, "red_space_grid", 6488078, 6488078, null, null, 2131232647, 2131558442),
    Message(FBLinks.f2141P, FragmentConstants$ContentFragmentType.THREAD_LIST_FRAGMENT, 2130841531, false, "messages", 6488071, 6488072, "LoadTab_Message", "LoadTab_Message_NoAnim", 2131232638, 2131558433),
    Notifications(FBLinks.cj, FragmentConstants$ContentFragmentType.NOTIFICATIONS_FRAGMENT, 2130841534, false, "notifications", 6488074, 6488075, "LoadTab_Notifications", "LoadTab_Notifications_NoAnim", 2131232642, 2131558436),
    NotificationsFriending(FBLinks.gc, FragmentConstants$ContentFragmentType.NOTIFICATIONS_FRIENDING_FRAGMENT, 2130841534, false, "notifications_friending", 6488081, 6488082, "LoadTab_NotificationsFriending", "LoadTab_NotificationsFriending_NoAnim", 2131232642, 2131558436),
    Notifications_east(FBLinks.cj, FragmentConstants$ContentFragmentType.NOTIFICATIONS_FRAGMENT, 2130841535, false, "notifications", 6488074, 6488075, "LoadTab_Notifications", "LoadTab_Notifications_NoAnim", 2131232642, 2131558436),
    Notifications_japan(FBLinks.cj, FragmentConstants$ContentFragmentType.NOTIFICATIONS_FRAGMENT, 2130841536, false, "notifications", 6488074, 6488075, "LoadTab_Notifications", "LoadTab_Notifications_NoAnim", 2131232642, 2131558436),
    Bookmark(FBLinks.bw, FragmentConstants$ContentFragmentType.BOOKMARKS_FRAGMENT, 2130841532, false, "bookmarks", 6488077, 6488076, "LoadTab_Bookmark", "LoadTab_Bookmark_NoAnim", 2131232643, 2131558437),
    B2C_Commerce(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, "/marketplace?ref=tab"), FragmentConstants$ContentFragmentType.FACEWEB_FRAGMENT, 2130841527, false, "b2c_commerce", 6488078, 6488078, null, null, 2131232640, 2131558434),
    C2C_Commerce(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, "/localmarket/home/?ref=tab"), FragmentConstants$ContentFragmentType.FACEWEB_FRAGMENT, 2130841528, false, "c2c_commerce", 6488078, 6488078, null, null, 2131232641, 2131558435),
    Marketplace(FBLinks.fG, FragmentConstants$ContentFragmentType.MARKETPLACE_TAB_FRAGMENT, 2130839806, false, "marketplace", 6488078, 6488078, null, null, 2131232649, 2131558444),
    VideoHome(FBLinks.fE, FragmentConstants$ContentFragmentType.VIDEOHOME_HOME_FRAGMENT, 2130841537, false, "video_home", 6488078, 6488078, null, null, 2131232648, 2131558443),
    WorkGroups(FBLinks.f2139N, FragmentConstants$ContentFragmentType.GROUPS_GRID_FRAGMENT, 2130841529, false, "work_groups_tab", 6488078, 6488078, null, null, 2131232639, 2131558445);
    
    private static final Map<String, TabTag> sFbLinkMapping = null;
    private static final Map<String, TabTag> sQEMapping = null;
    public final String analyticsTag;
    public final FragmentConstants$ContentFragmentType contentFragmentType;
    public final int descriptorResourceId;
    public final int drawableResourceId;
    public final String fblink;
    public final int loadTabTabPerfMarkerId;
    public final int loadTabTabPerfMarkerIdNoAnim;
    public final String loadTabTabPerfMarkerName;
    public final String loadTabTabPerfMarkerNameNoAnim;
    public final boolean shouldEnforceMaximumUnreadCount;
    public final int tabViewId;

    static {
        sQEMapping = Maps.m838c();
        sFbLinkMapping = Maps.m838c();
        for (TabTag tabTag : values()) {
            sQEMapping.put(tabTag.name().toLowerCase(Locale.ENGLISH), tabTag);
            sFbLinkMapping.put(tabTag.fblink, tabTag);
        }
    }

    private TabTag(String str, FragmentConstants$ContentFragmentType fragmentConstants$ContentFragmentType, int i, @Nullable boolean z, String str2, int i2, int i3, String str3, String str4, @Nullable int i4, int i5) {
        this.fblink = str;
        this.contentFragmentType = fragmentConstants$ContentFragmentType;
        this.drawableResourceId = i;
        this.shouldEnforceMaximumUnreadCount = z;
        this.analyticsTag = str2;
        this.loadTabTabPerfMarkerId = i2;
        this.loadTabTabPerfMarkerIdNoAnim = i3;
        this.loadTabTabPerfMarkerName = str3;
        this.loadTabTabPerfMarkerNameNoAnim = str4;
        this.descriptorResourceId = i4;
        this.tabViewId = i5;
    }

    public static TabTag fromName(@Nonnull String str) {
        return fromQEString(str.toLowerCase(Locale.ENGLISH));
    }

    public static TabTag fromFbLink(@Nonnull String str) {
        TabTag tabTag = (TabTag) sFbLinkMapping.get(str);
        if (tabTag != null) {
            return tabTag;
        }
        throw new IllegalArgumentException("FB Link " + str + " is not present in the TabTag enum");
    }

    public static TabTag fromQEString(String str) {
        TabTag tabTag = (TabTag) sQEMapping.get(str);
        if (tabTag != null) {
            return tabTag;
        }
        throw new IllegalArgumentException("Item " + str + " is not present in the TabTag enum");
    }

    @Nullable
    public static TabTag fromNameSafe(@Nonnull String str) {
        return fromQEStringSafe(str.toLowerCase(Locale.ENGLISH));
    }

    @Nullable
    public static TabTag fromFbLinkSafe(@Nonnull String str) {
        return (TabTag) sFbLinkMapping.get(str);
    }

    @Nullable
    public static TabTag fromQEStringSafe(String str) {
        return (TabTag) sQEMapping.get(str);
    }

    public static boolean isNotificationsTabTag(TabTag tabTag) {
        return tabTag == Notifications || tabTag == Notifications_japan || tabTag == Notifications_east || tabTag == NotificationsFriending;
    }

    public static boolean isNotificationsTabTagName(String str) {
        return isNotificationsTabTag(fromNameSafe(str));
    }
}
