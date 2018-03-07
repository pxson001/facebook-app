package com.facebook.photos.dialog.util;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: links_add_prompt_impression */
public class PhotosDialogPerfUtil {
    private static PhotosDialogPerfUtil f10152k;
    private static final Object f10153l = new Object();
    public final QuickPerformanceLogger f10154a;
    public final InteractionTTILogger f10155b;
    public final PhotosDialogPerfSequence f10156c;
    @Nullable
    public FullscreenGallerySource f10157d = null;
    @Nullable
    public String f10158e = null;
    public int f10159f = m12024a(this.f10157d);
    public FragmentPerfMarkerConfig f10160g = null;
    public boolean f10161h = false;
    private boolean f10162i = false;
    private boolean f10163j = false;

    /* compiled from: links_add_prompt_impression */
    public class FragmentPerfMarkerConfig {
        public final AbstractSequenceDefinition f10146a;
        public final String f10147b;
        public final int f10148c;
        public final boolean f10149d;
        public final int f10150e;
        public final int f10151f;

        public FragmentPerfMarkerConfig(AbstractSequenceDefinition abstractSequenceDefinition, String str, int i) {
            this.f10146a = abstractSequenceDefinition;
            this.f10147b = str;
            this.f10148c = i;
            this.f10149d = false;
            this.f10150e = 0;
            this.f10151f = 0;
        }

        public FragmentPerfMarkerConfig(AbstractSequenceDefinition abstractSequenceDefinition, String str, int i, int i2, int i3) {
            this.f10146a = abstractSequenceDefinition;
            this.f10147b = str;
            this.f10148c = i;
            this.f10149d = true;
            this.f10150e = i2;
            this.f10151f = i3;
        }
    }

