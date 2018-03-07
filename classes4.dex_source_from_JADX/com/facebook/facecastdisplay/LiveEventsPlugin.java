package com.facebook.facecastdisplay;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPLimitAspectRatioEvent;
import com.facebook.video.player.events.RVPLiveReactionClickedEvent;
import com.facebook.video.player.events.RVPLiveVideoControlChangeHideTimeEvent;
import com.facebook.video.player.events.RVPLiveVideoControlChangeHideTimeEvent.Event;
import com.facebook.video.player.events.RVPOpenLiveTipJarEvent;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: platformurlversion */
public class LiveEventsPlugin extends RichVideoPlayerPlugin implements FacecastInteractionView$FacecastInteractionViewListener {
    @Inject
    public FacecastUtil f4501a;
    public final View f4502b;
    public final FacecastInteractionView f4503c;
    public final VideoTimeUpdateHandler f4504d;
    @Nullable
    private final Activity f4505l;
    public boolean f4506m;
    private boolean f4507n;
    @Nullable
    public String f4508o;
    private int f4509p;
    public boolean f4510q;
    @Nullable
    private String f4511r;
    @Nullable
    private String f4512s;

    public static void m5012a(Object obj, Context context) {
        ((LiveEventsPlugin) obj).f4501a = FacecastUtil.b(FbInjector.get(context));
    }

    @DoNotStrip
    public LiveEventsPlugin(Context context) {
        this(context, null);
    }

