package com.facebook.ui.browser.logging;

import android.webkit.WebView;
import com.facebook.common.util.TriState;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.browser.event.BrowserEventBus;
import com.facebook.ui.browser.event.BrowserEventSubscriber;
import com.facebook.ui.browser.event.BrowserEvents.OnFinishEvent;
import com.facebook.ui.browser.event.BrowserEvents.OnFinishEventSubscriber;
import com.facebook.ui.browser.event.BrowserEvents.OnPageFinishedEvent;
import com.facebook.ui.browser.event.BrowserEvents.OnPageFinishedEventSubscriber;
import com.facebook.ui.browser.event.BrowserEvents.OnScrollChangedEvent;
import com.facebook.ui.browser.event.BrowserEvents.OnScrollChangedEvent.MAP_KEYS;
import com.facebook.ui.browser.event.BrowserEvents.OnScrollChangedEventSubscriber;
import com.facebook.ui.browser.gating.IsScrollLoggingEnabled;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: tincan_db_ */
public class BrowserScrollLogger {
    @IsScrollLoggingEnabled
    Provider<TriState> f1595a;
    public HashMap<String, List> f1596b = new HashMap();
    public HashSet<String> f1597c = new HashSet();
    public boolean f1598d = true;
    public BrowserAnalyticsLogger f1599e;
    public boolean f1600f;
    public BrowserEventSubscriber<OnFinishEvent> f1601g;
    public BrowserEventSubscriber<OnScrollChangedEvent> f1602h;
    public BrowserEventSubscriber<OnPageFinishedEvent> f1603i;
    public final BrowserEventBus f1604j;

    /* compiled from: tincan_db_ */
    public class C01601 extends OnFinishEventSubscriber {
        final /* synthetic */ BrowserScrollLogger f1587a;

        public C01601(BrowserScrollLogger browserScrollLogger) {
            this.f1587a = browserScrollLogger;
        }

        public final void m1651b(FbEvent fbEvent) {
            BrowserScrollLogger browserScrollLogger = this.f1587a;
            if (browserScrollLogger.f1600f) {
                Iterator it = browserScrollLogger.f1597c.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    List list = (List) browserScrollLogger.f1596b.get(str);
                    if (list != null) {
                        float floatValue = ((Float) list.get(tableIndexes.AMOUNT_SCROLLED_INDEX.getValue())).floatValue();
                        float floatValue2 = ((Float) list.get(tableIndexes.AMOUNT_SEEN_INDEX.getValue())).floatValue();
                        float floatValue3 = ((Float) list.get(tableIndexes.CONTENT_HEIGHT_INDEX.getValue())).floatValue();
                        Map hashMap = new HashMap();
                        hashMap.put("url", str);
                        hashMap.put("amount_scrolled", Float.toString(floatValue));
                        hashMap.put("amount_seen", Float.toString(floatValue2));
                        hashMap.put("content_height", Float.toString(floatValue3));
                        browserScrollLogger.f1599e.m1628a("browser_url_scroll", hashMap);
                    }
                }
            }
        }
    }

    /* compiled from: tincan_db_ */
    public class C01612 extends OnScrollChangedEventSubscriber {
        final /* synthetic */ BrowserScrollLogger f1588a;

        public C01612(BrowserScrollLogger browserScrollLogger) {
            this.f1588a = browserScrollLogger;
        }

        public final void m1652b(FbEvent fbEvent) {
            WebViewScrollExtras webViewScrollExtras = (WebViewScrollExtras) ((OnScrollChangedEvent) fbEvent).m1606c().get(MAP_KEYS.SCROLL_LOGGING_DATA);
            if (webViewScrollExtras != null) {
                this.f1588a.m1655a(webViewScrollExtras.f1590a, webViewScrollExtras.f1591b, webViewScrollExtras.f1592c, webViewScrollExtras.f1593d, webViewScrollExtras.f1594e);
            }
        }
    }

    /* compiled from: tincan_db_ */
    public class C01623 extends OnPageFinishedEventSubscriber {
        final /* synthetic */ BrowserScrollLogger f1589a;

        public C01623(BrowserScrollLogger browserScrollLogger) {
            this.f1589a = browserScrollLogger;
        }

        public final void m1653b(FbEvent fbEvent) {
            OnPageFinishedEvent onPageFinishedEvent = (OnPageFinishedEvent) fbEvent;
            BrowserScrollLogger browserScrollLogger = this.f1589a;
            WebView webView = onPageFinishedEvent.f1526a;
            String url = webView.getUrl();
            if (browserScrollLogger.f1600f && browserScrollLogger.f1598d) {
                browserScrollLogger.f1597c.add(url);
                browserScrollLogger.m1655a(url, 0, webView.getHeight(), webView.getContentHeight(), webView.getContext().getResources().getDisplayMetrics().density);
                browserScrollLogger.f1598d = false;
            }
        }
    }

    /* compiled from: tincan_db_ */
    public class WebViewScrollExtras {
        public String f1590a;
        public int f1591b;
        public int f1592c;
        public int f1593d;
        public float f1594e;
    }

    /* compiled from: tincan_db_ */
    public enum tableIndexes {
        AMOUNT_SCROLLED_INDEX(0),
        AMOUNT_SEEN_INDEX(1),
        CONTENT_HEIGHT_INDEX(2);
        
        private final int index;

        private tableIndexes(int i) {
            this.index = i;
        }

        public final int getValue() {
            return this.index;
        }
    }

    private static BrowserScrollLogger m1654b(InjectorLike injectorLike) {
        return new BrowserScrollLogger(BrowserAnalyticsLogger.m1626a(injectorLike), IdBasedProvider.a(injectorLike, 799), BrowserEventBus.m1600a(injectorLike));
    }

    @Inject
    public BrowserScrollLogger(BrowserAnalyticsLogger browserAnalyticsLogger, Provider<TriState> provider, BrowserEventBus browserEventBus) {
        this.f1604j = browserEventBus;
        this.f1599e = browserAnalyticsLogger;
        this.f1595a = provider;
        this.f1600f = ((TriState) this.f1595a.get()).asBoolean(false);
        this.f1601g = new C01601(this);
        this.f1602h = new C01612(this);
        this.f1603i = new C01623(this);
        this.f1604j.a(this.f1602h);
        this.f1604j.a(this.f1603i);
        this.f1604j.a(this.f1601g);
    }

    public final void m1655a(String str, int i, int i2, int i3, float f) {
        if (this.f1600f && this.f1596b != null) {
            float max;
            float max2;
            List arrayList = new ArrayList();
            List list = (List) this.f1596b.get(str);
            float f2 = (float) i;
            float f3 = (float) (i + i2);
            float f4 = ((float) i3) * f;
            if (list != null) {
                f2 = Math.max(((Float) list.get(tableIndexes.AMOUNT_SCROLLED_INDEX.getValue())).floatValue(), f2);
                max = Math.max(((Float) list.get(tableIndexes.AMOUNT_SEEN_INDEX.getValue())).floatValue(), f3);
                max2 = Math.max(((Float) list.get(tableIndexes.CONTENT_HEIGHT_INDEX.getValue())).floatValue(), f4);
                f4 = f2;
            } else {
                max2 = f4;
                max = f3;
                f4 = f2;
            }
            arrayList.add(Float.valueOf(f4));
            arrayList.add(Float.valueOf(max));
            arrayList.add(Float.valueOf(max2));
            this.f1596b.put(str, arrayList);
        }
    }
}
