package com.facebook.adinterfaces.model.boostpost;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.protocol.AdInterfacesConstants.CampaignStatus;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountBasicFieldsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CampaignGroupResultsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel;
import com.facebook.common.util.StringUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Creative;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import javax.annotation.Nullable;

/* compiled from: \? */
public class AdInterfacesBoostPostDataModel extends BaseAdInterfacesData implements HasAdCreative {
    public static final Creator<AdInterfacesBoostPostDataModel> CREATOR = new C25141();
    public StoryPromotionModel f21780a;
    public String f21781b = "";
    public String f21782c = "";
    public CampaignStatus f21783d;
    public String f21784e;
    private boolean f21785f = false;
    public Intent f21786g;
    public int f21787h = 0;

    /* compiled from: \? */
    final class C25141 implements Creator<AdInterfacesBoostPostDataModel> {
        C25141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AdInterfacesBoostPostDataModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new AdInterfacesBoostPostDataModel[i];
        }
    }

    /* compiled from: \? */
    public class Builder extends com.facebook.adinterfaces.model.BaseAdInterfacesData.Builder<AdInterfacesBoostPostDataModel> {
        public /* synthetic */ BaseAdInterfacesData mo950a() {
            return mo961b();
        }

        public AdInterfacesBoostPostDataModel mo961b() {
            return new AdInterfacesBoostPostDataModel(this);
        }
    }

    public AdInterfacesBoostPostDataModel(Builder builder) {
        super((com.facebook.adinterfaces.model.BaseAdInterfacesData.Builder) builder);
    }

    public AdInterfacesBoostPostDataModel(Parcel parcel) {
        super(parcel);
        this.f21780a = (StoryPromotionModel) FlatBufferModelHelper.a(parcel);
        this.f21781b = parcel.readString();
        this.f21782c = parcel.readString();
        this.f21786g = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        FlatBufferModelHelper.a(parcel, this.f21780a);
        parcel.writeString(this.f21781b);
        parcel.writeString(this.f21782c);
        parcel.writeParcelable(this.f21786g, i);
    }

    public int describeContents() {
        return 0;
    }

    public final DefaultTextWithEntitiesLongFields mo954m() {
        return this.f21780a.m23713l().m23675r();
    }

    public final FeedUnit mo959v() {
        Object obj;
        if (this.f21780a == null || this.f21780a.m23713l() == null || this.f21780a.m23713l().m23670m() == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return null;
        }
        return this.f21780a.m23713l().m23670m();
    }

    public final StoryPromotionModel m22880w() {
        return this.f21780a;
    }

    public final String m22881z() {
        return this.f21782c;
    }

    @Nullable
    public CreativeAdModel mo951C() {
        return null;
    }

    public final void mo952a(CreativeAdModel creativeAdModel) {
    }

    public final void m22873a(AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        if (adInterfacesBoostPostDataModel.f21745a != null) {
            this.f21745a = adInterfacesBoostPostDataModel.f21745a;
        }
        if (adInterfacesBoostPostDataModel.mo962b() != null) {
            this.f21746b = adInterfacesBoostPostDataModel.mo962b();
        }
        if (!(adInterfacesBoostPostDataModel.f21747c == null || "".equals(adInterfacesBoostPostDataModel.f21747c))) {
            this.f21747c = adInterfacesBoostPostDataModel.f21747c;
        }
        if (!(adInterfacesBoostPostDataModel.m22853i() == null || "".equals(adInterfacesBoostPostDataModel.m22853i()))) {
            this.f21749e = adInterfacesBoostPostDataModel.m22853i();
        }
        if (adInterfacesBoostPostDataModel.f21748d != null) {
            this.f21748d = adInterfacesBoostPostDataModel.f21748d;
        }
        if (adInterfacesBoostPostDataModel.f21750f != null) {
            this.f21750f = adInterfacesBoostPostDataModel.f21750f;
        }
        if (adInterfacesBoostPostDataModel.f21751g != null) {
            this.f21751g = adInterfacesBoostPostDataModel.f21751g;
        }
        if (adInterfacesBoostPostDataModel.f21752h != null) {
            this.f21752h = adInterfacesBoostPostDataModel.f21752h;
        }
        if (adInterfacesBoostPostDataModel.f21753i >= 0) {
            this.f21753i = adInterfacesBoostPostDataModel.f21753i;
        }
        if (adInterfacesBoostPostDataModel.f21755k != null) {
            this.f21755k = adInterfacesBoostPostDataModel.f21755k;
        }
        if (adInterfacesBoostPostDataModel.f21756l != null) {
            this.f21756l = adInterfacesBoostPostDataModel.f21756l;
        }
        if (adInterfacesBoostPostDataModel.f21754j != null) {
            this.f21754j = adInterfacesBoostPostDataModel.f21754j;
        }
        if (adInterfacesBoostPostDataModel.f21757m != null) {
            this.f21757m = adInterfacesBoostPostDataModel.f21757m;
        }
        if (adInterfacesBoostPostDataModel.f21758n != null) {
            this.f21758n = adInterfacesBoostPostDataModel.f21758n;
        }
        if (adInterfacesBoostPostDataModel.f21759o >= 0) {
            this.f21759o = adInterfacesBoostPostDataModel.f21759o;
        }
        if (adInterfacesBoostPostDataModel.f21784e != null) {
            this.f21784e = adInterfacesBoostPostDataModel.f21784e;
        }
        if (adInterfacesBoostPostDataModel.f21780a != null) {
            this.f21780a = adInterfacesBoostPostDataModel.f21780a;
        }
        if (!StringUtil.a(adInterfacesBoostPostDataModel.f21781b)) {
            this.f21781b = adInterfacesBoostPostDataModel.f21781b;
        }
        if (!StringUtil.a(adInterfacesBoostPostDataModel.f21782c)) {
            this.f21782c = adInterfacesBoostPostDataModel.f21782c;
        }
    }

    @Nullable
    public final CampaignGroupResultsModel mo955p() {
        Object obj = (this.f21780a == null || this.f21780a.m23713l() == null || this.f21780a.m23713l().m23669l() == null) ? null : 1;
        return obj != null ? this.f21780a.m23713l().m23669l() : null;
    }

    @Nullable
    public final AdAccountBasicFieldsModel mo956q() {
        Object obj = (this.f21780a == null || this.f21780a.m23713l() == null || this.f21780a.m23713l().m23664a() == null) ? null : 1;
        return obj != null ? this.f21780a.m23713l().m23664a() : null;
    }

    public final boolean mo957r() {
        return false;
    }

    public Creative mo958u() {
        Creative creative = new Creative();
        creative.a("story_graphql_token", this.f21781b);
        return creative;
    }
}
