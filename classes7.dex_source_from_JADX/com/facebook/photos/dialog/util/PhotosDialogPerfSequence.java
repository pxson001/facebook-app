package com.facebook.photos.dialog.util;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableBiMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: links_count */
public class PhotosDialogPerfSequence {
    private static PhotosDialogPerfSequence f10138g;
    private static final Object f10139h = new Object();
    private final SequenceLogger f10140a;
    private final MonotonicClock f10141b;
    public Optional<Sequence<AbstractSequenceDefinition>> f10142c = Absent.INSTANCE;
    private Optional<AbstractSequenceDefinition> f10143d = Absent.INSTANCE;
    public Optional<String> f10144e = Absent.INSTANCE;
    public Optional<String> f10145f = Absent.INSTANCE;

    private static PhotosDialogPerfSequence m12017b(InjectorLike injectorLike) {
        return new PhotosDialogPerfSequence((SequenceLogger) SequenceLoggerImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PhotosDialogPerfSequence(SequenceLogger sequenceLogger, MonotonicClock monotonicClock) {
        this.f10140a = sequenceLogger;
        this.f10141b = monotonicClock;
    }

    public static PhotosDialogPerfSequence m12016a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosDialogPerfSequence b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10139h) {
                PhotosDialogPerfSequence photosDialogPerfSequence;
                if (a2 != null) {
                    photosDialogPerfSequence = (PhotosDialogPerfSequence) a2.a(f10139h);
                } else {
                    photosDialogPerfSequence = f10138g;
                }
                if (photosDialogPerfSequence == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12017b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10139h, b3);
                        } else {
                            f10138g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosDialogPerfSequence;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m12021a(String str, AbstractSequenceDefinition abstractSequenceDefinition, String str2, long j) {
        if (this.f10142c.isPresent()) {
            m12018b();
        }
        if (m12019c()) {
            this.f10144e = Optional.of(str);
            this.f10142c = Optional.of(this.f10140a.a(abstractSequenceDefinition, str, ImmutableBiMap.b("source", str2), j));
            this.f10143d = Optional.of(abstractSequenceDefinition);
            SequenceLoggerDetour.a((Sequence) this.f10142c.get(), "WaitTime", null, null, j, -1782229737);
            SequenceLoggerDetour.a((Sequence) this.f10142c.get(), "DataFetch", null, null, j, 1661294608);
        }
    }

    private void m12018b() {
        if (this.f10142c.isPresent()) {
            this.f10140a.a((AbstractSequenceDefinition) this.f10143d.get(), (String) this.f10144e.get());
            this.f10142c = Absent.INSTANCE;
            this.f10143d = Absent.INSTANCE;
            this.f10144e = Absent.INSTANCE;
            this.f10145f = Absent.INSTANCE;
        }
    }

    public final void m12022b(String str) {
        if (this.f10142c.isPresent()) {
            SequenceLoggerDetour.a((Sequence) this.f10142c.get(), str, -297403199);
        }
    }

    public final void m12023d(String str) {
        if (this.f10142c.isPresent()) {
            SequenceLoggerDetour.b((Sequence) this.f10142c.get(), str, 294499439);
        }
    }

    public final void m12020a() {
        if (this.f10142c.isPresent()) {
            if (((Sequence) this.f10142c.get()).f("WaitTime")) {
                SequenceLoggerDetour.b((Sequence) this.f10142c.get(), "WaitTime", 203905170);
            }
            if (((Sequence) this.f10142c.get()).f("DataFetch")) {
                SequenceLoggerDetour.b((Sequence) this.f10142c.get(), "DataFetch", 1647139985);
            }
            this.f10140a.b((AbstractSequenceDefinition) this.f10143d.get(), (String) this.f10144e.get(), null, this.f10141b.now());
            this.f10142c = Absent.INSTANCE;
            this.f10143d = Absent.INSTANCE;
            this.f10144e = Absent.INSTANCE;
            this.f10145f = Absent.INSTANCE;
        }
    }

    private static boolean m12019c() {
        return Math.random() < 0.10000000149011612d;
    }
}
