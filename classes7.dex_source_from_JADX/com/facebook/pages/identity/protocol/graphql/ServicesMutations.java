package com.facebook.pages.identity.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.pages.identity.protocol.graphql.ServicesMutationsModels.PageServicesCardDeleteMutationModel;
import com.facebook.pages.identity.protocol.graphql.ServicesMutationsModels.ServicesSectionUpdateMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: me/facecast_live_comment_delay_logging_events */
public final class ServicesMutations {

    /* compiled from: me/facecast_live_comment_delay_logging_events */
    public class PageServicesCardDeleteMutationString extends TypedGraphQLMutationString<PageServicesCardDeleteMutationModel> {
        public PageServicesCardDeleteMutationString() {
            super(PageServicesCardDeleteMutationModel.class, false, "PageServicesCardDeleteMutation", "69d132b8b49cbe723328017e9d8e47d3", "page_services_card_delete", "0", "10154600231816729", RegularImmutableSet.a);
        }

        public final String m11195a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: me/facecast_live_comment_delay_logging_events */
    public class ServicesSectionUpdateMutationString extends TypedGraphQLMutationString<ServicesSectionUpdateMutationModel> {
        public ServicesSectionUpdateMutationString() {
            super(ServicesSectionUpdateMutationModel.class, false, "ServicesSectionUpdateMutation", "fecb5d97214fb972f7bdff9356257ac9", "page_services_section", "0", "10154600233711729", RegularImmutableSet.a);
        }

        public final String m11196a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
