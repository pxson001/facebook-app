package com.facebook.feedplugins.topiccustomizationstory.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLTopicCustomizationStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android_async_feed_cache_invalidation */
public class TopicCustomizationStoryHScrollRowPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLTopicCustomizationStory>, Void, FeedEnvironment> {
    private static TopicCustomizationStoryHScrollRowPartDefinition f9951d;
    private static final Object f9952e = new Object();
    private final TopicCustomizationStoryHeaderPartDefinition f9953a;
    private final TopicCustomizationStoryHScrollPartDefinition f9954b;
    private final TopicCustomizationStoryFooterPartDefinition f9955c;

    private static TopicCustomizationStoryHScrollRowPartDefinition m10309b(InjectorLike injectorLike) {
        return new TopicCustomizationStoryHScrollRowPartDefinition(TopicCustomizationStoryHeaderPartDefinition.m10312a(injectorLike), TopicCustomizationStoryHScrollPartDefinition.m10303a(injectorLike), TopicCustomizationStoryFooterPartDefinition.m10295a(injectorLike));
    }

    public final Object m10310a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f9953a, feedProps);
        baseMultiRowSubParts.a(this.f9954b, feedProps);
        baseMultiRowSubParts.a(this.f9955c, feedProps);
        return null;
    }

    @Inject
    public TopicCustomizationStoryHScrollRowPartDefinition(TopicCustomizationStoryHeaderPartDefinition topicCustomizationStoryHeaderPartDefinition, TopicCustomizationStoryHScrollPartDefinition topicCustomizationStoryHScrollPartDefinition, TopicCustomizationStoryFooterPartDefinition topicCustomizationStoryFooterPartDefinition) {
        this.f9953a = topicCustomizationStoryHeaderPartDefinition;
        this.f9954b = topicCustomizationStoryHScrollPartDefinition;
        this.f9955c = topicCustomizationStoryFooterPartDefinition;
    }

    public final boolean m10311a(Object obj) {
        return true;
    }

    public static TopicCustomizationStoryHScrollRowPartDefinition m10308a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TopicCustomizationStoryHScrollRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9952e) {
                TopicCustomizationStoryHScrollRowPartDefinition topicCustomizationStoryHScrollRowPartDefinition;
                if (a2 != null) {
                    topicCustomizationStoryHScrollRowPartDefinition = (TopicCustomizationStoryHScrollRowPartDefinition) a2.a(f9952e);
                } else {
                    topicCustomizationStoryHScrollRowPartDefinition = f9951d;
                }
                if (topicCustomizationStoryHScrollRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10309b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9952e, b3);
                        } else {
                            f9951d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = topicCustomizationStoryHScrollRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
