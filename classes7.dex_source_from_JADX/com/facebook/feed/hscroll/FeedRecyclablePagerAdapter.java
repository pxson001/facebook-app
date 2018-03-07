package com.facebook.feed.hscroll;

import android.view.View;
import com.facebook.feed.hscroll.HScrollFeedItem.Position;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.ui.recyclablepager.RecyclablePagerAdapter;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import java.util.List;

@Deprecated
/* compiled from: animated_image_format */
public abstract class FeedRecyclablePagerAdapter<ITEM> extends RecyclablePagerAdapter<ITEM> {
    public List<ITEM> f19220a;
    public boolean f19221b;

    protected abstract PagerViewType mo1517d();

    protected FeedRecyclablePagerAdapter(RecyclableViewPoolManager recyclableViewPoolManager) {
        super(recyclableViewPoolManager);
    }

    protected final PagerViewType m22741a(int i) {
        return mo1517d();
    }

    protected final ITEM m22745b(int i) {
        return this.f19220a.get(i);
    }

    public final void m22742a(List<ITEM> list) {
        boolean z = true;
        this.f19220a = list;
        if (list == null || list.size() <= 1) {
            z = false;
        }
        this.f19221b = z;
        kR_();
    }

    public final int m22744b() {
        return this.f19220a != null ? this.f19220a.size() : 0;
    }

    public final boolean m22743a(View view, Object obj) {
        return view.getTag(2131558745) == obj;
    }

    protected Position mo1516a(int i, int i2) {
        if (i == 0) {
            return Position.FIRST;
        }
        if (i == i2 - 1) {
            return Position.LAST;
        }
        return Position.INNER;
    }
}
