package com.facebook.events.create;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.title.IndicatorBarController;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.device.ScreenUtil;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.create.EventCreateMutationsController.EventCreateMutationsControllerListener;
import com.facebook.events.create.PageEventCreationPageHostsPager.C22703;
import com.facebook.events.create.PageEventCreationPageHostsPager.C22714;
import com.facebook.events.create.PageEventCreationPageHostsPager.FetchPageEventHostCallback;
import com.facebook.events.create.abtest.ExperimentsForEventsCreationModule;
import com.facebook.events.create.navigation.DefaultEventCreationNavHandler;
import com.facebook.events.create.navigation.EventCreationNavHandler;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageHostInfoFragmentModel;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageHostInfoFragmentModel.CoverPhotoModel.PhotoModel;
import com.facebook.events.create.ui.CohostsSelector;
import com.facebook.events.create.ui.CoverPhotoActivitiesLauncher;
import com.facebook.events.create.ui.CoverPhotoSelector;
import com.facebook.events.create.ui.CoverPhotoSelector.CoverPhotoRemovedListener;
import com.facebook.events.create.ui.EventCategorySelector;
import com.facebook.events.create.ui.EventCohostsModel;
import com.facebook.events.create.ui.EventCoverPhotoModel;
import com.facebook.events.create.ui.EventCreationCoverPhotoView;
import com.facebook.events.create.ui.EventDescriptionText;
import com.facebook.events.create.ui.EventHostSelector;
import com.facebook.events.create.ui.EventNameEditText;
import com.facebook.events.create.ui.EventNameEditText.OnEventNameEditedListener;
import com.facebook.events.create.ui.EventsCreationCoverPhotoAnimationController;
import com.facebook.events.create.ui.ThemeSuggestifier;
import com.facebook.events.create.ui.ThemeSuggestifierOptionViewHolder.OnOptionSelectedListener;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventCreatedEvent;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.PrivacyType;
import com.facebook.events.permalinkintent.EventPermalinkIntentBuilder;
import com.facebook.events.protocol.EventsApiConstants;
import com.facebook.events.ui.date.EventTimeModel;
import com.facebook.events.ui.date.StartAndEndTimeNikumanPicker;
import com.facebook.events.ui.location.EventLocationModel;
import com.facebook.events.ui.location.LocationNikumanPicker;
import com.facebook.events.ui.location.LocationPickerLauncher;
import com.facebook.events.ui.privacy.EventCreationEducationWidget;
import com.facebook.events.ui.privacy.EventCreationPrivacyEducationWidgetRedesign;
import com.facebook.events.ui.privacy.PrivacyOptionCheckbox;
import com.facebook.events.ui.privacy.PrivacyOptionCheckbox.OnPrivacyOptionToggledListener;
import com.facebook.events.ui.privacy.PrivacyPickerNikuman;
import com.facebook.events.ui.privacy.PrivacyPickerNikuman.OnPrivacyChangedListener;
import com.facebook.events.ui.privacy.PrivacyPickerNikumanController;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQL.FetchSingleEventThemePhotoQueryString;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQLModels.FetchSingleEventThemePhotoQueryModel;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.EventCreateInputData;
import com.facebook.graphql.calls.EventCreateInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventCreateInputData.CoverPhotoInfo;
import com.facebook.graphql.calls.EventCreateInputData.EventVisibility;
import com.facebook.graphql.calls.EventCreateInputData.InvitePolicy;
import com.facebook.graphql.calls.EventCreateInputData.PostApprovalRequired;
import com.facebook.graphql.calls.EventCreateInputData.PrivacyUpdatePolicy;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTemporalEventInfo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbCheckedTextView;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterTextView;
import com.facebook.work.config.String_WorkCommunityIdMethodAutoProvider;
import com.facebook.work.config.String_WorkCommunityNameMethodAutoProvider;
import com.facebook.work.config.community.WorkCommunityId;
import com.facebook.work.config.community.WorkCommunityName;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: contact_picker_dialog_nux */
public class EventCreationNikumanActivity extends FbFragmentActivity implements AnalyticsActivity {
    private static final Class<?> f16152P = EventCreationNikumanActivity.class;
    @Inject
    QeAccessor f16153A;
    @Inject
    @IsWorkBuild
    Boolean f16154B;
    @Inject
    DefaultEventCreationNavHandler f16155C;
    @Inject
    EventPermalinkIntentBuilder f16156D;
    @Inject
    Lazy<FbUriIntentHandler> f16157E;
    @Inject
    ViewerContext f16158F;
    @Inject
    PageEventCreationPageHostsPager f16159G;
    @Inject
    @LoggedInUser
    Provider<User> f16160H;
    @Inject
    IndicatorBarController f16161I;
    @Inject
    @WorkCommunityId
    String f16162J;
    @Inject
    @WorkCommunityName
    String f16163K;
    @Inject
    ScreenUtil f16164L;
    @Inject
    GraphQLQueryExecutor f16165M;
    @Inject
    TasksManager f16166N;
    @Inject
    CoverPhotoActivitiesLauncher f16167O;
    public EventCompositionModel f16168Q;
    private FrameLayout f16169R;
    private PrivacyOptionCheckbox f16170S;
    private FrameLayout f16171T;
    private EventNameEditText f16172U;
    private EventHostSelector f16173V;
    private LocationNikumanPicker f16174W;
    private FrameLayout f16175X;
    private EventDescriptionText f16176Y;
    private StartAndEndTimeNikumanPicker f16177Z;
    private final OnOptionSelectedListener aA = new C22513(this);
    private final OnEventNameEditedListener aB = new C22524(this);
    private final OnClickListener aC = new C22535(this);
    private final OnClickListener aD = new C22546(this);
    private final FetchPageEventHostCallback aE = new C22557(this);
    private final C22568 aF = new C22568(this);
    public ThemeSuggestifier aa;
    public CoverPhotoSelector ab;
    public EventCreationCoverPhotoView ac;
    private CohostsSelector ad;
    private PrivacyPickerNikuman ae;
    private EventCategorySelector af;
    private FrameLayout ag;
    private BetterEditTextView ah;
    private LinearLayout ai;
    private BetterTextView aj;
    @Nullable
    private FbCheckedTextView ak;
    private EventAnalyticsParams al;
    private ActionMechanism am;
    private Long an;
    private String ao;
    private long ap;
    public PageHostInfoFragmentModel aq;
    private boolean ar;
    public boolean as;
    private boolean at;
    private boolean au;
    private boolean av;
    private EventsCreationCoverPhotoAnimationController aw;
    public final Handler ax = new Handler();
    public final Runnable ay = new C22491(this);
    private final C22502 az = new C22502(this);
    @Inject
    CreateEventPerformanceLogger f16178p;
    @Inject
    EventCreateMutationsController f16179q;
    @Inject
    EventCreationAnimationHelper f16180r;
    @Inject
    EventsEventBus f16181s;
    @Inject
    PrivacyPickerNikumanController f16182t;
    @Inject
    EventEventLogger f16183u;
    @Inject
    GraphQLNotificationsContentProviderHelper f16184v;
    @Inject
    LaunchEventComposerPerformanceLogger f16185w;
    @Inject
    MonotonicClock f16186x;
    @Inject
    Product f16187y;
    @Inject
    Provider<LocationPickerLauncher> f16188z;

