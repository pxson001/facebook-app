package com.facebook.entitycards.intent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.AccessibilityManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.device.ScreenUtil;
import com.facebook.entitycards.EntityCardsAdapter;
import com.facebook.entitycards.analytics.EntityCardConfigurationSequenceLogger;
import com.facebook.entitycards.analytics.EntityCardConfigurationSequenceLoggerProvider;
import com.facebook.entitycards.analytics.EntityCardsAnalytics.DismissalReason;
import com.facebook.entitycards.analytics.EntityCardsAnalytics.Events;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLoggerProvider;
import com.facebook.entitycards.analytics.EntityCardsImpressionLogger;
import com.facebook.entitycards.analytics.EntityCardsImpressionLoggerProvider;
import com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger;
import com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger.Event;
import com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger.Span;
import com.facebook.entitycards.analytics.EntityCardsPerfLogger;
import com.facebook.entitycards.analytics.EntityCardsPerfLoggerProvider;
import com.facebook.entitycards.analytics.EntityCardsScrollTTITrackerProvider;
import com.facebook.entitycards.controller.EntityCardsController;
import com.facebook.entitycards.controller.EntityCardsControllerProvider;
import com.facebook.entitycards.model.EntityCardsDataSource;
import com.facebook.entitycards.model.EntityCardsDataSource.State;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycards.model.event.EntityModelCollectionChangedEvent;
import com.facebook.entitycards.model.event.EntityModelCollectionChangedEventSubscriber;
import com.facebook.entitycards.view.EntityCardDimensionsHelper;
import com.facebook.entitycardsplugins.person.surface.BasePersonCardsSurfaceConfiguration;
import com.facebook.fbui.draggable.Direction;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout.AnimationListener;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout.OnDismissListener;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout.OnResetListener;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.widget.text.SimpleVariableTextLayoutView;
import com.facebook.widget.viewpager.CompositeOnPageChangeListener;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: image_optimization_enabled */
public class EntityCardsFragment extends FbFragment implements AnalyticsActivity {
    public static final CallerContext f10974a = CallerContext.a(EntityCardsFragment.class, "entity_cards");
    private Optional<String> aA;
    private String aB;
    private int aC;
    public DismissalReason aD;
    private boolean aE = false;
    public boolean aF = false;
    private IntroAnimationState aG = IntroAnimationState.UNINITIALIZED;
    private EntityCardsDatasourceEventBus aH;
    public FbEventSubscriberListManager aI = new FbEventSubscriberListManager();
    public EntityModelCollectionChangedEventSubscriber aJ;
    public CompositeOnPageChangeListener aK;
    private OnPageChangeListener aL;
    public EntityCardsAnalyticsLogger aM;
    private EntityCardsPerfLogger aN;
    private EntityCardsImpressionLogger aO;
    private FrameRateLogger aP;
    public FrameRateLogger aQ;
    private EntityCardConfigurationSequenceLogger aR;
    @Inject
    DefaultUserInteractionController al;
    @Inject
    EntityCardsInitialCardsSequenceLogger am;
    @Inject
    EntityCardConfigurationSequenceLoggerProvider an;
    @Inject
    FrameRateLoggerProvider ao;
    @Inject
    public ScreenUtil ap;
    @Inject
    RecyclableViewPoolManager aq;
    private final C11761 ar = new C11761(this);
    public DismissibleFrameLayout as;
    @Nullable
    public ViewPager at;
    private SimpleVariableTextLayoutView au;
    public View av;
    public EntityCardsAdapter aw;
    private EntityCardsController ax;
    public EntityCardsDataSource ay;
    private String az;
    @Inject
    public AccessibilityManager f10975b;
    @Inject
    EntityCardsControllerProvider f10976c;
    @Inject
    EntityCardsImpressionLoggerProvider f10977d;
    @Inject
    EntityCardsPerfLoggerProvider f10978e;
    @Inject
    EntityCardsAnalyticsLoggerProvider f10979f;
    @Inject
    EntityCardsScrollTTITrackerProvider f10980g;
    @Inject
    public EntityCardDimensionsHelper f10981h;
    @Inject
    EntityCardsIntentReader f10982i;

    /* compiled from: image_optimization_enabled */
    public class C11761 {
        public final /* synthetic */ EntityCardsFragment f10965a;

        C11761(EntityCardsFragment entityCardsFragment) {
            this.f10965a = entityCardsFragment;
        }
    }

