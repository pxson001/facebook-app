package com.facebook.pages.common.childlocations;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.common.intent_builder.IPageIdentityIntentBuilder;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLModels.ChildLocationConnectionFieldsModel.NodesModel;
import java.util.List;
import javax.inject.Inject;

/* compiled from: step_save */
public class PageChildLocationsListAdapter extends ArrayAdapter<NodesModel> {
    public final DefaultPageSurfaceIntentBuilder f1362a;
    private final PageChildLocationsRowViewController f1363b = new PageChildLocationsRowViewController();
    public final SecureContextHelper f1364c;

    @Inject
    public PageChildLocationsListAdapter(Context context, @Assisted List<NodesModel> list, IPageIdentityIntentBuilder iPageIdentityIntentBuilder, SecureContextHelper secureContextHelper) {
        super(context, 0, list);
        this.f1362a = iPageIdentityIntentBuilder;
        this.f1364c = secureContextHelper;
    }

    public View getView(int i, View view, final ViewGroup viewGroup) {
        if (view != null) {
            view = (PageChildLocationsRowView) view;
        } else {
            view = new PageChildLocationsRowView(getContext());
        }
        final NodesModel nodesModel = (NodesModel) getItem(i);
        this.f1363b.m2017a(nodesModel);
        view.m2016a(this.f1363b);
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageChildLocationsListAdapter f1361c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1180899927);
                this.f1361c.f1364c.a(this.f1361c.f1362a.b(Long.parseLong(nodesModel.k()), nodesModel.m(), nodesModel.n().b()), viewGroup.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 1587360976, a);
            }
        });
        return view;
    }
}
