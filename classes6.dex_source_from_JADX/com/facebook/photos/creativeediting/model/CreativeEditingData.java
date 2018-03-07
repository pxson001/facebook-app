package com.facebook.photos.creativeediting.model;

import android.graphics.RectF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem.OverlayItemType;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Floats.FloatArrayAsList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = CreativeEditingDataDeserializer.class)
@JsonSerialize(using = CreativeEditingDataSerializer.class)
/* compiled from: tag_id */
public class CreativeEditingData implements Parcelable {
    public static final Creator<CreativeEditingData> CREATOR = new C02111();
    @JsonProperty("crop_box")
    final ImmutableList<Float> cropBox;
    @JsonProperty("display_uri")
    final String displayUri;
    @JsonProperty("doodle_list")
    final ImmutableList<DoodleParams> doodleParams;
    @JsonProperty("edited_uri")
    final String editedUri;
    @JsonProperty("filter_name")
    final String filterName;
    @JsonProperty("frame_packs")
    final ImmutableList<FramePackModel> framePacks;
    @JsonProperty("frames_overlayitem_list")
    final ImmutableList<StickerParams> framesOverlayItems;
    @JsonProperty("is_rotated")
    final boolean isRotated;
    @JsonProperty("ordering_list")
    final ImmutableList<OverlayItemType> orderingList;
    @JsonProperty("stickers_list")
    final ImmutableList<StickerParams> stickerParams;
    @JsonProperty("text_list")
    final ImmutableList<TextParams> textParams;

    /* compiled from: tag_id */
    final class C02111 implements Creator<CreativeEditingData> {
        C02111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreativeEditingData(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreativeEditingData[i];
        }
    }

    /* compiled from: tag_id */
    public class Builder {
        public String f3369a;
        public boolean f3370b;
        @Nullable
        public Uri f3371c;
        @Nullable
        public Uri f3372d;
        @Nullable
        public RectF f3373e;
        @Nullable
        public ImmutableList<StickerParams> f3374f;
        @Nullable
        public ImmutableList<TextParams> f3375g;
        @Nullable
        public ImmutableList<DoodleParams> f3376h;
        @Nullable
        public ImmutableList<OverlayItemType> f3377i;
        @Nullable
        public ImmutableList<StickerParams> f3378j;
        @Nullable
        public ImmutableList<FramePackModel> f3379k;

        public Builder() {
            this.f3369a = Filter.PassThrough.name();
            this.f3370b = false;
            this.f3371c = null;
            this.f3372d = null;
            this.f3373e = null;
            this.f3374f = null;
            this.f3376h = null;
            this.f3375g = null;
            this.f3377i = null;
            this.f3378j = null;
            this.f3379k = null;
        }

        public Builder(CreativeEditingData creativeEditingData) {
            this.f3369a = creativeEditingData.m4438a();
            this.f3370b = creativeEditingData.m4439b();
            this.f3373e = creativeEditingData.m4440c();
            this.f3371c = creativeEditingData.m4452o();
            this.f3372d = creativeEditingData.m4453p();
            this.f3374f = creativeEditingData.m4441d();
            this.f3375g = creativeEditingData.m4442e();
            this.f3376h = creativeEditingData.m4443f();
            this.f3377i = creativeEditingData.m4444g();
            this.f3378j = creativeEditingData.m4446i();
            this.f3379k = creativeEditingData.framePacks;
        }

        public final Builder m4437b(ImmutableList<UriAwarePhotoOverlayItem> immutableList) {
            if (immutableList != null) {
                com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = new com.google.common.collect.ImmutableList.Builder();
                com.google.common.collect.ImmutableList.Builder builder3 = new com.google.common.collect.ImmutableList.Builder();
                com.google.common.collect.ImmutableList.Builder builder4 = new com.google.common.collect.ImmutableList.Builder();
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    PhotoOverlayItem photoOverlayItem = (PhotoOverlayItem) immutableList.get(i);
                    if (photoOverlayItem instanceof TextParams) {
                        builder.c((TextParams) photoOverlayItem);
                        builder4.c(OverlayItemType.TEXT);
                    } else if (photoOverlayItem instanceof StickerParams) {
                        builder2.c((StickerParams) photoOverlayItem);
                        builder4.c(OverlayItemType.STICKER);
                    } else if (photoOverlayItem instanceof DoodleParams) {
                        builder3.c((DoodleParams) photoOverlayItem);
                        builder4.c(OverlayItemType.DOODLE);
                    }
                }
                this.f3375g = builder.b();
                this.f3374f = builder2.b();
                this.f3376h = builder3.b();
                this.f3377i = builder4.b();
            }
            return this;
        }