    /* compiled from: image_optimization_enabled */
    class C11772 extends SimpleOnPageChangeListener {
        final /* synthetic */ EntityCardsFragment f10966a;

        C11772(EntityCardsFragment entityCardsFragment) {
            this.f10966a = entityCardsFragment;
        }

        public final void m12898b(int i) {
            if (i == 1) {
                this.f10966a.aQ.a();
            } else if (i == 0) {
                this.f10966a.aQ.b();
            }
        }
    }

    /* compiled from: image_optimization_enabled */
    class C11783 extends EntityModelCollectionChangedEventSubscriber {
        final /* synthetic */ EntityCardsFragment f10967a;

        C11783(EntityCardsFragment entityCardsFragment) {
            this.f10967a = entityCardsFragment;
        }

        public final void m12899b(FbEvent fbEvent) {
            EntityModelCollectionChangedEvent entityModelCollectionChangedEvent = (EntityModelCollectionChangedEvent) fbEvent;
            if (entityModelCollectionChangedEvent.f11084b == State.UNINITIALIZED && entityModelCollectionChangedEvent.f11085c != State.UNINITIALIZED && this.f10967a.at != null && this.f10967a.ay != null) {
                EntityCardsFragment.m12908a(this.f10967a, this.f10967a.ay);
            }
        }
    }

    /* compiled from: image_optimization_enabled */
    class C11794 implements FutureCallback<Void> {
        final /* synthetic */ EntityCardsFragment f10968a;

        C11794(EntityCardsFragment entityCardsFragment) {
            this.f10968a = entityCardsFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f10968a.am.m12819b(Span.INITIAL_ENTITIES_FETCHED);
            this.f10968a.aF = true;
            EntityCardsFragment.aq(this.f10968a);
        }

        public void onFailure(Throwable th) {
            this.f10968a.am.m12820c(Span.INITIAL_ENTITIES_FETCHED);
            this.f10968a.aF = true;
        }
    }

    /* compiled from: image_optimization_enabled */
    class C11805 implements OnDismissListener {
        final /* synthetic */ EntityCardsFragment f10969a;

        C11805(EntityCardsFragment entityCardsFragment) {
            this.f10969a = entityCardsFragment;
        }

        public final void m12900b() {
            EntityCardsFragment entityCardsFragment = this.f10969a;
        }

        public final void m12901c() {
            EntityCardsFragment entityCardsFragment = this.f10969a;
            if (entityCardsFragment.aD == null) {
                entityCardsFragment.aD = DismissalReason.SWIPE_DOWN;
            }
            entityCardsFragment.aM.m12793a(entityCardsFragment.aD);
            if (entityCardsFragment.av != null) {
                EntityCardsFragment.m12907a(entityCardsFragment, 1.0f);
                entityCardsFragment.av.setVisibility(8);
            }
            entityCardsFragment.as.setVisibility(8);
            Activity ao = entityCardsFragment.ao();
            if (ao != null) {
                Intent intent = new Intent();
                intent.putExtra("entity_cards_visible_id", entityCardsFragment.aw.m12775f());
                ao.setResult(-1, intent);
                ao.finish();
            }
        }
    }

    /* compiled from: image_optimization_enabled */
    class C11816 implements OnResetListener {
        final /* synthetic */ EntityCardsFragment f10970a;

        C11816(EntityCardsFragment entityCardsFragment) {
            this.f10970a = entityCardsFragment;
        }

        public final void m12902d() {
            EntityCardsFragment.av(this.f10970a);
        }
    }

    /* compiled from: image_optimization_enabled */
    class C11827 implements AnimationListener {
        final /* synthetic */ EntityCardsFragment f10971a;

        C11827(EntityCardsFragment entityCardsFragment) {
            this.f10971a = entityCardsFragment;
        }

        public final void m12903a(float f, float f2) {
            EntityCardsFragment.m12907a(this.f10971a, f != 0.0f ? Math.abs(f) : Math.abs(f2));
        }
    }

    /* compiled from: image_optimization_enabled */
    public class C11838 implements Runnable {
        final /* synthetic */ EntityCardsFragment f10972a;

        public C11838(EntityCardsFragment entityCardsFragment) {
            this.f10972a = entityCardsFragment;
        }

        public void run() {
            this.f10972a.m12917e();
        }
    }

    /* compiled from: image_optimization_enabled */
    public class C11849 extends SimpleOnGestureListener {
        final /* synthetic */ EntityCardsFragment f10973a;

