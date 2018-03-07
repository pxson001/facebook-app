package com.facebook.friendsnearby.pingdialog;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.friendsnearby.pingdialog.graphql.FriendsNearbyPingGraphQLModels.OutgoingLocationPingModel;
import com.facebook.graphql.enums.GraphQLLocationPingType;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: [checkmark_placeholder] */
public class LocationPingTime implements Parcelable {
    public static final Creator<LocationPingTime> CREATOR = new C29381();
    public final Type f20625a;
    public final Optional<Long> f20626b;

    /* compiled from: [checkmark_placeholder] */
    final class C29381 implements Creator<LocationPingTime> {
        C29381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LocationPingTime(parcel);
        }

        public final Object[] newArray(int i) {
            return new LocationPingTime[i];
        }
    }

    /* compiled from: [checkmark_placeholder] */
    /* synthetic */ class C29392 {
        static final /* synthetic */ int[] f20624a = new int[GraphQLLocationPingType.values().length];

        static {
            try {
                f20624a[GraphQLLocationPingType.DURATION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20624a[GraphQLLocationPingType.FOREVER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: [checkmark_placeholder] */
    public enum Type {
        STOP,
        DURATION,
        FOREVER
    }

    public static LocationPingTime m21039a(long j) {
        return new LocationPingTime(Type.DURATION, Optional.of(Long.valueOf(j)));
    }

    public static LocationPingTime m21042b() {
        return new LocationPingTime(Type.FOREVER, Absent.INSTANCE);
    }

    public static LocationPingTime m21040a(OutgoingLocationPingModel outgoingLocationPingModel, long j) {
        switch (C29392.f20624a[outgoingLocationPingModel.m21091a().ordinal()]) {
            case 1:
                return m21039a((((long) outgoingLocationPingModel.m21094b()) * 1000) + j);
            case 2:
                return m21042b();
            default:
                throw new IllegalArgumentException("Invalid ping type");
        }
    }

    public static LocationPingTime m21041a(GraphQLLocationPingType graphQLLocationPingType, long j, long j2) {
        switch (C29392.f20624a[graphQLLocationPingType.ordinal()]) {
            case 1:
                return m21039a(j2 + j);
            case 2:
                return m21042b();
            default:
                throw new IllegalArgumentException("Invalid ping type");
        }
    }

    public LocationPingTime(Type type, Optional<Long> optional) {
        this.f20625a = type;
        this.f20626b = optional;
    }

    public LocationPingTime(Parcel parcel) {
        Optional optional;
        this.f20625a = Type.valueOf(parcel.readString());
        String readString = parcel.readString();
        if (readString == null) {
            optional = Absent.INSTANCE;
        } else {
            optional = Optional.of(Long.valueOf(Long.parseLong(readString)));
        }
        this.f20626b = optional;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f20625a.toString());
        parcel.writeString(this.f20626b.isPresent() ? this.f20626b.toString() : null);
    }
}
