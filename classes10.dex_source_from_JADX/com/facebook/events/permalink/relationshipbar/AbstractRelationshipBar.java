package com.facebook.events.permalink.relationshipbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
import android.text.TextUtils.TruncateAt;
import android.view.View.MeasureSpec;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.events.socialcontext.EventSocialContextFormatter;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: background_location_settings_perf_overall_tti */
public abstract class AbstractRelationshipBar extends CustomLinearLayout {
    @Inject
    public EventSocialContextFormatter f18823a;
    @Inject
    public Resources f18824b;
    private TextLayoutBuilder f18825c;
    private Layout f18826d;
    private Paint f18827e;
    private int f18828f;
    private int f18829g;

    public static void m19123a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AbstractRelationshipBar abstractRelationshipBar = (AbstractRelationshipBar) obj;
        EventSocialContextFormatter b = EventSocialContextFormatter.b(fbInjector);
        Resources a = ResourcesMethodAutoProvider.a(fbInjector);
        abstractRelationshipBar.f18823a = b;
        abstractRelationshipBar.f18824b = a;
    }

    public abstract void mo849a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams);

    public AbstractRelationshipBar(Context context) {
        super(context);
    }

    public void setContentView(int i) {
        Class cls = AbstractRelationshipBar.class;
        m19123a(this, getContext());
        super.setContentView(i);
        setGravity(1);
        setBackgroundResource(2131361920);
        int dimensionPixelSize = this.f18824b.getDimensionPixelSize(2131431150);
        int dimensionPixelSize2 = this.f18824b.getDimensionPixelSize(2131431152);
        int dimensionPixelSize3 = this.f18824b.getDimensionPixelSize(2131431153);
        setPadding(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
        this.f18829g = this.f18824b.getDimensionPixelSize(2131431151);
        this.f18827e = new Paint();
        this.f18827e.setStyle(Style.STROKE);
        this.f18827e.setColor(this.f18824b.getColor(2131363142));
        this.f18827e.setStrokeWidth((float) this.f18824b.getDimensionPixelSize(2131431154));
        this.f18825c = new TextLayoutBuilder().e(2).a(TruncateAt.END).b(this.f18824b.getDimensionPixelSize(2131427402)).c(this.f18824b.getColor(2131361937));
    }

    @TargetApi(17)
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        this.f18828f = i2;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        this.f18828f = i2;
    }

    public void setSocialSentence(CharSequence charSequence) {
        this.f18825c.a(charSequence);
    }

    public CharSequence getContentDescription() {
        CharSequence a = this.f18825c.a();
        if (a != null) {
            return a + "\n" + super.getContentDescription();
        }
        return super.getContentDescription();
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        if (size > 0) {
            this.f18825c.a((size - getPaddingLeft()) - getPaddingRight());
            this.f18826d = this.f18825c.d();
            super.setPadding(getPaddingLeft(), (this.f18826d == null ? 0 : this.f18828f + this.f18826d.getHeight()) + this.f18829g, getPaddingRight(), getPaddingBottom());
        } else {
            this.f18826d = null;
        }
        super.onMeasure(i, i2);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        float strokeWidth = ((float) height) - this.f18827e.getStrokeWidth();
        canvas.drawLine(0.0f, strokeWidth, (float) width, strokeWidth, this.f18827e);
        Layout layout = this.f18826d;
        if (layout != null && layout.getLineCount() > 0) {
            Object obj;
            height = getPaddingLeft();
            int paddingRight = getPaddingRight();
            float lineWidth = ((float) ((width - height) - paddingRight)) - layout.getLineWidth(0);
            if (ViewCompat.h(this) == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                height = paddingRight;
            }
            canvas.translate(((float) height) + (lineWidth / 2.0f), (float) this.f18828f);
            layout.draw(canvas);
        }
        canvas.restore();
    }
}
