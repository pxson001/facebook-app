package com.facebook.richdocument.logging;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: place_picker_place_to_people_select */
public class RichDocumentLoggingUtils {
    private static RichDocumentLoggingUtils f5499c;
    private static final Object f5500d = new Object();
    public final FbSharedPreferences f5501a;
    public final MonotonicClock f5502b;

    private static RichDocumentLoggingUtils m5379b(InjectorLike injectorLike) {
        return new RichDocumentLoggingUtils((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RichDocumentLoggingUtils(FbSharedPreferences fbSharedPreferences, MonotonicClock monotonicClock) {
        this.f5501a = fbSharedPreferences;
        this.f5502b = monotonicClock;
    }

    public static RichDocumentLoggingUtils m5376a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichDocumentLoggingUtils b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5500d) {
                RichDocumentLoggingUtils richDocumentLoggingUtils;
                if (a2 != null) {
                    richDocumentLoggingUtils = (RichDocumentLoggingUtils) a2.a(f5500d);
                } else {
                    richDocumentLoggingUtils = f5499c;
                }
                if (richDocumentLoggingUtils == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5379b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5500d, b3);
                        } else {
                            f5499c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richDocumentLoggingUtils;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static String m5377a(@Nullable String str, @Nullable int i, @Nullable String str2, @Nullable String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n\nLast Article Information");
        m5378a(stringBuilder, "id", str);
        m5378a(stringBuilder, "version", Integer.toString(i));
        m5378a(stringBuilder, "title", str2);
        m5378a(stringBuilder, "url", str3);
        stringBuilder.append("\n\n");
        return stringBuilder.toString();
    }

    private static void m5378a(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append('\n');
        stringBuilder.append(str);
        stringBuilder.append(": ");
        if (!StringUtil.c(str2)) {
            stringBuilder.append(str2);
        }
    }
}
