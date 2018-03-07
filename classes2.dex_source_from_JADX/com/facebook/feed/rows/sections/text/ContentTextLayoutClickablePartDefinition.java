package com.facebook.feed.rows.sections.text;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.views.AccessibleTextLayoutView;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
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
/* compiled from: holderAttached */
public class ContentTextLayoutClickablePartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasPositionInformation, AccessibleTextLayoutView> {
    private static ContentTextLayoutClickablePartDefinition f20980c;
    private static final Object f20981d = new Object();
    private final ContentTextLayoutBasePartDefinition f20982a;
    private final TextLinkPartDefinition f20983b;

    private static ContentTextLayoutClickablePartDefinition m28701b(InjectorLike injectorLike) {
        return new ContentTextLayoutClickablePartDefinition((Context) injectorLike.getInstance(Context.class), FbTextLayoutCacheWarmer.m28443a(injectorLike), (ContentTextLayoutBasePartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ContentTextLayoutBasePartDefinitionProvider.class), TextLinkPartDefinition.m28402a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f20982a, feedProps);
        subParts.mo2756a(this.f20983b, feedProps);
        return null;
    }

    public final boolean m28704a(Object obj) {
        return this.f20982a.m28615a((FeedProps) obj);
    }

    @Inject
    public ContentTextLayoutClickablePartDefinition(Context context, FbTextLayoutCacheWarmer fbTextLayoutCacheWarmer, ContentTextLayoutBasePartDefinitionProvider contentTextLayoutBasePartDefinitionProvider, TextLinkPartDefinition textLinkPartDefinition) {
        this.f20982a = contentTextLayoutBasePartDefinitionProvider.m28578a(Boolean.valueOf(true), TextLayoutBuilderUtil.m28585a(context, fbTextLayoutCacheWarmer), PaddingStyle.f13075e);
        this.f20983b = textLinkPartDefinition;
    }

    public final ViewType<AccessibleTextLayoutView> mo2547a() {
        return ContentTextLayoutBasePartDefinition.f20885a;
    }

    public static ContentTextLayoutClickablePartDefinition m28700a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentTextLayoutClickablePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20981d) {
                ContentTextLayoutClickablePartDefinition contentTextLayoutClickablePartDefinition;
                if (a2 != null) {
                    contentTextLayoutClickablePartDefinition = (ContentTextLayoutClickablePartDefinition) a2.mo818a(f20981d);
                } else {
                    contentTextLayoutClickablePartDefinition = f20980c;
                }
                if (contentTextLayoutClickablePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28701b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20981d, b3);
                        } else {
                            f20980c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = contentTextLayoutClickablePartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
