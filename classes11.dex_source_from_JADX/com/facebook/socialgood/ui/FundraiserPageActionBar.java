package com.facebook.socialgood.ui;

import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar;
import com.facebook.inject.FbInjector;
import com.facebook.ultralight.Inject;
import java.util.ArrayList;

/* compiled from: OK */
public class FundraiserPageActionBar extends InlineActionBar {
    @Inject
    public FundraiserPageActionBarMenuHandler f12831a;
    private ArrayList<FundraiserPageActionBarButtonType> f12832b = new ArrayList();

    private static <T extends View> void m13494a(Class<T> cls, T t) {
        m13495a((Object) t, t.getContext());
    }

    private static void m13495a(Object obj, Context context) {
        ((FundraiserPageActionBar) obj).f12831a = FundraiserPageActionBarMenuHandler.m13500b(FbInjector.get(context));
    }

    public FundraiserPageActionBar(Context context) {
        super(context);
        m13492a();
    }

    public FundraiserPageActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13492a();
    }

    public FundraiserPageActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13492a();
    }

    private void m13492a() {
        m13494a(FundraiserPageActionBar.class, (View) this);
        setGravity(17);
        setBackgroundResource(2130843556);
        this.b = this.f12831a;
        setMaxNumOfVisibleButtons(3);
        a(false, true, 0);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams generateDefaultLayoutParams = super.generateDefaultLayoutParams();
        generateDefaultLayoutParams.height = -1;
        return generateDefaultLayoutParams;
    }

    public final void m13497a(String str, String str2, String str3, boolean z, String str4, String str5, String str6, int i, boolean z2, boolean z3) {
        b();
        clear();
        this.f12831a.m13501a(str, str2, str3, str4, str5, str6, i);
        this.f12832b = new ArrayList();
        this.f12832b.add(FundraiserPageActionBarButtonType.INVITE);
        this.f12832b.add(FundraiserPageActionBarButtonType.SHARE);
        this.f12832b.add(FundraiserPageActionBarButtonType.GO_TO_PAGE);
        if (!TextUtils.isEmpty(str6)) {
            this.f12832b.add(FundraiserPageActionBarButtonType.COPY_LINK);
        }
        if (z3) {
            this.f12832b.add(FundraiserPageActionBarButtonType.REPORT_FUNDRAISER);
        }
        int size = this.f12832b.size();
        for (int i2 = 0; i2 < size; i2++) {
            FundraiserPageActionBarButtonType fundraiserPageActionBarButtonType = (FundraiserPageActionBarButtonType) this.f12832b.get(i2);
            MenuItem icon = a(0, fundraiserPageActionBarButtonType.ordinal(), 0, fundraiserPageActionBarButtonType.getTitleResId()).setEnabled(m13496a(fundraiserPageActionBarButtonType, str, str2, str3, str6, z)).setCheckable(false).setIcon(fundraiserPageActionBarButtonType.getIconResId());
            if (fundraiserPageActionBarButtonType.isOverflow()) {
                MenuItemCompat.a(icon, 0);
            } else {
                MenuItemCompat.a(icon, 2);
            }
        }
        if (z2) {
            a(true, true, 0);
        }
        d();
        setVisibility(0);
    }

    private static boolean m13496a(FundraiserPageActionBarButtonType fundraiserPageActionBarButtonType, String str, String str2, String str3, String str4, boolean z) {
        switch (fundraiserPageActionBarButtonType) {
            case INVITE:
                if (!z || TextUtils.isEmpty(str)) {
                    return false;
                }
                return true;
            case SHARE:
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
                    return false;
                }
                return true;
            case GO_TO_PAGE:
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return false;
                }
                return true;
            case REPORT_FUNDRAISER:
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return true;
            case COPY_LINK:
                return !TextUtils.isEmpty(str4);
            default:
                return false;
        }
    }

    private void m13493a(FundraiserPageActionBarMenuHandler fundraiserPageActionBarMenuHandler) {
        this.f12831a = fundraiserPageActionBarMenuHandler;
    }
}
