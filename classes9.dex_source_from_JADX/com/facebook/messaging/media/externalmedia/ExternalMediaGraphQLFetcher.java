package com.facebook.messaging.media.externalmedia;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLMessengerPlatformMediaType;
import com.facebook.graphql.enums.GraphQLMessengerPlatformResultType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLRequest.AppFbidFilter;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLRequest.ResultType;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLResult.MediaType;
import com.facebook.messaging.media.externalmedia.graphql.ExternalMediaQueryFragment;
import com.facebook.messaging.media.externalmedia.graphql.ExternalMediaQueryFragment.ExternalMediaQueryFragmentString;
import com.facebook.messaging.media.externalmedia.graphql.ExternalMediaQueryFragmentModels.ExternalMediaQueryFragmentModel;
import com.facebook.messaging.media.externalmedia.graphql.ExternalMediaQueryFragmentModels.ExternalMediaQueryFragmentModel.AppInfoModel;
import com.facebook.messaging.media.externalmedia.graphql.ExternalMediaQueryFragmentModels.ExternalMediaQueryFragmentModel.ResultGroupModel;
import com.facebook.messaging.media.externalmedia.graphql.ExternalMediaQueryFragmentModels.ExternalMediaQueryFragmentModel.ResultGroupModel.ResultsModel;
import com.facebook.messaging.media.externalmedia.graphql.ExternalMediaQueryFragmentModels.ExternalMediaQueryFragmentModel.ResultGroupModel.ResultsModel.MediaModel;
import com.facebook.messaging.media.externalmedia.graphql.ExternalMediaQueryFragmentModels.ExternalMediaQueryFragmentModel.ResultGroupModel.ResultsModel.SourceModel;
import com.facebook.messaging.model.attribution.AttributionVisibility;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.attribution.ContentAppAttributionBuilder;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerBuilder;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: mCountryCode */
public class ExternalMediaGraphQLFetcher {
    private final GraphQLQueryExecutor f11597a;

    /* compiled from: mCountryCode */
    class C13081 implements Function<GraphQLResult<ExternalMediaQueryFragmentModel>, ExternalMediaGraphQLResponse> {
        final /* synthetic */ ExternalMediaGraphQLFetcher f11594a;

        C13081(ExternalMediaGraphQLFetcher externalMediaGraphQLFetcher) {
            this.f11594a = externalMediaGraphQLFetcher;
        }

        public Object apply(Object obj) {
            return ExternalMediaGraphQLFetcher.m12235a(this.f11594a, (ExternalMediaQueryFragmentModel) ((GraphQLResult) obj).e);
        }
    }

