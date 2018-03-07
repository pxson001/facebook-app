package com.facebook.places.create.privacypicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;

/* compiled from: caption_description_medium_style */
public class PrivacyPickerRowData implements Parcelable {
    public static final Creator<PrivacyPickerRowData> CREATOR = new C20161();
    public GraphQLPrivacyOption f18410a;
    public boolean f18411b;

    /* compiled from: caption_description_medium_style */
    final class C20161 implements Creator<PrivacyPickerRowData> {
        C20161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PrivacyPickerRowData(parcel);
        }

        public final Object[] newArray(int i) {
            return new PrivacyPickerRowData[i];
        }
    }

    public PrivacyPickerRowData(GraphQLPrivacyOption graphQLPrivacyOption) {
        this.f18410a = graphQLPrivacyOption;
        this.f18411b = false;
    }

    protected PrivacyPickerRowData(Parcel parcel) {
        this.f18410a = (GraphQLPrivacyOption) FlatBufferModelHelper.a(parcel);
        this.f18411b = parcel.readByte() != (byte) 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f18410a);
        parcel.writeByte((byte) (this.f18411b ? 1 : 0));
    }
}
