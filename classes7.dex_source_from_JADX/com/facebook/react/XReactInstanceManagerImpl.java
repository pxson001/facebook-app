package com.facebook.react;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactInstanceManager.ReactInstanceEventListener;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JavaScriptModuleRegistry;
import com.facebook.react.bridge.MemoryPressureListener;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.ApplicationHolder;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.cxxbridge.Arguments;
import com.facebook.react.cxxbridge.CatalystInstanceImpl;
import com.facebook.react.cxxbridge.JSBundleLoader;
import com.facebook.react.cxxbridge.JSCJavaScriptExecutor;
import com.facebook.react.cxxbridge.JavaScriptExecutor;
import com.facebook.react.cxxbridge.JavaScriptExecutor.Factory;
import com.facebook.react.cxxbridge.NativeModuleRegistry;
import com.facebook.react.cxxbridge.NativeModuleRegistry.Builder;
import com.facebook.react.cxxbridge.UiThreadUtil;
import com.facebook.react.devsupport.DevSupportManager;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.ReactInstanceDevCommandsHandler;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.debug.DeveloperSettings;
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

/* compiled from: gsym_click */
public class XReactInstanceManagerImpl extends ReactInstanceManager {
    private final List<ReactRootView> f11431a = new ArrayList();
    private LifecycleState f11432b;
    @Nullable
    public ReactContextInitParams f11433c;
    @Nullable
    private ReactContextInitAsyncTask f11434d;
    @Nullable
    private String f11435e;
    @Nullable
    private final String f11436f;
    private final List<ReactPackage> f11437g;
    public final DevSupportManager f11438h;
    private final boolean f11439i;
    @Nullable
    private final NotThreadSafeBridgeIdleDebugListener f11440j;
    @Nullable
    public volatile ReactContext f11441k;
    private final Context f11442l;
    @Nullable
    private DefaultHardwareBackBtnHandler f11443m;
    private String f11444n;
    @Nullable
    private Activity f11445o;
    private final Collection<ReactInstanceEventListener> f11446p = Collections.synchronizedSet(new HashSet());
    private volatile boolean f11447q = false;
    private final UIImplementationProvider f11448r;
    public final MemoryPressureRouter f11449s;
    @Nullable
    private final NativeModuleCallExceptionHandler f11450t;
    @Nullable
    private final JSCConfig f11451u;
    private final ReactInstanceDevCommandsHandler f11452v = new C10051(this);
    private final DefaultHardwareBackBtnHandler f11453w = new C10062(this);

    /* compiled from: gsym_click */
    class C10051 implements ReactInstanceDevCommandsHandler {
        final /* synthetic */ XReactInstanceManagerImpl f11418a;

        C10051(XReactInstanceManagerImpl xReactInstanceManagerImpl) {
            this.f11418a = xReactInstanceManagerImpl;
        }
    }

    /* compiled from: gsym_click */
    class C10062 implements DefaultHardwareBackBtnHandler {
        final /* synthetic */ XReactInstanceManagerImpl f11419a;

        C10062(XReactInstanceManagerImpl xReactInstanceManagerImpl) {
            this.f11419a = xReactInstanceManagerImpl;
        }

        public final void mo164a() {
            XReactInstanceManagerImpl.m13360n(this.f11419a);
        }
    }

    /* compiled from: gsym_click */
    final class ReactContextInitAsyncTask extends AsyncTask<ReactContextInitParams, Void, Result<ReactApplicationContext>> {
        final /* synthetic */ XReactInstanceManagerImpl f11425a;

        public ReactContextInitAsyncTask(XReactInstanceManagerImpl xReactInstanceManagerImpl) {
            this.f11425a = xReactInstanceManagerImpl;
        }

        protected final Object doInBackground(Object[] objArr) {
            ReactContextInitParams[] reactContextInitParamsArr = (ReactContextInitParams[]) objArr;
            boolean z = false;
            if (!(reactContextInitParamsArr == null || reactContextInitParamsArr.length <= 0 || reactContextInitParamsArr[0] == null)) {
                z = true;
            }
            Assertions.a(z);
            try {
                return Result.m13335a(this.f11425a.m13340a(reactContextInitParamsArr[0].m13332a().mo716a(), reactContextInitParamsArr[0].m13333b()));
            } catch (Exception e) {
                return Result.m13334a(e);
            }
        }

