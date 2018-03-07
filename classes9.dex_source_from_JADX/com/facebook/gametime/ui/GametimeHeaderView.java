package com.facebook.gametime.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLInterfaces.GametimeMatchHeaderFragment.SportsMatchData;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: TD;I */
public class GametimeHeaderView extends CustomLinearLayout {
    @Inject
    public AbstractFbErrorReporter f25079a;
    private String f25080b;
    private String f25081c;
    private BetterTextView f25082d;
    private BetterTextView f25083e;
    private BetterTextView f25084f;
    private BetterTextView f25085g;
    private BetterTextView f25086h;

    private static <T extends View> void m27078a(Class<T> cls, T t) {
        m27079a((Object) t, t.getContext());
    }

    private static void m27079a(Object obj, Context context) {
        ((GametimeHeaderView) obj).f25079a = (AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(context));
    }

    public GametimeHeaderView(Context context) {
        super(context);
        m27077a();
    }

    public GametimeHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27077a();
    }

    public GametimeHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27077a();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Style.FILL);
        int height = (int) ((0.2679492f * ((float) getHeight())) / 2.0f);
        int width = getWidth() / 2;
        try {
            Path path;
            if (this.f25080b != null) {
                paint.setColor(Color.parseColor(this.f25080b));
                path = new Path();
                path.moveTo(0.0f, 0.0f);
                path.lineTo(0.0f, (float) getHeight());
                path.lineTo((float) (width - height), (float) getHeight());
                path.lineTo((float) (width + height), 0.0f);
                path.close();
                canvas.drawPath(path, paint);
            }
            if (this.f25081c != null) {
                paint.setColor(Color.parseColor(this.f25081c));
                path = new Path();
                path.moveTo((float) getWidth(), 0.0f);
                path.lineTo((float) getWidth(), (float) getHeight());
                path.lineTo((float) (width - height), (float) getHeight());
                path.lineTo((float) (height + width), 0.0f);
                path.close();
                canvas.drawPath(path, paint);
            }
        } catch (Throwable e) {
            this.f25079a.a(SoftError.a("GametimeHeaderView", "Could not parse color for header").a(e).g());
        }
    }

    public void setMatchData(SportsMatchData sportsMatchData) {
        this.f25082d.setText(sportsMatchData.mo1164b().m26823a());
        this.f25084f.setText(sportsMatchData.mo1167g().m26839a());
        if (sportsMatchData.mB_()) {
            this.f25083e.setText(String.valueOf(sportsMatchData.mo1166d()));
            this.f25085g.setText(String.valueOf(sportsMatchData.mD_()));
        }
        this.f25086h.setText(sportsMatchData.mo1168j());
        this.f25080b = "#" + sportsMatchData.mo1165c();
        this.f25081c = "#" + sportsMatchData.mC_();
        invalidate();
    }

    private void m27077a() {
        m27078a(GametimeHeaderView.class, (View) this);
        setWillNotDraw(false);
        setContentView(2130904575);
        this.f25082d = (BetterTextView) a(2131562493);
        this.f25083e = (BetterTextView) a(2131562494);
        this.f25084f = (BetterTextView) a(2131562497);
        this.f25085g = (BetterTextView) a(2131562496);
        this.f25086h = (BetterTextView) a(2131562495);
    }
}
