package com.facebook.adinterfaces.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.MapAreaPickerActivity;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent.IntentHandler;
import com.facebook.adinterfaces.events.AdInterfacesEvents.LocationTargetingChangedEvent;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdGeoCircleModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.android.maps.model.LatLng;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ContextUtils;
import com.facebook.datasource.DataSource;
import com.facebook.feedplugins.localad.AdInterfacesLocationFetcher;
import com.facebook.feedplugins.localad.AdInterfacesLocationFetcher.LocationFetcherListener;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mappin.MapMarkerImagePostProcessor;
import com.facebook.maps.Locations;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: V2_LOAD_MORE_THREADS_PLACEHOLDER */
public class AdInterfacesMapPreviewViewController extends BaseAdInterfacesViewController<AdInterfacesMapPreviewView, AdInterfacesBoostedComponentDataModel> {
    private static final CallerContext f22794a = CallerContext.a(AdInterfacesMapPreviewViewController.class);
    private final Executor f22795b;
    private final ImagePipeline f22796c;
    public final AdInterfacesEventBus f22797d;
    private final MapMarkerImagePostProcessor f22798e;
    public final AdInterfacesErrorReporter f22799f;
    public OnClickListener f22800g;
    private AdInterfacesLocationFetcher f22801h;
    private IntentHandler f22802i;
    public AdInterfacesMapPreviewView f22803j;
    public Location f22804k;
    public double f22805l = 2.0d;
    public AdInterfacesBoostedComponentDataModel f22806m;
    private DataSource<CloseableReference<CloseableImage>> f22807n;

    /* compiled from: V2_LOAD_MORE_THREADS_PLACEHOLDER */
    class C26381 implements OnClickListener {
        final /* synthetic */ AdInterfacesMapPreviewViewController f22788a;

