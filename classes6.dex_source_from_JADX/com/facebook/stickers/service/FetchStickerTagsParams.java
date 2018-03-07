package com.facebook.stickers.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;

/* compiled from: ec17a71b8f1ef281c1378529258c83fe */
public class FetchStickerTagsParams implements Parcelable {
    public static final Creator<FetchStickerTagsParams> CREATOR = new C12051();
    public final DataFreshnessParam f16900a;
    public final TagType f16901b;

    /* compiled from: ec17a71b8f1ef281c1378529258c83fe */
    final class C12051 implements Creator<FetchStickerTagsParams> {
        C12051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchStickerTagsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchStickerTagsParams[i];
        }
    }

    /* compiled from: ec17a71b8f1ef281c1378529258c83fe */
    public enum TagType {
        ALL("all"),
        FEATURED("featured"),
        NON_FEATURED("non_featured");
        
        private String queryParam;

        private TagType(String str) {
            this.queryParam = str;
        }

        public final String getQueryParam() {
            return this.queryParam;
        }
    }

    public FetchStickerTagsParams(DataFreshnessParam dataFreshnessParam, TagType tagType) {
        this.f16900a = dataFreshnessParam;
        this.f16901b = tagType;
    }

    public FetchStickerTagsParams(Parcel parcel) {
        this.f16900a = DataFreshnessParam.valueOf(parcel.readString());
        this.f16901b = TagType.valueOf(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16900a.toString());
        parcel.writeString(this.f16901b.toString());
    }
}
