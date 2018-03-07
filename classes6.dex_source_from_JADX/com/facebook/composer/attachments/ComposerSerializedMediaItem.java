package com.facebook.composer.attachments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerSerializedMediaItemDeserializer.class)
@JsonSerialize(using = ComposerSerializedMediaItemSerializer.class)
/* compiled from: place_picker_error_network_failure */
public class ComposerSerializedMediaItem implements Parcelable {
    public static final Creator<ComposerSerializedMediaItem> CREATOR = new C04611();
    @JsonProperty("photo_tags")
    final ImmutableList<PhotoTag> mPhotoTags;

    /* compiled from: place_picker_error_network_failure */
    final class C04611 implements Creator<ComposerSerializedMediaItem> {
        C04611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerSerializedMediaItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerSerializedMediaItem[i];
        }
    }

    @AutoGenJsonDeserializer
    @AutoGenJsonSerializer
    @JsonDeserialize(using = ComposerSerializedMediaItem_PhotoTagDeserializer.class)
    @JsonSerialize(using = ComposerSerializedMediaItem_PhotoTagSerializer.class)
    /* compiled from: place_picker_error_network_failure */
    final class PhotoTag implements Parcelable {
        public static final Creator<PhotoTag> CREATOR = new C04621();
        @JsonProperty("box_bottom")
        public final float boxBottom;
        @JsonProperty("box_left")
        public final float boxLeft;
        @JsonProperty("box_right")
        public final float boxRight;
        @JsonProperty("box_top")
        public final float boxTop;
        @JsonProperty("created")
        public final long created;
        @JsonProperty("first_name")
        public final String firstName;
        @JsonProperty("is_auto_tag")
        public final boolean isAutoTag;
        @JsonProperty("tagged_id")
        public final long taggedId;
        @JsonProperty("tagging_profile_type")
        public final Type taggingProfileType;
        @JsonProperty("text")
        public final String text;

        /* compiled from: place_picker_error_network_failure */
        final class C04621 implements Creator<PhotoTag> {
            C04621() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new PhotoTag(parcel);
            }

            public final Object[] newArray(int i) {
                return new PhotoTag[i];
            }
        }

        private PhotoTag() {
            this(0, 0.0f, 0.0f, 0.0f, 0.0f, Type.UNKNOWN, false, 0, "", "");
        }

        PhotoTag(long j, float f, float f2, float f3, float f4, Type type, boolean z, long j2, String str, String str2) {
            this.taggedId = j;
            this.boxLeft = f;
            this.boxTop = f2;
            this.boxRight = f3;
            this.boxBottom = f4;
            this.taggingProfileType = type;
            this.isAutoTag = z;
            this.created = j2;
            this.text = str;
            this.firstName = str2;
        }

        @JsonIgnore
        public PhotoTag(Parcel parcel) {
            this.taggedId = parcel.readLong();
            this.boxLeft = parcel.readFloat();
            this.boxTop = parcel.readFloat();
            this.boxRight = parcel.readFloat();
            this.boxBottom = parcel.readFloat();
            this.taggingProfileType = (Type) ParcelUtil.c(parcel, Type.class);
            this.isAutoTag = ParcelUtil.a(parcel);
            this.created = parcel.readLong();
            this.text = parcel.readString();
            this.firstName = parcel.readString();
        }

        @JsonIgnore
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.taggedId);
            parcel.writeFloat(this.boxLeft);
            parcel.writeFloat(this.boxTop);
            parcel.writeFloat(this.boxRight);
            parcel.writeFloat(this.boxBottom);
            ParcelUtil.a(parcel, this.taggingProfileType);
            ParcelUtil.a(parcel, this.isAutoTag);
            parcel.writeLong(this.created);
            parcel.writeString(this.text);
            parcel.writeString(this.firstName);
        }

        @JsonIgnore
        public final int describeContents() {
            return 0;
        }
    }

    static ComposerSerializedMediaItem m11238a(@Nullable ImmutableList<PhotoTag> immutableList) {
        if (immutableList == null) {
            immutableList = RegularImmutableList.a;
        }
        return new ComposerSerializedMediaItem(r2);
    }

    private ComposerSerializedMediaItem(ImmutableList<PhotoTag> immutableList) {
        this.mPhotoTags = (ImmutableList) Preconditions.checkNotNull(immutableList);
    }

    public ComposerSerializedMediaItem(Parcel parcel) {
        this.mPhotoTags = ParcelUtil.a(parcel, PhotoTag.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.mPhotoTags);
    }

    public int describeContents() {
        return 0;
    }

    private ComposerSerializedMediaItem() {
        this(RegularImmutableList.a);
    }
}
