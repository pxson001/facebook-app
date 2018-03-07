package com.facebook.groups.info;

import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: ThreadListFragment.onViewCreated */
public class DefaultGroupLeaveActionResponder {
    public static final String f22593a = DefaultGroupLeaveActionResponder.class.getName();
    public FbFragment f22594b;
    public AbstractFbErrorReporter f22595c;

    public static DefaultGroupLeaveActionResponder m23588b(InjectorLike injectorLike) {
        return new DefaultGroupLeaveActionResponder((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DefaultGroupLeaveActionResponder(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f22595c = abstractFbErrorReporter;
    }
}
