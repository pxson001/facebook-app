package com.facebook.sequencelogger;

import android.util.Pair;
import com.facebook.base.lwperf.perfstats.BackgroundChecker;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.systrace.Systrace;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: zero_rating_accepted */
public class SequenceData {
    private static final Comparator<SequenceElement> f52b = new C00021();
    private static final AtomicInteger f53c = new AtomicInteger(1);
    @GuardedBy("this")
    List<Pair<Long, String>> f54a;
    private final String f55d;
    private final String f56e;
    public final String f57f;
    private final int f58g = m59h();
    private final boolean f59h;
    private final ImmutableMap<String, String> f60i;
    private final long f61j;
    public final long f62k;
    @GuardedBy("this")
    public long f63l;
    @GuardedBy("this")
    private ImmutableMap<String, String> f64m;
    @GuardedBy("this")
    private List<String> f65n;
    @GuardedBy("this")
    private volatile Map<String, SubSequence> f66o;
    @GuardedBy("this")
    private final List<SequenceElement> f67p;
    @GuardedBy("this")
    private Map<String, Boolean> f68q;
    @GuardedBy("this")
    private Map<String, String> f69r;
    private volatile boolean f70s;
    private volatile boolean f71t;

    /* compiled from: zero_rating_accepted */
    final class C00021 implements Comparator<SequenceElement> {
        C00021() {
        }

        public final int compare(Object obj, Object obj2) {
            SequenceElement sequenceElement = (SequenceElement) obj;
            SequenceElement sequenceElement2 = (SequenceElement) obj2;
            if (sequenceElement == null && sequenceElement2 == null) {
                return 0;
            }
            if (sequenceElement == null) {
                return -1;
            }
            if (sequenceElement2 == null) {
                return 1;
            }
            return Long.valueOf(sequenceElement.mo12a()).compareTo(Long.valueOf(sequenceElement2.mo12a()));
        }
    }

    /* compiled from: zero_rating_accepted */
    class SubSequence implements SequenceElement {
        final String f78a;
        String f79b;
        final int f80c;
        final long f81d;
        final ImmutableMap<String, String> f82e;
        long f83f;
        ImmutableMap<String, String> f84g;
        boolean f85h;
        final /* synthetic */ SequenceData f86i;
        @Nullable
        private Boolean f87j;

        private SubSequence(SequenceData sequenceData, String str, @Nullable String str2, long j, @Nullable ImmutableMap<String, String> immutableMap, @Nullable Boolean bool) {
            String formatStrLocaleSafe;
            this.f86i = sequenceData;
            this.f78a = str;
            String str3 = sequenceData.f57f;
            if (str2 == null) {
                formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s (Seq: %s)", str, str3);
            } else {
                formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s(%s) (Seq: %s)", str, str2, str3);
            }
            this.f79b = formatStrLocaleSafe;
            this.f80c = SequenceData.m59h();
            this.f81d = j;
            this.f82e = immutableMap;
            this.f87j = bool;
            Systrace.a(2, this.f79b, this.f80c, TimeUnit.MILLISECONDS.toNanos(j));
        }

        public final void m92c() {
            Systrace.f(2, this.f79b, this.f80c);
        }

        private long m87a(long j, @Nullable Boolean bool, @Nullable ImmutableMap<String, String> immutableMap, boolean z) {
            this.f83f = j;
            this.f84g = immutableMap;
            this.f85h = z;
            m89a(this, bool);
            Systrace.b(2, this.f79b, this.f80c, TimeUnit.MILLISECONDS.toNanos(j));
            if (this.f85h) {
                String str = this.f79b;
                this.f79b = "FAILED: " + this.f79b;
                Systrace.b(2, str, this.f79b, this.f80c);
            }
            return this.f83f - this.f81d;
        }

        public static void m89a(SubSequence subSequence, Boolean bool) {
            if (bool != null) {
                if (subSequence.f87j == null || !subSequence.f87j.booleanValue()) {
                    subSequence.f87j = bool;
                }
            }
        }

        public final JsonNode mo13b() {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("name", this.f78a);
            objectNode.a("type", "s");
            objectNode.a("failed", this.f85h);
            objectNode.a("relative_start_ms", this.f81d - this.f86i.f62k);
            if (this.f86i.f63l != 0) {
                objectNode.a("duration_ms", this.f83f - this.f81d);
            }
            if (this.f82e != null) {
                objectNode.c("start_extra", JSONUtil.a(this.f82e));
            }
            if (this.f84g != null) {
                objectNode.c("stop_extra", JSONUtil.a(this.f84g));
            }
            if (this.f87j != null) {
                objectNode.a("guess_was_bg", this.f87j.booleanValue());
            }
            return objectNode;
        }

