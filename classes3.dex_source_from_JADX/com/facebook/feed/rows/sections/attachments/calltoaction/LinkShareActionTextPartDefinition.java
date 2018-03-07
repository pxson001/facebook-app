package com.facebook.feed.rows.sections.attachments.calltoaction;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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

@ContextScoped
/* compiled from: VideoPrefetchPartDefinition.prepare */
public class LinkShareActionTextPartDefinition extends BaseSinglePartDefinition<GraphQLStoryAttachment, CharSequence, AnyEnvironment, TextView> {
    private static LinkShareActionTextPartDefinition f324a;
    private static final Object f325b = new Object();

    private static LinkShareActionTextPartDefinition m285a() {
        return new LinkShareActionTextPartDefinition();
    }

    public final Object m287a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStoryAttachment) obj, 41461717);
        return a != null ? a.Q() : null;
    }

    public final /* bridge */ /* synthetic */ void m288a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1298320017);
        ((TextView) view).setText((CharSequence) obj2);
        Logger.a(8, EntryType.MARK_POP, 1087409988, a);
    }

    public static LinkShareActionTextPartDefinition m286a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LinkShareActionTextPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f325b) {
                LinkShareActionTextPartDefinition linkShareActionTextPartDefinition;
                if (a3 != null) {
                    linkShareActionTextPartDefinition = (LinkShareActionTextPartDefinition) a3.a(f325b);
                } else {
                    linkShareActionTextPartDefinition = f324a;
                }
                if (linkShareActionTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m285a();
                        if (a3 != null) {
                            a3.a(f325b, a2);
                        } else {
                            f324a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = linkShareActionTextPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
