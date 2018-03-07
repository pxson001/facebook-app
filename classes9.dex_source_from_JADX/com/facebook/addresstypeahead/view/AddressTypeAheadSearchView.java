package com.facebook.addresstypeahead.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Location;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.facebook.addresstypeahead.AddressTypeAheadActivity.C03461;
import com.facebook.addresstypeahead.analytics.AddressTypeAheadAnalyticsLogger;
import com.facebook.addresstypeahead.fetcher.AddressTypeAheadFetcher;
import com.facebook.addresstypeahead.fetcher.AddressTypeAheadFetcher.C03493;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.location.Coordinates;
import com.facebook.location.CoordinatesBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sender_status */
public class AddressTypeAheadSearchView extends CustomLinearLayout {
    public static final String f3946g = AddressTypeAheadSearchView.class.getSimpleName();
    @Inject
    AddressSuggestionsAdapter f3947a;
    @Inject
    AddressTypeAheadFetcher f3948b;
    @Inject
    TasksManager f3949c;
    @Inject
    AbstractFbErrorReporter f3950d;
    @Inject
    InputMethodManager f3951e;
    @Inject
    AddressTypeAheadAnalyticsLogger f3952f;
    private Handler f3953h;
    private SearchView f3954i;
    private GlyphView f3955j;
    private RecyclerView f3956k;
    private BetterTextView f3957l;
    private ProgressBar f3958m;
    private ProgressBar f3959n;
    public boolean f3960o;
    @Nullable
    public Location f3961p;
    @Nullable
    public String f3962q;
    @Nullable
    private String f3963r;
    @Nullable
    public C03461 f3964s;
    @Nullable
    public Runnable f3965t;

    /* compiled from: sender_status */
    class C03511 implements OnQueryTextListener {
        final /* synthetic */ AddressTypeAheadSearchView f3938a;

        C03511(AddressTypeAheadSearchView addressTypeAheadSearchView) {
            this.f3938a = addressTypeAheadSearchView;
        }

        public final boolean m3824a(String str) {
            this.f3938a.m3860a();
            this.f3938a.m3842b(str);
            return true;
        }

        public final boolean m3825b(String str) {
            this.f3938a.m3842b(str);
            return true;
        }
    }

    /* compiled from: sender_status */
    class C03522 implements OnClickListener {
        final /* synthetic */ AddressTypeAheadSearchView f3939a;

