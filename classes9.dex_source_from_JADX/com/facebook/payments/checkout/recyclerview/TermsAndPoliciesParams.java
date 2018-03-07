package com.facebook.payments.checkout.recyclerview;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: campaignName */
public class TermsAndPoliciesParams implements Parcelable {
    public static final Creator<TermsAndPoliciesParams> CREATOR = new C21511();
    public static final TermsAndPoliciesParams f18569a;
    public TermsAndPoliciesStyle f18570b;
    public Uri f18571c;
    @Nullable
    public final String f18572d;
    @Nullable
    public final String f18573e;

    /* compiled from: campaignName */
    final class C21511 implements Creator<TermsAndPoliciesParams> {
        C21511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TermsAndPoliciesParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new TermsAndPoliciesParams[i];
        }
    }

    /* compiled from: campaignName */
    public class Builder {
        public TermsAndPoliciesStyle f18565a;
        public Uri f18566b;
        public String f18567c;
        public String f18568d;

        public final TermsAndPoliciesParams m18594e() {
            return new TermsAndPoliciesParams(this);
        }
    }

    static {
        Builder newBuilder = newBuilder();
        newBuilder.f18565a = TermsAndPoliciesStyle.FACEBOOK;
        newBuilder = newBuilder;
        newBuilder.f18566b = Uri.parse("https://m.facebook.com/payments_terms");
        f18569a = newBuilder.m18594e();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public TermsAndPoliciesParams(Builder builder) {
        this.f18570b = (TermsAndPoliciesStyle) Preconditions.checkNotNull(builder.f18565a);
        this.f18571c = (Uri) Preconditions.checkNotNull(builder.f18566b);
        this.f18572d = builder.f18567c;
        this.f18573e = builder.f18568d;
    }

    public TermsAndPoliciesParams(Parcel parcel) {
        this.f18570b = (TermsAndPoliciesStyle) ParcelUtil.c(parcel, TermsAndPoliciesStyle.class);
        this.f18571c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f18572d = parcel.readString();
        this.f18573e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f18570b);
        parcel.writeParcelable(this.f18571c, i);
        parcel.writeString(this.f18572d);
        parcel.writeString(this.f18573e);
    }
}
