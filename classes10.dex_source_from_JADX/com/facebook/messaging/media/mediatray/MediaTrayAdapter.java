package com.facebook.messaging.media.mediatray;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.inject.IdBasedProvider;
import com.facebook.messaging.media.mediatray.MediaTrayItemViewHolder.C05026;
import com.facebook.messaging.media.mediatray.MediaTrayItemViewHolder.ClickListener;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.widget.SquareFrameLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: security_checkup_logging */
public class MediaTrayAdapter extends Adapter<ViewHolder> {
    private final ImmutableList<MediaTrayLoader$Item> f3035a;
    public final Map<MediaTrayLoader$Item, MediaTrayLoader$Item> f3036b = new LinkedHashMap();
    private final LayoutInflater f3037c;
    private final MediaTrayItemViewHolderProvider f3038d;
    private final PhotoRemindersNuxController f3039e;
    public final MediaItemClickListener f3040f = new MediaItemClickListener(this);
    private final PhotoRemindersNuxListener f3041g = new PhotoRemindersNuxListener(this);
    public int f3042h = -1;
    public boolean f3043i;
    @Nullable
    public MediaTrayItemViewHolder f3044j;
    @Nullable
    public ClickListener f3045k;
    public Set<MediaTrayLoader$Item> f3046l = new LinkedHashSet();

    /* compiled from: security_checkup_logging */
    public class MediaItemClickListener implements ClickListener {
        final /* synthetic */ MediaTrayAdapter f3033a;

        public MediaItemClickListener(MediaTrayAdapter mediaTrayAdapter) {
            this.f3033a = mediaTrayAdapter;
        }

        public final void mo106a(MediaTrayItemViewHolder mediaTrayItemViewHolder, int i) {
            if (this.f3033a.f3045k != null) {
                this.f3033a.f3045k.mo106a(mediaTrayItemViewHolder, i);
            }
        }

        public final void mo107a(MediaTrayLoader$Item mediaTrayLoader$Item, int i) {
            if (this.f3033a.f3045k != null) {
                this.f3033a.f3045k.mo107a(mediaTrayLoader$Item, i);
                this.f3033a.m3013e();
            }
        }

        public final void mo108b(MediaTrayLoader$Item mediaTrayLoader$Item, int i) {
            if (this.f3033a.f3045k != null) {
                this.f3033a.f3045k.mo108b(mediaTrayLoader$Item, i);
                this.f3033a.m3013e();
            }
        }

        @Nullable
        public final ThreadKey mo105a() {
            if (this.f3033a.f3045k != null) {
                return this.f3033a.f3045k.mo105a();
            }
            return null;
        }
    }

    /* compiled from: security_checkup_logging */
    public class PhotoRemindersNuxListener {
        public final /* synthetic */ MediaTrayAdapter f3034a;

        public PhotoRemindersNuxListener(MediaTrayAdapter mediaTrayAdapter) {
            this.f3034a = mediaTrayAdapter;
        }

        public final void m3004a() {
            this.f3034a.f3043i = false;
            this.f3034a.l_(0);
        }
    }

    @Inject
    public MediaTrayAdapter(LayoutInflater layoutInflater, MediaTrayItemViewHolderProvider mediaTrayItemViewHolderProvider, PhotoRemindersNuxController photoRemindersNuxController, @Assisted ImmutableList<MediaTrayLoader$Item> immutableList) {
        this.f3035a = immutableList;
        this.f3037c = layoutInflater;
        this.f3038d = mediaTrayItemViewHolderProvider;
        this.f3039e = photoRemindersNuxController;
        this.f3039e.f3159l = this.f3041g;
        this.f3043i = this.f3039e.m3124a();
    }

    public final int aZ_() {
        return this.f3043i ? this.f3035a.size() + 1 : this.f3035a.size();
    }

    public final int m3011d() {
        return this.f3035a.size();
    }

    public final MediaTrayLoader$Item m3012e(int i) {
        MediaTrayLoader$Item f = m3006f(i);
        MediaTrayLoader$Item mediaTrayLoader$Item = (MediaTrayLoader$Item) this.f3036b.get(f);
        return mediaTrayLoader$Item != null ? mediaTrayLoader$Item : f;
    }

    private MediaTrayLoader$Item m3006f(int i) {
        Object obj = (this.f3043i && i == 0) ? 1 : null;
        if (obj != null || i < 0 || i >= aZ_()) {
            return null;
        }
        ImmutableList immutableList = this.f3035a;
        if (this.f3043i) {
            i--;
        }
        return (MediaTrayLoader$Item) immutableList.get(i);
    }

    public final long H_(int i) {
        if (i < 0 || i >= aZ_()) {
            return -1;
        }
        return (long) i;
    }

