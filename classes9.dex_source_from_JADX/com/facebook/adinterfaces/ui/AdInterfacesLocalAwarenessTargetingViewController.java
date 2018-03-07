package com.facebook.adinterfaces.ui;

import android.location.Location;
import android.os.Bundle;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CallToActionSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.LocationTargetingChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.LocationTargetingChangedSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.TargetingChangedSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesTargetingData;
import com.facebook.adinterfaces.model.AdInterfacesTargetingData.LocationType;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.localawareness.AdInterfacesLocalAwarenessDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel.Builder;
import com.facebook.adinterfaces.util.targeting.AdInterfacesTargetingDelegate;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.enums.GraphQLAdGeoLocationType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import java.text.NumberFormat;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: V2_MESSAGE_REQUEST_THREADS */
public class AdInterfacesLocalAwarenessTargetingViewController extends AdInterfacesTargetingViewController<AdInterfacesLocalAwarenessDataModel> {
    private final NumberFormat f22773k = NumberFormat.getInstance(this.f22775m.a());
    public AdInterfacesMapPreviewViewController f22774l;
    public Locales f22775m;
    public AdInterfacesLocalAwarenessDataModel f22776n;
    public ImmutableList<GeoLocationModel> f22777o;
    private AdInterfacesLocalAwarenessAudienceView f22778p;
    public AdInterfacesContext f22779q;

    /* compiled from: V2_MESSAGE_REQUEST_THREADS */
    public class C26341 extends LocationTargetingChangedSubscriber {
        final /* synthetic */ AdInterfacesLocalAwarenessTargetingViewController f22770a;

        public C26341(AdInterfacesLocalAwarenessTargetingViewController adInterfacesLocalAwarenessTargetingViewController) {
            this.f22770a = adInterfacesLocalAwarenessTargetingViewController;
        }

        public final void m24683b(FbEvent fbEvent) {
            LocationTargetingChangedEvent locationTargetingChangedEvent = (LocationTargetingChangedEvent) fbEvent;
            Location location = locationTargetingChangedEvent.f21672a;
            AdInterfacesTargetingData adInterfacesTargetingData = this.f22770a.f22776n.f21754j;
            AdInterfacesLocalAwarenessTargetingViewController adInterfacesLocalAwarenessTargetingViewController = this.f22770a;
            Builder builder = new Builder();
            builder.f22135d = AdInterfacesTargetingDelegate.m25299a(this.f22770a.f22775m);
            builder = builder;
            builder.f22137f = location.getLatitude();
            builder = builder;
            builder.f22138g = GraphQLAdGeoLocationType.CUSTOM_LOCATION;
            builder = builder;
            builder.f22139h = location.getLongitude();
            Builder builder2 = builder;
            builder2.f22141j = locationTargetingChangedEvent.f21673b;
            adInterfacesLocalAwarenessTargetingViewController.f22777o = ImmutableList.of(builder2.m23431a());
            adInterfacesTargetingData.f21725e = this.f22770a.f22777o;
            AdInterfacesLocalAwarenessTargetingViewController.m24688h(this.f22770a);
            this.f22770a.m24447b();
        }
    }

    /* compiled from: V2_MESSAGE_REQUEST_THREADS */
    public class C26352 extends TargetingChangedSubscriber {
        final /* synthetic */ AdInterfacesLocalAwarenessTargetingViewController f22771a;

        public C26352(AdInterfacesLocalAwarenessTargetingViewController adInterfacesLocalAwarenessTargetingViewController) {
            this.f22771a = adInterfacesLocalAwarenessTargetingViewController;
        }

        public final void m24684b(FbEvent fbEvent) {
            AdInterfacesLocalAwarenessTargetingViewController.m24687g(this.f22771a);
        }
    }

    /* compiled from: V2_MESSAGE_REQUEST_THREADS */
    public class C26363 extends CallToActionSubscriber {
        final /* synthetic */ AdInterfacesLocalAwarenessTargetingViewController f22772a;

        public C26363(AdInterfacesLocalAwarenessTargetingViewController adInterfacesLocalAwarenessTargetingViewController) {
            this.f22772a = adInterfacesLocalAwarenessTargetingViewController;
        }

        public final void m24685b(FbEvent fbEvent) {
            AdInterfacesLocalAwarenessTargetingViewController.m24687g(this.f22772a);
        }
    }

