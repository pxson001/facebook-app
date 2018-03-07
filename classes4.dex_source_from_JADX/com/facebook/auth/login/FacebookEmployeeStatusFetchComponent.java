package com.facebook.auth.login;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.protocol.FetchEmployeeStatusGraphqlMethod;
import com.facebook.config.background.AbstractConfigurationComponent;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.facebook.user.model.UserBuilder;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: rtc_call_info */
public class FacebookEmployeeStatusFetchComponent extends AbstractConfigurationComponent {
    private static volatile FacebookEmployeeStatusFetchComponent f3281d;
    @Inject
    public LoggedInUserSessionManager f3282a;
    @Inject
    public FetchEmployeeStatusGraphqlMethod f3283b;
    private final MyBatchComponent f3284c = new MyBatchComponent(this);

    /* compiled from: rtc_call_info */
    class MyBatchComponent implements BatchComponent {
        final /* synthetic */ FacebookEmployeeStatusFetchComponent f3285a;

        public MyBatchComponent(FacebookEmployeeStatusFetchComponent facebookEmployeeStatusFetchComponent) {
            this.f3285a = facebookEmployeeStatusFetchComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            Builder a = BatchOperation.m12541a(this.f3285a.f3283b, null);
            a.f11927c = "fetchFacebookEmployeeStatus";
            return ImmutableList.of(a.m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            Boolean bool = (Boolean) map.get("fetchFacebookEmployeeStatus");
            if (bool != null) {
                User c = this.f3285a.f3282a.c();
                if (c != null) {
                    UserBuilder userBuilder = new UserBuilder();
                    userBuilder.a(c);
                    userBuilder.v = bool.booleanValue();
                    this.f3285a.f3282a.c(userBuilder.aa());
                }
            }
        }
    }

    public static com.facebook.auth.login.FacebookEmployeeStatusFetchComponent m3487a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3281d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.auth.login.FacebookEmployeeStatusFetchComponent.class;
        monitor-enter(r1);
        r0 = f3281d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3488b(r0);	 Catch:{ all -> 0x0035 }
        f3281d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3281d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.auth.login.FacebookEmployeeStatusFetchComponent.a(com.facebook.inject.InjectorLike):com.facebook.auth.login.FacebookEmployeeStatusFetchComponent");
    }

    private static FacebookEmployeeStatusFetchComponent m3488b(InjectorLike injectorLike) {
        FacebookEmployeeStatusFetchComponent facebookEmployeeStatusFetchComponent = new FacebookEmployeeStatusFetchComponent();
        FetchEmployeeStatusGraphqlMethod b = FetchEmployeeStatusGraphqlMethod.m3493b(injectorLike);
        facebookEmployeeStatusFetchComponent.f3282a = LoggedInUserSessionManager.a(injectorLike);
        facebookEmployeeStatusFetchComponent.f3283b = b;
        return facebookEmployeeStatusFetchComponent;
    }

    public final BatchComponent mo101b() {
        return this.f3284c;
    }

    public final long co_() {
        User c = this.f3282a.c();
        return (c == null || !c.o) ? 604800000 : 86400000;
    }
}
