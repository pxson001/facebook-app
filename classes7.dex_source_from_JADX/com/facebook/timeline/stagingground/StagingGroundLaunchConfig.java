package com.facebook.timeline.stagingground;

import android.graphics.RectF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel.AssociatedPagesModel;
import com.facebook.heisman.swipeable.ImageOverlayValidator;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: failed to update poll option */
public class StagingGroundLaunchConfig implements Parcelable {
    public static final Creator<StagingGroundLaunchConfig> CREATOR = new C10761();
    public final DefaultTextWithEntitiesLongFields f14769a;
    public final Uri f14770b;
    public final String f14771c;
    public final String f14772d;
    public final String f14773e;
    public final long f14774f;
    public final int f14775g;
    public final int f14776h;
    public final int f14777i;
    public final int f14778j;
    public final String f14779k;
    @Nullable
    public final ImageOverlayWithSwipeableOverlaysModel f14780l;
    @Nullable
    public final ImageOverlayFieldsModel f14781m;
    public final CreativeEditingData f14782n;
    public final VideoCreativeEditingData f14783o;
    public final boolean f14784p;
    public final int f14785q;
    public final boolean f14786r;
    public final boolean f14787s;
    public final boolean f14788t;
    public final boolean f14789u;
    public final boolean f14790v;
    @Nullable
    public final RectF f14791w;

