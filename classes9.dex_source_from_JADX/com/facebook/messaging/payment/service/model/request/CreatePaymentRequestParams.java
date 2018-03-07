package com.facebook.messaging.payment.service.model.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetch_event_info */
public class CreatePaymentRequestParams implements Parcelable {
    public static final Creator<CreatePaymentRequestParams> CREATOR = new C16911();
    public static String f14706a = "CreatePaymentRequestParams";
    public final String f14707b;
    public final String f14708c;
    public final String f14709d;
    public final String f14710e;
    public final String f14711f;
    public final String f14712g;
    public final String f14713h;

    /* compiled from: fetch_event_info */
    final class C16911 implements Creator<CreatePaymentRequestParams> {
        C16911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreatePaymentRequestParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreatePaymentRequestParams[i];
        }
    }

    public CreatePaymentRequestParams(String str, String str2, String str3, String str4, String str5, @Nullable String str6, @Nullable String str7) {
        this.f14707b = str;
        this.f14708c = str2;
        this.f14709d = str3;
        this.f14710e = str4;
        this.f14711f = str5;
        this.f14712g = str6;
        this.f14713h = str7;
    }

    public CreatePaymentRequestParams(Parcel parcel) {
        this.f14707b = parcel.readString();
        this.f14708c = parcel.readString();
        this.f14709d = parcel.readString();
        this.f14710e = parcel.readString();
        this.f14711f = parcel.readString();
        this.f14712g = parcel.readString();
        this.f14713h = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14707b);
        parcel.writeString(this.f14708c);
        parcel.writeString(this.f14709d);
        parcel.writeString(this.f14710e);
        parcel.writeString(this.f14711f);
        parcel.writeString(this.f14712g);
        parcel.writeString(this.f14713h);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("amount", this.f14707b).add("offlineThreadingId", this.f14708c).add("requesteeId", this.f14709d).add("memoText", this.f14710e).add("groupThreadId", this.f14711f).add("themeId", this.f14712g).add("platformContextId", this.f14713h).toString();
    }
}
