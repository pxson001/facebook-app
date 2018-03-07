package com.facebook.bookmark.ui.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.bookmark.event.BookmarkAnalyticHelper;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;

/* compiled from: received_ */
public class BookmarkClickEvent extends HoneyClientEvent {
    public BookmarkClickEvent(BookmarkAnalyticHelper bookmarkAnalyticHelper, Bookmark bookmark) {
        String str;
        super("bookmark_click");
        j(String.valueOf(bookmark.id));
        this.c = "sidebar_menu";
        b("mobile_platform", "android");
        b("item_category", BookmarkAnalyticHelper.m5855c(bookmark));
        b("item_name", bookmark.name);
        b("mobile_location_type", "sidebar");
        b("nav_section_mobile_sidebar", bookmarkAnalyticHelper.m5857b(bookmark));
        String str2 = "mobile_location";
        BookmarksGroup a = bookmarkAnalyticHelper.m5856a(bookmark);
        Object obj = (a == null || a.m5881c(bookmark)) ? 1 : null;
        if (obj != null) {
            str = "load";
        } else {
            str = "see_all";
        }
        b(str2, str);
    }
}
