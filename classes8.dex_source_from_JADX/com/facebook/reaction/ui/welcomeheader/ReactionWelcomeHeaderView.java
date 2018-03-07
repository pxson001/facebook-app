package com.facebook.reaction.ui.welcomeheader;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.analytics.ReactionAnalytics.WelcomeHeaderInteractionType;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger.Event;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionPageFieldsWithPlaceTipsInfoModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipWelcomeHeaderFragmentModel;
import com.facebook.reaction.ui.recyclerview.ReactionContextItemsView;
import com.facebook.reaction.ui.recyclerview.ReactionContextItemsView.C22451;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.reaction.ui.welcomeheader.ReactionNuxView.C22581;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: Unable to find initial entity ID in current list! */
public class ReactionWelcomeHeaderView extends ReactionHeaderViewWithTouchDelegate {
    private static final CallerContext f21240b = CallerContext.a(ReactionWelcomeHeaderView.class, "reaction_dialog");
    private ReactionInteractionTracker f21241c;
    private boolean f21242d;
    public boolean f21243e = false;
    private ReactionPageFieldsWithPlaceTipsInfoModel f21244f;
    public boolean f21245g;
    private float f21246h;
    private PlaceTipWelcomeHeaderFragmentModel f21247i;
    private float f21248j;
    private float f21249k;
    private float f21250l;
    private float f21251m;
    private float f21252n;
    private float f21253o;
    private float f21254p;
    public ReactionWelcomeHeaderActionButtonsView f21255q;
    private LinearLayout f21256r;
    private FbDraweeView f21257s;
    private FbTextView f21258t;
    private FbTextView f21259u;
    private FbTextView f21260v;
    private Fragment f21261w;
    private Surface f21262x;

    /* compiled from: Unable to find initial entity ID in current list! */
    class C22661 implements OnClickListener {
        final /* synthetic */ ReactionWelcomeHeaderView f21238a;

        C22661(ReactionWelcomeHeaderView reactionWelcomeHeaderView) {
            this.f21238a = reactionWelcomeHeaderView;
        }

