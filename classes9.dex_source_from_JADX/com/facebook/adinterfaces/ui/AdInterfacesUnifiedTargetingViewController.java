package com.facebook.adinterfaces.ui;

import android.os.Bundle;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ServerValidationRequestEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.TargetingChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.UnifiedAudienceChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.UnifiedAudienceChangedSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesTargetingData;
import com.facebook.adinterfaces.model.AdInterfacesTargetingData.Builder;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetSpecificationsModel;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: V2_ACTIVE_NOW_LOADING */
public class AdInterfacesUnifiedTargetingViewController<D extends AdInterfacesDataModel> extends AdInterfacesBaseTargetingViewController<AdInterfacesUnifiedTargetingView, D> {
    protected AdInterfacesUnifiedAudienceOptionsViewController f22849j;
    protected AdInterfacesDataHelper f22850k;

    /* compiled from: V2_ACTIVE_NOW_LOADING */
    class C26811 extends UnifiedAudienceChangedSubscriber {
        final /* synthetic */ AdInterfacesUnifiedTargetingViewController f22980a;

        C26811(AdInterfacesUnifiedTargetingViewController adInterfacesUnifiedTargetingViewController) {
            this.f22980a = adInterfacesUnifiedTargetingViewController;
        }

        public final void m24975b(FbEvent fbEvent) {
            boolean z = true;
            BoostedComponentAudienceModel boostedComponentAudienceModel = ((UnifiedAudienceChangedEvent) fbEvent).f21679a;
            boolean z2 = boostedComponentAudienceModel.m23232j() != null;
            if (boostedComponentAudienceModel.m23230a() != GraphQLBoostedPostAudienceOption.NCPP) {
                z = false;
            }
            this.f22980a.m24797a(z2, z);
            if (this.f22980a.f22577a instanceof AdInterfacesBoostedComponentDataModel) {
                ((AdInterfacesBoostedComponentDataModel) this.f22980a.f22577a).f21800e = boostedComponentAudienceModel.m23232j();
                ((AdInterfacesBoostedComponentDataModel) this.f22980a.f22577a).f21801f = boostedComponentAudienceModel.m23230a();
            }
            TargetSpecificationsModel m = boostedComponentAudienceModel.m23235m();
            if (boostedComponentAudienceModel.m23232j() != null && m != null) {
                BaseAdInterfacesData baseAdInterfacesData = this.f22980a.f22577a;
                Builder builder = new Builder();
                builder.f21718f = boostedComponentAudienceModel.m23230a();
                builder = builder;
                builder.f21720h = boostedComponentAudienceModel.m23232j();
                builder = builder;
                builder.f21714b = m.m23734m();
                builder = builder;
                builder.f21715c = m.m23733l();
                builder = builder;
                AdInterfacesDataHelper adInterfacesDataHelper = this.f22980a.f22850k;
                builder.f21713a = AdInterfacesDataHelper.m22793a(m.m23729a());
                builder = builder;
                adInterfacesDataHelper = this.f22980a.f22850k;
                builder.f21717e = AdInterfacesDataHelper.m22796a(m.m23732k());
                builder = builder;
                adInterfacesDataHelper = this.f22980a.f22850k;
                builder.f21716d = AdInterfacesDataHelper.m22795a(m.m23731j());
                baseAdInterfacesData.f21754j = builder.m22830a();
            } else if (z) {
                this.f22980a.f22577a.f21754j.m22839a(boostedComponentAudienceModel.m23232j(), boostedComponentAudienceModel.m23230a());
                this.f22980a.f22577a.f21754j = this.f22980a.mo1012c();
            }
            this.f22980a.f22440b.m22429a(new TargetingChangedEvent(this.f22980a.f22577a.f21754j));
            this.f22980a.f22440b.m22429a(new ServerValidationRequestEvent());
            this.f22980a.m24452d();
        }
    }

    private static AdInterfacesUnifiedTargetingViewController m24798b(InjectorLike injectorLike) {
        return new AdInterfacesUnifiedTargetingViewController(AdInterfacesUnifiedAudienceOptionsViewController.m24949b(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike));
    }

    @Inject
    public AdInterfacesUnifiedTargetingViewController(AdInterfacesUnifiedAudienceOptionsViewController adInterfacesUnifiedAudienceOptionsViewController, AdInterfacesDataHelper adInterfacesDataHelper) {
        super(adInterfacesDataHelper);
        this.f22849j = adInterfacesUnifiedAudienceOptionsViewController;
        this.f22850k = adInterfacesDataHelper;
    }

    public final void mo988a(AdInterfacesContext adInterfacesContext) {
        super.mo988a(adInterfacesContext);
        this.f22849j.mo988a(adInterfacesContext);
    }

    public void mo983a(D d) {
        super.mo983a((BaseAdInterfacesData) d);
        this.f22849j.mo983a((BaseAdInterfacesData) d);
    }

    public static AdInterfacesUnifiedTargetingViewController m24799c(InjectorLike injectorLike) {
        return m24798b(injectorLike);
    }

    public void mo1013a(AdInterfacesUnifiedTargetingView adInterfacesUnifiedTargetingView, AdInterfacesCardLayout adInterfacesCardLayout) {
        boolean z;
        boolean z2 = true;
        super.mo990a((AdInterfacesBaseTargetingView) adInterfacesUnifiedTargetingView, adInterfacesCardLayout);
        this.f22849j.m24972a(adInterfacesUnifiedTargetingView.f22979b, adInterfacesCardLayout);
        if (GraphQLBoostedPostAudienceOption.NCPP == this.f22577a.f21754j.f21728h) {
            z = true;
        } else {
            z = false;
        }
        if (AdInterfacesDataHelper.m22814j(this.f22577a) && z) {
            m24443a(this.f22577a.f21754j);
        } else {
            AdInterfacesTargetingData adInterfacesTargetingData = this.f22577a.f21754j;
            m24443a(this.f22850k.m22828n(this.f22577a));
            this.f22577a.f21754j = adInterfacesTargetingData;
        }
        if (this.f22577a.f21754j.f21729i == null) {
            z2 = false;
        }
        m24797a(z2, z);
        mo991e();
    }

    protected final void mo991e() {
        this.f22440b.m22430a(new C26811(this));
        super.mo991e();
    }

    private void m24797a(boolean z, boolean z2) {
        boolean z3;
        boolean z4 = true;
        if (z || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        m24453d(z3);
        if (z || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        m24446a(z3);
        if (z || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        m24451c(z3);
        if (z) {
            z4 = false;
        }
        mo993b(z4);
    }

    public final void mo981a() {
        super.mo981a();
        this.f22849j.mo981a();
    }

    public final void mo984a(Bundle bundle) {
        super.mo984a(bundle);
        this.f22849j.mo984a(bundle);
    }

    public final void mo985b(@Nullable Bundle bundle) {
        if (bundle != null) {
            super.mo985b(bundle);
            this.f22849j.mo985b(bundle);
        }
    }
}
