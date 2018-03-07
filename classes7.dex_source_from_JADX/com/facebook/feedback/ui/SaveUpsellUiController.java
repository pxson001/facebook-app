package com.facebook.feedback.ui;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.common.util.FindViewUtil;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.ui.BaseFeedbackFragment.C03558.C03541;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: rotateY */
public class SaveUpsellUiController {
    public final QeAccessor f4694a;
    public Snackbar f4695b;
    public View f4696c;

    public static SaveUpsellUiController m5223a(InjectorLike injectorLike) {
        return new SaveUpsellUiController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SaveUpsellUiController(QeAccessor qeAccessor) {
        this.f4694a = qeAccessor;
    }

    public final void m5226a(View view, final C03541 c03541) {
        if (m5224b()) {
            Resources resources = view.getResources();
            this.f4695b = Snackbar.a(view, view.getResources().getText(2131233349), this.f4694a.a(ExperimentsForFeedbackTestModule.ab, 5000));
            this.f4695b.a(2131230735, new OnClickListener(this) {
                final /* synthetic */ SaveUpsellUiController f4689b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 677388776);
                    c03541.m4717a();
                    Toast.makeText(view.getContext(), 2131233350, 1).show();
                    Logger.a(2, EntryType.UI_INPUT_END, -301396130, a);
                }
            });
            View view2 = this.f4695b.d;
            view2.setBackgroundDrawable(new ColorDrawable(resources.getColor(2131361917)));
            ((TextView) FindViewUtil.b(view2, 2131560959)).setTextColor(-1);
            ((Button) FindViewUtil.b(view2, 2131560689)).setAllCaps(true);
            this.f4695b.a(-1);
            this.f4695b.b();
            return;
        }
        this.f4696c = ((ViewStub) FindViewUtil.b(view, 2131562061)).inflate();
        final TextView textView = (TextView) FindViewUtil.b(this.f4696c, 2131562062);
        view2 = FindViewUtil.b(this.f4696c, 2131562063);
        view2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SaveUpsellUiController f4693d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1412652547);
                c03541.m4717a();
                textView.setText(2131233350);
                view2.setVisibility(4);
                Logger.a(2, EntryType.UI_INPUT_END, -289211965, a);
            }
        });
    }

    private boolean m5224b() {
        return this.f4694a.a(ExperimentsForFeedbackTestModule.ad, false);
    }

    public final void m5225a() {
        if (m5224b()) {
            if (this.f4695b != null) {
                Snackbar.d(this.f4695b, 3);
            }
        } else if (this.f4696c != null) {
            this.f4696c.setVisibility(8);
        }
    }
}
