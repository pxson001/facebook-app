package com.facebook.bookmark.ui.event;

import android.app.Activity;
import android.os.Parcelable;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.ui.BookmarkAdapter.BaseViewItem;

/* compiled from: receipt_fragment */
public class BookmarkEventBuilder {
    public Activity f5743a;
    public Bookmark f5744b;
    public BaseViewItem f5745c;
    public String f5746d;
    public boolean f5747e = false;
    private Parcelable f5748f;

    BookmarkEventBuilder() {
    }

    public final BookmarkEvent m5971a() {
        return new BookmarkEvent(this.f5743a, this.f5744b, this.f5745c, this.f5746d, this.f5747e, this.f5748f);
    }
}
