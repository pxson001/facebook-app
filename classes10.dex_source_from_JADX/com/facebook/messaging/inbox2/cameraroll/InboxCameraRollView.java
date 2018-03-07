package com.facebook.messaging.inbox2.cameraroll;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.loader.AbstractFbLoaderCallback;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.inbox2.items.InboxUnitItemViewWithState;
import com.facebook.messaging.inbox2.items.InboxUnitViewWithRecyclerView;
import com.facebook.messaging.inbox2.sharing.ShareFlowSelectorView;
import com.facebook.messaging.inbox2.sharing.UserSelectionListener;
import com.facebook.messaging.media.loader.LocalMediaLoader;
import com.facebook.messaging.media.loader.LocalMediaLoaderParams;
import com.facebook.messaging.send.common.SendResult;
import com.facebook.orca.threadlist.ThreadListAdapter.C09886;
import com.facebook.orca.threadlist.ThreadListFragment;
import com.facebook.orca.threadlist.ThreadListFragment.AnonymousClass18;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.user.model.User;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: setRowMessageItem */
public class InboxCameraRollView extends CustomLinearLayout implements InboxUnitItemViewWithState, InboxUnitViewWithRecyclerView {
    public static final Class<?> f2718e = InboxCameraRollView.class;
    public static final SpringConfig f2719f = new SpringConfig(1000.0d, 50.0d);
    @Inject
    public LocalMediaLoader f2720a;
    @Inject
    public InboxCameraRollAdapter f2721b;
    @Inject
    public AbstractFbErrorReporter f2722c;
    @Inject
    public SpringSystem f2723d;
    public Spring f2724g;
    public int f2725h;
    public int f2726i;
    public int f2727j;
    public BetterRecyclerView f2728k;
    public ShareFlowSelectorView f2729l;
    public LinearLayoutManager f2730m;
    @Nullable
    public ImmutableList<MediaResource> f2731n;
    public CameraRollInboxItem f2732o;
    @Nullable
    public C09886 f2733p;

    /* compiled from: setRowMessageItem */
    public class C04481 extends SimpleSpringListener {
        final /* synthetic */ InboxCameraRollView f2713a;

        public C04481(InboxCameraRollView inboxCameraRollView) {
            this.f2713a = inboxCameraRollView;
        }

        public final void m2683a(Spring spring) {
            float d = (float) spring.d();
            int i = (int) (((float) this.f2713a.f2725h) * d);
            this.f2713a.f2729l.setVisibility(d == 0.0f ? 8 : 0);
            this.f2713a.f2729l.getLayoutParams().height = i;
            this.f2713a.f2729l.requestLayout();
        }
    }

    /* compiled from: setRowMessageItem */
    public class C04492 extends ItemDecoration {
        final /* synthetic */ InboxCameraRollView f2714a;

        public C04492(InboxCameraRollView inboxCameraRollView) {
            this.f2714a = inboxCameraRollView;
        }

        public final void m2684a(Rect rect, View view, RecyclerView recyclerView, State state) {
            int d = RecyclerView.d(view);
            rect.set(d == 0 ? this.f2714a.f2726i : 0, 0, d == state.e() + -1 ? this.f2714a.f2726i : this.f2714a.f2727j, 0);
        }
    }

    /* compiled from: setRowMessageItem */
    public class C04503 {
        public final /* synthetic */ InboxCameraRollView f2715a;

        public C04503(InboxCameraRollView inboxCameraRollView) {
            this.f2715a = inboxCameraRollView;
        }

        public final void m2685a(ImmutableSet<MediaResource> immutableSet) {
            InboxCameraRollView inboxCameraRollView = this.f2715a;
            if (immutableSet.isEmpty()) {
                inboxCameraRollView.f2724g.b(0.0d);
                return;
            }
            CharSequence quantityString = inboxCameraRollView.getResources().getQuantityString(2131689794, immutableSet.size(), new Object[]{Integer.valueOf(immutableSet.size())});
            inboxCameraRollView.f2729l.a();
            inboxCameraRollView.f2729l.setSendButtonText(quantityString);
            inboxCameraRollView.f2725h = inboxCameraRollView.f2729l.getShareViewHeight();
            inboxCameraRollView.f2724g.b(1.0d);
        }
    }

    /* compiled from: setRowMessageItem */
    public class C04514 implements UserSelectionListener {
        final /* synthetic */ InboxCameraRollView f2716a;

        public C04514(InboxCameraRollView inboxCameraRollView) {
            this.f2716a = inboxCameraRollView;
        }

        public final void m2687a(User user, FutureCallback<SendResult> futureCallback) {
            if (this.f2716a.f2733p != null) {
                C09886 c09886 = this.f2716a.f2733p;
                ImmutableSet d = this.f2716a.f2721b.m2667d();
                if (c09886.f6558c.f6573j != null) {
                    c09886.f6558c.f6573j.m6290a(d, c09886.f6556a, c09886.f6557b, user, futureCallback);
                }
            }
        }

        public final void m2686a() {
            if (this.f2716a.f2733p != null) {
                C09886 c09886 = this.f2716a.f2733p;
                ImmutableSet d = this.f2716a.f2721b.m2667d();
                if (c09886.f6558c.f6573j != null) {
                    AnonymousClass18 anonymousClass18 = c09886.f6558c.f6573j;
                    InboxItem inboxItem = c09886.f6556a;
                    int i = c09886.f6557b;
                    ThreadListFragment.m6335a(anonymousClass18.f6606a, ImmutableList.copyOf(d), ThreadListFragment.m6320a(anonymousClass18.f6606a, inboxItem));
                    anonymousClass18.f6606a.bB.m2624a(inboxItem, i);
                }
            }
        }
    }

