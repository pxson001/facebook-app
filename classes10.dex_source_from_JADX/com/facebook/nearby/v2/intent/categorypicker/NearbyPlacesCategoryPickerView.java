package com.facebook.nearby.v2.intent.categorypicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.intent.categorypicker.icons.NearbyPlacesCategoryPickerIconType;
import com.facebook.nearby.v2.intent.categorypicker.icons.NearbyPlacesCategoryPickerIconView;
import com.facebook.nearby.v2.intent.categorypicker.icons.NearbyPlacesCategoryPickerIconViewFactory;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;

/* compiled from: people_tab_upload_upsell */
public class NearbyPlacesCategoryPickerView extends CustomFrameLayout {
    public static final NearbyPlacesCategoryPickerIconType[] f5141a;
    public static final int f5142b;
    public OnClickCategoryPickerIconListener f5143c;
    public TableLayout f5144d;
    public final OnClickListener f5145e;

    /* compiled from: people_tab_upload_upsell */
    public interface OnClickCategoryPickerIconListener {
        void mo139a(NearbyPlacesCategoryPickerIconType nearbyPlacesCategoryPickerIconType);
    }

    /* compiled from: people_tab_upload_upsell */
    class C07131 implements OnClickListener {
        final /* synthetic */ NearbyPlacesCategoryPickerView f5140a;

        C07131(NearbyPlacesCategoryPickerView nearbyPlacesCategoryPickerView) {
            this.f5140a = nearbyPlacesCategoryPickerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 364492750);
            if (this.f5140a.f5143c == null || view == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1941267971, a);
                return;
            }
            Preconditions.checkArgument(view instanceof NearbyPlacesCategoryPickerIconView);
            this.f5140a.f5143c.mo139a(((NearbyPlacesCategoryPickerIconView) view).f5149c);
            LogUtils.a(1465198716, a);
        }
    }

    static {
        NearbyPlacesCategoryPickerIconType[] nearbyPlacesCategoryPickerIconTypeArr = new NearbyPlacesCategoryPickerIconType[]{NearbyPlacesCategoryPickerIconType.ALL, NearbyPlacesCategoryPickerIconType.RESTAURANTS, NearbyPlacesCategoryPickerIconType.COFFEE, NearbyPlacesCategoryPickerIconType.NIGHTLIFE, NearbyPlacesCategoryPickerIconType.OUTDOORS, NearbyPlacesCategoryPickerIconType.ARTS, NearbyPlacesCategoryPickerIconType.HOTELS, NearbyPlacesCategoryPickerIconType.SHOPPING};
        f5141a = nearbyPlacesCategoryPickerIconTypeArr;
        f5142b = (int) Math.ceil((double) (((float) nearbyPlacesCategoryPickerIconTypeArr.length) / 4.0f));
    }

    public NearbyPlacesCategoryPickerView(Context context) {
        this(context, null);
    }

    private NearbyPlacesCategoryPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private NearbyPlacesCategoryPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5145e = new C07131(this);
        setContentView(2130905391);
        this.f5144d = (TableLayout) c(2131564111);
        Context context2 = getContext();
        for (int i2 = 0; i2 < f5142b; i2++) {
            View tableRow = new TableRow(context2);
            for (int i3 = 0; i3 < 4; i3++) {
                NearbyPlacesCategoryPickerIconView a = NearbyPlacesCategoryPickerIconViewFactory.m4641a(f5141a[(i2 * 4) + i3], context2);
                a.setOnClickListener(this.f5145e);
                a.setLayoutParams(new LayoutParams(0, -2, 1.0f));
                tableRow.addView(a);
            }
            this.f5144d.addView(tableRow, new TableLayout.LayoutParams(-1, -2));
        }
    }
}
