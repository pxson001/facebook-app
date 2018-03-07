package com.facebook.fbservice.ops;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.activity.FbServiceAwareActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.service.ContextServiceBinder;
import com.facebook.base.service.DefaultContextServiceBinder;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.dispose.AbstractListenableDisposable;
import com.facebook.common.dispose.DisposableContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.process.ProcessUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OnProgressListener;
import com.facebook.fbservice.service.BlueServiceLogic;
import com.facebook.fbservice.service.DefaultBlueService;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.IBlueService;
import com.facebook.fbservice.service.IBlueService.Stub;
import com.facebook.fbservice.service.ICompletionHandler;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: follow_videos_nux_history */
public class DefaultBlueServiceOperation implements BlueServiceOperationFactory$Operation {
    public static final Map<Object, String> f23538a = Maps.m843e();
    @GuardedBy("itself")
    private static final Map<ComponentName, Boolean> f23539b = Maps.m838c();
    private AbstractListenableDisposable f23540A;
    private TriState f23541B = TriState.UNSET;
    public final Context f23542c;
    private final PackageManager f23543d;
    private final Lazy<BlueServiceLogic> f23544e;
    private final ExecutorService f23545f;
    private final ViewerContextManager f23546g;
    private final DefaultProcessUtil f23547h;
    private final DefaultContextServiceBinder f23548i;
    private final AbstractFbErrorReporter f23549j;
    private final CriticalServiceExceptionChecker f23550k;
    public final BaseFbBroadcastManager f23551l;
    private final BlueServiceConnection f23552m;
    public final DefaultOperationFuture f23553n;
    private final String f23554o;
    private final Bundle f23555p;
    private final ErrorPropagation f23556q;
    private final CallerContext f23557r;
    public Handler f23558s;
    private IBlueService f23559t;
    private boolean f23560u;
    private DialogBasedProgressIndicator f23561v;
    public OnProgressListener f23562w;
    private State f23563x = State.INIT;
    private String f23564y;
    private boolean f23565z;

    /* compiled from: follow_videos_nux_history */
    public enum State {
        INIT,
        READY_TO_QUEUE,
        OPERATION_QUEUED,
        COMPLETED
    }

    /* compiled from: follow_videos_nux_history */
    class BlueServiceConnection implements ServiceConnection {
        final /* synthetic */ DefaultBlueServiceOperation f23566a;

        public BlueServiceConnection(DefaultBlueServiceOperation defaultBlueServiceOperation) {
            this.f23566a = defaultBlueServiceOperation;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f23566a.m31883a(Stub.m32049a(iBinder));
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f23566a.m31894i();
        }
    }

    /* compiled from: follow_videos_nux_history */
    public class DefaultOperationFuture extends BlueServiceOperationFactory$OperationFuture {
        final /* synthetic */ DefaultBlueServiceOperation f23567a;

        public DefaultOperationFuture(DefaultBlueServiceOperation defaultBlueServiceOperation) {
            this.f23567a = defaultBlueServiceOperation;
        }

        public Object get(long j, TimeUnit timeUnit) {
            m31895h();
            return (OperationResult) super.get(j, timeUnit);
        }

        public Object get() {
            m31895h();
            return (OperationResult) super.get();
        }

        private void m31895h() {
            boolean z = false;
            if (!isDone()) {
                boolean z2;
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkState(z2, "Cannot call get on main thread for unfinished operation");
                if (this.f23567a.f23558s == null || this.f23567a.f23558s.getLooper() != Looper.myLooper()) {
                    z = true;
                }
                Preconditions.checkState(z, "Cannot call get on the operation's handler thread for unfinished operation");
            }
        }

        public final boolean m31898a(@Nullable OperationResult operationResult) {
            return super.mo221a((Object) operationResult);
        }

        public final boolean mo222a(Throwable th) {
            return super.mo222a(th);
        }

        protected final void mo2679a() {
            if (!isDone()) {
                try {
                    this.f23567a.m31893h();
                } catch (Throwable e) {
                    BLog.a("DefaultBlueServiceOperation", "Could not cancel operation", e);
                }
            }
        }

        public final boolean mo3458f() {
            if (isDone()) {
                return false;
            }
            try {
                if (!this.f23567a.m31893h()) {
                    return false;
                }
                super.cancel(false);
                return true;
            } catch (Throwable e) {
                BLog.a("DefaultBlueServiceOperation", "Could not cancel operation", e);
                return false;
            }
        }

