package com.facebook.richdocument.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.facebook.common.idleexecutor.IdleExecutor_ForUiThreadMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentBlocksAppendedSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentBlocksErrorSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentStartupUiTasksCompletedSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksAppendedEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksErrorEvent;
import com.facebook.richdocument.genesis.BlockViewHolderFactory;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.Preloadable;
import com.facebook.richdocument.model.data.PreloadableBlock;
import com.facebook.richdocument.model.data.VideoBlockData;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.MapBlockPresenter;
import com.facebook.richdocument.view.block.impl.MapBlockViewImpl;
import com.facebook.richdocument.view.performance.BlocksPreInflater;
import com.facebook.richdocument.view.performance.BlocksPreInflaterProvider;
import com.facebook.richdocument.view.performance.IncrementalUiIdleJobManager;
import com.facebook.richdocument.view.performance.SingleTaskUiIdleJob;
import com.facebook.richdocument.view.performance.VideoParamsCreator;
import com.facebook.richdocument.view.recycler.RichDocumentCacheableLayoutManager;
import com.facebook.richdocument.view.viewholder.BlockViewHolder;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.viewadapterpreallocator.PreallocatingAdapter;
import com.google.common.collect.ImmutableBiMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: payments_component_dialog_fragment */
public class RichDocumentAdapter extends Adapter<ViewHolder> implements InjectableComponentWithContext, PreallocatingAdapter {
    private boolean f6493A = false;
    private BlocksPreInflater f6494B;
    private final RichDocumentBlocksAppendedSubscriber f6495C = new C07401(this);
    private final RichDocumentBlocksErrorSubscriber f6496D = new C07412(this);
    private final RichDocumentStartupUiTasksCompletedSubscriber f6497E = new C07423(this);
    @Inject
    BlocksPreInflaterProvider f6498a;
    @Inject
    GatekeeperStoreImpl f6499b;
    @Inject
    RichDocumentEventBus f6500c;
    @Inject
    SequenceLogger f6501d;
    @Inject
    QeAccessor f6502e;
    @Inject
    public IncrementalUiIdleJobManager f6503f;
    @Inject
    VideoParamsCreator f6504g;
    @Inject
    Lazy<SequenceLogger> f6505h;
    public final Context f6506i;
    public final RichDocumentBlocksImpl f6507j;
    private final BlockViewHolderFactory f6508k;
    public final LinearLayoutManager f6509l;
    private final RecyclerView f6510m;
    public final Map<Integer, Preloadable> f6511n = new HashMap();
    public final Map<Integer, Preloadable> f6512o = new HashMap();
    public final Map<Integer, Preloadable> f6513p = new HashMap();
    public final Set<Preloadable> f6514q = new HashSet();
    public final boolean f6515r;
    public final boolean f6516s;
    public final AbstractSequenceDefinition f6517t;
    private int f6518u = -1;
    private int f6519v = -1;
    private int f6520w = -1;
    public boolean f6521x = false;
    public boolean f6522y = false;
    private boolean f6523z = false;

    /* compiled from: payments_component_dialog_fragment */
    class C07401 extends RichDocumentBlocksAppendedSubscriber {
        final /* synthetic */ RichDocumentAdapter f6484a;

        C07401(RichDocumentAdapter richDocumentAdapter) {
            this.f6484a = richDocumentAdapter;
        }

        public final void m6865b(FbEvent fbEvent) {
            RichDocumentBlocksAppendedEvent richDocumentBlocksAppendedEvent = (RichDocumentBlocksAppendedEvent) fbEvent;
            if (this.f6484a.f6507j.m5459c() == 0 && this.f6484a.f6517t != null) {
                Sequence e = this.f6484a.f6501d.e(this.f6484a.f6517t);
                if (e != null) {
                    SequenceLoggerDetour.e(e, "rich_document_fragment_starts", -549057723);
                }
            }
            if (richDocumentBlocksAppendedEvent.f5167a == this.f6484a.f6507j) {
                int c = richDocumentBlocksAppendedEvent.f5167a.m5459c();
                this.f6484a.c(this.f6484a.f6507j.m5459c() - c, c);
                RichDocumentAdapter.m6874f(this.f6484a, this.f6484a.f6507j.m5459c() - c);
            }
        }
    }