    /* compiled from: failed to update poll option */
    final class C10761 implements Creator<StagingGroundLaunchConfig> {
        C10761() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new StagingGroundLaunchConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new StagingGroundLaunchConfig[i];
        }
    }

    /* compiled from: failed to update poll option */
    public class Builder {
        public DefaultTextWithEntitiesLongFields f14746a;
        public Uri f14747b;
        public String f14748c;
        public String f14749d;
        public String f14750e;
        public long f14751f = 0;
        public int f14752g = 2131237849;
        public int f14753h = 2131234496;
        public int f14754i = 2131234499;
        public int f14755j;
        public String f14756k = "timeline";
        @Nullable
        public ImageOverlayWithSwipeableOverlaysModel f14757l;
        @Nullable
        public ImageOverlayFieldsModel f14758m;
        public CreativeEditingData f14759n;
        public VideoCreativeEditingData f14760o;
        public boolean f14761p = false;
        public int f14762q;
        public boolean f14763r = false;
        public boolean f14764s = false;
        public boolean f14765t = false;
        public boolean f14766u = false;
        public boolean f14767v = false;
        @Nullable
        public RectF f14768w;

        public Builder(StagingGroundLaunchConfig stagingGroundLaunchConfig) {
            this.f14746a = stagingGroundLaunchConfig.f14769a;
            this.f14747b = stagingGroundLaunchConfig.f14770b;
            this.f14748c = stagingGroundLaunchConfig.f14771c;
            this.f14749d = stagingGroundLaunchConfig.f14772d;
            this.f14750e = stagingGroundLaunchConfig.f14773e;
            this.f14751f = stagingGroundLaunchConfig.f14774f;
            this.f14752g = stagingGroundLaunchConfig.f14775g;
            this.f14753h = stagingGroundLaunchConfig.f14776h;
            this.f14754i = stagingGroundLaunchConfig.f14777i;
            this.f14755j = stagingGroundLaunchConfig.f14778j;
            this.f14756k = stagingGroundLaunchConfig.f14779k;
            this.f14757l = stagingGroundLaunchConfig.f14780l;
            this.f14758m = stagingGroundLaunchConfig.f14781m;
            this.f14759n = stagingGroundLaunchConfig.f14782n;
            this.f14760o = stagingGroundLaunchConfig.f14783o;
            this.f14761p = stagingGroundLaunchConfig.f14784p;
            this.f14762q = stagingGroundLaunchConfig.f14785q;
            this.f14763r = stagingGroundLaunchConfig.f14786r;
            this.f14764s = stagingGroundLaunchConfig.f14787s;
            this.f14765t = stagingGroundLaunchConfig.f14788t;
            this.f14766u = stagingGroundLaunchConfig.f14789u;
            this.f14767v = stagingGroundLaunchConfig.f14790v;
            this.f14768w = stagingGroundLaunchConfig.f14791w;
        }

        public final Builder m18669a(Uri uri, String str) {
            this.f14747b = uri;
            this.f14748c = str;
            return this;
        }

        public final Builder m18668a(long j) {
            this.f14751f = j;
            return this;
        }

        public final StagingGroundLaunchConfig m18670a() {
            if (Strings.isNullOrEmpty(this.f14750e)) {
                this.f14750e = SafeUUIDGenerator.a().toString();
            }
            boolean b = ImageOverlayValidator.m8023b(this.f14758m);
            boolean z = this.f14758m == null || b;
            Preconditions.checkArgument(z, "If a selected image overlay is passed in, it must have a URI");
            if (this.f14757l != null) {
                boolean z2;
                Preconditions.checkArgument(b);
                ImageOverlayWithSwipeableOverlaysModel imageOverlayWithSwipeableOverlaysModel = this.f14757l;
                String c = this.f14758m.c();
                Preconditions.checkArgument(ImageOverlayValidator.m8022a(imageOverlayWithSwipeableOverlaysModel));
                ImmutableList a = ((AssociatedPagesModel) imageOverlayWithSwipeableOverlaysModel.a().get(0)).a().a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    if (Objects.equal(((ImageOverlayFieldsModel) a.get(i)).c(), c)) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                Preconditions.checkArgument(z2);
            }
            return new StagingGroundLaunchConfig(this);
        }
    }

    public StagingGroundLaunchConfig(Builder builder) {
        this.f14770b = builder.f14747b;
        this.f14771c = builder.f14748c;
        this.f14769a = builder.f14746a;
        this.f14772d = builder.f14749d;
        this.f14773e = builder.f14750e;
        this.f14774f = builder.f14751f;
        this.f14775g = builder.f14752g;
        this.f14776h = builder.f14753h;
        this.f14777i = builder.f14754i;
        this.f14778j = builder.f14755j;
        this.f14779k = builder.f14756k;
        this.f14780l = builder.f14757l;
        this.f14781m = builder.f14758m;
        this.f14782n = builder.f14759n;
        this.f14783o = builder.f14760o;
        this.f14784p = builder.f14761p;
        this.f14785q = builder.f14762q;
        this.f14786r = builder.f14763r;
        this.f14787s = builder.f14764s;
        this.f14788t = builder.f14765t;
        this.f14789u = builder.f14766u;
        this.f14790v = builder.f14767v;
        this.f14791w = builder.f14768w;
    }

    public StagingGroundLaunchConfig(Parcel parcel) {
        this.f14770b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f14771c = parcel.readString();
        this.f14769a = (DefaultTextWithEntitiesLongFields) FlatBufferModelHelper.a(parcel);
        this.f14772d = parcel.readString();
        this.f14773e = parcel.readString();
        this.f14774f = parcel.readLong();
        this.f14775g = parcel.readInt();
        this.f14776h = parcel.readInt();
        this.f14777i = parcel.readInt();
        this.f14778j = parcel.readInt();
        this.f14779k = parcel.readString();
        this.f14780l = (ImageOverlayWithSwipeableOverlaysModel) FlatBufferModelHelper.a(parcel);
        this.f14781m = (ImageOverlayFieldsModel) FlatBufferModelHelper.a(parcel);
        this.f14782n = (CreativeEditingData) parcel.readParcelable(CreativeEditingData.class.getClassLoader());
        this.f14783o = (VideoCreativeEditingData) parcel.readParcelable(VideoCreativeEditingData.class.getClassLoader());
        this.f14784p = ParcelUtil.a(parcel);
        this.f14785q = parcel.readInt();
        this.f14786r = ParcelUtil.a(parcel);
        this.f14787s = ParcelUtil.a(parcel);
        this.f14788t = ParcelUtil.a(parcel);
        this.f14789u = ParcelUtil.a(parcel);
        this.f14790v = ParcelUtil.a(parcel);
        this.f14791w = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f14770b, i);
        parcel.writeString(this.f14771c);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f14769a);
        parcel.writeString(this.f14772d);
        parcel.writeString(this.f14773e);
        parcel.writeLong(this.f14774f);
        parcel.writeInt(this.f14775g);
        parcel.writeInt(this.f14776h);
        parcel.writeInt(this.f14777i);
        parcel.writeInt(this.f14778j);
        parcel.writeString(this.f14779k);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f14780l);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f14781m);
        parcel.writeParcelable(this.f14782n, i);
        parcel.writeParcelable(this.f14783o, i);
        ParcelUtil.a(parcel, this.f14784p);
        parcel.writeInt(this.f14785q);
        ParcelUtil.a(parcel, this.f14786r);
        ParcelUtil.a(parcel, this.f14787s);
        ParcelUtil.a(parcel, this.f14788t);
        ParcelUtil.a(parcel, this.f14789u);
        ParcelUtil.a(parcel, this.f14790v);
        parcel.writeParcelable(this.f14791w, i);
    }
}
