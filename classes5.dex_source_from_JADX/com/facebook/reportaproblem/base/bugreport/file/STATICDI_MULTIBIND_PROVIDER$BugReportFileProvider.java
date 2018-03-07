package com.facebook.reportaproblem.base.bugreport.file;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.abtest.qe.bootstrap.utils.QuickExperimentUtil;
import com.facebook.abtest.qe.bugreport.QuickExperimentFileProvider;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.common.diagnostics.LogReportFetcher;
import com.facebook.common.diagnostics.bugreport.LogReportFileProvider;
import com.facebook.common.errorreporting.ACRAReportFileProvider;
import com.facebook.contacts.iterator.ContactsDbExtraFileProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.internal.GatekeeperFileProvider;
import com.facebook.http.executors.liger.utils.NetworkEventLog;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.service.methods.RecentMessagesTracker;
import com.facebook.omnistore.module.OmnistoreExtraFileProvider;
import com.facebook.rtc.bugreporter.RtcBugReportLogger;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$BugReportFileProvider implements MultiBindIndexedProvider<BugReportFileProvider>, Provider<Set<BugReportFileProvider>> {
    private final InjectorLike f5246a;

    private STATICDI_MULTIBIND_PROVIDER$BugReportFileProvider(InjectorLike injectorLike) {
        this.f5246a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f5246a.getScopeAwareInjector(), this);
    }

    public static Provider<Set<BugReportFileProvider>> m10149a(InjectorLike injectorLike) {
        return new STATICDI_MULTIBIND_PROVIDER$BugReportFileProvider(injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 11;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new QuickExperimentFileProvider(QuickExperimentUtil.m2363a(injector));
            case 1:
                return BugReportOperationLogger.a(injector);
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return new LogReportFileProvider(LogReportFetcher.m3639b(injector));
            case 3:
                return new ACRAReportFileProvider();
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                return ContactsDbExtraFileProvider.a(injector);
            case 5:
                return new GatekeeperFileProvider(GatekeeperStoreImplMethodAutoProvider.a(injector));
            case 6:
                return NetworkEventLog.a(injector);
            case 7:
                return RecentMessagesTracker.a(injector);
            case 8:
                return OmnistoreExtraFileProvider.getInstance__com_facebook_omnistore_module_OmnistoreExtraFileProvider__INJECTED_BY_TemplateInjector(injector);
            case 9:
                return RtcBugReportLogger.a(injector);
            case 10:
                return SearchBugReportExtraDataProvider.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
