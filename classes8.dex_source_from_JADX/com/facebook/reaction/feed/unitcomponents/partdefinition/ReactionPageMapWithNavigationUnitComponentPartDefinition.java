package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.rows.ui.ReactionPageMapWithNavigationComponentView;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionGeoRectangleFieldsModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.LocationModel;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: add_member */
public class ReactionPageMapWithNavigationUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, ReactionPageMapWithNavigationComponentView> {
    public static final ViewType f19894a = new C21331();
    private static ReactionPageMapWithNavigationUnitComponentPartDefinition f19895d;
    private static final Object f19896e = new Object();
    private final BasicReactionActionPartDefinition f19897b;
    private final TextPartDefinition f19898c;

    /* compiled from: add_member */
    final class C21331 extends ViewType {
        C21331() {
        }

        public final View m23799a(Context context) {
            return new ReactionPageMapWithNavigationComponentView(context);
        }
    }

    /* compiled from: add_member */
    public class State {
        public final String f19889a;
        public final String f19890b;
        public final ImmutableLocation f19891c;
        public final ReactionGeoRectangleFieldsModel f19892d;
        public final int f19893e;

        public State(@Nullable String str, @Nullable String str2, ImmutableLocation immutableLocation, ReactionGeoRectangleFieldsModel reactionGeoRectangleFieldsModel, int i) {
            this.f19889a = str;
            this.f19890b = str2;
            this.f19892d = reactionGeoRectangleFieldsModel;
            this.f19891c = immutableLocation;
            this.f19893e = i;
        }
    }

    private static ReactionPageMapWithNavigationUnitComponentPartDefinition m23801b(InjectorLike injectorLike) {
        return new ReactionPageMapWithNavigationUnitComponentPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m23803a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        String str = null;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentFields.v();
        if (v != null) {
            subParts.a(this.f19897b, new Props(v, null, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, null, null));
        }
        ReactionStoryAttachmentActionFragmentModel C = reactionUnitComponentFields.C();
        if (v != null) {
            subParts.a(2131566761, this.f19897b, new Props(C, null, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, null, null));
        }
        subParts.a(2131566762, this.f19898c, reactionUnitComponentFields.cZ().a());
        String a = reactionUnitComponentFields.Q() != null ? reactionUnitComponentFields.Q().a() : null;
        if (reactionUnitComponentFields.bI().d() != null) {
            str = reactionUnitComponentFields.bI().d().a();
        }
        return new State(a, str, ImmutableLocation.a(reactionUnitComponentFields.bn().a(), reactionUnitComponentFields.bn().b()).a(), reactionUnitComponentFields.bt(), reactionUnitComponentFields.di());
    }

    public final /* bridge */ /* synthetic */ void m23804a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -554934443);
        State state = (State) obj2;
        ((ReactionPageMapWithNavigationComponentView) view).m23438a(state.f19889a, state.f19890b, state.f19891c, state.f19892d, state.f19893e);
        Logger.a(8, EntryType.MARK_POP, 308862761, a);
    }

    public final boolean m23805a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        if (!(reactionUnitComponentFields.bI() == null || reactionUnitComponentFields.bn() == null)) {
            LocationModel bn = reactionUnitComponentFields.bn();
            Object obj2 = (Math.abs(bn.a()) > 90.0d || Math.abs(bn.b()) > 180.0d) ? null : 1;
            if (!(obj2 == null || reactionUnitComponentFields.cZ() == null || StringUtil.a(reactionUnitComponentFields.cZ().a()))) {
                return true;
            }
        }
        return false;
    }

    public final void m23806b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ReactionPageMapWithNavigationComponentView) view).f19474e.c();
    }

    public final ViewType m23802a() {
        return f19894a;
    }

    public static ReactionPageMapWithNavigationUnitComponentPartDefinition m23800a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPageMapWithNavigationUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19896e) {
                ReactionPageMapWithNavigationUnitComponentPartDefinition reactionPageMapWithNavigationUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionPageMapWithNavigationUnitComponentPartDefinition = (ReactionPageMapWithNavigationUnitComponentPartDefinition) a2.a(f19896e);
                } else {
                    reactionPageMapWithNavigationUnitComponentPartDefinition = f19895d;
                }
                if (reactionPageMapWithNavigationUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23801b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19896e, b3);
                        } else {
                            f19895d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPageMapWithNavigationUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionPageMapWithNavigationUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, TextPartDefinition textPartDefinition) {
        this.f19897b = basicReactionActionPartDefinition;
        this.f19898c = textPartDefinition;
    }
}
