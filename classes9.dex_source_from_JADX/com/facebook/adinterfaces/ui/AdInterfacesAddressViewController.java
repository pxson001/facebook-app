package com.facebook.adinterfaces.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.CallToActionWrapper;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CallToActionChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CallToActionSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesDataValidation;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.localawareness.AdInterfacesLocalAwarenessDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesGeocoder;
import com.facebook.adinterfaces.protocol.AdInterfacesGeocoder.GeocodeCallbacks;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel.Builder;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VIEW_FULL_HISTORY */
public class AdInterfacesAddressViewController extends BaseAdInterfacesViewController<AdInterfacesAddressEditView, AdInterfacesLocalAwarenessDataModel> {
    public final StaticMapOptions f22520a = new StaticMapOptions("ad_interfaces_get_direction_preview");
    public final AdInterfacesErrorReporter f22521b;
    public AdInterfacesLocalAwarenessDataModel f22522c;
    private GeoLocationModel f22523d;
    public String f22524e;
    private Resources f22525f;
    public AdInterfacesGeocoder f22526g;
    private InputMethodManager f22527h;
    public AdInterfacesContext f22528i;
    public AdInterfacesAddressEditView f22529j;
    public AdInterfacesCardLayout f22530k;
    public boolean f22531l;
    public boolean f22532m;
    public CreativeAdModel f22533n;
    private Spanned f22534o;
    public final Runnable f22535p = new C25771(this);

    /* compiled from: VIEW_FULL_HISTORY */
    class C25771 implements Runnable {
        final /* synthetic */ AdInterfacesAddressViewController f22517a;

        /* compiled from: VIEW_FULL_HISTORY */
        class C25761 implements GeocodeCallbacks {
            final /* synthetic */ C25771 f22516a;

            C25761(C25771 c25771) {
                this.f22516a = c25771;
            }

            public final void mo986a(double d, double d2) {
                AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel = this.f22516a.f22517a.f22522c;
                Builder builder = new Builder();
                builder.f22137f = d;
                builder = builder;
                builder.f22139h = d2;
                builder = builder;
                builder.f22132a = this.f22516a.f22517a.f22524e;
                adInterfacesLocalAwarenessDataModel.f21807a = builder.m23431a();
                if (this.f22516a.f22517a.f22531l) {
                    this.f22516a.f22517a.f22533n.f21775h = CallToActionWrapper.GET_DIRECTIONS_WRAPPER.getUri(this.f22516a.f22517a.f22522c);
                }
                this.f22516a.f22517a.f22530k.m24586a(false);
                this.f22516a.f22517a.f22532m = true;
                this.f22516a.f22517a.f22529j.setMapEnabled(true);
                this.f22516a.f22517a.f22529j.setMapOptions(this.f22516a.f22517a.f22520a.a().a(d, d2).a(13));
                this.f22516a.f22517a.f22530k.setFooterSpannableText(null);
                this.f22516a.f22517a.f22528i.m22431a(AdInterfacesDataValidation.ADDRESS, true);
            }

            public final void mo987a(Throwable th) {
                boolean z = false;
                this.f22516a.f22517a.f22521b.m22727a(AdInterfacesGeocoder.class.getClass(), "GraphQL error", th);
                this.f22516a.f22517a.f22532m = false;
                this.f22516a.f22517a.f22530k.m24586a(false);
                this.f22516a.f22517a.f22530k.setFooterSpannableText(this.f22516a.f22517a.m24392b());
                AdInterfacesContext adInterfacesContext = this.f22516a.f22517a.f22528i;
                AdInterfacesDataValidation adInterfacesDataValidation = AdInterfacesDataValidation.ADDRESS;
                if (!this.f22516a.f22517a.f22531l) {
                    z = true;
                }
                adInterfacesContext.m22431a(adInterfacesDataValidation, z);
            }
        }

        C25771(AdInterfacesAddressViewController adInterfacesAddressViewController) {
            this.f22517a = adInterfacesAddressViewController;
        }

        public void run() {
            this.f22517a.f22526g.m23050a(this.f22517a.f22524e, new C25761(this));
        }
    }

    /* compiled from: VIEW_FULL_HISTORY */
    class C25782 extends CallToActionSubscriber {
        final /* synthetic */ AdInterfacesAddressViewController f22518a;

        C25782(AdInterfacesAddressViewController adInterfacesAddressViewController) {
            this.f22518a = adInterfacesAddressViewController;
        }

        public final void m24385b(FbEvent fbEvent) {
            boolean z;
            CallToActionChangedEvent callToActionChangedEvent = (CallToActionChangedEvent) fbEvent;
            AdInterfacesAddressViewController adInterfacesAddressViewController = this.f22518a;
            if (callToActionChangedEvent.f21657a == GraphQLCallToActionType.GET_DIRECTIONS) {
                z = true;
            } else {
                z = false;
            }
            AdInterfacesAddressViewController.m24386a(adInterfacesAddressViewController, z);
        }
    }

    /* compiled from: VIEW_FULL_HISTORY */
    class C25793 implements TextWatcher {
        final /* synthetic */ AdInterfacesAddressViewController f22519a;

