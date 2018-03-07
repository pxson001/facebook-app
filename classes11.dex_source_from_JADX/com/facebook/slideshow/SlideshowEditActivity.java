package com.facebook.slideshow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSlideshowData;
import com.facebook.ipc.slideshow.SlideshowEditConfiguration;
import com.facebook.ipc.slideshow.SlideshowEditConfigurationSpec.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.slideshow.analytics.SlideshowLogger;
import com.facebook.slideshow.ui.DragSortThumbnailListViewControllerProvider;
import com.facebook.slideshow.ui.PlayableSlideshowViewControllerProvider;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: PLAY_REQUESTED */
public class SlideshowEditActivity extends FbFragmentActivity {
    public SlideshowEditController f12551p;
    public SlideshowEditConfiguration f12552q;
    @Inject
    private SlideshowEditControllerProvider f12553r;
    @Inject
    public SlideshowLogger f12554s;
    @Inject
    public ComposerLauncher f12555t;
    private Fb4aTitleBar f12556u;

    /* compiled from: PLAY_REQUESTED */
    class C14811 implements OnClickListener {
        final /* synthetic */ SlideshowEditActivity f12547a;

        C14811(SlideshowEditActivity slideshowEditActivity) {
            this.f12547a = slideshowEditActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1945946590);
            this.f12547a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -1785752297, a);
        }
    }

    /* compiled from: PLAY_REQUESTED */
    class C14822 extends OnToolbarButtonListener {
        final /* synthetic */ SlideshowEditActivity f12548a;

        C14822(SlideshowEditActivity slideshowEditActivity) {
            this.f12548a = slideshowEditActivity;
        }

        public final void m12949a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f12548a.f12554s.a(this.f12548a.f12551p.m12962a().size());
            Builder a = ComposerConfiguration.a(this.f12548a.f12552q.getComposerConfiguration());
            a.setInitialAttachments(ComposerAttachment.a(this.f12548a.f12551p.m12962a())).setInitialSlideshowData(ComposerSlideshowData.newBuilder().a());
            this.f12548a.f12555t.a(this.f12548a.f12552q.getSessionId(), a.a(), 1000, this.f12548a);
        }
    }

    /* compiled from: PLAY_REQUESTED */
    class C14833 extends OnToolbarButtonListener {
        final /* synthetic */ SlideshowEditActivity f12549a;

        C14833(SlideshowEditActivity slideshowEditActivity) {
            this.f12549a = slideshowEditActivity;
        }

        public final void m12950a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("extra_media_items", new ArrayList(this.f12549a.f12551p.m12962a()));
            intent.putExtra("extra_slideshow_data", ComposerSlideshowData.newBuilder().a());
            this.f12549a.f12554s.a(this.f12549a.f12551p.m12962a().size());
            this.f12549a.setResult(-1, intent);
            this.f12549a.finish();
        }
    }

    /* compiled from: PLAY_REQUESTED */
    /* synthetic */ class C14844 {
        static final /* synthetic */ int[] f12550a = new int[Action.values().length];

        static {
            try {
                f12550a[Action.LAUNCH_COMPOSER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12550a[Action.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static <T extends Context> void m12953a(Class<T> cls, T t) {
        m12954a((Object) t, (Context) t);
    }

    public static void m12954a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SlideshowEditActivity) obj).m12952a((SlideshowEditControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SlideshowEditControllerProvider.class), SlideshowLogger.b(fbInjector), (ComposerLauncher) ComposerLauncherImpl.a(fbInjector));
    }

    private void m12952a(SlideshowEditControllerProvider slideshowEditControllerProvider, SlideshowLogger slideshowLogger, ComposerLauncher composerLauncher) {
        this.f12553r = slideshowEditControllerProvider;
        this.f12554s = slideshowLogger;
        this.f12555t = composerLauncher;
    }

    public final void m12961b(Bundle bundle) {
        super.b(bundle);
        Class cls = SlideshowEditActivity.class;
        m12954a((Object) this, (Context) this);
        setContentView(2130907127);
        this.f12552q = (SlideshowEditConfiguration) getIntent().getParcelableExtra("extra_slideshow_configuration");
        this.f12556u = (Fb4aTitleBar) a(2131558563);
        m12958i();
        SlideshowEditControllerProvider slideshowEditControllerProvider = this.f12553r;
        SlideshowEditFragment slideshowEditFragment = (SlideshowEditFragment) kO_().a(2131567484);
        ImmutableList mediaItems = this.f12552q.getMediaItems();
        this.f12551p = new SlideshowEditController(slideshowEditFragment, mediaItems, this.f12552q.getSessionId(), (PlayableSlideshowViewControllerProvider) slideshowEditControllerProvider.getOnDemandAssistedProviderForStaticDi(PlayableSlideshowViewControllerProvider.class), (DragSortThumbnailListViewControllerProvider) slideshowEditControllerProvider.getOnDemandAssistedProviderForStaticDi(DragSortThumbnailListViewControllerProvider.class));
        this.f12554s.b = this.f12552q.getSessionId();
        this.f12554s.b(this.f12552q.getSource().toString());
    }

    private void m12958i() {
        this.f12556u.setTitle(2131242553);
        this.f12556u.a(new C14811(this));
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.g = getString(2131242554);
        a = a;
        a.q = true;
        this.f12556u.setButtonSpecs(ImmutableList.of(a.a()));
        switch (C14844.f12550a[this.f12552q.getActionWhenDone().ordinal()]) {
            case 1:
                Preconditions.checkNotNull(this.f12552q.getComposerConfiguration());
                this.f12556u.setOnToolbarButtonListener(m12959j());
                return;
            default:
                this.f12556u.setOnToolbarButtonListener(m12960k());
                return;
        }
    }

    private OnToolbarButtonListener m12959j() {
        return new C14822(this);
    }

    private OnToolbarButtonListener m12960k() {
        return new C14833(this);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1000) {
            setResult(i2, intent);
            finish();
        } else if (i2 != 0) {
            this.f12551p.m12963a(ImmutableList.copyOf(intent.getParcelableArrayListExtra("extra_media_items")));
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("extra_media_items", new ArrayList(this.f12552q.getMediaItems()));
        setResult(0, intent);
        finish();
    }
}
