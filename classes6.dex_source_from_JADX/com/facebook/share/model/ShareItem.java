package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: server_died */
public class ShareItem implements Parcelable {
    public static final Creator<ShareItem> CREATOR = new C02991();
    public final String f4904a;
    public final String f4905b;
    public final String f4906c;
    public final String f4907d;
    public final String f4908e;
    public final String f4909f;
    public final String f4910g;
    public final boolean f4911h;
    public final ComposerAppAttribution f4912i;
    public final OpenGraphShareItemData f4913j;

    /* compiled from: server_died */
    final class C02991 implements Creator<ShareItem> {
        C02991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShareItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShareItem[i];
        }
    }

    public ShareItem(Parcel parcel) {
        this.f4904a = parcel.readString();
        this.f4905b = parcel.readString();
        this.f4906c = parcel.readString();
        this.f4907d = parcel.readString();
        this.f4908e = parcel.readString();
        this.f4909f = parcel.readString();
        this.f4910g = parcel.readString();
        this.f4911h = ParcelUtil.a(parcel);
        this.f4912i = (ComposerAppAttribution) parcel.readParcelable(ComposerAppAttribution.class.getClassLoader());
        this.f4913j = (OpenGraphShareItemData) parcel.readParcelable(OpenGraphShareItemData.class.getClassLoader());
    }

    public ShareItem(ShareItemBuilder shareItemBuilder) {
        this.f4904a = shareItemBuilder.f4914a;
        this.f4905b = shareItemBuilder.f4915b;
        this.f4906c = shareItemBuilder.f4916c;
        this.f4907d = shareItemBuilder.f4917d;
        this.f4908e = shareItemBuilder.f4918e;
        this.f4909f = shareItemBuilder.f4919f;
        this.f4910g = shareItemBuilder.f4920g;
        this.f4911h = shareItemBuilder.f4921h;
        this.f4912i = shareItemBuilder.f4922i;
        this.f4913j = shareItemBuilder.f4923j;
    }

    public final String m7703a() {
        if (this.f4909f == null) {
            return null;
        }
        String[] split = this.f4909f.split("_");
        if (split.length >= 2) {
            return split[1];
        }
        return this.f4909f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4904a);
        parcel.writeString(this.f4905b);
        parcel.writeString(this.f4906c);
        parcel.writeString(this.f4907d);
        parcel.writeString(this.f4908e);
        parcel.writeString(this.f4909f);
        parcel.writeString(this.f4910g);
        ParcelUtil.a(parcel, this.f4911h);
        parcel.writeParcelable(this.f4912i, i);
        parcel.writeParcelable(this.f4913j, i);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("ShareItem{");
        stringBuilder.append("title='").append(this.f4904a).append('\'');
        stringBuilder.append(", subTitle='").append(this.f4905b).append('\'');
        stringBuilder.append(", summary='").append(this.f4906c).append('\'');
        stringBuilder.append(", imageUrl='").append(this.f4907d).append('\'');
        stringBuilder.append(", clickTarget='").append(this.f4908e).append('\'');
        stringBuilder.append(", shareLegacyAPIStoryId='").append(this.f4909f).append('\'');
        return stringBuilder.toString();
    }
}
