package com.facebook.feed.ui.imageloader;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.UriUtil;
import com.facebook.feed.collage.PhotoGridProperties;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.story.StoryImageSizes;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: hideFeedStoryParams */
public class FeedImageLoader {
    private static FeedImageLoader f21084f;
    private static final Object f21085g = new Object();
    private final Provider<StoryImageSizes> f21086a;
    private final PhotoGridProperties f21087b;
    private final GraphQLImageHelper f21088c;
    private final LegacyAngoraAttachmentUtil f21089d;
    private StoryImageSizes f21090e;

    private static FeedImageLoader m28812b(InjectorLike injectorLike) {
        return new FeedImageLoader(IdBasedProvider.m1811a(injectorLike, 3479), PhotoGridProperties.m28823b(injectorLike), GraphQLImageHelper.m10139a(injectorLike), LegacyAngoraAttachmentUtil.m28831a(injectorLike));
    }

    @Inject
    public FeedImageLoader(Provider<StoryImageSizes> provider, PhotoGridProperties photoGridProperties, GraphQLImageHelper graphQLImageHelper, LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil) {
        this.f21086a = provider;
        this.f21087b = photoGridProperties;
        this.f21088c = graphQLImageHelper;
        m28818a();
        this.f21089d = legacyAngoraAttachmentUtil;
    }

    public final void m28818a() {
        this.f21090e = (StoryImageSizes) this.f21086a.get();
    }

    public static FeedImageLoader m28808a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedImageLoader b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21085g) {
                FeedImageLoader feedImageLoader;
                if (a2 != null) {
                    feedImageLoader = (FeedImageLoader) a2.mo818a(f21085g);
                } else {
                    feedImageLoader = f21084f;
                }
                if (feedImageLoader == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28812b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21085g, b3);
                        } else {
                            f21084f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedImageLoader;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final int m28814a(FeedImageType feedImageType) {
        switch (1.a[feedImageType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return this.f21090e.f6094b;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return this.f21090e.f6095c;
            case 5:
            case 6:
                return this.f21090e.f6093a;
            default:
                return 0;
        }
    }

    public final ImageRequest m28817a(GraphQLMedia graphQLMedia, FeedImageType feedImageType) {
        return m28811a(m28819b(graphQLMedia, feedImageType));
    }

    @Nullable
    public final ImageRequest m28820b(FeedProps<GraphQLStoryAttachment> feedProps, GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLImage a = m28810a((GraphQLStoryAttachment) feedProps.f13444a, graphQLStoryAttachment);
        if (a == graphQLStoryAttachment.m23979r().m24441T() || a == graphQLStoryAttachment.m23979r().m24446Y()) {
            a = graphQLStoryAttachment.m23979r().m24447Z();
        } else if (a == graphQLStoryAttachment.m23979r().m24447Z()) {
            a = graphQLStoryAttachment.m23979r().m24441T();
        } else {
            a = null;
        }
        if (a == null) {
            return null;
        }
        ImageRequestBuilder a2 = ImageRequestBuilder.m18776a(ImageUtil.m26990a(a));
        a2.f12718b = RequestLevel.DISK_CACHE;
        return a2.m18785m();
    }

    public final ImageRequest m28816a(FeedProps<GraphQLStoryAttachment> feedProps, GraphQLStoryAttachment graphQLStoryAttachment) {
        return m28811a(m28810a((GraphQLStoryAttachment) feedProps.f13444a, graphQLStoryAttachment));
    }

    public static ImageRequest m28811a(GraphQLImage graphQLImage) {
        if (graphQLImage == null) {
            return null;
        }
        Uri a = ImageUtil.m26990a(graphQLImage);
        if (UriUtil.m18788a(a) || graphQLImage.mo2925c() <= 0 || graphQLImage.mo2923a() <= 0) {
            return ImageRequest.m18795a(a);
        }
        ImageRequestBuilder a2 = ImageRequestBuilder.m18776a(a);
        a2.f12720d = new ResizeOptions(graphQLImage.mo2925c(), graphQLImage.mo2923a());
        return a2.m18785m();
    }

    @Nullable
    public final GraphQLImage m28819b(GraphQLMedia graphQLMedia, FeedImageType feedImageType) {
        return m28815a(graphQLMedia, m28814a(feedImageType), feedImageType);
    }

    @Nullable
    public final GraphQLImage m28815a(GraphQLMedia graphQLMedia, int i, @Nullable FeedImageType feedImageType) {
        if (graphQLMedia == null) {
            return null;
        }
        int intValue = GraphQLImageHelper.m10140a(i).intValue();
        if (feedImageType == FeedImageType.Share) {
            if (m28813b(graphQLMedia.m24444W())) {
                return graphQLMedia.m24444W();
            }
            if (m28813b(graphQLMedia.m24440S())) {
                return graphQLMedia.m24440S();
            }
            intValue = this.f21090e.f6093a;
        }
        GraphQLImage a = m28809a(graphQLMedia, intValue);
        return a == null ? graphQLMedia.m24440S() : a;
    }

    @Nullable
    public static GraphQLImage m28809a(GraphQLMedia graphQLMedia, int i) {
        if (graphQLMedia.m24446Y() != null && graphQLMedia.m24446Y().mo2925c() >= i) {
            return graphQLMedia.m24446Y();
        }
        if (graphQLMedia.m24447Z() != null && graphQLMedia.m24447Z().mo2925c() >= i) {
            return graphQLMedia.m24447Z();
        }
        if (graphQLMedia.m24441T() == null || graphQLMedia.m24441T().mo2925c() < i) {
            return null;
        }
        return graphQLMedia.m24441T();
    }

    private boolean m28813b(GraphQLImage graphQLImage) {
        return graphQLImage != null && this.f21089d.m28836a(graphQLImage, 1.9318181f);
    }

    private GraphQLImage m28810a(GraphQLStoryAttachment graphQLStoryAttachment, GraphQLStoryAttachment graphQLStoryAttachment2) {
        PhotoGridProperties photoGridProperties = this.f21087b;
        GraphQLImage a = m28815a(graphQLStoryAttachment2.m23979r(), Math.min(GraphQLImageHelper.m10140a(Math.round((((float) photoGridProperties.f21091a.getDefaultDisplay().getWidth()) * 0.8888889f) * (((float) PhotoGridProperties.m28824d(graphQLStoryAttachment2)) / ((float) photoGridProperties.m28828a(graphQLStoryAttachment))))).intValue(), 640), FeedImageType.Album);
        GraphQLMedia r = graphQLStoryAttachment2.m23979r();
        if (r.m24447Z() != null && (a == r.m24441T() || a == r.m24440S())) {
            a = r.m24447Z();
        }
        if (r.m24441T() == null || PhotoGridProperties.m28824d(graphQLStoryAttachment2) != this.f21087b.m28828a(graphQLStoryAttachment)) {
            return a;
        }
        return r.m24441T();
    }
}
