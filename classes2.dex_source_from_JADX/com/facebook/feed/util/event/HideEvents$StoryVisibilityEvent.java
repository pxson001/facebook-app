package com.facebook.feed.util.event;

import com.facebook.graphql.enums.StoryVisibility;
import javax.annotation.Nullable;

/* compiled from: pigeon_beacon */
public class HideEvents$StoryVisibilityEvent extends FeedEvent {
    public final String f11646a;
    public final String f11647b;
    public final String f11648c;
    public final StoryVisibility f11649d;
    public final int f11650e;

    public HideEvents$StoryVisibilityEvent(String str, @Nullable String str2, @Nullable String str3, StoryVisibility storyVisibility, int i) {
        this.f11646a = str;
        this.f11647b = str2;
        this.f11648c = str3;
        this.f11649d = storyVisibility;
        this.f11650e = i;
    }
}
