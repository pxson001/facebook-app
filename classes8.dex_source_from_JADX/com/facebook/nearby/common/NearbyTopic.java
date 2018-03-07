package com.facebook.nearby.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.GraphQLPage;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/* compiled from: disable_tagged_media_set */
public class NearbyTopic implements Parcelable {
    public static final Creator<NearbyTopic> CREATOR = new C16731();
    public final String f15285a;
    public final ImmutableSet<Long> f15286b;

    /* compiled from: disable_tagged_media_set */
    final class C16731 implements Creator<NearbyTopic> {
        C16731() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyTopic(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyTopic[i];
        }
    }

    public NearbyTopic(GraphQLPage graphQLPage) {
        Preconditions.checkNotNull(graphQLPage.ae());
        this.f15285a = (String) Preconditions.checkNotNull(graphQLPage.aG());
        this.f15286b = ImmutableSet.of(Long.valueOf(Long.parseLong(graphQLPage.ae())));
    }

    public NearbyTopic(Set<Long> set, String str) {
        Preconditions.checkNotNull(set);
        this.f15285a = (String) Preconditions.checkNotNull(str);
        this.f15286b = ImmutableSet.copyOf(set);
    }

    public NearbyTopic(Parcel parcel) {
        this.f15286b = ImmutableSet.copyOf(parcel.readArrayList(Long.class.getClassLoader()));
        this.f15285a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15286b, this.f15285a});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        NearbyTopic nearbyTopic = (NearbyTopic) obj;
        if (Objects.equal(nearbyTopic.f15286b, this.f15286b) && Objects.equal(nearbyTopic.f15285a, this.f15285a)) {
            return true;
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f15286b.asList());
        parcel.writeString(this.f15285a);
    }
}