        public final long mo12a() {
            return this.f81d;
        }
    }

    /* compiled from: zero_rating_accepted */
    interface SequenceElement {
        long mo12a();

        JsonNode mo13b();
    }

    SequenceData(String str, String str2, @Nullable String str3, long j, long j2, boolean z, @Nullable ImmutableMap<String, String> immutableMap, @Nullable Boolean bool) {
        this.f55d = str;
        this.f56e = str2;
        this.f57f = m56d(str2, str3);
        this.f62k = j;
        this.f61j = j2;
        this.f59h = z;
        this.f60i = immutableMap;
        this.f67p = Lists.b();
        boolean b = m54b(bool);
        this.f70s = b;
        this.f71t = b;
        Systrace.a(2, this.f57f, this.f58g, TimeUnit.MILLISECONDS.toNanos(j));
    }

    final synchronized long m60a(long j, @Nullable ImmutableMap<String, String> immutableMap, @Nullable Boolean bool, List<String>... listArr) {
        this.f63l = j;
        this.f64m = immutableMap;
        if (listArr.length > 0) {
            this.f65n = new ArrayList();
            for (Collection collection : listArr) {
                if (collection != null) {
                    this.f65n.addAll(collection);
                }
            }
        }
        m53a(bool);
        Systrace.b(2, this.f57f, this.f58g, TimeUnit.MILLISECONDS.toNanos(j));
        return this.f63l - this.f62k;
    }

    final synchronized void m66a(String str, @Nullable String str2, long j, @Nullable ImmutableMap<String, String> immutableMap, @Nullable Boolean bool) {
        m53a(bool);
        String c = m55c(str, str2);
        SubSequence subSequence = (SubSequence) m57f().get(c);
        if (subSequence != null) {
            subSequence.m92c();
            m63a(j, str + "(" + str2 + ") was restarted.");
        }
        m57f().put(c, new SubSequence(str, str2, j, immutableMap, bool));
    }

    final synchronized long m61a(String str, @Nullable String str2, long j, @Nullable ImmutableMap<String, String> immutableMap, @Nullable Boolean bool, boolean z) {
        long j2;
        m53a(bool);
        String c = m55c(str, str2);
        SubSequence subSequence = (SubSequence) m57f().get(c);
        j2 = 0;
        if (subSequence != null) {
            j2 = subSequence.m87a(j, bool, immutableMap, z);
            m57f().remove(c);
            this.f67p.add(subSequence);
        }
        return j2;
    }

    final synchronized void m65a(String str, @Nullable String str2, long j) {
        String c = m55c(str, str2);
        SubSequence subSequence = (SubSequence) m57f().get(c);
        if (subSequence != null) {
            subSequence.m92c();
            m57f().remove(c);
        } else {
            m63a(j, "Called cancel on marker " + str + "(" + str2 + ") but it was not started yet.");
        }
    }

    final synchronized void m62a() {
        Systrace.f(2, this.f57f, this.f58g);
        for (SubSequence c : m57f().values()) {
            c.m92c();
        }
        for (SequenceElement sequenceElement : this.f67p) {
            if (sequenceElement instanceof SubSequence) {
                ((SubSequence) sequenceElement).m92c();
            }
        }
    }

    final synchronized boolean m67a(String str, @Nullable String str2) {
        return ((SubSequence) m57f().get(m55c(str, str2))) != null;
    }

    final synchronized void m64a(String str, long j, @Nullable ImmutableMap<String, String> immutableMap) {
        this.f67p.add(new SubEvent(this, str, j, immutableMap, (byte) 0));
    }

    final synchronized void m63a(long j, String str) {
        if (this.f54a == null) {
            this.f54a = Lists.b();
        }
        this.f54a.add(new Pair(Long.valueOf(j), str));
        if (BuildConstants.e() || BuildConstants.d()) {
            BLog.a(this.f56e, "Stopped Marker %s (%s); Monotonic Timestamp (ms): %d; Elapsed: %d ms", new Object[]{"error", Integer.valueOf(-1), Long.valueOf(j), Integer.valueOf(0)});
        }
    }