        C25793(AdInterfacesAddressViewController adInterfacesAddressViewController) {
            this.f22519a = adInterfacesAddressViewController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f22519a.f22530k.m24586a(true);
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f22519a.f22528i.m22431a(AdInterfacesDataValidation.ADDRESS, false);
            this.f22519a.f22529j.removeCallbacks(this.f22519a.f22535p);
            this.f22519a.f22529j.postDelayed(this.f22519a.f22535p, 2000);
        }

        public void afterTextChanged(Editable editable) {
            this.f22519a.f22524e = editable.toString();
        }
    }

    public static AdInterfacesAddressViewController m24387b(InjectorLike injectorLike) {
        return new AdInterfacesAddressViewController(AdInterfacesErrorReporter.m22724a(injectorLike), AdInterfacesGeocoder.m23047b(injectorLike), InputMethodManagerMethodAutoProvider.b(injectorLike));
    }

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        boolean z;
        AdInterfacesAddressEditView adInterfacesAddressEditView = (AdInterfacesAddressEditView) view;
        boolean z2 = false;
        super.mo982a(adInterfacesAddressEditView, adInterfacesCardLayout);
        AdInterfacesUiUtil.m25237a((ViewGroup) adInterfacesCardLayout, 1);
        this.f22528i = this.f22440b;
        this.f22529j = adInterfacesAddressEditView;
        this.f22525f = adInterfacesAddressEditView.getResources();
        this.f22530k = adInterfacesCardLayout;
        this.f22528i.m22430a(new C25782(this));
        if (this.f22533n.f21774g == GraphQLCallToActionType.GET_DIRECTIONS) {
            z = true;
        } else {
            z = false;
        }
        m24386a(this, z);
        if (this.f22523d != null) {
            this.f22532m = true;
            adInterfacesAddressEditView.setAddressString(this.f22523d.m23437a());
            adInterfacesAddressEditView.setMapOptions(this.f22520a.a().a(this.f22523d.m23442g(), this.f22523d.mN_()).a(13));
            this.f22530k.setFooterSpannableText(null);
        } else {
            this.f22532m = false;
            adInterfacesAddressEditView.setMapEnabled(false);
            this.f22530k.setFooterSpannableText(m24392b());
        }
        AdInterfacesContext adInterfacesContext = this.f22528i;
        AdInterfacesDataValidation adInterfacesDataValidation = AdInterfacesDataValidation.ADDRESS;
        if (!this.f22531l || this.f22532m) {
            z2 = true;
        }
        adInterfacesContext.m22431a(adInterfacesDataValidation, z2);
        adInterfacesAddressEditView.setOnAddressChangeListener(new C25793(this));
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        GeoLocationModel geoLocationModel;
        this.f22522c = (AdInterfacesLocalAwarenessDataModel) baseAdInterfacesData;
        if (this.f22522c.f21807a != null) {
            geoLocationModel = this.f22522c.f21807a;
        } else {
            geoLocationModel = this.f22522c.f21803h;
        }
        this.f22523d = geoLocationModel;
        this.f22533n = this.f22522c.mo951C();
    }

    @Inject
    public AdInterfacesAddressViewController(AdInterfacesErrorReporter adInterfacesErrorReporter, AdInterfacesGeocoder adInterfacesGeocoder, InputMethodManager inputMethodManager) {
        this.f22521b = adInterfacesErrorReporter;
        this.f22526g = adInterfacesGeocoder;
        this.f22527h = inputMethodManager;
    }

    public final void mo981a() {
        super.mo981a();
        this.f22526g.m23048a();
        this.f22529j.removeCallbacks(this.f22535p);
        this.f22530k = null;
        this.f22529j = null;
        this.f22534o = null;
        this.f22528i = null;
        this.f22525f = null;
        this.f22527h = null;
    }

    public static void m24386a(AdInterfacesAddressViewController adInterfacesAddressViewController, boolean z) {
        int i = 0;
        adInterfacesAddressViewController.f22531l = z;
        AdInterfacesContext adInterfacesContext = adInterfacesAddressViewController.f22528i;
        AdInterfacesDataValidation adInterfacesDataValidation = AdInterfacesDataValidation.ADDRESS;
        boolean z2 = !adInterfacesAddressViewController.f22531l || adInterfacesAddressViewController.f22532m;
        adInterfacesContext.m22431a(adInterfacesDataValidation, z2);
        if (adInterfacesAddressViewController.f22439a) {
            if (!z) {
                adInterfacesAddressViewController.f22527h.hideSoftInputFromWindow(adInterfacesAddressViewController.f22529j.getEditTextToken(), 0);
            }
            AdInterfacesCardLayout adInterfacesCardLayout = adInterfacesAddressViewController.f22530k;
            if (!z) {
                i = 8;
            }
            adInterfacesCardLayout.setVisibility(i);
        }
    }

    public final Spanned m24392b() {
        if (this.f22534o == null) {
            this.f22534o = Html.fromHtml(this.f22525f.getString(2131234097));
        }
        return this.f22534o;
    }

    public final void mo985b(@Nullable Bundle bundle) {
        super.mo985b(bundle);
        if (bundle != null) {
            this.f22524e = bundle.getString("address_extra");
            if (this.f22524e != null && this.f22439a) {
                this.f22529j.setAddressString(this.f22524e);
                this.f22529j.post(this.f22535p);
            }
        }
    }

    public final void mo984a(Bundle bundle) {
        super.mo984a(bundle);
        bundle.putString("address_extra", this.f22524e);
    }
}