        public final void mo2693a(RequestPriority requestPriority) {
            if (!isDone()) {
                this.f23567a.m31885a(requestPriority);
            }
        }
    }

    /* compiled from: follow_videos_nux_history */
    class C09651 extends AbstractListenableDisposable {
        final /* synthetic */ DefaultBlueServiceOperation f23568a;

        C09651(DefaultBlueServiceOperation defaultBlueServiceOperation) {
            this.f23568a = defaultBlueServiceOperation;
        }

        protected final void mo3461b() {
            DefaultBlueServiceOperation.m31876n(this.f23568a);
        }
    }

    /* compiled from: follow_videos_nux_history */
    class C09693 extends ICompletionHandler.Stub {
        final /* synthetic */ DefaultBlueServiceOperation f23657a;

        C09693(DefaultBlueServiceOperation defaultBlueServiceOperation) {
            this.f23657a = defaultBlueServiceOperation;
        }

        public final void mo3503a(OperationResult operationResult) {
            this.f23657a.m31884a(operationResult);
        }

        public final void mo3504b(OperationResult operationResult) {
            this.f23657a.m31887b(operationResult);
        }
    }

    @Inject
    DefaultBlueServiceOperation(Context context, PackageManager packageManager, Lazy<BlueServiceLogic> lazy, ExecutorService executorService, ProcessUtil processUtil, ContextServiceBinder contextServiceBinder, FbErrorReporter fbErrorReporter, @Assisted String str, @Assisted Bundle bundle, @Assisted ErrorPropagation errorPropagation, @Nullable @Assisted CallerContext callerContext, @Assisted ViewerContextManager viewerContextManager, CriticalServiceExceptionChecker criticalServiceExceptionChecker, FbBroadcastManager fbBroadcastManager) {
        this.f23542c = context;
        this.f23543d = packageManager;
        this.f23552m = new BlueServiceConnection(this);
        this.f23544e = lazy;
        this.f23545f = executorService;
        this.f23553n = new DefaultOperationFuture(this);
        this.f23547h = processUtil;
        this.f23548i = contextServiceBinder;
        this.f23549j = fbErrorReporter;
        this.f23554o = (String) Preconditions.checkNotNull(str);
        this.f23555p = new Bundle((Bundle) Preconditions.checkNotNull(bundle));
        this.f23556q = errorPropagation;
        this.f23557r = callerContext;
        this.f23546g = viewerContextManager;
        this.f23540A = new C09651(this);
        this.f23550k = criticalServiceExceptionChecker;
        this.f23551l = fbBroadcastManager;
        if (!this.f23555p.containsKey("overridden_viewer_context")) {
            Parcelable e = this.f23546g.mo218e();
            if (e != null) {
                this.f23555p.putParcelable("overridden_viewer_context", e);
            }
        }
        this.f23555p.putString("calling_process_name", processUtil.m2389a().b());
        DisposableContext disposableContext = (DisposableContext) ContextUtils.m2500a(context, DisposableContext.class);
        if (disposableContext != null) {
            disposableContext.mo821a(this.f23540A);
        }
    }

    public final void mo3455d() {
        this.f23540A.jc_();
    }

    public final boolean m31892g() {
        return this.f23540A.ba_();
    }

    public final String mo3456e() {
        return this.f23554o;
    }

    public final Bundle mo3457f() {
        return new Bundle(this.f23555p);
    }

    public final BlueServiceOperationFactory$Operation mo3450a(DialogBasedProgressIndicator dialogBasedProgressIndicator) {
        if (this.f23563x == State.READY_TO_QUEUE || this.f23563x == State.OPERATION_QUEUED) {
            m31878p();
        }
        this.f23561v = dialogBasedProgressIndicator;
        if (this.f23563x == State.READY_TO_QUEUE || this.f23563x == State.OPERATION_QUEUED) {
            m31877o();
        }
        return this;
    }

    public final BlueServiceOperationFactory$Operation mo3449a(OnProgressListener onProgressListener) {
        this.f23562w = onProgressListener;
        return this;
    }

    public final BlueServiceOperationFactory$Operation mo3451a(boolean z) {
        this.f23560u = z;
        return this;
    }

    public final BlueServiceOperationFactory$OperationFuture mo3452a() {
        return m31867b(true);
    }

    public final BlueServiceOperationFactory$OperationFuture mo3453b() {
        return m31867b(false);
    }

