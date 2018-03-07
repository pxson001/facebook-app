package com.facebook.notifications.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;

/* compiled from: min_messenger_version_for_secure_browser_share */
public class FetchGraphQLNotificationsParams implements Parcelable {
    public static final Creator<FetchGraphQLNotificationsParams> CREATOR = new C03751();
    public final DataFreshnessParam f7674a;
    public final int f7675b;
    public final int f7676c;
    public final String f7677d;
    public final String f7678e;
    public final ViewerContext f7679f;
    public final String f7680g;
    public final List<String> f7681h;
    public final boolean f7682i;
    public final boolean f7683j;
    public final boolean f7684k;
    public int f7685l;
    public final String f7686m;
    public boolean f7687n;
    public String f7688o;

    /* compiled from: min_messenger_version_for_secure_browser_share */
    final class C03751 implements Creator<FetchGraphQLNotificationsParams> {
        C03751() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchGraphQLNotificationsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchGraphQLNotificationsParams[i];
        }
    }

    public FetchGraphQLNotificationsParams(FetchGraphQLNotificationsParamsBuilder fetchGraphQLNotificationsParamsBuilder) {
        this.f7674a = fetchGraphQLNotificationsParamsBuilder.f7654a;
        this.f7675b = fetchGraphQLNotificationsParamsBuilder.f7655b;
        this.f7676c = fetchGraphQLNotificationsParamsBuilder.f7656c;
        this.f7677d = fetchGraphQLNotificationsParamsBuilder.f7657d;
        this.f7678e = fetchGraphQLNotificationsParamsBuilder.f7658e;
        this.f7679f = fetchGraphQLNotificationsParamsBuilder.f7659f;
        this.f7680g = fetchGraphQLNotificationsParamsBuilder.f7660g;
        this.f7681h = fetchGraphQLNotificationsParamsBuilder.f7661h;
        this.f7682i = fetchGraphQLNotificationsParamsBuilder.f7662i;
        this.f7683j = fetchGraphQLNotificationsParamsBuilder.f7663j;
        this.f7684k = fetchGraphQLNotificationsParamsBuilder.f7664k;
        this.f7685l = fetchGraphQLNotificationsParamsBuilder.f7665l;
        this.f7686m = fetchGraphQLNotificationsParamsBuilder.f7666m;
        this.f7687n = fetchGraphQLNotificationsParamsBuilder.f7667n;
        this.f7688o = fetchGraphQLNotificationsParamsBuilder.f7668o;
    }

    public FetchGraphQLNotificationsParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f7674a = DataFreshnessParam.valueOf(parcel.readString());
        this.f7675b = parcel.readInt();
        this.f7676c = parcel.readInt();
        this.f7677d = parcel.readString();
        this.f7678e = parcel.readString();
        this.f7679f = (ViewerContext) parcel.readParcelable(ViewerContext.class.getClassLoader());
        this.f7680g = parcel.readString();
        this.f7681h = new ArrayList();
        parcel.readList(this.f7681h, null);
        this.f7682i = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f7683j = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f7684k = z;
        this.f7685l = parcel.readInt();
        this.f7686m = parcel.readString();
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f7687n = z2;
        this.f7688o = parcel.readString();
    }

    public final int m8041b() {
        return this.f7675b;
    }

    public final long m8042f() {
        return Long.parseLong(this.f7679f.mUserId);
    }

    public final boolean m8043k() {
        return this.f7682i;
    }

    public final boolean m8044m() {
        return this.f7684k;
    }

    public final int m8045n() {
        return this.f7685l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f7674a.toString());
        parcel.writeInt(this.f7675b);
        parcel.writeInt(this.f7676c);
        parcel.writeString(this.f7677d);
        parcel.writeString(this.f7678e);
        parcel.writeParcelable(this.f7679f, i);
        parcel.writeString(this.f7680g);
        parcel.writeList(this.f7681h);
        parcel.writeInt(this.f7682i ? 1 : 0);
        if (this.f7683j) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f7684k) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.f7685l);
        parcel.writeString(this.f7686m);
        if (!this.f7687n) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.f7688o);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchGraphQLNotificationsParams)) {
            return false;
        }
        FetchGraphQLNotificationsParams fetchGraphQLNotificationsParams = (FetchGraphQLNotificationsParams) obj;
        if (Objects.equal(this.f7674a, fetchGraphQLNotificationsParams.f7674a) && Objects.equal(this.f7678e, fetchGraphQLNotificationsParams.f7678e) && Objects.equal(this.f7677d, fetchGraphQLNotificationsParams.f7677d) && Objects.equal(Integer.valueOf(this.f7675b), Integer.valueOf(fetchGraphQLNotificationsParams.f7675b)) && Objects.equal(Integer.valueOf(this.f7676c), Integer.valueOf(fetchGraphQLNotificationsParams.f7676c)) && Objects.equal(this.f7679f, fetchGraphQLNotificationsParams.f7679f) && Objects.equal(this.f7680g, fetchGraphQLNotificationsParams.f7680g) && this.f7681h.equals(fetchGraphQLNotificationsParams.f7681h) && this.f7682i == fetchGraphQLNotificationsParams.f7682i && this.f7683j == fetchGraphQLNotificationsParams.f7683j && this.f7684k == fetchGraphQLNotificationsParams.f7684k && this.f7685l == fetchGraphQLNotificationsParams.f7685l && this.f7686m.equals(fetchGraphQLNotificationsParams.f7686m) && this.f7687n == fetchGraphQLNotificationsParams.f7687n && this.f7688o.equals(fetchGraphQLNotificationsParams.f7688o)) {
            return true;
        }
        return false;
    }
}
