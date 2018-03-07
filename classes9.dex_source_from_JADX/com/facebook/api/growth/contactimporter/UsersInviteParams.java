package com.facebook.api.growth.contactimporter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.ipc.katana.findfriends.HowFound;
import java.util.List;

/* compiled from: send_button */
public class UsersInviteParams implements Parcelable {
    public static final Creator<UsersInviteParams> CREATOR = new C03661();
    public final List<String> f4036a;
    public final String f4037b;
    public final String f4038c;
    public final CIFlow f4039d;
    public final boolean f4040e;
    public final boolean f4041f;

    /* compiled from: send_button */
    final class C03661 implements Creator<UsersInviteParams> {
        C03661() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UsersInviteParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UsersInviteParams[i];
        }
    }

    public UsersInviteParams(List<String> list, String str, CIFlow cIFlow, boolean z, boolean z2) {
        this.f4036a = list;
        this.f4037b = str;
        this.f4038c = HowFound.a;
        this.f4039d = cIFlow;
        this.f4040e = z;
        this.f4041f = z2;
    }

    public UsersInviteParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f4036a = parcel.createStringArrayList();
        this.f4037b = parcel.readString();
        this.f4038c = parcel.readString();
        this.f4039d = (CIFlow) parcel.readSerializable();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f4040e = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f4041f = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeStringList(this.f4036a);
        parcel.writeString(this.f4037b);
        parcel.writeString(this.f4038c);
        parcel.writeSerializable(this.f4039d);
        if (this.f4040e) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f4041f) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
