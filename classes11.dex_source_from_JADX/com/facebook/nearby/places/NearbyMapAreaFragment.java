package com.facebook.nearby.places;

import android.content.Context;
import android.graphics.RectF;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.LocationManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.http.common.NetworkException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.MapFragment;
import com.facebook.maps.MapFragment.OnMapReadyListener;
import com.facebook.maps.MapFragmentFactory;
import com.facebook.nearby.analytics.NearbyBrowseAnalytics;
import com.facebook.nearby.analytics.NearbyBrowseAnalytics.LocationFixSource;
import com.facebook.nearby.analytics.NearbyBrowseAnalytics.TTIAmountOfTileInCache;
import com.facebook.nearby.cluster.MapClusterer;
import com.facebook.nearby.cluster.MapDisplayData;
import com.facebook.nearby.common.SearchSuggestion;
import com.facebook.nearby.data.TilesHelper;
import com.facebook.nearby.data.cache.TilesCache;
import com.facebook.nearby.maps.MapCoordinateHelper;
import com.facebook.nearby.maps.MapRegionCalculator;
import com.facebook.nearby.maps.NearbyMapController;
import com.facebook.nearby.model.MapTile;
import com.facebook.nearby.model.NearbyPlaceEdgeWithLayout;
import com.facebook.nearby.model.NearbyPlaceEdgeWrapper;
import com.facebook.nearby.module.C0057x8649099b;
import com.facebook.nearby.prefs.NearbyPrefKeys;
import com.facebook.nearby.protocol.FetchNearbyPlacesLayoutParams;
import com.facebook.nearby.protocol.NearbyProtocolZoomHelper;
import com.facebook.nearby.protocol.NearbyTilesParams;
import com.facebook.nearby.protocol.NearbyTilesWithLayoutsParams;
import com.facebook.nearby.protocol.NearbyTilesWithLayoutsResult;
import com.facebook.nearby.search.NearbySearchCategoryList;
import com.facebook.nearby.server.NearbyServiceHandler;
import com.facebook.nearby.utils.NearbyUriUtil;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesOldBrowseOldResultConnectionFragmentModel.EdgesModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesOldBrowseOldResultsSearchQueryModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesParams;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesRunner;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.ui.FbButton;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.futures.FuturesManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

/* compiled from: unknown_error_type_ */
public class NearbyMapAreaFragment extends FbFragment {
    private static final Class<?> f442a = NearbyMapAreaFragment.class;
    private static final String[] f443b = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    public boolean aA;
    public NearbyMapController aB;
    private ImageButton aC;
    private ImageButton aD;
    private ViewGroup aE;
    private View aF;
    public ViewGroup aG;
    private ViewGroup aH;
    public ViewGroup aI;
    private FbButton aJ;
    private Animation aK;
    private Animation aL;
    private Animation aM;
    public Animation aN;
    public Operation aO;
    public NearbyPlacesFragment aP;
    private NearbyProtocolZoomHelper aQ;
    private TilesHelper aR;
    private MapRegionCalculator aS;
    public MapClusterer aT;
    public MapCoordinateHelper aU;
    public FuturesManager aV;
    private Handler aW;
    private ActivityRuntimePermissionsManager aX;
    private boolean aY = false;
    private NearbyServiceHandler al;
    private LocationManager am;
    public DefaultAndroidThreadUtil an;
    public Clock ao;
    private AnalyticsTagger ap;
    private BrowseNearbyPlacesRunner aq;
    public boolean ar;
    public Toaster as;
    public String at = null;
    public SearchSuggestion au;
    private TilesCache av;
    public MapPinSelectState aw = MapPinSelectState.NONE_SELECTED;
    public MapInitialFetchState ax = MapInitialFetchState.INITIAL_FETCH_NOT_PERFORMED;
    public Location ay;
    public boolean az;
    public boolean f444c = false;
    public boolean f445d = false;
    public GraphQLGeoRectangle f446e;
    public FragmentManager f447f;
    public FbSharedPreferences f448g;
    public NearbyBrowseAnalytics f449h;
    private DefaultBlueServiceOperationFactory f450i;

    /* compiled from: unknown_error_type_ */
    class C00601 implements OnClickListener {
        final /* synthetic */ NearbyMapAreaFragment f427a;

        /* compiled from: unknown_error_type_ */
        class C00591 implements FutureCallback<Void> {
            final /* synthetic */ C00601 f410a;

            C00591(C00601 c00601) {
                this.f410a = c00601;
            }

            public void onSuccess(Object obj) {
                if (this.f410a.f427a.ar) {
                    NearbyMapAreaFragment.aI(this.f410a.f427a);
                } else {
                    this.f410a.f427a.m551b(this.f410a.f427a.ao.a(), false);
                }
            }

            public void onFailure(Throwable th) {
            }
        }

