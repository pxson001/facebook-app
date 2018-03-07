package com.facebook.search.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;

/* compiled from: nearby_places_results_list_received_results */
public class LogSelectedSuggestionToActivityLogParams implements Parcelable {
    public static final Creator<LogSelectedSuggestionToActivityLogParams> CREATOR = new C09131();
    public final String f8109a;
    public final String f8110b;
    public final String f8111c;
    public final String f8112d;
    public final long f8113e;
    public final SearchType f8114f;
    public final boolean f8115g;

    /* compiled from: nearby_places_results_list_received_results */
    final class C09131 implements Creator<LogSelectedSuggestionToActivityLogParams> {
        C09131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LogSelectedSuggestionToActivityLogParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new LogSelectedSuggestionToActivityLogParams[i];
        }
    }

    /* compiled from: nearby_places_results_list_received_results */
    public class Builder {
        public String f8102a;
        public String f8103b;
        public String f8104c;
        public String f8105d;
        public long f8106e;
        public SearchType f8107f;
        public boolean f8108g;
    }

    /* compiled from: nearby_places_results_list_received_results */
    public enum SearchType {
        SIMPLE_SEARCH("simple_search"),
        GRAPH_SEARCH("graph_search"),
        VIDEO_SEARCH("video_search");
        
        private final String mParamName;

        private SearchType(String str) {
            this.mParamName = str;
        }

        public final String getParamName() {
            return this.mParamName;
        }
    }

    public LogSelectedSuggestionToActivityLogParams(Builder builder) {
        this.f8109a = builder.f8102a;
        this.f8110b = builder.f8103b;
        this.f8111c = builder.f8104c;
        this.f8112d = builder.f8105d;
        this.f8113e = builder.f8106e;
        this.f8114f = (SearchType) Preconditions.checkNotNull(builder.f8107f);
        this.f8115g = builder.f8108g;
    }

    public LogSelectedSuggestionToActivityLogParams(Parcel parcel) {
        boolean z = true;
        this.f8109a = parcel.readString();
        this.f8110b = parcel.readString();
        this.f8111c = parcel.readString();
        this.f8112d = parcel.readString();
        this.f8113e = parcel.readLong();
        this.f8114f = SearchType.valueOf(parcel.readString());
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f8115g = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8109a);
        parcel.writeString(this.f8110b);
        parcel.writeString(this.f8111c);
        parcel.writeString(this.f8112d);
        parcel.writeLong(this.f8113e);
        parcel.writeString(this.f8114f.name());
        parcel.writeInt(this.f8115g ? 1 : 0);
    }
}
