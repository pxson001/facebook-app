package com.facebook.storelocator;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.android.maps.CameraUpdateFactory;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.FacebookMap.OnCameraChangeListener;
import com.facebook.android.maps.FacebookMap.OnMarkerClickListener;
import com.facebook.android.maps.FacebookMapOptions;
import com.facebook.android.maps.OnMapReadyCallback;
import com.facebook.android.maps.Projection;
import com.facebook.android.maps.SupportMapFragment;
import com.facebook.android.maps.model.BitmapDescriptor;
import com.facebook.android.maps.model.BitmapDescriptorFactory;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.android.maps.model.Marker;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.references.CloseableReference;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.datasource.DataSource;
import com.facebook.device.ScreenUtil;
import com.facebook.entitycards.contextitems.analytics.ContextItemsAnalyticsLogger;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.entitycards.contextitems.surface.ContextItemSurfaces;
import com.facebook.entitycards.contextitems.ui.ContextItemsViewBinder;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mappin.MapMarkerImagePostProcessor;
import com.facebook.pages.identity.contextitems.PageContextItemsFallbackHandler;
import com.facebook.storelocator.protocol.FetchStoresQueryMethod;
import com.facebook.storelocator.protocol.FetchStoresQueryMethod.OnNewLocationsListener;
import com.facebook.storelocator.protocol.FetchStoresQueryMethod.Tasks;
import com.facebook.storelocator.protocol.StoreLocatorQueryModels.StoreLocatorNearbyLocationsQueryModel.LocationsModel;
import com.facebook.storelocator.protocol.StoreLocatorQueryModels.StoreLocatorNearbyLocationsQueryModel.LocationsModel.PinLocationModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.uicontrib.contextitem.PlutoniumContextualItemView;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView.OnPageChangedListener;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Null adapter when onRelatedPageDataReady called */
public class StoreLocatorActivity extends FbFragmentActivity implements OnMapReadyCallback, OnNewLocationsListener {
    private static final CallerContext f12880z = CallerContext.a(StoreLocatorActivity.class);
    private SupportMapFragment f12881A;
    private LatLngBounds f12882B;
    private String f12883C;
    private String f12884D;
    private String f12885E;
    public FacebookMap f12886F;
    private BitmapDescriptor f12887G;
    public View f12888H;
    public StoreLocatorRowAdapter f12889I;
    public HScrollRecyclerView f12890J;
    public int f12891K;
    public float f12892L;
    public ArrayList<Marker> f12893M;
    public Marker f12894N;
    private DataSource<CloseableReference<CloseableImage>> f12895O;
    private boolean f12896P = true;
    @Inject
    AnalyticsLogger f12897p;
    @Inject
    ScreenUtil f12898q;
    @Inject
    FetchStoresQueryMethod f12899r;
    @Inject
    ContextItemsViewBinder f12900s;
    @Inject
    PageContextItemsFallbackHandler f12901t;
    @Inject
    MapMarkerImagePostProcessor f12902u;
    @Inject
    ImagePipeline f12903v;
    @Inject
    SecureContextHelper f12904w;
    @Inject
    ContextItemsAnalyticsLogger f12905x;
    @Inject
    @ForUiThread
    Executor f12906y;

    /* compiled from: Null adapter when onRelatedPageDataReady called */
    class C15141 implements OnClickListener {
        final /* synthetic */ StoreLocatorActivity f12860a;

