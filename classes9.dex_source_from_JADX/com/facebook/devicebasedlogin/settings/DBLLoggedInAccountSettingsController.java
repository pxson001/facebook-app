package com.facebook.devicebasedlogin.settings;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.bootstrapcache.core.BootstrapCache;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.devicebasedlogin.logging.DBLLoggerHelper;
import com.facebook.devicebasedlogin.settings.DBLSettingsItem.ItemViewType;
import com.facebook.devicebasedlogin.settings.DBLSettingsItem.SettingCategory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.dbl.DBLRequestHelper;
import com.facebook.katana.dbl.DBLStorageAndRetrievalHelper;
import com.facebook.katana.dbl.FetchDBLNonceInfoQuery.FetchDBLNonceInfoQueryString;
import com.facebook.katana.dbl.FetchDBLNonceInfoQueryModels.FetchDBLNonceInfoQueryModel;
import com.facebook.katana.dbl.FetchDBLNonceInfoQueryModels.FetchDBLNonceInfoQueryModel.DeviceBasedLoginNonceInfosModel;
import com.facebook.katana.dbl.FetchDBLNonceInfoQueryModels.FetchDBLNonceInfoQueryModel.DeviceBasedLoginNonceInfosModel.NodesModel;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: The player finished playing before pause() was called */
public class DBLLoggedInAccountSettingsController {
    private static volatile DBLLoggedInAccountSettingsController f24181l;
    public final DBLStorageAndRetrievalHelper f24182a;
    public final Provider<User> f24183b;
    public final Context f24184c;
    private final DefaultBlueServiceOperationFactory f24185d;
    private final BootstrapCache f24186e;
    private final DBLLoggerHelper f24187f;
    private final ExecutorService f24188g;
    public final GraphQLQueryExecutor f24189h;
    private final FbSharedPreferences f24190i;
    public final DBLRequestHelper f24191j;
    private List<DBLSettingsItem> f24192k = new ArrayList();

    /* compiled from: The player finished playing before pause() was called */
    public enum LoggedInAccountType {
        NO_DBL,
        DBL_WITHOUT_PIN,
        DBL_WITH_PIN,
        SAVED_ID,
        DBL_WITHOUT_PIN_CAN_SAVE_ID,
        DBL_WITH_PIN_CAN_SAVE_ID
    }

