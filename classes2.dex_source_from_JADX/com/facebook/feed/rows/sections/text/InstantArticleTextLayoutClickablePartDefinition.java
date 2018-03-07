package com.facebook.feed.rows.sections.text;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
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
/* compiled from: hot_like_has_seen_nux_bubble */
public class InstantArticleTextLayoutClickablePartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasPositionInformation, AccessibleTextLayoutView> {
    private static InstantArticleTextLayoutClickablePartDefinition f20849c;
    private static final Object f20850d = new Object();
    private final ContentTextLayoutBasePartDefinition f20851a;
    private final InstantArticleClickTextPartDefinition f20852b;

    private static InstantArticleTextLayoutClickablePartDefinition m28573b(InjectorLike injectorLike) {
        return new InstantArticleTextLayoutClickablePartDefinition((Context) injectorLike.getInstance(Context.class), FbTextLayoutCacheWarmer.m28443a(injectorLike), (ContentTextLayoutBasePartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ContentTextLayoutBasePartDefinitionProvider.class), InstantArticleClickTextPartDefinition.m28579a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f20851a, feedProps);
        subParts.mo2756a(this.f20852b, graphQLStory);
        return null;
    }

    @Inject
    public InstantArticleTextLayoutClickablePartDefinition(Context context, FbTextLayoutCacheWarmer fbTextLayoutCacheWarmer, ContentTextLayoutBasePartDefinitionProvider contentTextLayoutBasePartDefinitionProvider, InstantArticleClickTextPartDefinition instantArticleClickTextPartDefinition) {
        this.f20851a = contentTextLayoutBasePartDefinitionProvider.m28578a(Boolean.valueOf(true), TextLayoutBuilderUtil.m28585a(context, fbTextLayoutCacheWarmer), PaddingStyle.f13075e);
        this.f20852b = instantArticleClickTextPartDefinition;
    }

    public final ViewType<AccessibleTextLayoutView> mo2547a() {
        return ContentTextLayoutBasePartDefinition.f20885a;
    }

    public static InstantArticleTextLayoutClickablePartDefinition m28572a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantArticleTextLayoutClickablePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20850d) {
                InstantArticleTextLayoutClickablePartDefinition instantArticleTextLayoutClickablePartDefinition;
                if (a2 != null) {
                    instantArticleTextLayoutClickablePartDefinition = (InstantArticleTextLayoutClickablePartDefinition) a2.mo818a(f20850d);
                } else {
                    instantArticleTextLayoutClickablePartDefinition = f20849c;
                }
                if (instantArticleTextLayoutClickablePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28573b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20850d, b3);
                        } else {
                            f20849c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = instantArticleTextLayoutClickablePartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final boolean m28576a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        InstantArticleClickTextPartDefinition instantArticleClickTextPartDefinition = this.f20852b;
        return (InstantArticleClickTextPartDefinition.m28580a(graphQLStory) != null ? 1 : null) != null && this.f20851a.m28615a((FeedProps) feedProps);
    }
}
