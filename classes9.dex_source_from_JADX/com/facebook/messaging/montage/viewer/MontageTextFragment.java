package com.facebook.messaging.montage.viewer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.montage.MontageMessagesHelper;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.Nullable;

/* compiled from: is_coworker */
public class MontageTextFragment extends AbstractMontageItemFragment {
    private TextView f12613h;

    /* compiled from: is_coworker */
    class C14151 implements OnClickListener {
        final /* synthetic */ MontageTextFragment f12612a;

        C14151(MontageTextFragment montageTextFragment) {
            this.f12612a = montageTextFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 991497720);
            this.f12612a.T.performClick();
            Logger.a(2, EntryType.UI_INPUT_END, 1401564292, a);
        }
    }

    protected final void mo492a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f12613h = (TextView) FindViewUtil.b(layoutInflater.inflate(2130905341, viewGroup, true), 2131560151);
        this.f12613h.setOnClickListener(new C14151(this));
    }

    public final void mo497d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1744855935);
        super.mo497d(bundle);
        HandlerDetour.a(this.f12572b, this.aB);
        HandlerDetour.a(this.f12572b, this.aC, 2134122628);
        this.f12613h.setText(this.f12577g.f12555b.f);
        aA();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1896155395, a);
    }

    protected final void aq() {
        m13023a(MontageMessagesHelper.m12855a(this.f12577g.f12555b.f));
    }

    protected final void ar() {
    }
}
