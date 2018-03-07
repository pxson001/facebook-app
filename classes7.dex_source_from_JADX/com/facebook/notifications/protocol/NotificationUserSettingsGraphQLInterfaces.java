package com.facebook.notifications.protocol;

import com.facebook.graphql.enums.GraphQLNotifOptionClientActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotifOptionFragmentModel.OptionDisplayModel;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotifOptionSetFragmentModel.OptionSetDisplayModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: muted_until_time */
public class NotificationUserSettingsGraphQLInterfaces {

    /* compiled from: muted_until_time */
    public interface NotifOptionFragment {
    }

    /* compiled from: muted_until_time */
    public interface NotifOptionSetFragment {

        /* compiled from: muted_until_time */
        public interface NotifOptions {

            /* compiled from: muted_until_time */
            public interface Nodes extends NotifOptionFragment {

                /* compiled from: muted_until_time */
                public interface ClientInfo {
                    @Nullable
                    GraphQLObjectType mo455a();

                    @Nullable
                    GraphQLNotifOptionClientActionType mo456b();

                    @Nullable
                    DefaultTextWithEntitiesFields mo457d();

                    @Nullable
                    String mo458g();

                    @Nullable
                    String gy_();
                }

                @Nullable
                ClientInfo mo460b();

                @Nullable
                String mo461c();

                @Nullable
                OptionDisplayModel mo462d();

                @Nullable
                String gx_();
            }

            @Nonnull
            ImmutableList<? extends Nodes> mo464a();
        }

        @Nullable
        String mo466b();

        @Nullable
        NotifOptions mo467c();

        @Nullable
        OptionSetDisplayModel mo468d();
    }
}
