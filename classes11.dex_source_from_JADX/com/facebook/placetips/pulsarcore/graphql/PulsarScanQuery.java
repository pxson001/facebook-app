package com.facebook.placetips.pulsarcore.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.placetips.pulsarcore.graphql.PulsarScanQueryModels.SimplePulsarScanQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: The ViewPager must be bound before adding slaves */
public final class PulsarScanQuery {

    /* compiled from: The ViewPager must be bound before adding slaves */
    public class SimplePulsarScanQueryString extends TypedGraphQlQueryString<SimplePulsarScanQueryModel> {
        public SimplePulsarScanQueryString() {
            super(SimplePulsarScanQueryModel.class, false, "SimplePulsarScanQuery", "cb04f9addf988ef995767708aab06d6c", "pulsar_scan", "10154363614366729", RegularImmutableSet.a);
        }

        public final String m11199a(String str) {
            switch (str.hashCode()) {
                case 1928187114:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
