package com.facebook.redspace.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.ultralight.Inject;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: PROFILE_FIELD_EXPERIENCE_ITEM */
public class RedSpaceFeedEmptyView extends CustomLinearLayout {
    public BetterTextView f12291a;
    public RedSpaceProfileNavigationButton f12292b;
    public RedSpaceFeedProfileFragmentModel f12293c;
    public float f12294d;
    @Inject
    @LoggedInUserId
    public String f12295e;
    @Inject
    public Resources f12296f;
    public ViewGroup f12297g;

    /* compiled from: PROFILE_FIELD_EXPERIENCE_ITEM */
    class C14531 implements OnPreDrawListener {
        final /* synthetic */ RedSpaceFeedEmptyView f12290a;

        C14531(RedSpaceFeedEmptyView redSpaceFeedEmptyView) {
            this.f12290a = redSpaceFeedEmptyView;
        }

        public boolean onPreDraw() {
            if (this.f12290a.f12297g != null) {
                this.f12290a.setPadding(this.f12290a.getPaddingLeft(), (int) Math.max(this.f12290a.f12294d, (float) (((this.f12290a.f12297g.getBottom() - this.f12290a.getTop()) / 2) - (((this.f12290a.getHeight() - this.f12290a.getPaddingBottom()) - this.f12290a.getPaddingTop()) / 2))), this.f12290a.getPaddingRight(), this.f12290a.getPaddingBottom());
                this.f12290a.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            return true;
        }
    }

    public static void m12726a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RedSpaceFeedEmptyView redSpaceFeedEmptyView = (RedSpaceFeedEmptyView) obj;
        String b = String_LoggedInUserIdMethodAutoProvider.b(fbInjector);
        Resources a = ResourcesMethodAutoProvider.a(fbInjector);
        redSpaceFeedEmptyView.f12295e = b;
        redSpaceFeedEmptyView.f12296f = a;
    }

    public RedSpaceFeedEmptyView(Context context) {
        super(context);
        m12725a();
    }

    private void m12725a() {
        Class cls = RedSpaceFeedEmptyView.class;
        m12726a(this, getContext());
        setContentView(2130906757);
        this.f12291a = (BetterTextView) a(2131566850);
        this.f12292b = (RedSpaceProfileNavigationButton) a(2131558604);
        this.f12294d = this.f12296f.getDimension(2131430544);
        m12727b();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m12727b();
    }

    private void m12727b() {
        getViewTreeObserver().addOnPreDrawListener(new C14531(this));
    }
}