    /* compiled from: contact_picker_dialog_nux */
    class C22491 implements Runnable {
        final /* synthetic */ EventCreationNikumanActivity f16143a;

        C22491(EventCreationNikumanActivity eventCreationNikumanActivity) {
            this.f16143a = eventCreationNikumanActivity;
        }

        public void run() {
            if (this.f16143a.aa != null) {
                this.f16143a.aa.m16866a(this.f16143a.f16168Q.f16045c, this.f16143a.f16168Q.f16046d);
            }
        }
    }

    /* compiled from: contact_picker_dialog_nux */
    public class C22502 {
        final /* synthetic */ EventCreationNikumanActivity f16144a;

        C22502(EventCreationNikumanActivity eventCreationNikumanActivity) {
            this.f16144a = eventCreationNikumanActivity;
        }

        public final void m16498a(String str, String str2) {
            if (!Strings.isNullOrEmpty(str2) && !Strings.isNullOrEmpty(str)) {
                EventCoverPhotoModel eventCoverPhotoModel = this.f16144a.f16168Q.f16049g;
                eventCoverPhotoModel.f16328b = str;
                eventCoverPhotoModel.f16329c = Uri.parse(str2);
                this.f16144a.ac.m16824a(true);
            }
        }
    }

    /* compiled from: contact_picker_dialog_nux */
    class C22513 implements OnOptionSelectedListener {
        final /* synthetic */ EventCreationNikumanActivity f16145a;

        C22513(EventCreationNikumanActivity eventCreationNikumanActivity) {
            this.f16145a = eventCreationNikumanActivity;
        }

        public final void mo777a(int i) {
            if (i == 1) {
                this.f16145a.f16167O.m16774c();
            } else if (i == 2) {
                this.f16145a.f16167O.m16773b();
            }
        }
    }

    /* compiled from: contact_picker_dialog_nux */
    class C22524 implements OnEventNameEditedListener {
        final /* synthetic */ EventCreationNikumanActivity f16146a;

        C22524(EventCreationNikumanActivity eventCreationNikumanActivity) {
            this.f16146a = eventCreationNikumanActivity;
        }

        public final void mo778a(String str) {
            if (!this.f16146a.aa.f16412l || str.length() <= 3) {
                HandlerDetour.a(this.f16146a.ax, this.f16146a.ay);
                return;
            }
            this.f16146a.aa.setVisibility(0);
            HandlerDetour.a(this.f16146a.ax, this.f16146a.ay);
            HandlerDetour.b(this.f16146a.ax, this.f16146a.ay, 1000, 580102663);
        }
    }

    /* compiled from: contact_picker_dialog_nux */
    class C22535 implements OnClickListener {
        final /* synthetic */ EventCreationNikumanActivity f16147a;

