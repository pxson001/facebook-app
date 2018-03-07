package com.facebook.composer.shareintent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: context_menu_promo_row_enable */
public class MediaChainingFragment extends FbFragment {
    @Inject
    public FbDraweeControllerBuilder f15860a;
    private ViewGroup f15861b;

    /* compiled from: context_menu_promo_row_enable */
    class C22031 implements OnClickListener {
        final /* synthetic */ MediaChainingFragment f15855a;

        C22031(MediaChainingFragment mediaChainingFragment) {
            this.f15855a = mediaChainingFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1431536348);
            MediaChainingFragment.m16300b(this.f15855a);
            Logger.a(2, EntryType.UI_INPUT_END, 821509762, a);
        }
    }

    /* compiled from: context_menu_promo_row_enable */
    class C22042 implements OnClickListener {
        final /* synthetic */ MediaChainingFragment f15856a;

        C22042(MediaChainingFragment mediaChainingFragment) {
            this.f15856a = mediaChainingFragment;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, 1301415892, Logger.a(2, EntryType.UI_INPUT_START, 1700481941));
        }
    }

    /* compiled from: context_menu_promo_row_enable */
    class C22053 implements OnClickListener {
        final /* synthetic */ MediaChainingFragment f15857a;

        C22053(MediaChainingFragment mediaChainingFragment) {
            this.f15857a = mediaChainingFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 901892286);
            MediaChainingFragment.m16300b(this.f15857a);
            Logger.a(2, EntryType.UI_INPUT_END, -444217646, a);
        }
    }

    public static void m16299a(Object obj, Context context) {
        ((MediaChainingFragment) obj).f15860a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    public final void m16302c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = MediaChainingFragment.class;
        m16299a(this, getContext());
    }

    public final View m16301a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2128155253);
        View inflate = layoutInflater.inflate(2130904423, viewGroup, false);
        inflate.setOnClickListener(new C22031(this));
        inflate.findViewById(2131559223).setOnClickListener(new C22042(this));
        inflate.findViewById(2131560414).setOnClickListener(new C22053(this));
        this.f15861b = (ViewGroup) inflate.findViewById(2131562160);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -29358948, a);
        return inflate;
    }

    public final void m16303d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 41411827);
        super.d(bundle);
        List<Uri> parcelableArrayList = this.s.getParcelableArrayList("uris");
        int dimensionPixelSize = jW_().getDimensionPixelSize(2131432436);
        int dimensionPixelOffset = jW_().getDimensionPixelOffset(2131432437);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.setMargins(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        for (final Uri uri : parcelableArrayList) {
            FbDraweeView fbDraweeView = new FbDraweeView(getContext());
            ImageRequestBuilder a2 = ImageRequestBuilder.a(uri);
            a2.d = new ResizeOptions(dimensionPixelSize, dimensionPixelSize);
            fbDraweeView.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f15860a.p().a(CallerContext.a(MediaChainingFragment.class)).c(a2.m())).b(fbDraweeView.getController())).s());
            fbDraweeView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MediaChainingFragment f15859b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1144222011);
                    MediaChainingFragment mediaChainingFragment = this.f15859b;
                    ArrayList a2 = Lists.a(new Uri[]{uri});
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra("selected_uris", a2);
                    mediaChainingFragment.o().setResult(-1, intent);
                    mediaChainingFragment.o().finish();
                    Logger.a(2, EntryType.UI_INPUT_END, -355276476, a);
                }
            });
            this.f15861b.addView(fbDraweeView, layoutParams);
        }
        LogUtils.f(-364805590, a);
    }

    public static void m16300b(MediaChainingFragment mediaChainingFragment) {
        mediaChainingFragment.o().setResult(0);
        mediaChainingFragment.o().finish();
    }
}
