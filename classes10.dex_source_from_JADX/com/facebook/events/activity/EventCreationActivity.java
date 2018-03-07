package com.facebook.events.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.title.IndicatorBarController;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.composition.EventCreateController;
import com.facebook.events.create.CreateEventPerformanceLogger;
import com.facebook.events.create.EventCreateMutationsController;
import com.facebook.events.create.EventCreateMutationsController.EventCreateMutationsControllerListener;
import com.facebook.events.create.LaunchEventComposerPerformanceLogger;
import com.facebook.events.create.ui.EventNameEditText;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.PrivacyType;
import com.facebook.events.permalinkintent.EventPermalinkIntentBuilder;
import com.facebook.events.protocol.CreateEventParams;
import com.facebook.events.protocol.EventsApiConstants;
import com.facebook.events.ui.date.StartAndEndTimePicker;
import com.facebook.events.ui.location.EventLocationModel;
import com.facebook.events.ui.location.LocationPicker;
import com.facebook.events.ui.location.LocationPickerLauncher;
import com.facebook.events.ui.privacy.EventCreationEducationWidget;
import com.facebook.events.ui.privacy.PrivacyOptionCheckbox;
import com.facebook.events.ui.privacy.PrivacyOptionCheckbox.OnPrivacyOptionToggledListener;
import com.facebook.events.ui.privacy.PrivacyPicker;
import com.facebook.events.ui.privacy.PrivacyPickerNikuman;
import com.facebook.events.ui.privacy.PrivacyPickerNikuman.OnPrivacyChangedListener;
import com.facebook.events.ui.privacy.PrivacyPickerNikumanController;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.graphql.calls.EventCreateInputData;
import com.facebook.graphql.calls.EventCreateInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventCreateInputData.InvitePolicy;
import com.facebook.graphql.calls.EventCreateInputData.PrivacyUpdatePolicy;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.TimeZone;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: content_search_collapsed */
public class EventCreationActivity extends FbFragmentActivity implements AnalyticsActivity {
    private static final Class<?> f15903C = EventCreationActivity.class;
    @Inject
    ViewerContextManager f15904A;
    @Inject
    IndicatorBarController f15905B;
    private CheckBox f15906D;
    private EventNameEditText f15907E;
    public LocationPicker f15908F;
    private MentionsAutoCompleteTextView f15909G;
    private PrivacyPicker f15910H;
    private Optional<PrivacyPickerNikuman> f15911I;
    private StartAndEndTimePicker f15912J;
    private EventAnalyticsParams f15913K;
    private ActionMechanism f15914L;
    private Long f15915M = null;
    private long f15916N;
    private boolean f15917O;
    @Inject
    CreateEventPerformanceLogger f15918p;
    @Inject
    EventCreateController f15919q;
    @Inject
    EventCreateMutationsController f15920r;
    @Inject
    PrivacyPickerNikumanController f15921s;
    @Inject
    EventEventLogger f15922t;
    @Inject
    LaunchEventComposerPerformanceLogger f15923u;
    @Inject
    MonotonicClock f15924v;
    @Inject
    Product f15925w;
    @Inject
    Provider<LocationPickerLauncher> f15926x;
    @Inject
    @IsWorkBuild
    Boolean f15927y;
    @Inject
    EventPermalinkIntentBuilder f15928z;

    /* compiled from: content_search_collapsed */
    class C22131 implements OnClickListener {
        final /* synthetic */ EventCreationActivity f15894a;

