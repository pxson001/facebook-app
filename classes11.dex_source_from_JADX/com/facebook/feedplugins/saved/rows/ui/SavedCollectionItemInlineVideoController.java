package com.facebook.feedplugins.saved.rows.ui;

import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import java.util.HashSet;
import java.util.Set;

/* compiled from: bundle_collection_self */
public class SavedCollectionItemInlineVideoController extends VideoViewController<SavedCollectionItemView> {
    public final InlineVideoPersistentState f9348a;
    private boolean f9349b = false;
    private final Set<AutoPlayFailureReason> f9350c;

    public final void m9956a(Object obj) {
        SavedCollectionItemView savedCollectionItemView = (SavedCollectionItemView) obj;
        if (this.f9349b) {
            int i;
            this.f9349b = false;
            if (savedCollectionItemView.f == null) {
                i = 0;
            } else {
                i = savedCollectionItemView.f.getCurrentPositionMs();
            }
            int i2 = i;
            EventTriggerType c = this.f9348a.c();
            if (savedCollectionItemView.f != null) {
                savedCollectionItemView.f.b(c);
            }
            this.f9348a.a(i2);
        }
    }

    public final void m9957b(Object obj) {
        SavedCollectionItemView savedCollectionItemView = (SavedCollectionItemView) obj;
        if (!this.f9349b) {
            this.f9349b = true;
            if (this.f9348a.b().a(this.f9350c)) {
                savedCollectionItemView.a(this.f9348a.c(), this.f9348a.a());
            }
        }
    }

    public SavedCollectionItemInlineVideoController(String str, InlineVideoPersistentState inlineVideoPersistentState) {
        super(str);
        this.f9348a = inlineVideoPersistentState;
        this.f9350c = new HashSet();
    }
}
