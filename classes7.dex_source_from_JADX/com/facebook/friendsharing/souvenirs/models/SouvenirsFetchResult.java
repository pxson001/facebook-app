package com.facebook.friendsharing.souvenirs.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsDetailsFieldsModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.google.common.collect.ImmutableList;

/* compiled from: RESUME_ON_CLICK */
public class SouvenirsFetchResult implements Parcelable {
    public static final Creator<SouvenirsFetchResult> CREATOR = new C20981();
    public final SouvenirsDetailsFieldsModel f24076a;
    public final ImmutableList<SouvenirFormattingStringModel> f24077b;

    /* compiled from: RESUME_ON_CLICK */
    final class C20981 implements Creator<SouvenirsFetchResult> {
        C20981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SouvenirsFetchResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SouvenirsFetchResult[i];
        }
    }

    public SouvenirsFetchResult(SouvenirsDetailsFieldsModel souvenirsDetailsFieldsModel, ImmutableList<SouvenirFormattingStringModel> immutableList) {
        this.f24076a = souvenirsDetailsFieldsModel;
        this.f24077b = ImmutableListHelper.a(immutableList);
    }

    public SouvenirsFetchResult(Parcel parcel) {
        this.f24076a = (SouvenirsDetailsFieldsModel) FlatBufferModelHelper.a(parcel);
        this.f24077b = ImmutableListHelper.a(parcel.readArrayList(SouvenirFormattingStringModel.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f24076a);
        parcel.writeList(this.f24077b);
    }
}
