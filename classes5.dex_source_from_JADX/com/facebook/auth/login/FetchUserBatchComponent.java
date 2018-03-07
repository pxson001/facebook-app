package com.facebook.auth.login;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.protocol.FetchEmployeeStatusGraphqlMethod;
import com.facebook.auth.protocol.GetLoggedInUserGraphQLMethod;
import com.facebook.auth.protocol.GetLoggedInUserGraphQLResult;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.user.model.UserBuilder;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: sync_object_uuid */
public class FetchUserBatchComponent implements BatchComponent {
    private final LoggedInUserSessionManager f2294a;
    private final GetLoggedInUserGraphQLMethod f2295b;
    private final FetchEmployeeStatusGraphqlMethod f2296c;

    @Inject
    public FetchUserBatchComponent(LoggedInUserSessionManager loggedInUserSessionManager, GetLoggedInUserGraphQLMethod getLoggedInUserGraphQLMethod, FetchEmployeeStatusGraphqlMethod fetchEmployeeStatusGraphqlMethod) {
        this.f2294a = loggedInUserSessionManager;
        this.f2295b = getLoggedInUserGraphQLMethod;
        this.f2296c = fetchEmployeeStatusGraphqlMethod;
    }

    public final Iterable<BatchOperation> m3186a() {
        Builder a = BatchOperation.a(this.f2295b, null);
        a.c = "user";
        BatchOperation a2 = a.a();
        Builder a3 = BatchOperation.a(this.f2296c, null);
        a3.c = "fetchFacebookEmployeeStatus";
        return ImmutableList.of(a2, a3.a());
    }

    public final void m3187a(Map<String, Object> map) {
        GetLoggedInUserGraphQLResult getLoggedInUserGraphQLResult = (GetLoggedInUserGraphQLResult) map.get("user");
        Boolean bool = (Boolean) map.get("fetchFacebookEmployeeStatus");
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.a(getLoggedInUserGraphQLResult.a);
        if (bool != null) {
            userBuilder.v = bool.booleanValue();
        }
        this.f2294a.c(userBuilder.aa());
    }
}
