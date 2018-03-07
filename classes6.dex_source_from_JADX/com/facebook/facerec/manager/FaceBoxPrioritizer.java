package com.facebook.facerec.manager;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.facerec.model.LocalFaceRecImageData;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.PreFilledTagLogger;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.base.tagging.TaggablePhoto;
import com.facebook.photos.data.method.FetchDefaultTagSuggestions;
import com.facebook.photos.data.method.FetchDefaultTagSuggestions.DefaultTagSuggestionsCallback;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.annotation.Nullable;

/* compiled from: notifications_jewel_module */
public abstract class FaceBoxPrioritizer {
    public ListenableFuture<List<List<TaggingProfile>>> f9856a;
    protected boolean f9857b;
    public boolean f9858c;
    protected List<LocalFaceRecImageData> f9859d = Lists.a();
    public final Lazy<FetchDefaultTagSuggestions> f9860e;
    private final AbstractFbErrorReporter f9861f;
    public final Lazy<FaceRecManager> f9862g;
    private final PreFilledTagLogger f9863h;
    private ListenableFuture<List<FaceBox>> f9864i;
    public FaceBoxPrioritizerListener f9865j;
    @Nullable
    public ImmutableList<TaggingProfile> f9866k;
    public boolean f9867l;
    private FaceBoxStore f9868m;
    public int f9869n;
    private Stack<LocalFaceRecImageData> f9870o = new Stack();
    private Map<String, LocalFaceRecImageData> f9871p = Maps.c();

    /* compiled from: notifications_jewel_module */
    public class C05951 implements DefaultTagSuggestionsCallback {
        final /* synthetic */ FaceBoxPrioritizer f9855a;

        public C05951(FaceBoxPrioritizer faceBoxPrioritizer) {
            this.f9855a = faceBoxPrioritizer;
        }

        public final void mo1021a(List<TaggingProfile> list) {
            if (list != null && !list.isEmpty()) {
                Builder builder = ImmutableList.builder();
                for (TaggingProfile taggingProfile : list) {
                    if (taggingProfile != null) {
                        builder.c(taggingProfile);
                    }
                }
                this.f9855a.f9866k = builder.b();
            }
        }
    }

    /* compiled from: notifications_jewel_module */
    public interface FaceBoxPrioritizerListener {
        void m15598a(LocalFaceRecImageData localFaceRecImageData);

        void m15599b(LocalFaceRecImageData localFaceRecImageData);
    }

    protected abstract void mo1022b(LocalFaceRecImageData localFaceRecImageData);

    protected abstract void mo1023c(LocalFaceRecImageData localFaceRecImageData);

    public FaceBoxPrioritizer(PreFilledTagLogger preFilledTagLogger, FbErrorReporter fbErrorReporter, Lazy<FetchDefaultTagSuggestions> lazy, Lazy<FaceRecManager> lazy2, FaceBoxStore faceBoxStore) {
        this.f9863h = preFilledTagLogger;
        this.f9861f = fbErrorReporter;
        this.f9862g = lazy2;
        this.f9860e = lazy;
        this.f9868m = faceBoxStore;
        ((FetchDefaultTagSuggestions) this.f9860e.get()).m20312a(new C05951(this));
    }

    protected final boolean m15615d(LocalFaceRecImageData localFaceRecImageData) {
        if (localFaceRecImageData.f9939c == null) {
            return false;
        }
        return this.f9868m.m21134b((TaggablePhoto) localFaceRecImageData.f9939c.f12739f);
    }

    public final synchronized void m15607a(LocalFaceRecImageData localFaceRecImageData) {
        Preconditions.checkNotNull(localFaceRecImageData);
        if (!m15606i(localFaceRecImageData)) {
            this.f9871p.remove(localFaceRecImageData.m15651f());
            int b = m15602b(localFaceRecImageData, this.f9870o);
            if (b != -1) {
                this.f9870o.remove(b);
            }
        }
    }

