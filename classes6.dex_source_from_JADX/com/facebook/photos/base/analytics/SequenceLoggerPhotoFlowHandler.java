package com.facebook.photos.base.analytics;

import com.facebook.common.util.StringUtil;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: instrumented_image_fetch */
public class SequenceLoggerPhotoFlowHandler {
    private static final UploadSequence f12652a = new UploadSequence();
    private final SequenceLogger f12653b;
    public final SequenceExtra f12654c = new SequenceExtra();

    /* compiled from: instrumented_image_fetch */
    public final class SequenceExtra {
        public String f12650a;
        public List<Long> f12651b = RegularImmutableList.a;
    }

    /* compiled from: instrumented_image_fetch */
    public final class UploadSequence extends AbstractSequenceDefinition {
        public UploadSequence() {
            super(1310721, "media_upload_sequence");
        }
    }

    @Inject
    public SequenceLoggerPhotoFlowHandler(SequenceLogger sequenceLogger) {
        this.f12653b = sequenceLogger;
    }

    public final void m20025b() {
        m20013a("FlowMarker", ImmutableMap.copyOf(m20011a(false)));
    }

    public final void m20027c() {
        m20018d("FlowMarker");
        this.f12653b.b(f12652a);
    }

    public final void m20029d() {
        m20018d("FlowMarker");
        this.f12653b.b(f12652a);
    }

    public final void m20031e() {
        m20016c("FlowMarker");
        this.f12653b.b(f12652a);
    }

    public final void m20032f() {
        m20014b("FlowMarker");
        this.f12653b.b(f12652a);
    }

    public final void m20033g() {
        m20012a("ProcessVideoMarker");
    }

    public final void m20024a(String str, String str2) {
        Map a = m20011a(false);
        a.put("failure_reason", str);
        a.put("failure_message", str2);
        m20017c("ProcessVideoMarker", ImmutableMap.copyOf(a));
    }

    public final void m20034h() {
        m20018d("ProcessVideoMarker");
    }

    public final void m20023a(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
        Map a = m20011a(false);
        a.put("format", str);
        a.put("source_width", String.valueOf(i));
        a.put("source_height", String.valueOf(i2));
        a.put("source_bit_rate", String.valueOf(i3));
        a.put("source_frame_rate", String.valueOf(i4));
        a.put("target_width", String.valueOf(i5));
        a.put("target_height", String.valueOf(i6));
        a.put("target_bit_rate", String.valueOf(i7));
        a.put("target_frame_rate", String.valueOf(i8));
        a.put("video_time", String.valueOf(j));
        m20015b("ProcessVideoMarker", ImmutableMap.copyOf(a));
    }

    public final void m20035i() {
        m20012a("TransferMarker");
    }

    public final void m20036j() {
        m20016c("TransferMarker");
    }

    public final void m20037k() {
        m20018d("TransferMarker");
    }

    public final void m20038l() {
        m20014b("TransferMarker");
    }

    public final void m20039m() {
        SequenceLoggerDetour.e(m20021x(), "SkipUploadEvent", 828541776);
    }

    public final void m20040n() {
        m20012a("HashComputeMarker");
    }

    public final void m20041o() {
        m20014b("HashComputeMarker");
    }

    public final void m20042p() {
        m20012a("InitMarker");
    }

    public final void m20026b(String str, String str2) {
        Map a = m20011a(false);
        a.put("failure_reason", str);
        a.put("failure_message", str2);
        m20017c("InitMarker", ImmutableMap.copyOf(a));
    }

    public final void m20043q() {
        m20018d("InitMarker");
    }

    public final void m20044r() {
        m20014b("InitMarker");
    }

    public final void m20022a(int i, long j, long j2, int i2) {
        Map a = m20011a(false);
        a.put("chunk_id", String.valueOf(i));
        a.put("chunk_size", String.valueOf(j2));
        a.put("chunk_offset", String.valueOf(j));
        a.put("retry_count", String.valueOf(i2));
        m20013a("ChunkMarker", ImmutableMap.copyOf(a));
    }

    public final void m20028c(String str, String str2) {
        Map a = m20011a(false);
        a.put("failure_reason", str);
        a.put("failure_message", str2);
        m20017c("ChunkMarker", ImmutableMap.copyOf(a));
    }

    public final void m20045s() {
        m20018d("ChunkMarker");
    }

    public final void m20046t() {
        m20014b("ChunkMarker");
    }

    public final void m20047u() {
        m20012a("PostMarker");
    }

    public final void m20048v() {
        m20014b("PostMarker");
    }

    public final void m20030d(String str, String str2) {
        Map a = m20011a(false);
        a.put("failure_reason", str);
        a.put("failure_message", str2);
        m20017c("PostMarker", ImmutableMap.copyOf(a));
    }

    private Sequence m20020w() {
        return this.f12653b.a(f12652a, ImmutableMap.copyOf(m20011a(false)));
    }

    private Sequence m20021x() {
        Sequence e = this.f12653b.e(f12652a);
        if (e == null) {
            return m20020w();
        }
        return e;
    }

    private void m20012a(String str) {
        m20013a(str, ImmutableMap.copyOf(m20011a(false)));
    }

    private void m20014b(String str) {
        m20015b(str, ImmutableMap.copyOf(m20011a(false)));
    }

    private void m20016c(String str) {
        m20017c(str, ImmutableMap.copyOf(m20011a(false)));
    }

    private void m20018d(String str) {
        m20019d(str, ImmutableMap.copyOf(m20011a(true)));
    }

    private void m20013a(String str, ImmutableMap<String, String> immutableMap) {
        SequenceLoggerDetour.a(m20021x(), str, null, immutableMap, 309336235);
    }

    private void m20015b(String str, ImmutableMap<String, String> immutableMap) {
        SequenceLoggerDetour.b(m20021x(), str, null, immutableMap, 527082155);
    }

    private void m20017c(String str, ImmutableMap<String, String> immutableMap) {
        SequenceLoggerDetour.c(m20021x(), str, null, immutableMap, -172218769);
    }

    private void m20019d(String str, ImmutableMap<String, String> immutableMap) {
        SequenceLoggerDetour.b(m20021x(), str, null, immutableMap, -1696335322);
    }

    private Map<String, String> m20011a(boolean z) {
        String str;
        Map<String, String> hashMap = new HashMap();
        hashMap.put("waterfall_id", this.f12654c.f12650a);
        String str2 = "start_times";
        if (this.f12654c.f12651b == null) {
            str = "";
        } else {
            str = StringUtil.b(",", new Object[]{this.f12654c.f12651b});
        }
        hashMap.put(str2, str);
        if (z) {
            hashMap.put("is_cancelled", Boolean.toString(true));
        }
        return hashMap;
    }
}
