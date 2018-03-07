package com.facebook.feedplugins.graphqlstory.footer;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FlyoutLauncher$FlyoutContext;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: Song */
public class FeedDiscoveryBlingBarPartDefinition$3 implements OnClickListener {
    final /* synthetic */ FeedProps f23220a;
    final /* synthetic */ FeedDiscoveryBlingBarPartDefinition f23221b;

    public FeedDiscoveryBlingBarPartDefinition$3(FeedDiscoveryBlingBarPartDefinition feedDiscoveryBlingBarPartDefinition, FeedProps feedProps) {
        this.f23221b = feedDiscoveryBlingBarPartDefinition;
        this.f23220a = feedProps;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1745995615);
        this.f23221b.b.d((GraphQLStory) this.f23220a.a);
        this.f23221b.c.a(this.f23220a, view, FlyoutLauncher$FlyoutContext.BLINGBAR);
        Logger.a(2, EntryType.UI_INPUT_END, -1307920914, a);
    }
}
