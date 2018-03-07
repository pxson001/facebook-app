package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.SetAdAccountCurrenyTimeZoneMutationModels.FBPageSetAdAccountCurrenyTimeZoneModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Video Home badge count query failed */
public final class SetAdAccountCurrenyTimeZoneMutation {

    /* compiled from: Video Home badge count query failed */
    public class FBPageSetAdAccountCurrenyTimeZoneString extends TypedGraphQLMutationString<FBPageSetAdAccountCurrenyTimeZoneModel> {
        public FBPageSetAdAccountCurrenyTimeZoneString() {
            super(FBPageSetAdAccountCurrenyTimeZoneModel.class, false, "FBPageSetAdAccountCurrenyTimeZone", "72c39316f6e00d13ed5a1090e361beb8", "ad_account_set_currency_timezone", "0", "10154204801931729", RegularImmutableSet.a);
        }

        public final String m24269a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
