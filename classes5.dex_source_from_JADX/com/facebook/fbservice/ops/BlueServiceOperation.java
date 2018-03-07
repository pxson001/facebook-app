package com.facebook.fbservice.ops;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.activity.FbServiceAwareActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.DefaultBlueService;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.IBlueService;
import com.facebook.fbservice.service.ICompletionHandler.Stub;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: review */
public class BlueServiceOperation {
    public static final Map<Object, String> f2993a = Maps.e();
    private static final Class<?> f2994b = BlueServiceOperation.class;
    private final Context f2995c;
    private final BlueServiceConnection f2996d;
    private final ExecutorService f2997e;
    private final ViewerContextManager f2998f;
    private final Context f2999g;
    private final DefaultProcessUtil f3000h;
    private Handler f3001i;
    public IBlueService f3002j;
    public OnCompletedListener f3003k;
    public OnProgressListener f3004l;
    public boolean f3005m;
    private boolean f3006n;
    public boolean f3007o;
    private DialogBasedProgressIndicator f3008p;
    public State f3009q = State.INIT;
    public String f3010r;
    public Bundle f3011s;
    public CallerContext f3012t;
    public String f3013u;
    private boolean f3014v;
    public boolean f3015w;
    public boolean f3016x;

    /* compiled from: review */
    public abstract class OnCompletedListener {
        public abstract void mo605a(OperationResult operationResult);

        public abstract void mo606a(ServiceException serviceException);
    }

    /* compiled from: review */
    public abstract class OnProgressListener {
        public abstract void mo607a(OperationResult operationResult);
    }

    /* compiled from: review */
    class C02131 extends Stub {
        final /* synthetic */ BlueServiceOperation f2989a;

        C02131(BlueServiceOperation blueServiceOperation) {
            this.f2989a = blueServiceOperation;
        }

        public final void m4168a(final OperationResult operationResult) {
            if (!this.f2989a.f3007o) {
                BlueServiceOperation.m4170a(this.f2989a, new Runnable(this) {
                    final /* synthetic */ C02131 f2988b;

                    public void run() {
                        if (!this.f2988b.f2989a.f3016x) {
                            BlueServiceOperation blueServiceOperation = this.f2988b.f2989a;
                            OperationResult operationResult = operationResult;
                            if (blueServiceOperation.f3004l != null) {
                                blueServiceOperation.f3004l.mo607a(operationResult);
                            }
                        }
                    }
                });
            }
        }

        public final void m4169b(OperationResult operationResult) {
            this.f2989a.m4171a(operationResult);
        }
    }

    /* compiled from: review */
    class BlueServiceConnection implements ServiceConnection {
        final /* synthetic */ BlueServiceOperation f2992a;

        public BlueServiceConnection(BlueServiceOperation blueServiceOperation) {
            this.f2992a = blueServiceOperation;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (!this.f2992a.f3016x) {
                this.f2992a.f3002j = IBlueService.Stub.a(iBinder);
                BlueServiceOperation.m4180g(this.f2992a);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f2992a.f3002j = null;
            this.f2992a.f3015w = false;
        }
    }

    /* compiled from: review */
    public enum State {
        INIT,
        READY_TO_QUEUE,
        OPERATION_QUEUED,
        COMPLETED
    }

    public static BlueServiceOperation m4173b(InjectorLike injectorLike) {
        return new BlueServiceOperation((Context) injectorLike.getInstance(Context.class), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ViewerContextManagerProvider.b(injectorLike), DefaultProcessUtil.a(injectorLike));
    }

    @Inject
    public BlueServiceOperation(Context context, ExecutorService executorService, ViewerContextManager viewerContextManager, DefaultProcessUtil defaultProcessUtil) {
        this.f2995c = context;
        this.f2996d = new BlueServiceConnection(this);
        this.f2997e = executorService;
        this.f2998f = viewerContextManager;
        this.f2999g = ContextUtils.a(context);
        this.f3000h = defaultProcessUtil;
    }

