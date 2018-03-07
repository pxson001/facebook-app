package com.facebook.crowdsourcing.placequestion;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.inject.FbInjector;
import com.facebook.maps.FbStaticMapView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.groups */
public class PlaceQuestionView extends CustomLinearLayout {
    @Inject
    public RTLUtil f17529a;
    private TextWithEntitiesView f17530b;
    private TextWithEntitiesView f17531c;
    private TextWithEntitiesView f17532d;
    private FbDraweeView f17533e;
    private FbStaticMapView f17534f;
    private ImageBlockLayout f17535g;
    private TextView f17536h;
    private FbDraweeView f17537i;
    private TextView f17538j;
    private TextView f17539k;
    private View f17540l;
    private SegmentedLinearLayout f17541m;
    private int f17542n;
    private int f17543o;
    private int f17544p;
    private int f17545q;

    /* compiled from: com.facebook.groups */
    class AnswerBackgoundDrawable extends StateListDrawable {
        public AnswerBackgoundDrawable(int i, int i2) {
            Drawable paintDrawable = new PaintDrawable(i);
            Drawable paintDrawable2 = new PaintDrawable(i2);
            float[] fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            paintDrawable.setCornerRadii(fArr);
            paintDrawable2.setCornerRadii(fArr);
            addState(new int[]{-16842919}, paintDrawable);
            addState(new int[]{16842919}, paintDrawable2);
        }
    }

    private static <T extends View> void m21416a(Class<T> cls, T t) {
        m21417a((Object) t, t.getContext());
    }

    private static void m21417a(Object obj, Context context) {
        ((PlaceQuestionView) obj).f17529a = RTLUtil.a(FbInjector.get(context));
    }

    public PlaceQuestionView(Context context) {
        super(context);
        m21413a();
    }

