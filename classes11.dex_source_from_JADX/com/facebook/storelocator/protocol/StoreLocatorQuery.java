package com.facebook.storelocator.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.storelocator.protocol.StoreLocatorQueryModels.StoreLocatorNearbyLocationsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Notification in truncated list not present in full list */
public final class StoreLocatorQuery {

    /* compiled from: Notification in truncated list not present in full list */
    public class StoreLocatorNearbyLocationsQueryString extends TypedGraphQlQueryString<StoreLocatorNearbyLocationsQueryModel> {
        public StoreLocatorNearbyLocationsQueryString() {
            super(StoreLocatorNearbyLocationsQueryModel.class, false, "StoreLocatorNearbyLocationsQuery", "0acfb17dc2aa1a419d1efd5340c79904", "store_locator", "10154615234041729", RegularImmutableSet.a);
        }

        public final String m13586a(String str) {
            switch (str.hashCode()) {
                case -1982676604:
                    return "0";
                case -1700233621:
                    return "1";
                case 109250890:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m13587a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "20".equals(obj);
                    }
                    return (obj instanceof Integer) && ((Integer) obj).intValue() == 20;
                default:
                    return false;
            }
        }
    }

    public static final StoreLocatorNearbyLocationsQueryString m13588a() {
        return new StoreLocatorNearbyLocationsQueryString();
    }
}
