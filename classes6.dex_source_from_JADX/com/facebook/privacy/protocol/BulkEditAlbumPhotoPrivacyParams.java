package com.facebook.privacy.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;

/* compiled from: sticker_store_tab_load_error */
public class BulkEditAlbumPhotoPrivacyParams implements Parcelable {
    public static final Creator<BulkEditAlbumPhotoPrivacyParams> CREATOR = new C02281();
    public String f4117a;
    public BulkEditCaller f4118b;
    public BulkEditAlbumType f4119c;
    public long f4120d;
    public String f4121e;
    public boolean f4122f;

    /* compiled from: sticker_store_tab_load_error */
    final class C02281 implements Creator<BulkEditAlbumPhotoPrivacyParams> {
        C02281() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BulkEditAlbumPhotoPrivacyParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new BulkEditAlbumPhotoPrivacyParams[i];
        }
    }

    /* compiled from: sticker_store_tab_load_error */
    public enum BulkEditAlbumType {
        PROFILE_PHOTO_ALBUM("PROFILE_PHOTO");
        
        private final String mAlbumName;

        private BulkEditAlbumType(String str) {
            this.mAlbumName = str;
        }

        public final String toString() {
            return this.mAlbumName;
        }
    }

    /* compiled from: sticker_store_tab_load_error */
    public enum BulkEditCaller {
        PROFILE_PHOTO_CHECKUP("FB4A_PROFILE_PHOTO_CHECKUP");
        
        private final String mCallerName;

        private BulkEditCaller(String str) {
            this.mCallerName = str;
        }

        public final String toString() {
            return this.mCallerName;
        }
    }

    public BulkEditAlbumPhotoPrivacyParams(@Nullable String str, BulkEditCaller bulkEditCaller, BulkEditAlbumType bulkEditAlbumType, long j, String str2) {
        this.f4117a = str;
        this.f4118b = bulkEditCaller;
        this.f4119c = bulkEditAlbumType;
        this.f4120d = j;
        this.f4121e = str2;
        this.f4122f = false;
    }

    public BulkEditAlbumPhotoPrivacyParams(Parcel parcel) {
        this.f4117a = parcel.readString();
        this.f4118b = (BulkEditCaller) parcel.readSerializable();
        this.f4119c = (BulkEditAlbumType) parcel.readSerializable();
        this.f4120d = parcel.readLong();
        this.f4121e = parcel.readString();
        this.f4122f = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4117a);
        parcel.writeSerializable(this.f4118b);
        parcel.writeSerializable(this.f4119c);
        parcel.writeLong(this.f4120d);
        parcel.writeString(this.f4121e);
        ParcelUtil.a(parcel, this.f4122f);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("fbid", this.f4117a).add("caller", this.f4118b).add("albumType", this.f4119c).add("clientTime", this.f4120d).add("privacyJson", this.f4121e).add("capsPrivacy", this.f4122f).toString();
    }
}
