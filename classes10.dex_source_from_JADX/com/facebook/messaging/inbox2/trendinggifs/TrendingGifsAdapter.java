package com.facebook.messaging.inbox2.trendinggifs;

import android.graphics.drawable.Animatable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLResult;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: selection_name */
public class TrendingGifsAdapter extends Adapter<ViewHolder> implements InboxAdapter {
    private static final CallerContext f2973a = CallerContext.a(TrendingGifsAdapter.class);
    private final FbDraweeControllerBuilder f2974b;
    public ImmutableList<TrendingGifInboxItem> f2975c;
    @Nullable
    public TrendingGifsUnitListener f2976d;

    /* compiled from: selection_name */
    class C04861 extends BaseControllerListener {
        final /* synthetic */ TrendingGifsAdapter f2969a;

        C04861(TrendingGifsAdapter trendingGifsAdapter) {
            this.f2969a = trendingGifsAdapter;
        }

        public final void m2964a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    /* compiled from: selection_name */
    class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        final FbDraweeView f2972l;

        ViewHolder(FbDraweeView fbDraweeView) {
            super(fbDraweeView);
            this.f2972l = fbDraweeView;
        }
    }

    public final void m2966a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        FbDraweeView fbDraweeView = ((ViewHolder) viewHolder).f2972l;
        final TrendingGifInboxItem trendingGifInboxItem = (TrendingGifInboxItem) this.f2975c.get(i);
        ExternalMediaGraphQLResult externalMediaGraphQLResult = trendingGifInboxItem.f2968f;
        MediaResource mediaResource = (MediaResource) externalMediaGraphQLResult.f.get(0);
        MediaResource mediaResource2 = (MediaResource) externalMediaGraphQLResult.f.get(1);
        fbDraweeView.setAspectRatio(((float) mediaResource2.j) / ((float) mediaResource2.k));
        ImageRequestBuilder a = ImageRequestBuilder.a(mediaResource2.c);
        ImageDecodeOptionsBuilder newBuilder = ImageDecodeOptions.newBuilder();
        newBuilder.d = true;
        a.e = newBuilder.h();
        ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f2974b.p().a(f2973a).d(ImageRequest.a(mediaResource.c))).c(a.m())).b(fbDraweeView.getController())).a(new C04861(this));
        fbDraweeView.setController(this.f2974b.s());
        fbDraweeView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TrendingGifsAdapter f2971b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2097241344);
                if (this.f2971b.f2976d != null) {
                    this.f2971b.f2976d.mo104a(trendingGifInboxItem);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 481697960, a);
            }
        });
    }

    @Inject
    public TrendingGifsAdapter(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f2974b = fbDraweeControllerBuilder;
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m2965a(ViewGroup viewGroup, int i) {
        return new ViewHolder((FbDraweeView) LayoutInflater.from(viewGroup.getContext()).inflate(2130904888, viewGroup, false));
    }

    public final int aZ_() {
        return this.f2975c == null ? 0 : this.f2975c.size();
    }

    public final int m2967b() {
        return aZ_();
    }

    public final InboxItem m2968b(int i) {
        return (InboxItem) this.f2975c.get(i);
    }
}
