package com.facebook.messaging.composershortcuts.graphql;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLMessengerPlatformMediaType;
import com.facebook.graphql.enums.GraphQLMessengerPlatformResultType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.composershortcuts.PlatformSampleContent;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentInterfaces.SampleContentQueryFragment;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentInterfaces.SampleContentQueryFragment.Apps.Edges.Node;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentModels.SampleContentQueryFragmentModel.AppsModel.EdgesModel;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentModels.SampleContentQueryFragmentModel.AppsModel.EdgesModel.NodeModel;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentModels.SampleContentQueryFragmentModel.AppsModel.EdgesModel.NodeModel.SampleContentModel;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentModels.SampleContentQueryFragmentModel.AppsModel.EdgesModel.NodeModel.SampleContentModel.MediaModel;
import com.facebook.messaging.model.attribution.AttributionVisibility;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.attribution.ContentAppAttributionBuilder;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableList;

/* compiled from: messageRecipientFbid */
public class SampleContentQueryUtils {

    /* compiled from: messageRecipientFbid */
    /* synthetic */ class C11761 {
        static final /* synthetic */ int[] f10203a = new int[GraphQLMessengerPlatformMediaType.values().length];
        static final /* synthetic */ int[] f10204b = new int[GraphQLMessengerPlatformResultType.values().length];

        static {
            try {
                f10204b[GraphQLMessengerPlatformResultType.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10204b[GraphQLMessengerPlatformResultType.STICKER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10204b[GraphQLMessengerPlatformResultType.ANIMATION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10204b[GraphQLMessengerPlatformResultType.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f10203a[GraphQLMessengerPlatformMediaType.GIF.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f10203a[GraphQLMessengerPlatformMediaType.JPG.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f10203a[GraphQLMessengerPlatformMediaType.MP4.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f10203a[GraphQLMessengerPlatformMediaType.WEBP.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f10203a[GraphQLMessengerPlatformMediaType.PNG.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f10203a[GraphQLMessengerPlatformMediaType.WEBM.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    public static SampleContentQueryUtils m10748a(InjectorLike injectorLike) {
        return new SampleContentQueryUtils();
    }

    public final ImmutableMap<String, ImmutableList<PlatformSampleContent>> m10753a(SampleContentQueryFragment sampleContentQueryFragment) {
        Builder builder = ImmutableMap.builder();
        ImmutableList a = sampleContentQueryFragment.m10736a().m10730a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) a.get(i);
            String b = edgesModel.m10726a().m10719b();
            ImmutableList a2 = m10751a(edgesModel.m10726a());
            if (!(a2 == null || a2.isEmpty())) {
                builder.b(b, a2);
            }
        }
        return builder.b();
    }

    private ImmutableList<PlatformSampleContent> m10751a(Node node) {
        if (node == null) {
            return RegularImmutableList.a;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList d = node.m10721d();
        int size = d.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            SampleContentModel sampleContentModel = (SampleContentModel) d.get(i);
            builder.c(new PlatformSampleContent(m10750a((MediaModel) sampleContentModel.m10712a().get(0), sampleContentModel.m10714c(), sampleContentModel.m10713b(), node), m10750a((MediaModel) sampleContentModel.m10712a().get(1), sampleContentModel.m10714c(), sampleContentModel.m10713b(), node)));
            int i3 = i2 + 1;
            if (i3 == 10) {
                break;
            }
            i++;
            i2 = i3;
        }
        return builder.b();
    }

    private MediaResource m10750a(MediaModel mediaModel, GraphQLMessengerPlatformResultType graphQLMessengerPlatformResultType, String str, NodeModel nodeModel) {
        Uri parse = Uri.parse(mediaModel.m10707c());
        MediaResourceBuilder a = MediaResource.a();
        a.a = parse;
        a = a;
        a.w = parse;
        MediaResourceBuilder mediaResourceBuilder = a;
        mediaResourceBuilder.i = mediaModel.m10706b();
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.h = mediaModel.m10708d();
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.b = m10749a(graphQLMessengerPlatformResultType);
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.m = m10752a(mediaModel.m10703a());
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.s = str;
        mediaResourceBuilder = mediaResourceBuilder;
        ContentAppAttributionBuilder newBuilder = ContentAppAttribution.newBuilder();
        newBuilder.b = nodeModel.m10719b();
        newBuilder = newBuilder;
        newBuilder.c = nodeModel.m10720c();
        newBuilder = newBuilder;
        newBuilder.e = nodeModel.m10718a();
        newBuilder = newBuilder;
        newBuilder.h = AttributionVisibility.newBuilder().f().h();
        mediaResourceBuilder.v = newBuilder.i();
        return mediaResourceBuilder.C();
    }

    private static String m10752a(GraphQLMessengerPlatformMediaType graphQLMessengerPlatformMediaType) {
        if (graphQLMessengerPlatformMediaType == null) {
            throw new IllegalArgumentException();
        }
        switch (C11761.f10203a[graphQLMessengerPlatformMediaType.ordinal()]) {
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

    private static Type m10749a(GraphQLMessengerPlatformResultType graphQLMessengerPlatformResultType) {
        switch (C11761.f10204b[graphQLMessengerPlatformResultType.ordinal()]) {
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
