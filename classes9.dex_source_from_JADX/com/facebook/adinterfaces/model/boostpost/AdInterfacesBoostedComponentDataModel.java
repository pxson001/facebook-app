package com.facebook.adinterfaces.model.boostpost;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.EventSpecModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountBasicFieldsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CampaignGroupResultsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Creative;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.EventSpec;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import javax.annotation.Nullable;

/* compiled from: \+ */
public class AdInterfacesBoostedComponentDataModel extends BaseAdInterfacesData implements HasAdCreative {
    public static final Creator<AdInterfacesBoostedComponentDataModel> CREATOR = new C25151();
    private CreativeAdModel f21796a;
    public BoostedComponentModel f21797b;
    @Nullable
    public EventSpecModel f21798c;
    @Nullable
    public String f21799d;
    @Nullable
    public String f21800e;
    @Nullable
    public GraphQLBoostedPostAudienceOption f21801f;
    public String f21802g;
    public GeoLocationModel f21803h;

    /* compiled from: \+ */
    final class C25151 implements Creator<AdInterfacesBoostedComponentDataModel> {
        C25151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AdInterfacesBoostedComponentDataModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new AdInterfacesBoostedComponentDataModel[i];
        }
    }

    /* compiled from: \+ */
    public class Builder extends com.facebook.adinterfaces.model.BaseAdInterfacesData.Builder {
        public CreativeAdModel f21788a;
        public BoostedComponentModel f21789b;
        @Nullable
        public EventSpecModel f21790c;
        @Nullable
        public String f21791d;
        @Nullable
        public String f21792e;
        @Nullable
        public GraphQLBoostedPostAudienceOption f21793f;
        public String f21794g;
        public GeoLocationModel f21795h;

        public Builder(BaseAdInterfacesData baseAdInterfacesData) {
            super(baseAdInterfacesData);
        }

        public BaseAdInterfacesData mo950a() {
            return new AdInterfacesBoostedComponentDataModel(this);
        }
    }

    public AdInterfacesBoostedComponentDataModel(Builder builder) {
        super((com.facebook.adinterfaces.model.BaseAdInterfacesData.Builder) builder);
        this.f21796a = builder.f21788a;
        this.f21797b = builder.f21789b;
        this.f21798c = builder.f21790c;
        this.f21799d = builder.f21791d;
        this.f21800e = builder.f21792e;
        this.f21801f = builder.f21793f;
        this.f21802g = builder.f21794g;
        this.f21803h = builder.f21795h;
    }

    public AdInterfacesBoostedComponentDataModel(Parcel parcel) {
        super(parcel);
        this.f21796a = (CreativeAdModel) parcel.readParcelable(CreativeAdModel.class.getClassLoader());
        this.f21797b = (BoostedComponentModel) FlatBufferModelHelper.a(parcel);
        this.f21798c = (EventSpecModel) parcel.readParcelable(EventSpec.class.getClassLoader());
        this.f21799d = parcel.readString();
        this.f21800e = parcel.readString();
        String readString = parcel.readString();
        this.f21801f = readString != null ? GraphQLBoostedPostAudienceOption.fromString(readString) : null;
        this.f21802g = parcel.readString();
        this.f21803h = (GeoLocationModel) FlatBufferModelHelper.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f21796a, i);
        FlatBufferModelHelper.a(parcel, this.f21797b);
        parcel.writeParcelable(this.f21798c, i);
        parcel.writeString(this.f21799d);
        parcel.writeString(this.f21800e);
        parcel.writeString(this.f21801f != null ? this.f21801f.name() : null);
        parcel.writeString(this.f21802g);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f21803h);
    }

    public final void mo952a(CreativeAdModel creativeAdModel) {
        this.f21796a = creativeAdModel;
    }

    @Nullable
    public final DefaultTextWithEntitiesLongFields mo954m() {
        return this.f21797b.m23352s();
    }

    public final FeedUnit mo959v() {
        Object obj;
        if (this.f21797b == null || this.f21797b.m23350q() == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return this.f21797b.m23350q();
        }
        return null;
    }

    public final BoostedComponentModel m22891z() {
        return this.f21797b;
    }

    @Nullable
    public final CampaignGroupResultsModel mo955p() {
        Object obj = (this.f21797b == null || this.f21797b.m23347n() == null) ? null : 1;
        return obj != null ? this.f21797b.m23347n() : null;
    }

    @Nullable
    public final AdAccountBasicFieldsModel mo956q() {
        Object obj = (this.f21797b == null || this.f21797b.m23340a() == null) ? null : 1;
        return obj != null ? this.f21797b.m23340a() : null;
    }

    public final boolean mo957r() {
        return true;
    }

    public final Creative mo958u() {
        return mo951C() == null ? null : mo951C().m22866h();
    }

    public final CreativeAdModel mo951C() {
        return this.f21796a;
    }
}
