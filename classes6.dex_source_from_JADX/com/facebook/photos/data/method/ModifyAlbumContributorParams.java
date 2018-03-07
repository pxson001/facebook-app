package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: hubID */
public class ModifyAlbumContributorParams implements Parcelable {
    public static final Creator<ModifyAlbumContributorParams> CREATOR = new C08391();
    public final ImmutableList<String> f12949a;
    public final String f12950b;
    public final ModifyContributorOperationType f12951c;

    /* compiled from: hubID */
    final class C08391 implements Creator<ModifyAlbumContributorParams> {
        C08391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ModifyAlbumContributorParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ModifyAlbumContributorParams[i];
        }
    }

    /* compiled from: hubID */
    public class Builder {
        public ImmutableList<String> f12946a;
        public String f12947b;
        public ModifyContributorOperationType f12948c;

        public static Builder m20321a(ModifyAlbumContributorParams modifyAlbumContributorParams) {
            Builder builder = new Builder();
            builder.f12946a = modifyAlbumContributorParams.f12949a;
            builder.f12947b = modifyAlbumContributorParams.f12950b;
            builder.f12948c = modifyAlbumContributorParams.f12951c;
            return builder;
        }

        public final Builder m20322a(String str) {
            this.f12947b = str;
            return this;
        }

        public final ModifyAlbumContributorParams m20323a() {
            return new ModifyAlbumContributorParams(this);
        }
    }

    /* compiled from: hubID */
    public enum ModifyContributorOperationType {
        ADD_OPERATION,
        DELETE_OPERATION,
        UNSET_OR_UNRECOGNIZED_ENUM_VALUE
    }

    public ModifyAlbumContributorParams(ImmutableList<String> immutableList, String str, ModifyContributorOperationType modifyContributorOperationType) {
        this.f12950b = str;
        this.f12951c = modifyContributorOperationType;
        this.f12949a = immutableList;
    }

    public ModifyAlbumContributorParams(Builder builder) {
        this.f12950b = builder.f12947b;
        this.f12949a = builder.f12946a;
        this.f12951c = builder.f12948c;
    }

    public ModifyAlbumContributorParams(Parcel parcel) {
        Collection a = Lists.a();
        parcel.readStringList(a);
        this.f12949a = ImmutableList.copyOf(a);
        this.f12950b = parcel.readString();
        this.f12951c = ModifyContributorOperationType.valueOf(parcel.readString());
        Preconditions.checkState(this.f12951c != ModifyContributorOperationType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f12949a);
        parcel.writeString(this.f12950b);
        parcel.writeString(this.f12951c.name());
    }
}