        C00601(NearbyMapAreaFragment nearbyMapAreaFragment) {
            this.f427a = nearbyMapAreaFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1129744939);
            NearbyBrowseAnalytics nearbyBrowseAnalytics = this.f427a.f449h;
            String str = this.f427a.at;
            HoneyClientEventFast a2 = nearbyBrowseAnalytics.f297a.a("current_location_button", true);
            if (a2.a()) {
                a2.a("places_recommendations").a("session_id", str);
                a2.b();
            }
            Location e = this.f427a.m555e();
            if (e == null) {
                this.f427a.as.b(new ToastBuilder(2131236613));
                Logger.a(2, EntryType.UI_INPUT_END, 481406211, a);
                return;
            }
            this.f427a.an.a(this.f427a.aB.m474b(e), new C00591(this));
            LogUtils.a(-1628424917, a);
        }
    }

    /* compiled from: unknown_error_type_ */
    class C00612 implements OnClickListener {
        final /* synthetic */ NearbyMapAreaFragment f428a;

        C00612(NearbyMapAreaFragment nearbyMapAreaFragment) {
            this.f428a = nearbyMapAreaFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -722692280);
            NearbyBrowseAnalytics nearbyBrowseAnalytics = this.f428a.f449h;
            String str = this.f428a.at;
            HoneyClientEventFast a2 = nearbyBrowseAnalytics.f297a.a("view_result_list", true);
            if (a2.a()) {
                a2.a("places_recommendations").a("session_id", str);
                a2.b();
            }
            NearbyMapAreaFragment.aH(this.f428a);
            this.f428a.aB.m482o();
            Logger.a(2, EntryType.UI_INPUT_END, -1537921350, a);
        }
    }

    /* compiled from: unknown_error_type_ */
    class C00623 implements OnClickListener {
        final /* synthetic */ NearbyMapAreaFragment f429a;

        C00623(NearbyMapAreaFragment nearbyMapAreaFragment) {
            this.f429a = nearbyMapAreaFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 461107140);
            NearbyMapAreaFragment nearbyMapAreaFragment = this.f429a;
            if (nearbyMapAreaFragment.aI.getVisibility() == 0) {
                nearbyMapAreaFragment.aI.clearAnimation();
                nearbyMapAreaFragment.aN.reset();
                nearbyMapAreaFragment.aI.startAnimation(nearbyMapAreaFragment.aN);
                nearbyMapAreaFragment.aI.setVisibility(8);
            }
            this.f429a.m549a(this.f429a.ao.a(), true);
            Logger.a(2, EntryType.UI_INPUT_END, -1241001461, a);
        }
    }

    /* compiled from: unknown_error_type_ */
    class C00677 implements OnMapReadyListener {
        final /* synthetic */ NearbyMapAreaFragment f439a;

        C00677(NearbyMapAreaFragment nearbyMapAreaFragment) {
            this.f439a = nearbyMapAreaFragment;
        }

        public final void m528a() {
            this.f439a.aB.m469a(null);
            NearbyMapAreaFragment.m534a(this.f439a, null);
        }
    }

    /* compiled from: unknown_error_type_ */
    class C00688 implements OnMapReadyListener {
        final /* synthetic */ NearbyMapAreaFragment f440a;

        C00688(NearbyMapAreaFragment nearbyMapAreaFragment) {
            this.f440a = nearbyMapAreaFragment;
        }

        public final void m529a() {
            this.f440a.aB.m469a(null);
            this.f440a.m549a(this.f440a.ao.a(), false);
        }
    }

    /* compiled from: unknown_error_type_ */
    public class C00699 {
        public final /* synthetic */ NearbyMapAreaFragment f441a;

        C00699(NearbyMapAreaFragment nearbyMapAreaFragment) {
            this.f441a = nearbyMapAreaFragment;
        }
    }

    /* compiled from: unknown_error_type_ */
    enum MapInitialFetchState {
        INITIAL_FETCH_NOT_PERFORMED,
        INITIAL_FETCH_IN_PROGRESS,
        INITIAL_FETCH_COMPLETED;

        public static MapInitialFetchState from(String str) {
            for (MapInitialFetchState mapInitialFetchState : values()) {
                if (mapInitialFetchState.toString().equals(str)) {
                    return mapInitialFetchState;
                }
            }
            throw new IllegalArgumentException("Unknown MapInitialFetchState = " + str);
        }
    }

    /* compiled from: unknown_error_type_ */
    public enum MapPinSelectState {
        CLUSTER_SELECTED,
        PLACE_SELECTED,
        NONE_SELECTED
    }

    public final void m556e(Bundle bundle) {
        super.e(bundle);
        if (this.ay != null) {
            bundle.putParcelable("lastUserLocation", this.ay);
        }
        bundle.putParcelable("currentSearchSuggestion", this.au);
        bundle.putString("initialFetch", this.ax.toString());
    }

    public final void m553c(Bundle bundle) {
        super.c(bundle);
        FbInjector an = an();
        this.ap = AnalyticsTagger.a(an);
        this.aq = new BrowseNearbyPlacesRunner(SimpleExecutor.b(an), GraphQLQueryExecutor.a(an));
        this.ar = C0057x8649099b.m517b(an).booleanValue();
        this.as = Toaster.b(an);
    }

    public final void m554d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1665105256);
        super.d(bundle);
        if (bundle != null) {
            this.ay = (Location) bundle.getParcelable("lastUserLocation");
            this.au = (SearchSuggestion) bundle.getParcelable("currentSearchSuggestion");
            this.ax = MapInitialFetchState.from(bundle.getString("initialFetch"));
        }
        InjectorLike an = an();
        this.f448g = (FbSharedPreferences) FbSharedPreferencesImpl.a(an);
        this.f449h = NearbyBrowseAnalytics.m376b(an);
        this.f450i = DefaultBlueServiceOperationFactory.b(an);
        this.av = TilesCache.m417a(an);
        this.al = NearbyServiceHandler.m1057a(an);
        this.am = LocationManagerMethodAutoProvider.b(an);
        this.an = DefaultAndroidThreadUtil.b(an);
        this.ao = (Clock) SystemClockMethodAutoProvider.a(an);
        this.aW = Handler_ForUiThreadMethodAutoProvider.b(an);
        this.aQ = new NearbyProtocolZoomHelper(ResourcesMethodAutoProvider.a(an));
        this.aT = new MapClusterer(NearbyPlaceSorter.m565a(an), IdBasedProvider.a(an, 4227));
        this.aV = FuturesManager.a(an);
        ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider = (ActivityRuntimePermissionsManagerProvider) an.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class);
        this.f447f = s();
        this.aX = activityRuntimePermissionsManagerProvider.a(o());
        this.aD = (ImageButton) e(2131564095);
        this.aG = (ViewGroup) e(2131564097);
        this.aC = (ImageButton) e(2131564096);
        this.aE = (ViewGroup) e(2131564094);
        this.aF = e(2131564098);
        this.aH = (ViewGroup) e(2131564089);
        this.aI = (ViewGroup) e(2131564092);
        this.aJ = (FbButton) e(2131564093);
        this.aR = new TilesHelper(this.ao);
        this.aS = new MapRegionCalculator();
        this.aU = new MapCoordinateHelper();
        this.aL = AnimationUtils.loadAnimation(getContext(), 2130968662);
        this.aK = AnimationUtils.loadAnimation(getContext(), 2130968661);
        this.aN = AnimationUtils.loadAnimation(getContext(), 2130968662);
        this.aM = AnimationUtils.loadAnimation(getContext(), 2130968661);
        aK();
        aA();
        this.aC.setOnClickListener(new C00601(this));
        this.aD.setOnClickListener(new C00612(this));
        this.aJ.setOnClickListener(new C00623(this));
        this.aY = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1496736737, a);
    }

    public final void m546G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 445642028);
        super.G();
        aw();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1519128386, a);
    }

    public final View m548a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -41277936);
        View inflate = layoutInflater.inflate(2130905385, viewGroup, false);
        this.ap.a(inflate, "nearby_map", this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1344568239, a);
        return inflate;
    }

    @Nullable
    public final Location m555e() {
        Location aq = this.aB.f378l.aq();
        if (aq != null) {
            this.ay = aq;
        }
        return this.ay;
    }

    public final Set<NearbyPlaceEdgeWrapper> aq() {
        return this.aB.m479j();
    }

    public final void m547I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 136240774);
        super.I();
        if (this.aB != null) {
            this.aB.m468a(null);
            this.aB.m472a(null);
            this.aB.m471a(null);
            this.aB.m481m();
        }
        if (this.aW != null) {
            this.aW.removeCallbacksAndMessages(null);
        }
        av();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1018613928, a);
    }

    public final void at() {
        this.f444c = true;
        if (!this.f448g.a(NearbyPrefKeys.f510d, false)) {
            this.aG.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968675));
            this.aG.setVisibility(0);
        }
        this.aE.clearAnimation();
        this.aK.reset();
        this.aE.startAnimation(this.aK);
        this.aE.setVisibility(0);
        this.aF.setVisibility(8);
        this.aB.m482o();
        aK();
        if (this.ax != MapInitialFetchState.INITIAL_FETCH_COMPLETED) {
            this.ax = MapInitialFetchState.INITIAL_FETCH_COMPLETED;
            m549a(this.ao.a(), false);
        }
    }

    private void aw() {
        final boolean z = this.aY;
        this.aY = false;
        if (aB()) {
            this.aX.a(f443b, new RuntimePermissionsListener(this) {
                final /* synthetic */ NearbyMapAreaFragment f431b;

                public final void m525a() {
                    if (z) {
                        NearbyMapAreaFragment.ax(this.f431b);
                    }
                    NearbyMapAreaFragment.ay(this.f431b);
                }

                public final void m526a(String[] strArr, String[] strArr2) {
                    if (this.f431b.f444c) {
                        NearbyMapAreaFragment.aL(this.f431b);
                    } else {
                        this.f431b.aP.m602i();
                    }
                }

                public final void m527b() {
                    if (this.f431b.f444c) {
                        NearbyMapAreaFragment.aL(this.f431b);
                    } else {
                        this.f431b.aP.m602i();
                    }
                }
            });
        } else {
            this.aP.m599e();
        }
    }

    public static void ax(NearbyMapAreaFragment nearbyMapAreaFragment) {
        if (nearbyMapAreaFragment.aB()) {
            nearbyMapAreaFragment.aY = false;
            final long a = nearbyMapAreaFragment.ao.a();
            HandlerDetour.b(nearbyMapAreaFragment.aW, new Runnable(nearbyMapAreaFragment) {
                final /* synthetic */ NearbyMapAreaFragment f433b;

                public void run() {
                    if (this.f433b.ax == MapInitialFetchState.INITIAL_FETCH_NOT_PERFORMED) {
                        this.f433b.f449h.m379a(null, LocationFixSource.TIMEOUT, this.f433b.ao.a() - a);
                        NearbyMapAreaFragment.m534a(this.f433b, null);
                    }
                }
            }, 3000, 1509528072);
            nearbyMapAreaFragment.an.a(nearbyMapAreaFragment.aB.f378l.ar(), new FutureCallback<Location>(nearbyMapAreaFragment) {
                final /* synthetic */ NearbyMapAreaFragment f438b;

                public void onSuccess(Object obj) {
                    final Location location = (Location) obj;
                    final long a = this.f438b.ao.a() - a;
                    this.f438b.ay = location;
                    if (this.f438b.ax == MapInitialFetchState.INITIAL_FETCH_NOT_PERFORMED) {
                        this.f438b.an.a(this.f438b.aB.m474b(location), new FutureCallback<Void>(this) {
                            final /* synthetic */ C00666 f436c;

                            public void onSuccess(Object obj) {
                                this.f436c.f438b.f449h.m379a(location, LocationFixSource.BEFORE_TIMEOUT, a);
                                NearbyMapAreaFragment.m534a(this.f436c.f438b, location);
                            }

                            public void onFailure(Throwable th) {
                            }
                        });
                    }
                }

                public void onFailure(Throwable th) {
                }
            });
        }
    }

    public static void ay(NearbyMapAreaFragment nearbyMapAreaFragment) {
        if (!nearbyMapAreaFragment.aB() && nearbyMapAreaFragment.ax == MapInitialFetchState.INITIAL_FETCH_NOT_PERFORMED) {
            nearbyMapAreaFragment.aP.m599e();
            nearbyMapAreaFragment.f449h.m379a(null, LocationFixSource.LOCATION_SERVICES_OFF, 0);
            if (nearbyMapAreaFragment.aB.m478h()) {
                m534a(nearbyMapAreaFragment, null);
            } else {
                nearbyMapAreaFragment.aB.m469a(new C00677(nearbyMapAreaFragment));
            }
        } else if (!nearbyMapAreaFragment.aB.m478h()) {
            nearbyMapAreaFragment.aB.m469a(new C00688(nearbyMapAreaFragment));
        } else if (nearbyMapAreaFragment.aw == MapPinSelectState.NONE_SELECTED) {
            nearbyMapAreaFragment.m549a(nearbyMapAreaFragment.ao.a(), false);
        }
    }

    private void aA() {
        FbInjector an = an();
        this.aB = new NearbyMapController(FbDraweeControllerBuilder.b(an), (Context) an.getInstance(Context.class));
        NearbyMapController nearbyMapController = this.aB;
        MapFragment a = MapFragmentFactory.b(an()).a(false);
        a.a(17.0d);
        a.b(true);
        a.a(true);
        this.f447f.a().b(2131564091, a, "nearbyMapFragment").b();
        nearbyMapController.m467a((Fragment) a);
        this.aB.f377k = this;
        this.aB.m472a(new C00699(this));
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new SimpleOnGestureListener(this) {
            final /* synthetic */ NearbyMapAreaFragment f411a;

            {
                this.f411a = r1;
            }

            public boolean onDoubleTap(MotionEvent motionEvent) {
                this.f411a.aB.m466a();
                NearbyMapAreaFragment.aI(this.f411a);
                return true;
            }
        });
        this.aB.m468a(new OnTouchListener(this) {
            final /* synthetic */ NearbyMapAreaFragment f413b;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                this.f413b.aA = true;
                if (motionEvent.getAction() == 2) {
                    this.f413b.aB.m482o();
                    if (!this.f413b.f444c) {
                        return true;
                    }
                }
                if (motionEvent.getAction() == 0) {
                    NearbyMapAreaFragment.aF(this.f413b);
                }
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
        this.aB.m471a(new Object(this) {
            public final /* synthetic */ NearbyMapAreaFragment f414a;

            {
                this.f414a = r1;
            }
        });
    }

    private boolean aB() {
        return this.am.isProviderEnabled("network") || this.am.isProviderEnabled("gps");
    }

    public static void m534a(@Nullable NearbyMapAreaFragment nearbyMapAreaFragment, Location location) {
        final long a = nearbyMapAreaFragment.ao.a();
        if (nearbyMapAreaFragment.ar) {
            nearbyMapAreaFragment.ax = MapInitialFetchState.INITIAL_FETCH_COMPLETED;
            nearbyMapAreaFragment.m533a(a);
            return;
        }
        nearbyMapAreaFragment.ax = MapInitialFetchState.INITIAL_FETCH_IN_PROGRESS;
        nearbyMapAreaFragment.aO = nearbyMapAreaFragment.m531a(location, null);
        final ListenableFuture a2 = nearbyMapAreaFragment.aO.a();
        nearbyMapAreaFragment.m537a(a2, new OperationResultFutureCallback(nearbyMapAreaFragment) {
            final /* synthetic */ NearbyMapAreaFragment f417c;

            protected final void m520a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                this.f417c.aV.a(a2);
                this.f417c.f449h.m378a(a, this.f417c.ao.a());
                NearbyTilesWithLayoutsResult nearbyTilesWithLayoutsResult = (NearbyTilesWithLayoutsResult) operationResult.k();
                if (nearbyTilesWithLayoutsResult != null) {
                    GraphQLGeoRectangle graphQLGeoRectangle = nearbyTilesWithLayoutsResult.f650g;
                    NearbyMapController nearbyMapController = this.f417c.aB;
                    NearbyMapAreaFragment nearbyMapAreaFragment = this.f417c;
                    nearbyMapController.m465a(NearbyMapAreaFragment.m530a(graphQLGeoRectangle));
                }
                this.f417c.ax = MapInitialFetchState.INITIAL_FETCH_COMPLETED;
                this.f417c.m551b(a, true);
            }

            protected final void m519a(ServiceException serviceException) {
                this.f417c.aV.a(a2);
                this.f417c.f449h.m381a(serviceException.getMessage());
                this.f417c.ax = MapInitialFetchState.INITIAL_FETCH_COMPLETED;
                NearbyMapAreaFragment.aL(this.f417c);
                if (serviceException.errorCode == ErrorCode.CONNECTION_FAILURE) {
                    this.f417c.aP.m597d();
                } else {
                    this.f417c.aP.m603j();
                }
            }

            protected final void m521a(CancellationException cancellationException) {
                super.a(cancellationException);
                this.f417c.aV.a(a2);
                this.f417c.f449h.m377a();
                this.f417c.ax = MapInitialFetchState.INITIAL_FETCH_COMPLETED;
            }
        });
    }

    public final void m552b(NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper) {
        NearbyBrowseAnalytics nearbyBrowseAnalytics = this.f449h;
        String str = this.at;
        String c = nearbyPlaceEdgeWrapper.m499c();
        HoneyClientEventFast a = nearbyBrowseAnalytics.f297a.a("primary_pin_tapped", true);
        if (a.a()) {
            a.a("places_recommendations").a("session_id", str).a("page_id", c);
            a.b();
        }
        m544c(nearbyPlaceEdgeWrapper);
    }

    public final void m550a(NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper) {
        NearbyBrowseAnalytics nearbyBrowseAnalytics = this.f449h;
        String str = this.at;
        String c = nearbyPlaceEdgeWrapper.m499c();
        HoneyClientEventFast a = nearbyBrowseAnalytics.f297a.a("secondary_pin_tapped", true);
        if (a.a()) {
            a.a("places_recommendations").a("session_id", str).a("page_id", c);
            a.b();
        }
        m544c(nearbyPlaceEdgeWrapper);
    }

    private void m537a(ListenableFuture<OperationResult> listenableFuture, OperationResultFutureCallback operationResultFutureCallback) {
        if (!this.x && mx_() && !this.L) {
            this.aV.a(FutureAndCallbackHolder.a(listenableFuture, operationResultFutureCallback));
            this.an.a(listenableFuture, operationResultFutureCallback);
        }
    }

    public final void av() {
        if (this.aV != null) {
            this.aV.a();
        }
    }

    private void m544c(NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper) {
        if (this.aO != null) {
            this.aO.d();
        }
        this.aP.m594a(Sets.a(new NearbyPlaceEdgeWrapper[]{nearbyPlaceEdgeWrapper}));
        aH(this);
        this.aw = MapPinSelectState.PLACE_SELECTED;
    }

    private List<MapTile> m532a(RectF rectF) {
        return this.av.m421a((double) this.aQ.m651a(this.aB), Sets.b(aD()), Sets.b(aC()), rectF);
    }

    public final void m549a(long j, boolean z) {
        if (!this.ar) {
            m551b(j, z);
        } else if (z) {
            m533a(j);
        }
    }

    private void m533a(long j) {
        this.aq.a.c();
        Location e = m555e();
        RectF a = MapRegionCalculator.m444a(this.aB);
        final long a2 = this.ao.a();
        this.f445d = true;
        aK();
        final long j2 = j;
        this.aq.a(m543c(e, a), new FutureCallback<NearbyPlacesOldBrowseOldResultsSearchQueryModel>(this) {
            final /* synthetic */ NearbyMapAreaFragment f422c;

            public void onSuccess(@Nullable Object obj) {
                NearbyPlacesOldBrowseOldResultsSearchQueryModel nearbyPlacesOldBrowseOldResultsSearchQueryModel = (NearbyPlacesOldBrowseOldResultsSearchQueryModel) obj;
                long a = this.f422c.ao.a();
                this.f422c.f449h.m378a(a2, a);
                if (nearbyPlacesOldBrowseOldResultsSearchQueryModel == null || nearbyPlacesOldBrowseOldResultsSearchQueryModel.a() == null) {
                    this.f422c.f445d = false;
                } else {
                    NearbyMapAreaFragment.m536a(this.f422c, nearbyPlacesOldBrowseOldResultsSearchQueryModel.a().a());
                }
                NearbyMapAreaFragment.m535a(this.f422c, TTIAmountOfTileInCache.NOT_ALL_TILES_IN_CACHE, a - j2);
                this.f422c.az = false;
            }

            public void onFailure(Throwable th) {
                this.f422c.f449h.m381a(th.getMessage());
                NearbyMapAreaFragment.aL(this.f422c);
                if (th instanceof NetworkException) {
                    this.f422c.aP.m597d();
                } else {
                    this.f422c.aP.m603j();
                }
            }
        });
    }

    public final void m551b(long j, boolean z) {
        if (this.ax == MapInitialFetchState.INITIAL_FETCH_COMPLETED) {
            Location e = m555e();
            RectF a = MapRegionCalculator.m444a(this.aB);
            if (this.aO != null) {
                this.aO.d();
            }
            List a2 = m532a(a);
            boolean a3 = m539a(a, a2);
            if (!a2.isEmpty()) {
                m538a(a2);
                this.f449h.m387a(a3, a2.size(), aC(), MapCoordinateHelper.m440a(a), (double) this.aQ.m651a(this.aB), m542c(a2));
            }
            if (!z) {
                return;
            }
            if (a3) {
                m535a(this, this.aR.m416a(a2) ? TTIAmountOfTileInCache.ALL_TILES_IN_CACHE_SOME_ARE_STALE : TTIAmountOfTileInCache.ALL_TILES_IN_CACHE, this.ao.a() - j);
                this.az = false;
                return;
            }
            double a4 = this.aR.m415a(MapCoordinateHelper.m443b(a), a2);
            this.aO = m531a(e, a);
            this.al.f778l = GraphQLHelper.a(a.top, a.left, a.bottom, a.right);
            if (a4 < 0.97d) {
                this.f445d = true;
                aK();
            }
            final long a5 = this.ao.a();
            final ListenableFuture a6 = this.aO.a();
            final long j2 = j;
            m537a(a6, new OperationResultFutureCallback(this) {
                final /* synthetic */ NearbyMapAreaFragment f426d;

                public final void m523a(Object obj) {
                    OperationResult operationResult = (OperationResult) obj;
                    this.f426d.aV.a(a6);
                    long a = this.f426d.ao.a();
                    this.f426d.f449h.m378a(a5, a);
                    NearbyTilesWithLayoutsResult nearbyTilesWithLayoutsResult = (NearbyTilesWithLayoutsResult) operationResult.k();
                    if (nearbyTilesWithLayoutsResult != null) {
                        this.f426d.m538a(nearbyTilesWithLayoutsResult.f645b);
                    }
                    NearbyMapAreaFragment.m535a(this.f426d, TTIAmountOfTileInCache.NOT_ALL_TILES_IN_CACHE, a - j2);
                    this.f426d.az = false;
                }

                protected final void m522a(ServiceException serviceException) {
                    this.f426d.aV.a(a6);
                    if (serviceException.errorCode == ErrorCode.NO_ERROR) {
                        m524a(new CancellationException());
                        return;
                    }
                    this.f426d.f449h.m381a(serviceException.getMessage());
                    NearbyMapAreaFragment.aL(this.f426d);
                    if (serviceException.errorCode == ErrorCode.CONNECTION_FAILURE) {
                        this.f426d.aP.m597d();
                    } else {
                        this.f426d.aP.m603j();
                    }
                }

                protected final void m524a(CancellationException cancellationException) {
                    super.a(cancellationException);
                    this.f426d.aV.a(a6);
                    this.f426d.f449h.m377a();
                }
            });
        }
    }

    private Operation m531a(Location location, RectF rectF) {
        Parcelable nearbyTilesWithLayoutsParams = new NearbyTilesWithLayoutsParams(m540b(location, rectF), new FetchNearbyPlacesLayoutParams());
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchLayoutAndTilesParams", nearbyTilesWithLayoutsParams);
        return BlueServiceOperationFactoryDetour.a(this.f450i, "fetch_layout_and_tiles", bundle, -798560463);
    }

    public static void m535a(NearbyMapAreaFragment nearbyMapAreaFragment, TTIAmountOfTileInCache tTIAmountOfTileInCache, long j) {
        if (nearbyMapAreaFragment.az) {
            HoneyClientEventFast a = nearbyMapAreaFragment.f449h.f297a.a("category_search_time_to_interaction", true);
            if (a.a()) {
                a.a("places_recommendations").a("source", tTIAmountOfTileInCache.getAttributeValue()).a("elapsed_time_to_interaction", (double) (((float) j) / 1000.0f));
                a.b();
                return;
            }
            return;
        }
        nearbyMapAreaFragment.f449h.m380a(tTIAmountOfTileInCache, j);
    }

    private void m538a(List<MapTile> list) {
        MapClusterer mapClusterer = this.aT;
        Set hashSet = new HashSet();
        Builder builder = ImmutableList.builder();
        for (MapTile mapTile : list) {
            if (mapTile.places != null) {
                for (NearbyPlaceEdgeWithLayout nearbyPlaceEdgeWithLayout : mapTile.places) {
                    if (nearbyPlaceEdgeWithLayout.placeEdge != null) {
                        GraphQLPage a = nearbyPlaceEdgeWithLayout.placeEdge.a();
                        if (!(a == null || a.az() == null)) {
                            String ae = a.ae();
                            if (!hashSet.contains(ae)) {
                                hashSet.add(ae);
                                builder.c(new NearbyPlaceEdgeWrapper(nearbyPlaceEdgeWithLayout));
                            }
                        }
                    }
                }
            }
        }
        MapDisplayData a2 = mapClusterer.m393a(builder.b(), m545f(list), this.aB.m480l());
        aL(this);
        this.aB.m470a(a2);
        this.aP.m594a(this.aB.m479j());
    }

    private NearbyTilesParams m540b(Location location, RectF rectF) {
        float f;
        float f2 = 0.0f;
        NearbyTilesParams.Builder builder = new NearbyTilesParams.Builder(this.aQ.m651a(this.aB));
        builder.f613a = MapCoordinateHelper.m440a(rectF);
        builder = builder;
        builder.f615c = location;
        builder = builder;
        builder.f621i = aC();
        NearbyTilesParams.Builder builder2 = builder;
        if (location == null) {
            f = 0.0f;
        } else {
            f = (float) location.getAltitude();
        }
        builder2.f617e = f;
        builder2 = builder2;
        if (location == null) {
            f = 0.0f;
        } else {
            f = location.getBearing();
        }
        builder2.f619g = f;
        builder = builder2;
        if (location != null) {
            f2 = location.getSpeed();
        }
        builder.f623k = f2;
        builder = builder;
        builder.f622j = ImmutableList.copyOf(aD());
        return new NearbyTilesParams(builder);
    }

    private BrowseNearbyPlacesParams m543c(Location location, RectF rectF) {
        float f;
        float f2 = 0.0f;
        BrowseNearbyPlacesParams.Builder builder = new BrowseNearbyPlacesParams.Builder();
        builder.b = this.aQ.m651a(this.aB);
        builder = builder;
        builder.a = MapCoordinateHelper.m440a(rectF);
        builder = builder;
        builder.c = location;
        builder = builder;
        builder.i = ImmutableList.copyOf(aC());
        BrowseNearbyPlacesParams.Builder builder2 = builder;
        if (location == null) {
            f = 0.0f;
        } else {
            f = (float) location.getAltitude();
        }
        builder2.e = f;
        builder2 = builder2;
        if (location == null) {
            f = 0.0f;
        } else {
            f = location.getBearing();
        }
        builder2.g = f;
        builder = builder2;
        if (location != null) {
            f2 = location.getSpeed();
        }
        builder.j = f2;
        return new BrowseNearbyPlacesParams(builder);
    }

    private static int m542c(List<MapTile> list) {
        int i = 0;
        for (MapTile mapTile : list) {
            i = (mapTile.backgroundPlaces.size() + mapTile.places.size()) + i;
        }
        return i;
    }

    private List<Long> aC() {
        if (!(this.au == null || this.au.d == null)) {
            Object obj;
            SearchSuggestion searchSuggestion = this.au;
            NearbySearchCategoryList a = NearbySearchCategoryList.m1028a(getContext());
            if (searchSuggestion == null || (searchSuggestion.d != null && searchSuggestion.d.equals(a.f737a))) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                return new ArrayList(this.au.d.b);
            }
        }
        return Collections.emptyList();
    }

    private ImmutableList<String> aD() {
        Builder builder = new Builder();
        if (NearbyUriUtil.m1068a(ao(), this)) {
            builder.c("places-with-fb-wifi()");
        }
        return builder.b();
    }

    static /* synthetic */ void m536a(NearbyMapAreaFragment nearbyMapAreaFragment, List list) {
        Builder builder = ImmutableList.builder();
        for (EdgesModel edgesModel : list) {
            if (!(edgesModel.a() == null || edgesModel.a().l() == null)) {
                builder.c(new NearbyPlaceEdgeWrapper(edgesModel));
            }
        }
        List b = builder.b();
        MapDisplayData a = nearbyMapAreaFragment.aT.m393a(b, Arrays.asList(new NearbyPlaceEdgeWrapper[0]), nearbyMapAreaFragment.aB.m480l());
        aL(nearbyMapAreaFragment);
        nearbyMapAreaFragment.aB.m470a(a);
        nearbyMapAreaFragment.aP.m595a(nearbyMapAreaFragment.aB.m479j(), b);
    }

    private static ImmutableList<NearbyPlaceEdgeWrapper> m545f(List<MapTile> list) {
        Set hashSet = new HashSet();
        Builder builder = ImmutableList.builder();
        for (MapTile mapTile : list) {
            if (mapTile.backgroundPlaces != null) {
                for (NearbyPlaceEdgeWithLayout nearbyPlaceEdgeWithLayout : mapTile.backgroundPlaces) {
                    if (nearbyPlaceEdgeWithLayout.placeEdge != null) {
                        GraphQLPage a = nearbyPlaceEdgeWithLayout.placeEdge.a();
                        if (!(a == null || a.az() == null)) {
                            String ae = a.ae();
                            if (!hashSet.contains(ae)) {
                                hashSet.add(ae);
                                builder.c(new NearbyPlaceEdgeWrapper(nearbyPlaceEdgeWithLayout));
                            }
                        }
                    }
                }
            }
        }
        return builder.b();
    }

    public static void aF(NearbyMapAreaFragment nearbyMapAreaFragment) {
        if (nearbyMapAreaFragment.aG.getVisibility() == 0) {
            nearbyMapAreaFragment.aG.startAnimation(AnimationUtils.loadAnimation(nearbyMapAreaFragment.getContext(), 2130968677));
            nearbyMapAreaFragment.aG.setVisibility(8);
        }
    }

    public static void aH(NearbyMapAreaFragment nearbyMapAreaFragment) {
        if (nearbyMapAreaFragment.f445d) {
            nearbyMapAreaFragment.aP.m601f();
        }
        nearbyMapAreaFragment.aP.aB.h();
        nearbyMapAreaFragment.f444c = false;
        nearbyMapAreaFragment.aH.setVisibility(8);
        if (nearbyMapAreaFragment.aE.getVisibility() == 0) {
            nearbyMapAreaFragment.aE.clearAnimation();
            nearbyMapAreaFragment.aL.reset();
            nearbyMapAreaFragment.aE.startAnimation(nearbyMapAreaFragment.aL);
            nearbyMapAreaFragment.aE.setVisibility(8);
            aF(nearbyMapAreaFragment);
            nearbyMapAreaFragment.f448g.edit().putBoolean(NearbyPrefKeys.f510d, true).commit();
            nearbyMapAreaFragment.aF.setVisibility(0);
        }
    }

    public static void aI(NearbyMapAreaFragment nearbyMapAreaFragment) {
        int i = 1;
        if (nearbyMapAreaFragment.aI.getVisibility() == 8) {
            if (!nearbyMapAreaFragment.ar) {
                RectF a = MapRegionCalculator.m444a(nearbyMapAreaFragment.aB);
                if (nearbyMapAreaFragment.m539a(a, nearbyMapAreaFragment.m532a(a))) {
                    i = 0;
                }
            }
            if (i != 0) {
                nearbyMapAreaFragment.aI.clearAnimation();
                nearbyMapAreaFragment.aM.reset();
                nearbyMapAreaFragment.aI.startAnimation(nearbyMapAreaFragment.aM);
                nearbyMapAreaFragment.aI.setVisibility(0);
            }
        }
    }

    private boolean m539a(RectF rectF, List<MapTile> list) {
        return this.aR.m415a(rectF, (List) list) > 0.97d;
    }

    private void aK() {
        if (this.f445d && this.f444c) {
            this.aH.setVisibility(0);
            this.aH.bringToFront();
        }
    }

    public static void aL(NearbyMapAreaFragment nearbyMapAreaFragment) {
        nearbyMapAreaFragment.f445d = false;
        nearbyMapAreaFragment.aH.setVisibility(8);
    }

    public static RectF m530a(GraphQLGeoRectangle graphQLGeoRectangle) {
        return new RectF((float) graphQLGeoRectangle.l(), (float) graphQLGeoRectangle.j(), (float) graphQLGeoRectangle.a(), (float) graphQLGeoRectangle.k());
    }
}
