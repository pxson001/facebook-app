package com.facebook.video.engine;

import android.graphics.RectF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.server.VideoServer;
import com.google.common.base.Objects;

/* compiled from: photoreminderoptin */
public class VideoDataSource implements Parcelable {
    public static final Creator<VideoDataSource> CREATOR = new C02111();
    public static final RectF f4815a = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    public final Uri f4816b;
    public final Uri f4817c;
    public final Uri f4818d;
    public final Uri f4819e;
    public final String f4820f;
    public final StreamSourceType f4821g;
    public final RectF f4822h;
    public final VideoMirroringMode f4823i;

    /* compiled from: photoreminderoptin */
    final class C02111 implements Creator<VideoDataSource> {
        C02111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoDataSource(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoDataSource[i];
        }
    }

    /* compiled from: photoreminderoptin */
    public enum VideoMirroringMode {
        NONE,
        MIRROR_HORIZONTALLY
    }

    public static VideoDataSourceBuilder newBuilder() {
        return new VideoDataSourceBuilder();
    }

    VideoDataSource(VideoDataSourceBuilder videoDataSourceBuilder) {
        this.f4816b = videoDataSourceBuilder.f4824a;
        this.f4817c = videoDataSourceBuilder.f4825b;
        this.f4818d = videoDataSourceBuilder.f4826c;
        this.f4819e = videoDataSourceBuilder.f4827d;
        this.f4820f = videoDataSourceBuilder.f4828e;
        this.f4821g = videoDataSourceBuilder.f4829f;
        this.f4822h = videoDataSourceBuilder.f4830g;
        this.f4823i = videoDataSourceBuilder.f4831h;
    }

    public VideoDataSource(Parcel parcel) {
        this.f4816b = (Uri) parcel.readParcelable(null);
        this.f4817c = (Uri) parcel.readParcelable(null);
        this.f4818d = (Uri) parcel.readParcelable(null);
        this.f4819e = (Uri) parcel.readParcelable(null);
        this.f4820f = parcel.readString();
        this.f4821g = StreamSourceType.valueOf(parcel.readString());
        this.f4822h = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
        this.f4823i = VideoMirroringMode.values()[parcel.readInt()];
    }

    public String toString() {
        return this.f4816b + " (" + this.f4821g + ")";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4816b, i);
        parcel.writeParcelable(this.f4817c, i);
        parcel.writeParcelable(this.f4818d, i);
        parcel.writeParcelable(this.f4819e, i);
        parcel.writeString(this.f4820f);
        parcel.writeString(this.f4821g.name());
        parcel.writeParcelable(this.f4822h, i);
        parcel.writeInt(this.f4823i.ordinal());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoDataSource)) {
            return false;
        }
        VideoDataSource videoDataSource = (VideoDataSource) obj;
        if (m5250a(this.f4816b, videoDataSource.f4816b) && m5250a(this.f4817c, videoDataSource.f4817c) && m5250a(this.f4819e, videoDataSource.f4819e) && Objects.equal(this.f4820f, videoDataSource.f4820f) && Objects.equal(this.f4821g, videoDataSource.f4821g) && Objects.equal(this.f4822h, videoDataSource.f4822h) && Objects.equal(this.f4823i, videoDataSource.f4823i)) {
            return true;
        }
        return false;
    }

    public static boolean m5250a(Uri uri, Uri uri2) {
        if (uri == null && uri2 == null) {
            return true;
        }
        if (uri != null && uri2 != null && uri.equals(uri2)) {
            return true;
        }
        Uri e = VideoServer.e(uri);
        Uri e2 = VideoServer.e(uri2);
        if (e == null || e2 == null || !e.equals(e2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{VideoServer.e(this.f4816b), VideoServer.e(this.f4817c), VideoServer.e(this.f4819e), this.f4820f, this.f4821g, this.f4822h, this.f4823i});
    }
}