    private static PhotosDialogPerfUtil m12026b(InjectorLike injectorLike) {
        return new PhotosDialogPerfUtil(QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), InteractionTTILogger.a(injectorLike), PhotosDialogPerfSequence.m12016a(injectorLike));
    }

    public static PhotosDialogPerfUtil m12025a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosDialogPerfUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10153l) {
                PhotosDialogPerfUtil photosDialogPerfUtil;
                if (a2 != null) {
                    photosDialogPerfUtil = (PhotosDialogPerfUtil) a2.a(f10153l);
                } else {
                    photosDialogPerfUtil = f10152k;
                }
                if (photosDialogPerfUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12026b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10153l, b3);
                        } else {
                            f10152k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosDialogPerfUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PhotosDialogPerfUtil(QuickPerformanceLogger quickPerformanceLogger, InteractionTTILogger interactionTTILogger, PhotosDialogPerfSequence photosDialogPerfSequence) {
        this.f10154a = quickPerformanceLogger;
        this.f10155b = interactionTTILogger;
        this.f10156c = photosDialogPerfSequence;
    }

    public final void m12031a(FullscreenGallerySource fullscreenGallerySource, FragmentPerfMarkerConfig fragmentPerfMarkerConfig, String str, long j) {
        this.f10157d = fullscreenGallerySource;
        this.f10159f = m12024a(this.f10157d);
        this.f10158e = StringFormatUtil.formatStrLocaleSafe("LoadPhotoGalleryWithPhotoFromSource_%s-MediaGallery", this.f10157d != null ? this.f10157d.name() : FullscreenGallerySource.UNKNOWN.name());
        this.f10160g = fragmentPerfMarkerConfig;
        this.f10161h = true;
        this.f10162i = false;
        this.f10163j = false;
        this.f10155b.a(this.f10158e, getClass().getSimpleName(), j);
        this.f10154a.markerStart(this.f10160g.f10148c, 0, j);
        if (this.f10160g.f10149d) {
            this.f10154a.c(this.f10160g.f10150e);
            m12027h();
        }
        this.f10156c.m12021a(str, this.f10160g.f10146a, fullscreenGallerySource == null ? FullscreenGallerySource.UNKNOWN.name() : fullscreenGallerySource.name(), j);
    }

    public final void m12030a() {
        if (this.f10161h) {
            this.f10156c.m12022b("DataFetch");
        }
    }

    public final void m12034c() {
        if (this.f10161h) {
            this.f10162i = false;
            this.f10155b.c();
            this.f10156c.m12022b("Animation");
        }
    }

    public final void m12036d() {
        if (this.f10161h) {
            this.f10162i = true;
            this.f10155b.d();
            this.f10156c.m12023d("Animation");
            if (this.f10160g.f10149d) {
                if (this.f10163j) {
                    this.f10154a.a(this.f10160g.f10150e, (short) 2, 1);
                    this.f10154a.a(this.f10160g.f10151f, (short) 2, 1);
                } else {
                    this.f10154a.c(this.f10160g.f10150e);
                    m12027h();
                }
            }
            m12029k();
        }
    }

    public final void m12037e() {
        if (this.f10161h) {
            this.f10156c.m12022b("Inflate");
        }
    }

    public final void m12038f() {
        if (this.f10161h) {
            this.f10156c.m12023d("Inflate");
        }
    }

    public final void m12033a(boolean z) {
        if (this.f10161h) {
            this.f10154a.b(this.f10160g.f10148c, (short) 2);
            if (z) {
                this.f10156c.m12020a();
                this.f10155b.b(this.f10160g.f10147b, this.f10158e);
            }
        }
    }

    public final void m12035c(String str) {
        if (this.f10161h) {
            PhotosDialogPerfSequence photosDialogPerfSequence = this.f10156c;
            if (!(!photosDialogPerfSequence.f10144e.isPresent() || photosDialogPerfSequence.f10145f.isPresent() || ((Sequence) photosDialogPerfSequence.f10142c.get()).f("ImageFetch"))) {
                photosDialogPerfSequence.f10145f = Optional.of(str);
                photosDialogPerfSequence.m12022b("ImageFetch");
            }
        }
    }

    public final void m12032a(String str, boolean z) {
        if (this.f10161h) {
            this.f10163j = true;
            if (this.f10162i) {
                this.f10154a.b(this.f10160g.f10150e, (short) 2);
                this.f10154a.b(this.f10160g.f10151f, this.f10159f, (short) 2);
            } else {
                this.f10154a.d(this.f10160g.f10150e);
                m12028j();
            }
            if (this.f10154a.j(1310731, m12024a((Object) str))) {
                this.f10154a.b(1310731, m12024a((Object) str), (short) 2);
            }
            m12029k();
            if (z) {
                PhotosDialogPerfSequence photosDialogPerfSequence = this.f10156c;
                if (photosDialogPerfSequence.f10144e.isPresent() && photosDialogPerfSequence.f10145f.isPresent() && StringUtil.a((String) photosDialogPerfSequence.f10145f.get(), str)) {
                    photosDialogPerfSequence.m12023d("ImageFetch");
                    if (((Sequence) photosDialogPerfSequence.f10142c.get()).f("WaitTime")) {
                        SequenceLoggerDetour.b((Sequence) photosDialogPerfSequence.f10142c.get(), "WaitTime", -1127219332);
                    }
                    if (!((Sequence) photosDialogPerfSequence.f10142c.get()).f("DataFetch")) {
                        photosDialogPerfSequence.m12020a();
                    }
                }
            }
        }
    }

    public final void m12039g() {
        if (this.f10161h) {
            this.f10154a.d(this.f10160g.f10148c);
            this.f10154a.d(this.f10160g.f10150e);
            this.f10154a.d(1310731);
            m12028j();
            this.f10155b.a();
        }
    }

    public static int m12024a(@Nullable Object obj) {
        return obj != null ? obj.hashCode() : 0;
    }

    private void m12027h() {
        int i = this.f10160g.f10151f;
        this.f10154a.e(i, this.f10159f);
        this.f10154a.b(i, this.f10159f, this.f10158e);
    }

    private void m12028j() {
        this.f10154a.markerCancel(this.f10160g.f10151f, this.f10159f);
    }

    private void m12029k() {
        if (this.f10163j && this.f10162i) {
            this.f10155b.b(this.f10160g.f10147b, this.f10158e);
        }
    }
}
