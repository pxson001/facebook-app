package com.facebook.timeline.coverphoto.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.fragmentfactory.FragmentFactoryMap;
import com.facebook.common.fragmentfactory.FragmentFactoryMapImpl;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.friendsharing.suggestedcoverphotos.abtest.ExperimentsForSuggestedCoverPhotosAbtestModule;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger.Action;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.model.CreativeEditingData.Builder;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.event.CoverPhotoEditEventBus;
import com.facebook.timeline.event.CoverPhotoEditEvents.EditCoverPhotoLoadedEvent;
import com.facebook.timeline.event.CoverPhotoEditEvents.EditCoverPhotoLoadedEventSubscriber;
import com.facebook.timeline.profilepiccoverphotoupload.SetCoverPhotoHandler;
import com.facebook.timeline.profilepiccoverphotoupload.SetCoverPhotoHandler.C09561;
import com.facebook.timeline.profilepiccoverphotoupload.SetCoverPhotoParams;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpecCache;
import com.facebook.widget.titlebar.TitleBarButtonSpecCacheProvider;
import java.io.File;
import javax.inject.Inject;

/* compiled from: maxElements */
public class CoverPhotoRepositionActivity extends FbFragmentActivity implements AnalyticsActivity {
    public SuggestedCoverPhotosLogger f9124A;
    public QeAccessor f9125B;
    private Lazy<SetCoverPhotoHandler> f9126p;
    private TitleBarButtonSpecCache f9127q;
    private CoverPhotoEditEventBus f9128r;
    private FbEventSubscriberListManager f9129s;
    private Fragment f9130t;
    private ViewerContext f9131u;
    public FbTitleBar f9132v;
    private FragmentFactoryMap f9133w;
    @Nullable
    public String f9134x;
    @Nullable
    public PromptAnalytics f9135y;
    @Nullable
    private String f9136z;

    /* compiled from: maxElements */
    class C09481 implements OnClickListener {
        final /* synthetic */ CoverPhotoRepositionActivity f9121a;

