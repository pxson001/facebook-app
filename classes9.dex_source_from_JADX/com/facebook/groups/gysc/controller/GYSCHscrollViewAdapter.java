package com.facebook.groups.gysc.controller;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.content.event.FbEvent;
import com.facebook.groups.create.event.GroupCreatedEvent;
import com.facebook.groups.create.event.GroupCreatedEventBus;
import com.facebook.groups.create.event.GroupCreatedEventSubscriber;
import com.facebook.groups.gysc.model.Enums.Location;
import com.facebook.groups.gysc.model.Enums.ViewTypes;
import com.facebook.groups.gysc.model.SuggestionUnitsRowModel;
import com.facebook.groups.gysc.ui.GYSCCardView;
import com.facebook.inject.InjectorLike;
import java.util.List;
import javax.inject.Inject;

/* compiled from: payments_action_back */
public class GYSCHscrollViewAdapter extends Adapter<ViewHolder> {
    public static final String f6938a = GYSCHscrollViewAdapter.class.getName();
    public Context f6939b;
    public GroupCreatedEventBus f6940c;
    public List<SuggestionUnitsRowModel> f6941d;
    public Location f6942e;
    public final GroupCreatedEventSubscriber f6943f = new C07261(this);

    /* compiled from: payments_action_back */
    class C07261 extends GroupCreatedEventSubscriber {
        final /* synthetic */ GYSCHscrollViewAdapter f6937a;

        C07261(GYSCHscrollViewAdapter gYSCHscrollViewAdapter) {
            this.f6937a = gYSCHscrollViewAdapter;
        }

        public final /* synthetic */ void mo273b(FbEvent fbEvent) {
            mo272a((GroupCreatedEvent) fbEvent);
        }

        public final void mo272a(GroupCreatedEvent groupCreatedEvent) {
            GYSCHscrollViewAdapter gYSCHscrollViewAdapter = this.f6937a;
            String str = groupCreatedEvent.f6789b;
            String str2 = groupCreatedEvent.f6790c;
            if (str != null && str2 != null) {
                for (int i = 0; i < gYSCHscrollViewAdapter.f6941d.size(); i++) {
                    if (((SuggestionUnitsRowModel) gYSCHscrollViewAdapter.f6941d.get(i)).f6946b != null) {
                        String l = ((SuggestionUnitsRowModel) gYSCHscrollViewAdapter.f6941d.get(i)).f6946b.m7263l();
                        String name = ((SuggestionUnitsRowModel) gYSCHscrollViewAdapter.f6941d.get(i)).f6946b.m7264m().name();
                        if (l != null && name != null && l.equals(str) && name.equals(str2)) {
                            ((SuggestionUnitsRowModel) gYSCHscrollViewAdapter.f6941d.get(i)).f6945a = true;
                            gYSCHscrollViewAdapter.j_(i);
                            return;
                        }
                    }
                }
            }
        }
    }

    /* compiled from: payments_action_back */
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public static GYSCHscrollViewAdapter m7217b(InjectorLike injectorLike) {
        return new GYSCHscrollViewAdapter((Context) injectorLike.getInstance(Context.class), GroupCreatedEventBus.m7103a(injectorLike));
    }

    public final void m7223a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        View view = ((ViewHolder) viewHolder).a;
        if (i < aZ_() - 0) {
            ((GYSCCardView) view).m7299a((SuggestionUnitsRowModel) this.f6941d.get(i), this.f6942e);
        }
        int[] e = m7218e(i);
        view.setPadding(e[0], e[1], e[2], e[3]);
    }

    @Inject
    public GYSCHscrollViewAdapter(Context context, GroupCreatedEventBus groupCreatedEventBus) {
        this.f6939b = context;
        this.f6940c = groupCreatedEventBus;
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m7222a(ViewGroup viewGroup, int i) {
        return new ViewHolder(new GYSCCardView(viewGroup.getContext()));
    }

    public final int aZ_() {
        if (this.f6941d == null) {
            return 0;
        }
        return this.f6941d.size() + 0;
    }

    private int[] m7218e(int i) {
        int[] iArr = new int[4];
        if (i < aZ_()) {
            iArr[0] = m7220g();
            iArr[3] = this.f6939b.getResources().getDimensionPixelSize(2131433300);
        }
        if (m7219f(i)) {
            iArr[2] = m7220g();
        }
        return iArr;
    }

    public int getItemViewType(int i) {
        return ViewTypes.GYSC_ROW.ordinal();
    }

    private int m7220g() {
        return this.f6939b.getResources().getDimensionPixelSize(2131433299);
    }

    private boolean m7219f(int i) {
        return (i == aZ_() + -1 && !m7221j()) || (i == 0 && m7221j());
    }

    private boolean m7221j() {
        if (VERSION.SDK_INT < 17 || (this.f6939b.getApplicationInfo().flags & 4194304) == 0 || this.f6939b.getResources().getConfiguration().getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }
}
