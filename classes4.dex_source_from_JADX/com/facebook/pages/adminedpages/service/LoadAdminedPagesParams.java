package com.facebook.pages.adminedpages.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: error_detail_type_param */
public class LoadAdminedPagesParams implements Parcelable {
    public static final Creator<LoadAdminedPagesParams> CREATOR = new C06131();
    public final DataFreshnessParam f12807a;

    /* compiled from: error_detail_type_param */
    final class C06131 implements Creator<LoadAdminedPagesParams> {
        C06131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LoadAdminedPagesParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new LoadAdminedPagesParams[i];
        }
    }

    public LoadAdminedPagesParams(DataFreshnessParam dataFreshnessParam) {
        this.f12807a = dataFreshnessParam;
    }

    public LoadAdminedPagesParams(Parcel parcel) {
        this.f12807a = DataFreshnessParam.valueOf(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12807a.toString());
    }
}
