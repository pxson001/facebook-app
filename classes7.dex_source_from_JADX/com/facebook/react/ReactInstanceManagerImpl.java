package com.facebook.react;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactInstanceManager.ReactInstanceEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSCJavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutor.Factory;
import com.facebook.react.bridge.JavaScriptModuleRegistry;
import com.facebook.react.bridge.MemoryPressureListener;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.NativeModuleRegistry.Builder;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.ApplicationHolder;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.devsupport.DevSupportManager;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.ReactInstanceDevCommandsHandler;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.AppRegistry;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.Systrace;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

/* compiled from: hardwareBackPress */
public class ReactInstanceManagerImpl extends ReactInstanceManager {
    private final List<ReactRootView> f11381a = new ArrayList();
    private LifecycleState f11382b;
    @Nullable
    public ReactContextInitParams f11383c;
    @Nullable
    private ReactContextInitAsyncTask f11384d;
    @Nullable
    private String f11385e;
    @Nullable
    private final String f11386f;
    private final List<ReactPackage> f11387g;
    public final DevSupportManager f11388h;
    private final boolean f11389i;
    @Nullable
    private final NotThreadSafeBridgeIdleDebugListener f11390j;
    @Nullable
    public volatile ReactContext f11391k;
    private final Context f11392l;
    @Nullable
    private DefaultHardwareBackBtnHandler f11393m;
    private String f11394n;
    @Nullable
    private Activity f11395o;
    private final Collection<ReactInstanceEventListener> f11396p = Collections.synchronizedSet(new HashSet());
    private volatile boolean f11397q = false;
    private final UIImplementationProvider f11398r;
    public final MemoryPressureRouter f11399s;
    @Nullable
    private final NativeModuleCallExceptionHandler f11400t;
    @Nullable
    public final JSCConfig f11401u;
    private final ReactInstanceDevCommandsHandler f11402v = new C10001(this);
    private final DefaultHardwareBackBtnHandler f11403w = new C10012(this);

    /* compiled from: hardwareBackPress */
    class C10001 implements ReactInstanceDevCommandsHandler {
        final /* synthetic */ ReactInstanceManagerImpl f11369a;

        C10001(ReactInstanceManagerImpl reactInstanceManagerImpl) {
            this.f11369a = reactInstanceManagerImpl;
        }
    }

    /* compiled from: hardwareBackPress */
    class C10012 implements DefaultHardwareBackBtnHandler {
        final /* synthetic */ ReactInstanceManagerImpl f11370a;

        C10012(ReactInstanceManagerImpl reactInstanceManagerImpl) {
            this.f11370a = reactInstanceManagerImpl;
        }

        public final void mo164a() {
            ReactInstanceManagerImpl.m13297n(this.f11370a);
        }
    }

    /* compiled from: hardwareBackPress */
    class C10023 {
        final /* synthetic */ ReactInstanceManagerImpl f11371a;

        C10023(ReactInstanceManagerImpl reactInstanceManagerImpl) {
            this.f11371a = reactInstanceManagerImpl;
        }
    }

    /* compiled from: hardwareBackPress */
    final class ReactContextInitAsyncTask extends AsyncTask<ReactContextInitParams, Void, Result<ReactApplicationContext>> {
        final /* synthetic */ ReactInstanceManagerImpl f11375a;

        public ReactContextInitAsyncTask(ReactInstanceManagerImpl reactInstanceManagerImpl) {
            this.f11375a = reactInstanceManagerImpl;
        }

        protected final Object doInBackground(Object[] objArr) {
            ReactContextInitParams[] reactContextInitParamsArr = (ReactContextInitParams[]) objArr;
            boolean z = false;
            if (!(reactContextInitParamsArr == null || reactContextInitParamsArr.length <= 0 || reactContextInitParamsArr[0] == null)) {
                z = true;
            }
            Assertions.a(z);
            try {
                return Result.m13271a(this.f11375a.m13276a(reactContextInitParamsArr[0].m13268a().mo662a(this.f11375a.f11401u == null ? new WritableNativeMap() : this.f11375a.f11401u.m13230a()), reactContextInitParamsArr[0].m13269b()));
            } catch (Exception e) {
                return Result.m13270a(e);
            }
        }

