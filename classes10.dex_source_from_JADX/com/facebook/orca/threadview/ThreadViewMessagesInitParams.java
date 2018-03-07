package com.facebook.orca.threadview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.notify.FailedToSendMessageNotification.FailureReason;
import com.facebook.messaging.voip.missedcall.MissedCallInitParams;
import com.facebook.orca.compose.ComposerInitParams;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: media_tray_position */
public class ThreadViewMessagesInitParams implements Parcelable {
    public static final Creator<ThreadViewMessagesInitParams> CREATOR = new C11981();
    public final ComposerInitParams f7904a;
    public final String f7905b;
    @Nullable
    public final String f7906c;
    public final MissedCallInitParams f7907d;
    @Nullable
    public final FailureReason f7908e;

    /* compiled from: media_tray_position */
    final class C11981 implements Creator<ThreadViewMessagesInitParams> {
        C11981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThreadViewMessagesInitParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThreadViewMessagesInitParams[i];
        }
    }

    public ThreadViewMessagesInitParams(ThreadViewMessagesInitParamsBuilder threadViewMessagesInitParamsBuilder) {
        this.f7904a = threadViewMessagesInitParamsBuilder.f7909a;
        this.f7905b = threadViewMessagesInitParamsBuilder.f7910b;
        this.f7906c = threadViewMessagesInitParamsBuilder.f7911c;
        this.f7907d = threadViewMessagesInitParamsBuilder.f7912d;
        this.f7908e = threadViewMessagesInitParamsBuilder.f7913e;
    }

    public ThreadViewMessagesInitParams(Parcel parcel) {
        this.f7904a = (ComposerInitParams) parcel.readParcelable(ComposerInitParams.class.getClassLoader());
        this.f7905b = parcel.readString();
        this.f7906c = parcel.readString();
        this.f7907d = (MissedCallInitParams) parcel.readParcelable(MissedCallInitParams.class.getClassLoader());
        if (parcel.dataAvail() > 0) {
            this.f7908e = (FailureReason) parcel.readSerializable();
        } else {
            this.f7908e = null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7904a, i);
        parcel.writeString(this.f7905b);
        parcel.writeString(this.f7906c);
        parcel.writeParcelable(this.f7907d, i);
        parcel.writeSerializable(this.f7908e);
    }
}
