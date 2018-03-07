package com.facebook.zero.iptest.network;

import com.facebook.common.hardware.TelephonyManagerUtils;
import com.facebook.graphql.calls.ZeroIpTestSubmitInputData;
import com.facebook.graphql.calls.ZeroIpTestSubmitInputData.TestResults;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Lazy;
import com.facebook.telephony.FbTelephonyManager;
import com.facebook.zero.connectiontest.ConnectionTester;
import com.facebook.zero.iptest.ZeroIPTestPlan;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQL.ZeroIPTestSubmitMutationString;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLModels.ZeroIPTestSubmitMutationModel;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: events_creation_story_cache_id */
public class ZeroIPTestReport {
    public final GraphQLQueryExecutor f13097a;
    public final Lazy<ExecutorService> f13098b;
    public final FbTelephonyManager f13099c;
    public final AsyncFunction<ZeroIPTestPlan, GraphQLResult<ZeroIPTestSubmitMutationModel>> f13100d = new C18261(this);

    /* compiled from: events_creation_story_cache_id */
    public class C18261 implements AsyncFunction<ZeroIPTestPlan, GraphQLResult<ZeroIPTestSubmitMutationModel>> {
        public final /* synthetic */ ZeroIPTestReport f13096a;

        C18261(ZeroIPTestReport zeroIPTestReport) {
            this.f13096a = zeroIPTestReport;
        }

        public final ListenableFuture m13201a(@Nullable Object obj) {
            ZeroIPTestPlan zeroIPTestPlan = (ZeroIPTestPlan) obj;
            if (zeroIPTestPlan == null || zeroIPTestPlan.m13140a().isEmpty()) {
                return null;
            }
            Integer.valueOf(zeroIPTestPlan.m13140a().size());
            String a = TelephonyManagerUtils.a(this.f13096a.f13099c.c(0));
            List arrayList = new ArrayList();
            for (ConnectionTester connectionTester : zeroIPTestPlan.m13140a()) {
                TestResults testResults = new TestResults();
                testResults.a("ip", connectionTester.f13049c);
                testResults.a("latency", Integer.valueOf((int) connectionTester.f13056j));
                if (connectionTester.f13057k != null) {
                    testResults.a("error", connectionTester.f13057k.toString());
                }
                arrayList.add(testResults);
            }
            ZeroIpTestSubmitInputData zeroIpTestSubmitInputData = new ZeroIpTestSubmitInputData();
            zeroIpTestSubmitInputData.a("network_type", a);
            zeroIpTestSubmitInputData.a("test_results", arrayList);
            GraphQlQueryString zeroIPTestSubmitMutationString = new ZeroIPTestSubmitMutationString();
            zeroIPTestSubmitMutationString.a("input", zeroIpTestSubmitInputData);
            return this.f13096a.f13097a.a(GraphQLRequest.a(zeroIPTestSubmitMutationString));
        }
    }

    @Inject
    public ZeroIPTestReport(GraphQLQueryExecutor graphQLQueryExecutor, Lazy<ExecutorService> lazy, FbTelephonyManager fbTelephonyManager) {
        this.f13097a = graphQLQueryExecutor;
        this.f13098b = lazy;
        this.f13099c = fbTelephonyManager;
    }
}