        protected final void onCancelled(Object obj) {
            try {
                this.f11425a.f11449s.m13234a((Context) ((Result) obj).m13336a());
            } catch (Throwable e) {
                FLog.a("React", "Caught exception after cancelling react context init", e);
            } finally {
                this.f11425a.f11434d = null;
            }
        }

        protected final void onPostExecute(Object obj) {
            try {
                XReactInstanceManagerImpl.m13354b(this.f11425a, (ReactApplicationContext) ((Result) obj).m13336a());
            } catch (Exception e) {
                this.f11425a.f11438h.a(e);
            } finally {
                this.f11425a.f11434d = null;
            }
            if (this.f11425a.f11433c != null) {
                this.f11425a.m13349a(this.f11425a.f11433c.m13332a(), this.f11425a.f11433c.m13333b());
                this.f11425a.f11433c = null;
            }
        }

        protected final void onPreExecute() {
            if (this.f11425a.f11441k != null) {
                this.f11425a.m13348a(this.f11425a.f11441k);
                this.f11425a.f11441k = null;
            }
        }
    }

    /* compiled from: gsym_click */
    class ReactContextInitParams {
        final /* synthetic */ XReactInstanceManagerImpl f11426a;
        private final Factory f11427b;
        private final JSBundleLoader f11428c;

        public ReactContextInitParams(XReactInstanceManagerImpl xReactInstanceManagerImpl, Factory factory, JSBundleLoader jSBundleLoader) {
            this.f11426a = xReactInstanceManagerImpl;
            this.f11427b = (Factory) Assertions.b(factory);
            this.f11428c = (JSBundleLoader) Assertions.b(jSBundleLoader);
        }

        public final Factory m13332a() {
            return this.f11427b;
        }

        public final JSBundleLoader m13333b() {
            return this.f11428c;
        }
    }

    /* compiled from: gsym_click */
    class Result<T> {
        @Nullable
        private final T f11429a;
        @Nullable
        private final Exception f11430b;

        public static <T, U extends T> Result<T> m13335a(U u) {
            return new Result((Object) u);
        }

        public static <T> Result<T> m13334a(Exception exception) {
            return new Result(exception);
        }

        private Result(T t) {
            this.f11430b = null;
            this.f11429a = t;
        }

        private Result(Exception exception) {
            this.f11430b = exception;
            this.f11429a = null;
        }

        public final T m13336a() {
            if (this.f11430b != null) {
                throw this.f11430b;
            }
            Assertions.b(this.f11429a);
            return this.f11429a;
        }
    }

    XReactInstanceManagerImpl(Context context, @Nullable Activity activity, @Nullable DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, @Nullable String str, @Nullable String str2, List<ReactPackage> list, boolean z, @Nullable NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener, LifecycleState lifecycleState, UIImplementationProvider uIImplementationProvider, NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler, @Nullable JSCConfig jSCConfig) {
        m13341a(context);
        ApplicationHolder.f11578a = (Application) context.getApplicationContext();
        DisplayMetricsHolder.m13806a(context);
        this.f11442l = context;
        this.f11445o = activity;
        this.f11443m = defaultHardwareBackBtnHandler;
        this.f11435e = str;
        this.f11436f = str2;
        this.f11437g = list;
        this.f11439i = z;
        this.f11438h = DevSupportManagerFactory.m13685a(context, this.f11452v, this.f11436f, z);
        this.f11440j = notThreadSafeBridgeIdleDebugListener;
        this.f11432b = lifecycleState;
        this.f11448r = uIImplementationProvider;
        this.f11449s = new MemoryPressureRouter(context);
        this.f11450t = nativeModuleCallExceptionHandler;
        this.f11451u = jSCConfig;
    }

    public final DevSupportManager mo621a() {
        return this.f11438h;
    }

    private static void m13341a(Context context) {
        SoLoader.a(context, false);
    }