    public static com.facebook.devicebasedlogin.settings.DBLLoggedInAccountSettingsController m26140a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f24181l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.devicebasedlogin.settings.DBLLoggedInAccountSettingsController.class;
        monitor-enter(r1);
        r0 = f24181l;	 Catch:{ all -> 0x003a }
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
        r0 = m26142b(r0);	 Catch:{ all -> 0x0035 }
        f24181l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f24181l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.devicebasedlogin.settings.DBLLoggedInAccountSettingsController.a(com.facebook.inject.InjectorLike):com.facebook.devicebasedlogin.settings.DBLLoggedInAccountSettingsController");
    }

    private static DBLLoggedInAccountSettingsController m26142b(InjectorLike injectorLike) {
        return new DBLLoggedInAccountSettingsController(DBLStorageAndRetrievalHelper.b(injectorLike), IdBasedProvider.a(injectorLike, 3595), (Context) injectorLike.getInstance(Context.class), DefaultBlueServiceOperationFactory.b(injectorLike), BootstrapCache.b(injectorLike), DBLLoggerHelper.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), DBLRequestHelper.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public DBLLoggedInAccountSettingsController(DBLStorageAndRetrievalHelper dBLStorageAndRetrievalHelper, Provider<User> provider, Context context, BlueServiceOperationFactory blueServiceOperationFactory, BootstrapCache bootstrapCache, DBLLoggerHelper dBLLoggerHelper, ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, DBLRequestHelper dBLRequestHelper, FbSharedPreferences fbSharedPreferences) {
        this.f24182a = dBLStorageAndRetrievalHelper;
        this.f24183b = provider;
        this.f24184c = context;
        this.f24185d = blueServiceOperationFactory;
        this.f24186e = bootstrapCache;
        this.f24187f = dBLLoggerHelper;
        this.f24188g = executorService;
        this.f24189h = graphQLQueryExecutor;
        this.f24191j = dBLRequestHelper;
        this.f24190i = fbSharedPreferences;
    }

    public final List<DBLSettingsItem> m26155c() {
        LoggedInAccountType d = m26143d();
        List<DBLSettingsItem> arrayList = new ArrayList();
        arrayList.add(new DBLSettingsItem(this.f24184c.getResources().getString(2131236287), "", "", false, null, ItemViewType.CATEGORY, ""));
        switch (d) {
            case DBL_WITHOUT_PIN:
                arrayList.add(m26145f());
                arrayList.add(m26148i());
                break;
            case DBL_WITH_PIN:
                arrayList.add(m26146g());
                arrayList.add(m26147h());
                arrayList.add(m26148i());
                break;
            case SAVED_ID:
                arrayList.add(m26149j());
                arrayList.add(m26150k());
                arrayList.add(m26148i());
                break;
            case DBL_WITH_PIN_CAN_SAVE_ID:
                arrayList.add(m26146g());
                arrayList.add(m26147h());
                arrayList.add(m26151l());
                arrayList.add(m26152m());
                break;
            case DBL_WITHOUT_PIN_CAN_SAVE_ID:
                arrayList.add(m26145f());
                arrayList.add(m26151l());
                arrayList.add(m26152m());
                break;
        }
        if (!this.f24192k.isEmpty()) {
            arrayList.add(m26153o());
            arrayList.addAll(this.f24192k);
        }
        return arrayList;
    }

    private LoggedInAccountType m26143d() {
        DBLFacebookCredentials c = this.f24182a.c(((User) this.f24183b.get()).a);
        if (c == null) {
            return LoggedInAccountType.NO_DBL;
        }
        if (c.mNonce.equals("password_account")) {
            return LoggedInAccountType.SAVED_ID;
        }
        if (c.mIsPinSet.booleanValue()) {
            if (m26144e()) {
                return LoggedInAccountType.DBL_WITH_PIN_CAN_SAVE_ID;
            }
            return LoggedInAccountType.DBL_WITH_PIN;
        } else if (m26144e()) {
            return LoggedInAccountType.DBL_WITHOUT_PIN_CAN_SAVE_ID;
        } else {
            return LoggedInAccountType.DBL_WITHOUT_PIN;
        }
    }

    private boolean m26144e() {
        return this.f24182a.d(((User) this.f24183b.get()).a);
    }

    private DBLSettingsItem m26145f() {
        return new DBLSettingsItem(this.f24184c.getResources().getString(2131236236), this.f24184c.getResources().getString(2131236259), "", false, SettingCategory.ADD_PASSCODE, ItemViewType.PREFERENCE, "");
    }

    private DBLSettingsItem m26146g() {
        return new DBLSettingsItem(this.f24184c.getResources().getString(2131236249), "", "", false, SettingCategory.CHANGE_PASSCODE, ItemViewType.PREFERENCE, "");
    }

    private DBLSettingsItem m26147h() {
        return new DBLSettingsItem(this.f24184c.getResources().getString(2131236251), "", "", false, SettingCategory.REMOVE_PASSCODE, ItemViewType.PREFERENCE, "");
    }

    private DBLSettingsItem m26148i() {
        return new DBLSettingsItem(this.f24184c.getResources().getString(2131236294), this.f24184c.getResources().getString(2131236295), "", true, SettingCategory.REMOVE_ACCOUNT, ItemViewType.PREFERENCE, "");
    }

    private DBLSettingsItem m26149j() {
        return new DBLSettingsItem(this.f24184c.getResources().getString(2131236255), this.f24184c.getResources().getString(2131236257), "", false, SettingCategory.REMEMBER_PASSWORD, ItemViewType.PREFERENCE, "");
    }

    private DBLSettingsItem m26150k() {
        return new DBLSettingsItem(this.f24184c.getResources().getString(2131236258), this.f24184c.getResources().getString(2131236259), "", false, SettingCategory.USE_PASSCODE, ItemViewType.PREFERENCE, "");
    }

    private DBLSettingsItem m26151l() {
        return new DBLSettingsItem(this.f24184c.getResources().getString(2131236256), this.f24184c.getResources().getString(2131236260), "", false, SettingCategory.USE_PASSWORD, ItemViewType.PREFERENCE, "");
    }

    private DBLSettingsItem m26152m() {
        return new DBLSettingsItem(this.f24184c.getResources().getString(2131236294), this.f24184c.getResources().getString(2131236295), "", true, SettingCategory.RESET_SETTINGS, ItemViewType.PREFERENCE, "");
    }

    private DBLSettingsItem m26153o() {
        return new DBLSettingsItem(this.f24184c.getResources().getString(2131236288), "", "", false, null, ItemViewType.CATEGORY, "");
    }

    public final void m26154a(final Runnable runnable, final Context context) {
        this.f24192k.clear();
        Futures.a(this.f24189h.a(GraphQLRequest.a(new FetchDBLNonceInfoQueryString()).a(GraphQLCachePolicy.c)), new FutureCallback<GraphQLResult<FetchDBLNonceInfoQueryModel>>(this) {
            final /* synthetic */ DBLLoggedInAccountSettingsController f24179c;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null) {
                    try {
                        FetchDBLNonceInfoQueryModel fetchDBLNonceInfoQueryModel = (FetchDBLNonceInfoQueryModel) graphQLResult.d();
                        if (!(fetchDBLNonceInfoQueryModel == null || fetchDBLNonceInfoQueryModel.a() == null)) {
                            DBLLoggedInAccountSettingsController.m26141a(this.f24179c, fetchDBLNonceInfoQueryModel.a());
                        }
                    } catch (Exception e) {
                    }
                }
                ((Activity) context).runOnUiThread(runnable);
            }

            public void onFailure(Throwable th) {
                ((Activity) context).runOnUiThread(runnable);
            }
        }, this.f24188g);
    }

    public static void m26141a(DBLLoggedInAccountSettingsController dBLLoggedInAccountSettingsController, DeviceBasedLoginNonceInfosModel deviceBasedLoginNonceInfosModel) {
        String a = dBLLoggedInAccountSettingsController.f24190i.a(AuthPrefKeys.f, null);
        ImmutableList a2 = deviceBasedLoginNonceInfosModel.a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) a2.get(i);
            if (!(nodesModel.l() || nodesModel.a().equals(a))) {
                String string;
                String string2 = dBLLoggedInAccountSettingsController.f24184c.getResources().getString(2131236289, new Object[]{nodesModel.j().a()});
                Date date = new Date(nodesModel.m() * 1000);
                DateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
                String string3 = dBLLoggedInAccountSettingsController.f24184c.getResources().getString(2131236290, new Object[]{simpleDateFormat.format(date)});
                Resources resources = dBLLoggedInAccountSettingsController.f24184c.getResources();
                Object[] objArr = new Object[1];
                if (nodesModel.k()) {
                    string = dBLLoggedInAccountSettingsController.f24184c.getResources().getString(2131236292);
                } else {
                    string = dBLLoggedInAccountSettingsController.f24184c.getResources().getString(2131236293);
                }
                objArr[0] = string;
                dBLLoggedInAccountSettingsController.f24192k.add(new DBLSettingsItem(string2, string3, resources.getString(2131236291, objArr), false, SettingCategory.OTHER_SESSION, ItemViewType.PREFERENCE, nodesModel.a()));
            }
        }
    }
}
