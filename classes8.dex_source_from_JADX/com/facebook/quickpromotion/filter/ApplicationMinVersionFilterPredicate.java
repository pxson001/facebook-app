package com.facebook.quickpromotion.filter;

import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.VersionStringComparator;
import javax.inject.Inject;

/* compiled from: readd_policy */
public class ApplicationMinVersionFilterPredicate extends AbstractApplicationVersionFilterPredicate {
    @Inject
    public ApplicationMinVersionFilterPredicate(AppVersionInfo appVersionInfo, VersionStringComparator versionStringComparator) {
        super(appVersionInfo, versionStringComparator);
    }

    protected final boolean mo218a(int i) {
        return i >= 0;
    }
}
