package com.facebook.adinterfaces.ui;

import android.os.Bundle;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.events.AdInterfacesEvents.AudienceChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.AudienceChangedSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VIDEOAD */
public class AdInterfacesTargetingViewController<D extends AdInterfacesDataModel> extends AdInterfacesBaseTargetingViewController<AdInterfacesTargetingView, D> {
    protected AdInterfacesAudienceOptionsViewController f22586j;

    /* compiled from: VIDEOAD */
    class C26751 extends AudienceChangedSubscriber {
        final /* synthetic */ AdInterfacesTargetingViewController f22960a;

        C26751(AdInterfacesTargetingViewController adInterfacesTargetingViewController) {
            this.f22960a = adInterfacesTargetingViewController;
        }

        public final void m24926b(FbEvent fbEvent) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4 = true;
            GraphQLBoostedPostAudienceOption graphQLBoostedPostAudienceOption = ((AudienceChangedEvent) fbEvent).f21656a;
            if (this.f22960a.f22577a.f21754j.f21729i != null) {
                z = true;
            } else {
                z = false;
            }
            if (graphQLBoostedPostAudienceOption == GraphQLBoostedPostAudienceOption.NCPP) {
                z2 = true;
            } else {
                z2 = false;
            }
            AdInterfacesBaseTargetingViewController adInterfacesBaseTargetingViewController = this.f22960a;
            if (z || !r3) {
                z3 = false;
            } else {
                z3 = true;
            }
            adInterfacesBaseTargetingViewController.m24453d(z3);
            adInterfacesBaseTargetingViewController = this.f22960a;
            if (z || !r3) {
                z3 = false;
            } else {
                z3 = true;
            }
            adInterfacesBaseTargetingViewController.m24446a(z3);
            AdInterfacesBaseTargetingViewController adInterfacesBaseTargetingViewController2 = this.f22960a;
            if (z || !r3) {
                z2 = false;
            } else {
                z2 = true;
            }
            adInterfacesBaseTargetingViewController2.m24451c(z2);
            AdInterfacesBaseTargetingViewController adInterfacesBaseTargetingViewController3 = this.f22960a;
            if (z) {
                z4 = false;
            }
            adInterfacesBaseTargetingViewController3.mo993b(z4);
            this.f22960a.m24447b();
        }
    }

    private static AdInterfacesTargetingViewController m24460b(InjectorLike injectorLike) {
        return new AdInterfacesTargetingViewController(AdInterfacesAudienceOptionsViewController.m24419b(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike));
    }

    @Inject
    public AdInterfacesTargetingViewController(AdInterfacesAudienceOptionsViewController adInterfacesAudienceOptionsViewController, AdInterfacesDataHelper adInterfacesDataHelper) {
        super(adInterfacesDataHelper);
        this.f22586j = adInterfacesAudienceOptionsViewController;
    }

    public void mo988a(AdInterfacesContext adInterfacesContext) {
        super.mo988a(adInterfacesContext);
        this.f22586j.mo988a(adInterfacesContext);
    }

    public void mo983a(D d) {
        super.mo983a((BaseAdInterfacesData) d);
        this.f22586j.mo983a((BaseAdInterfacesData) d);
    }

    public void mo992a(AdInterfacesTargetingView adInterfacesTargetingView, AdInterfacesCardLayout adInterfacesCardLayout) {
        boolean z;
        super.mo990a((AdInterfacesBaseTargetingView) adInterfacesTargetingView, adInterfacesCardLayout);
        this.f22586j.m24426a(adInterfacesTargetingView.f22959b, adInterfacesCardLayout);
        m24443a(this.f22577a.f21754j);
        if (GraphQLBoostedPostAudienceOption.NCPP == this.f22577a.f21754j.f21728h) {
            z = true;
        } else {
            z = false;
        }
        m24446a(z);
        mo993b(true);
        m24451c(z);
        m24453d(z);
        mo991e();
        AdInterfacesBaseTargetingViewController.m24438a(adInterfacesCardLayout);
    }

    public static AdInterfacesTargetingViewController m24461c(InjectorLike injectorLike) {
        return m24460b(injectorLike);
    }

    protected final void mo991e() {
        this.f22440b.m22430a(new C26751(this));
        super.mo991e();
    }

    public void mo981a() {
        super.mo981a();
        this.f22586j.mo981a();
    }

    public void mo984a(Bundle bundle) {
        super.mo984a(bundle);
        this.f22586j.mo984a(bundle);
    }

    public void mo985b(@Nullable Bundle bundle) {
        if (bundle != null) {
            super.mo985b(bundle);
            this.f22586j.mo985b(bundle);
        }
    }
}
