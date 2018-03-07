package com.facebook.photos.upload.protocol;

import android.os.Bundle;
import android.util.Log;
import com.facebook.api.story.FetchSingleStoryParams;
import com.facebook.api.story.FetchSingleStoryParams.FetchType;
import com.facebook.api.story.FetchSingleStoryResult;
import com.facebook.commerce.publishing.event.CommercePublishingEventBus;
import com.facebook.commerce.publishing.event.CommercePublishingPhotosUploadedEvent;
import com.facebook.commerce.publishing.mutator.ProductItemMutator;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.lifeevent.protocol.ComposerLifeEventParam;
import com.facebook.composer.lifeevent.protocol.PublishLifeEventMethod;
import com.facebook.composer.protocol.PostReviewMethod;
import com.facebook.composer.protocol.PostReviewParams;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.protocol.EditPostMethod;
import com.facebook.composer.publish.protocol.PublishPostMethod;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.protocol.FetchGraphQLStoryMethod;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PagePhotoMenuPhotoUploadInputData;
import com.facebook.graphql.calls.PlacePhotoUploadInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.http.protocol.MethodBatcher;
import com.facebook.http.protocol.MethodBatcherImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.localcontent.protocol.graphql.PhotoUploadMutations.PagePhotoMenuUploadString;
import com.facebook.localcontent.protocol.graphql.PhotoUploadMutations.PlacePhotoUploadString;
import com.facebook.messaging.media.imageurirequest.FetchImageInfoGraphQlMethod;
import com.facebook.messaging.media.imageurirequest.FetchImageParams;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.base.analytics.InterpretedException;
import com.facebook.photos.base.analytics.PhotoFlowLogger;
import com.facebook.photos.base.analytics.PhotoFlowLogger$ExceptionReporter;
import com.facebook.photos.base.analytics.upload.PublishStageBaseParams;
import com.facebook.photos.base.analytics.upload.UploadBaseParams;
import com.facebook.photos.upload.event.BaseMediaUploadEvent$Status;
import com.facebook.photos.upload.event.LifeEventUploadEvent;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MultiPhotoUploadProgressEvent;
import com.facebook.photos.upload.event.MultiPhotoUploadProgressEvent$ProgressType;
import com.facebook.photos.upload.event.PhotoReviewUploadEvent;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.PublishMethod;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.photos.upload.operation.UploadOperationHelper;
import com.facebook.photos.upload.uploaders.ReportedException;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: getMapAsync() must be called on the main thread */
public class PhotoPublisher {
    private static final Class<?> f13997a = PhotoPublisher.class;
    private final AttachPhotoMethod f13998b;
    private final MediaUploadEventBus f13999c;
    private final Provider<MethodBatcher> f14000d;
    private final PublishPostMethod f14001e;
    private final PublishPhotoMethod f14002f;
    private final PublishProfilePicMethod f14003g;
    private final PublishCoverPhotoMethod f14004h;
    private final PostReviewMethod f14005i;
    private final PublishLifeEventMethod f14006j;
    private final FetchGraphQLStoryMethod f14007k;
    private final UpdatePhotoTagMethod f14008l;
    private final UpdatePhotoInfoMethod f14009m;
    private final UpdatePhotoOrderMethod f14010n;
    private final UploadVideoSlideshowPostMethod f14011o;
    private final FetchImageInfoGraphQlMethod f14012p;
    private final CreativeEditingPhotoUploadHelper f14013q;
    private final FbDataConnectionManager f14014r;
    private final GraphQLQueryExecutor f14015s;
    private final ProductItemMutator f14016t;
    private final EditPostMethod f14017u;
    private final UploadOperationHelper f14018v;
    private final CommercePublishingEventBus f14019w;

    /* compiled from: getMapAsync() must be called on the main thread */
    interface GraphQLMutationPublishRequestProvider {
        MutationRequest mo1145a();
    }

    /* compiled from: getMapAsync() must be called on the main thread */
    class GraphQLMutationPublishException extends ReportedException {
        public GraphQLMutationPublishException(ExceptionInterpreter exceptionInterpreter) {
            super(exceptionInterpreter);
        }
    }

    /* compiled from: getMapAsync() must be called on the main thread */
    public class OrderPublishException extends ReportedException {
        private String mResponse;

        public OrderPublishException(ExceptionInterpreter exceptionInterpreter, String str) {
            super(exceptionInterpreter);
            this.mResponse = str;
        }

        public final String m21709a() {
            return this.mResponse;
        }
    }

    /* compiled from: getMapAsync() must be called on the main thread */
    class PhotoReviewPublishException extends ReportedException {
        public PhotoReviewPublishException(ExceptionInterpreter exceptionInterpreter) {
            super(exceptionInterpreter);
        }
    }