        C03522(AddressTypeAheadSearchView addressTypeAheadSearchView) {
            this.f3939a = addressTypeAheadSearchView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1928841966);
            Activity activity = (Activity) ContextUtils.a(this.f3939a.getContext(), Activity.class);
            if (activity != null) {
                this.f3939a.m3860a();
                activity.onBackPressed();
            } else {
                this.f3939a.f3950d.a(AddressTypeAheadSearchView.f3946g, "Can't find host activity.");
            }
            LogUtils.a(51765293, a);
        }
    }

    /* compiled from: sender_status */
    public class C03533 {
        final /* synthetic */ AddressTypeAheadSearchView f3940a;

        C03533(AddressTypeAheadSearchView addressTypeAheadSearchView) {
            this.f3940a = addressTypeAheadSearchView;
        }

        public final void m3826a(int i, Address address) {
            String str;
            Coordinates d;
            Coordinates d2;
            this.f3940a.m3860a();
            if (this.f3940a.f3960o && (!address.hasLatitude() || !address.hasLongitude())) {
                this.f3940a.m3832a(address);
            } else if (this.f3940a.f3964s != null) {
                this.f3940a.f3964s.m3762a(address);
            }
            AddressTypeAheadAnalyticsLogger addressTypeAheadAnalyticsLogger = this.f3940a.f3952f;
            String inputString = AddressTypeAheadSearchView.getInputString(this.f3940a);
            String address2 = address.toString();
            if (this.f3940a.f3960o) {
                str = "google";
            } else {
                str = "facebook";
            }
            String str2 = this.f3940a.f3962q;
            if (this.f3940a.f3961p != null) {
                CoordinatesBuilder newBuilder = Coordinates.newBuilder();
                newBuilder.a = Double.valueOf(this.f3940a.f3961p.getLatitude());
                newBuilder = newBuilder;
                newBuilder.b = Double.valueOf(this.f3940a.f3961p.getLongitude());
                d = newBuilder.d();
            } else {
                d = null;
            }
            if (address.hasLatitude() && address.hasLongitude()) {
                CoordinatesBuilder newBuilder2 = Coordinates.newBuilder();
                newBuilder2.a = Double.valueOf(address.getLatitude());
                newBuilder2 = newBuilder2;
                newBuilder2.b = Double.valueOf(address.getLongitude());
                d2 = newBuilder2.d();
            } else {
                d2 = null;
            }
            addressTypeAheadAnalyticsLogger.m3765a(inputString, i, address2, str, str2, d, d2);
        }
    }

    /* compiled from: sender_status */
    class C03544 extends AbstractDisposableFutureCallback<ImmutableList<Address>> {
        final /* synthetic */ AddressTypeAheadSearchView f3941a;

        C03544(AddressTypeAheadSearchView addressTypeAheadSearchView) {
            this.f3941a = addressTypeAheadSearchView;
        }

        protected final void m3827a(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            if (immutableList.isEmpty()) {
                this.f3941a.m3845c(this.f3941a.getResources().getString(2131241077));
                return;
            }
            AddressTypeAheadSearchView.m3859m(this.f3941a);
            this.f3941a.f3947a.m3823a(immutableList);
        }

        protected final void m3828a(Throwable th) {
            this.f3941a.m3845c(this.f3941a.getResources().getString(2131241077));
            this.f3941a.f3950d.a(AddressTypeAheadSearchView.f3946g, "Can't get Address type ahead result", th);
        }
    }

    /* compiled from: sender_status */
    enum Task {
        FETCH_ADDRESS_SUGGESTIONS,
        FETCH_ADDRESS_DETAIL
    }

    private static <T extends View> void m3836a(Class<T> cls, T t) {
        m3837a((Object) t, t.getContext());
    }

    private static void m3837a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AddressTypeAheadSearchView) obj).m3833a(new AddressSuggestionsAdapter(LayoutInflaterMethodAutoProvider.b(fbInjector)), AddressTypeAheadFetcher.m3768b(fbInjector), TasksManager.b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), InputMethodManagerMethodAutoProvider.b(fbInjector), new AddressTypeAheadAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(fbInjector)));
    }

    public AddressTypeAheadSearchView(Context context) {
        super(context);
        m3849e();
    }

    public AddressTypeAheadSearchView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m3849e();
    }

    public AddressTypeAheadSearchView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3849e();
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m3849e() {
        m3836a(AddressTypeAheadSearchView.class, (View) this);
        setContentView(2130903174);
        setOrientation(1);
        this.f3953h = new Handler();
        this.f3954i = (SearchView) a(2131559378);
        this.f3955j = (GlyphView) a(2131559376);
        this.f3956k = (RecyclerView) a(2131559379);
        this.f3957l = (BetterTextView) a(2131559380);
        this.f3958m = (ProgressBar) a(2131559381);
        this.f3959n = (ProgressBar) a(2131559377);
        this.f3960o = false;
        m3854h();
        m3850f();
        m3852g();
    }

    public void setProductTag(String str) {
        this.f3962q = str;
    }

    public void setCurrentLocation(@Nullable Location location) {
        this.f3961p = location;
    }

    public void setIsUsingGoogleApi(boolean z) {
        this.f3960o = z;
        this.f3947a.f3936c = this.f3960o;
    }

    public final void m3860a() {
        this.f3951e.hideSoftInputFromWindow(this.f3954i.getWindowToken(), 0);
    }

    public final void m3861b() {
        this.f3952f.m3766a(getInputString(this), "back_button_pressed", this.f3960o ? "google" : "facebook", this.f3962q);
        m3855i();
        this.f3949c.c();
    }

    public final void m3862c() {
        m3855i();
        this.f3949c.c();
    }

    public static String getInputString(AddressTypeAheadSearchView addressTypeAheadSearchView) {
        return addressTypeAheadSearchView.f3954i.getQuery() == null ? "" : addressTypeAheadSearchView.f3954i.getQuery().toString();
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m3850f() {
        this.f3954i.setQueryHint(getResources().getString(2131241076));
        this.f3954i.setIconifiedByDefault(false);
        this.f3954i.mOnQueryChangeListener = new C03511(this);
        this.f3954i.findViewById(2131559137).setLayoutParams(new LayoutParams(0, 0));
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m3852g() {
        this.f3955j.setOnClickListener(new C03522(this));
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m3854h() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.b(1);
        this.f3947a.f3937d = new C03533(this);
        this.f3956k.setLayoutManager(linearLayoutManager);
        this.f3956k.setAdapter(this.f3947a);
    }

    private void m3838a(String str) {
        m3856j();
        this.f3949c.a(Task.FETCH_ADDRESS_SUGGESTIONS, this.f3948b.m3769a(str, this.f3961p, 10, this.f3960o), new C03544(this));
    }

    private void m3832a(final Address address) {
        String string = address.getExtras().getString("google_place_id");
        if (Strings.isNullOrEmpty(string)) {
            this.f3950d.a(f3946g, "Can't get Google Place id.");
            return;
        }
        m3857k();
        TasksManager tasksManager = this.f3949c;
        Task task = Task.FETCH_ADDRESS_DETAIL;
        AddressTypeAheadFetcher addressTypeAheadFetcher = this.f3948b;
        tasksManager.a(task, Futures.a(addressTypeAheadFetcher.f3910b.a(Places.c), new C03493(addressTypeAheadFetcher, string), addressTypeAheadFetcher.f3913e), new AbstractDisposableFutureCallback<LatLng>(this) {
            final /* synthetic */ AddressTypeAheadSearchView f3943b;

            protected final void m3829a(@Nullable Object obj) {
                LatLng latLng = (LatLng) obj;
                AddressTypeAheadSearchView.m3858l(this.f3943b);
                if (latLng == null || this.f3943b.f3964s == null) {
                    this.f3943b.f3950d.a(AddressTypeAheadSearchView.f3946g, "Error getting during fetch onSuccessfulResult.");
                    return;
                }
                address.setLatitude(latLng.a);
                address.setLongitude(latLng.b);
                this.f3943b.f3964s.m3762a(address);
            }

            protected final void m3830a(Throwable th) {
                AddressTypeAheadSearchView.m3858l(this.f3943b);
                this.f3943b.f3950d.a(AddressTypeAheadSearchView.f3946g, "Can't get location from Google Place id.", th);
            }
        });
    }

    private void m3842b(String str) {
        final String trim = str.trim();
        if (this.f3963r == null || !this.f3963r.equals(trim)) {
            m3855i();
            this.f3963r = trim;
            if (Strings.isNullOrEmpty(trim)) {
                m3845c(getResources().getString(2131241078));
                return;
            }
            this.f3965t = new Runnable(this) {
                final /* synthetic */ AddressTypeAheadSearchView f3945b;

                public void run() {
                    this.f3945b.f3965t = null;
                    this.f3945b.m3838a(trim);
                }
            };
            HandlerDetour.b(this.f3953h, this.f3965t, 750, 743381626);
        }
    }

    private void m3833a(AddressSuggestionsAdapter addressSuggestionsAdapter, AddressTypeAheadFetcher addressTypeAheadFetcher, TasksManager tasksManager, AbstractFbErrorReporter abstractFbErrorReporter, InputMethodManager inputMethodManager, AddressTypeAheadAnalyticsLogger addressTypeAheadAnalyticsLogger) {
        this.f3947a = addressSuggestionsAdapter;
        this.f3948b = addressTypeAheadFetcher;
        this.f3949c = tasksManager;
        this.f3950d = abstractFbErrorReporter;
        this.f3951e = inputMethodManager;
        this.f3952f = addressTypeAheadAnalyticsLogger;
    }

    private void m3855i() {
        if (this.f3965t != null) {
            HandlerDetour.a(this.f3953h, this.f3965t);
        }
    }

    private void m3856j() {
        this.f3957l.setVisibility(4);
        this.f3956k.setVisibility(4);
        this.f3958m.setVisibility(0);
    }

    private void m3857k() {
        this.f3959n.setVisibility(0);
        this.f3955j.setVisibility(4);
    }

    public static void m3858l(AddressTypeAheadSearchView addressTypeAheadSearchView) {
        addressTypeAheadSearchView.f3955j.setVisibility(0);
        addressTypeAheadSearchView.f3959n.setVisibility(4);
    }

    private void m3845c(String str) {
        this.f3958m.setVisibility(4);
        this.f3956k.setVisibility(4);
        this.f3957l.setText(str);
        this.f3957l.setVisibility(0);
    }

    public static void m3859m(AddressTypeAheadSearchView addressTypeAheadSearchView) {
        addressTypeAheadSearchView.f3958m.setVisibility(4);
        addressTypeAheadSearchView.f3957l.setVisibility(4);
        addressTypeAheadSearchView.f3956k.setVisibility(0);
    }
}
