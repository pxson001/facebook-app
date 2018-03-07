package com.facebook.composer.activity;

import android.content.Context;
import android.widget.ListView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.composer.activity.AlbumSelectorController.C07523;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbumsConnection;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.photos.albums.AlbumsAdapter;
import com.facebook.photos.albums.AlbumsAdapter.AlbumsAdapterMode;
import com.facebook.photos.albums.AlbumsAdapterProvider;
import com.facebook.photos.albums.futures.AlbumsFuturesGenerator;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: is_location_attached */
public class AlbumsListController {
    public final ListView f5975a;
    private final DefaultAndroidThreadUtil f5976b;
    public final AlbumsFuturesGenerator f5977c;
    public final Long f5978d;
    private final AlbumsAdapterProvider f5979e;
    public final C07523 f5980f;
    public final PerformanceLogger f5981g;
    public final AbstractFbErrorReporter f5982h;
    public final ComposerTargetData f5983i;
    public final boolean f5984j;
    public AlbumsAdapter f5985k;
    public final int f5986l;

    /* compiled from: is_location_attached */
    class C07531 extends OperationResultFutureCallback {
        final /* synthetic */ AlbumsListController f5974a;

        C07531(AlbumsListController albumsListController) {
            this.f5974a = albumsListController;
        }

        protected final void m7368a(Object obj) {
            GraphQLAlbumsConnection graphQLAlbumsConnection = (GraphQLAlbumsConnection) ((OperationResult) obj).k();
            if (graphQLAlbumsConnection == null) {
                this.f5974a.f5982h.b("albums_no_result_data_parcelable", "Composer result data parcelable is null.");
                return;
            }
            this.f5974a.f5985k = AlbumsAdapterProvider.a(AlbumsAdapterMode.DEFAULT);
            this.f5974a.f5975a.setAdapter(this.f5974a.f5985k);
            this.f5974a.f5985k.a(graphQLAlbumsConnection);
            if (this.f5974a.f5984j) {
                this.f5974a.f5985k.getFilter().filter(null);
            }
            C07523 c07523 = this.f5974a.f5980f;
            if (c07523.f5956b.f5968k.m7348b() != null) {
                AlbumsListController albumsListController = c07523.f5956b.f5967j;
                GraphQLAlbum b = c07523.f5956b.f5968k.m7348b();
                if (b != null) {
                    String u = b.u();
                    if (albumsListController.f5985k != null) {
                        albumsListController.f5985k.a(u);
                    }
                }
            }
            c07523.f5955a.setVisibility(8);
            this.f5974a.f5981g.c(917515, "perf_albums_list_fetch");
        }

        protected final void m7367a(ServiceException serviceException) {
        }
    }

    public AlbumsListController(ComposerTargetData composerTargetData, Long l, Context context, ListView listView, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AlbumsFuturesGenerator albumsFuturesGenerator, AlbumsAdapterProvider albumsAdapterProvider, C07523 c07523, PerformanceLogger performanceLogger, AbstractFbErrorReporter abstractFbErrorReporter, boolean z) {
        this.f5978d = l;
        this.f5975a = listView;
        this.f5976b = defaultAndroidThreadUtil;
        this.f5977c = albumsFuturesGenerator;
        this.f5986l = context.getResources().getDimensionPixelSize(2131429414);
        this.f5979e = albumsAdapterProvider;
        this.f5980f = c07523;
        this.f5981g = performanceLogger;
        this.f5982h = abstractFbErrorReporter;
        this.f5983i = composerTargetData;
        this.f5984j = z;
        m7369a();
    }

    private void m7369a() {
        ListenableFuture b;
        this.f5981g.d(917515, "perf_albums_list_fetch");
        if (this.f5983i.targetType == TargetType.GROUP) {
            b = this.f5977c.b(String.valueOf(this.f5983i.targetId), this.f5986l);
        } else {
            b = this.f5977c.a(String.valueOf(this.f5978d), this.f5986l);
        }
        this.f5976b.a(b, new C07531(this));
    }
}
