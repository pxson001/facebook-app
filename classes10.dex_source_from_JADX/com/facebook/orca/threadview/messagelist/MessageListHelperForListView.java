package com.facebook.orca.threadview.messagelist;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.orca.threadview.AnimatingListAdapterForMessageList;
import com.facebook.orca.threadview.GiftWrapAnimationManager;
import com.facebook.orca.threadview.InterRowItemAnimationFactory;
import com.facebook.orca.threadview.MessageDetailViewManager;
import com.facebook.orca.threadview.MessageListAdapter;
import com.facebook.orca.threadview.MessageListAdapter.Listener;
import com.facebook.orca.threadview.MessageListAdapterForListView;
import com.facebook.orca.threadview.MessageListAdapterForListViewProvider;
import com.facebook.orca.threadview.MessagesListViewScrollDeltaHelper;
import com.facebook.orca.threadview.PaymentsAnimationManager;
import com.facebook.orca.threadview.SendMessageAnimationManager;
import com.facebook.orca.threadview.ThreadViewMessagesAdapterUpdater;
import com.facebook.orca.threadview.ThreadViewMessagesAdapterUpdaterProvider;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass14;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.BotPromptViewListener;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.EmojilikePickerViewListener;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.MessageListListener;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.NicknamePromptViewListener;
import com.facebook.orca.threadview.ThreadViewMessagesListView;
import com.facebook.orca.threadview.ThreadViewMessagesListView.Decoration;
import com.facebook.orca.threadview.abtest.ThreadViewReducedAnimationExperimentController;
import com.facebook.orca.threadview.hotlikes.HotLikesAnimationManager;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.animatablelistview.AnimatingListMutation;
import com.facebook.widget.animatablelistview.AnimatingListMutation.MutationType;
import com.facebook.widget.animatablelistview.AnimatingListTransactionBuilder;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollState;
import com.facebook.widget.listview.ScrollState.ScrollPosition;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mark unread */
public class MessageListHelperForListView implements MessageListHelper {
    private static final Interpolator f8226a = new DecelerateInterpolator(1.2f);
    private final AnalyticsTagger f8227b;
    private final Context f8228c;
    private final AbstractFbErrorReporter f8229d;
    private final Handler f8230e;
    private final MessageListAdapter f8231f;
    private final MessageListAdapterForListView f8232g;
    private final ThreadViewMessagesAdapterUpdaterProvider f8233h;
    private final UserTileViewParamsFactory f8234i;
    private final ThreadViewReducedAnimationExperimentController f8235j;
    @Nullable
    public ThreadViewMessagesListView f8236k;
    @Nullable
    private ListViewProxy f8237l;
    private ThreadViewMessagesAdapterUpdater f8238m;
    public MessagesListViewScrollDeltaHelper f8239n;
    private BaseAdapter f8240o;
    private FrameLayout f8241p;
    @Nullable
    public MessageListListener f8242q;
    private DataSetObserver f8243r = new C12321(this);

    /* compiled from: mark unread */
    class C12321 extends DataSetObserver {
        final /* synthetic */ MessageListHelperForListView f8221a;

        C12321(MessageListHelperForListView messageListHelperForListView) {
            this.f8221a = messageListHelperForListView;
        }

        public void onChanged() {
            if (this.f8221a.f8242q != null) {
                this.f8221a.f8242q.m7500b();
            }
        }

        public void onInvalidated() {
            if (this.f8221a.f8242q != null) {
                this.f8221a.f8242q.m7500b();
            }
        }
    }

    /* compiled from: mark unread */
    class C12332 implements OnScrollListener {
        final /* synthetic */ MessageListHelperForListView f8222a;

        C12332(MessageListHelperForListView messageListHelperForListView) {
            this.f8222a = messageListHelperForListView;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (this.f8222a.f8242q != null) {
                this.f8222a.f8242q.mo332a(i);
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.f8222a.f8242q != null) {
                this.f8222a.f8242q.m7498a(absListView, i, i2, i3, i3 != 0 ? this.f8222a.f8239n.m6920a(i2, i3) : -1);
            }
        }
    }