    /* compiled from: payments_component_dialog_fragment */
    class C07412 extends RichDocumentBlocksErrorSubscriber {
        final /* synthetic */ RichDocumentAdapter f6485a;

        C07412(RichDocumentAdapter richDocumentAdapter) {
            this.f6485a = richDocumentAdapter;
        }

        public final void m6866b(FbEvent fbEvent) {
            RichDocumentBlocksErrorEvent richDocumentBlocksErrorEvent = (RichDocumentBlocksErrorEvent) fbEvent;
            if (richDocumentBlocksErrorEvent.f5170a == this.f6485a.f6507j) {
                richDocumentBlocksErrorEvent.f5172c.m5048a();
            }
        }
    }

    /* compiled from: payments_component_dialog_fragment */
    class C07423 extends RichDocumentStartupUiTasksCompletedSubscriber {
        final /* synthetic */ RichDocumentAdapter f6486a;

        C07423(RichDocumentAdapter richDocumentAdapter) {
            this.f6486a = richDocumentAdapter;
        }

        public final void m6867b(FbEvent fbEvent) {
            this.f6486a.f6522y = true;
            RichDocumentAdapter.m6872e(this.f6486a);
        }
    }

    /* compiled from: payments_component_dialog_fragment */
    class C07434 implements Runnable {
        final /* synthetic */ RichDocumentAdapter f6487a;

        C07434(RichDocumentAdapter richDocumentAdapter) {
            this.f6487a = richDocumentAdapter;
        }

        public void run() {
            RichDocumentAdapter.m6872e(this.f6487a);
        }
    }

    /* compiled from: payments_component_dialog_fragment */
    class C07456 implements Runnable {
        final /* synthetic */ RichDocumentAdapter f6492a;

        C07456(RichDocumentAdapter richDocumentAdapter) {
            this.f6492a = richDocumentAdapter;
        }

        public void run() {
            for (Entry key : this.f6492a.f6513p.entrySet()) {
                this.f6492a.f6512o.remove(key.getKey());
            }
            this.f6492a.f6511n.putAll(this.f6492a.f6513p);
            this.f6492a.f6513p.clear();
            this.f6492a.f6521x = false;
        }
    }

