package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.util.Pair;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.views.AccessibleTextLayoutView;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import java.util.HashMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: home_bubble */
public class VariableTextSizeClickablePartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasPositionInformation, AccessibleTextLayoutView> {
    private static VariableTextSizeClickablePartDefinition f20973f;
    private static final Object f20974g = new Object();
    private final FeedStoryUtil f20975a;
    private final FeedTextSizeExperimentUtil f20976b;
    private final ContentTextLayoutBasePartDefinitionProvider f20977c;
    private final TextLinkPartDefinition f20978d;
    private final HashMap<Pair<TextLayoutBuilder, PaddingStyle>, ContentTextLayoutBasePartDefinition> f20979e = new HashMap();

    private static VariableTextSizeClickablePartDefinition m28696b(InjectorLike injectorLike) {
        return new VariableTextSizeClickablePartDefinition(FeedStoryUtil.m18578a(injectorLike), FeedTextSizeExperimentUtil.m28675a(injectorLike), TextLinkPartDefinition.m28402a(injectorLike), (ContentTextLayoutBasePartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ContentTextLayoutBasePartDefinitionProvider.class));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Pair b = this.f20976b.m28681b((GraphQLStory) feedProps.f13444a);
        if (!this.f20979e.containsKey(b)) {
            this.f20979e.put(b, this.f20977c.m28578a(Boolean.valueOf(true), (TextLayoutBuilder) b.first, (PaddingStyle) b.second));
        }
        subParts.mo2756a((SinglePartDefinition) this.f20979e.get(b), feedProps);
        subParts.mo2756a(this.f20978d, feedProps);
        return null;
    }

    public final boolean m28699a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).f13444a;
        return this.f20976b.m28680a(graphQLStory) && FeedStoryUtil.m18583b(graphQLStory);
    }

    @Inject
    public VariableTextSizeClickablePartDefinition(FeedStoryUtil feedStoryUtil, FeedTextSizeExperimentUtil feedTextSizeExperimentUtil, TextLinkPartDefinition textLinkPartDefinition, ContentTextLayoutBasePartDefinitionProvider contentTextLayoutBasePartDefinitionProvider) {
        this.f20975a = feedStoryUtil;
        this.f20976b = feedTextSizeExperimentUtil;
        this.f20977c = contentTextLayoutBasePartDefinitionProvider;
        this.f20978d = textLinkPartDefinition;
    }

    public final ViewType<AccessibleTextLayoutView> mo2547a() {
        return ContentTextLayoutBasePartDefinition.f20885a;
    }

    public static VariableTextSizeClickablePartDefinition m28695a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VariableTextSizeClickablePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20974g) {
                VariableTextSizeClickablePartDefinition variableTextSizeClickablePartDefinition;
                if (a2 != null) {
                    variableTextSizeClickablePartDefinition = (VariableTextSizeClickablePartDefinition) a2.mo818a(f20974g);
                } else {
                    variableTextSizeClickablePartDefinition = f20973f;
                }
                if (variableTextSizeClickablePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28696b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20974g, b3);
                        } else {
                            f20973f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = variableTextSizeClickablePartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
