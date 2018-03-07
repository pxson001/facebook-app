package com.facebook.photos.albums.video;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.calls.MediaTypeInputMimeType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.albums.protocols.VideoListVideosGraphQL.VideosInVideoListDetailQueryString;
import com.facebook.photos.albums.protocols.VideoListVideosGraphQLModels.VideosInVideoListDetailQueryModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQL;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQL.VideosUploadedByUserDetailQueryString;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideosUploadedByUserDetailQueryModel;
import com.facebook.photos.albums.util.AlbumPermalinkRowConfig;
import com.facebook.photos.albums.util.AlbumPermalinkThumbnailController;
import com.facebook.photos.albums.video.VideoAlbumPermalinkActivity.VideoAlbumEntityType;
import com.facebook.photos.albums.video.ui.VideoAlbumPermalinkRowView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: confirmContactpoint */
public class VideoAlbumPermalinkAdapter extends BaseAdapter {
    private final Lazy<Resources> f17332a;
    private final Lazy<TasksManager> f17333b;
    private final Lazy<GraphQLQueryExecutor> f17334c;
    public final Long f17335d;
    public final VideoAlbumEntityType f17336e;
    public ArrayList<VideoDetailFragmentModel> f17337f = Lists.a();
    private AlbumPermalinkRowConfig f17338g;
    private int f17339h = 0;

    /* compiled from: confirmContactpoint */
    class C18401 extends AbstractDisposableFutureCallback<GraphQLResult> {
        final /* synthetic */ VideoAlbumPermalinkAdapter f17330a;

        C18401(VideoAlbumPermalinkAdapter videoAlbumPermalinkAdapter) {
            this.f17330a = videoAlbumPermalinkAdapter;
        }

        public final void m21349a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            BaseAdapter baseAdapter = this.f17330a;
            switch (baseAdapter.f17336e) {
                case USER:
                    if (!(graphQLResult == null || graphQLResult.e == null || ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k() == null || ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k().j() == null || ((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k().j().isEmpty())) {
                        baseAdapter.f17337f.addAll(((VideosUploadedByUserDetailQueryModel) graphQLResult.e).k().j());
                        break;
                    }
                case VIDEO_LIST:
                    if (!(graphQLResult == null || graphQLResult.e == null || ((VideosInVideoListDetailQueryModel) graphQLResult.e).j() == null || ((VideosInVideoListDetailQueryModel) graphQLResult.e).j().a() == null || ((VideosInVideoListDetailQueryModel) graphQLResult.e).j().a().isEmpty())) {
                        baseAdapter.f17337f.addAll(((VideosInVideoListDetailQueryModel) graphQLResult.e).j().a());
                        break;
                    }
            }
            AdapterDetour.a(baseAdapter, 1313268374);
        }

        protected final void m21350a(Throwable th) {
        }
    }

    @Inject
    public VideoAlbumPermalinkAdapter(@Assisted Long l, @Assisted VideoAlbumEntityType videoAlbumEntityType, Lazy<TasksManager> lazy, Lazy<GraphQLQueryExecutor> lazy2, Lazy<Resources> lazy3) {
        this.f17335d = l;
        this.f17336e = videoAlbumEntityType;
        this.f17333b = lazy;
        this.f17334c = lazy2;
        this.f17332a = lazy3;
        m21351d();
    }

    public int getCount() {
        if (this.f17337f.isEmpty() || this.f17332a.get() == null || this.f17338g == null) {
            return 0;
        }
        if (this.f17339h == 0 || this.f17339h != ((Resources) this.f17332a.get()).getConfiguration().orientation) {
            this.f17339h = ((Resources) this.f17332a.get()).getConfiguration().orientation;
            m21351d();
        }
        int i = this.f17338g.a;
        if (this.f17337f.size() % i == 0) {
            return this.f17337f.size() / i;
        }
        return (this.f17337f.size() / i) + 1;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f17337f.isEmpty()) {
            return null;
        }
        View view2;
        if (view != null) {
            view2 = (VideoAlbumPermalinkRowView) view;
        } else {
            view2 = new VideoAlbumPermalinkRowView(viewGroup.getContext());
        }
        int i2 = this.f17338g.a;
        view2.m21359a(i2, (double) this.f17338g.b, (double) this.f17338g.c);
        int i3 = i * i2;
        int min = Math.min(i2 + i3, this.f17337f.size());
        Builder builder = ImmutableList.builder();
        for (i2 = i3; i2 < min; i2++) {
            builder.c(this.f17337f.get(i2));
        }
        view2.m21360a(builder.b());
        return view2;
    }

    public final void m21352a() {
        if (this.f17337f.isEmpty()) {
            GraphQLRequest a;
            String str;
            int i = this.f17338g.b;
            switch (this.f17336e) {
                case USER:
                    VideosUploadedByUserDetailQueryString a2 = VideosUploadedByUserGraphQL.a();
                    a2.a("node_id", Long.toString(this.f17335d.longValue())).a("image_width", Integer.toString(i)).a("image_height", Integer.toString(i)).a("media_type", MediaTypeInputMimeType.IMAGEWEBP);
                    a = GraphQLRequest.a(a2);
                    break;
                case VIDEO_LIST:
                    GraphQlQueryString videosInVideoListDetailQueryString = new VideosInVideoListDetailQueryString();
                    videosInVideoListDetailQueryString.a("video_list_id", Long.toString(this.f17335d.longValue())).a("image_width", Integer.toString(i)).a("image_height", Integer.toString(i)).a("media_type", MediaTypeInputMimeType.IMAGEWEBP);
                    a = GraphQLRequest.a(videosInVideoListDetailQueryString);
                    break;
                default:
                    Preconditions.checkState(false, "Unhandled case");
                    a = null;
                    break;
            }
            GraphQLQueryFuture a3 = ((GraphQLQueryExecutor) this.f17334c.get()).a(a);
            C18401 c18401 = new C18401(this);
            TasksManager tasksManager = (TasksManager) this.f17333b.get();
            switch (this.f17336e) {
                case USER:
                    str = "tasks-executeVideoUploadedQuery" + this.f17335d;
                    break;
                case VIDEO_LIST:
                    str = "tasks-executeVideosInVideoListQuery" + this.f17335d;
                    break;
                default:
                    Preconditions.checkState(false, "Unhandled case");
                    str = null;
                    break;
            }
            tasksManager.a(str, a3, c18401);
        }
    }

    private void m21351d() {
        AlbumPermalinkThumbnailController albumPermalinkThumbnailController = new AlbumPermalinkThumbnailController((float) ((Resources) this.f17332a.get()).getDisplayMetrics().widthPixels, (float) ((Resources) this.f17332a.get()).getDimensionPixelSize(2131429418), (float) ((Resources) this.f17332a.get()).getDimensionPixelSize(2131429419));
        int i = (int) ((albumPermalinkThumbnailController.a + albumPermalinkThumbnailController.c) / (albumPermalinkThumbnailController.c + albumPermalinkThumbnailController.b));
        float f = (100.0f * ((albumPermalinkThumbnailController.c + albumPermalinkThumbnailController.a) - (((float) i) * (albumPermalinkThumbnailController.b + albumPermalinkThumbnailController.c)))) / ((((float) i) * (albumPermalinkThumbnailController.b + albumPermalinkThumbnailController.c)) - albumPermalinkThumbnailController.c);
        this.f17338g = new AlbumPermalinkRowConfig(i, (int) ((albumPermalinkThumbnailController.b * (f + 100.0f)) / 100.0f), (int) (((f + 100.0f) * albumPermalinkThumbnailController.c) / 100.0f));
    }
}
