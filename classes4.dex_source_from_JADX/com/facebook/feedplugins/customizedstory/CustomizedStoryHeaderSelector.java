package com.facebook.feedplugins.customizedstory;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.goodwill.DailyDialogueLightweightHeaderPartDefinition;
import com.facebook.graphql.model.GraphQLCustomizedStory;
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
/* compiled from: presence_typing_stale */
public class CustomizedStoryHeaderSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLCustomizedStory>, Void, FeedEnvironment> {
    private static CustomizedStoryHeaderSelector f4257c;
    private static final Object f4258d = new Object();
    private final CustomizedStoryHeaderFbVoicePartDefinition f4259a;
    private final DailyDialogueLightweightHeaderPartDefinition f4260b;

    private static CustomizedStoryHeaderSelector m4794b(InjectorLike injectorLike) {
        return new CustomizedStoryHeaderSelector(CustomizedStoryHeaderFbVoicePartDefinition.m4797a(injectorLike), DailyDialogueLightweightHeaderPartDefinition.m4807a(injectorLike));
    }

    public final Object m4795a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f4259a, feedProps).a(this.f4260b, feedProps);
        return null;
    }

    @Inject
    public CustomizedStoryHeaderSelector(CustomizedStoryHeaderFbVoicePartDefinition customizedStoryHeaderFbVoicePartDefinition, DailyDialogueLightweightHeaderPartDefinition dailyDialogueLightweightHeaderPartDefinition) {
        this.f4259a = customizedStoryHeaderFbVoicePartDefinition;
        this.f4260b = dailyDialogueLightweightHeaderPartDefinition;
    }

    public final boolean m4796a(Object obj) {
        return true;
    }

    public static CustomizedStoryHeaderSelector m4793a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CustomizedStoryHeaderSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4258d) {
                CustomizedStoryHeaderSelector customizedStoryHeaderSelector;
                if (a2 != null) {
                    customizedStoryHeaderSelector = (CustomizedStoryHeaderSelector) a2.a(f4258d);
                } else {
                    customizedStoryHeaderSelector = f4257c;
                }
                if (customizedStoryHeaderSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4794b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4258d, b3);
                        } else {
                            f4257c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = customizedStoryHeaderSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