    public final void m4184a() {
        this.f3016x = true;
        m4178e();
        this.f3002j = null;
        this.f3004l = null;
        this.f3003k = null;
        m4183j();
    }

    public final void m4187b(Bundle bundle) {
        this.f3009q = (State) bundle.getSerializable("operationState");
        this.f3010r = bundle.getString("type");
        this.f3011s = (Bundle) bundle.getParcelable("param");
        this.f3012t = (CallerContext) bundle.getParcelable("callerContext");
        this.f3013u = bundle.getString("operationId");
        if (Looper.myLooper() != null) {
            this.f3001i = new Handler();
        }
        if (this.f3009q == State.INIT) {
            return;
        }
        if (this.f3009q == State.READY_TO_QUEUE) {
            m4182i();
            m4179f();
        } else if (this.f3009q == State.OPERATION_QUEUED) {
            m4182i();
            m4179f();
        } else {
            State state = State.COMPLETED;
        }
    }

    public static void m4175c(BlueServiceOperation blueServiceOperation, OperationResult operationResult) {
        if (operationResult.b) {
            blueServiceOperation.m4177d(operationResult);
        } else {
            blueServiceOperation.m4172a(new ServiceException(operationResult));
        }
    }

    public final void m4185a(DialogBasedProgressIndicator dialogBasedProgressIndicator) {
        if (this.f3009q == State.READY_TO_QUEUE || this.f3009q == State.OPERATION_QUEUED) {
            m4183j();
        }
        this.f3008p = dialogBasedProgressIndicator;
        if (this.f3009q == State.READY_TO_QUEUE || this.f3009q == State.OPERATION_QUEUED) {
            m4182i();
        }
    }

    private void m4176d() {
        boolean z = this.f3009q == State.INIT || this.f3009q == State.COMPLETED;
        Preconditions.checkState(z);
        this.f3009q = State.INIT;
        this.f3010r = null;
        this.f3011s = null;
        this.f3012t = null;
        this.f3013u = null;
        this.f3015w = false;
        m4178e();
        this.f3002j = null;
    }

    private void m4178e() {
        if (this.f3014v) {
            try {
                ServiceConnectionDetour.a(this.f2999g, this.f2996d, 1759318896);
            } catch (Throwable e) {
                BLog.c(f2994b, e, "Exception unbinding %s", new Object[]{this.f3010r});
            }
            this.f3014v = false;
        }
    }

    public final void m4186a(String str, Bundle bundle, CallerContext callerContext) {
        boolean z = true;
        Preconditions.checkState(this.f3009q == State.INIT, "Incorrect operation state");
        if (this.f3010r != null) {
            z = false;
        }
        Preconditions.checkState(z, "Initially operationType should be null");
        Preconditions.checkNotNull(str, "non-null operationType");
        this.f3009q = State.READY_TO_QUEUE;
        this.f3010r = str;
        this.f3011s = new Bundle(bundle);
        this.f3012t = callerContext;
        if (Looper.myLooper() != null) {
            this.f3001i = new Handler();
        }
        if (!this.f3011s.containsKey("overridden_viewer_context")) {
            ViewerContext b = this.f2998f.b();
            if (b != null) {
                this.f3011s.putParcelable("overridden_viewer_context", b);
            }
        }
        this.f3011s.putString("calling_process_name", this.f3000h.a().b);
        m4182i();
        m4179f();
    }

    private void m4179f() {
        if (this.f3002j != null) {
            m4180g(this);
        } else if (!this.f3014v) {
            if (ServiceConnectionDetour.a(this.f2999g, new Intent(this.f2995c, DefaultBlueService.class), this.f2996d, 1, -601822247)) {
                this.f3014v = true;
            } else {
                m4171a(OperationResult.a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "Bind to BlueService failed"));
            }
        }
    }

