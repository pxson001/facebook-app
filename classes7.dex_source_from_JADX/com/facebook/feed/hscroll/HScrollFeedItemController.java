package com.facebook.feed.hscroll;

import android.content.res.Resources;
import com.facebook.feed.hscroll.HScrollFeedItem.Position;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.widget.CustomViewPager;
import java.util.List;

/* compiled from: android_sync */
public abstract class HScrollFeedItemController<T> {
    public abstract PagerViewType mo1562a();

    public abstract void mo1520a(List<T> list, CustomViewPager customViewPager);

    public void mo1519a(CustomViewPager customViewPager, Resources resources) {
        customViewPager.setPageMargin((((resources.getDimensionPixelSize(2131427507) / 2) + resources.getDimensionPixelSize(2131427507)) + (resources.getDimensionPixelSize(2131428854) * 2)) * -1);
    }

    public float mo1518a(Position position) {
        return 1.0f;
    }

    public int mo1521b() {
        return 2;
    }
}
