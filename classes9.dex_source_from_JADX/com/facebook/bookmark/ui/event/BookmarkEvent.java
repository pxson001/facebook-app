package com.facebook.bookmark.ui.event;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.ui.BookmarkAdapter.BaseViewItem;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: receipt_image_id */
public class BookmarkEvent {
    public final Activity f5736a;
    public final Bookmark f5737b;
    public final BaseViewItem f5738c;
    public final String f5739d;
    public final boolean f5740e;
    @Nullable
    private final Parcelable f5741f;
    private Bundle f5742g = null;

    public static BookmarkEventBuilder newBuilder() {
        return new BookmarkEventBuilder();
    }

    BookmarkEvent(Activity activity, Bookmark bookmark, BaseViewItem baseViewItem, String str, boolean z, @Nullable Parcelable parcelable) {
        this.f5736a = (Activity) Preconditions.checkNotNull(activity);
        if (bookmark == null && str == null) {
            throw new IllegalArgumentException("bookmark and url are both null.");
        }
        this.f5737b = bookmark;
        this.f5738c = baseViewItem;
        this.f5739d = str;
        this.f5740e = z;
        this.f5741f = parcelable;
    }

    public final <T extends Parcelable> T m5968a() {
        return this.f5741f;
    }

    public final String m5969b() {
        return this.f5739d != null ? this.f5739d : this.f5737b.url;
    }

    final Bundle m5970c() {
        if (this.f5742g == null) {
            this.f5742g = new Bundle();
            this.f5742g.putString("url", m5969b());
            if (this.f5741f != null) {
                this.f5742g.putParcelable("data", this.f5741f);
            }
            this.f5742g.putBoolean("long_click", this.f5740e);
        }
        return this.f5742g;
    }
}
