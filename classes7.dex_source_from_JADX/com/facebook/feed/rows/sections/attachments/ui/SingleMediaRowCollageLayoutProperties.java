package com.facebook.feed.rows.sections.attachments.ui;

import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.collage.CollageLayoutProperties;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: VERB_PICKER */
public class SingleMediaRowCollageLayoutProperties implements CollageLayoutProperties<MediaCollageItem> {
    private final ImmutableList<MediaCollageItem> f21093a;
    private final Map<MediaCollageItem, Integer> f21094b = new HashMap();
    private final int f21095c;
    private final int f21096d;

    public final int m23969a(CollageItem collageItem) {
        return ((Integer) this.f21094b.get((MediaCollageItem) collageItem)).intValue() * this.f21096d;
    }

    public final int m23974c(CollageItem collageItem) {
        return ((Integer) this.f21094b.get((MediaCollageItem) collageItem)).intValue() == 2 ? 2 : this.f21096d;
    }

    @Inject
    public SingleMediaRowCollageLayoutProperties(@Assisted ImmutableList<FeedProps<GraphQLMedia>> immutableList) {
        Builder builder = ImmutableList.builder();
        this.f21095c = Math.min(immutableList.size(), 3);
        if (this.f21095c == 0) {
            this.f21096d = 10;
            this.f21093a = RegularImmutableList.a;
            return;
        }
        for (int i = 0; i < this.f21095c; i++) {
            MediaCollageItem mediaCollageItem = new MediaCollageItem((FeedProps) immutableList.get(i));
            this.f21094b.put(mediaCollageItem, Integer.valueOf(i));
            builder.c(mediaCollageItem);
        }
        if (this.f21095c < 3) {
            this.f21096d = 10 / this.f21095c;
        } else {
            this.f21096d = 4;
        }
        this.f21093a = builder.b();
    }

    public final ImmutableList<MediaCollageItem> m23970a() {
        return this.f21093a;
    }

    public final int m23971b() {
        return 0;
    }

    public final int m23973c() {
        return 10;
    }

    public final int m23972b(CollageItem collageItem) {
        return 0;
    }

    public final int m23975d(CollageItem collageItem) {
        return 4;
    }
}
