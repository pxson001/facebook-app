package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.folders.ThreadTypeFilter;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: could not update unread count in the list view because the position went wrong! */
public class FetchThreadListParams implements Parcelable {
    public static final Creator<FetchThreadListParams> CREATOR = new C20271();
    public final DataFreshnessParam f17117a;
    public final FolderName f17118b;
    public final ThreadTypeFilter f17119c;
    public final boolean f17120d;
    public final long f17121e;
    private final int f17122f;
    public final RequestPriority f17123g;

    /* compiled from: could not update unread count in the list view because the position went wrong! */
    final class C20271 implements Creator<FetchThreadListParams> {
        C20271() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchThreadListParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchThreadListParams[i];
        }
    }

    FetchThreadListParams(FetchThreadListParamsBuilder fetchThreadListParamsBuilder) {
        this.f17117a = fetchThreadListParamsBuilder.f17124a;
        this.f17118b = fetchThreadListParamsBuilder.f17125b;
        this.f17119c = fetchThreadListParamsBuilder.f17126c;
        this.f17120d = fetchThreadListParamsBuilder.f17127d;
        this.f17121e = fetchThreadListParamsBuilder.f17128e;
        this.f17122f = fetchThreadListParamsBuilder.f17129f;
        this.f17123g = fetchThreadListParamsBuilder.f17130g;
    }

    public static FetchThreadListParamsBuilder newBuilder() {
        return new FetchThreadListParamsBuilder();
    }

    public FetchThreadListParams(Parcel parcel) {
        this.f17117a = DataFreshnessParam.valueOf(parcel.readString());
        this.f17118b = FolderName.fromDbName(parcel.readString());
        this.f17119c = ThreadTypeFilter.valueOf(parcel.readString());
        this.f17120d = ParcelUtil.a(parcel);
        this.f17121e = parcel.readLong();
        this.f17122f = parcel.readInt();
        this.f17123g = (RequestPriority) parcel.readParcelable(RequestPriority.class.getClassLoader());
    }

    public final DataFreshnessParam m17106a() {
        return this.f17117a;
    }

    public final FolderName m17107b() {
        return this.f17118b;
    }

    public final long m17108e() {
        return this.f17121e;
    }

    public final int m17109f() {
        return Math.max(1, this.f17122f);
    }

    public final RequestPriority m17110g() {
        return this.f17123g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17117a.toString());
        parcel.writeString(this.f17118b.dbName);
        parcel.writeString(this.f17119c.name());
        ParcelUtil.a(parcel, this.f17120d);
        parcel.writeLong(this.f17121e);
        parcel.writeInt(this.f17122f);
        parcel.writeParcelable(this.f17123g, i);
    }
}
