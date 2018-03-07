package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.analytics.MultiRowPerfLoggerMethodAutoProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition$Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition$Props;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.fig.common.ViewUtils;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
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
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentStyleMapper;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.feed.environment.CanAddReactionComponents;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEvents;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentPersistentState;
import com.facebook.reaction.feed.styling.ReactionHScrollPagerPaddingResolver;
import com.facebook.reaction.feed.styling.ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ui.ReactionHScrollComponentView;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionPaginatedComponentFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel.ReactionPaginatedComponentsModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.MessageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitSubComponentModel;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notif_option_id */
public class ReactionPaginatedHScrollUnitComponentPartDefinition<E extends CanAddReactionComponents & CanHandleHScrollPageChangedEvents & HasContext & HasPositionInformation & HasPersistentState & HasReactionInteractionTracker & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, HScrollRecyclerView> {
    public static final ViewType<ReactionHScrollComponentView> f6920a = new C03261();
    public static final ViewType<ReactionHScrollComponentView> f6921b = new C03272();
    private static ReactionPaginatedHScrollUnitComponentPartDefinition f6922l;
    private static final Object f6923m = new Object();
    private final ReactionHScrollPagerPaddingResolver f6924c;
    public final MultiRowPerfLogger f6925d;
    private final PageStyleFactory f6926e;
    private final PersistentRecyclerPartDefinition<Object, E> f6927f;
    public final ReactionUnitComponentStyleMapper f6928g;
    private final ReactionUnitValidator f6929h;
    private final ReactionUtil f6930i;
    private final ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition f6931j;
    private final AbstractFbErrorReporter f6932k;

    /* compiled from: notif_option_id */
    final class C03261 extends ViewType<ReactionHScrollComponentView> {
        C03261() {
        }

        public final View m7251a(Context context) {
            return new ReactionHScrollComponentView(context);
        }
    }

    /* compiled from: notif_option_id */
    final class C03272 extends ViewType<ReactionHScrollComponentView> {
        C03272() {
        }

        public final View m7252a(Context context) {
            ReactionHScrollComponentView reactionHScrollComponentView = new ReactionHScrollComponentView(context);
            ViewUtils.a(reactionHScrollComponentView.b, new ColorDrawable(-1));
            return reactionHScrollComponentView;
        }
    }

    private static ReactionPaginatedHScrollUnitComponentPartDefinition m7244b(InjectorLike injectorLike) {
        return new ReactionPaginatedHScrollUnitComponentPartDefinition((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ReactionHScrollPagerPaddingResolver.a(injectorLike), ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition.a(injectorLike), MultiRowPerfLoggerMethodAutoProvider.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), ReactionUnitComponentStyleMapper.a(injectorLike), ReactionUnitValidator.b(injectorLike), ReactionUtil.a(injectorLike));
    }

    private PersistentRecyclerPartDefinition$Callbacks<Object, E> m7238a(ReactionHScrollComponentKey reactionHScrollComponentKey, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        DefaultPageInfoFields b = ((ReactionPaginatedComponentFragment) reactionUnitComponentNode.b).dk().c().b();
        ImmutableList a = m7240a(reactionUnitComponentNode, (CanAddReactionComponents) e);
        ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState = (ReactionHScrollComponentPersistentState) ((HasPersistentState) e).a(new ReactionHScrollComponentKey(reactionUnitComponentNode.c), reactionUnitComponentNode);
        reactionHScrollComponentPersistentState.e = a.size();
        return new 3(this, a, reactionUnitComponentNode, e, reactionHScrollComponentKey, reactionHScrollComponentPersistentState, b);
    }

