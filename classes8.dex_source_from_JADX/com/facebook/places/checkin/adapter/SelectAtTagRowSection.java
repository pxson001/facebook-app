package com.facebook.places.checkin.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.StringUtil;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.models.RowType;
import com.facebook.places.checkin.models.SearchResults;
import com.facebook.places.checkin.models.SearchResults.ListType;
import com.facebook.places.checkin.utils.CheckinTextModifier;
import com.facebook.places.checkin.utils.FlowLogicTestHelper;
import com.facebook.places.graphql.PlacesGraphQLHelper;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.FlowableTaggableActivityModel;
import com.google.common.collect.Lists;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: claimed_offers */
public class SelectAtTagRowSection extends AdapterSection {
    public static final CallerContext f18021a = CallerContext.a(SelectAtTagRowSection.class);
    private final LayoutInflater f18022b;
    public final Context f18023c;
    private final CheckinTextModifier f18024d;
    public SearchResults f18025e;
    public Location f18026f;
    public String f18027g;
    private Locale f18028h;
    private boolean f18029i = false;
    public boolean f18030j;
    public ImagePipeline f18031k;
    public final Executor f18032l;
    public SearchType f18033m;

    @Inject
    public SelectAtTagRowSection(LayoutInflater layoutInflater, Context context, CheckinTextModifier checkinTextModifier, Locale locale, ImagePipeline imagePipeline, Executor executor) {
        this.f18023c = context;
        this.f18022b = layoutInflater;
        this.f18024d = checkinTextModifier;
        this.f18028h = locale;
        this.f18032l = executor;
        this.f18031k = imagePipeline;
    }

    public final boolean mo1066a(CheckinPlace checkinPlace, ArrayList<Pair<RowType, Object>> arrayList) {
        Object obj;
        if (this.f18025e == null || this.f18025e.b.size() <= 0 || this.f18025e.g != ListType.RECENT) {
            obj = null;
        } else {
            obj = 1;
        }
        if (!(obj == null || this.f18029i)) {
            this.f18029i = true;
            arrayList.add(new Pair(RowType.SelectAtTagRowHeader, null));
        }
        arrayList.add(new Pair(RowType.SelectAtTagRow, checkinPlace));
        return true;
    }

    public final boolean mo1067a(Object obj) {
        return obj != null;
    }

    public final RowType mo1064a() {
        return RowType.SelectAtTagRow;
    }

    public final RowType mo1069b() {
        return RowType.SelectAtTagRowHeader;
    }

