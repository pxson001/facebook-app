package com.facebook.pages.common.coverphotoreposition;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.TriState;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.timeline.header.coverphoto.edit.CoverPhotoEditView;
import com.facebook.timeline.header.data.TimelineHeaderPageData;
import com.facebook.timeline.util.TimelineViewHelper;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Joiner;
import com.google.inject.util.Providers;

/* compiled from: song_clip_url */
public class PageEditCoverPhotoHeaderView extends CustomLinearLayout {
    public static double f1501a = 1.78d;
    private static final CallerContext f1502e = CallerContext.a(PageEditCoverPhotoHeaderView.class, "pages_identity", "profile_photo");
    private Joiner f1503b;
    private final String f1504c;
    public FbDraweeControllerBuilder f1505d;
    public ScreenUtil f1506f;
    public Resources f1507g;

    public static void m2202a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageEditCoverPhotoHeaderView pageEditCoverPhotoHeaderView = (PageEditCoverPhotoHeaderView) obj;
        ScreenUtil a = ScreenUtil.a(fbInjector);
        Resources a2 = ResourcesMethodAutoProvider.a(fbInjector);
        FbDraweeControllerBuilder b = FbDraweeControllerBuilder.b(fbInjector);
        pageEditCoverPhotoHeaderView.f1506f = a;
        pageEditCoverPhotoHeaderView.f1507g = a2;
        pageEditCoverPhotoHeaderView.f1505d = b;
    }

    public PageEditCoverPhotoHeaderView(String str, Context context) {
        super(context);
        this.f1504c = str;
        Class cls = PageEditCoverPhotoHeaderView.class;
        m2202a(this, getContext());
        setContentView(2130905999);
    }

    public final boolean m2203a(TimelineHeaderPageData timelineHeaderPageData) {
        String b;
        int c = this.f1506f.c();
        ((CoverPhotoEditView) findViewById(2131565417)).a(this.f1504c, c, (int) Math.round(((double) c) / f1501a));
        ((FrameLayout) findViewById(2131565416)).setForeground(this.f1507g.getDrawable(2130842453));
        TextView textView = (TextView) a(2131565419);
        textView.setText(TimelineViewHelper.a(timelineHeaderPageData.a, false, TimelineViewHelper.a(textView, timelineHeaderPageData.e, null, 0, getContext()), 2130843878, 2130844053, getContext(), getResources().getDimensionPixelSize(2131429838), getResources().getDimensionPixelSize(2131429891), Providers.a(TriState.UNSET)));
        this.f1503b = Joiner.on(" · ");
        TextView textView2 = (TextView) a(2131565420);
        Iterable iterable = timelineHeaderPageData.f;
        if (!(iterable == null || iterable.isEmpty())) {
            textView2.setText(this.f1503b.join(iterable));
        }
        FbDraweeView fbDraweeView = (FbDraweeView) a(2131565418);
        FbDraweeControllerBuilder a = ((FbDraweeControllerBuilder) this.f1505d.p().b(fbDraweeView.getController())).a(f1502e);
        if (timelineHeaderPageData.c != null) {
            b = timelineHeaderPageData.c.b();
        } else {
            b = null;
        }
        a.b(Uri.parse(b));
        fbDraweeView.setController(a.s());
        return true;
    }
}
