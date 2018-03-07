package com.facebook.composer.lifeevent.interstitial;

import android.annotation.TargetApi;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.GridLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.LifeEventIconsFieldsModel;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.Assisted;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

@TargetApi(14)
/* compiled from: core_attribute_border */
public class ComposerLifeEventIconsListAdapter extends FbBaseAdapter {
    private static final CallerContext f16737a = CallerContext.a(ComposerLifeEventIconsListAdapter.class);
    private final ScreenUtil f16738b;
    private final OnClickListener f16739c;
    public ImmutableList<ImmutableList<LifeEventIconsFieldsModel>> f16740d = RegularImmutableList.a;

    @Inject
    public ComposerLifeEventIconsListAdapter(@Assisted OnClickListener onClickListener, ScreenUtil screenUtil) {
        this.f16739c = onClickListener;
        this.f16738b = screenUtil;
    }

    public final View m20770a(int i, ViewGroup viewGroup) {
        View gridLayout = new GridLayout(viewGroup.getContext());
        gridLayout.setLayoutParams(new LayoutParams(-1, -2));
        return gridLayout;
    }

    public final void m20771a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        int i3 = 0;
        ImmutableList immutableList = (ImmutableList) obj;
        GridLayout gridLayout = (GridLayout) view;
        gridLayout.removeAllViews();
        int c = ((LifeEventIconsFieldsModel) immutableList.get(0)).j().c();
        int c2 = this.f16738b.c() / ((((int) viewGroup.getResources().getDimension(2131429332)) * 2) + c);
        gridLayout.setColumnCount(c2);
        c2 = (this.f16738b.c() - (c * c2)) / (c2 * 2);
        int size = immutableList.size();
        while (i3 < size) {
            LifeEventIconsFieldsModel lifeEventIconsFieldsModel = (LifeEventIconsFieldsModel) immutableList.get(i3);
            FbDraweeView fbDraweeView = new FbDraweeView(viewGroup.getContext());
            ViewGroup.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = lifeEventIconsFieldsModel.j().c();
            layoutParams.height = lifeEventIconsFieldsModel.j().a();
            layoutParams.setMargins(c2, c2, c2, c2);
            fbDraweeView.setLayoutParams(layoutParams);
            fbDraweeView.a(Uri.parse(lifeEventIconsFieldsModel.j().b()), f16737a);
            fbDraweeView.setTag(lifeEventIconsFieldsModel);
            fbDraweeView.setContentDescription(viewGroup.getResources().getString(2131234191));
            fbDraweeView.setOnClickListener(this.f16739c);
            gridLayout.addView(fbDraweeView);
            i3++;
        }
    }

    public int getCount() {
        return this.f16740d.size();
    }

    public Object getItem(int i) {
        return this.f16740d.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
