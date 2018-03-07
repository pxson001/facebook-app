package com.facebook.groups.photos.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.photos.protocol.FetchGroupPhotosHeaderModels.FetchGroupPhotosHeaderModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: TOXICLE_ACTION_BAR */
public final class FetchGroupPhotosHeader {

    /* compiled from: TOXICLE_ACTION_BAR */
    public class FetchGroupPhotosHeaderString extends TypedGraphQlQueryString<FetchGroupPhotosHeaderModel> {
        public FetchGroupPhotosHeaderString() {
            super(FetchGroupPhotosHeaderModel.class, false, "FetchGroupPhotosHeader", "d9310532211f82f853f0f641886df93f", "group_address", "10153680821161729", RegularImmutableSet.a);
        }

        public final String m24374a(String str) {
            switch (str.hashCode()) {
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
