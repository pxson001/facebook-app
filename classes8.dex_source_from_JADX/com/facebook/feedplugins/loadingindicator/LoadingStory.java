package com.facebook.feedplugins.loadingindicator;

import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;

/* compiled from: friends_center_contacts_tab */
public interface LoadingStory {
    public static final StylingData f12895a;

    /* compiled from: friends_center_contacts_tab */
    public enum Type {
        GLOWING,
        SHIMMERING
    }

    static {
        Builder a = Builder.a();
        a.b = 6.0f;
        f12895a = new StylingData(null, a.i(), Position.BOX);
    }
}
