package com.facebook.messaging.attributionview;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attribution.AttributionActionType;
import com.facebook.messaging.attribution.FetchPlatformAppLogoUrlMethod;
import com.facebook.messaging.attribution.PlatformAttributionLogging;
import com.facebook.messaging.attributionview.AttributionHelper.AttributionSource;
import com.facebook.messaging.attributionview.AttributionView.LoggingListener;
import com.facebook.messaging.model.attribution.AttributionVisibility;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.messages.Message;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: orion_sender/ */
public class AttributionViewHelper {
    private static final Class<?> f7953a = AttributionViewHelper.class;
    private static final Set<String> f7954b = Sets.a(new String[]{"124024574287414", "174829003346", "656877194440124", "105130332854716", "442164512652912", "855665214540622", "1618947608322644", "1025893017429199", "1630981187182691", "727991484011850", "1766110890282433", "1478965865731978", "1647803662125878", "1631905017080967", "878517022202731", "1693579324195246", "409282235929050", "127263487617977", "1463208340651717", "547540368734655", "1605839019680063", "671525626282582", "1486124138352877", "956860287702725", "48119224995"});
    @DefaultExecutorService
    private final ListeningExecutorService f7955c;
    @ForUiThread
    private final Executor f7956d;
    public final FetchPlatformAppLogoUrlMethod f7957e;
    public final ApiMethodRunnerImpl f7958f;
    private final PackageManager f7959g;
    public final PlatformAttributionLogging f7960h;
    private final AttributionHelper f7961i;
    public FutureAndCallbackHolder f7962j;

    /* compiled from: orion_sender/ */
    class C08911 implements LoggingListener {
        final /* synthetic */ AttributionViewHelper f7947a;

        C08911(AttributionViewHelper attributionViewHelper) {
            this.f7947a = attributionViewHelper;
        }

        public final void mo289a(AttributionViewData attributionViewData, @Nullable AttributionActionType attributionActionType) {
            this.f7947a.f7960h.m8084a(attributionViewData.mo294b(), attributionViewData.mo292a().a, attributionActionType != null ? attributionActionType.loggingString : null);
        }

        public final void mo290b(AttributionViewData attributionViewData, @Nullable AttributionActionType attributionActionType) {
            this.f7947a.f7960h.m8087b(attributionViewData.mo294b(), attributionViewData.mo292a().a, attributionActionType != null ? attributionActionType.loggingString : null);
        }
    }

    private static AttributionViewHelper m8185b(InjectorLike injectorLike) {
        return new AttributionViewHelper(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), FetchPlatformAppLogoUrlMethod.m8047a(injectorLike), ApiMethodRunnerImpl.a(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike), PlatformAttributionLogging.m8077a(injectorLike), AttributionHelper.m8143b(injectorLike));
    }

    public static AttributionViewHelper m8178a(InjectorLike injectorLike) {
        return m8185b(injectorLike);
    }

    @Inject
    public AttributionViewHelper(ListeningExecutorService listeningExecutorService, Executor executor, FetchPlatformAppLogoUrlMethod fetchPlatformAppLogoUrlMethod, ApiMethodRunnerImpl apiMethodRunnerImpl, PackageManager packageManager, PlatformAttributionLogging platformAttributionLogging, AttributionHelper attributionHelper) {
        this.f7955c = listeningExecutorService;
        this.f7956d = executor;
        this.f7957e = fetchPlatformAppLogoUrlMethod;
        this.f7958f = apiMethodRunnerImpl;
        this.f7959g = packageManager;
        this.f7960h = platformAttributionLogging;
        this.f7961i = attributionHelper;
    }

    public final void m8189a(AttributionView attributionView, Message message, AttributionSource attributionSource) {
        m8180a();
        switch (attributionSource) {
            case PLATFORM_CONTENT_APP:
                m8181a(attributionView, message);
                return;
            case INTERNAL_FEATURE:
                m8186b(attributionView, message);
                return;
            case MONTAGE:
                m8188c(attributionView, message);
                return;
            default:
                return;
        }
    }

    private void m8181a(AttributionView attributionView, Message message) {
        AttributionViewData a = m8179a(message);
        attributionView.f7946k = new C08911(this);
        attributionView.setAttributionViewData(a);
    }

    private void m8186b(AttributionView attributionView, Message message) {
        AttributionViewData a = this.f7961i.m8146a(message);
        attributionView.f7946k = this.f7961i.m8145a();
        attributionView.setAttributionViewData(a);
    }

    private void m8188c(AttributionView attributionView, Message message) {
        AttributionViewData montageAddAttributionViewData = new MontageAddAttributionViewData(message);
        attributionView.f7946k = this.f7961i.m8145a();
        attributionView.setAttributionViewData(montageAddAttributionViewData);
    }

    private PlatformAttributionViewData m8179a(Message message) {
        ContentAppAttribution contentAppAttribution = message.F;
        boolean a = m8183a(contentAppAttribution.e);
        boolean a2 = m8182a(contentAppAttribution, a);
        boolean contains = f7954b.contains(contentAppAttribution.b);
        AttributionActionType attributionActionType = null;
        if (a2) {
            attributionActionType = a ? AttributionActionType.PLATFORM_APP_REPLY : AttributionActionType.PLATFORM_APP_INSTALL;
        }
        if (attributionActionType == AttributionActionType.PLATFORM_APP_REPLY && contains) {
            attributionActionType = AttributionActionType.PLATFORM_APP_OPEN;
        }
        final PlatformAttributionViewData platformAttributionViewData = new PlatformAttributionViewData(message, attributionActionType);
        ListenableFuture a3 = this.f7955c.a(new Callable<Uri>(this) {
            final /* synthetic */ AttributionViewHelper f7949b;

            public Object call() {
                return (Uri) this.f7949b.f7958f.a(this.f7949b.f7957e, platformAttributionViewData.mo294b());
            }
        });
        C08933 c08933 = new DisposableFutureCallback<Uri>(this) {
            final /* synthetic */ AttributionViewHelper f7951b;

            public void onSuccess(@Nullable Object obj) {
                platformAttributionViewData.m8205a((Uri) obj);
                this.f7951b.f7962j = null;
            }

            public void onFailure(Throwable th) {
                platformAttributionViewData.m8205a(null);
            }

            public final void jc_() {
            }

            public final boolean ba_() {
                return false;
            }
        };
        this.f7962j = FutureAndCallbackHolder.a(a3, c08933);
        Futures.a(a3, c08933, this.f7956d);
        return platformAttributionViewData;
    }

    private boolean m8183a(String str) {
        try {
            this.f7959g.getPackageInfo(str, 0);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static boolean m8182a(ContentAppAttribution contentAppAttribution, boolean z) {
        AttributionVisibility attributionVisibility = contentAppAttribution.h;
        if (StringUtil.a(contentAppAttribution.e)) {
            return false;
        }
        if (z) {
            if (attributionVisibility.e) {
                return false;
            }
            return true;
        } else if (attributionVisibility.f) {
            return false;
        } else {
            return true;
        }
    }

    private void m8180a() {
        if (this.f7962j != null) {
            this.f7962j.a(true);
        }
    }
}
