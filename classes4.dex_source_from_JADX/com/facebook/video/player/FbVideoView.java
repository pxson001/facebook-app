package com.facebook.video.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.SinglePlayIconPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

@TargetApi(14)
/* compiled from: delivery_receipt_new_send_success */
public class FbVideoView extends RichVideoPlayer {
    public FbVideoView(Context context) {
        this(context, null);
    }

    public FbVideoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FbVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setPlayerOrigin(getDefaultPlayerOrigin());
        setPlayerType(getDefaultPlayerType());
        m14825a(new VideoPlugin(context));
        ImmutableList a = mo1005a(context);
        if (a != null) {
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                m14825a((RichVideoPlayerPlugin) a.get(i2));
            }
        }
    }

    protected ImmutableList<? extends RichVideoPlayerPlugin> mo1005a(Context context) {
        return ImmutableList.of(new SinglePlayIconPlugin(context), new LoadingSpinnerPlugin(context));
    }

    protected PlayerType getDefaultPlayerType() {
        return PlayerType.OTHERS;
    }

    protected PlayerOrigin getDefaultPlayerOrigin() {
        return PlayerOrigin.UNKNOWN;
    }

    public void iE_() {
        m14818a(EventTriggerType.BY_USER);
    }

    public void mo394b() {
        m14832b(EventTriggerType.BY_USER);
    }
}
