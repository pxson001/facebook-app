package com.facebook.feed.ui.imageloader;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.collect.WeakHashSets;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.unit.FeedUnitHelper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.photos.adaptiveimagequality.base.ImageQuality;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.ListViewPreloader;
import com.facebook.widget.listview.ListViewPreloader.PreloadBufferSize;
import com.facebook.widget.listview.ListViewPreloader.PreloadBufferSizeCalculator;
import com.facebook.widget.listview.ListViewPreloader.PreloadDirection;
import com.facebook.widget.listview.ListViewPreloader.PreloadType;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* compiled from: The root catalyst view must have a width and height given to it by it's parent view. You can do this by specifying MATCH_PARENT or explicit width and height in the layout. */
public class FeedImagePrefetchViewPreloader extends ListViewPreloader {
    private final FeedImagePreloader f22211d;
    private final BasicAdapter f22212e;
    public final WeakHashMap<FeedUnit, List<ListenableFuture<?>>> f22213f;
    public final Set<FeedUnit> f22214g;
    @ForUiThread
    private final Executor f22215h;

    /* compiled from: The root catalyst view must have a width and height given to it by it's parent view. You can do this by specifying MATCH_PARENT or explicit width and height in the layout. */
    class ImagePrefetchBufferSizeCalculator implements PreloadBufferSizeCalculator {
        public final PreloadBufferSize m24854a() {
            return new PreloadBufferSize(18, 18);
        }
    }

    public FeedImagePrefetchViewPreloader(ScrollingViewProxy scrollingViewProxy, BasicAdapter basicAdapter, FeedImagePreloaderProvider feedImagePreloaderProvider, ImagePreprocessor imagePreprocessor, DefaultUserInteractionController defaultUserInteractionController, Executor executor, CallerContext callerContext) {
        super(scrollingViewProxy, new ImagePrefetchBufferSizeCalculator(), PreloadDirection.CLOSEST_FIRST, PreloadType.ALL_OFFSCREEN, defaultUserInteractionController, false, null, 0);
        this.f22215h = executor;
        if (callerContext == null) {
            callerContext = CallerContext.a(getClass(), "native_newsfeed");
        }
        this.f22211d = feedImagePreloaderProvider.a(callerContext, imagePreprocessor);
        this.f22212e = basicAdapter;
        this.f22213f = new WeakHashMap();
        this.f22214g = WeakHashSets.a();
    }

    public final void m24855a(int i) {
        if (i < this.f22212e.aZ_()) {
            final FeedUnit a = FeedUnitHelper.a(this.f22212e.getItem(i));
            if (a != null) {
                List<ListenableFuture> a2 = this.f22211d.m24864a(FeedProps.c(a), ImageQuality.OFF);
                if (a2 != null) {
                    for (final ListenableFuture listenableFuture : a2) {
                        listenableFuture.a(new Runnable(this) {
                            final /* synthetic */ FeedImagePrefetchViewPreloader f22210c;

                            public void run() {
                                FeedImagePrefetchViewPreloader feedImagePrefetchViewPreloader = this.f22210c;
                                FeedUnit feedUnit = a;
                                ListenableFuture listenableFuture = listenableFuture;
                                List list = (List) feedImagePrefetchViewPreloader.f22213f.get(feedUnit);
                                if (list != null) {
                                    list.remove(listenableFuture);
                                }
                            }
                        }, this.f22215h);
                    }
                    List list = (List) this.f22213f.get(a);
                    if (list != null) {
                        list.addAll(a2);
                    } else {
                        this.f22213f.put(a, a2);
                        this.f22214g.add(a);
                    }
                }
            }
        }
    }

    public final boolean m24856b(int i) {
        if (i >= this.f22212e.aZ_()) {
            return false;
        }
        return this.f22214g.contains(FeedUnitHelper.a(this.f22212e.getItem(i)));
    }

    public final void m24857c(int i) {
        if (i < this.f22212e.aZ_()) {
            FeedUnit a = FeedUnitHelper.a(this.f22212e.getItem(i));
            if (a != null) {
                List list = (List) this.f22213f.remove(a);
                if (list != null) {
                    for (ListenableFuture listenableFuture : Lists.a(list)) {
                        if (!listenableFuture.isDone()) {
                            this.f22214g.remove(a);
                            listenableFuture.cancel(false);
                        }
                    }
                }
            }
        }
    }
}
