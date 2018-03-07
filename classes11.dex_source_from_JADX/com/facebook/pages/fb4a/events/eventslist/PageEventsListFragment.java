package com.facebook.pages.fb4a.events.eventslist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.device.ScreenUtil;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.create.EventCreationNikumanActivity;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventCreatedEvent;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.events.mutators.SubscribeToPageEventsMutator;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.calls.ProfileSetEventsCalendarSubscriptionStatusInputData.SubscriptionStatus;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.EventsSubscribeStatusChangedEvent;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.fb4a.abtest.qe.ExperimentsForPagesFb4aAbTestModule;
import com.facebook.pages.fb4a.events.eventslist.PageEventsListAdapter.Section;
import com.facebook.pages.fb4a.events.eventslist.PageEventsListAdapter.SectionType;
import com.facebook.pages.fb4a.events.eventslist.PageEventsListPager.C04116;
import com.facebook.pages.fb4a.events.eventslist.PageEventsListPager.C04127;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: progressViewOffset */
public class PageEventsListFragment extends FbFragment implements AnalyticsFragment, PagesSurfaceTabFragment {
    public static final int[] aR = new int[2];
    @Inject
    FbTitleBarSupplier f2978a;
    private View aA;
    private FbTextView aB;
    private FbButton aC;
    private Resources aD;
    private LinearLayout aE;
    public BetterListView aF;
    private MetricAffectingSpan aG;
    private MetricAffectingSpan aH;
    public EmptyListViewItem aI;
    private ReactionHeaderTouchDelegateView aJ;
    private ReactionHeaderViewWithTouchDelegate aK;
    public View aL;
    public PagesSurfaceFragment aM;
    private boolean aN = false;
    public int aO;
    private int aP;
    private int aQ = -1;
    public boolean aS = false;
    public int aT = -1;
    @Inject
    SecureContextHelper al;
    @Inject
    EventsEventBus am;
    private final EventCreatedEventSubscriber an = new EventCreatedEventSubscriber(this);
    public String ao;
    public boolean ap = true;
    private boolean aq = false;
    public long ar;
    private String as;
    public GraphQLEventsCalendarSubscriptionStatus at;
    public int au;
    public EventType av;
    public PageEventsListAdapter aw;
    public EventAnalyticsParams ax;
    @Nullable
    public List<String> ay;
    public boolean az;
    @Inject
    PageEventsListAdapterProvider f2979b;
    @Inject
    public PageEventsListPager f2980c;
    @Inject
    NumberTruncationUtil f2981d;
    @Inject
    PageScopedEventBus f2982e;
    @Inject
    EventGraphQLModelHelper f2983f;
    @Inject
    SubscribeToPageEventsMutator f2984g;
    @Inject
    ScreenUtil f2985h;
    @Inject
    QeAccessor f2986i;

    /* compiled from: progressViewOffset */
    class C03991 implements OnScrollListener {
        final /* synthetic */ PageEventsListFragment f2969a;

