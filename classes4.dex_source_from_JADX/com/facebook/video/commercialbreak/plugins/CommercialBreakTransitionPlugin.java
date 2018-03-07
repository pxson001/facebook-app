package com.facebook.video.commercialbreak.plugins;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.event.FbEvent;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.video.util.RichVideoPlayerParamsUtil;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.commercialbreak.CommercialBreakInfoTracker;
import com.facebook.video.commercialbreak.abtest.CommercialBreakConfig;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent.State;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.StubbableRichVideoPlayerPlugin;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: platform */
public class CommercialBreakTransitionPlugin extends StubbableRichVideoPlayerPlugin {
    private static final String f4615d = CommercialBreakTransitionPlugin.class.getSimpleName();
    private static final CallerContext f4616l = CallerContext.a(CommercialBreakTransitionPlugin.class);
    @Inject
    public CommercialBreakConfig f4617b;
    @Inject
    public CommercialBreakInfoTracker f4618c;
    @Nullable
    private String f4619m;
    @Nullable
    public View f4620n;
    @Nullable
    private GraphQLActor f4621o;
    @Nullable
    private GraphQLMedia f4622p;
    @Nullable
    private FbDraweeView f4623q;
    @Nullable
    public FbDraweeView f4624r;
    @Nullable
    public TextView f4625s;
    @Nullable
    public FbTextView f4626t;
    @Nullable
    public FbTextView f4627u;
    @Nullable
    public LoadingIndicatorView f4628v;
    @Nullable
    public CommercialBreakStaticCountdownTimer f4629w;
    @Nullable
    public CommercialBreakTransitionAnimationTimer f4630x;

    /* compiled from: platform */
    class CommercialBreakStateChangeEventSubscriber extends RichVideoPlayerEventSubscriber<RVPCommercialBreakStateChangeEvent> {
        final /* synthetic */ CommercialBreakTransitionPlugin f4631a;

        public CommercialBreakStateChangeEventSubscriber(CommercialBreakTransitionPlugin commercialBreakTransitionPlugin) {
            this.f4631a = commercialBreakTransitionPlugin;
        }

        public final void m5118b(FbEvent fbEvent) {
            RVPCommercialBreakStateChangeEvent rVPCommercialBreakStateChangeEvent = (RVPCommercialBreakStateChangeEvent) fbEvent;
            CommercialBreakTransitionPlugin.m5108f(this.f4631a);
            CommercialBreakTransitionPlugin.m5102a(this.f4631a, rVPCommercialBreakStateChangeEvent.a, rVPCommercialBreakStateChangeEvent.b);
            switch (1.a[rVPCommercialBreakStateChangeEvent.a.ordinal()]) {
                case 1:
                    CommercialBreakTransitionPlugin.m5103a(this.f4631a, rVPCommercialBreakStateChangeEvent);
                    return;
                case 2:
                    CommercialBreakTransitionPlugin.m5109k(this.f4631a);
                    return;
                case 3:
                    CommercialBreakTransitionPlugin.m5101a(this.f4631a, rVPCommercialBreakStateChangeEvent.c.a);
                    return;
                case 4:
                case 5:
                    CommercialBreakTransitionPlugin.m5110l(this.f4631a);
                    return;
                default:
                    return;
            }
        }

        public final Class<RVPCommercialBreakStateChangeEvent> m5117a() {
            return RVPCommercialBreakStateChangeEvent.class;
        }
    }

