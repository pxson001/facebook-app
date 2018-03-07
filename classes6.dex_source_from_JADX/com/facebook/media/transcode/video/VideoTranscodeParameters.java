package com.facebook.media.transcode.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.media.transcode.MediaTranscodeParameters;
import com.facebook.videocodec.base.VideoOperationProgressListener;

/* compiled from: keyword_render_type */
public class VideoTranscodeParameters extends MediaTranscodeParameters {
    public static final Creator<VideoTranscodeParameters> CREATOR = new C07561();
    public boolean f11876a;
    public int f11877b;
    public VideoEditConfig f11878c;
    public VideoOperationProgressListener f11879d;

    /* compiled from: keyword_render_type */
    final class C07561 implements Creator<VideoTranscodeParameters> {
        C07561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoTranscodeParameters(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoTranscodeParameters[i];
        }
    }

    public VideoTranscodeParameters(Parcel parcel) {
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f11876a = z;
        this.f11877b = parcel.readInt();
        this.f11878c = (VideoEditConfig) parcel.readParcelable(VideoEditConfig.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        if (this.f11876a) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.f11877b);
        parcel.writeParcelable(this.f11878c, 0);
    }
}
