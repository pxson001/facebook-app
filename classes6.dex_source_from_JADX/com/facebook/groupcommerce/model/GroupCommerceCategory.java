package com.facebook.groupcommerce.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = GroupCommerceCategoryDeserializer.class)
@JsonSerialize(using = GroupCommerceCategorySerializer.class)
/* compiled from: mPostWithMinutiaeSurveyId */
public class GroupCommerceCategory implements Parcelable {
    public static final Creator<GroupCommerceCategory> CREATOR = new C06801();
    @JsonProperty("category_id")
    public final String categoryID;
    @JsonProperty("name")
    public final String name;

    /* compiled from: mPostWithMinutiaeSurveyId */
    final class C06801 implements Creator<GroupCommerceCategory> {
        C06801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GroupCommerceCategory(parcel);
        }

        public final Object[] newArray(int i) {
            return new GroupCommerceCategory[i];
        }
    }

    /* compiled from: mPostWithMinutiaeSurveyId */
    public class Builder {
        public String f10987a;
        public String f10988b;
    }

    @JsonIgnore
    private GroupCommerceCategory() {
        this(new Builder());
    }

    public GroupCommerceCategory(Builder builder) {
        this.name = builder.f10987a;
        this.categoryID = builder.f10988b;
    }

    public GroupCommerceCategory(Parcel parcel) {
        this.name = parcel.readString();
        this.categoryID = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.categoryID);
    }
}
