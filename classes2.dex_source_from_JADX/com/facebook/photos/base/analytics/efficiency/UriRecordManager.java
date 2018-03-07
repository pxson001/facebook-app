package com.facebook.photos.base.analytics.efficiency;

import android.net.Uri;
import com.facebook.inject.Assisted;
import com.facebook.photos.prefs.PhotosPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: onUnintentionalDisconnection must only be called on the Handler thread */
public class UriRecordManager {
    private final PrefKey f11052a;
    private final PrefKey f11053b = ((PrefKey) this.f11052a.m2011a("KEY_URI"));
    private final PrefKey f11054c = ((PrefKey) this.f11052a.m2011a("KEY_CONTENT_LENGTH"));
    private final PrefKey f11055d = ((PrefKey) this.f11052a.m2011a("KEY_FETCH_TIME_MS"));
    private final PrefKey f11056e = ((PrefKey) this.f11052a.m2011a("KEY_FIRST_UI_TIME_MS"));
    private final PrefKey f11057f = ((PrefKey) this.f11052a.m2011a("KEY_IS_PREFETCH"));
    private final PrefKey f11058g = ((PrefKey) this.f11052a.m2011a("KEY_IS_CANCELLATION_REQUESTED"));
    private final PrefKey f11059h = ((PrefKey) this.f11052a.m2011a("KEY_FETCHER_CALLING_CLASS"));
    private final PrefKey f11060i = ((PrefKey) this.f11052a.m2011a("KEY_FETCHER_ANALYTICS_TAG"));
    private final PrefKey f11061j = ((PrefKey) this.f11052a.m2011a("KEY_FETCHER_FEATURE_TAG"));
    private final FbSharedPreferences f11062k;

    @Inject
    public UriRecordManager(FbSharedPreferences fbSharedPreferences, @Assisted String str) {
        this.f11062k = fbSharedPreferences;
        this.f11052a = (PrefKey) PhotosPrefKeys.f11065c.m2011a(str + "EFFICIENCY");
    }

    public final boolean m16414a() {
        return this.f11062k.mo284a();
    }

    public final synchronized Optional<UriRecord> m16415b() {
        Optional<UriRecord> withType;
        Preconditions.checkState(this.f11062k.mo284a());
        String a = this.f11062k.mo278a(this.f11053b, null);
        if (a == null) {
            withType = Absent.withType();
        } else {
            long a2 = this.f11062k.mo277a(this.f11056e, -1);
            withType = Optional.of(new UriRecord(Uri.parse(a), this.f11062k.mo276a(this.f11054c, 0), this.f11062k.mo277a(this.f11055d, 0), a2 == -1 ? Absent.withType() : Optional.of(Long.valueOf(a2)), this.f11062k.mo286a(this.f11057f, false), this.f11062k.mo286a(this.f11058g, false), this.f11062k.mo278a(this.f11059h, null), this.f11062k.mo278a(this.f11060i, null), this.f11062k.mo278a(this.f11061j, null)));
        }
        return withType;
    }

    public final synchronized void m16416c() {
        Preconditions.checkState(this.f11062k.mo284a());
        this.f11062k.edit().mo1278b(this.f11052a).commit();
    }

    public final synchronized UriRecord m16412a(Uri uri, int i, long j, boolean z, boolean z2, String str, String str2, String str3) {
        Preconditions.checkState(this.f11062k.mo284a());
        this.f11062k.edit().mo1276a(this.f11053b, uri.toString()).mo1274a(this.f11054c, i).mo1275a(this.f11055d, j).putBoolean(this.f11057f, z).putBoolean(this.f11058g, z2).mo1276a(this.f11059h, str).mo1276a(this.f11060i, str2).mo1276a(this.f11061j, str3).commit();
        return (UriRecord) m16415b().get();
    }

    public final synchronized UriRecord m16413a(UriRecord uriRecord, long j) {
        Preconditions.checkState(this.f11062k.mo284a());
        Preconditions.checkState(uriRecord.f17694a.toString().equals(this.f11062k.mo278a(this.f11053b, null)));
        this.f11062k.edit().mo1275a(this.f11056e, j).commit();
        return (UriRecord) m16415b().get();
    }
}
