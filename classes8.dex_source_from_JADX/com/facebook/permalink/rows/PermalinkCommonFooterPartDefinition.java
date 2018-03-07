package com.facebook.permalink.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.graphql.model.GraphQLStory;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: story_attachment_null */
public class PermalinkCommonFooterPartDefinition<V extends View & Footer> extends BaseSinglePartDefinition<GraphQLStory, Void, CanFeedback, V> {
    private static PermalinkCommonFooterPartDefinition f2034b;
    private static final Object f2035c = new Object();
    private final int f2036a;

    private static PermalinkCommonFooterPartDefinition m2265b(InjectorLike injectorLike) {
        return new PermalinkCommonFooterPartDefinition(ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m2266a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -301467539);
        m2264a(view);
        Logger.a(8, EntryType.MARK_POP, -1566670644, a);
    }

    @Inject
    public PermalinkCommonFooterPartDefinition(Resources resources) {
        this.f2036a = (int) resources.getDimension(2131427485);
    }

    private void m2264a(V v) {
        ((Footer) v).setButtonContainerHeight(this.f2036a);
    }

    public static PermalinkCommonFooterPartDefinition m2263a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkCommonFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2035c) {
                PermalinkCommonFooterPartDefinition permalinkCommonFooterPartDefinition;
                if (a2 != null) {
                    permalinkCommonFooterPartDefinition = (PermalinkCommonFooterPartDefinition) a2.a(f2035c);
                } else {
                    permalinkCommonFooterPartDefinition = f2034b;
                }
                if (permalinkCommonFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2265b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2035c, b3);
                        } else {
                            f2034b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkCommonFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
