package com.facebook.feed.ui.inlinevideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.video.util.RichVideoPlayerParamsUtil;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;

@DoNotStrip
/* compiled from: Text */
public class RecordedLivePlugin extends RichVideoPlayerPlugin {
    private final View f22321a;

    @DoNotStrip
    public RecordedLivePlugin(Context context) {
        this(context, null);
    }

    private RecordedLivePlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private RecordedLivePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906750);
        this.f22321a = a(2131566843);
    }

    protected final void m24931a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        this.f22321a.setVisibility(8);
        if (richVideoPlayerParams.b != null && richVideoPlayerParams.b.containsKey("GraphQLStoryProps") && (richVideoPlayerParams.b.get("GraphQLStoryProps") instanceof FeedProps)) {
            GraphQLMedia a = RichVideoPlayerParamsUtil.a(richVideoPlayerParams);
            if (a != null && a.aq() && a.br() != GraphQLVideoBroadcastStatus.LIVE) {
                this.f22321a.setVisibility(0);
            }
        }
    }
}
