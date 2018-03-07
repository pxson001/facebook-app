package com.facebook.orca.threadlist;

import android.content.Context;
import android.view.ContextThemeWrapper;
import com.facebook.common.util.ContextUtils;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: name_max_length_ever */
public class ThreadListThemeWrapper {
    private final ThreadListExperimentManager f6736a;
    private final QeAccessor f6737b;

    @Inject
    public ThreadListThemeWrapper(ThreadListExperimentManager threadListExperimentManager, QeAccessor qeAccessor) {
        this.f6736a = threadListExperimentManager;
        this.f6737b = qeAccessor;
    }

    public final Context m6423a(Context context) {
        Context a = ContextUtils.a(context, 2130772970, 2131625118);
        if (this.f6736a.f6597b) {
            return new ContextThemeWrapper(a, 2131625119);
        }
        return a;
    }
}
