package com.facebook.zero.iptest.network;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Lazy;
import com.facebook.zero.connectiontest.ConnectionTester;
import com.facebook.zero.connectiontest.ConnectionTester.ConnectionTestType;
import com.facebook.zero.iptest.ZeroIPTestManager;
import com.facebook.zero.iptest.ZeroIPTestPlan;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLModels.FetchZeroIPTestModel;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLModels.FetchZeroIPTestModel.ZeroCarrierModel;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLModels.FetchZeroIPTestModel.ZeroCarrierModel.IpTestsModel;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLModels.FetchZeroIPTestModel.ZeroCarrierModel.IpTestsModel.NodesModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: events_dashboard_scroll */
public class ZeroIPTestFetch {
    public final GraphQLQueryExecutor f13093a;
    public final Lazy<ExecutorService> f13094b;
    public final Function<GraphQLResult<FetchZeroIPTestModel>, ZeroIPTestPlan> f13095c = new C18251(this);

    /* compiled from: events_dashboard_scroll */
    class C18251 implements Function<GraphQLResult<FetchZeroIPTestModel>, ZeroIPTestPlan> {
        final /* synthetic */ ZeroIPTestFetch f13092a;

        C18251(ZeroIPTestFetch zeroIPTestFetch) {
            this.f13092a = zeroIPTestFetch;
        }

        @Nullable
        public /* synthetic */ Object apply(Object obj) {
            return C18251.m13200a((GraphQLResult) obj);
        }

        @Nullable
        private static ZeroIPTestPlan m13200a(GraphQLResult<FetchZeroIPTestModel> graphQLResult) {
            ZeroCarrierModel a = ((FetchZeroIPTestModel) graphQLResult.d()).m13169a();
            if (a == null) {
                return ZeroIPTestPlan.f13075a;
            }
            IpTestsModel a2 = a.m13166a();
            if (a2 == null) {
                return ZeroIPTestPlan.f13075a;
            }
            ImmutableList a3 = a2.m13160a();
            List arrayList = new ArrayList();
            int size = a3.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) a3.get(i);
                try {
                    String str;
                    ConnectionTestType valueOfName = ConnectionTestType.valueOfName(nodesModel.mG_());
                    String a4 = nodesModel.m13152a();
                    if (a4 == null) {
                        str = "0";
                    } else {
                        str = a4;
                    }
                    arrayList.add(new ConnectionTester(valueOfName, nodesModel.m13154b(), nodesModel.m13156d(), nodesModel.m13155c(), new ArrayList(), a2.m13162j(), Integer.parseInt(str)));
                } catch (IllegalArgumentException e) {
                    BLog.a(ZeroIPTestManager.class, "TestType %s is unsupported, skipping", new Object[]{nodesModel.mG_(), e});
                }
            }
            ZeroIPTestPlan zeroIPTestPlan = new ZeroIPTestPlan();
            zeroIPTestPlan.m13141a(arrayList);
            return zeroIPTestPlan;
        }
    }

    @Inject
    public ZeroIPTestFetch(GraphQLQueryExecutor graphQLQueryExecutor, Lazy<ExecutorService> lazy) {
        this.f13093a = graphQLQueryExecutor;
        this.f13094b = lazy;
    }
}
