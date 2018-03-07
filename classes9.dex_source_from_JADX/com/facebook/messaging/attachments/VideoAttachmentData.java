package com.facebook.messaging.attachments;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.messaging.model.attachment.VideoData.Source;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.video.engine.VideoDataSource;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: p2p_cancel_add_card */
public class VideoAttachmentData implements Parcelable, DownloadableAttachment {
    public static final Creator<VideoAttachmentData> CREATOR = new C08581();
    public final int f7764a;
    public final int f7765b;
    public final int f7766c;
    public final int f7767d;
    public final int f7768e;
    public final List<VideoDataSource> f7769f;
    public final Uri f7770g;
    public final Source f7771h;
    public final String f7772i;
    public final MediaResource f7773j;
    public final int f7774k;
    public final int f7775l;
    public final AttachmentType f7776m;

    /* compiled from: p2p_cancel_add_card */
    final class C08581 implements Creator<VideoAttachmentData> {
        C08581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoAttachmentData(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoAttachmentData[i];
        }
    }

    /* compiled from: p2p_cancel_add_card */
    public enum AttachmentType {
        MESSAGE_ATTACHMENT,
        FACEBOOK_STORY_ATTACHMENT
    }

    public static VideoAttachmentDataBuilder newBuilder() {
        return new VideoAttachmentDataBuilder();
    }

    VideoAttachmentData(VideoAttachmentDataBuilder videoAttachmentDataBuilder) {
        this.f7764a = videoAttachmentDataBuilder.f7778b;
        this.f7765b = videoAttachmentDataBuilder.f7779c;
        this.f7766c = videoAttachmentDataBuilder.f7780d;
        this.f7767d = videoAttachmentDataBuilder.f7781e;
        this.f7768e = videoAttachmentDataBuilder.f7782f;
        this.f7769f = videoAttachmentDataBuilder.f7783g;
        this.f7770g = videoAttachmentDataBuilder.f7784h;
        this.f7771h = videoAttachmentDataBuilder.f7785i;
        this.f7772i = videoAttachmentDataBuilder.f7786j;
        this.f7773j = videoAttachmentDataBuilder.f7787k;
        this.f7774k = videoAttachmentDataBuilder.f7788l;
        this.f7775l = videoAttachmentDataBuilder.f7789m;
        this.f7776m = videoAttachmentDataBuilder.f7777a;
    }

    public final boolean mo286a() {
        if (this.f7776m == AttachmentType.FACEBOOK_STORY_ATTACHMENT) {
            return false;
        }
        for (VideoDataSource videoDataSource : this.f7769f) {
            if (FacebookUriUtil.f(videoDataSource.b)) {
                return true;
            }
        }
        return false;
    }

    public VideoAttachmentData(Parcel parcel) {
        this.f7764a = parcel.readInt();
        this.f7765b = parcel.readInt();
        this.f7766c = parcel.readInt();
        this.f7767d = parcel.readInt();
        this.f7768e = parcel.readInt();
        this.f7769f = parcel.readArrayList(VideoDataSource.class.getClassLoader());
        this.f7770g = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f7771h = Source.valueOf(parcel.readString());
        this.f7772i = parcel.readString();
        this.f7773j = (MediaResource) parcel.readParcelable(MediaResource.class.getClassLoader());
        this.f7774k = parcel.readInt();
        this.f7775l = parcel.readInt();
        this.f7776m = (AttachmentType) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7764a);
        parcel.writeInt(this.f7765b);
        parcel.writeInt(this.f7766c);
        parcel.writeInt(this.f7767d);
        parcel.writeInt(this.f7768e);
        parcel.writeList(this.f7769f);
        parcel.writeParcelable(this.f7770g, i);
        parcel.writeString(this.f7771h.name());
        parcel.writeString(this.f7772i);
        parcel.writeParcelable(this.f7773j, i);
        parcel.writeInt(this.f7774k);
        parcel.writeInt(this.f7775l);
        parcel.writeSerializable(this.f7776m);
    }
}
