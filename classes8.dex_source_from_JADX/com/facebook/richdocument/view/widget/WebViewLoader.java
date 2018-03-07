package com.facebook.richdocument.view.widget;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.logging.WebViewPerfInfoLogger;
import com.facebook.richdocument.view.widget.PrioritizedLoadingWebView.OnPageFinishedListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.inject.Inject;

@ContextScoped
/* compiled from: offer_claim_id */
public class WebViewLoader {
    private static WebViewLoader f7570d;
    private static final Object f7571e = new Object();
    private final Queue<LoadInfoHolder> f7572a = new PriorityQueue(10, new ItemComparator());
    private final List<LoadInfoHolder> f7573b = new ArrayList();
    private final WebViewPerfInfoLogger f7574c;

    /* compiled from: offer_claim_id */
    class ItemComparator implements Comparator<LoadInfoHolder> {
        public int compare(Object obj, Object obj2) {
            return m7769a((LoadInfoHolder) obj, LoadPriority.LOW).ordinal() - m7769a((LoadInfoHolder) obj2, LoadPriority.LOW).ordinal();
        }

        private static LoadPriority m7769a(LoadInfoHolder loadInfoHolder, LoadPriority loadPriority) {
            return (loadInfoHolder == null || loadInfoHolder.f7569f == null) ? loadPriority : loadInfoHolder.f7569f;
        }
    }

    /* compiled from: offer_claim_id */
    class LoadInfoHolder {
        final String f7564a;
        final String f7565b;
        final String f7566c;
        final String f7567d;
        final WeakReference<IAWebView> f7568e;
        final LoadPriority f7569f;

        public LoadInfoHolder(IAWebView iAWebView, String str, String str2, LoadPriority loadPriority) {
            this.f7564a = str;
            this.f7565b = str2;
            this.f7568e = new WeakReference(iAWebView);
            this.f7566c = null;
            this.f7567d = null;
            this.f7569f = loadPriority;
        }

        public LoadInfoHolder(IAWebView iAWebView, String str, String str2, String str3, LoadPriority loadPriority) {
            this.f7564a = str;
            this.f7566c = str2;
            this.f7567d = str3;
            this.f7565b = null;
            this.f7568e = new WeakReference(iAWebView);
            this.f7569f = loadPriority;
        }

