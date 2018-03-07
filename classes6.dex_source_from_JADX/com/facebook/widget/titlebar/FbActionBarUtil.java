package com.facebook.widget.titlebar;

import android.content.Context;
import com.facebook.R;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: rawImageURI */
public class FbActionBarUtil {
    private static FbActionBarUtil f6239b;
    private static final Object f6240c = new Object();
    private final Context f6241a;

    private static FbActionBarUtil m8790b(InjectorLike injectorLike) {
        return new FbActionBarUtil((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public FbActionBarUtil(Context context) {
        this.f6241a = context;
    }

    public final boolean m8791a() {
        return this.f6241a.getTheme().obtainStyledAttributes(R.styleable.TitleBarViewStub).getBoolean(2, false);
    }

    public static FbActionBarUtil m8789a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FbActionBarUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6240c) {
                FbActionBarUtil fbActionBarUtil;
                if (a2 != null) {
                    fbActionBarUtil = (FbActionBarUtil) a2.a(f6240c);
                } else {
                    fbActionBarUtil = f6239b;
                }
                if (fbActionBarUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8790b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6240c, b3);
                        } else {
                            f6239b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fbActionBarUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
