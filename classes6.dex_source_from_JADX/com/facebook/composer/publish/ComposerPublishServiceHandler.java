package com.facebook.composer.publish;

import android.os.Bundle;
import com.facebook.api.story.FetchSingleStoryParams;
import com.facebook.api.story.FetchSingleStoryParams.FetchType;
import com.facebook.api.story.FetchSingleStoryResult;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.composer.lifeevent.protocol.ComposerLifeEventParam;
import com.facebook.composer.lifeevent.protocol.PublishLifeEventMethod;
import com.facebook.composer.protocol.FetchReviewInBatchMethod;
import com.facebook.composer.protocol.PostReviewMethod;
import com.facebook.composer.protocol.PostReviewParams;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.protocol.EditPostMethod;
import com.facebook.composer.publish.protocol.PollUploadMethod;
import com.facebook.composer.publish.protocol.PublishPostMethod;
import com.facebook.composer.publish.protocol.PublishShareMethod;
import com.facebook.composer.publish.protocol.SimplePhotoUploadMethod;
import com.facebook.composer.publish.protocol.SimplePhotoUploadParams;
import com.facebook.composer.publish.protocol.SimplePhotoUploadResult;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Filter;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.protocol.FetchGraphQLStoryMethod;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import javax.inject.Inject;

/* compiled from: pinned_message_threads */
public class ComposerPublishServiceHandler implements Filter {
    private final Lazy<ApiMethodRunner> f7948a;
    private final Lazy<PublishPostMethod> f7949b;
    private final Lazy<PublishShareMethod> f7950c;
    private final Lazy<SimplePhotoUploadMethod> f7951d;
    private final Lazy<EditPostMethod> f7952e;
    private final Lazy<PostReviewMethod> f7953f;
    private final Lazy<PublishLifeEventMethod> f7954g;
    private final Lazy<FetchReviewInBatchMethod> f7955h;
    private final Lazy<FetchGraphQLStoryMethod> f7956i;
    private final Lazy<PollUploadMethod> f7957j;

    public static ComposerPublishServiceHandler m11506b(InjectorLike injectorLike) {
        return new ComposerPublishServiceHandler(IdBasedSingletonScopeProvider.b(injectorLike, 2279), IdBasedLazy.a(injectorLike, 5279), IdBasedLazy.a(injectorLike, 5280), IdBasedLazy.a(injectorLike, 5281), IdBasedLazy.a(injectorLike, 5277), IdBasedLazy.a(injectorLike, 5270), IdBasedLazy.a(injectorLike, 5269), IdBasedLazy.a(injectorLike, 1468), IdBasedLazy.a(injectorLike, 5227), IdBasedLazy.a(injectorLike, 5278));
    }

    public static ComposerPublishServiceHandler m11504a(InjectorLike injectorLike) {
        return m11506b(injectorLike);
    }

