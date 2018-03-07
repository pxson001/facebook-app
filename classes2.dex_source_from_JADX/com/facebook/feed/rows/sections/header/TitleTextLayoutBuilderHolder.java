package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.text.Layout.Alignment;
import android.util.TypedValue;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: group/%s */
public class TitleTextLayoutBuilderHolder {
    private static TitleTextLayoutBuilderHolder f21788b;
    private static final Object f21789c = new Object();
    public final TextLayoutBuilder f21790a = new TextLayoutBuilder();

    private static TitleTextLayoutBuilderHolder m29522b(InjectorLike injectorLike) {
        return new TitleTextLayoutBuilderHolder((Context) injectorLike.getInstance(Context.class), RTLUtil.m6553a(injectorLike), FbTextLayoutCacheWarmer.m28443a(injectorLike));
    }

    @Inject
    public TitleTextLayoutBuilderHolder(Context context, RTLUtil rTLUtil, FbTextLayoutCacheWarmer fbTextLayoutCacheWarmer) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842806, typedValue, true);
        this.f21790a.m28604b(context.getResources().getDimensionPixelSize(2131430351));
        this.f21790a.m28606c(typedValue.data);
        this.f21790a.m28590a(context.getResources().getDimension(2131430350));
        this.f21790a.m28603b(1.0f);
        this.f21790a.m28600a(false);
        this.f21790a.m28597a(rTLUtil.m6557a() ? Alignment.ALIGN_OPPOSITE : Alignment.ALIGN_NORMAL);
        this.f21790a.f20866f = true;
        this.f21790a.f20864d = fbTextLayoutCacheWarmer;
    }

    public static TitleTextLayoutBuilderHolder m29521a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TitleTextLayoutBuilderHolder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21789c) {
                TitleTextLayoutBuilderHolder titleTextLayoutBuilderHolder;
                if (a2 != null) {
                    titleTextLayoutBuilderHolder = (TitleTextLayoutBuilderHolder) a2.mo818a(f21789c);
                } else {
                    titleTextLayoutBuilderHolder = f21788b;
                }
                if (titleTextLayoutBuilderHolder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29522b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21789c, b3);
                        } else {
                            f21788b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = titleTextLayoutBuilderHolder;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
