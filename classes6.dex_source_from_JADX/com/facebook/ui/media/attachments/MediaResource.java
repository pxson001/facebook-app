package com.facebook.ui.media.attachments;

import android.graphics.RectF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.ExifOrientation;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Comparator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: search_photos_grid_module */
public class MediaResource implements Parcelable {
    public static final Creator<MediaResource> CREATOR = new C03112();
    public static final Comparator<MediaResource> f5160a = new C03101();
    public static final RectF f5161b = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    public final long f5162A;
    public final boolean f5163B;
    public final boolean f5164C;
    public final String f5165D;
    public final Uri f5166c;
    public final Type f5167d;
    public final Source f5168e;
    @Nullable
    public final Uri f5169f;
    public final long f5170g;
    public final MediaResource f5171h;
    public final long f5172i;
    public final int f5173j;
    public final int f5174k;
    public final ExifOrientation f5175l;
    @Nullable
    public final String f5176m;
    @Nullable
    public final ThreadKey f5177n;
    @Nullable
    public final String f5178o;
    public final long f5179p;
    @Nullable
    public final RectF f5180q;
    public final boolean f5181r;
    public final int f5182s;
    public final int f5183t;
    public final String f5184u;
    public final boolean f5185v;
    public final ImmutableMap<String, String> f5186w;
    @Nullable
    public final ContentAppAttribution f5187x;
    public final Uri f5188y;
    public final boolean f5189z;

    /* compiled from: search_photos_grid_module */
    final class C03101 implements Comparator<MediaResource> {
        C03101() {
        }

        public final int compare(Object obj, Object obj2) {
            return Long.signum(((MediaResource) obj2).f5162A - ((MediaResource) obj).f5162A);
        }
    }

    /* compiled from: search_photos_grid_module */
    final class C03112 implements Creator<MediaResource> {
        C03112() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MediaResource(parcel);
        }

