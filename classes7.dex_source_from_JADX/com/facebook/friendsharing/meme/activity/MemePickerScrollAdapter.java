package com.facebook.friendsharing.meme.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: RootView */
public class MemePickerScrollAdapter extends Adapter<MemePickerScrollViewHolder> {
    public static final CallerContext f23945a = CallerContext.a(MemePickerScrollAdapter.class);
    private final ImmutableList<String> f23946b;
    public final FbDraweeControllerBuilder f23947c;
    public final MemePickerFragment f23948d;
    public final int f23949e;
    public final Resources f23950f;
    public Drawable f23951g;

    /* compiled from: RootView */
    public class MemePickerScrollViewHolder extends ViewHolder {
        public final /* synthetic */ MemePickerScrollAdapter f23943l;
        public DraweeView f23944m;

        /* compiled from: RootView */
        public class C20751 implements OnClickListener {
            final /* synthetic */ String f23941a;
            final /* synthetic */ MemePickerScrollViewHolder f23942b;

            public C20751(MemePickerScrollViewHolder memePickerScrollViewHolder, String str) {
                this.f23942b = memePickerScrollViewHolder;
                this.f23941a = str;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 930319338);
                this.f23942b.f23943l.f23948d.m26070a(this.f23941a);
                Logger.a(2, EntryType.UI_INPUT_END, -1445922595, a);
            }
        }

        public MemePickerScrollViewHolder(MemePickerScrollAdapter memePickerScrollAdapter, View view) {
            this.f23943l = memePickerScrollAdapter;
            super(view);
            this.f23944m = (DraweeView) FindViewUtil.b(view, 2131563795);
            this.f23944m.getLayoutParams().width = memePickerScrollAdapter.f23949e;
            this.f23944m.getLayoutParams().height = memePickerScrollAdapter.f23949e;
            DraweeView draweeView = this.f23944m;
            if (this.f23943l.f23951g == null) {
                this.f23943l.f23951g = this.f23943l.f23950f.getDrawable(2130844043);
            }
            GenericDraweeHierarchyBuilder e = new GenericDraweeHierarchyBuilder(this.f23943l.f23950f).e(ScaleType.c);
            e.l = new AutoRotateDrawable(this.f23943l.f23951g.getConstantState().newDrawable(), 1000);
            draweeView.setHierarchy(e.u());
        }
    }

    public final void m26073a(ViewHolder viewHolder, int i) {
        MemePickerScrollViewHolder memePickerScrollViewHolder = (MemePickerScrollViewHolder) viewHolder;
        String str = (String) this.f23946b.get(i);
        DraweeView draweeView = memePickerScrollViewHolder.f23944m;
        ImageRequestBuilder a = ImageRequestBuilder.a(Uri.parse(str));
        a.d = new ResizeOptions(memePickerScrollViewHolder.f23943l.f23949e, memePickerScrollViewHolder.f23943l.f23949e);
        a = a;
        a.c = true;
        draweeView.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) memePickerScrollViewHolder.f23943l.f23947c.p().c(a.m())).a(f23945a).c(true)).s());
        memePickerScrollViewHolder.f23944m.setOnClickListener(new C20751(memePickerScrollViewHolder, str));
    }

    @Inject
    public MemePickerScrollAdapter(@Assisted Context context, @Assisted ImmutableList<String> immutableList, @Assisted MemeSelectDelegate memeSelectDelegate, @Assisted Integer num, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f23950f = context.getResources();
        this.f23946b = immutableList;
        this.f23947c = fbDraweeControllerBuilder;
        this.f23948d = memeSelectDelegate;
        this.f23949e = (this.f23950f.getDisplayMetrics().widthPixels - ((num.intValue() + 1) * this.f23950f.getDimensionPixelSize(2131432479))) / 2;
    }

    public final ViewHolder m26072a(ViewGroup viewGroup, int i) {
        return new MemePickerScrollViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130905207, viewGroup, false));
    }

    public final int aZ_() {
        return this.f23946b.size();
    }
}
