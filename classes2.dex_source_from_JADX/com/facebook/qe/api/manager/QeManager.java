package com.facebook.qe.api.manager;

import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: unfan_page */
public interface QeManager {
    void mo586a();

    void mo587a(QuickExperimentInfo quickExperimentInfo);

    void mo591a(String str);

    void mo592a(Map<String, SyncedExperimentData> map, boolean z);

    boolean mo595a(Authority authority, String str);

    @Nullable
    String mo597b(Authority authority, String str);

    void mo598b();

    boolean mo599b(String str);

    Iterable<String> mo600c();

    @Nullable
    String mo601c(Authority authority, String str);

    boolean mo602c(String str);

    Iterable<String> mo603d();

    @Nullable
    Map<String, String> mo604d(Authority authority, String str);

    void mo605d(String str);

    Iterable<String> mo606e();

    void mo607e(String str);

    boolean mo608f();
}