        public LoadInfoHolder(IAWebView iAWebView) {
            this.f7568e = new WeakReference(iAWebView);
            this.f7564a = null;
            this.f7565b = null;
            this.f7566c = null;
            this.f7567d = null;
            this.f7569f = LoadPriority.LOW;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LoadInfoHolder)) {
                return super.equals(obj);
            }
            LoadInfoHolder loadInfoHolder = (LoadInfoHolder) obj;
            return (this.f7568e.get() != null && this.f7568e.get() == loadInfoHolder.f7568e.get()) || ((loadInfoHolder.f7566c != null && StringUtil.a(this.f7566c, loadInfoHolder.f7566c)) || (loadInfoHolder.f7565b != null && StringUtil.a(this.f7565b, loadInfoHolder.f7565b)));
        }
    }

    /* compiled from: offer_claim_id */
    public enum LoadPriority {
        BYPASS_LIMITS,
        HIGH,
        NORMAL,
        LOW
    }

    private static WebViewLoader m7773b(InjectorLike injectorLike) {
        return new WebViewLoader(WebViewPerfInfoLogger.m5422a(injectorLike));
    }

    @Inject
    public WebViewLoader(WebViewPerfInfoLogger webViewPerfInfoLogger) {
        this.f7574c = webViewPerfInfoLogger;
    }

    public final void m7777a(IAWebView iAWebView) {
        m7772a(new LoadInfoHolder(iAWebView));
    }

    private void m7772a(LoadInfoHolder loadInfoHolder) {
        this.f7572a.remove(loadInfoHolder);
        this.f7573b.remove(loadInfoHolder);
        m7774b(this);
    }

    public final void m7778a(IAWebView iAWebView, String str, String str2, LoadPriority loadPriority) {
        if (!StringUtil.c(str2)) {
            this.f7574c.m5425a(str);
            LoadInfoHolder loadInfoHolder = new LoadInfoHolder(iAWebView, str, str2, loadPriority);
            m7772a(loadInfoHolder);
            this.f7572a.add(loadInfoHolder);
            m7774b(this);
        }
    }

    public static WebViewLoader m7770a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WebViewLoader b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7571e) {
                WebViewLoader webViewLoader;
                if (a2 != null) {
                    webViewLoader = (WebViewLoader) a2.a(f7571e);
                } else {
                    webViewLoader = f7570d;
                }
                if (webViewLoader == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7773b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7571e, b3);
                        } else {
                            f7570d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = webViewLoader;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m7779a(IAWebView iAWebView, String str, String str2, String str3, LoadPriority loadPriority) {
        if (!StringUtil.c(str2) && !StringUtil.c(str3)) {
            this.f7574c.m5425a(str);
            LoadInfoHolder loadInfoHolder = new LoadInfoHolder(iAWebView, str, str2, str3, loadPriority);
            m7772a(loadInfoHolder);
            this.f7572a.add(loadInfoHolder);
            m7774b(this);
        }
    }

    private void m7771a() {
        LoadInfoHolder loadInfoHolder;
        do {
            loadInfoHolder = (LoadInfoHolder) this.f7572a.peek();
            if (loadInfoHolder != null && ((IAWebView) loadInfoHolder.f7568e.get()) == null) {
                this.f7572a.poll();
            } else {
                return;
            }
        } while (loadInfoHolder != null);
    }

    public static synchronized void m7774b(WebViewLoader webViewLoader) {
        synchronized (webViewLoader) {
            webViewLoader.m7771a();
            LoadInfoHolder loadInfoHolder = (LoadInfoHolder) webViewLoader.f7572a.peek();
            if (loadInfoHolder != null && (webViewLoader.f7573b.size() < 3 || loadInfoHolder.f7569f == LoadPriority.BYPASS_LIMITS)) {
                webViewLoader.f7572a.poll();
                webViewLoader.m7776c(loadInfoHolder);
                if (loadInfoHolder.f7569f != LoadPriority.BYPASS_LIMITS) {
                    webViewLoader.f7573b.add(loadInfoHolder);
                }
            }
        }
    }

    public static synchronized void m7775b(WebViewLoader webViewLoader, LoadInfoHolder loadInfoHolder) {
        synchronized (webViewLoader) {
            webViewLoader.f7573b.remove(loadInfoHolder);
        }
    }

    private synchronized void m7776c(final LoadInfoHolder loadInfoHolder) {
        ((IAWebView) loadInfoHolder.f7568e.get()).m7448a(new OnPageFinishedListener(this) {
            final /* synthetic */ WebViewLoader f7563b;

            public final void mo461a() {
                ((IAWebView) loadInfoHolder.f7568e.get()).m7449b(this);
                WebViewLoader.m7775b(this.f7563b, loadInfoHolder);
                WebViewLoader.m7774b(this.f7563b);
            }

            public final void mo462b() {
                ((IAWebView) loadInfoHolder.f7568e.get()).m7449b(this);
                WebViewLoader.m7775b(this.f7563b, loadInfoHolder);
                WebViewLoader.m7774b(this.f7563b);
            }

            public final void mo463c() {
                ((IAWebView) loadInfoHolder.f7568e.get()).m7449b(this);
                WebViewLoader.m7775b(this.f7563b, loadInfoHolder);
                WebViewLoader.m7774b(this.f7563b);
            }
        });
        this.f7574c.m5427b(loadInfoHolder.f7564a);
        if (StringUtil.c(loadInfoHolder.f7566c)) {
            ((IAWebView) loadInfoHolder.f7568e.get()).loadUrl(loadInfoHolder.f7565b);
        } else {
            ((IAWebView) loadInfoHolder.f7568e.get()).loadDataWithBaseURL(loadInfoHolder.f7567d, loadInfoHolder.f7566c, "text/html", "utf-8", null);
        }
    }
}
