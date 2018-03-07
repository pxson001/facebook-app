package com.facebook.bookmark.ui.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.bookmark.model.Bookmark;

/* compiled from: receiverId */
public class BookmarkAdClickEvent extends HoneyClientEvent {
    public BookmarkAdClickEvent(Bookmark bookmark) {
        super("ad_click");
        a("bookmark_id", bookmark.id);
        b("bookmark_type", bookmark.type);
        b("client_token", bookmark.clientToken);
    }
}
