package com.facebook.composer.lifeevent.type;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.LifeEventFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.listview.BetterListView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: controlFilters */
public class ComposerLifeEventTypeSubcategoryFragment extends FbFragment {
    @Inject
    public ComposerLifeEventTypeListAdapterProvider f16794a;
    public OnClickListener f16795b;
    public ImmutableList<LifeEventFieldsModel> f16796c;

    public static void m20808a(Object obj, Context context) {
        ((ComposerLifeEventTypeSubcategoryFragment) obj).f16794a = (ComposerLifeEventTypeListAdapterProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(ComposerLifeEventTypeListAdapterProvider.class);
    }

    public final void m20811c(Bundle bundle) {
        super.c(bundle);
        Class cls = ComposerLifeEventTypeSubcategoryFragment.class;
        m20808a((Object) this, getContext());
    }

    public final View m20809a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 281695981);
        View inflate = layoutInflater.inflate(2130903691, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -606443020, a);
        return inflate;
    }

    public final void m20810a(View view, Bundle bundle) {
        super.a(view, bundle);
        ComposerLifeEventTypeListAdapter a = this.f16794a.m20798a(getContext(), null, null, this.f16795b);
        a.m20797a(this.f16796c);
        ((BetterListView) e(2131560547)).setAdapter(a);
    }
}
