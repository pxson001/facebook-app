package com.facebook.events.create;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.create.EventCreationCategorySelectionFragment.C22451;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageEventCategoriesQueryModel.EventCategoryGroupsModel.NodesModel;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageEventCategoriesQueryModel.EventCategoryGroupsModel.NodesModel.CategoriesModel;
import com.facebook.events.create.ui.EventCreationCategorySelectionTextViewHolder;
import com.facebook.events.create.ui.EventCreationCategorySelectionTextViewHolderProvider;
import com.facebook.inject.Assisted;
import com.facebook.inject.IdBasedProvider;
import com.facebook.resources.ui.FbTextView;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/* compiled from: contact_sync_permanent_row_view_synced_contacts_click */
public class EventCreationCategorySelectionAdapter extends Adapter<EventCreationCategorySelectionTextViewHolder> {
    private boolean f16102a;
    public List<NodesModel> f16103b = Collections.emptyList();
    public List<CategoriesModel> f16104c = Collections.emptyList();
    public C22451 f16105d;
    private EventCreationCategorySelectionTextViewHolderProvider f16106e;

    public final void m16473a(ViewHolder viewHolder, int i) {
        EventCreationCategorySelectionTextViewHolder eventCreationCategorySelectionTextViewHolder = (EventCreationCategorySelectionTextViewHolder) viewHolder;
        if (this.f16102a) {
            CategoriesModel categoriesModel = (CategoriesModel) this.f16104c.get(i);
            C22451 c22451 = this.f16105d;
            eventCreationCategorySelectionTextViewHolder.f16339r = categoriesModel;
            if (eventCreationCategorySelectionTextViewHolder.f16339r == null) {
                eventCreationCategorySelectionTextViewHolder.f16333l.setVisibility(8);
                return;
            }
            eventCreationCategorySelectionTextViewHolder.f16340s = c22451;
            eventCreationCategorySelectionTextViewHolder.f16333l.setVisibility(0);
            eventCreationCategorySelectionTextViewHolder.f16333l.setText(categoriesModel.m16686j());
            eventCreationCategorySelectionTextViewHolder.f16333l.setTextAppearance(eventCreationCategorySelectionTextViewHolder.f16334m, 2131625741);
            eventCreationCategorySelectionTextViewHolder.f16333l.setOnClickListener(eventCreationCategorySelectionTextViewHolder.f16337p);
            return;
        }
        eventCreationCategorySelectionTextViewHolder.m16813a((NodesModel) this.f16103b.get(i), this.f16105d);
    }

    @Inject
    public EventCreationCategorySelectionAdapter(@Assisted Boolean bool, EventCreationCategorySelectionTextViewHolderProvider eventCreationCategorySelectionTextViewHolderProvider) {
        this.f16102a = bool.booleanValue();
        this.f16106e = eventCreationCategorySelectionTextViewHolderProvider;
    }

    public final ViewHolder m16472a(ViewGroup viewGroup, int i) {
        FbTextView fbTextView = (FbTextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130904016, viewGroup, false);
        EventCreationCategorySelectionTextViewHolderProvider eventCreationCategorySelectionTextViewHolderProvider = this.f16106e;
        return new EventCreationCategorySelectionTextViewHolder(fbTextView, Boolean.valueOf(this.f16102a), IdBasedProvider.a(eventCreationCategorySelectionTextViewHolderProvider, 12), (SecureContextHelper) DefaultSecureContextHelper.a(eventCreationCategorySelectionTextViewHolderProvider), I18nJoiner.b(eventCreationCategorySelectionTextViewHolderProvider));
    }

    public final int aZ_() {
        return this.f16102a ? this.f16104c.size() : this.f16103b.size();
    }
}