        C22535(EventCreationNikumanActivity eventCreationNikumanActivity) {
            this.f16147a = eventCreationNikumanActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1441700920);
            EventCreationNikumanActivity.m16514H(this.f16147a);
            EventCreationNikumanActivity.m16511E(this.f16147a);
            Logger.a(2, EntryType.UI_INPUT_END, -1278358147, a);
        }
    }

    /* compiled from: contact_picker_dialog_nux */
    class C22546 implements OnClickListener {
        final /* synthetic */ EventCreationNikumanActivity f16148a;

        C22546(EventCreationNikumanActivity eventCreationNikumanActivity) {
            this.f16148a = eventCreationNikumanActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -449107891);
            this.f16148a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 882152558, a);
        }
    }

    /* compiled from: contact_picker_dialog_nux */
    class C22557 implements FetchPageEventHostCallback {
        final /* synthetic */ EventCreationNikumanActivity f16149a;

        C22557(EventCreationNikumanActivity eventCreationNikumanActivity) {
            this.f16149a = eventCreationNikumanActivity;
        }

        public final void mo776a(List<PageHostInfoFragmentModel> list) {
            if (!list.isEmpty()) {
                this.f16149a.aq = (PageHostInfoFragmentModel) list.get(0);
            }
            this.f16149a.m16548d(false);
            EventCreationNikumanActivity.m16567r(this.f16149a);
        }
    }

    /* compiled from: contact_picker_dialog_nux */
    public class C22568 {
        final /* synthetic */ EventCreationNikumanActivity f16150a;

        C22568(EventCreationNikumanActivity eventCreationNikumanActivity) {
            this.f16150a = eventCreationNikumanActivity;
        }

        public final void m16504a(PageHostInfoFragmentModel pageHostInfoFragmentModel) {
            this.f16150a.aq = pageHostInfoFragmentModel;
            this.f16150a.m16548d(false);
            EventCreationNikumanActivity.m16567r(this.f16150a);
        }
    }

    /* compiled from: contact_picker_dialog_nux */
    class C22579 implements CoverPhotoRemovedListener {
        final /* synthetic */ EventCreationNikumanActivity f16151a;

        C22579(EventCreationNikumanActivity eventCreationNikumanActivity) {
            this.f16151a = eventCreationNikumanActivity;
        }

        public final void mo779a() {
            this.f16151a.f16168Q.f16049g.m16806a();
            this.f16151a.ac.m16824a(true);
        }
    }

    private static <T extends Context> void m16530a(Class<T> cls, T t) {
        m16531a((Object) t, (Context) t);
    }

    public static void m16531a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventCreationNikumanActivity) obj).m16523a(CreateEventPerformanceLogger.m16442a(injectorLike), EventCreateMutationsController.m16462a(injectorLike), EventCreationAnimationHelper.m16468a(injectorLike), EventsEventBus.a(injectorLike), PrivacyPickerNikumanController.m19732a(injectorLike), EventEventLogger.m18116a(injectorLike), GraphQLNotificationsContentProviderHelper.a(injectorLike), LaunchEventComposerPerformanceLogger.m16624a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 5707), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), DefaultEventCreationNavHandler.m16638a(injectorLike), EventPermalinkIntentBuilder.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 616), ViewerContextMethodAutoProvider.a(injectorLike), PageEventCreationPageHostsPager.m16634a(injectorLike), IdBasedProvider.a(injectorLike, 3595), IndicatorBarController.a(injectorLike), String_WorkCommunityIdMethodAutoProvider.a(injectorLike), String_WorkCommunityNameMethodAutoProvider.a(injectorLike), ScreenUtil.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.a(injectorLike), CoverPhotoActivitiesLauncher.m16771a(injectorLike));
    }

    private void m16523a(CreateEventPerformanceLogger createEventPerformanceLogger, EventCreateMutationsController eventCreateMutationsController, EventCreationAnimationHelper eventCreationAnimationHelper, EventsEventBus eventsEventBus, PrivacyPickerNikumanController privacyPickerNikumanController, EventEventLogger eventEventLogger, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, LaunchEventComposerPerformanceLogger launchEventComposerPerformanceLogger, MonotonicClock monotonicClock, Product product, Provider<LocationPickerLauncher> provider, QeAccessor qeAccessor, Boolean bool, EventCreationNavHandler eventCreationNavHandler, EventPermalinkIntentBuilder eventPermalinkIntentBuilder, Lazy<FbUriIntentHandler> lazy, ViewerContext viewerContext, PageEventCreationPageHostsPager pageEventCreationPageHostsPager, Provider<User> provider2, IndicatorBarController indicatorBarController, String str, String str2, ScreenUtil screenUtil, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, CoverPhotoActivitiesLauncher coverPhotoActivitiesLauncher) {
        this.f16178p = createEventPerformanceLogger;
        this.f16179q = eventCreateMutationsController;
        this.f16180r = eventCreationAnimationHelper;
        this.f16181s = eventsEventBus;
        this.f16182t = privacyPickerNikumanController;
        this.f16183u = eventEventLogger;
        this.f16184v = graphQLNotificationsContentProviderHelper;
        this.f16185w = launchEventComposerPerformanceLogger;
        this.f16186x = monotonicClock;
        this.f16187y = product;
        this.f16188z = provider;
        this.f16153A = qeAccessor;
        this.f16154B = bool;
        this.f16155C = eventCreationNavHandler;
        this.f16156D = eventPermalinkIntentBuilder;
        this.f16157E = lazy;
        this.f16158F = viewerContext;
        this.f16159G = pageEventCreationPageHostsPager;
        this.f16160H = provider2;
        this.f16161I = indicatorBarController;
        this.f16162J = str;
        this.f16163K = str2;
        this.f16164L = screenUtil;
        this.f16165M = graphQLQueryExecutor;
        this.f16166N = tasksManager;
        this.f16167O = coverPhotoActivitiesLauncher;
    }

    public static Intent m16516a(Context context, Long l, String str, ActionMechanism actionMechanism) {
        return m16519a(context, str, l, actionMechanism, null, null, null, null);
    }

    public static Intent m16517a(Context context, String str, ActionMechanism actionMechanism, Long l) {
        return m16518a(context, str, null, actionMechanism, l, null, null, null, null);
    }

    public static Intent m16519a(Context context, String str, Long l, ActionMechanism actionMechanism, String str2, String str3, GraphQLGroupVisibility graphQLGroupVisibility, String str4) {
        return m16518a(context, str, l, actionMechanism, null, str2, str3, graphQLGroupVisibility, str4);
    }

    private static Intent m16518a(Context context, String str, Long l, ActionMechanism actionMechanism, Long l2, String str2, String str3, GraphQLGroupVisibility graphQLGroupVisibility, String str4) {
        Intent intent = new Intent(context, EventCreationNikumanActivity.class);
        intent.putExtra("extra_ref_module", str);
        intent.putExtra("extras_event_action_mechanism", actionMechanism);
        if (l != null) {
            intent.putExtra("com.facebook.katana.profile.id", l);
        }
        if (l2 != null) {
            intent.putExtra("extra_page_event_host_id", l2);
        }
        if (!(Strings.isNullOrEmpty(str2) || Strings.isNullOrEmpty(str3) || graphQLGroupVisibility == null || graphQLGroupVisibility == GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) {
            intent.putExtra("group_id", str2);
            intent.putExtra("extra_group_name", str3);
            intent.putExtra("extra_group_visibility", graphQLGroupVisibility);
        }
        if (!Strings.isNullOrEmpty(str4)) {
            intent.putExtra("extra_parent_group_name", str4);
        }
        return intent;
    }

    protected final void m16576b(Bundle bundle) {
        boolean z = true;
        super.b(bundle);
        Class cls = EventCreationNikumanActivity.class;
        m16531a((Object) this, (Context) this);
        overridePendingTransition(2130968739, 2130968614);
        this.f16185w.m16626a();
        Bundle extras = getIntent().getExtras();
        if (getIntent().hasExtra("com.facebook.katana.profile.id")) {
            this.an = Long.valueOf(getIntent().getLongExtra("com.facebook.katana.profile.id", -1));
        }
        setContentView(2130904014);
        if (bundle == null) {
            this.f16168Q = new EventCompositionModel();
            this.f16168Q.m16447a();
            m16546d(extras);
        } else {
            this.f16168Q = (EventCompositionModel) bundle.getParcelable("EVENT_COMPOSITION_MODEL");
        }
        ViewStub viewStub = (ViewStub) findViewById(2131561006);
        this.f16161I.f = (ViewStub) findViewById(2131568572);
        this.f16161I.b(viewStub);
        this.f16155C.m16639a(this, this.aD, this.aC);
        LinearLayout linearLayout = (LinearLayout) a(2131561254);
        this.f16169R = (FrameLayout) a(2131561252);
        this.f16171T = (FrameLayout) a(2131561265);
        this.f16172U = (EventNameEditText) a(2131561236);
        this.f16172U.f16380h = this.f16180r;
        this.f16172U.m16847a(this.f16168Q);
        if (bundle != null) {
            this.aq = (PageHostInfoFragmentModel) FlatBufferModelHelper.a(bundle, "PAGE_EVENT_HOST");
        }
        if (getIntent().hasExtra("extra_page_event_host_id")) {
            Long valueOf = Long.valueOf(getIntent().getLongExtra("extra_page_event_host_id", -1));
            if (valueOf != null) {
                this.av = true;
                m16528a(PrivacyType.PAGE, Long.toString(valueOf.longValue()));
                m16548d(true);
            }
        }
        m16572w();
        m16573x();
        m16540c(bundle);
        m16555i();
        m16558j();
        m16559k();
        m16561l();
        this.aw = new EventsCreationCoverPhotoAnimationController(this, this.ab, linearLayout, this.f16171T, 300);
        this.ac = (EventCreationCoverPhotoView) a(2131561253);
        this.ac.m16823a(this.f16168Q.f16049g, this.aw);
        if (bundle != null && m16510D()) {
            m16567r(this);
        }
        if (this.f16182t.f19538e == PrivacyType.USER_PUBLIC || this.f16182t.f19538e == PrivacyType.PAGE || this.f16182t.f19538e == PrivacyType.COMMUNITY) {
            m16568s();
            if (!(bundle == null || this.ak == null)) {
                this.ak.setChecked(((Integer) FlatBufferModelHelper.a(bundle, "EVENT_ADMIN_POST_APPROVAL_REQUIRED")).intValue() == 1);
            }
        }
        m16508B();
        CheckBox checkBox = (CheckBox) a(2131561246);
        if (m16574y()) {
            checkBox.setVisibility(0);
        }
        this.f16183u.m18123a();
        this.ap = this.f16186x.now();
        this.al = new EventAnalyticsParams(EventActionContext.a, extras.getString("extra_ref_module"), am_(), null);
        this.am = (ActionMechanism) extras.getParcelable("extras_event_action_mechanism");
        m16509C();
        m16537b(this.f16168Q.f16049g.m16809g());
        if (bundle == null) {
            if (!(this.f16182t.f19538e == PrivacyType.INVITE_ONLY && this.f16153A.a(ExperimentsForEventsCreationModule.f16253a, false))) {
                z = false;
            }
            this.as = z;
        } else {
            this.as = bundle.getBoolean("IS_SHOWING_COLLAPSED_FLOW");
        }
        if (this.as) {
            this.at = this.f16153A.a(ExperimentsForEventsCreationModule.f16255c, false);
            this.au = this.f16153A.a(ExperimentsForEventsCreationModule.f16254b, false);
        }
        m16542c(this.as);
        EventEventLogger eventEventLogger = this.f16183u;
        String str = this.al.c;
        ActionMechanism I = m16515I();
        HoneyClientEventFast a = eventEventLogger.f17787i.a("view", false);
        if (a.a()) {
            a.a("event_composer").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).a("ref_module", str).a("source_module", "event_composer").a("action_mechanism", I).b();
        }
        this.f16167O.f16293d = this.f16168Q;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        int i;
        int i2 = 0;
        super.onSaveInstanceState(bundle);
        FlatBufferModelHelper.a(bundle, "PAGE_EVENT_HOST", this.aq);
        bundle.putParcelable("EVENT_COMPOSITION_MODEL", this.f16168Q);
        bundle.putString("EVENT_PRIVACY_TYPE", this.f16182t.f19538e == null ? null : this.f16182t.f19538e.name());
        String str = "EVENT_CAN_GUEST_INVITE_FRIENDS";
        if (this.f16182t.f19539f) {
            i = 1;
        } else {
            i = 0;
        }
        bundle.putInt(str, i);
        String str2 = "EVENT_ADMIN_POST_APPROVAL_REQUIRED";
        if (this.ak != null && this.ak.isChecked()) {
            i2 = 1;
        }
        bundle.putInt(str2, i2);
        bundle.putBoolean("IS_SHOWING_COLLAPSED_FLOW", this.as);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        m16537b(this.f16168Q.f16049g.m16809g());
    }

    private void m16555i() {
        this.ab = (CoverPhotoSelector) a(2131561233);
        this.ab.setEventCompositionModel(this.f16168Q);
        this.ab.f16310i = m16543c(this.f16182t.f19538e);
        this.ab.f16308g = new C22579(this);
        if (m16574y() || m16575z()) {
            this.ab.setVisibility(8);
        } else {
            this.ab.setVisibility(0);
        }
    }

    @TargetApi(21)
    public void onEnterAnimationComplete() {
        this.f16180r.m16471b(this.f16172U);
    }

    private void m16558j() {
        this.aa = (ThemeSuggestifier) a(2131561255);
        if (this.f16153A.a(ExperimentsForEventsCreationModule.f16257e, false) && !this.f16168Q.f16049g.m16809g() && (this.f16182t.f19538e == PrivacyType.INVITE_ONLY || this.f16182t.f19538e == PrivacyType.GROUP || this.f16182t.f19538e == PrivacyType.COMMUNITY)) {
            this.aa.setVisibility(0);
            this.f16172U.f16379g = this.aB;
            ThemeSuggestifier themeSuggestifier = this.aa;
            C22502 c22502 = this.az;
            if (themeSuggestifier.f16410j != null) {
                themeSuggestifier.f16410j.f16421g = c22502;
            }
            this.aa.setOnOptionSelectedListener(this.aA);
            return;
        }
        this.aa.setVisibility(8);
        this.f16172U.m16846a();
    }

    private void m16537b(boolean z) {
        this.ac.m16824a(false);
        this.aw.m16851a(z);
        this.aw.m16853b(z);
        this.ab.m16792a(z, false);
    }

    private void m16559k() {
        boolean z;
        this.ad = (CohostsSelector) a(2131561263);
        CohostsSelector cohostsSelector = this.ad;
        EventCohostsModel eventCohostsModel = this.f16168Q.f16052j;
        if (m16574y() || m16507A()) {
            z = false;
        } else {
            z = true;
        }
        cohostsSelector.m16769a(eventCohostsModel, 105, z, false);
    }

    private void m16561l() {
        this.ai = (LinearLayout) a(2131561261);
        this.aj = (BetterTextView) a(2131561262);
        this.ai.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EventCreationNikumanActivity f16136a;

            {
                this.f16136a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -947253033);
                this.f16136a.as = false;
                this.f16136a.m16542c(this.f16136a.as);
                this.f16136a.f16183u.m18146e();
                Logger.a(2, EntryType.UI_INPUT_END, -811490552, a);
            }
        });
    }

    private void m16542c(boolean z) {
        int i = 8;
        if (z) {
            int i2;
            this.f16175X.setVisibility(8);
            this.ad.setVisibility(8);
            this.f16174W.setVisibility(this.au ? 0 : 8);
            StartAndEndTimeNikumanPicker startAndEndTimeNikumanPicker = this.f16177Z;
            if (this.at) {
                i = 0;
            }
            startAndEndTimeNikumanPicker.setVisibility(i);
            this.ai.setVisibility(0);
            this.f16169R.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131361940)));
            BetterTextView betterTextView = this.aj;
            Resources resources = getResources();
            if (this.au) {
                i2 = 2131236945;
            } else {
                i2 = 2131236944;
            }
            betterTextView.setText(resources.getString(i2));
            return;
        }
        this.f16175X.setVisibility(0);
        if (!(m16574y() || m16507A())) {
            this.ad.setVisibility(0);
        }
        this.f16174W.setVisibility(0);
        this.f16177Z.setVisibility(0);
        this.ai.setVisibility(8);
        this.f16169R.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131361920)));
    }

    public static void m16535b(EventCreationNikumanActivity eventCreationNikumanActivity, PrivacyType privacyType) {
        if (eventCreationNikumanActivity.f16187y == Product.FB4A) {
            eventCreationNikumanActivity.m16558j();
            if (privacyType == PrivacyType.USER_PUBLIC || privacyType == PrivacyType.PAGE) {
                if (eventCreationNikumanActivity.aq == null) {
                    eventCreationNikumanActivity.m16548d(true);
                } else {
                    eventCreationNikumanActivity.m16548d(false);
                    m16567r(eventCreationNikumanActivity);
                }
                eventCreationNikumanActivity.m16542c(false);
                eventCreationNikumanActivity.m16568s();
                return;
            }
            eventCreationNikumanActivity.m16548d(false);
            eventCreationNikumanActivity.m16569t();
            eventCreationNikumanActivity.m16570u();
            eventCreationNikumanActivity.m16542c(eventCreationNikumanActivity.as);
        }
    }

    private void m16548d(boolean z) {
        FrameLayout frameLayout = (FrameLayout) a(2131561251);
        FrameLayout frameLayout2 = (FrameLayout) a(2131561249);
        if (z) {
            frameLayout2.setVisibility(0);
            frameLayout.setVisibility(8);
            return;
        }
        frameLayout2.setVisibility(8);
        frameLayout.setVisibility(0);
    }

    private void m16562m() {
        String l;
        String str;
        boolean z;
        boolean z2 = true;
        this.f16173V = (EventHostSelector) a(2131561256);
        this.f16173V.f16365f = 108;
        this.f16173V.setVisibility(0);
        String m;
        if (this.aq != null) {
            l = this.aq.m16741l();
            m = this.aq.m16742m();
            m16571v();
            str = l;
            l = m;
            z = true;
        } else {
            l = ((User) this.f16160H.get()).a;
            m = ((User) this.f16160H.get()).j();
            this.ar = false;
            str = l;
            l = m;
            z = false;
        }
        EventHostSelector eventHostSelector = this.f16173V;
        if (this.av) {
            z2 = false;
        }
        eventHostSelector.m16837a(str, l, z, z2);
    }

    private void m16563n() {
        this.af = (EventCategorySelector) a(2131561257);
        boolean z = m16564o() && m16510D();
        this.af.m16804a(this.f16168Q, this.aq == null ? null : this.aq.m16741l(), z, 109);
    }

    private boolean m16564o() {
        return (this.aq == null || this.aq.m16740k() == null || this.aq.m16740k().m16729a() <= 0) ? false : true;
    }

    private void m16565p() {
        this.ag = (FrameLayout) a(2131561259);
        this.ah = (BetterEditTextView) a(2131561260);
        if (this.aq != null) {
            this.ag.setVisibility(0);
        } else {
            this.ag.setVisibility(8);
        }
    }

    private void m16566q() {
        if (this.aq != null) {
            this.f16182t.m19743a(PrivacyType.PAGE);
        } else {
            this.f16182t.m19743a(PrivacyType.USER_PUBLIC);
        }
    }

    public static void m16567r(EventCreationNikumanActivity eventCreationNikumanActivity) {
        eventCreationNikumanActivity.m16566q();
        eventCreationNikumanActivity.m16562m();
        eventCreationNikumanActivity.m16563n();
        eventCreationNikumanActivity.m16565p();
    }

    private void m16568s() {
        if (this.ak == null) {
            this.ak = (FbCheckedTextView) a(2131561264);
            this.ak.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ EventCreationNikumanActivity f16137a;

                {
                    this.f16137a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1062414187);
                    ((FbCheckedTextView) view).toggle();
                    Logger.a(2, EntryType.UI_INPUT_END, -146827705, a);
                }
            });
        }
        this.ak.setVisibility(0);
    }

    private void m16569t() {
        if (this.f16173V != null) {
            this.f16173V.setVisibility(8);
        }
        if (this.af != null) {
            this.af.setVisibility(8);
        }
        if (this.ag != null) {
            this.ag.setVisibility(8);
        }
        if (this.ar) {
            this.f16168Q.f16049g.m16806a();
            this.ac.m16824a(true);
        }
    }

    private void m16570u() {
        if (this.ak != null) {
            this.ak.setVisibility(8);
        }
    }

    private void m16571v() {
        PhotoModel a = this.aq.m16739j() != null ? this.aq.m16739j().m16724a() : null;
        if (a == null || a.m16720k() == null) {
            this.ar = false;
            return;
        }
        Object b = a.m16720k().b();
        Object j = a.m16719j();
        if (!StringUtil.a(b) && !StringUtil.a(j)) {
            EventCoverPhotoModel eventCoverPhotoModel = this.f16168Q.f16049g;
            eventCoverPhotoModel.f16327a = j;
            eventCoverPhotoModel.f16329c = Uri.parse(b);
            this.ac.m16824a(true);
            this.ar = true;
        }
    }

    private void m16572w() {
        this.f16175X = (FrameLayout) a(2131561258);
        this.f16176Y = (EventDescriptionText) a(2131561241);
        this.f16176Y.m16829a(this.f16168Q);
    }

    private void m16573x() {
        this.f16174W = (LocationNikumanPicker) a(2131561240);
        this.f16174W.m19645a(this.f16168Q.f16051i, this.f16188z, this, 102, m16574y());
    }

    private boolean m16574y() {
        return this.f16187y == Product.PAA;
    }

    private boolean m16575z() {
        return this.f16187y == Product.GROUPS;
    }

    private boolean m16507A() {
        return !Strings.isNullOrEmpty(this.ao);
    }

    private void m16540c(Bundle bundle) {
        if (m16574y()) {
            this.f16182t.m19744a(PrivacyType.PAGE, true);
        } else {
            if (!m16575z()) {
                this.ae = (PrivacyPickerNikuman) a(2131561273);
                this.ae.f19519e = false;
                if (this.f16154B.booleanValue()) {
                    this.ae.f19520f = false;
                    this.ae.m19730a(true, this.f16163K);
                }
                this.f16170S = (PrivacyOptionCheckbox) a(2131561245);
            }
            this.f16182t.m19748a(this.ae, this.f16170S);
            if (this.f16153A.a(ExperimentsForEventsCreationModule.f16256d, false)) {
                this.f16182t.m19747a((EventCreationPrivacyEducationWidgetRedesign) a(2131561250));
            } else {
                this.f16182t.m19746a((EventCreationEducationWidget) a(2131561247));
            }
            if (getIntent().hasExtra("group_id") && getIntent().hasExtra("extra_group_name") && getIntent().hasExtra("extra_group_visibility")) {
                String stringExtra;
                this.ao = getIntent().getStringExtra("group_id");
                PrivacyPickerNikumanController privacyPickerNikumanController = this.f16182t;
                String stringExtra2 = getIntent().getStringExtra("extra_group_name");
                GraphQLGroupVisibility graphQLGroupVisibility = (GraphQLGroupVisibility) getIntent().getSerializableExtra("extra_group_visibility");
                if (getIntent().hasExtra("extra_parent_group_name")) {
                    stringExtra = getIntent().getStringExtra("extra_parent_group_name");
                } else {
                    stringExtra = null;
                }
                privacyPickerNikumanController.m19750a(stringExtra2, graphQLGroupVisibility, stringExtra);
            } else if (bundle != null) {
                this.f16182t.m19744a(PrivacyType.valueOf(bundle.getString("EVENT_PRIVACY_TYPE")), bundle.getInt("EVENT_CAN_GUEST_INVITE_FRIENDS") == 1);
            } else if (this.av) {
                this.f16182t.m19742a();
                this.f16182t.m19743a(PrivacyType.PAGE);
            } else {
                this.f16182t.m19744a(PrivacyType.INVITE_ONLY, true);
            }
        }
        this.f16182t.m19752b();
    }

    private void m16508B() {
        this.f16177Z = (StartAndEndTimeNikumanPicker) a(2131561237);
        this.f16177Z.m19588a(this.f16168Q.f16050h);
    }

    private void m16546d(Bundle bundle) {
        String string;
        String string2;
        String str;
        long j;
        String str2 = null;
        if (Strings.isNullOrEmpty(bundle.getString("events_creation_story_cache_id"))) {
            String string3 = bundle.getString("events_creation_prefill_title", null);
            long j2 = bundle.getLong("events_creation_prefill_start_time", -1);
            string = bundle.getString("events_creation_prefill_theme_id", null);
            long j3 = j2;
            string2 = bundle.getString("events_creation_prefill_theme_url", null);
            str = string;
            j = j3;
            string = string3;
        } else {
            GraphQLStory c = this.f16184v.c(bundle.getString("events_creation_story_cache_id"));
            if (c != null) {
                GraphQLStoryAttachment o = StoryAttachmentHelper.o(c);
                if (o != null && o.j() != null && !o.j().isEmpty()) {
                    GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) o.j().get(0);
                    if (graphQLStoryActionLink.a() != null && graphQLStoryActionLink.a().g() == -89875450) {
                        GraphQLTemporalEventInfo aA = graphQLStoryActionLink.aA();
                        if (aA != null) {
                            String str3;
                            string = aA.k();
                            if (aA.j() == null || aA.j().k() == null) {
                                str3 = null;
                            } else {
                                str3 = aA.j().k().b();
                                str2 = aA.j().l();
                            }
                            string2 = str3;
                            str = str2;
                            j = aA.a();
                        } else {
                            string = null;
                            j = -1;
                            string2 = null;
                            str = null;
                        }
                    } else {
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (!Strings.isNullOrEmpty(string)) {
            this.f16168Q.f16045c = string;
        }
        if (j >= 0) {
            this.f16168Q.f16050h.m19538a(TimeUnit.MILLISECONDS.convert(j, TimeUnit.SECONDS), 0);
        }
        if (string2 != null) {
            EventCoverPhotoModel eventCoverPhotoModel = this.f16168Q.f16049g;
            eventCoverPhotoModel.f16329c = Uri.parse(string2);
            eventCoverPhotoModel.f16328b = str;
        } else if (str != null) {
            m16536b(str);
        }
    }

    private void m16536b(String str) {
        if (!Strings.isNullOrEmpty(str)) {
            FetchSingleEventThemePhotoQueryString fetchSingleEventThemePhotoQueryString = new FetchSingleEventThemePhotoQueryString();
            fetchSingleEventThemePhotoQueryString.a("theme_id", str);
            fetchSingleEventThemePhotoQueryString.a("theme_height", Integer.valueOf(1));
            fetchSingleEventThemePhotoQueryString.a("theme_width", Integer.valueOf(this.f16164L.c()));
            GraphQLRequest a = GraphQLRequest.a(new FetchSingleEventThemePhotoQueryString());
            a.a(fetchSingleEventThemePhotoQueryString.a);
            this.f16166N.a("fetch_single_theme", this.f16165M.a(a), new AbstractDisposableFutureCallback<GraphQLResult<FetchSingleEventThemePhotoQueryModel>>(this) {
                final /* synthetic */ EventCreationNikumanActivity f16138a;

                {
                    this.f16138a = r1;
                }

                protected final void m16492a(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    EventCoverPhotoModel eventCoverPhotoModel = this.f16138a.f16168Q.f16049g;
                    if (!eventCoverPhotoModel.m16809g() && graphQLResult != null) {
                        FetchSingleEventThemePhotoQueryModel fetchSingleEventThemePhotoQueryModel = (FetchSingleEventThemePhotoQueryModel) graphQLResult.e;
                        if (fetchSingleEventThemePhotoQueryModel != null && !Strings.isNullOrEmpty(fetchSingleEventThemePhotoQueryModel.m19879j()) && fetchSingleEventThemePhotoQueryModel.m19880k() != null && fetchSingleEventThemePhotoQueryModel.m19880k().m19872a() != null) {
                            eventCoverPhotoModel.f16329c = Uri.parse(fetchSingleEventThemePhotoQueryModel.m19880k().m19872a());
                            eventCoverPhotoModel.f16328b = fetchSingleEventThemePhotoQueryModel.m19879j();
                            this.f16138a.ac.m16824a(true);
                        }
                    }
                }

                protected final void m16493a(Throwable th) {
                }
            });
        }
    }

    private void m16509C() {
        if (this.ae != null) {
            this.ae.f19515a = new OnPrivacyChangedListener(this) {
                final /* synthetic */ EventCreationNikumanActivity f16139a;

                {
                    this.f16139a = r1;
                }

                public final void mo771a(PrivacyType privacyType) {
                    this.f16139a.m16528a(privacyType, null);
                    if (this.f16139a.f16182t != null) {
                        this.f16139a.f16182t.m19743a(privacyType);
                        this.f16139a.ab.f16310i = EventCreationNikumanActivity.m16543c(privacyType);
                        EventCreationNikumanActivity.m16535b(this.f16139a, privacyType);
                    }
                }
            };
        }
        if (this.f16170S != null) {
            this.f16170S.f19491a = new OnPrivacyOptionToggledListener(this) {
                final /* synthetic */ EventCreationNikumanActivity f16140a;

                {
                    this.f16140a = r1;
                }

                public final void mo772a(boolean z) {
                    if (this.f16140a.f16182t != null) {
                        this.f16140a.f16182t.m19744a(null, z);
                    }
                }
            };
        }
    }

    public static boolean m16543c(PrivacyType privacyType) {
        return privacyType != null && (privacyType == PrivacyType.INVITE_ONLY || privacyType == PrivacyType.GROUP || privacyType == PrivacyType.COMMUNITY);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 763749483);
        super.onPause();
        this.f16185w.m16627c();
        this.f16161I.f();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 806242801, a);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 368433998);
        super.onResume();
        this.f16161I.d();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 645027237, a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 102:
                    this.f16174W.m19644a(intent);
                    return;
                case 103:
                case 104:
                case 9913:
                    this.ac.m16822a(i, intent);
                    return;
                case 105:
                    this.ad.m16768a(intent);
                    return;
                case 108:
                    PageHostInfoFragmentModel pageHostInfoFragmentModel = (PageHostInfoFragmentModel) FlatBufferModelHelper.a(intent, "selected_host");
                    if (!m16532a(pageHostInfoFragmentModel)) {
                        m16569t();
                        this.aq = pageHostInfoFragmentModel;
                        m16567r(this);
                        return;
                    }
                    return;
                case 109:
                    this.af.m16803a(intent);
                    return;
                default:
                    return;
            }
        }
    }

    private boolean m16532a(PageHostInfoFragmentModel pageHostInfoFragmentModel) {
        if (this.aq == null && pageHostInfoFragmentModel == null) {
            return true;
        }
        if (this.aq == null || pageHostInfoFragmentModel == null) {
            return false;
        }
        return Objects.equal(this.aq.m16741l(), pageHostInfoFragmentModel.m16741l());
    }

    private void m16529a(EventCreateInputData eventCreateInputData) {
        List of;
        String str;
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a(this.al.d);
        eventActionHistory.b(m16515I().toString());
        if (this.al.c == null) {
            of = ImmutableList.of(eventActionHistory);
        } else {
            EventActionHistory eventActionHistory2 = new EventActionHistory();
            eventActionHistory2.a(this.al.c);
            if (this.am != null) {
                eventActionHistory2.b(this.am.toString());
            }
            of = ImmutableList.of(eventActionHistory2, eventActionHistory);
        }
        String stringExtra = getIntent().getStringExtra("events_creation_prompt_id");
        if (!Strings.isNullOrEmpty(stringExtra)) {
            eventCreateInputData.a("event_promotion_id", stringExtra);
        }
        EventVisibility d = this.f16182t.m19754d();
        EventCreateInputData.Context context = new EventCreateInputData.Context();
        context.a(of);
        EventCreateInputData a = eventCreateInputData.a(context);
        if (this.an == null) {
            str = this.f16158F.mUserId;
        } else {
            str = Long.toString(this.an.longValue());
        }
        a.a(str).b(this.f16168Q.f16045c).a(d).a(PrivacyUpdatePolicy.PRIVACY_LOCKED).a(m16550e(this.f16182t.f19539f));
        EventTimeModel eventTimeModel = this.f16168Q.f16050h;
        eventCreateInputData.c(EventsApiConstants.m19289a(eventTimeModel.m19540d(), eventTimeModel.f19388c, eventTimeModel.f19387b));
        if (eventTimeModel.m19541e()) {
            eventCreateInputData.d(EventsApiConstants.m19288a(eventTimeModel.m19542g(), eventTimeModel.f19388c));
        }
        if (this.f16168Q.m16448c()) {
            eventCreateInputData.e(this.f16168Q.f16046d);
        }
        EventLocationModel eventLocationModel = this.f16168Q.f16051i;
        if (eventLocationModel.f19462b > 0) {
            eventCreateInputData.g(Long.toString(eventLocationModel.f19462b));
        }
        if (eventLocationModel.f19463c != null) {
            eventCreateInputData.f(eventLocationModel.f19463c);
        }
        if (this.f16168Q.m16449j()) {
            eventCreateInputData.a("add_host_ids", this.f16168Q.f16052j.f16324a);
        }
        if (this.ak != null) {
            Enum enumR;
            if (this.ak.isChecked()) {
                enumR = PostApprovalRequired.TRUE;
            } else {
                enumR = PostApprovalRequired.FALSE;
            }
            eventCreateInputData.a("post_approval_required", enumR);
        }
        CoverPhotoInfo coverPhotoInfo;
        if (this.f16168Q.f16049g.m16810j()) {
            coverPhotoInfo = new CoverPhotoInfo();
            coverPhotoInfo.a("photo_id", this.f16168Q.f16049g.f16327a);
            coverPhotoInfo.a("photo_url", this.f16168Q.f16049g.m16808f());
            eventCreateInputData.a(coverPhotoInfo);
        } else if (this.f16168Q.f16049g.m16807d()) {
            coverPhotoInfo = new CoverPhotoInfo();
            coverPhotoInfo.a("theme_photo_id", this.f16168Q.f16049g.f16328b);
            eventCreateInputData.a(coverPhotoInfo);
        }
        if (this.ao != null) {
            eventCreateInputData.h(this.ao);
        } else if (this.f16158F.mIsPageContext) {
            eventCreateInputData.h(this.f16158F.mUserId);
        } else if (this.f16154B.booleanValue() && d == EventVisibility.COMMUNITY) {
            eventCreateInputData.h(this.f16162J);
        }
    }

    private static boolean m16544c(String str) {
        if (StringUtil.a(str)) {
            return true;
        }
        return Patterns.WEB_URL.matcher(str).find();
    }

    private boolean m16510D() {
        if (this.f16187y == Product.FB4A && this.f16182t.f19538e == PrivacyType.PAGE) {
            return true;
        }
        return false;
    }

    private static InvitePolicy m16550e(boolean z) {
        return z ? InvitePolicy.CAN_INVITE_FRIENDS : InvitePolicy.CANNOT_INVITE_FRIENDS;
    }

    public static void m16511E(EventCreationNikumanActivity eventCreationNikumanActivity) {
        if (StringUtil.a(eventCreationNikumanActivity.f16168Q.f16045c)) {
            Toaster.a(eventCreationNikumanActivity, 2131236906);
            return;
        }
        eventCreationNikumanActivity.f16178p.m16444a();
        EventCreateInputData eventCreateInputData = new EventCreateInputData();
        eventCreationNikumanActivity.m16529a(eventCreateInputData);
        if (eventCreationNikumanActivity.m16510D()) {
            if (!(eventCreationNikumanActivity.ah == null || eventCreationNikumanActivity.ah.getText() == null || StringUtil.a(eventCreationNikumanActivity.ah.getText().toString()))) {
                String trim = eventCreationNikumanActivity.ah.getText().toString().trim();
                if (!m16544c(trim)) {
                    Toast.makeText(eventCreationNikumanActivity, eventCreationNikumanActivity.getResources().getString(2131236940), 1).show();
                    return;
                } else if (!StringUtil.a(trim)) {
                    eventCreateInputData.a("event_buy_ticket_url", trim);
                }
            }
            if (eventCreationNikumanActivity.m16564o()) {
                if (StringUtil.a(eventCreationNikumanActivity.f16168Q.f16053k.f16316a)) {
                    Toast.makeText(eventCreationNikumanActivity, eventCreationNikumanActivity.getResources().getString(2131236941), 1).show();
                    return;
                }
                eventCreateInputData.a("category_name", eventCreationNikumanActivity.f16168Q.f16053k.f16316a);
            }
            eventCreateInputData.h(eventCreationNikumanActivity.aq.m16741l());
        }
        EventCoverPhotoModel eventCoverPhotoModel = eventCreationNikumanActivity.f16168Q.f16049g;
        eventCreationNikumanActivity.f16179q.m16466a(eventCreationNikumanActivity.kO_(), eventCreateInputData, eventCreationNikumanActivity.m16512F(), eventCreationNikumanActivity.ac.getHandler(), eventCoverPhotoModel.m16811k() ? eventCoverPhotoModel.f16329c : null, eventCreationNikumanActivity.al, eventCreationNikumanActivity.am, eventCreationNikumanActivity.m16513G());
    }

    private EventCreateMutationsControllerListener m16512F() {
        return new EventCreateMutationsControllerListener(this) {
            final /* synthetic */ EventCreationNikumanActivity f16141a;

            {
                this.f16141a = r1;
            }

            public final void mo773a(long j) {
                if (j > 0) {
                    this.f16141a.f16181s.a(new EventCreatedEvent(Long.toString(j)));
                    this.f16141a.m16522a(j);
                }
            }
        };
    }

    private void m16522a(long j) {
        if (this.f16187y == Product.PAA) {
            ((FbUriIntentHandler) this.f16157E.get()).a(this, StringFormatUtil.formatStrLocaleSafe(FBLinks.t, Long.valueOf(j)));
        } else if (this.f16187y != Product.GROUPS) {
            this.f16156D.a(this, Long.toString(j), this.al.b);
        }
        finish();
    }

    public void onBackPressed() {
        boolean z = true;
        m16514H(this);
        EventLocationModel eventLocationModel = this.f16168Q.f16051i;
        boolean z2;
        if (eventLocationModel.f19461a == null && StringUtil.a(eventLocationModel.f19463c)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!(!StringUtil.a(this.f16168Q.f16045c) || this.f16168Q.m16448c() || this.f16177Z.f19436h)) {
            Object obj;
            EventCompositionModel eventCompositionModel = this.f16168Q;
            if (eventCompositionModel.f16049g.m16807d() || eventCompositionModel.f16049g.m16811k() || eventCompositionModel.f16049g.m16810j()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (!(obj != null || r0 || this.f16168Q.m16449j())) {
                z = false;
            }
        }
        if (z) {
            EventDiscardConfirmationDialog.m16577a(this, new Object(this) {
                final /* synthetic */ EventCreationNikumanActivity f16142a;

                {
                    this.f16142a = r1;
                }

                public final void m16497a() {
                    EventCreationNikumanActivity.m16552f(this.f16142a, true);
                    super.onBackPressed();
                }
            });
            return;
        }
        m16552f(this, false);
        super.onBackPressed();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130968724, 2130968740);
    }

    private HoneyClientEventFast m16513G() {
        EventLocationModel pickedLocation = this.f16174W.getPickedLocation();
        boolean z = (pickedLocation.m19633a() == null && StringUtil.a(pickedLocation.m19635c())) ? false : true;
        EventEventLogger eventEventLogger = this.f16183u;
        long now = this.ap == 0 ? 0 : this.f16186x.now() - this.ap;
        int length = this.f16172U.getText().length();
        int longestEverMaxLength = this.f16172U.getLongestEverMaxLength();
        int length2 = this.f16176Y.getText().length();
        boolean a = this.f16177Z.m19589a();
        boolean z2 = this.ae != null && this.ae.m19731a();
        boolean z3 = this.f16170S != null && this.f16170S.m19682a();
        return eventEventLogger.m18122a(now, length, longestEverMaxLength, length2, a, z2, z3, this.f16174W.m19646a(), z, this.ad.m16770a(), this.ab.m16793a(), this.ab.m16794b(), this.ab.m16795e(), this.ab.m16796f());
    }

    public static void m16552f(EventCreationNikumanActivity eventCreationNikumanActivity, boolean z) {
        long j;
        boolean z2;
        boolean z3;
        EventLocationModel pickedLocation = eventCreationNikumanActivity.f16174W.getPickedLocation();
        boolean z4 = (pickedLocation.m19633a() == null && StringUtil.a(pickedLocation.m19635c())) ? false : true;
        EventEventLogger eventEventLogger = eventCreationNikumanActivity.f16183u;
        if (eventCreationNikumanActivity.ap == 0) {
            j = 0;
        } else {
            j = eventCreationNikumanActivity.f16186x.now() - eventCreationNikumanActivity.ap;
        }
        int length = eventCreationNikumanActivity.f16172U.getText().length();
        int longestEverMaxLength = eventCreationNikumanActivity.f16172U.getLongestEverMaxLength();
        int length2 = eventCreationNikumanActivity.f16176Y.getText().length();
        boolean a = eventCreationNikumanActivity.f16177Z.m19589a();
        if (eventCreationNikumanActivity.ae == null || !eventCreationNikumanActivity.ae.m19731a()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (eventCreationNikumanActivity.f16170S == null || !eventCreationNikumanActivity.f16170S.m19682a()) {
            z3 = false;
        } else {
            z3 = true;
        }
        eventEventLogger.m18137a(z, j, length, longestEverMaxLength, length2, a, z2, z3, eventCreationNikumanActivity.f16174W.m19646a(), z4, eventCreationNikumanActivity.ad.m16770a(), eventCreationNikumanActivity.ab.m16793a(), eventCreationNikumanActivity.ab.m16794b(), eventCreationNikumanActivity.ab.m16795e(), eventCreationNikumanActivity.ab.m16796f(), eventCreationNikumanActivity.f16182t.m19756f());
    }

    public static void m16514H(EventCreationNikumanActivity eventCreationNikumanActivity) {
        ((InputMethodManager) eventCreationNikumanActivity.getSystemService("input_method")).hideSoftInputFromWindow(eventCreationNikumanActivity.f16172U.getWindowToken(), 0);
    }

    public final String am_() {
        return "event_composer";
    }

    private void m16528a(PrivacyType privacyType, String str) {
        if (privacyType == PrivacyType.USER_PUBLIC && this.aq == null) {
            this.f16159G.m16636a(Integer.toString(1), this.aE);
        } else if (privacyType == PrivacyType.PAGE && this.aq == null) {
            PageEventCreationPageHostsPager pageEventCreationPageHostsPager = this.f16159G;
            C22568 c22568 = this.aF;
            pageEventCreationPageHostsPager.f16252d.a("fetchSinglePage", new C22703(pageEventCreationPageHostsPager, str), new C22714(pageEventCreationPageHostsPager, c22568));
        }
    }

    private ActionMechanism m16515I() {
        if (this.f16182t.f19538e == PrivacyType.PAGE) {
            return ActionMechanism.PAGE_CREATE_DIALOG;
        }
        return ActionMechanism.USER_CREATE_DIALOG;
    }
}
