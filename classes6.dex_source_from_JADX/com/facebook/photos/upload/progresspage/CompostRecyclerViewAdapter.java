package com.facebook.photos.upload.progresspage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.composer.publish.compost.story.CompostDraftStory;
import com.facebook.composer.publish.compost.story.CompostStory;
import com.facebook.composer.publish.compost.story.RecentlyUploadedStory;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.progresspage.CompostFragment.C08912;
import com.facebook.photos.upload.progresspage.CompostStoryViewHolder.OnUnbindListener;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: getTypesDeprecated */
public class CompostRecyclerViewAdapter extends Adapter {
    public final List<List<CompostStory>> f13875a = new ArrayList();
    public final List<CompostSectionType> f13876b = new ArrayList();
    private final CompostStoryViewHolderProvider f13877c;
    private final CompostHeaderViewHolderProvider f13878d;
    private final C09001 f13879e = new C09001(this);
    public Optional<CompostStoryListener> f13880f;

    /* compiled from: getTypesDeprecated */
    public class C09001 {
        public final /* synthetic */ CompostRecyclerViewAdapter f13870a;

        C09001(CompostRecyclerViewAdapter compostRecyclerViewAdapter) {
            this.f13870a = compostRecyclerViewAdapter;
        }

        public final void m21643a(CompostDraftStory compostDraftStory) {
            if (this.f13870a.f13880f.isPresent()) {
                C08912 c08912 = (C08912) this.f13870a.f13880f.get();
                c08912.f13837a.f13845d.m21684a(compostDraftStory, c08912.f13837a, 1);
            }
        }
    }

    /* compiled from: getTypesDeprecated */
    public enum CompostSectionType {
        PENDING_SECTION,
        UPLOADED_SECTION,
        DRAFT_SECTION
    }

    /* compiled from: getTypesDeprecated */
    public class MultiIndex {
        public int f13873a;
        public int f13874b;

        public MultiIndex(int i, int i2) {
            this.f13873a = i;
            this.f13874b = i2;
        }
    }

    public static CompostRecyclerViewAdapter m21646b(InjectorLike injectorLike) {
        return new CompostRecyclerViewAdapter((CompostStoryViewHolderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CompostStoryViewHolderProvider.class), (CompostHeaderViewHolderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CompostHeaderViewHolderProvider.class));
    }

    @Inject
    public CompostRecyclerViewAdapter(CompostStoryViewHolderProvider compostStoryViewHolderProvider, CompostHeaderViewHolderProvider compostHeaderViewHolderProvider) {
        this.f13877c = compostStoryViewHolderProvider;
        this.f13878d = compostHeaderViewHolderProvider;
        this.f13880f = Absent.INSTANCE;
    }

    public final <T extends CompostStory> void m21657a(CompostSectionType compostSectionType, List<T> list) {
        int a = m21645a(compostSectionType);
        Preconditions.checkArgument(a != -1);
        this.f13875a.set(a, new ArrayList(list));
        int c = m21648c(new MultiIndex(a, 0));
        c(c, list.size());
        a(c, aZ_());
    }

