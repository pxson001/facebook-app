package com.facebook.timeline.logging;

import android.content.Context;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.profile.api.RelationshipType;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.sequencelogger.Sequence;
import com.facebook.timeline.data.PhotoLoadState;
import com.facebook.timeline.data.TimelineHeaderRenderState;
import com.facebook.timeline.protocol.ResultSource;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fav_photos_replace_in_editing_view_tile */
public class TimelinePerformanceLogger {
    private static TimelinePerformanceLogger f14636I;
    private static final Object f14637J = new Object();
    private boolean f14638A = false;
    private boolean f14639B = false;
    public final Set<String> f14640C = Sets.a();
    private boolean f14641D = false;
    public boolean f14642E = false;
    public String f14643F = "NA";
    public int f14644G = -1;
    public String f14645H = "NA";
    private InitialUnitsLoadingIndicatorVisibility f14646a;
    public final QuickPerformanceLogger f14647b;
    public final TimelineSequenceLogger f14648c;
    private final FbNetworkManager f14649d;
    public final MonotonicClock f14650e;
    public final TimelineHeaderRenderState f14651f;
    public final ProfileOverlayHelper f14652g;
    private ResultSource f14653h = ResultSource.UNDEFINED;
    private ResultSource f14654i = ResultSource.UNDEFINED;
    private RelationshipType f14655j = RelationshipType.UNDEFINED;
    public boolean f14656k = false;
    public boolean f14657l = false;
    private boolean f14658m = false;
    private boolean f14659n = false;
    private boolean f14660o = false;
    private boolean f14661p = false;
    private boolean f14662q = false;
    private boolean f14663r = false;
    private boolean f14664s = false;
    private boolean f14665t = false;
    public boolean f14666u = false;
    public boolean f14667v = false;
    public boolean f14668w = false;
    private boolean f14669x = false;
    private boolean f14670y = false;
    private boolean f14671z = false;

