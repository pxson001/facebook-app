package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: identitygrowth */
public class EditPhotoCaptionParams implements Parcelable {
    public static final Creator<EditPhotoCaptionParams> CREATOR = new C08331();
    public final String f12923a;
    public final DefaultTextWithEntitiesLongFields f12924b;

    /* compiled from: identitygrowth */
    final class C08331 implements Creator<EditPhotoCaptionParams> {
        C08331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditPhotoCaptionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditPhotoCaptionParams[i];
        }
    }

    public EditPhotoCaptionParams(String str, @Nullable DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        this.f12923a = str;
        this.f12924b = defaultTextWithEntitiesLongFields;
    }

    public EditPhotoCaptionParams(Parcel parcel) {
        this.f12923a = parcel.readString();
        this.f12924b = (DefaultTextWithEntitiesLongFields) FlatBufferModelHelper.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12923a);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f12924b);
    }
}
