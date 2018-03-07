package com.facebook.adinterfaces;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesTargetingData;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdGeoCircleModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel.Builder;
import com.facebook.adinterfaces.protocol.ReachEstimateDataQuery.ReachEstimateQueryString;
import com.facebook.adinterfaces.protocol.ReachEstimationMethod;
import com.facebook.adinterfaces.protocol.ReachEstimationMethod.C25521;
import com.facebook.adinterfaces.protocol.ReachEstimationMethod.Tasks;
import com.facebook.adinterfaces.ui.MapSpinnerView;
import com.facebook.adinterfaces.ui.MapSpinnerView.State;
import com.facebook.adinterfaces.util.MapPickerGeoHelperMetric;
import com.facebook.adinterfaces.util.MapPickerLocaleAwareGeoHelper;
import com.facebook.adinterfaces.util.targeting.AdInterfacesTargetingDelegate;
import com.facebook.android.maps.CameraUpdateFactory;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.FacebookMap.OnCameraChangeListener;
import com.facebook.android.maps.FacebookMap.OnMapLoadedCallback;
import com.facebook.android.maps.FacebookMapOptions;
import com.facebook.android.maps.OnMapReadyCallback;
import com.facebook.android.maps.Projection;
import com.facebook.android.maps.SupportMapFragment;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.LatLng;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.feedplugins.localad.AdInterfacesLocationFetcher;
import com.facebook.feedplugins.localad.AdInterfacesLocationFetcher.C29751;
import com.facebook.feedplugins.localad.AdInterfacesLocationFetcher.Key;
import com.facebook.feedplugins.localad.AdInterfacesLocationFetcher.LocationFetcherListener;
import com.facebook.graphql.calls.BidForInputBidFor;
import com.facebook.graphql.enums.GraphQLAdGeoLocationType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.Locations;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.facebook.widget.titlebar.FbActionBarUtil;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableList;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: aa6858001fd6f9ce42a8453ce88a9d6e */
public class MapAreaPickerActivity extends FbFragmentActivity implements OnMapLoadedCallback, OnMapReadyCallback {
    public TextView f21574A;
    private TextView f21575B;
    private View f21576C;
    public String f21577D;
    public float f21578E;
    public double f21579F;
    public double f21580G;
    public boolean f21581H;
    public ProgressBar f21582I;
    private AdInterfacesTargetingData f21583J;
    private String f21584K;
    public SpannableString f21585L;
    private ActionBarBasedFbTitleBar f21586M;
    private boolean f21587N;
    private double f21588O;
    public int f21589P;
    private PopoverMenuWindow f21590Q;
    private View f21591R;
    public String f21592S;
    @Inject
    AdInterfacesDataHelper f21593p;
    @Inject
    MapPickerLocaleAwareGeoHelper f21594q;
    @Inject
    TasksManager f21595r;
    @Inject
    ReachEstimationMethod f21596s;
    @Inject
    Locales f21597t;
    @Inject
    AppCompatActivityOverrider f21598u;
    @Inject
    Product f21599v;
    @Inject
    FbActionBarUtil f21600w;
    @Inject
    AdInterfacesLocationFetcher f21601x;
    public MapSpinnerView f21602y;
    public SupportMapFragment f21603z;

    /* compiled from: aa6858001fd6f9ce42a8453ce88a9d6e */
    class C24961 implements OnClickListener {
        final /* synthetic */ MapAreaPickerActivity f21563a;

