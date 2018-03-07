package com.facebook.gametime.ui.components.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;

@ContextScoped
/* compiled from: TARGET_ID */
public class GametimeSportsPlayFeedAttachmentPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, AnyEnvironment> {
    private static GametimeSportsPlayFeedAttachmentPartDefinition f25127a;
    private static final Object f25128b = new Object();

    private static GametimeSportsPlayFeedAttachmentPartDefinition m27108b() {
        return new GametimeSportsPlayFeedAttachmentPartDefinition();
    }

    public final boolean m27109a(Object obj) {
        return true;
    }

    public static GametimeSportsPlayFeedAttachmentPartDefinition m27107a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeSportsPlayFeedAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25128b) {
                GametimeSportsPlayFeedAttachmentPartDefinition gametimeSportsPlayFeedAttachmentPartDefinition;
                if (a2 != null) {
                    gametimeSportsPlayFeedAttachmentPartDefinition = (GametimeSportsPlayFeedAttachmentPartDefinition) a2.a(f25128b);
                } else {
                    gametimeSportsPlayFeedAttachmentPartDefinition = f25127a;
                }
                if (gametimeSportsPlayFeedAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m27108b();
                        if (a2 != null) {
                            a2.a(f25128b, b3);
                        } else {
                            f25127a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeSportsPlayFeedAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