    public static void m4180g(BlueServiceOperation blueServiceOperation) {
        boolean z = true;
        if (blueServiceOperation.f3009q == State.READY_TO_QUEUE) {
            boolean z2;
            Preconditions.checkState(blueServiceOperation.f3010r != null, "Null operation type");
            if (blueServiceOperation.f3013u == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2, "Non-null operation id");
            if (blueServiceOperation.f3015w) {
                z = false;
            }
            Preconditions.checkState(z, "Registered for completion and haven't yet sent");
            try {
                blueServiceOperation.f3013u = blueServiceOperation.f3002j.a(blueServiceOperation.f3010r, blueServiceOperation.f3011s, false, blueServiceOperation.f3012t);
                if (blueServiceOperation.f3002j == null) {
                    throw new RemoteException();
                }
                blueServiceOperation.m4181h();
                blueServiceOperation.f3009q = State.OPERATION_QUEUED;
            } catch (RemoteException e) {
                blueServiceOperation.m4171a(OperationResult.a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "BlueService.<method> or registerCompletionHandler failed"));
            }
        } else if (blueServiceOperation.f3009q == State.OPERATION_QUEUED) {
            if (blueServiceOperation.f3013u == null) {
                z = false;
            }
            Preconditions.checkState(z, "null operation id");
            if (!blueServiceOperation.f3015w) {
                try {
                    blueServiceOperation.m4181h();
                } catch (RemoteException e2) {
                    blueServiceOperation.m4171a(OperationResult.a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "BlueService.registerCompletionHandler failed"));
                }
            }
        }
    }

    private void m4181h() {
        if (this.f3002j.a(this.f3013u, new C02131(this))) {
            this.f3015w = true;
        } else {
            m4171a(OperationResult.a(ErrorCode.ORCA_SERVICE_IPC_FAILURE, "Unknown operation: " + this.f3013u));
        }
    }

    private void m4171a(final OperationResult operationResult) {
        if (this.f3007o) {
            m4184a();
        } else {
            m4170a(this, new Runnable(this) {
                final /* synthetic */ BlueServiceOperation f2991b;

                public void run() {
                    if (!this.f2991b.f3016x) {
                        BlueServiceOperation.m4175c(this.f2991b, operationResult);
                    }
                }
            });
        }
    }

    public static void m4170a(BlueServiceOperation blueServiceOperation, Runnable runnable) {
        if (blueServiceOperation.f3001i != null) {
            HandlerDetour.a(blueServiceOperation.f3001i, runnable, 307589974);
        } else {
            ExecutorDetour.a(blueServiceOperation.f2997e, runnable, 1401584281);
        }
    }

    private void m4177d(OperationResult operationResult) {
        this.f3009q = State.COMPLETED;
        this.f3013u = null;
        m4183j();
        if (this.f3005m) {
            m4176d();
        }
        if (this.f3003k != null) {
            this.f3003k.mo605a(operationResult);
        }
        if (this.f3006n) {
            m4184a();
        }
    }

    private void m4172a(ServiceException serviceException) {
        boolean a;
        this.f3009q = State.COMPLETED;
        this.f3013u = null;
        m4183j();
        FbServiceAwareActivity fbServiceAwareActivity = (FbServiceAwareActivity) ContextUtils.a(this.f2995c, FbServiceAwareActivity.class);
        if (fbServiceAwareActivity != null) {
            a = fbServiceAwareActivity.a(serviceException);
        } else {
            a = false;
        }
        if (this.f3005m) {
            m4176d();
        }
        if (!(a || this.f3003k == null)) {
            this.f3003k.mo606a(serviceException);
        }
        if (this.f3006n) {
            m4184a();
        }
    }

    private void m4182i() {
        if (this.f3008p != null) {
            this.f3008p.m4189a();
        }
    }

    private void m4183j() {
        if (this.f3008p != null) {
            this.f3008p.m4190b();
        }
    }
}
