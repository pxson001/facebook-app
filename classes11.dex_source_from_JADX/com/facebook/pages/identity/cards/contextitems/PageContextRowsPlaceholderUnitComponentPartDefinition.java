package com.facebook.pages.identity.cards.contextitems;

import android.content.Context;
import android.os.ParcelUuid;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemsConnectionWithPageInfoFragmentModel;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.model.GraphQLRating;
import com.facebook.graphql.model.GraphQLRating.Builder;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.pages.common.contextitems.card.PageIdentityContextItemsHeaderCardView;
import com.facebook.pages.common.contextitems.card.PageIdentityContextItemsHeaderCardView.PageContextItemsViewModel;
import com.facebook.pages.common.surface.fragments.common.PagesFragmentWithUuid;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.DefaultReactionFeedEnvironment;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: privacy_checkup_manager_no_items */
public class PageContextRowsPlaceholderUnitComponentPartDefinition<E extends HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageIdentityContextItemsHeaderCardView> {
    public static final ViewType f3387a = new C04571();
    private static PageContextRowsPlaceholderUnitComponentPartDefinition f3388c;
    private static final Object f3389d = new Object();
    private final QeAccessor f3390b;

    /* compiled from: privacy_checkup_manager_no_items */
    final class C04571 extends ViewType {
        C04571() {
        }

        public final View m4488a(Context context) {
            return new PageIdentityContextItemsHeaderCardView(context);
        }
    }

    /* compiled from: privacy_checkup_manager_no_items */
    public class State {
        public final PageContextItemsViewModel f3385a;
        public final ParcelUuid f3386b;

        public State(PageContextItemsViewModel pageContextItemsViewModel, ParcelUuid parcelUuid) {
            this.f3385a = pageContextItemsViewModel;
            this.f3386b = parcelUuid;
        }
    }

    private static PageContextRowsPlaceholderUnitComponentPartDefinition m4491b(InjectorLike injectorLike) {
        return new PageContextRowsPlaceholderUnitComponentPartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m4493a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m4489a((ReactionUnitComponentNode) obj, (HasContext) anyEnvironment);
    }

    public final /* bridge */ /* synthetic */ void m4494a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 770946621);
        State state = (State) obj2;
        PageIdentityContextItemsHeaderCardView pageIdentityContextItemsHeaderCardView = (PageIdentityContextItemsHeaderCardView) view;
        pageIdentityContextItemsHeaderCardView.m2182a(state.f3385a);
        pageIdentityContextItemsHeaderCardView.f1490k = state.f3386b;
        pageIdentityContextItemsHeaderCardView.setContainerBorderVisibility(false);
        Logger.a(8, EntryType.MARK_POP, 1921779109, a);
    }

    public final boolean m4495a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.bI() == null || !ProfilePermissions.a(reactionUnitComponentFields.bI().j()) || StringUtil.a(reactionUnitComponentFields.bI().b()) || StringUtil.a(reactionUnitComponentFields.bI().c()) || reactionUnitComponentFields.bI().gi_() == null || StringUtil.a(reactionUnitComponentFields.bI().gi_().b()) || reactionUnitComponentFields.bI().gk_() == null || reactionUnitComponentFields.bI().gk_().a().isEmpty()) ? false : true;
    }

    public final void m4496b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PageIdentityContextItemsHeaderCardView) view).m2181a();
    }

    public final ViewType m4492a() {
        return f3387a;
    }

    public static PageContextRowsPlaceholderUnitComponentPartDefinition m4490a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageContextRowsPlaceholderUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3389d) {
                PageContextRowsPlaceholderUnitComponentPartDefinition pageContextRowsPlaceholderUnitComponentPartDefinition;
                if (a2 != null) {
                    pageContextRowsPlaceholderUnitComponentPartDefinition = (PageContextRowsPlaceholderUnitComponentPartDefinition) a2.a(f3389d);
                } else {
                    pageContextRowsPlaceholderUnitComponentPartDefinition = f3388c;
                }
                if (pageContextRowsPlaceholderUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4491b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3389d, b3);
                        } else {
                            f3388c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageContextRowsPlaceholderUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageContextRowsPlaceholderUnitComponentPartDefinition(QeAccessor qeAccessor) {
        this.f3390b = qeAccessor;
    }

    private static State m4489a(ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ParcelUuid parcelUuid;
        GraphQLRating graphQLRating = null;
        ReactionUnitComponentFields f = reactionUnitComponentNode.f();
        if (e == null || !(e instanceof DefaultReactionFeedEnvironment) || ((DefaultReactionFeedEnvironment) e).q() == null || !(((DefaultReactionFeedEnvironment) e).q() instanceof PagesFragmentWithUuid)) {
            parcelUuid = null;
        } else {
            parcelUuid = ((PagesFragmentWithUuid) ((DefaultReactionFeedEnvironment) e).q()).mo55h();
        }
        long parseLong = Long.parseLong(f.bI().b());
        String c = f.bI().c();
        String b = f.bI().gi_().b();
        ContextItemsConnectionWithPageInfoFragmentModel gk_ = f.bI().gk_();
        ImmutableList j = f.bI().j();
        if (f.bI().gj_() != null) {
            Builder builder = new Builder();
            builder.d = f.bI().gj_().a();
            graphQLRating = builder.a(f.bI().gj_().b()).a();
        }
        return new State(new PageContextItemsViewModel(parseLong, c, b, gk_, j, graphQLRating, (DefaultLocationFieldsModel) f.bI().g()), parcelUuid);
    }
}
