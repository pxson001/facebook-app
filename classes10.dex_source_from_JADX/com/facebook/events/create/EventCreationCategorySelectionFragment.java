package com.facebook.events.create;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.events.create.PageEventCreationCategoryPager.C22661;
import com.facebook.events.create.PageEventCreationCategoryPager.C22672;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageEventCategoriesQueryModel.EventCategoryGroupsModel;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageEventCategoriesQueryModel.EventCategoryGroupsModel.NodesModel;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageEventCategoriesQueryModel.EventCategoryGroupsModel.NodesModel.CategoriesModel;
import com.facebook.events.create.ui.EventCreationCategorySelectionTextViewHolderProvider;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import javax.inject.Inject;

/* compiled from: contact_sync_permanent_row_try_again_dialog_accept */
public class EventCreationCategorySelectionFragment extends FbFragment {
    @Inject
    public FbTitleBarSupplier f16109a;
    private RecyclerView al;
    @Inject
    public PageEventCreationCategoryPager f16110b;
    @Inject
    public EventCreationCategorySelectionAdapterProvider f16111c;
    private String f16112d;
    private boolean f16113e;
    public EventCreationCategorySelectionAdapter f16114f;
    private String f16115g;
    private NodesModel f16116h;
    private C22451 f16117i;

    /* compiled from: contact_sync_permanent_row_try_again_dialog_accept */
    public class C22451 {
        final /* synthetic */ EventCreationCategorySelectionFragment f16107a;

        C22451(EventCreationCategorySelectionFragment eventCreationCategorySelectionFragment) {
            this.f16107a = eventCreationCategorySelectionFragment;
        }

        public final void m16474a(CategoriesModel categoriesModel) {
            EventCreationCategorySelectionFragment.m16476a(this.f16107a, categoriesModel);
        }
    }

    /* compiled from: contact_sync_permanent_row_try_again_dialog_accept */
    public class C22462 {
        final /* synthetic */ EventCreationCategorySelectionFragment f16108a;

        C22462(EventCreationCategorySelectionFragment eventCreationCategorySelectionFragment) {
            this.f16108a = eventCreationCategorySelectionFragment;
        }

        public final void m16475a(EventCategoryGroupsModel eventCategoryGroupsModel) {
            if (eventCategoryGroupsModel != null && eventCategoryGroupsModel.m16696a() != null) {
                EventCreationCategorySelectionAdapter eventCreationCategorySelectionAdapter = this.f16108a.f16114f;
                eventCreationCategorySelectionAdapter.f16103b = eventCategoryGroupsModel.m16696a();
                eventCreationCategorySelectionAdapter.notifyDataSetChanged();
            }
        }
    }

    public static void m16477a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventCreationCategorySelectionFragment eventCreationCategorySelectionFragment = (EventCreationCategorySelectionFragment) obj;
        FbTitleBarSupplier fbTitleBarSupplier = (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector);
        PageEventCreationCategoryPager pageEventCreationCategoryPager = new PageEventCreationCategoryPager(GraphQLQueryExecutor.a(fbInjector), TasksManager.b(fbInjector));
        EventCreationCategorySelectionAdapterProvider eventCreationCategorySelectionAdapterProvider = (EventCreationCategorySelectionAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EventCreationCategorySelectionAdapterProvider.class);
        eventCreationCategorySelectionFragment.f16109a = fbTitleBarSupplier;
        eventCreationCategorySelectionFragment.f16110b = pageEventCreationCategoryPager;
        eventCreationCategorySelectionFragment.f16111c = eventCreationCategorySelectionAdapterProvider;
    }

    public final void m16481c(Bundle bundle) {
        super.c(bundle);
        Class cls = EventCreationCategorySelectionFragment.class;
        m16477a((Object) this, getContext());
        this.f16112d = this.s.getString("extra_title_bar_content");
        this.f16113e = this.s.getBoolean("extra_is_subcateory");
        this.f16114f = new EventCreationCategorySelectionAdapter(Boolean.valueOf(this.f16113e), (EventCreationCategorySelectionTextViewHolderProvider) this.f16111c.getOnDemandAssistedProviderForStaticDi(EventCreationCategorySelectionTextViewHolderProvider.class));
        if (this.f16113e) {
            this.f16116h = (NodesModel) FlatBufferModelHelper.a(this.s, "extra_category_group");
        } else {
            this.f16115g = this.s.getString("extra_page_id");
        }
        this.f16117i = new C22451(this);
    }

    public final View m16478a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -477941003);
        View inflate = layoutInflater.inflate(2130904015, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -506478948, a);
        return inflate;
    }

    public final void m16480a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.al = (RecyclerView) e(2131561266);
        this.al.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.al.setAdapter(this.f16114f);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -805832119);
        super.mi_();
        ((FbTitleBar) this.f16109a.get()).setTitle(this.f16112d);
        if (this.f16113e) {
            EventCreationCategorySelectionAdapter eventCreationCategorySelectionAdapter = this.f16114f;
            eventCreationCategorySelectionAdapter.f16104c = this.f16116h.m16691a();
            eventCreationCategorySelectionAdapter.notifyDataSetChanged();
        } else {
            PageEventCreationCategoryPager pageEventCreationCategoryPager = this.f16110b;
            String str = this.f16115g;
            C22462 c22462 = new C22462(this);
            pageEventCreationCategoryPager.f16240b.a("fetchCategories", new C22661(pageEventCreationCategoryPager, str), new C22672(pageEventCreationCategoryPager, c22462));
        }
        this.f16114f.f16105d = this.f16117i;
        LogUtils.f(578471402, a);
    }

    public final void m16479a(int i, int i2, Intent intent) {
        if (i == 110 && i2 == -1) {
            m16476a(this, (CategoriesModel) FlatBufferModelHelper.a(intent, "extra_selected_category"));
        }
    }

    public static void m16476a(EventCreationCategorySelectionFragment eventCreationCategorySelectionFragment, CategoriesModel categoriesModel) {
        Intent intent = new Intent();
        FlatBufferModelHelper.a(intent, "extra_selected_category", categoriesModel);
        eventCreationCategorySelectionFragment.o().setResult(-1, intent);
        eventCreationCategorySelectionFragment.o().finish();
    }
}
