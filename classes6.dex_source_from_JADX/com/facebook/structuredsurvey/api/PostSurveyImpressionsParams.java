package com.facebook.structuredsurvey.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: download_session_id */
public class PostSurveyImpressionsParams implements Parcelable {
    public static final Creator<PostSurveyImpressionsParams> CREATOR = new C12471();
    public String f17136a;
    public String f17137b;
    public String f17138c;
    public ImmutableMap<String, String> f17139d;

    /* compiled from: download_session_id */
    final class C12471 implements Creator<PostSurveyImpressionsParams> {
        C12471() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PostSurveyImpressionsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PostSurveyImpressionsParams[i];
        }
    }

    public PostSurveyImpressionsParams(String str, String str2, String str3, ImmutableMap<String, String> immutableMap) {
        this.f17136a = str;
        this.f17137b = str2;
        this.f17138c = str3;
        this.f17139d = immutableMap;
    }

    public PostSurveyImpressionsParams(Parcel parcel) {
        this.f17136a = parcel.readString();
        this.f17137b = parcel.readString();
        this.f17138c = parcel.readString();
        Map hashMap = new HashMap();
        parcel.readMap(hashMap, Map.class.getClassLoader());
        this.f17139d = ImmutableMap.copyOf(hashMap);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17136a);
        parcel.writeString(this.f17137b);
        parcel.writeString(this.f17138c);
        parcel.writeMap(this.f17139d);
    }

    public int describeContents() {
        return 0;
    }
}
