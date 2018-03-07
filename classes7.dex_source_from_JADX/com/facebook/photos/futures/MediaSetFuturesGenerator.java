package com.facebook.photos.futures;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.photos.albums.protocols.MediasetQuery.AlbumMediasetQueryString;
import com.facebook.photos.albums.protocols.MediasetQuery.MediasetQueryString;
import com.facebook.photos.albums.protocols.MediasetQuery.PhotosTakenHereMediasetQueryString;
import com.facebook.photos.albums.protocols.MediasetQuery.PhotosTakenOfMediasetQueryString;
import com.facebook.photos.albums.protocols.MediasetQuery.PostedPhotosMediasetQueryString;
import com.facebook.photos.albums.protocols.MediasetQuery.TaggedMediasetQueryString;
import com.facebook.photos.albums.protocols.MediasetQueryInterfaces.DefaultMediaSetMediaConnection;
import com.facebook.photos.albums.protocols.MediasetQueryModels.AlbumMediasetQueryModel;
import com.facebook.photos.albums.protocols.MediasetQueryModels.MediasetQueryModel;
import com.facebook.photos.albums.protocols.MediasetQueryModels.PhotosTakenHereMediasetQueryModel;
import com.facebook.photos.albums.protocols.MediasetQueryModels.PhotosTakenOfMediasetQueryModel;
import com.facebook.photos.albums.protocols.MediasetQueryModels.PostedPhotosMediasetQueryModel;
import com.facebook.photos.albums.protocols.MediasetQueryModels.TaggedMediasetQueryModel;
import com.facebook.photos.albums.protocols.MediasetType;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: last_event_completed_at_millis */
public class MediaSetFuturesGenerator {
    private final GraphQLQueryExecutor f10527a;
    private final GraphQLImageHelper f10528b;
    private final SizeAwareImageUtil f10529c;

    /* compiled from: last_event_completed_at_millis */
    class C08921 implements Function<GraphQLResult<TaggedMediasetQueryModel>, DefaultMediaSetMediaConnection> {
        final /* synthetic */ MediaSetFuturesGenerator f10520a;

