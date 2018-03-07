package com.facebook.backstage.consumption.reply;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.backstage.consumption.BackstagePanelImageView;
import com.facebook.backstage.consumption.BackstagePanelView;
import com.facebook.backstage.consumption.BackstagePanelViewProvider;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.backstage.consumption.reply.BackstageReplyThreadSummaryListView.C05081;
import com.facebook.backstage.data.BackstageProfile.SeenByUser;
import com.facebook.backstage.data.ReplyThreadSummary;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: ride_cancel */
public class ReplyThreadSummaryListAdapter extends Adapter {
    private final ScreenUtil f4967a;
    public final C05081 f4968b;
    public final RecyclerView f4969c;
    private final BackstagePanelViewProvider f4970d;
    public ImmutableList<ReplyThreadSummary> f4971e;

    @Inject
    public ReplyThreadSummaryListAdapter(BackstagePanelViewProvider backstagePanelViewProvider, ScreenUtil screenUtil, @Assisted C05081 c05081, @Assisted RecyclerView recyclerView) {
        this.f4970d = backstagePanelViewProvider;
        this.f4968b = c05081;
        this.f4969c = recyclerView;
        this.f4967a = screenUtil;
    }

    private boolean m4808d() {
        return this.f4971e == null || this.f4971e.isEmpty();
    }

    public int getItemViewType(int i) {
        if (m4808d()) {
            return 0;
        }
        return 1;
    }

    public final ViewHolder m4809a(ViewGroup viewGroup, int i) {
        if (m4808d()) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130906820, viewGroup, false);
            frameLayout.setLayoutParams(new LayoutParams(this.f4967a.m4551a(), this.f4967a.m4551a()));
            return new ViewHolder(this, frameLayout) {
                final /* synthetic */ ReplyThreadSummaryListAdapter f4964l;
            };
        }
        final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130903362, viewGroup, false);
        linearLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ReplyThreadSummaryListAdapter f4966b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -972315706);
                ReplyThreadSummary replyThreadSummary = (ReplyThreadSummary) this.f4966b.f4971e.get(this.f4966b.f4969c.c(view));
                if (replyThreadSummary.m4919i()) {
                    view = linearLayout.findViewById(2131559877);
                }
                this.f4966b.f4968b.m4750a(view, replyThreadSummary);
                Logger.a(2, EntryType.UI_INPUT_END, -1130279559, a);
            }
        });
        return this.f4970d.m4507a(linearLayout);
    }

    public final void m4810a(ViewHolder viewHolder, int i) {
        if (!m4808d()) {
            ReplyThreadSummary replyThreadSummary = (ReplyThreadSummary) this.f4971e.get(i);
            BackstagePanelView backstagePanelView = (BackstagePanelView) viewHolder;
            backstagePanelView.f4551m.setImage(replyThreadSummary.f5141c.f5101b);
            backstagePanelView.f4552n.setText(backstagePanelView.f4550l.getResources().getString(replyThreadSummary.m4919i() ? 2131239943 : 2131239942, new Object[]{replyThreadSummary.m4918a()}));
            backstagePanelView.f4553o.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            CharSequence a = backstagePanelView.f4555q.m4565a(backstagePanelView.a.getContext().getResources(), replyThreadSummary.f5143e.getTime());
            if (a != null) {
                backstagePanelView.f4553o.setText(a);
                backstagePanelView.f4553o.setVisibility(0);
            } else {
                backstagePanelView.f4553o.setVisibility(8);
            }
            if (replyThreadSummary.f5140b != null) {
                ((BackstagePanelImageView) backstagePanelView.f4554p.m5715a()).m4505a(false);
                ((BackstagePanelImageView) backstagePanelView.f4554p.m5715a()).setImage(Uri.parse(replyThreadSummary.f5140b));
                ((BackstagePanelImageView) backstagePanelView.f4554p.m5715a()).setVisibility(0);
            } else {
                ((BackstagePanelImageView) backstagePanelView.f4554p.m5715a()).setVisibility(8);
            }
            if (replyThreadSummary.m4919i()) {
                ((AnimatingEmojiView) backstagePanelView.f4556r.m5715a()).setVisibility(0);
                ((AnimatingEmojiView) backstagePanelView.f4556r.m5715a()).setUser(new SeenByUser(replyThreadSummary.f5141c, replyThreadSummary.f5144f));
                ((AnimatingEmojiView) backstagePanelView.f4556r.m5715a()).m4740a();
            } else if (backstagePanelView.f4556r.m5716b()) {
                ((AnimatingEmojiView) backstagePanelView.f4556r.m5715a()).setVisibility(8);
            }
        }
    }

    public final int aZ_() {
        return m4808d() ? 1 : this.f4971e.size();
    }
}
