package com.facebook.photos.upload.manager;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.base.analytics.LoggingTypes.UploadMethodType;
import com.facebook.photos.base.analytics.PhotoFlowLogger$ExceptionReporter;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.upload.compost.CompostPendingPostStore;
import com.facebook.photos.upload.operation.UploadInterruptionCause;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.photos.upload.operation.UploadOperationHelper;
import com.facebook.photos.upload.operation.UploadRecords;
import com.facebook.photos.upload.serverprocessing.util.VideoProcessingUtil;
import com.facebook.photos.upload.uploaders.PartialUploadException;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.CancellationException;

/* compiled from: graph_search_results_page_app */
class UploadManager$3 implements FutureCallback<OperationResult> {
    final /* synthetic */ UploadOperation f13637a;
    final /* synthetic */ UploadOperation f13638b;
    final /* synthetic */ boolean f13639c;
    final /* synthetic */ UploadManager f13640d;

    UploadManager$3(UploadManager uploadManager, UploadOperation uploadOperation, UploadOperation uploadOperation2, boolean z) {
        this.f13640d = uploadManager;
        this.f13637a = uploadOperation;
        this.f13638b = uploadOperation2;
        this.f13639c = z;
    }

    public void onSuccess(Object obj) {
        OperationResult operationResult = (OperationResult) obj;
        GraphQLStory graphQLStory = null;
        try {
            Bundle bundle;
            if (UploadManager.p(this.f13640d)) {
                ((OptimisticVideoUploadHelper) this.f13640d.t.get()).m21367a(this.f13637a);
            }
            if (UploadManager.a) {
                new StringBuilder("Future.onSuccess() for ").append(this.f13637a.m21509N()).append(": ").append(operationResult.b()).append(", error: ").append(operationResult.c()).append(", ").append(operationResult.d());
            }
            this.f13637a.m21525a(null);
            this.f13637a.m21526a(null);
            UploadManager.l(this.f13640d, this.f13637a);
            try {
                bundle = (Bundle) operationResult.c("fbids");
            } catch (Throwable th) {
                ((AbstractFbErrorReporter) this.f13640d.m.get()).b("Upload success getResultDataParcelableNullOk (FBIDS)", th);
                bundle = null;
            }
            try {
                GraphQLStory graphQLStory2;
                Bundle bundle2 = (Bundle) operationResult.c("graphql_story");
                if (bundle2 != null) {
                    graphQLStory2 = (GraphQLStory) bundle2.getParcelable("graphql_story");
                } else {
                    graphQLStory2 = null;
                }
                graphQLStory = graphQLStory2;
            } catch (Throwable th2) {
                ((AbstractFbErrorReporter) this.f13640d.m.get()).b("Upload success getResultDataParcelableNullOk (GraphQLStory)", th2);
            }
            ((UploadNotificationManager) this.f13640d.c.get()).m21417a(this.f13637a, operationResult.f(), bundle, graphQLStory);
            if (UploadManager.k(this.f13640d) && (this.f13638b.m21510O() == Type.PROFILE_PIC || this.f13638b.m21510O() == Type.COVER_PHOTO)) {
                ((CompostPendingPostStore) this.f13640d.A.get()).mo928a(this.f13638b.m21509N());
            }
            if (VideoProcessingUtil.m21932a(this.f13640d.B)) {
                if (bundle != null) {
                    String string;
                    if (this.f13637a.m21520Y()) {
                        string = bundle.getString(((VideoItem) this.f13638b.m21548x().get(0)).e());
                    } else if (this.f13637a.m21521Z() || this.f13637a.aa()) {
                        string = operationResult.f();
                    } else {
                        return;
                    }
                    UploadManager.a(this.f13640d, this.f13637a, operationResult.f(), bundle, string);
                } else {
                    return;
                }
            }
            this.f13640d.b("Upload success retry");
            UploadManager.k(this.f13640d, this.f13637a);
        } catch (Throwable th22) {
            ((AbstractFbErrorReporter) this.f13640d.m.get()).b("UploadManager onSuccess throwable", th22);
        }
    }