        public C11849(EntityCardsFragment entityCardsFragment) {
            this.f10973a = entityCardsFragment;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            this.f10973a.m12915a(true, DismissalReason.PAGER_TAP);
            return false;
        }
    }

    /* compiled from: image_optimization_enabled */
    enum IntroAnimationState {
        UNINITIALIZED,
        OPENING,
        IDLE,
        CLOSING
    }

    private static <T extends InjectableComponentWithContext> void m12909a(Class<T> cls, T t) {
        m12910a((Object) t, t.getContext());
    }

    private static void m12910a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EntityCardsFragment) obj).m12905a(AccessibilityManagerMethodAutoProvider.b(injectorLike), (EntityCardsControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EntityCardsControllerProvider.class), (EntityCardsImpressionLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EntityCardsImpressionLoggerProvider.class), (EntityCardsPerfLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EntityCardsPerfLoggerProvider.class), (EntityCardsAnalyticsLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EntityCardsAnalyticsLoggerProvider.class), (EntityCardsScrollTTITrackerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EntityCardsScrollTTITrackerProvider.class), EntityCardDimensionsHelper.m13043a(injectorLike), EntityCardsIntentReader.m12924a(injectorLike), DefaultUserInteractionController.a(injectorLike), EntityCardsInitialCardsSequenceLogger.m12807a(injectorLike), (EntityCardConfigurationSequenceLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EntityCardConfigurationSequenceLoggerProvider.class), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), ScreenUtil.a(injectorLike), RecyclableViewPoolManager.a(injectorLike));
    }

    private void m12905a(AccessibilityManager accessibilityManager, EntityCardsControllerProvider entityCardsControllerProvider, EntityCardsImpressionLoggerProvider entityCardsImpressionLoggerProvider, EntityCardsPerfLoggerProvider entityCardsPerfLoggerProvider, EntityCardsAnalyticsLoggerProvider entityCardsAnalyticsLoggerProvider, EntityCardsScrollTTITrackerProvider entityCardsScrollTTITrackerProvider, EntityCardDimensionsHelper entityCardDimensionsHelper, EntityCardsIntentReader entityCardsIntentReader, DefaultUserInteractionController defaultUserInteractionController, EntityCardsInitialCardsSequenceLogger entityCardsInitialCardsSequenceLogger, EntityCardConfigurationSequenceLoggerProvider entityCardConfigurationSequenceLoggerProvider, FrameRateLoggerProvider frameRateLoggerProvider, ScreenUtil screenUtil, RecyclableViewPoolManager recyclableViewPoolManager) {
        this.f10975b = accessibilityManager;
        this.f10976c = entityCardsControllerProvider;
        this.f10977d = entityCardsImpressionLoggerProvider;
        this.f10978e = entityCardsPerfLoggerProvider;
        this.f10979f = entityCardsAnalyticsLoggerProvider;
        this.f10980g = entityCardsScrollTTITrackerProvider;
        this.f10981h = entityCardDimensionsHelper;
        this.f10982i = entityCardsIntentReader;
        this.al = defaultUserInteractionController;
        this.am = entityCardsInitialCardsSequenceLogger;
        this.an = entityCardConfigurationSequenceLoggerProvider;
        this.ao = frameRateLoggerProvider;
        this.ap = screenUtil;
        this.aq = recyclableViewPoolManager;
    }

    public final void m12916c(@Nullable Bundle bundle) {
        Preconditions.checkState(getContext() instanceof EntityCardsActivity);
        super.c(bundle);
        m12909a(EntityCardsFragment.class, (InjectableComponentWithContext) this);
        if (bundle == null && D()) {
            this.am.m12817a(Span.FRAGMENT_CREATE);
        }
        EntityCardsParameters a = EntityCardsIntentReader.m12925a(mt_());
        BasePersonCardsSurfaceConfiguration a2 = this.f10982i.m12932a(a.f11005a);
        this.az = a2.mo833a();
        this.aA = a.f11006b;
        this.aB = a.f11009e;
        this.aC = a2.m13237d();
        Bundle a3 = this.f10982i.m12931a(mt_(), bundle);
        this.aN = this.f10978e.m12830a(this.aB, this.az, this.aA);
        Object string = a3 != null ? a3.getString("friending_location") : null;
        if (StringUtil.a(string)) {
            string = null;
        } else {
            string = FriendingLocation.valueOf(string);
        }
        this.aM = this.f10979f.m12800a(this.aB, this.az, this.aA, Optional.fromNullable(string));
        ImmutableList b = EntityCardsIntentReader.m12927b(mt_(), bundle);
        this.aM.m12792a(this.am);
        String c = EntityCardsIntentReader.m12929c(mt_(), bundle);
        E();
        this.ay = (EntityCardsDataSource) Preconditions.checkNotNull(a2.m13233a(b, c, this.aM, this.aN, f10974a, a3));
        this.aO = this.f10977d.m12806a(this.aM, this.ay);
        String a4 = this.aM.m12789a();
        this.aP = this.ao.a(Boolean.valueOf(false), "ec_intro_animation", Optional.of(a4));
        this.ax = this.f10976c.m12890a(this.aq, a2.mo834b());
        this.aw = this.ay.mo777a(this.aM, this.ax, this.ay, this.ar, EntityCardsScrollTTITrackerProvider.m12834a(this.aN), LayoutInflater.from(getContext()), this.aq, Integer.valueOf(this.aC), a3);
        this.aR = this.an.m12784a(this.aw, this.aB, this.az, this.aA, b);
        this.aM.m12792a(this.aR);
        this.aQ = this.ao.a(Boolean.valueOf(false), "ec_scroll_animation", Optional.of(a4));
        this.aL = new C11772(this);
        this.aK = new CompositeOnPageChangeListener(ImmutableList.of(this.aw, this.aO, this.aL, this.aR));
        this.aH = this.ay.mo775a();
        this.aJ = new C11783(this);
        ar();
        this.aI.a(this.aH);
        this.am.m12817a(Span.INITIAL_ENTITIES_FETCHED);
        Futures.a(this.ay.mo782e(), new C11794(this), MoreExecutors.a());
    }

    public final View m12914a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1848483570);
        View inflate = layoutInflater.inflate(2130903984, viewGroup, false);
        this.as = (DismissibleFrameLayout) FindViewUtil.b(inflate, 2131561197);
        this.as.e = new C11805(this);
        this.as.f = new C11816(this);
        this.as.g = new C11827(this);
        this.av = FindViewUtil.b(inflate, 2131561195);
        m12904a(inflate, EntityCardsIntentReader.m12928b(this.s), this.aC);
        int i = this.au.getLayoutParams().height;
        this.at = (ViewPager) FindViewUtil.b(inflate, 2131561198);
        this.at.setOnPageChangeListener(this.aK);
        this.at.post(new C11838(this));
        LayoutParams layoutParams = (LayoutParams) this.at.getLayoutParams();
        if (this.f10975b.isEnabled()) {
            layoutParams.setMargins(0, i, 0, 0);
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
            final GestureDetector gestureDetector = new GestureDetector(getContext(), new C11849(this));
            this.at.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ EntityCardsFragment f10964b;

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
            });
        }
        this.at.setLayoutParams(layoutParams);
        this.at.setPageMargin(jW_().getDimensionPixelSize(2131433153));
        this.at.setOffscreenPageLimit(1);
        this.at.setAdapter((PagerAdapter) this.aw);
        if (this.ay.mo787j()) {
            m12908a(this, this.ay);
        }
        this.aE = true;
        aq(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 260447019, a);
        return inflate;
    }

    public static void m12907a(EntityCardsFragment entityCardsFragment, float f) {
        if (entityCardsFragment.at()) {
            if (entityCardsFragment.av != null) {
                entityCardsFragment.av.setAlpha((-f) + 1.0f);
            }
            if (entityCardsFragment.au != null) {
                entityCardsFragment.au.setAlpha((-Math.min(1.0f, 6.0f * f)) + 1.0f);
            }
        }
    }

    public final void m12911G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1735769091);
        super.G();
        if (this.aO != null) {
            this.aO.m12804b();
        }
        if (this.am != null) {
            this.am.m12819b(Span.FRAGMENT_CREATE);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1955001066, a);
    }

    public final void m12918e(Bundle bundle) {
        super.e(bundle);
        String f = this.aw.m12775f();
        if (f != null) {
            bundle.putParcelable("entity_cards_fragment_parameters", new EntityCardsParameters(this.az, this.aA, this.ay.mo784g(), f, this.aB, EntityCardsIntentReader.m12928b(this.s)));
            Optional h = this.ay.mo785h();
            if (h.isPresent()) {
                bundle.putParcelable("entity_cards_config_extras", (Parcelable) h.get());
            }
        }
    }

    public final void m12912H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1528721231);
        super.H();
        this.aP.b();
        this.aQ.b();
        if (this.aO != null) {
            this.aO.m12803a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1002967049, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -923415550);
        super.mY_();
        if (this.at != null) {
            this.at.setOnPageChangeListener(null);
            this.at.setAdapter(null);
            this.at = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2107410406, a);
    }

    public final void m12913I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -291008457);
        super.I();
        if (this.ay != null) {
            this.ay.mo783f();
        }
        this.aM.m12799b(this.am);
        this.aM.m12799b(this.aR);
        this.aI.b(this.aH);
        this.aI.b(this.aJ);
        EntityCardsAdapter entityCardsAdapter = this.aw;
        entityCardsAdapter.f10849l.b(entityCardsAdapter.f10850m);
        entityCardsAdapter.f10849l.b(entityCardsAdapter.f10848k);
        entityCardsAdapter.f10850m = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -78497247, a);
    }

    public final String am_() {
        return "entity_cards";
    }

    public static void m12908a(EntityCardsFragment entityCardsFragment, EntityCardsDataSource entityCardsDataSource) {
        int i = entityCardsDataSource.mo786i();
        entityCardsFragment.aO.m12805c(i);
        entityCardsFragment.at.a(i, false);
        entityCardsFragment.aR.e_(i);
    }

    public static void aq(EntityCardsFragment entityCardsFragment) {
        if (entityCardsFragment.aF && entityCardsFragment.aE) {
            entityCardsFragment.aM.m12794a(Events.ENTITY_CARDS_DISPLAYED, (Optional) Absent.INSTANCE);
        }
    }

    private void ar() {
        Preconditions.checkNotNull(this.aJ);
        this.aI.a(this.aJ);
    }

    public final void m12917e() {
        if (this.aG == IntroAnimationState.UNINITIALIZED) {
            m12906a(IntroAnimationState.OPENING);
            this.aP.a();
            this.as.l = false;
            this.as.setVisibility(0);
            this.av.setVisibility(0);
            m12907a(this, 1.0f);
            this.am.m12817a(Span.INTRO_ANIMATION);
            this.as.scrollTo(0, (-this.as.getHeight()) + 1);
            this.as.a(true);
        }
    }

    public final void m12915a(boolean z, DismissalReason dismissalReason) {
        if (this.aG != IntroAnimationState.CLOSING && this.aG != IntroAnimationState.OPENING && at()) {
            m12906a(IntroAnimationState.CLOSING);
            m12907a(this, 0.0f);
            this.aD = dismissalReason;
            this.as.a(Direction.DOWN, z);
        }
    }

    private void m12906a(IntroAnimationState introAnimationState) {
        this.aG = introAnimationState;
        if (introAnimationState == IntroAnimationState.OPENING || introAnimationState == IntroAnimationState.CLOSING) {
            this.al.a(this.at);
        } else {
            this.al.b(this.at);
        }
    }

    private boolean at() {
        return this.as != null && this.as.getVisibility() == 0;
    }

    private void au() {
        if (this.at != null && this.as != null && this.am != null) {
            if (this.aP.q) {
                this.aP.b();
            }
            m12907a(this, 0.0f);
            this.as.l = true;
            m12906a(IntroAnimationState.IDLE);
            this.at.setOffscreenPageLimit(2);
            this.am.m12816a(Event.INTRO_ANIMATION_END);
        }
    }

    public static void av(EntityCardsFragment entityCardsFragment) {
        if (entityCardsFragment.aG == IntroAnimationState.OPENING) {
            entityCardsFragment.au();
            entityCardsFragment.am.m12819b(Span.INTRO_ANIMATION);
        }
        if (entityCardsFragment.aG == IntroAnimationState.CLOSING) {
            entityCardsFragment.au();
        }
    }

    private void m12904a(View view, @Nullable String str, int i) {
        this.au = (SimpleVariableTextLayoutView) FindViewUtil.b(view, 2131561196);
        LayoutParams layoutParams = (LayoutParams) this.au.getLayoutParams();
        if (str != null) {
            Object obj;
            EntityCardDimensionsHelper entityCardDimensionsHelper = this.f10981h;
            if (this.ap.g() > ((entityCardDimensionsHelper.f11109b.getDimensionPixelSize(2131433156) + (entityCardDimensionsHelper.f11109b.getDimensionPixelSize(2131433156) * 2)) + i) + jW_().getDimensionPixelSize(2131433155)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                layoutParams.height = ((this.ap.g() - jW_().getDimensionPixelSize(2131433155)) - i) / 2;
                this.au.setText(str);
                return;
            }
        }
        layoutParams.height = 0;
    }
}
