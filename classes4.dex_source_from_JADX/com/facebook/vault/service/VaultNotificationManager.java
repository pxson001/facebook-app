package com.facebook.vault.service;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.vault.prefs.UploadStatePref;
import com.facebook.vault.prefs.VaultPrefKeys;
import com.facebook.vault.provider.VaultImageProviderRow;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: findpages_feed_unit */
public class VaultNotificationManager {
    private static volatile VaultNotificationManager f11601e;
    @GuardedBy("this")
    private Map<String, VaultImageProviderRow> f11602a = Maps.d();
    @GuardedBy("this")
    private int f11603b = 0;
    private Context f11604c;
    private UploadStatePref f11605d;

    public static com.facebook.vault.service.VaultNotificationManager m12091a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11601e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.vault.service.VaultNotificationManager.class;
        monitor-enter(r1);
        r0 = f11601e;	 Catch:{ all -> 0x003a }
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
        r0 = m12093b(r0);	 Catch:{ all -> 0x0035 }
        f11601e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11601e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.vault.service.VaultNotificationManager.a(com.facebook.inject.InjectorLike):com.facebook.vault.service.VaultNotificationManager");
    }

    private static VaultNotificationManager m12093b(InjectorLike injectorLike) {
        return new VaultNotificationManager((Context) injectorLike.getInstance(Context.class), UploadStatePref.m12111a(injectorLike));
    }

    @Inject
    public VaultNotificationManager(Context context, UploadStatePref uploadStatePref) {
        this.f11604c = context;
        this.f11605d = uploadStatePref;
        this.f11603b = 0;
        this.f11602a = Maps.d();
        m12094b("end_vault_upload");
    }

    public final void m12105a(Set<String> set) {
        if (set.size() > 0) {
            m12092a(new Intent().putExtra("vault.table_refreshed_key", true));
        }
    }

    public final void m12100a() {
        m12092a(new Intent().putExtra("vault.table_refreshed_key", true));
    }

    private static boolean m12095c(VaultImageProviderRow vaultImageProviderRow) {
        return vaultImageProviderRow.b > 0 && (vaultImageProviderRow.f == 0 || vaultImageProviderRow.f == 6);
    }

    public final void m12106b() {
        m12092a(new Intent().putExtra("vault.status_change_key", true));
    }

    public final void m12104a(List<VaultImageProviderRow> list) {
        if (!m12099i()) {
            m12094b("begin_vault_upload");
        }
        synchronized (this) {
            for (VaultImageProviderRow vaultImageProviderRow : list) {
                if (!m12095c(vaultImageProviderRow)) {
                    this.f11602a.put(vaultImageProviderRow.a, vaultImageProviderRow);
                }
            }
        }
        Intent intent = new Intent();
        intent.putExtra("vault.sync_start", true);
        m12092a(intent);
    }

    public final void m12108c() {
        m12097g();
        m12098h();
    }

    public final void m12101a(VaultImageProviderRow vaultImageProviderRow) {
        if (!m12095c(vaultImageProviderRow)) {
            synchronized (this) {
                this.f11602a.put(vaultImageProviderRow.a, vaultImageProviderRow);
            }
            m12094b("vault_upload_start");
            m12092a(m12090a(new Intent(), vaultImageProviderRow.a, 0));
        }
    }

    public final void m12102a(VaultImageProviderRow vaultImageProviderRow, int i) {
        if (!m12095c(vaultImageProviderRow)) {
            m12092a(m12090a(new Intent(), vaultImageProviderRow.a, i));
        }
    }

    public final void m12107b(VaultImageProviderRow vaultImageProviderRow) {
        synchronized (this) {
            if (this.f11602a.containsKey(vaultImageProviderRow.a)) {
                this.f11602a.put(vaultImageProviderRow.a, vaultImageProviderRow);
                this.f11603b++;
            }
            Intent a = m12090a(new Intent(), vaultImageProviderRow.a, 100);
            a.putExtra("vault.upload_completed", true);
            m12092a(a);
            if (m12096f()) {
                m12108c();
            }
        }
    }

    public final void m12109d() {
        synchronized (this) {
            if (m12096f()) {
                m12097g();
            }
        }
    }

    private boolean m12096f() {
        return this.f11603b == this.f11602a.size();
    }

    private void m12097g() {
        synchronized (this) {
            m12094b("end_vault_upload");
            Intent intent = new Intent();
            intent.putExtra("vault.sync_end", true);
            m12092a(intent);
        }
    }

    private static Intent m12090a(Intent intent, String str, int i) {
        intent.putExtra("vault.row_upload_key", str);
        intent.putExtra("vault.upload_percentage", i);
        return intent;
    }

    private void m12092a(Intent intent) {
        intent.setAction("vault.intent.action.SyncStatus");
        FbLocalBroadcastManager.a(this.f11604c).a(intent);
    }

    public final void m12103a(String str) {
        synchronized (this) {
            this.f11602a.remove(str);
            if (m12096f()) {
                m12108c();
            }
        }
    }

    private void m12098h() {
        synchronized (this) {
            if (!m12099i()) {
                this.f11602a.clear();
                this.f11603b = 0;
            }
        }
    }

    public final String m12110e() {
        return this.f11605d.f11607a.a(VaultPrefKeys.f11548c, "end_vault_upload");
    }

    private void m12094b(String str) {
        Editor edit = this.f11605d.f11607a.edit();
        edit.a(VaultPrefKeys.f11548c, str);
        edit.commit();
    }

    private boolean m12099i() {
        return !m12110e().equals("end_vault_upload");
    }
}
