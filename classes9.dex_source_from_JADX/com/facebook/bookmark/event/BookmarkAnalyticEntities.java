package com.facebook.bookmark.event;

/* compiled from: region_keys */
public final class BookmarkAnalyticEntities {

    /* compiled from: region_keys */
    public enum BookmarkGroupTypes {
        PROFILE,
        PINNED,
        AD,
        PAGE,
        GROUP,
        APP,
        DEVELOPER,
        FRIEND_LIST,
        INTEREST_LIST,
        SETTINGS,
        UNKNOWN;

        public static BookmarkGroupTypes lookup(String str) {
            try {
                return valueOf(str);
            } catch (Exception e) {
                return UNKNOWN;
            }
        }
    }

    /* compiled from: region_keys */
    public enum BookmarkTypes {
        APP,
        PROFILE,
        NEWSFEED,
        GROUP,
        FRIEND_LIST,
        INTEREST_LIST,
        UNKNOWN;

        public static BookmarkTypes lookup(String str) {
            try {
                return valueOf(str);
            } catch (Exception e) {
                return UNKNOWN;
            }
        }
    }

    private BookmarkAnalyticEntities() {
    }
}
