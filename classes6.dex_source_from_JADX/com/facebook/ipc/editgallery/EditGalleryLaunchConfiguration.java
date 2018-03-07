package com.facebook.ipc.editgallery;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.timeline.tempprofilepic.model.ExpirationState;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: learning_nux/ */
public class EditGalleryLaunchConfiguration implements Parcelable {
    public static final Creator<EditGalleryLaunchConfiguration> CREATOR = new C07441();
    public final Uri f11639a;
    public final String f11640b;
    public final EditFeature f11641c;
    private final List<EditFeature> f11642d;
    public final CropMode f11643e;
    public final boolean f11644f;
    @Nullable
    public final String f11645g;
    public final boolean f11646h;
    @Nullable
    public final String f11647i;
    @Nullable
    public final CreativeEditingData f11648j;
    @Nullable
    public final ExpirationState f11649k;
    public final ImmutableList<SwipeableParams> f11650l;
    public final EditGalleryZoomCropParams f11651m;
    public final boolean f11652n;

    /* compiled from: learning_nux/ */
    final class C07441 implements Creator<EditGalleryLaunchConfiguration> {
        C07441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditGalleryLaunchConfiguration(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditGalleryLaunchConfiguration[i];
        }
    }

    /* compiled from: learning_nux/ */
    public class Builder {
        private Uri f11625a;
        private String f11626b;
        private final List<EditFeature> f11627c = new ArrayList();
        private EditFeature f11628d = EditFeature.CROP;
        private CropMode f11629e = CropMode.DEFAULT_CROP;
        public boolean f11630f = false;
        private String f11631g = null;
        public boolean f11632h = true;
        public String f11633i = null;
        @Nullable
        public CreativeEditingData f11634j = null;
        @Nullable
        public ExpirationState f11635k = null;
        public ImmutableList<SwipeableParams> f11636l = RegularImmutableList.a;
        public EditGalleryZoomCropParams f11637m;
        public boolean f11638n = true;

        public Builder(EditGalleryLaunchConfiguration editGalleryLaunchConfiguration) {
            this.f11625a = editGalleryLaunchConfiguration.f11639a;
            this.f11626b = editGalleryLaunchConfiguration.f11640b;
            this.f11627c.clear();
            this.f11627c.addAll(editGalleryLaunchConfiguration.m18348e());
            this.f11629e = editGalleryLaunchConfiguration.f11643e;
            this.f11628d = editGalleryLaunchConfiguration.f11641c;
            this.f11630f = editGalleryLaunchConfiguration.f11644f;
            this.f11631g = editGalleryLaunchConfiguration.f11645g;
            this.f11632h = editGalleryLaunchConfiguration.f11646h;
            this.f11633i = editGalleryLaunchConfiguration.f11647i;
            this.f11634j = editGalleryLaunchConfiguration.f11648j;
            this.f11635k = editGalleryLaunchConfiguration.f11649k;
            this.f11636l = editGalleryLaunchConfiguration.f11650l;
            this.f11637m = editGalleryLaunchConfiguration.f11651m;
            this.f11638n = editGalleryLaunchConfiguration.f11652n;
        }

        public final Builder m18342a(Uri uri, String str) {
            this.f11625a = uri;
            this.f11626b = str;
            return this;
        }

        public final Builder m18344a(EditFeature editFeature) {
            if (editFeature != null) {
                Preconditions.checkState(!this.f11627c.contains(editFeature));
                this.f11628d = editFeature;
            }
            return this;
        }

        public final Builder m18343a(CropMode cropMode) {
            Preconditions.checkState(!this.f11627c.contains(EditFeature.CROP));
            this.f11629e = cropMode;
            return this;
        }

        public final Builder m18346b(EditFeature editFeature) {
            if (editFeature != null) {
                Preconditions.checkState(editFeature != this.f11628d);
                if (!this.f11627c.contains(editFeature)) {
                    this.f11627c.add(editFeature);
                }
            }
            return this;
        }

