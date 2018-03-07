package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: open_person_options */
public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, Builder> {
    public static final Creator<ShareOpenGraphAction> CREATOR = new C06211();

    /* compiled from: open_person_options */
    final class C06211 implements Creator<ShareOpenGraphAction> {
        C06211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShareOpenGraphAction(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShareOpenGraphAction[i];
        }
    }

    /* compiled from: open_person_options */
    public final class Builder extends com.facebook.share.model.ShareOpenGraphValueContainer.Builder<ShareOpenGraphAction, Builder> {
        private Builder m5827a(ShareOpenGraphAction shareOpenGraphAction) {
            if (shareOpenGraphAction == null) {
                return this;
            }
            Builder builder = (Builder) super.mo116a(shareOpenGraphAction);
            String string = shareOpenGraphAction.f4597a.getString("og:type");
            builder.f4596a.putString("og:type", string);
            return builder;
        }

        public final Builder m5828a(Parcel parcel) {
            return m5827a((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
        }
    }

    public ShareOpenGraphAction(Builder builder) {
        super((com.facebook.share.model.ShareOpenGraphValueContainer.Builder) builder);
    }

    ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }
}
