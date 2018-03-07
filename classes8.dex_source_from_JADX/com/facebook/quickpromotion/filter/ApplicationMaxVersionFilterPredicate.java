package com.facebook.quickpromotion.filter;

import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.VersionStringComparator;
import javax.inject.Inject;

/* compiled from: recent */
public class ApplicationMaxVersionFilterPredicate extends AbstractApplicationVersionFilterPredicate {
    @Inject
    public ApplicationMaxVersionFilterPredicate(AppVersionInfo appVersionInfo, VersionStringComparator versionStringComparator) {
        super(appVersionInfo, versionStringComparator);
    }

    protected final boolean mo218a(int i) {
        return i <= 0;
    }
}
