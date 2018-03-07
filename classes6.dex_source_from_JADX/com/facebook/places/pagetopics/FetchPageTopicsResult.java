package com.facebook.places.pagetopics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.ipc.model.PageTopic;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FetchPageTopicsResultDeserializer.class)
/* compiled from: food_photos */
public class FetchPageTopicsResult implements Parcelable {
    public static final Creator<FetchPageTopicsResult> CREATOR = new C09461();
    @JsonProperty("data")
    private ImmutableList<PageTopic> data;
    @JsonProperty("locale")
    private String mLocale;
    @JsonProperty("summary")
    private PageTopicsGetResponseSummary summary;

    /* compiled from: food_photos */
    final class C09461 implements Creator<FetchPageTopicsResult> {
        C09461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPageTopicsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPageTopicsResult[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = FetchPageTopicsResult_PageTopicsGetResponseSummaryDeserializer.class)
    /* compiled from: food_photos */
    public class PageTopicsGetResponseSummary implements Parcelable {
        public static final Creator<PageTopicsGetResponseSummary> CREATOR = new C09471();
        @JsonProperty("topics_version")
        private long topicsVersion;

        /* compiled from: food_photos */
        final class C09471 implements Creator<PageTopicsGetResponseSummary> {
            C09471() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new PageTopicsGetResponseSummary(parcel);
            }

            public final Object[] newArray(int i) {
                return new PageTopicsGetResponseSummary[i];
            }
        }

        public PageTopicsGetResponseSummary() {
            this.topicsVersion = -1;
        }

        public final long m22295a() {
            return this.topicsVersion;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.topicsVersion);
        }

        public PageTopicsGetResponseSummary(Parcel parcel) {
            this.topicsVersion = parcel.readLong();
        }
    }

    public FetchPageTopicsResult() {
        this.data = null;
        this.summary = null;
    }

    public final ImmutableList<PageTopic> m22296a() {
        return this.data;
    }

    public final PageTopicsGetResponseSummary m22298b() {
        return this.summary;
    }

    public int describeContents() {
        return 0;
    }

    public final void m22297a(String str) {
        this.mLocale = str;
    }

    public final String m22299c() {
        return this.mLocale;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.data);
        parcel.writeParcelable(this.summary, i);
        parcel.writeString(this.mLocale);
    }

    public FetchPageTopicsResult(Parcel parcel) {
        Collection arrayList = new ArrayList();
        parcel.readList(arrayList, PageTopic.class.getClassLoader());
        this.data = ImmutableList.copyOf(arrayList);
        this.summary = (PageTopicsGetResponseSummary) parcel.readParcelable(PageTopicsGetResponseSummary.class.getClassLoader());
        this.mLocale = parcel.readString();
    }
}