    public PlaceQuestionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21413a();
    }

    public final void m21423c(int i) {
        this.f17541m.removeAllViews();
        this.f17542n = i;
        this.f17540l.setVisibility(i == 0 ? 0 : 8);
        this.f17541m.setOrientation(i);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(i == 0 ? 2131432730 : 2131432731);
        this.f17541m.a(dimensionPixelOffset, dimensionPixelOffset);
    }

    public void setTitle(@Nullable DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        if (defaultTextWithEntitiesLongFields != null) {
            this.f17530b.setTextWithEntities(defaultTextWithEntitiesLongFields);
        }
        this.f17530b.setVisibility(m21418a(defaultTextWithEntitiesLongFields) ? 0 : 8);
    }

    public void setDetails(@Nullable DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        if (defaultTextWithEntitiesLongFields != null) {
            this.f17531c.setTextWithEntities(defaultTextWithEntitiesLongFields);
        }
        this.f17531c.setVisibility(m21418a(defaultTextWithEntitiesLongFields) ? 0 : 8);
    }

    public void setSubtitle(@Nullable DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        if (defaultTextWithEntitiesLongFields != null) {
            this.f17532d.setTextWithEntities(defaultTextWithEntitiesLongFields);
        }
        this.f17532d.setVisibility(m21418a(defaultTextWithEntitiesLongFields) ? 0 : 8);
    }

    public void setPhoto(@Nullable Uri uri) {
        int i = this.f17533e.getResources().getDisplayMetrics().widthPixels / 2;
        this.f17533e.getLayoutParams().width = i;
        this.f17533e.getLayoutParams().height = i;
        this.f17533e.a(uri, CallerContext.a(PlaceQuestionView.class));
        this.f17533e.setVisibility(uri != null ? 0 : 8);
    }

    public void setMapVisible(boolean z) {
        this.f17534f.setVisibility(z ? 0 : 8);
    }

    public final void m21420a(double d, double d2, int i) {
        this.f17534f.setMapOptions(new StaticMapOptions("places_feed_place_question").a(d, d2).a(i));
    }

    public void setPlaceDetailsVisible(boolean z) {
        this.f17535g.setVisibility(z ? 0 : 8);
    }

    public void setPlaceName(String str) {
        this.f17536h.setText(str);
    }

    public void setProfilePicture(@Nullable Uri uri) {
        if (uri == null) {
            this.f17537i.setImageDrawable(getResources().getDrawable(2130842656));
            this.f17537i.setScaleType(ScaleType.CENTER);
            return;
        }
        this.f17537i.a(uri, CallerContext.a(PlaceQuestionView.class));
        this.f17537i.setScaleType(ScaleType.CENTER_INSIDE);
    }

    public void setPlaceCategories(String str) {
        this.f17538j.setText(str);
    }

    public void setPlaceAddress(String str) {
        this.f17539k.setText(str);
    }

    public void setMapOnClickListener(OnClickListener onClickListener) {
        this.f17534f.setOnClickListener(onClickListener);
    }

    public final void m21421a(String str, OnClickListener onClickListener, int i) {
        m21412a(str, onClickListener, i == -1, i).setCheckBoxVisibility(8);
    }

    public final void m21422a(String str, OnClickListener onClickListener, boolean z) {
        m21412a(str, onClickListener, z, -1);
    }

    private PlaceQuestionAnswerView m21412a(String str, OnClickListener onClickListener, boolean z, int i) {
        PlaceQuestionAnswerView placeQuestionAnswerView = this.f17542n == 1 ? (PlaceQuestionAnswerView) LayoutInflater.from(getContext()).inflate(2130906260, this, false) : (PlaceQuestionAnswerView) LayoutInflater.from(getContext()).inflate(2130906259, this, false);
        placeQuestionAnswerView.setAnswerLabel(str);
        placeQuestionAnswerView.setOnClickListener(onClickListener);
        m21415a(placeQuestionAnswerView, z);
        this.f17541m.addView(placeQuestionAnswerView, i);
        return placeQuestionAnswerView;
    }

    private void m21415a(PlaceQuestionAnswerView placeQuestionAnswerView, boolean z) {
        m21419b(placeQuestionAnswerView, z);
        CustomViewUtils.a(placeQuestionAnswerView, new AnswerBackgoundDrawable(this.f17543o, this.f17544p));
    }

    private void m21419b(PlaceQuestionAnswerView placeQuestionAnswerView, boolean z) {
        int i = 0;
        if (this.f17542n != 1) {
            int i2;
            int i3;
            if (this.f17541m.getChildCount() == 0) {
                i2 = this.f17545q;
            } else {
                i2 = 0;
            }
            if (z) {
                i = this.f17545q;
            }
            boolean a = this.f17529a.a();
            int paddingLeft = placeQuestionAnswerView.getPaddingLeft();
            if (a) {
                i3 = i;
            } else {
                i3 = i2;
            }
            i3 += paddingLeft;
            paddingLeft = placeQuestionAnswerView.getPaddingTop();
            int paddingRight = placeQuestionAnswerView.getPaddingRight();
            if (!a) {
                i2 = i;
            }
            placeQuestionAnswerView.setPadding(i3, paddingLeft, paddingRight + i2, placeQuestionAnswerView.getPaddingBottom());
        }
    }

    private void m21413a() {
        m21416a(PlaceQuestionView.class, (View) this);
        setFocusableInTouchMode(true);
        this.f17543o = getResources().getColor(2131361920);
        this.f17544p = getResources().getColor(2131361941);
        this.f17545q = getResources().getDimensionPixelSize(2131432731);
        setOrientation(1);
        setContentView(2130906261);
        this.f17530b = (TextWithEntitiesView) a(2131565988);
        this.f17531c = (TextWithEntitiesView) a(2131565989);
        this.f17532d = (TextWithEntitiesView) a(2131565990);
        this.f17533e = (FbDraweeView) a(2131565991);
        this.f17534f = (FbStaticMapView) a(2131565992);
        this.f17535g = (ImageBlockLayout) a(2131565993);
        this.f17536h = (TextView) a(2131565995);
        this.f17537i = (FbDraweeView) a(2131565994);
        this.f17538j = (TextView) a(2131565996);
        this.f17539k = (TextView) a(2131565997);
        this.f17540l = a(2131565999);
        this.f17541m = (SegmentedLinearLayout) a(2131566000);
        m21423c(0);
    }

    private static boolean m21418a(@Nullable DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        return (defaultTextWithEntitiesLongFields == null || Strings.isNullOrEmpty(defaultTextWithEntitiesLongFields.a())) ? false : true;
    }

    private void m21414a(RTLUtil rTLUtil) {
        this.f17529a = rTLUtil;
    }
}
