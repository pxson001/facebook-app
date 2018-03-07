package com.facebook.photos.creativeediting.model;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.facebook.photos.creativeediting.model.PhotoOverlayItemFactory.PhotoOverlayItemBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = StickerParamsDeserializer.class)
@JsonSerialize(using = StickerParamsSerializer.class)
/* compiled from: survey_flow */
public class StickerParams implements Parcelable, UriAwarePhotoOverlayItem {
    @JsonIgnore
    public static final Creator<StickerParams> CREATOR = new C02151();
    @JsonProperty("height")
    private final float heightPercentage;
    @JsonProperty("id")
    private final String id;
    @JsonProperty("isFlipped")
    private final boolean isFlipped;
    @JsonProperty("isFrameItem")
    private final boolean isFrameItem;
    @JsonProperty("isSelectable")
    private final boolean isSelectable;
    @JsonProperty("left")
    private final float leftPercentage;
    @JsonProperty("rotation_degrees")
    private final float rotateDegrees;
    @JsonProperty("sticker_uri")
    @Nullable
    private final String stickerUri;
    @JsonProperty("top")
    private final float topPercentage;
    @JsonProperty("uniqueId")
    public final String uniqueId;
    @JsonProperty("width")
    private final float widthPercentage;

    /* compiled from: survey_flow */
    final class C02151 implements Creator<StickerParams> {
        C02151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new StickerParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new StickerParams[i];
        }
    }

    /* compiled from: survey_flow */
    public class Builder implements PhotoOverlayItemBuilder {
        @Nullable
        public final Uri f3502a;
        public String f3503b;
        public String f3504c;
        public float f3505d;
        public float f3506e;
        public float f3507f;
        public float f3508g;
        public float f3509h;
        public boolean f3510i;
        public boolean f3511j;
        public boolean f3512k;

        public final /* synthetic */ UriAwarePhotoOverlayItem mo214b() {
            return m4675a();
        }

        public Builder() {
            this.f3505d = 0.0f;
            this.f3506e = 0.0f;
            this.f3507f = 0.0f;
            this.f3508g = 0.0f;
            this.f3509h = 0.0f;
            this.f3512k = false;
            this.f3502a = null;
            this.f3503b = null;
            this.f3504c = null;
            this.f3510i = false;
            this.f3511j = true;
        }

        public Builder(Uri uri, String str) {
            this.f3505d = 0.0f;
            this.f3506e = 0.0f;
            this.f3507f = 0.0f;
            this.f3508g = 0.0f;
            this.f3509h = 0.0f;
            this.f3512k = false;
            this.f3502a = uri;
            this.f3503b = str;
            this.f3504c = null;
            this.f3510i = false;
            this.f3511j = true;
        }

        public Builder(StickerParams stickerParams) {
            this.f3505d = 0.0f;
            this.f3506e = 0.0f;
            this.f3507f = 0.0f;
            this.f3508g = 0.0f;
            this.f3509h = 0.0f;
            this.f3512k = false;
            this.f3502a = stickerParams.mo225d();
            this.f3503b = stickerParams.mo228g();
            this.f3504c = stickerParams.uniqueId;
            this.f3505d = stickerParams.mo224c();
            this.f3506e = stickerParams.m4699n();
            this.f3507f = stickerParams.m4700o();
            this.f3508g = stickerParams.mo226e();
            this.f3509h = stickerParams.mo227f();
            this.f3510i = stickerParams.mo229h();
            this.f3511j = stickerParams.mo232k();
            this.f3512k = stickerParams.mo231j();
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo219j(float f) {
            this.f3505d = f;
            return this;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo218i(float f) {
            this.f3506e = f;
            return this;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo217h(float f) {
            this.f3507f = f;
            return this;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo216g(float f) {
            this.f3508g = f;
            return this;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo215f(float f) {
            this.f3509h = f;
            return this;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo213a(boolean z) {
            this.f3510i = z;
            return this;
        }

        public final StickerParams m4675a() {
            if (Strings.isNullOrEmpty(this.f3504c)) {
                this.f3504c = SafeUUIDGenerator.a().toString();
            }
            return new StickerParams(this);
        }
    }

    private StickerParams() {
        this(new Builder());
    }

    public StickerParams(Builder builder) {
        this.id = builder.f3503b;
        this.uniqueId = builder.f3504c;
        this.rotateDegrees = builder.f3505d;
        this.stickerUri = builder.f3502a != null ? builder.f3502a.toString() : null;
        this.leftPercentage = builder.f3506e;
        this.topPercentage = builder.f3507f;
        this.widthPercentage = builder.f3508g;
        this.heightPercentage = builder.f3509h;
        this.isFlipped = builder.f3510i;
        this.isSelectable = builder.f3511j;
        this.isFrameItem = builder.f3512k;
    }

    public StickerParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.id = parcel.readString();
        this.uniqueId = parcel.readString();
        this.rotateDegrees = parcel.readFloat();
        this.stickerUri = parcel.readString();
        this.leftPercentage = parcel.readFloat();
        this.topPercentage = parcel.readFloat();
        this.widthPercentage = parcel.readFloat();
        this.heightPercentage = parcel.readFloat();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.isFlipped = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.isSelectable = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.isFrameItem = z2;
    }

    public final String mo228g() {
        return this.id;
    }

    @JsonIgnore
    @Nullable
    public final String m4697l() {
        return this.stickerUri;
    }

    @JsonIgnore
    public final String m4698m() {
        return this.uniqueId;
    }

    public final float m4699n() {
        return this.leftPercentage;
    }

    public final float m4700o() {
        return this.topPercentage;
    }

    public final float mo226e() {
        return this.widthPercentage;
    }

    public final float mo227f() {
        return this.heightPercentage;
    }

    @Nullable
    public final Uri mo225d() {
        if (this.stickerUri == null) {
            return null;
        }
        return Uri.parse(this.stickerUri);
    }

    public final boolean mo229h() {
        return this.isFlipped;
    }

    public final boolean mo232k() {
        return this.isSelectable;
    }

    public final boolean mo230i() {
        return true;
    }

    public final boolean mo231j() {
        return this.isFrameItem;
    }

    @JsonIgnore
    public final Rect mo220a(Rect rect) {
        int width = ((int) (this.leftPercentage * ((float) rect.width()))) + rect.left;
        int height = ((int) (this.topPercentage * ((float) rect.height()))) + rect.top;
        return new Rect(width, height, ((int) (this.widthPercentage * ((float) rect.width()))) + width, ((int) (this.heightPercentage * ((float) rect.height()))) + height);
    }

    @JsonIgnore
    private static boolean m4682a(float f, float f2) {
        return ((double) Math.abs(f - f2)) < 0.001d;
    }

    @JsonIgnore
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StickerParams)) {
            return false;
        }
        StickerParams stickerParams = (StickerParams) obj;
        if (m4686a(stickerParams) && this.uniqueId.equals(stickerParams.uniqueId)) {
            return true;
        }
        return false;
    }

    @JsonIgnore
    public final boolean m4686a(StickerParams stickerParams) {
        return m4682a(this.leftPercentage, stickerParams.leftPercentage) && m4682a(this.topPercentage, stickerParams.topPercentage) && m4682a(this.widthPercentage, stickerParams.widthPercentage) && m4682a(this.heightPercentage, stickerParams.heightPercentage) && m4682a(this.rotateDegrees, stickerParams.rotateDegrees) && Objects.equal(m4697l(), stickerParams.m4697l()) && Objects.equal(mo228g(), stickerParams.mo228g()) && this.isFlipped == stickerParams.isFlipped;
    }

    @JsonIgnore
    public int hashCode() {
        int floatToIntBits = ((((((((Float.floatToIntBits(this.leftPercentage) + 527) * 31) + Float.floatToIntBits(this.topPercentage)) * 31) + Float.floatToIntBits(this.widthPercentage)) * 31) + Float.floatToIntBits(this.heightPercentage)) * 31) + Float.floatToIntBits(this.rotateDegrees);
        if (this.stickerUri != null) {
            floatToIntBits = (floatToIntBits * 31) + this.stickerUri.hashCode();
        }
        return (this.isFlipped ? 1231 : 1237) + (((((floatToIntBits * 31) + this.id.hashCode()) * 31) + this.uniqueId.hashCode()) * 31);
    }

    @JsonIgnore
    public int describeContents() {
        return 0;
    }

    @JsonIgnore
    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.id);
        parcel.writeString(this.uniqueId);
        parcel.writeFloat(this.rotateDegrees);
        parcel.writeString(this.stickerUri);
        parcel.writeFloat(this.leftPercentage);
        parcel.writeFloat(this.topPercentage);
        parcel.writeFloat(this.widthPercentage);
        parcel.writeFloat(this.heightPercentage);
        if (this.isFlipped) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.isSelectable) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.isFrameItem) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }

    public final RectF mo221a() {
        return new RectF(this.leftPercentage, this.topPercentage, this.leftPercentage + this.widthPercentage, this.topPercentage + this.heightPercentage);
    }

    public final PointF mo223b() {
        return new PointF(this.leftPercentage + (this.widthPercentage / 2.0f), this.topPercentage + (this.heightPercentage / 2.0f));
    }

    public final float mo224c() {
        return this.rotateDegrees;
    }

    public final PhotoOverlayItem mo222a(RectF rectF, PointF pointF, float f) {
        Builder builder = new Builder(mo225d(), mo228g());
        builder.f3506e = rectF.left;
        builder = builder;
        builder.f3507f = rectF.top;
        builder = builder;
        builder.f3508g = rectF.width();
        builder = builder;
        builder.f3509h = rectF.height();
        builder = builder;
        builder.f3505d = f;
        builder = builder;
        builder.f3510i = this.isFlipped;
        builder = builder;
        builder.f3512k = this.isFrameItem;
        return builder.m4675a();
    }
}