        protected final void onCancelled(Object obj) {
            try {
                this.f11375a.f11399s.m13234a((Context) ((Result) obj).m13272a());
            } catch (Throwable e) {
                FLog.a("React", "Caught exception after cancelling react context init", e);
            } finally {
                this.f11375a.f11384d = null;
            }
        }

        protected final void onPostExecute(Object obj) {
            try {
                ReactInstanceManagerImpl.m13289b(this.f11375a, (ReactApplicationContext) ((Result) obj).m13272a());
            } catch (Exception e) {
                this.f11375a.f11388h.a(e);
            } finally {
                this.f11375a.f11384d = null;
            }
            if (this.f11375a.f11383c != null) {
                this.f11375a.m13284a(this.f11375a.f11383c.m13268a(), this.f11375a.f11383c.m13269b());
                this.f11375a.f11383c = null;
            }
        }

        protected final void onPreExecute() {
            if (this.f11375a.f11391k != null) {
                this.f11375a.m13285a(this.f11375a.f11391k);
                this.f11375a.f11391k = null;
            }
        }
    }

    /* compiled from: hardwareBackPress */
    class ReactContextInitParams {
        final /* synthetic */ ReactInstanceManagerImpl f11376a;
        private final Factory f11377b;
        private final JSBundleLoader f11378c;

        public ReactContextInitParams(ReactInstanceManagerImpl reactInstanceManagerImpl, Factory factory, JSBundleLoader jSBundleLoader) {
            this.f11376a = reactInstanceManagerImpl;
            this.f11377b = (Factory) Assertions.b(factory);
            this.f11378c = (JSBundleLoader) Assertions.b(jSBundleLoader);
        }

        public final Factory m13268a() {
            return this.f11377b;
        }

        public final JSBundleLoader m13269b() {
            return this.f11378c;
        }
    }

    /* compiled from: hardwareBackPress */
    class Result<T> {
        @Nullable
        private final T f11379a;
        @Nullable
        private final Exception f11380b;

        public static <T, U extends T> Result<T> m13271a(U u) {
            return new Result((Object) u);
        }

        public static <T> Result<T> m13270a(Exception exception) {
            return new Result(exception);
        }

        private Result(T t) {
            this.f11380b = null;
            this.f11379a = t;
        }

        private Result(Exception exception) {
            this.f11380b = exception;
            this.f11379a = null;
        }

        public final T m13272a() {
            if (this.f11380b != null) {
                throw this.f11380b;
            }
            Assertions.b(this.f11379a);
            return this.f11379a;
        }
    }

    ReactInstanceManagerImpl(Context context, @Nullable Activity activity, @Nullable DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, @Nullable String str, @Nullable String str2, List<ReactPackage> list, boolean z, @Nullable NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener, LifecycleState lifecycleState, UIImplementationProvider uIImplementationProvider, NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler, @Nullable JSCConfig jSCConfig) {
        m13277a(context);
        ApplicationHolder.f11578a = (Application) context.getApplicationContext();
        DisplayMetricsHolder.m13806a(context);
        this.f11392l = context;
        this.f11395o = activity;
        this.f11393m = defaultHardwareBackBtnHandler;
        this.f11385e = str;
        this.f11386f = str2;
        this.f11387g = list;
        this.f11389i = z;
        this.f11388h = DevSupportManagerFactory.m13685a(context, this.f11402v, this.f11386f, z);
        this.f11390j = notThreadSafeBridgeIdleDebugListener;
        this.f11382b = lifecycleState;
        this.f11398r = uIImplementationProvider;
        this.f11399s = new MemoryPressureRouter(context);
        this.f11400t = nativeModuleCallExceptionHandler;
        this.f11401u = jSCConfig;
    }

    public final DevSupportManager mo621a() {
        return this.f11388h;
    }

    private static void m13277a(Context context) {
        SoLoader.a(context, false);
    }

    public final void mo627b() {
        Assertions.a(!this.f11397q, "createReactContextInBackground should only be called when creating the react application for the first time. When reloading JS, e.g. from a new file, explicitly use recreateReactContextInBackground");
        this.f11397q = true;
        m13295l();
    }

