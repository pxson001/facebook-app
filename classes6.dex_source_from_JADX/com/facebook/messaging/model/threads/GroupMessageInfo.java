package com.facebook.messaging.model.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: update_saved_state_params */
public class GroupMessageInfo implements Parcelable {
    public static final Creator<GroupMessageInfo> CREATOR = new C01141();
    public final int f2231a;
    public final ImmutableList<ParticipantInfo> f2232b;
    @Nullable
    public final String f2233c;
    @Nullable
    public final String f2234d;

    /* compiled from: update_saved_state_params */
    final class C01141 implements Creator<GroupMessageInfo> {
        C01141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GroupMessageInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GroupMessageInfo[i];
        }
    }

    public GroupMessageInfo(int i, List<ParticipantInfo> list, String str, String str2) {
        this.f2231a = i;
        this.f2232b = ImmutableList.copyOf(list);
        this.f2233c = str;
        this.f2234d = str2;
    }

    public GroupMessageInfo(Parcel parcel) {
        this.f2231a = parcel.readInt();
        this.f2232b = ImmutableList.copyOf(parcel.readArrayList(ParticipantInfo.class.getClassLoader()));
        this.f2233c = parcel.readString();
        this.f2234d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2231a);
        parcel.writeList(this.f2232b);
        parcel.writeString(this.f2233c);
        parcel.writeString(this.f2234d);
    }
}
