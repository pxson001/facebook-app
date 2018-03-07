package com.facebook.bookmark.ui.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.bookmark.event.BookmarkAnalyticHelper;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;

/* compiled from: receipt_payload */
public class BookmarkImpressionEvent extends HoneyClientEvent {
    public BookmarkImpressionEvent(BookmarkAnalyticHelper bookmarkAnalyticHelper, List<Bookmark> list) {
        super("bookmark_impression");
        this.c = "sidebar_menu";
        b("mobile_platform", "android");
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bookmark bookmark = (Bookmark) list.get(i);
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            BookmarksGroup a = bookmarkAnalyticHelper.m5856a(bookmark);
            objectNode.a("index", i + 1);
            objectNode.a("name", bookmark.name);
            objectNode.a("group", a != null ? a.name : null);
            objectNode.a("category", BookmarkAnalyticHelper.m5855c(bookmark));
            objectNode.a("nav_section", bookmarkAnalyticHelper.m5857b(bookmark));
            arrayNode.a(objectNode);
        }
        a("bookmarks", arrayNode);
    }
}