    private void m13295l() {
        UiThreadUtil.m13554b();
        if (!this.f11389i || this.f11386f == null) {
            m13296m();
        } else if (this.f11388h.mo722f()) {
            m13300q();
        } else if (this.f11385e != null) {
            C10023 c10023 = new C10023(this);
        }
    }

    private void m13296m() {
        m13284a(new JSCJavaScriptExecutor.Factory(), JSBundleLoader.m13452a(this.f11392l, this.f11385e));
    }

    public final boolean mo630c() {
        return this.f11397q;
    }

    public final void mo631d() {
        UiThreadUtil.m13554b();
        ReactContext reactContext = this.f11391k;
        if (this.f11391k == null) {
            FLog.a("React", "Instance detached from instance manager");
            m13297n(this);
            return;
        }
        ((DeviceEventManagerModule) ((ReactContext) Assertions.b(reactContext)).m13525b(DeviceEventManagerModule.class)).m13697r();
    }

    public static void m13297n(ReactInstanceManagerImpl reactInstanceManagerImpl) {
        UiThreadUtil.m13554b();
        if (reactInstanceManagerImpl.f11393m != null) {
            reactInstanceManagerImpl.f11393m.mo164a();
        }
    }

    public final void mo632e() {
        UiThreadUtil.m13554b();
        this.f11393m = null;
        m13298o();
        this.f11395o = null;
    }

    public final void mo624a(Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        UiThreadUtil.m13554b();
        this.f11393m = defaultHardwareBackBtnHandler;
        this.f11395o = activity;
        m13286a(false);
    }

    public final void mo633f() {
        UiThreadUtil.m13554b();
        m13299p();
        this.f11395o = null;
    }

    public final void mo636i() {
        UiThreadUtil.m13554b();
        m13299p();
        if (this.f11384d != null) {
            this.f11384d.cancel(true);
        }
        this.f11399s.m13234a(this.f11392l);
        if (this.f11391k != null) {
            this.f11391k.m13532e();
            this.f11391k = null;
            this.f11397q = false;
        }
        this.f11395o = null;
    }

    private void m13286a(boolean z) {
        if (this.f11391k != null && (z || this.f11382b == LifecycleState.BEFORE_RESUME || this.f11382b == LifecycleState.BEFORE_CREATE)) {
            this.f11391k.m13517a(this.f11395o);
        }
        this.f11382b = LifecycleState.RESUMED;
    }

    private void m13298o() {
        if (this.f11391k != null) {
            if (this.f11382b == LifecycleState.BEFORE_CREATE) {
                this.f11391k.m13517a(this.f11395o);
                this.f11391k.m13529c();
            } else if (this.f11382b == LifecycleState.RESUMED) {
                this.f11391k.m13529c();
            }
        }
        this.f11382b = LifecycleState.BEFORE_RESUME;
    }

    private void m13299p() {
        if (this.f11391k != null) {
            if (this.f11382b == LifecycleState.RESUMED) {
                this.f11391k.m13529c();
                this.f11382b = LifecycleState.BEFORE_RESUME;
            }
            if (this.f11382b == LifecycleState.BEFORE_RESUME) {
                this.f11391k.m13531d();
            }
        }
        this.f11382b = LifecycleState.BEFORE_CREATE;
    }

    public final void mo623a(int i, int i2, Intent intent) {
        if (this.f11391k != null) {
            this.f11391k.m13516a(i, i2, intent);
        }
    }

    public final void mo634g() {
        UiThreadUtil.m13554b();
    }

    public final String mo635h() {
        return (String) Assertions.b(this.f11394n);
    }

    public final void mo626a(ReactRootView reactRootView) {
        UiThreadUtil.m13554b();
        this.f11381a.add(reactRootView);
        if (this.f11384d == null && this.f11391k != null) {
            m13283a(reactRootView, this.f11391k.m13513a());
        }
    }

    public final void mo629b(ReactRootView reactRootView) {
        UiThreadUtil.m13554b();
        if (this.f11381a.remove(reactRootView) && this.f11391k != null && this.f11391k.m13528b()) {
            m13290b(reactRootView, this.f11391k.m13513a());
        }
    }