    public final ViewHolder m3007a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return m3005a(viewGroup, Type.PHOTO);
            case 1:
                return m3005a(viewGroup, Type.VIDEO);
            case 2:
                return this.f3039e.m3122a(viewGroup);
            default:
                throw new IllegalStateException("Can't create unexpected view type");
        }
    }

    public final void m3008a(ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case 0:
            case 1:
                MediaTrayItemViewHolder mediaTrayItemViewHolder = (MediaTrayItemViewHolder) viewHolder;
                MediaTrayLoader$Item e = m3012e(i);
                mediaTrayItemViewHolder.f3056C = e;
                mediaTrayItemViewHolder.f3057D = e.f3127b;
                Preconditions.checkState(mediaTrayItemViewHolder.f3057D.d == mediaTrayItemViewHolder.f3054A);
                mediaTrayItemViewHolder.f3066t.setVisibility(8);
                int dimensionPixelSize = mediaTrayItemViewHolder.a.getContext().getResources().getDimensionPixelSize(2131428036);
                mediaTrayItemViewHolder.f3070x = false;
                FbDraweeControllerBuilder a = mediaTrayItemViewHolder.f3060n.p().a(CallerContext.a(MediaTrayItemViewHolder.class, "media_tray_item_view"));
                ImageRequestBuilder a2 = ImageRequestBuilder.a(mediaTrayItemViewHolder.f3057D.c);
                a2.d = new ResizeOptions(dimensionPixelSize, dimensionPixelSize);
                mediaTrayItemViewHolder.f3067u.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) a.c(a2.m())).b(mediaTrayItemViewHolder.f3067u.getController())).a(new C05026(mediaTrayItemViewHolder))).s());
                if (mediaTrayItemViewHolder.f3054A == Type.VIDEO) {
                    mediaTrayItemViewHolder.f3068v.setMediaResource(mediaTrayItemViewHolder.f3057D);
                }
                mediaTrayItemViewHolder.m3026c(this.f3046l.contains(e));
                return;
            case 2:
                this.f3039e.m3123a((PhotoRemindersNuxViewHolder) viewHolder);
                return;
            default:
                throw new IllegalStateException("Can't bind unexpected view type");
        }
    }

    public int getItemViewType(int i) {
        MediaTrayLoader$Item e = m3012e(i);
        if (e == null) {
            return 2;
        }
        return e.f3126a == Type.PHOTO ? 0 : 1;
    }

    private MediaTrayItemViewHolder m3005a(ViewGroup viewGroup, Type type) {
        SquareFrameLayout squareFrameLayout = (SquareFrameLayout) this.f3037c.inflate(2130905189, viewGroup, false);
        MediaTrayItemViewHolderProvider mediaTrayItemViewHolderProvider = this.f3038d;
        MediaTrayItemViewHolder mediaTrayItemViewHolder = new MediaTrayItemViewHolder((QeAccessor) QeInternalImplMethodAutoProvider.a(mediaTrayItemViewHolderProvider), SpringSystem.b(mediaTrayItemViewHolderProvider), IdBasedProvider.a(mediaTrayItemViewHolderProvider, 4187), FbDraweeControllerBuilder.b(mediaTrayItemViewHolderProvider), squareFrameLayout, type);
        mediaTrayItemViewHolder.f3055B = this.f3040f;
        return mediaTrayItemViewHolder;
    }

    public final void m3013e() {
        if (this.f3044j != null) {
            MediaTrayItemViewHolder mediaTrayItemViewHolder = this.f3044j;
            mediaTrayItemViewHolder.f3065s.setVisibility(8);
            mediaTrayItemViewHolder.f3064r.setVisibility(8);
            Spring spring = mediaTrayItemViewHolder.f3061o;
            spring.c = true;
            spring.b(0.0d);
        }
        this.f3042h = -1;
        this.f3044j = null;
    }

    final boolean m3010b(int i, MediaTrayItemViewHolder mediaTrayItemViewHolder) {
        MediaTrayLoader$Item e = m3012e(i);
        if (this.f3046l.remove(e)) {
            mediaTrayItemViewHolder.m3025b(false);
            if (this.f3036b.remove(m3006f(i)) == null) {
                return false;
            }
            j_(i);
            return false;
        }
        this.f3046l.add(e);
        mediaTrayItemViewHolder.m3025b(true);
        return true;
    }

    final int m3014g() {
        return this.f3046l.size();
    }

    final void m3009a(MediaTrayLoader$Item mediaTrayLoader$Item, int i, MediaResource mediaResource) {
        MediaTrayLoader$Item mediaTrayLoader$Item2 = new MediaTrayLoader$Item(mediaResource, mediaResource);
        this.f3036b.put(m3006f(i), mediaTrayLoader$Item2);
        this.f3046l.remove(mediaTrayLoader$Item);
        this.f3046l.add(mediaTrayLoader$Item2);
        j_(i);
    }
}
