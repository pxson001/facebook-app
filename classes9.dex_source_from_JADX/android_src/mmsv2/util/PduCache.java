package android_src.mmsv2.util;

import android.content.ContentUris;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.Telephony.Mms;
import android.support.v4.util.SimpleArrayMap;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: sent_payment */
public final class PduCache extends AbstractCache<Uri, PduCacheEntry> {
    private static final UriMatcher f3891a;
    private static final SparseArray<Integer> f3892b;
    private static PduCache f3893c;
    private final SparseArray<HashSet<Uri>> f3894d = new SparseArray();
    private final SimpleArrayMap<Long, HashSet<Uri>> f3895e = new SimpleArrayMap();
    private final HashSet<Uri> f3896f = new HashSet();

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f3891a = uriMatcher;
        uriMatcher.addURI("mms", null, 0);
        f3891a.addURI("mms", "#", 1);
        f3891a.addURI("mms", "inbox", 2);
        f3891a.addURI("mms", "inbox/#", 3);
        f3891a.addURI("mms", "sent", 4);
        f3891a.addURI("mms", "sent/#", 5);
        f3891a.addURI("mms", "drafts", 6);
        f3891a.addURI("mms", "drafts/#", 7);
        f3891a.addURI("mms", "outbox", 8);
        f3891a.addURI("mms", "outbox/#", 9);
        f3891a.addURI("mms-sms", "conversations", 10);
        f3891a.addURI("mms-sms", "conversations/#", 11);
        SparseArray sparseArray = new SparseArray();
        f3892b = sparseArray;
        sparseArray.put(2, Integer.valueOf(1));
        f3892b.put(4, Integer.valueOf(2));
        f3892b.put(6, Integer.valueOf(3));
        f3892b.put(8, Integer.valueOf(4));
    }

    private PduCache() {
    }

    public static final synchronized PduCache m3747b() {
        PduCache pduCache;
        synchronized (PduCache.class) {
            if (f3893c == null) {
                f3893c = new PduCache();
            }
            pduCache = f3893c;
        }
        return pduCache;
    }

    public final synchronized boolean m3755a(Uri uri, PduCacheEntry pduCacheEntry) {
        boolean a;
        HashSet hashSet;
        int b = pduCacheEntry.m3760b();
        HashSet hashSet2 = (HashSet) this.f3894d.get(b);
        if (hashSet2 == null) {
            hashSet2 = new HashSet();
            this.f3894d.put(b, hashSet2);
            hashSet = hashSet2;
        } else {
            hashSet = hashSet2;
        }
        long c = pduCacheEntry.m3761c();
        hashSet2 = (HashSet) this.f3895e.get(Long.valueOf(c));
        if (hashSet2 == null) {
            hashSet2 = new HashSet();
            this.f3895e.put(Long.valueOf(c), hashSet2);
        }
        Uri d = m3751d(uri);
        a = super.mo126a(d, pduCacheEntry);
        if (a) {
            hashSet.add(d);
            hashSet2.add(d);
        }
        m3753a(uri, false);
        return a;
    }

    public final synchronized void m3753a(Uri uri, boolean z) {
        if (z) {
            this.f3896f.add(uri);
        } else {
            this.f3896f.remove(uri);
        }
    }

    public final synchronized boolean m3754a(Uri uri) {
        return this.f3896f.contains(uri);
    }

    public final synchronized PduCacheEntry m3757b(Uri uri) {
        PduCacheEntry pduCacheEntry;
        int match = f3891a.match(uri);
        switch (match) {
            case 0:
            case 10:
                mo125a();
                pduCacheEntry = null;
                break;
            case 1:
                pduCacheEntry = m3749c(uri);
                break;
            case 2:
            case 4:
            case 6:
            case 8:
                m3746a((Integer) f3892b.get(match));
                pduCacheEntry = null;
                break;
            case 3:
            case 5:
            case 7:
            case 9:
                pduCacheEntry = m3749c(Uri.withAppendedPath(Mms.CONTENT_URI, uri.getLastPathSegment()));
                break;
            case 11:
                m3745a(ContentUris.parseId(uri));
                pduCacheEntry = null;
                break;
            default:
                pduCacheEntry = null;
                break;
        }
        return pduCacheEntry;
    }

    private PduCacheEntry m3749c(Uri uri) {
        this.f3896f.remove(uri);
        PduCacheEntry pduCacheEntry = (PduCacheEntry) super.mo127b(uri);
        if (pduCacheEntry == null) {
            return null;
        }
        m3748b(uri, pduCacheEntry);
        m3750c(uri, pduCacheEntry);
        return pduCacheEntry;
    }

    public final synchronized void mo125a() {
        super.mo125a();
        this.f3894d.clear();
        this.f3895e.clear();
        this.f3896f.clear();
    }

    private static Uri m3751d(Uri uri) {
        switch (f3891a.match(uri)) {
            case 1:
                return uri;
            case 3:
            case 5:
            case 7:
            case 9:
                return Uri.withAppendedPath(Mms.CONTENT_URI, uri.getLastPathSegment());
            default:
                return null;
        }
    }

    private void m3746a(Integer num) {
        if (num != null) {
            HashSet hashSet = (HashSet) this.f3894d.get(num.intValue());
            this.f3894d.remove(num.intValue());
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    Uri uri = (Uri) it.next();
                    this.f3896f.remove(uri);
                    PduCacheEntry pduCacheEntry = (PduCacheEntry) super.mo127b(uri);
                    if (pduCacheEntry != null) {
                        m3748b(uri, pduCacheEntry);
                    }
                }
            }
        }
    }

    private void m3748b(Uri uri, PduCacheEntry pduCacheEntry) {
        HashSet hashSet = (HashSet) this.f3895e.get(Long.valueOf(pduCacheEntry.f3899c));
        if (hashSet != null) {
            hashSet.remove(uri);
        }
    }

    private void m3745a(long j) {
        HashSet hashSet = (HashSet) this.f3895e.remove(Long.valueOf(j));
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                this.f3896f.remove(uri);
                PduCacheEntry pduCacheEntry = (PduCacheEntry) super.mo127b(uri);
                if (pduCacheEntry != null) {
                    m3750c(uri, pduCacheEntry);
                }
            }
        }
    }

    private void m3750c(Uri uri, PduCacheEntry pduCacheEntry) {
        HashSet hashSet = (HashSet) this.f3895e.get(Long.valueOf((long) pduCacheEntry.f3898b));
        if (hashSet != null) {
            hashSet.remove(uri);
        }
    }
}
