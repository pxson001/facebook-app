package com.facebook.feedplugins.multishare;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: connqual */
public class BusinessLocationActionLinkClickListener implements OnClickListener {
    public final DefaultFeedUnitRenderer f8004a;
    public final CommonEventsBuilder f8005b;
    private final OnClickListener f8006c;

    @Inject
    public BusinessLocationActionLinkClickListener(CommonEventsBuilder commonEventsBuilder, DefaultFeedUnitRenderer defaultFeedUnitRenderer, @Nullable @Assisted FeedProps<GraphQLStory> feedProps, @Assisted String str, @Assisted int i) {
        OnClickListener onClickListener;
        this.f8005b = commonEventsBuilder;
        this.f8004a = defaultFeedUnitRenderer;
        if (feedProps == null) {
            onClickListener = null;
        } else {
            HoneyClientEvent a = this.f8005b.a(str, ((GraphQLStory) feedProps.a).u(), TrackableFeedProps.a(feedProps), "native_newsfeed", i);
            if (a != null) {
                a.a("cta_click", true);
            }
            onClickListener = this.f8004a.a(str, a, null);
        }
        this.f8006c = onClickListener;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1793533979);
        if (this.f8006c != null) {
            this.f8006c.onClick(view);
        }
        Logger.a(2, EntryType.UI_INPUT_END, 999502286, a);
    }
}
