package com.facebook.nearby.v2.resultlist.views;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2CombinedResultsFragment;
import com.facebook.nearby.v2.resultlist.views.SetSearchPlaceView.Accessory;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.viewpager.BetterPagerAdapter;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: data_freshness */
public class SetSearchMapPagerAdapter extends BetterPagerAdapter {
    public static final Accessory f15903a = Accessory.BOOKMARK;
    public List<NearbyPlacesPlaceModel> f15904b;
    public Map<NearbyPlacesPlaceModel, Integer> f15905c;
    public NearbyPlacesV2CombinedResultsFragment f15906d;
    private SetSearchPlaceViewBinder f15907e;
    private final OnClickListener f15908f = new C17041(this);

    /* compiled from: data_freshness */
    class C17041 implements OnClickListener {
        final /* synthetic */ SetSearchMapPagerAdapter f15902a;

        C17041(SetSearchMapPagerAdapter setSearchMapPagerAdapter) {
            this.f15902a = setSearchMapPagerAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 373153273);
            if (this.f15902a.f15906d != null) {
                this.f15902a.f15906d.m18658a((NearbyPlacesPlaceModel) view.getTag(2131558608), ((Integer) view.getTag(2131558609)).intValue(), this.f15902a.f15904b == null ? 0 : this.f15902a.f15904b.size());
            }
            LogUtils.a(-935528146, a);
        }
    }

    @Inject
    public SetSearchMapPagerAdapter(DefaultAndroidThreadUtil defaultAndroidThreadUtil, SetSearchPlaceViewBinder setSearchPlaceViewBinder) {
        super(defaultAndroidThreadUtil);
        this.f15907e = setSearchPlaceViewBinder;
    }

    public final int m18765b() {
        return this.f15904b == null ? 0 : this.f15904b.size();
    }

    public final Object mo767b(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        Object a = new SetSearchPlaceView(context).m18773a(true).m18777b(true).m18778c(true).m18779d(false).m18780e(false).m18781f(false).m18782g(false).m18772a(f15903a);
        CustomViewUtils.b(a, context.getResources().getDrawable(2130843341));
        Object obj = a;
        View frameLayout = new FrameLayout(context);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(2131427416);
        int i2 = dimensionPixelOffset * 2;
        frameLayout.setPadding(i2, 0, i2, dimensionPixelOffset);
        frameLayout.addView(obj, -1, -2);
        View view = frameLayout;
        view.setOnClickListener(this.f15908f);
        NearbyPlacesPlaceModel a2 = m18763a(i);
        if (a2 != null) {
            this.f15907e.m18787a(obj, a2);
        }
        view.setTag(2131558608, a2);
        view.setTag(2131558609, Integer.valueOf(i));
        viewGroup.addView(view);
        return view;
    }

    public final void mo768c(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final boolean m18764a(View view, Object obj) {
        return view == obj;
    }

    public final int m18762a(Object obj) {
        if (this.f15905c == null || !(obj instanceof NearbyPlacesPlaceModel)) {
            return -2;
        }
        Integer num = (Integer) this.f15905c.get((NearbyPlacesPlaceModel) obj);
        return num == null ? -2 : num.intValue();
    }

    @Nullable
    public final NearbyPlacesPlaceModel m18763a(int i) {
        return (this.f15904b == null || i < 0 || i >= this.f15904b.size()) ? null : (NearbyPlacesPlaceModel) this.f15904b.get(i);
    }
}
