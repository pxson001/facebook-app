package com.facebook.orca.background;

import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.stickers.analytics.StickersAutodownloadAnalyticsLogger.OperationStatus;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: page_suggestions */
class FetchAutoDownloadStickersBackgroundTask$3 implements Function<OperationResult, BackgroundResult> {
    final /* synthetic */ String f5228a;
    final /* synthetic */ String f5229b;
    final /* synthetic */ FetchAutoDownloadStickersBackgroundTask f5230c;

    FetchAutoDownloadStickersBackgroundTask$3(FetchAutoDownloadStickersBackgroundTask fetchAutoDownloadStickersBackgroundTask, String str, String str2) {
        this.f5230c = fetchAutoDownloadStickersBackgroundTask;
        this.f5228a = str;
        this.f5229b = str2;
    }

    public Object apply(@Nullable Object obj) {
        OperationResult operationResult = (OperationResult) obj;
        FetchAutoDownloadStickersBackgroundTask.m(this.f5230c);
        if (!operationResult.b) {
            return new BackgroundResult(false);
        }
        if (this.f5228a.equals("download_sticker_pack_assets")) {
            this.f5230c.m.b(this.f5229b, OperationStatus.COMPLETED);
        } else if (this.f5228a.equals("add_sticker_pack")) {
            this.f5230c.m.a(this.f5229b, OperationStatus.COMPLETED);
        }
        return new BackgroundResult(true);
    }
}
