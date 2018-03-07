package com.facebook.backstage.consumption.importflow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.facebook.backstage.StacksConstants;
import com.facebook.backstage.consumption.BackstageUploadService;
import com.facebook.backstage.consumption.SimpleAnimationHelper;
import com.facebook.backstage.consumption.SimpleAnimationHelper.AnimationListener;
import com.facebook.backstage.consumption.SimpleAnimationHelper.AnimationType;
import com.facebook.backstage.data.LocalShot.MediaType;
import com.facebook.backstage.data.UploadShot;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.backstage.util.BetterGestureDetector;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: risk_legal_name_birthday_fragment_tag */
public class ImportFlowStackView extends FrameLayout {
    @Inject
    ImportFlowStackViewController f4786a;
    @Inject
    Lazy<SecureContextHelper> f4787b;
    @Inject
    ImportFlowDataProvider f4788c;
    private final OnClickListener f4789d;
    private final OnClickListener f4790e;
    private final SimpleAnimationHelper f4791f;
    public final BetterGestureDetector f4792g;
    private final FbTextView f4793h;
    private final ViewGroup f4794i;
    private final FbButton f4795j;
    private ImportFlowTitleView f4796k;
    public ImmutableList<ImportMedia> f4797l;
    public ImportFlowStackEventListener f4798m;

    /* compiled from: risk_legal_name_birthday_fragment_tag */
    public interface ImportFlowStackEventListener {
        void mo161a();

        void mo162b();
    }

    /* compiled from: risk_legal_name_birthday_fragment_tag */
    class C04901 implements OnClickListener {
        final /* synthetic */ ImportFlowStackView f4782a;

        C04901(ImportFlowStackView importFlowStackView) {
            this.f4782a = importFlowStackView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 181302795);
            BackstageUploadService.m4523a((SecureContextHelper) this.f4782a.f4787b.get(), this.f4782a.getContext(), ImportFlowStackView.m4672b(this.f4782a.f4797l));
            this.f4782a.m4664a(this.f4782a.f4797l.size());
            ImportFlowDataProvider importFlowDataProvider = this.f4782a.f4788c;
            importFlowDataProvider.f4734g.edit().a(StacksConstants.f4255e, importFlowDataProvider.f4735h.a()).commit();
            this.f4782a.m4670b();
            this.f4782a.f4798m.mo161a();
            Logger.a(2, EntryType.UI_INPUT_END, 217526264, a);
        }
    }

    /* compiled from: risk_legal_name_birthday_fragment_tag */
    class C04912 implements OnClickListener {
        final /* synthetic */ ImportFlowStackView f4783a;

        C04912(ImportFlowStackView importFlowStackView) {
            this.f4783a = importFlowStackView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1541883223);
            this.f4783a.m4677a();
            Logger.a(2, EntryType.UI_INPUT_END, 377614017, a);
        }
    }

    /* compiled from: risk_legal_name_birthday_fragment_tag */
    class C04923 implements AnimationListener {
        final /* synthetic */ ImportFlowStackView f4784a;

        C04923(ImportFlowStackView importFlowStackView) {
            this.f4784a = importFlowStackView;
        }

        public final void mo168a() {
            this.f4784a.f4786a.m4695d();
        }

        public final void mo169b() {
        }
    }

    /* compiled from: risk_legal_name_birthday_fragment_tag */
    class C04934 implements OnTouchListener {
        final /* synthetic */ ImportFlowStackView f4785a;

        C04934(ImportFlowStackView importFlowStackView) {
            this.f4785a = importFlowStackView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f4785a.f4786a.f4810j) {
                this.f4785a.f4792g.onTouchEvent(motionEvent);
            }
            return true;
        }
    }

    private static <T extends View> void m4667a(Class<T> cls, T t) {
        m4668a((Object) t, t.getContext());
    }

    private static void m4668a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ImportFlowStackView) obj).m4666a(ImportFlowStackViewController.m4683b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 968), ImportFlowDataProvider.m4619b(injectorLike));
    }

    private void m4666a(ImportFlowStackViewController importFlowStackViewController, Lazy<SecureContextHelper> lazy, ImportFlowDataProvider importFlowDataProvider) {
        this.f4786a = importFlowStackViewController;
        this.f4787b = lazy;
        this.f4788c = importFlowDataProvider;
    }

    public ImportFlowStackView(Context context) {
        this(context, null);
    }

    public ImportFlowStackView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImportFlowStackView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4789d = new C04901(this);
        this.f4790e = new C04912(this);
        this.f4791f = new SimpleAnimationHelper(this, new C04923(this));
        m4667a(ImportFlowStackView.class, (View) this);
        View inflate = LayoutInflater.from(getContext()).inflate(2130904850, this);
        inflate.setOnTouchListener(new C04934(this));
        this.f4794i = (ViewGroup) inflate.findViewById(2131563071);
        this.f4793h = (FbTextView) inflate.findViewById(2131563072);
        this.f4795j = (FbButton) inflate.findViewById(2131563073);
        this.f4795j.setOnClickListener(this.f4789d);
        this.f4792g = new BetterGestureDetector(getContext(), this.f4786a.m4693b());
    }

    public final boolean m4677a() {
        ViewAnimator.m5752a((View) this).m5761e();
        if (!this.f4791f.m4561a()) {
            return false;
        }
        m4674c();
        this.f4798m.mo162b();
        return true;
    }

    private void m4670b() {
        this.f4786a.m4695d();
        this.f4796k = null;
        this.f4797l = RegularImmutableList.a;
        this.f4791f.m4562b(AnimationType.SLIDE_FROM_RIGHT);
    }

    private void m4674c() {
        this.f4786a.m4694c();
        this.f4796k = null;
        this.f4797l = RegularImmutableList.a;
        this.f4791f.m4562b(AnimationType.SLIDE_FROM_RIGHT);
    }

    public final void m4676a(ImmutableList<ImportMedia> immutableList, ImportFlowTitleView importFlowTitleView, ImportFlowStackEventListener importFlowStackEventListener) {
        ViewAnimator.m5752a((View) this).m5761e();
        this.f4797l = immutableList;
        this.f4798m = importFlowStackEventListener;
        this.f4796k = importFlowTitleView;
        this.f4796k.m4702d();
        this.f4796k.setOnCloseClickedListener(this.f4790e);
        this.f4796k.m4698a();
        setFocusable(true);
        requestFocus();
        setX((float) this.f4794i.getWidth());
        this.f4786a.m4691a(immutableList, this, this.f4794i, this.f4796k, this.f4793h);
        this.f4791f.m4560a(AnimationType.SLIDE_FROM_RIGHT);
        this.f4795j.setText(getResources().getQuantityString(2131689746, this.f4797l.size(), new Object[]{Integer.valueOf(this.f4797l.size())}));
    }

    public static UploadShot[] m4672b(ImmutableList<ImportMedia> immutableList) {
        UploadShot[] uploadShotArr = new UploadShot[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            MediaType mediaType;
            ImportMedia importMedia = (ImportMedia) immutableList.get(i);
            String str = importMedia.f4823c;
            String h = importMedia.mo173h();
            if (importMedia.mo172g()) {
                mediaType = MediaType.VIDEO;
            } else {
                mediaType = MediaType.PHOTO;
            }
            uploadShotArr[i] = new UploadShot(str, h, mediaType, importMedia.f4821e.getTime(), "", "");
        }
        return uploadShotArr;
    }

    private void m4664a(int i) {
        Toast.makeText(getContext(), getResources().getQuantityString(2131689747, i, new Object[]{Integer.valueOf(i)}), 1).show();
    }
}
