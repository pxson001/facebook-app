package com.facebook.feed.renderer;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: destroy_recorder */
public class WithTagsClickListener implements OnClickListener {
    private final OnClickListener f13944a;
    private int[] f13945b;
    private Object[] f13946c;

    public WithTagsClickListener(OnClickListener onClickListener, int i, Object obj, int i2, Object obj2) {
        this.f13944a = onClickListener;
        this.f13945b = new int[]{i, i2};
        this.f13946c = new Object[]{obj, obj2};
    }

    public WithTagsClickListener(OnClickListener onClickListener, int i, Object obj, int i2, Object obj2, int i3, Object obj3) {
        this.f13944a = onClickListener;
        this.f13945b = new int[]{i, i2, i3};
        this.f13946c = new Object[]{obj, obj2, obj3};
    }

    public WithTagsClickListener(OnClickListener onClickListener, int i, Object obj, int i2, Object obj2, int i3, Object obj3, int i4, Object obj4) {
        this.f13944a = onClickListener;
        this.f13945b = new int[]{i, i2, i3, i4};
        this.f13946c = new Object[]{obj, obj2, obj3, obj4};
    }

    public void onClick(View view) {
        int i;
        int i2 = 0;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1490408561);
        int length = this.f13945b.length;
        for (i = 0; i < length; i++) {
            view.setTag(this.f13945b[i], this.f13946c[i]);
        }
        this.f13944a.onClick(view);
        i = this.f13945b.length;
        while (i2 < i) {
            view.setTag(this.f13945b[i2], null);
            i2++;
        }
        LogUtils.a(-1957600964, a);
    }
}
