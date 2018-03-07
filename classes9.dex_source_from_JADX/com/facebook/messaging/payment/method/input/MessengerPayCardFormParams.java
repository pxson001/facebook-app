package com.facebook.messaging.payment.method.input;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.paymentmethods.cardform.CardFormCommonParams;
import com.facebook.payments.paymentmethods.cardform.CardFormParams;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: infra */
public class MessengerPayCardFormParams implements CardFormParams {
    public static final Creator<MessengerPayCardFormParams> CREATOR = new C14501();
    @Nullable
    public final String f13028a;
    @Nullable
    public final String f13029b;
    @Nullable
    public final String f13030c;
    @Nullable
    public final String f13031d;
    public final boolean f13032e;
    public final CardFormCommonParams f13033f;
    public final boolean f13034g;
    public final boolean f13035h;
    public final boolean f13036i;

    /* compiled from: infra */
    final class C14501 implements Creator<MessengerPayCardFormParams> {
        C14501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MessengerPayCardFormParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MessengerPayCardFormParams[i];
        }
    }

    public static MessengerPayCardFormParamsBuilder newBuilder() {
        return new MessengerPayCardFormParamsBuilder();
    }

    public MessengerPayCardFormParams(MessengerPayCardFormParamsBuilder messengerPayCardFormParamsBuilder) {
        boolean z;
        Preconditions.checkNotNull(messengerPayCardFormParamsBuilder.f13042f);
        if (messengerPayCardFormParamsBuilder.f13043g && messengerPayCardFormParamsBuilder.f13042f.d == null) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.f13028a = messengerPayCardFormParamsBuilder.f13037a;
        this.f13029b = messengerPayCardFormParamsBuilder.f13038b;
        this.f13030c = messengerPayCardFormParamsBuilder.f13039c;
        this.f13031d = messengerPayCardFormParamsBuilder.f13040d;
        this.f13032e = messengerPayCardFormParamsBuilder.f13041e;
        this.f13033f = messengerPayCardFormParamsBuilder.f13042f;
        this.f13034g = messengerPayCardFormParamsBuilder.f13043g;
        this.f13035h = messengerPayCardFormParamsBuilder.f13044h;
        this.f13036i = messengerPayCardFormParamsBuilder.f13045i;
    }

    protected MessengerPayCardFormParams(Parcel parcel) {
        this.f13028a = parcel.readString();
        this.f13029b = parcel.readString();
        this.f13030c = parcel.readString();
        this.f13031d = parcel.readString();
        this.f13032e = ParcelUtil.a(parcel);
        this.f13033f = (CardFormCommonParams) parcel.readParcelable(CardFormCommonParams.class.getClassLoader());
        this.f13034g = ParcelUtil.a(parcel);
        this.f13035h = ParcelUtil.a(parcel);
        this.f13036i = ParcelUtil.a(parcel);
    }

    public final CardFormCommonParams m13335a() {
        return this.f13033f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13028a);
        parcel.writeString(this.f13029b);
        parcel.writeString(this.f13030c);
        parcel.writeString(this.f13031d);
        ParcelUtil.a(parcel, this.f13032e);
        parcel.writeParcelable(this.f13033f, i);
        ParcelUtil.a(parcel, this.f13034g);
        ParcelUtil.a(parcel, this.f13035h);
        ParcelUtil.a(parcel, this.f13036i);
    }

    public int describeContents() {
        return 0;
    }
}
