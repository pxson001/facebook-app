package com.facebook.photos.mediagallery.mutation;

import android.graphics.PointF;
import android.os.Bundle;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryScheduler;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLWriteLock;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.method.AddPhotoTagParams;
import com.facebook.photos.data.method.DeletePhotoParams;
import com.facebook.photos.data.method.DeletePhotoTagParams;
import com.facebook.photos.data.method.EditPhotoCaptionParams;
import com.facebook.photos.data.method.EditPhotoLocationParams;
import com.facebook.photos.data.method.PlaceSuggestionMutationParams;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel;
import com.facebook.photos.futures.PhotosFuturesGenerator;
import com.facebook.photos.mediagallery.mutation.MediaVisitorFactory.C09141;
import com.facebook.photos.mediagallery.mutation.MediaVisitorFactory.C09152;
import com.facebook.photos.mediagallery.mutation.MediaVisitorFactory.C09163;
import com.facebook.photos.mediagallery.mutation.MediaVisitorFactory.C09174;
import com.facebook.photos.mediagallery.mutation.MediaVisitorFactory.C09185;
import com.facebook.photos.mediagallery.mutation.MediaVisitorFactory.C09196;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: is_sticky_header_off */
public class MediaMutationGenerator {
    private final ExecutorService f10749a;
    public final GraphQLQueryExecutor f10750b;
    private final GraphQLQueryScheduler f10751c;
    private final MediaVisitorFactory f10752d;
    public final PhotosFuturesGenerator f10753e;

    public static MediaMutationGenerator m12765b(InjectorLike injectorLike) {
        return new MediaMutationGenerator((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), GraphQLQueryScheduler.a(injectorLike), MediaVisitorFactory.m12795a(injectorLike), IdBasedProvider.a(injectorLike, 9334));
    }

    @Inject
    public MediaMutationGenerator(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLQueryScheduler graphQLQueryScheduler, MediaVisitorFactory mediaVisitorFactory, Provider<PhotosFuturesGenerator> provider) {
        this.f10749a = executorService;
        this.f10750b = graphQLQueryExecutor;
        this.f10751c = graphQLQueryScheduler;
        this.f10752d = mediaVisitorFactory;
        this.f10753e = (PhotosFuturesGenerator) provider.get();
    }

    public static MediaMutationGenerator m12762a(InjectorLike injectorLike) {
        return m12765b(injectorLike);
    }

    public final ListenableFuture m12767a(final String str, final DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        return m12764a(new Callable<Future<OperationResult>>(this) {
            final /* synthetic */ MediaMutationGenerator f10723c;

            public Object call() {
                PhotosFuturesGenerator photosFuturesGenerator = this.f10723c.f10753e;
                String str = str;
                DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields = defaultTextWithEntitiesLongFields;
                Bundle bundle = new Bundle();
                bundle.putParcelable("editPhotoCaptionParams", new EditPhotoCaptionParams(str, defaultTextWithEntitiesLongFields));
                return BlueServiceOperationFactoryDetour.a(photosFuturesGenerator.f10532a, "edit_photo_caption", bundle, 257828710).a();
            }
        }, new MediaVisitor(str, new C09141(this.f10752d, str, defaultTextWithEntitiesLongFields)));
    }

    public final ListenableFuture m12770a(final String str, final TaggingProfile taggingProfile, final PointF pointF) {
        return m12764a(new Callable<Future<OperationResult>>(this) {
            final /* synthetic */ MediaMutationGenerator f10730d;

            public Object call() {
                PhotosFuturesGenerator photosFuturesGenerator = this.f10730d.f10753e;
                String str = str;
                TaggingProfile taggingProfile = taggingProfile;
                PointF pointF = pointF;
                Bundle bundle = new Bundle();
                bundle.putParcelable("addPhotoTagParams", new AddPhotoTagParams(str, taggingProfile, pointF));
                return BlueServiceOperationFactoryDetour.a(photosFuturesGenerator.f10532a, "add_photo_tag", bundle, 691557517).a();
            }
        }, new MediaVisitorTagAdd(str, taggingProfile, pointF));
    }

    public final ListenableFuture m12768a(final String str, final NodeModel nodeModel) {
        return m12764a(new Callable<Future<OperationResult>>(this) {
            final /* synthetic */ MediaMutationGenerator f10726c;

            public Object call() {
                PhotosFuturesGenerator photosFuturesGenerator = this.f10726c.f10753e;
                String str = str;
                NodeModel nodeModel = nodeModel;
                Bundle bundle = new Bundle();
                bundle.putParcelable("deletePhotoTagParams", new DeletePhotoTagParams(str, nodeModel.c(), nodeModel.d()));
                return BlueServiceOperationFactoryDetour.a(photosFuturesGenerator.f10532a, "delete_photo_tag", bundle, 128007561).a();
            }
        }, new MediaVisitorTagDelete(str, nodeModel));
    }

