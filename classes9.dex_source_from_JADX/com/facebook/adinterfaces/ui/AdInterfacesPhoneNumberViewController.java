package com.facebook.adinterfaces.ui;

import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.CallToActionWrapper;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CallToActionChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CallToActionSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorDialogEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.LocationTargetingChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.LocationTargetingChangedSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesDataValidation;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.localawareness.AdInterfacesLocalAwarenessDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesGeocoder;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.phonenumbers.PhoneNumberUtilMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.inject.InjectorLike;
import com.facebook.maps.Locations;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.phonenumbers.Phonenumber.PhoneNumber;
import com.facebook.widget.text.BetterEditTextView;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Using APN [MMSC= */
public class AdInterfacesPhoneNumberViewController extends BaseAdInterfacesViewController<AdInterfacesPhoneNumberView, AdInterfacesLocalAwarenessDataModel> {
    public final Runnable f22858a = new C26581(this);
    private String f22859b;
    private AdInterfacesCardLayout f22860c;
    private AdInterfacesLocalAwarenessDataModel f22861d;
    public PhoneNumberUtil f22862e;
    private InputMethodManager f22863f;
    private AdInterfacesGeocoder f22864g;
    private Resources f22865h;
    public BetterEditTextView f22866i;
    public AdInterfacesContext f22867j;
    public boolean f22868k;
    public int f22869l = -1;
    public AdInterfacesPhoneNumberView f22870m;
    private String f22871n;
    private boolean f22872o;
    private Spanned f22873p;
    private CreativeAdModel f22874q;

    /* compiled from: Using APN [MMSC= */
    class C26581 implements Runnable {
        final /* synthetic */ AdInterfacesPhoneNumberViewController f22853a;

        C26581(AdInterfacesPhoneNumberViewController adInterfacesPhoneNumberViewController) {
            this.f22853a = adInterfacesPhoneNumberViewController;
        }

        public void run() {
            if (this.f22853a.f22439a) {
                this.f22853a.m24840b();
            }
        }
    }

    /* compiled from: Using APN [MMSC= */
    class C26592 extends CallToActionSubscriber {
        final /* synthetic */ AdInterfacesPhoneNumberViewController f22854a;

        C26592(AdInterfacesPhoneNumberViewController adInterfacesPhoneNumberViewController) {
            this.f22854a = adInterfacesPhoneNumberViewController;
        }

        public final void m24816b(FbEvent fbEvent) {
            boolean z;
            CallToActionChangedEvent callToActionChangedEvent = (CallToActionChangedEvent) fbEvent;
            AdInterfacesPhoneNumberViewController adInterfacesPhoneNumberViewController = this.f22854a;
            if (callToActionChangedEvent.f21657a == GraphQLCallToActionType.CALL_NOW) {
                z = true;
            } else {
                z = false;
            }
            adInterfacesPhoneNumberViewController.m24827a(z);
        }
    }

    /* compiled from: Using APN [MMSC= */
    class C26603 extends LocationTargetingChangedSubscriber {
        final /* synthetic */ AdInterfacesPhoneNumberViewController f22855a;

        C26603(AdInterfacesPhoneNumberViewController adInterfacesPhoneNumberViewController) {
            this.f22855a = adInterfacesPhoneNumberViewController;
        }

        public final void m24817b(FbEvent fbEvent) {
            this.f22855a.m24823a(((LocationTargetingChangedEvent) fbEvent).f21672a);
        }
    }

    /* compiled from: Using APN [MMSC= */
    public class C26614 {
        final /* synthetic */ AdInterfacesPhoneNumberViewController f22856a;

        C26614(AdInterfacesPhoneNumberViewController adInterfacesPhoneNumberViewController) {
            this.f22856a = adInterfacesPhoneNumberViewController;
        }

        public final void m24819a(String str) {
            this.f22856a.f22869l = this.f22856a.f22862e.getCountryCodeForRegion(str);
            this.f22856a.f22870m.setCountryCode(String.valueOf(this.f22856a.f22869l));
            this.f22856a.f22870m.postDelayed(this.f22856a.f22858a, 1000);
        }

        public final void m24818a() {
            if (this.f22856a.f22868k) {
                this.f22856a.f22867j.m22429a(new ErrorDialogEvent());
            }
        }
    }

    /* compiled from: Using APN [MMSC= */
    class C26625 implements TextWatcher {
        final /* synthetic */ AdInterfacesPhoneNumberViewController f22857a;

        C26625(AdInterfacesPhoneNumberViewController adInterfacesPhoneNumberViewController) {
            this.f22857a = adInterfacesPhoneNumberViewController;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f22857a.f22867j.m22431a(AdInterfacesDataValidation.PHONE_NUMBER, false);
        }

        public void afterTextChanged(Editable editable) {
            this.f22857a.f22866i.removeCallbacks(this.f22857a.f22858a);
            this.f22857a.f22866i.postDelayed(this.f22857a.f22858a, 2000);
        }
    }

    public static AdInterfacesPhoneNumberViewController m24829b(InjectorLike injectorLike) {
        return new AdInterfacesPhoneNumberViewController(PhoneNumberUtilMethodAutoProvider.a(injectorLike), InputMethodManagerMethodAutoProvider.b(injectorLike), AdInterfacesGeocoder.m23047b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        AdInterfacesPhoneNumberView adInterfacesPhoneNumberView = (AdInterfacesPhoneNumberView) view;
        boolean z = false;
        super.mo982a(adInterfacesPhoneNumberView, adInterfacesCardLayout);
        this.f22860c = adInterfacesCardLayout;
        this.f22870m = adInterfacesPhoneNumberView;
        this.f22866i = adInterfacesPhoneNumberView.getPhoneNumberEditView();
        this.f22867j = m24311l();
        this.f22867j.m22430a(new C26592(this));
        this.f22867j.m22430a(new C26603(this));
        if (this.f22861d.mo951C() != null) {
            if (this.f22861d.mo951C().m22864e() == GraphQLCallToActionType.CALL_NOW) {
                z = true;
            }
            m24827a(z);
        }
        if (this.f22859b != null) {
            m24826a(this.f22859b);
        }
        try {
            GeoLocationModel geoLocationModel = (GeoLocationModel) this.f22861d.m22854j().m22840f().get(0);
            m24823a(Locations.a(geoLocationModel.m23442g(), geoLocationModel.mN_()));
        } catch (Exception e) {
        }
        m24831c();
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22861d = (AdInterfacesLocalAwarenessDataModel) baseAdInterfacesData;
        this.f22859b = this.f22861d.f21809c;
        this.f22874q = this.f22861d.mo951C();
        this.f22873p = Html.fromHtml(this.f22865h.getString(2131234064));
    }

    public static AdInterfacesPhoneNumberViewController m24821a(InjectorLike injectorLike) {
        return m24829b(injectorLike);
    }

    @Inject
    public AdInterfacesPhoneNumberViewController(PhoneNumberUtil phoneNumberUtil, InputMethodManager inputMethodManager, AdInterfacesGeocoder adInterfacesGeocoder, Resources resources) {
        this.f22862e = phoneNumberUtil;
        this.f22863f = inputMethodManager;
        this.f22864g = adInterfacesGeocoder;
        this.f22865h = resources;
    }

    private void m24826a(String str) {
        boolean z = false;
        try {
            this.f22861d.m22899i(str);
            if (this.f22868k) {
                this.f22874q.m22865f(CallToActionWrapper.CALL_NOW_WRAPPER.getUri(this.f22861d));
            }
            PhoneNumber parseAndKeepRawInput = this.f22862e.parseAndKeepRawInput(str, null);
            this.f22872o = this.f22862e.isValidNumber(parseAndKeepRawInput);
            this.f22871n = String.valueOf(parseAndKeepRawInput.getNationalNumber());
            this.f22869l = parseAndKeepRawInput.getCountryCode();
        } catch (Exception e) {
            this.f22872o = false;
        } finally {
            AdInterfacesContext adInterfacesContext = this.f22867j;
            AdInterfacesDataValidation adInterfacesDataValidation = AdInterfacesDataValidation.PHONE_NUMBER;
            if (!this.f22868k || this.f22872o) {
                z = true;
            }
            adInterfacesContext.m22431a(adInterfacesDataValidation, z);
        }
        this.f22860c.setFooterSpannableText(this.f22872o ? null : this.f22873p);
    }

    private void m24823a(Location location) {
        this.f22867j.m22431a(AdInterfacesDataValidation.PHONE_NUMBER, !this.f22868k);
        this.f22864g.m23049a(location.getLatitude(), location.getLongitude(), new C26614(this));
    }

    private void m24827a(boolean z) {
        int i = 0;
        this.f22868k = z;
        AdInterfacesContext adInterfacesContext = this.f22867j;
        AdInterfacesDataValidation adInterfacesDataValidation = AdInterfacesDataValidation.PHONE_NUMBER;
        boolean z2 = !this.f22868k || this.f22872o;
        adInterfacesContext.m22431a(adInterfacesDataValidation, z2);
        if (this.f22439a) {
            if (!z) {
                this.f22863f.hideSoftInputFromWindow(this.f22866i.getWindowToken(), 0);
            }
            AdInterfacesCardLayout adInterfacesCardLayout = this.f22860c;
            if (!z) {
                i = 8;
            }
            adInterfacesCardLayout.setVisibility(i);
        }
    }

    private void m24831c() {
        this.f22866i.setText(this.f22871n);
        this.f22870m.setCountryCode(String.valueOf(this.f22869l));
        this.f22866i.addTextChangedListener(new C26625(this));
    }

    public final void mo981a() {
        super.mo981a();
        this.f22864g.m23048a();
        this.f22866i.removeCallbacks(this.f22858a);
        this.f22866i = null;
        this.f22863f = null;
        this.f22870m = null;
        this.f22860c = null;
        this.f22867j = null;
    }

    @VisibleForTesting
    public final void m24840b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+").append(this.f22869l).append(this.f22866i.getText());
        m24826a(stringBuilder.toString());
    }

    public final void mo984a(Bundle bundle) {
        bundle.putString("phone_number_key", this.f22871n);
        bundle.putInt("country_code_key", this.f22869l);
    }

    public final void mo985b(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.f22871n = bundle.getString("phone_number_key");
            this.f22869l = bundle.getInt("country_code_key");
            this.f22866i.setText(this.f22871n);
        }
    }
}
