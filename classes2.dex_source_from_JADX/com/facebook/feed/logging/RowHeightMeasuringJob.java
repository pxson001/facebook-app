package com.facebook.feed.logging;

import com.facebook.common.executors.IncrementalRunnable;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.inject.Assisted;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: messenger_two_line_composer_android */
public class RowHeightMeasuringJob extends IncrementalRunnable {
    private final RowHeightMeasurer f13669a;
    public final List<RowData> f13670b = Lists.m1306b();
    public final ExecutorService f13671c;

    @Inject
    public RowHeightMeasuringJob(@Assisted RowHeightMeasurer rowHeightMeasurer, DefaultProcessIdleExecutor defaultProcessIdleExecutor) {
        super(defaultProcessIdleExecutor);
        this.f13671c = defaultProcessIdleExecutor;
        this.f13669a = rowHeightMeasurer;
    }

    public final void mo2638b() {
        RowData rowData = (RowData) this.f13670b.remove(0);
        this.f13669a.m20081a(rowData.b, rowData.c, rowData.d, rowData.e);
    }

    public final boolean mo2639c() {
        return !this.f13670b.isEmpty();
    }

    public final void m20084d() {
        this.f13670b.clear();
    }
}
