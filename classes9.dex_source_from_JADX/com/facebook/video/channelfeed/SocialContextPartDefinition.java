package com.facebook.video.channelfeed;

import android.content.Context;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.multirow.parts.ViewColorPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: success_from_delta */
public class SocialContextPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, AnyEnvironment, TextView> {
    public static ViewType f2650a = ViewType.a(2130907728);
    private static SocialContextPartDefinition f2651d;
    private static final Object f2652e = new Object();
    private final TextOrHiddenPartDefinition f2653b;
    private final ViewColorPartDefinition f2654c;

    private static SocialContextPartDefinition m2548b(InjectorLike injectorLike) {
        return new SocialContextPartDefinition(TextOrHiddenPartDefinition.a(injectorLike), ViewColorPartDefinition.a(injectorLike));
    }

    public final Object m2550a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f2653b, m2547b((FeedProps) obj).a());
        subParts.a(this.f2654c, Integer.valueOf(2131362143));
        return null;
    }

    public final boolean m2551a(Object obj) {
        return m2547b((FeedProps) obj) != null;
    }

    @Inject
    public SocialContextPartDefinition(TextOrHiddenPartDefinition textOrHiddenPartDefinition, ViewColorPartDefinition viewColorPartDefinition) {
        this.f2653b = textOrHiddenPartDefinition;
        this.f2654c = viewColorPartDefinition;
    }

    public final ViewType m2549a() {
        return f2650a;
    }

    public static SocialContextPartDefinition m2546a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SocialContextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2652e) {
                SocialContextPartDefinition socialContextPartDefinition;
                if (a2 != null) {
                    socialContextPartDefinition = (SocialContextPartDefinition) a2.a(f2652e);
                } else {
                    socialContextPartDefinition = f2651d;
                }
                if (socialContextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2548b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2652e, b3);
                        } else {
                            f2651d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = socialContextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static GraphQLTextWithEntities m2547b(FeedProps<GraphQLStory> feedProps) {
        GraphQLActor r = StoryAttachmentHelper.r((GraphQLStory) feedProps.a);
        return r != null ? r.aE() : null;
    }
}
