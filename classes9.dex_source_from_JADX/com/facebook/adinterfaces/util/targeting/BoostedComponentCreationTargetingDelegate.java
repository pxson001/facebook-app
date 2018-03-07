package com.facebook.adinterfaces.util.targeting;

import com.facebook.adinterfaces.model.AdInterfacesTargetingData.LocationType;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Audience.TargetSpec;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Audience.TargetSpec.Genders;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Audience.TargetSpec.GeoLocations;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Audience.TargetSpec.GeoLocations.CustomLocations;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.Audience.TargetSpec.GeoLocations.LocationTypes;
import com.facebook.graphql.enums.GraphQLAdsTargetingGender;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Unexpected value for visibility  */
public class BoostedComponentCreationTargetingDelegate extends AdInterfacesTargetingDelegate<TargetSpec> {
    private final TargetSpec f23364e;
    private ArrayList<LocationTypes> f23365f;

    /* compiled from: Unexpected value for visibility  */
    public /* synthetic */ class C27831 {
        public static final /* synthetic */ int[] f23363a = new int[GraphQLAdsTargetingGender.values().length];

        static {
            try {
                f23363a[GraphQLAdsTargetingGender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23363a[GraphQLAdsTargetingGender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23363a[GraphQLAdsTargetingGender.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23363a[GraphQLAdsTargetingGender.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public BoostedComponentCreationTargetingDelegate(TargetSpec targetSpec) {
        this.f23364e = targetSpec;
    }

    public final void mo1054a(int i) {
        this.f23364e.a("age_max", Integer.valueOf(i));
    }

    public final void mo1059b(int i) {
        this.f23364e.a("age_min", Integer.valueOf(i));
    }

    public final void mo1055a(GraphQLAdsTargetingGender graphQLAdsTargetingGender) {
        List asList;
        TargetSpec targetSpec = this.f23364e;
        switch (C27831.f23363a[graphQLAdsTargetingGender.ordinal()]) {
            case 1:
                asList = Arrays.asList(new Genders[]{Genders.FEMALE});
                break;
            case 2:
                asList = Arrays.asList(new Genders[]{Genders.MALE});
                break;
            default:
                asList = Arrays.asList(new Object[0]);
                break;
        }
        targetSpec.a("genders", asList);
    }

    protected final void mo1056a(@Nullable ImmutableList<LocationType> immutableList) {
        if (immutableList != null) {
            this.f23365f = new ArrayList();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                this.f23365f.add(LocationTypes.valueOf(((LocationType) immutableList.get(i)).name()));
            }
        }
    }

    public final void mo1058a(List<String> list) {
        this.f23364e.a("interest_ids", list);
    }

    protected final Object mo1053a() {
        return this.f23364e;
    }

    protected final void mo1057a(ImmutableList<GeoLocationModel> immutableList, ImmutableList<LocationType> immutableList2) {
        super.mo1057a(immutableList, immutableList2);
        GeoLocations geoLocations = new GeoLocations();
        if (!(this.f23362d == null || this.f23362d.isEmpty())) {
            List<GeoLocationModel> list = this.f23362d;
            ArrayList arrayList = new ArrayList();
            for (GeoLocationModel geoLocationModel : list) {
                CustomLocations customLocations = new CustomLocations();
                customLocations.a("distance_unit", geoLocationModel.m23441d());
                customLocations.a("radius", Double.valueOf(geoLocationModel.m23444k()));
                customLocations.a("latitude", Double.valueOf(geoLocationModel.m23442g()));
                customLocations.a("longitude", Double.valueOf(geoLocationModel.mN_()));
                arrayList.add(customLocations);
            }
            geoLocations.a("custom_locations", arrayList);
        }
        if (this.f23361c != null) {
            geoLocations.a("city_keys", this.f23361c);
        }
        if (this.f23359a != null) {
            geoLocations.a("countries", this.f23359a);
        }
        if (this.f23360b != null) {
            geoLocations.a("region_keys", this.f23360b);
        }
        if (this.f23365f != null) {
            geoLocations.a("location_types", this.f23365f);
        }
        this.f23364e.a("geo_locations", geoLocations);
    }
}
