package com.facebook.feedplugins.greetingcard;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.greetingcard.GreetingCardPartDefinition.Props;
import com.facebook.graphql.model.GraphQLGreetingCard;
import com.facebook.graphql.model.GraphQLGreetingCard.Builder;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: deselected_option_ids */
public class GreetingCardAttachmentPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPositionInformation, GreetingCardView> {
    public static final ViewType f7658a = new C09751();
    private static GreetingCardAttachmentPartDefinition f7659e;
    private static final Object f7660f = new Object();
    private final BackgroundPartDefinition f7661b;
    private final GreetingCardPartDefinition f7662c;
    private final Provider<String> f7663d;

    /* compiled from: deselected_option_ids */
    final class C09751 extends ViewType {
        C09751() {
        }

        public final View m8870a(Context context) {
            return new GreetingCardView(context);
        }
    }

    private static GreetingCardAttachmentPartDefinition m8872b(InjectorLike injectorLike) {
        return new GreetingCardAttachmentPartDefinition(BackgroundPartDefinition.a(injectorLike), GreetingCardPartDefinition.m8881a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    public final Object m8874a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStory graphQLStory;
        Object H;
        GraphQLGreetingCard graphQLGreetingCard;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        FeedProps e = AttachmentProps.e(feedProps);
        if (e == null) {
            graphQLStory = null;
        } else {
            graphQLStory = (GraphQLStory) e.a;
        }
        subParts.a(this.f7661b, new StylingData(e, PaddingStyle.a));
        if (graphQLStory == null || StoryActorHelper.b(graphQLStory) == null) {
            String str = "";
        } else {
            H = StoryActorHelper.b(graphQLStory).H();
        }
        boolean equals = ((String) this.f7663d.get()).equals(H);
        GreetingCardPartDefinition greetingCardPartDefinition = this.f7662c;
        GraphQLNode z = graphQLStoryAttachment.z();
        if (z == null || z.j() == null || z.j().g() != -703791351) {
            graphQLGreetingCard = null;
        } else {
            Builder builder = new Builder();
            builder.d = z.da();
            builder.e = z.dp();
            builder.f = z.fY();
            builder.g = z.hs();
            builder.h = z.ih();
            builder.i = z.iR();
            graphQLGreetingCard = new GraphQLGreetingCard(builder);
        }
        subParts.a(greetingCardPartDefinition, new Props(graphQLGreetingCard, Boolean.valueOf(false), Boolean.valueOf(equals)));
        return null;
    }

    @Inject
    public GreetingCardAttachmentPartDefinition(BackgroundPartDefinition backgroundPartDefinition, GreetingCardPartDefinition greetingCardPartDefinition, Provider<String> provider) {
        this.f7661b = backgroundPartDefinition;
        this.f7662c = greetingCardPartDefinition;
        this.f7663d = provider;
    }

    public final ViewType m8873a() {
        return f7658a;
    }

    public static GreetingCardAttachmentPartDefinition m8871a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GreetingCardAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7660f) {
                GreetingCardAttachmentPartDefinition greetingCardAttachmentPartDefinition;
                if (a2 != null) {
                    greetingCardAttachmentPartDefinition = (GreetingCardAttachmentPartDefinition) a2.a(f7660f);
                } else {
                    greetingCardAttachmentPartDefinition = f7659e;
                }
                if (greetingCardAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8872b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7660f, b3);
                        } else {
                            f7659e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = greetingCardAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m8875a(Object obj) {
        return true;
    }
}
