package com.facebook.adinterfaces.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountBasicFieldsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdminInfoModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentValidationMessageModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CampaignGroupResultsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.IntervalModel;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Creative;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: \d[\dA-Z]?[ ]?\d[ABD-HJLN-UW-Z]{2} */
public abstract class BaseAdInterfacesData implements Parcelable {
    public AdminInfoModel f21745a;
    public ObjectiveType f21746b;
    public String f21747c = "";
    public AdInterfacesStatus f21748d;
    public String f21749e = "";
    public CurrencyQuantityModel f21750f;
    public CurrencyQuantityModel f21751g;
    public IntervalModel f21752h;
    public int f21753i = -1;
    public AdInterfacesTargetingData f21754j;
    public String f21755k;
    public String f21756l;
    public BoostedComponentValidationMessageModel f21757m;
    public ImmutableList<BoostedComponentAudienceModel> f21758n;
    public int f21759o = -1;

    /* compiled from: \d[\dA-Z]?[ ]?\d[ABD-HJLN-UW-Z]{2} */
    public class BoostedComponentParceableAudience implements Parcelable {
        public static final Creator<BoostedComponentParceableAudience> CREATOR = new C25111();
        public BoostedComponentAudienceModel f21730a;

        /* compiled from: \d[\dA-Z]?[ ]?\d[ABD-HJLN-UW-Z]{2} */
        final class C25111 implements Creator<BoostedComponentParceableAudience> {
            C25111() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new BoostedComponentParceableAudience(parcel);
            }

            public final Object[] newArray(int i) {
                return new BoostedComponentParceableAudience[i];
            }
        }

        public BoostedComponentParceableAudience(BoostedComponentAudienceModel boostedComponentAudienceModel) {
            this.f21730a = boostedComponentAudienceModel;
        }

        public BoostedComponentParceableAudience(Parcel parcel) {
            this.f21730a = (BoostedComponentAudienceModel) FlatBufferModelHelper.a(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            FlatBufferModelHelper.a(parcel, this.f21730a);
        }
    }

    /* compiled from: \d[\dA-Z]?[ ]?\d[ABD-HJLN-UW-Z]{2} */
    public abstract class Builder<T extends BaseAdInterfacesData> {
        public AdminInfoModel f21731a;
        public ObjectiveType f21732b;
        public String f21733c = "";
        public AdInterfacesStatus f21734d;
        public String f21735e = "";
        public CurrencyQuantityModel f21736f;
        public CurrencyQuantityModel f21737g;
        public IntervalModel f21738h;
        public int f21739i = -1;
        public AdInterfacesTargetingData f21740j;
        public String f21741k;
        public String f21742l;
        public ImmutableList<BoostedComponentAudienceModel> f21743m;
        public int f21744n = -1;

        public abstract T mo950a();

        public Builder(BaseAdInterfacesData baseAdInterfacesData) {
            this.f21732b = baseAdInterfacesData.mo962b();
            this.f21731a = baseAdInterfacesData.f21745a;
            this.f21734d = baseAdInterfacesData.f21748d;
            this.f21733c = baseAdInterfacesData.f21747c;
            this.f21735e = baseAdInterfacesData.m22853i();
            this.f21736f = baseAdInterfacesData.f21750f;
            this.f21737g = baseAdInterfacesData.f21751g;
            this.f21738h = baseAdInterfacesData.f21752h;
            this.f21739i = baseAdInterfacesData.f21753i;
            this.f21740j = baseAdInterfacesData.f21754j;
            this.f21741k = baseAdInterfacesData.f21755k;
            this.f21742l = baseAdInterfacesData.f21756l;
            this.f21744n = baseAdInterfacesData.f21759o;
            this.f21743m = baseAdInterfacesData.f21758n;
        }
    }

    @Nullable
    public abstract DefaultTextWithEntitiesLongFields mo954m();

    @Nullable
    public abstract CampaignGroupResultsModel mo955p();

    @Nullable
    public abstract AdAccountBasicFieldsModel mo956q();

    public abstract boolean mo957r();

    public abstract Creative mo958u();

    public BaseAdInterfacesData(Builder builder) {
        this.f21745a = builder.f21731a;
        this.f21746b = builder.f21732b;
        this.f21747c = builder.f21733c;
        this.f21748d = builder.f21734d;
        this.f21749e = builder.f21735e;
        this.f21750f = builder.f21736f;
        this.f21751g = builder.f21737g;
        this.f21752h = builder.f21738h;
        this.f21753i = builder.f21739i;
        this.f21754j = builder.f21740j;
        this.f21755k = builder.f21741k;
        this.f21756l = builder.f21742l;
        this.f21759o = builder.f21744n;
        this.f21758n = builder.f21743m;
    }

