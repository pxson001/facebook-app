package com.facebook.messaging.events.banner;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.hscrollrecyclerview.HScrollLinearLayoutManager;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: source_ref */
public class EventReminderMembersRowView extends CustomLinearLayout {
    @Inject
    EventReminderFacepileRecyclerViewAdapter f2313a;
    @Inject
    HScrollLinearLayoutManager f2314b;
    private EventReminderMembers f2315c;
    private BetterTextView f2316d;
    private HScrollRecyclerView f2317e;

    private static <T extends View> void m2172a(Class<T> cls, T t) {
        m2173a((Object) t, t.getContext());
    }

    private static void m2173a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventReminderMembersRowView) obj).m2171a(new EventReminderFacepileRecyclerViewAdapter(UserTileViewParamsFactory.a(fbInjector)), HScrollLinearLayoutManager.b(fbInjector));
    }

    private void m2171a(EventReminderFacepileRecyclerViewAdapter eventReminderFacepileRecyclerViewAdapter, HScrollLinearLayoutManager hScrollLinearLayoutManager) {
        this.f2313a = eventReminderFacepileRecyclerViewAdapter;
        this.f2314b = hScrollLinearLayoutManager;
    }

    public EventReminderMembersRowView(Context context) {
        super(context);
        m2170a();
    }

    public EventReminderMembersRowView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2170a();
    }

    public EventReminderMembersRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2170a();
    }

    private void m2170a() {
        m2172a(EventReminderMembersRowView.class, (View) this);
        setContentView(2130904092);
        setOrientation(1);
        m2174b();
        m2176d();
    }

    private void m2174b() {
        this.f2316d = (BetterTextView) a(2131561377);
        m2175c();
    }

    private void m2175c() {
        if (this.f2315c != null) {
            int size = this.f2315c.f2310b.size();
            CharSequence stringBuilder = new StringBuilder();
            if (size > 0) {
                stringBuilder.append(getResources().getQuantityString(2131689791, size, new Object[]{Integer.valueOf(size)}));
            }
            int size2 = this.f2315c.f2311c.size();
            if (size2 > 0) {
                if (size > 0) {
                    stringBuilder.append(" ⋅ ");
                }
                stringBuilder.append(getResources().getQuantityString(2131689792, size2, new Object[]{Integer.valueOf(size2)}));
            }
            this.f2316d.setText(stringBuilder);
        }
    }

    private void m2176d() {
        this.f2314b.b(0);
        this.f2317e = (HScrollRecyclerView) a(2131561378);
        this.f2317e.setAdapter(this.f2313a);
        this.f2317e.setLayoutManager(this.f2314b);
    }

    public void setMembers(EventReminderMembers eventReminderMembers) {
        this.f2315c = eventReminderMembers;
        EventReminderFacepileRecyclerViewAdapter eventReminderFacepileRecyclerViewAdapter = this.f2313a;
        eventReminderFacepileRecyclerViewAdapter.f2304c = eventReminderMembers.f2310b;
        eventReminderFacepileRecyclerViewAdapter.f2305d = eventReminderMembers.f2311c;
        eventReminderFacepileRecyclerViewAdapter.f2306e = eventReminderMembers.f2312d;
        eventReminderFacepileRecyclerViewAdapter.f2303b = (eventReminderFacepileRecyclerViewAdapter.f2304c.size() + eventReminderFacepileRecyclerViewAdapter.f2305d.size()) + eventReminderFacepileRecyclerViewAdapter.f2306e.size();
        eventReminderFacepileRecyclerViewAdapter.notifyDataSetChanged();
        m2175c();
    }
}
