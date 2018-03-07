package com.facebook.messaging.cache;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.folders.ThreadTypeFilter;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.push.mqtt.service.ChannelConnectivityTracker;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: messenger_user_control */
public class ThreadsCacheUpdateRateLimiter {
    private static final Class<?> f9588a = ThreadsCacheUpdateRateLimiter.class;
    private static final Object f9589m = new Object();
    private final DataCache f9590b;
    private final ChannelConnectivityTracker f9591c;
    private final Clock f9592d;
    private final Product f9593e;
    private final Provider<Boolean> f9594f;
    private final Provider<Boolean> f9595g;
    private final Provider<Boolean> f9596h;
    private final Map<FolderName, Long> f9597i = Maps.c();
    private final Map<FolderName, Long> f9598j = Maps.c();
    private final Map<ThreadKey, Long> f9599k = Maps.c();
    private final Map<ThreadKey, Long> f9600l = Maps.c();

    @VisibleForTesting
    /* compiled from: messenger_user_control */
    public class DataFreshnessParamWithReason {
        public final DataFreshnessParam f9586a;
        public final Reason f9587b;

        DataFreshnessParamWithReason(@Nullable DataFreshnessParam dataFreshnessParam, Reason reason) {
            this.f9586a = dataFreshnessParam;
            this.f9587b = reason;
        }
    }

    /* compiled from: messenger_user_control */
    public enum Reason {
        SPECIFIC_INTENTION,
        MQTT_RECENTLY_DISCONNECTED,
        MQTT_DISCONNECTED_AND_NOT_RECENTLY_UPDATED,
        MQTT_CONNECTED,
        OLD_DATA,
        OLD_DATA_PAGES_MANAGER,
        DATA_KNOWN_TO_BE_STALE,
        DEFAULT
    }