    /* compiled from: fav_photos_replace_in_editing_view_tile */
    public /* synthetic */ class C10631 {
        public static final /* synthetic */ int[] f14635a = new int[UnitsFetchTrigger.values().length];

        static {
            try {
                f14635a[UnitsFetchTrigger.AUTO_INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14635a[UnitsFetchTrigger.AUTO_SCROLL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14635a[UnitsFetchTrigger.MANUAL_SECTION_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: fav_photos_replace_in_editing_view_tile */
    public enum InitialUnitsLoadingIndicatorVisibility {
        VISIBLE,
        INVISIBLE
    }

    /* compiled from: fav_photos_replace_in_editing_view_tile */
    public enum UnitsFetchTrigger {
        AUTO_INITIAL,
        AUTO_SCROLL,
        MANUAL_SECTION_HEADER
    }

    private static TimelinePerformanceLogger m18596b(InjectorLike injectorLike) {
        return new TimelinePerformanceLogger(QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), TimelineSequenceLogger.m18621a(injectorLike), FbNetworkManager.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), TimelineHeaderRenderState.m18470a(injectorLike), ProfileOverlayHelper.m18525a(injectorLike));
    }

    public static TimelinePerformanceLogger m18594a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelinePerformanceLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14637J) {
                TimelinePerformanceLogger timelinePerformanceLogger;
                if (a2 != null) {
                    timelinePerformanceLogger = (TimelinePerformanceLogger) a2.a(f14637J);
                } else {
                    timelinePerformanceLogger = f14636I;
                }
                if (timelinePerformanceLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18596b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14637J, b3);
                        } else {
                            f14636I = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelinePerformanceLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public TimelinePerformanceLogger(QuickPerformanceLogger quickPerformanceLogger, TimelineSequenceLogger timelineSequenceLogger, FbNetworkManager fbNetworkManager, MonotonicClock monotonicClock, TimelineHeaderRenderState timelineHeaderRenderState, ProfileOverlayHelper profileOverlayHelper) {
        this.f14647b = quickPerformanceLogger;
        this.f14648c = timelineSequenceLogger;
        this.f14649d = fbNetworkManager;
        this.f14650e = monotonicClock;
        this.f14651f = timelineHeaderRenderState;
        this.f14652g = profileOverlayHelper;
    }

    public final void m18611b() {
        this.f14648c.m18624a("TimelineFragmentFbInjectorInjectMe");
    }

    public final void m18612c() {
        this.f14648c.m18627b("TimelineFragmentFbInjectorInjectMe");
    }

    public final void m18614f() {
        this.f14648c.m18624a("TimelineLoadHeader");
        this.f14652g.m18527a("TimelineLoadHeader");
    }

    public final void m18610a(boolean z, ResultSource resultSource, RelationshipType relationshipType, CoverPhotoSource coverPhotoSource) {
        Builder b = new Builder().b("source_header", resultSource.toString()).b("relationship_type", relationshipType.toString()).b("cover_photo_source", coverPhotoSource.toString());
        if (z) {
            b.b("from_get_notified_notification", Boolean.TRUE.toString());
        }
        this.f14648c.m18629b("TimelineLoadHeader", b.b());
        this.f14652g.m18528b("TimelineLoadHeader");
        if (this.f14653h == ResultSource.UNDEFINED) {
            this.f14653h = resultSource;
        }
        if (this.f14655j == RelationshipType.UNDEFINED) {
            this.f14655j = relationshipType;
        }
        this.f14642E = true;
    }

    public final void m18604a(long j) {
        long now = this.f14650e.now();
        String str = "TimelineEarlyFetchHeadStart";
        Sequence e = this.f14648c.f14673a.e(TimelineSequences.f14676a);
        if (e != null) {
            SequenceLoggerDetour.a(e, str, null, null, now, 1554707199);
        }
        this.f14648c.m18628b("TimelineEarlyFetchHeadStart", now + j);
    }

    public final void m18605a(DataFreshnessResult dataFreshnessResult) {
        if (DataFreshnessResult.FROM_SERVER.equals(dataFreshnessResult)) {
            this.f14648c.m18627b("ProtilesNetworkFetch");
        } else {
            this.f14648c.m18631c("ProtilesNetworkFetch");
        }
        if (this.f14639B) {
            this.f14648c.m18627b("ProtilesWaitTime");
            this.f14669x = true;
            m18602y();
        }
        this.f14662q = true;
    }

    public final void m18606a(DataFreshnessResult dataFreshnessResult, ResultSource resultSource, RelationshipType relationshipType) {
        this.f14647b.b(1703954, (short) 2);
        if (DataFreshnessResult.FROM_SERVER.equals(dataFreshnessResult)) {
            this.f14647b.b(1703955, (short) 2);
            this.f14647b.d(1703956);
            this.f14647b.b(1703952, (short) 2);
            this.f14648c.m18627b("TimelineFirstUnitsNetworkFetch");
        } else {
            this.f14647b.b(1703956, (short) 2);
            this.f14647b.d(1703955);
            this.f14647b.d(1703952);
            this.f14648c.m18631c("TimelineFirstUnitsNetworkFetch");
        }
        this.f14648c.m18629b("TimelineInitialFetchUnits", new Builder().b("source_initial_units", resultSource.toString()).b("relationship_type", relationshipType.toString()).b());
        if (this.f14654i == ResultSource.UNDEFINED) {
            this.f14654i = resultSource;
        }
        if (this.f14638A) {
            this.f14647b.b(1703938, (short) 2);
            this.f14648c.m18627b("TimelineFetchInitialUnitsWaitTime");
            this.f14671z = true;
        }
        this.f14664s = true;
        m18602y();
    }

    public final void m18615k() {
        this.f14648c.m18633d("ProtilesNetworkFetch");
        this.f14663r = true;
        m18602y();
    }

    public final void m18616l() {
        this.f14647b.b(1703954, (short) 3);
        this.f14647b.d(1703955);
        this.f14647b.d(1703956);
        this.f14647b.d(1703952);
        this.f14648c.m18633d("TimelineFirstUnitsNetworkFetch");
        this.f14648c.m18633d("TimelineInitialFetchUnits");
        this.f14647b.b(1703938, (short) 3);
        this.f14648c.m18633d("TimelineFetchInitialUnitsWaitTime");
        this.f14665t = true;
        m18602y();
    }

    public final void m18609a(boolean z, InitialUnitsLoadingIndicatorVisibility initialUnitsLoadingIndicatorVisibility) {
        if (z) {
            this.f14670y = true;
            this.f14646a = initialUnitsLoadingIndicatorVisibility;
        } else if (initialUnitsLoadingIndicatorVisibility == this.f14646a) {
            this.f14670y = false;
        }
    }

    public final void m18617r() {
        this.f14648c.m18624a("TimelineBindHeader");
    }

    public final void m18618s() {
        this.f14648c.m18627b("TimelineBindHeader");
    }

    public final void m18619t() {
        if (!this.f14651f.f14578a) {
            this.f14648c.m18634f("TimelineRenderCoreHeader");
            this.f14651f.f14578a = true;
            m18597f("core_header_rendered");
            m18598g("core_header_rendered");
            m18600i("header rendered");
            m18601x();
        }
    }

    public final void m18620u() {
        if (!this.f14641D) {
            this.f14648c.m18634f("TimelineUserScrolled");
            this.f14641D = true;
        }
        m18597f("user_scrolled");
        m18598g("user_scrolled");
    }

    private void m18597f(String str) {
        if (!this.f14639B && this.f14668w) {
            this.f14639B = true;
            if (this.f14662q) {
                this.f14648c.m18625a("ProtilesWaitTime", m18599h(str));
                this.f14648c.m18627b("ProtilesWaitTime");
                this.f14669x = true;
                m18602y();
                return;
            }
            this.f14648c.m18625a("ProtilesWaitTime", m18599h(str));
        }
    }

    private void m18598g(String str) {
        if (!this.f14638A && this.f14670y) {
            this.f14638A = true;
            if (this.f14664s) {
                m18595a(m18599h(str));
                return;
            }
            this.f14647b.b(1703938);
            this.f14648c.m18625a("TimelineFetchInitialUnitsWaitTime", m18599h(str));
        }
    }

    private static ImmutableMap<String, String> m18599h(String str) {
        return new Builder().b("initial_units_wait_time_start_reason", str).b();
    }

    private void m18595a(ImmutableMap<String, String> immutableMap) {
        long now = this.f14650e.now();
        this.f14647b.markerStart(1703938, 0, now);
        this.f14647b.markerEnd(1703938, 0, (short) 2, now);
        this.f14648c.m18625a("TimelineFetchInitialUnitsWaitTime", (ImmutableMap) immutableMap);
        this.f14648c.m18627b("TimelineFetchInitialUnitsWaitTime");
        this.f14671z = true;
        m18602y();
    }

    public final void m18607a(PhotoLoadState photoLoadState) {
        if (photoLoadState == PhotoLoadState.PHOTO_LOW_RES && this.f14651f.f14581d == PhotoLoadState.PHOTO_NOT_LOADED) {
            this.f14648c.m18627b("TimelineLoadProfilePicPreview");
        } else if (photoLoadState == PhotoLoadState.PHOTO_HIGH_RES && this.f14651f.f14581d != PhotoLoadState.PHOTO_HIGH_RES) {
            this.f14648c.m18627b("TimelineLoadProfilePic");
        } else if (photoLoadState == PhotoLoadState.PHOTO_LOW_RES_FAILED) {
            this.f14648c.m18633d("TimelineLoadProfilePicPreview");
        } else if (photoLoadState == PhotoLoadState.PHOTO_HIGH_RES_FAILED) {
            this.f14648c.m18633d("TimelineLoadProfilePic");
        }
        this.f14651f.f14581d = photoLoadState;
        m18600i("profile photo loaded");
        m18601x();
    }

    public final void m18613c(PhotoLoadState photoLoadState) {
        if (photoLoadState == PhotoLoadState.PHOTO_NONE) {
            this.f14647b.d(1703960);
        } else if ((photoLoadState == PhotoLoadState.PHOTO_LOW_RES || photoLoadState == PhotoLoadState.PHOTO_MINI_PREVIEW) && this.f14651f.f14582e == PhotoLoadState.PHOTO_NOT_LOADED) {
            this.f14648c.m18627b("TimelineLoadCoverPhotoLowRes");
        } else if (photoLoadState == PhotoLoadState.PHOTO_HIGH_RES && this.f14651f.f14582e != PhotoLoadState.PHOTO_HIGH_RES) {
            this.f14647b.b(1703960, (short) 2);
            this.f14648c.m18629b("TimelineLoadCoverPhoto", new Builder().b("slow_connection", this.f14649d.g() ? "yes" : "no").b());
        } else if (photoLoadState == PhotoLoadState.PHOTO_LOW_RES_FAILED) {
            ImmutableMap b = new Builder().b("slow_connection", this.f14649d.g() ? "yes" : "no").b();
            TimelineSequenceLogger timelineSequenceLogger = this.f14648c;
            String str = "TimelineLoadCoverPhotoLowRes";
            Sequence e = timelineSequenceLogger.f14673a.e(TimelineSequences.f14676a);
            if (e != null) {
                SequenceLoggerDetour.c(e, str, null, b, timelineSequenceLogger.f14675c.now(), -1970951135);
            }
        } else if (photoLoadState == PhotoLoadState.PHOTO_HIGH_RES_FAILED) {
            this.f14647b.b(1703960, (short) 3);
            this.f14648c.m18633d("TimelineLoadCoverPhoto");
        }
        if (this.f14651f.f14582e != PhotoLoadState.PHOTO_HIGH_RES) {
            this.f14651f.f14582e = photoLoadState;
        }
        m18600i("cover photo loaded");
        m18601x();
    }

    private void m18601x() {
        if (!this.f14660o) {
            if (this.f14651f.m18473h()) {
                this.f14647b.b(1703945, (short) 3);
                this.f14648c.m18633d("TimelineRenderEntireHeader");
                this.f14647b.d(1703946);
                this.f14647b.d(1703947);
                this.f14660o = true;
                return;
            }
            if (this.f14651f.m18477l() && !this.f14660o) {
                this.f14647b.b(1703945, (short) 2);
                this.f14648c.m18629b("TimelineRenderEntireHeader", new Builder().b("source_header", this.f14653h.toString()).b("source_initial_units", this.f14654i.toString()).b("relationship_type", this.f14655j.toString()).b());
                if (ResultSource.SERVER.equals(this.f14653h)) {
                    this.f14647b.b(1703946, (short) 2);
                    this.f14647b.d(1703947);
                } else if (ResultSource.DISK_CACHE.equals(this.f14653h)) {
                    this.f14647b.b(1703947, (short) 2);
                    this.f14647b.d(1703946);
                }
                this.f14660o = true;
            }
            m18602y();
        }
    }

    private void m18600i(String str) {
        if (!this.f14659n) {
            if (this.f14651f.m18473h()) {
                this.f14648c.m18633d("TimelineRenderLowResHeader");
                this.f14647b.b(1703962, (short) 3);
                this.f14647b.d(1703949);
                this.f14647b.d(1703950);
                this.f14648c.m18633d("TimelineRenderLowResHeaderCoverphotoOptional");
                this.f14659n = true;
                this.f14658m = true;
                return;
            }
            if (this.f14651f.m18475j() && !this.f14658m) {
                this.f14648c.m18629b("TimelineRenderLowResHeaderCoverphotoOptional", new Builder().b("source_header", this.f14653h.toString()).b("relationship_type", this.f14655j.toString()).b("last_finish_element", str).b("profile pic load state", this.f14651f.f14581d.toString()).b("cover photo load state", this.f14651f.f14582e.toString()).b());
                this.f14658m = true;
            }
            if (this.f14651f.m18476k() && !this.f14659n) {
                this.f14647b.b(1703962, (short) 2);
                this.f14648c.m18629b("TimelineRenderLowResHeader", new Builder().b("source_header", this.f14653h.toString()).b("relationship_type", this.f14655j.toString()).b("last_finish_element", str).b("profile pic load state", this.f14651f.f14581d.toString()).b("cover photo load state", this.f14651f.f14582e.toString()).b("intro_bio_view_type", this.f14643F).b("intro_num_about_items", String.valueOf(this.f14644G)).b("intro_photos_view_type", this.f14645H).b());
                this.f14652g.m18528b("TimelineRenderLowResHeader");
                this.f14648c.f14674b.b("LoadTimelineHeader", str);
                this.f14659n = true;
                if (ResultSource.SERVER.equals(this.f14653h)) {
                    this.f14647b.b(1703949, (short) 2);
                    this.f14647b.d(1703950);
                } else if (ResultSource.DISK_CACHE.equals(this.f14653h)) {
                    this.f14647b.b(1703950, (short) 2);
                    this.f14647b.d(1703949);
                }
            }
        }
    }

    private void m18602y() {
        if (!this.f14661p) {
            if (this.f14651f.m18473h() || this.f14665t || this.f14663r) {
                this.f14648c.m18630c();
                this.f14661p = true;
            }
            if (this.f14651f.m18477l() && this.f14669x && this.f14671z && !this.f14661p) {
                this.f14648c.m18626b();
                this.f14661p = true;
            }
        }
    }

    public final void m18608a(String str, boolean z) {
        this.f14647b.b(1703945);
        this.f14647b.b(1703946);
        this.f14647b.b(1703947);
        this.f14647b.b(1703949);
        this.f14647b.b(1703950);
        this.f14647b.b(1703962);
        this.f14647b.b(1703954);
        this.f14647b.b(1703955);
        this.f14647b.b(1703956);
        this.f14647b.b(1703960);
        this.f14648c.f14673a.a(TimelineSequences.f14676a);
        Builder builder = new Builder();
        String str2 = "navigation_source";
        if (str == null) {
            str = "unknown";
        }
        this.f14648c.m18625a("TimelineFragmentCreate", builder.b(str2, str).b("is_first_load", String.valueOf(z)).b());
        this.f14648c.m18624a("TimelineRenderEntireHeader");
        this.f14648c.m18624a("TimelineRenderLowResHeader");
        this.f14648c.m18624a("TimelineRenderLowResHeaderCoverphotoOptional");
        this.f14652g.m18527a("TimelineRenderLowResHeader");
    }

    public final void m18603a() {
        this.f14647b.d(1703945);
        this.f14647b.d(1703946);
        this.f14647b.d(1703947);
        this.f14647b.d(1703949);
        this.f14647b.d(1703950);
        this.f14647b.b(1703962, (short) 4);
        this.f14647b.d(1703954);
        this.f14647b.d(1703955);
        this.f14647b.d(1703956);
        this.f14647b.d(1703938);
        this.f14647b.d(1703960);
        this.f14648c.m18632d();
    }
}
