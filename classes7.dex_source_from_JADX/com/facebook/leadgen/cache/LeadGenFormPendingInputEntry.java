package com.facebook.leadgen.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: pivot_on_share */
public class LeadGenFormPendingInputEntry implements Parcelable {
    public static final Creator<LeadGenFormPendingInputEntry> CREATOR = new C05771();
    public final String f6362a;
    public final int f6363b;
    public final Map<String, String> f6364c;

    /* compiled from: pivot_on_share */
    final class C05771 implements Creator<LeadGenFormPendingInputEntry> {
        C05771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LeadGenFormPendingInputEntry(parcel);
        }

        public final Object[] newArray(int i) {
            return new LeadGenFormPendingInputEntry[i];
        }
    }

    public LeadGenFormPendingInputEntry(String str, int i, Map<String, String> map) {
        this.f6362a = str;
        this.f6363b = i;
        this.f6364c = map;
    }

    public LeadGenFormPendingInputEntry(Parcel parcel) {
        this.f6362a = parcel.readString();
        this.f6363b = parcel.readInt();
        this.f6364c = new HashMap();
        parcel.readMap(this.f6364c, Map.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6362a);
        parcel.writeInt(this.f6363b);
        parcel.writeMap(this.f6364c);
    }
}
