package com.facebook.vault.service;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.vault.VaultContract.ImagesTable;
import com.facebook.ipc.vault.VaultContract.ImagesTable.Columns;
import com.facebook.vault.constants.VaultConstants;
import com.facebook.vault.prefs.DeviceCreationTimePref;
import com.facebook.vault.prefs.DeviceIDPref;
import com.facebook.vault.prefs.TableCutoffTimePref;
import com.facebook.vault.prefs.VaultPrefKeys;
import com.facebook.vault.protocol.VaultGetSyncedImageStatus;
import com.facebook.vault.provider.VaultImageProviderRow;
import com.facebook.vault.service.VaultLocalImageFetcher.SearchConstraint;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: first_language */
public class VaultTable {
    private static final String f11565a = VaultTable.class.getSimpleName();
    private static volatile VaultTable f11566k;
    private final Context f11567b;
    private final VaultLocalImageFetcher f11568c;
    private final VaultRowStatusUpdater f11569d;
    private final VaultImageStatusFetcher f11570e;
    private final ContentResolver f11571f;
    private final DeviceIDPref f11572g;
    private final TableCutoffTimePref f11573h;
    private final DeviceCreationTimePref f11574i;
    private final AbstractFbErrorReporter f11575j;

    public static com.facebook.vault.service.VaultTable m12041a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11566k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.vault.service.VaultTable.class;
        monitor-enter(r1);
        r0 = f11566k;	 Catch:{ all -> 0x003a }
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
        r0 = m12050b(r0);	 Catch:{ all -> 0x0035 }
        f11566k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11566k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.vault.service.VaultTable.a(com.facebook.inject.InjectorLike):com.facebook.vault.service.VaultTable");
    }

    private static VaultTable m12050b(InjectorLike injectorLike) {
        return new VaultTable((Context) injectorLike.getInstance(Context.class), ContentResolverMethodAutoProvider.b(injectorLike), VaultLocalImageFetcher.m9838c(injectorLike), new VaultRowStatusUpdater(VaultLocalImageFetcher.m9838c(injectorLike), BitmapUtils.m11716a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike)), VaultImageStatusFetcher.m12078b(injectorLike), DeviceIDPref.m9819a(injectorLike), TableCutoffTimePref.m12083a(injectorLike), DeviceCreationTimePref.m12087a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public VaultTable(Context context, ContentResolver contentResolver, VaultLocalImageFetcher vaultLocalImageFetcher, VaultRowStatusUpdater vaultRowStatusUpdater, VaultImageStatusFetcher vaultImageStatusFetcher, DeviceIDPref deviceIDPref, TableCutoffTimePref tableCutoffTimePref, DeviceCreationTimePref deviceCreationTimePref, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f11567b = context;
        this.f11571f = contentResolver;
        this.f11568c = vaultLocalImageFetcher;
        this.f11569d = vaultRowStatusUpdater;
        this.f11570e = vaultImageStatusFetcher;
        this.f11572g = deviceIDPref;
        this.f11573h = tableCutoffTimePref;
        this.f11574i = deviceCreationTimePref;
        this.f11575j = abstractFbErrorReporter;
    }

    public final Set<String> m12062a() {
        m12055h();
        return m12063a(20);
    }

    public final Set<String> m12063a(int i) {
        long a = this.f11573h.m12085a();
        if (a == 0) {
            a = System.currentTimeMillis();
        }
        Set<String> a2 = m12047a(m12045a(a, i, SearchConstraint.BEFORE, 4));
        this.f11573h.m12086a(m12053f());
        return a2;
    }

    public final Set<String> m12069b() {
        if (this.f11572g.m9821a() == 0) {
            this.f11575j.b("vault_table_refresh missing device_oid", "");
            return new HashSet();
        }
        long a = this.f11573h.m12085a();
        Set<String> emptySet = Collections.emptySet();
        if (a != 0) {
            Map a2 = m12045a(m12053f(), 1000, SearchConstraint.AFTER, 4);
            Integer.valueOf(a2.size());
            emptySet = m12047a(a2);
            this.f11573h.m12086a(m12053f());
        }
        if (!Log.isLoggable(f11565a, 2)) {
            return emptySet;
        }
        m12054g();
        return emptySet;
    }

    private Map<String, VaultImageProviderRow> m12045a(long j, int i, SearchConstraint searchConstraint, int i2) {
        String str;
        String[] strArr = new String[]{Columns.a.a()};
        if (searchConstraint == SearchConstraint.BEFORE) {
            str = "%s <= %d";
        } else {
            str = "%s >= %d";
        }
        Cursor query = this.f11567b.getContentResolver().query(ImagesTable.a, strArr, StringFormatUtil.a(str, new Object[]{Columns.c.a(), Long.valueOf(j)}), null, null);
        Set<String> hashSet = new HashSet();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    if (!(query == null || query.getString(0) == null)) {
                        hashSet.add(query.getString(0));
                    }
                } finally {
                    query.close();
                }
            }
        }
        Map<String, VaultImageProviderRow> a = this.f11568c.m9842a(j, i, searchConstraint, i2);
        int size = a.size();
        for (String str2 : hashSet) {
            a.remove(str2);
        }
        Integer.valueOf(size);
        Integer.valueOf(hashSet.size());
        Integer.valueOf(a.size());
        return a;
    }

    private Set<String> m12047a(Map<String, VaultImageProviderRow> map) {
        Map a = this.f11570e.m12080a(map.keySet(), this.f11572g.m9821a());
        VaultRowStatusUpdater vaultRowStatusUpdater = this.f11569d;
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            VaultImageProviderRow vaultImageProviderRow = (VaultImageProviderRow) entry.getValue();
            VaultGetSyncedImageStatus vaultGetSyncedImageStatus = (VaultGetSyncedImageStatus) a.get(str);
            if (vaultGetSyncedImageStatus != null) {
                if (vaultGetSyncedImageStatus.mDeleted) {
                    vaultImageProviderRow.f = 7;
                } else if (vaultGetSyncedImageStatus.mHeight >= VaultConstants.f11595b || vaultGetSyncedImageStatus.mWidth >= VaultConstants.f11595b) {
                    vaultImageProviderRow.f = 1;
                } else if (vaultGetSyncedImageStatus.mHeight <= 0 || vaultGetSyncedImageStatus.mWidth <= 0) {
                    vaultRowStatusUpdater.f11585d.a("Unexpected server image state", "Image found on server but has 0px width or 0px height");
                    vaultImageProviderRow.f = 4;
                } else {
                    str = vaultRowStatusUpdater.f11583b.m9845c(str);
                    if (str != null) {
                        Dimension a2 = BitmapUtils.m11717a(str);
                        if (vaultGetSyncedImageStatus.mHeight == a2.a && vaultGetSyncedImageStatus.mWidth == a2.b) {
                            vaultImageProviderRow.f = 1;
                        } else {
                            vaultImageProviderRow.f = 0;
                        }
                    }
                }
                vaultImageProviderRow.b = vaultGetSyncedImageStatus.mFbid;
            }
            vaultImageProviderRow.toString();
        }
        Map<String, VaultImageProviderRow> map2 = map;
        ContentValues[] contentValuesArr = new ContentValues[map2.size()];
        int i = 0;
        for (VaultImageProviderRow b : map2.values()) {
            int i2 = i + 1;
            contentValuesArr[i] = b.b();
            i = i2;
        }
        Integer.valueOf(this.f11571f.bulkInsert(ImagesTable.a, contentValuesArr));
        return map2.keySet();
    }

    private List<VaultImageProviderRow> m12044a(UpgradeStatus upgradeStatus, int i, AttemptStatus attemptStatus, TimeConstraint timeConstraint, long j) {
        if (i == 0) {
            return Lists.a();
        }
        List a = Lists.a();
        String a2 = StringFormatUtil.a("%s = ?", new Object[]{Columns.f.a()});
        if (upgradeStatus != UpgradeStatus.UPGRADE_ONLY) {
            a.add(Integer.toString(4));
            if (upgradeStatus == UpgradeStatus.ALL) {
                a2 = a2 + StringFormatUtil.a(" or %s = ?", new Object[]{Columns.f.a()});
                a.add(Integer.toString(0));
            }
        } else {
            a.add(Integer.toString(0));
        }
        if (attemptStatus == AttemptStatus.RETRY_WITH_HARD_FAILURES) {
            a2 = a2 + StringFormatUtil.a(" or %s = ?", new Object[]{Columns.f.a()});
            a.add(Integer.toString(6));
        }
        String a3 = StringFormatUtil.a("(%s) and (%s = ?)", new Object[]{a2, Columns.h.a()});
        a.add(Integer.toString(0));
        if (attemptStatus == AttemptStatus.RETRY_SOFT_FAILURES_ONLY) {
            a2 = StringFormatUtil.a("%s > 0 and %s < %d", new Object[]{Columns.e.a(), Columns.e.a(), Integer.valueOf(8)});
        } else if (attemptStatus == AttemptStatus.RETRY_WITH_HARD_FAILURES) {
            a2 = StringFormatUtil.a("%s > 0", new Object[]{Columns.e.a()});
        } else {
            a2 = StringFormatUtil.a("%s = 0", new Object[]{Columns.e.a()});
        }
        String a4 = StringFormatUtil.a("(%s) and (%s)", new Object[]{a3, a2});
        if (timeConstraint == TimeConstraint.OLD_PHOTOS) {
            a4 = StringFormatUtil.a("(%s) and (%s < ?)", new Object[]{a4, Columns.c.a()});
            a.add(Long.toString(j));
        } else if (timeConstraint == TimeConstraint.NEW_PHOTOS) {
            a4 = StringFormatUtil.a("(%s) and (%s >= ?)", new Object[]{a4, Columns.c.a()});
            a.add(Long.toString(j));
        }
        return m12043a(this.f11571f.query(ImagesTable.a, null, a4, (String[]) a.toArray(new String[a.size()]), StringFormatUtil.a("%s DESC LIMIT %d", new Object[]{Columns.c.a(), Integer.valueOf(i)})));
    }

    private static List<VaultImageProviderRow> m12043a(Cursor cursor) {
        List<VaultImageProviderRow> a;
        if (cursor != null) {
            try {
                a = Lists.a(cursor.getCount());
                while (cursor.moveToNext()) {
                    a.add(new VaultImageProviderRow(cursor));
                }
            } finally {
                cursor.close();
            }
        } else {
            a = Lists.a(0);
        }
        if (Log.isLoggable("vault", 2)) {
            new StringBuilder("getResultsFromCursor: ").append(a.toString());
        }
        return a;
    }

    public final VaultImageProviderRow m12057a(String str) {
        Set hashSet = new HashSet();
        hashSet.add(str);
        List a = m12061a(hashSet);
        if (a == null || a.size() <= 0) {
            return null;
        }
        return (VaultImageProviderRow) a.iterator().next();
    }

    public final List<VaultImageProviderRow> m12061a(Set<String> set) {
        Cursor cursor = null;
        List a = Lists.a();
        if (m12042a((Set) set, a).length() > 0) {
            String a2 = StringFormatUtil.a("%s DESC", new Object[]{Columns.c.d});
            cursor = this.f11571f.query(ImagesTable.a, null, StringFormatUtil.a("%s", new Object[]{r0}), (String[]) a.toArray(new String[a.size()]), a2);
        }
        return m12043a(cursor);
    }

    private long m12051d() {
        String a = StringFormatUtil.a("%s DESC LIMIT 1", new Object[]{Columns.c.a()});
        String a2 = StringFormatUtil.a("%s != %d AND %s = %d", new Object[]{Columns.f.a(), Integer.valueOf(4), Columns.h.a(), Integer.valueOf(0)});
        Cursor query = this.f11571f.query(ImagesTable.a, new String[]{Columns.c.a()}, a2, null, a);
        long j = 0;
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    j = query.getLong(Columns.c.a(query));
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        return j;
    }

    private static String m12052e() {
        return StringFormatUtil.a("%s IN (%d, %d, %d, %d, %d)", new Object[]{Columns.f.d, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6)}).toString();
    }

    public final List<VaultImageProviderRow> m12060a(long j, int i, boolean z) {
        String a = StringFormatUtil.a("%s DESC", new Object[]{Columns.c.d});
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s >= ?", Columns.c.d);
        List arrayList = new ArrayList();
        arrayList.add(Long.toString(j));
        String e = m12052e();
        List<VaultImageProviderRow> a2 = m12043a(this.f11571f.query(ImagesTable.a, null, StringFormatUtil.a("(%s) and (%s)", new Object[]{formatStrLocaleSafe, e}), (String[]) arrayList.toArray(new String[arrayList.size()]), a));
        if (z) {
            Set a3 = Sets.a();
            int i2 = 0;
            for (VaultImageProviderRow vaultImageProviderRow : a2) {
                a3.add(vaultImageProviderRow.a);
                int i3 = i2 + 1;
                if (i3 >= i) {
                    break;
                }
                i2 = i3;
            }
            List a4 = VaultRowStatusUpdater.m12073a(a2, this.f11570e.m12080a(a3, this.f11572g.m9821a()));
            if (a4.size() > 0) {
                m12065a(a4);
            }
        }
        return a2;
    }

    private static StringBuffer m12042a(Set<String> set, List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (set != null && set.size() > 0) {
            for (String str : set) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(StringFormatUtil.a(" or ", new Object[0]));
                }
                stringBuffer.append(StringFormatUtil.a("%s = ?", new Object[]{Columns.a.d}));
                list.add(str);
            }
        }
        return stringBuffer;
    }

    public final SyncableRows m12058a(int i, boolean z) {
        Collection a;
        List a2 = Lists.a();
        List a3 = Lists.a();
        ArrayList a4 = Lists.a();
        long d = m12051d();
        List<VaultImageProviderRow> a5 = m12044a(UpgradeStatus.NO_UPGRADES, i, AttemptStatus.FIRST, TimeConstraint.NONE, 0);
        for (VaultImageProviderRow vaultImageProviderRow : a5) {
            if (vaultImageProviderRow.c >= d) {
                a2.add(vaultImageProviderRow);
            } else {
                a3.add(vaultImageProviderRow);
            }
        }
        if (!z || a5.size() >= i) {
            Object obj = a4;
        } else {
            a = m12044a(UpgradeStatus.UPGRADE_ONLY, i - a5.size(), AttemptStatus.FIRST, TimeConstraint.NONE, 0);
        }
        Integer.valueOf(a2.size());
        Integer.valueOf(a3.size());
        Integer.valueOf(a.size());
        a3.addAll(a);
        return new SyncableRows(this, a2, a3);
    }

    public final List<VaultImageProviderRow> m12059a(int i, boolean z, boolean z2) {
        return m12044a(z ? UpgradeStatus.ALL : UpgradeStatus.NO_UPGRADES, i, z2 ? AttemptStatus.RETRY_WITH_HARD_FAILURES : AttemptStatus.RETRY_SOFT_FAILURES_ONLY, TimeConstraint.NONE, 0);
    }

    public final boolean m12070c() {
        long a = this.f11573h.m12085a();
        if (a == 0) {
            if (this.f11568c.m9840a() > 0) {
                return true;
            }
            return false;
        } else if (m12045a(a, 6, SearchConstraint.BEFORE, 4).size() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public final void m12064a(VaultImageProviderRow vaultImageProviderRow) {
        vaultImageProviderRow.h = 1;
        vaultImageProviderRow.i = System.currentTimeMillis();
        ContentValues b = vaultImageProviderRow.b();
        String[] strArr = new String[]{vaultImageProviderRow.a};
        this.f11571f.update(ImagesTable.a, b, StringFormatUtil.a("%s = ?", new Object[]{Columns.a.d}), strArr);
    }

    public final int m12066b(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.h.d, Integer.valueOf(0));
        return this.f11571f.update(Uri.parse(ImagesTable.a + "/" + Uri.encode(str)), contentValues, null, null);
    }

    public final int m12056a(long j) {
        int i = 0;
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.h.d, Integer.valueOf(0));
        String a = StringFormatUtil.a("%s < ? AND %s = ?", new Object[]{Columns.i.d, Columns.h.d});
        List a2 = Lists.a();
        a2.add(Long.toString(System.currentTimeMillis() - j));
        a2.add(Integer.toString(1));
        if (this.f11571f.acquireContentProviderClient(ImagesTable.a) != null) {
            i = this.f11571f.update(ImagesTable.a, contentValues, a, (String[]) a2.toArray(new String[a2.size()]));
        }
        new StringBuilder("reseting queue flags for # rows: ").append(i);
        return i;
    }

    public final void m12065a(List<VaultImageProviderRow> list) {
        if (list.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder("?");
            ArrayList a = Lists.a();
            for (VaultImageProviderRow vaultImageProviderRow : list) {
                if (!Strings.isNullOrEmpty(vaultImageProviderRow.a)) {
                    if (a.isEmpty()) {
                        a.add(vaultImageProviderRow.a);
                    } else {
                        stringBuilder.append(",?");
                        a.add(vaultImageProviderRow.a);
                    }
                }
                if (a.size() == 999) {
                    m12048a(stringBuilder, a);
                    a.clear();
                }
            }
            if (!a.isEmpty()) {
                m12048a(stringBuilder, a);
            }
        }
    }

    private void m12048a(StringBuilder stringBuilder, ArrayList<String> arrayList) {
        Preconditions.checkNotNull(stringBuilder);
        Preconditions.checkNotNull(arrayList);
        this.f11571f.delete(ImagesTable.a, StringFormatUtil.a("%s IN (%s)", new Object[]{Columns.a.d, stringBuilder.toString()}), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final Map<String, Long> m12068b(Set<String> set) {
        String str = null;
        List arrayList = new ArrayList();
        if (set != null) {
            str = m12042a((Set) set, arrayList).toString();
        }
        return m12046a(str, arrayList);
    }

    public final Map<String, Long> m12067b(long j) {
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s >= ?", Columns.c.d);
        List arrayList = new ArrayList();
        arrayList.add(Long.toString(j));
        return m12046a(formatStrLocaleSafe, arrayList);
    }

    private Map<String, Long> m12046a(String str, List list) {
        Map<String, Long> map = null;
        Cursor query = this.f11567b.getContentResolver().query(ImagesTable.a, new String[]{Columns.a.a(), Columns.b.a()}, str, (String[]) list.toArray(new String[list.size()]), null);
        if (query == null) {
            this.f11575j.b("get_fbids_for_hashes_no_cursor", "no vault cursor");
        } else {
            map = Maps.c();
            while (query.moveToNext()) {
                try {
                    map.put(query.getString(0), Long.valueOf(query.getLong(1)));
                } finally {
                    query.close();
                }
            }
        }
        return map;
    }

    private long m12049b(int i) {
        String str = i == 1 ? "DESC" : "ASC";
        Cursor query = this.f11571f.query(ImagesTable.a, null, null, null, StringFormatUtil.a("%s %s", new Object[]{Columns.c.a(), str}));
        try {
            if (query.moveToNext()) {
                long j = query.getLong(Columns.c.a(query));
                return j;
            }
            query.close();
            return 0;
        } finally {
            query.close();
        }
    }

    private long m12053f() {
        long b = m12049b(2);
        return b != 0 ? b : this.f11574i.f11600a.a(VaultPrefKeys.f11552g, 0);
    }

    private void m12054g() {
        Cursor query = this.f11571f.query(ImagesTable.a, null, null, null, StringFormatUtil.a("%s DESC", new Object[]{Columns.c.a()}));
        while (query.moveToNext()) {
            try {
                new VaultImageProviderRow(query).toString();
            } finally {
                query.close();
            }
        }
    }

    private void m12055h() {
        try {
            Integer.valueOf(this.f11571f.delete(ImagesTable.a, "", null));
        } catch (IllegalArgumentException e) {
            new StringBuilder("IContentProvider for ").append(ImagesTable.a).append(" cannot be found.");
        }
    }
}
