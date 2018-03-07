package com.facebook.orca.threadview.messagelist;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.orca.threadview.GiftWrapAnimationManager;
import com.facebook.orca.threadview.MessageDetailViewManager;
import com.facebook.orca.threadview.MessageListAdapter;
import com.facebook.orca.threadview.MessageListAdapter.Listener;
import com.facebook.orca.threadview.MessageListAdapterForRecyclerView;
import com.facebook.orca.threadview.MessageListAdapterForRecyclerViewProvider;
import com.facebook.orca.threadview.PaymentsAnimationManager;
import com.facebook.orca.threadview.SendMessageAnimationManager;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass14;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.BotPromptViewListener;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.EmojilikePickerViewListener;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.MessageListListener;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.NicknamePromptViewListener;
import com.facebook.orca.threadview.ThreadViewMessagesListView.Decoration;
import com.facebook.orca.threadview.ThreadViewMessagesRecyclerView;
import com.facebook.orca.threadview.hotlikes.HotLikesAnimationManager;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.ScrollState;
import com.facebook.widget.listview.ScrollState.ScrollPosition;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: mark read */
public class MessageListHelperForRecyclerView implements MessageListHelper {
    private final AdapterObserverForListener f8247a = new AdapterObserverForListener();
    public final List<Decoration> f8248b = new ArrayList(1);
    private final BetterLinearLayoutManager f8249c;
    private final MessageListAdapter f8250d;
    private final MessageListAdapterForRecyclerView f8251e;
    @Nullable
    public ThreadViewMessagesRecyclerView f8252f;
    @Nullable
    public MessageListListener f8253g;
    @Nullable
    private RecyclerViewProxy f8254h;

    /* compiled from: mark read */
    class C12361 extends OnScrollListener {
        final /* synthetic */ MessageListHelperForRecyclerView f8244a;

        C12361(MessageListHelperForRecyclerView messageListHelperForRecyclerView) {
            this.f8244a = messageListHelperForRecyclerView;
        }

        public final void m8190a(RecyclerView recyclerView, int i) {
            if (this.f8244a.f8253g != null) {
                this.f8244a.f8253g.mo332a(i);
            }
        }

        public final void m8191a(RecyclerView recyclerView, int i, int i2) {
            for (Decoration a : this.f8244a.f8248b) {
                a.mo244a();
            }
            if (this.f8244a.f8253g != null) {
                this.f8244a.f8253g.m7498a(recyclerView, this.f8244a.mo357e(), this.f8244a.f8252f.getChildCount(), this.f8244a.mo356d(), i2);
            }
        }
    }

    /* compiled from: mark read */
    class C12372 implements OnDrawListener {
        final /* synthetic */ MessageListHelperForRecyclerView f8245a;

        C12372(MessageListHelperForRecyclerView messageListHelperForRecyclerView) {
            this.f8245a = messageListHelperForRecyclerView;
        }

        public final boolean gD_() {
            return this.f8245a.f8253g != null && this.f8245a.f8253g.m7499a();
        }
    }

    /* compiled from: mark read */
    public final class AdapterObserverForListener extends AdapterDataObserver {
        public MessageListListener f8246a;

        public final void bb_() {
            m8192b();
        }

        public final void m8193a(int i, int i2) {
            m8192b();
        }

        public final void m8195b(int i, int i2) {
            m8192b();
        }

        public final void m8194a(int i, int i2, int i3) {
            m8192b();
        }

        public final void m8196c(int i, int i2) {
            m8192b();
        }

        private void m8192b() {
            if (this.f8246a != null) {
                this.f8246a.m7500b();
            }
        }
    }

    public static MessageListHelperForRecyclerView m8197b(InjectorLike injectorLike) {
        return new MessageListHelperForRecyclerView((Context) injectorLike.getInstance(Context.class), (MessageListAdapterForRecyclerViewProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MessageListAdapterForRecyclerViewProvider.class), MessageListAdapter.m6861b(injectorLike));
    }