    private BlueServiceOperationFactory$OperationFuture m31867b(boolean z) {
        boolean z2 = true;
        Preconditions.checkState(this.f23563x == State.INIT, "Incorrect operation state");
        this.f23563x = State.READY_TO_QUEUE;
        if (Looper.myLooper() != null) {
            this.f23558s = new Handler();
        }
        m31877o();
        if (z) {
            z2 = false;
        }
        m31869c(this, z2);
        return this.f23553n;
    }

    public final BlueServiceOperationFactory$OperationFuture mo3454c() {
        Preconditions.checkState(this.f23563x == State.INIT, "Incorrect operation state");
        this.f23563x = State.READY_TO_QUEUE;
        this.f23558s = new Handler(Looper.getMainLooper());
        m31877o();
        m31866a(new 2(this));
        return this.f23553n;
    }

    public final boolean m31893h() {
        IBlueService iBlueService = this.f23559t;
        String str = this.f23564y;
        if (iBlueService == null || str == null) {
            return false;
        }
        return iBlueService.mo3500a(str);
    }

    public final boolean m31885a(RequestPriority requestPriority) {
        boolean z = false;
        try {
            IBlueService iBlueService = this.f23559t;
            String str = this.f23564y;
            if (!(iBlueService == null || str == null)) {
                z = iBlueService.mo3502a(str, requestPriority);
            }
        } catch (Throwable e) {
            BLog.b("DefaultBlueServiceOperation", e, "Cannot changePriority because of a RemoteException.", new Object[0]);
        }
        return z;
    }

    public static void m31869c(DefaultBlueServiceOperation defaultBlueServiceOperation, boolean z) {
        if (!defaultBlueServiceOperation.m31892g() && defaultBlueServiceOperation.f23563x == State.READY_TO_QUEUE) {
            Intent intent = new Intent(defaultBlueServiceOperation.f23542c, DefaultBlueService.class);
            if (!z || defaultBlueServiceOperation.m31868b(intent)) {
                defaultBlueServiceOperation.f23541B = TriState.NO;
                defaultBlueServiceOperation.m31865a(intent);
                return;
            }
            defaultBlueServiceOperation.f23541B = TriState.YES;
            defaultBlueServiceOperation.m31872j();
        }
    }

