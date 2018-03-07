package com.facebook.reaction.ui.card;

import android.content.Context;
import android.view.View;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.crowdsourcing.placequestion.PlaceQuestionStackView;
import com.facebook.inject.FbInjector;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionCard;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionValidationResult;
import com.facebook.reaction.interfaces.ReactionUnitParent;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitDefaultFields;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unsupported method! Did you mean to reach out to AsyncNewsFeedPrefetchHelper? */
public class ReactionUnitStackView extends PlaceQuestionStackView implements ReactionCard, ReactionUnitParent {
    @Inject
    public MonotonicClock f21076a;
    @Nullable
    public ReactionCardContainer f21077b;
    public ReactionUnitFragment f21078c;
    public ImmutableList<? extends ReactionUnitDefaultFields> f21079e;
    public ReactionValidationResult f21080f;

    public static void m24710a(Object obj, Context context) {
        ((ReactionUnitStackView) obj).f21076a = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(FbInjector.get(context));
    }

    public ReactionUnitStackView(Context context) {
        super(context);
        Class cls = ReactionUnitStackView.class;
        m24710a(this, getContext());
        int dimension = (int) getResources().getDimension(2131431415);
        setPadding(0, dimension, 0, dimension);
    }

    public final void ko_() {
        ReactionInteractionTracker interactionTracker = getInteractionTracker();
        if (interactionTracker != null && !Strings.isNullOrEmpty(getUnitId()) && getUnitType() != null) {
            interactionTracker.mo981a(getUnitId(), getUnitType(), new ReactionAttachmentIntent(null, UnitInteractionType.STACK_CHILD_INTERACTION));
        }
    }

    public int getNumAttachmentsLoaded() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ReactionCard) {
                i += ((ReactionCard) childAt).getNumAttachmentsLoaded();
            }
        }
        return i;
    }

    @Nullable
    public String getUnitId() {
        return this.f21078c == null ? null : this.f21078c.d();
    }

    @Nullable
    public String getUnitType() {
        return this.f21078c == null ? null : this.f21078c.n();
    }

    public View getView() {
        return this;
    }

    private ReactionInteractionTracker getInteractionTracker() {
        return this.f21077b == null ? null : this.f21077b.getInteractionTracker();
    }

    public final View m24711a(int i) {
        Preconditions.checkState(i >= 0);
        if (i >= this.f21079e.size()) {
            return null;
        }
        ReactionCardView reactionCardView = new ReactionCardView(this.f21077b, getContext());
        reactionCardView.m24709a((ReactionUnitDefaultFields) this.f21079e.get(i), (ReactionValidationResult) this.f21080f.f18876c.get(i), (ReactionUnitParent) this);
        reactionCardView.setPadding(0, 0, 0, 0);
        return reactionCardView;
    }

    public final void m24712b(int i) {
        ReactionInteractionTracker interactionTracker = getInteractionTracker();
        if (interactionTracker != null) {
            ReactionUnitDefaultFields reactionUnitDefaultFields = (ReactionUnitDefaultFields) this.f21079e.get(i);
            ReactionUnitDefaultFields reactionUnitDefaultFields2 = i == 0 ? null : (ReactionUnitDefaultFields) this.f21079e.get(i - 1);
            interactionTracker.m18932a(reactionUnitDefaultFields);
            String d = reactionUnitDefaultFields.d();
            reactionUnitDefaultFields.n();
            interactionTracker.mo983b(d, 1);
            if (reactionUnitDefaultFields2 != null) {
                interactionTracker.m18929a(this.f21076a.now(), reactionUnitDefaultFields2);
            }
            interactionTracker.m18930a(this.f21076a.now(), reactionUnitDefaultFields, this.f21078c);
        }
    }

    public int getNumQuestions() {
        return this.f21079e.size();
    }
}