    /* compiled from: mark unread */
    class C12343 implements OnDrawListener {
        final /* synthetic */ MessageListHelperForListView f8223a;

        C12343(MessageListHelperForListView messageListHelperForListView) {
            this.f8223a = messageListHelperForListView;
        }

        public final boolean gD_() {
            return this.f8223a.f8242q != null && this.f8223a.f8242q.m7499a();
        }
    }

    public static MessageListHelperForListView m8150b(InjectorLike injectorLike) {
        return new MessageListHelperForListView(AnalyticsTagger.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), MessageListAdapter.m6861b(injectorLike), (MessageListAdapterForListViewProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MessageListAdapterForListViewProvider.class), (ThreadViewMessagesAdapterUpdaterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ThreadViewMessagesAdapterUpdaterProvider.class), UserTileViewParamsFactory.a(injectorLike), new ThreadViewReducedAnimationExperimentController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public MessageListHelperForListView(AnalyticsTagger analyticsTagger, Context context, AbstractFbErrorReporter abstractFbErrorReporter, MessageListAdapter messageListAdapter, MessageListAdapterForListViewProvider messageListAdapterForListViewProvider, ThreadViewMessagesAdapterUpdaterProvider threadViewMessagesAdapterUpdaterProvider, UserTileViewParamsFactory userTileViewParamsFactory, ThreadViewReducedAnimationExperimentController threadViewReducedAnimationExperimentController) {
        this.f8227b = analyticsTagger;
        this.f8228c = context;
        this.f8229d = abstractFbErrorReporter;
        this.f8231f = messageListAdapter;
        this.f8232g = new MessageListAdapterForListView((Context) messageListAdapterForListViewProvider.getInstance(Context.class), MessageListViewTypeHelper.m8236b(messageListAdapterForListViewProvider), messageListAdapter);
        this.f8233h = threadViewMessagesAdapterUpdaterProvider;
        this.f8234i = userTileViewParamsFactory;
        this.f8235j = threadViewReducedAnimationExperimentController;
        this.f8230e = new Handler(Looper.getMainLooper());
    }

    public final void mo337a(FrameLayout frameLayout, ViewStub viewStub) {
        this.f8241p = frameLayout;
        viewStub.setLayoutResource(2130905227);
        this.f8236k = (ThreadViewMessagesListView) viewStub.inflate();
        this.f8239n = new MessagesListViewScrollDeltaHelper(this.f8236k);
        if (this.f8235j.m8073a()) {
            this.f8240o = this.f8232g;
        } else {
            AnimatingListAdapterForMessageList animatingListAdapterForMessageList = new AnimatingListAdapterForMessageList(this.f8228c, this.f8236k, this.f8232g, this.f8229d, this.f8227b);
            animatingListAdapterForMessageList.s = 200;
            animatingListAdapterForMessageList.t = f8226a;
            this.f8240o = animatingListAdapterForMessageList;
        }
        this.f8236k.setAdapter(this.f8240o);
        this.f8236k.setStackFromBottom(true);
        this.f8236k.setTranscriptMode(1);
        this.f8236k.setItemsCanFocus(true);
        this.f8236k.setBroadcastInteractionChanges(true);
        this.f8236k.setOnScrollListener(new C12332(this));
        this.f8236k.setOnDrawListenerTo(new C12343(this));
        this.f8238m = this.f8233h.m7400a(this.f8240o, this.f8235j, new InterRowItemAnimationFactory(this.f8228c, this.f8236k, this.f8241p, LayoutInflater.from(this.f8228c), this.f8234i, 200));
    }

    public final void mo344a(MessageListListener messageListListener) {
        this.f8242q = messageListListener;
    }

    public final void mo341a(AnonymousClass14 anonymousClass14) {
        this.f8231f.f7176B = anonymousClass14;
    }

    public final void mo343a(EmojilikePickerViewListener emojilikePickerViewListener) {
        this.f8231f.f7177C = emojilikePickerViewListener;
    }

    public final void mo345a(NicknamePromptViewListener nicknamePromptViewListener) {
        this.f8231f.f7178D = nicknamePromptViewListener;
    }

    public final void mo342a(BotPromptViewListener botPromptViewListener) {
        this.f8231f.f7179E = botPromptViewListener;
    }

    @Nullable
    public final ViewGroup mo334a() {
        return this.f8236k;
    }

    public final RowItem mo335a(int i) {
        return (RowItem) this.f8240o.getItem(i);
    }

    public final void mo351b() {
        if (this.f8236k != null) {
            this.f8236k.d();
        }
    }

    public final boolean mo355c() {
        return this.f8240o.isEmpty();
    }

    public final int mo356d() {
        return this.f8236k.getCount();
    }

    public final int mo357e() {
        return this.f8236k.getFirstVisiblePosition();
    }

    public final int mo358f() {
        return this.f8236k.getLastVisiblePosition();
    }

    public final void mo346a(Decoration decoration) {
        this.f8236k.m7866a(decoration);
    }

    public final void mo353b(Decoration decoration) {
        this.f8236k.m7867b(decoration);
    }

    public final void mo350a(boolean z) {
        this.f8238m.f7686h.f7364a = z;
        if (z) {
            this.f8240o.registerDataSetObserver(this.f8243r);
        } else {
            this.f8240o.unregisterDataSetObserver(this.f8243r);
        }
    }

    public final void mo338a(DefaultThreadViewTheme defaultThreadViewTheme) {
        this.f8231f.m6887a(defaultThreadViewTheme);
    }

    public final void mo359g() {
        if (this.f8236k != null) {
            int count = this.f8236k.getCount();
            if (count > 0 && !mo360h()) {
                if (count - this.f8236k.getLastVisiblePosition() > this.f8236k.getChildCount()) {
                    this.f8236k.setSelection(count - 1);
                } else {
                    this.f8236k.smoothScrollToPosition(count - 1);
                }
                m8151c(this.f8236k.getCount() - 1);
            }
        }
    }

    public final void mo352b(int i) {
        if (this.f8236k != null) {
            this.f8236k.smoothScrollToPositionFromTop(i, 0);
            m8151c(i);
        }
    }

    private void m8151c(final int i) {
        HandlerDetour.b(this.f8230e, new Runnable(this) {
            final /* synthetic */ MessageListHelperForListView f8225b;

            public void run() {
                this.f8225b.f8236k.setSelection(i);
            }
        }, 200, -372628252);
    }

    public final boolean mo360h() {
        return this.f8236k != null && this.f8236k.b();
    }

    public final void mo354b(boolean z) {
        this.f8238m.f7680b = z;
    }

    public final void mo339a(@Nullable RowItem rowItem) {
        int i = 1;
        int i2 = m8152s() != null ? 1 : 0;
        Builder builder = ImmutableList.builder();
        if (rowItem != null) {
            builder.c(rowItem);
        }
        ImmutableList a = this.f8232g.m6897a();
        if (i2 == 0) {
            i = 0;
        }
        builder.b(a.subList(i, a.size()));
        this.f8232g.m6899b(builder.b());
        if (this.f8235j.m8073a()) {
            MessageListAdapterForListView messageListAdapterForListView = (MessageListAdapterForListView) this.f8240o;
            if (i2 != 0) {
                messageListAdapterForListView.m6899b(messageListAdapterForListView.m6897a().subList(1, messageListAdapterForListView.getCount()));
            }
            if (rowItem != null) {
                messageListAdapterForListView.m6899b(ImmutableList.builder().c(rowItem).b(messageListAdapterForListView.m6897a()).b());
                return;
            }
            return;
        }
        AnimatingListTransactionBuilder a2 = ((AnimatingListAdapterForMessageList) this.f8240o).a();
        if (i2 != 0) {
            a2.c(0);
        }
        if (rowItem != null) {
            Integer.valueOf(0);
            a2.e.add(new AnimatingListMutation(ImmutableList.of(rowItem), MutationType.ADD, 0));
            a2.d.add(0, rowItem);
        }
        a2.a();
    }

    private RowItem m8152s() {
        if (this.f8240o.isEmpty()) {
            return null;
        }
        RowItem rowItem = (RowItem) this.f8240o.getItem(0);
        if (rowItem == MessageListAdapter.f7172a || rowItem == MessageListAdapter.f7173b || rowItem == MessageListAdapter.f7174c) {
            return rowItem;
        }
        return null;
    }

    public final void mo349a(List<RowItem> list) {
        TracerDetour.a("MessageListHelperForListView.updateAdapter", -783287452);
        try {
            this.f8238m.m7399a((List) list);
        } finally {
            TracerDetour.a(1766314724);
        }
    }

    public final ImmutableList<RowItem> mo361i() {
        if (this.f8235j.m8073a()) {
            return ((MessageListAdapterForListView) this.f8240o).m6897a();
        }
        return ((AnimatingListAdapterForMessageList) this.f8240o).d();
    }

    public final ImmutableList<RowItem> mo362j() {
        if (this.f8235j.m8073a()) {
            return ((MessageListAdapterForListView) this.f8240o).m6897a();
        }
        return ((AnimatingListAdapterForMessageList) this.f8240o).o;
    }

    @Nullable
    public final ScrollState mo363k() {
        if (this.f8236k == null) {
            return null;
        }
        return this.f8236k.getScrollState();
    }

    public final void mo348a(ScrollState scrollState) {
        if (this.f8236k != null) {
            if (scrollState.a == ScrollPosition.BOTTOM) {
                this.f8236k.setSelection(this.f8236k.getCount() - 1);
                return;
            }
            for (int i = 1; i < this.f8240o.getCount(); i++) {
                Integer num = (Integer) scrollState.b.get(Long.valueOf(this.f8240o.getItemId(i)));
                if (num != null) {
                    Integer.valueOf(i);
                    this.f8236k.setSelectionFromTop(i, num.intValue());
                    return;
                }
            }
        }
    }

    public final void mo364l() {
        if (this.f8240o != null && !this.f8235j.m8073a()) {
            AnimatingListAdapterForMessageList animatingListAdapterForMessageList = (AnimatingListAdapterForMessageList) this.f8240o;
            animatingListAdapterForMessageList.b();
            animatingListAdapterForMessageList.i();
        }
    }

    public final void mo336a(FragmentManager fragmentManager) {
        this.f8231f.f7182H = fragmentManager;
    }

    public final SendMessageAnimationManager mo365m() {
        return this.f8231f.f7193l;
    }

    public final MessageDetailViewManager mo366n() {
        return this.f8231f.f7196o;
    }

    public final HotLikesAnimationManager mo367o() {
        return this.f8231f.f7195n;
    }

    public final PaymentsAnimationManager mo368p() {
        return this.f8231f.f7197p;
    }

    public final GiftWrapAnimationManager mo369q() {
        return this.f8231f.f7194m;
    }

    public final void mo340a(Listener listener) {
        this.f8231f.f7175A = listener;
    }

    public final ScrollingViewProxy mo370r() {
        if (this.f8237l == null) {
            this.f8237l = new ListViewProxy(this.f8236k);
        }
        return this.f8237l;
    }

    public final void mo347a(MessageListAccessibilityDelegate messageListAccessibilityDelegate) {
        if (this.f8236k != null) {
            if (messageListAccessibilityDelegate != null) {
                messageListAccessibilityDelegate.d = this.f8236k;
            }
            ViewCompat.a(this.f8236k, messageListAccessibilityDelegate);
        }
    }
}
