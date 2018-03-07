package com.facebook.katana.activity.faceweb;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.facebook.graphql.calls.UniversalFeedbackGiveFeedbackInputData.DeliveryType;
import com.facebook.graphql.calls.UniversalFeedbackGiveFeedbackInputData.ExperienceType;
import com.facebook.universalfeedback.UniversalFeedbackContextBuilder;
import com.facebook.universalfeedback.UniversalFeedbackController;
import com.facebook.universalfeedback.UniversalFeedbackController.ResultListener;
import com.facebook.webview.FacebookWebView;
import com.facebook.webview.FacebookWebView.NativeCallHandler;
import com.facebook.webview.FacewebPalCall;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: uri_source */
public class NegativeFeedbackFacewebController implements ResultListener, NativeCallHandler {
    private static final ImmutableSet<String> f850a = ImmutableSet.of("REPORT_IP_VIOLATION", "REPORT_CONTENT");
    private static final ImmutableSet<String> f851b = ImmutableSet.of("REDIRECT");
    public UniversalFeedbackController f852c;
    public View f853d;
    public TitleBarButtonSpec f854e;
    public OnToolbarButtonListener f855f;
    public String f856g;
    public boolean f857h;
    public boolean f858i;
    public FragmentManager f859j;

    /* compiled from: uri_source */
    public class C01351 extends OnToolbarButtonListener {
        final /* synthetic */ NegativeFeedbackFacewebController f849a;

        public C01351(NegativeFeedbackFacewebController negativeFeedbackFacewebController) {
            this.f849a = negativeFeedbackFacewebController;
        }

        public final void m846a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            Object obj;
            this.f849a.f853d = view;
            this.f849a.f854e = titleBarButtonSpec;
            NegativeFeedbackFacewebController negativeFeedbackFacewebController = this.f849a;
            if (negativeFeedbackFacewebController.f856g == null || negativeFeedbackFacewebController.f857h || negativeFeedbackFacewebController.f858i) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                negativeFeedbackFacewebController = this.f849a;
                UniversalFeedbackContextBuilder universalFeedbackContextBuilder = new UniversalFeedbackContextBuilder(ExperienceType.NFX_FEEDBACK, DeliveryType.FB4A_NFX_DIALOG);
                universalFeedbackContextBuilder.c = negativeFeedbackFacewebController.f856g;
                universalFeedbackContextBuilder = universalFeedbackContextBuilder;
                negativeFeedbackFacewebController.f852c.k = negativeFeedbackFacewebController;
                negativeFeedbackFacewebController.f852c.a(universalFeedbackContextBuilder, negativeFeedbackFacewebController.f859j);
                return;
            }
            NegativeFeedbackFacewebController.m847c(this.f849a);
        }
    }

    @Inject
    public NegativeFeedbackFacewebController(UniversalFeedbackController universalFeedbackController) {
        this.f852c = universalFeedbackController;
    }

    public static void m847c(NegativeFeedbackFacewebController negativeFeedbackFacewebController) {
        negativeFeedbackFacewebController.f855f.a(negativeFeedbackFacewebController.f853d, negativeFeedbackFacewebController.f854e);
    }

    public final void m848a() {
        m847c(this);
    }

    public final void m850b() {
        m847c(this);
    }

    public final void m849a(Context context, FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
        String a = facewebPalCall.a(facebookWebView.k, "action");
        this.f856g = facewebPalCall.a(facebookWebView.k, "node_token");
        this.f858i = f850a.contains(a);
        this.f857h = f851b.contains(a);
    }
}
