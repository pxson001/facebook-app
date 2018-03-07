package com.facebook.adinterfaces.ui;

import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CreativeChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.UrlVisibilityEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.UrlVisibilitySubscriber;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataValidation;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.HasWebsiteUrl;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.text.BetterEditTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Update Operation failed! */
public class AdInterfacesUrlViewController<D extends AdInterfacesBoostedComponentDataModel & HasWebsiteUrl> extends BaseAdInterfacesViewController<BetterEditTextView, D> {
    private final InputMethodManager f22985a;
    public final Runnable f22986b = new C26821(this);
    public BetterEditTextView f22987c;
    public String f22988d;
    public String f22989e;
    public AdInterfacesCardLayout f22990f;
    private TextWatcher f22991g;
    public String f22992h;
    public String f22993i;
    public D f22994j;
    public boolean f22995k;
    public AdInterfacesContext f22996l;

    /* compiled from: Update Operation failed! */
    class C26821 implements Runnable {
        final /* synthetic */ AdInterfacesUrlViewController f22981a;

        C26821(AdInterfacesUrlViewController adInterfacesUrlViewController) {
            this.f22981a = adInterfacesUrlViewController;
        }

        public void run() {
            this.f22981a.f22996l.m22429a(new CreativeChangedEvent());
        }
    }

    /* compiled from: Update Operation failed! */
    class C26832 implements TextWatcher {
        final /* synthetic */ AdInterfacesUrlViewController f22982a;

        C26832(AdInterfacesUrlViewController adInterfacesUrlViewController) {
            this.f22982a = adInterfacesUrlViewController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f22982a.f22988d = editable.toString();
            if (!this.f22982a.f22988d.equals(this.f22982a.f22989e)) {
                boolean z;
                Pair b = AdInterfacesUrlViewController.m24979b(this.f22982a.f22988d);
                WebsiteUrlState websiteUrlState = (WebsiteUrlState) b.first;
                String str = (String) b.second;
                if (websiteUrlState == WebsiteUrlState.VALID) {
                    if (this.f22982a.f22995k || this.f22982a.f22994j.mo962b() == ObjectiveType.PROMOTE_WEBSITE) {
                        this.f22982a.f22994j.mo951C().f21771d = str;
                        this.f22982a.f22994j.mo951C().f21775h = str;
                    }
                    ((HasWebsiteUrl) this.f22982a.f22994j).c_(str);
                    if (!this.f22982a.f22988d.equals(str)) {
                        editable.replace(0, editable.length(), str);
                    }
                    this.f22982a.f22987c.removeCallbacks(this.f22982a.f22986b);
                    this.f22982a.f22987c.postDelayed(this.f22982a.f22986b, 1000);
                }
                this.f22982a.f22989e = str;
                AdInterfacesUrlViewController adInterfacesUrlViewController = this.f22982a;
                switch (websiteUrlState) {
                    case FORMAT_ERROR:
                        adInterfacesUrlViewController.f22990f.setFooterSpannableText(Html.fromHtml(adInterfacesUrlViewController.f22992h));
                        break;
                    case FACEBOOK_URL_ERROR:
                        adInterfacesUrlViewController.f22990f.setFooterSpannableText(Html.fromHtml(adInterfacesUrlViewController.f22993i));
                        break;
                    case VALID:
                        adInterfacesUrlViewController.f22990f.setFooterText(null);
                        break;
                }
                AdInterfacesContext adInterfacesContext = this.f22982a.f22440b;
                AdInterfacesDataValidation adInterfacesDataValidation = AdInterfacesDataValidation.INVALID_URL;
                if (websiteUrlState == WebsiteUrlState.VALID) {
                    z = true;
                } else {
                    z = false;
                }
                adInterfacesContext.m22431a(adInterfacesDataValidation, z);
                this.f22982a.f22440b.m22429a(new CreativeChangedEvent());
            }
        }
    }

    /* compiled from: Update Operation failed! */
    class C26843 extends UrlVisibilitySubscriber {
        final /* synthetic */ AdInterfacesUrlViewController f22983a;

        C26843(AdInterfacesUrlViewController adInterfacesUrlViewController) {
            this.f22983a = adInterfacesUrlViewController;
        }

