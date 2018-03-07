package com.facebook.messaging.momentsinvite.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: up_button */
public class MomentsInviteData implements Parcelable {
    public static final Creator<MomentsInviteData> CREATOR = new C01281();
    public final ImmutableList<String> f2396a;
    public final int f2397b;
    @Nullable
    public final String f2398c;
    @Nullable
    public final String f2399d;

    /* compiled from: up_button */
    final class C01281 implements Creator<MomentsInviteData> {
        C01281() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MomentsInviteData(parcel);
        }

        public final Object[] newArray(int i) {
            return new MomentsInviteData[i];
        }
    }

    MomentsInviteData(MomentsInviteDataBuilder momentsInviteDataBuilder) {
        this.f2396a = ImmutableList.copyOf((Collection) Preconditions.checkNotNull(momentsInviteDataBuilder.f2400a));
        this.f2397b = momentsInviteDataBuilder.f2401b;
        this.f2398c = momentsInviteDataBuilder.f2402c;
        this.f2399d = momentsInviteDataBuilder.f2403d;
    }

    public MomentsInviteData(Parcel parcel) {
        this.f2396a = ImmutableList.copyOf(parcel.createStringArrayList());
        this.f2397b = parcel.readInt();
        this.f2398c = parcel.readString();
        this.f2399d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f2396a);
        parcel.writeInt(this.f2397b);
        parcel.writeString(this.f2398c);
        parcel.writeString(this.f2399d);
    }
}
