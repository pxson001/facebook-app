package com.facebook.bookmark.event;

import android.net.Uri;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.event.BookmarkAnalyticEntities.BookmarkGroupTypes;
import com.facebook.bookmark.event.BookmarkAnalyticEntities.BookmarkTypes;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.util.StringLocaleUtil;
import javax.inject.Inject;

/* compiled from: refillBuffer() called when buffer wasn't empty. */
public final class BookmarkAnalyticHelper {
    private final BookmarkManager f5644a;

    @Inject
    public BookmarkAnalyticHelper(BookmarkManager bookmarkManager) {
        this.f5644a = bookmarkManager;
    }

    public final BookmarksGroup m5856a(Bookmark bookmark) {
        for (BookmarksGroup bookmarksGroup : this.f5644a.mo218b()) {
            if (bookmarksGroup.m5879b(bookmark)) {
                return bookmarksGroup;
            }
        }
        return null;
    }

    public final String m5857b(Bookmark bookmark) {
        BookmarksGroup a = m5856a(bookmark);
        switch (BookmarkGroupTypes.lookup(a != null ? StringLocaleUtil.b(a.id) : null)) {
            case PROFILE:
                return "self_timeline";
            case PINNED:
                return "user_favorite";
            case AD:
                return "ads_section";
            case APP:
                return "apps_section";
            case GROUP:
                return "groups_section";
            case PAGE:
                return "pages_section";
            case DEVELOPER:
                return "developer_section";
            case SETTINGS:
                return "settings_section";
            case INTEREST_LIST:
                return "interests_section";
            case FRIEND_LIST:
                return "friends_section";
            default:
                return "unknown";
        }
    }

    public static String m5855c(Bookmark bookmark) {
        Uri parse = Uri.parse(bookmark.url);
        switch (BookmarkTypes.lookup(StringLocaleUtil.b(bookmark.type))) {
            case APP:
                if (parse.toString().contains(FBLinks.b)) {
                    return "app_fb";
                }
                return "app_noncanvas_3rdparty";
            case NEWSFEED:
                return "newsfeed";
            case PROFILE:
                return "self_timeline";
            case GROUP:
                return "group_user";
            case FRIEND_LIST:
                return "friend_list";
            case INTEREST_LIST:
                return "interest_list";
            default:
                return "unknown";
        }
    }
}
