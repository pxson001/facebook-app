package com.facebook.messaging.customthreads;

import android.os.Bundle;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.service.model.ModifyThreadParams;
import com.facebook.messaging.service.model.ModifyThreadParams.NicknamePair;
import com.facebook.messaging.service.model.ModifyThreadParamsBuilder;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mediaAttachments.totalSize */
public class ModifyThreadCustomizationHelper {
    private final DefaultBlueServiceOperationFactory f10321a;
    private final ExecutorService f10322b;

    /* compiled from: mediaAttachments.totalSize */
    public interface Listener {
        void m10908a();
    }

    public static ModifyThreadCustomizationHelper m10909a(InjectorLike injectorLike) {
        return new ModifyThreadCustomizationHelper(DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ModifyThreadCustomizationHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService) {
        this.f10321a = defaultBlueServiceOperationFactory;
        this.f10322b = executorService;
    }

    public final void m10911a(ThreadKey threadKey, ThreadCustomization threadCustomization, int i, @Nullable String str, Listener listener) {
        ModifyThreadParamsBuilder modifyThreadParamsBuilder = new ModifyThreadParamsBuilder();
        modifyThreadParamsBuilder.f17237a = threadKey;
        modifyThreadParamsBuilder = modifyThreadParamsBuilder;
        boolean z = true;
        modifyThreadParamsBuilder.f17245i = (i & 1) != 0;
        if ((i & 2) == 0) {
            z = false;
        }
        modifyThreadParamsBuilder.f17246j = z;
        modifyThreadParamsBuilder.f17248l = threadCustomization;
        modifyThreadParamsBuilder.f17249m = str;
        m10910a(modifyThreadParamsBuilder.m17161q(), listener);
    }

    public final void m10912a(ThreadKey threadKey, String str, String str2, @Nullable String str3, Listener listener) {
        ModifyThreadParamsBuilder modifyThreadParamsBuilder = new ModifyThreadParamsBuilder();
        modifyThreadParamsBuilder.f17237a = threadKey;
        modifyThreadParamsBuilder = modifyThreadParamsBuilder;
        modifyThreadParamsBuilder.f17247k = new NicknamePair(str, str2);
        modifyThreadParamsBuilder.f17249m = str3;
        m10910a(modifyThreadParamsBuilder.m17161q(), listener);
    }

    private void m10910a(ModifyThreadParams modifyThreadParams, final Listener listener) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("modifyThreadParams", modifyThreadParams);
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f10321a, "modify_thread", bundle, -1115203267).a(), new FutureCallback<OperationResult>(this) {
            final /* synthetic */ ModifyThreadCustomizationHelper f10320b;

            public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
            }

            public void onFailure(Throwable th) {
                if (listener != null && !(th instanceof CancellationException)) {
                    listener.m10908a();
                }
            }
        }, this.f10322b);
    }
}