    public final void mo627b() {
        Assertions.a(!this.f11447q, "createReactContextInBackground should only be called when creating the react application for the first time. When reloading JS, e.g. from a new file, explicitlyuse recreateReactContextInBackground");
        this.f11447q = true;
        m13358l();
    }

    private void m13358l() {
        UiThreadUtil.m13677a();
        if (!this.f11439i || this.f11436f == null) {
            m13359m();
            return;
        }
        final DeveloperSettings b = this.f11438h.mo718b();
        if (this.f11438h.mo722f() && !b.m13722b()) {
            m13363q();
        } else if (this.f11435e != null) {
            C10073 c10073 = new Object(this) {
                final /* synthetic */ XReactInstanceManagerImpl f11421b;
            };
        }
    }

    private void m13359m() {
        m13349a(new JSCJavaScriptExecutor.Factory(this.f11451u == null ? new WritableNativeMap() : this.f11451u.m13230a()), JSBundleLoader.m13659a(this.f11442l, this.f11435e));
    }

    public final boolean mo630c() {
        return this.f11447q;
    }

    public final void mo631d() {
        UiThreadUtil.m13677a();
        ReactContext reactContext = this.f11441k;
        if (this.f11441k == null) {
            FLog.a("React", "Instance detached from instance manager");
            m13360n(this);
            return;
        }
        ((DeviceEventManagerModule) ((ReactContext) Assertions.b(reactContext)).m13525b(DeviceEventManagerModule.class)).m13697r();
    }

    public static void m13360n(XReactInstanceManagerImpl xReactInstanceManagerImpl) {
        UiThreadUtil.m13677a();
        if (xReactInstanceManagerImpl.f11443m != null) {
            xReactInstanceManagerImpl.f11443m.mo164a();
        }
    }

    public final void mo632e() {
        UiThreadUtil.m13677a();
        this.f11443m = null;
        m13361o();
        this.f11445o = null;
    }

    public final void mo624a(Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        UiThreadUtil.m13677a();
        this.f11443m = defaultHardwareBackBtnHandler;
        this.f11445o = activity;
        m13350a(false);
    }

    public final void mo633f() {
        UiThreadUtil.m13677a();
        m13362p();
        this.f11445o = null;
    }

    public final void mo636i() {
        UiThreadUtil.m13677a();
        m13362p();
        if (this.f11434d != null) {
            this.f11434d.cancel(true);
        }
        this.f11449s.m13234a(this.f11442l);
        if (this.f11441k != null) {
            this.f11441k.m13532e();
            this.f11441k = null;
            this.f11447q = false;
        }
        this.f11445o = null;
    }

    private void m13350a(boolean z) {
        if (this.f11441k != null && (z || this.f11432b == LifecycleState.BEFORE_RESUME || this.f11432b == LifecycleState.BEFORE_CREATE)) {
            this.f11441k.m13517a(this.f11445o);
        }
        this.f11432b = LifecycleState.RESUMED;
    }

    private void m13361o() {
        if (this.f11441k != null) {
            if (this.f11432b == LifecycleState.BEFORE_CREATE) {
                this.f11441k.m13517a(this.f11445o);
                this.f11441k.m13529c();
            } else if (this.f11432b == LifecycleState.RESUMED) {
                this.f11441k.m13529c();
            }
        }
        this.f11432b = LifecycleState.BEFORE_RESUME;
    }

    private void m13362p() {
        if (this.f11441k != null) {
            if (this.f11432b == LifecycleState.RESUMED) {
                this.f11441k.m13529c();
                this.f11432b = LifecycleState.BEFORE_RESUME;
            }
            if (this.f11432b == LifecycleState.BEFORE_RESUME) {
                this.f11441k.m13531d();
            }
        }
        this.f11432b = LifecycleState.BEFORE_CREATE;
    }

    public final void mo623a(int i, int i2, Intent intent) {
        if (this.f11441k != null) {
            this.f11441k.m13516a(i, i2, intent);
        }
    }

    public final void mo634g() {
        UiThreadUtil.m13677a();
    }

    public final String mo635h() {
        return (String) Assertions.b(this.f11444n);
    }

