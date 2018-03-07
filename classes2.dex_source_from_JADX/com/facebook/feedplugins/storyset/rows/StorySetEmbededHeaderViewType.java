package com.facebook.feedplugins.storyset.rows;

import com.facebook.feedplugins.storyset.rows.ui.CanHaveEmbededHeader;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: key == null */
public abstract class StorySetEmbededHeaderViewType<V extends PagerItemWrapperLayout & CanHaveEmbededHeader> extends ViewType<V> {
    public boolean f18520a = false;

    protected final V m26000a(V v) {
        ((CanHaveEmbededHeader) v).setUseEmbeddedHeaderComponent(this.f18520a);
        return v;
    }
}
