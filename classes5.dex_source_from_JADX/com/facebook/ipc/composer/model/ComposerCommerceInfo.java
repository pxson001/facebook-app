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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

@AutoGenJsonSerializer
@JsonDeserialize(using = Deserializer.class)
@JsonSerialize(using = ComposerCommerceInfoSerializer.class)
/* compiled from: TOOLS_SERVICE */
public class ComposerCommerceInfo implements Parcelable {
    public static final Creator<ComposerCommerceInfo> CREATOR = new C13251();
    @Nullable
    private final String f13930a;
    private final ImmutableList<String> f13931b;
    private final ImmutableList<String> f13932c;
    private final boolean f13933d;
    @Nullable
    private final MarketplaceCrossPostSettingModel f13934e;
    @Nullable
    private final String f13935f;
    @Nullable
    private final ProductItemLocationPickerSettings f13936g;

    /* compiled from: TOOLS_SERVICE */
    final class C13251 implements Creator<ComposerCommerceInfo> {
        C13251() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerCommerceInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerCommerceInfo[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = ComposerCommerceInfo_BuilderDeserializer.class)
    /* compiled from: TOOLS_SERVICE */
    public class Builder {
        @Nullable
        public String f13922a;
        public ImmutableList<String> f13923b = RegularImmutableList.a;
        public ImmutableList<String> f13924c = RegularImmutableList.a;
        public boolean f13925d;
        @Nullable
        public MarketplaceCrossPostSettingModel f13926e;
        @Nullable
        public String f13927f;
        @Nullable
        public ProductItemLocationPickerSettings f13928g;

        public final ComposerCommerceInfo m23290a() {
            return new ComposerCommerceInfo(this);
        }

        @JsonProperty("currency_code")
        public Builder setCurrencyCode(@Nullable String str) {
            this.f13922a = str;
            return this;
        }

        @JsonProperty("intercept_words")
        public Builder setInterceptWords(ImmutableList<String> immutableList) {
            this.f13923b = immutableList;
            return this;
        }

        @JsonProperty("intercept_words_after_number")
        public Builder setInterceptWordsAfterNumber(ImmutableList<String> immutableList) {
            this.f13924c = immutableList;
            return this;
        }

        @JsonProperty("is_category_optional")
        public Builder setIsCategoryOptional(boolean z) {
            this.f13925d = z;
            return this;
        }

        @JsonProperty("marketplace_cross_post_setting_model")
        public Builder setMarketplaceCrossPostSettingModel(@Nullable MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel) {
            this.f13926e = marketplaceCrossPostSettingModel;
            return this;
        }

        @JsonProperty("prefill_category_id")
        public Builder setPrefillCategoryId(@Nullable String str) {
            this.f13927f = str;
            return this;
        }

        @JsonProperty("product_item_location_picker_settings")
        public Builder setProductItemLocationPickerSettings(@Nullable ProductItemLocationPickerSettings productItemLocationPickerSettings) {
            this.f13928g = productItemLocationPickerSettings;
            return this;
        }
    }

    /* compiled from: TOOLS_SERVICE */
    class Deserializer extends JsonDeserializer<ComposerCommerceInfo> {
        private static final ComposerCommerceInfo_BuilderDeserializer f13929a = new ComposerCommerceInfo_BuilderDeserializer();

        private Deserializer() {
        }

        public Object m23291a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return ((Builder) f13929a.a(jsonParser, deserializationContext)).m23290a();
        }
    }

    public ComposerCommerceInfo(Builder builder) {
        this.f13930a = builder.f13922a;
        this.f13931b = (ImmutableList) Preconditions.checkNotNull(builder.f13923b);
        this.f13932c = (ImmutableList) Preconditions.checkNotNull(builder.f13924c);
        this.f13933d = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f13925d))).booleanValue();
        this.f13934e = builder.f13926e;
        this.f13935f = builder.f13927f;
        this.f13936g = builder.f13928g;
    }

    public ComposerCommerceInfo(Parcel parcel) {
        int i;
        boolean z = false;
        if (parcel.readInt() == 0) {
            this.f13930a = null;
        } else {
            this.f13930a = parcel.readString();
        }
        String[] strArr = new String[parcel.readInt()];
        for (i = 0; i < strArr.length; i++) {
            strArr[i] = parcel.readString();
        }
        this.f13931b = ImmutableList.copyOf(strArr);
        strArr = new String[parcel.readInt()];
        for (i = 0; i < strArr.length; i++) {
            strArr[i] = parcel.readString();
        }
        this.f13932c = ImmutableList.copyOf(strArr);
        if (parcel.readInt() == 1) {
            z = true;
        }
        this.f13933d = z;
        if (parcel.readInt() == 0) {
            this.f13934e = null;
        } else {
            this.f13934e = (MarketplaceCrossPostSettingModel) parcel.readParcelable(MarketplaceCrossPostSettingModel.class.getClassLoader());
        }
        if (parcel.readInt() == 0) {
            this.f13935f = null;
        } else {
            this.f13935f = parcel.readString();
        }
        if (parcel.readInt() == 0) {
            this.f13936g = null;
        } else {
            this.f13936g = (ProductItemLocationPickerSettings) parcel.readParcelable(ProductItemLocationPickerSettings.class.getClassLoader());
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        if (this.f13930a == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f13930a);
        }
        parcel.writeInt(this.f13931b.size());
        int size = this.f13931b.size();
        for (i2 = 0; i2 < size; i2++) {
            parcel.writeString((String) this.f13931b.get(i2));
        }
        parcel.writeInt(this.f13932c.size());
        size = this.f13932c.size();
        for (i2 = 0; i2 < size; i2++) {
            parcel.writeString((String) this.f13932c.get(i2));
        }
        parcel.writeInt(this.f13933d ? 1 : 0);
        if (this.f13934e == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f13934e, i);
        }
        if (this.f13935f == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(this.f13935f);
        }
        if (this.f13936g == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeParcelable(this.f13936g, i);
    }

    public int describeContents() {
        return 0;
    }

    @JsonProperty("currency_code")
    @Nullable
    public String getCurrencyCode() {
        return this.f13930a;
    }

    @JsonProperty("intercept_words")
    public ImmutableList<String> getInterceptWords() {
        return this.f13931b;
    }

    @JsonProperty("intercept_words_after_number")
    public ImmutableList<String> getInterceptWordsAfterNumber() {
        return this.f13932c;
    }

    @JsonProperty("is_category_optional")
    public boolean getIsCategoryOptional() {
        return this.f13933d;
    }

    @JsonProperty("marketplace_cross_post_setting_model")
    @Nullable
    public MarketplaceCrossPostSettingModel getMarketplaceCrossPostSettingModel() {
        return this.f13934e;
    }

    @JsonProperty("prefill_category_id")
    @Nullable
    public String getPrefillCategoryId() {
        return this.f13935f;
    }

    @JsonProperty("product_item_location_picker_settings")
    @Nullable
    public ProductItemLocationPickerSettings getProductItemLocationPickerSettings() {
        return this.f13936g;
    }
}
