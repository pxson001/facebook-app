package com.facebook.entitycardsplugins.person.widget.footer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.entitycards.analytics.EntityCardsAnalytics.TapSurfaces;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.presenter.Presenter;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Absent;

/* compiled from: heisman_entry_point */
public class PersonCardFooterView extends FbTextView {
    public PersonCardFooterPresenter f11400a;
    private Paint f11401b;
    private final OnClickListener f11402c = new C12421(this);

    /* compiled from: heisman_entry_point */
    class C12421 implements OnClickListener {
        final /* synthetic */ PersonCardFooterView f11399a;

        C12421(PersonCardFooterView personCardFooterView) {
            this.f11399a = personCardFooterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1024873203);
            if (this.f11399a.f11400a != null) {
                Presenter presenter = this.f11399a.f11400a;
                PersonCardFooterView personCardFooterView = this.f11399a;
                if (presenter.m13032c(personCardFooterView)) {
                    presenter.f11396b.m12795a(TapSurfaces.DEFAULT_ACTION, presenter.f11397c.m13204r(), Absent.INSTANCE, Absent.INSTANCE);
                    presenter.f11396b.m12796a(presenter.f11397c.m13204r());
                    presenter.f11395a.m13088a(personCardFooterView.getContext(), presenter.f11397c);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 360407033, a);
        }
    }

    public PersonCardFooterView(Context context) {
        super(context);
        m13325a();
    }

    public PersonCardFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13325a();
    }

    private void m13325a() {
        this.f11401b = new Paint(1);
        this.f11401b.setColor(getResources().getColor(2131362991));
        this.f11401b.setStrokeWidth(0.0f);
    }

    public void setPresenter(PersonCardFooterPresenter personCardFooterPresenter) {
        this.f11400a = personCardFooterPresenter;
    }

    public void setupFooter(String str) {
        setText(str);
        setOnClickListener(this.f11402c);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1171931894);
        super.onDetachedFromWindow();
        if (this.f11400a != null) {
            this.f11400a.mo790b(this);
            this.f11400a = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1223819082, a);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0.0f, 1.0f, (float) getWidth(), 1.0f, this.f11401b);
    }
}
