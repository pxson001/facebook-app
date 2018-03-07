package com.facebook.feedplugins.graphqlstory.footer.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.feedback.abtest.FeedDiscoveryExperimentUtil;
import com.facebook.feedplugins.graphqlstory.footer.FeedDiscoveryBlingBarPartDefinition$4;
import com.facebook.feedplugins.graphqlstory.footer.ui.FeedDiscoveryBlingBarAnimationController.FeedDiscoveryViewState;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.inject.FbInjector;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView.EntityListener;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ShowLiveCommentDialogFragment */
public abstract class BaseFeedDiscoveryBlingBarView extends CustomFrameLayout implements FeedDiscoveryBlingBar {
    @Inject
    public FeedDiscoveryExperimentUtil f23284a;
    public FeedDiscoveryBlingBarPartDefinition$4 f23285b = null;
    private final Handler f23286c = new Handler(Looper.getMainLooper());
    public View f23287d;
    public ViewStub f23288e;
    public FacepileView f23289f;
    public ViewStub f23290g;
    public TextWithEntitiesView f23291h;
    public ViewGroup f23292i;
    public FeedDiscoveryBlingBarAnimationController f23293j;
    public AnimationState f23294k = AnimationState.DISABLED;
    public Runnable f23295l;
    public Runnable f23296m;
    private final EntityListener f23297n = new C20131(this);

    /* compiled from: ShowLiveCommentDialogFragment */
    class C20131 implements EntityListener {
        final /* synthetic */ BaseFeedDiscoveryBlingBarView f23281a;

        C20131(BaseFeedDiscoveryBlingBarView baseFeedDiscoveryBlingBarView) {
            this.f23281a = baseFeedDiscoveryBlingBarView;
        }

        public final void mo1574a(Ranges ranges) {
        }
    }

    /* compiled from: ShowLiveCommentDialogFragment */
    public class C20142 implements Runnable {
        final /* synthetic */ BaseFeedDiscoveryBlingBarView f23282a;

        public C20142(BaseFeedDiscoveryBlingBarView baseFeedDiscoveryBlingBarView) {
            this.f23282a = baseFeedDiscoveryBlingBarView;
        }

        public void run() {
            if (this.f23282a.f23294k == AnimationState.DISABLED || this.f23282a.f23293j == null || this.f23282a.f23293j.f23303d == FeedDiscoveryViewState.SHOWING_REAL_TIME_ACTIVITY) {
                this.f23282a.m25662b(this.f23282a.f23284a.c());
            } else if (this.f23282a.f23293j.m25681c()) {
                this.f23282a.m25662b(this.f23282a.f23284a.c());
                if (this.f23282a.f23285b != null) {
                    FeedDiscoveryBlingBarPartDefinition$4 feedDiscoveryBlingBarPartDefinition$4 = this.f23282a.f23285b;
                    feedDiscoveryBlingBarPartDefinition$4.f23224c.b.b(feedDiscoveryBlingBarPartDefinition$4.f23222a);
                }
            } else {
                this.f23282a.m25659a(this.f23282a.f23284a.d());
            }
        }
    }

    /* compiled from: ShowLiveCommentDialogFragment */
    public class C20153 implements Runnable {
        final /* synthetic */ BaseFeedDiscoveryBlingBarView f23283a;

        public C20153(BaseFeedDiscoveryBlingBarView baseFeedDiscoveryBlingBarView) {
            this.f23283a = baseFeedDiscoveryBlingBarView;
        }

        public void run() {
            if (this.f23283a.f23294k != AnimationState.DISABLED && this.f23283a.f23293j != null && this.f23283a.f23293j.f23303d != FeedDiscoveryViewState.SHOWING_BLING_BAR) {
                if (!this.f23283a.f23293j.m25681c()) {
                    this.f23283a.m25662b(this.f23283a.f23284a.d());
                } else if (this.f23283a.f23285b != null) {
                    FeedDiscoveryBlingBarPartDefinition$4 feedDiscoveryBlingBarPartDefinition$4 = this.f23283a.f23285b;
                    feedDiscoveryBlingBarPartDefinition$4.f23224c.b.c(feedDiscoveryBlingBarPartDefinition$4.f23222a);
                    feedDiscoveryBlingBarPartDefinition$4.f23223b.f23226b = true;
                }
            }
        }
    }

