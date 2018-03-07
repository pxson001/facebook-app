package com.facebook.structuredsurvey.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: downloaded_size */
public class PostSurveyAnswersParams implements Parcelable {
    public static final Creator<PostSurveyAnswersParams> CREATOR = new C12461();
    public String f17129a;
    public String f17130b;
    public boolean f17131c;
    public ImmutableMap<String, ParcelableStringArrayList> f17132d;
    public ImmutableList<ParcelableStringArrayList> f17133e;
    public ImmutableList<Integer> f17134f;
    public ImmutableMap<String, String> f17135g;

    /* compiled from: downloaded_size */
    final class C12461 implements Creator<PostSurveyAnswersParams> {
        C12461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PostSurveyAnswersParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PostSurveyAnswersParams[i];
        }
    }

    public PostSurveyAnswersParams(String str, String str2, boolean z, ImmutableMap<String, ParcelableStringArrayList> immutableMap, ImmutableList<ParcelableStringArrayList> immutableList, ImmutableList<Integer> immutableList2, ImmutableMap<String, String> immutableMap2) {
        this.f17129a = str;
        this.f17130b = str2;
        this.f17131c = z;
        this.f17132d = immutableMap;
        this.f17133e = immutableList;
        this.f17134f = immutableList2;
        this.f17135g = immutableMap2;
    }

    public PostSurveyAnswersParams(Parcel parcel) {
        this.f17129a = parcel.readString();
        this.f17130b = parcel.readString();
        this.f17131c = parcel.readByte() != (byte) 0;
        Map c = Maps.c();
        parcel.readMap(c, ParcelableStringArrayList.class.getClassLoader());
        this.f17132d = ImmutableMap.copyOf(c);
        Collection a = Lists.a();
        parcel.readTypedList(a, ParcelableStringArrayList.CREATOR);
        this.f17133e = ImmutableList.copyOf(a);
        a = new ArrayList();
        parcel.readList(a, List.class.getClassLoader());
        this.f17134f = ImmutableList.copyOf(a);
        c = new HashMap();
        parcel.readMap(c, Map.class.getClassLoader());
        this.f17135g = ImmutableMap.copyOf(c);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17129a);
        parcel.writeString(this.f17130b);
        parcel.writeByte((byte) (this.f17131c ? 1 : 0));
        parcel.writeMap(this.f17132d);
        parcel.writeTypedList(this.f17133e);
        parcel.writeList(this.f17134f);
        parcel.writeMap(this.f17135g);
    }

    public int describeContents() {
        return 0;
    }
}