    private void m31865a(Intent intent) {
        try {
            if (this.f23548i.m22163a(intent, this.f23552m, 1)) {
                this.f23565z = true;
            } else {
                m31887b(OperationResult.m30113a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "Bind to BlueService failed"));
            }
        } catch (Throwable e) {
            throw new RuntimeException("Binding BlueService for `" + this.f23554o.toString() + "` threw an exception.", e);
        }
    }

    private void m31872j() {
        this.f23559t = (IBlueService) this.f23544e.get();
        m31874l();
    }

    private void m31873k() {
        if (this.f23565z) {
            try {
                this.f23548i.m22162a(this.f23552m);
            } catch (IllegalArgumentException e) {
                new Object[1][0] = this.f23554o;
            }
            this.f23565z = false;
        }
    }

    private boolean m31868b(Intent intent) {
        Preconditions.checkState(intent.getComponent() != null, "Bind intent must specify a component");
        Preconditions.checkState(this.f23542c.getPackageName().equals(intent.getComponent().getPackageName()), "We can currently only bind to a BlueService that is part of our package.");
        return m31870c(intent);
    }

    private boolean m31870c(Intent intent) {
        boolean z;
        synchronized (f23539b) {
            Boolean bool = (Boolean) f23539b.get(intent.getComponent());
            if (bool == null) {
                ResolveInfo resolveService = this.f23543d.resolveService(intent, 0);
                if (resolveService == null) {
                    throw new IllegalStateException("Can't bind to service specified by " + intent);
                }
                String b = this.f23547h.m2389a().b();
                String str = resolveService.serviceInfo.processName;
                if (b == null || !b.equals(str)) {
                    z = false;
                } else {
                    z = true;
                }
                bool = Boolean.valueOf(z);
                f23539b.put(intent.getComponent(), bool);
            }
            if (bool.booleanValue()) {
                z = false;
            } else {
                z = true;
            }
        }
        return z;
    }

    @VisibleForTesting
    final void m31883a(IBlueService iBlueService) {
        if (!m31892g()) {
            this.f23559t = iBlueService;
            m31874l();
        }
    }

    @VisibleForTesting
    final void m31894i() {
        this.f23559t = null;
        if (this.f23563x == State.OPERATION_QUEUED) {
            m31887b(OperationResult.m30113a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "BlueService disconnected"));
        }
    }

    private void m31874l() {
        if (this.f23563x == State.READY_TO_QUEUE) {
            boolean z;
            Preconditions.checkState(this.f23554o != null, "Null operation type");
            if (this.f23564y == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Non-null operation id");
            try {
                boolean z2;
                if (this.f23556q == ErrorPropagation.BY_EXCEPTION) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f23564y = this.f23559t.mo3499a(this.f23554o, this.f23555p, z2, m31875m(), this.f23557r);
                if (this.f23559t == null) {
                    throw new RemoteException();
                }
                this.f23563x = State.OPERATION_QUEUED;
                return;
            } catch (RemoteException e) {
                m31887b(OperationResult.m30113a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "BlueService.startOperationWithCompletionHandler failed"));
                return;
            }
        }
        this.f23549j.m2340a("DefaultBlueServiceOperation_START_AND_REGISTER_CALLED_UNEXPECTINGLY", "maybeStartAndRegister called in wrong state. triedBindingLocally=" + this.f23541B + ", state=" + this.f23563x + ", operationType=" + this.f23554o);
    }

    private ICompletionHandler m31875m() {
        return new C09693(this);
    }

    @VisibleForTesting
    final void m31884a(OperationResult operationResult) {
        if (!m31892g() && !this.f23560u) {
            m31866a(new 4(this, operationResult));
        }
    }

    @VisibleForTesting
    final void m31887b(final OperationResult operationResult) {
        if (!m31892g() && this.f23563x != State.COMPLETED) {
            this.f23563x = State.COMPLETED;
            this.f23564y = null;
            m31873k();
            if (this.f23560u) {
                mo3455d();
            } else {
                m31866a(new Runnable(this) {
                    final /* synthetic */ DefaultBlueServiceOperation f23817b;

                    public void run() {
                        if (!this.f23817b.m31892g()) {
                            DefaultBlueServiceOperation.m31871d(this.f23817b, operationResult);
                        }
                    }
                });
            }
        }
    }

    public static void m31876n(DefaultBlueServiceOperation defaultBlueServiceOperation) {
        defaultBlueServiceOperation.f23563x = State.COMPLETED;
        defaultBlueServiceOperation.f23564y = null;
        defaultBlueServiceOperation.m31873k();
        defaultBlueServiceOperation.f23559t = null;
        defaultBlueServiceOperation.m31878p();
        defaultBlueServiceOperation.f23553n.cancel(false);
    }

    public static void m31871d(DefaultBlueServiceOperation defaultBlueServiceOperation, OperationResult operationResult) {
        defaultBlueServiceOperation.m31878p();
        if (operationResult.f22220b) {
            defaultBlueServiceOperation.f23553n.m31898a(operationResult);
        } else {
            Throwable serviceException;
            boolean a;
            if (defaultBlueServiceOperation.f23556q != ErrorPropagation.BY_EXCEPTION || operationResult.f22225g == null) {
                serviceException = new ServiceException(operationResult);
            } else {
                serviceException = operationResult.f22225g;
            }
            FbServiceAwareActivity fbServiceAwareActivity = (FbServiceAwareActivity) ContextUtils.m2500a(defaultBlueServiceOperation.f23542c, FbServiceAwareActivity.class);
            if (fbServiceAwareActivity != null) {
                a = fbServiceAwareActivity.mo823a(serviceException);
            } else {
                if (CriticalServiceExceptionChecker.m6536a(serviceException)) {
                    defaultBlueServiceOperation.f23551l.mo406a(new Intent("BLUESERVICE_NO_AUTH"));
                }
                a = false;
            }
            if (!a) {
                defaultBlueServiceOperation.f23553n.mo222a(serviceException);
            }
        }
        defaultBlueServiceOperation.mo3455d();
    }

    private void m31877o() {
        if (this.f23561v != null) {
            this.f23561v.a();
        }
    }

    private void m31878p() {
        if (this.f23561v != null) {
            this.f23561v.b();
        }
    }

    private void m31866a(Runnable runnable) {
        if (this.f23558s != null) {
            HandlerDetour.a(this.f23558s, runnable, -1622907416);
        } else {
            ExecutorDetour.a(this.f23545f, runnable, -755389073);
        }
    }
}