    public static void m6870a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RichDocumentAdapter) obj).m6869a((BlocksPreInflaterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BlocksPreInflaterProvider.class), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), RichDocumentEventBus.m5130a(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IncrementalUiIdleJobManager.m7151a(injectorLike), VideoParamsCreator.m7158a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3422));
    }

    private void m6869a(BlocksPreInflaterProvider blocksPreInflaterProvider, GatekeeperStore gatekeeperStore, RichDocumentEventBus richDocumentEventBus, SequenceLogger sequenceLogger, QeAccessor qeAccessor, IncrementalUiIdleJobManager incrementalUiIdleJobManager, VideoParamsCreator videoParamsCreator, Lazy<SequenceLogger> lazy) {
        this.f6498a = blocksPreInflaterProvider;
        this.f6499b = gatekeeperStore;
        this.f6500c = richDocumentEventBus;
        this.f6501d = sequenceLogger;
        this.f6502e = qeAccessor;
        this.f6503f = incrementalUiIdleJobManager;
        this.f6504g = videoParamsCreator;
        this.f6505h = lazy;
    }

    public RichDocumentAdapter(Context context, RichDocumentBlocksImpl richDocumentBlocksImpl, BlockViewHolderFactory blockViewHolderFactory, LinearLayoutManager linearLayoutManager, RecyclerView recyclerView, AbstractSequenceDefinition abstractSequenceDefinition) {
        this.f6506i = context;
        this.f6507j = richDocumentBlocksImpl;
        this.f6508k = blockViewHolderFactory;
        this.f6509l = linearLayoutManager;
        this.f6510m = recyclerView;
        this.f6517t = abstractSequenceDefinition;
        Class cls = RichDocumentAdapter.class;
        m6870a((Object) this, getContext());
        this.f6523z = this.f6499b.a(106, false);
        this.f6515r = this.f6499b.a(701, false);
        this.f6516s = this.f6499b.a(698, false);
        boolean a = this.f6499b.a(699, false);
        if (this.f6523z) {
            this.f6494B = new BlocksPreInflater(this, recyclerView, Integer.valueOf(RichDocumentUIConfig.f6546Q), IdleExecutor_ForUiThreadMethodAutoProvider.b(this.f6498a));
            this.f6503f.m7155a(this.f6494B);
        }
        if (a) {
            this.f6504g.m7161a(richDocumentBlocksImpl);
            this.f6503f.m7155a(this.f6504g);
        }
        this.f6500c.a(this.f6495C);
        this.f6500c.a(this.f6496D);
        this.f6500c.a(this.f6497E);
        m6874f(this, 0);
    }

    public static void m6874f(RichDocumentAdapter richDocumentAdapter, int i) {
        if (richDocumentAdapter.f6507j.m5459c() != 0 && i < richDocumentAdapter.f6507j.m5459c()) {
            while (i < richDocumentAdapter.f6507j.m5459c()) {
                BlockData a = richDocumentAdapter.f6507j.m5457a(i);
                if (a instanceof Preloadable) {
                    richDocumentAdapter.f6512o.put(Integer.valueOf(i), (Preloadable) a);
                }
                i++;
            }
            m6872e(richDocumentAdapter);
        }
    }

    public final ViewHolder m6875a(ViewGroup viewGroup, int i) {
        if (this.f6523z) {
            return this.f6494B.a(i);
        }
        if (i == 4) {
            TracerDetour.a("RicDocumentAdapter.onCreateViewHolder#forPhoto", 699264284);
        }
        ViewHolder a = this.f6508k.m5227a(i, viewGroup);
        if (i != 4) {
            return a;
        }
        TracerDetour.a(-1064446716);
        return a;
    }

    public final void m6877a(ViewHolder viewHolder, int i) {
        Sequence e;
        this.f6518u = i;
        BlockViewHolder blockViewHolder = (BlockViewHolder) viewHolder;
        if (this.f6517t != null) {
            e = ((SequenceLogger) this.f6505h.get()).e(this.f6517t);
        } else {
            e = null;
        }
        if (!(e == null || viewHolder == null)) {
            SequenceLoggerDetour.a(e, "rich_document_block_bind", null, ImmutableBiMap.b("rich_document_block_type", viewHolder.getClass().getSimpleName()), 802986697);
        }
        blockViewHolder.m7382a(this.f6507j.m5457a(i));
        if (e != null) {
            SequenceLoggerDetour.b(e, "rich_document_block_bind", 2131991044);
        }
        m6872e(this);
    }

    public final BlockData m6882e(int i) {
        return this.f6507j.m5457a(i);
    }

    public final void m6880d() {
        if (!this.f6493A) {
            this.f6493A = true;
        }
    }

    public final int aZ_() {
        return this.f6507j.m5459c();
    }

    public final int m6878b() {
        return this.f6518u;
    }

    public final ViewHolder a_(ViewGroup viewGroup, int i) {
        return this.f6508k.m5227a(i, viewGroup);
    }

    public int getItemViewType(int i) {
        return this.f6507j.m5457a(i).mo272n();
    }

    public final void m6876a(ViewHolder viewHolder) {
        super.a(viewHolder);
        AbstractBlockPresenter f = m6873f(viewHolder);
        if (f != null) {
            ((MapBlockViewImpl) f.f6382d).f6634a.mo437a();
        }
        m6872e(this);
    }

    public final void m6879c(@Nullable ViewHolder viewHolder) {
        if (this.f6493A) {
            this.f6493A = false;
            return;
        }
        super.c(viewHolder);
        AbstractBlockPresenter e = m6871e(viewHolder);
        if (e != null) {
            e.mo367a(this.f6507j.m5457a(viewHolder.d()).iQ_());
        }
        m6872e(this);
    }

    public final void m6881d(ViewHolder viewHolder) {
        super.d(viewHolder);
        AbstractBlockPresenter e = m6871e(viewHolder);
        if (e != null) {
            e.mo371b(this.f6507j.m5457a(viewHolder.d()).iQ_());
        }
        this.f6510m.postDelayed(new C07434(this), 5);
    }

    private static AbstractBlockPresenter m6871e(ViewHolder viewHolder) {
        if (viewHolder != null) {
            return ((BlockViewHolder) viewHolder).m7383w();
        }
        return null;
    }

    private static MapBlockPresenter m6873f(ViewHolder viewHolder) {
        if (viewHolder != null) {
            BlockViewHolder blockViewHolder = (BlockViewHolder) viewHolder;
            if (blockViewHolder.m7383w() instanceof MapBlockPresenter) {
                return (MapBlockPresenter) blockViewHolder.m7383w();
            }
        }
        return null;
    }

    public static void m6872e(RichDocumentAdapter richDocumentAdapter) {
        if (richDocumentAdapter.f6522y && !richDocumentAdapter.f6521x) {
            int min = Math.min(richDocumentAdapter.f6518u, richDocumentAdapter.f6509l.l());
            int max = Math.max(richDocumentAdapter.f6518u, richDocumentAdapter.f6509l.n());
            if (richDocumentAdapter.f6519v != min || richDocumentAdapter.f6520w != max) {
                richDocumentAdapter.f6519v = min;
                richDocumentAdapter.f6520w = max;
                for (Entry entry : richDocumentAdapter.f6512o.entrySet()) {
                    final Preloadable preloadable = (Preloadable) entry.getValue();
                    if (preloadable.iU_()) {
                        Object obj;
                        final int intValue = ((Integer) entry.getKey()).intValue();
                        int d = preloadable.mo284d() + max;
                        if (intValue < min - preloadable.mo284d() || intValue > d) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj != null) {
                            richDocumentAdapter.f6521x = true;
                            preloadable.mo282a(richDocumentAdapter.f6506i);
                            richDocumentAdapter.f6514q.add(preloadable);
                            final RichDocumentCacheableLayoutManager richDocumentCacheableLayoutManager = richDocumentAdapter.f6509l instanceof RichDocumentCacheableLayoutManager ? (RichDocumentCacheableLayoutManager) richDocumentAdapter.f6509l : null;
                            if (!(preloadable instanceof PreloadableBlock) || richDocumentCacheableLayoutManager == null) {
                                m6868a(richDocumentAdapter, preloadable, intValue, true);
                            } else if ((preloadable instanceof VideoBlockData) && !richDocumentAdapter.f6516s) {
                                m6868a(richDocumentAdapter, preloadable, intValue, true);
                            } else if (richDocumentAdapter.f6515r) {
                                richDocumentAdapter.f6503f.m7155a(new SingleTaskUiIdleJob(new Runnable(richDocumentAdapter) {
                                    final /* synthetic */ RichDocumentAdapter f6491d;

                                    public void run() {
                                        RichDocumentAdapter.m6868a(this.f6491d, preloadable, intValue, richDocumentCacheableLayoutManager.a_(intValue, this.f6491d.getItemViewType(intValue)));
                                    }
                                }));
                            } else {
                                m6868a(richDocumentAdapter, preloadable, intValue, richDocumentCacheableLayoutManager.a_(intValue, richDocumentAdapter.getItemViewType(intValue)));
                            }
                        }
                    }
                }
            }
        }
    }

    public static void m6868a(RichDocumentAdapter richDocumentAdapter, Preloadable preloadable, int i, boolean z) {
        richDocumentAdapter.f6514q.remove(preloadable);
        if (z) {
            richDocumentAdapter.f6513p.put(Integer.valueOf(i), preloadable);
        }
        if (richDocumentAdapter.f6514q.isEmpty()) {
            richDocumentAdapter.f6510m.post(new C07456(richDocumentAdapter));
        }
    }

    public Context getContext() {
        return this.f6506i;
    }
}
