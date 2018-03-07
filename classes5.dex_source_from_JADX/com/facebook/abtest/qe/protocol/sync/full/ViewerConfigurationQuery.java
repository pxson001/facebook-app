package com.facebook.abtest.qe.protocol.sync.full;

import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ViewerConfigsModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: topics_context */
public final class ViewerConfigurationQuery {

    /* compiled from: topics_context */
    public class ViewerConfigurationQueryString extends TypedGraphQlQueryString<ViewerConfigsModel> {
        public ViewerConfigurationQueryString() {
            super(ViewerConfigsModel.class, false, "ViewerConfigurationQuery", "3a95ee8e8b500a090ca9c017b927c029", "viewer", "10154686240681729", RegularImmutableSet.a);
        }

        public final String m2385a(String str) {
            switch (str.hashCode()) {
                case 537183243:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
