package com.facebook.richdocument.view.performance;

import android.view.ViewGroup;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.inject.Assisted;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.widget.viewadapterpreallocator.PreallocatingAdapter;
import com.facebook.widget.viewadapterpreallocator.ViewAdapterPreallocator;
import com.facebook.widget.viewadapterpreallocator.ViewAllocations;
import javax.inject.Inject;

/* compiled from: page_call_to_action_tag */
public class BlocksPreInflater extends ViewAdapterPreallocator implements IncrementalUiIdleJob {
    private boolean f6903c = false;

    @Inject
    public BlocksPreInflater(@Assisted PreallocatingAdapter preallocatingAdapter, @Assisted ViewGroup viewGroup, @Assisted Integer num, DefaultProcessIdleExecutor defaultProcessIdleExecutor) {
        super(preallocatingAdapter, viewGroup, num, defaultProcessIdleExecutor);
    }

    protected final void m7145f() {
        int i;
        for (Integer intValue : this.b.keySet()) {
            c(intValue.intValue()).c = 0;
        }
        int aZ_ = this.a.aZ_();
        int e = e();
        for (i = 0; i < e; i++) {
            b(i);
        }
        int i2 = 1;
        for (i = e(); i < aZ_; i++) {
            e = this.a.getItemViewType(i2 - 1);
            ViewAllocations c = c(e);
            if (!RichDocumentUIConfig.f6547R.contains(Integer.valueOf(e))) {
                c.c--;
            }
            b(i);
            i2++;
        }
    }

    public final boolean mo409i() {
        return !this.f6903c || super.h();
    }

    public final void mo410j() {
        if (this.f6903c) {
            g();
            return;
        }
        b();
        this.f6903c = true;
    }

    protected final void m7144c() {
    }
}
