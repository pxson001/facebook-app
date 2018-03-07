package com.facebook.feed.photoreminder;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.photoreminder.PhotoReminderV2View.C17111;
import com.facebook.feed.photoreminder.common.ScrollingImagePromptView;
import com.facebook.feed.photoreminder.model.MediaReminderModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import javax.inject.Inject;

/* compiled from: admin_panel_view_posts_by_others */
public class PhotoReminderFrameView extends ScrollingImagePromptView {
    @Inject
    FbSharedPreferences f19735b;
    @Inject
    MediaReminderUtil f19736c;
    @Inject
    PhotoReminderLogger f19737d;
    @Inject
    PhotoGalleryScrollAdapter f19738e;
    public String f19739f;
    public MediaReminderModel f19740g;
    public C17111 f19741h;
    public String f19742i;
    private InlineComposerPromptSession f19743j;

    /* compiled from: admin_panel_view_posts_by_others */
    class C17081 implements AnimatorListener {
        final /* synthetic */ PhotoReminderFrameView f19723a;

        C17081(PhotoReminderFrameView photoReminderFrameView) {
            this.f19723a = photoReminderFrameView;
        }

        public void onAnimationStart(Animator animator) {
            this.f19723a.f19741h.m23006b();
            this.f19723a.f19737d.a(this.f19723a.f19739f, this.f19723a.f19740g.c());
            this.f19723a.f19736c.c();
            if (this.f19723a.f19742i == null || !this.f19723a.f19742i.equals(this.f19723a.f19740g.b())) {
                this.f19723a.f19742i = this.f19723a.f19740g.b();
                this.f19723a.f19739f = SafeUUIDGenerator.a().toString();
                this.f19723a.setSessionID(this.f19723a.f19739f);
            }
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: admin_panel_view_posts_by_others */
    class C17092 implements AnimatorListener {
        final /* synthetic */ PhotoReminderFrameView f19724a;

        C17092(PhotoReminderFrameView photoReminderFrameView) {
            this.f19724a = photoReminderFrameView;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f19724a.f19741h.m23005a();
            View findViewById = this.f19724a.findViewById(2131561949);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: admin_panel_view_posts_by_others */
    class C17103 implements AnimatorListener {
        final /* synthetic */ PhotoReminderFrameView f19725a;

        C17103(PhotoReminderFrameView photoReminderFrameView) {
            this.f19725a = photoReminderFrameView;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    private static <T extends View> void m22991a(Class<T> cls, T t) {
        m22992a((Object) t, t.getContext());
    }

    private static void m22992a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PhotoReminderFrameView) obj).m22990a((FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), MediaReminderUtil.a(fbInjector), PhotoReminderLogger.a(fbInjector), new PhotoGalleryScrollAdapter(FbDraweeControllerBuilder.b(fbInjector), (Context) fbInjector.getInstance(Context.class), MediaReminderUtil.a(fbInjector), IdBasedProvider.a(fbInjector, 3134), PhotoReminderPromptActionHandler.b(fbInjector), PromptsExperimentHelper.b(fbInjector), PromptActionContextFactory.b(fbInjector)));
    }

    public PhotoReminderFrameView(Context context) {
        super(context);
    }

    public PhotoReminderFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PhotoReminderFrameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void mo1467b() {
        m22991a(PhotoReminderFrameView.class, (View) this);
        super.mo1467b();
    }

    public void setMediaReminderModel(MediaReminderModel mediaReminderModel) {
        this.f19740g = mediaReminderModel;
    }

    public MediaReminderModel getMediaReminderMode() {
        return this.f19740g;
    }

    public final void m22997a(MediaReminderModel mediaReminderModel) {
        this.f19740g = mediaReminderModel;
        this.f19727b.setAdapter(this.f19738e);
        this.f19738e.m22979a(mediaReminderModel.a());
    }

    public void setPromptSession(InlineComposerPromptSession inlineComposerPromptSession) {
        this.f19743j = inlineComposerPromptSession;
        this.f19738e.f19721r = inlineComposerPromptSession;
    }

    public void setSessionID(String str) {
        this.f19738e.f19716m = str;
    }

    public String getSessionId() {
        return this.f19739f;
    }

    public final void mo1466a(boolean z) {
        if (z) {
            PhotoReminderLogger photoReminderLogger = this.f19737d;
            String str = this.f19739f;
            String c = this.f19740g.c();
            AnalyticsLogger analyticsLogger = photoReminderLogger.a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("photo_reminder_ignored");
            honeyClientEvent.c = "photo_reminder";
            honeyClientEvent = honeyClientEvent.b("prompt_type", c);
            honeyClientEvent.f = str;
            analyticsLogger.a(honeyClientEvent);
        }
        super.mo1466a(z);
    }

    public final ValueAnimator mo1468e() {
        ValueAnimator e = super.mo1468e();
        e.addListener(new C17081(this));
        return e;
    }

    public final ValueAnimator mo1469f() {
        ValueAnimator f = super.mo1469f();
        f.addListener(new C17092(this));
        return f;
    }

    protected void setHasBeenShown(boolean z) {
        this.f19740g.h = z;
    }

    private void m22990a(FbSharedPreferences fbSharedPreferences, MediaReminderUtil mediaReminderUtil, PhotoReminderLogger photoReminderLogger, PhotoGalleryScrollAdapter photoGalleryScrollAdapter) {
        this.f19735b = fbSharedPreferences;
        this.f19736c = mediaReminderUtil;
        this.f19737d = photoReminderLogger;
        this.f19738e = photoGalleryScrollAdapter;
    }

    protected final boolean mo1470g() {
        return this.f19740g.h;
    }

    protected void setIsAnimationRunning(boolean z) {
        this.f19740g.k = z;
    }

    protected final boolean mo1472h() {
        return this.f19740g.k;
    }

    protected final ObjectAnimator mo1473i() {
        ObjectAnimator i = super.mo1473i();
        i.addListener(new C17103(this));
        return i;
    }

    protected int getImageTrayHeight() {
        return this.f19736c.f();
    }
}