        public final void m24976b(FbEvent fbEvent) {
            AdInterfacesUrlViewController.m24978a(this.f22983a, ((UrlVisibilityEvent) fbEvent).f21680a);
        }
    }

    /* compiled from: Update Operation failed! */
    enum WebsiteUrlState {
        FORMAT_ERROR,
        FACEBOOK_URL_ERROR,
        VALID
    }

    public static AdInterfacesUrlViewController m24980b(InjectorLike injectorLike) {
        return new AdInterfacesUrlViewController(InputMethodManagerMethodAutoProvider.b(injectorLike));
    }

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        BetterEditTextView betterEditTextView = (BetterEditTextView) view;
        super.mo982a(betterEditTextView, adInterfacesCardLayout);
        this.f22990f = adInterfacesCardLayout;
        this.f22987c = betterEditTextView;
        this.f22996l = this.f22440b;
        this.f22992h = this.f22987c.getResources().getString(2131234065);
        this.f22993i = this.f22987c.getResources().getString(2131234066);
        if (!((HasWebsiteUrl) this.f22994j).mJ_()) {
            m24978a(this, false);
        }
        this.f22990f.setHeaderTitle(this.f22987c.getContext().getString(((HasWebsiteUrl) this.f22994j).mK_()));
        this.f22991g = new C26832(this);
        this.f22987c.addTextChangedListener(this.f22991g);
        this.f22987c.setInputType(524288);
        if (!StringUtil.a(this.f22988d)) {
            this.f22987c.setText(this.f22988d);
        }
        this.f22996l.m22430a(new C26843(this));
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel = (AdInterfacesBoostedComponentDataModel) baseAdInterfacesData;
        this.f22994j = adInterfacesBoostedComponentDataModel;
        this.f22988d = ((HasWebsiteUrl) adInterfacesBoostedComponentDataModel).mI_();
    }

    public static AdInterfacesUrlViewController m24977a(InjectorLike injectorLike) {
        return m24980b(injectorLike);
    }

    @Inject
    public AdInterfacesUrlViewController(InputMethodManager inputMethodManager) {
        this.f22985a = inputMethodManager;
    }

    public final void mo981a() {
        super.mo981a();
        this.f22987c.removeCallbacks(this.f22986b);
        this.f22996l = null;
        this.f22987c.removeTextChangedListener(this.f22991g);
        this.f22991g = null;
        this.f22987c = null;
        this.f22990f = null;
    }

    public static void m24978a(AdInterfacesUrlViewController adInterfacesUrlViewController, boolean z) {
        int i = 0;
        adInterfacesUrlViewController.f22995k = z;
        if (adInterfacesUrlViewController.f22439a) {
            AdInterfacesContext adInterfacesContext = adInterfacesUrlViewController.f22996l;
            AdInterfacesDataValidation adInterfacesDataValidation = AdInterfacesDataValidation.INVALID_URL;
            boolean z2 = !adInterfacesUrlViewController.f22995k || m24979b(adInterfacesUrlViewController.f22988d).first == WebsiteUrlState.VALID;
            adInterfacesContext.m22431a(adInterfacesDataValidation, z2);
            if (!z) {
                adInterfacesUrlViewController.f22985a.hideSoftInputFromWindow(adInterfacesUrlViewController.f22987c.getWindowToken(), 0);
            }
            AdInterfacesCardLayout adInterfacesCardLayout = adInterfacesUrlViewController.f22990f;
            if (!z) {
                i = 8;
            }
            adInterfacesCardLayout.setVisibility(i);
        }
    }

    public static Pair<WebsiteUrlState, String> m24979b(String str) {
        Object obj = WebsiteUrlState.VALID;
        if (!(str.startsWith("http://") || str.startsWith("https://"))) {
            str = "http://" + str;
        }
        if (!Patterns.WEB_URL.matcher(str).matches()) {
            obj = WebsiteUrlState.FORMAT_ERROR;
        }
        if (FacebookUriUtil.c(Uri.parse(str))) {
            obj = WebsiteUrlState.FACEBOOK_URL_ERROR;
        }
        return new Pair(obj, str);
    }

    public final void mo984a(Bundle bundle) {
        bundle.putString("website_url_key", this.f22988d);
    }

    public final void mo985b(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.f22987c.setText(bundle.getString("website_url_key"));
        }
    }
}