    /* compiled from: getMapAsync() must be called on the main thread */
    class SinglePhotoPublishException extends ReportedException {
        public SinglePhotoPublishException(ExceptionInterpreter exceptionInterpreter) {
            super(exceptionInterpreter);
        }
    }

    /* compiled from: getMapAsync() must be called on the main thread */
    class StatusPublishException extends ReportedException {
        public StatusPublishException(ExceptionInterpreter exceptionInterpreter) {
            super(exceptionInterpreter);
        }
    }

    /* compiled from: getMapAsync() must be called on the main thread */
    class TargetPublishException extends ReportedException {
        public TargetPublishException(ExceptionInterpreter exceptionInterpreter) {
            super(exceptionInterpreter);
        }
    }

    public static PhotoPublisher m21716b(InjectorLike injectorLike) {
        return new PhotoPublisher(AttachPhotoMethod.m21685a(injectorLike), MediaUploadEventBus.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2287), PublishPostMethod.m11652a(injectorLike), PublishPhotoMethod.m21732a(injectorLike), PublishProfilePicMethod.m21736a(injectorLike), PublishCoverPhotoMethod.m21729a(injectorLike), PostReviewMethod.m11490a(injectorLike), PublishLifeEventMethod.m11431a(injectorLike), FetchGraphQLStoryMethod.a(injectorLike), UpdatePhotoTagMethod.m21747a(injectorLike), UpdatePhotoInfoMethod.m21740a(injectorLike), UpdatePhotoOrderMethod.m21743a(injectorLike), UploadVideoSlideshowPostMethod.m21882a(injectorLike), FetchImageInfoGraphQlMethod.a(injectorLike), CreativeEditingPhotoUploadHelper.m21691a(injectorLike), FbDataConnectionManager.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), ProductItemMutator.m10984a(injectorLike), EditPostMethod.m11640a(injectorLike), UploadOperationHelper.m21580a(injectorLike), CommercePublishingEventBus.m10701a(injectorLike));
    }

    @Inject
    public PhotoPublisher(AttachPhotoMethod attachPhotoMethod, MediaUploadEventBus mediaUploadEventBus, Provider<MethodBatcher> provider, PublishPostMethod publishPostMethod, PublishPhotoMethod publishPhotoMethod, PublishProfilePicMethod publishProfilePicMethod, PublishCoverPhotoMethod publishCoverPhotoMethod, PostReviewMethod postReviewMethod, PublishLifeEventMethod publishLifeEventMethod, FetchGraphQLStoryMethod fetchGraphQLStoryMethod, UpdatePhotoTagMethod updatePhotoTagMethod, UpdatePhotoInfoMethod updatePhotoInfoMethod, UpdatePhotoOrderMethod updatePhotoOrderMethod, UploadVideoSlideshowPostMethod uploadVideoSlideshowPostMethod, FetchImageInfoGraphQlMethod fetchImageInfoGraphQlMethod, CreativeEditingPhotoUploadHelper creativeEditingPhotoUploadHelper, FbDataConnectionManager fbDataConnectionManager, GraphQLQueryExecutor graphQLQueryExecutor, ProductItemMutator productItemMutator, EditPostMethod editPostMethod, UploadOperationHelper uploadOperationHelper, CommercePublishingEventBus commercePublishingEventBus) {
        this.f13998b = attachPhotoMethod;
        this.f13999c = mediaUploadEventBus;
        this.f14000d = provider;
        this.f14001e = publishPostMethod;
        this.f14002f = publishPhotoMethod;
        this.f14003g = publishProfilePicMethod;
        this.f14004h = publishCoverPhotoMethod;
        this.f14005i = postReviewMethod;
        this.f14006j = publishLifeEventMethod;
        this.f14007k = fetchGraphQLStoryMethod;
        this.f14008l = updatePhotoTagMethod;
        this.f14009m = updatePhotoInfoMethod;
        this.f14010n = updatePhotoOrderMethod;
        this.f14011o = uploadVideoSlideshowPostMethod;
        this.f14012p = fetchImageInfoGraphQlMethod;
        this.f14013q = creativeEditingPhotoUploadHelper;
        this.f14014r = fbDataConnectionManager;
        this.f14015s = graphQLQueryExecutor;
        this.f14016t = productItemMutator;
        this.f14017u = editPostMethod;
        this.f14018v = uploadOperationHelper;
        this.f14019w = commercePublishingEventBus;
    }

    public final MediaUploadResult m21718a(UploadOperation uploadOperation, PhotoFlowLogger photoFlowLogger, ImmutableList<Long> immutableList, List<UploadPhotoParams> list, List<UploadPhotoParams> list2, int i) {
        UploadBaseParams j = photoFlowLogger.m19944j("2.0");
        Object obj = (list2.isEmpty() || immutableList.size() <= 1) ? null : 1;
        int c = uploadOperation.m21532c();
        PublishStageBaseParams a = photoFlowLogger.m19836a(uploadOperation.m21529b(), ((obj != null ? 1 : 2) + c) + m21710a(list2), uploadOperation.m21532c(), uploadOperation.m21508M().size(), i);
        this.f13999c.a(new MultiPhotoUploadProgressEvent(uploadOperation, immutableList.size(), immutableList.size(), MultiPhotoUploadProgressEvent$ProgressType.PUBLISHING));
        photoFlowLogger.m19869a(j, a);
        Batch a2 = ((MethodBatcherImpl) this.f14000d.get()).a();
        String a3 = m21714a(a2, list2, null);
        String str = "status";
        PublishPostParams a4 = this.f14018v.m21587b(uploadOperation).c(true).a();
        RequestLogger.m21739a(this.f14001e, a4);
        Builder a5 = BatchOperation.a(this.f14001e, a4).a(str);
        if (a3 != null) {
            a5.b(a3);
        }
        a2.a(a5.a());
        int size = immutableList.size();
        int i2 = 0;
        int i3 = 0;
        String str2 = str;
        while (i2 < size) {
            long longValue = ((Long) immutableList.get(i2)).longValue();
            String str3 = "photo_" + i3;
            AttachPhotoParam a6 = AttachPhotoParam.m21688a(Long.toString(longValue), "{result=status:$.id}", uploadOperation.m21509N(), m21715a(uploadOperation, str3), uploadOperation.ad(), c, uploadOperation.m21502G(), this.f14013q.m21693a((UploadPhotoParams) list.get(i3)), this.f14013q.m21694b((UploadPhotoParams) list.get(i3)), this.f14013q.m21695c((UploadPhotoParams) list.get(i3)), this.f14013q.m21696d((UploadPhotoParams) list.get(i3)), this.f14013q.m21697e((UploadPhotoParams) list.get(i3)), uploadOperation.ah(), uploadOperation.ai(), uploadOperation.m21519X(), uploadOperation.aD(), uploadOperation.aE());
            a2.a(BatchOperation.a(this.f13998b, a6).b(str2).a(str3).a());
            RequestLogger.m21739a(this.f13998b, a6);
            i2++;
            i3++;
            str2 = str3;
        }
        a3 = "fetch";
        if (obj == null) {
            a2.a(BatchOperation.a(this.f14007k, new FetchSingleStoryParams("{result=status:$.id}", DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, FetchType.PLATFORM_DEFAULT, 0)).a(a3).b(str2).a());
        }
        try {
            photoFlowLogger.m19915b(j, a);
            a2.a("multi_photo_publish", CallerContext.a(getClass()));
            if (Log.isLoggable("break_status_publish", 3)) {
                throw new InterpretedException("fake status publish break", !Log.isLoggable("break_publish_noretry", 3));
            }
            photoFlowLogger.m19927c(j, a);
            photoFlowLogger.m19933d(j, a);
            if (obj == null) {
                return new MediaUploadResult((String) a2.a("status"), Optional.of(((FetchSingleStoryResult) a2.a(a3)).a));
            }
            return m21722a(uploadOperation, photoFlowLogger, true, true, (String) a2.a("status"), immutableList, 0);
        } catch (Exception e) {
            PhotoFlowLogger$ExceptionReporter exceptionInterpreter = new ExceptionInterpreter(e);
            photoFlowLogger.m19870a(j, a, exceptionInterpreter);
            throw new StatusPublishException(exceptionInterpreter);
        }
    }

    public final MediaUploadResult m21723a(UploadOperation uploadOperation, List<Long> list) {
        Batch a = ((MethodBatcherImpl) this.f14000d.get()).a();
        List arrayList = new ArrayList();
        for (Long l : list) {
            FetchImageParams fetchImageParams = new FetchImageParams(Long.toString(l.longValue()), 0);
            String str = "fetch-image-info-" + l;
            a.a(BatchOperation.a(this.f14012p, fetchImageParams).a(str).a());
            RequestLogger.m21739a(this.f14012p, fetchImageParams);
            arrayList.add("{result=" + str + ":$..image.uri}");
        }
        UploadVideoSlideshowPostParams a2 = UploadVideoSlideshowPostParams.m21885a("-1", uploadOperation, arrayList, 2000, 200);
        String str2 = "slideshow-video-post";
        a.a(BatchOperation.a(this.f14011o, a2).a(str2).a());
        RequestLogger.m21739a(this.f14011o, a2);
        try {
            a.a("slideshow-video-batch", CallerContext.a(getClass()));
            return new MediaUploadResult((String) a.a(str2), Absent.withType());
        } catch (Exception e) {
            throw new StatusPublishException(new ExceptionInterpreter(e));
        }
    }

    public final MediaUploadResult m21719a(UploadOperation uploadOperation, PhotoFlowLogger photoFlowLogger, ImmutableList<Long> immutableList, List<UploadPhotoParams> list, List<UploadPhotoParams> list2, String str, String str2, int i, PublishMethod publishMethod) {
        Object obj;
        String str3;
        UploadBaseParams j = photoFlowLogger.m19944j("2.0");
        boolean z = uploadOperation.m21510O() != Type.ALBUM;
        Object obj2 = (list2.isEmpty() || immutableList.size() <= 1) ? null : 1;
        int c = uploadOperation.m21532c();
        int i2 = (z && obj2 == null) ? 1 : 0;
        PublishStageBaseParams a = photoFlowLogger.m19836a(uploadOperation.m21529b(), (i2 + c) + m21710a(list2), uploadOperation.m21532c(), uploadOperation.m21508M().size(), i);
        this.f13999c.a(new MultiPhotoUploadProgressEvent(uploadOperation, immutableList.size(), immutableList.size(), MultiPhotoUploadProgressEvent$ProgressType.PUBLISHING));
        photoFlowLogger.m19869a(j, a);
        Batch a2 = ((MethodBatcherImpl) this.f14000d.get()).a();
        String a3 = m21714a(a2, list2, null);
        ImmutableList y = uploadOperation.m21549y();
        int size = immutableList.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            String A;
            boolean z2;
            long longValue = ((Long) immutableList.get(i3)).longValue();
            String str4 = "photo_" + i4;
            Set b = uploadOperation.m21508M() != null ? Sets.b(uploadOperation.m21508M()) : null;
            String l = uploadOperation.m21499D() >= 0 ? Long.toString(uploadOperation.m21499D()) : null;
            String str5 = null;
            if (y != null) {
                str5 = ((Bundle) y.get(i4)).getString("caption");
            }
            String l2 = Long.toString(longValue);
            String N = uploadOperation.m21509N();
            String a4 = m21715a(uploadOperation, str4);
            String E = uploadOperation.m21500E();
            if (str5 == null) {
                A = uploadOperation.m21496A();
            } else {
                A = str5;
            }
            MinutiaeTag ac = uploadOperation.ac();
            boolean F = uploadOperation.m21501F();
            RedSpaceValue G = uploadOperation.m21502G();
            String a5 = this.f14013q.m21693a((UploadPhotoParams) list.get(i4));
            String b2 = this.f14013q.m21694b((UploadPhotoParams) list.get(i4));
            boolean c2 = this.f14013q.m21695c((UploadPhotoParams) list.get(i4));
            boolean d = this.f14013q.m21696d((UploadPhotoParams) list.get(i4));
            boolean e = this.f14013q.m21697e((UploadPhotoParams) list.get(i4));
            long ad = uploadOperation.ad();
            boolean X = uploadOperation.m21519X();
            if (publishMethod == PublishMethod.EDIT_POST) {
                z2 = true;
            } else {
                z2 = false;
            }
            AttachPhotoParam a6 = AttachPhotoParam.m21689a(l2, str, str2, N, a4, l, E, b, A, ac, F, G, a5, b2, c2, d, e, ad, c, X, z2, uploadOperation.aD(), uploadOperation.aE());
            Builder a7 = BatchOperation.a(this.f13998b, a6).a(str4);
            RequestLogger.m21739a(this.f13998b, a6);
            if (a3 != null) {
                a7.b(a3);
            }
            a2.a(a7.a());
            i3++;
            i4++;
            a3 = str4;
        }
        if (publishMethod == PublishMethod.EDIT_POST) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            EditPostParams S = uploadOperation.m21514S();
            ImmutableList.Builder builder = ImmutableList.builder();
            if (!(S.mediaFbIds == null || S.mediaFbIds.isEmpty())) {
                builder.b(S.mediaFbIds);
            }
            int size2 = immutableList.size();
            for (int i5 = 0; i5 < size2; i5++) {
                builder.c(String.valueOf((Long) immutableList.get(i5)));
            }
            a2.a(BatchOperation.a(this.f14017u, new EditPostParams.Builder(S).b(builder.b()).a()).a("edit_post").b(a3).a());
            str3 = "edit_post";
        } else {
            str3 = a3;
        }
        if (z) {
            FetchType fetchType;
            if (obj != null) {
                str5 = uploadOperation.m21514S().storyId;
            } else {
                str5 = String.valueOf(immutableList.get(0));
            }
            DataFreshnessParam dataFreshnessParam = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
            if (obj != null) {
                fetchType = FetchType.GRAPHQL_DEFAULT;
            } else {
                fetchType = FetchType.GRAPHQL_PHOTO_CREATION_STORY;
            }
            a2.a(BatchOperation.a(this.f14007k, new FetchSingleStoryParams(str5, dataFreshnessParam, fetchType, 0)).a("fetch").b(str3).a());
        }
        try {
            photoFlowLogger.m19915b(j, a);
            a2.a("multi_photo_publish_target", CallerContext.a(getClass()));
            if (Log.isLoggable("break_target_publish", 3)) {
                throw new InterpretedException("fake target publish break", !Log.isLoggable("break_publish_noretry", 3));
            }
            photoFlowLogger.m19927c(j, a);
            photoFlowLogger.m19933d(j, a);
            if (obj2 == null) {
                Optional of;
                Optional withType = Absent.withType();
                if (z) {
                    of = Optional.of(((FetchSingleStoryResult) a2.a("fetch")).a);
                } else {
                    of = withType;
                }
                return new MediaUploadResult(Long.toString(((Long) immutableList.get(0)).longValue()), of);
            }
            return m21722a(uploadOperation, photoFlowLogger, false, z, Long.toString(((Long) immutableList.get(0)).longValue()), immutableList, 0);
        } catch (Exception e2) {
            PhotoFlowLogger$ExceptionReporter exceptionInterpreter = new ExceptionInterpreter(e2);
            photoFlowLogger.m19870a(j, a, exceptionInterpreter);
            throw new TargetPublishException(exceptionInterpreter);
        }
    }

    public final MediaUploadResult m21717a(UploadOperation uploadOperation, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadPhotoParams uploadPhotoParams, int i) {
        return m21711a(uploadOperation, defaultPhotoFlowLogger, uploadPhotoParams, i, this.f14002f, true);
    }

    public final MediaUploadResult m21725b(UploadOperation uploadOperation, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadPhotoParams uploadPhotoParams, int i) {
        return m21711a(uploadOperation, defaultPhotoFlowLogger, uploadPhotoParams, i, this.f14003g, false);
    }

    public final MediaUploadResult m21728c(UploadOperation uploadOperation, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadPhotoParams uploadPhotoParams, int i) {
        return m21711a(uploadOperation, defaultPhotoFlowLogger, uploadPhotoParams, i, this.f14004h, false);
    }

    public final MediaUploadResult m21722a(UploadOperation uploadOperation, PhotoFlowLogger photoFlowLogger, boolean z, boolean z2, String str, ImmutableList<Long> immutableList, int i) {
        String str2 = "fetch";
        Batch a = ((MethodBatcherImpl) this.f14000d.get()).a();
        UploadBaseParams j = photoFlowLogger.m19944j("2.0");
        PublishStageBaseParams a2 = photoFlowLogger.m19836a(uploadOperation.m21529b(), (z2 ? 1 : 0) + 1, uploadOperation.m21532c(), uploadOperation.m21508M().size(), i);
        photoFlowLogger.m19869a(j, a2);
        String str3 = "updateOrderMethod";
        a.a(BatchOperation.a(this.f14010n, new UpdatePhotoOrderParams(z ? (String) StringUtil.a(str, '_').get(1) : str, immutableList, z)).a(str3).a());
        if (z2) {
            a.a(BatchOperation.a(this.f14007k, new FetchSingleStoryParams(str, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, z ? FetchType.PLATFORM_DEFAULT : FetchType.GRAPHQL_PHOTO_CREATION_STORY, 0)).a(str2).b(str3).a());
        }
        try {
            photoFlowLogger.m19915b(j, a2);
            a.a("multi_photo_reorder", CallerContext.a(getClass()));
            photoFlowLogger.m19927c(j, a2);
            photoFlowLogger.m19933d(j, a2);
            Optional withType = Absent.withType();
            if (z2) {
                withType = Optional.of(((FetchSingleStoryResult) a.a(str2)).a);
            }
            return new MediaUploadResult(str, withType);
        } catch (Exception e) {
            PhotoFlowLogger$ExceptionReporter exceptionInterpreter = new ExceptionInterpreter(e);
            photoFlowLogger.m19870a(j, a2, exceptionInterpreter);
            throw new OrderPublishException(exceptionInterpreter, str);
        }
    }

    private MediaUploadResult m21711a(UploadOperation uploadOperation, PhotoFlowLogger photoFlowLogger, UploadPhotoParams uploadPhotoParams, int i, ApiMethod<UploadPhotoParams, Long> apiMethod, boolean z) {
        String a;
        UploadBaseParams j = photoFlowLogger.m19944j("2.0");
        int i2 = (z ? 1 : 0) + 1;
        if (uploadPhotoParams.m21831v() != 0) {
            i2++;
            ImmutableList z2 = uploadPhotoParams.m21834z();
            if (!(z2 == null || z2.isEmpty())) {
                i2++;
            }
        }
        PublishStageBaseParams a2 = photoFlowLogger.m19836a(uploadOperation.m21529b(), i2, 1, uploadOperation.m21508M().size(), i);
        this.f13999c.a(new MultiPhotoUploadProgressEvent(uploadOperation, 1, 1, MultiPhotoUploadProgressEvent$ProgressType.PUBLISHING));
        photoFlowLogger.m19869a(j, a2);
        Batch a3 = ((MethodBatcherImpl) this.f14000d.get()).a();
        if (uploadPhotoParams.m21832w()) {
            a = m21713a(a3, uploadPhotoParams, 0, null);
        } else {
            a = null;
        }
        String str = "publish";
        Builder a4 = BatchOperation.a(apiMethod, uploadPhotoParams).a(str);
        if (a != null) {
            a4.b(a);
        }
        RequestLogger.m21739a(apiMethod, uploadPhotoParams);
        a3.a(a4.a());
        String str2 = "fetchCreationStory";
        if (z) {
            a3.a(BatchOperation.a(this.f14007k, new FetchSingleStoryParams(String.valueOf(uploadPhotoParams.m21831v()), DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, FetchType.GRAPHQL_PHOTO_CREATION_STORY, 0)).a(str2).b(str).a());
        }
        try {
            photoFlowLogger.m19915b(j, a2);
            if (Log.isLoggable("break_photo_publish", 3)) {
                throw new InterpretedException("fake photo publish break", !Log.isLoggable("break_publish_noretry", 3));
            }
            a3.a("single_photo_publish", CallerContext.a(getClass()));
            photoFlowLogger.m19927c(j, a2);
            photoFlowLogger.m19933d(j, a2);
            Optional withType = Absent.withType();
            if (z) {
                withType = Optional.of(((FetchSingleStoryResult) a3.a(str2)).a);
            }
            return new MediaUploadResult(Long.toString(uploadPhotoParams.m21831v()), withType);
        } catch (Exception e) {
            PhotoFlowLogger$ExceptionReporter exceptionInterpreter = new ExceptionInterpreter(e);
            photoFlowLogger.m19870a(j, a2, exceptionInterpreter);
            throw new SinglePhotoPublishException(exceptionInterpreter);
        }
    }

    public final MediaUploadResult m21721a(UploadOperation uploadOperation, PhotoFlowLogger photoFlowLogger, List<Long> list, List<UploadPhotoParams> list2, List<UploadPhotoParams> list3, int i) {
        UploadBaseParams j = photoFlowLogger.m19944j("2.0");
        int c = uploadOperation.m21532c();
        PublishStageBaseParams a = photoFlowLogger.m19836a(uploadOperation.m21529b(), (c + 2) + m21710a(list3), uploadOperation.m21532c(), uploadOperation.m21508M().size(), i);
        this.f13999c.a(new MultiPhotoUploadProgressEvent(uploadOperation, list.size(), list.size(), MultiPhotoUploadProgressEvent$ProgressType.PUBLISHING));
        photoFlowLogger.m19869a(j, a);
        Batch a2 = ((MethodBatcherImpl) this.f14000d.get()).a();
        String a3 = m21714a(a2, list3, null);
        String str = "post_review";
        PostReviewParams a4 = PostReviewParams.Builder.m11493a(uploadOperation.m21506K()).m11494a(c).m11495a();
        Builder a5 = BatchOperation.a(this.f14005i, a4).a(str);
        if (a3 != null) {
            a5.b(a3);
        }
        a2.a(a5.a());
        RequestLogger.m21739a(this.f14005i, a4);
        int i2 = 0;
        String str2 = str;
        for (Long longValue : list) {
            long longValue2 = longValue.longValue();
            String str3 = str + i2;
            AttachPhotoParam a6 = AttachPhotoParam.m21689a(Long.toString(longValue2), "{result=" + str + ":$.og_action_id}", null, uploadOperation.m21509N(), m21715a(uploadOperation, str3), null, null, null, null, MinutiaeTag.a, false, RedSpaceValue.POST_TO_NEWSFEED, this.f14013q.m21693a((UploadPhotoParams) list2.get(i2)), this.f14013q.m21694b((UploadPhotoParams) list2.get(i2)), this.f14013q.m21695c((UploadPhotoParams) list2.get(i2)), this.f14013q.m21696d((UploadPhotoParams) list2.get(i2)), this.f14013q.m21697e((UploadPhotoParams) list2.get(i2)), uploadOperation.ad(), c, false, false, uploadOperation.aD(), uploadOperation.aE());
            RequestLogger.m21739a(this.f13998b, a6);
            a2.a(BatchOperation.a(this.f13998b, a6).a(str3).b(str2).a());
            i2++;
            str2 = str3;
        }
        try {
            photoFlowLogger.m19915b(j, a);
            if (Log.isLoggable("break_review_publish", 3)) {
                throw new InterpretedException("fake review publish break", !Log.isLoggable("break_publish_noretry", 3));
            }
            a2.a("photo_upload_review", CallerContext.a(getClass()));
            photoFlowLogger.m19927c(j, a);
            photoFlowLogger.m19933d(j, a);
            this.f13999c.a(new PhotoReviewUploadEvent(uploadOperation));
            return new MediaUploadResult((String) a2.a(str), Absent.withType());
        } catch (Exception e) {
            PhotoFlowLogger$ExceptionReporter exceptionInterpreter = new ExceptionInterpreter(e);
            photoFlowLogger.m19870a(j, a, exceptionInterpreter);
            throw new PhotoReviewPublishException(exceptionInterpreter);
        } catch (Throwable th) {
            this.f13999c.a(new PhotoReviewUploadEvent(uploadOperation));
        }
    }

    private String m21713a(Batch batch, UploadPhotoParams uploadPhotoParams, int i, String str) {
        if (Long.valueOf(uploadPhotoParams.f14084B).longValue() == 0) {
            return str;
        }
        String str2 = "updateInfoMethod" + i;
        Builder a = BatchOperation.a(this.f14009m, uploadPhotoParams);
        a.c = str2;
        a = a;
        if (str != null) {
            a.d = str;
        }
        batch.a(a.a());
        ImmutableList immutableList = uploadPhotoParams.f14120n;
        if (immutableList == null || immutableList.isEmpty()) {
            return str2;
        }
        str = "updateTagMethod" + i;
        a = BatchOperation.a(this.f14008l, uploadPhotoParams);
        a.d = str2;
        Builder builder = a;
        builder.c = str;
        batch.a(builder.a());
        return str;
    }

    public final MediaUploadResult m21726b(UploadOperation uploadOperation, List<Long> list) {
        if (uploadOperation.af != null) {
            this.f14016t.m10987a(uploadOperation.af.m10731a(list));
        }
        this.f14019w.a(new CommercePublishingPhotosUploadedEvent(list));
        return new MediaUploadResult(String.valueOf(list.get(0)), Absent.INSTANCE);
    }

    public final MediaUploadResult m21720a(UploadOperation uploadOperation, PhotoFlowLogger photoFlowLogger, List<Long> list, List<UploadPhotoParams> list2, int i) {
        UploadBaseParams j = photoFlowLogger.m19944j("2.0");
        int c = (uploadOperation.m21532c() + 1) + m21710a(list2);
        PublishStageBaseParams a = photoFlowLogger.m19836a(uploadOperation.m21529b(), c, uploadOperation.m21532c(), uploadOperation.m21508M().size(), i);
        this.f13999c.a(new MultiPhotoUploadProgressEvent(uploadOperation, list.size(), list.size(), MultiPhotoUploadProgressEvent$ProgressType.PUBLISHING));
        photoFlowLogger.m19869a(j, a);
        Batch a2 = ((MethodBatcherImpl) this.f14000d.get()).a();
        String a3 = m21714a(a2, list2, null);
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (Long valueOf : list) {
            builder.c(String.valueOf(valueOf));
        }
        String str = "post_life_event_photo";
        ComposerLifeEventParam L = uploadOperation.m21507L();
        Builder a4 = BatchOperation.a(this.f14006j, new ComposerLifeEventParam.Builder(L).m11269b(builder.b()).m11268a()).a(str);
        if (a3 != null) {
            a4.b(a3);
        }
        a2.a(a4.a());
        RequestLogger.m21739a(this.f14006j, L);
        try {
            photoFlowLogger.m19915b(j, a);
            a2.a("photo_upload_life_event", CallerContext.a(getClass()));
            this.f13999c.a(new LifeEventUploadEvent(uploadOperation, BaseMediaUploadEvent$Status.UPLOAD_SUCCESS, (String) a2.a(str)));
            photoFlowLogger.m19927c(j, a);
            photoFlowLogger.m19933d(j, a);
        } catch (Exception e) {
            PhotoFlowLogger$ExceptionReporter exceptionInterpreter = new ExceptionInterpreter(e);
            this.f13999c.a(new LifeEventUploadEvent(uploadOperation, BaseMediaUploadEvent$Status.UPLOAD_FAILED, null));
            photoFlowLogger.m19870a(j, a, exceptionInterpreter);
        }
        return new MediaUploadResult((String) a2.a(str), Absent.withType());
    }

    public final MediaUploadResult m21724a(final UploadOperation uploadOperation, final List<Long> list, PhotoFlowLogger photoFlowLogger, int i) {
        return m21712a(uploadOperation, (List) list, (DefaultPhotoFlowLogger) photoFlowLogger, i, new GraphQLMutationPublishRequestProvider(this) {
            final /* synthetic */ PhotoPublisher f13993c;

            public final MutationRequest mo1145a() {
                List arrayList = new ArrayList();
                for (Long longValue : list) {
                    arrayList.add(String.valueOf(longValue.longValue()));
                }
                PagePhotoMenuPhotoUploadInputData pagePhotoMenuPhotoUploadInputData = new PagePhotoMenuPhotoUploadInputData();
                pagePhotoMenuPhotoUploadInputData.a("actor_id", String.valueOf(uploadOperation.f13786i));
                GraphQlCallInput graphQlCallInput = pagePhotoMenuPhotoUploadInputData;
                graphQlCallInput.a("page_id", String.valueOf(uploadOperation.f13786i));
                graphQlCallInput = graphQlCallInput;
                graphQlCallInput.a("photo_ids", arrayList);
                return GraphQLRequest.a((PagePhotoMenuUploadString) new PagePhotoMenuUploadString().a("input", graphQlCallInput));
            }
        });
    }

    public final MediaUploadResult m21727b(final UploadOperation uploadOperation, final List<Long> list, PhotoFlowLogger photoFlowLogger, int i) {
        return m21712a(uploadOperation, (List) list, (DefaultPhotoFlowLogger) photoFlowLogger, i, new GraphQLMutationPublishRequestProvider(this) {
            final /* synthetic */ PhotoPublisher f13996c;

            public final MutationRequest mo1145a() {
                List arrayList = new ArrayList();
                for (Long longValue : list) {
                    arrayList.add(String.valueOf(longValue.longValue()));
                }
                PlacePhotoUploadInputData placePhotoUploadInputData = new PlacePhotoUploadInputData();
                placePhotoUploadInputData.a("page_id", String.valueOf(uploadOperation.f13786i));
                GraphQlCallInput graphQlCallInput = placePhotoUploadInputData;
                graphQlCallInput.a("photo_ids", arrayList);
                return GraphQLRequest.a((PlacePhotoUploadString) new PlacePhotoUploadString().a("input", graphQlCallInput));
            }
        });
    }

    private MediaUploadResult m21712a(UploadOperation uploadOperation, List<Long> list, PhotoFlowLogger photoFlowLogger, int i, GraphQLMutationPublishRequestProvider graphQLMutationPublishRequestProvider) {
        PublishStageBaseParams a = photoFlowLogger.m19836a(uploadOperation.m21529b(), 1, uploadOperation.m21532c(), uploadOperation.m21508M().size(), i);
        UploadBaseParams j = photoFlowLogger.m19944j("2.0");
        this.f13999c.a(new MultiPhotoUploadProgressEvent(uploadOperation, list.size(), list.size(), MultiPhotoUploadProgressEvent$ProgressType.PUBLISHING));
        photoFlowLogger.m19869a(j, a);
        MutationRequest a2 = graphQLMutationPublishRequestProvider.mo1145a();
        photoFlowLogger.m19915b(j, a);
        try {
            FutureDetour.a(this.f14015s.a(a2, OfflineQueryBehavior.b), 1174744479);
            photoFlowLogger.m19927c(j, a);
            photoFlowLogger.m19933d(j, a);
            return new MediaUploadResult(String.valueOf(list.get(0)), Absent.withType());
        } catch (Exception e) {
            Exception e2 = e;
            if ((e2 instanceof ExecutionException) && (e2.getCause() instanceof Exception)) {
                e2 = (Exception) e2.getCause();
            }
            PhotoFlowLogger$ExceptionReporter exceptionInterpreter = new ExceptionInterpreter(e2);
            photoFlowLogger.m19870a(j, a, exceptionInterpreter);
            throw new GraphQLMutationPublishException(exceptionInterpreter);
        }
    }

    private String m21714a(Batch batch, List<UploadPhotoParams> list, String str) {
        int i = 0;
        for (UploadPhotoParams uploadPhotoParams : list) {
            int i2;
            if (uploadPhotoParams.f14085C) {
                str = m21713a(batch, uploadPhotoParams, i, str);
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return str;
    }

    private static int m21710a(List<UploadPhotoParams> list) {
        int i = 0;
        for (UploadPhotoParams uploadPhotoParams : list) {
            int i2;
            if (uploadPhotoParams.f14084B != 0) {
                i++;
                ImmutableList immutableList = uploadPhotoParams.f14120n;
                if (!(immutableList == null || immutableList.isEmpty())) {
                    i2 = i + 1;
                    i = i2;
                }
            }
            i2 = i;
            i = i2;
        }
        return i;
    }

    private static String m21715a(UploadOperation uploadOperation, String str) {
        return uploadOperation.f13793p + "_" + str;
    }
}
