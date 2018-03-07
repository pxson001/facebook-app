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

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = DoodleParamsDeserializer.class)
@JsonSerialize(using = DoodleParamsSerializer.class)
/* compiled from: system_tray_tag */
public class DoodleParams implements Parcelable, UriAwarePhotoOverlayItem {
    public static final Creator<DoodleParams> CREATOR = new C02141();
    @JsonProperty("height")
    final float heightPercentage;
    @JsonProperty("id")
    private final String id;
    @JsonProperty("left")
    final float leftPercentage;
    @JsonProperty("rotation_degrees")
    final float rotateDegrees;
    @JsonProperty("top")
    final float topPercentage;
    @JsonProperty("uri")
    final String uri;
    @JsonProperty("width")
    final float widthPercentage;

    /* compiled from: system_tray_tag */
    final class C02141 implements Creator<DoodleParams> {
        C02141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DoodleParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DoodleParams[i];
        }
    }

    /* compiled from: system_tray_tag */
    public class Builder implements PhotoOverlayItemBuilder {
        public Uri f3383a = null;
        public float f3384b = 0.0f;
        public float f3385c = 0.0f;
        public float f3386d = 0.0f;
        public float f3387e = 0.0f;
        public float f3388f = 0.0f;
        public String f3389g;

        public final /* synthetic */ UriAwarePhotoOverlayItem mo214b() {
            return m4467a();
        }

        public Builder(Uri uri) {
            this.f3383a = uri;
        }

        public Builder(DoodleParams doodleParams) {
            this.f3383a = doodleParams.mo225d();
            this.f3384b = doodleParams.leftPercentage;
            this.f3385c = doodleParams.topPercentage;
            this.f3386d = doodleParams.widthPercentage;
            this.f3387e = doodleParams.heightPercentage;
            this.f3388f = doodleParams.rotateDegrees;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo218i(float f) {
            this.f3384b = f;
            return this;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo217h(float f) {
            this.f3385c = f;
            return this;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo216g(float f) {
            this.f3386d = f;
            return this;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo215f(float f) {
            this.f3387e = f;
            return this;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo219j(float f) {
            this.f3388f = f;
            return this;
        }

        public final PhotoOverlayItemBuilder mo213a(boolean z) {
            return this;
        }

        public final DoodleParams m4467a() {
            if (Strings.isNullOrEmpty(this.f3389g)) {
                this.f3389g = SafeUUIDGenerator.a().toString();
            }
            return new DoodleParams(this);
        }
    }

    private DoodleParams() {
        this.id = null;
        this.uri = null;
        this.leftPercentage = 0.0f;
        this.topPercentage = 0.0f;
        this.widthPercentage = 0.0f;
        this.heightPercentage = 0.0f;
        this.rotateDegrees = 0.0f;
    }

    public DoodleParams(Builder builder) {
        this.id = builder.f3389g;
        this.uri = builder.f3383a.toString();
        this.leftPercentage = builder.f3384b;
        this.topPercentage = builder.f3385c;
        this.widthPercentage = builder.f3386d;
        this.heightPercentage = builder.f3387e;
        this.rotateDegrees = builder.f3388f;
    }

    public DoodleParams(Parcel parcel) {
        this.id = parcel.readString();
        this.uri = parcel.readString();
        this.leftPercentage = parcel.readFloat();
        this.topPercentage = parcel.readFloat();
        this.widthPercentage = parcel.readFloat();
        this.heightPercentage = parcel.readFloat();
        this.rotateDegrees = parcel.readFloat();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.uri);
        parcel.writeFloat(this.leftPercentage);
        parcel.writeFloat(this.topPercentage);
        parcel.writeFloat(this.widthPercentage);
        parcel.writeFloat(this.heightPercentage);
        parcel.writeFloat(this.rotateDegrees);
    }

    public final RectF mo221a() {
        return new RectF(this.leftPercentage, this.topPercentage, this.leftPercentage + this.widthPercentage, this.topPercentage + this.heightPercentage);
    }

    public final PointF mo223b() {
        return new PointF(this.leftPercentage + (this.widthPercentage / 2.0f), this.topPercentage + (this.heightPercentage / 2.0f));
    }

    public final float mo226e() {
        return this.widthPercentage;
    }

    public final float mo227f() {
        return this.heightPercentage;
    }

    public final Uri mo225d() {
        return Uri.parse(this.uri);
    }

    public final float mo224c() {
        return this.rotateDegrees;
    }

    public final boolean mo230i() {
        return false;
    }

    public final boolean mo229h() {
        return false;
    }

    public final boolean mo232k() {
        return false;
    }

    public final boolean mo231j() {
        return false;
    }

    @JsonIgnore
    public final Rect mo220a(Rect rect) {
        int width = ((int) (this.leftPercentage * ((float) rect.width()))) + rect.left;
        int height = ((int) (this.topPercentage * ((float) rect.height()))) + rect.top;
        return new Rect(width, height, ((int) (this.widthPercentage * ((float) rect.width()))) + width, ((int) (this.heightPercentage * ((float) rect.height()))) + height);
    }

    public final PhotoOverlayItem mo222a(RectF rectF, PointF pointF, float f) {
        Builder builder = new Builder(mo225d());
        builder.f3384b = rectF.left;
        builder = builder;
        builder.f3385c = rectF.top;
        builder = builder;
        builder.f3386d = rectF.width();
        builder = builder;
        builder.f3387e = rectF.height();
        builder = builder;
        builder.f3388f = f;
        builder = builder;
        builder.f3389g = this.id;
        return builder.m4467a();
    }

    public final String mo228g() {
        return this.id;
    }

    @JsonIgnore
    private static boolean m4475a(float f, float f2) {
        return ((double) Math.abs(f - f2)) < 0.001d;
    }

    @JsonIgnore
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DoodleParams)) {
            return false;
        }
        DoodleParams doodleParams = (DoodleParams) obj;
        if (m4475a(this.leftPercentage, doodleParams.leftPercentage) && m4475a(this.topPercentage, doodleParams.topPercentage) && m4475a(this.widthPercentage, doodleParams.widthPercentage) && m4475a(this.heightPercentage, doodleParams.heightPercentage) && m4475a(this.rotateDegrees, doodleParams.rotateDegrees) && Objects.equal(this.id, doodleParams.id) && Objects.equal(this.uri, doodleParams.uri)) {
            return true;
        }
        return false;
    }

    @JsonIgnore
    public int hashCode() {
        return ((((((((((((this.id.hashCode() + 527) * 31) + this.uri.hashCode()) * 31) + Float.floatToIntBits(this.leftPercentage)) * 31) + Float.floatToIntBits(this.topPercentage)) * 31) + Float.floatToIntBits(this.widthPercentage)) * 31) + Float.floatToIntBits(this.heightPercentage)) * 31) + Float.floatToIntBits(this.rotateDegrees);
    }
}
