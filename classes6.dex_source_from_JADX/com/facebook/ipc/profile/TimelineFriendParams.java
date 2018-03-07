package com.facebook.ipc.profile;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;

/* compiled from: latestMapZoom */
public class TimelineFriendParams implements Parcelable {
    public static final Creator<TimelineFriendParams> CREATOR = new C07461();
    public final long f11671a;
    public final ParcelUuid f11672b;
    public final String f11673c;
    public final GraphQLSubscribeStatus f11674d;
    public final GraphQLFriendshipStatus f11675e;

    /* compiled from: latestMapZoom */
    final class C07461 implements Creator<TimelineFriendParams> {
        C07461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TimelineFriendParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new TimelineFriendParams[i];
        }
    }

    private TimelineFriendParams(long j, ParcelUuid parcelUuid, String str, GraphQLSubscribeStatus graphQLSubscribeStatus, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        this.f11671a = j;
        this.f11672b = parcelUuid;
        this.f11673c = str;
        this.f11674d = graphQLSubscribeStatus;
        this.f11675e = graphQLFriendshipStatus;
    }

    public TimelineFriendParams(Parcel parcel) {
        this.f11671a = parcel.readLong();
        this.f11672b = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
        this.f11673c = parcel.readString();
        this.f11674d = GraphQLSubscribeStatus.fromString(parcel.readString());
        this.f11675e = GraphQLFriendshipStatus.fromString(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f11671a);
        parcel.writeParcelable(this.f11672b, i);
        parcel.writeString(this.f11673c);
        parcel.writeString(this.f11674d.name());
        parcel.writeString(this.f11675e.name());
    }

    public static TimelineFriendParams m18358a(TimelineContext timelineContext, String str, GraphQLSubscribeStatus graphQLSubscribeStatus, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        return new TimelineFriendParams(timelineContext.f11667b, timelineContext.f11669d, str, graphQLSubscribeStatus, graphQLFriendshipStatus);
    }
}
