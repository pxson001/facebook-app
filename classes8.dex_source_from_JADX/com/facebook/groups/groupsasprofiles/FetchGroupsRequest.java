package com.facebook.groups.groupsasprofiles;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.groupsasprofiles.protocol.FetchGroupGraphQLModels.GroupBasicModel;
import com.facebook.groups.groupsasprofiles.protocol.FetchGroupGraphQLModels.GroupsQueryModel;
import com.facebook.ipc.model.FacebookProfile;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Deprecated
/* compiled from: video_v1 */
public class FetchGroupsRequest {
    public final GraphQLQueryExecutor f513a;

    /* compiled from: video_v1 */
    public class C00681 implements Function<GraphQLResult<GroupsQueryModel>, List<FacebookProfile>> {
        final /* synthetic */ FetchGroupsRequest f512a;

        public C00681(FetchGroupsRequest fetchGroupsRequest) {
            this.f512a = fetchGroupsRequest;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            List a = Lists.a();
            if (graphQLResult == null) {
                return a;
            }
            ImmutableList a2 = ((GroupsQueryModel) graphQLResult.e).m565a().m558a().m553a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                GroupBasicModel groupBasicModel = (GroupBasicModel) a2.get(i);
                a.add(new FacebookProfile(Long.parseLong(groupBasicModel.m547m()), groupBasicModel.m545k(), groupBasicModel.m546l().m524a().m519a(), 3));
            }
            return a;
        }
    }

    /* compiled from: video_v1 */
    public enum GroupOrder {
        APP_LANDING(ImmutableList.of("app_landing")),
        IMPORTANCE(ImmutableList.of("importance")),
        NAME(ImmutableList.of("name"));
        
        private final ImmutableList<String> mOrderList;

        private GroupOrder(ImmutableList<String> immutableList) {
            this.mOrderList = immutableList;
        }

        public final ImmutableList<String> getOrderList() {
            return this.mOrderList;
        }
    }

    @Inject
    public FetchGroupsRequest(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f513a = graphQLQueryExecutor;
    }
}
