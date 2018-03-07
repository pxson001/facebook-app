package com.facebook.messaging.composershortcuts;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.composershortcuts.ComposerShortcutsContainerLogic.C11621;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.recyclerview.RecyclerViewScrollPosition;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets.4;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: message_view */
public class OverflowComposerShortcutsAdapter extends Adapter<ViewHolder> {
    public static final String f10126a = OverflowComposerShortcutsAdapter.class.getName();
    private static final CallerContext f10127b = CallerContext.a(OverflowComposerShortcutsAdapter.class);
    private final Context f10128c;
    private final ComposerShortcutsManager f10129d;
    private final ComposerButtonColorUtil f10130e;
    private final Executor f10131f;
    private final FbSharedPreferences f10132g;
    private final Clock f10133h;
    private final Provider<Boolean> f10134i;
    private final Provider<Boolean> f10135j;
    private final OverflowComposerShortcutItemViewHolderProvider f10136k;
    private final DefaultAndroidThreadUtil f10137l;
    private final List<Object> f10138m = Lists.a();
    private final C11681 f10139n = new C11681(this);
    private final Map<String, RecyclerViewScrollPosition> f10140o = Maps.c();
    private ImmutableSet<String> f10141p = RegularImmutableSet.a;
    public ImmutableMap<String, ImmutableList<PlatformSampleContent>> f10142q = RegularImmutableBiMap.a;
    public FutureAndCallbackHolder f10143r;
    public C11621 f10144s;

    /* compiled from: message_view */
    public class C11681 {
        public final /* synthetic */ OverflowComposerShortcutsAdapter f10120a;

        C11681(OverflowComposerShortcutsAdapter overflowComposerShortcutsAdapter) {
            this.f10120a = overflowComposerShortcutsAdapter;
        }
    }

    /* compiled from: message_view */
    class C11714 extends AbstractDisposableFutureCallback<ImmutableMap<String, ImmutableList<PlatformSampleContent>>> {
        final /* synthetic */ OverflowComposerShortcutsAdapter f10125a;

        C11714(OverflowComposerShortcutsAdapter overflowComposerShortcutsAdapter) {
            this.f10125a = overflowComposerShortcutsAdapter;
        }

        protected final void m10598a(Object obj) {
            ImmutableMap immutableMap = (ImmutableMap) obj;
            this.f10125a.f10143r = null;
            this.f10125a.f10142q = immutableMap;
            this.f10125a.notifyDataSetChanged();
        }

        protected final void m10599a(Throwable th) {
            BLog.b(OverflowComposerShortcutsAdapter.f10126a, "Exception while fetching sample content", th);
            this.f10125a.f10143r = null;
        }
    }

    public static OverflowComposerShortcutsAdapter m10602b(InjectorLike injectorLike) {
        return new OverflowComposerShortcutsAdapter((Context) injectorLike.getInstance(Context.class), ComposerShortcutsManagerMethodAutoProvider.m10561b(injectorLike), ComposerButtonColorUtil.m10509a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4049), IdBasedProvider.a(injectorLike, 4139), (OverflowComposerShortcutItemViewHolderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(OverflowComposerShortcutItemViewHolderProvider.class), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public OverflowComposerShortcutsAdapter(Context context, ComposerShortcutsManager composerShortcutsManager, ComposerButtonColorUtil composerButtonColorUtil, Executor executor, FbSharedPreferences fbSharedPreferences, Clock clock, Provider<Boolean> provider, Provider<Boolean> provider2, OverflowComposerShortcutItemViewHolderProvider overflowComposerShortcutItemViewHolderProvider, AndroidThreadUtil androidThreadUtil) {
        this.f10128c = context;
        this.f10129d = composerShortcutsManager;
        this.f10130e = composerButtonColorUtil;
        this.f10131f = executor;
        this.f10132g = fbSharedPreferences;
        this.f10133h = clock;
        this.f10134i = provider;
        this.f10135j = provider2;
        this.f10136k = overflowComposerShortcutItemViewHolderProvider;
        this.f10137l = androidThreadUtil;
    }

    public final void m10607a(List<ComposerShortcutItem> list) {
        this.f10137l.a();
        this.f10138m.clear();
        boolean z = false;
        for (ComposerShortcutItem composerShortcutItem : list) {
            if (!(composerShortcutItem.f9982k || composerShortcutItem.f9981j || r1)) {
                this.f10138m.add(new String(this.f10128c.getResources().getString(2131230979)));
                z = true;
            }
            this.f10138m.add(composerShortcutItem);
        }
        ImmutableList copyOf = ImmutableList.copyOf(list);
        Builder builder = ImmutableSet.builder();
        int size = copyOf.size();
        for (int i = 0; i < size; i++) {
            ComposerShortcutItem composerShortcutItem2 = (ComposerShortcutItem) copyOf.get(i);
            if (composerShortcutItem2.f9989r) {
                builder.c(composerShortcutItem2.f9973b);
            }
        }
        Set b = builder.b();
        ImmutableSet immutableSet = this.f10141p;
        Preconditions.checkNotNull(b, "set1");
        Preconditions.checkNotNull(immutableSet, "set2");
        if (!new 4(b, immutableSet).isEmpty()) {
            if (this.f10143r != null) {
                this.f10143r.a(true);
                this.f10143r = null;
            }
            this.f10142q = RegularImmutableBiMap.a;
            m10603d();
        }
        this.f10141p = b;
        notifyDataSetChanged();
    }

    public final ViewHolder m10604a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.f10128c);
        if (i == 0 || i == 1) {
            OverflowComposerShortcutItemView overflowComposerShortcutItemView = new OverflowComposerShortcutItemView(this.f10128c);
            overflowComposerShortcutItemView.setLayoutParams(new LayoutParams(-1, -2));
            return new OverflowComposerShortcutItemViewHolder(new PlatformContentAdapter((PlatformContentViewHolderProvider) this.f10136k.getOnDemandAssistedProviderForStaticDi(PlatformContentViewHolderProvider.class)), overflowComposerShortcutItemView);
        } else if (i == 2) {
            return new OverflowComposerBannerViewHolder(from.inflate(2130905941, viewGroup, false));
        } else {
            throw new IllegalArgumentException("Invalid view type for creating view holder.");
        }
    }

