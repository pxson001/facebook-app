package com.facebook.messaging.composer.botcomposer;

import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataType;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataUtil;
import com.facebook.messaging.model.messagemetadata.QuickRepliesPlatformMetadata;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: test_results */
public class QuickReplyMessageUpdater {
    private final GatekeeperStoreImpl f1772a;
    private final Lazy<FbBroadcastManager> f1773b;
    private long f1774c = -1;

    public static QuickReplyMessageUpdater m1725a(InjectorLike injectorLike) {
        return new QuickReplyMessageUpdater(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 401));
    }

    @Inject
    public QuickReplyMessageUpdater(GatekeeperStore gatekeeperStore, Lazy<FbBroadcastManager> lazy) {
        this.f1772a = gatekeeperStore;
        this.f1773b = lazy;
    }

    public final void m1726a(RowMessageItem rowMessageItem, long j) {
        if (this.f1772a.a(378, false)) {
            long a = rowMessageItem.m4299a();
            if (a != this.f1774c) {
                QuickRepliesPlatformMetadata quickRepliesPlatformMetadata = (QuickRepliesPlatformMetadata) PlatformMetadataUtil.a(PlatformMetadataType.QUICK_REPLIES, rowMessageItem.f4732a.Q);
                if (quickRepliesPlatformMetadata != null || this.f1774c != -1) {
                    Intent intent = new Intent("com.facebook.messaging.composer.QUICK_REPLY");
                    if (quickRepliesPlatformMetadata != null) {
                        ImmutableList immutableList = quickRepliesPlatformMetadata.a;
                        if (!(immutableList == null || immutableList.isEmpty())) {
                            intent.putParcelableArrayListExtra("action_list", new ArrayList(immutableList));
                            intent.putExtra("page_id", String.valueOf(j));
                        }
                        this.f1774c = a;
                    } else {
                        this.f1774c = -1;
                    }
                    ((BaseFbBroadcastManager) this.f1773b.get()).a(intent);
                }
            }
        }
    }
}