    public static AdInterfacesLocalAwarenessTargetingViewController m24686d(InjectorLike injectorLike) {
        return new AdInterfacesLocalAwarenessTargetingViewController(AdInterfacesMapPreviewViewController.m24716b(injectorLike), AdInterfacesAudienceOptionsViewController.m24419b(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike), Locales.a(injectorLike));
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesLocalAwarenessDataModel) baseAdInterfacesData;
        super.mo983a(baseAdInterfacesData);
        this.f22774l.f22806m = baseAdInterfacesData;
        this.f22776n = baseAdInterfacesData;
        this.f22777o = baseAdInterfacesData.f21754j.f21725e;
    }

    @Inject
    public AdInterfacesLocalAwarenessTargetingViewController(AdInterfacesMapPreviewViewController adInterfacesMapPreviewViewController, AdInterfacesAudienceOptionsViewController adInterfacesAudienceOptionsViewController, AdInterfacesDataHelper adInterfacesDataHelper, Locales locales) {
        super(adInterfacesAudienceOptionsViewController, adInterfacesDataHelper);
        this.f22774l = adInterfacesMapPreviewViewController;
        this.f22775m = locales;
        this.f22773k.setMaximumFractionDigits(2);
        this.f22773k.setMinimumFractionDigits(2);
    }

    public final void mo988a(AdInterfacesContext adInterfacesContext) {
        super.mo988a(adInterfacesContext);
        this.f22774l.mo988a(adInterfacesContext);
    }

    public final void mo992a(AdInterfacesTargetingView adInterfacesTargetingView, AdInterfacesCardLayout adInterfacesCardLayout) {
        this.e = adInterfacesTargetingView;
        this.f22778p = ((AdInterfacesTargetingView) this.f22581e).f22565m;
        this.f = adInterfacesCardLayout;
        this.f22779q = this.f22440b;
        m24443a(this.f22776n.f21754j);
        if (1 == null) {
            ((AdInterfacesTargetingView) this.f22581e).f22557e.setVisibility(8);
        } else {
            ((AdInterfacesTargetingView) this.f22581e).f22557e.setVisibility(0);
            this.f22774l.m24730a(((AdInterfacesTargetingView) this.f22581e).f22557e, this.f22582f);
        }
        ((AdInterfacesTargetingView) this.f22581e).setLocationsSelectorVisibility(8);
        ((AdInterfacesTargetingView) this.f22581e).setInterestsSelectorVisibility(8);
        this.f22778p.setOnClickListener(this.f22774l.f22800g);
        m24453d(true);
        ((AdInterfacesTargetingView) this.f22581e).setAgeViewTopDividerVisibility(8);
        m24446a(true);
        m24688h(this);
        this.f22779q.m22430a(new C26341(this));
        this.f22779q.m22430a(new C26352(this));
        this.f22779q.m22430a(new C26363(this));
        AdInterfacesBaseTargetingViewController.m24438a(adInterfacesCardLayout);
    }

    public final void mo981a() {
        super.mo981a();
        this.f22774l.mo981a();
        this.f22778p.setOnClickListener(null);
        this.f22779q = null;
        this.f = null;
        this.e = null;
        this.f22778p = null;
    }

    public final void mo984a(Bundle bundle) {
        super.mo984a(bundle);
        this.f22774l.mo984a(bundle);
    }

    public final void mo985b(Bundle bundle) {
        super.mo985b(bundle);
        this.f22774l.mo985b(bundle);
    }

    @Nullable
    public final AdInterfacesTargetingData mo1012c() {
        AdInterfacesTargetingData c = super.mo1012c();
        c.f21725e = this.f22777o;
        c.f21727g = ImmutableList.of(LocationType.HOME, LocationType.RECENT);
        return c;
    }

    public static void m24687g(AdInterfacesLocalAwarenessTargetingViewController adInterfacesLocalAwarenessTargetingViewController) {
        AdInterfacesCallToActionViewController.m24551a(adInterfacesLocalAwarenessTargetingViewController.f22779q, adInterfacesLocalAwarenessTargetingViewController.f22776n.mo951C().f21774g, adInterfacesLocalAwarenessTargetingViewController.f22582f, adInterfacesLocalAwarenessTargetingViewController.f22776n);
    }

    public static void m24688h(AdInterfacesLocalAwarenessTargetingViewController adInterfacesLocalAwarenessTargetingViewController) {
        AdInterfacesTargetingData adInterfacesTargetingData = adInterfacesLocalAwarenessTargetingViewController.f22776n.f21754j;
        if (adInterfacesTargetingData.f21725e != null && !adInterfacesTargetingData.f21725e.isEmpty()) {
            GeoLocationModel geoLocationModel = (GeoLocationModel) adInterfacesTargetingData.f21725e.get(0);
            adInterfacesLocalAwarenessTargetingViewController.f22778p.setAddress(StringUtil.a(new CharSequence[]{geoLocationModel.m23437a()}) ? ((AdInterfacesTargetingView) adInterfacesLocalAwarenessTargetingViewController.f22581e).getResources().getString(2131234098) : geoLocationModel.m23437a());
            adInterfacesLocalAwarenessTargetingViewController.f22778p.setRadius(geoLocationModel.m23444k());
            adInterfacesLocalAwarenessTargetingViewController.f22778p.setVisibility(0);
        }
    }
}
