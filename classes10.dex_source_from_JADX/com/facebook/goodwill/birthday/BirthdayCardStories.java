package com.facebook.goodwill.birthday;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;

/* compiled from: WEBVIEW_BANNER_250 */
public class BirthdayCardStories implements Parcelable {
    public static final Creator<BirthdayCardStories> CREATOR = new C29971();
    public final ImmutableList<GraphQLFeedUnitEdge> f21050a;
    public final BirthdayCardResources f21051b;
    public final GraphQLPageInfo f21052c;

    /* compiled from: WEBVIEW_BANNER_250 */
    final class C29971 implements Creator<BirthdayCardStories> {
        C29971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BirthdayCardStories(parcel);
        }

        public final Object[] newArray(int i) {
            return new BirthdayCardStories[i];
        }
    }

    public BirthdayCardStories(ImmutableList<GraphQLFeedUnitEdge> immutableList, BirthdayCardResources birthdayCardResources, GraphQLPageInfo graphQLPageInfo) {
        this.f21050a = immutableList;
        this.f21051b = birthdayCardResources;
        this.f21052c = graphQLPageInfo;
    }

    public BirthdayCardStories(Parcel parcel) {
        ImmutableList immutableList;
        Collection readArrayList = parcel.readArrayList(GraphQLFeedUnitEdge.class.getClassLoader());
        if (readArrayList == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList);
        }
        this.f21050a = immutableList;
        this.f21051b = (BirthdayCardResources) parcel.readParcelable(BirthdayCardResources.class.getClassLoader());
        this.f21052c = (GraphQLPageInfo) FlatBufferModelHelper.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f21050a);
        parcel.writeParcelable(this.f21051b, i);
        FlatBufferModelHelper.a(parcel, this.f21052c);
    }
}
