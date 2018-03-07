package com.facebook.crudolib.dao.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.crudolib.dao.DAOItem;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: TreehouseTTNotifCold */
public abstract class OnDAOItemClickListener<T extends DAOItem> implements OnClickListener {
    private int f23977a;
    private T f23978b;

    public abstract void m25927a(View view, T t);

    public final OnDAOItemClickListener<T> m25926a(T t, int i) {
        this.f23978b = t;
        this.f23977a = i;
        return this;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1905430582);
        IllegalStateException illegalStateException;
        if (this.f23978b == null) {
            illegalStateException = new IllegalStateException("DAOItem is null");
            Logger.a(2, EntryType.UI_INPUT_END, 2073171662, a);
            throw illegalStateException;
        } else if (this.f23978b.a(this.f23977a)) {
            m25927a(view, this.f23978b);
            LogUtils.a(-671119226, a);
        } else {
            illegalStateException = new IllegalStateException("Can't move dao to position: " + this.f23977a);
            LogUtils.a(706078062, a);
            throw illegalStateException;
        }
    }
}
