package com.facebook.bookmark.ipc;

import android.net.Uri;
import com.facebook.common.build.BuildConstants;

/* compiled from: zero_upsell_feed_unit */
public class BookmarkContract {
    public static final String f290a = (BuildConstants.n() + ".provider.BookmarkProvider");
    public static final Uri f291b = Uri.parse(f293d + "clear_all_data");
    public static final String f292c = (BuildConstants.n() + ".broadcast.bookmarks");
    public static final String f293d = ("content://" + f290a + "/");
}
