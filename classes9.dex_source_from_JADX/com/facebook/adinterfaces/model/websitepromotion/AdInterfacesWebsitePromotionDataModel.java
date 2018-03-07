package com.facebook.adinterfaces.model.websitepromotion;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.HasWebsiteUrl;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;

/* compiled from: [packed = true] can only be specified for repeated primitive fields. */
public class AdInterfacesWebsitePromotionDataModel extends AdInterfacesBoostedComponentDataModel implements HasWebsiteUrl {
    public static final Creator<AdInterfacesWebsitePromotionDataModel> CREATOR = new C25171();
    private String f21813a;

    /* compiled from: [packed = true] can only be specified for repeated primitive fields. */
    final class C25171 implements Creator<AdInterfacesWebsitePromotionDataModel> {
        C25171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AdInterfacesWebsitePromotionDataModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new AdInterfacesWebsitePromotionDataModel[i];
        }
    }

    /* compiled from: [packed = true] can only be specified for repeated primitive fields. */
    public class Builder extends com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel.Builder {
        public final BaseAdInterfacesData mo950a() {
            return new AdInterfacesWebsitePromotionDataModel(this);
        }
    }

    public AdInterfacesWebsitePromotionDataModel(Builder builder) {
        super((com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel.Builder) builder);
    }

    protected AdInterfacesWebsitePromotionDataModel(Parcel parcel) {
        super(parcel);
        this.f21813a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f21813a);
    }

    public final void c_(String str) {
        this.f21813a = str;
    }

    public final boolean mJ_() {
        return true;
    }

    public final int mK_() {
        return 2131234057;
    }

    public final String mI_() {
        return this.f21813a;
    }
}