    public void onFailure(Throwable th) {
        try {
            UploadOperation uploadOperation = (UploadOperation) this.f13640d.x.get(this.f13637a.m21509N());
            if (uploadOperation != null) {
                UploadManager.l(this.f13640d, this.f13637a);
                this.f13640d.a(uploadOperation, UploadManager$RequestType.UserRestart, "User requested upload restart");
                return;
            }
            UploadRecords uploadRecords;
            PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter;
            Throwable th2;
            Object obj;
            Object obj2;
            PhotoFlowLogger$ExceptionReporter t = this.f13637a.m21545t();
            this.f13637a.m21525a(null);
            this.f13637a.m21526a(null);
            if (this.f13639c) {
                this.f13637a.m21533c(this.f13640d.l.a());
            }
            if (th == null) {
                uploadRecords = null;
                photoFlowLogger$ExceptionReporter = null;
                th2 = new Throwable("null");
            } else if (th instanceof ServiceException) {
                UploadRecords uploadRecords2;
                UploadInterruptionCause uploadInterruptionCause;
                Parcelable parcelable = (Parcelable) ((ServiceException) th).b().k();
                if (parcelable == null || !(parcelable instanceof Bundle)) {
                    uploadRecords2 = null;
                    uploadInterruptionCause = null;
                } else {
                    Bundle bundle = (Bundle) parcelable;
                    uploadInterruptionCause = PartialUploadException.m22037a(bundle);
                    uploadRecords2 = PartialUploadException.m22038b(bundle);
                }
                uploadRecords = uploadRecords2;
                r9 = uploadInterruptionCause;
                th2 = th;
            } else if (th instanceof PartialUploadException) {
                PartialUploadException partialUploadException = (PartialUploadException) th;
                uploadRecords = partialUploadException.m22041c();
                r9 = partialUploadException.m22040b();
                th2 = th;
            } else {
                uploadRecords = null;
                photoFlowLogger$ExceptionReporter = null;
                th2 = th;
            }
            this.f13637a.m21525a((UploadInterruptionCause) photoFlowLogger$ExceptionReporter);
            this.f13637a.m21526a(uploadRecords);
            if (!(photoFlowLogger$ExceptionReporter == null || photoFlowLogger$ExceptionReporter.m21444a())) {
                this.f13637a.m21544s();
            }
            if (photoFlowLogger$ExceptionReporter == null || !photoFlowLogger$ExceptionReporter.m21451h()) {
                int i = 1;
            } else {
                this.f13637a.af();
                obj = null;
            }
            if (UploadManager.a) {
                this.f13637a.m21509N();
                th2.toString();
            }
            if ((th2 instanceof CancellationException) || ((th2 instanceof ServiceException) && ((ServiceException) th2).a() == ErrorCode.CANCELLED)) {
                boolean contains;
                ((UploadNotificationManager) this.f13640d.c.get()).m21420c(this.f13637a);
                synchronized (this) {
                    contains = this.f13640d.z.contains(this.f13637a.m21509N());
                }
                if (!(contains || this.f13637a.ar())) {
                    DefaultPhotoFlowLogger d = ((UploadOperationHelper) this.f13640d.e.get()).m21588d(this.f13637a);
                    if (this.f13637a.an()) {
                        d.m19916b(d.m19837a("2.1", UploadMethodType.CHUNKED), this.f13637a);
                    } else {
                        d.m19898a("2.0", this.f13637a.m21522a(), this.f13640d.g(this.f13637a), this.f13637a, t, this.f13640d.l.a() - this.f13637a.ae());
                    }
                }
            } else {
                if (photoFlowLogger$ExceptionReporter == null || uploadRecords == null) {
                    ((AbstractFbErrorReporter) this.f13640d.m.get()).b("UploadManager", "Missing UploadInterruptionCause", th2);
                    photoFlowLogger$ExceptionReporter = new UploadInterruptionCause(new ExceptionInterpreter(new RuntimeException("Missing UploadInterruptionCause", th2)));
                    this.f13637a.m21525a((UploadInterruptionCause) photoFlowLogger$ExceptionReporter);
                    this.f13637a.m21526a(new UploadRecords(Maps.c()));
                }
                if (!(photoFlowLogger$ExceptionReporter.m21451h() || this.f13637a.ar())) {
                    ((UploadOperationHelper) this.f13640d.e.get()).m21588d(this.f13637a).m19894a("2.0", this.f13637a.m21522a(), this.f13640d.g(this.f13637a), this.f13637a, uploadRecords.m21600a().size(), photoFlowLogger$ExceptionReporter, this.f13640d.l.a() - this.f13637a.ae());
                }
                UploadManager.m(this.f13640d, this.f13637a);
            }
            if (UploadManager.p(this.f13640d) && this.f13637a.m21520Y()) {
                uploadOperation = ((OptimisticVideoUploadHelper) this.f13640d.t.get()).m21370b(this.f13637a.m21509N());
                if (uploadOperation != null) {
                    this.f13640d.t.get();
                    if (!OptimisticVideoUploadHelper.m21364a(this.f13637a, uploadOperation)) {
                        obj2 = null;
                        if (obj2 != null) {
                            UploadManager.l(this.f13640d, this.f13637a);
                            if (this.f13637a.m21541i()) {
                                this.f13640d.c("Upload failed retry");
                            } else {
                                this.f13640d.h.a(this.f13640d);
                            }
                            if (obj != null) {
                                UploadManager.k(this.f13640d, this.f13637a);
                            }
                        }
                    }
                }
            }
            int i2 = 1;
            if (obj2 != null) {
                UploadManager.l(this.f13640d, this.f13637a);
                if (this.f13637a.m21541i()) {
                    this.f13640d.c("Upload failed retry");
                } else {
                    this.f13640d.h.a(this.f13640d);
                }
                if (obj != null) {
                    UploadManager.k(this.f13640d, this.f13637a);
                }
            }
        } catch (Throwable th3) {
            ((AbstractFbErrorReporter) this.f13640d.m.get()).b("UploadManager onFailure throwable", th3);
        }
    }
}
