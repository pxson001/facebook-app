package com.facebook.composer.minutiae;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.minutiae.MinutiaeConstants.TargetFragment;
import com.facebook.composer.minutiae.analytics.ActivityPickerAnalyticsLogger;
import com.facebook.composer.minutiae.analytics.MinutiaeAnalyticsLogger;
import com.facebook.composer.minutiae.analytics.MinutiaeAnalyticsLogger.Action;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel.AssociatedPlacesInfoModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.iconpicker.MinutiaeIconPickerIntentHelper;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.perf.MinutiaeObjectPickerPerformanceLogger;
import com.facebook.composer.minutiae.perf.MinutiaePerformanceLogger;
import com.facebook.composer.minutiae.perf.MinutiaeVerbPickerPerformanceLogger;
import com.facebook.composer.minutiae.prefs.MinutiaePrefKeys;
import com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher;
import com.facebook.composer.minutiae.ridge.RidgeHostActivity;
import com.facebook.composer.minutiae.titlebar.MinutiaeTitleBarHelper;
import com.facebook.composer.minutiae.titlebar.RidgeTitleBar;
import com.facebook.composer.minutiae.util.MinutiaeConfiguration;
import com.facebook.composer.minutiae.util.MinutiaeConfiguration.Builder;
import com.facebook.composer.minutiae.util.RidgeOptInController;
import com.facebook.content.SecureContextHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLCheckinPlaceResultsContext;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.location.FbLocationCache;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nux.ui.NuxBubbleView;
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.models.SearchResults;
import com.facebook.places.checkin.protocol.PlacePickerCache;
import com.facebook.places.checkin.protocol.PlacePickerFetcher;
import com.facebook.places.checkin.protocol.PlacePickerFetcher.View;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.widget.OverlayLayout;
import com.facebook.widget.OverlayLayout.LayoutParams;
import com.facebook.widget.titlebar.FbTitleBar;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.Stack;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: trans_dict_enabled */
public class MinutiaeTagPickerActivity extends FbFragmentActivity implements AnalyticsActivity, MinutiaeCustomIconPickerLauncher, ObjectSelectedListener, VerbSelectedListener, RidgeHostActivity {
    private Lazy<RidgeOptInController> f1359A;
    private Lazy<RidgeAnalyticsLogger> f1360B;
    private Lazy<MinutiaeVerbsFetcher> f1361C;
    private Lazy<MinutiaeIconPickerIntentHelper> f1362D;
    private RidgeTitleBar f1363E;
    private OverlayLayout f1364F;
    private FbTitleBar f1365G;
    private Optional<NuxBubbleView> f1366H = Absent.INSTANCE;
    public String f1367I;
    private PlacePickerFetcher f1368J;
    private PlacePickerCache f1369K;
    public SearchResults f1370L;
    private FbLocationCache f1371M;
    private final FutureCallback<SearchResults> f1372N = new C01234(this);
    private final View f1373O = new C01245(this);
    @VisibleForTesting
    protected Stack<TargetFragment> f1374p = new Stack();
    @VisibleForTesting
    protected MinutiaeConfiguration f1375q;
    private Provider<TriState> f1376r;
    private MinutiaeTitleBarHelper f1377s;
    public MinutiaeAnalyticsLogger f1378t;
    private TargetFragment f1379u;
    private ActivityPickerAnalyticsLogger f1380v;
    private MinutiaeVerbPickerPerformanceLogger f1381w;
    private MinutiaeObjectPickerPerformanceLogger f1382x;
    private ComposerLauncher f1383y;
    private Lazy<SecureContextHelper> f1384z;

    /* compiled from: trans_dict_enabled */
    public class C01201 {
        final /* synthetic */ MinutiaeTagPickerActivity f1350a;

        C01201(MinutiaeTagPickerActivity minutiaeTagPickerActivity) {
            this.f1350a = minutiaeTagPickerActivity;
        }

        public final void m1430a() {
            MinutiaeTagPickerActivity.m1459n(this.f1350a).hm_();
            Intent intent = new Intent();
            if (this.f1350a.f1375q.m1816f()) {
                FlatBufferModelHelper.a(intent, "extra_place", this.f1350a.f1375q.f1840f);
                this.f1350a.f1378t.m1547a(Action.SKIP, this.f1350a.f1375q.m1817g(), this.f1350a.f1375q.f1840f.cf_(), this.f1350a.f1367I);
            }
            this.f1350a.setResult(-1, intent);
            this.f1350a.finish();
        }
    }

