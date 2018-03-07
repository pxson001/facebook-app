package com.facebook.nearby.v2.logging;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.search.results.model.SearchResultsMutableContext;

/* compiled from: disable_adding_photos_to_albums */
public class NearbyPlacesSession implements Parcelable {
    public static final Creator<NearbyPlacesSession> CREATOR = new C16751();
    public EntryPoint f15291a;
    public ImpressionSource f15292b;
    public String f15293c;
    public SearchResultsMutableContext f15294d;

    /* compiled from: disable_adding_photos_to_albums */
    final class C16751 implements Creator<NearbyPlacesSession> {
        C16751() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlacesSession(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlacesSession[i];
        }
    }

    /* compiled from: disable_adding_photos_to_albums */
    public enum EntryPoint {
        BOOKMARK("bookmarks"),
        CITY_GUIDE("cityguide"),
        REACTION("reaction"),
        SEARCH_SUGGESTION("searchSuggestion"),
        UNKNOWN("unknown");
        
        private String mValue;

        private EntryPoint(String str) {
            this.mValue = str;
        }

        public final String getValue() {
            return this.mValue;
        }
    }

    /* compiled from: disable_adding_photos_to_albums */
    public enum ImpressionSource {
        open,
        tab_bar_tap,
        nearby_places
    }

    public NearbyPlacesSession(EntryPoint entryPoint, ImpressionSource impressionSource) {
        this(entryPoint, impressionSource, null);
    }

    public NearbyPlacesSession(EntryPoint entryPoint, ImpressionSource impressionSource, SearchResultsMutableContext searchResultsMutableContext) {
        this.f15291a = entryPoint;
        this.f15292b = impressionSource;
        this.f15293c = SafeUUIDGenerator.a().toString();
        this.f15294d = searchResultsMutableContext;
    }

    public NearbyPlacesSession(Parcel parcel) {
        this.f15291a = (EntryPoint) parcel.readSerializable();
        this.f15292b = (ImpressionSource) parcel.readSerializable();
        this.f15293c = parcel.readString();
    }

    public final void m17731e() {
        this.f15293c = SafeUUIDGenerator.a().toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f15291a);
        parcel.writeSerializable(this.f15292b);
        parcel.writeString(this.f15293c);
    }

    public int describeContents() {
        return 0;
    }
}
