package com.facebook.reaction.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.placetips.settings.PlaceTipsSettingsHelper;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.widget.PhotoButton;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: XOUT_BUTTON */
public class GravityActionMenuButton extends PhotoButton {
    @Inject
    public GravityActionMenuHelperProvider f20751a;
    @Nullable
    public GravityActionMenuHelper f20752b;

    /* compiled from: XOUT_BUTTON */
    class C21951 implements OnClickListener {
        final /* synthetic */ GravityActionMenuButton f20750a;

        C21951(GravityActionMenuButton gravityActionMenuButton) {
            this.f20750a = gravityActionMenuButton;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -283391981);
            if (this.f20750a.f20752b != null) {
                this.f20750a.f20752b.m24399a(view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -550990805, a);
        }
    }

    public static void m24391a(Object obj, Context context) {
        ((GravityActionMenuButton) obj).f20751a = (GravityActionMenuHelperProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(GravityActionMenuHelperProvider.class);
    }

    public GravityActionMenuButton(Context context) {
        this(context, null);
    }

    private GravityActionMenuButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = GravityActionMenuButton.class;
        m24391a((Object) this, getContext());
        setImageResource(2130843594);
        int dimension = (int) getResources().getDimension(2131431394);
        setPadding(dimension, dimension, dimension, dimension);
        setOnClickListener(new C21951(this));
    }

    public final boolean m24392a(ReactionSession reactionSession, Fragment fragment) {
        InjectorLike injectorLike = this.f20751a;
        this.f20752b = new GravityActionMenuHelper(fragment, reactionSession, getContext(), ReactionExperimentController.a(injectorLike), FbUriIntentHandler.a(injectorLike), PlaceTipsSettingsHelper.m3886a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 3588), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
        return this.f20752b.m24398a();
    }
}
