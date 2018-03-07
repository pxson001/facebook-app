package com.facebook.crowdsourcing.suggestedits.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsHeaderModel;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;

/* compiled from: codec.start() */
public class SuggestEditsHeaderState implements Parcelable {
    public static final Creator<SuggestEditsHeaderState> CREATOR = new C14801();
    public final boolean f17671a;
    public final SuggestEditsHeaderModel f17672b;
    public SuggestEditsHeaderModel f17673c;
    public SuggestEditsHeaderModel f17674d;

    /* compiled from: codec.start() */
    final class C14801 implements Creator<SuggestEditsHeaderState> {
        C14801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SuggestEditsHeaderState(parcel);
        }

        public final Object[] newArray(int i) {
            return new SuggestEditsHeaderState[i];
        }
    }

    public SuggestEditsHeaderState(SuggestEditsHeaderModel suggestEditsHeaderModel, boolean z) {
        this.f17672b = suggestEditsHeaderModel;
        this.f17673c = suggestEditsHeaderModel;
        this.f17671a = z;
    }

    public SuggestEditsHeaderState(Parcel parcel) {
        this.f17671a = parcel.readByte() != (byte) 0;
        this.f17672b = (SuggestEditsHeaderModel) FlatBufferModelHelper.a(parcel);
        this.f17673c = (SuggestEditsHeaderModel) FlatBufferModelHelper.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f17671a ? (byte) 1 : (byte) 0);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f17672b);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f17673c);
    }
}
