package com.facebook.composer.lifeevent.interstitial;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.TypeAheadSuggestionFieldsModel;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.Assisted;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: core_attribute_alignment */
public class ComposerLifeEventInterstitialListAdapter extends FbBaseAdapter {
    private final OnClickListener f16750a;
    public ImmutableList<TypeAheadSuggestionFieldsModel> f16751b = RegularImmutableList.a;

    @Inject
    public ComposerLifeEventInterstitialListAdapter(@Assisted OnClickListener onClickListener) {
        this.f16750a = onClickListener;
    }

    public final View m20775a(int i, ViewGroup viewGroup) {
        ContentView contentView = new ContentView(viewGroup.getContext());
        contentView.setBackgroundResource(2130839798);
        contentView.setOnClickListener(this.f16750a);
        contentView.setThumbnailSize(ThumbnailSize.SMALL);
        return contentView;
    }

    public final void m20776a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ContentView contentView = (ContentView) view;
        TypeAheadSuggestionFieldsModel typeAheadSuggestionFieldsModel = (TypeAheadSuggestionFieldsModel) obj;
        contentView.setTitleText(typeAheadSuggestionFieldsModel.k());
        contentView.setTag(typeAheadSuggestionFieldsModel);
        DefaultImageFieldsModel l = typeAheadSuggestionFieldsModel.l();
        contentView.setThumbnailUri(l != null ? l.b() : null);
    }

    public int getCount() {
        return this.f16751b.size();
    }

    public Object getItem(int i) {
        return this.f16751b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