    public final synchronized void m15610a(List<LocalFaceRecImageData> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                Object obj = null;
                int size = list.size() - 1;
                while (size >= 0) {
                    Object obj2;
                    LocalFaceRecImageData localFaceRecImageData = (LocalFaceRecImageData) list.get(size);
                    if (localFaceRecImageData.m15646a() && localFaceRecImageData.m15649d()) {
                        if (localFaceRecImageData.m15653h() != null && (localFaceRecImageData.m15653h().m20116r() instanceof LocalPhoto) && !((LocalPhoto) localFaceRecImageData.m15653h().m20116r()).m20131d() && m15604g(localFaceRecImageData)) {
                            m15605h(localFaceRecImageData);
                            obj2 = obj;
                        }
                        obj2 = obj;
                    } else {
                        this.f9871p.put(localFaceRecImageData.m15651f(), localFaceRecImageData);
                        if (!m15606i(localFaceRecImageData)) {
                            int b = m15602b(localFaceRecImageData, this.f9870o);
                            if (b != -1) {
                                this.f9870o.remove(b);
                            }
                            this.f9870o.push(localFaceRecImageData);
                            obj2 = 1;
                        }
                        obj2 = obj;
                    }
                    size--;
                    obj = obj2;
                }
                if (!(obj == null || this.f9857b)) {
                    m15619h();
                }
            }
        }
    }

    public synchronized void mo1024b() {
        this.f9870o.clear();
        this.f9859d.clear();
        this.f9871p.clear();
        this.f9857b = false;
        if (this.f9864i != null) {
            this.f9864i.cancel(false);
        }
        if (this.f9856a != null) {
            this.f9856a.cancel(false);
        }
    }

    public final void m15614d() {
        this.f9867l = false;
    }

    public final void m15617e() {
        this.f9867l = true;
    }

    protected final synchronized void m15619h() {
        if (!this.f9870o.isEmpty()) {
            LocalFaceRecImageData localFaceRecImageData = (LocalFaceRecImageData) this.f9870o.pop();
            if (localFaceRecImageData.m15646a()) {
                if (localFaceRecImageData.m15646a() && !localFaceRecImageData.m15649d()) {
                    mo1023c(localFaceRecImageData);
                }
                m15619h();
            } else {
                mo1022b(localFaceRecImageData);
            }
        }
    }

    protected final synchronized void m15609a(LocalFaceRecImageData localFaceRecImageData, boolean z) {
        int b = m15602b(localFaceRecImageData, this.f9859d);
        if (b != -1) {
            this.f9859d.remove(b);
        }
        if (z) {
            this.f9871p.remove(localFaceRecImageData.m15651f());
        }
    }

    protected final synchronized LocalFaceRecImageData m15616e(LocalFaceRecImageData localFaceRecImageData) {
        if (!(this.f9871p.get(localFaceRecImageData.m15651f()) == null || this.f9871p.get(localFaceRecImageData.m15651f()) == localFaceRecImageData)) {
            localFaceRecImageData = (LocalFaceRecImageData) this.f9871p.get(localFaceRecImageData.m15651f());
        }
        return localFaceRecImageData;
    }

    protected final void m15608a(LocalFaceRecImageData localFaceRecImageData, List<List<TaggingProfile>> list) {
        List b = localFaceRecImageData.m15647b();
        if (b != null) {
            m15600a(b, (List) list);
            m15604g(localFaceRecImageData);
            m15605h(localFaceRecImageData);
        }
    }

    private void m15600a(List<FaceBox> list, List<List<TaggingProfile>> list2) {
        Object obj = (list2 == null || list.size() != list2.size()) ? null : 1;
        int i = 0;
        while (i < list.size()) {
            FaceBox faceBox = (FaceBox) list.get(i);
            if (obj != null && !((List) list2.get(i)).isEmpty()) {
                new StringBuilder("Tag suggestions for face box ").append(faceBox.f12766b).append(":");
                for (TaggingProfile taggingProfile : (List) list2.get(i)) {
                    taggingProfile.f17538a.i();
                }
                if (((List) list2.get(i)).size() == 1 || !m15603b((List) list2.get(i))) {
                    faceBox.m20158b((List) list2.get(i));
                } else if (this.f9866k != null) {
                    faceBox.m20155a(this.f9866k);
                }
            } else if (this.f9866k != null) {
                faceBox.m20155a(this.f9866k);
            }
            i++;
        }
    }

    private boolean m15603b(List<TaggingProfile> list) {
        if (this.f9866k == null) {
            return false;
        }
        boolean z;
        int min = Math.min(list.size(), this.f9866k.size());
        int i = 0;
        while (i < min) {
            if (this.f9866k.get(i) == null) {
                this.f9861f.a("FaceBoxPrioritizer: suggestions has null", "mDefaultTagSuggestions is null at index " + i);
            }
            if (list.get(i) == null) {
                this.f9861f.a("FaceBoxPrioritizer: suggestions has null", "suggestions is null at index " + i);
            }
            if (!(list.get(i) == null && this.f9866k.get(i) == null) && (list.get(i) == null || this.f9866k.get(i) == null || ((TaggingProfile) list.get(i)).f17539b != ((TaggingProfile) this.f9866k.get(i)).f17539b)) {
                z = false;
                break;
            }
            i++;
        }
        z = true;
        return z;
    }

    private boolean m15604g(LocalFaceRecImageData localFaceRecImageData) {
        Preconditions.checkNotNull(localFaceRecImageData);
        if (!localFaceRecImageData.m15649d() || localFaceRecImageData.f9939c == null || localFaceRecImageData.f9939c.f12739f == null || this.f9869n >= 20) {
            return false;
        }
        TaggablePhoto taggablePhoto = localFaceRecImageData.f9939c.f12739f;
        if (taggablePhoto.f12750f) {
            return false;
        }
        boolean z = false;
        for (FaceBox a : this.f9868m.m21129a(taggablePhoto)) {
            boolean z2;
            if (m15601a(a, localFaceRecImageData) || z) {
                z2 = true;
            } else {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            this.f9869n++;
        }
        return z;
    }

    private boolean m15601a(FaceBox faceBox, LocalFaceRecImageData localFaceRecImageData) {
        if (faceBox == null || faceBox.mo1102n() == null || faceBox.mo1102n().size() != 1 || faceBox.f12770f || localFaceRecImageData.f9939c == null || localFaceRecImageData.f9939c.f12739f == null || !(localFaceRecImageData.f9939c.f12739f instanceof LocalPhoto) || localFaceRecImageData.f9939c.f12739f.f12750f) {
            return false;
        }
        if (this.f9867l) {
            this.f9863h.m19992b();
            return false;
        }
        this.f9863h.m19991a();
        Tag tag = new Tag(faceBox, ((TaggingProfile) faceBox.mo1102n().get(0)).f17538a, ((TaggingProfile) faceBox.mo1102n().get(0)).f17539b, true, ((TaggingProfile) faceBox.mo1102n().get(0)).f17542e, true);
        tag.m20182a(faceBox.m20163i());
        faceBox.f12770f = true;
        localFaceRecImageData.m15648c().add(tag);
        localFaceRecImageData.f9940d.add(tag);
        return true;
    }

    protected final void m15618f(LocalFaceRecImageData localFaceRecImageData) {
        if (this.f9865j != null) {
            this.f9865j.m15598a(localFaceRecImageData);
        }
        new StringBuilder("Got face boxes for photo ").append(localFaceRecImageData.m15652g());
    }

    private void m15605h(LocalFaceRecImageData localFaceRecImageData) {
        if (this.f9865j != null) {
            this.f9865j.m15599b(localFaceRecImageData);
        }
        new StringBuilder("Got tag suggestions for photo ").append(localFaceRecImageData.m15652g());
    }

    private boolean m15606i(LocalFaceRecImageData localFaceRecImageData) {
        Preconditions.checkNotNull(localFaceRecImageData);
        return m15602b(localFaceRecImageData, this.f9859d) != -1;
    }

    private static int m15602b(LocalFaceRecImageData localFaceRecImageData, List<LocalFaceRecImageData> list) {
        Preconditions.checkNotNull(localFaceRecImageData);
        String str = localFaceRecImageData.f9937a;
        for (int i = 0; i < list.size(); i++) {
            if (((LocalFaceRecImageData) list.get(i)).f9937a.equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }
}
