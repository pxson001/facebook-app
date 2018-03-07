package com.facebook.gametime.ui.components.partdefinition;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.LayoutMeasureUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.gametime.ui.components.view.HeadToHeadTextView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.google.common.base.Strings;

@ContextScoped
/* compiled from: TAB_OUTGOING */
public class HeadToHeadTextPartDefinition extends MultiRowSinglePartDefinition<Props, Void, AnyEnvironment, HeadToHeadTextView> {
    public static final ViewType f25156a = new C30121();
    private static HeadToHeadTextPartDefinition f25157b;
    private static final Object f25158c = new Object();

    /* compiled from: TAB_OUTGOING */
    final class C30121 extends ViewType {
        C30121() {
        }

        public final View m27122a(Context context) {
            return new HeadToHeadTextView(context);
        }
    }

    /* compiled from: TAB_OUTGOING */
    public class Props {
        public final String f25151a;
        public final String f25152b;
        public final String f25153c;
        public final int f25154d;
        public final int f25155e;

        public Props(String str, String str2, String str3, int i, int i2) {
            this.f25151a = str;
            this.f25152b = str2;
            this.f25153c = str3;
            this.f25154d = i;
            this.f25155e = i2;
        }
    }

    private static HeadToHeadTextPartDefinition m27124b() {
        return new HeadToHeadTextPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m27126a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2050053528);
        Props props = (Props) obj;
        HeadToHeadTextView headToHeadTextView = (HeadToHeadTextView) view;
        headToHeadTextView.f25298b = headToHeadTextView.f25297a.a(props.f25151a).c(headToHeadTextView.f25301e).d();
        headToHeadTextView.f25302f = (float) LayoutMeasureUtil.a(headToHeadTextView.f25298b);
        CharSequence charSequence = props.f25152b;
        headToHeadTextView.f25299c = headToHeadTextView.f25297a.a(charSequence).c(props.f25154d).d();
        charSequence = props.f25153c;
        headToHeadTextView.f25300d = headToHeadTextView.f25297a.a(charSequence).c(props.f25155e).d();
        headToHeadTextView.f25303g = (float) LayoutMeasureUtil.a(headToHeadTextView.f25300d);
        Logger.a(8, EntryType.MARK_POP, -1834796200, a);
    }

    public final boolean m27127a(Object obj) {
        Props props = (Props) obj;
        return (Strings.isNullOrEmpty(props.f25151a) || Strings.isNullOrEmpty(props.f25152b) || Strings.isNullOrEmpty(props.f25153c)) ? false : true;
    }

    public final ViewType m27125a() {
        return f25156a;
    }

    public static HeadToHeadTextPartDefinition m27123a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeadToHeadTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25158c) {
                HeadToHeadTextPartDefinition headToHeadTextPartDefinition;
                if (a2 != null) {
                    headToHeadTextPartDefinition = (HeadToHeadTextPartDefinition) a2.a(f25158c);
                } else {
                    headToHeadTextPartDefinition = f25157b;
                }
                if (headToHeadTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m27124b();
                        if (a2 != null) {
                            a2.a(f25158c, b3);
                        } else {
                            f25157b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = headToHeadTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
