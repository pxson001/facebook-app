package com.facebook.feedplugins.base.footer.ui;

import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.widget.springbutton.TouchSpring;
import com.google.common.collect.Maps;
import java.util.EnumMap;

/* compiled from: gif_image */
public class FooterButtonAndTouchSpringKey implements ContextStateKey<String, EnumMap<FooterButtonId, TouchSpring>> {
    private final String f22376a;

    public FooterButtonAndTouchSpringKey(GraphQLStory graphQLStory, FeedListType feedListType) {
        this.f22376a = getClass() + StoryKeyUtil.m28909a(graphQLStory) + feedListType.mo2419a();
    }

    public FooterButtonAndTouchSpringKey(String str) {
        this.f22376a = getClass() + str;
    }

    public final Object mo2130a() {
        return Maps.m811a(FooterButtonId.class);
    }

    public final Object mo2131b() {
        return this.f22376a;
    }
}
