package com.facebook.adinterfaces.model.localawareness;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.HasWebsiteUrl;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: \" */
public class AdInterfacesLocalAwarenessDataModel extends AdInterfacesBoostedComponentDataModel implements HasWebsiteUrl {
    public static final Creator<AdInterfacesLocalAwarenessDataModel> CREATOR = new C25161();
    public GeoLocationModel f21807a;
    public String f21808b;
    public String f21809c;
    public ImmutableList<GraphQLCallToActionType> f21810d;
    public boolean f21811e;
    private String f21812f;

    /* compiled from: \" */
    final class C25161 implements Creator<AdInterfacesLocalAwarenessDataModel> {
        C25161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AdInterfacesLocalAwarenessDataModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new AdInterfacesLocalAwarenessDataModel[i];
        }
    }

    /* compiled from: \" */
    public class Builder extends com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel.Builder {
        public final BaseAdInterfacesData mo950a() {
            return new AdInterfacesLocalAwarenessDataModel(this);
        }
    }

    public AdInterfacesLocalAwarenessDataModel(Builder builder) {
        super((com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel.Builder) builder);
    }

    protected AdInterfacesLocalAwarenessDataModel(Parcel parcel) {
        super(parcel);
        this.f21807a = (GeoLocationModel) FlatBufferModelHelper.a(parcel);
        this.f21808b = parcel.readString();
        this.f21809c = parcel.readString();
        this.f21811e = parcel.readByte() != (byte) 0;
        this.f21812f = parcel.readString();
        List<String> arrayList = new ArrayList();
        parcel.readList(arrayList, null);
        com.google.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
        for (String valueOf : arrayList) {
            builder.c(GraphQLCallToActionType.valueOf(valueOf));
        }
        this.f21810d = builder.b();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f21807a);
        parcel.writeString(this.f21808b);
        parcel.writeString(this.f21809c);
        parcel.writeByte((byte) (this.f21811e ? 1 : 0));
        parcel.writeString(this.f21812f);
        List arrayList = new ArrayList();
        int size = this.f21810d.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((GraphQLCallToActionType) this.f21810d.get(i2)).name());
        }
        parcel.writeList(arrayList);
    }

    public final void m22899i(String str) {
        this.f21809c = str;
    }

    public final String mI_() {
        return this.f21812f;
    }

    public final void c_(String str) {
        this.f21812f = str;
    }

    public final boolean mJ_() {
        return mo951C() != null && mo951C().f21774g == GraphQLCallToActionType.LEARN_MORE;
    }

    public final int mK_() {
        return 2131233929;
    }
}