    public static ReactionPaginatedHScrollUnitComponentPartDefinition m7239a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPaginatedHScrollUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6923m) {
                ReactionPaginatedHScrollUnitComponentPartDefinition reactionPaginatedHScrollUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionPaginatedHScrollUnitComponentPartDefinition = (ReactionPaginatedHScrollUnitComponentPartDefinition) a2.a(f6923m);
                } else {
                    reactionPaginatedHScrollUnitComponentPartDefinition = f6922l;
                }
                if (reactionPaginatedHScrollUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7244b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6923m, b3);
                        } else {
                            f6922l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPaginatedHScrollUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m7247a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanAddReactionComponents canAddReactionComponents = (CanAddReactionComponents) anyEnvironment;
        ReactionHScrollComponentKey reactionHScrollComponentKey = new ReactionHScrollComponentKey(reactionUnitComponentNode.c);
        ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState = (ReactionHScrollComponentPersistentState) ((HasPersistentState) canAddReactionComponents).a(reactionHScrollComponentKey, reactionUnitComponentNode);
        int c = SizeUtil.c(((HasContext) canAddReactionComponents).getContext(), (float) this.f6924c.a(((HasContext) canAddReactionComponents).getContext(), reactionUnitComponentNode));
        subParts.a(this.f6931j, new StylingData(PageStyle.f13886a));
        subParts.a(this.f6927f, new PersistentRecyclerPartDefinition$Props(this.f6926e.a(((float) c) + 8.0f, PageStyle.f13886a, true), reactionHScrollComponentPersistentState.f, m7238a(reactionHScrollComponentKey, reactionUnitComponentNode, canAddReactionComponents), reactionUnitComponentNode.g(), reactionUnitComponentNode));
        return null;
    }

    public final /* synthetic */ void m7248a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2048369652);
        m7245b((ReactionUnitComponentNode) obj, (CanAddReactionComponents) anyEnvironment);
        Logger.a(8, EntryType.MARK_POP, 1568834146, a);
    }

    public final boolean m7249a(Object obj) {
        return ReactionUnitValidator.b((ReactionUnitComponentNode) obj);
    }

    public final void m7250b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((CanHandleHScrollPageChangedEvents) ((CanAddReactionComponents) anyEnvironment)).a((ReactionUnitComponentNode) obj);
    }

    public static void m7241a(ReactionPaginatedHScrollUnitComponentPartDefinition reactionPaginatedHScrollUnitComponentPartDefinition, ReactionUnitComponentNode reactionUnitComponentNode, CanAddReactionComponents canAddReactionComponents, ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState, DefaultPageInfoFields defaultPageInfoFields) {
        if (reactionHScrollComponentPersistentState.e - reactionHScrollComponentPersistentState.f <= 3 && defaultPageInfoFields.b() && !reactionHScrollComponentPersistentState.g) {
            reactionPaginatedHScrollUnitComponentPartDefinition.f6930i.a(defaultPageInfoFields.a(), new RequestCallback(reactionPaginatedHScrollUnitComponentPartDefinition, reactionUnitComponentNode, canAddReactionComponents, reactionHScrollComponentPersistentState), 5, ((ReactionPaginatedComponentFragment) reactionUnitComponentNode.b).dk().b(), ((HasReactionSession) canAddReactionComponents).p());
            reactionHScrollComponentPersistentState.g = true;
        }
    }

    @Inject
    public ReactionPaginatedHScrollUnitComponentPartDefinition(AbstractFbErrorReporter abstractFbErrorReporter, ReactionHScrollPagerPaddingResolver reactionHScrollPagerPaddingResolver, ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition reactionPaginatedHScrollUnitStyledBackgroundPartDefinition, MultiRowPerfLogger multiRowPerfLogger, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper, ReactionUnitValidator reactionUnitValidator, ReactionUtil reactionUtil) {
        this.f6932k = abstractFbErrorReporter;
        this.f6924c = reactionHScrollPagerPaddingResolver;
        this.f6931j = reactionPaginatedHScrollUnitStyledBackgroundPartDefinition;
        this.f6926e = pageStyleFactory;
        this.f6927f = persistentRecyclerPartDefinition;
        this.f6925d = multiRowPerfLogger;
        this.f6928g = reactionUnitComponentStyleMapper;
        this.f6929h = reactionUnitValidator;
        this.f6930i = reactionUtil;
    }

    public final ViewType m7246a() {
        return HScrollRecyclerViewRowType.f11901a;
    }

    public static void m7242a(ReactionPaginatedHScrollUnitComponentPartDefinition reactionPaginatedHScrollUnitComponentPartDefinition, CanAddReactionComponents canAddReactionComponents) {
        if (((HasReactionSession) canAddReactionComponents).p().c == Surface.VIDEO_HOME) {
            Object i = ((HasPositionInformation) canAddReactionComponents).i();
            if (i instanceof ReactionUnitComponentNode) {
                MessageModel bv = ((ReactionUnitComponentNode) i).b.bv();
                if (bv != null) {
                    reactionPaginatedHScrollUnitComponentPartDefinition.f6932k.a("ReactionPaginatedHScrollUnitComponentPartDefinition.noPages", StringFormatUtil.formatStrLocaleSafe("No needed pages for section: %s", bv.a()));
                }
            }
        }
    }

    public static ViewType<ReactionHScrollComponentView> m7243b(ReactionUnitComponentFields reactionUnitComponentFields) {
        GraphQLReactionUnitComponentStyle a = reactionUnitComponentFields.a();
        if (a == GraphQLReactionUnitComponentStyle.PAGE_CREATE_PHOTO_ALBUM || a == GraphQLReactionUnitComponentStyle.PAGE_PHOTO_ALBUM) {
            return f6921b;
        }
        return f6920a;
    }

    private static ImmutableList<ReactionUnitComponentFields> m7240a(ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        Builder builder = new Builder();
        ImmutableList a = ((ReactionPaginatedComponentFragment) reactionUnitComponentNode.b).dk().c().a();
        ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState = (ReactionHScrollComponentPersistentState) ((HasPersistentState) e).a(new ReactionHScrollComponentKey(reactionUnitComponentNode.c), reactionUnitComponentNode);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ReactionUnitSubComponentModel a2 = ((EdgesModel) a.get(i)).a();
            if (!reactionHScrollComponentPersistentState.b(a2.U())) {
                builder.c(a2);
            }
        }
        return builder.b();
    }

    private void m7245b(ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState = (ReactionHScrollComponentPersistentState) ((HasPersistentState) e).a(new ReactionHScrollComponentKey(reactionUnitComponentNode.c), reactionUnitComponentNode);
        ImmutableList a = m7240a(reactionUnitComponentNode, (CanAddReactionComponents) e);
        int i = reactionHScrollComponentPersistentState.f;
        int i2 = i < a.size() ? i : 0;
        ((CanHandleHScrollPageChangedEvents) e).a(i2, (ReactionUnitComponentFields) a.get(i2), reactionUnitComponentNode);
    }
}
