package com.facebook.location;

import android.location.Location;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Absent;
import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.math.DoubleMath;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: requestName */
public class ImmutableLocation implements Parcelable {
    public static final Creator<ImmutableLocation> CREATOR = new C03111();
    public final Location f7356a;
    private final long f7357b;
    private final long f7358c;
    private final float f7359d;

    /* compiled from: requestName */
    final class C03111 implements Creator<ImmutableLocation> {
        C03111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ImmutableLocation(parcel);
        }

        public final Object[] newArray(int i) {
            return new ImmutableLocation[i];
        }
    }

    public static ImmutableLocation m11980a(Location location) {
        Preconditions.checkNotNull(location);
        return new ImmutableLocation(location);
    }

    @Nullable
    public static ImmutableLocation m11981b(@Nullable Location location) {
        if (location == null) {
            return null;
        }
        return m11980a(location);
    }

    @Nullable
    static ImmutableLocation m11982c(@Nullable Location location) {
        if (LocationValidityUtil.m11965a(location)) {
            return m11980a(location);
        }
        return null;
    }

    public static Builder m11979a(double d, double d2) {
        return new Builder(d, d2);
    }

    public final double m11984a() {
        return this.f7356a.getLatitude();
    }

    public final double m11985b() {
        return this.f7356a.getLongitude();
    }

    public final Optional<Float> m11986c() {
        if (this.f7356a.hasAccuracy()) {
            return Optional.of(Float.valueOf(this.f7356a.getAccuracy()));
        }
        return Absent.INSTANCE;
    }

    public final Optional<Double> m11987d() {
        if (this.f7356a.hasAltitude()) {
            return Optional.of(Double.valueOf(this.f7356a.getAltitude()));
        }
        return Absent.INSTANCE;
    }

    public final Optional<Float> m11988e() {
        if (this.f7356a.hasBearing()) {
            return Optional.of(Float.valueOf(this.f7356a.getBearing()));
        }
        return Absent.INSTANCE;
    }

    public final Optional<Float> m11989f() {
        if (this.f7356a.hasSpeed()) {
            return Optional.of(Float.valueOf(this.f7356a.getSpeed()));
        }
        return Absent.INSTANCE;
    }

    public final Optional<Long> m11990g() {
        long time = this.f7356a.getTime();
        if (time == 0) {
            return Absent.INSTANCE;
        }
        return Optional.of(Long.valueOf(time));
    }

    public final Optional<Long> m11991h() {
        if (VERSION.SDK_INT < 17) {
            return Absent.INSTANCE;
        }
        Optional<Long> optional;
        Preconditions.checkState(VERSION.SDK_INT >= 17);
        long elapsedRealtimeNanos = this.f7356a.getElapsedRealtimeNanos();
        if (elapsedRealtimeNanos == 0) {
            optional = Absent.INSTANCE;
        } else {
            optional = Optional.of(Long.valueOf(elapsedRealtimeNanos));
        }
        return optional;
    }

    public final Optional<Long> m11992i() {
        return this.f7357b == 0 ? Absent.INSTANCE : Optional.of(Long.valueOf(this.f7357b));
    }

    public final Optional<Long> m11993j() {
        return this.f7358c == 0 ? Absent.INSTANCE : Optional.of(Long.valueOf(this.f7358c));
    }

    public final Optional<Float> m11994k() {
        return DoubleMath.a((double) this.f7359d, 0.0d, 0.001d) ? Absent.INSTANCE : Optional.of(Float.valueOf(this.f7359d));
    }

    public final Location m11995l() {
        return m11983d(this.f7356a);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("location", this.f7356a).add("geofenceStartTimestampMs", this.f7357b).add("geofenceEndTimestampMs", this.f7358c).add("geofenceRadiusMeters", this.f7359d).toString();
    }

    private ImmutableLocation(Location location) {
        this(location, 0, 0, Float.MIN_VALUE);
    }

    private ImmutableLocation(Location location, long j, long j2, float f) {
        boolean z = (location.getLatitude() == 0.0d && location.getLongitude() == 0.0d) ? false : true;
        Preconditions.checkArgument(z, "location must have latitude/longitude");
        this.f7356a = m11983d(location);
        this.f7357b = j;
        this.f7358c = j2;
        this.f7359d = f;
    }

    private static Location m11983d(Location location) {
        return new Location(location);
    }

    public ImmutableLocation(Parcel parcel) {
        this((Location) Preconditions.checkNotNull(parcel.readParcelable(Location.class.getClassLoader())), parcel.readLong(), parcel.readLong(), parcel.readFloat());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(m11995l(), i);
        parcel.writeLong(this.f7357b);
        parcel.writeLong(this.f7358c);
        parcel.writeFloat(this.f7359d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImmutableLocation)) {
            return false;
        }
        ImmutableLocation immutableLocation = (ImmutableLocation) obj;
        if (this.f7359d == immutableLocation.f7359d && this.f7357b == immutableLocation.f7357b && this.f7358c == immutableLocation.f7358c && this.f7356a.equals(immutableLocation.f7356a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f7356a == null ? 0 : this.f7356a.hashCode()) + 527) * 31) + ((int) (this.f7357b ^ (this.f7357b >> 32)))) * 31) + ((int) (this.f7358c ^ (this.f7358c >> 32)))) * 31) + Float.floatToIntBits(this.f7359d);
    }
}
