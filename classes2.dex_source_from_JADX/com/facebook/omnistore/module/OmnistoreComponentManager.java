package com.facebook.omnistore.module;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.analytics.CounterLogger;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.common.executors.C0115xfdf5bd2;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.omnistore.CollectionName;
import com.facebook.omnistore.Delta;
import com.facebook.omnistore.Delta.Status;
import com.facebook.omnistore.IndexedFields;
import com.facebook.omnistore.Omnistore;
import com.facebook.omnistore.Omnistore.CollectionIndexerFunction;
import com.facebook.omnistore.Omnistore.DeltaReceivedCallback;
import com.facebook.omnistore.Omnistore.StoredProcedureResultCallback;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashBiMap;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_mqtt_bytes_received_background */
public class OmnistoreComponentManager implements IHaveUserData, INeedInit, CollectionIndexerFunction, DeltaReceivedCallback, StoredProcedureResultCallback {
    public static final Class<?> TAG = OmnistoreComponentManager.class;
    private static volatile OmnistoreComponentManager f2338x450fd1f3;
    @GuardedBy("mComponentMutex")
    private final HashBiMap<CollectionName, OmnistoreComponent> mActiveComponents;
    private final Object mComponentMutex = new Object();
    private final CounterLogger mCounterLogger;
    private final ExecutorService mIdleExecutorService;
    public volatile boolean mIsOmnistoreStarted;
    public final ListeningScheduledExecutorService mListeningScheduledExecutorService;
    @GuardedBy("mOmnistoreMutex")
    @Nullable
    public Omnistore mOmnistore;
    private final Provider<OmnistoreCallbackRegistration> mOmnistoreCallbackRegistrationProvider;
    private final Provider<OmnistoreIndexerRegistration> mOmnistoreIndexerRegistrationProvider;
    public final Object mOmnistoreMutex = new Object();
    private final DefaultOmnistoreOpener mOmnistoreOpener;
    private final Runnable mStartOmnistoreRunnable = new C07031();
    public final Set<OmnistoreComponent> mStartupOmnistoreComponents;
    @GuardedBy("mStoredProcedureMutex")
    private final HashMap<Integer, OmnistoreStoredProcedureComponent> mStoredProcedureComponentMap;
    private final Set<OmnistoreStoredProcedureComponent> mStoredProcedureComponents;
    private final Object mStoredProcedureMutex = new Object();
    private final Provider<String> mViewerContextUserIdProvider;

