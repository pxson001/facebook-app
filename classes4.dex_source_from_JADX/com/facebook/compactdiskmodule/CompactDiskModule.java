package com.facebook.compactdiskmodule;

import android.content.Context;
import com.facebook.common.locale.Locales;
import com.facebook.common.time.MonotonicClock;
import com.facebook.compactdisk.AnalyticsEventReporterHolder;
import com.facebook.compactdisk.AttributeStoreHolder;
import com.facebook.compactdisk.Configuration;
import com.facebook.compactdisk.ConfigurationOverrides;
import com.facebook.compactdisk.DiskSizeCalculator;
import com.facebook.compactdisk.DiskSizeCalculatorHolder;
import com.facebook.compactdisk.ExperimentManager;
import com.facebook.compactdisk.FileUtilsHolder;
import com.facebook.compactdisk.LazyDispatcher;
import com.facebook.compactdisk.PrivacyGuard;
import com.facebook.compactdisk.StoreDirectoryNameBuilderFactory;
import com.facebook.compactdisk.StoreManagerFactory;
import com.facebook.compactdisk.TaskQueueFactoryHolder;
import com.facebook.compactdisk.TrashCollector;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: mem_available */
public class CompactDiskModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    public static FileUtilsHolder m8436a() {
        return new FileUtilsHolder();
    }

    @ProviderMethod
    @Singleton
    public static AttributeStoreHolder m8432a(FileUtilsHolder fileUtilsHolder) {
        return new AttributeStoreHolder(fileUtilsHolder);
    }

    @ProviderMethod
    @Singleton
    public static AnalyticsEventReporterHolder m8431a(AndroidXAnalyticsLogger androidXAnalyticsLogger) {
        return new AnalyticsEventReporterHolder(androidXAnalyticsLogger);
    }

    @ProviderMethod
    @Singleton
    public static Configuration m8443b() {
        return new Configuration();
    }

    @ProviderMethod
    @Singleton
    public static ConfigurationOverrides m8444c() {
        return new ConfigurationOverrides();
    }

    @ProviderMethod
    @Singleton
    public static DiskSizeCalculatorHolder m8434a(FileUtilsHolder fileUtilsHolder, AttributeStoreHolder attributeStoreHolder, AnalyticsEventReporterHolder analyticsEventReporterHolder, ScheduledExecutorService scheduledExecutorService, MonotonicClock monotonicClock) {
        return new DiskSizeCalculatorHolder(fileUtilsHolder, attributeStoreHolder, analyticsEventReporterHolder, scheduledExecutorService, monotonicClock);
    }

    @ProviderMethod
    @Singleton
    public static DiskSizeCalculator m8433a(DiskSizeCalculatorHolder diskSizeCalculatorHolder) {
        return new DiskSizeCalculator(diskSizeCalculatorHolder);
    }

    @ProviderMethod
    @Singleton
    public static ExperimentManager m8435a(Context context, FileUtilsHolder fileUtilsHolder) {
        return new ExperimentManager(context, fileUtilsHolder);
    }

    @ProviderMethod
    @Singleton
    public static LazyDispatcher m8437a(TaskQueueFactoryHolder taskQueueFactoryHolder) {
        return new LazyDispatcher(taskQueueFactoryHolder);
    }

    @ProviderMethod
    @Singleton
    public static StoreDirectoryNameBuilderFactory m8439a(Locales locales) {
        return new StoreDirectoryNameBuilderFactory(locales.a().toString(), Locales.e().toString());
    }

    @ProviderMethod
    @Singleton
    public static TaskQueueFactoryHolder m8441a(ScheduledExecutorService scheduledExecutorService) {
        return new TaskQueueFactoryHolder(scheduledExecutorService);
    }

    @ProviderMethod
    @Singleton
    public static TrashCollector m8442a(Context context, FileUtilsHolder fileUtilsHolder, AnalyticsEventReporterHolder analyticsEventReporterHolder, TaskQueueFactoryHolder taskQueueFactoryHolder) {
        return new TrashCollector(context, fileUtilsHolder, analyticsEventReporterHolder, taskQueueFactoryHolder);
    }

    @ProviderMethod
    @Singleton
    public static PrivacyGuard m8438a(Context context) {
        return new PrivacyGuard(context);
    }

    @ProviderMethod
    @Singleton
    public static StoreManagerFactory m8440a(Context context, AnalyticsEventReporterHolder analyticsEventReporterHolder, AttributeStoreHolder attributeStoreHolder, Configuration configuration, DiskSizeCalculator diskSizeCalculator, DiskSizeCalculatorHolder diskSizeCalculatorHolder, ConfigurationOverrides configurationOverrides, FileUtilsHolder fileUtilsHolder, LazyDispatcher lazyDispatcher, ExperimentManager experimentManager, StoreDirectoryNameBuilderFactory storeDirectoryNameBuilderFactory, TaskQueueFactoryHolder taskQueueFactoryHolder, TrashCollector trashCollector, PrivacyGuard privacyGuard) {
        return new StoreManagerFactory(context, analyticsEventReporterHolder, attributeStoreHolder, configuration, diskSizeCalculator, diskSizeCalculatorHolder, configurationOverrides, fileUtilsHolder, lazyDispatcher, experimentManager, storeDirectoryNameBuilderFactory, taskQueueFactoryHolder, trashCollector, privacyGuard);
    }
}