        C24961(MapAreaPickerActivity mapAreaPickerActivity) {
            this.f21563a = mapAreaPickerActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2004343460);
            this.f21563a.m22583j();
            Logger.a(2, EntryType.UI_INPUT_END, -955665818, a);
        }
    }

    /* compiled from: aa6858001fd6f9ce42a8453ce88a9d6e */
    class C24982 implements OnCameraChangeListener {
        final /* synthetic */ MapAreaPickerActivity f21565a;

        /* compiled from: aa6858001fd6f9ce42a8453ce88a9d6e */
        class C24971 implements OnMapReadyCallback {
            final /* synthetic */ C24982 f21564a;

            C24971(C24982 c24982) {
                this.f21564a = c24982;
            }

            public final void m22532a(FacebookMap facebookMap) {
                this.f21564a.f21565a.f21596s.m24268a();
                this.f21564a.f21565a.f21602y.setState(State.LOADING);
                if (!this.f21564a.f21565a.f21581H) {
                    this.f21564a.f21565a.f21581H = true;
                    MapPickerLocaleAwareGeoHelper mapPickerLocaleAwareGeoHelper = this.f21564a.f21565a.f21594q;
                    facebookMap.a = FacebookMap.c((float) ((Math.log(MapPickerGeoHelperMetric.m25279a(facebookMap.k, this.f21564a.f21565a.f21602y) / mapPickerLocaleAwareGeoHelper.f23343a.f23339a) / Math.log(2.0d)) + ((double) facebookMap.c().b)));
                    if (facebookMap.A.getZoom() > facebookMap.a) {
                        facebookMap.A.c(facebookMap.a, facebookMap.k(), facebookMap.l());
                        facebookMap.A.invalidate();
                    }
                    mapPickerLocaleAwareGeoHelper = this.f21564a.f21565a.f21594q;
                    View view = this.f21564a.f21565a.f21602y;
                    MapPickerGeoHelperMetric mapPickerGeoHelperMetric = mapPickerLocaleAwareGeoHelper.f23343a;
                    facebookMap.b = FacebookMap.c((float) (((double) facebookMap.c().b) - (Math.log(mapPickerGeoHelperMetric.f23340b / MapPickerGeoHelperMetric.m25279a(facebookMap.k, view)) / Math.log(2.0d))));
                    if (facebookMap.A.getZoom() < facebookMap.b) {
                        facebookMap.A.c(facebookMap.b, facebookMap.k(), facebookMap.l());
                        facebookMap.A.invalidate();
                    }
                }
                facebookMap.a(this.f21564a.f21565a);
            }
        }

        C24982(MapAreaPickerActivity mapAreaPickerActivity) {
            this.f21565a = mapAreaPickerActivity;
        }

        public final void m22533a(CameraPosition cameraPosition) {
            this.f21565a.f21601x.m26564a();
            this.f21565a.f21603z.a(new C24971(this));
        }
    }

    /* compiled from: aa6858001fd6f9ce42a8453ce88a9d6e */
    class C24993 implements OnMapReadyCallback {
        final /* synthetic */ MapAreaPickerActivity f21566a;

        C24993(MapAreaPickerActivity mapAreaPickerActivity) {
            this.f21566a = mapAreaPickerActivity;
        }

        public final void m22534a(FacebookMap facebookMap) {
            this.f21566a.f21602y.setState(State.IDLE);
            LatLng latLng = facebookMap.c().a;
            this.f21566a.f21579F = latLng.a;
            this.f21566a.f21580G = latLng.b;
            this.f21566a.f21578E = facebookMap.c().b;
            MapAreaPickerActivity.m22556b(this.f21566a, facebookMap);
        }
    }

    /* compiled from: aa6858001fd6f9ce42a8453ce88a9d6e */
    public class C25004 {
        final /* synthetic */ MapAreaPickerActivity f21567a;

        C25004(MapAreaPickerActivity mapAreaPickerActivity) {
            this.f21567a = mapAreaPickerActivity;
        }

        public final void m22535a(int i) {
            this.f21567a.f21574A.setText(i == -1 ? this.f21567a.f21585L : Html.fromHtml(StringFormatUtil.formatStrLocaleSafe(this.f21567a.f21577D, this.f21567a.f21593p.m22822a(i))));
            this.f21567a.f21574A.setVisibility(0);
            this.f21567a.f21582I.setVisibility(8);
        }
    }

    /* compiled from: aa6858001fd6f9ce42a8453ce88a9d6e */
    class C25015 implements LocationFetcherListener {
        final /* synthetic */ MapAreaPickerActivity f21568a;

        C25015(MapAreaPickerActivity mapAreaPickerActivity) {
            this.f21568a = mapAreaPickerActivity;
        }

        public final void mo945a(@Nullable AdGeoCircleModel adGeoCircleModel) {
            this.f21568a.m22549a(adGeoCircleModel, 2131234017);
        }
    }

    /* compiled from: aa6858001fd6f9ce42a8453ce88a9d6e */
    class C25026 implements LocationFetcherListener {
        final /* synthetic */ MapAreaPickerActivity f21569a;

        C25026(MapAreaPickerActivity mapAreaPickerActivity) {
            this.f21569a = mapAreaPickerActivity;
        }

        public final void mo945a(@Nullable AdGeoCircleModel adGeoCircleModel) {
            this.f21569a.m22549a(adGeoCircleModel, 2131234018);
        }
    }

    /* compiled from: aa6858001fd6f9ce42a8453ce88a9d6e */
    class C25048 extends OnToolbarButtonListener {
        final /* synthetic */ MapAreaPickerActivity f21572a;

        C25048(MapAreaPickerActivity mapAreaPickerActivity) {
            this.f21572a = mapAreaPickerActivity;
        }

        public final void m22540a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            MapAreaPickerActivity.m22574o(this.f21572a);
        }
    }

    /* compiled from: aa6858001fd6f9ce42a8453ce88a9d6e */
    class C25059 implements OnBackPressedListener {
        final /* synthetic */ MapAreaPickerActivity f21573a;

        C25059(MapAreaPickerActivity mapAreaPickerActivity) {
            this.f21573a = mapAreaPickerActivity;
        }

        public final void m22541a() {
            this.f21573a.onBackPressed();
        }
    }

    private static <T extends Context> void m22551a(Class<T> cls, T t) {
        m22552a((Object) t, (Context) t);
    }

    public static void m22552a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MapAreaPickerActivity) obj).m22548a(AdInterfacesDataHelper.m22789a(injectorLike), MapPickerLocaleAwareGeoHelper.m25281a(injectorLike), TasksManager.b(injectorLike), ReachEstimationMethod.m24266a(injectorLike), Locales.a(injectorLike), AppCompatActivityOverrider.b(injectorLike), ProductMethodAutoProvider.b(injectorLike), FbActionBarUtil.a(injectorLike), AdInterfacesLocationFetcher.m26563b(injectorLike));
    }

    private void m22548a(AdInterfacesDataHelper adInterfacesDataHelper, MapPickerLocaleAwareGeoHelper mapPickerLocaleAwareGeoHelper, TasksManager tasksManager, ReachEstimationMethod reachEstimationMethod, Locales locales, AppCompatActivityOverrider appCompatActivityOverrider, Product product, FbActionBarUtil fbActionBarUtil, AdInterfacesLocationFetcher adInterfacesLocationFetcher) {
        this.f21593p = adInterfacesDataHelper;
        this.f21594q = mapPickerLocaleAwareGeoHelper;
        this.f21595r = tasksManager;
        this.f21596s = reachEstimationMethod;
        this.f21597t = locales;
        this.f21598u = appCompatActivityOverrider;
        this.f21599v = product;
        this.f21600w = fbActionBarUtil;
        this.f21601x = adInterfacesLocationFetcher;
    }

    protected final void m22578a(@Nullable Bundle bundle) {
        super.a(bundle);
        Class cls = MapAreaPickerActivity.class;
        m22552a((Object) this, (Context) this);
        this.f21587N = this.f21600w.a();
        if (this.f21587N) {
            a(this.f21598u);
        }
    }

    public final void m22580b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903125);
        this.f21577D = getString(2131233950);
        this.f21585L = new SpannableString(getString(2131234059));
        this.f21602y = (MapSpinnerView) a(2131559303);
        this.f21574A = (TextView) a(2131559305);
        this.f21575B = (TextView) a(2131559304);
        this.f21576C = a(2131559249);
        this.f21582I = (ProgressBar) a(2131559306);
        this.f21591R = a(2131559302);
        this.f21589P = ((int) getResources().getDimension(2131429294)) / 2;
        m22561d(getIntent().getExtras());
        this.f21576C.setOnClickListener(new C24961(this));
        FacebookMapOptions facebookMapOptions = new FacebookMapOptions();
        facebookMapOptions.d = false;
        facebookMapOptions = facebookMapOptions;
        facebookMapOptions.m = "ad_area_picker";
        this.f21603z = SupportMapFragment.a(facebookMapOptions);
        kO_().a().b(2131559301, this.f21603z, "map_fragment").b();
        m22571l();
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1526318272);
        super.onResume();
        this.f21603z.a(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -439132195, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -223003952);
        super.onPause();
        this.f21603z.H();
        this.f21601x.m26564a();
        if (this.f21590Q != null) {
            this.f21590Q.l();
        }
        this.f21595r.c("get_location_task_key");
        this.f21596s.m24268a();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -313101851, a);
    }

    public final void m22579a(FacebookMap facebookMap) {
        LatLng latLng = new LatLng(this.f21579F, this.f21580G);
        facebookMap.b(CameraUpdateFactory.a(latLng, this.f21594q.m25284a(facebookMap, latLng, this.f21588O, this.f21589P)));
        facebookMap.b();
        this.f21581H = false;
        facebookMap.a(this);
        facebookMap.g = new C24982(this);
    }

    public final void m22577a() {
        this.f21603z.a(new C24993(this));
    }

    public static void m22556b(MapAreaPickerActivity mapAreaPickerActivity, FacebookMap facebookMap) {
        mapAreaPickerActivity.f21574A.setVisibility(8);
        mapAreaPickerActivity.f21582I.setVisibility(0);
        mapAreaPickerActivity.f21588O = mapAreaPickerActivity.f21594q.m25283a(facebookMap.k, mapAreaPickerActivity.f21602y);
        Builder builder = new Builder();
        builder.f22135d = AdInterfacesTargetingDelegate.m25299a(mapAreaPickerActivity.f21597t);
        builder = builder;
        builder.f22137f = mapAreaPickerActivity.f21579F;
        builder = builder;
        builder.f22139h = mapAreaPickerActivity.f21580G;
        builder = builder;
        builder.f22141j = mapAreaPickerActivity.f21588O;
        builder = builder;
        builder.f22138g = GraphQLAdGeoLocationType.CUSTOM_LOCATION;
        mapAreaPickerActivity.f21583J.f21725e = ImmutableList.of(builder.m23431a());
        ReachEstimationMethod reachEstimationMethod = mapAreaPickerActivity.f21596s;
        AdInterfacesTargetingData adInterfacesTargetingData = mapAreaPickerActivity.f21583J;
        reachEstimationMethod.f22411b.a(Tasks.REACH_TASK, reachEstimationMethod.f22410a.a(GraphQLRequest.a((ReachEstimateQueryString) new ReachEstimateQueryString().a("account_id", mapAreaPickerActivity.f21584K).a("bid_for", BidForInputBidFor.IMPRESSION).a("targeting_spec", adInterfacesTargetingData.m22837a(true)))), new C25521(reachEstimationMethod, new C25004(mapAreaPickerActivity)));
        TextView textView = mapAreaPickerActivity.f21575B;
        MapPickerLocaleAwareGeoHelper mapPickerLocaleAwareGeoHelper = mapAreaPickerActivity.f21594q;
        Projection projection = facebookMap.k;
        View view = mapAreaPickerActivity.f21602y;
        if (mapPickerLocaleAwareGeoHelper.f23347e == null) {
            mapPickerLocaleAwareGeoHelper.f23347e = mapPickerLocaleAwareGeoHelper.f23345c.getString(mapPickerLocaleAwareGeoHelper.f23346d ? 2131233947 : 2131233948);
        }
        textView.setText(Html.fromHtml(StringFormatUtil.formatStrLocaleSafe(mapPickerLocaleAwareGeoHelper.f23347e, Double.valueOf(mapPickerLocaleAwareGeoHelper.m25283a(projection, view)))));
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m22559c(bundle);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        m22561d(bundle);
    }

    private void m22559c(Bundle bundle) {
        bundle.putDouble("radius_extra", this.f21588O);
        bundle.putParcelable("location_extra", Locations.a(this.f21579F, this.f21580G));
        bundle.putParcelable("target_spec_extra", this.f21583J);
        bundle.putString("ad_account_id_extra", this.f21584K);
    }

    private void m22561d(Bundle bundle) {
        this.f21588O = bundle.getDouble("radius_extra");
        Location location = (Location) bundle.getParcelable("location_extra");
        this.f21579F = location.getLatitude();
        this.f21580G = location.getLongitude();
        this.f21583J = (AdInterfacesTargetingData) bundle.getParcelable("target_spec_extra");
        this.f21584K = bundle.getString("ad_account_id_extra");
    }

    public final void m22582i() {
        this.f21602y.setState(State.LOADING);
        m22568k();
    }

    public final void m22581b(String str) {
        this.f21602y.setState(State.LOADING);
        AdInterfacesLocationFetcher adInterfacesLocationFetcher = this.f21601x;
        LocationFetcherListener c25015 = new C25015(this);
        adInterfacesLocationFetcher.f24676i.c(Key.FETCH_RADIUS);
        adInterfacesLocationFetcher.f24677j.m23050a(str, new C29751(adInterfacesLocationFetcher, c25015));
    }

    private void m22568k() {
        this.f21602y.setState(State.LOADING);
        this.f21601x.m26565a(new C25026(this), (Activity) this);
    }

    private void m22549a(@Nullable final AdGeoCircleModel adGeoCircleModel, int i) {
        if (adGeoCircleModel == null) {
            m22555b(i);
        } else {
            this.f21603z.a(new OnMapReadyCallback(this) {
                final /* synthetic */ MapAreaPickerActivity f21571b;

                public final void m22539a(FacebookMap facebookMap) {
                    LatLng latLng = new LatLng(adGeoCircleModel.m23172a(), adGeoCircleModel.m23176b());
                    this.f21571b.f21578E = this.f21571b.f21594q.m25284a(facebookMap, latLng, adGeoCircleModel.m23177c(), this.f21571b.f21589P);
                    facebookMap.b(CameraUpdateFactory.a(latLng, this.f21571b.f21578E));
                }
            });
        }
    }

    private void m22555b(int i) {
        this.f21602y.setState(State.IDLE);
        Toast.makeText(getBaseContext(), i, 0).show();
    }

    private void m22571l() {
        if (this.f21599v == Product.PAA) {
            m22572m();
        } else if (this.f21599v == Product.FB4A) {
            m22573n();
        }
    }

    private void m22572m() {
        this.f21586M = new ActionBarBasedFbTitleBar(this, this.f21598u.g());
        this.f21586M.setTitle(2131234037);
        this.f21586M.setHasBackButton(true);
        this.f21586M.setButtonSpecs(ImmutableList.of(m22575p()));
        this.f21586M.setOnToolbarButtonListener(new C25048(this));
        this.f21586M.setOnBackPressedListener(new C25059(this));
    }

    private void m22573n() {
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.setHasBackButton(true);
        fbTitleBar.setTitle(getString(2131234037));
        fbTitleBar.setButtonSpecs(ImmutableList.of(m22575p()));
        fbTitleBar.setOnToolbarButtonListener(new OnToolbarButtonListener(this) {
            final /* synthetic */ MapAreaPickerActivity f21555a;

            {
                this.f21555a = r1;
            }

            public final void m22531a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                MapAreaPickerActivity.m22574o(this.f21555a);
            }
        });
        fbTitleBar.a(new OnClickListener(this) {
            final /* synthetic */ MapAreaPickerActivity f21556a;

            {
                this.f21556a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1887812537);
                this.f21556a.onBackPressed();
                Logger.a(2, EntryType.UI_INPUT_END, 32380026, a);
            }
        });
    }

    public static void m22574o(MapAreaPickerActivity mapAreaPickerActivity) {
        Bundle bundle = new Bundle();
        mapAreaPickerActivity.m22559c(bundle);
        mapAreaPickerActivity.setResult(-1, new Intent().putExtras(bundle));
        mapAreaPickerActivity.finish();
    }

    private TitleBarButtonSpec m22575p() {
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.n = true;
        a = a;
        a.a = 1;
        a = a;
        a.g = getString(2131233984).toUpperCase(Locale.getDefault());
        a = a;
        a.h = -2;
        return a.a();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        if (this.f21587N) {
            this.f21586M.a(menu);
        }
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f21587N && this.f21586M.a(menuItem)) {
            return false;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public final void m22583j() {
        if (this.f21590Q != null && this.f21590Q.r) {
            this.f21590Q.l();
        }
        this.f21590Q = new PopoverMenuWindow(this);
        PopoverMenu c = this.f21590Q.c();
        m22550a(c);
        this.f21590Q.a(c);
        this.f21590Q.c(true);
        this.f21590Q.c(this.f21591R);
        this.f21590Q.d();
    }

    private void m22550a(PopoverMenu popoverMenu) {
        popoverMenu.a(getResources().getColorStateList(2131364097));
        MenuItemImpl a = popoverMenu.a(2131234016);
        a.setIcon(2130840023);
        a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ MapAreaPickerActivity f21557a;

            {
                this.f21557a = r1;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f21557a.m22582i();
                return true;
            }
        });
        a = popoverMenu.a(2131234067);
        a.setIcon(2130840013);
        a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ MapAreaPickerActivity f21558a;

            {
                this.f21558a = r1;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                MapAreaPickerActivity.m22576q(this.f21558a);
                return true;
            }
        });
    }

    public static void m22576q(MapAreaPickerActivity mapAreaPickerActivity) {
        final View editText = new EditText(mapAreaPickerActivity);
        editText.setHint(2131234015);
        editText.setSingleLine(true);
        editText.setText(mapAreaPickerActivity.f21592S);
        AlertDialog a = new AlertDialog.Builder(mapAreaPickerActivity).a(2131234067).b(editText).a(2131234068, new DialogInterface.OnClickListener(mapAreaPickerActivity) {
            final /* synthetic */ MapAreaPickerActivity f21562b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f21562b.f21592S = editText.getText().toString();
                this.f21562b.m22581b(this.f21562b.f21592S);
            }
        }).b(2131234069, new DialogInterface.OnClickListener(mapAreaPickerActivity) {
            final /* synthetic */ MapAreaPickerActivity f21560b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f21560b.f21592S = editText.getText().toString();
            }
        }).a();
        a.getWindow().setSoftInputMode(5);
        a.show();
    }
}
