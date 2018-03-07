package com.facebook.messaging.payment.value.input;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: event_reminder_timestamp */
public class OrionMessengerPayParams implements Parcelable {
    public static final Creator<OrionMessengerPayParams> CREATOR = new C18131();
    public final UserKey f15512a;
    @Nullable
    public final String f15513b;
    @Nullable
    public final ThreadKey f15514c;
    public final String f15515d;
    @Nullable
    public final String f15516e;
    @Nullable
    public final PaymentPlatformContextModel f15517f;
    @Nullable
    public final String f15518g;

    /* compiled from: event_reminder_timestamp */
    final class C18131 implements Creator<OrionMessengerPayParams> {
        C18131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new OrionMessengerPayParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new OrionMessengerPayParams[i];
        }
    }

    public static OrionMessengerPayParamsBuilder newBuilder() {
        return new OrionMessengerPayParamsBuilder();
    }

    public OrionMessengerPayParams(OrionMessengerPayParamsBuilder orionMessengerPayParamsBuilder) {
        Preconditions.checkNotNull(orionMessengerPayParamsBuilder.f15519a);
        Preconditions.checkNotNull(orionMessengerPayParamsBuilder.f15522d);
        this.f15512a = orionMessengerPayParamsBuilder.f15519a;
        this.f15513b = orionMessengerPayParamsBuilder.f15520b;
        this.f15514c = orionMessengerPayParamsBuilder.f15521c;
        this.f15515d = orionMessengerPayParamsBuilder.f15522d;
        this.f15516e = orionMessengerPayParamsBuilder.f15523e;
        this.f15517f = orionMessengerPayParamsBuilder.f15524f;
        this.f15518g = orionMessengerPayParamsBuilder.f15525g;
    }

    protected OrionMessengerPayParams(Parcel parcel) {
        this.f15512a = (UserKey) parcel.readParcelable(UserKey.class.getClassLoader());
        this.f15513b = parcel.readString();
        this.f15514c = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f15515d = parcel.readString();
        this.f15516e = parcel.readString();
        this.f15517f = (PaymentPlatformContextModel) FlatBufferModelHelper.a(parcel);
        this.f15518g = parcel.readString();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("receiverUserKey", this.f15512a).add("receiverUserName", this.f15513b).add("threadKey", this.f15514c).add("defaultPaymentAmount", this.f15515d).add("memoText", this.f15516e).add("paymentPlatformContext", this.f15517f).add("groupThreadId", this.f15518g).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f15512a, i);
        parcel.writeString(this.f15513b);
        parcel.writeParcelable(this.f15514c, i);
        parcel.writeString(this.f15515d);
        parcel.writeString(this.f15516e);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f15517f);
        parcel.writeString(this.f15518g);
    }
}