        public void onClick(View view) {
            boolean z;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1886306371);
            ReactionWelcomeHeaderView reactionWelcomeHeaderView = this.f21238a;
            if (this.f21238a.f21245g) {
                z = false;
            } else {
                z = true;
            }
            reactionWelcomeHeaderView.f21245g = z;
            if (this.f21238a.f21245g) {
                ReactionWelcomeHeaderView.m24869l(this.f21238a);
            } else {
                ReactionWelcomeHeaderView.m24868k(this.f21238a);
            }
            LogUtils.a(-219820964, a);
        }
    }

    /* compiled from: Unable to find initial entity ID in current list! */
    class C22672 implements AnimatorListener {
        final /* synthetic */ ReactionWelcomeHeaderView f21239a;

        C22672(ReactionWelcomeHeaderView reactionWelcomeHeaderView) {
            this.f21239a = reactionWelcomeHeaderView;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f21239a.f21255q.setVisibility(0);
            ReactionContextItemsView reactionContextItemsView = this.f21239a.f21177a;
            if (reactionContextItemsView.f21166d != null) {
                reactionContextItemsView.f21166d.setVisibility(8);
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public ReactionWelcomeHeaderView(Context context) {
        super(context);
        m24862e();
    }

    public ReactionWelcomeHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24862e();
    }

    private void m24862e() {
        setContentView(2130906723);
    }

    public static boolean m24854a(@Nullable PlaceTipWelcomeHeaderFragmentModel placeTipWelcomeHeaderFragmentModel) {
        return (placeTipWelcomeHeaderFragmentModel == null || placeTipWelcomeHeaderFragmentModel.c() == null || Strings.isNullOrEmpty(placeTipWelcomeHeaderFragmentModel.c().k()) || Strings.isNullOrEmpty(placeTipWelcomeHeaderFragmentModel.c().eG_())) ? false : true;
    }

    public final void m24871a(Fragment fragment, ReactionInteractionTracker reactionInteractionTracker, Surface surface, @Nullable PlaceTipWelcomeHeaderFragmentModel placeTipWelcomeHeaderFragmentModel) {
        Preconditions.checkArgument(m24854a(placeTipWelcomeHeaderFragmentModel));
        this.f21256r = (LinearLayout) findViewById(2131566793);
        this.f21262x = surface;
        this.f21261w = fragment;
        this.f21247i = placeTipWelcomeHeaderFragmentModel;
        this.f21241c = reactionInteractionTracker;
        this.f21244f = this.f21247i.c();
        this.f21243e = m24865h();
        boolean z = (this.f21244f.d() == null || this.f21244f.d().a().isEmpty()) ? false : true;
        this.f21242d = z;
        m24866i();
        m24867j();
        m24853a(this.f21261w, this.f21262x);
        m24864g();
        m24863f();
        ReactionInteractionTracker reactionInteractionTracker2 = this.f21241c;
        reactionInteractionTracker2.f16102g.f18800a.c(ReactionAnalyticsLogger.m22811a(Event.REACTION_HEADER_DISPLAYED, reactionInteractionTracker2.f16107l.f18658a, "reaction_overlay", reactionInteractionTracker2.f16107l.f18660c).b("place_id", this.f21244f.eG_()));
        this.f21249k = getResources().getDimension(2131431456);
        this.f21250l = getResources().getDimension(this.f21243e ? 2131431458 : 2131431457);
        this.f21251m = this.f21250l;
        if (this.f21242d) {
            this.f21248j = getResources().getDimension(this.f21243e ? 2131431455 : 2131431454);
        } else {
            this.f21248j = getResources().getDimension(this.f21243e ? 2131431453 : 2131431452);
        }
        this.f21252n = getResources().getDimension(this.f21243e ? 2131431460 : 2131431459);
        this.f21246h = getResources().getDimension(2131431463);
        this.f21253o = getResources().getDimension(2131431461);
        this.f21254p = getResources().getDimension(2131431462);
    }

    private void m24863f() {
        if (this.f21242d && this.f21177a != null) {
            if (this.f21258t == null) {
                this.f21258t = (FbTextView) ((ViewStub) findViewById(2131566796)).inflate();
            }
            this.f21245g = false;
            ReactionContextItemsView reactionContextItemsView = this.f21177a;
            ReactionPageFieldsWithPlaceTipsInfoModel reactionPageFieldsWithPlaceTipsInfoModel = this.f21244f;
            Fragment fragment = this.f21261w;
            Surface surface = this.f21262x;
            ReactionInteractionTracker reactionInteractionTracker = this.f21241c;
            reactionContextItemsView.f21169g = reactionPageFieldsWithPlaceTipsInfoModel;
            reactionContextItemsView.f21170h = fragment;
            reactionContextItemsView.f21171i = surface;
            reactionContextItemsView.f21172j = reactionInteractionTracker;
            this.f21258t.setOnClickListener(new C22661(this));
        } else if (this.f21258t != null) {
            this.f21258t.setVisibility(8);
        }
    }

    public int getContentViewHeight() {
        return this.f21256r == null ? 0 : this.f21256r.getMeasuredHeight();
    }

    public final boolean m24872b() {
        return this.f21243e;
    }

    public final void m24870a(float f) {
        m24852a(this.f21249k, f, this.f21255q);
        m24852a(this.f21250l, f, this.f21257s);
        m24852a(this.f21248j, f, this.f21259u);
        m24852a(this.f21248j, f, this.f21260v);
        if (this.f21242d) {
            m24852a(this.f21251m, f, this.f21258t);
        }
        this.f21256r.setScrollY((int) (m24851a(this.f21248j, f) * this.f21252n));
    }

    private static float m24851a(float f, float f2) {
        return Math.min(Math.max((-f2) / f, 0.0f), 1.0f);
    }

    private static void m24852a(float f, float f2, @Nullable View view) {
        if (view != null) {
            view.setAlpha(1.0f - m24851a(f, f2));
        }
    }

    private void m24864g() {
        String headerCoverPhotoUri = getHeaderCoverPhotoUri();
        if (!Strings.isNullOrEmpty(headerCoverPhotoUri)) {
            this.f21257s = (FbDraweeView) findViewById(2131566792);
            this.f21257s.a(Uri.parse(headerCoverPhotoUri), f21240b);
        }
    }

    private void m24853a(Fragment fragment, Surface surface) {
        this.f21255q = (ReactionWelcomeHeaderActionButtonsView) c(2131566797);
        this.f21255q.m24849a(this.f21244f, fragment, surface, this.f21241c, this.f21244f.g(), this.f21244f.m());
    }

    private boolean m24865h() {
        Object obj;
        PlaceTipWelcomeHeaderFragmentModel placeTipWelcomeHeaderFragmentModel = this.f21247i;
        if (placeTipWelcomeHeaderFragmentModel == null || placeTipWelcomeHeaderFragmentModel.a() == null || Strings.isNullOrEmpty(placeTipWelcomeHeaderFragmentModel.a().a()) || placeTipWelcomeHeaderFragmentModel.b() == null || Strings.isNullOrEmpty(placeTipWelcomeHeaderFragmentModel.b().a())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null || this.f21256r == null) {
            return false;
        }
        ReactionNuxView reactionNuxView = new ReactionNuxView(getContext());
        PlaceTipWelcomeHeaderFragmentModel placeTipWelcomeHeaderFragmentModel2 = this.f21247i;
        reactionNuxView.f21213c.setText(placeTipWelcomeHeaderFragmentModel2.a().a());
        reactionNuxView.f21214d.setText(placeTipWelcomeHeaderFragmentModel2.b().a());
        String a = reactionNuxView.f21212b.m3890a();
        if (Strings.isNullOrEmpty(a)) {
            reactionNuxView.f21215e.setVisibility(8);
        } else {
            reactionNuxView.f21215e.setOnClickListener(new C22581(reactionNuxView, a));
        }
        this.f21256r.addView(reactionNuxView, 0, new LayoutParams(-1, -2));
        this.f21256r.setPadding(this.f21256r.getPaddingLeft(), 0, this.f21256r.getPaddingRight(), this.f21256r.getPaddingBottom());
        return true;
    }

    private void m24866i() {
        this.f21260v = (FbTextView) findViewById(2131566794);
        this.f21260v.setText(this.f21244f.k());
    }

    private void m24867j() {
        this.f21259u = (FbTextView) findViewById(2131566795);
        if (this.f21247i.g() != null && !Strings.isNullOrEmpty(this.f21247i.g().a())) {
            this.f21259u.setText(this.f21247i.g().a());
        } else if (this.f21247i.d() != null && !Strings.isNullOrEmpty(this.f21247i.d().a())) {
            this.f21259u.setText(this.f21247i.d().a());
        }
    }

    @Nullable
    private String getHeaderCoverPhotoUri() {
        if (this.f21247i.fq_() != null && this.f21247i.fq_().g() != null && !Strings.isNullOrEmpty(this.f21247i.fq_().g().b())) {
            return this.f21247i.fq_().g().b();
        }
        if (this.f21244f == null || this.f21244f.eI_() == null || this.f21244f.eI_().a() == null || this.f21244f.eI_().a().a() == null) {
            return null;
        }
        return this.f21244f.eI_().a().a().b();
    }

    private void m24857b(float f) {
        this.f21260v.animate().translationY(f);
        this.f21259u.animate().translationY(f);
        this.f21258t.animate().translationY(f);
    }

    public static void m24868k(ReactionWelcomeHeaderView reactionWelcomeHeaderView) {
        reactionWelcomeHeaderView.f21241c.m18936a(reactionWelcomeHeaderView.f21244f.eG_(), WelcomeHeaderInteractionType.HEADER_SEE_LESS_TAP);
        if (reactionWelcomeHeaderView.f21177a != null) {
            ReactionContextItemsView reactionContextItemsView = reactionWelcomeHeaderView.f21177a;
            AnimatorListener c22672 = new C22672(reactionWelcomeHeaderView);
            reactionContextItemsView.f21168f = new AnimatorSet();
            int childCount = reactionContextItemsView.f21167e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = reactionContextItemsView.f21167e.getChildAt(i);
                Animator loadAnimator = AnimatorInflater.loadAnimator(reactionContextItemsView.getContext(), 2131034113);
                loadAnimator.addListener(new C22451(reactionContextItemsView, childAt));
                loadAnimator.setTarget(childAt);
                loadAnimator.setStartDelay((long) (((childCount - 1) - i) * 30));
                reactionContextItemsView.f21168f.play(loadAnimator);
            }
            reactionContextItemsView.f21168f.addListener(c22672);
            reactionContextItemsView.f21168f.start();
            reactionWelcomeHeaderView.f21258t.setText(2131237285);
            reactionWelcomeHeaderView.m24857b(0.0f);
            reactionWelcomeHeaderView.f21248j += reactionWelcomeHeaderView.f21253o;
            reactionWelcomeHeaderView.f21250l += reactionWelcomeHeaderView.f21253o;
            reactionWelcomeHeaderView.f21251m += reactionWelcomeHeaderView.f21254p;
        }
    }

    public static void m24869l(ReactionWelcomeHeaderView reactionWelcomeHeaderView) {
        reactionWelcomeHeaderView.f21241c.m18936a(reactionWelcomeHeaderView.f21244f.eG_(), WelcomeHeaderInteractionType.HEADER_SEE_MORE_TAP);
        if (reactionWelcomeHeaderView.f21177a != null) {
            reactionWelcomeHeaderView.f21177a.m24798a(reactionWelcomeHeaderView.f21255q.f21237o, reactionWelcomeHeaderView.f21255q.getFollowSubscribeStatus());
            reactionWelcomeHeaderView.f21258t.setText(2131237286);
            reactionWelcomeHeaderView.f21255q.setVisibility(8);
            reactionWelcomeHeaderView.m24857b(-1.0f * reactionWelcomeHeaderView.f21246h);
            reactionWelcomeHeaderView.f21248j -= reactionWelcomeHeaderView.f21253o;
            reactionWelcomeHeaderView.f21250l -= reactionWelcomeHeaderView.f21253o;
            reactionWelcomeHeaderView.f21251m -= reactionWelcomeHeaderView.f21254p;
        }
    }
}