    /* compiled from: setRowMessageItem */
    public class C04525 extends AbstractFbLoaderCallback<LocalMediaLoaderParams, ImmutableList<MediaResource>, Throwable> {
        final /* synthetic */ InboxCameraRollView f2717a;

        public C04525(InboxCameraRollView inboxCameraRollView) {
            this.f2717a = inboxCameraRollView;
        }

        public final void m2688b(Object obj, Object obj2) {
            InboxCameraRollView.setMediaItems(this.f2717a, (ImmutableList) obj2);
        }

        public final void m2689c(Object obj, Object obj2) {
            this.f2717a.f2722c.a(InboxCameraRollView.f2718e.getSimpleName(), (Throwable) obj2);
        }
    }

    public static void m2690a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        InboxCameraRollView inboxCameraRollView = (InboxCameraRollView) obj;
        LocalMediaLoader b = LocalMediaLoader.b(fbInjector);
        InboxCameraRollAdapter inboxCameraRollAdapter = new InboxCameraRollAdapter((Context) fbInjector.getInstance(Context.class));
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        SpringSystem b2 = SpringSystem.b(fbInjector);
        inboxCameraRollView.f2720a = b;
        inboxCameraRollView.f2721b = inboxCameraRollAdapter;
        inboxCameraRollView.f2722c = abstractFbErrorReporter;
        inboxCameraRollView.f2723d = b2;
    }

    public InboxCameraRollView(Context context) {
        super(context);
        setOrientation(1);
        Class cls = InboxCameraRollView.class;
        m2690a(this, getContext());
        LayoutInflater.from(getContext()).inflate(2130904860, this);
        this.f2728k = (BetterRecyclerView) a(2131563086);
        this.f2729l = (ShareFlowSelectorView) a(2131563087);
        this.f2726i = getResources().getDimensionPixelSize(2131433866);
        this.f2727j = getResources().getDimensionPixelSize(2131433865);
        this.f2724g = this.f2723d.a().a(f2719f).a(new C04481(this));
        this.f2724g.c = true;
        getContext();
        this.f2730m = new LinearLayoutManager(0, false);
        this.f2728k.setLayoutManager(this.f2730m);
        this.f2728k.a(new C04492(this));
        this.f2721b.f2701e = new C04503(this);
        this.f2729l.c = new C04514(this);
        this.f2728k.setAdapter(this.f2721b);
        this.f2720a.a(new C04525(this));
    }

    public static void setMediaItems(InboxCameraRollView inboxCameraRollView, ImmutableList immutableList) {
        inboxCameraRollView.f2720a.a();
        inboxCameraRollView.f2731n = immutableList;
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            InboxCameraRollMediaItem inboxCameraRollMediaItem = new InboxCameraRollMediaItem(inboxCameraRollView.f2732o.d, (MediaResource) immutableList.get(i));
            int i3 = i2 + 1;
            inboxCameraRollMediaItem.a(i2);
            builder.c(inboxCameraRollMediaItem);
            i++;
            i2 = i3;
        }
        InboxCameraRollAdapter inboxCameraRollAdapter = inboxCameraRollView.f2721b;
        inboxCameraRollAdapter.f2699c = builder.b();
        inboxCameraRollAdapter.f2700d.clear();
        if (inboxCameraRollAdapter.f2701e != null) {
            inboxCameraRollAdapter.f2701e.m2685a(inboxCameraRollAdapter.m2667d());
        }
        inboxCameraRollView.f2721b.notifyDataSetChanged();
    }

    public BetterRecyclerView getRecyclerView() {
        return this.f2728k;
    }

    public InboxAdapter getInboxAdapter() {
        return this.f2721b;
    }

    public InboxUnitItem getInboxUnitItem() {
        return this.f2732o;
    }

    public final Bundle m2691a() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("layout_manager_state", this.f2730m.f());
        if (this.f2731n != null) {
            bundle.putParcelableArrayList("all_items_state", new ArrayList(this.f2731n));
            bundle.putParcelableArrayList("selected_items_state", new ArrayList(this.f2721b.m2667d()));
        }
        return bundle;
    }

    public final void m2692a(Bundle bundle) {
        Collection parcelableArrayList = bundle.getParcelableArrayList("all_items_state");
        if (parcelableArrayList != null) {
            setMediaItems(this, ImmutableList.copyOf(parcelableArrayList));
        }
        Collection<MediaResource> parcelableArrayList2 = bundle.getParcelableArrayList("selected_items_state");
        if (parcelableArrayList2 != null) {
            InboxCameraRollAdapter inboxCameraRollAdapter = this.f2721b;
            inboxCameraRollAdapter.f2700d.clear();
            for (MediaResource wrap : parcelableArrayList2) {
                inboxCameraRollAdapter.f2700d.add(InboxCameraRollAdapter.f2697a.wrap(wrap));
            }
            if (inboxCameraRollAdapter.f2701e != null) {
                inboxCameraRollAdapter.f2701e.m2685a(inboxCameraRollAdapter.m2667d());
            }
        }
        this.f2730m.a(bundle.getParcelable("layout_manager_state"));
    }
}
