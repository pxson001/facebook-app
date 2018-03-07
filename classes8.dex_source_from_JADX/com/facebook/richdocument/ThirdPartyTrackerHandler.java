package com.facebook.richdocument;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentStartupUiTasksCompletedSubscriber;
import com.facebook.richdocument.fetcher.TrackerFetcher;
import com.facebook.richdocument.logging.RichDocumentPerfInfoLogger;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTrackerModel;
import com.facebook.richdocument.view.util.WebViewUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: privacy_override */
public class ThirdPartyTrackerHandler {
    private static final int f5131a = "tracker_block_uuid".hashCode();
    private static ThirdPartyTrackerHandler f5132n;
    private static final Object f5133o = new Object();
    private final WebViewUtils f5134b;
    private final RichDocumentEventBus f5135c;
    private final GatekeeperStoreImpl f5136d;
    private final TrackerFetcher f5137e;
    public final AbstractFbErrorReporter f5138f;
    public final RichDocumentPerfInfoLogger f5139g;
    public final List<TrackerInfo> f5140h = new ArrayList();
    public FrameLayout f5141i;
    public String f5142j;
    public String f5143k;
    public boolean f5144l = false;
    private final RichDocumentStartupUiTasksCompletedSubscriber f5145m = new C06821(this);

    /* compiled from: privacy_override */
    class C06821 extends RichDocumentStartupUiTasksCompletedSubscriber {
        final /* synthetic */ ThirdPartyTrackerHandler f5121a;

        C06821(ThirdPartyTrackerHandler thirdPartyTrackerHandler) {
            this.f5121a = thirdPartyTrackerHandler;
        }

        public final void m5107b(FbEvent fbEvent) {
            this.f5121a.f5144l = true;
            for (TrackerInfo trackerInfo : this.f5121a.f5140h) {
                ThirdPartyTrackerHandler thirdPartyTrackerHandler = this.f5121a;
                if (StringUtil.c(trackerInfo.f5127b)) {
                    thirdPartyTrackerHandler.m5118a(trackerInfo.f5126a, trackerInfo.f5128c);
                } else {
                    thirdPartyTrackerHandler.m5120b(trackerInfo.f5127b, trackerInfo.f5128c);
                }
            }
        }
    }

    /* compiled from: privacy_override */
    public class TrackerInfo {
        public final String f5126a;
        public final String f5127b;
        public final String f5128c;

        public TrackerInfo(@Nullable String str, @Nullable String str2, String str3) {
            this.f5126a = str;
            this.f5128c = str3;
            this.f5127b = str2;
        }
    }

    /* compiled from: privacy_override */
    public enum TrackerType {
        URL,
        JS
    }

    /* compiled from: privacy_override */
    class TrackerWebViewClient extends WebViewClient {
        final /* synthetic */ ThirdPartyTrackerHandler f5129a;
        private final String f5130b;

        public TrackerWebViewClient(ThirdPartyTrackerHandler thirdPartyTrackerHandler, String str) {
            this.f5129a = thirdPartyTrackerHandler;
            this.f5130b = str;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return false;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.f5129a.f5139g.m5394a(this.f5130b);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.f5129a.f5139g.m5396b(this.f5130b);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            this.f5129a.f5139g.m5396b(this.f5130b);
        }
    }

