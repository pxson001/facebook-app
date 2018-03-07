package com.facebook.feedplugins.attachments.linkshare.offlinesave;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.saved.gating.feature.SaverInfoXConfig;
import com.facebook.saved.gating.feature.SaverInfoXConfig.SaveBookmarkNuxState;
import com.facebook.saved.prefs.SavedPrefKeys;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: TIPJAR */
class OfflineAttachmentSaveFooterPartDefinition$1 implements OnClickListener {
    final /* synthetic */ OfflineAttachmentSaveFooterPersistentState f22615a;
    final /* synthetic */ FeedProps f22616b;
    final /* synthetic */ HasInvalidate f22617c;
    final /* synthetic */ GraphQLStory f22618d;
    final /* synthetic */ OfflineAttachmentSaveFooterPartDefinition f22619e;

    OfflineAttachmentSaveFooterPartDefinition$1(OfflineAttachmentSaveFooterPartDefinition offlineAttachmentSaveFooterPartDefinition, OfflineAttachmentSaveFooterPersistentState offlineAttachmentSaveFooterPersistentState, FeedProps feedProps, HasInvalidate hasInvalidate, GraphQLStory graphQLStory) {
        this.f22619e = offlineAttachmentSaveFooterPartDefinition;
        this.f22615a = offlineAttachmentSaveFooterPersistentState;
        this.f22616b = feedProps;
        this.f22617c = hasInvalidate;
        this.f22618d = graphQLStory;
    }

    public void onClick(View view) {
        boolean z;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1485007093);
        if (this.f22615a.b) {
            this.f22619e.b.b(this.f22616b, CurationMechanism.OFFLINE_TOGGLE_BUTTON, CurationSurface.NATIVE_STORY);
        } else {
            OfflineAttachmentSaveFooterPartDefinition offlineAttachmentSaveFooterPartDefinition = this.f22619e;
            if (SaveBookmarkNuxState.ELIGIBLE.equals(SaveBookmarkNuxState.convertString(offlineAttachmentSaveFooterPartDefinition.c.a(SaverInfoXConfig.c, null)))) {
                offlineAttachmentSaveFooterPartDefinition.d.edit().putBoolean(SavedPrefKeys.f, true).commit();
            }
            this.f22619e.b.a(this.f22616b, CurationMechanism.OFFLINE_TOGGLE_BUTTON, CurationSurface.NATIVE_STORY);
        }
        OfflineAttachmentSaveFooterPersistentState offlineAttachmentSaveFooterPersistentState = this.f22615a;
        if (this.f22615a.b) {
            z = false;
        } else {
            z = true;
        }
        offlineAttachmentSaveFooterPersistentState.b = z;
        this.f22617c.a(new Object[]{this.f22618d});
        LogUtils.a(414070195, a);
    }
}
