package com.facebook.friendsharing.souvenirs.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem.Deserializer;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = Deserializer.class)
@Immutable
@JsonSerialize(using = Serializer.class)
/* compiled from: RTC_VOIP_QUICKRESPONSE */
public final class SouvenirBurstItem implements SouvenirItem {
    public static final Creator<SouvenirBurstItem> CREATOR = new C20921();
    @JsonProperty("photo_items")
    final ImmutableList<SouvenirPhotoItem> mItems;
    @JsonProperty("selected_index")
    final int mSelectedIndex;

    /* compiled from: RTC_VOIP_QUICKRESPONSE */
    final class C20921 implements Creator<SouvenirBurstItem> {
        C20921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SouvenirBurstItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new SouvenirBurstItem[i];
        }
    }

    /* compiled from: RTC_VOIP_QUICKRESPONSE */
    public class Serializer extends JsonSerializer<SouvenirBurstItem> {
        public final void m26155a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            SouvenirBurstItem souvenirBurstItem = (SouvenirBurstItem) obj;
            if (souvenirBurstItem == null) {
                throw new IllegalArgumentException("SouvenirBurstItem.serialize");
            }
            jsonGenerator.b(SouvenirBurstItem.class.getSimpleName());
            jsonGenerator.f();
            m26154b(souvenirBurstItem, jsonGenerator, serializerProvider);
            jsonGenerator.g();
        }

        static {
            FbSerializerProvider.a(SouvenirBurstItem.class, new Serializer());
        }

        private static void m26154b(SouvenirBurstItem souvenirBurstItem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "photo_items", souvenirBurstItem.mItems);
            AutoGenJsonHelper.a(jsonGenerator, "selected_index", Integer.valueOf(souvenirBurstItem.mSelectedIndex));
        }
    }

    public SouvenirBurstItem(ImmutableList<SouvenirPhotoItem> immutableList, int i) {
        Preconditions.checkArgument(!immutableList.isEmpty());
        this.mItems = immutableList;
        this.mSelectedIndex = i;
    }

    public final Type hw_() {
        return Type.Burst;
    }

    private String m26156d() {
        return ((SouvenirPhotoItem) this.mItems.get(this.mSelectedIndex)).m26186c();
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SouvenirBurstItem) && ((SouvenirBurstItem) obj).m26156d().equals(m26156d()) && ((SouvenirBurstItem) obj).m26157b().equals(m26157b());
    }

    public final int hashCode() {
        return ((((this.mItems.hashCode() + 85) * 17) + this.mSelectedIndex) * 17) + hw_().name().hashCode();
    }

    public final ImmutableList<SouvenirPhotoItem> m26157b() {
        return this.mItems;
    }

    public final int m26158c() {
        return this.mSelectedIndex;
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return String.format(Locale.US, "{SouvenirBurstItem size=%d selected=%s}", new Object[]{Integer.valueOf(this.mItems.size()), ((SouvenirPhotoItem) this.mItems.get(this.mSelectedIndex)).toString()});
    }

    private SouvenirBurstItem() {
        this.mItems = null;
        this.mSelectedIndex = 0;
    }

    public SouvenirBurstItem(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.mItems = ParcelUtil.a(parcel, SouvenirPhotoItem.CREATOR);
        this.mSelectedIndex = parcel.readInt();
        if (this.mItems.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z);
        if (this.mSelectedIndex >= this.mItems.size()) {
            z2 = false;
        }
        Preconditions.checkState(z2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.mItems);
        parcel.writeInt(this.mSelectedIndex);
    }
}
