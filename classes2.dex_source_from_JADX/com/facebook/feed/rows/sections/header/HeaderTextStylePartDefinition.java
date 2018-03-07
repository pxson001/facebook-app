package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.feed.rows.views.ContentTextView;
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
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friend_list_name */
public class HeaderTextStylePartDefinition extends BaseSinglePartDefinition<TextHeaderStyle, Props, AnyEnvironment, ContentTextView> {
    private static HeaderTextStylePartDefinition f23178b;
    private static final Object f23179c = new Object();
    private final Resources f23180a;

    private static HeaderTextStylePartDefinition m31289b(InjectorLike injectorLike) {
        return new HeaderTextStylePartDefinition(ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        TextHeaderStyle textHeaderStyle = (TextHeaderStyle) obj;
        return new Props(textHeaderStyle.getColor(this.f23180a), textHeaderStyle.getFontStyle(), textHeaderStyle.getFontSize(this.f23180a));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 625553576);
        Props props = (Props) obj2;
        ContentTextView contentTextView = (ContentTextView) view;
        contentTextView.setTextColor(props.a);
        contentTextView.setTypeface(null, props.b);
        contentTextView.setTextSize((float) props.c);
        Logger.a(8, EntryType.MARK_POP, 1166507042, a);
    }

    @Inject
    public HeaderTextStylePartDefinition(Resources resources) {
        this.f23180a = resources;
    }

    public static HeaderTextStylePartDefinition m31288a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderTextStylePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23179c) {
                HeaderTextStylePartDefinition headerTextStylePartDefinition;
                if (a2 != null) {
                    headerTextStylePartDefinition = (HeaderTextStylePartDefinition) a2.mo818a(f23179c);
                } else {
                    headerTextStylePartDefinition = f23178b;
                }
                if (headerTextStylePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31289b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23179c, b3);
                        } else {
                            f23178b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerTextStylePartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
