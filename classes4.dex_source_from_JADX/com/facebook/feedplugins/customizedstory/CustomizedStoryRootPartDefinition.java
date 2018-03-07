package com.facebook.feedplugins.customizedstory;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
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
/* compiled from: prev_phone_id */
public class CustomizedStoryRootPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLCustomizedStory, Void, FeedEnvironment> {
    private static CustomizedStoryRootPartDefinition f4249b;
    private static final Object f4250c = new Object();
    private final CustomizedStoryPartDefinition f4251a;

    private static CustomizedStoryRootPartDefinition m4785b(InjectorLike injectorLike) {
        return new CustomizedStoryRootPartDefinition(CustomizedStoryPartDefinition.m4788a(injectorLike));
    }

    public final Object m4786a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f4251a, FeedProps.c((GraphQLCustomizedStory) obj));
        return null;
    }

    public final boolean m4787a(Object obj) {
        return this.f4251a.m4791a(FeedProps.c((GraphQLCustomizedStory) obj));
    }

    @Inject
    public CustomizedStoryRootPartDefinition(CustomizedStoryPartDefinition customizedStoryPartDefinition) {
        this.f4251a = customizedStoryPartDefinition;
    }

    public static CustomizedStoryRootPartDefinition m4784a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CustomizedStoryRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4250c) {
                CustomizedStoryRootPartDefinition customizedStoryRootPartDefinition;
                if (a2 != null) {
                    customizedStoryRootPartDefinition = (CustomizedStoryRootPartDefinition) a2.a(f4250c);
                } else {
                    customizedStoryRootPartDefinition = f4249b;
                }
                if (customizedStoryRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4785b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4250c, b3);
                        } else {
                            f4249b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = customizedStoryRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
