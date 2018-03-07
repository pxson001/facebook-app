package com.facebook.events.create;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.events.create.PageEventCreationPageHostsPager.FetchPageEventHostCallback;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageHostInfoFragmentModel;
import com.facebook.events.create.ui.SelectiveViewTypeTopDivider;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: contact_sync_permanent_row_click */
public class EventCreationHostSelectionFragment extends FbFragment implements CanHandleBackPressed {
    @Inject
    public FbTitleBarSupplier f16128a;
    @Inject
    public PageEventCreationPageHostsPager f16129b;
    @Inject
    public EventCreationHostSelectionAdapterProvider f16130c;
    public String f16131d;
    public EventCreationHostSelectionAdapter f16132e;
    public HashMap<String, PageHostInfoFragmentModel> f16133f;
    @Nullable
    public PageHostInfoFragmentModel f16134g;
    public C22471 f16135h;

    /* compiled from: contact_sync_permanent_row_click */
    public class C22471 {
        public final /* synthetic */ EventCreationHostSelectionFragment f16126a;

        C22471(EventCreationHostSelectionFragment eventCreationHostSelectionFragment) {
            this.f16126a = eventCreationHostSelectionFragment;
        }
    }

    /* compiled from: contact_sync_permanent_row_click */
    class C22482 implements FetchPageEventHostCallback {
        final /* synthetic */ EventCreationHostSelectionFragment f16127a;

        C22482(EventCreationHostSelectionFragment eventCreationHostSelectionFragment) {
            this.f16127a = eventCreationHostSelectionFragment;
        }

        public final void mo776a(List<PageHostInfoFragmentModel> list) {
            EventCreationHostSelectionAdapter eventCreationHostSelectionAdapter = this.f16127a.f16132e;
            C22471 c22471 = this.f16127a.f16135h;
            Builder builder = new Builder();
            builder.c(eventCreationHostSelectionAdapter.f16125h.get()).c(EventCreationHostSelectionAdapter.f16118a);
            if (list == null || list.isEmpty()) {
                builder.c(EventCreationHostSelectionAdapter.f16120c);
            } else {
                builder.b(list);
            }
            eventCreationHostSelectionAdapter.f16122e = builder.c(EventCreationHostSelectionAdapter.f16121d).b();
            eventCreationHostSelectionAdapter.f16124g = c22471;
            eventCreationHostSelectionAdapter.notifyDataSetChanged();
            EventCreationHostSelectionFragment eventCreationHostSelectionFragment = this.f16127a;
            eventCreationHostSelectionFragment.f16133f = new HashMap(list.size());
            for (PageHostInfoFragmentModel pageHostInfoFragmentModel : list) {
                eventCreationHostSelectionFragment.f16133f.put(pageHostInfoFragmentModel.m16741l(), pageHostInfoFragmentModel);
            }
            this.f16127a.f16134g = (PageHostInfoFragmentModel) this.f16127a.f16133f.get(this.f16127a.f16131d);
        }
    }

    public static void m16487a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventCreationHostSelectionFragment eventCreationHostSelectionFragment = (EventCreationHostSelectionFragment) obj;
        FbTitleBarSupplier fbTitleBarSupplier = (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector);
        PageEventCreationPageHostsPager b = PageEventCreationPageHostsPager.m16635b(fbInjector);
        EventCreationHostSelectionAdapterProvider eventCreationHostSelectionAdapterProvider = (EventCreationHostSelectionAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EventCreationHostSelectionAdapterProvider.class);
        eventCreationHostSelectionFragment.f16128a = fbTitleBarSupplier;
        eventCreationHostSelectionFragment.f16129b = b;
        eventCreationHostSelectionFragment.f16130c = eventCreationHostSelectionAdapterProvider;
    }

    public final void m16490c(Bundle bundle) {
        super.c(bundle);
        Class cls = EventCreationHostSelectionFragment.class;
        m16487a((Object) this, getContext());
        this.f16131d = this.s.getString("extra_event_host_id");
        this.f16132e = new EventCreationHostSelectionAdapter(this.f16131d, IdBasedProvider.a(this.f16130c, 3595));
        this.f16135h = new C22471(this);
    }

    public final View m16488a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1171218318);
        View inflate = layoutInflater.inflate(2130904019, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1586837758, a);
        return inflate;
    }

    public final void m16489a(View view, Bundle bundle) {
        super.a(view, bundle);
        RecyclerView recyclerView = (RecyclerView) e(2131561269);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        SelectiveViewTypeTopDivider selectiveViewTypeTopDivider = new SelectiveViewTypeTopDivider(jW_().getColor(2131361986), jW_().getDimensionPixelSize(2131431111), this.f16132e, 2131558632);
        selectiveViewTypeTopDivider.f16396d = jW_().getDimensionPixelSize(2131431109);
        recyclerView.a(selectiveViewTypeTopDivider);
        recyclerView.setAdapter(this.f16132e);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 109387310);
        super.mi_();
        ((FbTitleBar) this.f16128a.get()).setTitle(2131236930);
        this.f16129b.m16636a(null, new C22482(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1728468984, a);
    }

    public final boolean O_() {
        Intent intent = new Intent();
        FlatBufferModelHelper.a(intent, "selected_host", this.f16134g);
        o().setResult(-1, intent);
        o().finish();
        return false;
    }
}
