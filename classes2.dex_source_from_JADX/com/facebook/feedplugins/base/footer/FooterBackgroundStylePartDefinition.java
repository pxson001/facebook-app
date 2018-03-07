package com.facebook.feedplugins.base.footer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;

@ContextScoped
/* compiled from: get_media */
public class FooterBackgroundStylePartDefinition<V extends View & Footer> extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, V> {
    private static FooterBackgroundStylePartDefinition f22438a;
    private static final Object f22439b = new Object();

    /* compiled from: get_media */
    public class Props {
        public final FooterBackgroundStyleDefinition f22445a;
        public final Drawable f22446b;
        public final Drawable f22447c;

        public Props(FooterBackgroundStyleDefinition footerBackgroundStyleDefinition, Drawable drawable, Drawable drawable2) {
            this.f22445a = footerBackgroundStyleDefinition;
            this.f22446b = drawable;
            this.f22447c = drawable2;
        }
    }

    private static FooterBackgroundStylePartDefinition m30343a() {
        return new FooterBackgroundStylePartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 106185426);
        Props props = (Props) obj;
        Footer footer = (Footer) view;
        footer.setButtonContainerBackground(props.f22447c);
        footer.setDownstateType(props.f22445a.f18974f);
        footer.setTopDividerStyle(props.f22445a.f18975g);
        footer.setBottomDividerStyle(props.f22445a.f18976h);
        if (props.f22446b != null) {
            view.setBackgroundDrawable(props.f22446b);
        }
        props.f22445a.f18971c.m26678a(view);
        Logger.a(8, EntryType.MARK_POP, -246802784, a);
    }

    public static FooterBackgroundStylePartDefinition m30344a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FooterBackgroundStylePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f22439b) {
                FooterBackgroundStylePartDefinition footerBackgroundStylePartDefinition;
                if (a3 != null) {
                    footerBackgroundStylePartDefinition = (FooterBackgroundStylePartDefinition) a3.mo818a(f22439b);
                } else {
                    footerBackgroundStylePartDefinition = f22438a;
                }
                if (footerBackgroundStylePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m30343a();
                        if (a3 != null) {
                            a3.mo822a(f22439b, a2);
                        } else {
                            f22438a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = footerBackgroundStylePartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