        C08921(MediaSetFuturesGenerator mediaSetFuturesGenerator) {
            this.f10520a = mediaSetFuturesGenerator;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((TaggedMediasetQueryModel) graphQLResult.e).a() == null) {
                return null;
            }
            return ((TaggedMediasetQueryModel) graphQLResult.e).a().a();
        }
    }

    /* compiled from: last_event_completed_at_millis */
    class C08932 implements Function<GraphQLResult<PostedPhotosMediasetQueryModel>, DefaultMediaSetMediaConnection> {
        final /* synthetic */ MediaSetFuturesGenerator f10521a;

        C08932(MediaSetFuturesGenerator mediaSetFuturesGenerator) {
            this.f10521a = mediaSetFuturesGenerator;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return null;
            }
            return ((PostedPhotosMediasetQueryModel) graphQLResult.e).a();
        }
    }

    /* compiled from: last_event_completed_at_millis */
    class C08943 implements Function<GraphQLResult<PhotosTakenOfMediasetQueryModel>, DefaultMediaSetMediaConnection> {
        final /* synthetic */ MediaSetFuturesGenerator f10522a;

        C08943(MediaSetFuturesGenerator mediaSetFuturesGenerator) {
            this.f10522a = mediaSetFuturesGenerator;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return null;
            }
            return ((PhotosTakenOfMediasetQueryModel) graphQLResult.e).a();
        }
    }

    /* compiled from: last_event_completed_at_millis */
    class C08954 implements Function<GraphQLResult<PhotosTakenHereMediasetQueryModel>, DefaultMediaSetMediaConnection> {
        final /* synthetic */ MediaSetFuturesGenerator f10523a;

        C08954(MediaSetFuturesGenerator mediaSetFuturesGenerator) {
            this.f10523a = mediaSetFuturesGenerator;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return null;
            }
            return ((PhotosTakenHereMediasetQueryModel) graphQLResult.e).a();
        }
    }

    /* compiled from: last_event_completed_at_millis */
    class C08965 implements Function<GraphQLResult<MediasetQueryModel>, DefaultMediaSetMediaConnection> {
        final /* synthetic */ MediaSetFuturesGenerator f10524a;

        C08965(MediaSetFuturesGenerator mediaSetFuturesGenerator) {
            this.f10524a = mediaSetFuturesGenerator;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return null;
            }
            return ((MediasetQueryModel) graphQLResult.e).a();
        }
    }

    /* compiled from: last_event_completed_at_millis */
    class C08976 implements Function<GraphQLResult<AlbumMediasetQueryModel>, DefaultMediaSetMediaConnection> {
        final /* synthetic */ MediaSetFuturesGenerator f10525a;

        C08976(MediaSetFuturesGenerator mediaSetFuturesGenerator) {
            this.f10525a = mediaSetFuturesGenerator;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return null;
            }
            return ((AlbumMediasetQueryModel) graphQLResult.e).a();
        }
    }

    /* compiled from: last_event_completed_at_millis */
    /* synthetic */ class C08987 {
        static final /* synthetic */ int[] f10526a = new int[MediasetType.values().length];

        static {
            try {
                f10526a[MediasetType.POSTED_PHOTOS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10526a[MediasetType.PHOTOS_TAKEN_OF.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10526a[MediasetType.PHOTOS_TAKEN_HERE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10526a[MediasetType.MEDIASET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f10526a[MediasetType.ALBUM_MEDIASET.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f10526a[MediasetType.TAGGED_MEDIASET.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Inject
    public MediaSetFuturesGenerator(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLImageHelper graphQLImageHelper, SizeAwareImageUtil sizeAwareImageUtil) {
        this.f10527a = graphQLQueryExecutor;
        this.f10528b = graphQLImageHelper;
        this.f10529c = sizeAwareImageUtil;
    }

    public final ListenableFuture<DefaultMediaSetMediaConnection> m12387a(String str, String str2, String str3, int i, int i2, int i3, MediasetType mediasetType) {
        Preconditions.checkNotNull(str);
        switch (C08987.f10526a[mediasetType.ordinal()]) {
            case 1:
                return m12382b(str, str2, str3, i, i2, i3);
            case 2:
                return m12383c(str, str2, str3, i, i2, i3);
            case 3:
                return m12384d(str, str2, str3, i, i2, i3);
            case 4:
                return m12385e(str, str2, str3, i, i2, i3);
            case 5:
                return m12386f(str, str2, str3, i, i2, i3);
            default:
                return m12380a(str, str2, str3, i, i2, i3);
        }
    }

    private ListenableFuture<DefaultMediaSetMediaConnection> m12380a(String str, String str2, String str3, int i, int i2, int i3) {
        GraphQlQueryString taggedMediasetQueryString = new TaggedMediasetQueryString();
        m12381a(taggedMediasetQueryString, str, str2, str3, i, i2, i3);
        return Futures.a(this.f10527a.a(GraphQLRequest.a(taggedMediasetQueryString)), new C08921(this), MoreExecutors.a());
    }

    private ListenableFuture<DefaultMediaSetMediaConnection> m12382b(String str, String str2, String str3, int i, int i2, int i3) {
        GraphQlQueryString postedPhotosMediasetQueryString = new PostedPhotosMediasetQueryString();
        m12381a(postedPhotosMediasetQueryString, str, str2, str3, i, i2, i3);
        return Futures.a(this.f10527a.a(GraphQLRequest.a(postedPhotosMediasetQueryString)), new C08932(this), MoreExecutors.a());
    }

    private ListenableFuture<DefaultMediaSetMediaConnection> m12383c(String str, String str2, String str3, int i, int i2, int i3) {
        GraphQlQueryString photosTakenOfMediasetQueryString = new PhotosTakenOfMediasetQueryString();
        m12381a(photosTakenOfMediasetQueryString, str, str2, str3, i, i2, i3);
        return Futures.a(this.f10527a.a(GraphQLRequest.a(photosTakenOfMediasetQueryString)), new C08943(this), MoreExecutors.a());
    }

    private void m12381a(GraphQlQueryString graphQlQueryString, String str, String str2, String str3, int i, int i2, int i3) {
        graphQlQueryString.a("node_id", str);
        graphQlQueryString.a("before", str2);
        graphQlQueryString.a("after", str3);
        this.f10529c.a(graphQlQueryString);
        if (i > 0) {
            graphQlQueryString.a("first", String.valueOf(i));
        }
        if (i2 > 0) {
            graphQlQueryString.a("image_width", String.valueOf(GraphQLImageHelper.a(i2)));
        }
        if (i3 > 0) {
            graphQlQueryString.a("image_height", String.valueOf(this.f10528b.a(i2, i3)));
        }
    }

    private ListenableFuture<DefaultMediaSetMediaConnection> m12384d(String str, String str2, String str3, int i, int i2, int i3) {
        GraphQlQueryString photosTakenHereMediasetQueryString = new PhotosTakenHereMediasetQueryString();
        m12381a(photosTakenHereMediasetQueryString, str, str2, str3, i, i2, i3);
        return Futures.a(this.f10527a.a(GraphQLRequest.a(photosTakenHereMediasetQueryString)), new C08954(this), MoreExecutors.a());
    }

    private ListenableFuture<DefaultMediaSetMediaConnection> m12385e(String str, String str2, String str3, int i, int i2, int i3) {
        GraphQlQueryString mediasetQueryString = new MediasetQueryString();
        m12381a(mediasetQueryString, str, str2, str3, i, i2, i3);
        return Futures.a(this.f10527a.a(GraphQLRequest.a(mediasetQueryString)), new C08965(this), MoreExecutors.a());
    }

    private ListenableFuture<DefaultMediaSetMediaConnection> m12386f(String str, String str2, String str3, int i, int i2, int i3) {
        GraphQlQueryString albumMediasetQueryString = new AlbumMediasetQueryString();
        m12381a(albumMediasetQueryString, str, str2, str3, i, i2, i3);
        return Futures.a(this.f10527a.a(GraphQLRequest.a(albumMediasetQueryString)), new C08976(this), MoreExecutors.a());
    }
}
