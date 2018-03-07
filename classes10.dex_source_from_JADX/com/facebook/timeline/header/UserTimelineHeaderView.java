package com.facebook.timeline.header;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.feed.inlinecomposer.InlineComposerFooterView;
import com.facebook.feed.inlinecomposer.model.InlineComposerFooterState;
import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.inlinecomposer.model.InlineComposerModelBuilder;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.contextual.ContextItemsRenderingStyle;
import com.facebook.timeline.contextual.TimelineContextItemsData;
import com.facebook.timeline.contextual.TimelineContextualInfoAdapter;
import com.facebook.timeline.contextual.TimelineContextualInfoAdapterProvider;
import com.facebook.timeline.contextual.TimelineContextualInfoData;
import com.facebook.timeline.data.NeedsFragmentCleanup;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.header.controllers.TimelineBioNuxController;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController;
import com.facebook.timeline.header.data.TimelineHeaderData.GetNotifiedState;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.ui.PlutoniumFriendRequestView;
import com.facebook.timeline.header.util.TimelineHeaderViewHelper;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.facebook.timeline.ui.common.InlineComposerHeaderView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.User;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.IViewAttachAware;
import com.facebook.widget.LazyView;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: forward_longclick */
public class UserTimelineHeaderView extends CustomLinearLayout implements NeedsFragmentCleanup, IViewAttachAware {
    @Inject
    ProfileControllerDelegate f11564a;
    @Inject
    TimelineContextualInfoAdapterProvider f11565b;
    @Inject
    public QeAccessor f11566c;
    @Inject
    public TimelineBioNuxController f11567d;
    @Inject
    Provider<TimelineHeaderComposerBinder> f11568e;
    @Inject
    TimelineHeaderViewController f11569f;
    @Inject
    TimelinePerformanceLogger f11570g;
    protected int f11571h;
    public final TimelineContextItemsSection f11572i;
    private final LazyView<InlineComposerHeaderView> f11573j;
    private final LazyView<InlineComposerFooterView> f11574k;
    private final Optional<LazyView<PlutoniumFriendRequestView>> f11575l;
    private final LazyView<TimelineGetNotifiedView> f11576m;
    private ProfileViewerContext f11577n;
    public TimelineUserContext f11578o;
    public TimelineHeaderUserData f11579p;
    private TimelineTaggedMediaSetData f11580q;
    public TimelineContextualInfoData f11581r;
    private int f11582s = -1;
    private int f11583t = -1;
    public boolean f11584u;
    private TimelineContextualInfoAdapter f11585v;
    private final OnClickListener f11586w = new C16611(this);

    /* compiled from: forward_longclick */
    class C16611 implements OnClickListener {
        final /* synthetic */ UserTimelineHeaderView f11562a;

