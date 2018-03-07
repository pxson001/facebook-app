package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.location.ImmutableLocation;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_menu_visibility_edit */
public class FetchChatContextParams implements Parcelable {
    public static final Creator<FetchChatContextParams> CREATOR = new C05351();
    public final Optional<ImmutableLocation> f8437a;
    public final boolean f8438b;

    /* compiled from: page_menu_visibility_edit */
    final class C05351 implements Creator<FetchChatContextParams> {
        C05351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchChatContextParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchChatContextParams[i];
        }
    }

    public FetchChatContextParams(Optional<ImmutableLocation> optional, boolean z) {
        this.f8437a = optional;
        this.f8438b = z;
    }

    public FetchChatContextParams() {
        this(Absent.INSTANCE, false);
    }

    public FetchChatContextParams(Parcel parcel) {
        this.f8437a = Optional.fromNullable((ImmutableLocation) parcel.readParcelable(ImmutableLocation.class.getClassLoader()));
        this.f8438b = parcel.readInt() == 1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable((Parcelable) this.f8437a.orNull(), i);
        parcel.writeInt(this.f8438b ? 1 : 0);
    }
}
