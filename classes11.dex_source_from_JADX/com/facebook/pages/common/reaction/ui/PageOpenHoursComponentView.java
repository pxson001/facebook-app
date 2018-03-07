package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.BetterTextView;

/* compiled from: search_error */
public class PageOpenHoursComponentView extends SegmentedLinearLayout {
    private final int f2210a;
    private final int f2211b;
    public BetterTextView f2212c = ((BetterTextView) a(2131564409));
    public BetterTextView f2213d = ((BetterTextView) a(2131564410));

    /* compiled from: search_error */
    public /* synthetic */ class C02791 {
        public static final /* synthetic */ int[] f2209a = new int[GraphQLPageOpenHoursDisplayDecisionEnum.values().length];

        static {
            try {
                f2209a[GraphQLPageOpenHoursDisplayDecisionEnum.SHOW_AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2209a[GraphQLPageOpenHoursDisplayDecisionEnum.SHOW_UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2209a[GraphQLPageOpenHoursDisplayDecisionEnum.SHOW_UNDETERMINED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public PageOpenHoursComponentView(Context context) {
        super(context);
        Resources resources = getResources();
        this.f2210a = resources.getDimensionPixelSize(2131429798);
        this.f2211b = resources.getDimensionPixelSize(2131429797);
        CustomViewUtils.b(this, resources.getDrawable(2130842474));
        setContentView(2130905552);
        setPadding(this.f2211b, this.f2210a, this.f2211b, this.f2210a);
        setSegmentedDivider(new ColorDrawable(resources.getColor(2131361956)));
        setSegmentedDividerThickness(resources.getDimensionPixelSize(2131427380));
        setSegmentedDividerPadding(this.f2210a);
    }

    protected void onMeasure(int i, int i2) {
        setOrientation(0);
        setShowSegmentedDividers(2);
        this.f2212c.setPadding(0, this.f2210a, this.f2211b, this.f2210a);
        this.f2213d.setPadding(this.f2211b, this.f2210a, 0, this.f2210a);
        super.onMeasure(i, i2);
        if (this.f2213d.getVisibility() == 0) {
            if (this.f2212c.getLineCount() > 1 || this.f2213d.getLineCount() > 1) {
                setOrientation(1);
                setShowSegmentedDividers(0);
                this.f2212c.setPadding(0, this.f2210a, 0, 0);
                this.f2213d.setPadding(0, 0, 0, this.f2210a);
                super.onMeasure(i, i2);
            }
        }
    }
}