    public final List<ViewManager> mo622a(ReactApplicationContext reactApplicationContext) {
        Systrace.a(8192, "createAllViewManagers");
        try {
            List<ViewManager> arrayList = new ArrayList();
            for (ReactPackage b : this.f11387g) {
                arrayList.addAll(b.mo620b(reactApplicationContext));
            }
            return arrayList;
        } finally {
            Systrace.a(8192);
        }
    }

    public final void mo625a(ReactInstanceEventListener reactInstanceEventListener) {
        this.f11396p.add(reactInstanceEventListener);
    }

    public final void mo628b(ReactInstanceEventListener reactInstanceEventListener) {
        this.f11396p.remove(reactInstanceEventListener);
    }

    @VisibleForTesting
    @Nullable
    public final ReactContext mo637j() {
        return this.f11391k;
    }

    private void m13300q() {
        m13284a(new JSCJavaScriptExecutor.Factory(), JSBundleLoader.m13453a(this.f11388h.mo720d(), this.f11388h.mo721e()));
    }

    private void m13284a(Factory factory, JSBundleLoader jSBundleLoader) {
        UiThreadUtil.m13554b();
        ReactContextInitParams reactContextInitParams = new ReactContextInitParams(this, factory, jSBundleLoader);
        if (this.f11384d == null) {
            this.f11384d = new ReactContextInitAsyncTask(this);
            this.f11384d.execute(new ReactContextInitParams[]{reactContextInitParams});
            return;
        }
        this.f11383c = reactContextInitParams;
    }

    public static void m13289b(ReactInstanceManagerImpl reactInstanceManagerImpl, ReactApplicationContext reactApplicationContext) {
        int i = 0;
        UiThreadUtil.m13554b();
        Assertions.a(reactInstanceManagerImpl.f11391k == null);
        reactInstanceManagerImpl.f11391k = (ReactContext) Assertions.b(reactApplicationContext);
        CatalystInstance catalystInstance = (CatalystInstance) Assertions.b(reactApplicationContext.m13513a());
        catalystInstance.mo657d();
        reactInstanceManagerImpl.f11399s.m13235a((MemoryPressureListener) catalystInstance);
        reactInstanceManagerImpl.m13301r();
        for (ReactRootView a : reactInstanceManagerImpl.f11381a) {
            m13283a(a, catalystInstance);
        }
        ReactInstanceEventListener[] reactInstanceEventListenerArr = (ReactInstanceEventListener[]) reactInstanceManagerImpl.f11396p.toArray(new ReactInstanceEventListener[reactInstanceManagerImpl.f11396p.size()]);
        int length = reactInstanceEventListenerArr.length;
        while (i < length) {
            reactInstanceEventListenerArr[i].m13248a(reactApplicationContext);
            i++;
        }
    }

    private static void m13283a(ReactRootView reactRootView, CatalystInstance catalystInstance) {
        UiThreadUtil.m13554b();
        reactRootView.removeAllViews();
        reactRootView.setId(-1);
        int a = ((UIManagerModule) catalystInstance.mo652b(UIManagerModule.class)).m14033a((SizeMonitoringFrameLayout) reactRootView);
        Bundle bundle = reactRootView.f11412c;
        WritableMap a2 = bundle != null ? Arguments.m13386a(bundle) : Arguments.m13388b();
        String jSModuleName = reactRootView.getJSModuleName();
        WritableMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("rootTag", (double) a);
        writableNativeMap.mo696a("initialProps", a2);
        ((AppRegistry) catalystInstance.mo648a(AppRegistry.class)).runApplication(jSModuleName, writableNativeMap);
    }

    private static void m13290b(ReactRootView reactRootView, CatalystInstance catalystInstance) {
        UiThreadUtil.m13554b();
        ((AppRegistry) catalystInstance.mo648a(AppRegistry.class)).unmountApplicationComponentAtRootTag(reactRootView.getId());
    }

