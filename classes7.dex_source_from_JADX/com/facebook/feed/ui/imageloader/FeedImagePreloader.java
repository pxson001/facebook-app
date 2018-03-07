package com.facebook.feed.ui.imageloader;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.feed.collage.PhotoGridProperties;
import com.facebook.feed.photos.FeedImagesCacheStateMapper;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;
import com.facebook.feed.util.StoryAttachmentUtil;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnitItem;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.photos.adaptiveimagequality.base.ImageQuality;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: The recorder surface invalid. Delegate %s */
public class FeedImagePreloader {
    private final FeedImageLoader f22220a;
    private final PhotoGridProperties f22221b;
    private List<FeedProps<GraphQLStoryAttachment>> f22222c;
    private final ImagePreprocessor f22223d;
    private final CallerContext f22224e;
    private final PerfTestConfig f22225f;
    private final AbstractFbErrorReporter f22226g;
    public final FeedImagesCacheStateMapper f22227h;

    /* compiled from: The recorder surface invalid. Delegate %s */
    /* synthetic */ class C19002 {
        static final /* synthetic */ int[] f22218a = new int[GraphQLStoryAttachmentStyle.values().length];
        static final /* synthetic */ int[] f22219b = new int[ImageQuality.values().length];

        static {
            try {
                f22219b[ImageQuality.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22219b[ImageQuality.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22219b[ImageQuality.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22218a[GraphQLStoryAttachmentStyle.SHARE.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f22218a[GraphQLStoryAttachmentStyle.SHARE_LARGE_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f22218a[GraphQLStoryAttachmentStyle.PHOTO.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f22218a[GraphQLStoryAttachmentStyle.ALBUM.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f22218a[GraphQLStoryAttachmentStyle.AVATAR_LIST.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    @Inject
    public FeedImagePreloader(FeedImageLoader feedImageLoader, PhotoGridProperties photoGridProperties, @Assisted CallerContext callerContext, @Assisted ImagePreprocessor imagePreprocessor, PerfTestConfig perfTestConfig, AbstractFbErrorReporter abstractFbErrorReporter, FeedImagesCacheStateMapper feedImagesCacheStateMapper, StoryAttachmentUtil storyAttachmentUtil) {
        this.f22220a = feedImageLoader;
        this.f22221b = photoGridProperties;
        this.f22224e = callerContext;
        this.f22223d = imagePreprocessor;
        this.f22225f = perfTestConfig;
        this.f22226g = abstractFbErrorReporter;
        this.f22227h = feedImagesCacheStateMapper;
    }

    public final List<ListenableFuture<?>> m24864a(FeedProps<? extends FeedUnit> feedProps, ImageQuality imageQuality) {
        List arrayList = new ArrayList();
        if (!PerfTestConfigBase.h) {
            m24861a((FeedProps) feedProps, imageQuality, this.f22223d, arrayList);
        }
        return arrayList;
    }

    private static void m24862a(@Nullable List<ListenableFuture<?>> list, @Nullable ListenableFuture<?> listenableFuture) {
        if (listenableFuture != null && list != null) {
            list.add(listenableFuture);
        }
    }

    private void m24861a(FeedProps<? extends FeedUnit> feedProps, ImageQuality imageQuality, ImagePreprocessor imagePreprocessor, @Nullable List<ListenableFuture<?>> list) {
        int i;
        int i2 = 0;
        FeedUnit feedUnit = (FeedUnit) feedProps.a;
        if (feedUnit instanceof GraphQLPaginatedPeopleYouMayKnowFeedUnit) {
            ImmutableList a = ItemListFeedUnitImpl.a((GraphQLPaginatedPeopleYouMayKnowFeedUnit) feedUnit);
            int size = a.size();
            int i3 = 0;
            i = 0;
            while (i3 < size) {
                int i4;
                GraphQLProfile a2 = FeedUnitItemProfileHelper.a((PeopleYouMayKnowFeedUnitItem) a.get(i3));
                if (a2 != null && a2.ai() != null) {
                    m24862a((List) list, imagePreprocessor.mo1549a(ImageRequest.a(a2.ai().b()), this.f22224e));
                    i4 = i + 1;
                    if (i4 >= 3) {
                        break;
                    }
                } else {
                    i4 = i;
                }
                i3++;
                i = i4;
            }
        }
        if (feedUnit instanceof GraphQLStory) {
            GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
            GraphQLActor b = StoryActorHelper.b(graphQLStory);
            if (b != null && GraphQLActorUtil.b(b)) {
                m24862a((List) list, m24860a(imagePreprocessor, StoryProps.d(feedProps), ImageRequest.a(b.ai().b())));
            }
            if (StoryAttachmentHelper.a(graphQLStory)) {
                for (i = 0; i < graphQLStory.x().size(); i++) {
                    if (!((GraphQLStoryAttachment) graphQLStory.x().get(i)).q()) {
                        m24863b(feedProps.a((Flattenable) graphQLStory.x().get(i)), imageQuality, imagePreprocessor, list);
                    }
                }
            }
            if (graphQLStory.L() != null) {
                m24861a(feedProps.a(graphQLStory.L()), imageQuality, imagePreprocessor, (List) list);
            }
            if (graphQLStory.aD() > 0) {
                while (i2 < StoryHierarchyHelper.a(graphQLStory).j().size()) {
                    m24861a(feedProps.a((Flattenable) StoryHierarchyHelper.a(graphQLStory).j().get(i2)), imageQuality, imagePreprocessor, (List) list);
                    i2++;
                }
            }
        }
    }

    private void m24863b(FeedProps<GraphQLStoryAttachment> feedProps, ImageQuality imageQuality, ImagePreprocessor imagePreprocessor, @Nullable List<ListenableFuture<?>> list) {
        FeedImageType feedImageType;
        ImageRequest a;
        int i = 0;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        switch (C19002.f22218a[(graphQLStoryAttachment.w().isEmpty() ? GraphQLStoryAttachmentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE : (GraphQLStoryAttachmentStyle) graphQLStoryAttachment.w().get(0)).ordinal()]) {
            case 1:
                Object obj;
                if (graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().aO() == null || !graphQLStoryAttachment.r().an() || graphQLStoryAttachment.r().S() == null || graphQLStoryAttachment.r().j() == null || 82650203 != graphQLStoryAttachment.r().j().g()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    if (!ActionLinkHelper.b(graphQLStoryAttachment, 1337291567)) {
                        feedImageType = FeedImageType.Share;
                        break;
                    } else {
                        feedImageType = FeedImageType.AddFriend;
                        break;
                    }
                }
                feedImageType = FeedImageType.Video;
                break;
                break;
            case 2:
                feedImageType = FeedImageType.ShareLargeImage;
                break;
            case 3:
                feedImageType = FeedImageType.Photo;
                break;
            case 4:
                if (graphQLStoryAttachment.x() != null && !graphQLStoryAttachment.x().isEmpty()) {
                    boolean f = this.f22221b.f(graphQLStoryAttachment);
                    if (f) {
                        this.f22222c = this.f22221b.a(feedProps);
                    } else {
                        this.f22222c = new ArrayList();
                        int min = Math.min(graphQLStoryAttachment.x().size(), 2);
                        while (i < min) {
                            this.f22222c.add(feedProps.a((Flattenable) graphQLStoryAttachment.x().get(i)));
                            i++;
                        }
                    }
                    for (FeedProps feedProps2 : this.f22222c) {
                        graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps2.a;
                        ImageRequest a2 = f ? this.f22220a.a(feedProps, graphQLStoryAttachment) : this.f22220a.a(graphQLStoryAttachment.r(), FeedImageType.Album);
                        if (a2 == null) {
                            this.f22226g.a("FeedImagePreloader", "Null imageParams: " + graphQLStoryAttachment);
                            return;
                        }
                        if (imageQuality != ImageQuality.OFF) {
                            a = m24858a(a2, graphQLStoryAttachment.r(), imageQuality);
                        } else {
                            a = a2;
                        }
                        m24862a((List) list, m24859a(FeedImageType.Album, imagePreprocessor, (FeedProps) feedProps, a));
                    }
                    return;
                }
                return;
            case 5:
                feedImageType = FeedImageType.AvatarList;
                break;
            default:
                return;
        }
        GraphQLImage b = this.f22220a.b(graphQLStoryAttachment.r(), feedImageType);
        if (b != null) {
            ImageRequest a3 = FeedImageLoader.a(b);
            if (imageQuality != ImageQuality.OFF) {
                a = m24858a(a3, graphQLStoryAttachment.r(), imageQuality);
            } else {
                a = a3;
            }
            m24862a((List) list, m24859a(feedImageType, imagePreprocessor, (FeedProps) feedProps, a));
        }
    }

    private ListenableFuture m24859a(FeedImageType feedImageType, ImagePreprocessor imagePreprocessor, FeedProps<GraphQLStoryAttachment> feedProps, ImageRequest imageRequest) {
        if (feedImageType == FeedImageType.Photo || feedImageType == FeedImageType.Album || feedImageType == FeedImageType.Share || feedImageType == FeedImageType.ShareLargeImage) {
            return m24860a(imagePreprocessor, AttachmentProps.a(feedProps), imageRequest);
        }
        return imagePreprocessor.mo1549a(imageRequest, this.f22224e);
    }

    private ListenableFuture m24860a(ImagePreprocessor imagePreprocessor, GraphQLStory graphQLStory, final ImageRequest imageRequest) {
        if (graphQLStory.g() == null) {
            return imagePreprocessor.mo1549a(imageRequest, this.f22224e);
        }
        this.f22227h.a(graphQLStory.g(), imageRequest.c.toString());
        ListenableFuture a = imagePreprocessor.mo1549a(imageRequest, this.f22224e);
        if (a == null) {
            return null;
        }
        Futures.a(a, new FutureCallback(this) {
            final /* synthetic */ FeedImagePreloader f22217b;

            public void onSuccess(@Nullable Object obj) {
                this.f22217b.f22227h.a(imageRequest.c.toString(), true);
            }

            public void onFailure(Throwable th) {
                this.f22217b.f22227h.a(imageRequest.c.toString(), false);
            }
        }, CallerThreadExecutor.a);
        return a;
    }

    private static ImageRequest m24858a(ImageRequest imageRequest, GraphQLMedia graphQLMedia, ImageQuality imageQuality) {
        GraphQLImage graphQLImage = null;
        switch (C19002.f22219b[imageQuality.ordinal()]) {
            case 1:
                graphQLImage = graphQLMedia.Y();
                break;
            case 2:
                graphQLImage = graphQLMedia.Z();
                break;
            case 3:
                graphQLImage = graphQLMedia.T();
                break;
        }
        if (graphQLImage != null) {
            return ImageRequestBuilder.a(imageRequest).b(Uri.parse(graphQLImage.b())).m();
        }
        return imageRequest;
    }
}
