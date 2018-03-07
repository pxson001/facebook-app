package com.facebook.pages.adminedpages.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.ipc.pages.PageInfo;
import java.util.ArrayList;

/* compiled from: cta_phone_view */
public class FetchAllPagesResult extends BaseResult implements Parcelable {
    public static final Creator<FetchAllPagesResult> CREATOR = new C17901();
    public final ArrayList<PageInfo> f16551a;
    private final String f16552b;

    /* compiled from: cta_phone_view */
    final class C17901 implements Creator<FetchAllPagesResult> {
        C17901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchAllPagesResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchAllPagesResult[i];
        }
    }

    public FetchAllPagesResult(DataFreshnessResult dataFreshnessResult, ArrayList<PageInfo> arrayList, String str, long j) {
        super(dataFreshnessResult, j);
        this.f16551a = arrayList;
        this.f16552b = str;
    }

    public FetchAllPagesResult(Parcel parcel) {
        super(parcel);
        this.f16551a = parcel.readArrayList(PageInfo.class.getClassLoader());
        this.f16552b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f16551a);
        parcel.writeString(this.f16552b);
    }
}