        C03991(PageEventsListFragment pageEventsListFragment) {
            this.f2969a = pageEventsListFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 > i3 - 3 && this.f2969a.ap) {
                PageEventsListFragment.m3994a(this.f2969a, false);
            }
            int count = this.f2969a.aF.getAdapter() != null ? this.f2969a.aF.getAdapter().getCount() : 0;
            if (!(this.f2969a.aS && this.f2969a.aT == count)) {
                Pair a = PagesScrollUtils.a(this.f2969a.aL, this.f2969a.aF, i, PageEventsListFragment.aR, this.f2969a.f2985h.d());
                this.f2969a.aS = ((Boolean) a.a).booleanValue();
                if (this.f2969a.aS) {
                    this.f2969a.E_(((Integer) a.b).intValue());
                    this.f2969a.aT = count;
                }
            }
            int top = this.f2969a.aF.getChildAt(0).getTop();
            if (this.f2969a.aM != null && this.f2969a.aF != null && this.f2969a.aO != top && this.f2969a.D()) {
                this.f2969a.aM.m5039a(this.f2969a.aF, i);
                this.f2969a.aO = top;
            }
        }
    }

    /* compiled from: progressViewOffset */
    class C04002 implements OnClickListener {
        final /* synthetic */ PageEventsListFragment f2970a;

        C04002(PageEventsListFragment pageEventsListFragment) {
            this.f2970a = pageEventsListFragment;
        }

        public void onClick(View view) {
            SubscriptionStatus subscriptionStatus;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -197933077);
            if (this.f2970a.at == GraphQLEventsCalendarSubscriptionStatus.NONE) {
                subscriptionStatus = SubscriptionStatus.LOCAL;
                this.f2970a.at = GraphQLEventsCalendarSubscriptionStatus.LOCAL;
            } else {
                subscriptionStatus = SubscriptionStatus.NONE;
                this.f2970a.at = GraphQLEventsCalendarSubscriptionStatus.NONE;
            }
            this.f2970a.f2984g.a(String.valueOf(this.f2970a.ar), subscriptionStatus, ActionMechanism.PAGE_EVENT_LIST_SUBSCRIBE_BUTTON, this.f2970a.ax, null);
            PageEventsListFragment.ar(this.f2970a);
            this.f2970a.f2982e.a(new EventsSubscribeStatusChangedEvent(Long.valueOf(this.f2970a.ar), this.f2970a.at));
            LogUtils.a(738548347, a);
        }
    }

    /* compiled from: progressViewOffset */
    public class C04024 {
        final /* synthetic */ PageEventsListFragment f2973a;

        C04024(PageEventsListFragment pageEventsListFragment) {
            this.f2973a = pageEventsListFragment;
        }

        public final void m3987a(List<EventCommonFragmentModel> list, String str, boolean z) {
            if (this.f2973a.aF != null) {
                PageEventsListFragment.m3993a(this.f2973a, (List) list, SectionType.PAST);
                this.f2973a.ao = str;
                if (!z || str == null) {
                    this.f2973a.ap = false;
                    this.f2973a.aI.setVisibility(8);
                }
            }
        }
    }

    /* compiled from: progressViewOffset */
    class C04035 implements Function<EventCommonFragmentModel, Event> {
        final /* synthetic */ PageEventsListFragment f2974a;

        C04035(PageEventsListFragment pageEventsListFragment) {
            this.f2974a = pageEventsListFragment;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            EventCommonFragmentModel eventCommonFragmentModel = (EventCommonFragmentModel) obj;
            if (eventCommonFragmentModel == null) {
                return null;
            }
            EventGraphQLModelHelper eventGraphQLModelHelper = this.f2974a.f2983f;
            return EventGraphQLModelHelper.b(eventCommonFragmentModel);
        }
    }

    /* compiled from: progressViewOffset */
    public class C04046 {
        final /* synthetic */ PageEventsListFragment f2975a;

        C04046(PageEventsListFragment pageEventsListFragment) {
            this.f2975a = pageEventsListFragment;
        }

        public final void m3988a(List<EventCommonFragmentModel> list) {
            PageEventsListFragment.m3993a(this.f2975a, (List) list, SectionType.NEW);
        }
    }

    /* compiled from: progressViewOffset */
    class C04057 implements OnClickListener {
        final /* synthetic */ PageEventsListFragment f2976a;

        C04057(PageEventsListFragment pageEventsListFragment) {
            this.f2976a = pageEventsListFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -744538583);
            this.f2976a.al.a(EventCreationNikumanActivity.a(this.f2976a.getContext(), this.f2976a.am_(), ActionMechanism.EVENTS_LIST, Long.valueOf(this.f2976a.ar)), this.f2976a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1853302477, a);
        }
    }

    /* compiled from: progressViewOffset */
    class EventCreatedEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventCreatedEventSubscriber {
        final /* synthetic */ PageEventsListFragment f2977a;

        public EventCreatedEventSubscriber(PageEventsListFragment pageEventsListFragment) {
            this.f2977a = pageEventsListFragment;
        }

        public final void m3989b(FbEvent fbEvent) {
            if (((EventCreatedEvent) fbEvent).a != null) {
                this.f2977a.ay = Arrays.asList(new String[]{r5.a});
                PageEventsListFragment.at(this.f2977a);
            }
        }
    }

    /* compiled from: progressViewOffset */
    enum EventType {
        UPCOMING,
        PAST
    }

    public static void m3996a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageEventsListFragment) obj).m3995a((FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector), (PageEventsListAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PageEventsListAdapterProvider.class), PageEventsListPager.m4012b(fbInjector), NumberTruncationUtil.a(fbInjector), PageScopedEventBus.a(fbInjector), EventGraphQLModelHelper.a(fbInjector), SubscribeToPageEventsMutator.b(fbInjector), ScreenUtil.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), EventsEventBus.a(fbInjector));
    }

    public final String am_() {
        return "page_events_list";
    }

    public final void m4003c(Bundle bundle) {
        super.c(bundle);
        Class cls = PageEventsListFragment.class;
        m3996a((Object) this, getContext());
        this.ar = this.s.getLong("com.facebook.katana.profile.id");
        this.as = this.s.getString("extra_page_name");
        this.ay = this.s.getStringArrayList("event_id");
        this.aD = jW_();
        this.av = EventType.UPCOMING;
        String string = this.s.getString("extra_ref_module");
        String string2 = this.s.getString("event_ref_mechanism");
        this.ax = new EventAnalyticsParams(EventActionContext.a, string, string2, am_().toString(), null);
        this.aN = this.s.getBoolean("extra_is_inside_page_surface_tab", false);
        this.aw = new PageEventsListAdapter(this.ax, (Context) this.f2979b.getInstance(Context.class));
        PageEventsListAdapter pageEventsListAdapter = this.aw;
        Collection collection = this.ay;
        if (collection != null) {
            pageEventsListAdapter.f2965j.addAll(collection);
        }
        this.f2980c.f3011e = this.aw;
        this.am.a(this.an);
    }

    public static PageEventsListFragment m3991a(long j, String str, @Nullable ArrayList<String> arrayList, String str2, String str3, boolean z) {
        PageEventsListFragment pageEventsListFragment = new PageEventsListFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("com.facebook.katana.profile.id", j);
        bundle.putString("extra_page_name", str);
        bundle.putStringArrayList("event_id", arrayList);
        bundle.putString("extra_ref_module", str2);
        bundle.putString("event_ref_mechanism", str3);
        bundle.putBoolean("extra_is_inside_page_surface_tab", z);
        pageEventsListFragment.g(bundle);
        return pageEventsListFragment;
    }

    public final View m3998a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -241693974);
        View inflate = layoutInflater.inflate(2130904439, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 760775863, a);
        return inflate;
    }

    public final void m3999a(View view, Bundle bundle) {
        int i;
        super.a(view, bundle);
        this.aE = (LinearLayout) e(2131562202);
        this.aF = (BetterListView) e(2131562203);
        this.aA = b(bundle).inflate(2130904442, this.aF, false);
        if (this.aN) {
            this.aE.setPadding(0, jW_().getDimensionPixelSize(2131427418), 0, 0);
        } else {
            this.aE.setBackgroundResource(2131361920);
        }
        aq();
        if (this.aJ != null) {
            this.aF.addHeaderView(this.aJ);
            i = 2;
        } else {
            i = 1;
        }
        this.aI = new EmptyListViewItem(getContext());
        int dimensionPixelSize = this.aD.getDimensionPixelSize(2131427416);
        this.aI.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        this.aI.setBackgroundResource(0);
        this.aI.setVisibility(0);
        this.aI.a(true);
        this.aF.addFooterView(this.aI);
        this.aL = new View(getContext());
        E_(this.aQ);
        this.aF.addFooterView(this.aL);
        this.aF.addHeaderView(this.aA);
        this.aF.setStickyHeaderEnabled(true);
        this.aw.f2968m = i;
        this.aF.setAdapter(this.aw);
        this.aF.setOnScrollListener(new C03991(this));
        this.aB = (FbTextView) FindViewUtil.b(this.aA, 2131562206);
        this.aC = (FbButton) FindViewUtil.b(this.aA, 2131562207);
        if (au(this)) {
            av(this);
        } else {
            this.aG = new TextAppearanceSpan(getContext(), 2131626250);
            this.aH = new TextAppearanceSpan(getContext(), 2131626251);
            this.aC.setOnClickListener(new C04002(this));
        }
        if (this.aN) {
            this.aF.setVerticalScrollBarEnabled(false);
        }
        D_(this.aP);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -711456932);
        super.mi_();
        if (!this.aN) {
            ((FbTitleBar) this.f2978a.get()).setTitle(2131239533);
        }
        if (!this.aq) {
            m3994a(this, true);
            this.aq = true;
        }
        if (!(this.aI == null || this.ap)) {
            this.aI.setVisibility(8);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1417093645, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1585896669);
        this.f2980c.f3008b.c();
        this.aF = null;
        this.am.b(this.an);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -746420157, a);
    }

    private void aq() {
        if (this.aJ == null) {
            if (this.aK == null) {
                this.aJ = new ReactionHeaderTouchDelegateView(new View(getContext()));
            } else {
                this.aJ = new ReactionHeaderTouchDelegateView(this.aK);
                this.aK.a(this.aJ);
            }
            this.aJ.c = true;
        } else if (this.aK != null) {
            this.aJ.a = this.aK;
            this.aK.a(this.aJ);
            this.aJ.requestLayout();
        }
    }

    public final void m4001a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.aM = pagesSurfaceFragment;
    }

    public final void m4004j() {
        PageEventsListAdapter pageEventsListAdapter = this.aw;
        for (SectionType sectionType : pageEventsListAdapter.f2960e.keySet()) {
            ((Section) pageEventsListAdapter.f2960e.get(sectionType)).f2957b.clear();
        }
        pageEventsListAdapter.f2963h.clear();
        pageEventsListAdapter.f2964i.clear();
        this.av = EventType.UPCOMING;
        this.ao = null;
        this.ap = true;
        m3994a(this, true);
    }

    public final void m4002a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.aK = reactionHeaderViewWithTouchDelegate;
        aq();
    }

    public final void D_(int i) {
        this.aP = i;
        PagesScrollUtils.a(this.aF, this.aP);
    }

    public final void E_(int i) {
        if (this.aQ < 0 || i <= this.aQ) {
            this.aQ = i;
            if (this.aL != null) {
                this.aL.setLayoutParams(new LayoutParams(-1, this.aQ));
            }
        }
    }

    public final void m4000a(C05581 c05581) {
    }

    public static void m3994a(PageEventsListFragment pageEventsListFragment, final boolean z) {
        pageEventsListFragment.f2980c.f3010d = pageEventsListFragment.jW_().getDimensionPixelSize(2131427461);
        if (EventType.UPCOMING.equals(pageEventsListFragment.av)) {
            pageEventsListFragment.f2980c.m4013a(pageEventsListFragment.ar, 10, pageEventsListFragment.ao, new Object(pageEventsListFragment) {
                final /* synthetic */ PageEventsListFragment f2972b;

                public final void m3986a(boolean z, GraphQLEventsCalendarSubscriptionStatus graphQLEventsCalendarSubscriptionStatus, int i, List<EventCommonFragmentModel> list, String str, boolean z2) {
                    this.f2972b.az = z;
                    if (this.f2972b.aF != null) {
                        PageEventsListFragment.m3993a(this.f2972b, (List) list, SectionType.UPCOMING);
                        this.f2972b.ao = str;
                        this.f2972b.au = i;
                        if (PageEventsListFragment.au(this.f2972b)) {
                            PageEventsListFragment.av(this.f2972b);
                        } else {
                            this.f2972b.at = graphQLEventsCalendarSubscriptionStatus;
                            PageEventsListFragment.ar(this.f2972b);
                        }
                        if (!z2 || list.isEmpty()) {
                            this.f2972b.av = EventType.PAST;
                            this.f2972b.ao = null;
                        }
                        if (!list.isEmpty() && z && this.f2972b.ay != null && !this.f2972b.ay.isEmpty()) {
                            int p_;
                            String str2 = (String) this.f2972b.ay.get(0);
                            PageEventsListAdapter pageEventsListAdapter = this.f2972b.aw;
                            if (str2 == null) {
                                p_ = pageEventsListAdapter.p_(0);
                            } else if (pageEventsListAdapter.f2963h.containsKey(str2)) {
                                p_ = ((Integer) pageEventsListAdapter.f2963h.get(str2)).intValue() + pageEventsListAdapter.p_(0);
                            } else {
                                p_ = -1;
                            }
                            int i2 = p_;
                            if (i2 != -1) {
                                this.f2972b.aF.smoothScrollToPosition(i2);
                            } else {
                                PageEventsListFragment.at(this.f2972b);
                            }
                        }
                    }
                }
            });
        } else {
            pageEventsListFragment.as();
        }
    }

    public static void ar(PageEventsListFragment pageEventsListFragment) {
        String string;
        String g;
        Drawable a;
        GlyphColorizer glyphColorizer = new GlyphColorizer(pageEventsListFragment.jW_());
        if (pageEventsListFragment.at == null || pageEventsListFragment.at.equals(GraphQLEventsCalendarSubscriptionStatus.NONE)) {
            string = pageEventsListFragment.aD.getString(2131239534, new Object[]{pageEventsListFragment.as});
            g = pageEventsListFragment.m3997g(pageEventsListFragment.au);
            pageEventsListFragment.aC.setText(pageEventsListFragment.aD.getString(2131239535));
            pageEventsListFragment.aC.setTextColor(pageEventsListFragment.aD.getColor(2131364066));
            pageEventsListFragment.aC.setBackgroundResource(2130839738);
            a = glyphColorizer.a(2130842470, -8421505);
        } else {
            string = pageEventsListFragment.aD.getString(2131239536, new Object[]{pageEventsListFragment.as});
            g = pageEventsListFragment.m3997g(0);
            pageEventsListFragment.aC.setText(pageEventsListFragment.aD.getString(2131239537));
            pageEventsListFragment.aC.setTextColor(pageEventsListFragment.aD.getColor(2131364067));
            pageEventsListFragment.aC.setBackgroundResource(2130839741);
            a = pageEventsListFragment.aD.getDrawable(2130842470);
        }
        pageEventsListFragment.aB.setVisibility(0);
        pageEventsListFragment.aC.setVisibility(0);
        pageEventsListFragment.aB.setText(pageEventsListFragment.m3990a(string, g));
        pageEventsListFragment.aC.setCompoundDrawablesWithIntrinsicBounds(a, null, null, null);
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private SpannableStringBuilder m3990a(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!StringUtil.a(str)) {
            m3992a(spannableStringBuilder, str, this.aG, 17);
        }
        if (!StringUtil.a(str2)) {
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append("\n");
            }
            m3992a(spannableStringBuilder, str2, this.aH, 17);
        }
        return spannableStringBuilder;
    }

    private String m3997g(int i) {
        if (i == 0) {
            return null;
        }
        return this.aD.getQuantityString(2131689744, i, new Object[]{this.f2981d.a(i)});
    }

    private static void m3992a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, Object obj, int i) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), i);
    }

    private void as() {
        this.f2980c.m4014a(this.ar, 10, this.ao, new C04024(this));
    }

    public static void m3993a(PageEventsListFragment pageEventsListFragment, List list, SectionType sectionType) {
        pageEventsListFragment.aw.m3976a(Lists.a(list, new C04035(pageEventsListFragment)), sectionType);
    }

    public static void at(PageEventsListFragment pageEventsListFragment) {
        PageEventsListPager pageEventsListPager = pageEventsListFragment.f2980c;
        List list = pageEventsListFragment.ay;
        C04046 c04046 = new C04046(pageEventsListFragment);
        pageEventsListPager.f3008b.a("fetchEventsList", new C04116(pageEventsListPager, list), new C04127(pageEventsListPager, c04046));
    }

    public static boolean au(PageEventsListFragment pageEventsListFragment) {
        return pageEventsListFragment.az && pageEventsListFragment.f2986i.a(Liveness.Live, ExperimentsForPagesFb4aAbTestModule.g, false);
    }

    public static void av(PageEventsListFragment pageEventsListFragment) {
        pageEventsListFragment.aB.setText(pageEventsListFragment.m3990a(pageEventsListFragment.jW_().getString(2131239539), null));
        pageEventsListFragment.aB.setVisibility(0);
        pageEventsListFragment.aC.setText(pageEventsListFragment.jW_().getString(2131239540));
        pageEventsListFragment.aC.setOnClickListener(new C04057(pageEventsListFragment));
        pageEventsListFragment.aC.setTextColor(pageEventsListFragment.aD.getColor(2131364067));
        pageEventsListFragment.aC.setBackgroundResource(2130839741);
        pageEventsListFragment.aC.setVisibility(0);
    }

    private void m3995a(FbTitleBarSupplier fbTitleBarSupplier, PageEventsListAdapterProvider pageEventsListAdapterProvider, PageEventsListPager pageEventsListPager, NumberTruncationUtil numberTruncationUtil, PageScopedEventBus pageScopedEventBus, EventGraphQLModelHelper eventGraphQLModelHelper, SubscribeToPageEventsMutator subscribeToPageEventsMutator, ScreenUtil screenUtil, QeAccessor qeAccessor, SecureContextHelper secureContextHelper, EventsEventBus eventsEventBus) {
        this.f2978a = fbTitleBarSupplier;
        this.f2979b = pageEventsListAdapterProvider;
        this.f2980c = pageEventsListPager;
        this.f2981d = numberTruncationUtil;
        this.f2982e = pageScopedEventBus;
        this.f2983f = eventGraphQLModelHelper;
        this.f2984g = subscribeToPageEventsMutator;
        this.f2985h = screenUtil;
        this.f2986i = qeAccessor;
        this.al = secureContextHelper;
        this.am = eventsEventBus;
    }
}
