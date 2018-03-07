package com.facebook.adinterfaces.util.targeting;

import com.facebook.adinterfaces.model.AdInterfacesTargetingData;
import com.facebook.adinterfaces.model.AdInterfacesTargetingData.LocationType;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.InterestModel;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.UnitLocale;
import com.facebook.graphql.enums.GraphQLAdGeoLocationType;
import com.facebook.graphql.enums.GraphQLAdsTargetingGender;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Unhandled  */
public abstract class AdInterfacesTargetingDelegate<T> {
    public ArrayList<String> f23359a;
    public ArrayList<String> f23360b;
    public ArrayList<String> f23361c;
    public List<GeoLocationModel> f23362d = new ArrayList();

    /* compiled from: Unhandled  */
    public /* synthetic */ class C27821 {
        public static final /* synthetic */ int[] f23358a = new int[GraphQLAdGeoLocationType.values().length];

        static {
            try {
                f23358a[GraphQLAdGeoLocationType.COUNTRY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23358a[GraphQLAdGeoLocationType.REGION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23358a[GraphQLAdGeoLocationType.CITY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23358a[GraphQLAdGeoLocationType.CUSTOM_LOCATION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    protected abstract T mo1053a();

    protected abstract void mo1054a(int i);

    protected abstract void mo1055a(GraphQLAdsTargetingGender graphQLAdsTargetingGender);

    protected abstract void mo1056a(@Nullable ImmutableList<LocationType> immutableList);

    public abstract void mo1058a(List<String> list);

    protected abstract void mo1059b(int i);

    protected void mo1057a(ImmutableList<GeoLocationModel> immutableList, ImmutableList<LocationType> immutableList2) {
        if (!(immutableList == null || immutableList.isEmpty())) {
            this.f23362d.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                GeoLocationModel geoLocationModel = (GeoLocationModel) immutableList.get(i);
                switch (C27821.f23358a[geoLocationModel.mM_().ordinal()]) {
                    case 1:
                        arrayList.add(geoLocationModel.m23439b());
                        break;
                    case 2:
                        arrayList2.add(geoLocationModel.mL_());
                        break;
                    case 3:
                        arrayList3.add(geoLocationModel.mL_());
                        break;
                    case 4:
                        this.f23362d.add(geoLocationModel);
                        break;
                    default:
                        break;
                }
            }
            this.f23359a = arrayList;
            this.f23360b = arrayList2;
            this.f23361c = arrayList3;
        }
        mo1056a((ImmutableList) immutableList2);
    }

    public static String m25299a(Locales locales) {
        return (UnitLocale.from(locales.a()) == UnitLocale.IMPERIAL ? 1 : null) != null ? "mile" : "kilometer";
    }

    public final T m25301a(AdInterfacesTargetingData adInterfacesTargetingData) {
        mo1054a(adInterfacesTargetingData.f21723c);
        mo1059b(adInterfacesTargetingData.f21722b);
        mo1055a(adInterfacesTargetingData.f21721a);
        mo1057a(adInterfacesTargetingData.f21725e, adInterfacesTargetingData.f21727g);
        ImmutableList immutableList = adInterfacesTargetingData.f21726f;
        if (!(immutableList == null || immutableList.isEmpty())) {
            List arrayList = new ArrayList();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(((InterestModel) immutableList.get(i)).m23463j());
            }
            mo1058a(arrayList);
        }
        return mo1053a();
    }
}
