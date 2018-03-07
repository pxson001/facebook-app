package com.facebook.compactdisk;

import android.content.Context;
import com.facebook.compactdisk.LazySingletonMap.Factory;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: me/staging_resources */
public class StoreManagerFactory {
    private final DiskSizeCalculator f8165a;
    private PrivacyGuard f8166b;
    private LazySingletonMap<String, StoreManager> f8167c = new LazySingletonMap(new C03971(this));
    @DoNotStrip
    private final HybridData mHybridData;

    /* compiled from: me/staging_resources */
    class C03971 implements Factory<String, StoreManager> {
        final /* synthetic */ StoreManagerFactory f8188a;

        C03971(StoreManagerFactory storeManagerFactory) {
            this.f8188a = storeManagerFactory;
        }

        public final Object mo670a(Object obj) {
            return this.f8188a.createStoreManager((String) obj);
        }
    }

    private native StoreManager createStoreManager(String str);

    private native HybridData initHybrid(AnalyticsEventReporterHolder analyticsEventReporterHolder, AttributeStoreHolder attributeStoreHolder, Configuration configuration, DiskSizeCalculatorHolder diskSizeCalculatorHolder, ConfigurationOverrides configurationOverrides, FileUtilsHolder fileUtilsHolder, LazyDispatcher lazyDispatcher, ExperimentManager experimentManager, PathLocations pathLocations, StoreDirectoryNameBuilderFactory storeDirectoryNameBuilderFactory, TaskQueueFactoryHolder taskQueueFactoryHolder, TrashCollector trashCollector, PrivacyGuard privacyGuard);

    private native String managerNameForDiskCacheConfig(DiskCacheConfig diskCacheConfig);

    private native void nativeInvalidate();

    static {
        SoLoader.a("compactdisk-jni");
    }

    public final StoreManager m8454a(String str) {
        return (StoreManager) this.f8167c.m8485a(str);
    }

    public final StoreManager m8453a(DiskCacheConfig diskCacheConfig) {
        return m8454a(managerNameForDiskCacheConfig(diskCacheConfig));
    }

    public final void m8455a() {
        this.f8167c.m8486a();
        nativeInvalidate();
    }

    public StoreManagerFactory(Context context, AnalyticsEventReporterHolder analyticsEventReporterHolder, AttributeStoreHolder attributeStoreHolder, Configuration configuration, DiskSizeCalculator diskSizeCalculator, DiskSizeCalculatorHolder diskSizeCalculatorHolder, ConfigurationOverrides configurationOverrides, FileUtilsHolder fileUtilsHolder, LazyDispatcher lazyDispatcher, ExperimentManager experimentManager, StoreDirectoryNameBuilderFactory storeDirectoryNameBuilderFactory, TaskQueueFactoryHolder taskQueueFactoryHolder, TrashCollector trashCollector, PrivacyGuard privacyGuard) {
        this.f8165a = diskSizeCalculator;
        this.f8166b = privacyGuard;
        this.mHybridData = initHybrid(analyticsEventReporterHolder, attributeStoreHolder, configuration, diskSizeCalculatorHolder, configurationOverrides, fileUtilsHolder, lazyDispatcher, experimentManager, new PathLocations(context), storeDirectoryNameBuilderFactory, taskQueueFactoryHolder, trashCollector, privacyGuard);
    }
}
