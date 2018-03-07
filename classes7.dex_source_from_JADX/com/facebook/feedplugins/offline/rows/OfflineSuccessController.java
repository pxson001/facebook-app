package com.facebook.feedplugins.offline.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.content.SecureContextHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.progresspage.CompostActivity;
import com.facebook.photos.upload.progresspage.CompostSourceType;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: STARS_LOWRATING_CANCEL */
public class OfflineSuccessController {
    public final QeAccessor f23689a;
    public final OptimisticStoryStateCache f23690b;
    public final SecureContextHelper f23691c;

    /* compiled from: STARS_LOWRATING_CANCEL */
    public class C20461 implements OnClickListener {
        final /* synthetic */ OfflineSuccessController f23688a;

        public C20461(OfflineSuccessController offlineSuccessController) {
            this.f23688a = offlineSuccessController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1366121490);
            Context context = view.getContext();
            this.f23688a.f23691c.a(CompostActivity.a(context, CompostSourceType.OPTIMISTIC_STORY), context);
            Logger.a(2, EntryType.UI_INPUT_END, -441765124, a);
        }
    }

    @Inject
    public OfflineSuccessController(QeAccessor qeAccessor, OptimisticStoryStateCache optimisticStoryStateCache, SecureContextHelper secureContextHelper) {
        this.f23689a = qeAccessor;
        this.f23690b = optimisticStoryStateCache;
        this.f23691c = secureContextHelper;
    }
}
