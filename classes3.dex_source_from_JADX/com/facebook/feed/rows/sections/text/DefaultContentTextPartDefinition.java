package com.facebook.feed.rows.sections.text;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.views.ContentTextView;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: video_channel_id */
public class DefaultContentTextPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasPositionInformation, ContentTextView> {
    private static DefaultContentTextPartDefinition f13e;
    private static final Object f14f = new Object();
    private final BaseTextPartDefinition f15a;
    private final TextLinkPartDefinition f16b;
    private final BackgroundPartDefinition f17c;
    private final FeedStoryUtil f18d;

    private static DefaultContentTextPartDefinition m13b(InjectorLike injectorLike) {
        return new DefaultContentTextPartDefinition(FeedStoryUtil.a(injectorLike), (BaseTextPartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BaseTextPartDefinitionProvider.class), TextLinkPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m15a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f17c, new StylingData(feedProps, PaddingStyle.e));
        subParts.a(this.f15a, feedProps);
        subParts.a(this.f16b, feedProps);
        return null;
    }

    public final boolean m16a(Object obj) {
        return FeedStoryUtil.b((GraphQLStory) ((FeedProps) obj).a);
    }

    @Inject
    public DefaultContentTextPartDefinition(FeedStoryUtil feedStoryUtil, BaseTextPartDefinitionProvider baseTextPartDefinitionProvider, TextLinkPartDefinition textLinkPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f18d = feedStoryUtil;
        this.f16b = textLinkPartDefinition;
        this.f15a = baseTextPartDefinitionProvider.m17a(Boolean.valueOf(true));
        this.f17c = backgroundPartDefinition;
    }

    public final ViewType m14a() {
        return this.f15a.m18a();
    }

    public static DefaultContentTextPartDefinition m12a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultContentTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14f) {
                DefaultContentTextPartDefinition defaultContentTextPartDefinition;
                if (a2 != null) {
                    defaultContentTextPartDefinition = (DefaultContentTextPartDefinition) a2.a(f14f);
                } else {
                    defaultContentTextPartDefinition = f13e;
                }
                if (defaultContentTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m13b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14f, b3);
                        } else {
                            f13e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultContentTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
