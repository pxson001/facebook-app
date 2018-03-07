package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.instantshopping.view.widget.media.VideoPlayButtonPlugin;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.richdocument.view.widget.RichDocumentVideoPlayer;
import com.facebook.richdocument.view.widget.RichDocumentVideoPlayer.WrappedPlayOnClickListener;
import com.facebook.richdocument.view.widget.media.MediaFrameBody;
import com.facebook.richdocument.view.widget.video.VideoControlIcon;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: SHA-1 */
public class InstantShoppingVideoPlayer extends RichDocumentVideoPlayer implements OnSharedPreferenceChangeListener {
    private final boolean f23928i = true;
    private final boolean f23929j = false;
    private VideoPlayButtonPlugin f23930k;
    public boolean f23931l;

    /* compiled from: SHA-1 */
    class InstantShoppingPlayOnClickListener extends WrappedPlayOnClickListener {
        final /* synthetic */ InstantShoppingVideoPlayer f23927b;

        public InstantShoppingPlayOnClickListener(InstantShoppingVideoPlayer instantShoppingVideoPlayer, OnClickListener onClickListener) {
            this.f23927b = instantShoppingVideoPlayer;
            super(instantShoppingVideoPlayer, onClickListener);
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -395119434);
            VideoControlIcon videoControlIcon = (VideoControlIcon) ((MediaFrameBody) view.getParent()).findViewById(2131563319);
            ImageView imageView = (ImageView) ((MediaFrameBody) view.getParent()).findViewById(2131563256);
            videoControlIcon.d();
            if (videoControlIcon.getVisibility() != 8) {
                videoControlIcon.setVisibility(8);
                imageView.setAlpha(0.0f);
                imageView.setVisibility(0);
                imageView.animate().alpha(1.0f).setDuration(1000);
            } else if (this.f23927b.f23931l) {
                super.onClick(view);
            }
            this.f23927b.a(this.f23927b.m.a(true, false));
            if (!(this.f23927b.m() || this.f23927b.o())) {
                this.f23927b.a(EventTriggerType.BY_USER);
            }
            LogUtils.a(-1795531770, a);
        }
    }

    public InstantShoppingVideoPlayer(Context context) {
        super(context);
    }

    public InstantShoppingVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstantShoppingVideoPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected PlayerOrigin getDefaultPlayerOrigin() {
        return PlayerOrigin.INSTANT_SHOPPING;
    }

    protected final ImmutableList<? extends RichVideoPlayerPlugin> m25200a(Context context) {
        this.f23930k = new VideoPlayButtonPlugin(context);
        Builder builder = ImmutableList.builder();
        builder.b(super.a(context));
        builder.c(this.f23930k);
        return builder.b();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(new InstantShoppingPlayOnClickListener(this, onClickListener));
    }

    public final void m25201a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
        boolean z = false;
        if (!fbSharedPreferences.a(prefKey, false)) {
            z = true;
        }
        a(z, EventTriggerType.BY_USER);
    }

    public final void m25203x() {
        VideoPlayButtonPlugin videoPlayButtonPlugin = this.f23930k;
        videoPlayButtonPlugin.f23956c = false;
        videoPlayButtonPlugin.f23955b.setVisibility(8);
        videoPlayButtonPlugin.f23955b.setLoading(false);
        videoPlayButtonPlugin.f.clear();
    }

    public final void m25202b() {
        b(EventTriggerType.BY_ANDROID);
    }

    public void setDefaultClickEnabled(boolean z) {
        this.f23931l = z;
    }
}