    /* compiled from: mCountryCode */
    /* synthetic */ class C13092 {
        static final /* synthetic */ int[] f11595a = new int[GraphQLMessengerPlatformMediaType.values().length];
        static final /* synthetic */ int[] f11596b = new int[GraphQLMessengerPlatformResultType.values().length];

        static {
            try {
                f11596b[GraphQLMessengerPlatformResultType.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11596b[GraphQLMessengerPlatformResultType.STICKER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11596b[GraphQLMessengerPlatformResultType.ANIMATION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11596b[GraphQLMessengerPlatformResultType.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11595a[GraphQLMessengerPlatformMediaType.GIF.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f11595a[GraphQLMessengerPlatformMediaType.JPG.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f11595a[GraphQLMessengerPlatformMediaType.MP4.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f11595a[GraphQLMessengerPlatformMediaType.WEBP.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f11595a[GraphQLMessengerPlatformMediaType.PNG.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f11595a[GraphQLMessengerPlatformMediaType.WEBM.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    public static ExternalMediaGraphQLFetcher m12242b(InjectorLike injectorLike) {
        return new ExternalMediaGraphQLFetcher(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public ExternalMediaGraphQLFetcher(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f11597a = graphQLQueryExecutor;
    }

    public final ListenableFuture<ExternalMediaGraphQLResponse> m12243a(ExternalMediaGraphQLRequest externalMediaGraphQLRequest) {
        ExternalMediaQueryFragmentString a = ExternalMediaQueryFragment.m12247a();
        String str = "0";
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("query", externalMediaGraphQLRequest.f11599b);
        objectNode.a("query_type", externalMediaGraphQLRequest.f11598a.jsonValue);
        objectNode.c("result_types", ResultType.toJsonNode(externalMediaGraphQLRequest.f11600c));
        objectNode.a("group_by", externalMediaGraphQLRequest.f11601d.jsonValue);
        objectNode.a("num", externalMediaGraphQLRequest.f11602e);
        objectNode.c("media_params", MediaParams.m12244a(externalMediaGraphQLRequest.f11603f));
        objectNode.c("app_icon_params", MediaParams.m12244a(externalMediaGraphQLRequest.f11604g));
        if (externalMediaGraphQLRequest.f11605h != null) {
            objectNode.c("app_fbid_filter", AppFbidFilter.toJsonNode(externalMediaGraphQLRequest.f11605h));
        }
        a.a(str, objectNode.toString());
        GraphQLRequest a2 = GraphQLRequest.a(ExternalMediaQueryFragment.m12247a()).a(a.a);
        a2.a(1800);
        return Futures.a(this.f11597a.a(a2), new C13081(this));
    }

    public static ExternalMediaGraphQLResponse m12235a(ExternalMediaGraphQLFetcher externalMediaGraphQLFetcher, ExternalMediaQueryFragmentModel externalMediaQueryFragmentModel) {
        int i;
        Map hashMap = new HashMap();
        ImmutableList a = externalMediaQueryFragmentModel.m12299a();
        int size = a.size();
        for (i = 0; i < size; i++) {
            AppInfoModel appInfoModel = (AppInfoModel) a.get(i);
            hashMap.put(appInfoModel.m12261j(), appInfoModel);
        }
        Builder builder = ImmutableList.builder();
        ImmutableList j = externalMediaQueryFragmentModel.m12300j();
        int size2 = j.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ImmutableList a2 = ((ResultGroupModel) j.get(i2)).m12295a();
            int size3 = a2.size();
            for (i = 0; i < size3; i++) {
                builder.c(externalMediaGraphQLFetcher.m12236a((ResultsModel) a2.get(i), hashMap));
            }
        }
        return new ExternalMediaGraphQLResponse(builder.b(), externalMediaQueryFragmentModel.m12299a());
    }

    private ExternalMediaGraphQLResult m12236a(ResultsModel resultsModel, Map<String, AppInfoModel> map) {
        boolean z;
        GraphQLMessengerPlatformResultType l = resultsModel.m12290l();
        if (resultsModel.m12290l() != GraphQLMessengerPlatformResultType.STICKER || resultsModel.m12287a().equals(AppFbidFilter.INTERNAL_STICKERS.value)) {
            z = false;
        } else {
            l = GraphQLMessengerPlatformResultType.ANIMATION;
            z = true;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList j = resultsModel.m12288j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            builder.c(m12239a((MediaModel) j.get(i), resultsModel.m12290l()));
        }
        if (l == GraphQLMessengerPlatformResultType.STICKER) {
            return new ExternalMediaGraphQLResult(MediaType.STICKER, resultsModel.m12287a(), resultsModel.m12289k(), m12237a(resultsModel), null, builder.b());
        }
        return new ExternalMediaGraphQLResult(MediaType.MEDIA_RESOURCE, resultsModel.m12287a(), resultsModel.m12289k(), null, m12240a(resultsModel.m12287a(), resultsModel.m12291m(), l, (AppInfoModel) map.get(resultsModel.m12287a()), z), builder.b());
    }

    private static Sticker m12237a(ResultsModel resultsModel) {
        Uri parse = Uri.parse(((MediaModel) resultsModel.m12288j().get(0)).m12273k());
        Uri parse2 = resultsModel.m12288j().size() > 1 ? Uri.parse(((MediaModel) resultsModel.m12288j().get(1)).m12273k()) : parse;
        StickerBuilder stickerBuilder = new StickerBuilder();
        stickerBuilder.e = parse2;
        StickerBuilder stickerBuilder2 = stickerBuilder;
        stickerBuilder2.c = parse;
        stickerBuilder2 = stickerBuilder2;
        stickerBuilder2.a = resultsModel.m12289k();
        stickerBuilder2 = stickerBuilder2;
        stickerBuilder2.b = "";
        return stickerBuilder2.a();
    }

    private MediaResource m12239a(MediaModel mediaModel, GraphQLMessengerPlatformResultType graphQLMessengerPlatformResultType) {
        Uri parse = Uri.parse(mediaModel.m12273k());
        MediaResourceBuilder a = MediaResource.a();
        a.a = parse;
        a = a;
        a.w = parse;
        MediaResourceBuilder mediaResourceBuilder = a;
        mediaResourceBuilder.i = mediaModel.m12272j();
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.h = mediaModel.m12274l();
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.b = m12238a(graphQLMessengerPlatformResultType);
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.m = m12241a(mediaModel.m12269a());
        return mediaResourceBuilder.C();
    }

    private MediaResource m12240a(String str, SourceModel sourceModel, GraphQLMessengerPlatformResultType graphQLMessengerPlatformResultType, AppInfoModel appInfoModel, boolean z) {
        Uri parse = Uri.parse(sourceModel.m12283k());
        ContentAppAttributionBuilder newBuilder = ContentAppAttribution.newBuilder();
        newBuilder.b = str;
        newBuilder = newBuilder;
        newBuilder.c = appInfoModel.m12262k();
        newBuilder = newBuilder;
        newBuilder.e = appInfoModel.m12260a();
        newBuilder = newBuilder;
        newBuilder.h = AttributionVisibility.a;
        ContentAppAttribution i = newBuilder.i();
        MediaResourceBuilder a = MediaResource.a();
        a.a = parse;
        a = a;
        a.w = parse;
        MediaResourceBuilder mediaResourceBuilder = a;
        mediaResourceBuilder.x = true;
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.i = sourceModel.m12278a();
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.h = sourceModel.m12284l();
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.b = m12238a(graphQLMessengerPlatformResultType);
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.m = sourceModel.m12282j();
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.v = i;
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.z = z;
        return mediaResourceBuilder.C();
    }

    private static String m12241a(GraphQLMessengerPlatformMediaType graphQLMessengerPlatformMediaType) {
        if (graphQLMessengerPlatformMediaType == null) {
            throw new IllegalArgumentException();
        }
        switch (C13092.f11595a[graphQLMessengerPlatformMediaType.ordinal()]) {
            case 1:
                return "image/gif";
            case 2:
                return "image/jpeg";
            case 3:
                return "video/mp4";
            case 4:
                return "image/webp";
            case 5:
                return "image/png";
            case 6:
                return "video/webm";
            default:
                throw new IllegalArgumentException("Unknown result format: " + graphQLMessengerPlatformMediaType);
        }
    }

    private static Type m12238a(GraphQLMessengerPlatformResultType graphQLMessengerPlatformResultType) {
        switch (C13092.f11596b[graphQLMessengerPlatformResultType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return Type.PHOTO;
            case 4:
                return Type.VIDEO;
            default:
                throw new IllegalArgumentException("Unknown result type: " + graphQLMessengerPlatformResultType);
        }
    }
}
