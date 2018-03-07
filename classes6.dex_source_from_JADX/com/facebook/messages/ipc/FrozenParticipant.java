package com.facebook.messages.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.annotation.FrozenField;
import com.facebook.ipc.annotation.FrozenParcelable;
import com.facebook.ipc.annotation.FrozenParcelableUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: vnd.android.cursor.item/email_v2 */
public class FrozenParticipant implements Parcelable, FrozenParcelable {
    public static final Creator<FrozenParticipant> CREATOR = new C00581();
    @FrozenField
    public final String f426a;
    @FrozenField
    private final String f427b;

    /* compiled from: vnd.android.cursor.item/email_v2 */
    final class C00581 implements Creator<FrozenParticipant> {
        C00581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return (FrozenParticipant) FrozenParcelableUtil.a(parcel, FrozenParticipant.class);
        }

        public final Object[] newArray(int i) {
            return new FrozenParticipant[i];
        }
    }

    public FrozenParticipant(String str, String str2) {
        this.f426a = str;
        this.f427b = str2;
    }

    private FrozenParticipant(Parcel parcel) {
        parcel.readInt();
        this.f426a = parcel.readString();
        this.f427b = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        FrozenParcelableUtil.a(parcel, i, this);
    }

    public final void m377a(Parcel parcel, int i) {
        parcel.writeInt(1);
        parcel.writeString(this.f426a);
        parcel.writeString(this.f427b);
    }

    public int describeContents() {
        return 0;
    }
}
