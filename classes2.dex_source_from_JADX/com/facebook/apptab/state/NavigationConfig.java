package com.facebook.apptab.state;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.build.BuildConstants;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.Collection;

/* compiled from: resolvers_serialized */
public class NavigationConfig implements Parcelable {
    public static final Creator<NavigationConfig> CREATOR = new C03001();
    public final ImmutableList<TabTag> f7048a;
    private boolean f7049b;

    /* compiled from: resolvers_serialized */
    final class C03001 implements Creator<NavigationConfig> {
        C03001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NavigationConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new NavigationConfig[i];
        }
    }

    public NavigationConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f7049b = z;
        this.f7048a = m11581a(z2, z3, z4, z5, z6, z7);
    }

    public NavigationConfig(Parcel parcel) {
        Collection a = Lists.m1296a();
        parcel.readList(a, TabTag.class.getClassLoader());
        this.f7048a = ImmutableList.copyOf(a);
    }

    public final boolean m11582a() {
        return (this.f7048a.contains(TabTag.FriendRequests) || this.f7048a.contains(TabTag.NotificationsFriending) || this.f7048a.contains(TabTag.Notifications)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NavigationConfig)) {
            return false;
        }
        return Objects.equal(this.f7048a, ((NavigationConfig) obj).f7048a);
    }

    public int hashCode() {
        return Objects.hashCode(this.f7048a);
    }

    private ImmutableList<TabTag> m11581a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        Builder builder = ImmutableList.builder();
        builder.m1069c(TabTag.Feed);
        if (z) {
            builder.m1069c(TabTag.RedSpace);
        }
        if (z6 && !BuildConstants.j) {
            builder.m1069c(TabTag.FriendRequests);
        }
        if (z2) {
            builder.m1069c(TabTag.VideoHome);
        }
        if (z3) {
            builder.m1069c(TabTag.Marketplace);
        }
        if (z5) {
            builder.m1069c(TabTag.WorkGroups);
        }
        if (!z4 || BuildConstants.j) {
            builder.m1069c(TabTag.Notifications);
        } else {
            builder.m1069c(TabTag.NotificationsFriending);
        }
        builder.m1069c(TabTag.Bookmark);
        ImmutableList<TabTag> b = builder.m1068b();
        return this.f7049b ? b.reverse() : b;
    }

    public final boolean m11583f() {
        return this.f7049b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f7048a);
    }
}