        C16611(UserTimelineHeaderView userTimelineHeaderView) {
            this.f11562a = userTimelineHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1319513967);
            TimelineHeaderDataLogger f = this.f11562a.f11564a.mo471f();
            f.f11370e.k(f.f11368c, f.f11367b);
            this.f11562a.f11570g.c.f("TimelineGetNotifiedButtonClick");
            this.f11562a.f11579p.a(GetNotifiedState.GET_NOTIFIED);
            this.f11562a.f11564a.mq_();
            this.f11562a.f11564a.mo_();
            Logger.a(2, EntryType.UI_INPUT_END, -1946817464, a);
        }
    }

    /* compiled from: forward_longclick */
    class C16622 implements OnClickListener {
        final /* synthetic */ UserTimelineHeaderView f11563a;

        C16622(UserTimelineHeaderView userTimelineHeaderView) {
            this.f11563a = userTimelineHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1025991484);
            if (this.f11563a.f11566c.a(ExperimentsForTimelineAbTestModule.aj, false)) {
                this.f11563a.f11581r.m10468a((TimelineContextItemsData) this.f11563a.f11581r.a().get(), 2);
                UserTimelineHeaderView.m11594j(this.f11563a);
            } else {
                this.f11563a.f11564a.mo482r().mo503a();
            }
            LogUtils.a(631034277, a);
        }
    }

    public static void m11587a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((UserTimelineHeaderView) obj).m11586a(ProfileControllerDelegate.m10751a(injectorLike), (TimelineContextualInfoAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineContextualInfoAdapterProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), TimelineBioNuxController.m11672a(injectorLike), IdBasedProvider.a(injectorLike, 11251), TimelineHeaderViewController.m11687b(injectorLike), TimelinePerformanceLogger.a(injectorLike));
    }

    public UserTimelineHeaderView(Context context) {
        super(context);
        Class cls = UserTimelineHeaderView.class;
        m11587a(this, getContext());
        setBackgroundColor(-1);
        this.f11570g.c.a("TimelineInflateHeader");
        setContentView(2130907631);
        this.f11570g.c.b("TimelineInflateHeader");
        this.f11572i = (TimelineContextItemsSection) a(2131568243);
        this.f11573j = new LazyView((ViewStub) a(2131568239));
        this.f11574k = new LazyView((ViewStub) a(2131568241));
        Optional b = b(2131568238);
        if (b.isPresent()) {
            this.f11575l = Optional.of(new LazyView((ViewStub) b.get()));
        } else {
            this.f11575l = Absent.INSTANCE;
        }
        b = b(2131568244);
        if (b.isPresent()) {
            this.f11576m = new LazyView((ViewStub) b.get());
        } else {
            this.f11576m = null;
        }
        setOrientation(1);
        this.f11571h = context.getResources().getConfiguration().orientation;
    }

    public final boolean m11595a() {
        return this.f11584u;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1985188859);
        super.onAttachedToWindow();
        this.f11584u = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1108240655, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -80071049);
        super.onDetachedFromWindow();
        this.f11584u = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1231999238, a);
    }

    public final boolean m11596a(TimelineUserContext timelineUserContext, TimelineHeaderUserData timelineHeaderUserData, TimelineTaggedMediaSetData timelineTaggedMediaSetData, TimelineContextualInfoData timelineContextualInfoData) {
        TracerDetour.a("UserTimelineHeaderView.bindModel", 2069666641);
        try {
            boolean b = m11588b(timelineUserContext, timelineHeaderUserData, timelineTaggedMediaSetData, timelineContextualInfoData);
            return b;
        } finally {
            TracerDetour.a(-1121483458);
        }
    }

    private boolean m11588b(TimelineUserContext timelineUserContext, TimelineHeaderUserData timelineHeaderUserData, TimelineTaggedMediaSetData timelineTaggedMediaSetData, TimelineContextualInfoData timelineContextualInfoData) {
        if (timelineHeaderUserData == null) {
            return false;
        }
        boolean z = this.f11579p != timelineHeaderUserData;
        this.f11578o = timelineUserContext;
        this.f11577n = new ProfileViewerContext(this.f11578o.b, this.f11578o.f());
        this.f11579p = timelineHeaderUserData;
        this.f11580q = timelineTaggedMediaSetData;
        this.f11581r = timelineContextualInfoData;
        int i = getContext().getResources().getConfiguration().orientation;
        if (z || this.f11571h != i || this.f11582s < this.f11579p.c) {
            this.f11571h = i;
            if (!this.f11579p.j()) {
                this.f11570g.r();
            }
            m11589e();
            m11592h();
            if (m11590f()) {
                m11591g();
            }
            m11593i();
            if (!this.f11579p.j()) {
                this.f11570g.s();
            }
            this.f11582s = this.f11579p.c;
            if (this.f11579p.j()) {
                return false;
            }
            return true;
        } else if (this.f11583t >= this.f11581r.a) {
            return false;
        } else {
            m11592h();
            this.f11583t = this.f11581r.a;
            return false;
        }
    }

    private void m11589e() {
        if (this.f11576m != null) {
            boolean z = false;
            if (this.f11566c.a(ExperimentsForTimelineAbTestModule.ap, false) && this.f11579p.g != GetNotifiedState.NOT_SHOWN) {
                z = true;
            }
            if (z) {
                TimelineGetNotifiedView timelineGetNotifiedView = (TimelineGetNotifiedView) this.f11576m.a();
                if (this.f11579p.g == GetNotifiedState.ASK) {
                    timelineGetNotifiedView.setButtonStateToAsk(this.f11586w);
                } else {
                    timelineGetNotifiedView.m11410a();
                }
                timelineGetNotifiedView.setVisibility(0);
                TimelineHeaderDataLogger f = this.f11564a.mo471f();
                if (!f.f11388w) {
                    f.f11388w = true;
                    f.f11370e.j(f.f11368c, f.f11367b);
                }
                TimelinePerformanceLogger timelinePerformanceLogger = this.f11570g;
                if (!timelinePerformanceLogger.v) {
                    timelinePerformanceLogger.v = true;
                }
                timelinePerformanceLogger.c.f("TimelineGetNotifiedButtonImpression");
                return;
            }
            this.f11576m.c();
        }
    }

    private boolean m11590f() {
        return !this.f11579p.j() && TimelineHeaderViewHelper.a(this.f11578o, this.f11579p.T()) && this.f11566c.a(ExperimentsForTimelineAbTestModule.G, false);
    }

    private void m11591g() {
        InlineComposerModel a;
        TimelineHeaderComposerBinder timelineHeaderComposerBinder = (TimelineHeaderComposerBinder) this.f11568e.get();
        InlineComposerHeaderView inlineComposerHeaderView = (InlineComposerHeaderView) this.f11573j.a();
        InlineComposerFooterView inlineComposerFooterView = (InlineComposerFooterView) this.f11574k.a();
        boolean i = this.f11578o.i();
        Resources resources = inlineComposerHeaderView.getResources();
        User user;
        InlineComposerModelBuilder inlineComposerModelBuilder;
        InlineComposerModelBuilder inlineComposerModelBuilder2;
        if (i) {
            user = (User) timelineHeaderComposerBinder.f11357a.get();
            inlineComposerModelBuilder = new InlineComposerModelBuilder(user.a, user.x());
            inlineComposerModelBuilder.i = resources.getString(2131234528);
            inlineComposerModelBuilder2 = inlineComposerModelBuilder;
            inlineComposerModelBuilder2.f = resources.getString(2131234879);
            inlineComposerModelBuilder2 = inlineComposerModelBuilder2;
            inlineComposerModelBuilder2.g = resources.getString(2131234840);
            inlineComposerModelBuilder2 = inlineComposerModelBuilder2;
            inlineComposerModelBuilder2.h = resources.getString(2131234881);
            inlineComposerModelBuilder2 = inlineComposerModelBuilder2;
            inlineComposerModelBuilder2.e = 2130841040;
            inlineComposerModelBuilder2 = inlineComposerModelBuilder2;
            inlineComposerModelBuilder2.k = true;
            a = inlineComposerModelBuilder2.a();
        } else {
            user = (User) timelineHeaderComposerBinder.f11357a.get();
            inlineComposerModelBuilder = new InlineComposerModelBuilder(user.a, user.x());
            inlineComposerModelBuilder.i = resources.getString(2131234538);
            inlineComposerModelBuilder2 = inlineComposerModelBuilder;
            inlineComposerModelBuilder2.f = resources.getString(2131234876);
            inlineComposerModelBuilder2 = inlineComposerModelBuilder2;
            inlineComposerModelBuilder2.g = resources.getString(2131234842);
            inlineComposerModelBuilder2 = inlineComposerModelBuilder2;
            inlineComposerModelBuilder2.k = false;
            a = inlineComposerModelBuilder2.a();
        }
        inlineComposerHeaderView.setComposerHintText(a.l);
        inlineComposerHeaderView.a(a.b);
        inlineComposerHeaderView.setHeaderSectionOnClickListener(timelineHeaderComposerBinder.f11359c.m12488a());
        inlineComposerHeaderView.setProfileImageOnClickListener(timelineHeaderComposerBinder.f11359c.m12489a(a.a));
        InlineComposerFooterState a2 = InlineComposerFooterState.a(inlineComposerFooterView.getResources(), a, timelineHeaderComposerBinder.f11358b);
        inlineComposerFooterView.setCheckinButtonVisibility(i ? 0 : 8);
        inlineComposerFooterView.setCheckinButtonDrawable(a2.d);
        inlineComposerFooterView.a(a2.b, a2.a, a2.c);
        inlineComposerFooterView.setCheckinButtonOnClickListener(i ? timelineHeaderComposerBinder.f11359c.m12491c() : null);
        inlineComposerFooterView.setStatusButtonOnClickListener(timelineHeaderComposerBinder.f11359c.m12488a());
        inlineComposerFooterView.setPhotoButtonOnClickListener(timelineHeaderComposerBinder.f11359c.m12490b());
    }

    public final void m11597c() {
        this.f11572i.removeAllViews();
        this.f11581r = null;
        this.f11579p = null;
        this.f11578o = null;
        this.f11577n = null;
    }

    private void m11593i() {
        if (!this.f11575l.isPresent()) {
            return;
        }
        if (this.f11579p.B() == GraphQLFriendshipStatus.INCOMING_REQUEST) {
            ((PlutoniumFriendRequestView) ((LazyView) this.f11575l.get()).a()).m12042a(this.f11579p, this.f11578o);
        } else if (this.f11579p.B() == GraphQLFriendshipStatus.CAN_REQUEST && FriendRequestMakeRef.isProfileShareMakeRef(this.f11578o.a)) {
            ((PlutoniumFriendRequestView) ((LazyView) this.f11575l.get()).a()).m12043a(this.f11579p, this.f11578o, true);
        } else if (((LazyView) this.f11575l.get()).b()) {
            ((PlutoniumFriendRequestView) ((LazyView) this.f11575l.get()).a()).setVisibility(8);
        }
    }

    public static void m11594j(UserTimelineHeaderView userTimelineHeaderView) {
        ContextItemsRenderingStyle contextItemsRenderingStyle;
        if (userTimelineHeaderView.f11566c.a(ExperimentsForTimelineAbTestModule.X, false)) {
            contextItemsRenderingStyle = ContextItemsRenderingStyle.INTRO_CARD_CONTEXT_ITEMS_STYLE;
        } else {
            contextItemsRenderingStyle = ContextItemsRenderingStyle.PROTILE_STYLE;
        }
        if (userTimelineHeaderView.f11585v == null) {
            userTimelineHeaderView.f11585v = userTimelineHeaderView.f11565b.m10456a(userTimelineHeaderView.f11578o, userTimelineHeaderView.f11581r, contextItemsRenderingStyle, new C16622(userTimelineHeaderView), null);
        }
        userTimelineHeaderView.f11572i.setAdapter(userTimelineHeaderView.f11585v);
    }

    private void m11586a(ProfileControllerDelegate profileControllerDelegate, TimelineContextualInfoAdapterProvider timelineContextualInfoAdapterProvider, QeAccessor qeAccessor, TimelineBioNuxController timelineBioNuxController, Provider<TimelineHeaderComposerBinder> provider, TimelineHeaderViewController timelineHeaderViewController, TimelinePerformanceLogger timelinePerformanceLogger) {
        this.f11564a = profileControllerDelegate;
        this.f11565b = timelineContextualInfoAdapterProvider;
        this.f11566c = qeAccessor;
        this.f11567d = timelineBioNuxController;
        this.f11568e = provider;
        this.f11569f = timelineHeaderViewController;
        this.f11570g = timelinePerformanceLogger;
    }

    private void m11592h() {
        Object obj;
        if (1 == 0 || !this.f11567d.m11674a(this.f11578o, this.f11579p)) {
            obj = null;
        } else {
            obj = 1;
        }
        Object obj2 = obj;
        TimelineHeaderViewController timelineHeaderViewController = this.f11569f;
        TimelineHeaderUserData timelineHeaderUserData = this.f11579p;
        TimelineUserContext timelineUserContext = this.f11578o;
        boolean z = true;
        boolean a = timelineHeaderViewController.f11641a.a(ExperimentsForTimelineAbTestModule.ae, false);
        boolean z2 = (timelineUserContext.i() || timelineHeaderUserData.B() == GraphQLFriendshipStatus.ARE_FRIENDS) ? false : true;
        if (z2 && a) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (obj2 != null || timelineHeaderViewController.f11641a.a(ExperimentsForTimelineAbTestModule.ah, false) || r6) {
            z = false;
        }
        if (z) {
            m11594j(this);
        } else {
            this.f11572i.setVisibility(8);
        }
    }

    public TimelineHeaderUserData getHeaderData() {
        return this.f11579p;
    }
}
