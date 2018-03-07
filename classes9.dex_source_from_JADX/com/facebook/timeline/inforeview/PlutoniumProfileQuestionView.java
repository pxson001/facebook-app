package com.facebook.timeline.inforeview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.identitygrowth.profilequestion.ui.ProfileQuestionOptionListView;
import com.facebook.identitygrowth.profilequestion.ui.ProfileQuestionOptionListView.OnSelectionChangedListener;
import com.facebook.identitygrowth.profilequestion.ui.ProfileQuestionPrivacySelectorView;
import com.facebook.identitygrowth.profilequestion.utils.ProfileQuestionHelper;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionFragmentModel;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.InfoReviewItemFragmentModel;
import com.facebook.widget.OverlayableLinearLayout;

/* compiled from: upload_batch_fail */
public class PlutoniumProfileQuestionView extends OverlayableLinearLayout {
    public AbstractFbErrorReporter f893a;
    public ProfileQuestionHelper f894b;
    public PlutoniumProfileQuestionHandlerProvider f895c;
    public InfoReviewProfileQuestionStatusData f896d;
    public PlutoniumProfileQuestionHandler f897e;
    public InfoReviewItemFragmentModel f898f;
    public ProfileQuestionFragmentModel f899g;
    public String f900h;
    public OnClickListener f901i;
    public final InfoReviewItemView f902j = ((InfoReviewItemView) a(2131566158));
    public final FbButton f903k = ((FbButton) a(2131566164));
    public final FbButton f904l = ((FbButton) a(2131566165));
    public final ProfileQuestionOptionListView f905m = ((ProfileQuestionOptionListView) a(2131566160));
    public final View f906n = a(2131566163);
    public final ProfileQuestionPrivacySelectorView f907o = ((ProfileQuestionPrivacySelectorView) a(2131566162));

    /* compiled from: upload_batch_fail */
    class C00831 implements OnClickListener {
        final /* synthetic */ PlutoniumProfileQuestionView f890a;

        C00831(PlutoniumProfileQuestionView plutoniumProfileQuestionView) {
            this.f890a = plutoniumProfileQuestionView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1129467880);
            PlutoniumProfileQuestionView.m916a(this.f890a, "SAVE");
            Logger.a(2, EntryType.UI_INPUT_END, 1027758474, a);
        }
    }

    /* compiled from: upload_batch_fail */
    class C00842 implements OnClickListener {
        final /* synthetic */ PlutoniumProfileQuestionView f891a;

        C00842(PlutoniumProfileQuestionView plutoniumProfileQuestionView) {
            this.f891a = plutoniumProfileQuestionView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1320760941);
            PlutoniumProfileQuestionView.m916a(this.f891a, "SKIP");
            Logger.a(2, EntryType.UI_INPUT_END, -1867225748, a);
        }
    }

    /* compiled from: upload_batch_fail */
    public class C00853 implements OnSelectionChangedListener {
        final /* synthetic */ PlutoniumProfileQuestionView f892a;

        public C00853(PlutoniumProfileQuestionView plutoniumProfileQuestionView) {
            this.f892a = plutoniumProfileQuestionView;
        }

        public final void m915a(String str) {
            this.f892a.f904l.setEnabled(str != null);
        }
    }

    public static void m917a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PlutoniumProfileQuestionView plutoniumProfileQuestionView = (PlutoniumProfileQuestionView) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        ProfileQuestionHelper a = ProfileQuestionHelper.a(fbInjector);
        PlutoniumProfileQuestionHandlerProvider plutoniumProfileQuestionHandlerProvider = (PlutoniumProfileQuestionHandlerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PlutoniumProfileQuestionHandlerProvider.class);
        plutoniumProfileQuestionView.f893a = abstractFbErrorReporter;
        plutoniumProfileQuestionView.f894b = a;
        plutoniumProfileQuestionView.f895c = plutoniumProfileQuestionHandlerProvider;
    }

    public PlutoniumProfileQuestionView(Context context) {
        super(context);
        Class cls = PlutoniumProfileQuestionView.class;
        m917a((Object) this, getContext());
        setContentView(2130906333);
        setOrientation(1);
        this.f902j.a(0, 0, 0, 0);
        this.f902j.setOnClickListener(null);
        this.f904l.setOnClickListener(new C00831(this));
        this.f901i = new C00842(this);
    }

    public static void m916a(PlutoniumProfileQuestionView plutoniumProfileQuestionView, String str) {
        plutoniumProfileQuestionView.f897e.m911a(plutoniumProfileQuestionView.f899g, plutoniumProfileQuestionView.f900h, plutoniumProfileQuestionView.f907o.getSelectedPrivacyRow(), str, "android_plutonium_expando", "native_plutonium_header");
    }
}
