package com.facebook.timeline.publisher;

import android.app.Activity;
import android.content.Intent;
import com.facebook.analytics.NavigationLogger;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.profile.api.RelationshipType;
import com.facebook.timeline.TimelineRefreshUnitsController;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.services.intentbuilder.ProfileServicesIntentBuilder;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: failed_video_length_retrieval */
public class TimelinePublishControllerImpl implements TimelinePublishController {
    private final Lazy<ComposerIntentLauncher> f12419a;
    public final ComposerLauncher f12420b;
    private final Provider<NavigationLogger> f12421c;
    private final Provider<ProfileServicesIntentBuilder> f12422d;
    public final Activity f12423e;
    private final TimelineStoriesDataFetcher f12424f;
    public final TimelineContext f12425g;
    public final TimelineHeaderUserData f12426h;
    private final TimelineAnalyticsLogger f12427i;

    @Inject
    public TimelinePublishControllerImpl(@Assisted Activity activity, @Assisted TimelineAnalyticsLogger timelineAnalyticsLogger, @Assisted TimelineContext timelineContext, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted TimelineRefreshUnitsController timelineRefreshUnitsController, Lazy<ComposerIntentLauncher> lazy, ComposerLauncher composerLauncher, Provider<NavigationLogger> provider, Provider<ProfileServicesIntentBuilder> provider2) {
        this.f12423e = activity;
        this.f12427i = timelineAnalyticsLogger;
        this.f12425g = timelineContext;
        this.f12426h = timelineHeaderUserData;
        this.f12424f = timelineRefreshUnitsController;
        this.f12419a = lazy;
        this.f12420b = composerLauncher;
        this.f12421c = provider;
        this.f12422d = provider2;
        if (this.f12425g != null && this.f12426h != null) {
            this.f12420b.a(1756, this.f12423e);
        }
    }

    public final void mo555a(String str) {
        this.f12427i.a(this.f12425g.b, "update_status", RelationshipType.getRelationshipType(this.f12425g.i(), this.f12426h.B(), this.f12426h.C()));
        m12464d(str);
    }

    public final void mo556b(String str) {
        ((NavigationLogger) this.f12421c.get()).a(str);
        this.f12427i.a(this.f12425g.b, "publish_photo", RelationshipType.getRelationshipType(this.f12425g.i(), this.f12426h.B(), this.f12426h.C()));
        ((ComposerIntentLauncher) this.f12419a.get()).a(m12463a(), 1756, this.f12423e);
    }

    public final void mo557c(String str) {
        ((NavigationLogger) this.f12421c.get()).a(str);
        this.f12427i.a(this.f12425g.b, "publish_moment", RelationshipType.getRelationshipType(this.f12425g.i(), this.f12426h.B(), this.f12426h.C()));
        if (this.f12424f != null) {
            this.f12424f.m10717a();
        }
        ((ComposerIntentLauncher) this.f12419a.get()).a(((ProfileServicesIntentBuilder) this.f12422d.get()).a(this.f12423e), 1760, this.f12423e);
    }

    private void m12464d(String str) {
        ((NavigationLogger) this.f12421c.get()).a(str);
        this.f12420b.a(null, ((ProfileServicesIntentBuilder) this.f12422d.get()).a(String.valueOf(this.f12425g.b), this.f12426h.N(), this.f12426h.L(), this.f12426h.U()).a(), 1756, this.f12423e);
    }

    private Intent m12463a() {
        return ((ProfileServicesIntentBuilder) this.f12422d.get()).a(this.f12423e, String.valueOf(this.f12425g.b), this.f12426h.N(), this.f12426h.L(), this.f12426h.U());
    }
}
