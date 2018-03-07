package com.facebook.ui.browser.logging;

import android.content.Context;
import android.webkit.WebView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.analytics.LongClickTracker;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.logging.RichDocumentSessionTracker;
import com.facebook.ui.browser.event.BrowserEventBus;
import com.facebook.ui.browser.event.BrowserEventSubscriber;
import com.facebook.ui.browser.event.BrowserEvents.OnPageFinishedEvent;
import com.facebook.ui.browser.event.BrowserEvents.OnPageFinishedEventSubscriber;
import com.facebook.ui.browser.event.BrowserEvents.OnPageStartedEvent;
import com.facebook.ui.browser.event.BrowserEvents.OnPauseEvent;
import com.facebook.ui.browser.event.BrowserEvents.OnPauseEventSubscriber;
import com.facebook.ui.browser.event.BrowserEvents.OnResumeEvent;
import com.facebook.ui.browser.event.BrowserEvents.OnResumeEventSubscriber;
import com.facebook.ui.browser.event.BrowserEvents.OnScrollChangedEvent;
import com.facebook.ui.browser.event.BrowserEvents.OnScrollChangedEvent.MAP_KEYS;
import com.facebook.ui.browser.event.BrowserEvents.OnScrollChangedEventSubscriber;
import com.facebook.ui.browser.event.BrowserEvents.ShouldOverrideUrlLoadingEvent;
import com.facebook.ui.browser.event.BrowserEvents.ShouldOverrideUrlLoadingEvent.ACTIVE_LOGGERS;
import com.facebook.ui.browser.event.BrowserEvents.ShouldOverrideUrlLoadingEventSubscriber;
import com.facebook.ui.browser.event.BrowserEvents.onPageStartedEventSubscriber;
import com.google.common.collect.ImmutableSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: tincan_master_key */
public class BrowserLongClickLogger {
    private static BrowserLongClickLogger f1567s;
    private static final Object f1568t = new Object();
    private final LongClickTracker f1569a;
    private final RichDocumentSessionTracker f1570b;
    private final Context f1571c;
    private String f1572d;
    private boolean f1573e = true;
    private boolean f1574f = false;
    private TimeCounter f1575g;
    private double f1576h;
    private double f1577i;
    private double f1578j;
    private double f1579k;
    public BrowserEventSubscriber<OnPageStartedEvent> f1580l;
    public BrowserEventSubscriber<OnResumeEvent> f1581m;
    public BrowserEventSubscriber<OnPauseEvent> f1582n;
    public BrowserEventSubscriber<OnScrollChangedEvent> f1583o;
    public BrowserEventSubscriber<OnPageFinishedEvent> f1584p;
    public BrowserEventSubscriber<ShouldOverrideUrlLoadingEvent> f1585q;
    public final BrowserEventBus f1586r;

    /* compiled from: tincan_master_key */
    public class C01541 extends onPageStartedEventSubscriber {
        final /* synthetic */ BrowserLongClickLogger f1560a;

        public C01541(BrowserLongClickLogger browserLongClickLogger) {
            this.f1560a = browserLongClickLogger;
        }

        public final void m1630b(FbEvent fbEvent) {
            OnPageStartedEvent onPageStartedEvent = (OnPageStartedEvent) fbEvent;
            if (StringUtil.a(onPageStartedEvent.f1529b, onPageStartedEvent.f1528a.getUrl())) {
                this.f1560a.m1646a();
            }
        }
    }

    /* compiled from: tincan_master_key */
    public class C01552 extends OnResumeEventSubscriber {
        final /* synthetic */ BrowserLongClickLogger f1561a;

        public C01552(BrowserLongClickLogger browserLongClickLogger) {
            this.f1561a = browserLongClickLogger;
        }

        public final void m1631b(FbEvent fbEvent) {
            this.f1561a.m1649b();
        }
    }

    /* compiled from: tincan_master_key */
    public class C01563 extends OnPauseEventSubscriber {
        final /* synthetic */ BrowserLongClickLogger f1562a;

        public C01563(BrowserLongClickLogger browserLongClickLogger) {
            this.f1562a = browserLongClickLogger;
        }

        public final void m1632b(FbEvent fbEvent) {
            this.f1562a.m1650c();
        }
    }

    /* compiled from: tincan_master_key */
    public class C01574 extends ShouldOverrideUrlLoadingEventSubscriber {
        final /* synthetic */ BrowserLongClickLogger f1563a;

        public C01574(BrowserLongClickLogger browserLongClickLogger) {
            this.f1563a = browserLongClickLogger;
        }

        public final void m1633b(FbEvent fbEvent) {
            if (ImmutableSet.copyOf(((ShouldOverrideUrlLoadingEvent) fbEvent).f1533a).contains(ACTIVE_LOGGERS.LONG_CLICK_BROWSER)) {
                this.f1563a.m1646a();
            }
        }
    }

    /* compiled from: tincan_master_key */
    public class C01585 extends OnScrollChangedEventSubscriber {
        final /* synthetic */ BrowserLongClickLogger f1564a;

        public C01585(BrowserLongClickLogger browserLongClickLogger) {
            this.f1564a = browserLongClickLogger;
        }

