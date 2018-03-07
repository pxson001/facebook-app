package com.facebook.friending.jewel;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.friending.common.list.model.FriendListUserCommonModel;
import com.facebook.friending.jewel.adapter.FriendingJewelAdapter;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.widget.listview.ListViewPreloader;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.WeakHashMap;
import javax.inject.Inject;

/* compiled from: first6 */
public class FriendingJewelImagePreloader extends ListViewPreloader {
    private final FriendingJewelAdapter f13214d;
    public final CallerContext f13215e;
    public final ImagePipeline f13216f;
    private final WeakHashMap<Object, ListenableFuture<Void>> f13217g = new WeakHashMap();

    @Inject
    public FriendingJewelImagePreloader(ImagePipeline imagePipeline, @Assisted CallerContext callerContext, @Assisted ScrollingViewProxy scrollingViewProxy, @Assisted FriendingJewelAdapter friendingJewelAdapter, @Assisted int i) {
        super(scrollingViewProxy, i);
        this.f13214d = friendingJewelAdapter;
        this.f13215e = callerContext;
        this.f13216f = imagePipeline;
    }

    protected final void m14873a(int i) {
        if (i < this.f13214d.getCount()) {
            Object item = this.f13214d.getItem(i);
            if (item != null && (item instanceof FriendListUserCommonModel)) {
                String d = ((FriendListUserCommonModel) item).d();
                if (d != null) {
                    this.f13217g.put(item, DataSourceToFutureAdapter.a(this.f13216f.f(ImageRequestBuilder.a(Uri.parse(d)).m(), this.f13215e)));
                }
            }
        }
    }

    public final boolean m14874b(int i) {
        return i < this.f13214d.getCount() && this.f13217g.get(this.f13214d.getItem(i)) != null;
    }

    public final void m14875c(int i) {
        if (i < this.f13214d.getCount()) {
            Object item = this.f13214d.getItem(i);
            if (item != null) {
                this.f13217g.remove(item);
            }
        }
    }
}
