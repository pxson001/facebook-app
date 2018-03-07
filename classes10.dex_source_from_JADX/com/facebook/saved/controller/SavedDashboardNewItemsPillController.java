package com.facebook.saved.controller;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;

/* compiled from: is_fallback */
public class SavedDashboardNewItemsPillController implements OnScrollListener {
    public View f9040a;
    public ViewStub f9041b;
    public SavedDataAndListStateController f9042c;

    /* compiled from: is_fallback */
    public class C13751 implements OnClickListener {
        final /* synthetic */ SavedDashboardNewItemsPillController f9039a;

        public C13751(SavedDashboardNewItemsPillController savedDashboardNewItemsPillController) {
            this.f9039a = savedDashboardNewItemsPillController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 907050175);
            SavedDashboardNewItemsPillController.m9059e(this.f9039a);
            Logger.a(2, EntryType.UI_INPUT_END, 1439100280, a);
        }
    }

    public static SavedDashboardNewItemsPillController m9058a(InjectorLike injectorLike) {
        return new SavedDashboardNewItemsPillController();
    }

    public final void m9061a(ScrollingViewProxy scrollingViewProxy, int i) {
    }

    public final void m9062a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        if (this.f9040a != null && this.f9040a.getVisibility() == 0 && i == 0) {
            m9059e(this);
        }
    }

    public final void m9063c() {
        m9060g();
    }

    public final void m9064d() {
        m9060g();
    }

    public static void m9059e(SavedDashboardNewItemsPillController savedDashboardNewItemsPillController) {
        savedDashboardNewItemsPillController.f9042c.m9092d();
        savedDashboardNewItemsPillController.m9060g();
    }

    private void m9060g() {
        if (this.f9040a != null) {
            this.f9040a.setVisibility(8);
            this.f9040a.setOnClickListener(null);
        }
    }
}
