package com.facebook.backstage.consumption;

import android.widget.LinearLayout;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: savedHeaderText */
public class BackstagePanelViewProvider extends AbstractAssistedProvider<BackstagePanelView> {
    public final BackstagePanelView m4507a(LinearLayout linearLayout) {
        return new BackstagePanelView(linearLayout, new TimeUtil((Clock) SystemClockMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this)));
    }
}
