package com.facebook.graphql.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: education_content */
final class JsonPathValue$1 implements Creator<JsonPathValue> {
    JsonPathValue$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return JsonPathValue.a(parcel.readString());
    }

    public final Object[] newArray(int i) {
        return new JsonPathValue[i];
    }
}
