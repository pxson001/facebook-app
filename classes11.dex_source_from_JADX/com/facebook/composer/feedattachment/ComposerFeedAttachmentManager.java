package com.facebook.composer.feedattachment;

import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.inject.Assisted;
import com.facebook.widget.LazyView;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group_edit_favorites */
public class ComposerFeedAttachmentManager implements ComposerEventHandler {
    public final ImmutableSet<ComposerFeedAttachment> f6436a;
    private final LazyView<ViewGroup> f6437b;
    @Nullable
    private ComposerFeedAttachment f6438c;

    /* compiled from: group_edit_favorites */
    /* synthetic */ class C08121 {
        static final /* synthetic */ int[] f6435a = new int[ComposerEvent.values().length];

        static {
            try {
                f6435a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6435a[ComposerEvent.ON_LAUNCH_FACECAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6435a[ComposerEvent.ON_DESTROY_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public ComposerFeedAttachmentManager(@Assisted ImmutableSet<ComposerFeedAttachment> immutableSet, @Assisted ViewStub viewStub) {
        this.f6436a = immutableSet;
        this.f6437b = new LazyView(viewStub);
        m7862b();
    }

    public final void m7864a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        ComposerFeedAttachment composerFeedAttachment = this.f6438c;
        switch (C08121.f6435a[composerEvent.ordinal()]) {
            case 1:
                m7862b();
                break;
            case 2:
                m7863c();
                break;
            case 3:
                m7863c();
                break;
        }
        if (this.f6438c == composerFeedAttachment && this.f6438c != null) {
            this.f6438c.a(composerEvent, composerEventOriginator);
        }
    }

    private void m7862b() {
        ComposerFeedAttachment composerFeedAttachment;
        Iterator it = this.f6436a.iterator();
        while (it.hasNext()) {
            composerFeedAttachment = (ComposerFeedAttachment) it.next();
            if (composerFeedAttachment.mo189a()) {
                break;
            }
        }
        composerFeedAttachment = null;
        ComposerFeedAttachment composerFeedAttachment2 = composerFeedAttachment;
        if (this.f6438c != composerFeedAttachment2) {
            m7863c();
            this.f6438c = composerFeedAttachment2;
            if (this.f6438c != null) {
                this.f6438c.mo188a((ViewGroup) this.f6437b.a());
            }
        }
    }

    private void m7863c() {
        if (this.f6438c != null) {
            this.f6438c.mo190b();
            this.f6438c = null;
            ((ViewGroup) this.f6437b.a()).removeAllViews();
        }
    }
}
