package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.facebook.R;

/* compiled from: upsell_buy_confirm_impression */
public class ActionBarPolicy {
    public Context f707a;

    public static ActionBarPolicy m1276a(Context context) {
        return new ActionBarPolicy(context);
    }

    private ActionBarPolicy(Context context) {
        this.f707a = context;
    }

    public final boolean m1277d() {
        if (this.f707a.getApplicationInfo().targetSdkVersion >= 16) {
            return this.f707a.getResources().getBoolean(2131296256);
        }
        return this.f707a.getResources().getBoolean(2131296257);
    }

    public final int m1278e() {
        TypedArray obtainStyledAttributes = this.f707a.obtainStyledAttributes(null, R.styleable.ActionBar, 2130771984, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(0, 0);
        Resources resources = this.f707a.getResources();
        if (!m1277d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(2131427332));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public final int m1279g() {
        return this.f707a.getResources().getDimensionPixelSize(2131427331);
    }
}
