package com.facebook.feedplugins.attachments.poll;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.FeedUnit;

/* compiled from: THREAD_LIST */
public class PollItemBackgroundStyler {
    public static StylingData m25321a(boolean z, FeedProps<? extends FeedUnit> feedProps, PollDisplayAndClickListenerBuilder pollDisplayAndClickListenerBuilder) {
        float f;
        if (z) {
            f = 31.0f;
        } else {
            f = 3.0f;
        }
        float f2 = f;
        if (z) {
            f = 65.0f;
        } else {
            f = 92.5f;
        }
        float f3 = f;
        float f4 = -1.5f;
        Builder a = Builder.a();
        a.b = f4;
        Builder builder = a;
        builder.e = f3;
        Builder builder2 = builder;
        builder2.d = f2;
        return new StylingData(feedProps, builder2.i(), 2130842718, -1);
    }
}
