package com.facebook.ipc.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@Immutable
/* compiled from: TEXMEX_RESTAURANT */
public class NuxStep implements Parcelable {
    public static final Creator<NuxStep> CREATOR = new C13621();
    @JsonProperty("is_current")
    public final int isCurrent;
    @JsonProperty("name")
    public final String name;

    /* compiled from: TEXMEX_RESTAURANT */
    final class C13621 implements Creator<NuxStep> {
        C13621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NuxStep(parcel);
        }

        public final Object[] newArray(int i) {
            return new NuxStep[i];
        }
    }

    public NuxStep(String str, boolean z) {
        this.name = str;
        this.isCurrent = z ? 1 : 0;
    }

    public NuxStep() {
        this(null, false);
    }

    public NuxStep(Parcel parcel) {
        this.name = parcel.readString();
        this.isCurrent = parcel.readInt();
    }

    public final boolean m23515b() {
        return this.isCurrent > 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.isCurrent);
    }
}
