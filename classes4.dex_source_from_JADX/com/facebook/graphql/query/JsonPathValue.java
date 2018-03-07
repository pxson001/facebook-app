package com.facebook.graphql.query;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = JsonPathValueDeserializer.class)
/* compiled from: friend_confirmed */
public class JsonPathValue implements Parcelable {
    public static final Creator<JsonPathValue> CREATOR = new 1();
    @JsonProperty("value")
    private String mValue;

    public static JsonPathValue m11815a(String str) {
        JsonPathValue jsonPathValue = new JsonPathValue();
        jsonPathValue.mValue = str;
        return jsonPathValue;
    }

    public String toString() {
        return this.mValue;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mValue);
    }
}
