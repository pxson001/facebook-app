package com.facebook.reaction.ui.attachment.handler;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCardFragment;
import com.facebook.events.graphql.EventsGraphQLModels.EventPlaceModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventPlaceModel.AddressModel;
import com.facebook.events.mutators.PrivateEventsRsvpMutator;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.events.socialcontext.EventSocialContextFormatter;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelectorProvider;
import com.facebook.events.widget.eventcard.EventsCardView;
import com.facebook.events.widget.eventcard.EventsRsvpActionListener;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import javax.inject.Inject;

/* compiled from: WEIGHT_SUM */
public class ReactionEventsCardLargeViewHelper {
    public EventsCardView f20826a;
    private final EventActionButtonStateSelectorProvider f20827b;
    public final PublicEventsRsvpMutator f20828c;
    public final PrivateEventsRsvpMutator f20829d;
    public final FbDraweeControllerBuilder f20830e;
    public final EventSocialContextFormatter f20831f;
    private final Resources f20832g;

    public static ReactionEventsCardLargeViewHelper m24474b(InjectorLike injectorLike) {
        return new ReactionEventsCardLargeViewHelper((EventActionButtonStateSelectorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventActionButtonStateSelectorProvider.class), PublicEventsRsvpMutator.b(injectorLike), PrivateEventsRsvpMutator.b(injectorLike), FbDraweeControllerBuilder.b(injectorLike), EventSocialContextFormatter.m13402b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ReactionEventsCardLargeViewHelper(EventActionButtonStateSelectorProvider eventActionButtonStateSelectorProvider, PublicEventsRsvpMutator publicEventsRsvpMutator, PrivateEventsRsvpMutator privateEventsRsvpMutator, FbDraweeControllerBuilder fbDraweeControllerBuilder, EventSocialContextFormatter eventSocialContextFormatter, Resources resources) {
        this.f20827b = eventActionButtonStateSelectorProvider;
        this.f20828c = publicEventsRsvpMutator;
        this.f20829d = privateEventsRsvpMutator;
        this.f20830e = fbDraweeControllerBuilder;
        this.f20831f = eventSocialContextFormatter;
        this.f20832g = resources;
    }

    public final void m24476a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, EventsCardView eventsCardView, CallerContext callerContext) {
        String dU_;
        String a;
        this.f20826a = eventsCardView;
        this.f20826a.e();
        this.f20826a.a(this.f20832g.getDrawable(2130839488));
        EventCardFragment n = reactionStoryAttachmentFragmentModel.n();
        this.f20826a.setTitleText(n.dM_());
        this.f20826a.setCalendarFormatStartDate(EventsDateUtil.c(n.dN_()));
        EventsCardView eventsCardView2 = this.f20826a;
        EventPlaceModel d = n.d();
        if (d != null) {
            if (d.dU_() != null) {
                dU_ = d.dU_();
            } else {
                AddressModel c = d.c();
                if (!(c == null || StringUtil.a(c.a()))) {
                    dU_ = c.a();
                }
            }
            eventsCardView2.a(dU_, null);
            if (n.m()) {
                this.f20826a.setSocialContextText(null);
            } else {
                this.f20826a.a(this.f20831f.m13406a(), 2131361917);
            }
            a = ReactionEventAttachmentHelper.m24462a(reactionStoryAttachmentFragmentModel);
            if (a == null) {
                this.f20826a.setCoverPhotoController(this.f20830e.a(callerContext).a(a).s());
            } else {
                this.f20826a.setCoverPhotoController(null);
            }
            m24475b(reactionStoryAttachmentFragmentModel.n());
        }
        dU_ = null;
        eventsCardView2.a(dU_, null);
        if (n.m()) {
            this.f20826a.setSocialContextText(null);
        } else {
            this.f20826a.a(this.f20831f.m13406a(), 2131361917);
        }
        a = ReactionEventAttachmentHelper.m24462a(reactionStoryAttachmentFragmentModel);
        if (a == null) {
            this.f20826a.setCoverPhotoController(null);
        } else {
            this.f20826a.setCoverPhotoController(this.f20830e.a(callerContext).a(a).s());
        }
        m24475b(reactionStoryAttachmentFragmentModel.n());
    }

    private void m24475b(final EventCardFragment eventCardFragment) {
        this.f20826a.g.a(this.f20827b.a(new EventsRsvpActionListener(this) {
            final /* synthetic */ ReactionEventsCardLargeViewHelper f20825b;

            public final void m24472a(GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2) {
                if (eventCardFragment != null) {
                    this.f20825b.f20829d.a(eventCardFragment.dL_(), graphQLEventGuestStatus2, "unknown", "reaction_dialog", ActionMechanism.REACTION_ATTACHMENT);
                }
            }

            public final void m24473a(GraphQLEventWatchStatus graphQLEventWatchStatus, GraphQLEventWatchStatus graphQLEventWatchStatus2) {
                if (eventCardFragment != null) {
                    this.f20825b.f20828c.a(eventCardFragment.dL_(), graphQLEventWatchStatus2, "unknown", "reaction_dialog", ActionMechanism.REACTION_ATTACHMENT);
                }
            }
        }).a(eventCardFragment.k(), eventCardFragment.o(), eventCardFragment.q()));
    }
}
