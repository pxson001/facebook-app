package com.facebook.platform.webdialogs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = PlatformWebViewActionManifestDeserializer.class)
/* compiled from: feed_fetch_news_feed_after */
public class PlatformWebViewActionManifest implements Parcelable {
    public static final Creator<PlatformWebViewActionManifest> CREATOR = new C05721();
    @JsonProperty("action")
    private String mAction;
    @JsonProperty("fetchState")
    private FetchState mFetchState;
    @JsonProperty("resultAction")
    private String mResultAction;
    @JsonProperty("uri")
    private String mUri;
    @JsonProperty("version")
    private String mVersion;

    /* compiled from: feed_fetch_news_feed_after */
    final class C05721 implements Creator<PlatformWebViewActionManifest> {
        C05721() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlatformWebViewActionManifest(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlatformWebViewActionManifest[i];
        }
    }

    /* compiled from: feed_fetch_news_feed_after */
    public enum FetchState implements Parcelable {
        NOT_FETCHED,
        FETCHING,
        FETCHED;
        
        public static final Creator<FetchState> CREATOR = null;

        /* compiled from: feed_fetch_news_feed_after */
        final class C05731 implements Creator<FetchState> {
            C05731() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return FetchState.values()[parcel.readInt()];
            }

            public final Object[] newArray(int i) {
                return new FetchState[i];
            }
        }

        static {
            CREATOR = new C05731();
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(ordinal());
        }
    }

    public PlatformWebViewActionManifest(Parcel parcel) {
        this.mAction = parcel.readString();
        this.mResultAction = parcel.readString();
        this.mVersion = parcel.readString();
        this.mUri = parcel.readString();
        this.mFetchState = (FetchState) parcel.readParcelable(FetchState.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAction);
        parcel.writeString(this.mResultAction);
        parcel.writeString(this.mVersion);
        parcel.writeString(this.mUri);
        parcel.writeParcelable(this.mFetchState, i);
    }

    public int describeContents() {
        return 0;
    }

    public final String m12487a() {
        return this.mAction;
    }

    public final String m12490b() {
        return this.mVersion;
    }

    public final String m12492c() {
        return this.mUri;
    }

    public final FetchState m12494d() {
        return this.mFetchState;
    }

    public final void m12489a(String str) {
        this.mAction = str;
    }

    public final void m12491b(String str) {
        this.mResultAction = str;
    }

    public final void m12493c(String str) {
        this.mVersion = str;
    }

    public final void m12495d(String str) {
        this.mUri = str;
    }

    public final void m12488a(FetchState fetchState) {
        this.mFetchState = fetchState;
    }
}