        C09481(CoverPhotoRepositionActivity coverPhotoRepositionActivity) {
            this.f9121a = coverPhotoRepositionActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -750485594);
            if (this.f9121a.f9134x != null) {
                this.f9121a.f9124A.g(this.f9121a.f9134x);
            }
            this.f9121a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, -1511040183, a);
        }
    }

    /* compiled from: maxElements */
    class C09492 extends OnToolbarButtonListener {
        final /* synthetic */ CoverPhotoRepositionActivity f9122a;

        C09492(CoverPhotoRepositionActivity coverPhotoRepositionActivity) {
            this.f9122a = coverPhotoRepositionActivity;
        }

        public final void m10900a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            view.setEnabled(false);
            CoverPhotoRepositionActivity.m10912i(this.f9122a);
            if (this.f9122a.f9134x != null) {
                this.f9122a.f9124A.a.a(SuggestedCoverPhotosLogger.a(this.f9122a.f9134x, Action.CONFIRM_UPLOAD.name()));
            }
        }
    }

    /* compiled from: maxElements */
    class C09503 extends EditCoverPhotoLoadedEventSubscriber {
        final /* synthetic */ CoverPhotoRepositionActivity f9123a;

        C09503(CoverPhotoRepositionActivity coverPhotoRepositionActivity) {
            this.f9123a = coverPhotoRepositionActivity;
        }

        public final void m10902b(FbEvent fbEvent) {
            EditCoverPhotoLoadedEvent editCoverPhotoLoadedEvent = (EditCoverPhotoLoadedEvent) fbEvent;
            if (this.f9123a.f9132v != null) {
                if (this.f9123a.f9135y == null || !this.f9123a.f9125B.a(ExperimentsForSuggestedCoverPhotosAbtestModule.d, false)) {
                    if (editCoverPhotoLoadedEvent.f9140a) {
                        this.f9123a.f9132v.setTitle(2131234969);
                    } else {
                        this.f9123a.f9132v.setTitle(2131234970);
                    }
                } else if (editCoverPhotoLoadedEvent.f9140a) {
                    this.f9123a.f9132v.setTitle(this.f9123a.f9125B.a(ExperimentsForSuggestedCoverPhotosAbtestModule.b, this.f9123a.getResources().getString(2131234969)));
                } else {
                    this.f9123a.f9132v.setTitle(this.f9123a.f9125B.a(ExperimentsForSuggestedCoverPhotosAbtestModule.c, this.f9123a.getResources().getString(2131234970)));
                }
            }
        }
    }

    private static <T extends Context> void m10905a(Class<T> cls, T t) {
        m10906a((Object) t, (Context) t);
    }

    public static void m10906a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CoverPhotoRepositionActivity) obj).m10904a(CoverPhotoEditEventBus.m10919a(fbInjector), IdBasedLazy.a(fbInjector, 11306), ViewerContextMethodAutoProvider.b(fbInjector), (FragmentFactoryMap) FragmentFactoryMapImpl.a(fbInjector), (TitleBarButtonSpecCacheProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TitleBarButtonSpecCacheProvider.class), SuggestedCoverPhotosLogger.b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    protected final void m10913b(Bundle bundle) {
        super.b(bundle);
        Class cls = CoverPhotoRepositionActivity.class;
        m10906a((Object) this, (Context) this);
        setContentView(2130907450);
        Intent intent = getIntent();
        this.f9134x = intent.getStringExtra("session_id");
        this.f9135y = (PromptAnalytics) intent.getParcelableExtra("prompt_entry_point_analytics_extra");
        this.f9136z = intent.getStringExtra("prompt_object_class_name_extra");
        this.f9130t = this.f9133w.a(intent.getIntExtra("target_fragment", -1)).a(intent);
        kO_().a().b(2131558429, this.f9130t).b();
        if (FbTitleBarUtil.b(this)) {
            this.f9132v = (FbTitleBar) findViewById(2131558563);
            this.f9132v.setShowDividers(true);
            this.f9132v.setHasBackButton(false);
            this.f9132v.a(new C09481(this));
            this.f9132v.setButtonSpecs(this.f9127q.a());
            this.f9132v.setOnToolbarButtonListener(new C09492(this));
        }
        this.f9129s = new FbEventSubscriberListManager();
        this.f9129s.a(new C09503(this));
        this.f9129s.a(this.f9128r);
    }

    @Inject
    private void m10904a(CoverPhotoEditEventBus coverPhotoEditEventBus, Lazy<SetCoverPhotoHandler> lazy, ViewerContext viewerContext, FragmentFactoryMap fragmentFactoryMap, TitleBarButtonSpecCacheProvider titleBarButtonSpecCacheProvider, SuggestedCoverPhotosLogger suggestedCoverPhotosLogger, QeAccessor qeAccessor) {
        this.f9128r = coverPhotoEditEventBus;
        this.f9126p = lazy;
        this.f9131u = viewerContext;
        this.f9133w = fragmentFactoryMap;
        this.f9127q = titleBarButtonSpecCacheProvider.a(2131234971);
        this.f9124A = suggestedCoverPhotosLogger;
        this.f9125B = qeAccessor;
    }

    public static void m10912i(CoverPhotoRepositionActivity coverPhotoRepositionActivity) {
        SetCoverPhotoParams a = ((CoverPhotoFragment) coverPhotoRepositionActivity.f9130t).m10899a();
        SetCoverPhotoHandler setCoverPhotoHandler = (SetCoverPhotoHandler) coverPhotoRepositionActivity.f9126p.get();
        ViewerContext viewerContext = coverPhotoRepositionActivity.f9131u;
        String uuid = SafeUUIDGenerator.a().toString();
        setCoverPhotoHandler.f9239j.a(uuid).a(new Builder().a(), Uri.fromFile(new File(a.f9248d)), a.f9247c, a.f9246b, new C09561(setCoverPhotoHandler, a, uuid, viewerContext));
        Intent intent = new Intent();
        if (coverPhotoRepositionActivity.f9135y != null) {
            intent.putExtra("prompt_entry_point_analytics_extra", coverPhotoRepositionActivity.f9135y);
            intent.putExtra("did_use_prompt_extra", true);
        }
        if (coverPhotoRepositionActivity.f9136z != null) {
            intent.putExtra("prompt_object_class_name_extra", coverPhotoRepositionActivity.f9136z);
        }
        coverPhotoRepositionActivity.setResult(-1, intent);
        coverPhotoRepositionActivity.finish();
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1620631587);
        super.onDestroy();
        if (this.f9129s != null) {
            this.f9129s.b(this.f9128r);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 2130950124, a);
    }

    public final String am_() {
        return "set_cover_photo";
    }

    public void onBackPressed() {
        if (this.f9134x != null) {
            this.f9124A.g(this.f9134x);
        }
        super.onBackPressed();
    }
}
