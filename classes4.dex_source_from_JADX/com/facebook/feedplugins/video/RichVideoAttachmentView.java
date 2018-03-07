package com.facebook.feedplugins.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.attachments.videos.ui.CanShowLiveCommentDialogFragment;
import com.facebook.attachments.videos.ui.HasChannelFeedLauncherInfo;
import com.facebook.feed.autoplay.KeepRegisteredVideoPlayerView;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.feed.ui.inlinevideoplayer.plugins.InlineCallToActionEndscreenPlugin;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.katana.app.module.Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.commercialbreak.abtest.CommercialBreakConfig;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.VideoSubtitlesListener;
import com.facebook.video.player.VideoTransitionNode;
import com.facebook.video.player.plugins.InlineFeed360TouchPlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.video.watchandbrowse.CanLaunchWatchAndBrowse;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;
import java.util.List;
import javax.inject.Inject;

/* compiled from: preprocess_frames */
public class RichVideoAttachmentView extends CustomRelativeLayout implements CanShowLiveCommentDialogFragment, HasChannelFeedLauncherInfo, KeepRegisteredVideoPlayerView, VideoSubtitlesListener, VideoTransitionNode, CanLaunchWatchAndBrowse, RecyclerViewKeepAttached {
    @Inject
    Video360PlayerConfig f4297a;
    @Inject
    public InlineRichVideoPlayerPluginSelector f4298b;
    private RichVideoPlayer f4299c;
    private boolean f4300d;
    private boolean f4301e;
    private boolean f4302f;
    private InlineCallToActionEndscreenPlugin f4303g;
    private Subtitles f4304h;
    private View f4305i;

    private static <T extends View> void m4840a(Class<T> cls, T t) {
        m4841a((Object) t, t.getContext());
    }

    private static void m4841a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RichVideoAttachmentView) obj).m4839a(Video360PlayerConfig.b(fbInjector), new InlineRichVideoPlayerPluginSelector((Context) fbInjector.getInstance(Context.class), Video360PlayerConfig.b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.m4865b(fbInjector), IdBasedProvider.a(fbInjector, 767), CommercialBreakConfig.m4866a(fbInjector)));
    }

    private void m4839a(Video360PlayerConfig video360PlayerConfig, InlineRichVideoPlayerPluginSelector inlineRichVideoPlayerPluginSelector) {
        this.f4297a = video360PlayerConfig;
        this.f4298b = inlineRichVideoPlayerPluginSelector;
    }

    public RichVideoAttachmentView(Context context) {
        this(context, null);
    }

    public RichVideoAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RichVideoAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4300d = true;
        this.f4302f = false;
        m4840a(RichVideoAttachmentView.class, (View) this);
        setContentView(2130906859);
        this.f4305i = m14861a(2131567025);
        this.f4299c = (RichVideoPlayer) m14861a(2131560290);
        this.f4303g = new InlineCallToActionEndscreenPlugin(context);
        this.f4299c.m14825a(this.f4303g);
        this.f4304h = null;
    }

    public final void mo361a(RichVideoPlayer richVideoPlayer) {
        if (this.f4299c != richVideoPlayer) {
            mo371i();
        }
        if (!this.f4300d) {
            this.f4305i.setVisibility(8);
            if (!(richVideoPlayer.getLayoutParams() instanceof LayoutParams)) {
                richVideoPlayer.setLayoutParams(new LayoutParams(richVideoPlayer.getLayoutParams()));
            }
            attachViewToParent(richVideoPlayer, 0, this.f4305i.getLayoutParams());
        }
        this.f4299c = richVideoPlayer;
        this.f4300d = true;
        requestLayout();
    }

    public final RichVideoPlayer mo371i() {
        if (this.f4300d) {
            ViewGroup.LayoutParams layoutParams = this.f4305i.getLayoutParams();
            layoutParams.height = this.f4299c.getMeasuredHeight();
            layoutParams.width = this.f4299c.getMeasuredWidth();
            this.f4305i.setLayoutParams(layoutParams);
            this.f4305i.setVisibility(4);
            detachViewFromParent(this.f4299c);
            requestLayout();
        }
        this.f4300d = false;
        return this.f4299c;
    }

    public InlineRichVideoPlayerPluginSelector getPluginSelector() {
        return this.f4298b;
    }

    public VideoTransitionNode getTransitionNode() {
        return this;
    }

    public final RichVideoPlayer mo372j() {
        return this.f4299c;
    }

    public RichVideoPlayer getRichVideoPlayer() {
        return this.f4299c;
    }

    public PlayerType getPlayerType() {
        return PlayerType.INLINE_PLAYER;
    }

    public List<RichVideoPlayerPlugin> getAdditionalPlugins() {
        return null;
    }

    public int getSeekPosition() {
        return this.f4299c.getCurrentPositionMs();
    }

    public int getLastStartPosition() {
        return this.f4299c.getLastStartPosition();
    }

    public final boolean gK_() {
        return true;
    }

    public void setShowLiveCommentDialogFragment(boolean z) {
        this.f4301e = z;
    }

    public boolean getAndClearShowLiveCommentDialogFragment() {
        boolean z = this.f4301e;
        this.f4301e = false;
        return z;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f4303g.f14134o = onClickListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1658639259);
        RichVideoPlayer richVideoPlayer = getRichVideoPlayer();
        if (richVideoPlayer == null || richVideoPlayer.f14027t == null || !richVideoPlayer.f14027t.m5358c() || !this.f4297a.t) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(13290080, a);
            return onTouchEvent;
        }
        onTouchEvent = m4842a(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -1284746349, a);
        return onTouchEvent;
    }

    private boolean m4842a(MotionEvent motionEvent) {
        boolean z;
        InlineFeed360TouchPlugin inlineFeed360TouchPlugin = (InlineFeed360TouchPlugin) getRichVideoPlayer().m14816a(InlineFeed360TouchPlugin.class);
        if (inlineFeed360TouchPlugin != null) {
            if (inlineFeed360TouchPlugin.f4679l) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            boolean onTouchEvent = inlineFeed360TouchPlugin.onTouchEvent(motionEvent);
            if (onTouchEvent || !inlineFeed360TouchPlugin.f4680m) {
                z = onTouchEvent;
            } else {
                performClick();
                return true;
            }
        }
        z = false;
        return !z ? super.onTouchEvent(motionEvent) : z;
    }

    public final void mo360a(EventTriggerType eventTriggerType, int i) {
        this.f4299c.m14819a(eventTriggerType, i);
    }

    public final void mo359a(EventTriggerType eventTriggerType) {
        this.f4299c.m14832b(eventTriggerType);
    }

    public final void m4843a() {
        this.f4302f = true;
    }

    public final boolean mo363d() {
        return this.f4302f;
    }

    public final void mo362a(Subtitles subtitles) {
        if (this.f4304h != subtitles) {
            this.f4304h = subtitles;
            this.f4299c.m14826a(subtitles);
            this.f4299c.m14829a(subtitles != null);
        }
    }

    public VideoStoryPersistentState getVideoStoryPersistentState() {
        return null;
    }
}
