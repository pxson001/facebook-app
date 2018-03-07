package com.facebook.auth.protocol;

import com.facebook.auth.protocol.WorkCommunityPeekGraphQL.WorkCommunityPeekQueryString;
import com.facebook.auth.protocol.WorkCommunityPeekGraphQLModels.WorkCommunityPeekQueryModel;
import com.facebook.auth.protocol.WorkCommunityPeekGraphQLModels.WorkCommunityPeekQueryModel.WorkUsersModel;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.work.auth.request.model.WorkCommunity;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: tab_icon_uri */
public class WorkCommunityPeekMethod extends AbstractPersistedGraphQlApiMethod<Void, WorkCommunityPeekResult> {
    private final Clock f1362c;

    public static WorkCommunityPeekMethod m1600a(InjectorLike injectorLike) {
        return new WorkCommunityPeekMethod(GraphQLProtocolHelper.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m1602a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return m1601a(jsonParser);
    }

    @Inject
    public WorkCommunityPeekMethod(GraphQLProtocolHelper graphQLProtocolHelper, Clock clock) {
        super(graphQLProtocolHelper);
        this.f1362c = clock;
    }

    public final GraphQlQueryString m1604f(Object obj) {
        return new WorkCommunityPeekQueryString();
    }

    private WorkCommunityPeekResult m1601a(JsonParser jsonParser) {
        ImmutableList immutableList;
        WorkCommunity workCommunity;
        WorkCommunityPeekQueryModel workCommunityPeekQueryModel = (WorkCommunityPeekQueryModel) jsonParser.a(WorkCommunityPeekQueryModel.class);
        boolean a = workCommunityPeekQueryModel.a();
        if (a) {
            String a2;
            if (workCommunityPeekQueryModel.j().j() != null) {
                a2 = workCommunityPeekQueryModel.j().j().a();
            } else {
                a2 = null;
            }
            immutableList = null;
            workCommunity = new WorkCommunity(workCommunityPeekQueryModel.j().l(), workCommunityPeekQueryModel.j().k(), a2, null, workCommunityPeekQueryModel.k());
        } else {
            Builder builder = ImmutableList.builder();
            ImmutableList l = workCommunityPeekQueryModel.l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                WorkUsersModel workUsersModel = (WorkUsersModel) l.get(i);
                if (workUsersModel.a() != null) {
                    String a3;
                    if (workUsersModel.a().j() != null) {
                        a3 = workUsersModel.a().j().a();
                    } else {
                        a3 = null;
                    }
                    builder.c(new WorkCommunity(workUsersModel.a().k(), workUsersModel.a().a(), a3, workUsersModel.j(), workUsersModel.a().l()));
                }
            }
            immutableList = builder.b();
            workCommunity = null;
        }
        return new WorkCommunityPeekResult(DataFreshnessResult.FROM_SERVER, this.f1362c.a(), a, workCommunity, immutableList);
    }

    public final int m1603b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