    private static ThreadsCacheUpdateRateLimiter m10192b(InjectorLike injectorLike) {
        return new ThreadsCacheUpdateRateLimiter(DataCache.a(injectorLike), ChannelConnectivityTracker.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 4075), IdBasedProvider.a(injectorLike, 4087), IdBasedProvider.a(injectorLike, 4088));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.cache.ThreadsCacheUpdateRateLimiter m10190a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f9589m;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m10192b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9589m;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.ThreadsCacheUpdateRateLimiter) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.cache.ThreadsCacheUpdateRateLimiter) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f9589m;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.ThreadsCacheUpdateRateLimiter) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.cache.ThreadsCacheUpdateRateLimiter.a(com.facebook.inject.InjectorLike):com.facebook.messaging.cache.ThreadsCacheUpdateRateLimiter");
    }

    @Inject
    public ThreadsCacheUpdateRateLimiter(DataCache dataCache, ChannelConnectivityTracker channelConnectivityTracker, Clock clock, Product product, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3) {
        this.f9590b = dataCache;
        this.f9591c = channelConnectivityTracker;
        this.f9592d = clock;
        this.f9593e = product;
        this.f9594f = provider;
        this.f9595g = provider2;
        this.f9596h = provider3;
    }

    public final boolean m10198a(FolderName folderName) {
        if (m10188a(folderName, null, false).f9586a != null) {
            return true;
        }
        return false;
    }

    public final DataFreshnessParam m10196a(FolderName folderName, DataFreshnessParam dataFreshnessParam) {
        return m10188a(folderName, dataFreshnessParam, true).f9586a;
    }

    @VisibleForTesting
    private synchronized DataFreshnessParamWithReason m10188a(FolderName folderName, @Nullable DataFreshnessParam dataFreshnessParam, boolean z) {
        DataFreshnessParamWithReason dataFreshnessParamWithReason;
        if (BLog.b(2)) {
            StringBuilder stringBuilder = new StringBuilder("upgradeDataFreshnessForThreadListRequest called for:");
            stringBuilder.append(" folder=").append(folderName.dbName);
            if (dataFreshnessParam != null) {
                stringBuilder.append(" freshness=").append(dataFreshnessParam.toString());
            }
            stringBuilder.append(" updateTimestamp=").append(z);
        }
        if (dataFreshnessParam == DataFreshnessParam.DO_NOT_CHECK_SERVER || dataFreshnessParam == DataFreshnessParam.STALE_DATA_OKAY || dataFreshnessParam == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
            dataFreshnessParamWithReason = new DataFreshnessParamWithReason(dataFreshnessParam, Reason.SPECIFIC_INTENTION);
        } else {
            if (!(((Boolean) this.f9594f.get()).booleanValue() && ((Boolean) this.f9595g.get()).booleanValue())) {
                long a = this.f9592d.a();
                long c = this.f9590b.c(folderName, ThreadTypeFilter.ALL);
                long b = m10191b(folderName);
                long d = this.f9591c.d();
                if (BLog.b(2)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("upgradeDataFreshnessForThreadListRequest mqtt timestamps:");
                    stringBuilder2.append("disconnectedMqttEarliestRetryMs=").append(b);
                    stringBuilder2.append("lastDisconnectionTimeStampMS=").append(d);
                    stringBuilder2.append("lastUpdatedTimeMs=").append(c);
                    stringBuilder2.append("now=").append(a);
                }
                if (d > 0 && c < d && b < a) {
                    if (z) {
                        new StringBuilder("Upgrading timestamp mDisconnectedMqttEarliestRetryMsForFolders:").append(b);
                        this.f9597i.put(folderName, Long.valueOf(a + 60000));
                    }
                    dataFreshnessParamWithReason = new DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, Reason.MQTT_RECENTLY_DISCONNECTED);
                } else if (this.f9591c.f() || a - c < 300000) {
                    b = m10193c(folderName);
                    if (this.f9591c.e() && c < this.f9591c.c() && b < a) {
                        if (z) {
                            this.f9598j.put(folderName, Long.valueOf(a + 60000));
                        }
                        dataFreshnessParamWithReason = new DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, Reason.MQTT_CONNECTED);
                    } else if (a - c >= 1800000) {
                        dataFreshnessParamWithReason = new DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, Reason.OLD_DATA);
                    } else if (a - c >= 600000 && this.f9593e == Product.PAA) {
                        dataFreshnessParamWithReason = new DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, Reason.OLD_DATA_PAGES_MANAGER);
                    }
                } else {
                    dataFreshnessParamWithReason = new DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, Reason.MQTT_DISCONNECTED_AND_NOT_RECENTLY_UPDATED);
                }
            }
            dataFreshnessParamWithReason = !this.f9590b.b(folderName) ? new DataFreshnessParamWithReason(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, Reason.DATA_KNOWN_TO_BE_STALE) : new DataFreshnessParamWithReason(dataFreshnessParam, Reason.DEFAULT);
        }
        return dataFreshnessParamWithReason;
    }

    public final boolean m10199a(@Nullable ThreadKey threadKey) {
        if (m10189a(threadKey, null, false).f9586a != null) {
            return true;
        }
        return false;
    }

    public final boolean m10200b(@Nullable ThreadKey threadKey) {
        if (m10189a(threadKey, null, false).f9586a == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
            return true;
        }
        return false;
    }

    public final DataFreshnessParam m10197a(@Nullable ThreadKey threadKey, DataFreshnessParam dataFreshnessParam) {
        return m10189a(threadKey, dataFreshnessParam, true).f9586a;
    }

    @VisibleForTesting
    private synchronized DataFreshnessParamWithReason m10189a(@Nullable ThreadKey threadKey, @Nullable DataFreshnessParam dataFreshnessParam, boolean z) {
        DataFreshnessParamWithReason dataFreshnessParamWithReason;
        if (threadKey != null) {
            if (!(dataFreshnessParam == DataFreshnessParam.DO_NOT_CHECK_SERVER || dataFreshnessParam == DataFreshnessParam.STALE_DATA_OKAY || dataFreshnessParam == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA)) {
                if (!(((Boolean) this.f9594f.get()).booleanValue() && ((Boolean) this.f9596h.get()).booleanValue())) {
                    long d = this.f9590b.d(threadKey);
                    long a = this.f9592d.a();
                    long c = m10194c(threadKey);
                    if (d < this.f9591c.d() && c < a) {
                        if (z) {
                            this.f9599k.put(threadKey, Long.valueOf(a + 60000));
                        }
                        dataFreshnessParamWithReason = new DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, Reason.MQTT_RECENTLY_DISCONNECTED);
                    } else if (this.f9591c.f() || a - d < 300000) {
                        c = m10195d(threadKey);
                        if (this.f9591c.e() && d < this.f9591c.c() && c < a) {
                            if (z) {
                                this.f9600l.put(threadKey, Long.valueOf(a + 60000));
                            }
                            dataFreshnessParamWithReason = new DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, Reason.MQTT_CONNECTED);
                        } else if (a - d >= 600000) {
                            dataFreshnessParamWithReason = new DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, Reason.OLD_DATA);
                        } else if (a - d >= 180000 && this.f9593e == Product.PAA) {
                            dataFreshnessParamWithReason = new DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, Reason.OLD_DATA_PAGES_MANAGER);
                        }
                    } else {
                        dataFreshnessParamWithReason = new DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, Reason.MQTT_DISCONNECTED_AND_NOT_RECENTLY_UPDATED);
                    }
                }
                dataFreshnessParamWithReason = !this.f9590b.a(threadKey, 20) ? new DataFreshnessParamWithReason(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, Reason.DATA_KNOWN_TO_BE_STALE) : new DataFreshnessParamWithReason(dataFreshnessParam, Reason.DEFAULT);
            }
        }
        dataFreshnessParamWithReason = new DataFreshnessParamWithReason(dataFreshnessParam, Reason.SPECIFIC_INTENTION);
        return dataFreshnessParamWithReason;
    }

    private long m10191b(FolderName folderName) {
        Long l = (Long) this.f9597i.get(folderName);
        return l != null ? l.longValue() : -1;
    }

    private long m10193c(FolderName folderName) {
        Long l = (Long) this.f9598j.get(folderName);
        return l != null ? l.longValue() : -1;
    }

    private long m10194c(ThreadKey threadKey) {
        Long l = (Long) this.f9599k.get(threadKey);
        return l != null ? l.longValue() : -1;
    }

    private long m10195d(ThreadKey threadKey) {
        Long l = (Long) this.f9600l.get(threadKey);
        return l != null ? l.longValue() : -1;
    }
}
