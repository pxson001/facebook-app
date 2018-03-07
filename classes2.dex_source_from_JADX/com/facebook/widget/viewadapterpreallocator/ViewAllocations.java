package com.facebook.widget.viewadapterpreallocator;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.google.common.base.Throwables;
import java.util.Stack;
import java.util.concurrent.Callable;

/* compiled from: is_deactivated_allowed_on_messenger */
public class ViewAllocations<VH extends ViewHolder> {
    protected int f19215a;
    protected int f19216b;
    public int f19217c;
    public Stack<VH> f19218d = new Stack();
    private Callable<VH> f19219e;

    protected ViewAllocations(Callable<VH> callable) {
        this.f19219e = callable;
    }

    public final void m26921b() {
        this.f19215a++;
        try {
            ViewHolder viewHolder = (ViewHolder) this.f19219e.call();
            if (viewHolder != null) {
                this.f19218d.push(viewHolder);
            }
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        }
    }
}