        public final Builder m18347b(String str) {
            Preconditions.checkState(!Strings.isNullOrEmpty(str));
            this.f11631g = str;
            return this;
        }

        public final EditGalleryLaunchConfiguration m18345a() {
            if (Strings.isNullOrEmpty(this.f11631g)) {
                this.f11631g = SafeUUIDGenerator.a().toString();
            }
            if (this.f11637m == null) {
                this.f11637m = new com.facebook.ipc.editgallery.EditGalleryZoomCropParams.Builder().m18349a();
            }
            return new EditGalleryLaunchConfiguration(this.f11625a, this.f11626b, this.f11628d, this.f11629e, this.f11627c, this.f11630f, this.f11631g, this.f11632h, this.f11633i, this.f11634j, this.f11635k, this.f11636l, this.f11637m, this.f11638n);
        }
    }

    private EditGalleryLaunchConfiguration(Uri uri, String str, EditFeature editFeature, CropMode cropMode, List<EditFeature> list, boolean z, String str2, boolean z2, String str3, @Nullable CreativeEditingData creativeEditingData, @Nullable ExpirationState expirationState, ImmutableList<SwipeableParams> immutableList, EditGalleryZoomCropParams editGalleryZoomCropParams, boolean z3) {
        this.f11642d = new ArrayList();
        this.f11639a = uri;
        this.f11640b = str;
        this.f11641c = editFeature;
        this.f11642d.addAll(list);
        this.f11643e = cropMode;
        this.f11644f = z;
        this.f11645g = str2;
        this.f11646h = z2;
        this.f11647i = str3;
        this.f11648j = creativeEditingData;
        this.f11649k = expirationState;
        this.f11650l = (ImmutableList) Preconditions.checkNotNull(immutableList);
        this.f11651m = editGalleryZoomCropParams;
        this.f11652n = z3;
    }

    public final List<EditFeature> m18348e() {
        return new ArrayList(this.f11642d);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f11639a, 0);
        parcel.writeString(this.f11640b);
        ParcelUtil.a(parcel, this.f11641c);
        ParcelUtil.a(parcel, this.f11643e);
        parcel.writeList(this.f11642d);
        ParcelUtil.a(parcel, this.f11644f);
        parcel.writeString(this.f11645g);
        ParcelUtil.a(parcel, this.f11646h);
        parcel.writeString(this.f11647i);
        parcel.writeParcelable(this.f11648j, 0);
        parcel.writeParcelable(this.f11649k, 0);
        parcel.writeTypedList(this.f11650l);
        parcel.writeParcelable(this.f11651m, 0);
        ParcelUtil.a(parcel, this.f11652n);
    }

    public EditGalleryLaunchConfiguration(Parcel parcel) {
        this.f11642d = new ArrayList();
        this.f11639a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f11640b = parcel.readString();
        this.f11641c = (EditFeature) ParcelUtil.c(parcel, EditFeature.class);
        this.f11643e = (CropMode) ParcelUtil.c(parcel, CropMode.class);
        parcel.readList(this.f11642d, EditFeature.class.getClassLoader());
        this.f11644f = ParcelUtil.a(parcel);
        this.f11645g = parcel.readString();
        this.f11646h = ParcelUtil.a(parcel);
        this.f11647i = parcel.readString();
        this.f11648j = (CreativeEditingData) parcel.readParcelable(CreativeEditingData.class.getClassLoader());
        this.f11649k = (ExpirationState) parcel.readParcelable(ExpirationState.class.getClassLoader());
        this.f11650l = ParcelUtil.a(parcel, SwipeableParams.CREATOR);
        this.f11651m = (EditGalleryZoomCropParams) parcel.readParcelable(EditGalleryZoomCropParams.class.getClassLoader());
        this.f11652n = ParcelUtil.a(parcel);
    }
}
