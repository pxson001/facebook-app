package com.facebook.search.util;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.api.SearchTheme;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import javax.inject.Inject;

@ContextScoped
/* compiled from: member_search_invite_result_section */
public class SearchThemeHelper {
    private static SearchThemeHelper f8932b;
    private static final Object f8933c = new Object();
    @Inject
    public FbTitleBarSupplier f8934a;

    /* compiled from: member_search_invite_result_section */
    /* synthetic */ class C09251 {
        static final /* synthetic */ int[] f8931a = new int[SearchTheme.values().length];

        static {
            try {
                f8931a[SearchTheme.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8931a[SearchTheme.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static SearchThemeHelper m10663b(InjectorLike injectorLike) {
        SearchThemeHelper searchThemeHelper = new SearchThemeHelper();
        searchThemeHelper.f8934a = (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike);
        return searchThemeHelper;
    }

    public static ContextThemeWrapper m10661a(Context context, SearchTheme searchTheme) {
        int i;
        switch (C09251.f8931a[searchTheme.ordinal()]) {
            case 1:
                i = 2131625933;
                break;
            case 2:
                i = 2131625931;
                break;
            default:
                throw new IllegalArgumentException("Unknown theme: " + searchTheme);
        }
        return new ContextThemeWrapper(context, i);
    }

    public final void m10664a(Context context) {
        FbTitleBar fbTitleBar = (FbTitleBar) this.f8934a.get();
        if (!BuildConstants.j && fbTitleBar != null && (fbTitleBar instanceof View)) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(2130772517, typedValue, true);
            ((View) fbTitleBar).setBackgroundDrawable(new ColorDrawable(typedValue.data));
        }
    }

    public static SearchThemeHelper m10662a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchThemeHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8933c) {
                SearchThemeHelper searchThemeHelper;
                if (a2 != null) {
                    searchThemeHelper = (SearchThemeHelper) a2.a(f8933c);
                } else {
                    searchThemeHelper = f8932b;
                }
                if (searchThemeHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10663b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8933c, b3);
                        } else {
                            f8932b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchThemeHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
