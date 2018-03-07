package com.facebook.abtest.qe.bootstrap.cache;

import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.abtest.qe.bootstrap.db.DataSource;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryInterfaces.Configuration;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationModel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: update_favorite_contacts */
public interface QuickExperimentMemoryCache {

    /* compiled from: update_favorite_contacts */
    public interface QuickExperimentMemoryCacheInitializer {
        void mo556a();
    }

    @Deprecated
    /* compiled from: update_favorite_contacts */
    public interface QuickExperimentMemoryCacheObserver {
        void mo634b();

        void mo635c();
    }

    QuickExperimentInfo mo536a(String str, DataSource dataSource);

    @Nullable
    ConfigurationModel mo537a(String str);

    ListenableFuture<QuickExperimentMemoryCache> mo538a();

    void mo539a(QuickExperimentMemoryCacheObserver quickExperimentMemoryCacheObserver);

    QuickExperimentInfo mo540b(String str);

    void mo541b();

    void mo542c();

    Map<String, Configuration> mo543d();

    QuickExperimentMemoryCacheInitializer mo544e();
}
