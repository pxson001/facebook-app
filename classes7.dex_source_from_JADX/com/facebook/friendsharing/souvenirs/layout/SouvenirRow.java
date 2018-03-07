package com.facebook.friendsharing.souvenirs.layout;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.friendsharing.souvenirs.layout.template.SouvenirTemplateEnum;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirItemList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = SouvenirRowDeserializer.class)
@Immutable
@JsonSerialize(using = SouvenirRowSerializer.class)
/* compiled from: ReactionQuery */
public class SouvenirRow implements Parcelable {
    public static final Creator<SouvenirRow> CREATOR = new C20901();
    @JsonProperty("items")
    final ImmutableList<SouvenirItem> mItems;
    @JsonProperty("template")
    final SouvenirTemplateEnum mTemplate;

    /* compiled from: ReactionQuery */
    final class C20901 implements Creator<SouvenirRow> {
        C20901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SouvenirRow(parcel);
        }

        public final Object[] newArray(int i) {
            return new SouvenirRow[i];
        }
    }

    public SouvenirRow(Parcel parcel) {
        this.mTemplate = (SouvenirTemplateEnum) parcel.readParcelable(SouvenirTemplateEnum.class.getClassLoader());
        this.mItems = SouvenirItemList.m26166a(parcel);
    }

    private SouvenirRow() {
        this.mTemplate = null;
        this.mItems = null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mTemplate, i);
        SouvenirItemList.m26167a(this.mItems, parcel, i);
    }

    public int describeContents() {
        return 0;
    }
}
