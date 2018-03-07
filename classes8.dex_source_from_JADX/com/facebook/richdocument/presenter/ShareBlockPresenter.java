package com.facebook.richdocument.presenter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.ShareBlockData;
import com.facebook.richdocument.model.data.impl.ShareBlockDataImpl;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.block.ShareBlockView;
import com.facebook.richdocument.view.block.impl.ShareBlockViewImpl;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: perceivedLatency */
public class ShareBlockPresenter extends AbstractBlockPresenter<ShareBlockView, ShareBlockData> {
    @Inject
    public ComposerLauncher f6442d;
    @Inject
    public RichDocumentInfo f6443e;
    @Inject
    public BlockViewUtil f6444f;
    @Inject
    public RichDocumentAnalyticsLogger f6445g;

    public static void m6826a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ShareBlockPresenter shareBlockPresenter = (ShareBlockPresenter) obj;
        ComposerLauncher composerLauncher = (ComposerLauncher) ComposerLauncherImpl.a(injectorLike);
        RichDocumentInfo a = RichDocumentInfo.m5102a(injectorLike);
        BlockViewUtil a2 = BlockViewUtil.m6915a(injectorLike);
        RichDocumentAnalyticsLogger a3 = RichDocumentAnalyticsLogger.m5360a(injectorLike);
        shareBlockPresenter.f6442d = composerLauncher;
        shareBlockPresenter.f6443e = a;
        shareBlockPresenter.f6444f = a2;
        shareBlockPresenter.f6445g = a3;
    }

    public final void mo366a(BlockData blockData) {
        final ShareBlockDataImpl shareBlockDataImpl = (ShareBlockDataImpl) blockData;
        ((ShareBlockViewImpl) this.f6382d).mo374a(null);
        final String uuid = SafeUUIDGenerator.a().toString();
        ShareBlockViewImpl shareBlockViewImpl = (ShareBlockViewImpl) this.f6382d;
        shareBlockViewImpl.f6795h.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShareBlockPresenter f6441c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1918388505);
                ShareBlockPresenter shareBlockPresenter = this.f6441c;
                Map hashMap = new HashMap();
                hashMap.put("block_media_type", "article");
                hashMap.put("ia_source", "share_block");
                hashMap.put("share_type", "edit_and_share_tapped");
                shareBlockPresenter.f6445g.m5371c("feed_share_action_bottom", hashMap);
                this.f6441c.f6444f.m6923a(this.f6441c.getContext(), this.f6441c.f6442d, uuid, shareBlockDataImpl.f5760a, this.f6441c.f6443e.m5104b(), 1003);
                Logger.a(2, EntryType.UI_INPUT_END, 1690556345, a);
            }
        });
    }

    public ShareBlockPresenter(ShareBlockViewImpl shareBlockViewImpl) {
        super(shareBlockViewImpl);
        Class cls = ShareBlockPresenter.class;
        m6826a(this, getContext());
    }
}
