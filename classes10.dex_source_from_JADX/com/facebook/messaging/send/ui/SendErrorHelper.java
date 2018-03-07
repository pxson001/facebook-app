package com.facebook.messaging.send.ui;

import android.content.res.Resources;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.http.protocol.ApiException;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.VideoAttachmentData;
import com.facebook.messaging.media.upload.MediaItemUploadStatus;
import com.facebook.messaging.media.upload.MediaItemUploadStatus.Stage;
import com.facebook.messaging.media.upload.MediaItemUploadStatus.State;
import com.facebook.messaging.media.upload.MediaUploadManager;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.media.upload.MessageMediaUploadState.UploadState;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import javax.annotation.Nullable;
import org.apache.http.client.HttpResponseException;

/* compiled from: radius_meters */
public class SendErrorHelper {
    public final MessageClassifier f3989a;
    private final AttachmentDataFactory f3990b;
    private final AbstractFbErrorReporter f3991c;
    public final Resources f3992d;
    private final QeAccessor f3993e;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MediaUploadManager> f3994f = UltralightRuntime.b;

    /* compiled from: radius_meters */
    /* synthetic */ class C06011 {
        static final /* synthetic */ int[] f3988a = new int[SendErrorType.values().length];

        static {
            try {
                f3988a[SendErrorType.IO_EXCEPTION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3988a[SendErrorType.MEDIA_UPLOAD_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3988a[SendErrorType.HTTP_4XX_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public SendErrorHelper(MessageClassifier messageClassifier, AttachmentDataFactory attachmentDataFactory, AbstractFbErrorReporter abstractFbErrorReporter, Resources resources, QeAccessor qeAccessor) {
        this.f3989a = messageClassifier;
        this.f3990b = attachmentDataFactory;
        this.f3991c = abstractFbErrorReporter;
        this.f3992d = resources;
        this.f3993e = qeAccessor;
    }

    public final String m3719b(Message message) {
        if (message == null) {
            return null;
        }
        SendError sendError = message.w;
        if (sendError == null) {
            this.f3991c.a("ResendMessageDialogFragment_MISSING_SEND_ERROR", "null error");
            return null;
        } else if (!Strings.isNullOrEmpty(sendError.c)) {
            return sendError.c;
        } else {
            switch (C06011.f3988a[sendError.b.ordinal()]) {
                case 1:
                    return this.f3992d.getString(2131230759);
                case 2:
                    return m3714c(message);
                default:
                    return null;
            }
        }
    }

    private String m3714c(Message message) {
        if (((MediaUploadManagerImpl) this.f3994f.get()).b(message).b != UploadState.FAILED) {
            return null;
        }
        if (this.f3989a.a(message) == MessageClassification.VIDEO_CLIP) {
            return m3715e(message);
        }
        return m3716f(message);
    }

    private String m3715e(Message message) {
        VideoAttachmentData j = this.f3990b.j(message);
        if (j == null) {
            this.f3991c.a("ResendMessageDialogFragment_EXPECTED_VIDEO", "missing video");
            return null;
        }
        MediaItemUploadStatus c = ((MediaUploadManagerImpl) this.f3994f.get()).c(j.j);
        if (c.b != State.FAILED) {
            return null;
        }
        if (c.e == Stage.RESIZING) {
            return this.f3992d.getString(2131231741);
        }
        return c.e == Stage.UPLOADING ? m3712a(c.f) : null;
    }

    private String m3716f(Message message) {
        Preconditions.checkArgument(!ThreadKey.d(message.b));
        ImmutableList immutableList = message.t;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            MediaItemUploadStatus c = ((MediaUploadManagerImpl) this.f3994f.get()).c((MediaResource) immutableList.get(i));
            if (c.b == State.FAILED) {
                if (c.e == Stage.UPLOADING) {
                    return m3712a(c.f);
                }
                if (c.e == Stage.ENCRYPTING) {
                    return this.f3992d.getString(2131231748);
                }
            }
        }
        return null;
    }

    private String m3712a(Throwable th) {
        for (Throwable th2 : Throwables.getCausalChain(th)) {
            if (th2 instanceof ApiException) {
                return ((ApiException) th2).b().c();
            }
            if (th2 instanceof HttpResponseException) {
                int statusCode = ((HttpResponseException) th2).getStatusCode();
                if (statusCode >= 400 && statusCode < 500) {
                    return this.f3992d.getString(2131231739);
                }
            } else if (th2 instanceof IOException) {
                return this.f3992d.getString(2131230759);
            }
        }
        return this.f3992d.getString(2131231737);
    }

    public final String m3718a(int i, String str) {
        if (!m3713b()) {
            return str;
        }
        switch (i) {
            case 1404080:
            case 1404132:
                return this.f3992d.getString(2131231242);
            default:
                return str;
        }
    }

    @Nullable
    public final String m3717a(int i) {
        if (!m3713b()) {
            return null;
        }
        switch (i) {
            case 1404080:
            case 1404132:
                return "https://www.facebook.com/help/189165674568397";
            default:
                return null;
        }
    }

    private boolean m3713b() {
        return this.f3993e.a(ExperimentsForMessagingSendUiModule.f3971a, true);
    }
}