    @Inject
    private MessageListHelperForRecyclerView(Context context, MessageListAdapterForRecyclerViewProvider messageListAdapterForRecyclerViewProvider, MessageListAdapter messageListAdapter) {
        this.f8250d = messageListAdapter;
        this.f8251e = messageListAdapterForRecyclerViewProvider.m6911a(messageListAdapter);
        this.f8249c = new BetterLinearLayoutManager(context, 1, false);
    }

    public final void mo337a(FrameLayout frameLayout, ViewStub viewStub) {
        viewStub.setLayoutResource(2130905228);
        this.f8252f = (ThreadViewMessagesRecyclerView) viewStub.inflate();
        this.f8252f.setAdapter(this.f8251e);
        this.f8252f.setLayoutManager(this.f8249c);
        this.f8252f.setBroadcastInteractionChanges(true);
        this.f8252f.setOnScrollListener(new C12361(this));
        this.f8252f.a(new C12372(this));
    }

    public final void mo344a(MessageListListener messageListListener) {
        this.f8253g = messageListListener;
        this.f8247a.f8246a = this.f8253g;
    }

    public final void mo341a(AnonymousClass14 anonymousClass14) {
        this.f8250d.f7176B = anonymousClass14;
    }

    public final void mo343a(EmojilikePickerViewListener emojilikePickerViewListener) {
        this.f8250d.f7177C = emojilikePickerViewListener;
    }

    public final void mo345a(NicknamePromptViewListener nicknamePromptViewListener) {
        this.f8250d.f7178D = nicknamePromptViewListener;
    }

    public final void mo342a(BotPromptViewListener botPromptViewListener) {
        this.f8250d.f7179E = botPromptViewListener;
    }

    @Nullable
    public final ViewGroup mo334a() {
        return this.f8252f;
    }

    public final RowItem mo335a(int i) {
        return this.f8251e.m6910e(i);
    }

    public final void mo351b() {
        this.f8251e.notifyDataSetChanged();
    }

    public final boolean mo355c() {
        return this.f8251e.aZ_() == 0;
    }

    public final int mo356d() {
        return this.f8251e.aZ_();
    }

    public final int mo357e() {
        return this.f8249c.l();
    }

    public final int mo358f() {
        return this.f8249c.n();
    }

    public final void mo346a(Decoration decoration) {
        if (this.f8252f != null) {
            this.f8252f.m7871a(decoration);
        }
    }

    public final void mo353b(Decoration decoration) {
        if (this.f8252f != null) {
            this.f8252f.m7872b(decoration);
        }
    }

    public final void mo350a(boolean z) {
        if (z) {
            this.f8251e.a(this.f8247a);
        } else {
            this.f8251e.b(this.f8247a);
        }
    }

    public final void mo338a(DefaultThreadViewTheme defaultThreadViewTheme) {
        this.f8250d.m6887a(defaultThreadViewTheme);
    }

    public final void mo359g() {
        if (this.f8252f != null) {
            int d = mo356d();
            if (d > 0 && !mo360h()) {
                if (d - this.f8252f.getLastVisiblePosition() > this.f8252f.getChildCount()) {
                    this.f8252f.a(d - 1);
                } else {
                    this.f8252f.b(d - 1);
                }
            }
        }
    }

    public final void mo352b(int i) {
        if (this.f8252f != null) {
            this.f8252f.b(i);
        }
    }

    public final boolean mo360h() {
        int d = mo356d();
        return d == 0 || this.f8249c.o() == d - 1;
    }