        C26381(AdInterfacesMapPreviewViewController adInterfacesMapPreviewViewController) {
            this.f22788a = adInterfacesMapPreviewViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1768372062);
            this.f22788a.m24712a(view.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 1350832749, a);
        }
    }

    /* compiled from: V2_LOAD_MORE_THREADS_PLACEHOLDER */
    class C26392 implements OnClickListener {
        final /* synthetic */ AdInterfacesMapPreviewViewController f22789a;

        C26392(AdInterfacesMapPreviewViewController adInterfacesMapPreviewViewController) {
            this.f22789a = adInterfacesMapPreviewViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -239943286);
            this.f22789a.m24712a(view.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1966343940, a);
        }
    }

    /* compiled from: V2_LOAD_MORE_THREADS_PLACEHOLDER */
    class C26403 implements IntentHandler {
        final /* synthetic */ AdInterfacesMapPreviewViewController f22790a;

        C26403(AdInterfacesMapPreviewViewController adInterfacesMapPreviewViewController) {
            this.f22790a = adInterfacesMapPreviewViewController;
        }

        public final void mo980a(int i, Intent intent) {
            if (i == -1) {
                this.f22790a.mo985b(intent.getExtras());
                this.f22790a.f22797d.a(new LocationTargetingChangedEvent(this.f22790a.f22804k, this.f22790a.f22805l));
            }
        }
    }

    /* compiled from: V2_LOAD_MORE_THREADS_PLACEHOLDER */
    class C26414 implements LocationFetcherListener {
        final /* synthetic */ AdInterfacesMapPreviewViewController f22791a;

        C26414(AdInterfacesMapPreviewViewController adInterfacesMapPreviewViewController) {
            this.f22791a = adInterfacesMapPreviewViewController;
        }

        public final void mo945a(@Nullable AdGeoCircleModel adGeoCircleModel) {
            if (adGeoCircleModel != null) {
                this.f22791a.m24725a(Locations.a(adGeoCircleModel.m23172a(), adGeoCircleModel.m23176b()), adGeoCircleModel.m23177c());
            }
        }
    }

    public static AdInterfacesMapPreviewViewController m24716b(InjectorLike injectorLike) {
        return new AdInterfacesMapPreviewViewController((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), AdInterfacesEventBus.m22728a(injectorLike), AdInterfacesLocationFetcher.m26563b(injectorLike), MapMarkerImagePostProcessor.b(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike));
    }

    public static AdInterfacesMapPreviewViewController m24711a(InjectorLike injectorLike) {
        return m24716b(injectorLike);
    }

    @Inject
    public AdInterfacesMapPreviewViewController(Executor executor, ImagePipeline imagePipeline, AdInterfacesEventBus adInterfacesEventBus, AdInterfacesLocationFetcher adInterfacesLocationFetcher, MapMarkerImagePostProcessor mapMarkerImagePostProcessor, AdInterfacesErrorReporter adInterfacesErrorReporter) {
        this.f22795b = executor;
        this.f22796c = imagePipeline;
        this.f22797d = adInterfacesEventBus;
        this.f22801h = adInterfacesLocationFetcher;
        this.f22798e = mapMarkerImagePostProcessor;
        this.f22799f = adInterfacesErrorReporter;
    }

    public final void m24729a(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel) {
        this.f22806m = adInterfacesBoostedComponentDataModel;
    }

    public final void m24730a(AdInterfacesMapPreviewView adInterfacesMapPreviewView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo982a(adInterfacesMapPreviewView, adInterfacesCardLayout);
        this.f22803j = adInterfacesMapPreviewView;
        m24717b(this.f22806m);
        this.f22803j.setOnClickListener(new C26381(this));
        this.f22800g = new C26392(this);
        this.f22803j.setOnClickListener(this.f22800g);
        this.f22802i = new C26403(this);
        this.f22797d.m22730a(20005, this.f22802i);
    }

    public final void mo981a() {
        super.mo981a();
        AdInterfacesEventBus adInterfacesEventBus = this.f22797d;
        IntentHandler intentHandler = this.f22802i;
        IntentHandler intentHandler2 = (IntentHandler) adInterfacesEventBus.f21653a.get(20005);
        if (intentHandler2 != null) {
            if (intentHandler2 == intentHandler) {
                adInterfacesEventBus.f21653a.remove(20005);
            } else {
                adInterfacesEventBus.f21654b.m22726a(AdInterfacesEventBus.class, "Unregister handler mismatch for request code " + 20005);
            }
        }
        if (this.f22807n != null) {
            this.f22807n.g();
        }
        this.f22803j.setOnClickListener(null);
        this.f22803j = null;
        this.f22802i = null;
    }

    public final void mo984a(Bundle bundle) {
        bundle.putParcelable("location_extra", this.f22804k);
        bundle.putDouble("radius_extra", this.f22805l);
    }

    public final void mo985b(@Nullable Bundle bundle) {
        if (bundle != null) {
            m24725a((Location) bundle.getParcelable("location_extra"), bundle.getDouble("radius_extra"));
        }
    }

    private void m24712a(Context context) {
        Intent intent = new Intent(context, MapAreaPickerActivity.class);
        intent.putExtra("location_extra", this.f22804k);
        intent.putExtra("radius_extra", this.f22805l);
        intent.putExtra("target_spec_extra", this.f22806m.f21754j);
        intent.putExtra("ad_account_id_extra", m24719c());
        this.f22801h.m26564a();
        this.f22797d.a(new IntentEvent(intent, 20005));
    }

    private String m24719c() {
        return ((AdAccountModel) this.f22806m.f21745a.m23183a().m23158a().get(0)).m23145s();
    }

    private void m24717b(BaseAdInterfacesData baseAdInterfacesData) {
        ImmutableList immutableList = baseAdInterfacesData.f21754j.f21725e;
        if (immutableList == null || immutableList.isEmpty()) {
            m24725a(Locations.a(0.0d, 0.0d), this.f22805l);
            m24721d();
            return;
        }
        GeoLocationModel geoLocationModel = this.f22806m.f21803h;
        if (!(geoLocationModel == null || this.f22806m.f21802g == null)) {
            m24714a(new LatLng(geoLocationModel.m23442g(), geoLocationModel.mN_()));
        }
        GeoLocationModel geoLocationModel2 = (GeoLocationModel) immutableList.get(0);
        m24725a(Locations.a(geoLocationModel2.m23442g(), geoLocationModel2.mN_()), geoLocationModel2.m23444k());
    }

    private void m24721d() {
        this.f22801h.m26565a(new C26414(this), (Activity) ContextUtils.a(this.f22803j.getContext(), Activity.class));
    }

    @VisibleForTesting
    public final void m24725a(Location location, double d) {
        this.f22804k = location;
        this.f22805l = d;
        this.f22803j.m24704a(new LatLng(location.getLatitude(), location.getLongitude()), d);
    }

    @VisibleForTesting
    private void m24714a(final LatLng latLng) {
        ImageRequestBuilder a = ImageRequestBuilder.a(Uri.parse(this.f22806m.f21802g));
        a.j = this.f22798e;
        this.f22807n = this.f22796c.c(a.m(), f22794a);
        this.f22807n.a(new BaseBitmapDataSubscriber(this) {
            final /* synthetic */ AdInterfacesMapPreviewViewController f22793b;

            protected final void m24708a(@Nullable Bitmap bitmap) {
                if (bitmap != null) {
                    this.f22793b.f22803j.m24705a(latLng, bitmap);
                }
            }

            protected final void m24709f(DataSource<CloseableReference<CloseableImage>> dataSource) {
                this.f22793b.f22799f.m22726a(getClass(), "Failed to download page picture for page " + this.f22793b.f22806m.f21747c);
            }
        }, this.f22795b);
    }

    public final OnClickListener m24731b() {
        return this.f22800g;
    }
}
