package com.facebook.facecastdisplay;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.Interpolator;
import com.facebook.R;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.auth.annotations.ViewerContextUserId;
import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.common.internal.Preconditions;
import com.facebook.facecastdisplay.LiveEventsListAdapter.LiveEventsListAdapterListener;
import com.facebook.facecastdisplay.LiveEventsPillController.LiveEventsPillControllerListener;
import com.facebook.facecastdisplay.LiveVideoContextView.LiveVideoContextViewListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.widget.CustomRelativeLayout;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: store_conversion_v2 */
public class LiveEventsTickerView extends CustomRelativeLayout implements FacecastEventStoreListener, LiveEventsListAdapterListener {
    @Inject
    Lazy<LiveEventsStore> f3013a;
    @Inject
    Lazy<VodEventsStore> f3014b;
    @Inject
    LiveEventsPillControllerProvider f3015c;
    @Inject
    LiveEventsLogger f3016d;
    @Inject
    Lazy<GraphQLActorCache> f3017e;
    @Inject
    LiveEventsListAdapter f3018f;
    @Inject
    FacecastUtil f3019g;
    @Inject
    @ViewerContextUserId
    String f3020h;
    private final Interpolator f3021i;
    public final LiveEventsRecyclerView f3022j;
    public final View f3023k;
    private final View f3024l;
    public final LiveEventsPillController f3025m;
    public final ViewStub f3026n;
    private final ViewStub f3027o;
    @Nullable
    private FacecastEventsStore f3028p;
    @Nullable
    private String f3029q;
    @Nullable
    private GraphQLPage f3030r;
    @Nullable
    private LiveEventAuthor f3031s;
    @Nullable
    public LiveVideoContextView f3032t;
    @Nullable
    private LiveEventsCommentNuxView f3033u;
    @Nullable
    private Mode f3034v;
    public boolean f3035w;
    private boolean f3036x;
    public boolean f3037y;

    /* compiled from: store_conversion_v2 */
    class C02761 implements LiveEventsPillControllerListener {
        final /* synthetic */ LiveEventsTickerView f3008a;

        C02761(LiveEventsTickerView liveEventsTickerView) {
            this.f3008a = liveEventsTickerView;
        }

        public final void mo142a() {
            this.f3008a.f3022j.b(this.f3008a.f3018f.aZ_() - 1);
        }
    }

    /* compiled from: store_conversion_v2 */
    class C02772 extends OnScrollListener {
        final /* synthetic */ LiveEventsTickerView f3009a;

        C02772(LiveEventsTickerView liveEventsTickerView) {
            this.f3009a = liveEventsTickerView;
        }

        public final void m3276a(RecyclerView recyclerView, int i, int i2) {
            LiveEventsTickerView.m3290f(this.f3009a);
        }
    }

    /* compiled from: store_conversion_v2 */
    class C02783 extends AdapterDataObserver {
        final /* synthetic */ LiveEventsTickerView f3010a;

        C02783(LiveEventsTickerView liveEventsTickerView) {
            this.f3010a = liveEventsTickerView;
        }

        public final void m3277b(int i, int i2) {
            this.f3010a.f3026n.setVisibility(8);
            if (this.f3010a.f3022j.getLastCompletelyVisiblePosition() < i - 1 || this.f3010a.f3018f.m3228f()) {
                LiveEventModel liveEventModel;
                LiveEventsListAdapter liveEventsListAdapter = this.f3010a.f3018f;
                if (liveEventsListAdapter.f2938e.isEmpty()) {
                    liveEventModel = null;
                } else {
                    liveEventModel = (LiveEventModel) liveEventsListAdapter.f2938e.get(liveEventsListAdapter.f2938e.size() - 1);
                }
                LiveEventModel liveEventModel2 = liveEventModel;
                if (liveEventModel2 != null) {
                    this.f3010a.f3025m.m3244a(liveEventModel2);
                    return;
                }
                return;
            }
            this.f3010a.f3022j.a(this.f3010a.f3018f.aZ_() - 1);
        }

