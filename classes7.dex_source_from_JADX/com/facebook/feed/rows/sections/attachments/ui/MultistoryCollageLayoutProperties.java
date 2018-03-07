package com.facebook.feed.rows.sections.attachments.ui;

import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.collage.CollageLayoutProperties;
import com.facebook.feed.collage.StoryCollageItem;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.attachments.FallbackPhotoGridProperties;
import com.facebook.feed.ui.attachments.FallbackPhotoGridPropertiesProvider;
import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VIEW_TYPE_BOTTOM_PADDING */
public class MultistoryCollageLayoutProperties implements CollageLayoutProperties<StoryCollageItem> {
    public static Predicate<GraphQLStoryAttachment> f21077a = new C17881();
    private static final ImmutableMap<GraphQLStoryAttachmentStyle, FeedImageType> f21078b = ImmutableMap.of(GraphQLStoryAttachmentStyle.PHOTO, FeedImageType.Photo, GraphQLStoryAttachmentStyle.VIDEO, FeedImageType.Video);
    private final FallbackPhotoGridProperties f21079c;
    private final ImmutableList<FeedProps<GraphQLStoryAttachment>> f21080d;
    private final HashMap<GraphQLStoryAttachment, Integer> f21081e = Maps.c();
    private final ImmutableList<StoryCollageItem> f21082f;

    /* compiled from: VIEW_TYPE_BOTTOM_PADDING */
    final class C17881 implements Predicate<GraphQLStoryAttachment> {
        C17881() {
        }

        public final boolean apply(Object obj) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
            ImmutableList w = graphQLStoryAttachment.w();
            if (GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment) == null || w == null) {
                return false;
            }
            int size = w.size();
            for (int i = 0; i < size; i++) {
                if (MultistoryCollageLayoutProperties.m23952b((GraphQLStoryAttachmentStyle) w.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    public final int m23953a(CollageItem collageItem) {
        StoryCollageItem storyCollageItem = (StoryCollageItem) collageItem;
        FallbackPhotoGridProperties fallbackPhotoGridProperties = this.f21079c;
        int b = m23951b((GraphQLStoryAttachment) storyCollageItem.a.a);
        Preconditions.checkElementIndex(b, fallbackPhotoGridProperties.f21833f);
        int a = (fallbackPhotoGridProperties.f21832e || fallbackPhotoGridProperties.f21833f == 5) ? fallbackPhotoGridProperties.f21828a.mo1512a(b) : fallbackPhotoGridProperties.f21829b.mo1512a(b);
        return a;
    }

    public final int m23957b(CollageItem collageItem) {
        StoryCollageItem storyCollageItem = (StoryCollageItem) collageItem;
        FallbackPhotoGridProperties fallbackPhotoGridProperties = this.f21079c;
        int b = m23951b((GraphQLStoryAttachment) storyCollageItem.a.a);
        Preconditions.checkElementIndex(b, fallbackPhotoGridProperties.f21833f);
        int a = (fallbackPhotoGridProperties.f21832e || fallbackPhotoGridProperties.f21833f == 5) ? fallbackPhotoGridProperties.f21829b.mo1512a(b) : fallbackPhotoGridProperties.f21828a.mo1512a(b);
        return a;
    }

    public final int m23959c(CollageItem collageItem) {
        StoryCollageItem storyCollageItem = (StoryCollageItem) collageItem;
        FallbackPhotoGridProperties fallbackPhotoGridProperties = this.f21079c;
        int b = m23951b((GraphQLStoryAttachment) storyCollageItem.a.a);
        Preconditions.checkElementIndex(b, fallbackPhotoGridProperties.f21833f);
        int a = (fallbackPhotoGridProperties.f21832e || fallbackPhotoGridProperties.f21833f == 5) ? fallbackPhotoGridProperties.f21830c.mo1513a(b) : fallbackPhotoGridProperties.f21831d.mo1513a(b);
        return a;
    }

    public final int m23960d(CollageItem collageItem) {
        StoryCollageItem storyCollageItem = (StoryCollageItem) collageItem;
        FallbackPhotoGridProperties fallbackPhotoGridProperties = this.f21079c;
        int b = m23951b((GraphQLStoryAttachment) storyCollageItem.a.a);
        Preconditions.checkElementIndex(b, fallbackPhotoGridProperties.f21833f);
        int a = (fallbackPhotoGridProperties.f21832e || fallbackPhotoGridProperties.f21833f == 5) ? fallbackPhotoGridProperties.f21831d.mo1513a(b) : fallbackPhotoGridProperties.f21830c.mo1513a(b);
        return a;
    }

    public static boolean m23950a(ImmutableList<FeedProps<GraphQLStoryAttachment>> immutableList) {
        if (immutableList.size() < 2 || immutableList.size() > 5) {
            return false;
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (!f21077a.apply(((FeedProps) immutableList.get(i)).a)) {
                return false;
            }
        }
        return true;
    }

    @Inject
    public MultistoryCollageLayoutProperties(FallbackPhotoGridPropertiesProvider fallbackPhotoGridPropertiesProvider, @Assisted ImmutableList<FeedProps<GraphQLStoryAttachment>> immutableList) {
        Preconditions.checkArgument(m23950a((ImmutableList) immutableList));
        this.f21080d = immutableList;
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < this.f21080d.size(); i++) {
            this.f21081e.put(((FeedProps) this.f21080d.get(i)).a, Integer.valueOf(i));
            builder.c(new StoryCollageItem((FeedProps) this.f21080d.get(i)));
        }
        this.f21079c = new FallbackPhotoGridProperties(Integer.valueOf(this.f21080d.size()), Boolean.valueOf(GraphQLHelper.b(GraphQLStoryAttachmentUtil.l((GraphQLStoryAttachment) ((FeedProps) this.f21080d.get(0)).a))));
        this.f21082f = builder.b();
    }

    public final ImmutableList<StoryCollageItem> m23955a() {
        return this.f21082f;
    }

    public final int m23956b() {
        return 4;
    }

    public final int m23958c() {
        return 6;
    }

    @Nullable
    public final FeedImageType m23954a(GraphQLStoryAttachment graphQLStoryAttachment) {
        Preconditions.checkArgument(this.f21081e.containsKey(graphQLStoryAttachment));
        Preconditions.checkNotNull(graphQLStoryAttachment.w());
        ImmutableList w = graphQLStoryAttachment.w();
        int size = w.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle = (GraphQLStoryAttachmentStyle) w.get(i);
            if (m23952b(graphQLStoryAttachmentStyle)) {
                return (FeedImageType) f21078b.get(graphQLStoryAttachmentStyle);
            }
        }
        throw new IllegalStateException("Attachment not supported.");
    }

    public static boolean m23952b(GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle) {
        return f21078b.containsKey(graphQLStoryAttachmentStyle);
    }

    private int m23951b(GraphQLStoryAttachment graphQLStoryAttachment) {
        Preconditions.checkArgument(this.f21081e.containsKey(graphQLStoryAttachment), "Provided attachment is not one of the visible attachments");
        return ((Integer) this.f21081e.get(graphQLStoryAttachment)).intValue();
    }
}
