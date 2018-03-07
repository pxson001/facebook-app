package com.facebook.video.videohome.environment;

import com.facebook.inject.InjectorLike;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEvents;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: state_input_controller_fragment_tag */
public class VideoHomeCanHandlePageChangedEventsImpl extends CanHandleHScrollPageChangedEventsImpl {
    private final List<CanHandleHScrollPageChangedEvents> f2834a = new ArrayList();

    public static VideoHomeCanHandlePageChangedEventsImpl m2738b(InjectorLike injectorLike) {
        return new VideoHomeCanHandlePageChangedEventsImpl();
    }

    public final void m2741a(CanHandleHScrollPageChangedEvents canHandleHScrollPageChangedEvents) {
        Preconditions.checkNotNull(canHandleHScrollPageChangedEvents);
        this.f2834a.add(canHandleHScrollPageChangedEvents);
    }

    public final void m2739a(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        for (CanHandleHScrollPageChangedEvents a : this.f2834a) {
            a.a(i, reactionUnitComponentFields, reactionUnitComponentNode);
        }
    }

    public final void m2740a(ReactionUnitComponentNode reactionUnitComponentNode) {
        for (CanHandleHScrollPageChangedEvents a : this.f2834a) {
            a.a(reactionUnitComponentNode);
        }
    }

    public final void m2742b(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        for (CanHandleHScrollPageChangedEvents b : this.f2834a) {
            b.b(i, reactionUnitComponentFields, reactionUnitComponentNode);
        }
    }
}
