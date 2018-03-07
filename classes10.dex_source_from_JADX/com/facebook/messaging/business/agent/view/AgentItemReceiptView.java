package com.facebook.messaging.business.agent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsInterfaces.AgentItemReceiptBubble;
import com.facebook.messaging.payment.prefs.receipts.PaymentReceiptActivity;
import com.facebook.messaging.payment.prefs.receipts.PaymentReceiptActivity.AnalyticsSource;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: thread_timestamps */
public class AgentItemReceiptView extends CustomRelativeLayout {
    @Inject
    public SecureContextHelper f1486a;
    public final FbButton f1487b;
    public AgentItemReceiptBubble f1488c;
    public final Context f1489d;

    /* compiled from: thread_timestamps */
    public class C02531 implements OnClickListener {
        final /* synthetic */ AgentItemReceiptView f1485a;

        public C02531(AgentItemReceiptView agentItemReceiptView) {
            this.f1485a = agentItemReceiptView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 902709221);
            AgentItemReceiptView agentItemReceiptView = this.f1485a;
            Preconditions.checkNotNull(agentItemReceiptView.f1488c.bL());
            agentItemReceiptView.f1486a.a(PaymentReceiptActivity.a(agentItemReceiptView.f1489d, agentItemReceiptView.f1488c.bL().b(), AnalyticsSource.THREAD), agentItemReceiptView.f1489d);
            Logger.a(2, EntryType.UI_INPUT_END, 698091049, a);
        }
    }

    public static void m1468a(Object obj, Context context) {
        ((AgentItemReceiptView) obj).f1486a = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    public AgentItemReceiptView(Context context) {
        this(context, null, 0);
    }

    private AgentItemReceiptView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = AgentItemReceiptView.class;
        m1468a(this, getContext());
        setContentView(2130903198);
        this.f1489d = context;
        this.f1487b = (FbButton) a(2131559460);
    }
}
