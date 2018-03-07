package com.facebook.events.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.events.carousel.EventCardViewBinder;
import com.facebook.events.carousel.EventCardViewBinderProvider;
import com.facebook.events.carousel.EventsCarouselPagerAdapter;
import com.facebook.events.carousel.EventsCarouselPagerAdapterProvider;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dashboard.EventsDashboardCaspianHeaderView.OnFilterClickedListener;
import com.facebook.events.dashboard.birthdays.EventsBirthdaysCard;
import com.facebook.events.dashboard.subscriptions.EventCardSubscribedRemover;
import com.facebook.events.dashboard.subscriptions.EventCardUnsubscribeRemover;
import com.facebook.events.dashboard.subscriptions.EventsSubscriptionsCard;
import com.facebook.events.dashboard.suggestions.EventCardSuggestionRemover;
import com.facebook.events.dashboard.suggestions.EventsSuggestionsCard;
import com.facebook.events.data.EventsDAO;
import com.facebook.events.dateformatter.EventsBirthdayTimeFormatUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil.CalendarBucket;
import com.facebook.events.dateformatter.TimeRange;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventCountsQueryModel.EventCountsModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSubscribedEventsModel.SubscribedProfileCalendarEventsModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSubscribedEventsModel.SubscribedProfileCalendarEventsModel.NodesModel.EventViewerSubscribedSourceProfilesModel.EventViewerSubscribedSourceProfilesNodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.SuggestedEventCutModel;
import com.facebook.events.model.Event;
import com.facebook.events.model.Event.Builder;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.events.permalink.guestlist.EventGuestListLoadingRowView;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.SectionedListAdapter;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.NaturalOrdering;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer_banner_pointer_overflows_to_more_tab */
public class CaspianEventsDashboardBucketAdapter extends SectionedListAdapter {
    private static final Object f16452c = ViewTypes.EMPTY_HEADER;
    private static final Object f16453d = ViewTypes.LOADING;
    private static final Object f16454e = ViewTypes.VIEW_ALL;
    private static final Object f16455f = ViewTypes.NO_EVENTS;
    private static final Object f16456g = ViewTypes.BIRTHDAYS_CARD;
    private static final ViewTypes[] f16457h = ViewTypes.values();
    private Object f16458A;
    public EventCountsModel f16459B;
    private boolean f16460C;
    private int f16461D = -1;
    private int f16462E = -1;
    public EventAnalyticsParams f16463F;
    public final Context f16464G;
    public final EventsDashboardTimeFormatUtil f16465H;
    public final EventsCarouselPagerAdapterProvider f16466I;
    public final EventCardSubscribedRemover f16467J;
    public final EventCardSuggestionRemover f16468K;
    public final EventCardUnsubscribeRemover f16469L;
    public final EventCardViewBinderProvider f16470M;
    public final EventGraphQLModelHelper f16471N;
    private final boolean f16472O;
    private final boolean f16473P;
    public final EventPermalinkController f16474Q;
    private final QeAccessor f16475R;
    private final OnClickListener f16476S = new C22921(this);
    public EventsDashboardCaspianHeaderView f16477i;
    public EventsDashboardController f16478j;
    public EventsDashboardFragment f16479k;
    private final EventsDashboardAdapterCollection f16480l;
    private ImmutableList<EventUserWithBirthdayFragmentModel> f16481m;
    private List<Section> f16482n;
    private SuggestedEventCutModel f16483o;
    public EventsCarouselPagerAdapter f16484p;
    public EventsCarouselPagerAdapter f16485q;
    private boolean f16486r;
    private DashboardFilterType f16487s;
    public List<NodesModel> f16488t;
    public int f16489u;
    private String f16490v;
    private boolean f16491w = true;
    public boolean f16492x;
    private int f16493y = -1;
    private int f16494z = -1;

    /* compiled from: composer_banner_pointer_overflows_to_more_tab */
    class C22921 implements OnClickListener {
        final /* synthetic */ CaspianEventsDashboardBucketAdapter f16438a;

