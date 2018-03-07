package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.graphql.model.Impression.ImpressionType;
import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.annotation.JsonIgnore;

/* compiled from: instant_articles */
public abstract class BaseImpression implements Parcelable {
    @JsonIgnore
    public Impression$LoggingStatus f19778a;
    @JsonIgnore
    public Impression$LoggingStatus f19779b;
    @JsonIgnore
    protected Impression$LoggingStatus f19780c;
    @JsonIgnore
    public boolean f19781d;
    @JsonIgnore
    public boolean f19782e;
    @JsonIgnore
    public long f19783f;
    @JsonIgnore
    protected long f19784g;
    @JsonIgnore
    public long f19785h;
    @JsonIgnore
    public String f19786i;
    @JsonIgnore
    protected int f19787j;
    @JsonIgnore
    protected int f19788k;
    @JsonIgnore
    public int f19789l;
    @JsonIgnore
    public long f19790m;

    public abstract boolean mo3118a();

    public abstract boolean mo3119b();

    public abstract boolean mo3120c();

    public abstract boolean mo3121k();

    public BaseImpression() {
        this.f19778a = Impression$LoggingStatus.NOT_LOGGED;
        this.f19779b = Impression$LoggingStatus.NOT_LOGGED;
        this.f19780c = Impression$LoggingStatus.NOT_LOGGED;
        this.f19781d = false;
        this.f19782e = false;
        this.f19783f = 0;
        this.f19784g = 0;
        this.f19785h = 0;
        this.f19787j = 0;
        this.f19788k = 0;
        this.f19789l = 0;
        this.f19790m = 0;
        this.f19786i = "";
    }

    public BaseImpression(Parcel parcel) {
        this.f19781d = ParcelUtil.a(parcel);
        this.f19782e = ParcelUtil.a(parcel);
        this.f19787j = parcel.readInt();
        this.f19788k = parcel.readInt();
        this.f19778a = Impression$LoggingStatus.NOT_LOGGED;
        this.f19779b = Impression$LoggingStatus.NOT_LOGGED;
        this.f19780c = Impression$LoggingStatus.NOT_LOGGED;
        this.f19783f = 0;
        this.f19784g = 0;
        this.f19785h = 0;
        this.f19789l = 0;
        this.f19790m = 0;
        this.f19786i = "";
    }

    public long mo3168d() {
        return Long.MAX_VALUE;
    }

    public long mo3169f() {
        return Long.MAX_VALUE;
    }

    public int mo3170g() {
        return 0;
    }

    private boolean m27474c(long j) {
        if (!mo3121k() || !mo3120c() || this.f19780c == Impression$LoggingStatus.PENDING || this.f19780c == Impression$LoggingStatus.LOGGING || this.f19781d || this.f19784g == 0 || this.f19784g + ((long) this.f19788k) > j) {
            return false;
        }
        return true;
    }

    public final boolean m27478a(int i) {
        if (!mo3121k() || !mo3120c()) {
            return false;
        }
        boolean z = i > 0 && i >= this.f19787j;
        if (z || this.f19784g == 0) {
            return false;
        }
        return true;
    }

    public final void m27475a(ImpressionType impressionType) {
        switch (1.a[impressionType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f19778a = Impression$LoggingStatus.PENDING;
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f19779b = Impression$LoggingStatus.PENDING;
                return;
            case 3:
                this.f19780c = Impression$LoggingStatus.PENDING;
                this.f19781d = true;
                return;
            default:
                return;
        }
    }

    public final void m27481b(ImpressionType impressionType) {
        switch (1.a[impressionType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f19778a = Impression$LoggingStatus.LOGGING;
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f19779b = Impression$LoggingStatus.LOGGING;
                return;
            case 3:
                this.f19780c = Impression$LoggingStatus.LOGGING;
                return;
            default:
                return;
        }
    }

    public final void m27476a(ImpressionType impressionType, boolean z, long j) {
        Impression$LoggingStatus impression$LoggingStatus = z ? Impression$LoggingStatus.LOGGED : Impression$LoggingStatus.FAILED;
        switch (1.a[impressionType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f19778a = impression$LoggingStatus;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f19779b = impression$LoggingStatus;
                break;
            case 3:
                this.f19780c = impression$LoggingStatus;
                break;
        }
        if (impressionType != ImpressionType.ORIGINAL && impressionType != ImpressionType.SUBSEQUENT) {
            return;
        }
        if (z) {
            this.f19783f = j;
            this.f19790m = 0;
            this.f19789l = 0;
            return;
        }
        this.f19790m = j;
        this.f19789l++;
    }

    public final boolean m27479a(int i, long j, boolean z) {
        if (i >= this.f19787j) {
            if (this.f19784g == 0) {
                this.f19784g = j;
            }
            return m27474c(j);
        }
        if (this.f19784g > 0 && z) {
            this.f19782e = true;
        }
        boolean c = m27474c(j);
        this.f19784g = 0;
        return c;
    }

    public final long m27480b(long j) {
        return this.f19784g > 0 ? j - this.f19784g : 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f19781d);
        ParcelUtil.a(parcel, this.f19782e);
        parcel.writeInt(this.f19787j);
        parcel.writeInt(this.f19788k);
    }
}
