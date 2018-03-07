package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import javax.annotation.Nullable;

/* compiled from: composer_add_location_click */
public class OverflowMenuPlugin<E extends HasFeedMenuHelper> extends RichVideoPlayerPluginWithEnv<E> {
    @Nullable
    public FeedProps<GraphQLStory> f19359a;
    private View f19360b;

    /* compiled from: composer_add_location_click */
    class C14451 implements OnClickListener {
        final /* synthetic */ OverflowMenuPlugin f19358a;

        C14451(OverflowMenuPlugin overflowMenuPlugin) {
            this.f19358a = overflowMenuPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -294152403);
            BaseFeedStoryMenuHelper l = this.f19358a.c != null ? ((HasFeedMenuHelper) this.f19358a.c).m28063l() : null;
            if (!(l == null || this.f19358a.f19359a == null)) {
                l.a(this.f19358a.f19359a, view);
                this.f19358a.i.b(EventTriggerType.BY_REPORTING_FLOW);
            }
            LogUtils.a(-1208339828, a);
        }
    }

    public OverflowMenuPlugin(Context context) {
        this(context, null);
    }

    public OverflowMenuPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverflowMenuPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(getContentViewResource());
        this.f19360b = a(2131561907);
        this.f19360b.setOnClickListener(new C14451(this));
    }

    protected int getContentViewResource() {
        return 2130904788;
    }

    protected final void m28137a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (!z || (richVideoPlayerParams.b != null && richVideoPlayerParams.b.containsKey("GraphQLStoryProps") && (richVideoPlayerParams.b.get("GraphQLStoryProps") instanceof FeedProps))) {
            GraphQLStory graphQLStory;
            this.f19359a = (FeedProps) richVideoPlayerParams.b.get("GraphQLStoryProps");
            if (this.f19359a != null) {
                graphQLStory = (GraphQLStory) this.f19359a.a;
            } else {
                graphQLStory = null;
            }
            if (graphQLStory == null || m28136a(graphQLStory)) {
                this.f19360b.setVisibility(8);
                return;
            } else {
                this.f19360b.setVisibility(0);
                return;
            }
        }
        this.f19360b.setVisibility(8);
    }

    private static boolean m28136a(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        GraphQLMedia r = o == null ? null : o.r();
        return r != null && r.aq() && r.br() == GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }

    protected final void m28138c() {
        this.f19359a = null;
    }
}
