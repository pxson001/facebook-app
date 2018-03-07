package com.facebook.photos.mediagallery.launcher;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.fbui.draggable.Direction;
import com.facebook.feed.rows.photosfeed.PhotosFeedFragment.PhotosFeedMediaGalleryScrollListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.galleryutil.GalleryDeepLinkBinder.DeepLinkBinderConfig;
import com.facebook.photos.galleryutil.PhotoViewController;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcher.MediaFetcherListener;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: item_actions */
public class MediaGalleryLauncherParams<M> implements Parcelable {
    public static final Creator<MediaGalleryLauncherParams> CREATOR = new C09051();
    public final String f10691a;
    public final MediaFetcherConstructionRule f10692b;
    public final ImmutableList<M> f10693c;
    @Nullable
    public final MediaFetcherListener f10694d;
    @Nullable
    public final PhotoViewController f10695e;
    @Nullable
    public final String f10696f;
    @Nullable
    public final ImageRequest f10697g;
    @Nullable
    public final String f10698h;
    @Nullable
    public final String f10699i;
    @Nullable
    public final String f10700j;
    @Nullable
    public final String f10701k;
    public final boolean f10702l;
    public final boolean f10703m;
    public final boolean f10704n;
    public final boolean f10705o;
    public final int f10706p;
    public final FullscreenGallerySource f10707q;
    @Nullable
    public final DeepLinkBinderConfig f10708r;
    public final Direction f10709s;
    public final int f10710t;
    @Nullable
    public final PhotosFeedMediaGalleryScrollListener f10711u;
    public final int f10712v;
    public final Resources f10713w;
    public final int f10714x;
    public final String f10715y;
    public final String f10716z;

    /* compiled from: item_actions */
    public class Builder<M> {
        private String f10649a;
        private MediaFetcherConstructionRule f10650b;
        public ImmutableList<M> f10651c;
        private MediaFetcherListener f10652d;
        private PhotoViewController f10653e;
        private String f10654f;
        private ImageRequest f10655g;
        public String f10656h;
        public String f10657i;
        public String f10658j;
        public String f10659k;
        public boolean f10660l;
        public boolean f10661m = false;
        public boolean f10662n = true;
        public boolean f10663o = false;
        public int f10664p = -1;
        private FullscreenGallerySource f10665q = null;
        public DeepLinkBinderConfig f10666r = null;
        private Direction f10667s;
        private int f10668t;
        private PhotosFeedMediaGalleryScrollListener f10669u;
        private int f10670v = 10;
        private Resources f10671w;
        public int f10672x;
        public String f10673y;
        public String f10674z;

        public Builder(MediaGalleryLauncherParams mediaGalleryLauncherParams) {
            this.f10649a = mediaGalleryLauncherParams.f10691a;
            this.f10650b = mediaGalleryLauncherParams.f10692b;
            this.f10651c = ImmutableList.copyOf(mediaGalleryLauncherParams.f10693c);
            this.f10652d = mediaGalleryLauncherParams.f10694d;
            this.f10653e = mediaGalleryLauncherParams.f10695e;
            this.f10654f = mediaGalleryLauncherParams.f10696f;
            this.f10655g = mediaGalleryLauncherParams.f10697g;
            this.f10656h = mediaGalleryLauncherParams.f10699i;
            this.f10657i = mediaGalleryLauncherParams.f10700j;
            this.f10661m = mediaGalleryLauncherParams.f10703m;
            this.f10662n = mediaGalleryLauncherParams.f10704n;
            this.f10658j = mediaGalleryLauncherParams.f10698h;
            this.f10659k = mediaGalleryLauncherParams.f10701k;
            this.f10660l = mediaGalleryLauncherParams.f10702l;
            this.f10663o = mediaGalleryLauncherParams.f10705o;
            this.f10665q = mediaGalleryLauncherParams.f10707q;
            this.f10666r = mediaGalleryLauncherParams.f10708r;
            this.f10664p = mediaGalleryLauncherParams.f10706p;
            this.f10667s = mediaGalleryLauncherParams.f10709s;
            this.f10668t = mediaGalleryLauncherParams.f10710t;
            this.f10669u = mediaGalleryLauncherParams.f10711u;
            this.f10670v = mediaGalleryLauncherParams.f10712v;
            this.f10671w = mediaGalleryLauncherParams.f10713w;
            this.f10672x = mediaGalleryLauncherParams.f10714x;
            this.f10673y = mediaGalleryLauncherParams.f10715y;
            this.f10674z = mediaGalleryLauncherParams.f10716z;
        }

