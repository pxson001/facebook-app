package com.facebook.feed.rows.sections;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
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
/* compiled from: \. */
public class SubStoriesTitlePartDefinition<E extends AnyEnvironment> extends BaseSinglePartDefinition<GraphQLStoryAttachment, CharSequence, E, TextView> {
    private static SubStoriesTitlePartDefinition f20464a;
    private static final Object f20465b = new Object();

    private static SubStoriesTitlePartDefinition m23550a() {
        return new SubStoriesTitlePartDefinition();
    }

    public final Object m23552a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
        if (graphQLStoryAttachment.A() != null) {
            return graphQLStoryAttachment.A();
        }
        return "";
    }

    public final /* bridge */ /* synthetic */ void m23553a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 778587777);
        ((TextView) view).setText((CharSequence) obj2);
        Logger.a(8, EntryType.MARK_POP, 108437843, a);
    }

    public static SubStoriesTitlePartDefinition m23551a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SubStoriesTitlePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f20465b) {
                SubStoriesTitlePartDefinition subStoriesTitlePartDefinition;
                if (a3 != null) {
                    subStoriesTitlePartDefinition = (SubStoriesTitlePartDefinition) a3.a(f20465b);
                } else {
                    subStoriesTitlePartDefinition = f20464a;
                }
                if (subStoriesTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m23550a();
                        if (a3 != null) {
                            a3.a(f20465b, a2);
                        } else {
                            f20464a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = subStoriesTitlePartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
