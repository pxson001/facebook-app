package com.facebook.feed.rows.sections.attachments.ui;

import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.collage.CollageLayoutProperties;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: VIEW_TYPE_UNKNOWN */
public class MediaGridCollageLayoutProperties implements CollageLayoutProperties<MediaCollageItem> {
    private final ImmutableList<MediaCollageItem> f21074a;
    private final Map<MediaCollageItem, Integer> f21075b = new HashMap();

    public final int m23943a(CollageItem collageItem) {
        return ((Integer) this.f21075b.get((MediaCollageItem) collageItem)).intValue() % 3;
    }

    public final int m23946b(CollageItem collageItem) {
        return ((Integer) this.f21075b.get((MediaCollageItem) collageItem)).intValue() / 3;
    }

    @Inject
    public MediaGridCollageLayoutProperties(@Assisted ImmutableList<FeedProps<GraphQLMedia>> immutableList) {
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < immutableList.size(); i++) {
            MediaCollageItem mediaCollageItem = new MediaCollageItem((FeedProps) immutableList.get(i));
            this.f21075b.put(mediaCollageItem, Integer.valueOf(i));
            builder.c(mediaCollageItem);
        }
        this.f21074a = builder.b();
    }

    public final ImmutableList<MediaCollageItem> m23944a() {
        return this.f21074a;
    }

    public final int m23945b() {
        return 0;
    }

    public final int m23947c() {
        return 3;
    }

    public final int m23948c(CollageItem collageItem) {
        return 1;
    }

    public final int m23949d(CollageItem collageItem) {
        return 1;
    }
}
