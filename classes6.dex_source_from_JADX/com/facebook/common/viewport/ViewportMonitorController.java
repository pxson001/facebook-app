package com.facebook.common.viewport;

import android.database.DataSetObserver;
import android.widget.BaseAdapter;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.inject.Inject;

/* compiled from: place_picker_nonintrusive_error_button_location_settings */
public class ViewportMonitorController<T> {
    public final ViewportMonitor f7772a;
    public final ListDataSetObserver f7773b = new ListDataSetObserver(this);
    public ScrollingViewProxy f7774c;
    public BaseAdapter f7775d;
    private final QeAccessor f7776e;

    /* compiled from: place_picker_nonintrusive_error_button_location_settings */
    class ListDataSetObserver extends DataSetObserver {
        final /* synthetic */ ViewportMonitorController f7771a;

        public ListDataSetObserver(ViewportMonitorController viewportMonitorController) {
            this.f7771a = viewportMonitorController;
        }

        public void onChanged() {
            this.f7771a.f7772a.a(this.f7771a.f7774c);
        }
    }

    public static ViewportMonitorController m11094a(InjectorLike injectorLike) {
        return new ViewportMonitorController(ViewportMonitor.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ViewportMonitorController(ViewportMonitor viewportMonitor, QeAccessor qeAccessor) {
        this.f7772a = viewportMonitor;
        this.f7776e = qeAccessor;
    }
}
