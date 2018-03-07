package com.facebook.ipc.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;

@AutoGenJsonDeserializer
@JsonDeserialize(using = GeoRegionDeserializer.class)
/* compiled from: THROWBACK_NOTIFICATION */
public class GeoRegion {
    @JsonProperty("abbr_name")
    public final String abbrName = null;
    @JsonProperty("page_fbid")
    public final long id = -1;
    @JsonProperty("type")
    public final String type = null;

    @AutoGenJsonDeserializer
    @AutoGenJsonSerializer
    @JsonDeserialize(using = GeoRegion_ImplicitLocationDeserializer.class)
    @JsonSerialize(using = GeoRegion_ImplicitLocationSerializer.class)
    /* compiled from: THROWBACK_NOTIFICATION */
    public class ImplicitLocation implements Parcelable {
        @JsonIgnore
        public static final Creator<ImplicitLocation> CREATOR = new C13471();
        @JsonProperty("label")
        public final String label;
        @JsonProperty("page_id")
        public final long pageId;

        /* compiled from: THROWBACK_NOTIFICATION */
        final class C13471 implements Creator<ImplicitLocation> {
            C13471() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new ImplicitLocation(parcel);
            }

            public final Object[] newArray(int i) {
                return new ImplicitLocation[i];
            }
        }

        /* compiled from: THROWBACK_NOTIFICATION */
        public class Builder {
            public final String f14074a;
            public final long f14075b;

            public Builder(String str, long j) {
                this.f14074a = str;
                this.f14075b = j;
            }

            public final ImplicitLocation m23439a() {
                return new ImplicitLocation(this);
            }
        }

        public static Builder m23440a(String str, long j) {
            return new Builder(str, j);
        }

        private ImplicitLocation() {
            this.label = "";
            this.pageId = -1;
        }

        public ImplicitLocation(Builder builder) {
            this.label = builder.f14074a;
            this.pageId = builder.f14075b;
        }

        public ImplicitLocation(Parcel parcel) {
            this.label = parcel.readString();
            this.pageId = parcel.readLong();
        }

        @JsonIgnore
        public int describeContents() {
            return 0;
        }

        @JsonIgnore
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.label);
            parcel.writeLong(this.pageId);
        }
    }

    private GeoRegion() {
    }

    public static ImplicitLocation m23441a(ImmutableList<GeoRegion> immutableList) {
        if (immutableList == null) {
            return null;
        }
        int size = immutableList.size();
        int i = 0;
        GeoRegion geoRegion = null;
        while (i < size) {
            GeoRegion geoRegion2 = (GeoRegion) immutableList.get(i);
            if (geoRegion2.type == null || !geoRegion2.type.equals("city")) {
                geoRegion2 = geoRegion;
            }
            i++;
            geoRegion = geoRegion2;
        }
        return geoRegion != null ? ImplicitLocation.m23440a(geoRegion.abbrName, geoRegion.id).m23439a() : null;
    }
}
