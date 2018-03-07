package com.facebook.feed.collage;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: applied_filter_in_gallery */
public class DataSavingsCollageLayoutProperties implements CollageLayoutProperties<StoryCollageItem> {
    private final ImmutableList<StoryCollageItem> f19127a;
    private final Map<StoryCollageItem, Integer> f19128b = new HashMap();
    private final int f19129c;

    public final int m22677a(CollageItem collageItem) {
        return ((Integer) this.f19128b.get((StoryCollageItem) collageItem)).intValue() * this.f19129c;
    }

    @Inject
    public DataSavingsCollageLayoutProperties(PhotoGridProperties photoGridProperties, @Assisted FeedProps<GraphQLStoryAttachment> feedProps) {
        ImmutableList a = photoGridProperties.a(feedProps);
        int min = Math.min(a.size(), 3);
        if (min == 0) {
            this.f19129c = 6;
            this.f19127a = RegularImmutableList.a;
            return;
        }
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < min; i++) {
            StoryCollageItem storyCollageItem = new StoryCollageItem((FeedProps) a.get(i));
            this.f19128b.put(storyCollageItem, Integer.valueOf(i));
            builder.c(storyCollageItem);
        }
        if (min < 3) {
            this.f19129c = 6 / min;
        } else {
            this.f19129c = 2;
        }
        this.f19127a = builder.b();
    }

    public final ImmutableList<StoryCollageItem> m22678a() {
        return this.f19127a;
    }

    public final int m22679b() {
        return 0;
    }

    public final int m22681c() {
        return 6;
    }

    public final int m22680b(CollageItem collageItem) {
        return 0;
    }

    public final int m22682c(CollageItem collageItem) {
        return this.f19129c;
    }

    public final int m22683d(CollageItem collageItem) {
        return 2;
    }
}