    public final void mo626a(ReactRootView reactRootView) {
        UiThreadUtil.m13677a();
        this.f11431a.add(reactRootView);
        if (this.f11434d == null && this.f11441k != null) {
            m13343a(reactRootView, this.f11441k.m13513a());
        }
    }

    public final void mo629b(ReactRootView reactRootView) {
        UiThreadUtil.m13677a();
        if (this.f11431a.remove(reactRootView) && this.f11441k != null && this.f11441k.m13528b()) {
            m13353b(reactRootView, this.f11441k.m13513a());
        }
    }

    public final List<ViewManager> mo622a(ReactApplicationContext reactApplicationContext) {
        Systrace.a(8192, "createAllViewManagers");
        try {
            List<ViewManager> arrayList = new ArrayList();
            for (ReactPackage b : this.f11437g) {
                arrayList.addAll(b.mo620b(reactApplicationContext));
            }
            return arrayList;
        } finally {
            Systrace.a(8192);
        }
    }

    public final void mo625a(ReactInstanceEventListener reactInstanceEventListener) {
        this.f11446p.add(reactInstanceEventListener);
    }

    public final void mo628b(ReactInstanceEventListener reactInstanceEventListener) {
        this.f11446p.remove(reactInstanceEventListener);
    }

    @VisibleForTesting
    @Nullable
    public final ReactContext mo637j() {
        return this.f11441k;
    }

    private void m13363q() {
        m13349a(new JSCJavaScriptExecutor.Factory(this.f11451u == null ? new WritableNativeMap() : this.f11451u.m13230a()), JSBundleLoader.m13660a(this.f11438h.mo720d(), this.f11438h.mo721e()));
    }

    private void m13349a(Factory factory, JSBundleLoader jSBundleLoader) {
        UiThreadUtil.m13677a();
        ReactContextInitParams reactContextInitParams = new ReactContextInitParams(this, factory, jSBundleLoader);
        if (this.f11434d == null) {
            this.f11434d = new ReactContextInitAsyncTask(this);
            this.f11434d.execute(new ReactContextInitParams[]{reactContextInitParams});
            return;
        }
        this.f11433c = reactContextInitParams;
    }

    public static void m13354b(XReactInstanceManagerImpl xReactInstanceManagerImpl, ReactApplicationContext reactApplicationContext) {
        int i = 0;
        Systrace.a(8192, "setupReactContext");
        UiThreadUtil.m13677a();
        Assertions.a(xReactInstanceManagerImpl.f11441k == null);
        xReactInstanceManagerImpl.f11441k = (ReactContext) Assertions.b(reactApplicationContext);
        CatalystInstance catalystInstance = (CatalystInstance) Assertions.b(reactApplicationContext.m13513a());
        catalystInstance.mo657d();
        xReactInstanceManagerImpl.f11449s.m13235a((MemoryPressureListener) catalystInstance);
        xReactInstanceManagerImpl.m13364r();
        for (ReactRootView a : xReactInstanceManagerImpl.f11431a) {
            m13343a(a, catalystInstance);
        }
        ReactInstanceEventListener[] reactInstanceEventListenerArr = (ReactInstanceEventListener[]) xReactInstanceManagerImpl.f11446p.toArray(new ReactInstanceEventListener[xReactInstanceManagerImpl.f11446p.size()]);
        int length = reactInstanceEventListenerArr.length;
        while (i < length) {
            reactInstanceEventListenerArr[i].m13248a(reactApplicationContext);
            i++;
        }
        Systrace.a(8192);
    }

    private static void m13343a(ReactRootView reactRootView, CatalystInstance catalystInstance) {
        Systrace.a(8192, "attachMeasuredRootViewToInstance");
        UiThreadUtil.m13677a();
        reactRootView.removeAllViews();
        reactRootView.setId(-1);
        int a = ((UIManagerModule) catalystInstance.mo652b(UIManagerModule.class)).m14033a((SizeMonitoringFrameLayout) reactRootView);
        WritableMap a2 = Arguments.m13619a(reactRootView.f11412c);
        String jSModuleName = reactRootView.getJSModuleName();
        WritableMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("rootTag", (double) a);
        writableNativeMap.mo696a("initialProps", a2);
        ((AppRegistry) catalystInstance.mo648a(AppRegistry.class)).runApplication(jSModuleName, writableNativeMap);
        Systrace.a(8192);
    }

