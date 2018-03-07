package com.facebook.bookmark.ui.event;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.content.SecureContextHelper;
import javax.annotation.Nullable;

/* compiled from: receipt_image_media_picker_fragment */
public abstract class BaseBookmarkSelectedListener {
    private final SecureContextHelper f5735a;

    protected abstract Intent m5966b(BookmarkEvent bookmarkEvent);

    protected BaseBookmarkSelectedListener(SecureContextHelper secureContextHelper) {
        this.f5735a = secureContextHelper;
    }

    public final boolean m5965a(BookmarkEvent bookmarkEvent) {
        if (m5967c(bookmarkEvent)) {
            return true;
        }
        Object obj;
        Bundle bundle = null;
        Bundle extras = bookmarkEvent.f5736a.getIntent().getExtras();
        if (extras != null) {
            extras.setClassLoader(BaseBookmarkSelectedListener.class.getClassLoader());
            bundle = extras.getBundle("bookmark_identifier");
        }
        extras = bookmarkEvent.m5970c();
        if (extras == null && bundle == null) {
            obj = 1;
        } else if (extras == null || bundle == null) {
            obj = null;
        } else if (extras.size() != bundle.size()) {
            obj = null;
        } else {
            for (String str : extras.keySet()) {
                String str2;
                Object obj2 = extras.get(str2);
                obj = bundle.get(str2);
                if (!(obj2 == null && obj == null) && (obj2 == null || !obj2.equals(obj))) {
                    obj = null;
                    break;
                }
            }
            int i = 1;
        }
        if (obj != null) {
            return true;
        }
        Intent b = m5966b(bookmarkEvent);
        m5964a(bookmarkEvent, b);
        if (b == null) {
            return false;
        }
        b.putExtra("bookmark_identifier", bookmarkEvent.m5970c());
        str2 = bookmarkEvent.m5969b();
        Uri parse = str2 != null ? Uri.parse(str2) : null;
        obj = FacebookUriUtil.h(parse) ? null : FacebookUriUtil.g(parse) ? 1 : null;
        if (obj != null) {
            if (bookmarkEvent.m5969b() != null) {
                b.putExtra("extra_launch_uri", bookmarkEvent.m5969b());
            }
            this.f5735a.a(b, bookmarkEvent.f5736a);
        } else {
            this.f5735a.b(b, bookmarkEvent.f5736a);
        }
        return true;
    }

    protected boolean m5967c(BookmarkEvent bookmarkEvent) {
        return false;
    }

    protected void m5964a(BookmarkEvent bookmarkEvent, @Nullable Intent intent) {
    }
}
