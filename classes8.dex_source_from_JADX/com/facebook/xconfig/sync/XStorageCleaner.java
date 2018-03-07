package com.facebook.xconfig.sync;

import com.facebook.auth.component.persistent.RecentUserIdsManager;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.debug.log.BLog;
import com.facebook.xconfig.core.XConfigStorage;
import com.google.common.base.Strings;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: location_opt_in_confirmation_page_impression */
public class XStorageCleaner implements IHaveUserData {
    private final Provider<String> f9937a;
    private final XConfigStorage f9938b;
    private final RecentUserIdsManager f9939c;

    @Inject
    public XStorageCleaner(Provider<String> provider, XConfigStorage xConfigStorage, RecentUserIdsManager recentUserIdsManager) {
        this.f9937a = provider;
        this.f9938b = xConfigStorage;
        this.f9939c = recentUserIdsManager;
    }

    public void clearUserData() {
        String str = (String) this.f9937a.get();
        if (Strings.isNullOrEmpty(str)) {
            BLog.c("XStorageCleaner", "User ID was null during attempt to clean xconfig storage");
            return;
        }
        List a = this.f9939c.a("most_recent_user_ids", str, 5);
        if (a != null) {
            int size = a.size();
            for (int i = 0; i < size; i++) {
                if (!this.f9938b.b((String) a.get(i))) {
                    BLog.c("XStorageCleaner", "Failed to clean up xconfig storage data for user %s", new Object[]{(String) a.get(i)});
                }
            }
        }
    }
}
