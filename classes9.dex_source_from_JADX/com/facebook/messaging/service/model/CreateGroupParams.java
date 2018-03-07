package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.user.model.UserIdentifier;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: payments_reliability */
public class CreateGroupParams implements Parcelable {
    public static final Creator<CreateGroupParams> CREATOR = new C19941();
    public final String f17017a;
    public final MediaResource f17018b;
    public final ImmutableList<UserIdentifier> f17019c;
    public final boolean f17020d;
    public final boolean f17021e;

    /* compiled from: payments_reliability */
    final class C19941 implements Creator<CreateGroupParams> {
        C19941() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreateGroupParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreateGroupParams[i];
        }
    }

    public static CreateGroupParams m17081a(String str, MediaResource mediaResource, List<UserIdentifier> list) {
        return new CreateGroupParams(str, mediaResource, list, false, false);
    }

    private CreateGroupParams(String str, MediaResource mediaResource, List<UserIdentifier> list, boolean z, boolean z2) {
        this.f17017a = str;
        this.f17018b = mediaResource;
        this.f17019c = ImmutableList.copyOf(list);
        this.f17020d = z;
        this.f17021e = z2;
    }

    public CreateGroupParams(Parcel parcel) {
        this.f17017a = parcel.readString();
        this.f17018b = (MediaResource) parcel.readParcelable(MediaResource.class.getClassLoader());
        this.f17019c = ImmutableList.copyOf(parcel.readArrayList(String.class.getClassLoader()));
        this.f17020d = ParcelUtil.a(parcel);
        this.f17021e = ParcelUtil.a(parcel);
    }

    public final ImmutableList<UserIdentifier> m17082c() {
        return this.f17019c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17017a);
        parcel.writeParcelable(this.f17018b, i);
        parcel.writeList(this.f17019c);
        ParcelUtil.a(parcel, this.f17020d);
        ParcelUtil.a(parcel, this.f17021e);
    }
}
