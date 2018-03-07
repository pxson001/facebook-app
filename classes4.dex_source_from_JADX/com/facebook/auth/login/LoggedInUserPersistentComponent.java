package com.facebook.auth.login;

import com.facebook.auth.component.persistent.AbstractPersistentComponent;
import com.facebook.auth.component.persistent.RecentUserIdsManager;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.protocol.GetLoggedInUserGraphQLMethod;
import com.facebook.auth.protocol.GetLoggedInUserGraphQLResult;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.build.BuildConstants;
import com.facebook.config.application.Product;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.Lazy;
import com.facebook.user.model.UserBuilder;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: survey */
public class LoggedInUserPersistentComponent extends AbstractPersistentComponent {
    public final Lazy<LoggedInUserSessionManager> f1536a;
    public final Lazy<GetLoggedInUserGraphQLMethod> f1537b;
    private final Lazy<RecentUserIdsManager> f1538c;
    private final int f1539d;

    /* compiled from: survey */
    class LoggedInUserBatchComponent implements BatchComponent {
        final /* synthetic */ LoggedInUserPersistentComponent f1540a;

        public LoggedInUserBatchComponent(LoggedInUserPersistentComponent loggedInUserPersistentComponent) {
            this.f1540a = loggedInUserPersistentComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            Builder a = BatchOperation.m12541a((ApiMethod) this.f1540a.f1537b.get(), null);
            a.f11927c = "getLoggedInUser";
            return Collections.singletonList(a.m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            GetLoggedInUserGraphQLResult getLoggedInUserGraphQLResult = (GetLoggedInUserGraphQLResult) map.get("getLoggedInUser");
            UserBuilder userBuilder = new UserBuilder();
            userBuilder.a(getLoggedInUserGraphQLResult.f1998a);
            ((LoggedInUserSessionManager) this.f1540a.f1536a.get()).c(userBuilder.aa());
        }
    }

    @Inject
    public LoggedInUserPersistentComponent(Lazy<LoggedInUserSessionManager> lazy, Lazy<GetLoggedInUserGraphQLMethod> lazy2, Lazy<RecentUserIdsManager> lazy3, Product product) {
        int i;
        this.f1536a = lazy;
        this.f1537b = lazy2;
        this.f1538c = lazy3;
        if (product != Product.FB4A || BuildConstants.j) {
            i = 0;
        } else {
            i = 3;
        }
        this.f1539d = i;
    }

    public final boolean cn_() {
        return ((LoggedInUserSessionManager) this.f1536a.get()).e();
    }

    public final BatchComponent mo95c() {
        return new LoggedInUserBatchComponent(this);
    }

    public final void mo97d() {
        LoggedInUserSessionManager loggedInUserSessionManager = (LoggedInUserSessionManager) this.f1536a.get();
        ViewerContext a = loggedInUserSessionManager.a();
        if (a != null) {
            List a2 = ((RecentUserIdsManager) this.f1538c.get()).a("logged_in_user_ids", a.mUserId, this.f1539d);
            if (a2 != null) {
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    loggedInUserSessionManager.a((String) a2.get(i));
                }
            }
        }
    }
}