    public final void m10606a(ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0 || itemViewType == 1) {
            m10600a((OverflowComposerShortcutItemViewHolder) viewHolder, (ComposerShortcutItem) this.f10138m.get(i));
        } else if (itemViewType == 2) {
            ((OverflowComposerBannerViewHolder) viewHolder).f10108l.setText((String) this.f10138m.get(i));
        } else {
            throw new IllegalArgumentException("Invalid view type for binding view holder.");
        }
    }

    private void m10600a(final OverflowComposerShortcutItemViewHolder overflowComposerShortcutItemViewHolder, final ComposerShortcutItem composerShortcutItem) {
        int i = 1;
        int i2 = (composerShortcutItem.f9981j || composerShortcutItem.f9982k) ? 0 : 1;
        Resources resources = this.f10128c.getResources();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        if (!composerShortcutItem.f9981j) {
            genericDraweeHierarchyBuilder.u = RoundingParams.e();
        }
        overflowComposerShortcutItemViewHolder.f10111l.setHierarchy(genericDraweeHierarchyBuilder.u());
        if (composerShortcutItem.f9975d != 0) {
            overflowComposerShortcutItemViewHolder.f10111l.setImageDrawable(resources.getDrawable(composerShortcutItem.f9975d));
        } else {
            overflowComposerShortcutItemViewHolder.f10111l.a(Uri.parse(composerShortcutItem.f9976e), f10127b);
        }
        if (composerShortcutItem.f9987p) {
            overflowComposerShortcutItemViewHolder.f10111l.setColorFilter(this.f10130e.m10514a(composerShortcutItem.f9973b));
        } else {
            overflowComposerShortcutItemViewHolder.f10111l.setColorFilter(null);
        }
        overflowComposerShortcutItemViewHolder.f10112m.setText(composerShortcutItem.f9978g);
        overflowComposerShortcutItemViewHolder.f10115p.setVisibility(8);
        overflowComposerShortcutItemViewHolder.f10112m.setTypeface(null, 0);
        if (i2 == 0 || composerShortcutItem.f9979h == null || composerShortcutItem.f9979h.isEmpty()) {
            overflowComposerShortcutItemViewHolder.f10113n.setVisibility(8);
            if (m10601a(composerShortcutItem)) {
                overflowComposerShortcutItemViewHolder.f10115p.setVisibility(0);
                overflowComposerShortcutItemViewHolder.f10112m.setTypeface(overflowComposerShortcutItemViewHolder.f10112m.getTypeface(), 1);
            }
        } else {
            overflowComposerShortcutItemViewHolder.f10113n.setVisibility(0);
            overflowComposerShortcutItemViewHolder.f10113n.setText(composerShortcutItem.f9979h);
        }
        FbTextView fbTextView = overflowComposerShortcutItemViewHolder.f10114o;
        if (i2 != 0) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        fbTextView.setVisibility(i2);
        overflowComposerShortcutItemViewHolder.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OverflowComposerShortcutsAdapter f10122b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1830280022);
                if (this.f10122b.f10144s != null) {
                    C11621 c11621 = this.f10122b.f10144s;
                    ComposerShortcutItem composerShortcutItem = composerShortcutItem;
                    ComposerShortcutsContainerLogic.m10535a(c11621.f10016a, composerShortcutItem);
                    ComposerShortcutsAnalyticsLogger composerShortcutsAnalyticsLogger = c11621.f10016a.f10025b;
                    composerShortcutsAnalyticsLogger.f10011a.a(ComposerShortcutsAnalyticsLogger.m10531e("select_composer_shortcut_from_overflow").b("shortcut_id", composerShortcutItem.f9973b));
                    c11621.f10016a.m10555g();
                }
                Logger.a(2, EntryType.UI_INPUT_END, -80137029, a);
            }
        });
        overflowComposerShortcutItemViewHolder.f10119t = composerShortcutItem.f9973b;
        ImmutableList immutableList = (ImmutableList) this.f10142q.get(composerShortcutItem.f9973b);
        if (immutableList == null) {
            immutableList = RegularImmutableList.a;
        }
        if (composerShortcutItem.f9989r) {
            PlatformContentAdapter platformContentAdapter = overflowComposerShortcutItemViewHolder.f10118s;
            platformContentAdapter.f10158b = immutableList;
            platformContentAdapter.notifyDataSetChanged();
            overflowComposerShortcutItemViewHolder.f10117r.setVisibility(immutableList.isEmpty() ? 8 : 0);
            overflowComposerShortcutItemViewHolder.f10117r.requestLayout();
        }
        overflowComposerShortcutItemViewHolder.m10596a((RecyclerViewScrollPosition) this.f10140o.get(composerShortcutItem.f9973b));
        overflowComposerShortcutItemViewHolder.f10117r.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ OverflowComposerShortcutsAdapter f10124b;

            public final void m10597a(RecyclerView recyclerView, int i) {
                if (this.f10124b.f10144s != null) {
                    C11621 c11621;
                    if (i == 1) {
                        c11621 = this.f10124b.f10144s;
                        c11621.f10016a.f10044u.b.c.add(overflowComposerShortcutItemViewHolder.a);
                        return;
                    }
                    c11621 = this.f10124b.f10144s;
                    c11621.f10016a.f10044u.b.c.remove(overflowComposerShortcutItemViewHolder.a);
                }
            }
        });
        overflowComposerShortcutItemViewHolder.f10118s.f10159c = this.f10139n;
        if (!(((Boolean) this.f10135j.get()).booleanValue() && composerShortcutItem.f9989r)) {
            i = 0;
        }
        overflowComposerShortcutItemViewHolder.f10117r.setVisibility(i != 0 ? 0 : 8);
    }

    public final void a_(RecyclerView recyclerView) {
        RecycledViewPool recycledViewPool = recyclerView.getRecycledViewPool();
        recycledViewPool.a(2, 20);
        recycledViewPool.a(0, 20);
        recycledViewPool.a(1, 20);
    }

    public final void m10605a(ViewHolder viewHolder) {
        if (viewHolder instanceof OverflowComposerShortcutItemViewHolder) {
            OverflowComposerShortcutItemViewHolder overflowComposerShortcutItemViewHolder = (OverflowComposerShortcutItemViewHolder) viewHolder;
            Map map = this.f10140o;
            String str = overflowComposerShortcutItemViewHolder.f10119t;
            OverflowComposerShortcutItemView overflowComposerShortcutItemView = overflowComposerShortcutItemViewHolder.f10116q;
            int i = 0;
            int l = overflowComposerShortcutItemView.f10110b.l();
            if (overflowComposerShortcutItemView.f10109a.getChildCount() != 0) {
                i = overflowComposerShortcutItemView.f10109a.getChildAt(0).getLeft() - overflowComposerShortcutItemView.f10109a.getPaddingLeft();
            }
            map.put(str, new RecyclerViewScrollPosition(l, i));
        }
    }

    public int getItemViewType(int i) {
        Object obj = this.f10138m.get(i);
        if (obj instanceof ComposerShortcutItem) {
            return ((ComposerShortcutItem) obj).f9989r ? 1 : 0;
        } else {
            return 2;
        }
    }

    public final int aZ_() {
        return this.f10138m.size();
    }

    private boolean m10601a(ComposerShortcutItem composerShortcutItem) {
        boolean z;
        long a = this.f10132g.a(MessengerComposerShortcutsManager.f10072d, 0);
        long a2 = this.f10132g.a(MessengerComposerShortcutsManager.f10071c, 0);
        if (a < composerShortcutItem.f9984m) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (composerShortcutItem.f9981j) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean z3;
        if (this.f10133h.a() < a2 + 432000000) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean booleanValue = ((Boolean) this.f10134i.get()).booleanValue();
        if (z && r4 && r5 && booleanValue) {
            return true;
        }
        return false;
    }

    private void m10603d() {
        this.f10137l.a();
        ListenableFuture a = this.f10129d.mo407a();
        C11714 c11714 = new C11714(this);
        Futures.a(a, c11714, this.f10131f);
        this.f10143r = FutureAndCallbackHolder.a(a, c11714);
    }
}
