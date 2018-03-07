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
import com.google.common.base.Strings;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = TextParamsDeserializer.class)
@JsonSerialize(using = TextParamsSerializer.class)
/* compiled from: suppress_failure_notification */
public class TextParams implements Parcelable, UriAwarePhotoOverlayItem {
    public static final Creator<TextParams> CREATOR = new C02171();
    @JsonProperty("height")
    final float heightPercentage;
    @JsonProperty("id")
    private final String id;
    @JsonProperty("isFrameItem")
    final boolean isFrameItem;
    @JsonProperty("isSelectable")
    final boolean isSelectable;
    @JsonProperty("left")
    final float leftPercentage;
    @JsonProperty("rotation_degrees")
    final float rotateDegrees;
    @JsonProperty("text_color")
    final int textColor;
    @JsonProperty("text_string")
    final String textString;
    @JsonProperty("top")
    final float topPercentage;
    @JsonProperty("uri")
    final String uri;
    @JsonProperty("width")
    final float widthPercentage;

    /* compiled from: suppress_failure_notification */
    final class C02171 implements Creator<TextParams> {
        C02171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TextParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new TextParams[i];
        }
    }

    /* compiled from: suppress_failure_notification */
    public class Builder implements PhotoOverlayItemBuilder {
        public String f3527a = null;
        public Uri f3528b = null;
        public float f3529c = 0.0f;
        public float f3530d = 0.0f;
        public float f3531e = 0.0f;
        public float f3532f = 0.0f;
        public float f3533g = 0.0f;
        public int f3534h = 0;
        public String f3535i;
        public boolean f3536j = true;
        public boolean f3537k = false;

        public final /* synthetic */ UriAwarePhotoOverlayItem mo214b() {
            return m4715a();
        }

        public Builder(String str, Uri uri) {
            this.f3527a = str;
            this.f3528b = uri;
        }

        public Builder(TextParams textParams) {
            this.f3527a = textParams.textString;
            this.f3528b = textParams.mo225d();
            this.f3529c = textParams.leftPercentage;
            this.f3530d = textParams.topPercentage;
            this.f3531e = textParams.widthPercentage;
            this.f3532f = textParams.heightPercentage;
            this.f3533g = textParams.rotateDegrees;
            this.f3534h = textParams.textColor;
            this.f3536j = textParams.isSelectable;
            this.f3537k = textParams.mo231j();
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo218i(float f) {
            this.f3529c = f;
            return this;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo217h(float f) {
            this.f3530d = f;
            return this;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo216g(float f) {
            this.f3531e = f;
            return this;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo215f(float f) {
            this.f3532f = f;
            return this;
        }

        public final /* synthetic */ PhotoOverlayItemBuilder mo219j(float f) {
            this.f3533g = f;
            return this;
        }

        public final PhotoOverlayItemBuilder mo213a(boolean z) {
            return this;
        }

        public final TextParams m4715a() {
            if (Strings.isNullOrEmpty(this.f3535i)) {
                this.f3535i = SafeUUIDGenerator.a().toString();
            }
            return new TextParams(this);
        }
    }

    private TextParams() {
        this.id = null;
        this.uri = null;
        this.textString = null;
        this.leftPercentage = 0.0f;
        this.topPercentage = 0.0f;
        this.widthPercentage = 0.0f;
        this.heightPercentage = 0.0f;
        this.rotateDegrees = 0.0f;
        this.textColor = 0;
        this.isSelectable = true;
        this.isFrameItem = false;
    }

    public TextParams(Builder builder) {
        this.id = builder.f3535i;
        this.uri = builder.f3528b.toString();
        this.textString = builder.f3527a;
        this.leftPercentage = builder.f3529c;
        this.topPercentage = builder.f3530d;
        this.widthPercentage = builder.f3531e;
        this.heightPercentage = builder.f3532f;
        this.rotateDegrees = builder.f3533g;
        this.textColor = builder.f3534h;
        this.isSelectable = builder.f3536j;
        this.isFrameItem = builder.f3537k;
    }

    public TextParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.id = parcel.readString();
        this.uri = parcel.readString();
        this.textString = parcel.readString();
        this.leftPercentage = parcel.readFloat();
        this.topPercentage = parcel.readFloat();
        this.widthPercentage = parcel.readFloat();
        this.heightPercentage = parcel.readFloat();
        this.rotateDegrees = parcel.readFloat();
        this.textColor = parcel.readInt();
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

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.id);
        parcel.writeString(this.uri);
        parcel.writeString(this.textString);
        parcel.writeFloat(this.leftPercentage);
        parcel.writeFloat(this.topPercentage);
        parcel.writeFloat(this.widthPercentage);
        parcel.writeFloat(this.heightPercentage);
        parcel.writeFloat(this.rotateDegrees);
        parcel.writeInt(this.textColor);
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

    @JsonIgnore
    public final String m4736l() {
        return this.textString;
    }

    @JsonIgnore
    public final int m4737m() {
        return this.textColor;
    }

    public final float m4738n() {
        return this.leftPercentage;
    }

    public final float m4739o() {
        return this.topPercentage;
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

    public final boolean mo229h() {
        return false;
    }

    public final boolean mo230i() {
        return false;
    }

    public final boolean mo232k() {
        return this.isSelectable;
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

    public final PhotoOverlayItem mo222a(RectF rectF, PointF pointF, float f) {
        Builder builder = new Builder(this.textString, mo225d());
        builder.f3529c = rectF.left;
        builder = builder;
        builder.f3530d = rectF.top;
        builder = builder;
        builder.f3531e = rectF.width();
        builder = builder;
        builder.f3532f = rectF.height();
        builder = builder;
        builder.f3533g = f;
        builder = builder;
        builder.f3534h = this.textColor;
        builder = builder;
        builder.f3535i = this.id;
        builder = builder;
        builder.f3537k = this.isFrameItem;
        return builder.m4715a();
    }

    public final String mo228g() {
        return this.id;
    }

    @JsonIgnore
    private static boolean m4722a(float f, float f2) {
        return ((double) Math.abs(f - f2)) < 0.001d;
    }

    @JsonIgnore
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextParams)) {
            return false;
        }
        TextParams textParams = (TextParams) obj;
        if (m4722a(this.leftPercentage, textParams.leftPercentage) && m4722a(this.topPercentage, textParams.topPercentage) && m4722a(this.widthPercentage, textParams.widthPercentage) && m4722a(this.heightPercentage, textParams.heightPercentage) && m4722a(this.rotateDegrees, textParams.rotateDegrees) && this.id.equals(textParams.id) && this.textColor == textParams.textColor && m4736l().equals(textParams.m4736l()) && mo225d().equals(textParams.mo225d())) {
            return true;
        }
        return false;
    }

    @JsonIgnore
    public int hashCode() {
        return ((((((((((((Float.floatToIntBits(this.leftPercentage) + 527) * 31) + Float.floatToIntBits(this.topPercentage)) * 31) + Float.floatToIntBits(this.widthPercentage)) * 31) + Float.floatToIntBits(this.heightPercentage)) * 31) + Float.floatToIntBits(this.rotateDegrees)) * 31) + this.textString.hashCode()) * 31) + this.uri.hashCode();
    }
}
