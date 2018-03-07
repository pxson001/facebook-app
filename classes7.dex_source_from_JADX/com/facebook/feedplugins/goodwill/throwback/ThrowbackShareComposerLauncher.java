package com.facebook.feedplugins.goodwill.throwback;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: Starting status fetch from server. */
public class ThrowbackShareComposerLauncher implements OnClickListener {
    private final IFeedIntentBuilder f23145a;
    private final ComposerLauncher f23146b;
    private final ComposerSourceType f23147c;
    private final String f23148d;
    private final FeedProps<GraphQLStory> f23149e;

    @Inject
    public ThrowbackShareComposerLauncher(IFeedIntentBuilder iFeedIntentBuilder, ComposerLauncher composerLauncher, @Assisted FeedProps<GraphQLStory> feedProps, @Assisted ComposerSourceType composerSourceType, @Assisted String str) {
        this.f23145a = iFeedIntentBuilder;
        this.f23146b = composerLauncher;
        this.f23149e = feedProps;
        this.f23147c = composerSourceType;
        this.f23148d = str;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1265658779);
        this.f23146b.a(null, this.f23145a.a(this.f23149e, this.f23147c).setIsThrowbackPost(true).setNectarModule(this.f23148d).a(), 1756, (Activity) ContextUtils.a(view.getContext(), Activity.class));
        Logger.a(2, EntryType.UI_INPUT_END, -1050338031, a);
    }
}
