package com.facebook.messaging.ephemeral;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.ModifyThreadParamsBuilder;
import com.facebook.orca.threadview.ephemeral.EphemeralToggleButtonHelper.1;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mStreet2 */
public class ModifyThreadEphemeralityHelper {
    public final DefaultBlueServiceOperationFactory f11031a;
    public final Context f11032b;
    public final Resources f11033c;
    private final TasksManager<ThreadKey> f11034d;
    public 1 f11035e;

    /* compiled from: mStreet2 */
    class C12222 implements FutureCallback<OperationResult> {
        final /* synthetic */ ModifyThreadEphemeralityHelper f11030a;

        C12222(ModifyThreadEphemeralityHelper modifyThreadEphemeralityHelper) {
            this.f11030a = modifyThreadEphemeralityHelper;
        }

        public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public void onFailure(Throwable th) {
            if (this.f11030a.f11035e != null) {
                this.f11030a.f11035e.a();
            }
            Toast.makeText(this.f11030a.f11032b, 2131231886, 1).show();
        }
    }

    public static ModifyThreadEphemeralityHelper m11443b(InjectorLike injectorLike) {
        return new ModifyThreadEphemeralityHelper(DefaultBlueServiceOperationFactory.b(injectorLike), (Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public ModifyThreadEphemeralityHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Context context, Resources resources, TasksManager tasksManager) {
        this.f11031a = defaultBlueServiceOperationFactory;
        this.f11032b = context;
        this.f11033c = resources;
        this.f11034d = tasksManager;
    }

    public final void m11445a(ThreadSummary threadSummary) {
        int i = ThreadKey.g(threadSummary.a) ? 10000 : 3600000;
        if (threadSummary.H != 0) {
            i = 0;
        }
        m11446b(threadSummary.a, i, threadSummary.H);
    }

    public final void m11444a(ThreadKey threadKey, int i, int i2) {
        m11442a(threadKey, i, i2, true);
    }

    public final void m11446b(ThreadKey threadKey, int i, int i2) {
        m11442a(threadKey, i, i2, false);
    }

    private void m11442a(ThreadKey threadKey, int i, int i2, final boolean z) {
        Preconditions.checkNotNull(threadKey);
        final Bundle bundle = new Bundle();
        ModifyThreadParamsBuilder modifyThreadParamsBuilder = new ModifyThreadParamsBuilder();
        modifyThreadParamsBuilder.f17237a = threadKey;
        modifyThreadParamsBuilder = modifyThreadParamsBuilder;
        modifyThreadParamsBuilder.f17250n = true;
        modifyThreadParamsBuilder = modifyThreadParamsBuilder;
        modifyThreadParamsBuilder.f17251o = i;
        modifyThreadParamsBuilder = modifyThreadParamsBuilder;
        modifyThreadParamsBuilder.f17252p = i2;
        bundle.putParcelable("modifyThreadParams", modifyThreadParamsBuilder.m17161q());
        this.f11034d.a(threadKey, new Callable<ListenableFuture<OperationResult>>(this) {
            final /* synthetic */ ModifyThreadEphemeralityHelper f11029c;

            public Object call() {
                Operation a = BlueServiceOperationFactoryDetour.a(this.f11029c.f11031a, "modify_thread", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(ModifyThreadEphemeralityHelper.class), -1993744243);
                if (z) {
                    a.a(new DialogBasedProgressIndicator(this.f11029c.f11032b, this.f11029c.f11033c.getString(2131231889)));
                }
                return a.a();
            }
        }, AbstractDisposableFutureCallback.a(new C12222(this)));
    }
}
