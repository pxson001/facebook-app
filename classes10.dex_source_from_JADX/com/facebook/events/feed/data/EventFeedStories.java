package com.facebook.events.feed.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;

/* compiled from: com.facebook.ads.interstitial.impression.logged */
public class EventFeedStories implements Parcelable {
    public static final Creator<EventFeedStories> CREATOR = new C24521();
    public final ImmutableList<GraphQLFeedUnitEdge> f17371a;
    public final GraphQLPageInfo f17372b;
    public final DataFreshnessResult f17373c;

    /* compiled from: com.facebook.ads.interstitial.impression.logged */
    final class C24521 implements Creator<EventFeedStories> {
        C24521() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventFeedStories(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventFeedStories[i];
        }
    }

    public EventFeedStories(Parcel parcel) {
        ImmutableList immutableList;
        Collection readArrayList = parcel.readArrayList(getClass().getClassLoader());
        if (readArrayList == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList);
        }
        this.f17371a = immutableList;
        this.f17372b = (GraphQLPageInfo) FlatBufferModelHelper.a(parcel);
        this.f17373c = (DataFreshnessResult) parcel.readSerializable();
    }

    public EventFeedStories(ImmutableList<GraphQLFeedUnitEdge> immutableList, GraphQLPageInfo graphQLPageInfo, DataFreshnessResult dataFreshnessResult) {
        this.f17371a = immutableList;
        this.f17372b = graphQLPageInfo;
        this.f17373c = dataFreshnessResult;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17371a);
        FlatBufferModelHelper.a(parcel, this.f17372b);
        parcel.writeSerializable(this.f17373c);
    }
}
