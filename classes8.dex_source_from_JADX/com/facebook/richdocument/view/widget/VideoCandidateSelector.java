package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.facebook.common.util.CollectionUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.AutoplayCandidateRegisterEventSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.AutoplayCandidateRegisterEvent;
import com.facebook.richdocument.event.RichDocumentEvents.AutoplayCandidateRegisterEvent.RequestType;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.impl.VideoBlockViewImpl;
import com.facebook.richdocument.view.viewholder.BlockViewHolder;
import com.facebook.richdocument.view.widget.video.AutoplayCandidateAware;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

/* compiled from: offer_claim_mark_as_used */
public class VideoCandidateSelector extends RecyclerViewChildSelector implements InjectableComponentWithContext {
    @Inject
    public RichDocumentEventBus f7558a;
    private final List<AutoplayCandidateAware> f7559b = new CopyOnWriteArrayList();
    private final AutoplayCandidateRegisterEventSubscriber f7560c = new C08681(this);
    private final OnScrollListener f7561d;

    /* compiled from: offer_claim_mark_as_used */
    class C08681 extends AutoplayCandidateRegisterEventSubscriber {
        final /* synthetic */ VideoCandidateSelector f7556a;

        C08681(VideoCandidateSelector videoCandidateSelector) {
            this.f7556a = videoCandidateSelector;
        }

        public final void m7757b(FbEvent fbEvent) {
            AutoplayCandidateRegisterEvent autoplayCandidateRegisterEvent = (AutoplayCandidateRegisterEvent) fbEvent;
            RequestType requestType = autoplayCandidateRegisterEvent.f5158b;
            VideoBlockViewImpl videoBlockViewImpl = autoplayCandidateRegisterEvent.f5157a;
            if (requestType == RequestType.REGISTER) {
                this.f7556a.m7762a(videoBlockViewImpl);
            } else if (requestType == RequestType.UNREGISTER) {
                this.f7556a.m7764b(videoBlockViewImpl);
            }
        }
    }

    /* compiled from: offer_claim_mark_as_used */
    class C08692 extends OnScrollListener {
        final /* synthetic */ VideoCandidateSelector f7557a;

        C08692(VideoCandidateSelector videoCandidateSelector) {
            this.f7557a = videoCandidateSelector;
        }

        public final void m7758a(RecyclerView recyclerView, int i, int i2) {
            this.f7557a.m7765c();
        }
    }

    public static void m7759a(Object obj, Context context) {
        ((VideoCandidateSelector) obj).f7558a = RichDocumentEventBus.m5130a(FbInjector.get(context));
    }

    private boolean m7760d() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f7250a.getLayoutManager();
        int l = linearLayoutManager.l();
        int v = l + linearLayoutManager.v();
        for (int i = l; i <= v; i++) {
            VideoBlockViewImpl videoBlockViewImpl;
            VideoBlockViewImpl videoBlockViewImpl2;
            RichDocumentVideoPlayer D;
            boolean o;
            ViewHolder c = this.f7250a.c(i);
            if (c instanceof BlockViewHolder) {
                BlockView blockView = ((BlockViewHolder) c).m7383w().f6382d;
                if (blockView instanceof VideoBlockViewImpl) {
                    videoBlockViewImpl = (VideoBlockViewImpl) blockView;
                    videoBlockViewImpl2 = videoBlockViewImpl;
                    if (videoBlockViewImpl2 != null) {
                        D = videoBlockViewImpl2.m7029D();
                        if (D == null) {
                            o = D.o();
                        } else {
                            o = false;
                        }
                        if (o) {
                            return true;
                        }
                    }
                }
            }
            videoBlockViewImpl = null;
            videoBlockViewImpl2 = videoBlockViewImpl;
            if (videoBlockViewImpl2 != null) {
                D = videoBlockViewImpl2.m7029D();
                if (D == null) {
                    o = false;
                } else {
                    o = D.o();
                }
                if (o) {
                    return true;
                }
            }
        }
        return false;
    }

    public Context getContext() {
        return this.f7250a.getContext();
    }

    public VideoCandidateSelector(BetterRecyclerView betterRecyclerView) {
        super(betterRecyclerView);
        Class cls = VideoCandidateSelector.class;
        m7759a(this, getContext());
        this.f7558a.a(this.f7560c);
        this.f7561d = new C08692(this);
        betterRecyclerView.a(this.f7561d);
    }

    public final void m7763b() {
        m7761e();
        this.f7558a.b(this.f7560c);
        ((BetterRecyclerView) this.f7250a).b(this.f7561d);
    }

    public final synchronized void m7765c() {
        if (!(CollectionUtil.a(this.f7559b) || m7760d())) {
            Collection arrayList = new ArrayList();
            for (VideoBlockViewImpl A : this.f7559b) {
                arrayList.add(A.m7026A());
            }
            View a = m7517a(arrayList);
            if (a != null) {
                for (VideoBlockViewImpl A2 : this.f7559b) {
                    if (a == A2.m7026A() && A2.m7027B()) {
                        A2.m7028C();
                    }
                }
            }
        }
    }

    public final synchronized void m7762a(VideoBlockViewImpl videoBlockViewImpl) {
        if (!this.f7559b.contains(videoBlockViewImpl)) {
            this.f7559b.add(videoBlockViewImpl);
            m7765c();
        }
    }

    public final synchronized void m7764b(VideoBlockViewImpl videoBlockViewImpl) {
        if (this.f7559b.contains(videoBlockViewImpl)) {
            this.f7559b.remove(videoBlockViewImpl);
        }
        m7765c();
    }

    private synchronized void m7761e() {
        this.f7559b.clear();
        m7765c();
    }
}
