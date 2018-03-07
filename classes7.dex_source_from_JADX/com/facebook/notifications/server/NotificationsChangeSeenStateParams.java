package com.facebook.notifications.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: month_text */
public class NotificationsChangeSeenStateParams implements Parcelable {
    public static final Creator<NotificationsChangeSeenStateParams> CREATOR = new C07011();
    public final ImmutableList<String> f8693a;
    public final GraphQLStorySeenState f8694b;

    /* compiled from: month_text */
    final class C07011 implements Creator<NotificationsChangeSeenStateParams> {
        C07011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NotificationsChangeSeenStateParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new NotificationsChangeSeenStateParams[i];
        }
    }

    public NotificationsChangeSeenStateParams(Collection<String> collection, GraphQLStorySeenState graphQLStorySeenState) {
        Preconditions.checkNotNull(graphQLStorySeenState);
        this.f8693a = ImmutableList.copyOf(collection);
        this.f8694b = graphQLStorySeenState;
    }

    public NotificationsChangeSeenStateParams(Parcel parcel) {
        this.f8694b = GraphQLStorySeenState.valueOf(parcel.readString());
        Collection arrayList = new ArrayList();
        parcel.readList(arrayList, null);
        this.f8693a = ImmutableList.copyOf(arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8694b.name());
        parcel.writeList(this.f8693a);
    }
}
