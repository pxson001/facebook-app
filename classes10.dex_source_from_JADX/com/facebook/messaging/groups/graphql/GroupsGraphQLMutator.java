package com.facebook.messaging.groups.graphql;

import com.facebook.graphql.calls.MessengerGroupChangeThreadJoinableSettingsInputData;
import com.facebook.graphql.calls.MessengerGroupChangeThreadJoinableSettingsInputData.Mode;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.messaging.model.threads.ThreadSummary.GroupType;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: showRemoveButton */
public class GroupsGraphQLMutator {
    public final Provider<String> f2464a;
    public final GraphQLQueryExecutor f2465b;

    /* compiled from: showRemoveButton */
    /* synthetic */ class C04091 {
        static final /* synthetic */ int[] f2463a = new int[GroupType.values().length];

        static {
            try {
                f2463a[GroupType.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2463a[GroupType.HIDDEN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Inject
    public GroupsGraphQLMutator(Provider<String> provider, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f2464a = provider;
        this.f2465b = graphQLQueryExecutor;
    }

    public static MessengerGroupChangeThreadJoinableSettingsInputData m2436a(GroupType groupType, MessengerGroupChangeThreadJoinableSettingsInputData messengerGroupChangeThreadJoinableSettingsInputData) {
        switch (C04091.f2463a[groupType.ordinal()]) {
            case 1:
                messengerGroupChangeThreadJoinableSettingsInputData.a(Mode.PRIVATE);
                break;
            case 2:
                messengerGroupChangeThreadJoinableSettingsInputData.a(Mode.JOINABLE);
                break;
            default:
                throw new IllegalArgumentException("Cannot sent mutation for Group Type:" + groupType.dbValue);
        }
        return messengerGroupChangeThreadJoinableSettingsInputData;
    }
}
