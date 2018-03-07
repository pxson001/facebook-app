package com.facebook.feed.topicfeeds.events;

import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedFragmentModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedListModel;

/* compiled from: TSECTION_TYPE;>; */
public class TopicFeedsEvents {

    /* compiled from: TSECTION_TYPE;>; */
    public abstract class TopicFeedsListItemToggledEventSubscriber extends TopicFeedsEventSubscriber<TopicFeedsListItemToggledEvent> {
        public final Class<TopicFeedsListItemToggledEvent> m26455a() {
            return TopicFeedsListItemToggledEvent.class;
        }
    }

    /* compiled from: TSECTION_TYPE;>; */
    public abstract class TopicFeedsListUpdatedEventSubscriber extends TopicFeedsEventSubscriber<TopicFeedsListUpdatedEvent> {
        public final Class<TopicFeedsListUpdatedEvent> m26457a() {
            return TopicFeedsListUpdatedEvent.class;
        }
    }

    /* compiled from: TSECTION_TYPE;>; */
    public class TopicFeedsListItemToggledEvent extends TopicFeedsEvent {
        public final UpdatedState f24594a;
        public final TopicFeedFragmentModel f24595b;
        public final TopicFeedListModel f24596c;

        public TopicFeedsListItemToggledEvent(UpdatedState updatedState, TopicFeedFragmentModel topicFeedFragmentModel, TopicFeedListModel topicFeedListModel) {
            this.f24594a = updatedState;
            this.f24595b = topicFeedFragmentModel;
            this.f24596c = topicFeedListModel;
        }
    }

    /* compiled from: TSECTION_TYPE;>; */
    public class TopicFeedsListUpdatedEvent extends TopicFeedsEvent {
        public final TopicFeedListModel f24597a;
    }

    /* compiled from: TSECTION_TYPE;>; */
    public enum UpdatedState {
        FAVORITE_INSERTED,
        FAVORITE_REMOVED
    }
}