    public static void m5104a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CommercialBreakTransitionPlugin commercialBreakTransitionPlugin = (CommercialBreakTransitionPlugin) obj;
        CommercialBreakConfig a = CommercialBreakConfig.m4866a(fbInjector);
        CommercialBreakInfoTracker a2 = CommercialBreakInfoTracker.m5025a(fbInjector);
        commercialBreakTransitionPlugin.f4617b = a;
        commercialBreakTransitionPlugin.f4618c = a2;
    }

    @DoNotStrip
    public CommercialBreakTransitionPlugin(Context context) {
        this(context, null);
    }

    private CommercialBreakTransitionPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CommercialBreakTransitionPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CommercialBreakTransitionPlugin.class;
        m5104a((Object) this, getContext());
        this.f14094f.add(new CommercialBreakStateChangeEventSubscriber(this));
    }

    protected final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        Integer.valueOf(System.identityHashCode(this));
        if (z && richVideoPlayerParams.f4962a.f4839h && this.f4617b.f4316a && richVideoPlayerParams.f4963b != null && richVideoPlayerParams.f4963b.containsKey("GraphQLStoryProps") && (richVideoPlayerParams.f4963b.get("GraphQLStoryProps") instanceof FeedProps)) {
            FeedProps feedProps = (FeedProps) richVideoPlayerParams.f4963b.get("GraphQLStoryProps");
            if (feedProps != null) {
                ImmutableList b = ((GraphQLStory) feedProps.a).b();
                if (!b.isEmpty()) {
                    this.f4621o = (GraphQLActor) b.get(0);
                }
            }
            this.f4622p = RichVideoPlayerParamsUtil.m5428a(richVideoPlayerParams);
            this.f4619m = richVideoPlayerParams.f4962a.f4833b;
            if (this.f4618c.m5033e(this.f4619m) == State.STATIC_COUNTDOWN && m14963d()) {
                m5108f(this);
                m5102a(this, State.STATIC_COUNTDOWN, State.TRANSITION);
                m5101a(this, this.f4618c.m5034h(this.f4619m) - this.f4617b.f4320e);
            }
        }
    }

    protected final void mo378c() {
        Integer.valueOf(System.identityHashCode(this));
        m5110l(this);
    }

    protected final boolean mo377a(RichVideoPlayerParams richVideoPlayerParams) {
        return true;
    }

    protected int getStubLayout() {
        return 2130903646;
    }

    protected int getLayoutToInflate() {
        return 2130903645;
    }

    protected void setupPlugin(RichVideoPlayerParams richVideoPlayerParams) {
    }

    protected void setupViews(View view) {
        Integer.valueOf(System.identityHashCode(this));
        this.f4620n = view.findViewById(2131559223);
        this.f4623q = (FbDraweeView) view.findViewById(2131560476);
        this.f4624r = (FbDraweeView) view.findViewById(2131559671);
        this.f4625s = (TextView) view.findViewById(2131558927);
        this.f4626t = (FbTextView) view.findViewById(2131560477);
        this.f4627u = (FbTextView) view.findViewById(2131560478);
        this.f4628v = (LoadingIndicatorView) view.findViewById(2131560479);
        m5108f(this);
    }

    public static void m5108f(CommercialBreakTransitionPlugin commercialBreakTransitionPlugin) {
        if (commercialBreakTransitionPlugin.f4623q != null && commercialBreakTransitionPlugin.f4624r != null && commercialBreakTransitionPlugin.f4625s != null) {
            if (commercialBreakTransitionPlugin.f4622p == null || commercialBreakTransitionPlugin.f4622p.bt() == null || commercialBreakTransitionPlugin.f4622p.bt().b() == null) {
                commercialBreakTransitionPlugin.f4623q.setVisibility(8);
            } else {
                commercialBreakTransitionPlugin.f4623q.a(Uri.parse(commercialBreakTransitionPlugin.f4622p.bt().b()), f4616l);
                commercialBreakTransitionPlugin.f4623q.setVisibility(0);
            }
            if (commercialBreakTransitionPlugin.f4621o == null || commercialBreakTransitionPlugin.f4621o.ai() == null || commercialBreakTransitionPlugin.f4621o.ai().b() == null) {
                commercialBreakTransitionPlugin.f4624r.setVisibility(8);
                return;
            }
            commercialBreakTransitionPlugin.f4624r.a(Uri.parse(commercialBreakTransitionPlugin.f4621o.ai().b()), f4616l);
            commercialBreakTransitionPlugin.f4624r.setVisibility(0);
            commercialBreakTransitionPlugin.f4625s.setText(commercialBreakTransitionPlugin.f4621o.aa());
            m5107e(commercialBreakTransitionPlugin.f4624r);
            m5107e(commercialBreakTransitionPlugin.f4625s);
        }
    }

    public static void m5102a(CommercialBreakTransitionPlugin commercialBreakTransitionPlugin, State state, State state2) {
        if (commercialBreakTransitionPlugin.f4626t != null) {
            switch (1.a[state.ordinal()]) {
                case 1:
                case 2:
                    if (state2 == State.LIVE || state2 == State.TRANSITION) {
                        commercialBreakTransitionPlugin.f4626t.setText(commercialBreakTransitionPlugin.getResources().getString(2131232843));
                        m5107e(commercialBreakTransitionPlugin.f4626t);
                        return;
                    }
                    commercialBreakTransitionPlugin.f4626t.setText(commercialBreakTransitionPlugin.getResources().getString(2131232845));
                    m5107e(commercialBreakTransitionPlugin.f4626t);
                    return;
                case 3:
                    commercialBreakTransitionPlugin.f4626t.setText(commercialBreakTransitionPlugin.getResources().getString(2131232844));
                    return;
                default:
                    return;
            }
        }
    }

    public static void m5103a(CommercialBreakTransitionPlugin commercialBreakTransitionPlugin, RVPCommercialBreakStateChangeEvent rVPCommercialBreakStateChangeEvent) {
        commercialBreakTransitionPlugin.m5111m();
        commercialBreakTransitionPlugin.m5112p();
        if (rVPCommercialBreakStateChangeEvent.c.b) {
            commercialBreakTransitionPlugin.f4630x = new CommercialBreakTransitionAnimationTimer(commercialBreakTransitionPlugin, rVPCommercialBreakStateChangeEvent.c.c - 500);
            commercialBreakTransitionPlugin.f4630x.start();
        }
    }

    public static void m5109k(CommercialBreakTransitionPlugin commercialBreakTransitionPlugin) {
        commercialBreakTransitionPlugin.m5111m();
        commercialBreakTransitionPlugin.m5112p();
        if (commercialBreakTransitionPlugin.m14963d() && commercialBreakTransitionPlugin.f4628v != null) {
            commercialBreakTransitionPlugin.f4628v.a();
            LoadingIndicatorView loadingIndicatorView = commercialBreakTransitionPlugin.f4628v;
            loadingIndicatorView.setAlpha(0.0f);
            loadingIndicatorView.setScaleX(0.5f);
            loadingIndicatorView.setScaleY(0.5f);
            loadingIndicatorView.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(500);
        }
    }

    public static void m5101a(CommercialBreakTransitionPlugin commercialBreakTransitionPlugin, long j) {
        commercialBreakTransitionPlugin.m5111m();
        commercialBreakTransitionPlugin.m5113r();
        m5100a(commercialBreakTransitionPlugin.f4624r);
        m5100a(commercialBreakTransitionPlugin.f4625s);
        m5100a(commercialBreakTransitionPlugin.f4626t);
        if (commercialBreakTransitionPlugin.m14963d() && commercialBreakTransitionPlugin.f4627u != null) {
            commercialBreakTransitionPlugin.f4627u.setVisibility(0);
        }
        if (commercialBreakTransitionPlugin.m14963d()) {
            if (commercialBreakTransitionPlugin.f4629w != null) {
                commercialBreakTransitionPlugin.f4629w.cancel();
            }
            commercialBreakTransitionPlugin.f4629w = new CommercialBreakStaticCountdownTimer(commercialBreakTransitionPlugin, j);
            commercialBreakTransitionPlugin.f4629w.start();
            if (commercialBreakTransitionPlugin.f4627u != null) {
                commercialBreakTransitionPlugin.f4627u.setAlpha(0.0f);
            }
            commercialBreakTransitionPlugin.f4627u.animate().alpha(1.0f).setDuration(500);
        }
    }

    private void m5111m() {
        if (m14963d() && this.f4620n != null && this.f4620n != null) {
            this.f4620n.setVisibility(0);
            this.f4620n.bringToFront();
        }
    }

    public static void m5110l(CommercialBreakTransitionPlugin commercialBreakTransitionPlugin) {
        if (!(!commercialBreakTransitionPlugin.m14963d() || commercialBreakTransitionPlugin.f4620n == null || commercialBreakTransitionPlugin.f4620n == null)) {
            commercialBreakTransitionPlugin.f4620n.setVisibility(8);
        }
        commercialBreakTransitionPlugin.m5112p();
        if (commercialBreakTransitionPlugin.f4629w != null) {
            commercialBreakTransitionPlugin.f4629w.cancel();
        }
        if (commercialBreakTransitionPlugin.f4630x != null) {
            commercialBreakTransitionPlugin.f4630x.cancel();
        }
        commercialBreakTransitionPlugin.m5113r();
    }

    private void m5112p() {
        if (m14963d() && this.f4627u != null) {
            this.f4627u.setVisibility(8);
        }
    }

    private void m5113r() {
        if (m14963d() && this.f4628v != null && this.f4628v.f()) {
            this.f4628v.b();
            m5106d(this.f4628v);
        }
    }

    public static void m5100a(View view) {
        view.animate().translationY(-50.0f).setDuration(500);
    }

    public static void m5105b(View view) {
        view.animate().translationY(50.0f).setDuration(500);
    }

    public static void m5106d(View view) {
        view.animate().alpha(0.0f).setDuration(300);
    }

    private static void m5107e(View view) {
        view.setAlpha(0.0f);
        view.setScaleX(0.5f);
        view.setScaleY(0.5f);
        view.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(500);
    }
}
