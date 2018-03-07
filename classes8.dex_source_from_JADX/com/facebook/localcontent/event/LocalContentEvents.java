package com.facebook.localcontent.event;

import com.facebook.localcontent.protocol.graphql.PopularProductFragmentsModels.PageProductModel;

/* compiled from: ec_intro_animation_end */
public class LocalContentEvents {

    /* compiled from: ec_intro_animation_end */
    public final class PageProductLikeUpdatedEvent extends LocalContentEvent {
        public final PageProductModel f14944a;

        public PageProductLikeUpdatedEvent(PageProductModel pageProductModel) {
            this.f14944a = pageProductModel;
        }
    }

    /* compiled from: ec_intro_animation_end */
    public abstract class PageProductLikeUpdatedSubscriber extends LocalContentEventSubscriber<PageProductLikeUpdatedEvent> {
        public final Class<PageProductLikeUpdatedEvent> m17417a() {
            return PageProductLikeUpdatedEvent.class;
        }
    }
}
