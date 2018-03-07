package com.facebook.ipc.simplepicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.model.ComposerEntryPicker;
import com.facebook.ipc.composer.model.ComposerLaunchLoggingParams;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.timeline.tempprofilepic.model.ExpirationState;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: latLng */
public class SimplePickerLauncherConfiguration implements Parcelable {
    public static final Creator<SimplePickerLauncherConfiguration> CREATOR = new C07491();
    @Nullable
    public final ComposerConfiguration f11729a;
    public final Action f11730b;
    @Nullable
    public final ExpirationState f11731c;
    public final SimplePickerConfiguration f11732d;
    public final boolean f11733e;
    public final boolean f11734f;

    /* compiled from: latLng */
    final class C07491 implements Creator<SimplePickerLauncherConfiguration> {
        C07491() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimplePickerLauncherConfiguration(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimplePickerLauncherConfiguration[i];
        }
    }

    /* compiled from: latLng */
    public enum Action {
        LAUNCH_PROFILE_PIC_CROPPER,
        LAUNCH_PROFILE_PIC_EDIT_GALLERY,
        LAUNCH_AD_IMAGE_CROPPER,
        LAUNCH_GENERIC_CROPPER,
        LAUNCH_COMPOSER,
        LAUNCH_COMPOSER_ALBUM_CREATOR,
        LAUNCH_PLACE_PICKER,
        LAUNCH_STICKER_EDITOR,
        LAUNCH_COVER_PIC_CROPPER,
        LAUNCH_SLIDESHOW_EDIT_ACTIVITY,
        NONE
    }

    /* compiled from: latLng */
    public class Builder {
        public ComposerConfiguration f11723a;
        public Action f11724b = Action.LAUNCH_COMPOSER;
        @Nullable
        public ExpirationState f11725c = null;
        public com.facebook.ipc.simplepicker.SimplePickerConfiguration.Builder f11726d = new com.facebook.ipc.simplepicker.SimplePickerConfiguration.Builder().m18363m();
        public boolean f11727e = false;
        public boolean f11728f = false;

        public Builder(SimplePickerSource simplePickerSource) {
            Preconditions.checkNotNull(simplePickerSource);
            this.f11726d.f11682e = simplePickerSource;
        }

        public final Builder m18374a(Action action) {
            this.f11724b = action;
            switch (action) {
                case LAUNCH_COMPOSER:
                    this.f11726d.m18363m();
                    break;
                default:
                    this.f11726d.f11685h = false;
                    break;
            }
            return this;
        }

        public final Builder m18372a() {
            this.f11728f = true;
            return this;
        }

        public final Builder m18376b() {
            this.f11726d.f11686i = true;
            return this;
        }

        public final Builder m18378c() {
            this.f11726d.f11687j = true;
            return this;
        }

        public final Builder m18379d() {
            this.f11726d.f11687j = false;
            return this;
        }

        public final Builder m18380e() {
            this.f11726d.f11691n = true;
            return this;
        }

        public final Builder m18381g() {
            this.f11726d.f11693p = true;
            return this;
        }

        public final Builder m18382h() {
            this.f11726d.f11678a = false;
            return this;
        }

        public final Builder m18383i() {
            com.facebook.ipc.simplepicker.SimplePickerConfiguration.Builder builder = this.f11726d;
            Preconditions.checkArgument(builder.f11679b == SupportedMediaType.ALL);
            builder.f11679b = SupportedMediaType.PHOTO_ONLY;
            return this;
        }

        public final Builder m18384j() {
            com.facebook.ipc.simplepicker.SimplePickerConfiguration.Builder builder = this.f11726d;
            Preconditions.checkArgument(builder.f11679b == SupportedMediaType.ALL);
            builder.f11679b = SupportedMediaType.VIDEO_ONLY;
            return this;
        }

        public final Builder m18385k() {
            this.f11726d.f11680c = false;
            return this;
        }

