package com.facebook.growth.nux;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import com.facebook.growth.friendfinder.FriendFinderPreferenceSetter;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialNUXController;
import com.facebook.ipc.model.NuxStep;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: p2p_sync_delta */
public class NUXStepAdapter extends FragmentPagerAdapter {
    private static final Class<?> f7407a = NUXStepAdapter.class;
    public List<NuxStep> f7408b;
    private final NUXFragmentFactory f7409c;
    public final NUXStepsValidator f7410d;

    public static NUXStepAdapter m7730b(InjectorLike injectorLike) {
        return new NUXStepAdapter((Context) injectorLike.getInstance(Context.class), InterstitialManager.a(injectorLike), NUXStepsValidator.m7734a(injectorLike), new NUXFragmentFactory(IdBasedProvider.a(injectorLike, 690), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FriendFinderPreferenceSetter.m7544b(injectorLike)));
    }

    @Inject
    public NUXStepAdapter(Context context, InterstitialManager interstitialManager, NUXStepsValidator nUXStepsValidator, NUXFragmentFactory nUXFragmentFactory) {
        super(((FragmentActivity) context).kO_());
        InterstitialController a = interstitialManager.a("1630");
        if (a == null || !(a instanceof InterstitialNUXController) || ((InterstitialNUXController) a).e() == null) {
            this.f7408b = new ArrayList();
        } else {
            this.f7408b = nUXStepsValidator.m7736a(((InterstitialNUXController) a).e());
        }
        this.f7409c = nUXFragmentFactory;
        this.f7410d = nUXStepsValidator;
    }

    public final int m7732b() {
        return this.f7408b.size();
    }

    public final Fragment m7731a(int i) {
        return this.f7409c.m7729a(((NuxStep) this.f7408b.get(i)).name);
    }

    public final String m7733e(int i) {
        if (i < b()) {
            return ((NuxStep) this.f7408b.get(i)).name;
        }
        Integer.valueOf(i);
        Integer.valueOf(b());
        return "";
    }
}
