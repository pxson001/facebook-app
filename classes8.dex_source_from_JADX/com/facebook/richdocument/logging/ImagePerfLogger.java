package com.facebook.richdocument.logging;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.utils.ConnectionQualityMonitor;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

@ContextScoped
/* compiled from: place_review_ego_unit */
public class ImagePerfLogger {
    private static ImagePerfLogger f5465g;
    private static final Object f5466h = new Object();
    private final int f5467a;
    private final int f5468b;
    private final ConnectionQuality f5469c;
    private final RichDocumentAnalyticsLogger f5470d;
    public final MonotonicClock f5471e;
    public final Map<String, ImageInfo> f5472f = new HashMap();

    /* compiled from: place_review_ego_unit */
    public class ImageInfo {
        final /* synthetic */ ImagePerfLogger f5452a;
        public boolean f5453b;
        public int f5454c;
        public int f5455d;
        public long f5456e = -1;
        public long f5457f = -1;
        public boolean f5458g;
        public boolean f5459h;
        public boolean f5460i;
        public long f5461j;
        public String f5462k;
        public boolean f5463l;
        public boolean f5464m;

        public ImageInfo(ImagePerfLogger imagePerfLogger, int i, int i2) {
            this.f5452a = imagePerfLogger;
            this.f5454c = i;
            this.f5455d = i2;
        }
    }

    private static ImagePerfLogger m5348b(InjectorLike injectorLike) {
        return new ImagePerfLogger((Context) injectorLike.getInstance(Context.class), RichDocumentAnalyticsLogger.m5360a(injectorLike), ConnectionQualityMonitor.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ImagePerfLogger(Context context, RichDocumentAnalyticsLogger richDocumentAnalyticsLogger, ConnectionQualityMonitor connectionQualityMonitor, MonotonicClock monotonicClock) {
        this.f5470d = richDocumentAnalyticsLogger;
        this.f5467a = context.getResources().getDisplayMetrics().widthPixels;
        this.f5468b = context.getResources().getDisplayMetrics().heightPixels;
        this.f5469c = connectionQualityMonitor.a();
        this.f5471e = monotonicClock;
    }

    public final void m5350a(String str, int i, int i2, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle, boolean z, boolean z2) {
        ImageInfo imageInfo = (ImageInfo) this.f5472f.get(str);
        if (imageInfo == null) {
            boolean z3;
            ImageInfo imageInfo2 = new ImageInfo(this, i, i2);
            if (graphQLDocumentMediaPresentationStyle == GraphQLDocumentMediaPresentationStyle.NON_INTERACTIVE || graphQLDocumentMediaPresentationStyle == GraphQLDocumentMediaPresentationStyle.ASPECT_FIT_ONLY) {
                z3 = false;
            } else {
                z3 = true;
            }
            imageInfo2.f5453b = z3;
            this.f5472f.put(str, imageInfo2);
            imageInfo = imageInfo2;
        }
        if (!(imageInfo.f5459h && imageInfo.f5460i)) {
            imageInfo.f5461j = this.f5471e.now();
        }
        if (z && !imageInfo.f5459h) {
            imageInfo.f5459h = true;
            imageInfo.f5456e = 0;
        }
        if (z2 && !imageInfo.f5460i) {
            imageInfo.f5460i = true;
            imageInfo.f5457f = 0;
        }
    }

    public static ImagePerfLogger m5347a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ImagePerfLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5466h) {
                ImagePerfLogger imagePerfLogger;
                if (a2 != null) {
                    imagePerfLogger = (ImagePerfLogger) a2.a(f5466h);
                } else {
                    imagePerfLogger = f5465g;
                }
                if (imagePerfLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5348b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5466h, b3);
                        } else {
                            f5465g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = imagePerfLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m5351a(String str, String str2, boolean z, boolean z2) {
        ImageInfo imageInfo = (ImageInfo) this.f5472f.get(str);
        if (imageInfo != null && !imageInfo.f5460i) {
            imageInfo.f5457f = this.f5471e.now() - imageInfo.f5461j;
            imageInfo.f5460i = true;
            imageInfo.f5462k = str2;
            imageInfo.f5463l = z;
            imageInfo.f5464m = z2;
        }
    }

    public final void m5349a() {
        for (Entry value : this.f5472f.entrySet()) {
            ImageInfo imageInfo = (ImageInfo) value.getValue();
            if (imageInfo != null) {
                Map hashMap = new HashMap();
                hashMap.put("image_width", Integer.valueOf(imageInfo.f5454c));
                hashMap.put("image_height", Integer.valueOf(imageInfo.f5455d));
                hashMap.put("expands_on_click", Boolean.valueOf(imageInfo.f5453b));
                hashMap.put("user_clicked_to_expand", Boolean.valueOf(imageInfo.f5458g));
                hashMap.put("duration_in_viewport_before_intermediate_image", Long.valueOf(imageInfo.f5456e));
                hashMap.put("duration_in_viewport_before_final_image", Long.valueOf(imageInfo.f5457f));
                hashMap.put("fragment_name", imageInfo.f5462k);
                hashMap.put("supports_screen_resolution_images", Boolean.valueOf(imageInfo.f5463l));
                hashMap.put("supports_full_resolution_images", Boolean.valueOf(imageInfo.f5464m));
                Map map = hashMap;
                map.put("screen_width", Integer.valueOf(this.f5467a));
                map.put("screen_height", Integer.valueOf(this.f5468b));
                map.put("connection_quality", this.f5469c);
                this.f5470d.m5371c("android_native_article_image_perf", map);
            }
        }
        this.f5472f.clear();
    }
}
