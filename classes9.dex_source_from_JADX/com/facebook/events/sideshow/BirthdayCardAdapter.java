package com.facebook.events.sideshow;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.facebook.device.ScreenUtil;
import com.facebook.events.sideshow.graphql.SideshowEventsAndBirthdaysQueryModels.SideshowEventsBirthdaysQueryModel.BirthdayFriendsModel.BirthdayPersonModel;
import java.util.List;

/* compiled from: TYPE_STRING */
public class BirthdayCardAdapter extends Adapter<ViewHolder> {
    private List<BirthdayPersonModel> f24406a;
    private BirthdayCardController f24407b;
    private ScreenUtil f24408c;
    private int f24409d = -1;

    /* compiled from: TYPE_STRING */
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public BirthdayCard f24405l;

        public ViewHolder(BirthdayCard birthdayCard) {
            super(birthdayCard);
            this.f24405l = birthdayCard;
        }
    }

    public final void m26253a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
        ((ViewHolder) viewHolder).f24405l.m26246a();
    }

    public final void m26254a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.f24405l.m26247a(this.f24407b, (BirthdayPersonModel) this.f24406a.get(i), i);
        m26251a(viewHolder2.a, i);
    }

    public BirthdayCardAdapter(List<BirthdayPersonModel> list, BirthdayCardController birthdayCardController, ScreenUtil screenUtil) {
        this.f24406a = list;
        this.f24407b = birthdayCardController;
        this.f24408c = screenUtil;
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m26252a(ViewGroup viewGroup, int i) {
        return new ViewHolder((BirthdayCard) LayoutInflater.from(viewGroup.getContext()).inflate(2130907090, viewGroup, false));
    }

    private void m26251a(View view, int i) {
        if (this.f24409d < i) {
            this.f24409d = i;
            int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(2131433973);
            if (this.f24408c.c() >= i * dimensionPixelSize) {
                ViewPropertyAnimatorCompat t = ViewCompat.t(view);
                ViewCompat.e(view, 0.25f);
                ViewCompat.f(view, 0.25f);
                ViewCompat.d(view, (float) (45 - (i * 20)));
                ViewCompat.a(view, (float) (Math.max(2 - i, 0) * dimensionPixelSize));
                ViewCompat.b(view, ((float) (-dimensionPixelSize)) / 2.0f);
                ViewCompat.c(view, 0.2f);
                t.e(1.0f);
                t.f(1.0f);
                t.d(0.0f);
                t.b(0.0f);
                t.c(0.0f);
                t.a(1.0f);
                t.a(200);
                t.b(((long) i) * 20);
                t.a(new DecelerateInterpolator(1.0f));
                t.b();
            }
        }
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public final int aZ_() {
        return this.f24406a.size();
    }
}
