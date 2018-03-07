package com.facebook.messaging.montage.viewer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.seenheads.SeenHeadCircleOverflowRendererProvider;
import com.facebook.messaging.util.CircleOverflowDrawable;
import com.facebook.messaging.util.CircleOverflowRenderer.Builder;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: is_client_based_in_france */
public class MontageViewerSeenHeadsView extends CustomFrameLayout {
    @Inject
    public Lazy<SeenHeadCircleOverflowRendererProvider> f12635a;
    private final SeenHeadsAdapter f12636b;

    @VisibleForTesting
    /* compiled from: is_client_based_in_france */
    class SeenHeadsAdapter extends Adapter<ViewHolder> {
        private final List<UserKey> f12633a = new ArrayList();
        private final Lazy<SeenHeadCircleOverflowRendererProvider> f12634b;

        /* compiled from: is_client_based_in_france */
        public class OverflowViewHolder extends ViewHolder {
            private final CircleOverflowDrawable f12631l;

            public OverflowViewHolder(View view, CircleOverflowDrawable circleOverflowDrawable) {
                super(view);
                this.f12631l = circleOverflowDrawable;
            }

            public final void m13083c(int i) {
                this.f12631l.a(i);
                ((ImageView) this.a).setImageDrawable(this.f12631l);
            }
        }

        /* compiled from: is_client_based_in_france */
        public class SeenByViewHolder extends ViewHolder {
            private final UserTileView f12632l;

            public SeenByViewHolder(View view) {
                super(view);
                this.f12632l = (UserTileView) FindViewUtil.b(view, 2131563980);
            }

            public final void m13084a(UserKey userKey) {
                this.f12632l.setParams(UserTileViewParams.a(userKey));
            }
        }

        protected SeenHeadsAdapter(Lazy<SeenHeadCircleOverflowRendererProvider> lazy) {
            this.f12634b = lazy;
            a(true);
        }

        public final ViewHolder m13086a(ViewGroup viewGroup, int i) {
            if (i != 0) {
                return new SeenByViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130905338, viewGroup, false));
            }
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130905339, viewGroup, false);
            Builder a = ((SeenHeadCircleOverflowRendererProvider) this.f12634b.get()).m16635a();
            a.b = viewGroup.getResources().getDimensionPixelSize(2131433666);
            return new OverflowViewHolder(inflate, new CircleOverflowDrawable(a.a()));
        }

        public final void m13087a(ViewHolder viewHolder, int i) {
            if (getItemViewType(i) == 0) {
                ((OverflowViewHolder) viewHolder).m13083c(this.f12633a.size() - 4);
            } else {
                ((SeenByViewHolder) viewHolder).m13084a((UserKey) this.f12633a.get(i));
            }
        }

        public int getItemViewType(int i) {
            if (m13085d() && i == 4) {
                return 0;
            }
            return 1;
        }

        public final int aZ_() {
            return Math.min(this.f12633a.size(), 5);
        }

        public final long H_(int i) {
            if (getItemViewType(i) == 0) {
                return -1;
            }
            return (long) ((UserKey) this.f12633a.get(i)).b().hashCode();
        }

        public final void m13088a(List<UserKey> list) {
            this.f12633a.clear();
            this.f12633a.addAll(list);
            notifyDataSetChanged();
        }

        private boolean m13085d() {
            return this.f12633a.size() > 5;
        }
    }

    private static <T extends View> void m13091a(Class<T> cls, T t) {
        m13092a((Object) t, t.getContext());
    }

    private static void m13092a(Object obj, Context context) {
        ((MontageViewerSeenHeadsView) obj).f12635a = IdBasedLazy.a(FbInjector.get(context), 8336);
    }

    public MontageViewerSeenHeadsView(Context context) {
        this(context, null);
    }

    public MontageViewerSeenHeadsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MontageViewerSeenHeadsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13091a(MontageViewerSeenHeadsView.class, (View) this);
        setContentView(2130905347);
        this.f12636b = new SeenHeadsAdapter(this.f12635a);
        RecyclerView recyclerView = (RecyclerView) c(2131563991);
        recyclerView.setAdapter(this.f12636b);
        recyclerView.setLayoutManager(new BetterLinearLayoutManager(context, 0, false));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setSeenBy(ImmutableList<ThreadParticipant> immutableList) {
        this.f12636b.m13088a(m13089a((ImmutableList) immutableList));
    }

    private static List<UserKey> m13089a(ImmutableList<ThreadParticipant> immutableList) {
        List<UserKey> arrayList = new ArrayList(immutableList.size());
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((ThreadParticipant) immutableList.get(i)).b());
        }
        return arrayList;
    }

    private void m13090a(Lazy<SeenHeadCircleOverflowRendererProvider> lazy) {
        this.f12635a = lazy;
    }
}