    public final OperationResult m11512a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        String str = operationParams.b;
        if ("publish_post".equals(str)) {
            return m11508c(operationParams);
        }
        if ("publish_share".equals(str)) {
            return m11507b(operationParams);
        }
        if ("publish_photo".equals(str)) {
            return m11509d(operationParams);
        }
        if ("publish_edit_post".equals(str)) {
            return m11510e(operationParams);
        }
        if ("publish_review".equals(str)) {
            return m11511f(operationParams);
        }
        if ("publish_life_event".equals(str)) {
            return m11505a(operationParams);
        }
        return blueServiceHandler.a(operationParams);
    }

    private OperationResult m11505a(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        Batch a = ((ApiMethodRunnerImpl) this.f7948a.get()).a();
        String str = "graphObjectPosts";
        Builder a2 = BatchOperation.a((ApiMethod) this.f7954g.get(), (ComposerLifeEventParam) bundle.getParcelable("publishLifeEventParams"));
        a2.c = str;
        a.a(a2.a());
        a.a(str, CallerContext.a(getClass()));
        return OperationResult.a((String) a.a(str));
    }

    private OperationResult m11507b(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        Batch a = ((ApiMethodRunnerImpl) this.f7948a.get()).a();
        String str = "graphObjectShares";
        Builder a2 = BatchOperation.a((ApiMethod) this.f7950c.get(), (PublishPostParams) bundle.getParcelable("publishPostParams"));
        a2.c = str;
        a.a(a2.a());
        String str2 = "fetchShare";
        a2 = BatchOperation.a((ApiMethod) this.f7956i.get(), new FetchSingleStoryParams("{result=" + str + ":$.id}", DataFreshnessParam.STALE_DATA_OKAY, FetchType.PLATFORM_DEFAULT, 25));
        a2.c = str2;
        a.a(a2.a());
        a.a("publishShare", CallerContext.a(getClass()));
        return OperationResult.a(((FetchSingleStoryResult) a.a(str2)).a);
    }

    private OperationResult m11508c(OperationParams operationParams) {
        Object a;
        Bundle bundle = operationParams.c;
        Batch a2 = ((ApiMethodRunnerImpl) this.f7948a.get()).a();
        PublishPostParams publishPostParams = (PublishPostParams) bundle.getParcelable("publishPostParams");
        if (publishPostParams == null || publishPostParams.d == null) {
            PublishPostParams publishPostParams2 = publishPostParams;
        } else {
            Builder a3 = BatchOperation.a((ApiMethod) this.f7957j.get(), publishPostParams.d);
            a3.c = "uploadPoll";
            a2.a(a3.a());
            PublishPostParams.Builder builder = new PublishPostParams.Builder(publishPostParams);
            builder.am = "{result=uploadPoll:$.id}";
            a = builder.a();
        }
        String str = "graphObjectPosts";
        Builder a4 = BatchOperation.a((ApiMethod) this.f7949b.get(), a);
        a4.c = str;
        a2.a(a4.a());
        String str2 = "fetchPost";
        a4 = BatchOperation.a((ApiMethod) this.f7956i.get(), new FetchSingleStoryParams("{result=" + str + ":$.id}", DataFreshnessParam.STALE_DATA_OKAY, FetchType.PLATFORM_DEFAULT, 25));
        a4.c = str2;
        a2.a(a4.a());
        a2.a("publishPost", CallerContext.a(getClass()));
        return OperationResult.a(((FetchSingleStoryResult) a2.a(str2)).a);
    }

    private OperationResult m11509d(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        Batch a = ((ApiMethodRunnerImpl) this.f7948a.get()).a();
        Builder a2 = BatchOperation.a((ApiMethod) this.f7951d.get(), (SimplePhotoUploadParams) bundle.getParcelable("simplePhotoUploadParams"));
        a2.c = "graphObjectPhoto";
        a.a(a2.a());
        a.a("publishPhoto", CallerContext.a(getClass()));
        return OperationResult.a((SimplePhotoUploadResult) a.a("graphObjectPhoto"));
    }

    private OperationResult m11510e(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        Batch a = ((ApiMethodRunnerImpl) this.f7948a.get()).a();
        String str = "editPost";
        EditPostParams editPostParams = (EditPostParams) bundle.getParcelable("publishEditPostParamsKey");
        Builder a2 = BatchOperation.a((ApiMethod) this.f7952e.get(), editPostParams);
        a2.c = str;
        a.a(a2.a());
        String str2 = "fetchPost";
        Builder a3 = BatchOperation.a((ApiMethod) this.f7956i.get(), new FetchSingleStoryParams(editPostParams.storyId, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, FetchType.GRAPHQL_DEFAULT, 0));
        a3.c = str2;
        a3 = a3;
        a3.d = str;
        a.a(a3.a());
        a.a(str, CallerContext.a(getClass()));
        return OperationResult.a(((FetchSingleStoryResult) a.a(str2)).a);
    }

    @Inject
    public ComposerPublishServiceHandler(Lazy<ApiMethodRunner> lazy, Lazy<PublishPostMethod> lazy2, Lazy<PublishShareMethod> lazy3, Lazy<SimplePhotoUploadMethod> lazy4, Lazy<EditPostMethod> lazy5, Lazy<PostReviewMethod> lazy6, Lazy<FetchReviewInBatchMethod> lazy7, Lazy<FetchGraphQLStoryMethod> lazy8, Lazy<PublishLifeEventMethod> lazy9, Lazy<PollUploadMethod> lazy10) {
        this.f7948a = lazy;
        this.f7949b = lazy2;
        this.f7950c = lazy3;
        this.f7951d = lazy4;
        this.f7952e = lazy5;
        this.f7953f = lazy6;
        this.f7955h = lazy7;
        this.f7956i = lazy8;
        this.f7954g = lazy9;
        this.f7957j = lazy10;
    }

    private OperationResult m11511f(OperationParams operationParams) {
        Batch a = ((ApiMethodRunnerImpl) this.f7948a.get()).a();
        Builder a2 = BatchOperation.a((ApiMethod) this.f7953f.get(), (PostReviewParams) operationParams.c.getParcelable("publishReviewParams"));
        a2.c = "post_review";
        a.a(a2.a());
        String str = "fetchReview";
        a2 = BatchOperation.a((ApiMethod) this.f7955h.get(), null);
        a2.c = str;
        a.a(a2.a());
        a.a("postReviewAndFetchReview", CallerContext.a(getClass()));
        return OperationResult.a((ReviewWithFeedback) a.a(str));
    }
}