    private static ThirdPartyTrackerHandler m5115b(InjectorLike injectorLike) {
        return new ThirdPartyTrackerHandler(WebViewUtils.m7372a(injectorLike), RichDocumentEventBus.m5130a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), TrackerFetcher.m5168a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), RichDocumentPerfInfoLogger.m5390a(injectorLike));
    }

    public static ThirdPartyTrackerHandler m5112a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThirdPartyTrackerHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5133o) {
                ThirdPartyTrackerHandler thirdPartyTrackerHandler;
                if (a2 != null) {
                    thirdPartyTrackerHandler = (ThirdPartyTrackerHandler) a2.a(f5133o);
                } else {
                    thirdPartyTrackerHandler = f5132n;
                }
                if (thirdPartyTrackerHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5115b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5133o, b3);
                        } else {
                            f5132n = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = thirdPartyTrackerHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ThirdPartyTrackerHandler(WebViewUtils webViewUtils, RichDocumentEventBus richDocumentEventBus, GatekeeperStoreImpl gatekeeperStoreImpl, TrackerFetcher trackerFetcher, AbstractFbErrorReporter abstractFbErrorReporter, RichDocumentPerfInfoLogger richDocumentPerfInfoLogger) {
        this.f5134b = webViewUtils;
        this.f5135c = richDocumentEventBus;
        this.f5135c.a(this.f5145m);
        this.f5136d = gatekeeperStoreImpl;
        this.f5137e = trackerFetcher;
        this.f5138f = abstractFbErrorReporter;
        this.f5139g = richDocumentPerfInfoLogger;
    }

    public final void m5118a(@Nullable String str, @Nullable final String str2) {
        if (!StringUtil.c(str) && !StringUtil.c(str2)) {
            if (!this.f5144l) {
                this.f5140h.add(new TrackerInfo(str, null, str2));
            } else if (!m5113a(str2) && this.f5141i != null) {
                if (m5117c()) {
                    this.f5137e.m5170a(str2, this.f5142j, new ResultFutureCallback<GraphQLResult<RichDocumentTrackerModel>>(this) {
                        final /* synthetic */ ThirdPartyTrackerHandler f5123b;

                        protected final void m5109a(Object obj) {
                            GraphQLResult graphQLResult = (GraphQLResult) obj;
                            if (graphQLResult != null && graphQLResult.e != null) {
                                CharSequence k = ((RichDocumentTrackerModel) graphQLResult.e).m6450k();
                                String a = ((RichDocumentTrackerModel) graphQLResult.e).m6448a();
                                if (!StringUtil.c(k)) {
                                    CharSequence charSequence = k;
                                }
                                ThirdPartyTrackerHandler.m5116c(this.f5123b, a, str2);
                            }
                        }

                        protected final void m5108a(ServiceException serviceException) {
                            this.f5123b.f5138f.a("ThirdPartyTrackerHandler", "Error fetching async tracker info: " + str2, serviceException);
                        }
                    });
                } else {
                    m5116c(this, str, str2);
                }
            }
        }
    }

    public static void m5116c(ThirdPartyTrackerHandler thirdPartyTrackerHandler, String str, String str2) {
        if (thirdPartyTrackerHandler.f5141i != null) {
            thirdPartyTrackerHandler.f5139g.m5395a(str2, TrackerType.URL);
            WebView webView = new WebView(thirdPartyTrackerHandler.m5114b());
            webView.setWebViewClient(new TrackerWebViewClient(thirdPartyTrackerHandler, str2));
            thirdPartyTrackerHandler.f5134b.m7378a(webView);
            webView.setTag(f5131a, str2);
            thirdPartyTrackerHandler.f5141i.addView(webView);
            webView.loadUrl(str);
        }
    }

    public final void m5120b(@Nullable String str, @Nullable final String str2) {
        if (!StringUtil.c(str) && !StringUtil.c(str2)) {
            if (!this.f5144l) {
                this.f5140h.add(new TrackerInfo(null, str, str2));
            } else if (this.f5141i != null && !m5113a(str2)) {
                if (m5117c()) {
                    this.f5137e.m5170a(str2, this.f5142j, new ResultFutureCallback<GraphQLResult<RichDocumentTrackerModel>>(this) {
                        final /* synthetic */ ThirdPartyTrackerHandler f5125b;

                        protected final void m5111a(Object obj) {
                            GraphQLResult graphQLResult = (GraphQLResult) obj;
                            if (graphQLResult != null && graphQLResult.e != null) {
                                String k = ((RichDocumentTrackerModel) graphQLResult.e).m6450k();
                                String a = ((RichDocumentTrackerModel) graphQLResult.e).m6448a();
                                if (StringUtil.c(k)) {
                                    k = a;
                                }
                                this.f5125b.m5119a(((RichDocumentTrackerModel) graphQLResult.e).m6449j(), str2, k);
                            }
                        }

                        protected final void m5110a(ServiceException serviceException) {
                            this.f5125b.f5138f.a("ThirdPartyTrackerHandler", "Error fetching async tracker info: " + str2, serviceException);
                        }
                    });
                } else {
                    m5119a(str, str2, this.f5143k);
                }
            }
        }
    }

    public final void m5119a(String str, String str2, String str3) {
        if (this.f5141i != null) {
            this.f5139g.m5395a(str2, TrackerType.JS);
            WebView webView = new WebView(m5114b());
            webView.setWebViewClient(new TrackerWebViewClient(this, str2));
            this.f5134b.m7378a(webView);
            webView.setTag(f5131a, str2);
            this.f5141i.addView(webView);
            webView.loadDataWithBaseURL(str3, str, "text/html", "utf-8", null);
        }
    }

    private Context m5114b() {
        Context context = this.f5141i.getContext();
        if (this.f5136d.a(706, false)) {
            return context.getApplicationContext();
        }
        return context;
    }

    private boolean m5113a(@Nullable String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < this.f5141i.getChildCount(); i++) {
            if (StringUtil.a((String) this.f5141i.getChildAt(i).getTag(f5131a), str)) {
                return true;
            }
        }
        return false;
    }

    private boolean m5117c() {
        return this.f5136d.a(680, false);
    }
}
