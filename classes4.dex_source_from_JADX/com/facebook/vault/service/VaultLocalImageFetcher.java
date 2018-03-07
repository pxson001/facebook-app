package com.facebook.vault.service;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.bitmaps.FbBitmapFactory;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.photos.base.util.PhotoHashUtil;
import com.facebook.photos.local.LocalImageFetcher;
import com.facebook.vault.hash.VaultHashUtil;
import com.facebook.vault.prefs.BlacklistedSyncPathsPref;
import com.facebook.vault.provider.VaultImageProviderRow;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: latestMarkFolderSeenResult */
public class VaultLocalImageFetcher extends LocalImageFetcher {
    private static final String f9466a = VaultLocalImageFetcher.class.getSimpleName();
    private final Context f9467b;
    private final BlacklistedSyncPathsPref f9468c;
    public final Lazy<VaultTable> f9469d;
    private final AbstractFbErrorReporter f9470e;
    private final VaultHelpers f9471f;
    private final PerformanceLogger f9472g;

    public static VaultLocalImageFetcher m9838c(InjectorLike injectorLike) {
        return new VaultLocalImageFetcher((Context) injectorLike.getInstance(Context.class, ForAppContext.class), BlacklistedSyncPathsPref.m9806a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), VaultHelpers.m9810b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3633), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike));
    }

    @Inject
    public VaultLocalImageFetcher(@ForAppContext Context context, BlacklistedSyncPathsPref blacklistedSyncPathsPref, FbErrorReporter fbErrorReporter, VaultHelpers vaultHelpers, Lazy<VaultTable> lazy, PerformanceLogger performanceLogger) {
        super(context);
        this.f9467b = context;
        this.f9468c = blacklistedSyncPathsPref;
        this.f9470e = fbErrorReporter;
        this.f9471f = vaultHelpers;
        this.f9469d = lazy;
        this.f9472g = performanceLogger;
    }

    public final Map<String, VaultImageProviderRow> m9842a(long j, int i, SearchConstraint searchConstraint, int i2) {
        String formatStrLocaleSafe;
        String[] strArr = new String[]{"_id", "_data", "_display_name", "datetaken"};
        List a = Lists.a();
        switch (1.a[searchConstraint.ordinal()]) {
            case 1:
                formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s <= ?", "datetaken");
                a.add(Long.toString(j));
                break;
            case 2:
                formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s >= ?", "datetaken");
                a.add(Long.toString(j));
                break;
            default:
                this.f9470e.b(StringFormatUtil.a("Unsupported search constraint %d", new Object[]{searchConstraint}), "");
                return Collections.emptyMap();
        }
        String a2 = m9835a(formatStrLocaleSafe, a);
        String a3 = StringFormatUtil.a("%s DESC LIMIT %d", new Object[]{"datetaken", Integer.valueOf(i)});
        LinkedHashMap d = Maps.d();
        Cursor query = this.f9467b.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, strArr, a2, (String[]) a.toArray(new String[a.size()]), a3);
        if (query != null) {
            try {
                int columnIndex = query.getColumnIndex("_display_name");
                int columnIndex2 = query.getColumnIndex("datetaken");
                int columnIndex3 = query.getColumnIndex("_data");
                while (query.moveToNext()) {
                    formatStrLocaleSafe = query.getString(columnIndex3);
                    if (!(query.getString(columnIndex) == null || !m9839e(formatStrLocaleSafe) || LocalImageFetcher.m9848a(formatStrLocaleSafe))) {
                        String a4 = PhotoHashUtil.a(query.getString(columnIndex), query.getLong(columnIndex2));
                        d.put(a4, new VaultImageProviderRow(a4, 0, query.getLong(columnIndex2), 0, 0, i2, 0, 0, 0));
                    }
                }
            } finally {
                query.close();
            }
        }
        return d;
    }

    public final String m9845c(String str) {
        String str2 = null;
        String[] strArr = new String[]{"_data", "_display_name", "datetaken"};
        if (VaultHashUtil.a(str)) {
            Pair b = VaultHashUtil.b(str);
            String str3 = (String) b.first;
            long longValue = ((Long) b.second).longValue();
            Cursor query = this.f9467b.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, strArr, StringFormatUtil.formatStrLocaleSafe("%s = ? AND %s = ?", "_display_name", "datetaken"), new String[]{str3, Long.toString(longValue)}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        str2 = query.getString(query.getColumnIndex("_data"));
                    } else {
                        query.close();
                    }
                } finally {
                    query.close();
                }
            }
        } else {
            this.f9470e.a("vault_bad_image_hash", str);
        }
        return str2;
    }

    public final MediaItem m9846d(String str) {
        Set<String> hashSet = new HashSet();
        hashSet.add(str);
        Preconditions.checkNotNull(hashSet);
        Map b = ((VaultTable) this.f9469d.get()).m12068b((Set) hashSet);
        String str2 = null;
        List arrayList = new ArrayList();
        if (hashSet != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String b2 : hashSet) {
                Pair b3 = VaultHashUtil.b(b2);
                String b22 = (String) b3.first;
                Long l = (Long) b3.second;
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(StringFormatUtil.a(" or ", new Object[0]));
                }
                stringBuffer.append(StringFormatUtil.a("(%s = ?", new Object[]{"_display_name"}));
                arrayList.add(b22);
                stringBuffer.append(StringFormatUtil.a(" and %s = ?)", new Object[]{"datetaken"}));
                arrayList.add(l);
            }
            str2 = stringBuffer.toString();
        }
        Map a = mo754a(b, str2, arrayList);
        if (a.size() > 0) {
            return (MediaItem) a.values().iterator().next();
        }
        return null;
    }

    public final int m9840a() {
        int i;
        CharSequence a = m9835a("", Lists.a());
        String[] strArr = new String[]{"COUNT(*)"};
        String str = "";
        if (!StringUtil.a(a)) {
            str = a;
        }
        List a2 = Lists.a();
        Cursor query = this.f9480h.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, strArr, str, (String[]) a2.toArray(new String[a2.size()]), null);
        if (query == null || !query.moveToFirst()) {
            i = 0;
        } else {
            i = query.getInt(0);
            query.close();
        }
        return i;
    }

    public final boolean m9844b() {
        return m9837c() == 0;
    }

    private long m9837c() {
        return m9834a(TIMESTAMP.MIN);
    }

    public final Map<String, MediaItem> m9841a(long j) {
        Map b = ((VaultTable) this.f9469d.get()).m12067b(j);
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s >= ?", "datetaken");
        List arrayList = new ArrayList();
        arrayList.add(Long.toString(j));
        return mo754a(b, formatStrLocaleSafe, arrayList);
    }

    public final Map<String, MediaItem> mo754a(@Nullable Map<String, Long> map, @Nullable String str, @Nullable List<String> list) {
        return super.mo754a(map, m9835a(str, list), list);
    }

    @VisibleForTesting
    private String m9835a(String str, List<String> list) {
        try {
            str = m9836a(str, (List) list, this.f9468c.m9808b());
        } catch (Throwable e) {
            BLog.b(f9466a, e.getMessage());
            this.f9470e.b(e.getClass().getName(), e.getMessage(), e);
        }
        return str;
    }

    private static String m9836a(String str, List<String> list, List<String> list2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list2 == null || list2.isEmpty()) {
            return str;
        }
        for (String str2 : list2) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(StringFormatUtil.a(" AND ", new Object[0]));
            }
            stringBuffer.append(StringFormatUtil.a("(lower(%s) NOT LIKE lower(?))", new Object[]{"_data"}));
            list.add(str2 + "%");
        }
        if (stringBuffer.length() <= 0) {
            return str;
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return stringBuffer.toString();
        }
        return StringFormatUtil.formatStrLocaleSafe("(%s) AND (%s)", str, stringBuffer);
    }

    private long m9834a(TIMESTAMP timestamp) {
        String str = timestamp == TIMESTAMP.MAX ? "DESC" : "ASC";
        String a = StringFormatUtil.a("%s %s LIMIT 1", new Object[]{"datetaken", str});
        str = StringFormatUtil.a("%s > %d", new Object[]{"datetaken", Integer.valueOf(0)});
        List a2 = Lists.a();
        Cursor query = this.f9467b.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, null, m9835a(str, a2), (String[]) a2.toArray(new String[a2.size()]), a);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    long j = query.getLong(query.getColumnIndex("datetaken"));
                    return j;
                }
                query.close();
            } finally {
                query.close();
            }
        }
        return 0;
    }

    private static boolean m9839e(String str) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        FbBitmapFactory.m13881a(str, options);
        if (options.outWidth < 100 || options.outHeight < 100) {
            return false;
        }
        return true;
    }
}
