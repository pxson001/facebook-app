package com.facebook.feedplugins.articlechaining.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import javax.annotation.Nullable;

/* compiled from: num_inclusions */
public class ArticleChainingFeedUnitItemView extends PagerItemWrapperLayout implements RecyclableView {
    public final ArticleChainingItemContainer f6576a;
    public boolean f6577b;

    public ArticleChainingFeedUnitItemView(Context context) {
        this(context, null);
    }

    private ArticleChainingFeedUnitItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130903293);
        this.f6576a = new ArticleChainingItemContainer(this);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1652563004);
        super.onAttachedToWindow();
        this.f6577b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2008422973, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1860569996);
        super.onDetachedFromWindow();
        this.f6577b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1362374135, a);
    }

    public final boolean mo569a() {
        return this.f6577b;
    }
}
