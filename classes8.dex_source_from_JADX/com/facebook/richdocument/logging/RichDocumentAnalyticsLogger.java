package com.facebook.richdocument.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.RichDocumentInfo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: place_review_ego_launched_page */
public class RichDocumentAnalyticsLogger {
    private static RichDocumentAnalyticsLogger f5486g;
    private static final Object f5487h = new Object();
    private final AnalyticsLogger f5488a;
    private final RichDocumentSessionTracker f5489b;
    private final WeakReference<Context> f5490c;
    private final RichDocumentInfo f5491d;
    private final Set<String> f5492e = new HashSet();
    public String f5493f;

    private static RichDocumentAnalyticsLogger m5362b(InjectorLike injectorLike) {
        return new RichDocumentAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), RichDocumentSessionTracker.m5403a(injectorLike), (Context) injectorLike.getInstance(Context.class), RichDocumentInfo.m5102a(injectorLike));
    }

    @Inject
    public RichDocumentAnalyticsLogger(AnalyticsLogger analyticsLogger, RichDocumentSessionTracker richDocumentSessionTracker, Context context, RichDocumentInfo richDocumentInfo) {
        this.f5488a = analyticsLogger;
        this.f5489b = richDocumentSessionTracker;
        this.f5490c = new WeakReference(context);
        this.f5491d = richDocumentInfo;
    }

    public final void m5365a(String str, @Nullable String str2) {
        Map hashMap = new HashMap();
        if (!StringUtil.c(str2)) {
            hashMap.put("instant_article_media_id", str2);
        }
        m5366a(str, hashMap);
    }

    public static RichDocumentAnalyticsLogger m5360a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichDocumentAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5487h) {
                RichDocumentAnalyticsLogger richDocumentAnalyticsLogger;
                if (a2 != null) {
                    richDocumentAnalyticsLogger = (RichDocumentAnalyticsLogger) a2.a(f5487h);
                } else {
                    richDocumentAnalyticsLogger = f5486g;
                }
                if (richDocumentAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5362b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5487h, b3);
                        } else {
                            f5486g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richDocumentAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m5366a(String str, Map<String, Object> map) {
        if (!StringUtil.c(str) && !this.f5492e.contains(str)) {
            if (!(this.f5491d == null || this.f5491d.f5116d == null)) {
                map.put("instant_article_tracking_codes", this.f5491d.f5116d);
            }
            map.put("instant_article_element_id", str);
            m5371c("instant_article_vpv", map);
            this.f5492e.add(str);
        }
    }

    public final void m5369b(String str, Map<String, Object> map) {
        HoneyClientEventFast a = this.f5488a.a("open_link", false);
        if (a.a()) {
            a.b("url").c(str);
            m5361a(a, (Map) map);
        }
    }

    public final void m5367b(String str) {
        Map hashMap = new HashMap();
        hashMap.put("interaction", str);
        hashMap.put("ia_source", "native_article_text_block");
        m5371c("android_native_article_block_interaction", hashMap);
    }

    public final void m5363a(int i, String str, Map<String, Object> map) {
        if (map != null) {
            if (i == -1) {
                map.put("share_type", "edit_and_share_successful");
            } else if (i == 0) {
                map.put("share_type", "edit_and_share_abandoned");
            }
            m5371c(str, map);
        }
    }

    public final void m5368b(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("interaction", "link_tap");
        hashMap.put("webview_URL", str);
        hashMap.put("ia_source", str2);
        m5371c("android_native_article_block_interaction", hashMap);
    }

    public final void m5364a(String str, int i, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("interaction", str);
        hashMap.put("block_media_type", "slideshow");
        hashMap.put("current_slide", Integer.valueOf(i));
        hashMap.put("total_slides", Integer.valueOf(i2));
        if (i2 != 0) {
            hashMap.put("swipe_percent", Integer.valueOf((i * 100) / i2));
        }
        m5371c("android_native_article_block_interaction", hashMap);
    }

    public final void m5370c(@Nullable String str) {
        m5371c(str, null);
    }

    public final void m5371c(@Nullable String str, @Nullable Map<String, Object> map) {
        if (!StringUtil.a(str)) {
            m5361a(this.f5488a.a(str, false), (Map) map);
        }
    }

    private void m5361a(@Nullable HoneyClientEventFast honeyClientEventFast, @Nullable Map<String, Object> map) {
        if (honeyClientEventFast != null && honeyClientEventFast.a()) {
            if (map == null) {
                map = new HashMap();
            }
            if (!StringUtil.c(this.f5489b.f5564a)) {
                honeyClientEventFast.a("article_chaining_ID", this.f5489b.f5564a);
            }
            if (this.f5490c.get() != null) {
                honeyClientEventFast.a("article_depth_level", this.f5489b.m5409c((Context) this.f5490c.get()));
            }
            if (!map.containsKey("article_ID")) {
                map.put("article_ID", this.f5493f);
            }
            honeyClientEventFast.a(map);
            honeyClientEventFast.a("native_article_story");
            honeyClientEventFast.b();
        }
    }
}
