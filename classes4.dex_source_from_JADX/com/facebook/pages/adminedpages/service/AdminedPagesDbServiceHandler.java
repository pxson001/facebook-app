package com.facebook.pages.adminedpages.service;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler$Filter;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.pages.adminedpages.db.DbAdminedPagesHandler;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchMethod.Result;
import com.facebook.pages.adminedpages.protocol.PagesAccessTokenPrefetchMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: error reading input (ignored) */
public class AdminedPagesDbServiceHandler implements BlueServiceHandler$Filter {
    public DbAdminedPagesHandler f12816a;
    public FbSharedPreferences f12817b;
    public Lazy<FbErrorReporter> f12818c;

    public static AdminedPagesDbServiceHandler m13659b(InjectorLike injectorLike) {
        return new AdminedPagesDbServiceHandler(DbAdminedPagesHandler.m13661a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public AdminedPagesDbServiceHandler(DbAdminedPagesHandler dbAdminedPagesHandler, FbSharedPreferences fbSharedPreferences, Lazy<FbErrorReporter> lazy) {
        this.f12816a = dbAdminedPagesHandler;
        this.f12817b = fbSharedPreferences;
        this.f12818c = lazy;
    }

    public final OperationResult mo57a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (!"admined_pages_prefetch".equals(operationParams.b)) {
            return blueServiceHandler.a(operationParams);
        }
        OperationResult a;
        if (((LoadAdminedPagesParams) operationParams.c.getParcelable("loadAdminedPagesParam")).f12807a != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
            a = this.f12816a.m13663a();
        } else {
            OperationResult a2 = blueServiceHandler.a(operationParams);
            ArrayList l = a2.l();
            if (l != null) {
                Result result = (Result) l.get(0);
                this.f12816a.m13664a(result, (PagesAccessTokenPrefetchMethod.Result) l.get(1));
                this.f12817b.edit().a(AdminedPagesOperationConstants.f12806b, result.clientTimeMs).commit();
            } else {
                ((AbstractFbErrorReporter) this.f12818c.get()).b(getClass().getSimpleName(), "Admined pages prefetch result is null.");
            }
            a = a2;
        }
        return a;
    }
}
