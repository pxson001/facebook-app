package com.facebook.bugreporter;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.contacts.iterator.ContactsDbExtraFileProvider;
import com.facebook.http.executors.liger.utils.NetworkEventLog;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.service.methods.RecentMessagesTracker;
import com.facebook.omnistore.module.OmnistoreExtraFileProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.richdocument.logging.RichDocumentBugReportExtraFileMapProvider;
import com.facebook.rtc.bugreporter.RtcBugReportLogger;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import com.facebook.xconfig.bugreporting.XConfigExtraFileProvider;
import com.facebook.xconfig.core.XConfigReader;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$BugReportExtraFileMapProvider implements MultiBindIndexedProvider<BugReportExtraFileMapProvider>, Provider<Set<BugReportExtraFileMapProvider>> {
    private final InjectorLike f10662a;

    private STATICDI_MULTIBIND_PROVIDER$BugReportExtraFileMapProvider(InjectorLike injectorLike) {
        this.f10662a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10662a.getScopeAwareInjector(), this);
    }

    public static Set<BugReportExtraFileMapProvider> m18684a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$BugReportExtraFileMapProvider(injectorLike));
    }

    public final int size() {
        return 9;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return BugReportOperationLogger.a(injector);
            case 1:
                return ContactsDbExtraFileProvider.a(injector);
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return NetworkEventLog.a(injector);
            case 3:
                return RecentMessagesTracker.a(injector);
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                return OmnistoreExtraFileProvider.getInstance__com_facebook_omnistore_module_OmnistoreExtraFileProvider__INJECTED_BY_TemplateInjector(injector);
            case 5:
                return new RichDocumentBugReportExtraFileMapProvider((FbSharedPreferences) FbSharedPreferencesImpl.a(injector), FbObjectMapperMethodAutoProvider.a(injector), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injector), XConfigReader.a(injector));
            case 6:
                return RtcBugReportLogger.a(injector);
            case 7:
                return SearchBugReportExtraDataProvider.a(injector);
            case 8:
                return new XConfigExtraFileProvider(XConfigReader.a(injector), IdBasedSingletonScopeProvider.b(injector, 3750));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