        public Builder(MediaFetcherConstructionRule mediaFetcherConstructionRule) {
            this.f10650b = (MediaFetcherConstructionRule) Preconditions.checkNotNull(mediaFetcherConstructionRule);
        }

        public final Builder m12720a(FullscreenGallerySource fullscreenGallerySource) {
            this.f10665q = (FullscreenGallerySource) Preconditions.checkNotNull(fullscreenGallerySource);
            return this;
        }

        public final Builder m12722a(ImmutableList<M> immutableList) {
            Preconditions.checkNotNull(immutableList);
            Preconditions.checkState(this.f10651c == null, "Multiple sources set");
            this.f10651c = immutableList;
            return this;
        }

        public final Builder m12721a(PhotoViewController photoViewController) {
            this.f10653e = (PhotoViewController) Preconditions.checkNotNull(photoViewController);
            return this;
        }

        public final Builder m12723a(String str) {
            Preconditions.checkState(this.f10654f == null, "Multiple start id's set");
            this.f10654f = str;
            return this;
        }

        public final Builder m12719a(ImageRequest imageRequest) {
            Preconditions.checkNotNull(this.f10654f, "StartMediaId must be set in order to use this feature");
            this.f10655g = imageRequest;
            return this;
        }

        public final Builder m12725b(@Nullable String str) {
            this.f10656h = str;
            return this;
        }

        public final Builder m12728c(@Nullable String str) {
            this.f10657i = str;
            return this;
        }

        public final Builder m12730d(String str) {
            this.f10658j = str;
            return this;
        }

        public final Builder m12729c(boolean z) {
            this.f10663o = z;
            return this;
        }

        public final Builder m12717a(int i) {
            this.f10664p = i;
            return this;
        }

        public final Builder m12718a(PhotosFeedMediaGalleryScrollListener photosFeedMediaGalleryScrollListener) {
            this.f10669u = photosFeedMediaGalleryScrollListener;
            return this;
        }

        public final Builder m12724b(int i) {
            this.f10670v = i;
            return this;
        }

        public final Builder m12727c(int i) {
            this.f10672x = i;
            return this;
        }

        public final Builder m12732e(String str) {
            this.f10673y = str;
            return this;
        }

        public final Builder m12733f(String str) {
            this.f10659k = str;
            return this;
        }

        public final Builder m12731d(boolean z) {
            this.f10660l = z;
            return this;
        }

        public final Builder m12734g(String str) {
            this.f10674z = str;
            return this;
        }

        public final MediaGalleryLauncherParams m12726b() {
            Preconditions.checkNotNull(this.f10650b, "no source specified");
            Preconditions.checkNotNull(this.f10665q, "must set gallery source");
            return new MediaGalleryLauncherParams(this.f10649a, this.f10650b, this.f10651c, this.f10652d, this.f10653e, this.f10654f, this.f10655g, this.f10656h, this.f10657i, this.f10658j, this.f10659k, this.f10660l, this.f10661m, this.f10662n, this.f10663o, this.f10664p, this.f10665q, this.f10666r, this.f10667s, this.f10668t, this.f10669u, this.f10670v, this.f10671w, this.f10672x, this.f10673y, this.f10674z);
        }
    }

