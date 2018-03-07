package com.facebook.entitycards.view;

import android.content.Context;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.RecyclableView;

/* compiled from: home_%s_name_updated */
public class EntityCardsLoadingCardView extends CustomFrameLayout implements RecyclableView {
    public boolean f11130a = false;

    public EntityCardsLoadingCardView(Context context) {
        super(context);
        setContentView(2130903985);
        setBackgroundResource(2130839472);
    }

    public final boolean m13069a() {
        return this.f11130a;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 349282112);
        super.onAttachedToWindow();
        this.f11130a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1935327000, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 375267879);
        super.onDetachedFromWindow();
        this.f11130a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -959183417, a);
    }
}
