package com.facebook.events.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.data.EventsCommonContract;
import com.facebook.events.data.EventsProvider;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventUpdatedEvent;
import com.facebook.events.graphql.EventsConverter;
import com.facebook.events.model.Event;
import com.facebook.events.model.PrivacyType;
import com.facebook.events.protocol.EditEventParams;
import com.facebook.events.protocol.EventsQueries;
import com.facebook.events.ui.date.StartAndEndTimePicker;
import com.facebook.events.ui.location.EventLocationModel;
import com.facebook.events.ui.location.LocationPicker;
import com.facebook.events.ui.location.LocationPickerLauncher;
import com.facebook.events.ui.privacy.PrivacyPicker;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.LocationModel;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: contentSearchParams */
public class EventEditActivity extends FbFragmentActivity {
    private EventActionContext f15934A;
    private FbTitleBar f15935B;
    private FbEditText f15936C;
    public MentionsAutoCompleteTextView f15937D;
    public LocationPicker f15938E;
    private StartAndEndTimePicker f15939F;
    private PrivacyPicker f15940G;
    private CheckBox f15941H;
    public ProgressDialog f15942I;
    private boolean f15943J;
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f15944p;
    @Inject
    DefaultBlueServiceOperationFactory f15945q;
    @Inject
    EventsCommonContract f15946r;
    @Inject
    EventsEventBus f15947s;
    @Inject
    EventsQueries f15948t;
    @Inject
    Product f15949u;
    @Inject
    Provider<LocationPickerLauncher> f15950v;
    @Inject
    TasksManager f15951w;
    @Inject
    Toaster f15952x;
    public Event f15953y;
    public Event f15954z;

    /* compiled from: contentSearchParams */
    class C22221 implements OnClickListener {
        final /* synthetic */ EventEditActivity f15929a;