    /* compiled from: item_actions */
    final class C09051 implements Creator<MediaGalleryLauncherParams> {
        C09051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MediaGalleryLauncherParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MediaGalleryLauncherParams[i];
        }
    }

    private MediaGalleryLauncherParams(String str, MediaFetcherConstructionRule mediaFetcherConstructionRule, @Nullable ImmutableList<M> immutableList, @Nullable MediaFetcherListener mediaFetcherListener, @Nullable PhotoViewController photoViewController, @Nullable String str2, @Nullable ImageRequest imageRequest, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, boolean z, boolean z2, boolean z3, boolean z4, int i, FullscreenGallerySource fullscreenGallerySource, DeepLinkBinderConfig deepLinkBinderConfig, Direction direction, int i2, @Nullable MediaGalleryScrollListener mediaGalleryScrollListener, int i3, Resources resources, int i4, String str7, String str8) {
        if (str == null) {
            str = SafeUUIDGenerator.a().toString();
        }
        this.f10691a = str;
        this.f10692b = (MediaFetcherConstructionRule) Preconditions.checkNotNull(mediaFetcherConstructionRule);
        this.f10696f = str2;
        if (immutableList == null) {
            immutableList = ImmutableList.of();
        }
        this.f10693c = immutableList;
        this.f10694d = mediaFetcherListener;
        this.f10695e = photoViewController;
        this.f10697g = imageRequest;
        this.f10699i = str3;
        this.f10700j = str4;
        this.f10698h = str5;
        this.f10701k = str6;
        this.f10702l = z;
        this.f10703m = z2;
        this.f10704n = z3;
        this.f10705o = z4;
        this.f10706p = i;
        this.f10707q = fullscreenGallerySource;
        this.f10708r = deepLinkBinderConfig;
        this.f10709s = direction;
        this.f10710t = i2;
        this.f10711u = mediaGalleryScrollListener;
        this.f10712v = i3;
        this.f10713w = resources;
        this.f10714x = i4;
        this.f10715y = str7;
        this.f10716z = str8;
    }

    public MediaGalleryLauncherParams(Parcel parcel) {
        this.f10691a = parcel.readString();
        this.f10692b = (MediaFetcherConstructionRule) parcel.readParcelable(MediaGalleryLauncherParams.class.getClassLoader());
        this.f10693c = RegularImmutableList.a;
        this.f10694d = null;
        this.f10695e = null;
        this.f10696f = parcel.readString();
        this.f10697g = null;
        this.f10699i = parcel.readString();
        this.f10700j = parcel.readString();
        this.f10698h = parcel.readString();
        this.f10701k = parcel.readString();
        this.f10702l = ParcelUtil.a(parcel);
        this.f10703m = ParcelUtil.a(parcel);
        this.f10704n = ParcelUtil.a(parcel);
        this.f10705o = ParcelUtil.a(parcel);
        this.f10706p = parcel.readInt();
        this.f10707q = (FullscreenGallerySource) parcel.readSerializable();
        this.f10708r = (DeepLinkBinderConfig) parcel.readParcelable(DeepLinkBinderConfig.class.getClassLoader());
        this.f10709s = (Direction) parcel.readSerializable();
        this.f10710t = parcel.readInt();
        this.f10711u = null;
        this.f10712v = parcel.readInt();
        this.f10713w = null;
        this.f10714x = parcel.readInt();
        this.f10715y = parcel.readString();
        this.f10716z = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10691a);
        parcel.writeParcelable(this.f10692b, i);
        parcel.writeString(this.f10696f);
        parcel.writeString(this.f10699i);
        parcel.writeString(this.f10700j);
        parcel.writeString(this.f10698h);
        parcel.writeString(this.f10701k);
        ParcelUtil.a(parcel, this.f10702l);
        ParcelUtil.a(parcel, this.f10703m);
        ParcelUtil.a(parcel, this.f10704n);
        ParcelUtil.a(parcel, this.f10705o);
        parcel.writeInt(this.f10706p);
        parcel.writeSerializable(this.f10707q);
        parcel.writeParcelable(this.f10708r, i);
        parcel.writeSerializable(this.f10709s);
        parcel.writeInt(this.f10710t);
        parcel.writeInt(this.f10712v);
        parcel.writeInt(this.f10714x);
        parcel.writeString(this.f10715y);
        parcel.writeString(this.f10716z);
    }
}
