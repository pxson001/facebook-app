package com.facebook.messages.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.annotation.FrozenField;
import com.facebook.ipc.annotation.FrozenParcelable;
import com.facebook.ipc.annotation.FrozenParcelableUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: vnd.android.cursor.item/name */
public class FrozenGroupMessageInfo implements Parcelable, FrozenParcelable {
    public static final Creator<FrozenGroupMessageInfo> CREATOR = new C00561();
    @FrozenField
    private final int f410a;
    @FrozenField
    public final ImmutableList<FrozenParticipant> f411b;
    @FrozenField
    @Nullable
    public final String f412c;
    @FrozenField
    @Nullable
    public final String f413d;

    /* compiled from: vnd.android.cursor.item/name */
    final class C00561 implements Creator<FrozenGroupMessageInfo> {
        C00561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return (FrozenGroupMessageInfo) FrozenParcelableUtil.a(parcel, FrozenGroupMessageInfo.class);
        }

        public final Object[] newArray(int i) {
            return new FrozenGroupMessageInfo[i];
        }
    }

    public FrozenGroupMessageInfo(int i, ImmutableList<FrozenParticipant> immutableList, String str, String str2) {
        this.f410a = i;
        this.f411b = (ImmutableList) Preconditions.checkNotNull(immutableList);
        this.f412c = str;
        this.f413d = str2;
    }

    private FrozenGroupMessageInfo(Parcel parcel) {
        parcel.readInt();
        this.f410a = parcel.readInt();
        this.f411b = ImmutableList.copyOf(parcel.readArrayList(FrozenParticipant.class.getClassLoader()));
        this.f412c = parcel.readString();
        this.f413d = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        FrozenParcelableUtil.a(parcel, i, this);
    }

    public final void m374a(Parcel parcel, int i) {
        parcel.writeInt(1);
        parcel.writeInt(this.f410a);
        parcel.writeList(this.f411b);
        parcel.writeString(this.f412c);
        parcel.writeString(this.f413d);
    }

    public int describeContents() {
        return 0;
    }
}
