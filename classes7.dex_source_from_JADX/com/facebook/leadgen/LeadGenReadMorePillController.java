package com.facebook.leadgen;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.leadgen.event.LeadGenEventBus;
import com.facebook.leadgen.event.LeadGenEventSubscribers.SubmitButtonEnabledEventSubscriber;
import com.facebook.leadgen.event.LeadGenEvents.SubmitButtonEnabledEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.FbScrollView;
import javax.inject.Inject;

/* compiled from: place_delete_review_success */
public class LeadGenReadMorePillController {
    @Inject
    public LeadGenEventBus f6330a;
    public View f6331b;
    public FbScrollView f6332c;
    public final SubmitButtonEnabledEventSubscriber f6333d = new C05721(this);

    /* compiled from: place_delete_review_success */
    class C05721 extends SubmitButtonEnabledEventSubscriber {
        final /* synthetic */ LeadGenReadMorePillController f6328a;

        C05721(LeadGenReadMorePillController leadGenReadMorePillController) {
            this.f6328a = leadGenReadMorePillController;
        }

        public final void m8165b(FbEvent fbEvent) {
            SubmitButtonEnabledEvent submitButtonEnabledEvent = (SubmitButtonEnabledEvent) fbEvent;
            LeadGenReadMorePillController leadGenReadMorePillController = this.f6328a;
            if (submitButtonEnabledEvent.f6381a) {
                leadGenReadMorePillController.f6331b.setVisibility(4);
            } else {
                leadGenReadMorePillController.f6331b.setVisibility(0);
            }
        }
    }

    /* compiled from: place_delete_review_success */
    public class C05732 implements OnClickListener {
        final /* synthetic */ LeadGenReadMorePillController f6329a;

        public C05732(LeadGenReadMorePillController leadGenReadMorePillController) {
            this.f6329a = leadGenReadMorePillController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 738555864);
            this.f6329a.f6332c.pageScroll(130);
            Logger.a(2, EntryType.UI_INPUT_END, -773239612, a);
        }
    }

    public static void m8166a(Object obj, Context context) {
        ((LeadGenReadMorePillController) obj).f6330a = LeadGenEventBus.m8217a(FbInjector.get(context));
    }

    public LeadGenReadMorePillController(Context context, View view, FbScrollView fbScrollView) {
        this.f6331b = view;
        this.f6332c = fbScrollView;
        Class cls = LeadGenReadMorePillController.class;
        m8166a(this, context);
    }
}
