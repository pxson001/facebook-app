package com.facebook.ipc.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerTaggedUserDeserializer.class)
@JsonSerialize(using = ComposerTaggedUserSerializer.class)
/* compiled from: TIP */
public class ComposerTaggedUser implements Parcelable {
    public static final Creator<ComposerTaggedUser> CREATOR = new C13341();
    @JsonProperty("id")
    final long mId;
    @JsonProperty("image_url")
    @Nullable
    final String mImageUrl;
    @JsonProperty("name")
    @Nullable
    final String mName;

    /* compiled from: TIP */
    final class C13341 implements Creator<ComposerTaggedUser> {
        C13341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerTaggedUser(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerTaggedUser[i];
        }
    }

    /* compiled from: TIP */
    public class Builder {
        public final long f13974a;
        @Nullable
        public String f13975b;
        @Nullable
        public String f13976c;

        public Builder(long j) {
            this.f13974a = j;
        }

        public final Builder m23356a(@Nullable String str) {
            this.f13975b = str;
            return this;
        }

        public final Builder m23358b(@Nullable String str) {
            this.f13976c = str;
            return this;
        }

        public final ComposerTaggedUser m23357a() {
            return new ComposerTaggedUser(this);
        }
    }

    /* compiled from: TIP */
    public interface ProvidesTaggedUsers {
        ImmutableList<ComposerTaggedUser> m23359h();
    }

    public static Builder m23360a(long j) {
        return new Builder(j);
    }

    private ComposerTaggedUser() {
        this(new Builder(0));
    }

    public ComposerTaggedUser(Builder builder) {
        this.mId = builder.f13974a;
        this.mName = builder.f13975b;
        this.mImageUrl = builder.f13976c;
    }

    public ComposerTaggedUser(Parcel parcel) {
        this.mId = parcel.readLong();
        this.mName = parcel.readString();
        this.mImageUrl = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mImageUrl);
    }

    public int describeContents() {
        return 0;
    }

    public final long m23361a() {
        return this.mId;
    }

    @Nullable
    public final String m23362b() {
        return this.mName;
    }

    @Nullable
    public final String m23363c() {
        return this.mImageUrl;
    }
}
