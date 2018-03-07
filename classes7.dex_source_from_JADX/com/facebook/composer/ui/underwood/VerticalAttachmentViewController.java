package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.facebook.common.internal.Preconditions;
import com.facebook.composer.activity.ComposerFragment.62;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.ui.underwood.TaggingController.TagsChangedListener;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsComposerDrawn;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLogger.EventListener;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ultralight.Inject;
import com.facebook.widget.ScrollingAwareScrollView;
import javax.annotation.Nullable;

/* compiled from: comment_story */
public class VerticalAttachmentViewController<DataProvider extends ProvidesAttachments & ProvidesIsComposerDrawn & ProvidesTargetData> implements UnderwoodAttachmentViewController {
    private final DataProvider f17323a;
    private final boolean f17324b;
    private final 62 f17325c;
    private final boolean f17326d;
    private final ScrollingAwareScrollView f17327e;
    private final VerticalAttachmentView f17328f;
    @Nullable
    private ComposerAttachment f17329g;

    /* compiled from: comment_story */
    /* synthetic */ class C14191 {
        static final /* synthetic */ int[] f17322a = new int[ComposerEvent.values().length];

        static {
            try {
                f17322a[ComposerEvent.ON_FIRST_DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17322a[ComposerEvent.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17322a[ComposerEvent.ON_NEW_MEDIA_ATTACHED_FROM_QUICK_CAM_AFTER_RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17322a[ComposerEvent.ON_FACE_DETECTION_COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f17322a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f17322a[ComposerEvent.ON_USER_POST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Inject
    public VerticalAttachmentViewController(@Assisted FragmentManager fragmentManager, @Assisted Integer num, @Assisted Integer num2, @Assisted String str, @Assisted boolean z, @Assisted boolean z2, @Assisted AttachmentsEventListener attachmentsEventListener, @Assisted EventListener eventListener, @Nullable @Assisted DataProvider dataProvider, @Nullable @Assisted TagsChangedListener tagsChangedListener, @Assisted boolean z3, @Assisted boolean z4, @Assisted ScrollingAwareScrollView scrollingAwareScrollView, Context context, ComposerAttachmentViewUtility composerAttachmentViewUtility, TasksManager tasksManager) {
        this.f17323a = dataProvider;
        this.f17325c = tagsChangedListener;
        this.f17324b = z3;
        this.f17326d = z4;
        this.f17327e = scrollingAwareScrollView;
        this.f17328f = new VerticalAttachmentView(context, fragmentManager, attachmentsEventListener, eventListener, composerAttachmentViewUtility, tasksManager, num.intValue(), num2.intValue(), str, z, z2);
    }

    public final void mo1339a() {
        this.f17328f.m21213j();
    }

    public final void mo1343b() {
        this.f17328f.m21212f();
    }

    public final float mo1345c() {
        return this.f17328f.at;
    }

    public final void mo1347d() {
        this.f17328f.f17295W.setVisibility(0);
    }

    public final void mo1348e() {
        VerticalAttachmentView verticalAttachmentView = this.f17328f;
        if (!verticalAttachmentView.f17295W.getText().toString().isEmpty()) {
            verticalAttachmentView.f17295W.setText("");
        }
        verticalAttachmentView.f17295W.setVisibility(8);
    }

    public final void mo1349f() {
        VerticalAttachmentView verticalAttachmentView = this.f17328f;
        if (verticalAttachmentView.f17295W.getText().toString().isEmpty()) {
            verticalAttachmentView.f17295W.setVisibility(8);
        }
    }

    public final void mo1341a(boolean z) {
        this.f17328f.setFaceBoxesAndTags(z);
    }

    public final void mo1340a(float f) {
        this.f17328f.setScale(f);
    }

    public final float mo1350g() {
        return this.f17328f.au;
    }

    public final boolean mo1342a(ComposerAttachment composerAttachment) {
        return true;
    }

    public final View mo1351h() {
        return this.f17328f;
    }

    @Nullable
    public final ComposerAttachment mo1352i() {
        return this.f17329g;
    }

    public final void mo1344b(ComposerAttachment composerAttachment) {
        VerticalAttachmentView verticalAttachmentView = this.f17328f;
        verticalAttachmentView.as = composerAttachment;
        if ((verticalAttachmentView.as.b() instanceof PhotoItem) && verticalAttachmentView.ar.isPresent()) {
            ((TaggingController) verticalAttachmentView.ar.get()).m21128a((PhotoItem) verticalAttachmentView.as.b());
        }
    }

    public final void mo1346c(@Nullable ComposerAttachment composerAttachment) {
        this.f17329g = (ComposerAttachment) Preconditions.a(composerAttachment);
        this.f17328f.m21209a(this.f17329g, this.f17325c, this.f17323a, this.f17324b, this.f17326d, this.f17327e);
    }

    public final void mo1353j() {
        this.f17328f.m21209a(null, null, null, false, false, null);
    }

    public final void m21217a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C14191.f17322a[composerEvent.ordinal()]) {
            case 1:
                this.f17328f.m21208a();
                return;
            case 2:
                this.f17328f.f17283H = true;
                this.f17328f.m21208a();
                return;
            case 3:
                this.f17328f.f17283H = true;
                return;
            case 4:
                this.f17328f.m21211e();
                return;
            case 5:
                Object obj;
                VerticalAttachmentView verticalAttachmentView = this.f17328f;
                if (verticalAttachmentView.aH == null || ((ProvidesTargetData) verticalAttachmentView.aH).s() == null) {
                    int i = 1;
                } else {
                    obj = (verticalAttachmentView.aJ == null || verticalAttachmentView.aJ != ((ProvidesTargetData) verticalAttachmentView.aH).s().targetType) ? null : 1;
                }
                if (obj == null) {
                    this.f17328f.m21214l();
                    return;
                }
                return;
            case 6:
                this.f17328f.m21210b();
                return;
            default:
                return;
        }
    }
}
