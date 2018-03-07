package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.text.ContentTextLayoutBasePartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextLayoutBasePartDefinitionProvider;
import com.facebook.feed.rows.sections.text.TextLayoutBuilderUtil;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.views.AccessibleTextLayoutView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: added_edge */
public class DefaultPermalinkTextPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasPositionInformation, AccessibleTextLayoutView> {
    private static DefaultPermalinkTextPartDefinition f19845b;
    private static final Object f19846c = new Object();
    private final ContentTextLayoutBasePartDefinition f19847a;

    private static DefaultPermalinkTextPartDefinition m23098b(InjectorLike injectorLike) {
        return new DefaultPermalinkTextPartDefinition((Context) injectorLike.getInstance(Context.class), FbTextLayoutCacheWarmer.a(injectorLike), (ContentTextLayoutBasePartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ContentTextLayoutBasePartDefinitionProvider.class));
    }

    public final Object m23100a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f19847a, (FeedProps) obj);
        return null;
    }

    @Inject
    public DefaultPermalinkTextPartDefinition(Context context, FbTextLayoutCacheWarmer fbTextLayoutCacheWarmer, ContentTextLayoutBasePartDefinitionProvider contentTextLayoutBasePartDefinitionProvider) {
        this.f19847a = contentTextLayoutBasePartDefinitionProvider.a(Boolean.valueOf(false), TextLayoutBuilderUtil.a(context, fbTextLayoutCacheWarmer), PaddingStyle.e);
    }

    public final ViewType<AccessibleTextLayoutView> m23099a() {
        return ContentTextLayoutBasePartDefinition.a;
    }

    public final boolean m23101a(Object obj) {
        return true;
    }

    public static DefaultPermalinkTextPartDefinition m23097a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultPermalinkTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19846c) {
                DefaultPermalinkTextPartDefinition defaultPermalinkTextPartDefinition;
                if (a2 != null) {
                    defaultPermalinkTextPartDefinition = (DefaultPermalinkTextPartDefinition) a2.a(f19846c);
                } else {
                    defaultPermalinkTextPartDefinition = f19845b;
                }
                if (defaultPermalinkTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23098b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19846c, b3);
                        } else {
                            f19845b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultPermalinkTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