        public final CreativeEditingData m4436a() {
            return new CreativeEditingData(this);
        }
    }

    private CreativeEditingData() {
        this(new Builder());
    }

    public CreativeEditingData(Builder builder) {
        ImmutableList immutableList;
        this.filterName = builder.f3369a;
        this.isRotated = builder.f3370b;
        this.editedUri = builder.f3371c != null ? builder.f3371c.toString() : "";
        this.displayUri = builder.f3372d != null ? builder.f3372d.toString() : "";
        RectF rectF = builder.f3373e;
        if (rectF == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.of(Float.valueOf(rectF.left), Float.valueOf(rectF.top), Float.valueOf(rectF.right), Float.valueOf(rectF.bottom));
        }
        this.cropBox = immutableList;
        if (builder.f3374f == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = builder.f3374f;
        }
        this.stickerParams = immutableList;
        if (builder.f3375g == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = builder.f3375g;
        }
        this.textParams = immutableList;
        if (builder.f3376h == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = builder.f3376h;
        }
        this.doodleParams = immutableList;
        if (builder.f3377i == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = builder.f3377i;
        }
        this.orderingList = immutableList;
        if (builder.f3378j == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = builder.f3378j;
        }
        this.framesOverlayItems = immutableList;
        if (builder.f3379k == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = builder.f3379k;
        }
        this.framePacks = immutableList;
    }

    public CreativeEditingData(Parcel parcel) {
        List emptyList;
        boolean z = true;
        int i = 0;
        this.filterName = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.isRotated = z;
        this.editedUri = parcel.readString();
        this.displayUri = parcel.readString();
        float[] createFloatArray = parcel.createFloatArray();
        if (createFloatArray.length == 0) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = new FloatArrayAsList(createFloatArray);
        }
        this.cropBox = ImmutableList.copyOf(emptyList);
        this.stickerParams = ImmutableList.copyOf(parcel.createTypedArrayList(StickerParams.CREATOR));
        ImmutableList immutableList = RegularImmutableList.a;
        this.textParams = ImmutableList.copyOf(parcel.createTypedArrayList(TextParams.CREATOR));
        this.doodleParams = ImmutableList.copyOf(parcel.createTypedArrayList(DoodleParams.CREATOR));
        int[] createIntArray = parcel.createIntArray();
        com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder();
        if (createIntArray != null) {
            while (i < createIntArray.length) {
                builder.c(OverlayItemType.values()[createIntArray[i]]);
                i++;
            }
        }
        this.orderingList = builder.b();
        this.framesOverlayItems = ImmutableList.copyOf(parcel.createTypedArrayList(StickerParams.CREATOR));
        this.framePacks = ImmutableList.copyOf(FlatBufferModelHelper.b(parcel));
    }

    @JsonIgnore
    public final String m4438a() {
        return this.filterName;
    }

    @JsonIgnore
    public final boolean m4439b() {
        return this.isRotated;
    }

    @JsonIgnore
    public final RectF m4440c() {
        return this.cropBox.isEmpty() ? null : new RectF(((Float) this.cropBox.get(0)).floatValue(), ((Float) this.cropBox.get(1)).floatValue(), ((Float) this.cropBox.get(2)).floatValue(), ((Float) this.cropBox.get(3)).floatValue());
    }

    @JsonIgnore
    public final ImmutableList<StickerParams> m4441d() {
        return this.stickerParams;
    }

    @JsonIgnore
    public final ImmutableList<TextParams> m4442e() {
        return this.textParams;
    }

    @JsonIgnore
    public final ImmutableList<DoodleParams> m4443f() {
        return this.doodleParams;
    }

    @JsonIgnore
    public final ImmutableList<OverlayItemType> m4444g() {
        return this.orderingList;
    }

    @JsonIgnore
    public final ImmutableList<PhotoOverlayItem> m4445h() {
        com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder();
        if (this.orderingList.isEmpty() && (!this.stickerParams.isEmpty() || !this.textParams.isEmpty() || !this.doodleParams.isEmpty())) {
            return builder.b(this.stickerParams).b(this.textParams).b(this.doodleParams).b();
        }
        int size = this.orderingList.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < size) {
            int i5;
            int i6;
            switch ((OverlayItemType) this.orderingList.get(i)) {
                case STICKER:
                    builder.c(this.stickerParams.get(i4));
                    i6 = i2;
                    i2 = i3;
                    i3 = i4 + 1;
                    i5 = i6;
                    break;
                case TEXT:
                    builder.c(this.textParams.get(i3));
                    i5 = i3 + 1;
                    i3 = i4;
                    i6 = i5;
                    i5 = i2;
                    i2 = i6;
                    break;
                case DOODLE:
                    builder.c(this.doodleParams.get(i2));
                    i5 = i2 + 1;
                    i2 = i3;
                    i3 = i4;
                    break;
                default:
                    i5 = i2;
                    i2 = i3;
                    i3 = i4;
                    break;
            }
            i++;
            i4 = i3;
            i3 = i2;
            i2 = i5;
        }
        return builder.b();
    }

    @JsonIgnore
    public final ImmutableList<StickerParams> m4446i() {
        return this.framesOverlayItems;
    }

    @JsonIgnore
    public final ImmutableList<FramePack> m4447j() {
        return new com.google.common.collect.ImmutableList.Builder().b(this.framePacks).b();
    }

    @JsonIgnore
    public final boolean m4448k() {
        return ((m4445h() == null || m4445h().isEmpty()) && (m4446i() == null || m4446i().isEmpty())) ? false : true;
    }

    @JsonIgnore
    public final boolean m4449l() {
        return m4450m() || m4451n() || !((this.cropBox == null || this.cropBox.isEmpty()) && Strings.isNullOrEmpty(this.editedUri) && this.stickerParams.isEmpty() && !this.isRotated && this.textParams.isEmpty() && this.doodleParams.isEmpty());
    }

    @JsonIgnore
    public final boolean m4450m() {
        if (Filter.PassThrough.name().equals(this.filterName)) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    public final boolean m4451n() {
        return (this.framesOverlayItems == null || this.framesOverlayItems.isEmpty()) ? false : true;
    }

    @JsonIgnore
    @Nullable
    public final Uri m4452o() {
        if (Strings.isNullOrEmpty(this.editedUri)) {
            return null;
        }
        return Uri.parse(this.editedUri);
    }

    @JsonIgnore
    @Nullable
    public final Uri m4453p() {
        if (Strings.isNullOrEmpty(this.displayUri)) {
            return null;
        }
        return Uri.parse(this.displayUri);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.filterName);
        parcel.writeInt(this.isRotated ? 1 : 0);
        parcel.writeString(this.editedUri);
        parcel.writeString(this.displayUri);
        parcel.writeFloatArray(Floats.a(this.cropBox));
        parcel.writeTypedArray((Parcelable[]) this.stickerParams.toArray(new StickerParams[this.stickerParams.size()]), i);
        parcel.writeTypedArray((Parcelable[]) this.textParams.toArray(new TextParams[this.textParams.size()]), i);
        parcel.writeTypedArray((Parcelable[]) this.doodleParams.toArray(new DoodleParams[this.doodleParams.size()]), i);
        int[] iArr = new int[this.orderingList.size()];
        while (i2 < this.orderingList.size()) {
            iArr[i2] = ((OverlayItemType) this.orderingList.get(i2)).ordinal();
            i2++;
        }
        parcel.writeIntArray(iArr);
        parcel.writeTypedArray((Parcelable[]) this.framesOverlayItems.toArray(new StickerParams[this.framesOverlayItems.size()]), i);
        FlatBufferModelHelper.a(parcel, this.framePacks);
    }
}
