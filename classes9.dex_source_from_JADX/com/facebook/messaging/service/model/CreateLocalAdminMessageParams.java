package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.model.messages.Message;

/* compiled from: create_thread_offline_id */
public class CreateLocalAdminMessageParams implements Parcelable {
    public static final Creator<CreateLocalAdminMessageParams> CREATOR = new C19951();
    public final Message f17022a;
    public final boolean f17023b;

    /* compiled from: create_thread_offline_id */
    final class C19951 implements Creator<CreateLocalAdminMessageParams> {
        C19951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreateLocalAdminMessageParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreateLocalAdminMessageParams[i];
        }
    }

    public CreateLocalAdminMessageParams(Parcel parcel) {
        this.f17022a = (Message) parcel.readParcelable(Message.class.getClassLoader());
        this.f17023b = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17022a, i);
        ParcelUtil.a(parcel, this.f17023b);
    }
}
