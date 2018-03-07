package com.facebook.profile.inforequest.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

/* compiled from: loaded_profile_name */
public class DeleteInfoRequestParams implements Parcelable {
    public static final Creator<DeleteInfoRequestParams> CREATOR = new C12751();
    public final String f8572a;
    public final List<String> f8573b;

    /* compiled from: loaded_profile_name */
    final class C12751 implements Creator<DeleteInfoRequestParams> {
        C12751() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeleteInfoRequestParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeleteInfoRequestParams[i];
        }
    }

    public DeleteInfoRequestParams(String str, List<String> list) {
        this.f8572a = str;
        this.f8573b = list;
    }

    public DeleteInfoRequestParams(Parcel parcel) {
        this.f8572a = parcel.readString();
        this.f8573b = parcel.readArrayList(String.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8572a);
        parcel.writeList(this.f8573b);
    }
}