        public final Builder m18373a(int i, int i2) {
            com.facebook.ipc.simplepicker.SimplePickerConfiguration.Builder builder = this.f11726d;
            boolean z = i >= 0 && (i2 >= i || i2 == 0);
            Preconditions.checkArgument(z, "min >= 0 AND (max >= min OR max == NO_MAX)");
            builder.f11696s = true;
            builder.f11697t = i;
            builder.f11698u = i2;
            return this;
        }

        public final Builder m18386n() {
            com.facebook.ipc.simplepicker.SimplePickerConfiguration.Builder builder = this.f11726d;
            if (builder.f11694q <= 0) {
                builder.m18362a(1, builder.f11695r);
            }
            return this;
        }

        public final Builder m18375a(ImmutableList<MediaItem> immutableList) {
            this.f11726d.f11681d = immutableList;
            return this;
        }

        public final Builder m18387o() {
            this.f11726d.f11683f = true;
            return this;
        }

        public final Builder m18388p() {
            this.f11726d.f11684g = true;
            return this;
        }

        public final Builder m18389q() {
            this.f11727e = true;
            return this;
        }

        public final Builder m18377b(int i, int i2) {
            this.f11726d.m18362a(i, i2);
            return this;
        }

        public final SimplePickerLauncherConfiguration m18390r() {
            return new SimplePickerLauncherConfiguration(this);
        }
    }

    @Nullable
    public final SimplePickerConfiguration m18392f() {
        return this.f11732d;
    }

    public SimplePickerLauncherConfiguration(Builder builder) {
        boolean z;
        boolean z2 = true;
        this.f11732d = new SimplePickerConfiguration(builder.f11726d);
        ComposerConfiguration composerConfiguration = builder.f11723a;
        if (this.f11732d == null || this.f11732d.f11702c) {
            z = false;
        } else {
            z = true;
        }
        if (builder.f11724b != Action.LAUNCH_COMPOSER) {
            z2 = false;
        }
        this.f11729a = m18391a(composerConfiguration, z, z2);
        this.f11730b = builder.f11724b;
        this.f11731c = builder.f11725c;
        this.f11733e = builder.f11727e;
        this.f11734f = builder.f11728f;
    }

    private static ComposerConfiguration m18391a(ComposerConfiguration composerConfiguration, boolean z, boolean z2) {
        if (!z2) {
            return composerConfiguration;
        }
        Preconditions.checkNotNull(composerConfiguration, "A composer configuration must be provided in order to launch the composer");
        com.facebook.ipc.composer.intent.ComposerConfiguration.Builder launchLoggingParams = ComposerConfiguration.m18225a(composerConfiguration).setLaunchLoggingParams(ComposerLaunchLoggingParams.a(composerConfiguration.getLaunchLoggingParams()).setEntryPicker(ComposerEntryPicker.MEDIA_PICKER).a());
        boolean z3 = composerConfiguration.shouldDisableFriendTagging() || z;
        return launchLoggingParams.setDisableFriendTagging(z3).m18223a();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f11729a, i);
        parcel.writeInt(this.f11730b.ordinal());
        parcel.writeParcelable(this.f11731c, i);
        parcel.writeParcelable(this.f11732d, i);
        ParcelUtil.a(parcel, this.f11733e);
        ParcelUtil.a(parcel, this.f11734f);
    }

    public SimplePickerLauncherConfiguration(Parcel parcel) {
        this.f11729a = (ComposerConfiguration) parcel.readParcelable(ComposerConfiguration.class.getClassLoader());
        this.f11730b = Action.values()[parcel.readInt()];
        this.f11731c = (ExpirationState) parcel.readParcelable(ExpirationState.class.getClassLoader());
        this.f11732d = (SimplePickerConfiguration) parcel.readParcelable(SimplePickerConfiguration.class.getClassLoader());
        this.f11733e = ParcelUtil.a(parcel);
        this.f11734f = ParcelUtil.a(parcel);
    }
}
