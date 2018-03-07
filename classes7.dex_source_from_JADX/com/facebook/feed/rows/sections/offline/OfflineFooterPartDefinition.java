package com.facebook.feed.rows.sections.offline;

import android.content.Context;
import android.view.View;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.animators.OfflinePartAnimator;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.offline.ui.OfflineFooterView;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition.Props;
import com.facebook.feedplugins.graphqlstory.footer.FooterPartDefinition;
import com.facebook.feedplugins.offline.OfflineStoryKey;
import com.facebook.feedplugins.offline.OfflineStoryPersistentState;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: USD */
public class OfflineFooterPartDefinition<E extends HasPositionInformation & HasPersistentState & CanFeedback> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, OfflineStoryPersistentState, E, OfflineFooterView> {
    public static final ViewType f21544a = new C18091();
    private static OfflineFooterPartDefinition f21545h;
    private static final Object f21546i = new Object();
    public final OfflinePartAnimator f21547b;
    private final OfflinePartAnimationPartDefinition f21548c;
    private final FooterPartDefinition<OfflineFooterView> f21549d;
    private final FooterBackgroundPartDefinition<OfflineFooterView> f21550e;
    public final QeAccessor f21551f;
    private final OptimisticStoryStateCache f21552g;

    /* compiled from: USD */
    final class C18091 extends ViewType {
        C18091() {
        }

        public final View m24181a(Context context) {
            OfflineFooterView offlineFooterView = new OfflineFooterView(context);
            View a = DefaultFooterView.a.a(context);
            a.setId(2131558599);
            offlineFooterView.addView(a);
            return offlineFooterView;
        }
    }

    private static OfflineFooterPartDefinition m24183b(InjectorLike injectorLike) {
        return new OfflineFooterPartDefinition(OfflinePartAnimator.m23093a(injectorLike), OfflinePartAnimationPartDefinition.m24192a(injectorLike), FooterPartDefinition.a(injectorLike), FooterBackgroundPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), OptimisticStoryStateCache.a(injectorLike));
    }

    public final Object m24185a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f21549d, feedProps);
        subParts.a(this.f21548c, graphQLStory);
        subParts.a(this.f21550e, new Props(feedProps, this.f21551f.a(ExperimentsForFeedUtilComposerAbtestModule.ak, false) ? FooterLevel.HAS_INLINE_COMMENTS : FooterLevel.TOP));
        return (OfflineStoryPersistentState) ((HasPersistentState) hasPositionInformation).a(new OfflineStoryKey(graphQLStory), graphQLStory);
    }

    public final /* bridge */ /* synthetic */ void m24186a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 538517044);
        OfflineStoryPersistentState offlineStoryPersistentState = (OfflineStoryPersistentState) obj2;
        OfflineFooterView offlineFooterView = (OfflineFooterView) view;
        offlineFooterView.setBackgroundDrawable(offlineFooterView.getBaseView().getBackground());
        if (!offlineStoryPersistentState.f23557a) {
            this.f21547b.f19839d = offlineFooterView;
        }
        Logger.a(8, EntryType.MARK_POP, 14590053, a);
    }

    public final boolean m24187a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return this.f21552g.a((GraphQLStory) feedProps.a) == GraphQLFeedOptimisticPublishState.SUCCESS && this.f21549d.a(feedProps);
    }

    public static OfflineFooterPartDefinition m24182a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21546i) {
                OfflineFooterPartDefinition offlineFooterPartDefinition;
                if (a2 != null) {
                    offlineFooterPartDefinition = (OfflineFooterPartDefinition) a2.a(f21546i);
                } else {
                    offlineFooterPartDefinition = f21545h;
                }
                if (offlineFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24183b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21546i, b3);
                        } else {
                            f21545h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public OfflineFooterPartDefinition(OfflinePartAnimator offlinePartAnimator, OfflinePartAnimationPartDefinition offlinePartAnimationPartDefinition, FooterPartDefinition footerPartDefinition, FooterBackgroundPartDefinition footerBackgroundPartDefinition, QeAccessor qeAccessor, OptimisticStoryStateCache optimisticStoryStateCache) {
        this.f21547b = offlinePartAnimator;
        this.f21548c = offlinePartAnimationPartDefinition;
        this.f21549d = footerPartDefinition;
        this.f21550e = footerBackgroundPartDefinition;
        this.f21551f = qeAccessor;
        this.f21552g = optimisticStoryStateCache;
    }

    public final ViewType m24184a() {
        return f21544a;
    }
}
