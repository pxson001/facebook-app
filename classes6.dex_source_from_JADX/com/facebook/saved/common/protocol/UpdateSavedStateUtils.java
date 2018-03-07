package com.facebook.saved.common.protocol;

import android.os.Bundle;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.inject.InjectorLike;
import com.facebook.saved.common.protocol.UpdateSavedStateParams.Builder;
import com.facebook.saved.common.protocol.UpdateSavedStateParams.SavedAction;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Optional;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Callables;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: setDescription */
public class UpdateSavedStateUtils {
    private static volatile UpdateSavedStateUtils f4865c;
    private final DefaultBlueServiceOperationFactory f4866a;
    private final TasksManager f4867b;

    public static com.facebook.saved.common.protocol.UpdateSavedStateUtils m7661a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4865c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.saved.common.protocol.UpdateSavedStateUtils.class;
        monitor-enter(r1);
        r0 = f4865c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m7663b(r0);	 Catch:{ all -> 0x0035 }
        f4865c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4865c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.saved.common.protocol.UpdateSavedStateUtils.a(com.facebook.inject.InjectorLike):com.facebook.saved.common.protocol.UpdateSavedStateUtils");
    }

    private static UpdateSavedStateUtils m7663b(InjectorLike injectorLike) {
        return new UpdateSavedStateUtils(DefaultBlueServiceOperationFactory.b(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public UpdateSavedStateUtils(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, TasksManager tasksManager) {
        this.f4866a = defaultBlueServiceOperationFactory;
        this.f4867b = tasksManager;
    }

    public final void m7665a(String str, CurationSurface curationSurface, CurationMechanism curationMechanism, OperationResultFutureCallback operationResultFutureCallback) {
        Builder builder = new Builder(SavedAction.ARCHIVE, curationSurface, curationMechanism, RegularImmutableList.a);
        builder.f4851c = Optional.of(str);
        m7662a(builder.m7660a(), operationResultFutureCallback);
    }

    public final void m7666b(String str, CurationSurface curationSurface, CurationMechanism curationMechanism, OperationResultFutureCallback operationResultFutureCallback) {
        Builder builder = new Builder(SavedAction.UNARCHIVE, curationSurface, curationMechanism, RegularImmutableList.a);
        builder.f4851c = Optional.of(str);
        m7662a(builder.m7660a(), operationResultFutureCallback);
    }

    public final void m7667c(String str, CurationSurface curationSurface, CurationMechanism curationMechanism, OperationResultFutureCallback operationResultFutureCallback) {
        Builder builder = new Builder(SavedAction.UNSAVE, curationSurface, curationMechanism, RegularImmutableList.a);
        builder.f4851c = Optional.of(str);
        m7662a(builder.m7660a(), operationResultFutureCallback);
    }

    public final void m7668d(String str, CurationSurface curationSurface, CurationMechanism curationMechanism, OperationResultFutureCallback operationResultFutureCallback) {
        Builder builder = new Builder(SavedAction.REMOVE_FROM_ARCHIVE, curationSurface, curationMechanism, RegularImmutableList.a);
        builder.f4851c = Optional.of(str);
        m7662a(builder.m7660a(), operationResultFutureCallback);
    }

    public final void m7669e(String str, CurationSurface curationSurface, CurationMechanism curationMechanism, OperationResultFutureCallback operationResultFutureCallback) {
        Builder builder = new Builder(SavedAction.SAVE, curationSurface, curationMechanism, RegularImmutableList.a);
        builder.f4850b = Optional.of(str);
        m7662a(builder.m7660a(), operationResultFutureCallback);
    }

    public final void m7670f(String str, CurationSurface curationSurface, CurationMechanism curationMechanism, OperationResultFutureCallback operationResultFutureCallback) {
        Builder builder = new Builder(SavedAction.UNSAVE, curationSurface, curationMechanism, RegularImmutableList.a);
        builder.f4850b = Optional.of(str);
        m7662a(builder.m7660a(), operationResultFutureCallback);
    }

    public final void m7664a(SavedAction savedAction, String str, CurationSurface curationSurface, CurationMechanism curationMechanism, OperationResultFutureCallback operationResultFutureCallback) {
        Builder builder = new Builder(savedAction, curationSurface, curationMechanism, RegularImmutableList.a);
        builder.f4851c = Optional.of(str);
        m7662a(builder.m7660a(), operationResultFutureCallback);
    }

    private void m7662a(UpdateSavedStateParams updateSavedStateParams, OperationResultFutureCallback operationResultFutureCallback) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("update_saved_state_params", updateSavedStateParams);
        this.f4867b.a("task_key_update_item_saved_state" + updateSavedStateParams.f4858b, Callables.a(BlueServiceOperationFactoryDetour.a(this.f4866a, "update_saved_state", bundle, 608193769).a()), operationResultFutureCallback);
    }
}