    /* compiled from: total_mqtt_bytes_received_background */
    public class OmnistoreComponentManagerBroadcastReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<OmnistoreComponentManager> {
        public static OmnistoreComponentManagerBroadcastReceiverRegistration m4526x47a887d1(InjectorLike injectorLike) {
            return new OmnistoreComponentManagerBroadcastReceiverRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 2868), Handler_BackgroundBroadcastThreadMethodAutoProvider.m4110a(injectorLike));
        }

        protected /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent, Object obj) {
            OmnistoreComponentManager omnistoreComponentManager = (OmnistoreComponentManager) obj;
            Class cls = OmnistoreComponentManager.TAG;
            ExecutorDetour.a(omnistoreComponentManager.mListeningScheduledExecutorService, new 1(this, omnistoreComponentManager), 662876289);
            omnistoreComponentManager.mListeningScheduledExecutorService.mo310a(new 2(this, omnistoreComponentManager), 5, TimeUnit.SECONDS);
        }

        @Inject
        public OmnistoreComponentManagerBroadcastReceiverRegistration(Lazy<OmnistoreComponentManager> lazy, Handler handler) {
            super(FbBroadcastManagerType.LOCAL, (Lazy) lazy, handler, "com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE");
            Class cls = OmnistoreComponentManager.TAG;
        }
    }

    /* compiled from: total_mqtt_bytes_received_background */
    class C07031 implements Runnable {
        C07031() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r3 = this;
            com.facebook.omnistore.module.OmnistoreComponentManager.TAG;
            r0 = com.facebook.omnistore.module.OmnistoreComponentManager.this;
            r1 = r0.mOmnistoreMutex;
            monitor-enter(r1);
            r0 = com.facebook.omnistore.module.OmnistoreComponentManager.this;	 Catch:{ all -> 0x0025 }
            r0 = r0.mOmnistore;	 Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0010;
        L_0x000e:
            monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        L_0x000f:
            return;
        L_0x0010:
            r0 = com.facebook.omnistore.module.OmnistoreComponentManager.this;	 Catch:{ all -> 0x0025 }
            r0 = r0.mIsOmnistoreStarted;	 Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0023;
        L_0x0016:
            r0 = com.facebook.omnistore.module.OmnistoreComponentManager.this;	 Catch:{ all -> 0x0025 }
            r2 = 1;
            r0.mIsOmnistoreStarted = r2;	 Catch:{ all -> 0x0025 }
            r0 = com.facebook.omnistore.module.OmnistoreComponentManager.this;	 Catch:{ all -> 0x0025 }
            r0 = r0.mOmnistore;	 Catch:{ all -> 0x0025 }
            r0.start();	 Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r1);	 Catch:{ all -> 0x0025 }
            goto L_0x000f;
        L_0x0025:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0025 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.omnistore.module.OmnistoreComponentManager.1.run():void");
        }
    }

    public static com.facebook.omnistore.module.OmnistoreComponentManager m4528x77537f3(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f2338x450fd1f3;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.omnistore.module.OmnistoreComponentManager.class;
        monitor-enter(r1);
        r0 = f2338x450fd1f3;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m4527xbdfea18d(r0);	 Catch:{ all -> 0x0035 }
        f2338x450fd1f3 = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2338x450fd1f3;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.omnistore.module.OmnistoreComponentManager.getInstance__com_facebook_omnistore_module_OmnistoreComponentManager__INJECTED_BY_TemplateInjector(com.facebook.inject.InjectorLike):com.facebook.omnistore.module.OmnistoreComponentManager");
    }

    private static OmnistoreComponentManager m4527xbdfea18d(InjectorLike injectorLike) {
        return new OmnistoreComponentManager(DefaultOmnistoreOpener.m22131xed2aa177(injectorLike), STATICDI_MULTIBIND_PROVIDER$OmnistoreComponent.getSet(injectorLike), STATICDI_MULTIBIND_PROVIDER$OmnistoreStoredProcedureComponent.getSet(injectorLike), IdBasedProvider.m1811a(injectorLike, 4443), C0115xfdf5bd2.m3569a(injectorLike), IdBasedProvider.m1811a(injectorLike, 8765), IdBasedProvider.m1811a(injectorLike, 8769), CounterLogger.m12608a(injectorLike), IdleExecutor_DefaultIdleExecutorMethodAutoProvider.m2724a(injectorLike));
    }

    @Inject
    public OmnistoreComponentManager(OmnistoreOpener omnistoreOpener, Set<OmnistoreComponent> set, Set<OmnistoreStoredProcedureComponent> set2, Provider<String> provider, ListeningScheduledExecutorService listeningScheduledExecutorService, Provider<OmnistoreCallbackRegistration> provider2, Provider<OmnistoreIndexerRegistration> provider3, CounterLogger counterLogger, ExecutorService executorService) {
        this.mOmnistoreOpener = omnistoreOpener;
        this.mStartupOmnistoreComponents = set;
        this.mStoredProcedureComponents = set2;
        this.mViewerContextUserIdProvider = provider;
        this.mListeningScheduledExecutorService = listeningScheduledExecutorService;
        this.mOmnistoreCallbackRegistrationProvider = provider2;
        this.mOmnistoreIndexerRegistrationProvider = provider3;
        this.mCounterLogger = counterLogger;
        this.mIdleExecutorService = executorService;
        this.mActiveComponents = HashBiMap.m23020a(set.size());
        this.mStoredProcedureComponentMap = new HashMap();
    }

    public void onDeltaReceived(Delta[] deltaArr) {
        ((OmnistoreCallbackRegistration) this.mOmnistoreCallbackRegistrationProvider.get()).onDeltaReceived(deltaArr);
        Integer.valueOf(deltaArr.length);
        HashMap hashMap = new HashMap();
        for (Delta delta : deltaArr) {
            Status status = delta.getStatus();
            if (status == Status.LOCALLY_COMMITTED || status == Status.PERSISTED_REMOTE) {
                CollectionName collectionName = delta.getCollectionName();
                ArrayList arrayList = (ArrayList) hashMap.get(collectionName);
                if (arrayList == null) {
                    arrayList = new ArrayList(deltaArr.length);
                    hashMap.put(collectionName, arrayList);
                }
                arrayList.add(delta);
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            synchronized (this.mComponentMutex) {
                OmnistoreComponent omnistoreComponent = (OmnistoreComponent) this.mActiveComponents.get(entry.getKey());
            }
            if (omnistoreComponent != null) {
                omnistoreComponent.onDeltasReceived((List) entry.getValue());
            }
        }
    }

    public IndexedFields getIndexedFields(CollectionName collectionName, String str, String str2, ByteBuffer byteBuffer) {
        OmnistoreComponent omnistoreComponent;
        synchronized (this.mComponentMutex) {
            omnistoreComponent = (OmnistoreComponent) this.mActiveComponents.get(collectionName);
        }
        return omnistoreComponent == null ? ((OmnistoreIndexerRegistration) this.mOmnistoreIndexerRegistrationProvider.get()).getIndexedFields(collectionName, str, str2, byteBuffer) : omnistoreComponent.indexObject(str, str2, byteBuffer);
    }

    @Deprecated
    public Omnistore getOmnistoreInstanceForLegacyInjection() {
        Omnistore omnistore;
        synchronized (this.mOmnistoreMutex) {
            if (this.mOmnistore == null) {
                BLog.b(TAG, "Legacy injection is forcing OmnistoreComponentManager to init as a side-effect");
                init();
            }
            omnistore = this.mOmnistore;
        }
        return omnistore;
    }

    public void init() {
        String str = (String) this.mViewerContextUserIdProvider.get();
        if (str != null && !str.equals("0")) {
            synchronized (this.mOmnistoreMutex) {
                if (this.mOmnistore != null) {
                    return;
                }
                this.mOmnistore = this.mOmnistoreOpener.openOmnistoreInstance();
                this.mOmnistore.addDeltaReceivedCallback(this);
                this.mOmnistore.setCollectionIndexerFunction(this);
                this.mOmnistore.addStoredProcedureResultCallback(this);
                synchronized (this.mStoredProcedureMutex) {
                    for (OmnistoreStoredProcedureComponent omnistoreStoredProcedureComponent : this.mStoredProcedureComponents) {
                        int provideStoredProcedureId = omnistoreStoredProcedureComponent.provideStoredProcedureId();
                        this.mStoredProcedureComponentMap.put(Integer.valueOf(provideStoredProcedureId), omnistoreStoredProcedureComponent);
                        omnistoreStoredProcedureComponent.onSenderAvailable(new OmnistoreStoredProcedureSender(this, provideStoredProcedureId));
                    }
                }
                for (OmnistoreComponent maybeUpdateComponent : this.mStartupOmnistoreComponents) {
                    maybeUpdateComponent(maybeUpdateComponent);
                }
                ExecutorDetour.a(this.mIdleExecutorService, this.mStartOmnistoreRunnable, -1255056355);
            }
        }
    }

    public void startOmnistoreIfNotYet() {
        if (!this.mIsOmnistoreStarted) {
            ExecutorDetour.a(this.mListeningScheduledExecutorService, this.mStartOmnistoreRunnable, -545714018);
        }
    }

    public void clearUserData() {
        synchronized (this.mOmnistoreMutex) {
            if (this.mOmnistore == null) {
                return;
            }
            synchronized (this.mComponentMutex) {
                HashMap hashMap = new HashMap(this.mActiveComponents);
                this.mActiveComponents.clear();
            }
            for (Entry entry : hashMap.entrySet()) {
                entry.getKey();
                ((OmnistoreComponent) entry.getValue()).onCollectionInvalidated();
            }
            synchronized (this.mStoredProcedureMutex) {
                for (OmnistoreStoredProcedureComponent onSenderInvalidated : this.mStoredProcedureComponents) {
                    onSenderInvalidated.onSenderInvalidated();
                }
                this.mStoredProcedureComponentMap.clear();
            }
            this.mOmnistore.remove();
            this.mOmnistore = null;
            this.mCounterLogger.m12611a("omnistore_remove_called");
        }
    }

    public void onStoredProcedureResult(int i, ByteBuffer byteBuffer) {
        synchronized (this.mStoredProcedureMutex) {
            OmnistoreStoredProcedureComponent omnistoreStoredProcedureComponent = (OmnistoreStoredProcedureComponent) this.mStoredProcedureComponentMap.get(Integer.valueOf(i));
            if (omnistoreStoredProcedureComponent == null) {
                return;
            }
            omnistoreStoredProcedureComponent.onStoredProcedureResult(byteBuffer);
        }
    }

    public void checkComponentSubscription(OmnistoreComponent omnistoreComponent) {
        Preconditions.checkState(this.mStartupOmnistoreComponents.contains(omnistoreComponent), "All component instances must be registered in the OmnistoreComponent multibind");
        synchronized (this.mOmnistoreMutex) {
            if (this.mOmnistore == null) {
                return;
            }
            maybeUpdateComponent(omnistoreComponent);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.common.annotations.VisibleForTesting
    public void maybeUpdateComponent(com.facebook.omnistore.module.OmnistoreComponent r10) {
        /*
        r9 = this;
        r3 = 1;
        r2 = 0;
        r5 = r9.mOmnistoreMutex;
        monitor-enter(r5);
        r0 = r9.mOmnistore;	 Catch:{ all -> 0x0046 }
        com.google.common.base.Preconditions.checkNotNull(r0);	 Catch:{ all -> 0x0046 }
        r0 = r9.mOmnistore;	 Catch:{ all -> 0x0046 }
        r6 = r10.provideSubscriptionInfo(r0);	 Catch:{ all -> 0x0046 }
        r0 = r6.subscriptionState;	 Catch:{ all -> 0x0046 }
        r0 = com.facebook.omnistore.module.OmnistoreComponentManager.2.$SwitchMap$com$facebook$omnistore$module$OmnistoreComponent$SubscriptionState;	 Catch:{ all -> 0x0046 }
        r1 = r6.subscriptionState;	 Catch:{ all -> 0x0046 }
        r1 = r1.ordinal();	 Catch:{ all -> 0x0046 }
        r0 = r0[r1];	 Catch:{ all -> 0x0046 }
        switch(r0) {
            case 1: goto L_0x002f;
            case 2: goto L_0x004e;
            case 3: goto L_0x0073;
            default: goto L_0x001f;
        };	 Catch:{ all -> 0x0046 }
    L_0x001f:
        r0 = 0;
        r1 = "Unexpected Subscription action: %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0046 }
        r3 = 0;
        r4 = r6.subscriptionState;	 Catch:{ all -> 0x0046 }
        r2[r3] = r4;	 Catch:{ all -> 0x0046 }
        com.google.common.base.Preconditions.checkState(r0, r1, r2);	 Catch:{ all -> 0x0046 }
        monitor-exit(r5);	 Catch:{ all -> 0x0046 }
    L_0x002e:
        return;
    L_0x002f:
        r1 = r9.mComponentMutex;	 Catch:{ all -> 0x0046 }
        monitor-enter(r1);	 Catch:{ all -> 0x0046 }
        r0 = r9.mActiveComponents;	 Catch:{ all -> 0x004b }
        r0 = r0.a_();	 Catch:{ all -> 0x004b }
        r0 = r0.remove(r10);	 Catch:{ all -> 0x004b }
        if (r0 == 0) goto L_0x0049;
    L_0x003e:
        monitor-exit(r1);	 Catch:{ all -> 0x004b }
        if (r3 == 0) goto L_0x0044;
    L_0x0041:
        r10.onCollectionInvalidated();	 Catch:{  }
    L_0x0044:
        monitor-exit(r5);	 Catch:{  }
        goto L_0x002e;
    L_0x0046:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{  }
        throw r0;
    L_0x0049:
        r3 = r2;
        goto L_0x003e;
    L_0x004b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x004e:
        r0 = r6.collectionName;	 Catch:{  }
        r0 = com.google.common.base.Preconditions.checkNotNull(r0);	 Catch:{  }
        r0 = (com.facebook.omnistore.CollectionName) r0;	 Catch:{  }
        r1 = r9.mComponentMutex;	 Catch:{  }
        monitor-enter(r1);	 Catch:{  }
        r2 = r9.mActiveComponents;	 Catch:{ all -> 0x0070 }
        r2 = r2.a_();	 Catch:{ all -> 0x0070 }
        r2 = r2.remove(r10);	 Catch:{ all -> 0x0070 }
        if (r2 == 0) goto L_0x0068;
    L_0x0065:
        r10.onCollectionInvalidated();	 Catch:{ all -> 0x0070 }
    L_0x0068:
        monitor-exit(r1);	 Catch:{ all -> 0x0070 }
        r1 = r9.mOmnistore;	 Catch:{  }
        r1.unsubscribeCollection(r0);	 Catch:{  }
        monitor-exit(r5);	 Catch:{  }
        goto L_0x002e;
    L_0x0070:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0073:
        r0 = r6.collectionName;	 Catch:{  }
        r0 = com.google.common.base.Preconditions.checkNotNull(r0);	 Catch:{  }
        r0 = (com.facebook.omnistore.CollectionName) r0;	 Catch:{  }
        r7 = r9.mComponentMutex;	 Catch:{  }
        monitor-enter(r7);	 Catch:{  }
        r1 = r9.mActiveComponents;	 Catch:{ all -> 0x00b9 }
        r1 = r1.put(r0, r10);	 Catch:{ all -> 0x00b9 }
        r1 = (com.facebook.omnistore.module.OmnistoreComponent) r1;	 Catch:{ all -> 0x00b9 }
        if (r1 != 0) goto L_0x00b5;
    L_0x0088:
        r4 = r3;
    L_0x0089:
        if (r10 == r1) goto L_0x008d;
    L_0x008b:
        if (r4 == 0) goto L_0x00b7;
    L_0x008d:
        r1 = r3;
    L_0x008e:
        r2 = "Two components are trying to use the same collection name: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00b9 }
        r8 = 0;
        r3[r8] = r0;	 Catch:{ all -> 0x00b9 }
        com.google.common.base.Preconditions.checkState(r1, r2, r3);	 Catch:{ all -> 0x00b9 }
        monitor-exit(r7);	 Catch:{ all -> 0x00b9 }
        r2 = r9.mOmnistore;	 Catch:{  }
        r1 = r6.subscriptionParams;	 Catch:{  }
        if (r1 != 0) goto L_0x00bc;
    L_0x00a0:
        r1 = new com.facebook.omnistore.SubscriptionParams$Builder;	 Catch:{  }
        r1.<init>();	 Catch:{  }
        r1 = r1.build();	 Catch:{  }
    L_0x00a9:
        r0 = r2.subscribeCollection(r0, r1);	 Catch:{  }
        if (r4 == 0) goto L_0x00b2;
    L_0x00af:
        r10.onCollectionAvailable(r0);	 Catch:{  }
    L_0x00b2:
        monitor-exit(r5);	 Catch:{  }
        goto L_0x002e;
    L_0x00b5:
        r4 = r2;
        goto L_0x0089;
    L_0x00b7:
        r1 = r2;
        goto L_0x008e;
    L_0x00b9:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x00bc:
        r1 = r6.subscriptionParams;	 Catch:{  }
        goto L_0x00a9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.omnistore.module.OmnistoreComponentManager.maybeUpdateComponent(com.facebook.omnistore.module.OmnistoreComponent):void");
    }
}
