package com.facebook.composer.minutiae.iconpicker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeIcon;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeIconModel;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.widget.listview.FbBaseAdapter;
import java.util.List;

/* compiled from: toggle_like_ */
public class MinutiaeIconPickerGridAdapter extends FbBaseAdapter {
    private static final CallerContext f1547a = CallerContext.a(MinutiaeIconPickerGridAdapter.class, "composer");
    private final List<? extends MinutiaeIcon> f1548b;
    private final Context f1549c;
    private final FbDraweeControllerBuilder f1550d;
    private final StyleParams f1551e;

    /* compiled from: toggle_like_ */
    public class StyleParams {
        public final int f1545a;
        public final int f1546b;

        public StyleParams(int i, int i2) {
            this.f1545a = i;
            this.f1546b = i2;
        }
    }

    public MinutiaeIconPickerGridAdapter(List<? extends MinutiaeIcon> list, Context context, FbDraweeControllerBuilder fbDraweeControllerBuilder, StyleParams styleParams) {
        this.f1548b = list;
        this.f1549c = context;
        this.f1550d = fbDraweeControllerBuilder;
        this.f1551e = styleParams;
    }

    public final View m1599a(int i, ViewGroup viewGroup) {
        FbDraweeView fbDraweeView = new FbDraweeView(this.f1549c);
        fbDraweeView.setAspectRatio(1.0f);
        fbDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(this.f1549c.getResources()).e(ScaleType.c).u());
        fbDraweeView.setLayoutParams(new LayoutParams(this.f1551e.f1545a, this.f1551e.f1545a));
        fbDraweeView.setPadding(this.f1551e.f1546b, this.f1551e.f1546b, this.f1551e.f1546b, this.f1551e.f1546b);
        return fbDraweeView;
    }

    public final void m1600a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        DraweeView draweeView = (DraweeView) view;
        draweeView.setController(((FbDraweeControllerBuilder) this.f1550d.a(f1547a).a(((MinutiaeIconModel) obj).c().b()).b(draweeView.getController())).s());
    }

    public int getCount() {
        return this.f1548b.size();
    }

    public Object getItem(int i) {
        return this.f1548b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
