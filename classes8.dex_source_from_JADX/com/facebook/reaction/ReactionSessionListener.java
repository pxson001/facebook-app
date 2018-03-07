package com.facebook.reaction;

import com.facebook.composer.publish.common.PendingStory;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.google.common.base.Optional;

/* compiled from: kFBSearchContextSearchClear */
public interface ReactionSessionListener {
    void mo726a(ReactionStories reactionStories);

    void mo727a(String str, Optional<PendingStory> optional);

    void kQ_();

    void kp_();

    boolean kq_();

    void kr_();
}