    private void m13285a(ReactContext reactContext) {
        UiThreadUtil.m13554b();
        if (this.f11382b == LifecycleState.RESUMED) {
            reactContext.m13529c();
        }
        for (ReactRootView b : this.f11381a) {
            m13290b(b, reactContext.m13513a());
        }
        reactContext.m13532e();
        this.f11399s.m13236b(reactContext.m13513a());
    }

    private ReactApplicationContext m13276a(JavaScriptExecutor javaScriptExecutor, JSBundleLoader jSBundleLoader) {
        NativeModuleRegistry a;
        Throwable e;
        ReactMarker.logMarker("CREATE_REACT_CONTEXT_START");
        this.f11394n = jSBundleLoader.mo660a();
        Builder builder = new Builder();
        JavaScriptModuleRegistry.Builder builder2 = new JavaScriptModuleRegistry.Builder();
        final ReactContext reactApplicationContext = new ReactApplicationContext(this.f11392l);
        if (this.f11389i) {
            reactApplicationContext.m13521a(this.f11388h);
        }
        ReactMarker.logMarker("PROCESS_PACKAGES_START");
        Systrace.a(8192, "createAndProcessCoreModulesPackage");
        try {
            m13282a(new CoreModulesPackage(this, this.f11403w, this.f11398r), reactApplicationContext, builder, builder2);
            for (ReactPackage reactPackage : this.f11387g) {
                Systrace.a(8192, "createAndProcessCustomReactPackage");
                try {
                    m13282a(reactPackage, reactApplicationContext, builder, builder2);
                    Systrace.a(8192);
                } catch (Throwable th) {
                    Systrace.a(8192);
                }
            }
            ReactMarker.logMarker("PROCESS_PACKAGES_END");
            ReactMarker.logMarker("BUILD_NATIVE_MODULE_REGISTRY_START");
            Systrace.a(8192, "buildNativeModuleRegistry");
            try {
                a = builder.m13491a();
                CatalystInstanceImpl.Builder a2 = new CatalystInstanceImpl.Builder().m13418a(ReactQueueConfigurationSpec.m13589c()).m13414a(javaScriptExecutor).m13417a(a).m13415a(builder2.m13467a()).m13413a(jSBundleLoader).m13416a(this.f11400t != null ? this.f11400t : this.f11388h);
                ReactMarker.logMarker("CREATE_CATALYST_INSTANCE_START");
                Systrace.a(8192, "createCatalystInstance");
                try {
                    final CatalystInstance a3 = a2.m13419a();
                    if (this.f11390j != null) {
                        a3.mo651a(this.f11390j);
                    }
                    try {
                        FutureDetour.a(a3.mo658e().mo709c().callOnQueue(new Callable<Void>(this) {
                            final /* synthetic */ ReactInstanceManagerImpl f11374c;

                            public Object call() {
                                reactApplicationContext.m13519a(a3);
                                ReactMarker.logMarker("RUN_JS_BUNDLE_START");
                                Systrace.a(8192, "runJSBundle");
                                try {
                                    a3.mo649a();
                                    return null;
                                } finally {
                                    Systrace.a(8192);
                                }
                            }
                        }), 1456570719);
                        return reactApplicationContext;
                    } catch (InterruptedException e2) {
                        e = e2;
                        throw new RuntimeException(e);
                    } catch (ExecutionException e3) {
                        e = e3;
                        throw new RuntimeException(e);
                    }
                } finally {
                    Systrace.a(8192);
                    ReactMarker.logMarker("CREATE_CATALYST_INSTANCE_END");
                }
            } finally {
                Systrace.a(8192);
                a = "BUILD_NATIVE_MODULE_REGISTRY_END";
                ReactMarker.logMarker(a);
            }
        } finally {
            Systrace.a(8192);
        }
    }

    private static void m13282a(ReactPackage reactPackage, ReactApplicationContext reactApplicationContext, Builder builder, JavaScriptModuleRegistry.Builder builder2) {
        for (NativeModule a : reactPackage.mo619a(reactApplicationContext)) {
            builder.m13490a(a);
        }
        for (Class a2 : reactPackage.mo618a()) {
            builder2.m13466a(a2);
        }
    }

    private void m13301r() {
        if (this.f11382b == LifecycleState.RESUMED) {
            m13286a(true);
        }
    }
}
