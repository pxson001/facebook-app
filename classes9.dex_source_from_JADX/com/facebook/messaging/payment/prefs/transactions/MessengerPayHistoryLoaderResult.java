package com.facebook.messaging.payment.prefs.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentRequest;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: front_facing */
public class MessengerPayHistoryLoaderResult implements Parcelable {
    public static final Creator<MessengerPayHistoryLoaderResult> CREATOR = new C16361();
    private final ImmutableList<PaymentTransaction> f14372a;
    private final ImmutableList<PaymentRequest> f14373b;
    public final boolean f14374c;

    /* compiled from: front_facing */
    final class C16361 implements Creator<MessengerPayHistoryLoaderResult> {
        C16361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MessengerPayHistoryLoaderResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new MessengerPayHistoryLoaderResult[i];
        }
    }

    public MessengerPayHistoryLoaderResult(@Nullable ImmutableList<PaymentTransaction> immutableList, @Nullable ImmutableList<PaymentRequest> immutableList2, boolean z) {
        boolean z2 = (immutableList == null && immutableList2 == null) ? false : true;
        Preconditions.checkArgument(z2);
        this.f14372a = immutableList;
        this.f14373b = immutableList2;
        this.f14374c = z;
    }

    public MessengerPayHistoryLoaderResult(Parcel parcel) {
        this.f14372a = ImmutableList.copyOf(parcel.readArrayList(PaymentTransaction.class.getClassLoader()));
        this.f14373b = ImmutableList.copyOf(FlatBufferModelHelper.b(parcel));
        this.f14374c = ParcelUtil.a(parcel);
    }

    public static MessengerPayHistoryLoaderResult m14771a(ImmutableList<PaymentTransaction> immutableList, boolean z) {
        return new MessengerPayHistoryLoaderResult(immutableList, null, z);
    }

    public final ImmutableList<? extends Object> m14772a() {
        return this.f14372a != null ? this.f14372a : this.f14373b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f14372a);
        FlatBufferModelHelper.a(parcel, this.f14373b);
        ParcelUtil.a(parcel, this.f14374c);
    }
}
