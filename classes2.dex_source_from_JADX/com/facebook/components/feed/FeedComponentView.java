package com.facebook.components.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.components.ComponentView;
import com.facebook.components.fb.view.ComponentViewTagFinder;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.environment.CanShowAnchoredTooltip;

/* compiled from: getNotificationCount */
public class FeedComponentView extends ComponentView implements CanShowAnchoredTooltip {
    public FeedComponentView(Context context) {
        super(context);
    }

    public FeedComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean hk_() {
        View a = ComponentViewTagFinder.a(this, 2131558756);
        return a != null && ((Boolean) a.getTag(2131558756)).booleanValue();
    }

    public final void mo3090a(Tooltip tooltip) {
        tooltip.a(ComponentViewTagFinder.a(this, 2131558756));
    }
}
