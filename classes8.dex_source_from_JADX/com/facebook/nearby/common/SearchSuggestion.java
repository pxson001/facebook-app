package com.facebook.nearby.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLNearbySearchSuggestion;
import com.google.common.base.Objects;

/* compiled from: disable_story_menu_actions */
public class SearchSuggestion implements Parcelable {
    public static final Creator<SearchSuggestion> CREATOR = new C16741();
    public final String f15287a;
    public final String f15288b;
    public final GraphQLGeoRectangle f15289c;
    public final NearbyTopic f15290d;

    /* compiled from: disable_story_menu_actions */
    final class C16741 implements Creator<SearchSuggestion> {
        C16741() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SearchSuggestion(parcel);
        }

        public final Object[] newArray(int i) {
            return new SearchSuggestion[i];
        }
    }

    public SearchSuggestion(String str, String str2, GraphQLGeoRectangle graphQLGeoRectangle, NearbyTopic nearbyTopic) {
        this.f15287a = str;
        this.f15288b = str2;
        this.f15289c = graphQLGeoRectangle;
        this.f15290d = nearbyTopic;
    }

    public SearchSuggestion(GraphQLNearbySearchSuggestion graphQLNearbySearchSuggestion) {
        this.f15287a = graphQLNearbySearchSuggestion.j().a();
        this.f15288b = graphQLNearbySearchSuggestion.k().a();
        this.f15289c = graphQLNearbySearchSuggestion.a();
        this.f15290d = graphQLNearbySearchSuggestion.l() == null ? null : new NearbyTopic(graphQLNearbySearchSuggestion.l());
    }

    public SearchSuggestion(Parcel parcel) {
        this.f15289c = (GraphQLGeoRectangle) FlatBufferModelHelper.a(parcel);
        this.f15288b = parcel.readString();
        this.f15287a = parcel.readString();
        this.f15290d = (NearbyTopic) parcel.readParcelable(NearbyTopic.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.f15289c);
        parcel.writeString(this.f15288b);
        parcel.writeString(this.f15287a);
        parcel.writeParcelable(this.f15290d, i);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15287a, this.f15288b, this.f15289c, this.f15290d});
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SearchSuggestion)) {
            return false;
        }
        SearchSuggestion searchSuggestion = (SearchSuggestion) obj;
        if (Objects.equal(searchSuggestion.f15287a, this.f15287a) && Objects.equal(searchSuggestion.f15288b, this.f15288b) && GraphQLHelper.a(searchSuggestion.f15289c, this.f15289c) && Objects.equal(searchSuggestion.f15290d, this.f15290d)) {
            return true;
        }
        return false;
    }
}
