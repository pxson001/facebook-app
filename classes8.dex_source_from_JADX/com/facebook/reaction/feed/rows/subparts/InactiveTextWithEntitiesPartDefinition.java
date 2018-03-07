package com.facebook.reaction.feed.rows.subparts;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
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
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: annotation_text */
public class InactiveTextWithEntitiesPartDefinition extends BaseSinglePartDefinition<LinkableTextWithEntities, Void, AnyEnvironment, TextWithEntitiesView> {
    private static InactiveTextWithEntitiesPartDefinition f19418a;
    private static final Object f19419b = new Object();

    private static InactiveTextWithEntitiesPartDefinition m23401a() {
        return new InactiveTextWithEntitiesPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m23403a(@Nullable Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -421324833);
        LinkableTextWithEntities linkableTextWithEntities = (LinkableTextWithEntities) obj;
        TextWithEntitiesView textWithEntitiesView = (TextWithEntitiesView) view;
        if (linkableTextWithEntities == null || TextUtils.isEmpty(linkableTextWithEntities.a())) {
            textWithEntitiesView.setVisibility(8);
        } else {
            textWithEntitiesView.setVisibility(0);
            textWithEntitiesView.a(linkableTextWithEntities.a(), linkableTextWithEntities.b());
        }
        Logger.a(8, EntryType.MARK_POP, -1807779503, a);
    }

    public static InactiveTextWithEntitiesPartDefinition m23402a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InactiveTextWithEntitiesPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f19419b) {
                InactiveTextWithEntitiesPartDefinition inactiveTextWithEntitiesPartDefinition;
                if (a3 != null) {
                    inactiveTextWithEntitiesPartDefinition = (InactiveTextWithEntitiesPartDefinition) a3.a(f19419b);
                } else {
                    inactiveTextWithEntitiesPartDefinition = f19418a;
                }
                if (inactiveTextWithEntitiesPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m23401a();
                        if (a3 != null) {
                            a3.a(f19419b, a2);
                        } else {
                            f19418a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = inactiveTextWithEntitiesPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
