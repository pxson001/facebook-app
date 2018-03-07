package com.facebook.photos.upload.abtest;

import com.facebook.abtest.qe.bootstrap.data.QuickExperimentParameters;
import com.facebook.abtest.qe.bootstrap.framework.BaseQuickExperiment;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperiment;
import com.google.common.collect.RegularImmutableBiMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: graphql_tags_search_params */
public class PastExperimentHelper<CONFIG> {
    @GuardedBy("ui-thread")
    public CONFIG f13522a;
    @GuardedBy("this")
    private String f13523b = null;

    public PastExperimentHelper(BaseQuickExperiment<CONFIG> baseQuickExperiment) {
        this.f13522a = ((QuickExperiment) baseQuickExperiment).a(new QuickExperimentParameters(false, false, "local_default_group", RegularImmutableBiMap.a));
    }

    public void mo1126a() {
    }

    public final void m21202a(CONFIG config, String str) {
        this.f13522a = config;
        synchronized (this) {
            this.f13523b = str;
        }
    }

    public final synchronized String m21203e() {
        return this.f13523b;
    }
}
