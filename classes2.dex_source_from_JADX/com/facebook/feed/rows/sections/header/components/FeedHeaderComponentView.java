package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.components.fb.view.ComponentViewTagFinder;
import com.facebook.components.feed.FeedComponentView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feedplugins.graphqlstory.header.CanShowSeeFirstIndicator;

/* compiled from: getNotificationURI */
class FeedHeaderComponentView extends FeedComponentView implements CanShowSeeFirstIndicator {
    FeedHeaderComponentView(Context context) {
        super(context);
    }

    public final void a_(Tooltip tooltip) {
        tooltip.a(ComponentViewTagFinder.a(this, 2131558757));
    }
}