    public final ListenableFuture m12766a(final String str) {
        return m12764a(new Callable<Future<OperationResult>>(this) {
            final /* synthetic */ MediaMutationGenerator f10732b;

            public Object call() {
                PhotosFuturesGenerator photosFuturesGenerator = this.f10732b.f10753e;
                String str = str;
                Bundle bundle = new Bundle();
                bundle.putParcelable("deletePhotoParams", new DeletePhotoParams(str));
                return BlueServiceOperationFactoryDetour.a(photosFuturesGenerator.f10532a, "delete_photo", bundle, 2143812136).a();
            }
        }, new MediaVisitor(str, new C09152(this.f10752d, str)));
    }

    public final ListenableFuture m12769a(String str, @Nullable CheckinPlaceModel checkinPlaceModel, @Nullable String str2) {
        return m12763a(new MediaVisitor(str, new C09163(this.f10752d, str, checkinPlaceModel, str2)), str, checkinPlaceModel, str2);
    }

    public final ListenableFuture m12773b(String str, @Nullable CheckinPlaceModel checkinPlaceModel, @Nullable String str2) {
        return m12763a(new MediaVisitor(str, new C09174(this.f10752d, str, checkinPlaceModel, str2)), str, checkinPlaceModel, str2);
    }

    public final ListenableFuture m12772a(final String str, final String str2, String str3, final String str4) {
        return m12764a(new Callable<Future<OperationResult>>(this) {
            final /* synthetic */ MediaMutationGenerator f10736d;

            public Object call() {
                PhotosFuturesGenerator photosFuturesGenerator = this.f10736d.f10753e;
                String str = str;
                String str2 = str2;
                String str3 = str4;
                Bundle bundle = new Bundle();
                bundle.putParcelable("placeSuggestionMutationParams", new PlaceSuggestionMutationParams(str, str2, str3));
                return BlueServiceOperationFactoryDetour.a(photosFuturesGenerator.f10532a, "accept_place_suggestion", bundle, -832072082).a();
            }
        }, new MediaVisitor(str, new C09185(this.f10752d, str, str2, str3)));
    }

    public final ListenableFuture m12771a(final String str, final String str2, final String str3) {
        return m12764a(new Callable<Future<OperationResult>>(this) {
            final /* synthetic */ MediaMutationGenerator f10740d;

            public Object call() {
                PhotosFuturesGenerator photosFuturesGenerator = this.f10740d.f10753e;
                String str = str;
                String str2 = str2;
                String str3 = str3;
                Bundle bundle = new Bundle();
                bundle.putParcelable("placeSuggestionMutationParams", new PlaceSuggestionMutationParams(str, str2, str3));
                return BlueServiceOperationFactoryDetour.a(photosFuturesGenerator.f10532a, "reject_place_suggestion", bundle, 1322599442).a();
            }
        }, new MediaVisitor(str, new C09196(this.f10752d, str)));
    }

    private ListenableFuture m12763a(MediaVisitor mediaVisitor, final String str, @Nullable final CheckinPlaceModel checkinPlaceModel, @Nullable final String str2) {
        return m12764a(new Callable<Future<OperationResult>>(this) {
            final /* synthetic */ MediaMutationGenerator f10744d;

            public Object call() {
                String cf_;
                PhotosFuturesGenerator photosFuturesGenerator = this.f10744d.f10753e;
                String str = str;
                CheckinPlaceModel checkinPlaceModel = checkinPlaceModel;
                String str2 = str2;
                Bundle bundle = new Bundle();
                if (checkinPlaceModel != null) {
                    cf_ = checkinPlaceModel.cf_();
                } else if (checkinPlaceModel == null && str2 == null) {
                    cf_ = "0";
                } else {
                    cf_ = "-1";
                }
                bundle.putParcelable("editPhotoLocationParams", new EditPhotoLocationParams(str, cf_, str2));
                return BlueServiceOperationFactoryDetour.a(photosFuturesGenerator.f10532a, "edit_photo_location", bundle, 216170086).a();
            }
        }, mediaVisitor);
    }

    private ListenableFuture m12764a(final Callable<Future<OperationResult>> callable, MediaVisitor mediaVisitor) {
        final SettableFuture f = SettableFuture.f();
        final GraphQLWriteLock a = this.f10751c.a(mediaVisitor);
        ExecutorDetour.a(this.f10749a, new Runnable(this) {
            final /* synthetic */ MediaMutationGenerator f10748d;

            public void run() {
                try {
                    a.g();
                    OperationResult operationResult = (OperationResult) FutureDetour.a((Future) callable.call(), -955979875);
                    if (operationResult.b()) {
                        a.a(true);
                        FutureDetour.a(f, operationResult, -2027812383);
                        try {
                            this.f10748d.f10750b.a(a);
                        } catch (Throwable th) {
                        }
                        a.e();
                        return;
                    }
                    throw operationResult.e();
                } catch (Throwable th2) {
                    a.e();
                }
            }
        }, 595076103);
        return f;
    }
}
