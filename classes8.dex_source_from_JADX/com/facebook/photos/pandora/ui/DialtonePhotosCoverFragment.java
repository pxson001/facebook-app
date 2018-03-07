package com.facebook.photos.pandora.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.dialtone.DialtoneController.FeatureType;
import com.facebook.drawee.fbpipeline.DegradableDraweeController;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.pandora.common.futures.PandoraFuturesGenerator;
import com.facebook.photos.pandora.protocols.PandoraQuery.PandoraTaggedMediaCountQueryString;
import com.facebook.photos.pandora.protocols.PandoraQuery.PandoraUploadedMediaCountQueryString;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraTaggedMediaCountQueryModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraUploadedMediaCountQueryModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.photos.pandora.ui.PandoraTabPagerFragment */
public class DialtonePhotosCoverFragment extends FbFragment {
    @Inject
    public PandoraFuturesGenerator f17591a;
    @Inject
    public Lazy<TasksManager> f17592b;
    public int f17593c;

    /* compiled from: com.facebook.photos.pandora.ui.PandoraTabPagerFragment */
    public enum PandoraType {
        UPLOADED,
        TAGGED,
        ALBUM,
        SYNC
    }

    public static void m21560a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        DialtonePhotosCoverFragment dialtonePhotosCoverFragment = (DialtonePhotosCoverFragment) obj;
        PandoraFuturesGenerator a = PandoraFuturesGenerator.m21380a(fbInjector);
        Lazy a2 = IdBasedLazy.a(fbInjector, 3561);
        dialtonePhotosCoverFragment.f17591a = a;
        dialtonePhotosCoverFragment.f17592b = a2;
    }

    public static DialtonePhotosCoverFragment m21558a(PandoraType pandoraType, int i, String str) {
        DialtonePhotosCoverFragment dialtonePhotosCoverFragment = new DialtonePhotosCoverFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pandoraType", pandoraType.ordinal());
        bundle.putInt("photoCount", i);
        bundle.putString("userId", str);
        dialtonePhotosCoverFragment.g(bundle);
        return dialtonePhotosCoverFragment;
    }

    public final void m21565c(Bundle bundle) {
        super.c(bundle);
        Class cls = DialtonePhotosCoverFragment.class;
        m21560a((Object) this, getContext());
        this.f17593c = this.s.getInt("photoCount");
    }

    public final void m21564a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        final FbDraweeView fbDraweeView = (FbDraweeView) view.findViewById(2131560998);
        switch (PandoraType.values()[this.s.getInt("pandoraType")]) {
            case TAGGED:
                final String string = this.s.getString("userId");
                ((TasksManager) this.f17592b.get()).a("fetch tagged media count " + string, new Callable<ListenableFuture>(this) {
                    final /* synthetic */ DialtonePhotosCoverFragment f17587b;

                    public Object call() {
                        PandoraFuturesGenerator pandoraFuturesGenerator = this.f17587b.f17591a;
                        String str = string;
                        GraphQlQueryString pandoraTaggedMediaCountQueryString = new PandoraTaggedMediaCountQueryString();
                        pandoraTaggedMediaCountQueryString.a("node_id", str);
                        return GraphQLQueryExecutor.a(((GraphQLQueryExecutor) pandoraFuturesGenerator.f17385b.get()).a(GraphQLRequest.a(pandoraTaggedMediaCountQueryString).a(GraphQLCachePolicy.c).a(RequestPriority.INTERACTIVE)));
                    }
                }, new AbstractDisposableFutureCallback<PandoraTaggedMediaCountQueryModel>(this) {
                    final /* synthetic */ DialtonePhotosCoverFragment f17589b;

                    public final void m21556a(@Nullable Object obj) {
                        PandoraTaggedMediaCountQueryModel pandoraTaggedMediaCountQueryModel = (PandoraTaggedMediaCountQueryModel) obj;
                        if (pandoraTaggedMediaCountQueryModel != null && pandoraTaggedMediaCountQueryModel.a() != null && pandoraTaggedMediaCountQueryModel.a().a() != null) {
                            this.f17589b.f17593c = pandoraTaggedMediaCountQueryModel.a().a().a();
                            DialtonePhotosCoverFragment.m21561c(this.f17589b, fbDraweeView);
                        }
                    }

                    public final void m21557a(Throwable th) {
                    }
                });
                return;
            case UPLOADED:
                m21559a(fbDraweeView);
                return;
            default:
                return;
        }
    }

    public static void m21561c(DialtonePhotosCoverFragment dialtonePhotosCoverFragment, FbDraweeView fbDraweeView) {
        DraweeController controller = fbDraweeView.getController();
        if (controller instanceof DegradableDraweeController) {
            ((DegradableDraweeController) controller).a(dialtonePhotosCoverFragment.f17593c, FeatureType.PHOTO);
        }
    }

    public final View m21563a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1854524675);
        View inflate = layoutInflater.inflate(2130903898, viewGroup, false);
        FbDraweeView fbDraweeView = (FbDraweeView) inflate.findViewById(2131560998);
        fbDraweeView.setImageURI(null);
        m21561c(this, fbDraweeView);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2048102782, a);
        return inflate;
    }

    public final void m21562H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1862895657);
        super.H();
        ((TasksManager) this.f17592b.get()).c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1683909661, a);
    }

    private void m21559a(final FbDraweeView fbDraweeView) {
        final String string = this.s.getString("userId");
        ((TasksManager) this.f17592b.get()).a("fetch uploaded media count " + string, new Callable<ListenableFuture>(this) {
            final /* synthetic */ DialtonePhotosCoverFragment f17583b;

            public Object call() {
                PandoraFuturesGenerator pandoraFuturesGenerator = this.f17583b.f17591a;
                String str = string;
                GraphQlQueryString pandoraUploadedMediaCountQueryString = new PandoraUploadedMediaCountQueryString();
                pandoraUploadedMediaCountQueryString.a("node_id", str);
                return GraphQLQueryExecutor.a(((GraphQLQueryExecutor) pandoraFuturesGenerator.f17385b.get()).a(GraphQLRequest.a(pandoraUploadedMediaCountQueryString).a(GraphQLCachePolicy.c).a(RequestPriority.INTERACTIVE)));
            }
        }, new AbstractDisposableFutureCallback<PandoraUploadedMediaCountQueryModel>(this) {
            final /* synthetic */ DialtonePhotosCoverFragment f17585b;

            public final void m21554a(@Nullable Object obj) {
                PandoraUploadedMediaCountQueryModel pandoraUploadedMediaCountQueryModel = (PandoraUploadedMediaCountQueryModel) obj;
                if (pandoraUploadedMediaCountQueryModel != null && pandoraUploadedMediaCountQueryModel.a() != null && pandoraUploadedMediaCountQueryModel.a().a() != null) {
                    this.f17585b.f17593c = pandoraUploadedMediaCountQueryModel.a().a().a();
                    DialtonePhotosCoverFragment.m21561c(this.f17585b, fbDraweeView);
                }
            }

            public final void m21555a(Throwable th) {
            }
        });
    }
}