    public final ViewHolder m21652a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                CompostHeaderViewHolderProvider compostHeaderViewHolderProvider = this.f13878d;
                return new CompostHeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130907607, viewGroup, false), FbNetworkManager.a(compostHeaderViewHolderProvider), (QeAccessor) QeInternalImplMethodAutoProvider.a(compostHeaderViewHolderProvider));
            default:
                return this.f13877c.m21675a(viewGroup.getContext(), LayoutInflater.from(viewGroup.getContext()).inflate(2130907610, viewGroup, false));
        }
    }

    public final int aZ_() {
        int i = 0;
        for (List list : this.f13875a) {
            int i2;
            if (list.isEmpty()) {
                i2 = i;
            } else {
                i2 = (list.size() + 1) + i;
            }
            i = i2;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public int getItemViewType(int i) {
        return m21650f(i) ? 0 : 1;
    }

    @Nullable
    private CompostStory m21649e(int i) {
        MultiIndex g = m21651g(i);
        if (!m21647b(g) || g.f13874b == 0) {
            return null;
        }
        return (CompostStory) ((List) this.f13875a.get(g.f13873a)).get(g.f13874b - 1);
    }

    private boolean m21647b(MultiIndex multiIndex) {
        if (multiIndex.f13873a < 0 || multiIndex.f13873a >= this.f13875a.size()) {
            return false;
        }
        if (multiIndex.f13874b < 0 || multiIndex.f13874b >= ((List) this.f13875a.get(multiIndex.f13873a)).size() + 1) {
            return false;
        }
        return true;
    }

    private boolean m21650f(int i) {
        return m21651g(i).f13874b == 0;
    }

    private MultiIndex m21651g(int i) {
        int i2 = i + 0;
        for (int i3 = 0; i3 < this.f13875a.size(); i3++) {
            int size = ((List) this.f13875a.get(i3)).size() + 1;
            if (!((List) this.f13875a.get(i3)).isEmpty()) {
                if (i2 < 0) {
                    return new MultiIndex(-1, -1);
                }
                if (i2 < size) {
                    return new MultiIndex(i3, i2);
                }
                i2 -= size;
            }
        }
        return new MultiIndex(-1, -1);
    }

    private int m21648c(MultiIndex multiIndex) {
        int i = 0;
        for (int i2 = 0; i2 < Math.min(this.f13875a.size(), multiIndex.f13873a); i2++) {
            if (!((List) this.f13875a.get(i2)).isEmpty()) {
                i += ((List) this.f13875a.get(i2)).size() + 1;
            }
        }
        return multiIndex.f13874b + i;
    }

    public final void m21655a(RecentlyUploadedStory recentlyUploadedStory) {
        int aZ_ = aZ_();
        int a = m21645a(CompostSectionType.UPLOADED_SECTION);
        ((List) this.f13875a.get(a)).add(0, recentlyUploadedStory);
        int aZ_2 = aZ_();
        a = m21648c(new MultiIndex(a, 0));
        if (aZ_2 - aZ_ == 2) {
            c(a, 2);
            a(a, aZ_2);
            j_(0);
            return;
        }
        k_(a);
    }

    public final void m21658a(MultiIndex multiIndex) {
        if (m21647b(multiIndex)) {
            int aZ_ = aZ_();
            ((List) this.f13875a.get(multiIndex.f13873a)).remove(multiIndex.f13874b - 1);
            int aZ_2 = aZ_();
            int c = m21648c(multiIndex);
            if (aZ_ - aZ_2 == 2) {
                d(c - 1, 2);
                j_(0);
            } else {
                l_(c);
            }
            a(c, aZ_2);
            for (int i = 0; i < this.f13876b.size(); i++) {
                if (!((List) this.f13875a.get(i)).isEmpty()) {
                    break;
                }
            }
            if (this.f13880f.isPresent()) {
                CompostFragment.ax(((C08912) this.f13880f.get()).f13837a);
            }
        }
    }

    public final void m21656a(@Nullable C08912 c08912) {
        this.f13880f = Optional.fromNullable(c08912);
    }

    public final void m21659e() {
        j_(0);
        int a = m21645a(CompostSectionType.PENDING_SECTION);
        int c = m21648c(new MultiIndex(a, 0));
        a(c, (((List) this.f13875a.get(a)).size() + c) + 1);
    }

    private int m21645a(CompostSectionType compostSectionType) {
        for (int i = 0; i < this.f13876b.size(); i++) {
            if (this.f13876b.get(i) == compostSectionType) {
                return i;
            }
        }
        return -1;
    }

    public final void m21653a(ViewHolder viewHolder) {
        if (viewHolder.e == 1) {
            CompostStoryViewHolder compostStoryViewHolder = (CompostStoryViewHolder) viewHolder;
            if (compostStoryViewHolder.f13923I.isPresent()) {
                ((OnUnbindListener) compostStoryViewHolder.f13923I.get()).mo1144a();
            }
            HandlerDetour.a(compostStoryViewHolder.f13938y, compostStoryViewHolder.f13925K);
            compostStoryViewHolder.m21674a(null);
        }
    }

    public final void m21654a(ViewHolder viewHolder, int i) {
        int i2 = viewHolder.e;
        final MultiIndex g = m21651g(i);
        if (i2 == 0) {
            ((CompostHeaderViewHolder) viewHolder).m21625a((CompostSectionType) this.f13876b.get(g.f13873a), i == 0);
            return;
        }
        CompostSectionType compostSectionType = (CompostSectionType) this.f13876b.get(g.f13873a);
        CompostStoryViewHolder compostStoryViewHolder = (CompostStoryViewHolder) viewHolder;
        compostStoryViewHolder.f13922H = new Object(this) {
            final /* synthetic */ CompostRecyclerViewAdapter f13872b;

            public final void m21644a() {
                this.f13872b.m21658a(g);
            }
        };
        CompostStory e = m21649e(i);
        if (e != null) {
            compostStoryViewHolder.m21673a(e, compostSectionType);
            if (compostSectionType == CompostSectionType.DRAFT_SECTION) {
                compostStoryViewHolder.m21674a(this.f13879e);
            }
        }
    }
}