    final synchronized void m69b(String str, String str2) {
        m58g().put(str, str2);
    }

    public final synchronized HoneySequenceLoggerEvent m68b() {
        HoneySequenceLoggerEvent honeySequenceLoggerEvent;
        if (this.f63l == 0) {
            throw new IllegalStateException("Tried to serialize a SequenceData before it was finished.");
        }
        JsonNode jsonNode = null;
        try {
            if (!this.f67p.isEmpty()) {
                Collections.sort(this.f67p, f52b);
                jsonNode = new ArrayNode(JsonNodeFactory.a);
                for (SequenceElement b : this.f67p) {
                    jsonNode.a(b.mo13b());
                }
            }
            JsonNode jsonNode2 = null;
            if (!(this.f60i == null || this.f60i.isEmpty())) {
                jsonNode2 = JSONUtil.a(this.f60i);
            }
            JsonNode jsonNode3 = null;
            if (!(this.f64m == null || this.f64m.isEmpty())) {
                jsonNode3 = JSONUtil.a(this.f64m);
            }
            JsonNode jsonNode4 = null;
            if (!(this.f65n == null || this.f65n.isEmpty())) {
                jsonNode4 = JSONUtil.a(this.f65n);
            }
            ArrayNode arrayNode = null;
            if (!(this.f54a == null || this.f54a.isEmpty())) {
                arrayNode = JsonNodeFactory.a.b();
                for (Pair pair : this.f54a) {
                    ObjectNode c = JsonNodeFactory.a.c();
                    c.a("relative_start_ms", ((Long) pair.first).longValue() - this.f62k);
                    c.a("error", (String) pair.second);
                    arrayNode.a(c);
                }
            }
            ObjectNode objectNode = null;
            if (!(this.f68q == null || this.f68q.isEmpty())) {
                objectNode = new ObjectNode(JsonNodeFactory.a);
                for (Entry entry : this.f68q.entrySet()) {
                    objectNode.a((String) entry.getKey(), (Boolean) entry.getValue());
                }
            }
            ObjectNode objectNode2 = null;
            if (!(this.f69r == null || this.f69r.isEmpty())) {
                objectNode2 = new ObjectNode(JsonNodeFactory.a);
                for (Entry entry2 : this.f69r.entrySet()) {
                    objectNode2.a((String) entry2.getKey(), (String) entry2.getValue());
                }
            }
            honeySequenceLoggerEvent = new HoneySequenceLoggerEvent(this.f55d.toString(), this.f56e.toString(), this.f63l - this.f62k, jsonNode2, jsonNode3, jsonNode4, arrayNode, objectNode, objectNode2, jsonNode, this.f62k, m70c(), this.f59h);
            honeySequenceLoggerEvent.a(this.f61j);
        } catch (Throwable th) {
            BLog.a("SequenceData", th, "Exception while serializing the sequence %s", new Object[]{this.f56e.toString()});
        }
        return honeySequenceLoggerEvent;
    }

    public final synchronized Boolean m70c() {
        return Boolean.valueOf(this.f71t);
    }

    private synchronized boolean m53a(Boolean bool) {
        boolean z;
        boolean b = m54b(bool);
        if (this.f70s == b) {
            z = b;
        } else {
            this.f70s = b;
            if (b) {
                this.f71t = true;
            }
            if (b) {
                for (SubSequence a : m57f().values()) {
                    SubSequence.m89a(a, Boolean.valueOf(b));
                }
            }
            z = b;
        }
        return z;
    }

    private static boolean m54b(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return BackgroundChecker.b.e();
    }

    private static String m55c(String str, @Nullable String str2) {
        return StringUtil.a(str2) ? str : str + str2;
    }

    private Map<String, SubSequence> m57f() {
        Map<String, SubSequence> map = this.f66o;
        if (map == null) {
            synchronized (this) {
                map = this.f66o;
                if (map == null) {
                    map = Maps.c();
                    this.f66o = map;
                }
            }
        }
        return map;
    }

    private synchronized Map<String, String> m58g() {
        if (this.f69r == null) {
            this.f69r = Maps.c();
        }
        return this.f69r;
    }

    private static String m56d(String str, @Nullable String str2) {
        return str2 == null ? str : StringFormatUtil.formatStrLocaleSafe("%s(%s)", str, str2);
    }

    public static int m59h() {
        return f53c.getAndIncrement();
    }
}
