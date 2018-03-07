package com.facebook.feed.photoreminder;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewStub;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPhotoTray;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.feed.photoreminder.model.MediaReminderModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.widget.LazyView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: admin_panel_upsell_messages_row */
public class PhotoReminderV2View extends SegmentedLinearLayout implements HasPhotoTray, V2Attachment {
    @Inject
    PhotoReminderViewController f19746a;
    @Inject
    MediaReminderUtil f19747b;
    @Inject
    Provider<PromptsExperimentHelper> f19748c;
    private MediaReminderModel f19749d;
    private LazyView<PhotoReminderFrameView> f19750e;

    private static <T extends View> void m23008a(Class<T> cls, T t) {
        m23009a((Object) t, t.getContext());
    }

    private static void m23009a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PhotoReminderV2View) obj).m23007a(new PhotoReminderViewController(), MediaReminderUtil.a(fbInjector), IdBasedProvider.a(fbInjector, 3128));
    }

    public PhotoReminderV2View(Context context) {
        this(context, null);
    }

    public PhotoReminderV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m23008a(PhotoReminderV2View.class, (View) this);
        setContentView(2130906206);
        this.f19750e = new LazyView((ViewStub) a(2131561931));
        this.f19746a.f19751a = this.f19750e;
    }

    public final void m23013a(MediaReminderModel mediaReminderModel) {
        Preconditions.checkNotNull(mediaReminderModel);
        this.f19749d = mediaReminderModel;
        this.f19746a.f19752b = this.f19749d;
        m23010b(this.f19749d);
    }

    private void m23010b(MediaReminderModel mediaReminderModel) {
        if (((PromptsExperimentHelper) this.f19748c.get()).d() || ((PromptsExperimentHelper) this.f19748c.get()).c()) {
            ((PhotoReminderFrameView) this.f19750e.a()).m22997a(mediaReminderModel);
        } else {
            m23011c(mediaReminderModel);
        }
    }

    private void m23011c(MediaReminderModel mediaReminderModel) {
        setupViewForPhotoReminder(mediaReminderModel);
        if (!mediaReminderModel.k) {
            this.f19746a.f19752b = mediaReminderModel;
            if (!this.f19746a.m23015b() && !mediaReminderModel.j) {
                if (mediaReminderModel.d()) {
                    ((PhotoReminderFrameView) this.f19750e.a()).m22997a(mediaReminderModel);
                } else {
                    this.f19746a.m23014a();
                }
            }
        }
    }

    private void setupViewForPhotoReminder(final MediaReminderModel mediaReminderModel) {
        ((PhotoReminderFrameView) this.f19746a.f19751a.a()).f19741h = new Object(this) {
            final /* synthetic */ PhotoReminderV2View f19745b;

            public final void m23005a() {
                mediaReminderModel.j = false;
            }

            public final void m23006b() {
                mediaReminderModel.j = true;
            }
        };
        ((PhotoReminderFrameView) this.f19750e.a()).f19740g = mediaReminderModel;
    }

    public void setPromptSession(InlineComposerPromptSession inlineComposerPromptSession) {
        ((PhotoReminderFrameView) this.f19750e.a()).setPromptSession(inlineComposerPromptSession);
    }

    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        super.onMeasure(i, i2);
        setMeasuredDimension(size, ((PhotoReminderFrameView) this.f19750e.a()).getMinimumHeight());
    }

    public View getPhotoTray() {
        return findViewById(2131561947);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1379406411);
        super.onDetachedFromWindow();
        setupViewForPhotoReminder(this.f19749d);
        this.f19746a.f19752b = this.f19749d;
        if (!this.f19746a.m23015b()) {
            this.f19749d.k = false;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1014510013, a);
    }

    public final View mo1476a() {
        ((PhotoReminderFrameView) this.f19750e.a()).setVisibility(0);
        setVisibility(0);
        return this;
    }

    public Animator getExpandAnimator() {
        return ((PromptsExperimentHelper) this.f19748c.get()).d() ? null : ((PhotoReminderFrameView) this.f19750e.a()).f19729d;
    }

    public Animator getCollapseAnimator() {
        return ((PromptsExperimentHelper) this.f19748c.get()).d() ? null : ((PhotoReminderFrameView) this.f19750e.a()).f19730e;
    }

    private void m23007a(PhotoReminderViewController photoReminderViewController, MediaReminderUtil mediaReminderUtil, Provider<PromptsExperimentHelper> provider) {
        this.f19746a = photoReminderViewController;
        this.f19747b = mediaReminderUtil;
        this.f19748c = provider;
    }
}
