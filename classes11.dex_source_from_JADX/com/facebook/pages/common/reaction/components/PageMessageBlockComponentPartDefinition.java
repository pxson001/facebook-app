package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.pages.common.reaction.components.utils.PagesSurfaceReactionHelper;
import com.facebook.pages.common.reaction.ui.PageMessageBlockComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionPageMessageBlockComponentFragment.CustomerData.CustomTagLinks;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPageMessageBlockComponentFragmentModel.CustomerDataModel.CustomTagLinksModel.NodesModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPageMessageBlockComponentFragmentModel.CustomerDataModel.CustomTagLinksModel.NodesModel.CustomTagModel;
import com.facebook.user.model.UserCustomTag;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setComposerDateInfo */
public class PageMessageBlockComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageMessageBlockComponentView> {
    public static final ViewType f1963a = new C02561();
    private static PageMessageBlockComponentPartDefinition f1964c;
    private static final Object f1965d = new Object();
    private final PagesSurfaceReactionHelper<E> f1966b;

    /* compiled from: setComposerDateInfo */
    final class C02561 extends ViewType {
        C02561() {
        }

        public final View m3009a(Context context) {
            return new PageMessageBlockComponentView(context);
        }
    }

    /* compiled from: setComposerDateInfo */
    public class State {
        public final String f1956a;
        public final String f1957b;
        public final long f1958c;
        public final String f1959d;
        public final String f1960e;
        public final ImmutableList<UserCustomTag> f1961f;
        public final OnClickListener f1962g;

        public State(String str, String str2, long j, String str3, String str4, ImmutableList<UserCustomTag> immutableList, OnClickListener onClickListener) {
            this.f1956a = str;
            this.f1957b = str2;
            this.f1958c = j;
            this.f1959d = str3;
            this.f1960e = str4;
            this.f1961f = immutableList;
            this.f1962g = onClickListener;
        }
    }

    private static PageMessageBlockComponentPartDefinition m3013b(InjectorLike injectorLike) {
        return new PageMessageBlockComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m3015a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m3010a((ReactionUnitComponentNode) obj, (CanLaunchReactionIntent) anyEnvironment);
    }

    public final /* bridge */ /* synthetic */ void m3016a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 655279442);
        State state = (State) obj2;
        PageMessageBlockComponentView pageMessageBlockComponentView = (PageMessageBlockComponentView) view;
        pageMessageBlockComponentView.m3173a(state.f1956a, state.f1957b, state.f1959d, state.f1958c, state.f1961f);
        pageMessageBlockComponentView.setOnClickListener(state.f1962g);
        Logger.a(8, EntryType.MARK_POP, 70190203, a);
    }

    public final boolean m3017a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.by() == null || reactionUnitComponentFields.bH() == null || reactionUnitComponentFields.aU() == null) ? false : true;
    }

    public final void m3018b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PageMessageBlockComponentView) view).setOnClickListener(null);
    }

    private State m3010a(ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        ImmutableList immutableList = null;
        if (reactionUnitComponentFields.ai() != null) {
            immutableList = m3012a(reactionUnitComponentFields.ai().a());
        }
        return new State(reactionUnitComponentFields.by().a(), reactionUnitComponentFields.bH().a(), reactionUnitComponentFields.cS(), reactionUnitComponentFields.aU().b(), reactionUnitComponentFields.G(), immutableList, this.f1966b.m3152a(reactionUnitComponentFields.v(), e, reactionUnitComponentNode.k(), reactionUnitComponentNode.l()));
    }

    public final ViewType m3014a() {
        return f1963a;
    }

    public static PageMessageBlockComponentPartDefinition m3011a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageMessageBlockComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1965d) {
                PageMessageBlockComponentPartDefinition pageMessageBlockComponentPartDefinition;
                if (a2 != null) {
                    pageMessageBlockComponentPartDefinition = (PageMessageBlockComponentPartDefinition) a2.a(f1965d);
                } else {
                    pageMessageBlockComponentPartDefinition = f1964c;
                }
                if (pageMessageBlockComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3013b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1965d, b3);
                        } else {
                            f1964c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageMessageBlockComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageMessageBlockComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1966b = pagesSurfaceReactionHelper;
    }

    private static ImmutableList<UserCustomTag> m3012a(CustomTagLinks customTagLinks) {
        Builder builder = ImmutableList.builder();
        ImmutableList a = customTagLinks.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            CustomTagModel a2 = ((NodesModel) a.get(i)).a();
            builder.c(new UserCustomTag(a2.ga_(), a2.g(), (int) Long.parseLong(a2.c(), 16), (int) Long.parseLong(a2.d(), 16), (int) Long.parseLong(a2.b(), 16)));
        }
        return builder.b();
    }
}
