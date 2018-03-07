package com.facebook.messaging.events.banner;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLLightweightEventGuestStatus;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: special */
public class EventReminderMembers implements Parcelable {
    public static final Creator<EventReminderMembers> CREATOR = new C03871();
    public final GraphQLLightweightEventGuestStatus f2309a;
    public final ImmutableList<User> f2310b;
    public final ImmutableList<User> f2311c;
    public final ImmutableList<User> f2312d;

    /* compiled from: special */
    final class C03871 implements Creator<EventReminderMembers> {
        C03871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventReminderMembers(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventReminderMembers[i];
        }
    }

    public EventReminderMembers(GraphQLLightweightEventGuestStatus graphQLLightweightEventGuestStatus, ImmutableList<User> immutableList, ImmutableList<User> immutableList2, ImmutableList<User> immutableList3) {
        this.f2309a = graphQLLightweightEventGuestStatus;
        this.f2310b = immutableList;
        this.f2311c = immutableList2;
        this.f2312d = immutableList3;
    }

    protected EventReminderMembers(Parcel parcel) {
        this.f2309a = GraphQLLightweightEventGuestStatus.valueOf(parcel.readString());
        this.f2310b = ImmutableList.copyOf(parcel.createTypedArrayList(User.CREATOR));
        this.f2311c = ImmutableList.copyOf(parcel.createTypedArrayList(User.CREATOR));
        this.f2312d = ImmutableList.copyOf(parcel.createTypedArrayList(User.CREATOR));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2309a.toString());
        parcel.writeTypedList(this.f2310b);
        parcel.writeTypedList(this.f2311c);
        parcel.writeTypedList(this.f2312d);
    }
}
