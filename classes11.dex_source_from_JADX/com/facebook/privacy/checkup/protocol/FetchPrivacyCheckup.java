package com.facebook.privacy.checkup.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchGenericPrivacyReviewQueryModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchPrivacyCheckupAppsStepQueryModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchPrivacyCheckupComposerStepQueryModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchPrivacyCheckupProfileStepQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: page/{#%s}/child_locations */
public final class FetchPrivacyCheckup {

    /* compiled from: page/{#%s}/child_locations */
    public class FetchGenericPrivacyReviewQueryString extends TypedGraphQlQueryString<FetchGenericPrivacyReviewQueryModel> {
        public FetchGenericPrivacyReviewQueryString() {
            super(FetchGenericPrivacyReviewQueryModel.class, false, "FetchGenericPrivacyReviewQuery", "ae0d17ae1690700d23953b398f2755ae", "viewer", "10154661259066729", RegularImmutableSet.a);
        }

        public final TriState m5517g() {
            return TriState.NO;
        }

        public final String m5516a(String str) {
            switch (str.hashCode()) {
                case -1966910237:
                    return "4";
                case -1777441434:
                    return "5";
                case -549741174:
                    return "0";
                case 92734940:
                    return "3";
                case 493034338:
                    return "1";
                case 1217255443:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: page/{#%s}/child_locations */
    public class FetchPrivacyCheckupAppsStepQueryString extends TypedGraphQlQueryString<FetchPrivacyCheckupAppsStepQueryModel> {
        public FetchPrivacyCheckupAppsStepQueryString() {
            super(FetchPrivacyCheckupAppsStepQueryModel.class, false, "FetchPrivacyCheckupAppsStepQuery", "feee54e6c08852e304ab500d4e479f97", "viewer", "10154661259046729", RegularImmutableSet.a);
        }

        public final TriState m5519g() {
            return TriState.NO;
        }

        public final String m5518a(String str) {
            switch (str.hashCode()) {
                case 92734940:
                    return "0";
                case 97440432:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: page/{#%s}/child_locations */
    public class FetchPrivacyCheckupComposerStepQueryString extends TypedGraphQlQueryString<FetchPrivacyCheckupComposerStepQueryModel> {
        public FetchPrivacyCheckupComposerStepQueryString() {
            super(FetchPrivacyCheckupComposerStepQueryModel.class, false, "FetchPrivacyCheckupComposerStepQuery", "39efb71572fd4b153f15c99dc4b0768d", "viewer", "10154661259056729", RegularImmutableSet.a);
        }

        public final TriState m5520g() {
            return TriState.NO;
        }
    }

    /* compiled from: page/{#%s}/child_locations */
    public class FetchPrivacyCheckupProfileStepQueryString extends TypedGraphQlQueryString<FetchPrivacyCheckupProfileStepQueryModel> {
        public FetchPrivacyCheckupProfileStepQueryString() {
            super(FetchPrivacyCheckupProfileStepQueryModel.class, false, "FetchPrivacyCheckupProfileStepQuery", "36f07ec729dbb241f66c9959ce1c2ebf", "viewer", "10154661259041729", RegularImmutableSet.a);
        }

        public final TriState m5522g() {
            return TriState.NO;
        }

        public final String m5521a(String str) {
            switch (str.hashCode()) {
                case 92734940:
                    return "0";
                case 97440432:
                    return "1";
                default:
                    return str;
            }
        }
    }

    public static final FetchGenericPrivacyReviewQueryString m5523d() {
        return new FetchGenericPrivacyReviewQueryString();
    }
}
