package com.facebook.timeline.aboutpage.summary;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.graphql.enums.GraphQLProfileFieldStyle;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.MultiCollectionFragment.Adapter;
import com.facebook.timeline.aboutpage.MutualFriendsInfo;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldInfoModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldSectionInfoModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLInterfaces.CollectionsAppSectionWithItemsOrRequestables;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.summary.CollectionsSummaryItemsListFactory.ProfileFieldItem;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory.ItemData;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: MAP_VIEW_FRAGMENT */
public class CollectionsSummaryAdapter extends BaseAdapter implements Adapter {
    static final Object f13579a = new Object();
    public final ArrayList<CollectionsAppSectionWithItemsOrRequestables> f13580b = new ArrayList();
    public final ArrayList<Object> f13581c = new ArrayList();
    public final ArrayList<ProfileFieldSectionInfoModel> f13582d = new ArrayList();
    public final ArrayList<Object> f13583e = new ArrayList();
    private final ArrayList<Object> f13584f = new ArrayList();
    private final Context f13585g;
    private final ProfileViewerContext f13586h;
    private final MutualFriendsInfo f13587i;
    private final CollectionsViewFactory f13588j;
    private final CollectionsAnalyticsLogger f13589k;
    private final CollectionsSummaryItemsListFactory f13590l;
    private final CollectionSummaryItemRenderer f13591m;
    private boolean f13592n;
    public boolean f13593o;
    public String f13594p;

    @Inject
    public CollectionsSummaryAdapter(@Assisted Context context, @Assisted ProfileViewerContext profileViewerContext, @Assisted MutualFriendsInfo mutualFriendsInfo, CollectionsViewFactory collectionsViewFactory, @Assisted CollectionsAnalyticsLogger collectionsAnalyticsLogger, CollectionsSummaryItemsListFactory collectionsSummaryItemsListFactory, CollectionSummaryItemRenderer collectionSummaryItemRenderer) {
        this.f13585g = context;
        this.f13586h = profileViewerContext;
        this.f13587i = mutualFriendsInfo;
        this.f13588j = collectionsViewFactory;
        this.f13589k = collectionsAnalyticsLogger;
        this.f13590l = collectionsSummaryItemsListFactory;
        this.f13591m = collectionSummaryItemRenderer;
        this.f13592n = true;
        this.f13593o = false;
    }

    public final void mo405a(boolean z) {
        this.f13592n = z;
        m14792f();
    }

    public final void m14795a(CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel) {
        this.f13580b.add(collectionsAppSectionWithItemsOrRequestablesModel);
        this.f13581c.addAll(this.f13590l.m14844a(collectionsAppSectionWithItemsOrRequestablesModel, this.f13586h, this.f13594p));
        m14792f();
    }

    public final void m14794a(ProfileFieldSectionInfoModel profileFieldSectionInfoModel) {
        Object obj;
        ImmutableList immutableList;
        this.f13582d.add(profileFieldSectionInfoModel);
        ArrayList arrayList = this.f13583e;
        CollectionsSummaryItemsListFactory collectionsSummaryItemsListFactory = this.f13590l;
        int i = 0;
        if (profileFieldSectionInfoModel == null || profileFieldSectionInfoModel.m14087j() == null || profileFieldSectionInfoModel.m14087j().m14065a().isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            immutableList = RegularImmutableList.a;
        } else {
            Iterable a = Lists.a();
            if (!(profileFieldSectionInfoModel.m14087j() == null || profileFieldSectionInfoModel.m14087j().m14065a().isEmpty())) {
                if (((ProfileFieldInfoModel) profileFieldSectionInfoModel.m14087j().m14065a().get(0)).m14041b().get(0) != GraphQLProfileFieldStyle.INFO_REQUEST) {
                    a.add(CollectionsSummaryViewDataFactory.m14846a(profileFieldSectionInfoModel));
                }
                ImmutableList a2 = profileFieldSectionInfoModel.m14087j().m14065a();
                while (i < a2.size()) {
                    ProfileFieldInfoModel profileFieldInfoModel = (ProfileFieldInfoModel) a2.get(i);
                    if (CollectionsSummaryItemsListFactory.m14841a(profileFieldInfoModel)) {
                        a.add(new ProfileFieldItem(profileFieldInfoModel));
                    }
                    i++;
                }
                if (a.size() > 1) {
                    ((ProfileFieldItem) a.get(a.size() - 1)).f13632b = true;
                }
            }
            immutableList = new Builder().b(a).b();
        }
        arrayList.addAll(immutableList);
        m14792f();
    }

