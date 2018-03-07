package com.facebook.composer.minutiae.iconpicker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.metatext.MetaTextBuilder;
import com.facebook.composer.metatext.MetaTextBuilder.ParamsBuilder;
import com.facebook.composer.metatext.MinutiaeTemplateMetaTextBuilder;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeIcon;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeIconModel;
import com.facebook.composer.minutiae.iconpicker.MinutiaeIconPickerGridAdapter.StyleParams;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.model.MinutiaeObject.Builder;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.gridview.BetterGridView;
import java.util.List;

/* compiled from: toggle_like_fail */
public class MinutiaeIconPickerFragment extends FbFragment {
    private static final CallerContext f1536a = CallerContext.a(MinutiaeIconPickerFragment.class);
    public MinutiaeIconPickerGridAdapter al;
    private List<? extends MinutiaeIcon> f1537b;
    public MinutiaeObject f1538c;
    public BetterGridView f1539d;
    private TextView f1540e;
    public LinearLayout f1541f;
    private FbDraweeView f1542g;
    public MetaTextBuilder f1543h;
    public FbDraweeControllerBuilder f1544i;

    /* compiled from: toggle_like_fail */
    class C01471 implements OnGlobalLayoutListener {
        final /* synthetic */ MinutiaeIconPickerFragment f1534a;

        C01471(MinutiaeIconPickerFragment minutiaeIconPickerFragment) {
            this.f1534a = minutiaeIconPickerFragment;
        }

        public void onGlobalLayout() {
            MinutiaeIconPickerFragment minutiaeIconPickerFragment = this.f1534a;
            if (minutiaeIconPickerFragment.f1539d.getChildCount() != 0) {
                ((LayoutParams) minutiaeIconPickerFragment.f1541f.getLayoutParams()).leftMargin = minutiaeIconPickerFragment.f1539d.m20154a(minutiaeIconPickerFragment.jW_().getDimensionPixelOffset(2131429642));
            }
        }
    }

    /* compiled from: toggle_like_fail */
    class C01482 implements OnItemClickListener {
        final /* synthetic */ MinutiaeIconPickerFragment f1535a;

        C01482(MinutiaeIconPickerFragment minutiaeIconPickerFragment) {
            this.f1535a = minutiaeIconPickerFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MinutiaeIconModel minutiaeIconModel = (MinutiaeIconModel) this.f1535a.al.getItem(i);
            MinutiaeIconPickerFragment minutiaeIconPickerFragment = this.f1535a;
            Builder a = Builder.a(minutiaeIconPickerFragment.f1538c);
            a.c = minutiaeIconModel;
            minutiaeIconPickerFragment.f1538c = a.a();
            Intent intent = new Intent();
            intent.putExtra("minutiae_object", minutiaeIconPickerFragment.f1538c);
            minutiaeIconPickerFragment.o().setResult(-1, intent);
            minutiaeIconPickerFragment.o().finish();
        }
    }

    public static void m1596a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        MinutiaeIconPickerFragment minutiaeIconPickerFragment = (MinutiaeIconPickerFragment) obj;
        MinutiaeTemplateMetaTextBuilder b = MinutiaeTemplateMetaTextBuilder.m1391b(injectorLike);
        FbDraweeControllerBuilder b2 = FbDraweeControllerBuilder.b(injectorLike);
        minutiaeIconPickerFragment.f1543h = b;
        minutiaeIconPickerFragment.f1544i = b2;
    }

    public final void m1598c(Bundle bundle) {
        super.c(bundle);
        Class cls = MinutiaeIconPickerFragment.class;
        m1596a(this, getContext());
        this.f1537b = FlatBufferModelHelper.b(this.s, "custom_icons");
        this.f1538c = (MinutiaeObject) this.s.getParcelable("minutiae_object");
    }

    public final View m1597a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1109273797);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130903699, viewGroup, false);
        this.f1540e = (TextView) FindViewUtil.b(inflate, 2131560568);
        this.f1539d = (BetterGridView) FindViewUtil.b(inflate, 2131560569);
        this.f1541f = (LinearLayout) FindViewUtil.b(inflate, 2131560566);
        this.f1542g = (FbDraweeView) FindViewUtil.b(inflate, 2131560567);
        this.al = new MinutiaeIconPickerGridAdapter(this.f1537b, getContext(), this.f1544i, new StyleParams(jW_().getDimensionPixelSize(2131429642), jW_().getDimensionPixelSize(2131429643)));
        this.f1539d.setAdapter(this.al);
        TextView textView = this.f1540e;
        MetaTextBuilder metaTextBuilder = this.f1543h;
        ParamsBuilder paramsBuilder = new ParamsBuilder();
        paramsBuilder.f1292a = this.f1538c;
        textView.setText(metaTextBuilder.mo56a(paramsBuilder.m1371a()));
        this.f1539d.getViewTreeObserver().addOnGlobalLayoutListener(new C01471(this));
        this.f1539d.setOnItemClickListener(new C01482(this));
        if (!(this.f1538c.customIcon == null && this.f1538c.object.k().d() == null)) {
            this.f1542g.a(this.f1538c.a(), f1536a);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 646523714, a);
        return inflate;
    }
}
