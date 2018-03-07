package com.facebook.ipc.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;

@AutoGenJsonSerializer
@JsonDeserialize(using = Deserializer.class)
@JsonSerialize(using = ProductItemLocationPickerSettingsSerializer.class)
/* compiled from: TIMELINE_ESCAPE_HATCH */
public class ProductItemLocationPickerSettings implements Parcelable {
    public static final Creator<ProductItemLocationPickerSettings> CREATOR = new C13391();
    private final boolean f14025a;
    private final boolean f14026b;
    private final boolean f14027c;

    /* compiled from: TIMELINE_ESCAPE_HATCH */
    final class C13391 implements Creator<ProductItemLocationPickerSettings> {
        C13391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProductItemLocationPickerSettings(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProductItemLocationPickerSettings[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = ProductItemLocationPickerSettings_BuilderDeserializer.class)
    /* compiled from: TIMELINE_ESCAPE_HATCH */
    public class Builder {
        public boolean f14021a;
        public boolean f14022b;
        public boolean f14023c;

        public final ProductItemLocationPickerSettings m23403a() {
            return new ProductItemLocationPickerSettings(this);
        }

        @JsonProperty("is_compulsory")
        public Builder setIsCompulsory(boolean z) {
            this.f14021a = z;
            return this;
        }

        @JsonProperty("use_neighborhood_data_source")
        public Builder setUseNeighborhoodDataSource(boolean z) {
            this.f14022b = z;
            return this;
        }

        @JsonProperty("use_zip_code")
        public Builder setUseZipCode(boolean z) {
            this.f14023c = z;
            return this;
        }
    }

    /* compiled from: TIMELINE_ESCAPE_HATCH */
    class Deserializer extends JsonDeserializer<ProductItemLocationPickerSettings> {
        private static final ProductItemLocationPickerSettings_BuilderDeserializer f14024a = new ProductItemLocationPickerSettings_BuilderDeserializer();

        private Deserializer() {
        }

        public Object m23404a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return ((Builder) f14024a.a(jsonParser, deserializationContext)).m23403a();
        }
    }

    public ProductItemLocationPickerSettings(Builder builder) {
        this.f14025a = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f14021a))).booleanValue();
        this.f14026b = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f14022b))).booleanValue();
        this.f14027c = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f14023c))).booleanValue();
    }

    public ProductItemLocationPickerSettings(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f14025a = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f14026b = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f14027c = z2;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        if (this.f14025a) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f14026b) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f14027c) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }

    public int describeContents() {
        return 0;
    }

    @JsonProperty("is_compulsory")
    public boolean getIsCompulsory() {
        return this.f14025a;
    }

    @JsonProperty("use_neighborhood_data_source")
    public boolean getUseNeighborhoodDataSource() {
        return this.f14026b;
    }

    @JsonProperty("use_zip_code")
    public boolean getUseZipCode() {
        return this.f14027c;
    }
}