    public final void mo354b(boolean z) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo339a(@javax.annotation.Nullable com.facebook.messaging.threadview.rows.RowItem r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r5 = r7.mo355c();
        if (r5 != 0) goto L_0x0047;
    L_0x0008:
        r5 = 0;
        r5 = r7.mo335a(r5);
        r6 = com.facebook.orca.threadview.MessageListAdapter.f7172a;
        if (r5 == r6) goto L_0x0019;
    L_0x0011:
        r6 = com.facebook.orca.threadview.MessageListAdapter.f7173b;
        if (r5 == r6) goto L_0x0019;
    L_0x0015:
        r6 = com.facebook.orca.threadview.MessageListAdapter.f7174c;
        if (r5 != r6) goto L_0x0047;
    L_0x0019:
        r0 = r5;
        if (r0 == 0) goto L_0x0043;
    L_0x001c:
        r0 = r1;
    L_0x001d:
        r3 = com.google.common.collect.ImmutableList.builder();
        if (r8 == 0) goto L_0x0026;
    L_0x0023:
        r3.c(r8);
    L_0x0026:
        r4 = r7.f8251e;
        r4 = r4.m6909d();
        if (r0 == 0) goto L_0x0045;
    L_0x002e:
        r0 = r4.size();
        r0 = r4.subList(r1, r0);
        r3.b(r0);
        r0 = r7.f8251e;
        r1 = r3.b();
        r0.m6908a(r1);
        return;
    L_0x0043:
        r0 = r2;
        goto L_0x001d;
    L_0x0045:
        r1 = r2;
        goto L_0x002e;
    L_0x0047:
        r5 = 0;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadview.messagelist.MessageListHelperForRecyclerView.a(com.facebook.messaging.threadview.rows.RowItem):void");
    }

    public final void mo349a(List<RowItem> list) {
        TracerDetour.a("MessageListHelperForRecyclerView.updateAdapter", 684456548);
        try {
            this.f8251e.m6908a(list);
        } finally {
            TracerDetour.a(314288928);
        }
    }

    public final ImmutableList<RowItem> mo361i() {
        return this.f8251e.m6909d();
    }

    public final ImmutableList<RowItem> mo362j() {
        return this.f8251e.m6909d();
    }

    @Nullable
    public final ScrollState mo363k() {
        if (this.f8252f == null) {
            return null;
        }
        int e = mo357e();
        ImmutableMap immutableMap = RegularImmutableBiMap.a;
        if (mo356d() > 0) {
            immutableMap = ImmutableBiMap.b(Long.valueOf(this.f8251e.H_(e)), Integer.valueOf(this.f8252f.getChildAt(0).getTop()));
        }
        ScrollPosition scrollPosition = ScrollPosition.MIDDLE;
        if (mo360h()) {
            scrollPosition = ScrollPosition.BOTTOM;
        } else if (e == 0) {
            scrollPosition = ScrollPosition.TOP;
        }
        return new ScrollState(scrollPosition, immutableMap);
    }

    public final void mo348a(ScrollState scrollState) {
        int d = mo356d();
        if (scrollState.a == ScrollPosition.BOTTOM) {
            this.f8249c.e(d - 1);
            return;
        }
        for (int i = 1; i < d; i++) {
            Integer num = (Integer) scrollState.b.get(Long.valueOf(this.f8251e.H_(i)));
            if (num != null) {
                Integer.valueOf(i);
                this.f8249c.d(i, num.intValue());
                return;
            }
        }
    }

    public final void mo364l() {
        this.f8251e.m6908a(RegularImmutableList.a);
    }

    public final void mo336a(FragmentManager fragmentManager) {
        this.f8250d.f7182H = fragmentManager;
    }

    public final SendMessageAnimationManager mo365m() {
        return this.f8250d.f7193l;
    }

    public final MessageDetailViewManager mo366n() {
        return this.f8250d.f7196o;
    }

    public final HotLikesAnimationManager mo367o() {
        return this.f8250d.f7195n;
    }

    public final PaymentsAnimationManager mo368p() {
        return this.f8250d.f7197p;
    }

    public final GiftWrapAnimationManager mo369q() {
        return this.f8250d.f7194m;
    }

    public final void mo340a(Listener listener) {
        this.f8250d.f7175A = listener;
    }

    public final ScrollingViewProxy mo370r() {
        if (this.f8254h == null) {
            this.f8254h = new RecyclerViewProxy(this.f8252f);
        }
        return this.f8254h;
    }

    public final void mo347a(MessageListAccessibilityDelegate messageListAccessibilityDelegate) {
        if (this.f8252f != null) {
            if (messageListAccessibilityDelegate != null) {
                messageListAccessibilityDelegate.d = this.f8252f;
            }
            ViewCompat.a(this.f8252f, messageListAccessibilityDelegate);
        }
    }
}
