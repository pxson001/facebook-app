package com.facebook.events.dashboard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.text.TextUtilsCompat;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventCountsQueryModel.EventCountsModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Supplier;
import java.util.Locale;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: commerce_product_adapter */
public class EventsDashboardFilterView extends FbTextView implements OnClickListener {
    @Inject
    EventsDashboardCaspianPagerController f16585a;
    @Inject
    EventEventLogger f16586b;
    @Inject
    NumberTruncationUtil f16587c;
    private boolean f16588d;
    private int f16589e;
    private int f16590f;
    private int f16591g;
    private int f16592h;
    private Path f16593i;
    private Paint f16594j;
    public DashboardFilterType f16595k;
    public OnFilterTypeChangedListener f16596l;
    public Supplier<EventCountsModel> f16597m;

    /* compiled from: commerce_product_adapter */
    class FilterTypeOnClickListener implements OnMenuItemClickListener {
        final /* synthetic */ EventsDashboardFilterView f16583a;
        private DashboardFilterType f16584b;

        FilterTypeOnClickListener(EventsDashboardFilterView eventsDashboardFilterView, DashboardFilterType dashboardFilterType) {
            this.f16583a = eventsDashboardFilterView;
            this.f16584b = dashboardFilterType;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (!(this.f16583a.f16596l == null || this.f16583a.f16595k == this.f16584b)) {
                this.f16583a.setDashboardFilterType(this.f16584b);
                this.f16583a.f16586b.m18141c(this.f16584b.name());
                this.f16583a.f16596l.mo789a(this.f16583a.f16595k);
            }
            return true;
        }
    }

    /* compiled from: commerce_product_adapter */
    public interface OnFilterTypeChangedListener {
        void mo789a(@Nonnull DashboardFilterType dashboardFilterType);
    }

    private static <T extends View> void m16992a(Class<T> cls, T t) {
        m16993a((Object) t, t.getContext());
    }

    private static void m16993a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventsDashboardFilterView) obj).m16991a(EventsDashboardCaspianPagerController.m16972a(fbInjector), EventEventLogger.m18119b(fbInjector), NumberTruncationUtil.a(fbInjector));
    }

    private void m16991a(EventsDashboardCaspianPagerController eventsDashboardCaspianPagerController, EventEventLogger eventEventLogger, NumberTruncationUtil numberTruncationUtil) {
        this.f16585a = eventsDashboardCaspianPagerController;
        this.f16586b = eventEventLogger;
        this.f16587c = numberTruncationUtil;
    }

    public final void m16999a(@Nonnull Supplier<EventCountsModel> supplier) {
        this.f16597m = supplier;
    }

    public EventsDashboardFilterView(Context context) {
        super(context);
        m16989a(context);
    }

    public EventsDashboardFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16989a(context);
    }

    public EventsDashboardFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16989a(context);
    }

    private void m16989a(Context context) {
        m16992a(EventsDashboardFilterView.class, (View) this);
        this.f16588d = this.f16585a.m16974a();
        m16998b(context);
        m16997b();
    }

    private void m16998b(Context context) {
        Resources resources = context.getResources();
        this.f16589e = resources.getDimensionPixelSize(2131427421);
        this.f16590f = resources.getDimensionPixelSize(2131431184);
        this.f16591g = resources.getDimensionPixelSize(2131431185);
        this.f16592h = resources.getDimensionPixelSize(2131431186);
        this.f16594j = new Paint();
        this.f16594j.setColor(getResources().getColor(2131361939));
        this.f16593i = m16986a(this.f16591g, this.f16590f);
    }

    private static Path m16986a(int i, int i2) {
        Path path = new Path();
        path.lineTo((float) i2, 0.0f);
        path.lineTo((float) (i2 / 2), (float) i);
        path.close();
        return path;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m16990a(canvas);
    }

    private void m16990a(Canvas canvas) {
        canvas.save();
        int i = this.f16590f;
        int width = getWidth();
        int height = getHeight();
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        int compoundPaddingRight = super.getCompoundPaddingRight();
        canvas.translate((float) getScrollX(), (float) getScrollY());
        int lineWidth = (int) getLayout().getLineWidth(0);
        canvas.translate((float) (m16994a() ? (lineWidth + compoundPaddingLeft) + this.f16589e : (((width - lineWidth) - compoundPaddingRight) - i) - this.f16589e), (float) (((((getTotalPaddingTop() + height) - getTotalPaddingBottom()) - this.f16591g) / 2) + this.f16592h));
        canvas.drawPath(this.f16593i, this.f16594j);
        canvas.restore();
    }

    private static boolean m16994a() {
        return TextUtilsCompat.a(Locale.getDefault()) == 0;
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        if (m16994a()) {
            return compoundPaddingLeft;
        }
        return (compoundPaddingLeft + this.f16589e) + this.f16590f;
    }

    public int getCompoundPaddingRight() {
        int compoundPaddingRight = super.getCompoundPaddingRight();
        if (m16994a()) {
            return (compoundPaddingRight + this.f16589e) + this.f16590f;
        }
        return compoundPaddingRight;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 411739038);
        super.onAttachedToWindow();
        setOnClickListener(this);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 370525201, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1830576661);
        setOnClickListener(null);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 691148117, a);
    }

    private String m16988a(DashboardFilterType dashboardFilterType) {
        if (this.f16597m == null || this.f16597m.get() == null) {
            return null;
        }
        int a = ((EventCountsModel) this.f16597m.get()).a();
        return (dashboardFilterType != DashboardFilterType.INVITED || a == 0) ? null : this.f16587c.a(a);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1846861882);
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(getContext());
        PopoverMenu c = figPopoverMenuWindow.c();
        for (DashboardFilterType dashboardFilterType : DashboardFilterType.values()) {
            if (this.f16588d || dashboardFilterType != DashboardFilterType.BIRTHDAYS) {
                boolean z;
                MenuItemImpl a2 = c.a(dashboardFilterType.menuStringResId);
                a2.b(m16988a(dashboardFilterType));
                a2.setIcon(m16995b(dashboardFilterType));
                a2.setCheckable(true);
                if (dashboardFilterType == this.f16595k) {
                    z = true;
                } else {
                    z = false;
                }
                a2.setChecked(z);
                a2.setOnMenuItemClickListener(new FilterTypeOnClickListener(this, dashboardFilterType));
            }
        }
        figPopoverMenuWindow.e = false;
        figPopoverMenuWindow.f(this);
        LogUtils.a(-633499217, a);
    }

    public void setDashboardFilterType(DashboardFilterType dashboardFilterType) {
        this.f16595k = dashboardFilterType;
        m16997b();
    }

    public DashboardFilterType getDashboardFilterType() {
        return this.f16595k;
    }

    public void setOnFilterTypeChangedListener(OnFilterTypeChangedListener onFilterTypeChangedListener) {
        this.f16596l = onFilterTypeChangedListener;
    }

    private void m16997b() {
        if (this.f16595k != null) {
            setText(this.f16595k.menuStringResId);
        }
    }

    private int m16995b(@Nonnull DashboardFilterType dashboardFilterType) {
        return this.f16595k == dashboardFilterType ? dashboardFilterType.selectedIconResId : dashboardFilterType.iconResId;
    }
}