    private View m21983a(View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f18022b.inflate(2130907055, viewGroup, false);
        }
        ((TextView) view.findViewById(2131567395)).setText(this.f18023c.getResources().getString(2131235151));
        return view;
    }

    private String m21984a(CheckinPlaceModel checkinPlaceModel) {
        if (checkinPlaceModel.m() != GraphQLPlaceType.RESIDENCE) {
            List a = Lists.a();
            boolean e = m21987e();
            if (!(this.f18026f == null || checkinPlaceModel.cg_() == null || !e)) {
                a.add(this.f18024d.m22090a(this.f18026f, checkinPlaceModel.cg_().a(), checkinPlaceModel.cg_().b()));
            }
            Object obj = !m21987e() ? 1 : null;
            if (!(checkinPlaceModel.c() == null || obj == null)) {
                if (this.f18025e.g == ListType.TRADITIONAL) {
                    CharSequence a2 = PlacesGraphQLHelper.a(checkinPlaceModel);
                    if (!StringUtil.c(a2)) {
                        a.add(a2);
                    }
                } else if (!StringUtil.c(checkinPlaceModel.c().b())) {
                    a.add(checkinPlaceModel.c().b());
                }
            }
            return StringUtil.b(" · ", a.toArray());
        } else if (checkinPlaceModel.c() != null) {
            return checkinPlaceModel.c().a();
        } else {
            return "";
        }
    }

    private boolean m21987e() {
        return StringUtil.a(this.f18027g);
    }

    public final boolean mo1070c() {
        return true;
    }

    public final void mo1071d() {
        this.f18029i = false;
    }

    public final View mo1063a(View view, ViewGroup viewGroup, Object obj) {
        if (obj == null) {
            return m21983a(view, viewGroup);
        }
        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) obj;
        view = (ContentView) view;
        if (view == null) {
            view = new ContentView(this.f18023c);
            view.setThumbnailSize(ThumbnailSize.SMALL);
            FbDraweeView fbDraweeView = new FbDraweeView(this.f18023c);
            int dimension = (int) this.f18023c.getResources().getDimension(2131430019);
            fbDraweeView.setPadding(dimension, dimension, dimension, dimension);
            view.setThumbnailView(fbDraweeView);
            view.setMaxLinesFromThumbnailSize(false);
        }
        if (FlowLogicTestHelper.m22091a(checkinPlaceModel, this.f18033m)) {
            FlowableTaggableActivityModel g = checkinPlaceModel.g();
            if (!(g == null || g.c() == null || g.c().a() == null)) {
                ImageRequest m = ImageRequestBuilder.a(Uri.parse(g.c().a())).m();
                final WeakReference weakReference = new WeakReference(checkinPlaceModel);
                final WeakReference weakReference2 = new WeakReference(view);
                this.f18031k.c(m, f18021a).a(new BaseBitmapDataSubscriber(this) {
                    final /* synthetic */ SelectAtTagRowSection f18020c;

                    public final void m21980a(@Nullable Bitmap bitmap) {
                        if (weakReference2.get() != null && weakReference.get() != null) {
                            SelectAtTagRowSection.m21985a(this.f18020c, (CheckinPlaceModel) weakReference.get(), (ContentView) weakReference2.get(), bitmap);
                        }
                    }

                    public final void m21981f(DataSource<CloseableReference<CloseableImage>> dataSource) {
                    }
                }, this.f18032l);
            }
        }
        m21985a(this, checkinPlaceModel, view, null);
        return view;
    }

    public static void m21985a(SelectAtTagRowSection selectAtTagRowSection, CheckinPlaceModel checkinPlaceModel, @Nullable ContentView contentView, Bitmap bitmap) {
        contentView.setTitleText(CheckinTextModifier.m22088a(selectAtTagRowSection.f18028h, checkinPlaceModel.j(), selectAtTagRowSection.f18027g));
        contentView.setSubtitleText(selectAtTagRowSection.f18030j ? contentView.getContext().getResources().getString(2131235322) : selectAtTagRowSection.m21982a(checkinPlaceModel, bitmap, contentView.getSubitleLayout()));
        contentView.setSubtitleTextAppearance(selectAtTagRowSection.f18030j ? 2131625494 : 2131624222);
        Uri parse = (checkinPlaceModel.d() == null || checkinPlaceModel.d().a() == null) ? null : Uri.parse(checkinPlaceModel.d().a());
        contentView.setThumbnailUri(parse);
        contentView.f.setBackgroundDrawable(selectAtTagRowSection.f18023c.getResources().getDrawable(2130842670));
    }

    private SpannableStringBuilder m21982a(CheckinPlaceModel checkinPlaceModel, @Nullable Bitmap bitmap, Layout layout) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        if (FlowLogicTestHelper.m22091a(checkinPlaceModel, this.f18033m)) {
            FlowableTaggableActivityModel g = checkinPlaceModel.g();
            if (!(g == null || StringUtil.a(g.a()) || g.g() == null)) {
                spannableStringBuilder.append(g.a()).append(" · ");
            }
        }
        CharSequence a = m21984a(checkinPlaceModel);
        if (!a.isEmpty()) {
            spannableStringBuilder.append(a).append(" · ");
        }
        spannableStringBuilder.append(m21986b(checkinPlaceModel));
        if (bitmap != null) {
            spannableStringBuilder.insert(0, "  ");
            Drawable bitmapDrawable = new BitmapDrawable(bitmap);
            float abs = ((float) Math.abs(layout.getLineAscent(0))) * 0.8f;
            bitmapDrawable.setBounds(0, 0, (int) ((abs / ((float) bitmap.getHeight())) * ((float) bitmap.getWidth())), (int) abs);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 1), 0, 1, 33);
        }
        return spannableStringBuilder;
    }

    private String m21986b(CheckinPlaceModel checkinPlaceModel) {
        if (checkinPlaceModel.m() == GraphQLPlaceType.RESIDENCE) {
            return checkinPlaceModel.ce_();
        }
        NumberFormat instance = NumberFormat.getInstance(this.f18028h);
        return this.f18023c.getResources().getQuantityString(2131689607, checkinPlaceModel.k() == null ? 0 : checkinPlaceModel.k().a(), new Object[]{instance.format((long) (checkinPlaceModel.k() == null ? 0 : checkinPlaceModel.k().a()))});
    }
}
