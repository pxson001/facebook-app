package com.facebook.feedplugins.topiccustomizationstory.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.topicfeeds.customization.TopicFeedsIntentFactory;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.graphql.model.GraphQLTopicCustomizationStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ResourceIdTextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android_async_feed_prefetch */
public class TopicCustomizationStoryFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLTopicCustomizationStory>, Void, FeedEnvironment, OneButtonFooterView> {
    private static TopicCustomizationStoryFooterPartDefinition f9931f;
    private static final Object f9932g = new Object();
    private final ClickListenerPartDefinition f9933a;
    private final ResourceIdTextPartDefinition f9934b;
    private final TopicFeedsIntentFactory f9935c;
    private final SecureContextHelper f9936d;
    private final Context f9937e;

    private static TopicCustomizationStoryFooterPartDefinition m10296b(InjectorLike injectorLike) {
        return new TopicCustomizationStoryFooterPartDefinition(ClickListenerPartDefinition.a(injectorLike), ResourceIdTextPartDefinition.a(injectorLike), TopicFeedsIntentFactory.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m10298a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f9933a, TopicCustomizationStoryUtil.m10325a(this.f9935c, this.f9936d, this.f9937e, (GraphQLTopicCustomizationStory) ((FeedProps) obj).a));
        subParts.a(2131559974, this.f9934b, Integer.valueOf(2131242494));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m10299a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1010029004);
        ((OneButtonFooterView) view).b.setTextColor(-7829368);
        Logger.a(8, EntryType.MARK_POP, -1396435085, a);
    }

    public final boolean m10300a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps.a == null) {
            return false;
        }
        return CollectionUtil.b(((GraphQLTopicCustomizationStory) feedProps.a).o());
    }

    @Inject
    public TopicCustomizationStoryFooterPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, ResourceIdTextPartDefinition resourceIdTextPartDefinition, TopicFeedsIntentFactory topicFeedsIntentFactory, SecureContextHelper secureContextHelper, Context context) {
        this.f9933a = clickListenerPartDefinition;
        this.f9934b = resourceIdTextPartDefinition;
        this.f9935c = topicFeedsIntentFactory;
        this.f9936d = secureContextHelper;
        this.f9937e = context;
    }

    public final ViewType<OneButtonFooterView> m10297a() {
        return OneButtonFooterView.a;
    }

    public static TopicCustomizationStoryFooterPartDefinition m10295a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TopicCustomizationStoryFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9932g) {
                TopicCustomizationStoryFooterPartDefinition topicCustomizationStoryFooterPartDefinition;
                if (a2 != null) {
                    topicCustomizationStoryFooterPartDefinition = (TopicCustomizationStoryFooterPartDefinition) a2.a(f9932g);
                } else {
                    topicCustomizationStoryFooterPartDefinition = f9931f;
                }
                if (topicCustomizationStoryFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10296b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9932g, b3);
                        } else {
                            f9931f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = topicCustomizationStoryFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
