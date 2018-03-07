package com.facebook.pages.common.surface.calltoaction.graphql;

import com.facebook.graphql.enums.GraphQLPageCtaConfigFieldType;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: create_call_to_action_key */
public class PageAdminCallToActionGraphQLInterfaces {

    /* compiled from: create_call_to_action_key */
    public interface CallToActionConfigCommonFields {

        /* compiled from: create_call_to_action_key */
        public interface Subfields {

            /* compiled from: create_call_to_action_key */
            public interface Nodes {
                @Nullable
                GraphQLPageCtaConfigFieldType mo1020c();

                @Nullable
                String mo1021d();
            }

            @Nonnull
            ImmutableList<? extends Nodes> mo1022a();
        }

        @Nullable
        DefaultTextWithEntitiesLongFields mo1023a();

        @Nullable
        String mo1024b();

        @Nullable
        GraphQLPageCtaConfigFieldType mo1025c();

        @Nullable
        String mo1026d();

        boolean mo1027g();

        @Nullable
        String mo1028j();

        @Nullable
        Subfields kA_();

        @Nullable
        String ky_();

        @Nonnull
        ImmutableList<? extends Options> kz_();
    }
}
