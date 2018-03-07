package com.facebook.video.videohome.adapter.viewholders;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.attachments.videos.ui.BaseChannelFeedLauncherInfo;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FindViewUtil;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.calls.VideoChannelSetPinStateInputData.ChannelType;
import com.facebook.graphql.calls.VideoChannelSetPinStateInputData.PinState;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.topics.protocol.TopicFavoritesQueryInterfaces.VideoTopicFragment;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.VideoTopicFragmentModel;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.channelfeed.ChannelFeedHeaderParams;
import com.facebook.video.channelfeed.ChannelFeedParams.Builder;
import com.facebook.video.videohome.adapter.VideoHomeGuideAdapter;
import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: sticker_editing_present */
public class TopicViewHolder extends VideoTopicItemBaseViewHolder<VideoTopicFragment> {
    private static final CallerContext f2776l = CallerContext.a(VideoHomeGuideAdapter.class, "video_home");
    private final FbDraweeView f2777m;
    public final GlyphView f2778n;
    private final TextView f2779o;
    private final TextView f2780p;
    public final DefaultTopicClickListener f2781q;

    /* compiled from: sticker_editing_present */
    class C02571 implements Runnable {
        final /* synthetic */ TopicViewHolder f2771a;

        C02571(TopicViewHolder topicViewHolder) {
            this.f2771a = topicViewHolder;
        }

        public void run() {
            Rect rect = new Rect();
            int dimensionPixelSize = this.f2771a.a.getResources().getDimensionPixelSize(2131431534);
            this.f2771a.f2778n.getHitRect(rect);
            rect.set(rect.left - dimensionPixelSize, rect.top - dimensionPixelSize, rect.right + dimensionPixelSize, dimensionPixelSize + rect.bottom);
            this.f2771a.a.setTouchDelegate(new TouchDelegate(rect, this.f2771a.f2778n));
        }
    }

    public final /* synthetic */ void mo81b(Object obj) {
        m2656a((VideoTopicFragment) obj);
    }

    public TopicViewHolder(View view, DefaultTopicClickListener defaultTopicClickListener) {
        super(view);
        this.f2781q = defaultTopicClickListener;
        this.f2777m = (FbDraweeView) FindViewUtil.b(view, 2131568426);
        this.f2778n = (GlyphView) FindViewUtil.b(view, 2131568427);
        this.f2779o = (TextView) FindViewUtil.b(view, 2131568429);
        this.f2780p = (TextView) FindViewUtil.b(view, 2131568428);
    }

    public final void m2656a(final VideoTopicFragment videoTopicFragment) {
        if (videoTopicFragment == null) {
            BLog.b(getClass().getSimpleName(), "Null topic item received");
            this.a.setVisibility(8);
            return;
        }
        this.f2778n.post(new C02571(this));
        Resources resources = this.a.getResources();
        if (!(videoTopicFragment.d() == null || videoTopicFragment.d().a() == null)) {
            this.f2777m.a(Uri.parse(videoTopicFragment.d().a()), f2776l);
        }
        if (videoTopicFragment.g()) {
            this.f2778n.setImageResource(2130839776);
            this.f2778n.setBackgroundResource(2130840758);
            this.f2778n.setContentDescription(resources.getString(2131237317));
        } else {
            this.f2778n.setImageResource(2130840034);
            this.f2778n.setBackgroundResource(2130840759);
            this.f2778n.setContentDescription(resources.getString(2131237316));
        }
        this.f2779o.setText(videoTopicFragment.j().a());
        int c = videoTopicFragment.c();
        if (c == 0) {
            this.f2780p.setVisibility(4);
        } else {
            CharSequence string;
            if (c > videoTopicFragment.ff_()) {
                string = resources.getString(2131237309, new Object[]{Integer.valueOf(videoTopicFragment.ff_())});
            } else {
                string = resources.getString(2131237308, new Object[]{Integer.valueOf(c)});
            }
            this.f2780p.setText(string);
            this.f2780p.setVisibility(0);
        }
        this.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TopicViewHolder f2773b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1592999159);
                if (this.f2773b.f2781q != null) {
                    DefaultTopicClickListener defaultTopicClickListener = this.f2773b.f2781q;
                    VideoTopicFragment videoTopicFragment = videoTopicFragment;
                    FullScreenVideoPlayerHost fullScreenVideoPlayerHost = (FullScreenVideoPlayerHost) ContextUtils.a((Context) Preconditions.checkNotNull(defaultTopicClickListener.f2763c), FullScreenVideoPlayerHost.class);
                    ChannelFeedHeaderParams a2 = defaultTopicClickListener.f2762b.m2265a(videoTopicFragment, defaultTopicClickListener.f2766f);
                    Builder a3 = new Builder().a(videoTopicFragment.b());
                    a3.h = EventTriggerType.BY_USER;
                    a3 = a3;
                    a3.d = EntryPointInputVideoChannelEntryPoint.VIDEO_HOME;
                    a3 = a3;
                    a3.g = defaultTopicClickListener.f2768h;
                    a3 = a3;
                    a3.k = a2;
                    defaultTopicClickListener.f2765e.a(fullScreenVideoPlayerHost, a3.a()).m2524a(new BaseChannelFeedLauncherInfo(null), new AtomicReference(defaultTopicClickListener.f2764d));
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1529303495, a);
            }
        });
        this.f2778n.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TopicViewHolder f2775b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1356398209);
                if (this.f2775b.f2781q != null) {
                    DefaultTopicClickListener defaultTopicClickListener = this.f2775b.f2781q;
                    VideoTopicFragment videoTopicFragment = videoTopicFragment;
                    defaultTopicClickListener.f2767g.a(VideoTopicFragmentModel.a(videoTopicFragment), videoTopicFragment.g() ? PinState.UNPINNED : PinState.PINNED, ChannelType.TOPICAL_LIVE_VIDEOS, defaultTopicClickListener.f2766f, defaultTopicClickListener.f2769i, defaultTopicClickListener.f2761a);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -276874461, a);
            }
        });
    }
}