        C22131(EventCreationActivity eventCreationActivity) {
            this.f15894a = eventCreationActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1127616636);
            this.f15894a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1686374742, a);
        }
    }

    /* compiled from: content_search_collapsed */
    class C22142 extends OnToolbarButtonListener {
        final /* synthetic */ EventCreationActivity f15895a;

        C22142(EventCreationActivity eventCreationActivity) {
            this.f15895a = eventCreationActivity;
        }

        public final void m16332a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            EventCreationActivity.m16363r(this.f15895a);
            EventCreationActivity.m16360n(this.f15895a);
        }
    }

    /* compiled from: content_search_collapsed */
    class C22153 implements OnClickListener {
        final /* synthetic */ EventCreationActivity f15896a;

        C22153(EventCreationActivity eventCreationActivity) {
            this.f15896a = eventCreationActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 336891185);
            LocationPickerLauncher locationPickerLauncher = (LocationPickerLauncher) this.f15896a.f15926x.get();
            locationPickerLauncher.f19479c = this.f15896a.f15908F.f19475a;
            locationPickerLauncher = locationPickerLauncher;
            locationPickerLauncher.f19478b = EventCreationActivity.m16357k(this.f15896a);
            locationPickerLauncher.m19662a(this.f15896a, 102);
            Logger.a(2, EntryType.UI_INPUT_END, -1817392786, a);
        }
    }

    /* compiled from: content_search_collapsed */
    class C22164 implements OnPrivacyChangedListener {
        final /* synthetic */ EventCreationActivity f15897a;

        C22164(EventCreationActivity eventCreationActivity) {
            this.f15897a = eventCreationActivity;
        }

        public final void mo771a(PrivacyType privacyType) {
            if (this.f15897a.f15921s != null) {
                this.f15897a.f15921s.m19743a(privacyType);
            }
        }
    }

    /* compiled from: content_search_collapsed */
    class C22175 implements OnPrivacyOptionToggledListener {
        final /* synthetic */ EventCreationActivity f15898a;

        C22175(EventCreationActivity eventCreationActivity) {
            this.f15898a = eventCreationActivity;
        }

        public final void mo772a(boolean z) {
            if (this.f15898a.f15921s != null) {
                this.f15898a.f15921s.m19744a(null, z);
            }
        }
    }

    /* compiled from: content_search_collapsed */
    class C22186 implements EventCreateMutationsControllerListener {
        final /* synthetic */ EventCreationActivity f15899a;

        C22186(EventCreationActivity eventCreationActivity) {
            this.f15899a = eventCreationActivity;
        }

        public final void mo773a(long j) {
            if (j > 0) {
                this.f15899a.m16341a(j);
            }
        }
    }

    /* compiled from: content_search_collapsed */
    public class C22197 {
        final /* synthetic */ EventCreationActivity f15900a;

        public C22197(EventCreationActivity eventCreationActivity) {
            this.f15900a = eventCreationActivity;
        }

        public final void m16339a(long j) {
            if (j > 0) {
                this.f15900a.m16341a(j);
            }
        }
    }

    /* compiled from: content_search_collapsed */
    class C22208 implements DialogInterface.OnClickListener {
        final /* synthetic */ EventCreationActivity f15901a;

        C22208(EventCreationActivity eventCreationActivity) {
            this.f15901a = eventCreationActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: content_search_collapsed */
    class C22219 implements DialogInterface.OnClickListener {
        final /* synthetic */ EventCreationActivity f15902a;

        C22219(EventCreationActivity eventCreationActivity) {
            this.f15902a = eventCreationActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            EventCreationActivity.m16352c(this.f15902a, true);
            this.f15902a.setResult(0);
            this.f15902a.finish();
        }
    }

    private static <T extends Context> void m16348a(Class<T> cls, T t) {
        m16349a((Object) t, (Context) t);
    }

    public static void m16349a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventCreationActivity) obj).m16345a(CreateEventPerformanceLogger.m16442a(injectorLike), EventCreateController.m16440b(injectorLike), EventCreateMutationsController.m16465b(injectorLike), PrivacyPickerNikumanController.m19735b(injectorLike), EventEventLogger.m18119b(injectorLike), LaunchEventComposerPerformanceLogger.m16624a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 5707), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), EventPermalinkIntentBuilder.a(injectorLike), ViewerContextManagerProvider.b(injectorLike), IndicatorBarController.b(injectorLike));
    }

    private void m16345a(CreateEventPerformanceLogger createEventPerformanceLogger, EventCreateController eventCreateController, EventCreateMutationsController eventCreateMutationsController, PrivacyPickerNikumanController privacyPickerNikumanController, EventEventLogger eventEventLogger, LaunchEventComposerPerformanceLogger launchEventComposerPerformanceLogger, MonotonicClock monotonicClock, Product product, Provider<LocationPickerLauncher> provider, Boolean bool, EventPermalinkIntentBuilder eventPermalinkIntentBuilder, ViewerContextManager viewerContextManager, IndicatorBarController indicatorBarController) {
        this.f15918p = createEventPerformanceLogger;
        this.f15919q = eventCreateController;
        this.f15920r = eventCreateMutationsController;
        this.f15921s = privacyPickerNikumanController;
        this.f15922t = eventEventLogger;
        this.f15923u = launchEventComposerPerformanceLogger;
        this.f15924v = monotonicClock;
        this.f15925w = product;
        this.f15926x = provider;
        this.f15927y = bool;
        this.f15928z = eventPermalinkIntentBuilder;
        this.f15904A = viewerContextManager;
        this.f15905B = indicatorBarController;
    }

    public static Intent m16340a(Context context, Long l, String str, ActionMechanism actionMechanism) {
        Intent intent = new Intent(context, EventCreationActivity.class);
        intent.putExtra("extra_ref_module", str);
        intent.putExtra("extras_event_action_mechanism", actionMechanism);
        if (l != null) {
            intent.putExtra("com.facebook.katana.profile.id", l);
        }
        return intent;
    }

    private void m16355i() {
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        Builder a = TitleBarButtonSpec.a();
        a.a = 1;
        a = a;
        a.g = getString(2131236942);
        a = a;
        a.h = -2;
        TitleBarButtonSpec a2 = a.a();
        fbTitleBar.setShowDividers(true);
        if (this.f15917O) {
            fbTitleBar.setCustomTitleView(getLayoutInflater().inflate(2130904025, null, false));
        }
        fbTitleBar.setButtonSpecs(ImmutableList.of(a2));
        fbTitleBar.setHasBackButton(false);
        fbTitleBar.a(new C22131(this));
        fbTitleBar.setOnToolbarButtonListener(new C22142(this));
    }

    protected final void m16364b(Bundle bundle) {
        super.b(bundle);
        Class cls = EventCreationActivity.class;
        m16349a((Object) this, (Context) this);
        if (this.f15927y.booleanValue()) {
            finish();
        }
        this.f15923u.m16626a();
        if (getIntent().hasExtra("com.facebook.katana.profile.id")) {
            this.f15915M = Long.valueOf(getIntent().getLongExtra("com.facebook.katana.profile.id", -1));
        }
        setContentView(2130904013);
        ViewStub viewStub = (ViewStub) findViewById(2131561006);
        this.f15905B.f = (ViewStub) findViewById(2131568572);
        this.f15905B.b(viewStub);
        this.f15917O = this.f15925w == Product.FB4A;
        m16355i();
        this.f15911I = c(2131561273);
        this.f15907E = (EventNameEditText) a(2131561236);
        this.f15909G = (MentionsAutoCompleteTextView) a(2131561241);
        this.f15912J = (StartAndEndTimePicker) a(2131561237);
        this.f15912J.setTimeZone(TimeZone.getDefault());
        this.f15912J.m19617a(null, true);
        m16356j();
        if (this.f15917O) {
            m16359m();
        } else {
            m16358l();
        }
        this.f15906D = (CheckBox) a(2131561246);
        if (m16357k(this)) {
            this.f15906D.setVisibility(0);
        }
        this.f15922t.m18123a();
        this.f15916N = this.f15924v.now();
        Bundle extras = getIntent().getExtras();
        this.f15913K = new EventAnalyticsParams(EventActionContext.a, extras.getString("extra_ref_module"), am_().toString(), null);
        this.f15914L = (ActionMechanism) extras.getParcelable("extras_event_action_mechanism");
    }

    private void m16356j() {
        this.f15908F = (LocationPicker) a(2131561240);
        this.f15908F.setOnClickListener(new C22153(this));
    }

    public static boolean m16357k(EventCreationActivity eventCreationActivity) {
        return eventCreationActivity.f15925w == Product.PAA;
    }

    private void m16358l() {
        this.f15910H = (PrivacyPicker) a(2131561244);
        View a = a(2131561242);
        if (m16357k(this)) {
            this.f15910H.m19697a(PrivacyType.PAGE, true);
            a.setVisibility(8);
            return;
        }
        a.setVisibility(0);
    }

    private void m16359m() {
        EventCreationEducationWidget eventCreationEducationWidget = (EventCreationEducationWidget) a(2131561247);
        PrivacyOptionCheckbox privacyOptionCheckbox = (PrivacyOptionCheckbox) a(2131561245);
        PrivacyPickerNikuman privacyPickerNikuman = (PrivacyPickerNikuman) this.f15911I.get();
        privacyPickerNikuman.f19519e = false;
        this.f15921s.m19748a(privacyPickerNikuman, privacyOptionCheckbox);
        this.f15921s.m19746a(eventCreationEducationWidget);
        if (m16357k(this)) {
            this.f15921s.m19744a(PrivacyType.PAGE, true);
        } else {
            this.f15921s.m19744a(PrivacyType.INVITE_ONLY, true);
        }
        privacyPickerNikuman.f19515a = new C22164(this);
        if (privacyOptionCheckbox != null) {
            privacyOptionCheckbox.f19491a = new C22175(this);
        }
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 942673700);
        super.onResume();
        this.f15905B.d();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 748476714, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -536913182);
        super.onPause();
        this.f15923u.m16627c();
        this.f15905B.f();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1069787301, a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 102) {
            this.f15908F.setPickedLocation(new EventLocationModel(intent));
        }
    }

    private void m16347a(EventCreateInputData eventCreateInputData, String str, EventLocationModel eventLocationModel) {
        List of;
        String str2;
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a(this.f15913K.d);
        if (this.f15913K.c == null) {
            of = ImmutableList.of(eventActionHistory);
        } else {
            EventActionHistory eventActionHistory2 = new EventActionHistory();
            eventActionHistory2.a(this.f15913K.c);
            if (this.f15914L != null) {
                eventActionHistory2.b(this.f15914L.toString());
            }
            of = ImmutableList.of(eventActionHistory2, eventActionHistory);
        }
        EventCreateInputData.Context context = new EventCreateInputData.Context();
        context.a(of);
        EventCreateInputData a = eventCreateInputData.a(context);
        if (this.f15915M == null) {
            str2 = this.f15904A.d().mUserId;
        } else {
            str2 = Long.toString(this.f15915M.longValue());
        }
        a.a(str2).b(str).a(this.f15921s.m19754d()).a(PrivacyUpdatePolicy.PRIVACY_LOCKED).a(m16350b(this.f15921s.f19539f)).c(EventsApiConstants.m19289a(this.f15912J.getStartDate(), this.f15912J.getTimeZone(), this.f15912J.getIsDayEvent()));
        if (this.f15912J.getEndDate() != null) {
            eventCreateInputData.d(EventsApiConstants.m19288a(this.f15912J.getEndDate(), this.f15912J.getTimeZone()));
        }
        if (this.f15909G.getEncodedText() != null) {
            eventCreateInputData.e(this.f15909G.getEncodedText());
        }
        if (eventLocationModel.f19462b > 0) {
            eventCreateInputData.g(Long.toString(eventLocationModel.f19462b));
        }
        if (eventLocationModel.f19463c != null) {
            eventCreateInputData.f(eventLocationModel.f19463c);
        }
    }

    private static InvitePolicy m16350b(boolean z) {
        return z ? InvitePolicy.CAN_INVITE_FRIENDS : InvitePolicy.CANNOT_INVITE_FRIENDS;
    }

    private void m16346a(CreateEventParams.Builder builder, String str, EventLocationModel eventLocationModel) {
        builder.f19018a = this.f15913K.b;
        CreateEventParams.Builder builder2 = builder;
        builder2.f19020b = this.f15915M;
        builder2 = builder2;
        builder2.f19021c = str;
        builder2 = builder2;
        builder2.f19022d = this.f15909G.getEncodedText();
        builder2 = builder2;
        builder2.f19023e = eventLocationModel.f19462b;
        builder2 = builder2;
        builder2.f19030l = eventLocationModel.f19463c;
        builder2 = builder2;
        builder2.f19025g = this.f15912J.getIsDayEvent();
        builder2 = builder2;
        builder2.f19024f = this.f15912J.getStartDate();
        builder2 = builder2;
        builder2.f19026h = this.f15912J.getEndDate();
        builder2 = builder2;
        builder2.f19027i = this.f15912J.getTimeZone();
        builder2 = builder2;
        builder2.f19031m = this.f15906D.isChecked();
        builder2 = builder2;
        builder2.f19028j = this.f15910H.f19501b;
        builder2.f19029k = this.f15910H.f19502c;
    }

    public static void m16360n(EventCreationActivity eventCreationActivity) {
        String trim = eventCreationActivity.f15907E.getText().toString().trim();
        if (StringUtil.a(trim)) {
            Toaster.a(eventCreationActivity, 2131236906);
            return;
        }
        eventCreationActivity.f15918p.m16444a();
        EventLocationModel eventLocationModel = eventCreationActivity.f15908F.f19475a;
        if (eventCreationActivity.f15917O) {
            EventCreateInputData eventCreateInputData = new EventCreateInputData();
            eventCreationActivity.m16347a(eventCreateInputData, trim, eventLocationModel);
            eventCreationActivity.f15920r.m16466a(eventCreationActivity.kO_(), eventCreateInputData, eventCreationActivity.m16361o(), null, null, eventCreationActivity.f15913K, eventCreationActivity.f15914L, null);
            return;
        }
        CreateEventParams.Builder builder = new CreateEventParams.Builder();
        eventCreationActivity.m16346a(builder, trim, eventLocationModel);
        eventCreationActivity.f15919q.m16441a(eventCreationActivity.kO_(), builder.m19251a(), null, new C22197(eventCreationActivity));
    }

    private EventCreateMutationsControllerListener m16361o() {
        return new C22186(this);
    }

    private void m16341a(long j) {
        if (this.f15925w != Product.PAA) {
            this.f15928z.a(this, Long.toString(j), this.f15913K.b);
        }
        finish();
    }

    public void onBackPressed() {
        boolean z;
        m16363r(this);
        if (StringUtil.a(this.f15907E.getText().toString()) && StringUtil.a(this.f15909G.getText().toString()) && !this.f15912J.f19451h) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            m16352c(this, false);
            super.onBackPressed();
            return;
        }
        new AlertDialog.Builder(this).a(2131236898).b(2131236899).a(2131236900, new C22219(this)).b(2131236901, new C22208(this)).a(false).a().show();
    }

    public static void m16352c(EventCreationActivity eventCreationActivity, boolean z) {
        boolean z2;
        long j = 0;
        EventLocationModel eventLocationModel = eventCreationActivity.f15908F.f19475a;
        if (eventLocationModel.f19461a == null && StringUtil.a(eventLocationModel.f19463c)) {
            z2 = false;
        } else {
            z2 = true;
        }
        EventEventLogger eventEventLogger = eventCreationActivity.f15922t;
        if (eventCreationActivity.f15916N != 0) {
            j = eventCreationActivity.f15924v.now() - eventCreationActivity.f15916N;
        }
        eventEventLogger.m18136a(z, j, eventCreationActivity.f15907E.getText().length(), eventCreationActivity.f15907E.f16376d, eventCreationActivity.f15909G.getText().length(), eventCreationActivity.f15912J.f19451h, eventCreationActivity.m16362q(), z2);
    }

    private boolean m16362q() {
        if (this.f15910H != null) {
            return this.f15910H.f19503d;
        }
        if (this.f15911I.isPresent()) {
            return ((PrivacyPickerNikuman) this.f15911I.get()).f19522h;
        }
        return false;
    }

    public static void m16363r(EventCreationActivity eventCreationActivity) {
        ((InputMethodManager) eventCreationActivity.getSystemService("input_method")).hideSoftInputFromWindow(eventCreationActivity.f15907E.getWindowToken(), 0);
    }

    public final String am_() {
        return "event_composer";
    }
}