        public final void m1634b(FbEvent fbEvent) {
            OnScrollChangedEvent onScrollChangedEvent = (OnScrollChangedEvent) fbEvent;
            if (!onScrollChangedEvent.f1531b && onScrollChangedEvent.m1606c().containsKey(MAP_KEYS.URLS_EQUAL)) {
                this.f1564a.m1648a(((Boolean) onScrollChangedEvent.m1606c().get(MAP_KEYS.URLS_EQUAL)).booleanValue(), onScrollChangedEvent.f1530a);
            }
        }
    }

    /* compiled from: tincan_master_key */
    public class C01596 extends OnPageFinishedEventSubscriber {
        final /* synthetic */ BrowserLongClickLogger f1565a;

        public C01596(BrowserLongClickLogger browserLongClickLogger) {
            this.f1565a = browserLongClickLogger;
        }

        public final void m1635b(FbEvent fbEvent) {
            OnPageFinishedEvent onPageFinishedEvent = (OnPageFinishedEvent) fbEvent;
            this.f1565a.m1647a(onPageFinishedEvent.f1526a, onPageFinishedEvent.f1527b);
        }
    }

    /* compiled from: tincan_master_key */
    public class TimeCounter {
        public Date f1566a;

        public final double m1636a() {
            double d = 0.0d;
            if (this.f1566a != null) {
                d = (double) (new Date().getTime() - this.f1566a.getTime());
            }
            this.f1566a = new Date();
            return d;
        }
    }

    private static BrowserLongClickLogger m1639b(InjectorLike injectorLike) {
        return new BrowserLongClickLogger(LongClickTracker.a(injectorLike), BrowserEventBus.m1600a(injectorLike), RichDocumentSessionTracker.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public BrowserLongClickLogger(LongClickTracker longClickTracker, BrowserEventBus browserEventBus, RichDocumentSessionTracker richDocumentSessionTracker, Context context) {
        this.f1569a = longClickTracker;
        this.f1575g = new TimeCounter();
        this.f1586r = browserEventBus;
        this.f1570b = richDocumentSessionTracker;
        this.f1571c = context;
        this.f1580l = new C01541(this);
        this.f1581m = new C01552(this);
        this.f1582n = new C01563(this);
        this.f1585q = new C01574(this);
        this.f1583o = new C01585(this);
        this.f1584p = new C01596(this);
        this.f1586r.a(this.f1580l);
        this.f1586r.a(this.f1581m);
        this.f1586r.a(this.f1582n);
        this.f1586r.a(this.f1585q);
        this.f1586r.a(this.f1583o);
        this.f1586r.a(this.f1584p);
    }

    public static BrowserLongClickLogger m1637a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BrowserLongClickLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1568t) {
                BrowserLongClickLogger browserLongClickLogger;
                if (a2 != null) {
                    browserLongClickLogger = (BrowserLongClickLogger) a2.a(f1568t);
                } else {
                    browserLongClickLogger = f1567s;
                }
                if (browserLongClickLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1639b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1568t, b3);
                        } else {
                            f1567s = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = browserLongClickLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m1646a() {
        m1640b(true);
    }

    public final void m1647a(WebView webView, String str) {
        if (webView != null && StringUtil.a(str, webView.getUrl())) {
            this.f1572d = webView.getUrl();
            m1640b(false);
        }
    }

    public final void m1648a(boolean z, String str) {
        if (z) {
            this.f1572d = str;
            m1640b(false);
        }
    }

    public final void m1649b() {
        m1638a(true);
    }

    public final void m1650c() {
        m1638a(false);
        m1641c(false);
    }

    private void m1638a(boolean z) {
        if (z) {
            if (!this.f1574f) {
                m1644g();
            }
            m1642e();
        } else {
            if (!this.f1574f) {
                m1643f();
            }
            m1642e();
        }
        this.f1573e = z;
    }

    private void m1640b(boolean z) {
        if (this.f1573e) {
            if (!this.f1574f && z) {
                TimeCounter timeCounter = this.f1575g;
                double d = 0.0d;
                if (timeCounter.f1566a != null) {
                    d = (double) (new Date().getTime() - timeCounter.f1566a.getTime());
                }
                if (d > 1000.0d) {
                    m1643f();
                    m1641c(true);
                    this.f1576h = 0.0d;
                }
            }
            if (this.f1574f) {
                m1642e();
            } else {
                m1643f();
            }
        } else if (this.f1574f || !z) {
            m1642e();
        } else {
            m1644g();
        }
        this.f1574f = z;
    }

    private void m1642e() {
        this.f1576h += this.f1575g.m1636a();
        this.f1577i = 0.0d;
    }

    private void m1643f() {
        this.f1577i += this.f1575g.m1636a();
        m1645h();
    }

    private void m1644g() {
        this.f1575g.m1636a();
    }

    private void m1645h() {
        Map hashMap = new HashMap();
        hashMap.putAll(this.f1570b.b());
        hashMap.put("article_depth_level", Integer.toString(this.f1570b.c(this.f1571c)));
        hashMap.put("article_aggregate_view_time", Double.toString(this.f1578j / 1000.0d));
        hashMap.put("article_aggregate_load_time", Double.toString(this.f1579k / 1000.0d));
        this.f1569a.a(this.f1572d, this.f1576h, this.f1577i, hashMap);
    }

    private void m1641c(boolean z) {
        this.f1570b.a(this.f1577i);
        this.f1578j += this.f1577i;
        this.f1579k += this.f1576h;
        m1645h();
        this.f1569a.a();
        this.f1577i = 0.0d;
        this.f1576h = 0.0d;
        if (z) {
            this.f1572d = null;
        }
    }
}