    private static void m13353b(ReactRootView reactRootView, CatalystInstance catalystInstance) {
        UiThreadUtil.m13677a();
        ((AppRegistry) catalystInstance.mo648a(AppRegistry.class)).unmountApplicationComponentAtRootTag(reactRootView.getId());
    }

    private void m13348a(ReactContext reactContext) {
        UiThreadUtil.m13677a();
        if (this.f11432b == LifecycleState.RESUMED) {
            reactContext.m13529c();
        }
        for (ReactRootView b : this.f11431a) {
            m13353b(b, reactContext.m13513a());
        }
        reactContext.m13532e();
        this.f11449s.m13236b(reactContext.m13513a());
    }

    private ReactApplicationContext m13340a(JavaScriptExecutor javaScriptExecutor, JSBundleLoader jSBundleLoader) {
        Throwable e;
        ReactMarker.logMarker("CREATE_REACT_CONTEXT_START");
        this.f11444n = jSBundleLoader.mo714a();
        Builder builder = new Builder();
        JavaScriptModuleRegistry.Builder builder2 = new JavaScriptModuleRegistry.Builder();
        final ReactContext reactApplicationContext = new ReactApplicationContext(this.f11442l);
        if (this.f11439i) {
            reactApplicationContext.m13521a(this.f11438h);
        }
        ReactMarker.logMarker("PROCESS_PACKAGES_START");
        Systrace.a(8192, "createAndProcessCoreModulesPackage");
        try {
            m13342a(new CoreModulesPackage(this, this.f11453w, this.f11448r), reactApplicationContext, builder, builder2);
            for (ReactPackage reactPackage : this.f11437g) {
                Systrace.a(8192, "createAndProcessCustomReactPackage");
                try {
                    m13342a(reactPackage, reactApplicationContext, builder, builder2);
                    Systrace.a(8192);
                } catch (Throwable th) {
                    Systrace.a(8192);
                }
            }
            ReactMarker.logMarker("PROCESS_PACKAGES_END");
            ReactMarker.logMarker("BUILD_NATIVE_MODULE_REGISTRY_START");
            Systrace.a(8192, "buildNativeModuleRegistry");
            NativeModuleRegistry a;
            try {
                a = builder.m13670a();
                CatalystInstanceImpl.Builder a2 = new CatalystInstanceImpl.Builder().m13627a(ReactQueueConfigurationSpec.m13589c()).m13629a(javaScriptExecutor).m13630a(a).m13625a(builder2.m13467a()).m13628a(jSBundleLoader).m13626a(this.f11450t != null ? this.f11450t : this.f11438h);
                ReactMarker.logMarker("CREATE_CATALYST_INSTANCE_START");
                Systrace.a(8192, "createCatalystInstance");
                try {
                    final CatalystInstance a3 = a2.m13631a();
                    if (this.f11440j != null) {
                        a3.mo651a(this.f11440j);
                    }
                    ReactMarker.logMarker("RUN_JS_BUNDLE_START");
                    try {
                        FutureDetour.a(a3.mo658e().mo709c().callOnQueue(new Callable<Void>(this) {
                            final /* synthetic */ XReactInstanceManagerImpl f11424c;

                            public Object call() {
                                reactApplicationContext.m13519a(a3);
                                Systrace.a(8192, "runJSBundle");
                                try {
                                    a3.mo649a();
                                    return null;
                                } finally {
                                    Systrace.a(8192);
                                    ReactMarker.logMarker("RUN_JS_BUNDLE_END");
                                }
                            }
                        }), -599653879);
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

    private static void m13342a(ReactPackage reactPackage, ReactApplicationContext reactApplicationContext, Builder builder, JavaScriptModuleRegistry.Builder builder2) {
        for (NativeModule a : reactPackage.mo619a(reactApplicationContext)) {
            builder.m13669a(a);
        }
        for (Class a2 : reactPackage.mo618a()) {
            builder2.m13466a(a2);
        }
    }

    private void m13364r() {
        if (this.f11432b == LifecycleState.RESUMED) {
            m13350a(true);
        }
    }
}
