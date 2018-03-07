package com.facebook.friendsnearby.pingdialog;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLLocationPingType;
import com.facebook.location.ImmutableLocation;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: \d* */
public class LocationPingParams implements Parcelable {
    public static final Creator<LocationPingParams> CREATOR = new C29371();
    public final String f20620a;
    public final LocationPingTime f20621b;
    public final Optional<ImmutableLocation> f20622c;
    public final Optional<String> f20623d;

    /* compiled from: \d* */
    final class C29371 implements Creator<LocationPingParams> {
        C29371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LocationPingParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new LocationPingParams[i];
        }
    }

    public static LocationPingParams m21038a(String str, GraphQLLocationPingType graphQLLocationPingType, long j, String str2, long j2) {
        Optional optional;
        if (StringUtil.c(str)) {
            optional = Absent.INSTANCE;
        } else {
            optional = Optional.of(str);
        }
        return new LocationPingParams(str2, LocationPingTime.m21041a(graphQLLocationPingType, j, j2), Absent.INSTANCE, optional);
    }

    public LocationPingParams(String str, LocationPingTime locationPingTime, Optional<ImmutableLocation> optional, Optional<String> optional2) {
        this.f20620a = str;
        this.f20621b = locationPingTime;
        this.f20622c = optional;
        this.f20623d = optional2;
    }

    public LocationPingParams(Parcel parcel) {
        this.f20620a = parcel.readString();
        this.f20621b = (LocationPingTime) parcel.readParcelable(LocationPingTime.class.getClassLoader());
        this.f20622c = Optional.fromNullable((ImmutableLocation) parcel.readParcelable(ImmutableLocation.class.getClassLoader()));
        this.f20623d = Optional.fromNullable(parcel.readString());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f20620a);
        parcel.writeParcelable(this.f20621b, i);
        parcel.writeParcelable((Parcelable) this.f20622c.orNull(), i);
        parcel.writeString((String) this.f20623d.orNull());
    }

    public int describeContents() {
        return 0;
    }
}
