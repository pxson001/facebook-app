package com.facebook.platform.composer.targetprivacy;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.groupsasprofiles.protocol.FetchGroupGraphQLModels.GroupBasicModel;
import com.facebook.groups.groupsasprofiles.protocol.FetchGroupGraphQLModels.GroupsQueryModel;
import com.facebook.ipc.model.FacebookProfile;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: results_module_semantic */
public class PlatformComposerFetchGroupRequest {
    public GraphQLQueryExecutor f4299a;

    /* compiled from: results_module_semantic */
    public class C05491 implements Function<GraphQLResult<GroupsQueryModel>, List<FacebookProfile>> {
        final /* synthetic */ PlatformComposerFetchGroupRequest f4298a;

        public C05491(PlatformComposerFetchGroupRequest platformComposerFetchGroupRequest) {
            this.f4298a = platformComposerFetchGroupRequest;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            List arrayList = new ArrayList();
            if (graphQLResult == null) {
                return arrayList;
            }
            ImmutableList a = ((GroupsQueryModel) graphQLResult.e).m565a().m558a().m553a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GroupBasicModel groupBasicModel = (GroupBasicModel) a.get(i);
                arrayList.add(new FacebookProfile(Long.parseLong(groupBasicModel.m547m()), groupBasicModel.m545k(), groupBasicModel.m544j() != null ? groupBasicModel.m544j().m513a().m509a().m505a() : null, 3));
            }
            return arrayList;
        }
    }

    /* compiled from: results_module_semantic */
    public enum GroupOrder {
        IMPORTANCE(ImmutableList.of("importance"));
        
        private final ImmutableList<String> mOrderList;

        private GroupOrder(ImmutableList<String> immutableList) {
            this.mOrderList = immutableList;
        }

        public final ImmutableList<String> getOrderList() {
            return this.mOrderList;
        }
    }

    @Inject
    public PlatformComposerFetchGroupRequest(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f4299a = graphQLQueryExecutor;
    }
}
