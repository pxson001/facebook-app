package com.facebook.feed.thirdparty.instagram;

import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: should_rebuild_sections */
class InstagramUtils$InstagramImpressionEvent extends HoneyClientEvent {
    public InstagramUtils$InstagramImpressionEvent(InstagramEntryPoint instagramEntryPoint) {
        super("link_impression");
        this.c = "instagram_fb";
        b("type", instagramEntryPoint.getType());
    }
}
