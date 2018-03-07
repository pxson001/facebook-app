package com.facebook.pages.common.contactinbox.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxLeadUpdateMutationsModels.PagesContactInboxLeadUpdateStateMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: startY */
public final class PagesContactInboxLeadUpdateMutations {

    /* compiled from: startY */
    public class PagesContactInboxLeadUpdateStateMutationString extends TypedGraphQLMutationString<PagesContactInboxLeadUpdateStateMutationModel> {
        public PagesContactInboxLeadUpdateStateMutationString() {
            super(PagesContactInboxLeadUpdateStateMutationModel.class, false, "PagesContactInboxLeadUpdateStateMutation", "4c6b48b66973bf923e1e46e084c494a8", "page_leadgen_info_update", "0", "10154204804651729", RegularImmutableSet.a);
        }

        public final String m2111a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
