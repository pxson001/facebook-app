package com.facebook.auth.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.protocol.LoginApprovalMutation;
import com.facebook.auth.protocol.LoginApprovalMutation.LoginApprovalMutationString;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.UserLoginApprovalInputData;
import com.facebook.graphql.calls.UserLoginApprovalInputData.ResponseType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: survey_start_url */
public class LoginApprovalNotificationService extends FbIntentService {
    private static final Class<?> f2300a = LoginApprovalNotificationService.class;
    public Lazy<GraphQLQueryExecutor> f2301b;

    private static <T extends Context> void m3192a(Class<T> cls, T t) {
        m3193a((Object) t, (Context) t);
    }

    public static void m3193a(Object obj, Context context) {
        ((LoginApprovalNotificationService) obj).f2301b = IdBasedLazy.a(FbInjector.get(context), 2164);
    }

    public LoginApprovalNotificationService() {
        super(f2300a.getSimpleName());
    }

    @Inject
    private void m3191a(Lazy<GraphQLQueryExecutor> lazy) {
        this.f2301b = lazy;
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 564308803);
        super.onCreate();
        Class cls = LoginApprovalNotificationService.class;
        m3193a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -184465947, a);
    }

    protected final void m3194a(Intent intent) {
        if (intent != null && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            Object string = extras.getString("arg_action");
            try {
                JSONObject jSONObject = new JSONObject(extras.getString("a_md"));
                String string2 = jSONObject.getString("datr");
                Object string3 = jSONObject.getString("ip");
                Object string4 = jSONObject.getString("device");
                if (!StringUtil.a(string) && !StringUtil.a(string2) && !StringUtil.a(string3) && !StringUtil.a(string4)) {
                    ResponseType responseType;
                    if (string.equals("action_approve")) {
                        responseType = ResponseType.LOGIN_APPROVE;
                    } else {
                        responseType = ResponseType.LOGIN_DENY;
                    }
                    UserLoginApprovalInputData c = new UserLoginApprovalInputData().m4498a(responseType).m4499a(string2).m4500b(string3).m4501c(string4);
                    LoginApprovalMutationString a = LoginApprovalMutation.m3237a();
                    a.a("input", c);
                    ((GraphQLQueryExecutor) this.f2301b.get()).a(GraphQLRequest.a(a));
                }
            } catch (JSONException e) {
            }
        }
    }
}
