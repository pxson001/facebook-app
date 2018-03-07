package com.facebook.friendsharing.souvenirs.layout;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.friendsharing.souvenirs.models.SouvenirMetadata;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = SouvenirEditorModelDeserializer.class)
@Immutable
@JsonSerialize(using = SouvenirEditorModelSerializer.class)
/* compiled from: Recorded local file from live does not exist */
public class SouvenirEditorModel implements Parcelable {
    public static final Creator<SouvenirEditorModel> CREATOR = new C20891();
    @JsonProperty("metadata")
    final SouvenirMetadata mMetadata;
    @JsonProperty("rows")
    final ImmutableList<SouvenirRow> mRows;

    /* compiled from: Recorded local file from live does not exist */
    final class C20891 implements Creator<SouvenirEditorModel> {
        C20891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SouvenirEditorModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new SouvenirEditorModel[i];
        }
    }

    public SouvenirEditorModel(Parcel parcel) {
        this.mMetadata = (SouvenirMetadata) parcel.readParcelable(SouvenirMetadata.class.getClassLoader());
        this.mRows = ParcelUtil.a(parcel, SouvenirRow.CREATOR);
    }

    private SouvenirEditorModel() {
        this.mMetadata = null;
        this.mRows = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mMetadata, i);
        parcel.writeTypedList(this.mRows);
    }
}