    private LiveEventsPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private LiveEventsPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905076);
        Class cls = LiveEventsPlugin.class;
        m5012a((Object) this, getContext());
        this.f4502b = findViewById(2131561611);
        this.f4503c = (FacecastInteractionView) m14861a(2131561606);
        this.f4504d = new VideoTimeUpdateHandler(this);
        this.f4505l = (Activity) ContextUtils.a(context, Activity.class);
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this));
        this.f14094f.add(new LiveVideoControlFadeSubscriber(this));
        this.f14094f.add(new CommercialBreakStateChangeEventSubscriber(this));
        this.f14094f.add(new OrientationChangedEventSubscriber(this));
    }

    protected final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (richVideoPlayerParams.f4963b != null && richVideoPlayerParams.f4963b.containsKey("GraphQLStoryProps") && (richVideoPlayerParams.f4963b.get("GraphQLStoryProps") instanceof FeedProps)) {
            if (z) {
                boolean z2;
                this.f4506m = richVideoPlayerParams.f4962a.f4839h;
                this.f4508o = richVideoPlayerParams.f4962a.f4833b;
                Double d = (Double) richVideoPlayerParams.f4963b.get("VideoAspectRatioKey");
                double doubleValue = d != null ? d.doubleValue() : 1.0d;
                if (doubleValue >= 1.1d) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f4507n = z2;
                if (this.f4501a.w() && richVideoPlayerParams.m5357b()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f4510q = z2;
                this.f4503c.setVideoAspectRatio(doubleValue);
                int i = this.f4510q ? 0 : 2131560327;
                LayoutParams layoutParams = (LayoutParams) this.f4502b.getLayoutParams();
                layoutParams.addRule(5, i);
                layoutParams.addRule(6, i);
                layoutParams.addRule(7, i);
                layoutParams.addRule(8, i);
                this.f4502b.setLayoutParams(layoutParams);
            }
            FeedProps feedProps = (FeedProps) richVideoPlayerParams.f4963b.get("GraphQLStoryProps");
            FeedProps feedProps2 = (FeedProps) richVideoPlayerParams.f4963b.get("InterstitialGraphQLStoryPropsKey");
            if (!(feedProps == null || StoryAttachmentHelper.o((GraphQLStory) feedProps.a) == null || StoryAttachmentHelper.o((GraphQLStory) feedProps.a).r() == null)) {
                this.f4503c.setVisibility(0);
                this.f4503c.setFullScreenMode(this.f4510q);
                String g = ((GraphQLStory) feedProps.a).g();
                if (g == null || !g.equals(this.f4511r)) {
                    this.f4503c.setStoryForViewer(feedProps);
                    this.f4503c.a();
                    this.f4511r = g;
                }
                if (feedProps2 == null) {
                    feedProps2 = feedProps;
                }
                String g2 = ((GraphQLStory) feedProps2.a).g();
                if (g2 == null || !g2.equals(this.f4512s)) {
                    this.f4503c.setStoryForContext(feedProps2);
                    this.f4512s = g2;
                }
                this.f4503c.setListener(this);
                m5018d();
            }
            if (z) {
                if (richVideoPlayerParams.f4963b.containsKey("ShowLiveCommentDialogFragment") && (richVideoPlayerParams.f4963b.get("ShowLiveCommentDialogFragment") instanceof Boolean) && ((Boolean) richVideoPlayerParams.f4963b.get("ShowLiveCommentDialogFragment")).booleanValue()) {
                    this.f4503c.c();
                }
                if (this.f4505l != null) {
                    this.f4509p = this.f4505l.getRequestedOrientation();
                    if (this.f4501a.s() && this.f4507n) {
                        this.f4505l.setRequestedOrientation(-1);
                    } else {
                        this.f4505l.setRequestedOrientation(1);
                    }
                }
                m5013c(this, getResources().getConfiguration().orientation);
            }
        }
    }

    protected final void mo378c() {
        this.f4504d.removeMessages(2);
        this.f4503c.b();
        this.f4503c.d();
        this.f4508o = null;
        if (this.f4505l != null) {
            this.f4505l.setRequestedOrientation(this.f4509p);
        }
        if (this.f14095g != null) {
            this.f14095g.m14878a(new RVPLimitAspectRatioEvent(-1.0d));
        }
        this.f4511r = null;
        this.f4512s = null;
    }

    public final void mo400a(int i, boolean z) {
        if (this.f14095g != null) {
            this.f14095g.m14878a(new RVPLiveReactionClickedEvent(i, z));
        }
    }

    public final void mo399a() {
        if (this.f14095g != null) {
            this.f14095g.m14878a(new RVPOpenLiveTipJarEvent());
        }
    }

    protected final void m5018d() {
        if (this.f14096h != null) {
            this.f4503c.setVideoTime(((float) (this.f4506m ? (long) this.f14096h.m5478g() : (long) this.f14096h.m5477f())) / 1000.0f);
        }
        this.f4504d.removeMessages(2);
        this.f4504d.sendEmptyMessageDelayed(2, 200);
    }

    public final void mo401e() {
        if (this.f14095g != null) {
            this.f14095g.m14878a(new RVPLiveVideoControlChangeHideTimeEvent(Event.STOP_HIDE));
        }
    }

    public final void mo402f() {
        if (this.f14095g != null && this.f14096h != null && !this.f14096h.m5483m()) {
            this.f14095g.m14878a(new RVPLiveVideoControlChangeHideTimeEvent(Event.REFRESH_HIDE));
        }
    }

    public static void m5013c(LiveEventsPlugin liveEventsPlugin, int i) {
        if (i == 2) {
            liveEventsPlugin.f4503c.setVisibility(8);
            if (liveEventsPlugin.f14095g != null) {
                liveEventsPlugin.f14095g.m14878a(new RVPLimitAspectRatioEvent(-1.0d));
                return;
            }
            return;
        }
        liveEventsPlugin.f4503c.setVisibility(0);
        if (liveEventsPlugin.f14095g == null) {
            return;
        }
        if (liveEventsPlugin.f4510q) {
            liveEventsPlugin.f14095g.m14878a(new RVPLimitAspectRatioEvent(-1.0d));
        } else {
            liveEventsPlugin.f14095g.m14878a(new RVPLimitAspectRatioEvent(1.0d));
        }
    }
}
