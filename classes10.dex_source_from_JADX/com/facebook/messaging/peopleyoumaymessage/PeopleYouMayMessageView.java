package com.facebook.messaging.peopleyoumaymessage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.inbox2.items.InboxUnitItemViewWithState;
import com.facebook.messaging.inbox2.items.InboxUnitViewWithRecyclerView;
import com.facebook.messaging.peopleyoumaymessage.PeopleYouMayMessageLogger.PersonYouMayMessageViewImpression;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: remove_group_from_favorite */
public class PeopleYouMayMessageView extends CustomFrameLayout implements InboxUnitItemViewWithState, InboxUnitViewWithRecyclerView {
    @Inject
    public PeopleYouMayMessageAdapter f3489a;
    @Inject
    PeopleYouMayMessageLogger f3490b;
    private BetterRecyclerView f3491c;
    private InboxUnitItem f3492d;
    private PeopleYouMayMessageViewData f3493e;
    private LinearLayoutManager f3494f;
    public int f3495g = 0;
    private Set<String> f3496h = new HashSet();

    /* compiled from: remove_group_from_favorite */
    class C05531 extends OnScrollListener {
        final /* synthetic */ PeopleYouMayMessageView f3488a;

        C05531(PeopleYouMayMessageView peopleYouMayMessageView) {
            this.f3488a = peopleYouMayMessageView;
        }

        public final void m3369a(RecyclerView recyclerView, int i) {
            super.a(recyclerView, i);
            this.f3488a.f3495g = i;
            PeopleYouMayMessageView.m3376e(this.f3488a);
        }
    }

    private static <T extends View> void m3373a(Class<T> cls, T t) {
        m3374a((Object) t, t.getContext());
    }

    private static void m3374a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PeopleYouMayMessageView) obj).m3371a(new PeopleYouMayMessageAdapter(LayoutInflaterMethodAutoProvider.b(fbInjector)), PeopleYouMayMessageLogger.m3368b(fbInjector));
    }

    private void m3371a(PeopleYouMayMessageAdapter peopleYouMayMessageAdapter, PeopleYouMayMessageLogger peopleYouMayMessageLogger) {
        this.f3489a = peopleYouMayMessageAdapter;
        this.f3490b = peopleYouMayMessageLogger;
    }

    public PeopleYouMayMessageView(Context context) {
        super(context, null, 2130772865);
        m3375b();
    }

    public PeopleYouMayMessageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 2130772865);
        m3375b();
    }

    public PeopleYouMayMessageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3375b();
    }

    private void m3375b() {
        m3373a(PeopleYouMayMessageView.class, (View) this);
        setContentView(2130906171);
        this.f3491c = (BetterRecyclerView) c(2131560745);
        this.f3494f = new LinearLayoutManager(getContext());
        this.f3494f.b(0);
        this.f3491c.setLayoutManager(this.f3494f);
        this.f3491c.setAdapter(this.f3489a);
        this.f3491c.setOnScrollListener(new C05531(this));
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        m3376e(this);
    }

    public static void m3376e(PeopleYouMayMessageView peopleYouMayMessageView) {
        if (peopleYouMayMessageView.f3495g == 0) {
            int m = peopleYouMayMessageView.f3494f.m();
            int o = peopleYouMayMessageView.f3494f.o();
            if (m >= 0 && o < peopleYouMayMessageView.f3493e.f3497a.size() && m <= o) {
                List list = null;
                for (int i = m; i <= o; i++) {
                    PersonYouMayMessage personYouMayMessage = (PersonYouMayMessage) peopleYouMayMessageView.f3493e.f3497a.get(i);
                    if (!peopleYouMayMessageView.f3496h.contains(personYouMayMessage.f3501a.a)) {
                        if (r1 == null) {
                            list = new ArrayList();
                        }
                        list.add(new PersonYouMayMessageViewImpression(personYouMayMessage, i));
                        peopleYouMayMessageView.f3496h.add(personYouMayMessage.f3501a.a);
                    }
                }
                if (r1 != null) {
                    PeopleYouMayMessageLogger peopleYouMayMessageLogger = peopleYouMayMessageView.f3490b;
                    Integer.valueOf(r1.size());
                    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
                    for (PersonYouMayMessageViewImpression personYouMayMessageViewImpression : r1) {
                        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
                        objectNode.a("id", personYouMayMessageViewImpression.f3484a.f3501a.a);
                        objectNode.a("type", "top");
                        objectNode.a("pos", personYouMayMessageViewImpression.f3485b);
                        arrayNode.a(objectNode);
                    }
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("pymm_view_impression");
                    honeyClientEvent.c = "people_you_may_message";
                    peopleYouMayMessageLogger.f3487b.a(honeyClientEvent.a("impression_units", arrayNode));
                }
            }
        }
    }

    public final void m3379a(InboxUnitItem inboxUnitItem, PeopleYouMayMessageViewData peopleYouMayMessageViewData) {
        int dimensionPixelSize;
        this.f3492d = inboxUnitItem;
        this.f3493e = peopleYouMayMessageViewData;
        Resources resources = getResources();
        if (peopleYouMayMessageViewData.f3498b) {
            dimensionPixelSize = resources.getDimensionPixelSize(2131427931);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(2131427930);
        }
        this.f3491c.setLayoutManager(this.f3494f);
        PeopleYouMayMessageAdapter peopleYouMayMessageAdapter = this.f3489a;
        peopleYouMayMessageAdapter.f3469b = peopleYouMayMessageViewData;
        peopleYouMayMessageAdapter.f3470c = peopleYouMayMessageAdapter.f3469b.f3497a;
        peopleYouMayMessageAdapter.notifyDataSetChanged();
        this.f3491c.getLayoutParams().height = dimensionPixelSize;
        this.f3491c.requestLayout();
    }

    public BetterRecyclerView getRecyclerView() {
        return this.f3491c;
    }

    public InboxAdapter getInboxAdapter() {
        return this.f3489a;
    }

    public InboxUnitItem getInboxUnitItem() {
        return this.f3492d;
    }

    public final Bundle m3377a() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("layout_manager_state", this.f3494f.f());
        return bundle;
    }

    public final void m3378a(Bundle bundle) {
        this.f3494f.a(bundle.getParcelable("layout_manager_state"));
    }
}
