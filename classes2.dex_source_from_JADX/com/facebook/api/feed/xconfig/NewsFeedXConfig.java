package com.facebook.api.feed.xconfig;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: share_abandoned */
public class NewsFeedXConfig extends XConfig {
    public static final XConfigSetting f4993A = new XConfigSetting(f4997c, "memory_savings_stories_to_keep");
    public static final XConfigSetting f4994B = new XConfigSetting(f4997c, "cold_start_num_stories_on_db_fetch");
    public static final ImmutableSet<XConfigSetting> f4995C = ImmutableSet.of(f4998d, f4999e, f5000f, f5001g, f5002h, f5003i, f5004j, f5005k, f5006l, f5007m, f5008n, f5009o, f5010p, f5011q, f5012r, f5013s, f5014t, f5016v, f5017w, f5018x, f5019y, f5020z, f4993A, f4994B);
    private static volatile NewsFeedXConfig f4996D;
    public static final XConfigName f4997c = new XConfigName("android_newsfeed");
    public static final XConfigSetting f4998d = new XConfigSetting(f4997c, "stories_per_initial_fetch");
    public static final XConfigSetting f4999e = new XConfigSetting(f4997c, "stories_per_tail_fetch");
    public static final XConfigSetting f5000f = new XConfigSetting(f4997c, "chunked_first_fetch_size");
    public static final XConfigSetting f5001g = new XConfigSetting(f4997c, "min_newsfeed_db_size");
    public static final XConfigSetting f5002h = new XConfigSetting(f4997c, "min_unshown_stories_in_feed_adapter");
    public static final XConfigSetting f5003i = new XConfigSetting(f4997c, "unshown_stories_in_feed_adapter_tail_before_prune");
    public static final XConfigSetting f5004j = new XConfigSetting(f4997c, "num_stories_to_keep_in_feed_adapter_tail_after_prune");
    public static final XConfigSetting f5005k = new XConfigSetting(f4997c, "cold_start_frozen_feed_time_ms");
    public static final XConfigSetting f5006l = new XConfigSetting(f4997c, "streaming_fetch_story_count");
    public static final XConfigSetting f5007m = new XConfigSetting(f4997c, "streaming_fetch_rerun_count");
    public static final XConfigSetting f5008n = new XConfigSetting(f4997c, "min_unshown_stories_in_feed_adapter_by_cc");
    public static final XConfigSetting f5009o = new XConfigSetting(f4997c, "streaming_fetch_story_count_by_cc");
    public static final XConfigSetting f5010p = new XConfigSetting(f4997c, "streaming_fetch_rerun_count_by_cc");
    public static final XConfigSetting f5011q = new XConfigSetting(f4997c, "tail_fetch_story_count_by_cc");
    public static final XConfigSetting f5012r = new XConfigSetting(f4997c, "tail_fetch_rerun_count_by_cc");
    public static final XConfigSetting f5013s = new XConfigSetting(f4997c, "story_max_age_in_cache_in_hours");
    public static final XConfigSetting f5014t = new XConfigSetting(f4997c, "empty_layout_spinner_delay_ms");
    public static final XConfigSetting f5015u = new XConfigSetting(f4997c, "max_crash_count_before_feed_reset");
    public static final XConfigSetting f5016v = new XConfigSetting(f4997c, "stack_stories_behind_nsp");
    public static final XConfigSetting f5017w = new XConfigSetting(f4997c, "tail_fetch_from_db_enabled_by_cc");
    public static final XConfigSetting f5018x = new XConfigSetting(f4997c, "max_allowed_empty_tail_fetches");
    public static final XConfigSetting f5019y = new XConfigSetting(f4997c, "memory_savings_gap_position");
    public static final XConfigSetting f5020z = new XConfigSetting(f4997c, "memory_savings_max_story_count");

    public static com.facebook.api.feed.xconfig.NewsFeedXConfig m8933a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f4996D;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.api.feed.xconfig.NewsFeedXConfig.class;
        monitor-enter(r1);
        r0 = f4996D;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m8932a();	 Catch:{ all -> 0x0034 }
        f4996D = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f4996D;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feed.xconfig.NewsFeedXConfig.a(com.facebook.inject.InjectorLike):com.facebook.api.feed.xconfig.NewsFeedXConfig");
    }

    private static NewsFeedXConfig m8932a() {
        return new NewsFeedXConfig();
    }

    @Inject
    public NewsFeedXConfig() {
        super(f4997c, f4995C);
    }
}