        C22921(CaspianEventsDashboardBucketAdapter caspianEventsDashboardBucketAdapter) {
            this.f16438a = caspianEventsDashboardBucketAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1125191823);
            EventsDashboardRowView eventsDashboardRowView = (EventsDashboardRowView) view;
            if (eventsDashboardRowView.f16754m == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1931516121, a);
                return;
            }
            this.f16438a.f16474Q.m18266a(this.f16438a.f16464G, eventsDashboardRowView.f16754m, this.f16438a.f16463F.b);
            LogUtils.a(-864719414, a);
        }
    }

    /* compiled from: composer_banner_pointer_overflows_to_more_tab */
    class C22932 implements Supplier<EventCountsModel> {
        final /* synthetic */ CaspianEventsDashboardBucketAdapter f16439a;

        C22932(CaspianEventsDashboardBucketAdapter caspianEventsDashboardBucketAdapter) {
            this.f16439a = caspianEventsDashboardBucketAdapter;
        }

        public Object get() {
            return this.f16439a.f16459B;
        }
    }

    /* compiled from: composer_banner_pointer_overflows_to_more_tab */
    class C22943 implements Supplier<EventCountsModel> {
        final /* synthetic */ CaspianEventsDashboardBucketAdapter f16440a;

        C22943(CaspianEventsDashboardBucketAdapter caspianEventsDashboardBucketAdapter) {
            this.f16440a = caspianEventsDashboardBucketAdapter;
        }

        public Object get() {
            return this.f16440a.f16459B;
        }
    }

    /* compiled from: composer_banner_pointer_overflows_to_more_tab */
    class C22954 implements OnFilterClickedListener {
        final /* synthetic */ CaspianEventsDashboardBucketAdapter f16441a;

        C22954(CaspianEventsDashboardBucketAdapter caspianEventsDashboardBucketAdapter) {
            this.f16441a = caspianEventsDashboardBucketAdapter;
        }

        public final void mo780a(DashboardFilterType dashboardFilterType) {
            this.f16441a.f16478j.m16979a(dashboardFilterType);
        }
    }

    /* compiled from: composer_banner_pointer_overflows_to_more_tab */
    class C22976 implements Function<EventCommonFragment, EventCardViewBinder> {
        final /* synthetic */ CaspianEventsDashboardBucketAdapter f16444a;

        C22976(CaspianEventsDashboardBucketAdapter caspianEventsDashboardBucketAdapter) {
            this.f16444a = caspianEventsDashboardBucketAdapter;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            EventCommonFragment eventCommonFragment = (EventCommonFragment) obj;
            if (eventCommonFragment == null) {
                return null;
            }
            EventGraphQLModelHelper eventGraphQLModelHelper = this.f16444a.f16471N;
            Builder c = EventGraphQLModelHelper.m19281c(eventCommonFragment);
            if (eventCommonFragment.P() != null) {
                Object a = eventCommonFragment.P().a();
                if (!StringUtil.a(a)) {
                    c.ai = a;
                }
            }
            Event b = c.b();
            return this.f16444a.f16470M.m16417a(b, eventCommonFragment.l(), this.f16444a.f16463F, Lists.a(new EventCardSuggestionRemover[]{this.f16444a.f16468K}));
        }
    }

    /* compiled from: composer_banner_pointer_overflows_to_more_tab */
    public class C22987 implements Function<NodesModel, EventCardViewBinder> {
        final /* synthetic */ CaspianEventsDashboardBucketAdapter f16445a;

        public C22987(CaspianEventsDashboardBucketAdapter caspianEventsDashboardBucketAdapter) {
            this.f16445a = caspianEventsDashboardBucketAdapter;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            EventCommonFragment eventCommonFragment = (NodesModel) obj;
            if (eventCommonFragment == null) {
                return null;
            }
            EventGraphQLModelHelper eventGraphQLModelHelper = this.f16445a.f16471N;
            Builder c = EventGraphQLModelHelper.m19281c(eventCommonFragment);
            if (!(eventCommonFragment.T() == null || eventCommonFragment.T().a().isEmpty())) {
                EventViewerSubscribedSourceProfilesNodesModel eventViewerSubscribedSourceProfilesNodesModel = (EventViewerSubscribedSourceProfilesNodesModel) eventCommonFragment.T().a().get(0);
                c.aj = eventViewerSubscribedSourceProfilesNodesModel.j();
                c.ak = eventViewerSubscribedSourceProfilesNodesModel.k();
            }
            Event b = c.b();
            List a = Lists.a();
            a.add(this.f16445a.f16467J);
            if (!(StringUtil.a(b.al) || StringUtil.a(b.am))) {
                a.add(this.f16445a.f16469L);
            }
            return this.f16445a.f16470M.m16417a(b, eventCommonFragment.S(), this.f16445a.f16463F, a);
        }
    }

    /* compiled from: composer_banner_pointer_overflows_to_more_tab */
    public /* synthetic */ class C22998 {
        public static final /* synthetic */ int[] f16447b = new int[CalendarBucket.values().length];

        static {
            try {
                f16447b[CalendarBucket.PAST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16447b[CalendarBucket.YESTERDAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16447b[CalendarBucket.TODAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f16447b[CalendarBucket.TOMORROW.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f16447b[CalendarBucket.THIS_WEEK.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f16447b[CalendarBucket.NEXT_WEEK.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f16447b[CalendarBucket.FUTURE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            f16446a = new int[SectionType.values().length];
            try {
                f16446a[SectionType.DASHBOARD_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f16446a[SectionType.SUGGESTIONS.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f16446a[SectionType.BOTTOM_PADDING.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f16446a[SectionType.SUBSCRIPTIONS.ordinal()] = 4;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f16446a[SectionType.BIRTHDAYS.ordinal()] = 5;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f16446a[SectionType.EVENT.ordinal()] = 6;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    /* compiled from: composer_banner_pointer_overflows_to_more_tab */
    public class Section {
        protected final SectionType f16448a;
        protected final String f16449b;
        protected int f16450c;
        protected int f16451d;

        protected Section(@Nonnull SectionType sectionType, @Nullable String str) {
            this.f16448a = sectionType;
            this.f16449b = str;
        }
    }

    /* compiled from: composer_banner_pointer_overflows_to_more_tab */
    public enum SectionType {
        DASHBOARD_FILTER,
        EVENT,
        BIRTHDAYS,
        SUGGESTIONS,
        SUBSCRIPTIONS,
        BOTTOM_PADDING
    }

    /* compiled from: composer_banner_pointer_overflows_to_more_tab */
    enum ViewTypes {
        DASHBOARD_FILTER,
        TEXT_HEADER,
        EMPTY_HEADER,
        EVENT,
        BIRTHDAYS_CARD,
        LOADING,
        VIEW_ALL,
        NO_EVENTS,
        SUGGESTIONS,
        SUBSCRIPTIONS,
        BOTTOM_PADDING
    }

    public static CaspianEventsDashboardBucketAdapter m16886a(InjectorLike injectorLike) {
        return new CaspianEventsDashboardBucketAdapter(EventsDashboardCaspianPagerController.m16972a(injectorLike), EventsDashboardController.m16975a(injectorLike), (Context) injectorLike.getInstance(Context.class), EventsDashboardTimeFormatUtil.a(injectorLike), EventGraphQLModelHelper.m19271a(injectorLike), (EventsCarouselPagerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventsCarouselPagerAdapterProvider.class), EventCardSubscribedRemover.m17485b(injectorLike), EventCardSuggestionRemover.m17511b(injectorLike), EventCardUnsubscribeRemover.m17489b(injectorLike), (EventCardViewBinderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventCardViewBinderProvider.class), EventPermalinkController.m18262b(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CaspianEventsDashboardBucketAdapter(EventsDashboardCaspianPagerController eventsDashboardCaspianPagerController, EventsDashboardController eventsDashboardController, Context context, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, EventGraphQLModelHelper eventGraphQLModelHelper, EventsCarouselPagerAdapterProvider eventsCarouselPagerAdapterProvider, EventCardSubscribedRemover eventCardSubscribedRemover, EventCardSuggestionRemover eventCardSuggestionRemover, EventCardUnsubscribeRemover eventCardUnsubscribeRemover, EventCardViewBinderProvider eventCardViewBinderProvider, EventPermalinkController eventPermalinkController, Boolean bool, QeAccessor qeAccessor) {
        this.f16464G = new ContextThemeWrapper(context, 2131625810);
        this.f16478j = eventsDashboardController;
        this.f16465H = eventsDashboardTimeFormatUtil;
        this.f16466I = eventsCarouselPagerAdapterProvider;
        this.f16467J = eventCardSubscribedRemover;
        this.f16468K = eventCardSuggestionRemover;
        this.f16470M = eventCardViewBinderProvider;
        this.f16469L = eventCardUnsubscribeRemover;
        this.f16471N = eventGraphQLModelHelper;
        this.f16472O = eventsDashboardCaspianPagerController.m16974a();
        this.f16473P = bool.booleanValue();
        this.f16475R = qeAccessor;
        this.f16486r = true;
        this.f16480l = new EventsDashboardAdapterCollection(new EventsDAO());
        this.f16474Q = eventPermalinkController;
    }

    public final void m16910a(Cursor cursor, ImmutableSet<Event> immutableSet, DashboardFilterType dashboardFilterType, boolean z) {
        if (dashboardFilterType == DashboardFilterType.PAST) {
            this.f16480l.m16950b(cursor, immutableSet);
        } else {
            this.f16480l.m16947a(cursor, immutableSet);
        }
        this.f16487s = dashboardFilterType;
        this.f16492x = z;
        m16902j();
    }

    public final void m16913a(boolean z) {
        if (this.f16492x != z) {
            this.f16492x = z;
            m16902j();
        }
    }

    protected final int m16917c() {
        int i = m16900i() + 2;
        if (m16905m()) {
            i++;
        }
        if (m16904l()) {
            i++;
        }
        if (m16903k()) {
            return i + 1;
        }
        return i;
    }

    private int m16900i() {
        if (this.f16482n == null || this.f16482n.isEmpty()) {
            return 0;
        }
        if (this.f16460C || this.f16461D < 0) {
            return this.f16482n.size();
        }
        return this.f16461D + 1;
    }

    protected final View m16908a(int i, View view, ViewGroup viewGroup) {
        return m16892b(i, view, viewGroup);
    }

    private View m16892b(int i, View view, ViewGroup viewGroup) {
        SectionType g = m16897g(i);
        switch (g) {
            case DASHBOARD_FILTER:
            case SUGGESTIONS:
            case BOTTOM_PADDING:
            case SUBSCRIPTIONS:
            case BIRTHDAYS:
                return m16883a(view);
            case EVENT:
                if (m16900i() == 1) {
                    return m16883a(view);
                }
                return m16888a(view, viewGroup, ((Section) this.f16482n.get(i - 1)).f16449b);
            default:
                throw new IllegalArgumentException("No section header for section type: " + g);
        }
    }

    private View m16883a(View view) {
        if (view != null) {
            return view;
        }
        view = new View(this.f16464G);
        view.setTag(f16452c);
        return view;
    }

    private BetterTextView m16888a(View view, ViewGroup viewGroup, String str) {
        if (view != null) {
            view = (BetterTextView) view;
        } else {
            view = (BetterTextView) m16882a(2130904134, viewGroup);
        }
        view.setText(str);
        return view;
    }

    private <T extends View> T m16882a(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f16464G).inflate(i, viewGroup, false);
    }

    protected final int m16906a(int i) {
        SectionType g = m16897g(i);
        switch (g) {
            case DASHBOARD_FILTER:
            case SUGGESTIONS:
            case BOTTOM_PADDING:
            case SUBSCRIPTIONS:
            case BIRTHDAYS:
                return ViewTypes.EMPTY_HEADER.ordinal();
            case EVENT:
                if (m16900i() == 1) {
                    return ViewTypes.EMPTY_HEADER.ordinal();
                }
                return ViewTypes.TEXT_HEADER.ordinal();
            default:
                throw new IllegalArgumentException("No section header view type for section type: " + g);
        }
    }

    protected final Object m16914b(int i) {
        SectionType g = m16897g(i);
        switch (g) {
            case DASHBOARD_FILTER:
            case SUGGESTIONS:
            case BOTTOM_PADDING:
            case SUBSCRIPTIONS:
                return null;
            case BIRTHDAYS:
                return f16456g;
            case EVENT:
                return this.f16482n.get(i - 1);
            default:
                throw new IllegalArgumentException("No section header view type for section type: " + g);
        }
    }

    protected final int m16918c(int i) {
        SectionType g = m16897g(i);
        switch (g) {
            case DASHBOARD_FILTER:
            case SUGGESTIONS:
            case BOTTOM_PADDING:
            case SUBSCRIPTIONS:
            case BIRTHDAYS:
                return 1;
            case EVENT:
                int i2 = i - 1;
                if (!this.f16460C && i2 == this.f16461D) {
                    return this.f16462E + 1;
                }
                int i3 = ((Section) this.f16482n.get(i2)).f16451d;
                if (i3 == 0 || (i2 == this.f16482n.size() - 1 && this.f16491w)) {
                    return i3 + 1;
                }
                return i3;
            default:
                throw new IllegalArgumentException("No children count for section type: " + g);
        }
    }

    protected final Object m16909a(int i, int i2) {
        SectionType g = m16897g(i);
        switch (g) {
            case DASHBOARD_FILTER:
            case SUGGESTIONS:
            case BOTTOM_PADDING:
            case SUBSCRIPTIONS:
            case BIRTHDAYS:
                return null;
            case EVENT:
                return m16896f(i - 1, i2);
            default:
                throw new IllegalArgumentException("No child for section type: " + g);
        }
    }

    private Object m16896f(int i, int i2) {
        if (m16898g(i, i2)) {
            return f16454e;
        }
        if (m16899h(i, i2)) {
            return f16453d;
        }
        Section section = (Section) this.f16482n.get(i);
        if (section.f16451d != 0) {
            Event event;
            EventsDashboardAdapterCollection eventsDashboardAdapterCollection = this.f16480l;
            int i3 = section.f16450c + i2;
            if (i3 < eventsDashboardAdapterCollection.f16541f.size()) {
                event = (Event) eventsDashboardAdapterCollection.f16541f.get(i3);
            } else {
                while (eventsDashboardAdapterCollection.f16542g < eventsDashboardAdapterCollection.f16538c.b() && eventsDashboardAdapterCollection.f16543h < eventsDashboardAdapterCollection.f16539d.size()) {
                    eventsDashboardAdapterCollection.f16538c.a(eventsDashboardAdapterCollection.f16542g);
                    long c = eventsDashboardAdapterCollection.f16538c.c();
                    event = (Event) eventsDashboardAdapterCollection.f16539d.get(eventsDashboardAdapterCollection.f16543h);
                    long K = event.K();
                    if (eventsDashboardAdapterCollection.f16540e ? c < K : c > K) {
                        eventsDashboardAdapterCollection.f16541f.add(eventsDashboardAdapterCollection.f16538c.d());
                        eventsDashboardAdapterCollection.f16542g++;
                    } else {
                        eventsDashboardAdapterCollection.f16541f.add(event);
                        eventsDashboardAdapterCollection.f16543h++;
                    }
                    if (i3 < eventsDashboardAdapterCollection.f16541f.size()) {
                        event = (Event) eventsDashboardAdapterCollection.f16541f.get(i3);
                        break;
                    }
                }
                while (eventsDashboardAdapterCollection.f16542g < eventsDashboardAdapterCollection.f16538c.b()) {
                    eventsDashboardAdapterCollection.f16538c.a(eventsDashboardAdapterCollection.f16542g);
                    eventsDashboardAdapterCollection.f16541f.add(eventsDashboardAdapterCollection.f16538c.d());
                    eventsDashboardAdapterCollection.f16542g++;
                    if (i3 < eventsDashboardAdapterCollection.f16541f.size()) {
                        event = (Event) eventsDashboardAdapterCollection.f16541f.get(i3);
                        break;
                    }
                }
                while (eventsDashboardAdapterCollection.f16543h < eventsDashboardAdapterCollection.f16539d.size()) {
                    ArrayList arrayList = eventsDashboardAdapterCollection.f16541f;
                    List list = eventsDashboardAdapterCollection.f16539d;
                    int i4 = eventsDashboardAdapterCollection.f16543h;
                    eventsDashboardAdapterCollection.f16543h = i4 + 1;
                    arrayList.add(list.get(i4));
                }
                event = (Event) eventsDashboardAdapterCollection.f16541f.get(i3);
            }
            return event;
        } else if (this.f16492x) {
            return f16455f;
        } else {
            return f16453d;
        }
    }

    private boolean m16898g(int i, int i2) {
        return !this.f16460C && i == this.f16461D && i2 == this.f16462E;
    }

    private boolean m16899h(int i, int i2) {
        return this.f16491w && i == this.f16482n.size() - 1 && i2 == ((Section) this.f16482n.get(i)).f16451d;
    }

    private SectionType m16897g(int i) {
        if (i == 0) {
            return SectionType.DASHBOARD_FILTER;
        }
        int i2 = i - 1;
        int i3 = m16900i();
        if (i3 > 0) {
            if (this.f16460C || this.f16461D < 0) {
                if (i2 < i3) {
                    return SectionType.EVENT;
                }
            } else if (i2 <= this.f16461D) {
                return SectionType.EVENT;
            }
        }
        i2 = i - (i3 + 1);
        if (m16905m()) {
            if (i2 == 0) {
                return SectionType.SUBSCRIPTIONS;
            }
            i2--;
        }
        if (m16904l()) {
            if (i2 == 0) {
                return SectionType.SUGGESTIONS;
            }
            i2--;
        }
        if (m16903k() && r0 == 0) {
            return SectionType.BIRTHDAYS;
        }
        return SectionType.BOTTOM_PADDING;
    }

    protected final View m16907a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        return m16881a(i, i2, view, viewGroup);
    }

    private View m16881a(int i, int i2, View view, ViewGroup viewGroup) {
        SectionType g = m16897g(i);
        Object obj;
        switch (g) {
            case DASHBOARD_FILTER:
                if (this.f16472O) {
                    return m16883a(view);
                }
                if (this.f16475R.a(ExperimentsForEventsGatingModule.y, false)) {
                    if (view == null) {
                        view = m16894b(viewGroup);
                    } else {
                        EventsDashboardCaspianHeaderView eventsDashboardCaspianHeaderView = (EventsDashboardCaspianHeaderView) view;
                    }
                    view.setDashboardFilterType(this.f16487s);
                    view.setCountsSummarySupplier(new C22943(this));
                    view.f16561k = new C22954(this);
                    this.f16477i = view;
                    return view;
                }
                if (view == null) {
                    view = m16887a(viewGroup);
                } else {
                    EventsDashboardHeaderView eventsDashboardHeaderView = (EventsDashboardHeaderView) view;
                }
                view.m17080a(new C22932(this), this.f16463F);
                return view;
            case SUGGESTIONS:
                if (view == null) {
                    view = new EventsSuggestionsCard(this.f16464G);
                } else {
                    EventsSuggestionsCard eventsSuggestionsCard = (EventsSuggestionsCard) view;
                }
                if (this.f16484p == null) {
                    return view;
                }
                if (view.f17199d != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    return view;
                }
                ActionSource actionSource;
                SuggestedEventCutModel suggestedEventCutModel = this.f16483o;
                EventsCarouselPagerAdapter eventsCarouselPagerAdapter = this.f16484p;
                EventAnalyticsParams eventAnalyticsParams = this.f16463F;
                if (eventAnalyticsParams.b.e == ActionSource.DASHBOARD) {
                    actionSource = ActionSource.MOBILE_SUGGESTIONS_DASHBOARD;
                } else {
                    actionSource = eventAnalyticsParams.b.e;
                }
                view.f17199d = suggestedEventCutModel;
                view.f17200e = eventAnalyticsParams.a(actionSource);
                view.setPagerAdapter(eventsCarouselPagerAdapter);
                return view;
            case BOTTOM_PADDING:
                if (view != null) {
                    return view;
                }
                if (this.f16472O) {
                    return m16882a(2130904127, viewGroup);
                }
                return m16882a(2130904135, viewGroup);
            case SUBSCRIPTIONS:
                if (view == null) {
                    view = new EventsSubscriptionsCard(this.f16464G);
                } else {
                    EventsSubscriptionsCard eventsSubscriptionsCard = (EventsSubscriptionsCard) view;
                }
                if (this.f16485q == null) {
                    return view;
                }
                if (view.f17161e > 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    return view;
                }
                view.m17495a(this.f16488t, this.f16489u, this.f16485q, this.f16463F);
                return view;
            case BIRTHDAYS:
                if (view == null) {
                    view = new EventsBirthdaysCard(this.f16464G);
                } else {
                    EventsBirthdaysCard eventsBirthdaysCard = (EventsBirthdaysCard) view;
                }
                if (this.f16481m == null || this.f16481m.isEmpty()) {
                    return view;
                }
                view.m17301a(this.f16481m, this.f16479k, this.f16490v);
                return view;
            case EVENT:
                return m16891b(i - 1, i2, view, viewGroup);
            default:
                throw new IllegalArgumentException("No child views for section type: " + g);
        }
    }

    private EventsDashboardHeaderView m16887a(ViewGroup viewGroup) {
        return (EventsDashboardHeaderView) m16882a(2130904129, viewGroup);
    }

    private EventsDashboardCaspianHeaderView m16894b(ViewGroup viewGroup) {
        return (EventsDashboardCaspianHeaderView) m16882a(2130904126, viewGroup);
    }

    private View m16891b(int i, int i2, View view, ViewGroup viewGroup) {
        Object f = m16896f(i, i2);
        if (f == f16453d) {
            return m16893b(view);
        }
        if (f == f16454e) {
            return m16884a(view, viewGroup);
        }
        if (f == f16455f) {
            return m16895c(view);
        }
        return m16885a((Event) f, view);
    }

    private View m16893b(View view) {
        if (view != null) {
            return view;
        }
        view = new EventGuestListLoadingRowView(this.f16464G);
        view.setTag(f16453d);
        view.setBackgroundResource(2131361920);
        return view;
    }

    private View m16884a(View view, ViewGroup viewGroup) {
        if (view != null) {
            return view;
        }
        EventsDashboardViewAllRowView eventsDashboardViewAllRowView = (EventsDashboardViewAllRowView) m16882a(2130904140, viewGroup);
        eventsDashboardViewAllRowView.f16766c = this.f16463F;
        eventsDashboardViewAllRowView.f16765b = this;
        return eventsDashboardViewAllRowView;
    }

    private View m16895c(View view) {
        if (view == null) {
            view = new EventsDashboardNoEventsRowView(this.f16464G);
        } else {
            EventsDashboardNoEventsRowView eventsDashboardNoEventsRowView = (EventsDashboardNoEventsRowView) view;
        }
        if (this.f16487s == null) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
            view.m17083a(this.f16487s);
        }
        return view;
    }

    private View m16885a(Event event, View view) {
        EventsDashboardRowView eventsDashboardRowView;
        if (view != null) {
            eventsDashboardRowView = (EventsDashboardRowView) view;
        } else {
            eventsDashboardRowView = new EventsDashboardRowView(this.f16464G);
            eventsDashboardRowView.setOnClickListener(this.f16476S);
        }
        eventsDashboardRowView.m17145a(event, this.f16480l.f16539d.contains(event), this.f16463F, this.f16478j.f16570c, false);
        return eventsDashboardRowView;
    }

    protected final boolean m16916b(int i, int i2) {
        return true;
    }

    protected final int m16919c(int i, int i2) {
        SectionType g = m16897g(i);
        switch (g) {
            case DASHBOARD_FILTER:
                return ViewTypes.DASHBOARD_FILTER.ordinal();
            case SUGGESTIONS:
                return ViewTypes.SUGGESTIONS.ordinal();
            case BOTTOM_PADDING:
                return ViewTypes.BOTTOM_PADDING.ordinal();
            case SUBSCRIPTIONS:
                return ViewTypes.SUBSCRIPTIONS.ordinal();
            case BIRTHDAYS:
                return ViewTypes.BIRTHDAYS_CARD.ordinal();
            case EVENT:
                int i3 = i - 1;
                if (m16898g(i3, i2)) {
                    return ViewTypes.VIEW_ALL.ordinal();
                }
                if (m16899h(i3, i2)) {
                    return ViewTypes.LOADING.ordinal();
                }
                if (((Section) this.f16482n.get(i3)).f16451d != 0) {
                    return ViewTypes.EVENT.ordinal();
                }
                if (this.f16492x) {
                    return ViewTypes.NO_EVENTS.ordinal();
                }
                return ViewTypes.LOADING.ordinal();
            default:
                throw new IllegalArgumentException("No child view type for section type: " + g);
        }
    }

    public int getViewTypeCount() {
        return f16457h.length;
    }

    public final void m16915b(boolean z) {
        if (z != this.f16491w) {
            this.f16491w = z;
            AdapterDetour.a(this, -1135837314);
        }
    }

    public final void m16920c(boolean z) {
        if (this.f16460C != z) {
            this.f16460C = z;
            if (z) {
                m16902j();
            }
            AdapterDetour.a(this, 1349194553);
        }
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f16493y = -1;
        this.f16494z = -1;
        this.f16458A = null;
    }

    public final Event m16921d(int i, int i2) {
        m16901i(i, i2);
        if (this.f16458A instanceof Event) {
            return (Event) this.f16458A;
        }
        return null;
    }

    public final boolean m16923e(int i, int i2) {
        m16901i(i, i2);
        return this.f16458A == f16453d;
    }

    private void m16901i(int i, int i2) {
        if (i != this.f16493y || i2 != this.f16494z) {
            this.f16493y = i;
            this.f16494z = i2;
            SectionType g = m16897g(d(i)[0]);
            if (!(g == SectionType.EVENT || g == SectionType.DASHBOARD_FILTER)) {
                this.f16458A = null;
            }
            while (i2 >= i) {
                int[] d = d(i2);
                if (d[1] >= 0) {
                    Object a = m16909a(d[0], d[1]);
                    if ((a instanceof Event) || a == f16453d) {
                        this.f16458A = a;
                        return;
                    }
                }
                i2--;
            }
            this.f16458A = null;
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    private void m16902j() {
        if (this.f16480l.m16948a()) {
            m16890a(Lists.a(new Section[]{new Section(SectionType.EVENT, "")}), -1, -1);
            return;
        }
        List a = Lists.a();
        Section section = null;
        long currentTimeMillis = System.currentTimeMillis();
        TimeRange a2 = TimeRange.a(currentTimeMillis);
        TimeRange b = TimeRange.b(currentTimeMillis);
        Iterator c = this.f16480l.m16951c();
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        while (c.hasNext()) {
            String f;
            Section section2;
            long longValue = ((Long) c.next()).longValue();
            Date date = new Date(longValue);
            boolean c2 = a2.c(longValue);
            boolean c3 = b.c(longValue);
            CalendarBucket a3 = this.f16465H.a(longValue, currentTimeMillis);
            if (this.f16487s == DashboardFilterType.PAST) {
                f = c3 ? this.f16465H.f(date) : this.f16465H.g(date);
            } else {
                f = m16889a(a3, date, c2, c3);
            }
            if (i < 0 && i3 >= 7 && (a3 == CalendarBucket.NEXT_WEEK || a3 == CalendarBucket.FUTURE)) {
                i = a.size() - 1;
                i2 = section.f16451d;
            }
            if (section == null || !section.f16449b.equals(f)) {
                section2 = new Section(SectionType.EVENT, f);
                section2.f16450c = i3;
                a.add(section2);
            } else {
                section2 = section;
            }
            int i4 = i3 + 1;
            section2.f16451d++;
            if (!this.f16460C && r6 >= 0) {
                break;
            }
            i3 = i4;
            section = section2;
        }
        m16890a(a, i, i2);
    }

    private boolean m16903k() {
        return (this.f16487s != DashboardFilterType.UPCOMING || this.f16481m == null || this.f16481m.isEmpty() || this.f16472O) ? false : true;
    }

    private void m16890a(List<Section> list, int i, int i2) {
        this.f16482n = list;
        this.f16461D = i;
        this.f16462E = i2;
        AdapterDetour.a(this, 429730358);
    }

    public final void m16912a(List<EventUserWithBirthdayFragmentModel> list, String str) {
        if (!list.isEmpty()) {
            final Date date = new Date();
            C22965 c22965 = new Function<EventUserWithBirthdayFragmentModel, Date>(this) {
                final /* synthetic */ CaspianEventsDashboardBucketAdapter f16443b;

                public Object apply(@Nullable Object obj) {
                    EventUserWithBirthdayFragmentModel eventUserWithBirthdayFragmentModel = (EventUserWithBirthdayFragmentModel) obj;
                    return EventsBirthdayTimeFormatUtil.a(date, TimeZone.getDefault(), eventUserWithBirthdayFragmentModel.j().a(), eventUserWithBirthdayFragmentModel.j().b()).getTime();
                }
            };
            this.f16490v = str;
            this.f16481m = NaturalOrdering.a.a(c22965).d(list);
            AdapterDetour.a(this, -2021841490);
        }
    }

    public final void m16911a(SuggestedEventCutModel suggestedEventCutModel) {
        boolean z = false;
        boolean z2 = this.f16486r;
        this.f16486r = false;
        if (suggestedEventCutModel == null || suggestedEventCutModel.c() == null || suggestedEventCutModel.c().a().isEmpty()) {
            z = true;
        }
        if (this.f16483o == null && !r0) {
            this.f16483o = suggestedEventCutModel;
            this.f16484p = this.f16466I.m16435a(this.f16464G, this.f16463F, Lists.a(suggestedEventCutModel.c().a(), new C22976(this)), ActionSource.MOBILE_SUGGESTIONS_DASHBOARD, ActionMechanism.DASHBOARD_SUGGESTIONS_CARD, null);
            AdapterDetour.a(this, 1064998811);
        } else if (z2) {
            AdapterDetour.a(this, -569131439);
        }
    }

    public final int m16922e() {
        int i = 0;
        int i2 = 0;
        while (i < m16917c()) {
            if (m16897g(i) == SectionType.SUBSCRIPTIONS) {
                return i2 + 1;
            }
            i2 = (i2 + 1) + m16918c(i);
            i++;
        }
        return -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m16889a(com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil.CalendarBucket r6, java.util.Date r7, boolean r8, boolean r9) {
        /*
        r5 = this;
        r0 = r5.f16480l;
        r0 = r0.m16949b();
        r1 = 3;
        if (r0 > r1) goto L_0x0023;
    L_0x0009:
        r2 = com.facebook.events.dashboard.CaspianEventsDashboardBucketAdapter.C22998.f16447b;
        r3 = r6.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 1: goto L_0x0038;
            case 2: goto L_0x0038;
            case 3: goto L_0x0038;
            case 4: goto L_0x0038;
            case 5: goto L_0x0038;
            case 6: goto L_0x0046;
            default: goto L_0x0014;
        };
    L_0x0014:
        r2 = r5.f16464G;
        r2 = r2.getResources();
        r3 = 2131237143; // 0x7f081917 float:1.8090528E38 double:1.0529710555E-314;
        r2 = r2.getString(r3);
    L_0x0021:
        r0 = r2;
    L_0x0022:
        return r0;
    L_0x0023:
        r2 = com.facebook.events.dashboard.CaspianEventsDashboardBucketAdapter.C22998.f16447b;
        r3 = r6.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 1: goto L_0x0056;
            case 2: goto L_0x0056;
            case 3: goto L_0x0056;
            case 4: goto L_0x005c;
            case 5: goto L_0x0062;
            case 6: goto L_0x0069;
            case 7: goto L_0x0077;
            default: goto L_0x002e;
        };
    L_0x002e:
        if (r9 == 0) goto L_0x0080;
    L_0x0030:
        r2 = r5.f16465H;
        r2 = r2.f(r7);
    L_0x0036:
        r0 = r2;
        goto L_0x0022;
    L_0x0038:
        r2 = r5.f16464G;
        r2 = r2.getResources();
        r3 = 2131237141; // 0x7f081915 float:1.8090524E38 double:1.0529710545E-314;
        r2 = r2.getString(r3);
        goto L_0x0021;
    L_0x0046:
        r2 = r5.f16464G;
        r2 = r2.getResources();
        r3 = 2131237142; // 0x7f081916 float:1.8090526E38 double:1.052971055E-314;
        r2 = r2.getString(r3);
        goto L_0x0021;
    L_0x0056:
        r2 = r5.f16465H;
        r4 = r2.p;
        r2 = r4;
        goto L_0x0036;
    L_0x005c:
        r2 = r5.f16465H;
        r4 = r2.q;
        r2 = r4;
        goto L_0x0036;
    L_0x0062:
        r2 = r5.f16465H;
        r2 = r2.e(r7);
        goto L_0x0036;
    L_0x0069:
        r2 = r5.f16464G;
        r2 = r2.getResources();
        r3 = 2131237142; // 0x7f081916 float:1.8090526E38 double:1.052971055E-314;
        r2 = r2.getString(r3);
        goto L_0x0036;
    L_0x0077:
        if (r8 == 0) goto L_0x002e;
    L_0x0079:
        r2 = r5.f16465H;
        r2 = r2.h(r7);
        goto L_0x0036;
    L_0x0080:
        r2 = r5.f16465H;
        r2 = r2.g(r7);
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.dashboard.CaspianEventsDashboardBucketAdapter.a(com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil$CalendarBucket, java.util.Date, boolean, boolean):java.lang.String");
    }

    private boolean m16904l() {
        if (this.f16473P || this.f16487s != DashboardFilterType.UPCOMING) {
            return false;
        }
        if (this.f16483o != null || this.f16486r) {
            return true;
        }
        return false;
    }

    private boolean m16905m() {
        return this.f16487s == DashboardFilterType.UPCOMING && this.f16489u > 0;
    }
}
