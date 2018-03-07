package com.facebook.feedplugins.base.blingbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FlyoutLauncher.FlyoutContext;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: passed_scroll_threshold */
class BlingBarFlyoutAndVideoLauncherPartDefinition$1 implements OnClickListener {
    final /* synthetic */ GraphQLStory f5338a;
    final /* synthetic */ CanShowVideoInFullScreen f5339b;
    final /* synthetic */ FeedProps f5340c;
    final /* synthetic */ BlingBarFlyoutAndVideoLauncherPartDefinition f5341d;

    BlingBarFlyoutAndVideoLauncherPartDefinition$1(BlingBarFlyoutAndVideoLauncherPartDefinition blingBarFlyoutAndVideoLauncherPartDefinition, GraphQLStory graphQLStory, CanShowVideoInFullScreen canShowVideoInFullScreen, FeedProps feedProps) {
        this.f5341d = blingBarFlyoutAndVideoLauncherPartDefinition;
        this.f5338a = graphQLStory;
        this.f5339b = canShowVideoInFullScreen;
        this.f5340c = feedProps;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1711931868);
        this.f5341d.d.d(this.f5338a);
        GraphQLStoryUtil graphQLStoryUtil = this.f5341d.c;
        GraphQLStoryAttachment p = GraphQLStoryUtil.p(this.f5338a);
        if (this.f5339b.c(p)) {
            this.f5339b.b(p);
        } else {
            this.f5341d.a.a(this.f5340c, view, FlyoutContext.BLINGBAR);
        }
        LogUtils.a(1312899353, a);
    }
}
