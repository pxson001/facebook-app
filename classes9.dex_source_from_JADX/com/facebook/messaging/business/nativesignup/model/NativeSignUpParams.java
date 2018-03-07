package com.facebook.messaging.business.nativesignup.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: mutatePaymentPlatformContextParams */
public class NativeSignUpParams implements Parcelable {
    public static final Creator<NativeSignUpParams> CREATOR = new C10101();
    public final String f8884a;
    public final String f8885b;
    @Nullable
    public final String f8886c;
    @Nullable
    public final String f8887d;
    @Nullable
    public final ThreadKey f8888e;
    @Nullable
    public final Bundle f8889f;
    @Nullable
    public final String f8890g;

    /* compiled from: mutatePaymentPlatformContextParams */
    final class C10101 implements Creator<NativeSignUpParams> {
        C10101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NativeSignUpParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new NativeSignUpParams[i];
        }
    }

    /* compiled from: mutatePaymentPlatformContextParams */
    public class NativeSignUpParamsBuilder {
        @Nullable
        public String f8877a;
        @Nullable
        public String f8878b;
        @Nullable
        public String f8879c;
        @Nullable
        public String f8880d;
        @Nullable
        public ThreadKey f8881e;
        @Nullable
        public Bundle f8882f;
        @Nullable
        public String f8883g;

        public final NativeSignUpParams m9162h() {
            return new NativeSignUpParams(this);
        }
    }

    public NativeSignUpParams(NativeSignUpParamsBuilder nativeSignUpParamsBuilder) {
        this.f8884a = (String) Preconditions.checkNotNull(nativeSignUpParamsBuilder.f8877a);
        this.f8885b = (String) Preconditions.checkNotNull(nativeSignUpParamsBuilder.f8878b);
        this.f8886c = nativeSignUpParamsBuilder.f8879c;
        this.f8887d = nativeSignUpParamsBuilder.f8880d;
        this.f8888e = nativeSignUpParamsBuilder.f8881e;
        this.f8889f = nativeSignUpParamsBuilder.f8882f;
        this.f8890g = nativeSignUpParamsBuilder.f8883g;
    }

    public static NativeSignUpParamsBuilder newBuilder() {
        return new NativeSignUpParamsBuilder();
    }

    public NativeSignUpParams(Parcel parcel) {
        ClassLoader classLoader = NativeSignUpParams.class.getClassLoader();
        this.f8884a = parcel.readString();
        this.f8885b = parcel.readString();
        this.f8886c = parcel.readString();
        this.f8887d = parcel.readString();
        this.f8888e = (ThreadKey) parcel.readParcelable(classLoader);
        this.f8889f = parcel.readBundle(classLoader);
        this.f8890g = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8884a);
        parcel.writeString(this.f8885b);
        parcel.writeString(this.f8886c);
        parcel.writeString(this.f8887d);
        parcel.writeParcelable(this.f8888e, 0);
        parcel.writeBundle(this.f8889f);
        parcel.writeString(this.f8890g);
    }
}
