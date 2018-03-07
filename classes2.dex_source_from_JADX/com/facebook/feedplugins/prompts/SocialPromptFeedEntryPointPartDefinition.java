package com.facebook.feedplugins.prompts;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition.Props;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionTightGreyView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.productionprompts.abtest.ExperimentsForProductionPromptsAbtestModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: imp_connection_state */
public class SocialPromptFeedEntryPointPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ActionLinkCallToActionTightGreyView> implements HasSpecialStyling {
    public static final ViewType f20348a = new C08241();
    private static SocialPromptFeedEntryPointPartDefinition f20349g;
    private static final Object f20350h = new Object();
    private final Lazy<ActionLinkCallToActionPartDefinition> f20351b;
    public final Lazy<SocialPromptFeedActionHandler> f20352c;
    private final QeAccessor f20353d;
    private final Context f20354e;
    private final Provider<String> f20355f;

    /* compiled from: imp_connection_state */
    final class C08241 extends ViewType {
        C08241() {
        }

        public final View mo1995a(Context context) {
            return new ActionLinkCallToActionTightGreyView(context);
        }
    }

    private static SocialPromptFeedEntryPointPartDefinition m28013b(InjectorLike injectorLike) {
        return new SocialPromptFeedEntryPointPartDefinition(IdBasedLazy.m1808a(injectorLike, 1837), IdBasedLazy.m1808a(injectorLike, 6434), QeInternalImplMethodAutoProvider.m3744a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedProvider.m1811a(injectorLike, 4442));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStoryActionLink graphQLStoryActionLink;
        FeedProps feedProps = (FeedProps) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        String aF = m28012a((GraphQLStory) feedProps.f13444a).aF();
        Preconditions.checkNotNull(aF);
        OnClickListener 2 = new 2(this, feedEnvironment.getContext(), aF);
        ImmutableList E = ((GraphQLStory) feedProps.f13444a).m22319E();
        if (E == null || E.size() <= 0) {
            graphQLStoryActionLink = null;
        } else {
            graphQLStoryActionLink = (GraphQLStoryActionLink) E.get(0);
        }
        subParts.mo2756a((SinglePartDefinition) this.f20351b.get(), Props.a(feedProps, graphQLStoryActionLink, 2, 2, null, null, this.f20354e.getResources().getString(2131239238), false));
        return null;
    }

    public final boolean m28016a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (!this.f20353d.mo596a(ExperimentsForProductionPromptsAbtestModule.f13420i, false)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (((String) this.f20355f.get()).equals(StoryActorHelper.m27492b(graphQLStory).m23765H())) {
            return m28012a(graphQLStory) != null;
        } else {
            return false;
        }
    }

    public static SocialPromptFeedEntryPointPartDefinition m28011a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SocialPromptFeedEntryPointPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20350h) {
                SocialPromptFeedEntryPointPartDefinition socialPromptFeedEntryPointPartDefinition;
                if (a2 != null) {
                    socialPromptFeedEntryPointPartDefinition = (SocialPromptFeedEntryPointPartDefinition) a2.mo818a(f20350h);
                } else {
                    socialPromptFeedEntryPointPartDefinition = f20349g;
                }
                if (socialPromptFeedEntryPointPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28013b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20350h, b3);
                        } else {
                            f20349g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = socialPromptFeedEntryPointPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public SocialPromptFeedEntryPointPartDefinition(Lazy<ActionLinkCallToActionPartDefinition> lazy, Lazy<SocialPromptFeedActionHandler> lazy2, QeAccessor qeAccessor, Context context, Provider<String> provider) {
        this.f20351b = lazy;
        this.f20352c = lazy2;
        this.f20353d = qeAccessor;
        this.f20354e = context;
        this.f20355f = provider;
    }

    public final ViewType<ActionLinkCallToActionTightGreyView> mo2547a() {
        return f20348a;
    }

    public final SpecialStylingType mo3125b() {
        return SpecialStylingType.FOLLOWUP_FEEDUNIT;
    }

    @Nullable
    private static GraphQLStoryActionLink m28012a(GraphQLStory graphQLStory) {
        ImmutableList E = graphQLStory.m22319E();
        int size = E.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) E.get(i);
            if (graphQLStoryActionLink.aF() != null) {
                return graphQLStoryActionLink;
            }
        }
        return null;
    }
}