        C22221(EventEditActivity eventEditActivity) {
            this.f15929a = eventEditActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 636774265);
            this.f15929a.onBackPressed();
            EventEditActivity.m16394s(this.f15929a);
            Logger.a(2, EntryType.UI_INPUT_END, -2083530635, a);
        }
    }

    /* compiled from: contentSearchParams */
    class C22232 extends OnToolbarButtonListener {
        final /* synthetic */ EventEditActivity f15930a;

        C22232(EventEditActivity eventEditActivity) {
            this.f15930a = eventEditActivity;
        }

        public final void m16365a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (StringUtil.a(EventEditActivity.m16390n(this.f15930a))) {
                this.f15930a.f15952x.b(new ToastBuilder(2131236906));
                return;
            }
            EventEditActivity.m16394s(this.f15930a);
            EventEditActivity.m16391o(this.f15930a);
        }
    }

    /* compiled from: contentSearchParams */
    class C22243 implements OnClickListener {
        final /* synthetic */ EventEditActivity f15931a;

        C22243(EventEditActivity eventEditActivity) {
            this.f15931a = eventEditActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -994959173);
            LocationPickerLauncher locationPickerLauncher = (LocationPickerLauncher) this.f15931a.f15950v.get();
            locationPickerLauncher.f19479c = this.f15931a.f15938E.f19475a;
            locationPickerLauncher = locationPickerLauncher;
            locationPickerLauncher.f19478b = EventEditActivity.m16387k(this.f15931a);
            locationPickerLauncher.m19662a(this.f15931a, 101);
            Logger.a(2, EntryType.UI_INPUT_END, 618226723, a);
        }
    }

    /* compiled from: contentSearchParams */
    class C22254 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ EventEditActivity f15932a;

        C22254(EventEditActivity eventEditActivity) {
            this.f15932a = eventEditActivity;
        }

        protected final void m16367a(Object obj) {
            Bundle bundle = ((OperationResult) obj).d.getBundle("result");
            if (bundle == null || !bundle.getBoolean("editEventResult")) {
                m16366b();
            } else {
                this.f15932a.f15948t.m19295a(this.f15932a.getResources().getDimensionPixelSize(2131431107), this.f15932a.f15954z.a);
            }
            this.f15932a.f15942I.dismiss();
            this.f15932a.f15942I = null;
            this.f15932a.setResult(-1);
            this.f15932a.f15947s.a(new EventUpdatedEvent(this.f15932a.f15954z.a));
            this.f15932a.finish();
        }

        protected final void m16368a(Throwable th) {
            BLog.b(EventEditActivity.class, "Error editing event: ", th);
            m16366b();
            this.f15932a.f15942I.dismiss();
            this.f15932a.f15942I = null;
            this.f15932a.setResult(-1);
            this.f15932a.finish();
        }

        private void m16366b() {
            EventsProvider.a(this.f15932a.getApplicationContext().getContentResolver(), this.f15932a.f15946r, this.f15932a.f15953y, this.f15932a.f15944p);
        }
    }

    /* compiled from: contentSearchParams */
    /* synthetic */ class C22265 {
        static final /* synthetic */ int[] f15933a = new int[PrivacyType.values().length];

        static {
            try {
                f15933a[PrivacyType.PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15933a[PrivacyType.USER_PUBLIC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15933a[PrivacyType.FRIENDS_OF_GUESTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15933a[PrivacyType.INVITE_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15933a[PrivacyType.FRIENDS_OF_FRIENDS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15933a[PrivacyType.GROUP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static <T extends Context> void m16376a(Class<T> cls, T t) {
        m16377a((Object) t, (Context) t);
    }

    public static void m16377a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventEditActivity) obj).m16375a(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), DefaultBlueServiceOperationFactory.b(fbInjector), EventsCommonContract.b(fbInjector), EventsEventBus.a(fbInjector), EventsQueries.m19293a(fbInjector), ProductMethodAutoProvider.b(fbInjector), IdBasedProvider.a(fbInjector, 5707), TasksManager.b(fbInjector), Toaster.b(fbInjector));
    }

    private void m16375a(ListeningExecutorService listeningExecutorService, BlueServiceOperationFactory blueServiceOperationFactory, EventsCommonContract eventsCommonContract, EventsEventBus eventsEventBus, EventsQueries eventsQueries, Product product, Provider<LocationPickerLauncher> provider, TasksManager tasksManager, Toaster toaster) {
        this.f15944p = listeningExecutorService;
        this.f15945q = blueServiceOperationFactory;
        this.f15946r = eventsCommonContract;
        this.f15947s = eventsEventBus;
        this.f15948t = eventsQueries;
        this.f15949u = product;
        this.f15950v = provider;
        this.f15951w = tasksManager;
        this.f15952x = toaster;
    }

    public static Intent m16369a(Context context, Event event, EventActionContext eventActionContext) {
        Intent intent = new Intent(context, EventEditActivity.class);
        intent.putExtra("extras_event", event);
        intent.putExtra("extras_event_action_context", eventActionContext);
        return intent;
    }

    protected final void m16395b(Bundle bundle) {
        super.b(bundle);
        Class cls = EventEditActivity.class;
        m16377a((Object) this, (Context) this);
        setContentView(2130904029);
        m16385i();
        m16374a((Event) getIntent().getParcelableExtra("extras_event"));
        this.f15934A = (EventActionContext) getIntent().getParcelableExtra("extras_event_action_context");
    }

    private void m16385i() {
        FbTitleBarUtil.b(this);
        this.f15935B = (FbTitleBar) a(2131558563);
        Builder a = TitleBarButtonSpec.a();
        a.a = 1;
        a = a;
        a.g = getString(2131236943);
        a = a;
        a.h = -2;
        this.f15935B.setButtonSpecs(ImmutableList.of(a.a()));
        this.f15935B.setHasBackButton(false);
        this.f15935B.a(new C22221(this));
        this.f15935B.setOnToolbarButtonListener(new C22232(this));
        this.f15936C = (FbEditText) a(2131561236);
        this.f15937D = (MentionsAutoCompleteTextView) a(2131561241);
        this.f15939F = (StartAndEndTimePicker) a(2131561237);
        m16386j();
        m16388l();
        this.f15941H = (CheckBox) a(2131561278);
    }

    private void m16386j() {
        this.f15938E = (LocationPicker) a(2131561240);
        this.f15938E.setOnClickListener(new C22243(this));
    }

    public static boolean m16387k(EventEditActivity eventEditActivity) {
        return eventEditActivity.f15953y.f != null && eventEditActivity.f15953y.f == PrivacyType.PAGE;
    }

    private void m16388l() {
        this.f15940G = (PrivacyPicker) a(2131561273);
        ((FbTextView) a(2131560822)).setText(getString(2131236928).toUpperCase(Locale.getDefault()));
    }

    private void m16374a(Event event) {
        boolean z;
        TimeZone timeZone;
        Date date;
        int i = 0;
        this.f15953y = event;
        this.f15941H.setVisibility(8);
        if (this.f15949u == Product.FB4A && event.k) {
            z = true;
        } else {
            z = false;
        }
        this.f15943J = z;
        if (this.f15943J) {
            View inflate = getLayoutInflater().inflate(2130904030, null, false);
            this.f15935B.setCustomTitleView(inflate);
            ((FbTextView) inflate.findViewById(2131561280)).setText(this.f15953y.b);
            FbTextView fbTextView = (FbTextView) inflate.findViewById(2131561281);
            fbTextView.setText(m16371a(event.f));
            fbTextView.setVisibility(0);
            if (event.f == PrivacyType.INVITE_ONLY) {
                this.f15941H.setVisibility(0);
                this.f15941H.setChecked(this.f15953y.h);
            }
        } else {
            this.f15935B.setTitle(this.f15953y.b);
        }
        this.f15936C.setText(this.f15953y.b);
        this.f15937D.setText(MentionsUtils.a(this.f15953y.c));
        this.f15938E.m19657a(this.f15953y.O, this.f15953y.P);
        if (this.f15953y.L == null) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = this.f15953y.L;
        }
        this.f15939F.setTimeZone(timeZone);
        this.f15939F.m19617a(this.f15953y.J(), this.f15953y.M);
        StartAndEndTimePicker startAndEndTimePicker = this.f15939F;
        if (this.f15953y.M) {
            date = null;
        } else {
            date = this.f15953y.L();
        }
        startAndEndTimePicker.setEndDate(date);
        View a = a(2131561242);
        if (this.f15953y.f == null || PrivacyPicker.m19690a(this.f15953y.f)) {
            i = 8;
        } else {
            this.f15940G.m19697a(this.f15953y.f, this.f15953y.h);
            if (this.f15943J) {
                i = 8;
            }
        }
        a.setVisibility(i);
    }

    private String m16389m() {
        if (this.f15953y.t == null) {
            return getResources().getString(2131241653);
        }
        return this.f15953y.t;
    }

    private String m16371a(PrivacyType privacyType) {
        switch (C22265.f15933a[privacyType.ordinal()]) {
            case 1:
            case 2:
                return getResources().getString(2131241637);
            case 3:
            case 4:
            case 5:
                return getResources().getString(2131241636);
            case 6:
                return m16389m();
            default:
                throw new IllegalArgumentException("Unsupported events privacy type: " + privacyType);
        }
    }

    public static String m16390n(EventEditActivity eventEditActivity) {
        return eventEditActivity.f15936C.getText().toString().trim();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 101 && i2 == -1) {
            this.f15938E.setPickedLocation(new EventLocationModel(intent));
        }
    }

    public static void m16391o(EventEditActivity eventEditActivity) {
        eventEditActivity.m16393r();
        eventEditActivity.f15954z = eventEditActivity.m16392p();
        EventsProvider.a(eventEditActivity.getContentResolver(), eventEditActivity.f15946r, eventEditActivity.f15954z, eventEditActivity.f15944p);
        Parcelable editEventParams = new EditEventParams(eventEditActivity.f15934A, eventEditActivity.f15953y, eventEditActivity.f15954z);
        Bundle bundle = new Bundle();
        bundle.putParcelable("editEventParams", editEventParams);
        eventEditActivity.f15951w.a("tasks-editEvent:" + eventEditActivity.f15953y.a, BlueServiceOperationFactoryDetour.a(eventEditActivity.f15945q, "edit_event", bundle, -1925315882).a(), new C22254(eventEditActivity));
    }

    private Event m16392p() {
        Date date;
        PrivacyType privacyType;
        boolean isChecked;
        boolean isDayEvent = this.f15939F.getIsDayEvent();
        Date startDate = this.f15939F.getStartDate();
        if (isDayEvent) {
            date = new Date(startDate.getTime() + 86399999);
        } else {
            date = this.f15939F.getEndDate();
        }
        if (this.f15940G.f19501b == null || this.f15940G.f19501b == PrivacyType.GROUP) {
            privacyType = this.f15953y.f;
        } else {
            privacyType = this.f15940G.f19501b;
        }
        Event.Builder builder = new Event.Builder(this.f15953y);
        builder.b = m16390n(this);
        builder = builder;
        GraphQLTextWithEntities.Builder builder2 = new GraphQLTextWithEntities.Builder();
        builder2.i = this.f15937D.getText().toString();
        builder2 = builder2;
        builder2.h = ImmutableList.copyOf(this.f15937D.getMentionsEntityRanges());
        builder.c = EventsConverter.a(builder2.a());
        builder = builder;
        builder.K = isDayEvent;
        Event.Builder builder3 = builder;
        builder3.H = startDate;
        builder3 = builder3;
        builder3.I = date;
        Event.Builder builder4 = builder3;
        builder4.J = this.f15939F.getTimeZone();
        builder4 = builder4;
        builder4.g = privacyType;
        Event.Builder builder5 = builder4;
        if (this.f15943J) {
            isChecked = this.f15941H.isChecked();
        } else {
            isChecked = this.f15940G.f19502c;
        }
        builder5.h = isChecked;
        builder4 = builder5;
        m16373a(builder4);
        return builder4.b();
    }

    private void m16373a(Event.Builder builder) {
        Object obj;
        Object obj2 = 1;
        EventLocationModel eventLocationModel = this.f15938E.f19475a;
        if (Event.b(this.f15953y.O) && Objects.equal(Long.valueOf(this.f15953y.O), Long.valueOf(eventLocationModel.f19462b))) {
            obj = 1;
        } else {
            obj = null;
        }
        if (Event.b(this.f15953y.O) || Event.b(eventLocationModel.f19462b) || !Objects.equal(this.f15953y.P, eventLocationModel.f19463c)) {
            obj2 = null;
        }
        if (obj != null || r1 != null) {
            return;
        }
        if (Event.b(eventLocationModel.f19462b)) {
            builder.a();
            CheckinPlaceModel checkinPlaceModel = eventLocationModel.f19461a;
            if (checkinPlaceModel != null) {
                double a;
                double b;
                String str;
                LocationModel cg_ = checkinPlaceModel.cg_();
                builder.M = Long.parseLong(checkinPlaceModel.cf_());
                Event.Builder builder2 = builder;
                builder2.N = checkinPlaceModel.j();
                Event.Builder builder3 = builder2;
                if (cg_ != null) {
                    a = cg_.a();
                } else {
                    a = 0.0d;
                }
                if (cg_ != null) {
                    b = cg_.b();
                } else {
                    b = 0.0d;
                }
                Event.Builder a2 = builder3.a(a, b);
                if (checkinPlaceModel.c() == null) {
                    str = null;
                } else {
                    str = checkinPlaceModel.c().b();
                }
                a2.O = str;
                return;
            }
            return;
        }
        builder.a(eventLocationModel.f19462b, eventLocationModel.f19463c);
    }

    private void m16393r() {
        this.f15942I = new ProgressDialog(this);
        this.f15942I.d = 0;
        this.f15942I.a(getText(2131236907));
        this.f15942I.a(true);
        this.f15942I.setCancelable(false);
        this.f15942I.show();
    }

    public static void m16394s(EventEditActivity eventEditActivity) {
        ((InputMethodManager) eventEditActivity.getSystemService("input_method")).hideSoftInputFromWindow(eventEditActivity.f15936C.getWindowToken(), 0);
    }
}
