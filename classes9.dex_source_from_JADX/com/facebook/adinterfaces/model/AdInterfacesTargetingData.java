package com.facebook.adinterfaces.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.InterestModel;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLAdGeoLocationType;
import com.facebook.graphql.enums.GraphQLAdsTargetingGender;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: \d{2}-\d{3} */
public class AdInterfacesTargetingData implements Parcelable {
    public static final Creator<AdInterfacesTargetingData> CREATOR = new C25091();
    public GraphQLAdsTargetingGender f21721a;
    public int f21722b;
    public int f21723c;
    public ImmutableList<GeoLocationModel> f21724d;
    public ImmutableList<GeoLocationModel> f21725e;
    public ImmutableList<InterestModel> f21726f;
    public ImmutableList<LocationType> f21727g;
    public GraphQLBoostedPostAudienceOption f21728h;
    public String f21729i;

    /* compiled from: \d{2}-\d{3} */
    final class C25091 implements Creator<AdInterfacesTargetingData> {
        C25091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AdInterfacesTargetingData(parcel);
        }

        public final Object[] newArray(int i) {
            return new AdInterfacesTargetingData[i];
        }
    }

    /* compiled from: \d{2}-\d{3} */
    public /* synthetic */ class C25102 {
        public static final /* synthetic */ int[] f21711a = new int[GraphQLAdsTargetingGender.values().length];
        static final /* synthetic */ int[] f21712b = new int[GraphQLAdGeoLocationType.values().length];

        static {
            try {
                f21712b[GraphQLAdGeoLocationType.COUNTRY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21712b[GraphQLAdGeoLocationType.REGION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21712b[GraphQLAdGeoLocationType.CITY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21711a[GraphQLAdsTargetingGender.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f21711a[GraphQLAdsTargetingGender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f21711a[GraphQLAdsTargetingGender.FEMALE.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: \d{2}-\d{3} */
    public class Builder {
        public GraphQLAdsTargetingGender f21713a;
        public int f21714b;
        public int f21715c;
        public ImmutableList<GeoLocationModel> f21716d;
        public ImmutableList<InterestModel> f21717e;
        public GraphQLBoostedPostAudienceOption f21718f;
        public ImmutableList<LocationType> f21719g;
        public String f21720h = null;

        public final AdInterfacesTargetingData m22830a() {
            return new AdInterfacesTargetingData(this);
        }
    }

    /* compiled from: \d{2}-\d{3} */
    public enum LocationType {
        HOME("home"),
        RECENT("recent"),
        TRAVEL_IN("travel_in");
        
        public final String key;

        private LocationType(String str) {
            this.key = str;
        }
    }

    public AdInterfacesTargetingData(GraphQLAdsTargetingGender graphQLAdsTargetingGender, int i, int i2, ImmutableList<GeoLocationModel> immutableList, ImmutableList<GeoLocationModel> immutableList2, ImmutableList<InterestModel> immutableList3, GraphQLBoostedPostAudienceOption graphQLBoostedPostAudienceOption, String str) {
        Preconditions.checkNotNull(graphQLAdsTargetingGender);
        Preconditions.checkNotNull(immutableList2);
        this.f21721a = graphQLAdsTargetingGender;
        this.f21722b = i;
        this.f21723c = i2;
        this.f21724d = immutableList;
        this.f21725e = immutableList2;
        this.f21726f = immutableList3;
        this.f21728h = graphQLBoostedPostAudienceOption;
        this.f21729i = str;
    }

    public AdInterfacesTargetingData(Builder builder) {
        this.f21721a = builder.f21713a;
        this.f21722b = builder.f21714b;
        this.f21723c = builder.f21715c;
        this.f21725e = builder.f21716d;
        this.f21726f = builder.f21717e;
        this.f21728h = builder.f21718f;
        this.f21727g = builder.f21719g;
        this.f21729i = builder.f21720h;
    }

    public AdInterfacesTargetingData(Parcel parcel) {
        ImmutableList immutableList = null;
        this.f21721a = (GraphQLAdsTargetingGender) parcel.readSerializable();
        this.f21722b = parcel.readInt();
        this.f21723c = parcel.readInt();
        Collection b = FlatBufferModelHelper.b(parcel);
        this.f21724d = b == null ? null : ImmutableList.copyOf(b);
        b = FlatBufferModelHelper.b(parcel);
        this.f21725e = b == null ? null : ImmutableList.copyOf(b);
        b = FlatBufferModelHelper.b(parcel);
        if (b != null) {
            immutableList = ImmutableList.copyOf(b);
        }
        this.f21726f = immutableList;
        this.f21728h = (GraphQLBoostedPostAudienceOption) parcel.readSerializable();
        this.f21729i = parcel.readString();
        List<Integer> arrayList = new ArrayList();
        parcel.readList(arrayList, null);
        LocationType[] values = LocationType.values();
        com.google.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
        for (Integer intValue : arrayList) {
            builder.c(values[intValue.intValue()]);
        }
        this.f21727g = builder.b();
    }

    public final ImmutableList<GeoLocationModel> m22840f() {
        return this.f21725e;
    }

    public final GraphQLBoostedPostAudienceOption m22841h() {
        return this.f21728h;
    }

    public final void m22838a(GraphQLBoostedPostAudienceOption graphQLBoostedPostAudienceOption) {
        this.f21728h = graphQLBoostedPostAudienceOption;
        this.f21729i = null;
    }

    public final String m22842i() {
        return this.f21729i;
    }

    public final void m22839a(String str, GraphQLBoostedPostAudienceOption graphQLBoostedPostAudienceOption) {
        this.f21728h = graphQLBoostedPostAudienceOption;
        this.f21729i = str;
    }

    @Nullable
    public final String m22843j() {
        return m22837a(false);
    }

    @Nullable
    public final String m22837a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            m22836c(jSONObject);
            if (this.f21728h == GraphQLBoostedPostAudienceOption.GROUPER) {
                return jSONObject.toString();
            }
            m22834a(jSONObject, z);
            m22835b(jSONObject);
            m22832a(jSONObject);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdInterfacesTargetingData adInterfacesTargetingData = (AdInterfacesTargetingData) obj;
        if (this.f21722b != adInterfacesTargetingData.f21722b || this.f21723c != adInterfacesTargetingData.f21723c || this.f21721a != adInterfacesTargetingData.f21721a) {
            return false;
        }
        if (this.f21725e == null && adInterfacesTargetingData.f21725e != null) {
            return false;
        }
        if (adInterfacesTargetingData.f21725e == null && this.f21725e != null) {
            return false;
        }
        if (this.f21726f == null && adInterfacesTargetingData.f21726f != null) {
            return false;
        }
        if ((adInterfacesTargetingData.f21726f == null && this.f21726f != null) || this.f21725e.size() != adInterfacesTargetingData.f21725e.size()) {
            return false;
        }
        int i;
        HashSet hashSet = new HashSet();
        for (i = 0; i < this.f21725e.size(); i++) {
            hashSet.add(((GeoLocationModel) this.f21725e.get(i)).mL_());
        }
        for (i = 0; i < this.f21725e.size(); i++) {
            hashSet.remove(((GeoLocationModel) adInterfacesTargetingData.f21725e.get(i)).mL_());
        }
        if (!hashSet.isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f21725e.size(); i2++) {
            GeoLocationModel geoLocationModel = (GeoLocationModel) this.f21725e.get(i2);
            if (geoLocationModel.mM_() == GraphQLAdGeoLocationType.CUSTOM_LOCATION) {
                boolean z;
                GeoLocationModel geoLocationModel2 = (GeoLocationModel) adInterfacesTargetingData.f21725e.get(i2);
                if (geoLocationModel2.m23442g() == geoLocationModel.m23442g() && geoLocationModel2.mN_() == geoLocationModel.mN_() && geoLocationModel2.m23444k() == geoLocationModel.m23444k() && !geoLocationModel2.m23441d().equals(geoLocationModel.m23441d())) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    return false;
                }
            }
        }
        if (this.f21726f.size() != adInterfacesTargetingData.f21726f.size()) {
            return false;
        }
        HashSet hashSet2 = new HashSet();
        for (i = 0; i < this.f21726f.size(); i++) {
            hashSet.add(((InterestModel) this.f21726f.get(i)).m23462a());
        }
        for (i = 0; i < this.f21726f.size(); i++) {
            hashSet.remove(((InterestModel) adInterfacesTargetingData.f21726f.get(i)).m23462a());
        }
        if (hashSet2.isEmpty()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = (((((this.f21721a != null ? this.f21721a.hashCode() : 0) * 31) + this.f21722b) * 31) + this.f21723c) * 31;
        if (this.f21725e != null) {
            hashCode = this.f21725e.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.f21726f != null) {
            i = this.f21726f.hashCode();
        }
        return hashCode + i;
    }

    private void m22832a(JSONObject jSONObject) {
        if (this.f21726f != null) {
            JSONArray jSONArray;
            if (this.f21726f == null) {
                jSONArray = null;
            } else {
                JSONArray jSONArray2 = new JSONArray();
                int size = this.f21726f.size();
                for (int i = 0; i < size; i++) {
                    InterestModel interestModel = (InterestModel) this.f21726f.get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", interestModel.m23463j());
                    jSONObject2.put("name", interestModel.m23464k());
                    jSONArray2.put(jSONObject2);
                }
                jSONArray = jSONArray2;
            }
            JSONArray jSONArray3 = jSONArray;
            if (jSONArray3 != null && jSONArray3.length() > 0) {
                jSONObject.put("interests", jSONArray3);
            }
        }
    }

    private void m22835b(JSONObject jSONObject) {
        jSONObject.put("age_min", this.f21722b);
        if (this.f21723c < 65) {
            jSONObject.put("age_max", this.f21723c);
        }
    }

    private void m22834a(JSONObject jSONObject, boolean z) {
        JSONArray jSONArray = new JSONArray();
        if (this.f21721a != null) {
            switch (C25102.f21711a[this.f21721a.ordinal()]) {
                case 1:
                    if (!z) {
                        jSONArray.put(1).put(2);
                        break;
                    } else {
                        jSONArray.put(GraphQLAdsTargetingGender.MALE.name()).put(GraphQLAdsTargetingGender.FEMALE.name());
                        break;
                    }
                case 2:
                    if (!z) {
                        jSONArray.put(1);
                        break;
                    } else {
                        jSONArray.put(GraphQLAdsTargetingGender.MALE.name());
                        break;
                    }
                case 3:
                    if (!z) {
                        jSONArray.put(2);
                        break;
                    } else {
                        jSONArray.put(GraphQLAdsTargetingGender.FEMALE.name());
                        break;
                    }
            }
            jSONObject.put("genders", jSONArray);
        }
    }

    private void m22836c(JSONObject jSONObject) {
        if (this.f21725e != null || this.f21729i != null) {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            List arrayList = new ArrayList();
            int size = this.f21725e.size();
            for (int i = 0; i < size; i++) {
                GeoLocationModel geoLocationModel = (GeoLocationModel) this.f21725e.get(i);
                if (geoLocationModel.mM_() == GraphQLAdGeoLocationType.CUSTOM_LOCATION) {
                    arrayList.add(geoLocationModel);
                } else {
                    m22831a(jSONArray, jSONArray2, jSONArray3, geoLocationModel.mL_(), geoLocationModel.mM_(), geoLocationModel.m23439b());
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            m22833a(jSONObject2, arrayList);
            jSONObject2.put("countries", jSONArray);
            if (jSONArray2.length() > 0) {
                jSONObject2.put("regions", jSONArray2);
            }
            if (jSONArray3.length() > 0) {
                jSONObject2.put("cities", jSONArray3);
            }
            if (this.f21727g != null) {
                JSONArray jSONArray4 = new JSONArray();
                int size2 = this.f21727g.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    jSONArray4.put(((LocationType) this.f21727g.get(i2)).key);
                }
                jSONObject2.put("location_types", jSONArray4);
            }
            jSONObject.put("geo_locations", jSONObject2);
        }
    }

    private static void m22831a(JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, String str, GraphQLAdGeoLocationType graphQLAdGeoLocationType, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", str);
        switch (C25102.f21712b[graphQLAdGeoLocationType.ordinal()]) {
            case 1:
                jSONArray.put(str2);
                return;
            case 2:
                jSONArray2.put(jSONObject);
                return;
            case 3:
                jSONArray3.put(jSONObject);
                return;
            default:
                return;
        }
    }

    private static void m22833a(JSONObject jSONObject, List<GeoLocationModel> list) {
        if (!list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (GeoLocationModel geoLocationModel : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("radius", geoLocationModel.m23444k());
                jSONObject2.put("latitude", geoLocationModel.m23442g());
                jSONObject2.put("longitude", geoLocationModel.mN_());
                jSONObject2.put("distance_unit", geoLocationModel.m23441d());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("custom_locations", jSONArray);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f21721a);
        parcel.writeInt(this.f21722b);
        parcel.writeInt(this.f21723c);
        FlatBufferModelHelper.a(parcel, this.f21724d);
        FlatBufferModelHelper.a(parcel, this.f21725e);
        FlatBufferModelHelper.a(parcel, this.f21726f);
        parcel.writeSerializable(this.f21728h);
        parcel.writeString(this.f21729i);
        if (this.f21727g == null) {
            parcel.writeValue(null);
            return;
        }
        List arrayList = new ArrayList();
        int size = this.f21727g.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(Integer.valueOf(((LocationType) this.f21727g.get(i2)).ordinal()));
        }
        parcel.writeList(arrayList);
    }
}
