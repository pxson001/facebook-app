package com.facebook.search.suggestions.logging;

import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.suggestions.SuggestionsFragment;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

/* compiled from: zipcode */
public abstract class SuggestionsPerformanceLogger {
    public final SequenceLogger f152a;
    protected final QuickPerformanceLogger f153b;
    public final List<Integer> f154c = Lists.a();
    public int f155d = 0;
    public final HashMap<TypeaheadRequest, Integer> f156e = Maps.c();
    public final BitSet f157f = new BitSet();
    public final List<Integer> f158g = Lists.a();

    /* compiled from: zipcode */
    public class SuggestionsTypeaheadSequenceDefinition extends AbstractSequenceDefinition {
        public SuggestionsTypeaheadSequenceDefinition(int i, String str) {
            super(i, str, false, ImmutableSet.of(SuggestionsFragment.class.getName()));
        }
    }

    public abstract SuggestionsTypeaheadSequenceDefinition mo31a();

    public SuggestionsPerformanceLogger(SequenceLogger sequenceLogger, QuickPerformanceLogger quickPerformanceLogger) {
        this.f152a = sequenceLogger;
        this.f153b = quickPerformanceLogger;
    }

    public void mo32a(TypeaheadRequest typeaheadRequest) {
        int i = this.f155d;
        this.f155d++;
        Integer num = (Integer) this.f156e.get(typeaheadRequest);
        if (num == null || !this.f157f.get(num.intValue())) {
            this.f156e.put(typeaheadRequest, Integer.valueOf(i));
            this.f154c.add(Integer.valueOf(i));
            Sequence b = m273b();
            SequenceLoggerDetour.a(b, "end_to_end", String.valueOf(i), null, -1798914589);
            SequenceLoggerDetour.a(b, "pre_fetch", String.valueOf(i), null, -365800989);
            this.f153b.e(458784, i);
        }
    }

    public final void m274b(TypeaheadRequest typeaheadRequest) {
        Integer num = (Integer) this.f156e.get(typeaheadRequest);
        if (num != null) {
            Sequence b = m273b();
            SequenceLoggerDetour.a(b, "pre_fetch", String.valueOf(num), 1964195882);
            SequenceLoggerDetour.a(b, "end_to_end", String.valueOf(num), 1418062187);
            this.f156e.remove(typeaheadRequest);
            this.f154c.remove(num);
        }
    }

    public void mo36c(TypeaheadRequest typeaheadRequest) {
        mo33a(typeaheadRequest, 0);
    }

    public void mo33a(TypeaheadRequest typeaheadRequest, int i) {
        Integer num = (Integer) this.f156e.get(typeaheadRequest);
        if (num != null) {
            Sequence b = m273b();
            ImmutableMap immutableMap = RegularImmutableBiMap.a;
            if (i > 0) {
                immutableMap = ImmutableMap.of("IS_DELAYED_REQUEST", Boolean.TRUE.toString(), "DELAY_MS", String.valueOf(i), "QUERY_LENGTH", String.valueOf(typeaheadRequest.b.codePointCount(0, typeaheadRequest.b.length())));
            }
            SequenceLoggerDetour.b(b, "pre_fetch", String.valueOf(num), immutableMap, -615527364);
            SequenceLoggerDetour.a(b, "network", String.valueOf(num), null, -2056249306);
            this.f154c.remove(num);
            this.f157f.set(num.intValue());
        }
    }

    public void mo34a(TypeaheadRequest typeaheadRequest, List<TypeaheadUnit> list) {
        Integer num = (Integer) this.f156e.get(typeaheadRequest);
        if (num != null && this.f157f.get(num.intValue())) {
            String valueOf = String.valueOf(num);
            Sequence b = m273b();
            SequenceLoggerDetour.b(b, "network", valueOf, ImmutableBiMap.b("fetched_count", String.valueOf(list.size())), -1356487913);
            SequenceLoggerDetour.a(b, "post_processing", valueOf, null, 2025785659);
            this.f158g.add(num);
        }
    }

    public void mo37d(TypeaheadRequest typeaheadRequest) {
        Integer num = (Integer) this.f156e.get(typeaheadRequest);
        if (num != null) {
            String valueOf = String.valueOf(num);
            Sequence b = m273b();
            this.f153b.markerCancel(458784, num.intValue());
            SequenceLoggerDetour.a(b, "end_to_end", valueOf, -1988981849);
            SequenceLoggerDetour.a(b, "pre_fetch", valueOf, -408137850);
            SequenceLoggerDetour.a(b, "network", valueOf, -756027959);
            this.f156e.remove(typeaheadRequest);
            this.f157f.clear(num.intValue());
        }
    }

    public void mo35a(List<TypeaheadUnit> list) {
        if (!this.f158g.isEmpty()) {
            Sequence b = m273b();
            for (Integer intValue : this.f158g) {
                int intValue2 = intValue.intValue();
                SequenceLoggerDetour.b(b, "post_processing", String.valueOf(intValue2), null, 1891870141);
                SequenceLoggerDetour.b(b, "end_to_end", String.valueOf(intValue2), null, 304860233);
                this.f153b.b(458784, intValue2, (short) 2);
                this.f157f.clear(intValue2);
            }
            this.f158g.clear();
        }
    }

    protected final Sequence<SuggestionsTypeaheadSequenceDefinition> m273b() {
        Sequence<SuggestionsTypeaheadSequenceDefinition> e = this.f152a.e(mo31a());
        return e != null ? e : this.f152a.a(mo31a());
    }
}
