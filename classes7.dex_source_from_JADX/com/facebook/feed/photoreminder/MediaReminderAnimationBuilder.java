package com.facebook.feed.photoreminder;

import android.animation.Animator;
import android.view.View;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPhotoTray;
import com.facebook.feed.photoreminder.common.PromptHScrollView;
import com.facebook.feed.photoreminder.common.ScrollingImagePromptViewAnimationBuilder;
import com.facebook.feed.photoreminder.common.ScrollingImagePromptViewAnimationBuilder.BaseTrayAnimatorListener;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import javax.inject.Inject;

/* compiled from: admin_tapped_edit_page */
public class MediaReminderAnimationBuilder<V extends View & HasPhotoTray> extends ScrollingImagePromptViewAnimationBuilder<TrayAnimatorListener, V> {
    public final PhotoReminderLogger f19686a;
    public final MediaReminderUtil f19687b;

    /* compiled from: admin_tapped_edit_page */
    public class TrayAnimatorListener extends BaseTrayAnimatorListener {
        final PromptHScrollView f19679d;
        final PhotoReminderFrameView f19680e;
        final boolean f19681f;
        final /* synthetic */ MediaReminderAnimationBuilder f19682g;

        public TrayAnimatorListener(MediaReminderAnimationBuilder mediaReminderAnimationBuilder, PhotoReminderFrameView photoReminderFrameView, PromptHScrollView promptHScrollView, boolean z) {
            this.f19682g = mediaReminderAnimationBuilder;
            super(mediaReminderAnimationBuilder, promptHScrollView, z);
            this.f19679d = promptHScrollView;
            this.f19680e = photoReminderFrameView;
            this.f19681f = z;
        }

        public void onAnimationStart(Animator animator) {
            if (this.f19681f) {
                String uuid = SafeUUIDGenerator.a().toString();
                this.f19682g.f19686a.a(uuid, this.f19680e.f19740g.c());
                this.f19682g.f19687b.c();
                this.f19680e.setSessionID(uuid);
                this.f19680e.setVisibility(0);
            }
            super.onAnimationStart(animator);
        }
    }

    public static MediaReminderAnimationBuilder m22954b(InjectorLike injectorLike) {
        return new MediaReminderAnimationBuilder(ScreenUtil.a(injectorLike), DefaultAnimationPartFactory.a(injectorLike), PhotoReminderLogger.a(injectorLike), MediaReminderUtil.a(injectorLike));
    }

    @Inject
    public MediaReminderAnimationBuilder(ScreenUtil screenUtil, DefaultAnimationPartFactory defaultAnimationPartFactory, PhotoReminderLogger photoReminderLogger, MediaReminderUtil mediaReminderUtil) {
        super(screenUtil, defaultAnimationPartFactory, mediaReminderUtil.f());
        this.f19686a = photoReminderLogger;
        this.f19687b = mediaReminderUtil;
    }

    public final BaseTrayAnimatorListener mo1465a(View view, PromptHScrollView promptHScrollView, boolean z) {
        return new TrayAnimatorListener(this, (PhotoReminderFrameView) view.findViewById(2131565918), promptHScrollView, z);
    }
}
