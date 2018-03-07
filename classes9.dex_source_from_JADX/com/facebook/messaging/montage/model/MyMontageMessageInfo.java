package com.facebook.messaging.montage.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: is_funnel_logging_started */
public class MyMontageMessageInfo extends MontageMessageInfo {
    public static final Creator<MyMontageMessageInfo> CREATOR = new C14001();
    public final ImmutableList<ThreadParticipant> f12562d;

    /* compiled from: is_funnel_logging_started */
    final class C14001 implements Creator<MyMontageMessageInfo> {
        C14001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MyMontageMessageInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new MyMontageMessageInfo[i];
        }
    }

    public MyMontageMessageInfo(MontageMessageType montageMessageType, Message message, long j, ImmutableList<ThreadParticipant> immutableList) {
        super(montageMessageType, message, j);
        if (immutableList == null) {
            immutableList = RegularImmutableList.a;
        }
        this.f12562d = immutableList;
    }

    public MyMontageMessageInfo(Parcel parcel) {
        super(parcel);
        this.f12562d = ParcelUtil.a(parcel, ThreadParticipant.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f12562d);
    }
}
