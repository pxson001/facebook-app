package com.facebook.feedplugins.opengraph;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.linkshare.ShareAttachmentImageFormatSelector;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.PartWithIsNeeded;
import javax.inject.Inject;

@ContextScoped
/* compiled from: collections_sections_end_cursor */
public class OpenGraphAttachmentPartSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> implements PartWithIsNeeded<FeedProps<GraphQLStoryAttachment>> {
    private static OpenGraphAttachmentPartSelector f8571c;
    private static final Object f8572d = new Object();
    private final OpenGraphFallbackAttachmentPartDefinition<FeedEnvironment> f8573a;
    private final ShareAttachmentImageFormatSelector f8574b;

    private static OpenGraphAttachmentPartSelector m9420b(InjectorLike injectorLike) {
        return new OpenGraphAttachmentPartSelector(ShareAttachmentImageFormatSelector.a(injectorLike), OpenGraphFallbackAttachmentPartDefinition.m9423a(injectorLike));
    }

    public final Object m9421a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().j() == null || graphQLStoryAttachment.z().j().g() != -1703624614) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 == null || !baseMultiRowSubParts.a(this.f8574b, feedProps)) {
            baseMultiRowSubParts.a(this.f8573a, feedProps);
        }
        return null;
    }

    @Inject
    public OpenGraphAttachmentPartSelector(ShareAttachmentImageFormatSelector shareAttachmentImageFormatSelector, OpenGraphFallbackAttachmentPartDefinition openGraphFallbackAttachmentPartDefinition) {
        this.f8573a = openGraphFallbackAttachmentPartDefinition;
        this.f8574b = shareAttachmentImageFormatSelector;
    }

    public final boolean m9422a(Object obj) {
        return true;
    }

    public static OpenGraphAttachmentPartSelector m9419a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OpenGraphAttachmentPartSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8572d) {
                OpenGraphAttachmentPartSelector openGraphAttachmentPartSelector;
                if (a2 != null) {
                    openGraphAttachmentPartSelector = (OpenGraphAttachmentPartSelector) a2.a(f8572d);
                } else {
                    openGraphAttachmentPartSelector = f8571c;
                }
                if (openGraphAttachmentPartSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9420b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8572d, b3);
                        } else {
                            f8571c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = openGraphAttachmentPartSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