    /* compiled from: ShowLiveCommentDialogFragment */
    public enum AnimationState {
        ENABLED,
        DISABLED
    }

    public static void m25661a(Object obj, Context context) {
        ((BaseFeedDiscoveryBlingBarView) obj).f23284a = FeedDiscoveryExperimentUtil.a(FbInjector.get(context));
    }

    public abstract int getLayout();

    public BaseFeedDiscoveryBlingBarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = BaseFeedDiscoveryBlingBarView.class;
        m25661a((Object) this, getContext());
        setContentView(getLayout());
        setClipChildren(false);
        this.f23287d = c(2131561892);
        this.f23292i = (ViewGroup) c(2131561891);
        this.f23288e = (ViewStub) c(2131561893);
        this.f23290g = (ViewStub) c(2131561894);
        this.f23295l = new C20142(this);
        this.f23296m = new C20153(this);
        mo1575a();
    }

    public final void mo1575a() {
        m25664j();
        this.f23287d.setAlpha(1.0f);
        this.f23287d.setTranslationY(0.0f);
    }

    public final void mo1576b() {
        m25664j();
        this.f23292i.setAlpha(1.0f);
        this.f23292i.setTranslationY(0.0f);
    }

    private void m25664j() {
        this.f23292i.setAlpha(0.0f);
        this.f23287d.setAlpha(0.0f);
    }

    public void setAnimationController(FeedDiscoveryBlingBarAnimationController feedDiscoveryBlingBarAnimationController) {
        this.f23293j = feedDiscoveryBlingBarAnimationController;
        FeedDiscoveryBlingBarAnimationController feedDiscoveryBlingBarAnimationController2 = this.f23293j;
        feedDiscoveryBlingBarAnimationController2.m25682d();
        feedDiscoveryBlingBarAnimationController2.f23312m = new WeakReference(this);
        feedDiscoveryBlingBarAnimationController2.m25680a(feedDiscoveryBlingBarAnimationController2.f23303d, true);
    }

    public final void mo1577e() {
        if (this.f23293j != null) {
            this.f23293j.m25682d();
        }
        this.f23293j = null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public final void mo1578f() {
        this.f23294k = AnimationState.ENABLED;
        m25659a(this.f23284a.d());
    }

    public final void mo1579g() {
        this.f23294k = AnimationState.ENABLED;
        m25662b(this.f23284a.d());
    }

    public final void mo1580h() {
        this.f23294k = AnimationState.DISABLED;
        HandlerDetour.a(this.f23286c, this.f23296m);
        HandlerDetour.a(this.f23286c, this.f23295l);
    }

    public void setAnimationEventListener(FeedDiscoveryBlingBarPartDefinition$4 feedDiscoveryBlingBarPartDefinition$4) {
        this.f23285b = feedDiscoveryBlingBarPartDefinition$4;
    }

    private void m25659a(int i) {
        HandlerDetour.a(this.f23286c, this.f23295l);
        HandlerDetour.b(this.f23286c, this.f23295l, (long) i, 2103964219);
    }

    private void m25662b(int i) {
        HandlerDetour.a(this.f23286c, this.f23296m);
        HandlerDetour.b(this.f23286c, this.f23296m, (long) i, -2143211096);
    }

    public void setAnimatorTargetToBlingBar(ObjectAnimator objectAnimator) {
        objectAnimator.setTarget(this.f23287d);
    }

    public void setAnimatorTargetToRealTimeActivity(ObjectAnimator objectAnimator) {
        objectAnimator.setTarget(this.f23292i);
    }

    public void setFacepileStrings(List<String> list) {
        if (this.f23289f == null) {
            this.f23289f = (FacepileView) this.f23288e.inflate();
        }
        this.f23289f.setFaceStrings(list);
    }

    public void setText(DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        if (this.f23291h == null) {
            this.f23291h = (TextWithEntitiesView) this.f23290g.inflate();
        }
        this.f23291h.m20239a(defaultTextWithEntitiesLongFields, this.f23297n);
    }
}
