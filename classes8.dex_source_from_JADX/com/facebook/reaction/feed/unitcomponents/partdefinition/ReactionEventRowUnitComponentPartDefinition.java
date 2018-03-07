package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ui.ReactionEventRowComponentView;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.ProfileModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.MessageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.SubMessageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.TertiaryMessageModel;
import javax.annotation.Nullable;

/* compiled from: alignParentRight */
public abstract class ReactionEventRowUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession & HasReactionInteractionTracker> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, ReactionEventRowComponentView> {
    public static final ViewType f19639a = new C21251();
    private final BasicReactionActionPartDefinition f19640b;

    /* compiled from: alignParentRight */
    final class C21251 extends ViewType {
        C21251() {
        }

        public final View m23554a(Context context) {
            return new ReactionEventRowComponentView(context);
        }
    }

    /* compiled from: alignParentRight */
    public class State {
        public final String f19632a;
        public final String f19633b;
        public final String f19634c;
        public final String f19635d;
        public final ProfileModel f19636e;
        @Nullable
        public final String f19637f;
        @Nullable
        public final String f19638g;

        public State(String str, String str2, String str3, String str4, ProfileModel profileModel, @Nullable String str5, @Nullable String str6) {
            this.f19632a = str;
            this.f19633b = str2;
            this.f19634c = str3;
            this.f19635d = str4;
            this.f19636e = profileModel;
            this.f19637f = str5;
            this.f19638g = str6;
        }
    }

    protected abstract boolean mo1123b();

    public final Object m23557a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        String str = null;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        subParts.a(this.f19640b, new Props(reactionUnitComponentFields.v(), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        MessageModel bv = reactionUnitComponentFields.bv();
        SubMessageModel cG = reactionUnitComponentFields.cG();
        ProfileModel M = reactionUnitComponentFields.C().M();
        ReactionImageFields ah = reactionUnitComponentFields.ah();
        TertiaryMessageModel cO = reactionUnitComponentFields.cO();
        if (((HasReactionAnalyticsParams) canLaunchReactionIntent).mo706r() != null) {
            ((HasReactionAnalyticsParams) canLaunchReactionIntent).mo706r().f18812d = reactionUnitComponentNode.f18864d;
        }
        String bz = reactionUnitComponentFields.bz();
        String al = reactionUnitComponentFields.al();
        String a = bv != null ? bv.a() : null;
        String a2 = cG != null ? cG.a() : null;
        String b = ah != null ? ah.b() : null;
        if (cO != null) {
            str = cO.a();
        }
        return new State(bz, al, a, a2, M, b, str);
    }

    public final boolean m23559a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (StringUtil.a(reactionUnitComponentFields.al()) || StringUtil.a(reactionUnitComponentFields.bz()) || reactionUnitComponentFields.bv() == null || StringUtil.a(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.v() == null || reactionUnitComponentFields.C() == null || reactionUnitComponentFields.C().M() == null || StringUtil.a(reactionUnitComponentFields.C().M().eL_())) ? false : true;
    }

    public final void m23560b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ReactionEventRowComponentView reactionEventRowComponentView = (ReactionEventRowComponentView) view;
        reactionEventRowComponentView.m24046a(null, null);
        reactionEventRowComponentView.setEventTitle(null);
        reactionEventRowComponentView.setEventInfo(null);
        reactionEventRowComponentView.f20171q.a();
        reactionEventRowComponentView.m24047a(false, null);
        reactionEventRowComponentView.setEventSocialContext(null);
        reactionEventRowComponentView.f20176v = null;
    }

    public ReactionEventRowUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition) {
        this.f19640b = basicReactionActionPartDefinition;
    }

    public final ViewType m23556a() {
        return f19639a;
    }

    private void m23555a(ReactionUnitComponentNode reactionUnitComponentNode, State state, E e, ReactionEventRowComponentView reactionEventRowComponentView) {
        ReactionInteractionTracker kE_ = ((HasReactionInteractionTracker) e).kE_();
        String str = reactionUnitComponentNode.f18863c;
        String str2 = reactionUnitComponentNode.f18864d;
        reactionEventRowComponentView.f20177w = kE_;
        reactionEventRowComponentView.f20178x = str;
        reactionEventRowComponentView.f20179y = str2;
        reactionEventRowComponentView.m24046a(state.f19633b, state.f19632a);
        reactionEventRowComponentView.setEventTitle(state.f19634c);
        reactionEventRowComponentView.setEventInfo(state.f19635d);
        ProfileModel profileModel = state.f19636e;
        reactionEventRowComponentView.f20171q.setVisibility(0);
        reactionEventRowComponentView.f20174t = profileModel;
        reactionEventRowComponentView.f20171q.a(reactionEventRowComponentView.f20164h.a(reactionEventRowComponentView).a(profileModel.o(), profileModel.q(), profileModel.t()));
        reactionEventRowComponentView.m24047a(mo1123b(), state.f19637f);
        reactionEventRowComponentView.setEventSocialContext(state.f19638g);
        reactionEventRowComponentView.f20176v = ((HasReactionAnalyticsParams) e).mo706r();
    }
}