    protected BaseAdInterfacesData(Parcel parcel) {
        this.f21745a = (AdminInfoModel) FlatBufferModelHelper.a(parcel);
        this.f21746b = (ObjectiveType) parcel.readSerializable();
        this.f21747c = parcel.readString();
        this.f21748d = (AdInterfacesStatus) parcel.readSerializable();
        this.f21749e = parcel.readString();
        this.f21750f = (CurrencyQuantityModel) FlatBufferModelHelper.a(parcel);
        this.f21751g = (CurrencyQuantityModel) FlatBufferModelHelper.a(parcel);
        this.f21752h = (IntervalModel) FlatBufferModelHelper.a(parcel);
        this.f21753i = parcel.readInt();
        this.f21754j = (AdInterfacesTargetingData) parcel.readParcelable(AdInterfacesTargetingData.class.getClassLoader());
        this.f21755k = parcel.readString();
        this.f21756l = parcel.readString();
        this.f21759o = parcel.readInt();
        List<BoostedComponentParceableAudience> arrayList = new ArrayList();
        parcel.readTypedList(arrayList, BoostedComponentParceableAudience.CREATOR);
        Collection arrayList2 = new ArrayList();
        for (BoostedComponentParceableAudience boostedComponentParceableAudience : arrayList) {
            arrayList2.add(boostedComponentParceableAudience.f21730a);
        }
        this.f21758n = ImmutableList.copyOf(arrayList2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        List list;
        FlatBufferModelHelper.a(parcel, this.f21745a);
        parcel.writeSerializable(this.f21746b);
        parcel.writeString(this.f21747c);
        parcel.writeSerializable(this.f21748d);
        parcel.writeString(this.f21749e);
        FlatBufferModelHelper.a(parcel, this.f21750f);
        FlatBufferModelHelper.a(parcel, this.f21751g);
        FlatBufferModelHelper.a(parcel, this.f21752h);
        parcel.writeInt(this.f21753i);
        parcel.writeParcelable(this.f21754j, i);
        parcel.writeString(this.f21755k);
        parcel.writeString(this.f21756l);
        parcel.writeInt(this.f21759o);
        List arrayList = new ArrayList();
        if (this.f21758n == null) {
            list = arrayList;
        } else {
            ImmutableList asList = this.f21758n.asList();
            int size = asList.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new BoostedComponentParceableAudience((BoostedComponentAudienceModel) asList.get(i2)));
            }
            list = arrayList;
        }
        parcel.writeTypedList(list);
    }

    public final AdminInfoModel m22850d() {
        return this.f21745a;
    }

    public ObjectiveType mo962b() {
        return this.f21746b;
    }

    public final String m22849c() {
        return this.f21747c;
    }

    public final AdInterfacesStatus m22845a() {
        return this.f21748d;
    }

    @Nullable
    public final String m22853i() {
        if (!((this.f21749e != null && !this.f21749e.equals("")) || this.f21745a == null || this.f21745a.m23183a() == null || this.f21745a.m23183a().m23158a() == null || this.f21745a.m23183a().m23158a().isEmpty() || this.f21745a.m23183a().m23158a().get(0) == null)) {
            this.f21749e = ((AdAccountModel) this.f21745a.m23183a().m23158a().get(0)).m23146t();
        }
        return this.f21749e;
    }

    public final CurrencyQuantityModel m22851g() {
        return this.f21750f;
    }

    public final void m22848b(CurrencyQuantityModel currencyQuantityModel, IntervalModel intervalModel) {
        this.f21750f = currencyQuantityModel;
        this.f21752h = intervalModel;
    }

    public final void m22846a(CurrencyQuantityModel currencyQuantityModel, IntervalModel intervalModel) {
        this.f21751g = currencyQuantityModel;
        this.f21752h = intervalModel;
    }

    public final int m22852h() {
        return this.f21753i;
    }

    public final AdInterfacesTargetingData m22854j() {
        return this.f21754j;
    }

    public final String m22855k() {
        return this.f21755k;
    }

    public final String m22856l() {
        return this.f21756l;
    }

    public FeedUnit mo959v() {
        return null;
    }
}
