package com.facebook.composer.publish;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.FutureUtils;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.RetrySource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.FbResources;
import com.facebook.resources.impl.DownloadedFbResources;
import com.facebook.ui.toaster.ToastThreadUtil;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: placeAliases */
public class ComposerPublishService extends FbIntentService {
    private ComposerPublishServiceHelper f7944a;
    private ExecutorService f7945b;
    public ToastThreadUtil f7946c;
    private FbResources f7947d;

    private static <T extends Context> void m11500a(Class<T> cls, T t) {
        m11501a((Object) t, (Context) t);
    }

    public static void m11501a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ComposerPublishService) obj).m11502a((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ComposerPublishServiceHelper.m11547b(injectorLike), ToastThreadUtil.b(injectorLike), (FbResources) DownloadedFbResources.a(injectorLike));
    }

    public ComposerPublishService() {
        super("ComposerPublishService");
    }

    public static Intent m11498a(Context context, Intent intent) {
        return new Intent(context, ComposerPublishService.class).putExtras(intent);
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 992540752);
        super.onCreate();
        Class cls = ComposerPublishService.class;
        m11501a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -626299693, a);
    }

    @Inject
    private void m11502a(ExecutorService executorService, ComposerPublishServiceHelper composerPublishServiceHelper, ToastThreadUtil toastThreadUtil, FbResources fbResources) {
        this.f7945b = executorService;
        this.f7944a = composerPublishServiceHelper;
        this.f7946c = toastThreadUtil;
        this.f7947d = fbResources;
    }

    protected final void m11503a(Intent intent) {
        int i;
        final PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
        Builder builder = new Builder(publishPostParams);
        builder.ak = false;
        intent.putExtra("publishPostParams", builder.a());
        ListenableFuture c = this.f7944a.m11572c(intent);
        if (publishPostParams.isBackoutDraft) {
            i = 2131234774;
        } else if (publishPostParams.c() > 0) {
            i = 2131234705;
            publishPostParams.a(RetrySource.NOTIFICATION);
        } else {
            i = 2131234541;
        }
        this.f7946c.a(getString(i));
        Futures.a(c, new OperationResultFutureCallback(this) {
            final /* synthetic */ ComposerPublishService f7943b;

            protected final void m11496a(ServiceException serviceException) {
            }

            protected final void m11497a(Object obj) {
                if (publishPostParams.composerType != ComposerType.SHARE) {
                    this.f7943b.f7946c.a(this.f7943b.getString(2131234706));
                }
            }
        }, this.f7945b);
        FutureUtils.a(c);
    }

    public Resources getResources() {
        return this.f7947d != null ? this.f7947d : super.getResources();
    }
}