    public final void m14797b(CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel) {
        this.f13584f.addAll(this.f13590l.m14844a(collectionsAppSectionWithItemsOrRequestablesModel, this.f13586h, this.f13594p));
        m14792f();
    }

    public final void m14798e() {
        this.f13584f.clear();
        m14792f();
    }

    public int getCount() {
        if (!this.f13592n || (this.f13582d.isEmpty() && this.f13580b.isEmpty())) {
            return m14793g();
        }
        return m14793g() + 1;
    }

    public Object getItem(int i) {
        if (this.f13592n && i == m14793g()) {
            return f13579a;
        }
        if (i < this.f13583e.size()) {
            return this.f13583e.get(i);
        }
        int size = i - this.f13583e.size();
        if (size < this.f13581c.size()) {
            return this.f13581c.get(size);
        }
        return this.f13584f.get(size - this.f13581c.size());
    }

    public int getItemViewType(int i) {
        return CollectionSummaryItemRenderer.m14783a(getItem(i));
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            View a;
            int itemViewType = getItemViewType(i);
            if (view == null || CollectionsViewFactory.m14945a(view)) {
                a = this.f13591m.m14788a(this.f13585g, itemViewType, viewGroup);
            } else {
                a = view;
            }
            m14791a(getItem(i), a, itemViewType, viewGroup);
            return a;
        } catch (Exception e) {
            Exception exception = e;
            Object item = getItem(i);
            return this.f13588j.m14950a(exception, this.f13585g, item instanceof CollectionsAppSectionWithItemsOrRequestablesModel ? ((CollectionsAppSectionWithItemsOrRequestablesModel) item).mo390d() : null, "CollectionsSummaryAdapter.getView");
        }
    }

    private void m14792f() {
        AdapterDetour.a(this, -1471702503);
    }

    private int m14793g() {
        return (this.f13583e.size() + this.f13581c.size()) + this.f13584f.size();
    }

    private void m14791a(Object obj, View view, int i, ViewGroup viewGroup) {
        String nQ_;
        String str = null;
        this.f13591m.m14790a(obj, view, this.f13586h, this.f13587i);
        if (obj instanceof CollectionsAppSectionWithItemsOrRequestablesModel) {
            CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel = (CollectionsAppSectionWithItemsOrRequestablesModel) obj;
            CollectionWithItemsOrRequestablesModel collectionWithItemsOrRequestablesModel = (CollectionWithItemsOrRequestablesModel) collectionsAppSectionWithItemsOrRequestablesModel.m14583j().m14562a().get(0);
            nQ_ = collectionsAppSectionWithItemsOrRequestablesModel.nQ_();
            str = collectionWithItemsOrRequestablesModel.mo398j();
        } else {
            if (obj instanceof ItemData) {
                ItemData itemData = (ItemData) obj;
                if (itemData.f13787g != null) {
                    nQ_ = itemData.f13790j;
                    str = itemData.f13787g.mo398j();
                }
            } else if (obj instanceof SectionItemData) {
                SectionItemData sectionItemData = (SectionItemData) obj;
                if (!(sectionItemData.f13650b == null || sectionItemData.f13650b.f13787g == null)) {
                    nQ_ = sectionItemData.f13650b.f13790j;
                    str = sectionItemData.f13650b.f13787g.mo398j();
                }
            }
            nQ_ = null;
        }
        if (nQ_ != null && str != null) {
            this.f13589k.m13741a(this.f13586h.a, CollectionsAnalyticsLogger.m13739a(this.f13586h), nQ_, str);
        }
    }

    public int getViewTypeCount() {
        return CollectionSummaryItemRenderer.f13571b + CollectionSummaryItemRenderer.f13570a;
    }
}
