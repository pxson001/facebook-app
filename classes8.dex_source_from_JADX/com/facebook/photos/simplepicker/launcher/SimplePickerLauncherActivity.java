package com.facebook.photos.simplepicker.launcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.photos.simplepicker.SimplePickerFlowLogger;
import com.facebook.photos.simplepicker.SimplePickerFragment;
import com.facebook.photos.simplepicker.logging.SimplePickerSequences;
import com.facebook.photos.simplepicker.logging.SimplePickerSequences.LaunchSequence;
import com.facebook.photos.simplepicker.module.SimplePickerFragmentFactoryMethodAutoProvider;
import com.facebook.photos.simplepicker.module.SimplePickerModule.C04091;
import com.facebook.photos.taggablegallery.TaggablePhotoGalleryFragment;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.base.Preconditions;

/* compiled from: shadowColor */
public class SimplePickerLauncherActivity extends FbFragmentActivity implements AnalyticsActivity, IAuthNotRequired {
    private static final Class<?> f3166p = SimplePickerLauncherActivity.class;
    private SimplePickerFragment f3167q;
    private SimplePickerLauncherConfiguration f3168r;
    public SimplePickerFlowLogger f3169s;
    private String f3170t;
    public SequenceLogger f3171u;
    public InteractionTTILogger f3172v;
    private Sequence<LaunchSequence> f3173w;
    public C04091 f3174x;

    private static <T extends Context> void m3158a(Class<T> cls, T t) {
        m3159a((Object) t, (Context) t);
    }

    public static void m3159a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        SimplePickerLauncherActivity simplePickerLauncherActivity = (SimplePickerLauncherActivity) obj;
        SimplePickerFlowLogger b = SimplePickerFlowLogger.m2934b(injectorLike);
        SequenceLogger sequenceLogger = (SequenceLogger) SequenceLoggerImpl.a(injectorLike);
        InteractionTTILogger a = InteractionTTILogger.a(injectorLike);
        C04091 a2 = SimplePickerFragmentFactoryMethodAutoProvider.m3168a(injectorLike);
        simplePickerLauncherActivity.f3169s = b;
        simplePickerLauncherActivity.f3171u = sequenceLogger;
        simplePickerLauncherActivity.f3172v = a;
        simplePickerLauncherActivity.f3174x = a2;
    }

    public final void m3161b(Bundle bundle) {
        String string;
        SimplePickerLauncherActivity simplePickerLauncherActivity;
        long j;
        long uptimeMillis = SystemClock.uptimeMillis();
        super.b(bundle);
        Class cls = SimplePickerLauncherActivity.class;
        m3159a((Object) this, (Context) this);
        this.f3173w = this.f3171u.a(SimplePickerSequences.f3186a);
        setContentView(2130907114);
        Intent intent = getIntent();
        this.f3168r = (SimplePickerLauncherConfiguration) intent.getParcelableExtra("extra_simple_picker_launcher_settings");
        Preconditions.checkNotNull(this.f3168r);
        if (bundle != null) {
            string = bundle.getString("extra_simple_picker_launcher_waterfall_id");
            simplePickerLauncherActivity = this;
        } else if (intent.hasExtra("extra_simple_picker_launcher_waterfall_id")) {
            string = intent.getStringExtra("extra_simple_picker_launcher_waterfall_id");
            simplePickerLauncherActivity = this;
        } else {
            string = SafeUUIDGenerator.a().toString();
            simplePickerLauncherActivity = this;
        }
        simplePickerLauncherActivity.f3170t = string;
        this.f3169s.f2880a = this.f3170t;
        if (this.f3168r.a != null) {
            j = this.f3168r.a.getInitialTargetData().targetId;
        } else {
            j = -1;
        }
        this.f3169s.m2937a(this.f3168r.d.e, j);
        this.f3167q = m3160i();
        this.f3172v.a(f3166p.getSimpleName(), uptimeMillis);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -208755488);
        this.f3172v.e(f3166p.getSimpleName());
        super.onResume();
        this.f3172v.f(f3166p.getSimpleName());
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1644033225, a);
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -116690142);
        this.f3172v.c(f3166p.getSimpleName());
        super.onStart();
        this.f3172v.d(f3166p.getSimpleName());
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -289316050, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 2033263977);
        super.onPause();
        this.f3171u.d(SimplePickerSequences.f3186a);
        this.f3172v.a();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1079130567, a);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.f3172v.a(this);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("extra_simple_picker_launcher_waterfall_id", this.f3170t);
    }

    public void onBackPressed() {
        boolean z;
        SimplePickerFragment simplePickerFragment = this.f3167q;
        simplePickerFragment.at = false;
        Fragment a = simplePickerFragment.s().a("GALLERY_FRAGMENT");
        if (a == null) {
            z = false;
        } else {
            z = ((TaggablePhotoGalleryFragment) a).m3425b();
        }
        if (!z) {
            if (this.f3168r.e) {
                this.f3167q.as();
                return;
            }
            super.onBackPressed();
            this.f3169s.m2935a();
        }
    }

    public final String am_() {
        return "simple_picker";
    }

    private SimplePickerFragment m3160i() {
        SequenceLoggerDetour.a(this.f3173w, "LaunchFragmentAndDi", 1912061636);
        SimplePickerFragment simplePickerFragment = (SimplePickerFragment) kO_().a(2131558429);
        if (simplePickerFragment != null) {
            return simplePickerFragment;
        }
        simplePickerFragment = this.f3174x.m3170a(null, this.f3168r, this.f3170t);
        kO_().a().a(2131558429, simplePickerFragment).b();
        kO_().b();
        return simplePickerFragment;
    }
}
