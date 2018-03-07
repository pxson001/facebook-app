package com.facebook.messages.ipc;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.annotation.FrozenField;
import com.facebook.ipc.annotation.FrozenParcelable;
import com.facebook.ipc.annotation.FrozenParcelableUtil;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: vnd.android.cursor.item/im */
public class FrozenNewMessageNotification implements Parcelable, FrozenParcelable, Comparable<FrozenNewMessageNotification> {
    public static final Creator<FrozenNewMessageNotification> CREATOR = new C00571();
    @FrozenField
    public final String f414a;
    @FrozenField
    private final String f415b;
    @FrozenField
    @Nullable
    public final String f416c;
    @FrozenField
    @Nullable
    public final String f417d;
    @FrozenField
    public final String f418e;
    @FrozenField
    public final String f419f;
    @FrozenField
    public final PendingIntent f420g;
    @FrozenField
    private final String f421h;
    @FrozenField
    private final String f422i;
    @FrozenField
    public final long f423j;
    @FrozenField
    private final long f424k;
    @FrozenField
    @Nullable
    public final FrozenGroupMessageInfo f425l;

    /* compiled from: vnd.android.cursor.item/im */
    final class C00571 implements Creator<FrozenNewMessageNotification> {
        C00571() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return (FrozenNewMessageNotification) FrozenParcelableUtil.a(parcel, FrozenNewMessageNotification.class);
        }

        public final Object[] newArray(int i) {
            return new FrozenNewMessageNotification[i];
        }
    }

    public int compareTo(Object obj) {
        FrozenNewMessageNotification frozenNewMessageNotification = (FrozenNewMessageNotification) obj;
        if (equals(frozenNewMessageNotification)) {
            return 0;
        }
        return (int) (this.f423j - frozenNewMessageNotification.f423j);
    }

    public FrozenNewMessageNotification(String str, String str2, String str3, String str4, String str5, String str6, PendingIntent pendingIntent, String str7, String str8, long j, long j2, FrozenGroupMessageInfo frozenGroupMessageInfo) {
        this.f414a = (String) Preconditions.checkNotNull(str);
        this.f415b = (String) Preconditions.checkNotNull(str2);
        this.f416c = str3;
        this.f417d = str4;
        this.f418e = (String) Preconditions.checkNotNull(str5);
        this.f419f = (String) Preconditions.checkNotNull(str6);
        this.f420g = (PendingIntent) Preconditions.checkNotNull(pendingIntent);
        this.f421h = (String) Preconditions.checkNotNull(str7);
        this.f422i = (String) Preconditions.checkNotNull(str8);
        this.f423j = j;
        this.f424k = j2;
        this.f425l = frozenGroupMessageInfo;
    }

    private FrozenNewMessageNotification(Parcel parcel) {
        parcel.readInt();
        this.f414a = parcel.readString();
        this.f415b = parcel.readString();
        this.f416c = parcel.readString();
        this.f417d = parcel.readString();
        this.f418e = parcel.readString();
        this.f419f = parcel.readString();
        this.f420g = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        this.f421h = parcel.readString();
        this.f422i = parcel.readString();
        this.f423j = parcel.readLong();
        this.f424k = parcel.readLong();
        this.f425l = (FrozenGroupMessageInfo) parcel.readParcelable(FrozenGroupMessageInfo.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        FrozenParcelableUtil.a(parcel, i, this);
    }

    public final void m375a(Parcel parcel, int i) {
        parcel.writeInt(1);
        parcel.writeString(this.f414a);
        parcel.writeString(this.f415b);
        parcel.writeString(this.f416c);
        parcel.writeString(this.f417d);
        parcel.writeString(this.f418e);
        parcel.writeString(this.f419f);
        PendingIntent.writePendingIntentOrNullToParcel(this.f420g, parcel);
        parcel.writeString(this.f421h);
        parcel.writeString(this.f422i);
        parcel.writeLong(this.f423j);
        parcel.writeLong(this.f424k);
        parcel.writeParcelable(this.f425l, i);
    }

    @FrozenField
    public final PendingIntent m376f() {
        return this.f420g;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FrozenNewMessageNotification)) {
            return false;
        }
        return Objects.equal(this.f414a, ((FrozenNewMessageNotification) obj).f414a);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f414a});
    }
}
