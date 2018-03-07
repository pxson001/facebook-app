package com.facebook.widget.tiles;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.callercontext.CallerContext;
import java.util.HashMap;
import java.util.Map;

/* compiled from: outgoing_message_lifetime */
public class InstrumentTile {
    public static void m6248a(AnalyticsLogger analyticsLogger, CallerContext callerContext, Drawable drawable, Bitmap bitmap) {
        if (Math.random() <= 0.002d && analyticsLogger != null && callerContext != null && drawable != null && bitmap != null) {
            Map hashMap = new HashMap();
            Rect bounds = drawable.getBounds();
            hashMap.put("view_width", String.valueOf(bounds.width()));
            hashMap.put("view_height", String.valueOf(bounds.height()));
            hashMap.put("image_width", String.valueOf(bitmap.getWidth()));
            hashMap.put("image_height", String.valueOf(bitmap.getHeight()));
            hashMap.put("calling_class", callerContext.b);
            hashMap.put("analytics_tag", callerContext.c());
            hashMap.put("module_tag", callerContext.d());
            hashMap.put("feature_tag", callerContext.b());
            analyticsLogger.a("messenger_instrumented_drawable", hashMap);
        }
    }
}
