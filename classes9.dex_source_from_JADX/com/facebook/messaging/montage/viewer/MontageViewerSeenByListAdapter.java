package com.facebook.messaging.montage.viewer;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.resources.ui.FbTextView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: is_client_paying_invoices */
public class MontageViewerSeenByListAdapter extends Adapter<ViewHolder> {
    public final Context f12623a;
    public final List<ThreadParticipant> f12624b = new ArrayList();
    public String f12625c;

    /* compiled from: is_client_paying_invoices */
    public class SeenByViewHolder extends ViewHolder {
        public SeenByViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: is_client_paying_invoices */
    public class TitleViewHolder extends ViewHolder {
        public final FbTextView f12622l;

        public TitleViewHolder(View view) {
            super(view);
            this.f12622l = (FbTextView) FindViewUtil.b(view, 2131558927);
        }
    }

    private static MontageViewerSeenByListAdapter m13079b(InjectorLike injectorLike) {
        return new MontageViewerSeenByListAdapter((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public MontageViewerSeenByListAdapter(Context context) {
        this.f12623a = context;
    }

    public final ViewHolder m13080a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case 0:
                return new TitleViewHolder(from.inflate(2130905337, viewGroup, false));
            case 1:
                return new SeenByViewHolder(new MontageSeenByListItemView(viewGroup.getContext()));
            default:
                throw new IllegalStateException("Unknown view type: " + i);
        }
    }

    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    public final int aZ_() {
        return this.f12624b.size() + 1;
    }

    public final void m13081a(ViewHolder viewHolder, int i) {
        if (viewHolder.e == 0) {
            TitleViewHolder titleViewHolder = (TitleViewHolder) viewHolder;
            titleViewHolder.f12622l.setText(this.f12625c);
        } else if (viewHolder.e == 1) {
            ThreadParticipant threadParticipant;
            if (i == 0) {
                threadParticipant = null;
            } else {
                threadParticipant = (ThreadParticipant) this.f12624b.get(i - 1);
            }
            ThreadParticipant threadParticipant2 = threadParticipant;
            MontageSeenByListItemView montageSeenByListItemView = (MontageSeenByListItemView) ((SeenByViewHolder) viewHolder).a;
            montageSeenByListItemView.f12604c.setParams(montageSeenByListItemView.f12603b.m16382a(threadParticipant2.b()));
            montageSeenByListItemView.f12605d.setText(threadParticipant2.e());
            montageSeenByListItemView.f12606e.setText(montageSeenByListItemView.f12602a.a(threadParticipant2.b));
        }
    }
}