    /* compiled from: trans_dict_enabled */
    class C01234 implements FutureCallback<SearchResults> {
        final /* synthetic */ MinutiaeTagPickerActivity f1357a;

        C01234(MinutiaeTagPickerActivity minutiaeTagPickerActivity) {
            this.f1357a = minutiaeTagPickerActivity;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f1357a.f1370L = (SearchResults) obj;
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: trans_dict_enabled */
    class C01245 implements View {
        final /* synthetic */ MinutiaeTagPickerActivity f1358a;

        C01245(MinutiaeTagPickerActivity minutiaeTagPickerActivity) {
            this.f1358a = minutiaeTagPickerActivity;
        }

        public final void mo61a(SearchResults searchResults) {
            this.f1358a.f1370L = searchResults;
        }

        public final void mo60a() {
        }

        public final void mo62b() {
        }
    }

    private static <T extends Context> void m1444a(Class<T> cls, T t) {
        m1445a((Object) t, (Context) t);
    }

    public static void m1445a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MinutiaeTagPickerActivity) obj).m1446a(IdBasedProvider.a(injectorLike, 637), MinutiaeTitleBarHelper.m1738b(injectorLike), MinutiaeAnalyticsLogger.m1546b(injectorLike), ActivityPickerAnalyticsLogger.m1538a(injectorLike), MinutiaeVerbPickerPerformanceLogger.m1663a(injectorLike), MinutiaeObjectPickerPerformanceLogger.m1656a(injectorLike), IdBasedLazy.a(injectorLike, 5260), IdBasedSingletonScopeProvider.b(injectorLike, 5233), IdBasedLazy.a(injectorLike, 5255), IdBasedSingletonScopeProvider.b(injectorLike, 5239), IdBasedSingletonScopeProvider.b(injectorLike, 968), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), PlacePickerCache.m13054a(injectorLike), PlacePickerFetcher.m13061b(injectorLike), FbLocationCache.b(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1464b(android.os.Bundle r9) {
        /*
        r8 = this;
        r3 = 0;
        super.b(r9);
        r0 = com.facebook.composer.minutiae.MinutiaeTagPickerActivity.class;
        m1445a(r8, r8);
        if (r9 != 0) goto L_0x010f;
    L_0x000b:
        r0 = r8.getIntent();
        r0 = com.facebook.composer.minutiae.util.MinutiaeConfiguration.m1812a(r0);
        r8.f1375q = r0;
    L_0x0015:
        r0 = r8.f1371M;
        r0 = r0.a();
        r1 = r8.f1375q;
        r1 = r1.f1842h;
        r2 = com.facebook.composer.minutiae.util.MinutiaeConfiguration.Action.LAUNCH_COMPOSER;
        if (r1 != r2) goto L_0x0114;
    L_0x0023:
        if (r0 == 0) goto L_0x0114;
    L_0x0025:
        r1 = r8.f1368J;
        r2 = r8.f1373O;
        r1.f11131j = r2;
        r1 = new com.facebook.places.checkin.protocol.PlacePickerFetchParams;
        r1.<init>();
        r2 = "";
        r1.f11108a = r2;
        r1 = r1;
        r2 = com.facebook.places.checkin.ipc.SearchType.CHECKIN;
        r1.f11110c = r2;
        r1 = r1;
        r0 = r0.l();
        r1.f11109b = r0;
        r0 = r1;
        r0.f11111d = r3;
        r0 = r0;
        r1 = com.facebook.places.checkin.ipc.CheckinComposerEntryPoint.Status;
        r0.f11114g = r1;
        r0 = r0;
        r1 = r8.f1368J;
        r1.m13066a(r0, r3);
    L_0x004e:
        r0 = r8.f1375q;
        r0 = r0.f1835a;
        r8.f1367I = r0;
        r8.m1455j();
        r0 = r8.f1375q;
        r0 = r0.f1836b;
        r1 = com.facebook.composer.minutiae.MinutiaeConstants.TargetFragment.VERB_PICKER;
        if (r0 != r1) goto L_0x006a;
    L_0x005f:
        r0 = r8.f1361C;
        r0 = r0.get();
        r0 = (com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher) r0;
        r0.m1706a();
    L_0x006a:
        r0 = 2130903697; // 0x7f030291 float:1.741422E38 double:1.0528063113E-314;
        r8.setContentView(r0);
        r0 = 2131560559; // 0x7f0d086f float:1.8746494E38 double:1.053130844E-314;
        r0 = r8.a(r0);
        r0 = (com.facebook.widget.OverlayLayout) r0;
        r8.f1364F = r0;
        r0 = r8.f1376r;
        r0 = r0.get();
        r1 = com.facebook.common.util.TriState.YES;
        if (r0 != r1) goto L_0x008b;
    L_0x0085:
        r0 = r8.f1375q;
        r0 = r0.f1841g;
        if (r0 != 0) goto L_0x011d;
    L_0x008b:
        com.facebook.widget.titlebar.FbTitleBarUtil.b(r8);
        r0 = 2131558563; // 0x7f0d00a3 float:1.8742445E38 double:1.053129858E-314;
        r0 = r8.a(r0);
        r0 = (com.facebook.widget.titlebar.FbTitleBar) r0;
        r8.f1365G = r0;
    L_0x0099:
        r0 = r8.f1377s;
        r1 = r8.f1365G;
        r2 = r8.f1375q;
        r0.m1740a(r1, r2);
        r0 = r8.f1380v;
        r1 = r8.f1367I;
        r5 = "activity_picker_started";
        r5 = com.facebook.composer.minutiae.analytics.ActivityPickerAnalyticsLogger.m1540f(r5, r1);
        r7 = r5.a;
        r5 = r7;
        r6 = r0.f1460a;
        r6.a(r5);
        r0 = r8.f1375q;
        r0 = r0.m1816f();
        if (r0 == 0) goto L_0x00d3;
    L_0x00bc:
        r0 = r8.f1378t;
        r1 = com.facebook.composer.minutiae.analytics.MinutiaeAnalyticsLogger.Action.SEEN;
        r2 = r8.f1375q;
        r2 = r2.m1817g();
        r3 = r8.f1375q;
        r3 = r3.f1840f;
        r3 = r3.cf_();
        r4 = r8.f1367I;
        r0.m1547a(r1, r2, r3, r4);
    L_0x00d3:
        r0 = r8.f1377s;
        r1 = new com.facebook.composer.minutiae.MinutiaeTagPickerActivity$1;
        r1.<init>(r8);
        r0.f1771b = r1;
        r0 = r8.f1363E;
        if (r0 == 0) goto L_0x0103;
    L_0x00e0:
        r0 = r8.f1375q;
        r5 = r0.f1838d;
        if (r5 == 0) goto L_0x013e;
    L_0x00e6:
        r5 = 1;
    L_0x00e7:
        r0 = r5;
        if (r0 != 0) goto L_0x00fc;
    L_0x00ea:
        r0 = r8.f1375q;
        r5 = r0.f1837c;
        if (r5 == 0) goto L_0x0140;
    L_0x00f0:
        r5 = r0.f1837c;
        r5 = r5.isEmpty();
        if (r5 != 0) goto L_0x0140;
    L_0x00f8:
        r5 = 1;
    L_0x00f9:
        r0 = r5;
        if (r0 == 0) goto L_0x0103;
    L_0x00fc:
        r0 = r8.f1363E;
        r5 = r0.f1815a;
        r5.m1799e();
    L_0x0103:
        r0 = r8.f1375q;
        r0 = r0.f1836b;
        r8.f1379u = r0;
        if (r9 != 0) goto L_0x013a;
    L_0x010b:
        r8.m1454i();
    L_0x010e:
        return;
    L_0x010f:
        r8.m1453d(r9);
        goto L_0x0015;
    L_0x0114:
        r0 = r8.f1369K;
        r1 = r8.f1372N;
        r0.m13057a(r1);
        goto L_0x004e;
    L_0x011d:
        r0 = 2131560560; // 0x7f0d0870 float:1.8746496E38 double:1.0531308447E-314;
        r0 = r8.a(r0);
        r0 = (com.facebook.composer.minutiae.titlebar.RidgeTitleBarStub) r0;
        r0 = r0.a();
        r0 = (com.facebook.composer.minutiae.titlebar.RidgeTitleBar) r0;
        r8.f1363E = r0;
        r8.f1365G = r0;
        r0 = r8.f1363E;
        r1 = r8.f1367I;
        r5 = r0.f1815a;
        r5.f1812y = r1;
        goto L_0x0099;
    L_0x013a:
        r8.m1458m();
        goto L_0x010e;
    L_0x013e:
        r5 = 0;
        goto L_0x00e7;
    L_0x0140:
        r5 = 0;
        goto L_0x00f9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.minutiae.MinutiaeTagPickerActivity.b(android.os.Bundle):void");
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        this.f1375q = MinutiaeConfiguration.m1812a(intent);
    }

    @VisibleForTesting
    private void m1454i() {
        Preconditions.checkNotNull(this.f1379u);
        Preconditions.checkArgument(this.f1379u != TargetFragment.UNKNOWN);
        this.f1374p.push(this.f1379u);
        m1456k();
    }

    public final String am_() {
        return "minutiae_tag_picker";
    }

    private void m1455j() {
        if (this.f1375q.f1836b == TargetFragment.VERB_PICKER) {
            MinutiaePerformanceLogger minutiaePerformanceLogger = this.f1381w;
            minutiaePerformanceLogger.m1654b(4390913, "minutiae_verb_picker_time_to_init");
            minutiaePerformanceLogger.m1655c(4390918, "minutiae_verb_picker_tti");
            return;
        }
        this.f1382x.m1654b(4325377, "minutiae_object_picker_time_to_init");
    }

    @Inject
    private void m1446a(Provider<TriState> provider, MinutiaeTitleBarHelper minutiaeTitleBarHelper, MinutiaeAnalyticsLogger minutiaeAnalyticsLogger, ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger, MinutiaeVerbPickerPerformanceLogger minutiaeVerbPickerPerformanceLogger, MinutiaeObjectPickerPerformanceLogger minutiaeObjectPickerPerformanceLogger, Lazy<RidgeOptInController> lazy, Lazy<RidgeAnalyticsLogger> lazy2, Lazy<MinutiaeVerbsFetcher> lazy3, Lazy<MinutiaeIconPickerIntentHelper> lazy4, Lazy<SecureContextHelper> lazy5, ComposerLauncher composerLauncher, PlacePickerCache placePickerCache, PlacePickerFetcher placePickerFetcher, FbLocationCache fbLocationCache) {
        this.f1376r = provider;
        this.f1377s = minutiaeTitleBarHelper;
        this.f1378t = minutiaeAnalyticsLogger;
        this.f1380v = activityPickerAnalyticsLogger;
        this.f1381w = minutiaeVerbPickerPerformanceLogger;
        this.f1382x = minutiaeObjectPickerPerformanceLogger;
        this.f1359A = lazy;
        this.f1360B = lazy2;
        this.f1361C = lazy3;
        this.f1362D = lazy4;
        this.f1384z = lazy5;
        this.f1383y = composerLauncher;
        this.f1369K = placePickerCache;
        this.f1368J = placePickerFetcher;
        this.f1371M = fbLocationCache;
    }

    public void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 878378813);
        super.onStart();
        if (this.f1363E != null) {
            this.f1363E.f1815a.m1797a();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1325500551, a);
    }

    public void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1664714067);
        super.onStop();
        if (this.f1363E != null) {
            this.f1363E.f1815a.m1798b();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1038481550, a);
    }

    @VisibleForTesting
    private void m1456k() {
        Fragment fragment;
        Parcelable parcelable;
        Bundle bundle;
        if (this.f1379u == TargetFragment.VERB_PICKER) {
            parcelable = this.f1375q;
            MinutiaeTaggableVerbFragment minutiaeTaggableVerbFragment = new MinutiaeTaggableVerbFragment();
            bundle = new Bundle();
            bundle.putParcelable("minutiae_configuration", parcelable);
            minutiaeTaggableVerbFragment.g(bundle);
            fragment = minutiaeTaggableVerbFragment;
        } else {
            parcelable = this.f1375q;
            MinutiaeTaggableObjectFragment minutiaeTaggableObjectFragment = new MinutiaeTaggableObjectFragment();
            bundle = new Bundle();
            bundle.putParcelable("minutiae_configuration", parcelable);
            minutiaeTaggableObjectFragment.g(bundle);
            fragment = minutiaeTaggableObjectFragment;
        }
        m1455j();
        m1442a((MinutiaeFragment) fragment);
        m1457l();
        FragmentTransaction a = kO_().a();
        if (this.f1374p.size() > 1) {
            a.a("back_stack").a(2130968748, 2130968757, 2130968747, 2130968758);
        }
        a.b(2131558429, fragment, this.f1379u.getFragmentName());
        a.b();
    }

    private void m1442a(MinutiaeFragment minutiaeFragment) {
        if (minutiaeFragment instanceof MinutiaeTaggableVerbFragment) {
            ((MinutiaeTaggableVerbFragment) minutiaeFragment).aA = this;
        } else if (minutiaeFragment instanceof MinutiaeTaggableObjectFragment) {
            ((MinutiaeTaggableObjectFragment) minutiaeFragment).f1417a = this;
        }
        minutiaeFragment.mo70a(this);
    }

    private void m1457l() {
        this.f1377s.m1740a(this.f1365G, this.f1375q);
        if (this.f1363E != null) {
            this.f1363E.m1802a(this.f1375q.f1839e);
        }
    }

    private void m1458m() {
        Fragment a = kO_().a(TargetFragment.VERB_PICKER.getFragmentName());
        if (a != null && (a instanceof MinutiaeFragment)) {
            m1442a((MinutiaeFragment) a);
        }
        a = kO_().a(TargetFragment.OBJECT_PICKER.getFragmentName());
        if (a != null && (a instanceof MinutiaeFragment)) {
            m1442a((MinutiaeFragment) a);
        }
        m1457l();
    }

    public void onBackPressed() {
        m1460o();
        super.onBackPressed();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m1452c(bundle);
    }

    @VisibleForTesting
    private void m1452c(Bundle bundle) {
        this.f1375q.f1848n = this.f1374p;
        bundle.putParcelable("bundle_config", this.f1375q);
    }

    @VisibleForTesting
    private void m1453d(Bundle bundle) {
        this.f1375q = (MinutiaeConfiguration) bundle.getParcelable("bundle_config");
        this.f1374p = this.f1375q.f1848n;
    }

    @Nullable
    public static MinutiaeFragment m1459n(MinutiaeTagPickerActivity minutiaeTagPickerActivity) {
        if (minutiaeTagPickerActivity.f1374p.isEmpty()) {
            return null;
        }
        return (MinutiaeFragment) minutiaeTagPickerActivity.kO_().a(minutiaeTagPickerActivity.f1379u.getFragmentName());
    }

    @VisibleForTesting
    private void m1460o() {
        if (!this.f1374p.isEmpty()) {
            MinutiaeFragment n = m1459n(this);
            if (n != null) {
                n.hl_();
            }
            this.f1374p.pop();
        }
        if (this.f1374p.isEmpty()) {
            if (this.f1375q.m1816f()) {
                this.f1378t.m1547a(Action.HIT_BACK, this.f1375q.m1817g(), this.f1375q.f1840f.cf_(), this.f1367I);
            }
            setResult(0);
            finish();
            return;
        }
        this.f1379u = (TargetFragment) this.f1374p.peek();
        Builder c = this.f1375q.m1815c();
        c.f1823b = this.f1379u;
        this.f1375q = c.m1811a();
        this.f1377s.m1740a(this.f1365G, this.f1375q);
        if (this.f1379u == TargetFragment.VERB_PICKER && this.f1363E != null) {
            this.f1363E.m1802a(null);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 101:
                MinutiaeFragment n = m1459n(this);
                if (i2 == -1) {
                    ((RidgeOptInController) this.f1359A.get()).m1829f();
                    ((RidgeOptInController) this.f1359A.get()).m1830h();
                    if (n != null) {
                        n.mo78b();
                        return;
                    }
                    return;
                }
                ((RidgeOptInController) this.f1359A.get()).f1852a.edit().putBoolean(MinutiaePrefKeys.f1616d, false).putBoolean(MinutiaePrefKeys.f1619g, true).commit();
                ((RidgeOptInController) this.f1359A.get()).m1831i();
                if (n != null) {
                    n.mo79c();
                    return;
                }
                return;
            case 1010:
                if (i2 == -1) {
                    setResult(i2, intent);
                    finish();
                    return;
                } else if (i2 == 0 && intent != null && intent.getBooleanExtra("composer_cancelled", false)) {
                    setResult(0, intent);
                    finish();
                    return;
                } else {
                    return;
                }
            case 1011:
                if (i2 == -1) {
                    mo65a((MinutiaeObject) intent.getParcelableExtra("minutiae_object"), intent);
                    return;
                }
                return;
            case 1012:
                if (i2 == 0) {
                    return;
                }
                if (this.f1375q.f1842h == MinutiaeConfiguration.Action.LAUNCH_COMPOSER) {
                    ImmutableList.Builder builder;
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_tagged_profiles");
                    if (parcelableArrayListExtra == null) {
                        builder = null;
                    } else {
                        ImmutableList.Builder builder2 = new ImmutableList.Builder();
                        int size = parcelableArrayListExtra.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            FacebookProfile facebookProfile = (FacebookProfile) parcelableArrayListExtra.get(i3);
                            ComposerTaggedUser.Builder a = ComposerTaggedUser.a(facebookProfile.mId);
                            a.b = facebookProfile.mDisplayName;
                            a = a;
                            a.c = facebookProfile.mImageUrl;
                            builder2.c(a.a());
                        }
                        builder = builder2;
                    }
                    ComposerConfiguration.Builder initialLocationInfo = ComposerConfiguration.a(this.f1375q.f1843i).setMinutiaeObjectTag((MinutiaeObject) intent.getParcelableExtra("minutiae_object")).setInitialLocationInfo(ComposerLocationInfo.newBuilder().b((CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place")).b());
                    if (builder != null) {
                        initialLocationInfo.setInitialTaggedUsers(builder.b());
                    }
                    this.f1383y.a(this.f1375q.f1835a, initialLocationInfo.a(), 1240, this);
                    return;
                }
                setResult(-1, intent);
                finish();
                return;
            case 1240:
                setResult(i2, intent);
                finish();
                return;
            default:
                return;
        }
    }

    public final void mo67b(String str) {
        String str2 = "ridge_nux_tooltip_displayed";
        RidgeAnalyticsLogger.m1551a(str2, this.f1367I).m1550a(((RidgeAnalyticsLogger) this.f1360B.get()).f1464a);
        final NuxBubbleView nuxBubbleView = new NuxBubbleView(this);
        this.f1366H = Optional.of(nuxBubbleView);
        final android.view.View a = a(2131563896);
        final int dimensionPixelSize = getResources().getDimensionPixelSize(2131429648);
        nuxBubbleView.setBubbleBody(str);
        this.f1364F.addView(nuxBubbleView);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.b = 2131563896;
        layoutParams.a = true;
        layoutParams.d = 4620;
        layoutParams.rightMargin = -dimensionPixelSize;
        nuxBubbleView.setLayoutParams(layoutParams);
        nuxBubbleView.setNubPosition(1);
        nuxBubbleView.b();
        nuxBubbleView.setClickable(true);
        nuxBubbleView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MinutiaeTagPickerActivity f1352b;

            public void onClick(android.view.View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1077415488);
                nuxBubbleView.f();
                Logger.a(2, EntryType.UI_INPUT_END, -2055755648, a);
            }
        });
        nuxBubbleView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ MinutiaeTagPickerActivity f1356d;

            public void onGlobalLayout() {
                if (nuxBubbleView.getPointerWidth() != 0) {
                    FrameLayout.LayoutParams pointerLayoutParams = nuxBubbleView.getPointerLayoutParams();
                    pointerLayoutParams.gravity |= 5;
                    pointerLayoutParams.rightMargin = ((a.getWidth() / 2) - (nuxBubbleView.getPointerWidth() / 2)) + dimensionPixelSize;
                    nuxBubbleView.a(pointerLayoutParams);
                    nuxBubbleView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    private void m1449b(MinutiaeTaggableActivity minutiaeTaggableActivity) {
        Builder c = this.f1375q.m1815c();
        c.f1826e = minutiaeTaggableActivity;
        c = c;
        c.f1823b = TargetFragment.OBJECT_PICKER;
        this.f1375q = c.m1811a();
        this.f1379u = this.f1375q.f1836b;
        this.f1374p.push(this.f1379u);
        m1456k();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f1366H.isPresent()) {
            ((NuxBubbleView) this.f1366H.get()).f();
            this.f1366H = Absent.INSTANCE;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void mo63a(MinutiaeTaggableActivity minutiaeTaggableActivity) {
        m1449b(minutiaeTaggableActivity);
    }

    public final void mo65a(MinutiaeObject minutiaeObject, Intent intent) {
        if (this.f1375q.f1840f == null && minutiaeObject.a != null && m1450b(minutiaeObject)) {
            m1443a(minutiaeObject);
        } else if (this.f1375q.f1842h == MinutiaeConfiguration.Action.LAUNCH_COMPOSER) {
            this.f1383y.a(this.f1375q.f1835a, ComposerConfiguration.a(this.f1375q.f1843i).setMinutiaeObjectTag(minutiaeObject).setInitialLocationInfo(ComposerLocationInfo.newBuilder().b(this.f1375q.f1840f).b()).a(), 1240, this);
        } else {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("minutiae_object", minutiaeObject);
            m1448b(intent);
            setResult(-1, intent);
            finish();
        }
    }

    private void m1443a(MinutiaeObject minutiaeObject) {
        PlacePickerConfiguration.Builder newBuilder = PlacePickerConfiguration.newBuilder();
        newBuilder.p = SearchType.CHECKIN;
        newBuilder = newBuilder;
        newBuilder.c = this.f1375q.f1843i;
        newBuilder = newBuilder;
        newBuilder.m = minutiaeObject;
        newBuilder = newBuilder;
        newBuilder.w = true;
        startActivityForResult(CheckinIntentCreator.a(this, newBuilder.a()), 1012);
    }

    private boolean m1450b(MinutiaeObject minutiaeObject) {
        if (this.f1370L == null || minutiaeObject.a == null) {
            return false;
        }
        AssociatedPlacesInfoModel associatedPlacesInfoModel = minutiaeObject.a;
        if (associatedPlacesInfoModel.c() == GraphQLCheckinPlaceResultsContext.NORMAL) {
            return true;
        }
        for (CheckinPlaceModel checkinPlaceModel : this.f1370L.b) {
            boolean z;
            boolean z2 = !StringUtil.a(checkinPlaceModel.l()) && associatedPlacesInfoModel.b().contains(checkinPlaceModel.l());
            if (StringUtil.a(checkinPlaceModel.cf_()) || !associatedPlacesInfoModel.a().contains(checkinPlaceModel.cf_())) {
                z = false;
            } else {
                z = true;
            }
            if (z2) {
                return true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private void m1448b(Intent intent) {
        CheckinPlaceModel checkinPlaceModel = this.f1375q.f1840f;
        if (checkinPlaceModel != null) {
            FlatBufferModelHelper.a(intent, "extra_place", checkinPlaceModel);
            if (checkinPlaceModel.g() != null) {
                this.f1378t.m1547a(Action.SELECT, checkinPlaceModel.g(), checkinPlaceModel.cf_(), this.f1375q.f1835a);
            }
        }
    }

    public final void mo64a(MinutiaeObject minutiaeObject, int i) {
        Intent a = ((MinutiaeIconPickerIntentHelper) this.f1362D.get()).m1604a(this, minutiaeObject, minutiaeObject.b());
        if (a != null) {
            ((SecureContextHelper) this.f1384z.get()).a(a, i, this);
        }
    }

    public final void mo66b(MinutiaeObject minutiaeObject, int i) {
        MinutiaeIconPickerIntentHelper minutiaeIconPickerIntentHelper = (MinutiaeIconPickerIntentHelper) this.f1362D.get();
        ((SecureContextHelper) this.f1384z.get()).a(MinutiaeIconPickerIntentHelper.m1601a(this, minutiaeObject, minutiaeObject.b(), true), i, this);
    }
}
