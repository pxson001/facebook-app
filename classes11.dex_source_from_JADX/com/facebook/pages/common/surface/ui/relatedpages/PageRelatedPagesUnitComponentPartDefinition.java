package com.facebook.pages.common.surface.ui.relatedpages;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.pyml.controllers.HScrollFeedUnitView;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.widget.CustomViewUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: redspace_self_wall_content */
public class PageRelatedPagesUnitComponentPartDefinition<E extends HasContext> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, HScrollFeedUnitView> {
    public static final ViewType f2699a = new C03591();
    private static PageRelatedPagesUnitComponentPartDefinition f2700c;
    private static final Object f2701d = new Object();
    private final PageRelatedPagesDataStore f2702b;

    /* compiled from: redspace_self_wall_content */
    final class C03591 extends ViewType {
        C03591() {
        }

        public final View m3636a(Context context) {
            return new HScrollFeedUnitView(context);
        }
    }

    /* compiled from: redspace_self_wall_content */
    public class State {
        @Nullable
        public final GraphQLPagesYouMayLikeFeedUnit f2698a;

        public State(GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit) {
            this.f2698a = graphQLPagesYouMayLikeFeedUnit;
        }
    }

    private static PageRelatedPagesUnitComponentPartDefinition m3638b(InjectorLike injectorLike) {
        return new PageRelatedPagesUnitComponentPartDefinition(PageRelatedPagesDataStore.m3627a(injectorLike));
    }

    public final Object m3640a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new State(this.f2702b.m3629b(((ReactionUnitComponentNode) obj).b.bI().b()));
    }

    public final /* bridge */ /* synthetic */ void m3641a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1999401283);
        State state = (State) obj2;
        HScrollFeedUnitView hScrollFeedUnitView = (HScrollFeedUnitView) view;
        CustomViewUtils.b(hScrollFeedUnitView, new ColorDrawable(((HasContext) anyEnvironment).getContext().getResources().getColor(2131361920)));
        hScrollFeedUnitView.a(state.f2698a, false);
        Logger.a(8, EntryType.MARK_POP, -59887046, a);
    }

    public final boolean m3642a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return (reactionUnitComponentNode.b.bI() == null || StringUtil.a(reactionUnitComponentNode.b.bI().b()) || this.f2702b.m3629b(reactionUnitComponentNode.b.bI().b()) == null) ? false : true;
    }

    public final ViewType m3639a() {
        return f2699a;
    }

    public static PageRelatedPagesUnitComponentPartDefinition m3637a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageRelatedPagesUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2701d) {
                PageRelatedPagesUnitComponentPartDefinition pageRelatedPagesUnitComponentPartDefinition;
                if (a2 != null) {
                    pageRelatedPagesUnitComponentPartDefinition = (PageRelatedPagesUnitComponentPartDefinition) a2.a(f2701d);
                } else {
                    pageRelatedPagesUnitComponentPartDefinition = f2700c;
                }
                if (pageRelatedPagesUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3638b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2701d, b3);
                        } else {
                            f2700c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageRelatedPagesUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageRelatedPagesUnitComponentPartDefinition(PageRelatedPagesDataStore pageRelatedPagesDataStore) {
        this.f2702b = pageRelatedPagesDataStore;
    }
}