        C15141(StoreLocatorActivity storeLocatorActivity) {
            this.f12860a = storeLocatorActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -532828706);
            StoreLocatorActivity.m13570l(this.f12860a);
            Logger.a(2, EntryType.UI_INPUT_END, -576429156, a);
        }
    }

    /* compiled from: Null adapter when onRelatedPageDataReady called */
    class C15152 implements OnPageChangedListener {
        final /* synthetic */ StoreLocatorActivity f12861a;

        C15152(StoreLocatorActivity storeLocatorActivity) {
            this.f12861a = storeLocatorActivity;
        }

        public final void m13533a(int i, int i2) {
            AnalyticsLogger analyticsLogger = this.f12861a.f12897p;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("store_locator_card_focused");
            honeyClientEvent.c = "store_locator";
            analyticsLogger.a(honeyClientEvent.a("card_index", i));
            if (i < this.f12861a.f12893M.size()) {
                this.f12861a.m13557a((LocationsModel) this.f12861a.f12889I.f12877d.get(i));
                this.f12861a.m13552a((Marker) this.f12861a.f12893M.get(i), i, true);
            }
        }
    }

    /* compiled from: Null adapter when onRelatedPageDataReady called */
    public class C15163 {
        final /* synthetic */ StoreLocatorActivity f12862a;

        C15163(StoreLocatorActivity storeLocatorActivity) {
            this.f12862a = storeLocatorActivity;
        }

        public final boolean m13534a() {
            Location e = this.f12862a.f12886F.e();
            if (e != null) {
                Projection projection = this.f12862a.f12886F.k;
                this.f12862a.m13549a(projection, projection.a(new LatLng(e.getLatitude(), e.getLongitude())));
            }
            return true;
        }
    }

    /* compiled from: Null adapter when onRelatedPageDataReady called */
    class C15174 implements OnMarkerClickListener {
        final /* synthetic */ StoreLocatorActivity f12863a;

        C15174(StoreLocatorActivity storeLocatorActivity) {
            this.f12863a = storeLocatorActivity;
        }

        public final boolean m13535a(Marker marker) {
            int size = this.f12863a.f12893M.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Marker marker2 = (Marker) this.f12863a.f12893M.get(i2);
                if (marker2.a().equals(marker.a())) {
                    this.f12863a.f12890J.setCurrentPosition(i);
                    this.f12863a.m13552a(marker2, i, true);
                    break;
                }
                i++;
            }
            return true;
        }
    }

    /* compiled from: Null adapter when onRelatedPageDataReady called */
    class C15185 implements OnCameraChangeListener {
        final /* synthetic */ StoreLocatorActivity f12864a;

        C15185(StoreLocatorActivity storeLocatorActivity) {
            this.f12864a = storeLocatorActivity;
        }

        public final void m13536a(CameraPosition cameraPosition) {
            this.f12864a.f12888H.setVisibility(0);
        }
    }

    /* compiled from: Null adapter when onRelatedPageDataReady called */
    class C15196 implements OnClickListener {
        final /* synthetic */ StoreLocatorActivity f12865a;

        C15196(StoreLocatorActivity storeLocatorActivity) {
            this.f12865a = storeLocatorActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -384524742);
            this.f12865a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -2038299777, a);
        }
    }

    /* compiled from: Null adapter when onRelatedPageDataReady called */
    class C15218 extends BaseBitmapDataSubscriber {
        final /* synthetic */ StoreLocatorActivity f12869a;

        C15218(StoreLocatorActivity storeLocatorActivity) {
            this.f12869a = storeLocatorActivity;
        }

        protected final void m13537a(@Nullable Bitmap bitmap) {
            if (bitmap != null && this.f12869a.f12894N != null) {
                this.f12869a.f12894N.a(BitmapDescriptorFactory.a(bitmap));
                this.f12869a.f12894N.f(0.5f, 0.93f);
            }
        }

        protected final void m13538f(DataSource<CloseableReference<CloseableImage>> dataSource) {
        }
    }

    /* compiled from: Null adapter when onRelatedPageDataReady called */
    public final class StoreLocatorRowAdapter extends Adapter<StoreLocatorViewHolder> {
        final /* synthetic */ StoreLocatorActivity f12874a;
        private final OnClickListener f12875b;
        private final OnClickListener f12876c;
        public ImmutableList<LocationsModel> f12877d = RegularImmutableList.a;

        public final ViewHolder m13541a(ViewGroup viewGroup, int i) {
            int i2;
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130907242, viewGroup, false);
            LayoutParams layoutParams = new LayoutParams(this.f12874a.f12891K, -2);
            if (i == 0) {
                i2 = (int) this.f12874a.f12892L;
            } else {
                i2 = 0;
            }
            layoutParams.setMargins(i2, 0, (int) this.f12874a.f12892L, 0);
            inflate.setLayoutParams(layoutParams);
            return new StoreLocatorViewHolder(inflate);
        }

        public final void m13542a(ViewHolder viewHolder, int i) {
            StoreLocatorViewHolder storeLocatorViewHolder = (StoreLocatorViewHolder) viewHolder;
            ContentView contentView = storeLocatorViewHolder.f12878l;
            LocationsModel locationsModel = (LocationsModel) this.f12877d.get(i);
            contentView.setThumbnailUri(locationsModel.m13612l().b());
            contentView.setTag(2131558840, Integer.valueOf(i));
            contentView.setTitleText(locationsModel.m13611k());
            contentView.setSubtitleText(locationsModel.m13610j());
            contentView.setOnClickListener(this.f12876c);
            int size = locationsModel.m13609a().size();
            for (int i2 = 0; i2 < storeLocatorViewHolder.f12879m.size(); i2++) {
                m13540a(storeLocatorViewHolder, locationsModel, size, i2);
            }
        }

        StoreLocatorRowAdapter(final StoreLocatorActivity storeLocatorActivity) {
            this.f12874a = storeLocatorActivity;
            this.f12876c = new OnClickListener(this) {
                final /* synthetic */ StoreLocatorRowAdapter f12871b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 84917139);
                    Integer num = (Integer) view.getTag(2131558840);
                    AnalyticsLogger analyticsLogger = this.f12871b.f12874a.f12897p;
                    int intValue = num.intValue();
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("store_locator_card_click");
                    honeyClientEvent.c = "store_locator";
                    analyticsLogger.a(honeyClientEvent.a("card_index", intValue));
                    Logger.a(2, EntryType.UI_INPUT_END, -1394047949, a);
                }
            };
            this.f12875b = new OnClickListener(this) {
                final /* synthetic */ StoreLocatorRowAdapter f12873b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 2044033411);
                    ContextItemFieldsModel contextItemFieldsModel = (ContextItemFieldsModel) view.getTag(2131558837);
                    this.f12873b.f12874a.f12905x.a(ContextItemSurfaces.STORE_LOCATOR, contextItemFieldsModel.d().name(), (String) view.getTag(2131558839), ((Integer) view.getTag(2131558838)).intValue(), Optional.fromNullable(contextItemFieldsModel.bA_()));
                    if (contextItemFieldsModel.d() != GraphQLEntityCardContextItemType.GET_DIRECTIONS) {
                        this.f12873b.f12874a.f12901t.m4774a(contextItemFieldsModel);
                        Logger.a(2, EntryType.UI_INPUT_END, 1389076531, a);
                    } else if (contextItemFieldsModel.a() == null) {
                        LogUtils.a(397658049, a);
                    } else {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.putExtra("com.facebook.intent.extra.SKIP_IN_APP_BROWSER", true);
                        intent.setData(Uri.parse(contextItemFieldsModel.a()));
                        this.f12873b.f12874a.f12904w.b(intent, this.f12873b.f12874a);
                        LogUtils.a(-514740072, a);
                    }
                }
            };
        }

        final void m13543a(ImmutableList<LocationsModel> immutableList) {
            this.f12877d = immutableList;
        }

        public final int getItemViewType(int i) {
            return i == 0 ? 0 : 1;
        }

        private void m13540a(StoreLocatorViewHolder storeLocatorViewHolder, LocationsModel locationsModel, int i, int i2) {
            PlutoniumContextualItemView plutoniumContextualItemView = (PlutoniumContextualItemView) storeLocatorViewHolder.f12879m.get(i2);
            if (i2 >= i) {
                plutoniumContextualItemView.setVisibility(8);
                plutoniumContextualItemView.setTag(2131558837, null);
                plutoniumContextualItemView.setTag(2131558839, null);
                plutoniumContextualItemView.setTag(2131558838, null);
                return;
            }
            plutoniumContextualItemView.setVisibility(0);
            ContextItemFieldsModel contextItemFieldsModel = (ContextItemFieldsModel) locationsModel.m13609a().get(i2);
            this.f12874a.f12900s.a(plutoniumContextualItemView, contextItemFieldsModel, null);
            plutoniumContextualItemView.setOnClickListener(this.f12875b);
            plutoniumContextualItemView.setTag(2131558837, contextItemFieldsModel);
            plutoniumContextualItemView.setTag(2131558839, locationsModel.m13613m().m13598j());
            plutoniumContextualItemView.setTag(2131558838, Integer.valueOf(i2));
        }

        public final int aZ_() {
            return this.f12877d.size();
        }
    }

    /* compiled from: Null adapter when onRelatedPageDataReady called */
    class StoreLocatorViewHolder extends ViewHolder {
        final ContentView f12878l;
        final ImmutableList<PlutoniumContextualItemView> f12879m;

        StoreLocatorViewHolder(View view) {
            super(view);
            this.f12878l = (ContentView) view.findViewById(2131567665);
            this.f12879m = ImmutableList.of((PlutoniumContextualItemView) view.findViewById(2131567666), (PlutoniumContextualItemView) view.findViewById(2131567667), (PlutoniumContextualItemView) view.findViewById(2131567668), (PlutoniumContextualItemView) view.findViewById(2131567669));
        }
    }

    private static <T extends Context> void m13558a(Class<T> cls, T t) {
        m13559a((Object) t, (Context) t);
    }

    public static void m13559a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((StoreLocatorActivity) obj).m13548a(AnalyticsLoggerMethodAutoProvider.a(fbInjector), ScreenUtil.a(fbInjector), FetchStoresQueryMethod.m13582a(fbInjector), ContextItemsViewBinder.b(fbInjector), PageContextItemsFallbackHandler.m4773b(fbInjector), MapMarkerImagePostProcessor.b(fbInjector), ImagePipelineMethodAutoProvider.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), ContextItemsAnalyticsLogger.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector));
    }

    private void m13548a(AnalyticsLogger analyticsLogger, ScreenUtil screenUtil, FetchStoresQueryMethod fetchStoresQueryMethod, ContextItemsViewBinder contextItemsViewBinder, PageContextItemsFallbackHandler pageContextItemsFallbackHandler, MapMarkerImagePostProcessor mapMarkerImagePostProcessor, ImagePipeline imagePipeline, SecureContextHelper secureContextHelper, ContextItemsAnalyticsLogger contextItemsAnalyticsLogger, Executor executor) {
        this.f12897p = analyticsLogger;
        this.f12898q = screenUtil;
        this.f12899r = fetchStoresQueryMethod;
        this.f12900s = contextItemsViewBinder;
        this.f12901t = pageContextItemsFallbackHandler;
        this.f12902u = mapMarkerImagePostProcessor;
        this.f12903v = imagePipeline;
        this.f12904w = secureContextHelper;
        this.f12905x = contextItemsAnalyticsLogger;
        this.f12906y = executor;
    }

    protected final void m13572a(@Nullable Bundle bundle) {
        super.a(bundle);
        Class cls = StoreLocatorActivity.class;
        m13559a((Object) this, (Context) this);
        AnalyticsLogger analyticsLogger = this.f12897p;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("store_locator_open");
        honeyClientEvent.c = "store_locator";
        analyticsLogger.a(honeyClientEvent);
    }

    public final void m13575b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130907241);
        this.f12887G = BitmapDescriptorFactory.a(2130841141);
        this.f12893M = new ArrayList();
        FacebookMapOptions facebookMapOptions = new FacebookMapOptions();
        facebookMapOptions.m = "ad_area_picker";
        facebookMapOptions = facebookMapOptions;
        facebookMapOptions.d = false;
        this.f12881A = SupportMapFragment.a(facebookMapOptions);
        kO_().a().b(2131559301, this.f12881A, "map_fragment").b();
        Intent intent = getIntent();
        double parseDouble = Double.parseDouble(intent.getStringExtra("east"));
        double parseDouble2 = Double.parseDouble(intent.getStringExtra("north"));
        double parseDouble3 = Double.parseDouble(intent.getStringExtra("south"));
        double parseDouble4 = Double.parseDouble(intent.getStringExtra("west"));
        this.f12883C = intent.getStringExtra("ad_id");
        this.f12884D = intent.getStringExtra("page_set_id");
        this.f12885E = intent.getStringExtra("parent_page_id");
        this.f12882B = LatLngBounds.a().a(new LatLng(parseDouble2, parseDouble4)).a(new LatLng(parseDouble3, parseDouble)).a();
        this.f12888H = a(2131564093);
        this.f12888H.setOnClickListener(new C15141(this));
        m13568j();
        m13569k();
    }

    private void m13568j() {
        this.f12892L = getResources().getDimension(2131434508);
        this.f12890J = (HScrollRecyclerView) a(2131567663);
        this.f12889I = new StoreLocatorRowAdapter(this);
        this.f12890J.setAdapter(this.f12889I);
        this.f12890J.m = new C15152(this);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -258040925);
        super.onResume();
        this.f12881A.a(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1585815136, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 976336018);
        super.onPause();
        FetchStoresQueryMethod fetchStoresQueryMethod = this.f12899r;
        FetchStoresQueryMethod.m13584b(fetchStoresQueryMethod);
        fetchStoresQueryMethod.f12913b.c(Tasks.FETCH_LOCATIONS_TASK);
        this.f12886F.s = null;
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 55727979, a);
    }

    public final void m13573a(FacebookMap facebookMap) {
        this.f12886F = facebookMap;
        this.f12886F.a(true);
        this.f12886F.s = new C15163(this);
        this.f12886F.m = new C15174(this);
        this.f12886F.g = new C15185(this);
        if (this.f12896P) {
            this.f12886F.b(CameraUpdateFactory.a(this.f12882B, 0));
            m13570l(this);
        }
    }

    public final void mo363a(ImmutableList<LocationsModel> immutableList) {
        int i;
        int i2;
        this.f12886F.b();
        HScrollRecyclerView hScrollRecyclerView = this.f12890J;
        if (immutableList.isEmpty()) {
            i = 8;
        } else {
            i = 0;
        }
        hScrollRecyclerView.setVisibility(i);
        int size = this.f12893M.size();
        for (i2 = 0; i2 < size; i2++) {
            ((Marker) this.f12893M.get(i2)).l();
        }
        this.f12893M.clear();
        this.f12889I.f12877d = immutableList;
        i2 = this.f12898q.c();
        this.f12891K = (int) (((immutableList.size() == 1 ? 1.0f : 0.84f) * ((float) i2)) - (2.0f * this.f12892L));
        this.f12890J.removeAllViews();
        this.f12890J.g(this.f12891K, i2);
        this.f12889I.notifyDataSetChanged();
        size = immutableList.size();
        for (i2 = 0; i2 < size; i2++) {
            this.f12893M.add(this.f12886F.a(m13546a(((LocationsModel) immutableList.get(i2)).m13614n())));
        }
        if (this.f12893M.isEmpty()) {
            Toast.makeText(this, 2131242351, 1).show();
        } else {
            m13557a((LocationsModel) immutableList.get(0));
            this.f12890J.setCurrentPosition(0);
            m13552a((Marker) this.f12893M.get(0), 0, this.f12896P);
        }
        this.f12896P = false;
        m13547a(this.f12890J);
    }

    private MarkerOptions m13546a(PinLocationModel pinLocationModel) {
        if (this.f12887G == null) {
            this.f12887G = BitmapDescriptorFactory.a(2130841141);
        }
        MarkerOptions a = new MarkerOptions().a(0.5f, 0.5f);
        a.c = this.f12887G;
        a = a;
        a.b = new LatLng(pinLocationModel.m13601a(), pinLocationModel.m13605j());
        return a;
    }

    public final void mo364i() {
        this.f12886F.b();
    }

    private void m13557a(LocationsModel locationsModel) {
        ImmutableList a = locationsModel.m13609a();
        int size = a.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            ContextItemFieldsModel contextItemFieldsModel = (ContextItemFieldsModel) a.get(i);
            int i3 = i2 + 1;
            this.f12905x.b(ContextItemSurfaces.STORE_LOCATOR, contextItemFieldsModel.d().name(), locationsModel.m13613m().m13598j(), i2, Optional.fromNullable(contextItemFieldsModel.bA_()));
            i++;
            i2 = i3;
        }
    }

    private void m13569k() {
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.setHasBackButton(true);
        fbTitleBar.setTitle(getString(2131242348));
        fbTitleBar.a(new C15196(this));
    }

    public static void m13570l(StoreLocatorActivity storeLocatorActivity) {
        if (storeLocatorActivity.f12894N != null) {
            storeLocatorActivity.f12894N.l();
        }
        storeLocatorActivity.f12894N = null;
        ProgressDialog progressDialog = new ProgressDialog(storeLocatorActivity);
        progressDialog.a(storeLocatorActivity.getString(2131242350));
        progressDialog.show();
        storeLocatorActivity.f12888H.setVisibility(8);
        Projection projection = storeLocatorActivity.f12886F.k;
        LatLng latLng = projection.a().c;
        LatLng a = projection.a(new Point(storeLocatorActivity.f12898q.c(), (int) storeLocatorActivity.f12890J.getY()));
        storeLocatorActivity.f12899r.m13585a(storeLocatorActivity.f12883C, storeLocatorActivity.f12885E, storeLocatorActivity.f12884D, latLng.a, latLng.b, a.a, a.b, progressDialog, storeLocatorActivity);
    }

    private void m13547a(View view) {
        view.setTranslationX((float) this.f12898q.c());
        view.animate().translationX(0.0f).setInterpolator(new DecelerateInterpolator(3.0f)).setDuration(700).start();
    }

    private void m13552a(Marker marker, int i, boolean z) {
        m13571m();
        m13551a(marker, i);
        if (z) {
            m13550a(marker);
        }
    }

    private void m13571m() {
        if (this.f12894N != null) {
            this.f12894N.a(this.f12887G);
            this.f12894N.p();
            this.f12894N.f(0.5f, 0.5f);
        }
    }

    private void m13550a(Marker marker) {
        final Projection projection = this.f12886F.k;
        final Point a = projection.a(marker.a());
        if (this.f12890J.getHeight() > 0) {
            m13549a(projection, a);
        } else {
            this.f12890J.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ StoreLocatorActivity f12868c;

                public void onGlobalLayout() {
                    CustomViewUtils.a(this.f12868c.f12890J, this);
                    this.f12868c.m13549a(projection, a);
                }
            });
        }
    }

    private void m13551a(Marker marker, int i) {
        ImageRequestBuilder a = ImageRequestBuilder.a(Uri.parse(((LocationsModel) this.f12889I.f12877d.get(i)).m13612l().b()));
        a.j = this.f12902u;
        ImageRequest m = a.m();
        this.f12894N = marker;
        this.f12895O = this.f12903v.c(m, f12880z);
        this.f12895O.a(new C15218(this), this.f12906y);
        this.f12894N.q();
    }

    private void m13549a(Projection projection, Point point) {
        point.y += (this.f12890J.getHeight() + ((int) this.f12892L)) / 2;
        this.f12886F.a(CameraUpdateFactory.a(projection.a(point)), 500, null);
    }
}
