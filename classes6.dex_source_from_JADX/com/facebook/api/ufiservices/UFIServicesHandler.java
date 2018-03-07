package com.facebook.api.ufiservices;

import android.os.Bundle;
import com.facebook.api.ufiservices.common.DeleteCommentParams;
import com.facebook.api.ufiservices.common.EditCommentParams;
import com.facebook.api.ufiservices.common.SetNotifyMeParams;
import com.facebook.api.ufiservices.common.SetNotifyMeParams.Builder;
import com.facebook.api.ufiservices.common.ToggleLikeParams;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Filter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.media.MediaItem;
import com.facebook.localstats.LocalStatsLogger;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.PublishMethod;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.photos.upload.protocol.PhotoUploadPrivacy;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader;
import com.facebook.photos.upload.uploaders.VideoUploader;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: promoRemaining */
public class UFIServicesHandler implements Filter {
    public final Provider<SingleMethodRunner> f7197a;
    public final Lazy<ToggleLikeMethod> f7198b;
    public final Lazy<SetNotifyMeMethod> f7199c;
    public final Lazy<DeleteCommentMethod> f7200d;
    public final Lazy<EditCommentMethod> f7201e;
    private final Lazy<DirectPhotoUploader> f7202f;
    private final Lazy<VideoUploader> f7203g;
    private final Lazy<UploadOperationFactory> f7204h;
    public final LocalStatsLoggerImpl f7205i;

    @Inject
    public UFIServicesHandler(Provider<SingleMethodRunner> provider, Lazy<ToggleLikeMethod> lazy, Lazy<SetNotifyMeMethod> lazy2, Lazy<DeleteCommentMethod> lazy3, Lazy<EditCommentMethod> lazy4, Lazy<DirectPhotoUploader> lazy5, Lazy<VideoUploader> lazy6, Lazy<UploadOperationFactory> lazy7, LocalStatsLogger localStatsLogger) {
        this.f7197a = provider;
        this.f7198b = lazy;
        this.f7199c = lazy2;
        this.f7200d = lazy3;
        this.f7201e = lazy4;
        this.f7202f = lazy5;
        this.f7203g = lazy6;
        this.f7204h = lazy7;
        this.f7205i = localStatsLogger;
    }

    public final OperationResult m10354a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        String str = operationParams.b;
        if ("feed_delete_comment".equals(str)) {
            ((AbstractSingleMethodRunner) this.f7197a.get()).a((ApiMethod) this.f7200d.get(), (DeleteCommentParams) operationParams.c.getParcelable("deleteCommentParams"));
            return OperationResult.a;
        } else if ("feed_toggle_like".equals(str) || "feed_toggle_page_like".equals(str)) {
            this.f7205i.a(7405571);
            return OperationResult.a(Boolean.toString(((Boolean) ((AbstractSingleMethodRunner) this.f7197a.get()).a((ApiMethod) this.f7198b.get(), (ToggleLikeParams) operationParams.c.getParcelable("toggleLikeParams"))).booleanValue()));
        } else if ("feed_set_notify_me".equals(str)) {
            SetNotifyMeParams setNotifyMeParams = (SetNotifyMeParams) operationParams.c.getParcelable("setNotifyMeParams");
            Boolean valueOf = Boolean.valueOf(false);
            Builder builder = new Builder(setNotifyMeParams);
            builder.e = setNotifyMeParams.c;
            ((AbstractSingleMethodRunner) this.f7197a.get()).a((ApiMethod) this.f7199c.get(), builder.g());
            return OperationResult.a(Boolean.toString(valueOf.booleanValue()));
        } else if ("feed_edit_comment".equals(str)) {
            ((AbstractSingleMethodRunner) this.f7197a.get()).a((ApiMethod) this.f7201e.get(), (EditCommentParams) operationParams.c.getParcelable("editCommentParams"));
            return OperationResult.a;
        } else if ("feed_add_photo".equals(str)) {
            return m10352e(operationParams);
        } else {
            if ("feed_add_video".equals(str)) {
                return m10353f(operationParams);
            }
            return blueServiceHandler.a(operationParams);
        }
    }

    private OperationResult m10352e(OperationParams operationParams) {
        AddPhotoAttachmentParams addPhotoAttachmentParams = (AddPhotoAttachmentParams) operationParams.c.getParcelable("addPhotoAttachmentParams");
        return OperationResult.a((String) Preconditions.checkNotNull(((DirectPhotoUploader) this.f7202f.get()).m21993a(addPhotoAttachmentParams.f7157a, addPhotoAttachmentParams.f7158b, "photo_comment_batch", addPhotoAttachmentParams.f7159c)));
    }

    private OperationResult m10353f(OperationParams operationParams) {
        AddPhotoAttachmentParams addPhotoAttachmentParams = (AddPhotoAttachmentParams) operationParams.c.getParcelable("addVideoAttachmentParams");
        UploadOperationFactory uploadOperationFactory = (UploadOperationFactory) this.f7204h.get();
        MediaItem mediaItem = addPhotoAttachmentParams.f7157a;
        String str = addPhotoAttachmentParams.f7158b;
        ViewerContext viewerContext = addPhotoAttachmentParams.f7159c;
        Bundle bundle = new Bundle();
        UploadOperation.Builder builder = new UploadOperation.Builder();
        builder.f13727b = ImmutableList.of(mediaItem);
        builder = builder;
        builder.f13728c = ImmutableList.of(bundle);
        UploadOperation.Builder builder2 = builder;
        builder2.f13726a = str;
        builder2 = builder2;
        builder2.f13743r = viewerContext;
        builder2 = builder2;
        builder2.f13742q = Type.COMMENT_VIDEO;
        builder2 = builder2;
        builder2.f13733h = "comment_video";
        builder = builder2;
        builder.f13732g = Long.parseLong((String) uploadOperationFactory.f13816a.get());
        builder2 = builder;
        builder2.f13700A = PublishMode.NORMAL;
        builder2 = builder2;
        builder2.f13741p = PublishMethod.VIDEO_TARGET;
        builder2 = builder2;
        builder2.f13740o = PhotoUploadPrivacy.f14021b;
        builder2 = builder2;
        builder2.f13748w = uploadOperationFactory.f13817b.a() / 1000;
        return ((VideoUploader) this.f7203g.get()).mo1157a(builder2.m21467a());
    }
}
