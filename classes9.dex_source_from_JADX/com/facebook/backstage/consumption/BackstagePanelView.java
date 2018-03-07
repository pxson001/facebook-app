package com.facebook.backstage.consumption;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.backstage.consumption.BackstageFragment.C04323;
import com.facebook.backstage.consumption.reply.AnimatingEmojiView;
import com.facebook.backstage.data.BackstageProfile;
import com.facebook.backstage.data.BackstageProfile.BackstageStory;
import com.facebook.backstage.ui.LazyView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: savedPin */
public class BackstagePanelView extends ViewHolder {
    public final LinearLayout f4550l;
    public final BackstagePanelImageView f4551m;
    public final FbTextView f4552n;
    public final FbTextView f4553o;
    public final LazyView<BackstagePanelImageView> f4554p;
    public final TimeUtil f4555q;
    public final LazyView<AnimatingEmojiView> f4556r;
    private final ImageView f4557s;

    @Inject
    public BackstagePanelView(@Assisted LinearLayout linearLayout, TimeUtil timeUtil) {
        super(linearLayout);
        this.f4550l = linearLayout;
        this.f4555q = timeUtil;
        this.f4551m = (BackstagePanelImageView) linearLayout.findViewById(2131559873);
        this.f4551m.m4505a(true);
        this.f4552n = (FbTextView) linearLayout.findViewById(2131559864);
        this.f4553o = (FbTextView) linearLayout.findViewById(2131559874);
        this.f4554p = new LazyView((ViewStub) linearLayout.findViewById(2131559863));
        this.f4556r = new LazyView((ViewStub) linearLayout.findViewById(2131559876));
        this.f4557s = (ImageView) linearLayout.findViewById(2131559878);
    }

    public final void m4506a(final BackstageProfile backstageProfile, final C04323 c04323) {
        long j;
        this.f4551m.setImage(backstageProfile.m4900k());
        this.f4552n.setText(backstageProfile.m4899d());
        if (backstageProfile.f5114c) {
            this.f4553o.setCompoundDrawablesWithIntrinsicBounds(2130837767, 0, 0, 0);
        } else {
            this.f4553o.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        this.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackstagePanelView f4546c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -974906395);
                c04323.m4463a(backstageProfile);
                Logger.a(2, EntryType.UI_INPUT_END, -25398260, a);
            }
        });
        this.f4551m.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackstagePanelView f4549c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 673344447);
                c04323.m4464b(backstageProfile);
                Logger.a(2, EntryType.UI_INPUT_END, -1801396447, a);
            }
        });
        TimeUtil timeUtil = this.f4555q;
        Resources resources = this.a.getContext().getResources();
        if (backstageProfile.f5116e == null) {
            j = 0;
        } else {
            j = backstageProfile.f5116e.getTime();
        }
        CharSequence a = timeUtil.m4565a(resources, j);
        if (a != null) {
            this.f4553o.setText(a);
            this.f4553o.setVisibility(0);
        } else {
            this.f4553o.setVisibility(8);
        }
        if (backstageProfile.m4897b() != null) {
            if (((BackstageStory) backstageProfile.f5117f.get(backstageProfile.f5118g)).mo172g()) {
                this.f4557s.setVisibility(0);
            } else {
                this.f4557s.setVisibility(8);
            }
            ((BackstagePanelImageView) this.f4554p.m5715a()).m4505a(false);
            ((BackstagePanelImageView) this.f4554p.m5715a()).setImage(backstageProfile.m4897b());
            ((BackstagePanelImageView) this.f4554p.m5715a()).setVisibility(0);
            return;
        }
        ((BackstagePanelImageView) this.f4554p.m5715a()).setVisibility(8);
        this.f4557s.setVisibility(8);
    }
}