        public final void m3278c(int i, int i2) {
            if (this.f3010a.f3022j.getLastCompletelyVisiblePosition() == this.f3010a.f3018f.aZ_() - 1) {
                this.f3010a.f3023k.setVisibility(8);
                this.f3010a.f3025m.m3238b();
            }
        }
    }

    /* compiled from: store_conversion_v2 */
    class C02794 extends AnimatorListenerAdapter {
        final /* synthetic */ LiveEventsTickerView f3011a;

        C02794(LiveEventsTickerView liveEventsTickerView) {
            this.f3011a = liveEventsTickerView;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f3011a.f3035w) {
                this.f3011a.f3032t.setVisibility(8);
            }
        }
    }

    /* compiled from: store_conversion_v2 */
    class C02805 extends AnimatorListenerAdapter {
        final /* synthetic */ LiveEventsTickerView f3012a;

        C02805(LiveEventsTickerView liveEventsTickerView) {
            this.f3012a = liveEventsTickerView;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f3012a.f3035w) {
                this.f3012a.f3022j.setVisibility(8);
            }
        }
    }

    /* compiled from: store_conversion_v2 */
    public enum Mode {
        BROADCASTING,
        WATCHING_LIVE,
        WATCHING_VOD
    }

    private static <T extends View> void m3282a(Class<T> cls, T t) {
        m3283a((Object) t, t.getContext());
    }

    private static void m3283a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LiveEventsTickerView) obj).m3281a(IdBasedLazy.a(injectorLike, 5739), IdBasedLazy.a(injectorLike, 5742), (LiveEventsPillControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LiveEventsPillControllerProvider.class), LiveEventsLogger.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 262), LiveEventsListAdapter.m3217b(injectorLike), FacecastUtil.m3107b(injectorLike), String_ViewerContextUserIdMethodAutoProvider.b(injectorLike));
    }

    public LiveEventsTickerView(Context context) {
        this(context, null);
    }

    public LiveEventsTickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveEventsTickerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3021i = PathInterpolatorCompat.a(0.23f, 1.0f, 0.32f, 1.0f);
        m3282a(LiveEventsTickerView.class, (View) this);
        setContentView(2130905077);
        this.f3022j = (LiveEventsRecyclerView) findViewById(2131563470);
        this.f3023k = findViewById(2131563473);
        this.f3024l = findViewById(2131563472);
        ViewStub viewStub = (ViewStub) findViewById(2131563474);
        this.f3022j.setAdapter(this.f3018f);
        this.f3018f.f2943j = this;
        this.f3025m = this.f3015c.m3247a(viewStub, new C02761(this));
        m3290f(this);
        this.f3022j.setOnScrollListener(new C02772(this));
        this.f3018f.a(new C02783(this));
        this.f3026n = (ViewStub) findViewById(2131563471);
        this.f3027o = (ViewStub) a(2131563475);
    }

    public void setStoryForViewer(FeedProps<GraphQLStory> feedProps) {
        String str = null;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        GraphQLMedia r = StoryAttachmentHelper.o(graphQLStory).r();
        this.f3029q = r.b();
        this.f3030r = graphQLStory.l() != null ? graphQLStory.l().O() : null;
        m3286b(r.al());
        this.f3028p.mo139c(getViewerOrBroadcasterId());
        this.f3028p.mo136a(false);
        this.f3018f.f2936c.f2874c = new FeedbackLoggingParams(TrackableFeedProps.a(feedProps), "newsfeed_ufi", "video_fullscreen_player");
        LiveEventsListAdapter liveEventsListAdapter = this.f3018f;
        if (r.aF() != null) {
            str = r.aF().H();
        }
        liveEventsListAdapter.f2944k = str;
        this.f3034v = r.al() ? Mode.WATCHING_LIVE : Mode.WATCHING_VOD;
        this.f3018f.f2945l = this.f3034v;
        if (graphQLStory.l() != null) {
            this.f3028p.mo141e(graphQLStory.l().z_());
        }
    }

    public void setStoryForContext(FeedProps<GraphQLStory> feedProps) {
        if (this.f3019g.m3114j()) {
            m3280a((FeedProps) feedProps);
        }
    }

    private void m3280a(FeedProps<GraphQLStory> feedProps) {
        if (this.f3032t == null) {
            this.f3032t = (LiveVideoContextView) this.f3027o.inflate();
            this.f3032t.setVisibility(8);
        }
        this.f3032t.setMetadata(feedProps);
    }

    public final void m3299a(boolean z) {
        AnimatorListener animatorListener = null;
        float f = 0.0f;
        this.f3035w = z;
        if (this.f3032t != null) {
            float f2;
            AnimatorListener animatorListener2;
            if (z) {
                this.f3032t.setVisibility(0);
                this.f3032t.m22552a();
            }
            ViewPropertyAnimator animate = this.f3032t.animate();
            if (z) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            animate = animate.alpha(f2).setDuration(500).setInterpolator(this.f3021i);
            if (z) {
                animatorListener2 = null;
            } else {
                animatorListener2 = new C02794(this);
            }
            animate.setListener(animatorListener2).start();
        }
        if (this.f3036x) {
            if (!z) {
                this.f3022j.setVisibility(0);
            }
            ViewPropertyAnimator animate2 = this.f3022j.animate();
            if (!z) {
                f = 1.0f;
            }
            animate2 = animate2.alpha(f).setDuration(500).setInterpolator(this.f3021i);
            if (!z) {
                animatorListener = new C02805(this);
            }
            animate2.setListener(animatorListener).start();
        }
    }

    private void m3281a(Lazy<LiveEventsStore> lazy, Lazy<VodEventsStore> lazy2, LiveEventsPillControllerProvider liveEventsPillControllerProvider, LiveEventsLogger liveEventsLogger, Lazy<GraphQLActorCache> lazy3, LiveEventsListAdapter liveEventsListAdapter, FacecastUtil facecastUtil, String str) {
        this.f3013a = lazy;
        this.f3014b = lazy2;
        this.f3015c = liveEventsPillControllerProvider;
        this.f3016d = liveEventsLogger;
        this.f3017e = lazy3;
        this.f3018f = liveEventsListAdapter;
        this.f3019g = facecastUtil;
        this.f3020h = str;
    }

    public final void m3301c() {
        if (this.f3032t != null) {
            this.f3032t.animate().cancel();
            this.f3032t.setVisibility(8);
        }
        this.f3022j.animate().cancel();
        this.f3022j.setVisibility(0);
        this.f3022j.setAlpha(1.0f);
    }

    public void setVideoIdForBroadcaster(String str) {
        this.f3029q = str;
        this.f3034v = Mode.BROADCASTING;
        m3286b(true);
        this.f3028p.mo139c(this.f3020h);
        this.f3028p.mo136a(true);
        this.f3018f.f2944k = this.f3020h;
        this.f3018f.f2945l = Mode.BROADCASTING;
    }

    public void setListener(LiveVideoContextViewListener liveVideoContextViewListener) {
        if (this.f3032t != null) {
            this.f3032t.f18963k = liveVideoContextViewListener;
        }
    }

    public void setFullScreenMode(boolean z) {
        this.f3036x = z;
        this.f3022j.a();
        if (z) {
            this.f3024l.setVisibility(8);
            this.f3023k.setVisibility(8);
            this.f3022j.a(new LiveEventsOnScrollListener(this.f3022j.f2971h, TypedValue.applyDimension(1, 30.0f, getContext().getResources().getDisplayMetrics())));
        } else {
            this.f3024l.setVisibility(0);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.LiveEventsTickerView);
        int resourceId = obtainStyledAttributes.getResourceId(4, 0);
        obtainStyledAttributes.recycle();
        this.f3018f.f2948o = resourceId;
    }

    public final void m3302d() {
        Preconditions.a(this.f3028p);
        this.f3028p.mo135a(this.f3029q);
    }

    public final void m3303e() {
        Preconditions.a(this.f3028p);
        this.f3028p.mo132a();
        this.f3018f.m3227d();
        this.f3026n.setVisibility(8);
    }

    public void setSuspended(boolean z) {
        Preconditions.a(this.f3028p);
        this.f3028p.mo138b(z);
    }

    public void setVideoTime(float f) {
        if (this.f3028p != null) {
            this.f3028p.mo133a(f);
        }
    }

    public final void mo145a(String str) {
        Preconditions.a(this.f3028p);
        this.f3028p.mo140d(str);
    }

    public final void mo146a(List<LiveEventModel> list) {
        this.f3018f.m3226a((List) list);
    }

    public final void mo144a(LiveEventModel liveEventModel) {
        this.f3018f.m3224a(liveEventModel);
        this.f3016d.a(liveEventModel);
    }

    public final void mo143a() {
        this.f3018f.m3227d();
    }

    public final void mo147b() {
        if (!this.f3036x && this.f3018f.aZ_() == 0) {
            if (this.f3033u == null) {
                this.f3033u = (LiveEventsCommentNuxView) this.f3026n.inflate();
                this.f3033u.m3208a(this.f3034v, this.f3037y);
            }
            this.f3033u.setVisibility(0);
        }
    }

    public final void m3296a(String str, float f) {
        m3285b(str, (int) f, getViewerAsAuthor());
    }

    public final void m3297a(String str, int i, LiveEventAuthor liveEventAuthor) {
        m3285b(str, i, liveEventAuthor);
    }

    private void m3285b(String str, int i, LiveEventAuthor liveEventAuthor) {
        if (liveEventAuthor != null) {
            this.f3018f.m3224a(LiveCommentEventModel.m3146a(liveEventAuthor, str, i));
            Preconditions.a(this.f3028p);
            this.f3028p.mo137b(str);
        }
    }

    public void setIsReactionsEnabled(boolean z) {
        this.f3037y = z;
    }

    private void m3286b(boolean z) {
        if (z) {
            this.f3028p = (FacecastEventsStore) this.f3013a.get();
        } else {
            this.f3028p = (FacecastEventsStore) this.f3014b.get();
        }
        this.f3028p.mo134a((FacecastEventStoreListener) this);
    }

    public static void m3290f(LiveEventsTickerView liveEventsTickerView) {
        int i = 0;
        int i2 = liveEventsTickerView.f3018f.aZ_() == 0 ? 1 : 0;
        if (liveEventsTickerView.f3022j.getLastCompletelyVisiblePosition() == liveEventsTickerView.f3018f.aZ_() - 1 || i2 != 0) {
            liveEventsTickerView.f3023k.setVisibility(8);
            liveEventsTickerView.f3025m.m3238b();
        } else if (!liveEventsTickerView.f3036x) {
            liveEventsTickerView.f3023k.setVisibility(0);
        }
        if (!liveEventsTickerView.f3036x) {
            View view = liveEventsTickerView.f3024l;
            if (liveEventsTickerView.f3022j.getFirstCompletelyVisiblePosition() == 0 || i2 != 0) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    @Nullable
    private LiveEventAuthor getViewerAsAuthor() {
        if (this.f3031s == null) {
            if (this.f3030r != null) {
                GraphQLPage graphQLPage = this.f3030r;
                this.f3031s = new LiveEventAuthor(graphQLPage.aG(), graphQLPage.ae(), graphQLPage.au());
            } else {
                GraphQLActor a = ((GraphQLActorCacheImpl) this.f3017e.get()).a();
                if (a != null) {
                    this.f3031s = LiveEventAuthor.m3184a(a);
                }
            }
        }
        return this.f3031s;
    }

    @Nullable
    private String getViewerOrBroadcasterId() {
        if (this.f3030r != null) {
            return this.f3030r.ae();
        }
        GraphQLActor a = ((GraphQLActorCacheImpl) this.f3017e.get()).a();
        return a == null ? null : a.H();
    }
}
