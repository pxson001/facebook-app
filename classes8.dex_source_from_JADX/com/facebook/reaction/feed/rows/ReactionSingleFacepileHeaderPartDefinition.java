package com.facebook.reaction.feed.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ImageBlockLayoutThumbnailPartDefinition;
import com.facebook.multirow.parts.ImageBlockLayoutThumbnailPartDefinition.Props.Builder;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition;
import com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition.Props;
import com.facebook.reaction.feed.styling.ReactionBackgroundPartDefinition;
import com.facebook.reaction.feed.styling.ReactionBackgroundPartDefinition.StylingData;
import com.facebook.reaction.feed.styling.ReactionPaddingStyleConstants;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionFacepileProfile;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: arg_init_product_id */
public class ReactionSingleFacepileHeaderPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasPositionInformation> extends MultiRowSinglePartDefinition<ReactionCardNode, Void, E, ImageBlockLayout> {
    public static final ViewType f19277a = ViewType.a(2130906627);
    private static ReactionSingleFacepileHeaderPartDefinition f19278h;
    private static final Object f19279i = new Object();
    private final ReactionBackgroundPartDefinition<E> f19280b;
    private final ClickListenerPartDefinition f19281c;
    private final ImageBlockLayoutThumbnailPartDefinition f19282d;
    public final ReactionIntentFactory f19283e;
    private final ReactionTextWithEntitiesPartDefinition f19284f;
    private final boolean f19285g;

    private static ReactionSingleFacepileHeaderPartDefinition m23287b(InjectorLike injectorLike) {
        return new ReactionSingleFacepileHeaderPartDefinition(ReactionBackgroundPartDefinition.m23451a(injectorLike), ClickListenerPartDefinition.a(injectorLike), ReactionExperimentController.a(injectorLike), ImageBlockLayoutThumbnailPartDefinition.a(injectorLike), ReactionIntentFactory.m22683a(injectorLike), ReactionTextWithEntitiesPartDefinition.m23423a(injectorLike));
    }

    public final Object m23289a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitHeaderFieldsModel fw_ = reactionCardNode.mo1117k().fw_();
        if (this.f19285g) {
            subParts.a(this.f19280b, new StylingData(FeedProps.c(reactionCardNode), ReactionPaddingStyleConstants.f19519a));
        }
        subParts.a(2131566712, this.f19284f, new Props(fw_.fA_(), reactionCardNode.mo1117k().d(), reactionCardNode.mo1117k().n()));
        final ReactionFacepileProfile reactionFacepileProfile = (ReactionFacepileProfile) fw_.g().get(0);
        subParts.a(this.f19281c, new OnClickListener(this) {
            final /* synthetic */ ReactionSingleFacepileHeaderPartDefinition f19276d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1764389153);
                canLaunchReactionIntent.mo695a(reactionCardNode.mo1117k().d(), reactionCardNode.mo1117k().n(), this.f19276d.f19283e.m22761b(reactionFacepileProfile.c(), UnitInteractionType.PROFILE_TAP));
                Logger.a(2, EntryType.UI_INPUT_END, -621694128, a);
            }
        });
        ImageBlockLayoutThumbnailPartDefinition imageBlockLayoutThumbnailPartDefinition = this.f19282d;
        Builder builder = new Builder();
        builder.c = 2131361970;
        subParts.a(imageBlockLayoutThumbnailPartDefinition, builder.a(reactionFacepileProfile.d().b()).a());
        return null;
    }

    public final boolean m23290a(Object obj) {
        ReactionUnitHeaderFieldsModel fw_ = ((ReactionCardNode) obj).mo1117k().fw_();
        if (!(fw_ == null || fw_.fA_() == null || Strings.isNullOrEmpty(fw_.fA_().a()))) {
            int i;
            ImmutableList g = fw_.g();
            if (g.size() != 1) {
                i = 0;
            } else {
                ReactionFacepileProfile reactionFacepileProfile = (ReactionFacepileProfile) g.get(0);
                ReactionImageFields d = reactionFacepileProfile.d();
                i = (d == null || Strings.isNullOrEmpty(d.b()) || Strings.isNullOrEmpty(reactionFacepileProfile.c())) ? 0 : 1;
            }
            if (i != 0) {
                return true;
            }
        }
        return false;
    }

    public static ReactionSingleFacepileHeaderPartDefinition m23286a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionSingleFacepileHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19279i) {
                ReactionSingleFacepileHeaderPartDefinition reactionSingleFacepileHeaderPartDefinition;
                if (a2 != null) {
                    reactionSingleFacepileHeaderPartDefinition = (ReactionSingleFacepileHeaderPartDefinition) a2.a(f19279i);
                } else {
                    reactionSingleFacepileHeaderPartDefinition = f19278h;
                }
                if (reactionSingleFacepileHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23287b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19279i, b3);
                        } else {
                            f19278h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionSingleFacepileHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionSingleFacepileHeaderPartDefinition(ReactionBackgroundPartDefinition reactionBackgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, ReactionExperimentController reactionExperimentController, ImageBlockLayoutThumbnailPartDefinition imageBlockLayoutThumbnailPartDefinition, ReactionIntentFactory reactionIntentFactory, ReactionTextWithEntitiesPartDefinition reactionTextWithEntitiesPartDefinition) {
        this.f19280b = reactionBackgroundPartDefinition;
        this.f19281c = clickListenerPartDefinition;
        this.f19282d = imageBlockLayoutThumbnailPartDefinition;
        this.f19283e = reactionIntentFactory;
        this.f19284f = reactionTextWithEntitiesPartDefinition;
        this.f19285g = reactionExperimentController.o();
    }

    public final ViewType m23288a() {
        return f19277a;
    }
}
