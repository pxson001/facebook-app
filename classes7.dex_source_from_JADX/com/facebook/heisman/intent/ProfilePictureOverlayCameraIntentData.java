package com.facebook.heisman.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLModels.ImageOverlayCameraTitleFieldsModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.swipeable.ImageOverlayValidator;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: post_comment_ */
public class ProfilePictureOverlayCameraIntentData implements Parcelable {
    public static final Creator<ProfilePictureOverlayCameraIntentData> CREATOR = new C05501();
    private final ProfilePictureOverlayCommonParams f6105a;
    @Nullable
    public final ImageOverlayFieldsModel f6106b;
    @Nullable
    public final ImageOverlayCameraTitleFieldsModel f6107c;

    /* compiled from: post_comment_ */
    final class C05501 implements Creator<ProfilePictureOverlayCameraIntentData> {
        C05501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProfilePictureOverlayCameraIntentData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProfilePictureOverlayCameraIntentData[i];
        }
    }

    /* compiled from: post_comment_ */
    public class Builder extends com.facebook.heisman.intent.ProfilePictureOverlayCommonParams.Builder<Builder> {
        private final ImageOverlayFieldsModel f6103a;
        @Nullable
        public ImageOverlayCameraTitleFieldsModel f6104b;

        public Builder(ImageOverlayFieldsModel imageOverlayFieldsModel, String str, String str2) {
            super(str, str2);
            this.f6103a = imageOverlayFieldsModel;
        }

        public final com.facebook.heisman.intent.ProfilePictureOverlayCommonParams.Builder mo339b() {
            return this;
        }

        public final ProfilePictureOverlayCameraIntentData m7899a() {
            ProfilePictureOverlayCommonParams c = m7898c();
            Preconditions.checkArgument(ImageOverlayValidator.m8021a(this.f6103a), ImageOverlayValidator.m8024c(this.f6103a));
            return new ProfilePictureOverlayCameraIntentData(c, this.f6103a, this.f6104b);
        }
    }

    public ProfilePictureOverlayCameraIntentData(ProfilePictureOverlayCommonParams profilePictureOverlayCommonParams, @Nullable ImageOverlayFieldsModel imageOverlayFieldsModel, @Nullable ImageOverlayCameraTitleFieldsModel imageOverlayCameraTitleFieldsModel) {
        this.f6105a = profilePictureOverlayCommonParams;
        this.f6106b = imageOverlayFieldsModel;
        this.f6107c = imageOverlayCameraTitleFieldsModel;
    }

    public ProfilePictureOverlayCameraIntentData(Parcel parcel) {
        this.f6105a = (ProfilePictureOverlayCommonParams) parcel.readParcelable(ProfilePictureOverlayCommonParams.class.getClassLoader());
        this.f6106b = (ImageOverlayFieldsModel) FlatBufferModelHelper.a(parcel);
        this.f6107c = (ImageOverlayCameraTitleFieldsModel) FlatBufferModelHelper.a(parcel);
    }

    public final String m7901c() {
        return this.f6105a.f6108a;
    }

    public final long m7902d() {
        return this.f6105a.f6110c;
    }

    @Nullable
    public final String m7903e() {
        return this.f6105a.f6111d;
    }

    @Nullable
    public final String m7904f() {
        return this.f6105a.f6112e;
    }

    public final String m7905g() {
        return this.f6105a.f6109b;
    }

    @Nullable
    public final PromptAnalytics m7906h() {
        return this.f6105a.f6113f;
    }

    public final int m7907i() {
        return this.f6105a.f6114g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f6105a, i);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f6106b);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f6107c);
    }
}
