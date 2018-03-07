package com.facebook.richdocument.view.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.text.TextUtilsCompat;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLDocumentTextDirectionEnum;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.languages.switchercommon.ApplicationLocale;
import com.facebook.languages.switchercommonex.PersistentLocale;
import javax.inject.Inject;

@ContextScoped
/* compiled from: open_video_channel */
public class RichDocumentLayoutDirection {
    private static RichDocumentLayoutDirection f7066c;
    private static final Object f7067d = new Object();
    public GraphQLDocumentTextDirectionEnum f7068a;
    private final ApplicationLocale f7069b;

    private static RichDocumentLayoutDirection m7367b(InjectorLike injectorLike) {
        return new RichDocumentLayoutDirection((ApplicationLocale) PersistentLocale.a(injectorLike));
    }

    @Inject
    public RichDocumentLayoutDirection(ApplicationLocale applicationLocale) {
        this.f7069b = applicationLocale;
    }

    public final boolean m7369a() {
        return this.f7068a == GraphQLDocumentTextDirectionEnum.RIGHT_TO_LEFT;
    }

    public final boolean m7370b() {
        if (TextUtilsCompat.a(this.f7069b.a()) == 1) {
            return true;
        }
        return false;
    }

    public static boolean m7368c() {
        return VERSION.SDK_INT >= 17;
    }

    public static RichDocumentLayoutDirection m7366a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichDocumentLayoutDirection b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7067d) {
                RichDocumentLayoutDirection richDocumentLayoutDirection;
                if (a2 != null) {
                    richDocumentLayoutDirection = (RichDocumentLayoutDirection) a2.a(f7067d);
                } else {
                    richDocumentLayoutDirection = f7066c;
                }
                if (richDocumentLayoutDirection == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7367b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7067d, b3);
                        } else {
                            f7066c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richDocumentLayoutDirection;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
