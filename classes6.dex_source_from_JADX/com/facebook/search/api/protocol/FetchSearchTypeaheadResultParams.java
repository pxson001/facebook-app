package com.facebook.search.api.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.SearchTypeaheadResult.Type;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: extra_legacy_api_post_id */
public final class FetchSearchTypeaheadResultParams implements Parcelable {
    public static final Creator<FetchSearchTypeaheadResultParams> CREATOR = new C11071();
    public final GraphSearchQuery f15553a;
    public final String f15554b;
    public final int f15555c;
    public final List<Type> f15556d;
    public final int f15557e;
    public final String f15558f;
    public final boolean f15559g;
    public final String f15560h;
    public final KeywordMode f15561i;
    public final String f15562j;

    /* compiled from: extra_legacy_api_post_id */
    final class C11071 implements Creator<FetchSearchTypeaheadResultParams> {
        C11071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchSearchTypeaheadResultParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchSearchTypeaheadResultParams[i];
        }
    }

    /* compiled from: extra_legacy_api_post_id */
    public class Builder {
        public GraphSearchQuery f15543a;
        public String f15544b;
        public int f15545c;
        public List<Type> f15546d;
        public int f15547e;
        public String f15548f;
        public boolean f15549g;
        public String f15550h;
        public KeywordMode f15551i = KeywordMode.DEFAULT_KEYWORD_MODE;
        public String f15552j;

        public final FetchSearchTypeaheadResultParams m23175a() {
            Preconditions.checkNotNull(this.f15543a);
            Preconditions.checkState(this.f15545c > 0);
            return new FetchSearchTypeaheadResultParams(this);
        }
    }

    /* compiled from: extra_legacy_api_post_id */
    public enum KeywordMode {
        DEFAULT_KEYWORD_MODE("blended"),
        KEYWORD_ONLY_MODE("keyword_only"),
        ENTITY_ONLY_MODE("entity_only"),
        SINGLE_STATE_MODE("single_state_v2"),
        WEB_VIEW_SINGLE_STATE_MODE("web_view_search_box_single_state_no_pulse"),
        SCOPED("scoped"),
        VIDEO_HOME_SEARCH_KEYWORD_ONLY_MODE("video_home_search_keyword_only");
        
        private String mValue;

        private KeywordMode(String str) {
            this.mValue = str;
        }

        public final String getValue() {
            return this.mValue;
        }
    }

    public FetchSearchTypeaheadResultParams(Builder builder) {
        this.f15553a = builder.f15543a;
        this.f15554b = builder.f15544b;
        this.f15555c = builder.f15545c;
        this.f15556d = builder.f15546d;
        this.f15557e = builder.f15547e;
        this.f15558f = builder.f15548f;
        this.f15559g = builder.f15549g;
        this.f15560h = builder.f15550h;
        this.f15561i = builder.f15551i;
        this.f15562j = builder.f15552j;
    }

    public FetchSearchTypeaheadResultParams(Parcel parcel) {
        this.f15553a = (GraphSearchQuery) parcel.readParcelable(GraphSearchQuery.class.getClassLoader());
        this.f15554b = parcel.readString();
        this.f15555c = parcel.readInt();
        this.f15556d = parcel.readArrayList(Type.class.getClassLoader());
        this.f15557e = parcel.readInt();
        this.f15558f = parcel.readString();
        this.f15559g = parcel.readByte() != (byte) 0;
        this.f15560h = parcel.readString();
        this.f15561i = KeywordMode.valueOf(parcel.readString());
        this.f15562j = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeParcelable(this.f15553a, 0);
        parcel.writeString(this.f15554b);
        parcel.writeInt(this.f15555c);
        parcel.writeList(this.f15556d);
        parcel.writeInt(this.f15557e);
        parcel.writeString(this.f15558f);
        if (this.f15559g) {
            i2 = 1;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.f15560h);
        parcel.writeString(this.f15561i.name());
        parcel.writeString(this.f15562j);
    }

    public final String toString() {
        return Objects.toStringHelper(FetchSearchTypeaheadResultParams.class).add("queryText", this.f15553a.f15458b).add("typeaheadSessionId", this.f15554b).add("photoSize", this.f15555c).add("filter", this.f15556d).add("cached_ids", this.f15558f).add("limit", this.f15557e).add("noProfileImageUrls", this.f15559g).add("friendlyName", this.f15560h).add("keywordMode", this.f15561i).add("rankingModel", this.f15562j).toString();
    }

    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.f15553a.f15458b, Integer.valueOf(this.f15555c), this.f15556d, Integer.valueOf(this.f15557e), Boolean.valueOf(this.f15559g), this.f15560h, this.f15561i, this.f15562j});
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FetchSearchTypeaheadResultParams)) {
            return false;
        }
        FetchSearchTypeaheadResultParams fetchSearchTypeaheadResultParams = (FetchSearchTypeaheadResultParams) obj;
        if (Objects.equal(this.f15553a, fetchSearchTypeaheadResultParams.f15553a) && Objects.equal(Integer.valueOf(this.f15555c), Integer.valueOf(fetchSearchTypeaheadResultParams.f15555c)) && Objects.equal(this.f15556d, fetchSearchTypeaheadResultParams.f15556d) && Objects.equal(this.f15558f, fetchSearchTypeaheadResultParams.f15558f) && Objects.equal(Integer.valueOf(this.f15557e), Integer.valueOf(fetchSearchTypeaheadResultParams.f15557e)) && Objects.equal(Boolean.valueOf(this.f15559g), Boolean.valueOf(fetchSearchTypeaheadResultParams.f15559g)) && Objects.equal(this.f15560h, fetchSearchTypeaheadResultParams.f15560h) && Objects.equal(this.f15561i, fetchSearchTypeaheadResultParams.f15561i) && Objects.equal(this.f15562j, fetchSearchTypeaheadResultParams.f15562j)) {
            return true;
        }
        return false;
    }
}
