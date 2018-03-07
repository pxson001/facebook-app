package com.facebook.adinterfaces.model.events;

import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Creative;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.EventSpec.EventBoostType;

/* compiled from: \' */
public class AdInterfacesBoostEventDataModel extends AdInterfacesBoostPostDataModel {
    public final String f21805a;
    public EventBoostType f21806b = EventBoostType.RSVP;

    /* compiled from: \' */
    public class Builder extends com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel.Builder {
        public String f21804a;

        public final /* synthetic */ BaseAdInterfacesData mo950a() {
            return m22894c();
        }

        public final /* synthetic */ AdInterfacesBoostPostDataModel mo961b() {
            return m22894c();
        }

        public final AdInterfacesBoostEventDataModel m22894c() {
            return new AdInterfacesBoostEventDataModel(this);
        }
    }

    public AdInterfacesBoostEventDataModel(Builder builder) {
        super((com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel.Builder) builder);
        this.f21805a = builder.f21804a;
    }

    public final ObjectiveType mo962b() {
        return ObjectiveType.BOOST_EVENT;
    }

    public final Creative mo958u() {
        return null;
    }

    public final CreativeAdModel mo951C() {
        return null;
    }
}
