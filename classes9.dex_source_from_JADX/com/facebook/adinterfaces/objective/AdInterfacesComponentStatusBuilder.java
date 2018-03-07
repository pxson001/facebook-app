package com.facebook.adinterfaces.objective;

import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: [applinks]possible_applinks_url */
public class AdInterfacesComponentStatusBuilder {
    public ImmutableList<AdInterfacesStatus> f21828a = RegularImmutableList.a;
    public boolean f21829b = true;

    /* compiled from: [applinks]possible_applinks_url */
    class ComponentStatus implements AdInterfacesComponentStatus {
        final /* synthetic */ AdInterfacesComponentStatusBuilder f21825a;
        private final ImmutableList<AdInterfacesStatus> f21826b;
        private final boolean f21827c;

        ComponentStatus(AdInterfacesComponentStatusBuilder adInterfacesComponentStatusBuilder, AdInterfacesComponentStatusBuilder adInterfacesComponentStatusBuilder2) {
            this.f21825a = adInterfacesComponentStatusBuilder;
            this.f21826b = adInterfacesComponentStatusBuilder2.f21828a;
            this.f21827c = adInterfacesComponentStatusBuilder2.f21829b;
        }

        public final boolean mo967a(BaseAdInterfacesData baseAdInterfacesData) {
            if (this.f21827c && !AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
                return false;
            }
            return this.f21826b.contains(baseAdInterfacesData.f21748d);
        }
    }

    private AdInterfacesComponentStatusBuilder() {
    }

    public static AdInterfacesComponentStatusBuilder newBuilder() {
        return new AdInterfacesComponentStatusBuilder();
    }

    public final AdInterfacesComponentStatus m22909a() {
        return new ComponentStatus(this, this);
    }
}