        public final Object[] newArray(int i) {
            return new MediaResource[i];
        }
    }

    /* compiled from: search_photos_grid_module */
    public enum Source {
        UNSPECIFIED("unspecified"),
        WEB_SEARCH("websearch"),
        MEDIA_PICKER("mediapicker"),
        CAMERA("camera"),
        AUDIO("audio"),
        VOICE_CLIP("voiceclip"),
        VIDEO("video"),
        TRIMMED_VIDEO("trimmedvideo"),
        SHARE("share"),
        SHARED_MEDIA("shared_media"),
        ATTACHED_MEDIA("attached_media"),
        FORWARD("forward"),
        GALLERY("gallery"),
        QUICKCAM_FRONT("quickcamfront"),
        QUICKCAM_BACK("quickcamback"),
        MEDIA_PICKER_GALLERY("mediapicker_gallery"),
        PAGE_SAVED_REPLY("page_saved_reply"),
        PHOTO_REMINDER("photo_reminder"),
        VIDEO_MMS("video_mms");
        
        private static final ImmutableMap<String, Source> VALUE_MAP = null;
        public final String DBSerialValue;

        static {
            Builder builder = ImmutableMap.builder();
            Source[] values = values();
            int length = values.length;
            int i;
            while (i < length) {
                Source source = values[i];
                builder.b(source.DBSerialValue, source);
                i++;
            }
            VALUE_MAP = builder.b();
        }

        private Source(String str) {
            this.DBSerialValue = str;
        }

        public static Source fromDBSerialValue(String str) {
            if (VALUE_MAP.containsKey(str)) {
                return (Source) VALUE_MAP.get(str);
            }
            throw new IllegalArgumentException("Unsupported Source: " + str);
        }

        public final boolean isQuickCamSource() {
            return this == QUICKCAM_BACK || this == QUICKCAM_FRONT;
        }

        public final boolean isMediaPickerSource() {
            return this == MEDIA_PICKER_GALLERY || this == MEDIA_PICKER;
        }
    }

    public static MediaResourceBuilder m7889a() {
        return new MediaResourceBuilder();
    }

    MediaResource(MediaResourceBuilder mediaResourceBuilder) {
        this.f5166c = (Uri) Preconditions.checkNotNull(mediaResourceBuilder.f5201a);
        this.f5167d = (Type) Preconditions.checkNotNull(mediaResourceBuilder.f5202b);
        this.f5168e = (Source) Preconditions.checkNotNull(mediaResourceBuilder.f5203c);
        this.f5169f = mediaResourceBuilder.f5204d;
        this.f5170g = mediaResourceBuilder.f5206f;
        this.f5171h = mediaResourceBuilder.f5205e;
        this.f5172i = mediaResourceBuilder.f5207g;
        this.f5173j = mediaResourceBuilder.f5208h;
        this.f5174k = mediaResourceBuilder.f5209i;
        this.f5175l = mediaResourceBuilder.f5210j;
        this.f5176m = mediaResourceBuilder.f5211k;
        this.f5177n = mediaResourceBuilder.f5212l;
        this.f5178o = mediaResourceBuilder.f5213m;
        this.f5179p = mediaResourceBuilder.f5214n;
        this.f5180q = mediaResourceBuilder.f5215o;
        this.f5181r = mediaResourceBuilder.f5216p;
        this.f5182s = mediaResourceBuilder.f5217q;
        this.f5183t = mediaResourceBuilder.f5218r;
        this.f5184u = mediaResourceBuilder.f5219s;
        this.f5185v = mediaResourceBuilder.f5220t;
        this.f5186w = ImmutableMap.copyOf(mediaResourceBuilder.f5221u);
        this.f5187x = mediaResourceBuilder.f5222v;
        this.f5188y = mediaResourceBuilder.f5223w;
        this.f5189z = mediaResourceBuilder.f5224x;
        this.f5162A = mediaResourceBuilder.f5225y;
        this.f5163B = mediaResourceBuilder.f5226z;
        this.f5164C = mediaResourceBuilder.f5199A;
        this.f5165D = mediaResourceBuilder.f5200B;
    }

    public MediaResource(Parcel parcel) {
        this.f5166c = (Uri) parcel.readParcelable(null);
        this.f5167d = Type.valueOf(parcel.readString());
        this.f5168e = Source.values()[parcel.readInt()];
        this.f5169f = (Uri) parcel.readParcelable(null);
        this.f5170g = parcel.readLong();
        this.f5171h = (MediaResource) parcel.readParcelable(MediaResource.class.getClassLoader());
        this.f5172i = parcel.readLong();
        this.f5173j = parcel.readInt();
        this.f5174k = parcel.readInt();
        this.f5175l = (ExifOrientation) parcel.readSerializable();
        this.f5176m = parcel.readString();
        this.f5177n = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f5178o = parcel.readString();
        this.f5179p = parcel.readLong();
        this.f5180q = (RectF) parcel.readParcelable(null);
        this.f5181r = parcel.readInt() != 0;
        this.f5182s = parcel.readInt();
        this.f5183t = parcel.readInt();
        this.f5184u = parcel.readString();
        this.f5185v = ParcelUtil.a(parcel);
        this.f5186w = ImmutableMap.copyOf(parcel.readHashMap(null));
        this.f5187x = (ContentAppAttribution) parcel.readParcelable(MediaResource.class.getClassLoader());
        this.f5188y = (Uri) parcel.readParcelable(null);
        this.f5189z = ParcelUtil.a(parcel);
        this.f5162A = parcel.readLong();
        this.f5163B = ParcelUtil.a(parcel);
        this.f5164C = ParcelUtil.a(parcel);
        this.f5165D = parcel.readString();
    }

    public final int m7890b() {
        long j;
        long j2 = this.f5172i;
        if (this.f5182s >= 0) {
            j = (long) this.f5182s;
        } else {
            j = 0;
        }
        if (this.f5183t >= 0) {
            j2 = (long) this.f5183t;
        }
        return (int) Math.min(Math.max(0, j2 - j), this.f5172i);
    }

    public final boolean m7891c() {
        return "image/gif".equals(this.f5178o) || "image/webp".equals(this.f5178o);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5166c, i);
        parcel.writeString(this.f5167d.name());
        parcel.writeInt(this.f5168e.ordinal());
        parcel.writeParcelable(this.f5169f, i);
        parcel.writeLong(this.f5170g);
        parcel.writeParcelable(this.f5171h, i);
        parcel.writeLong(this.f5172i);
        parcel.writeInt(this.f5173j);
        parcel.writeInt(this.f5174k);
        parcel.writeSerializable(this.f5175l);
        parcel.writeString(this.f5176m);
        parcel.writeParcelable(this.f5177n, i);
        parcel.writeString(this.f5178o);
        parcel.writeLong(this.f5179p);
        parcel.writeParcelable(this.f5180q, i);
        parcel.writeInt(this.f5181r ? 1 : 0);
        parcel.writeInt(this.f5182s);
        parcel.writeInt(this.f5183t);
        parcel.writeString(this.f5184u);
        ParcelUtil.a(parcel, this.f5185v);
        parcel.writeMap(this.f5186w);
        parcel.writeParcelable(this.f5187x, i);
        parcel.writeParcelable(this.f5188y, i);
        ParcelUtil.a(parcel, this.f5189z);
        parcel.writeLong(this.f5162A);
        ParcelUtil.a(parcel, this.f5163B);
        ParcelUtil.a(parcel, this.f5164C);
        parcel.writeString(this.f5165D);
    }
}
