package com.facebook.feed.menu.base;

import android.net.Uri;
import com.facebook.bugreporter.BugReportExtraFileMapProvider;
import com.facebook.bugreporter.BugReportingXConfig;
import com.facebook.debug.log.BLog;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.io.File;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$SerializedStoryDataFileProvider implements BugReportExtraFileMapProvider {
    final /* synthetic */ BaseFeedStoryMenuHelper f19436a;
    @Nonnull
    private final String f19437b;

    public BaseFeedStoryMenuHelper$SerializedStoryDataFileProvider(BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, @Nonnull String str) {
        this.f19436a = baseFeedStoryMenuHelper;
        this.f19437b = str;
    }

    public boolean shouldSendAsync() {
        return this.f19436a.C.a(BugReportingXConfig.x, false);
    }

    public Map<String, String> getExtraFileFromWorkerThread(File file) {
        Builder builder = ImmutableMap.builder();
        try {
            File file2 = new File(file, "serialized_story_data.txt");
            Uri fromFile = Uri.fromFile(file2);
            this.f19436a.u.a(file2, this.f19437b);
            builder.b("serialized_story_data.txt", fromFile.toString());
        } catch (Throwable e) {
            BLog.a(BaseFeedStoryMenuHelper.o, "Exception saving serialized story data file", e);
        }
        return builder.b();
    }

    public void prepareDataForWriting() {
    }
}
