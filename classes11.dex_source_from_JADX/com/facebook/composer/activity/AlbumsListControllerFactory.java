package com.facebook.composer.activity;

import android.content.Context;
import android.widget.ListView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.composer.activity.AlbumSelectorController.C07523;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.photos.albums.AlbumsAdapterProvider;
import com.facebook.photos.albums.futures.AlbumsFuturesGenerator;
import javax.inject.Inject;

/* compiled from: is_inline_sprouts_open */
public class AlbumsListControllerFactory {
    private final long f5987a;
    private final Context f5988b;
    private final DefaultAndroidThreadUtil f5989c;
    private final AlbumsFuturesGenerator f5990d;
    private final AlbumsAdapterProvider f5991e;
    private final PerformanceLogger f5992f;
    private final AbstractFbErrorReporter f5993g;

    @Inject
    public AlbumsListControllerFactory(String str, Context context, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AlbumsFuturesGenerator albumsFuturesGenerator, AlbumsAdapterProvider albumsAdapterProvider, PerformanceLogger performanceLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f5988b = context;
        this.f5987a = Long.parseLong(str);
        this.f5989c = defaultAndroidThreadUtil;
        this.f5990d = albumsFuturesGenerator;
        this.f5991e = albumsAdapterProvider;
        this.f5992f = performanceLogger;
        this.f5993g = abstractFbErrorReporter;
    }

    public final AlbumsListController m7370a(ComposerTargetData composerTargetData, Long l, ListView listView, C07523 c07523, boolean z) {
        return new AlbumsListController(composerTargetData, Long.valueOf(l != null ? l.longValue() : this.f5987a), this.f5988b, listView, this.f5989c, this.f5990d, this.f5991e, c07523, this.f5992f, this.f5993g, z);
    }
}
