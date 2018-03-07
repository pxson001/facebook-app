package com.facebook.heisman;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.heisman.protocol.HeismanSelfProfilePictureGraphQLModels.SelfProfilePictureFieldsModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel;
import com.facebook.heisman.swipeable.SwipeableOverlays;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: valueName */
public class ProfilePictureOverlayCameraModel implements Parcelable {
    public static final Creator<ProfilePictureOverlayCameraModel> CREATOR = new C00861();
    public final ImageOverlayFieldsModel f689a;
    @Nullable
    public final SelfProfilePictureFieldsModel f690b;
    @Nullable
    public final String f691c;
    @Nullable
    public final String f692d;
    @Nullable
    public final ImageOverlayWithSwipeableOverlaysModel f693e;
    @Nullable
    public final String f694f;

    /* compiled from: valueName */
    final class C00861 implements Creator<ProfilePictureOverlayCameraModel> {
        C00861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProfilePictureOverlayCameraModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProfilePictureOverlayCameraModel[i];
        }
    }

    /* compiled from: valueName */
    public class Builder {
        public ImageOverlayFieldsModel f683a;
        @Nullable
        public SelfProfilePictureFieldsModel f684b;
        @Nullable
        public String f685c;
        @Nullable
        public String f686d;
        @Nullable
        public ImageOverlayWithSwipeableOverlaysModel f687e;
        @Nullable
        public String f688f;

        public Builder(ProfilePictureOverlayCameraModel profilePictureOverlayCameraModel) {
            this.f683a = profilePictureOverlayCameraModel.f689a;
            this.f684b = profilePictureOverlayCameraModel.f690b;
            this.f685c = profilePictureOverlayCameraModel.f691c;
            this.f686d = profilePictureOverlayCameraModel.f692d;
            this.f687e = profilePictureOverlayCameraModel.f693e;
            this.f688f = profilePictureOverlayCameraModel.f694f;
        }

        public Builder(ImageOverlayFieldsModel imageOverlayFieldsModel) {
            this.f683a = imageOverlayFieldsModel;
        }

        public final ProfilePictureOverlayCameraModel m754a() {
            return new ProfilePictureOverlayCameraModel(this);
        }
    }

    public ProfilePictureOverlayCameraModel(Builder builder) {
        this.f689a = builder.f683a;
        this.f690b = builder.f684b;
        this.f691c = builder.f685c;
        this.f692d = builder.f686d;
        this.f693e = builder.f687e;
        this.f694f = builder.f688f;
    }

    public ProfilePictureOverlayCameraModel(Parcel parcel) {
        this.f689a = (ImageOverlayFieldsModel) FlatBufferModelHelper.a(parcel);
        this.f690b = (SelfProfilePictureFieldsModel) FlatBufferModelHelper.a(parcel);
        this.f691c = parcel.readString();
        this.f692d = parcel.readString();
        this.f693e = (ImageOverlayWithSwipeableOverlaysModel) FlatBufferModelHelper.a(parcel);
        this.f694f = parcel.readString();
    }

    @Nullable
    public final String m756c() {
        return (this.f690b == null || this.f690b.j() == null) ? null : this.f690b.j().a();
    }

    public final String m757f() {
        return this.f689a.c();
    }

    @Nullable
    public final Uri m758g() {
        return (this.f689a.j() == null || this.f689a.j().a() == null) ? null : Uri.parse(this.f689a.j().a());
    }

    public final ImageOverlayFieldsModel m759i() {
        Preconditions.checkNotNull(this.f694f);
        return m755a(this.f694f);
    }

    @VisibleForTesting
    private ImageOverlayFieldsModel m755a(String str) {
        if (Objects.equal(this.f689a.c(), str)) {
            return this.f689a;
        }
        if (this.f693e != null) {
            return SwipeableOverlays.a(this.f693e, str);
        }
        throw new IllegalArgumentException("Did not find overlay with ID: " + str);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f689a);
        FlatBufferModelHelper.a(parcel, this.f690b);
        parcel.writeString(this.f691c);
        parcel.writeString(this.f692d);
        FlatBufferModelHelper.a(parcel, this.f693e);
        parcel.writeString(this.f694f);
    }

    public final Builder m760j() {
        return new Builder(this);
    }
}
