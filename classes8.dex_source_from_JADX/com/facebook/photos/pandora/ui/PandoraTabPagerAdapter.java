package com.facebook.photos.pandora.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.dialtone.DialtoneController;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.photos.pandora.ui.DialtonePhotosCoverFragment.PandoraType;
import com.facebook.photos.photoset.ui.photoset.PandoraAlbumsFragment;
import com.facebook.photos.simplepicker.SimplePickerFragment;
import com.facebook.photos.simplepicker.SimplePickerFragmentFactory;
import com.facebook.photos.simplepicker.module.SimplePickerModule.C04091;
import com.facebook.user.model.User;
import com.facebook.vault.momentsupsell.model.MomentsAppInfo;
import com.facebook.vault.momentsupsell.ui.MomentsAppPromotionFragment;
import com.facebook.vault.momentsupsell.ui.MomentsAppSegueFragment;
import com.facebook.vault.ui.VaultSyncNotSupportedFragment;
import com.facebook.vault.ui.VaultSyncScreenFragment;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import java.lang.ref.WeakReference;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.intent.action.ACTION_OPTIMISTIC_COVER_PHOTO_UPDATED */
public class PandoraTabPagerAdapter extends FragmentStatePagerAdapter {
    public static final String f17695a = PandoraTabPagerAdapter.class.getSimpleName();
    public Lazy<Resources> f17696b;
    private String f17697c;
    public String f17698d;
    public String f17699e;
    public Bundle f17700f;
    @Nullable
    public CallerContext f17701g;
    private String f17702h;
    public PandoraSyncTabUtils f17703i;
    private DialtoneController f17704j;
    private boolean f17705k;
    private boolean f17706l;
    private boolean f17707m;
    private boolean f17708n;
    @Nullable
    public MomentsAppInfo f17709o;
    private C04091 f17710p;
    @Nullable
    private WeakReference<SimplePickerFragment> f17711q;

    @Inject
    public PandoraTabPagerAdapter(String str, Lazy<Resources> lazy, Provider<User> provider, PandoraSyncTabUtils pandoraSyncTabUtils, @Assisted String str2, @Assisted String str3, @Assisted Bundle bundle, @Assisted FragmentManager fragmentManager, @Nullable @Assisted CallerContext callerContext, @Assisted String str4, DialtoneController dialtoneController, SimplePickerFragmentFactory simplePickerFragmentFactory) {
        super(fragmentManager);
        this.f17696b = lazy;
        this.f17697c = str;
        this.f17698d = str2;
        this.f17699e = str3;
        this.f17700f = bundle;
        this.f17701g = callerContext;
        this.f17702h = str4;
        this.f17703i = pandoraSyncTabUtils;
        this.f17704j = dialtoneController;
        if (Strings.isNullOrEmpty(this.f17698d)) {
            this.f17698d = this.f17697c;
        }
        if (Strings.isNullOrEmpty(this.f17699e) && Objects.equal(str2, this.f17697c)) {
            this.f17699e = ((User) provider.get()).j();
        }
        boolean z = !bundle.getBoolean("disable_tagged_media_set", false) && (this.f17698d.equals(this.f17697c) || bundle.getBoolean("has_tagged_mediaset", false));
        this.f17705k = z;
        this.f17706l = bundle.getBoolean("extra_should_merge_camera_roll");
        this.f17707m = bundle.getBoolean("extra_should_show_suggested_photos", false);
        this.f17708n = bundle.getBoolean("extra_should_show_suggested_photos_before_camera_roll", false);
        this.f17710p = simplePickerFragmentFactory;
    }

    public final Fragment m21675a(int i) {
        int i2;
        int i3;
        boolean j = this.f17704j.j();
        int i4 = this.f17706l ? 0 : 1;
        if (this.f17707m) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.f17705k) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (this.f17707m && this.f17708n) {
            if (i == 0) {
                return PandoraSuggestedProfilePhotosFragment.m21650a(this.f17700f, this.f17698d, this.f17701g);
            }
            if (i == 1 && this.f17706l) {
                return m21671e();
            }
        } else if (!this.f17707m || this.f17708n) {
            if (!this.f17707m && i == 0 && this.f17706l) {
                return m21671e();
            }
        } else if (i == 0) {
            return m21671e();
        } else {
            if (i == 1) {
                return PandoraSuggestedProfilePhotosFragment.m21650a(this.f17700f, this.f17698d, this.f17701g);
            }
        }
        i4 += i2 + 0;
        if (i == 2 - i4 && this.f17705k) {
            DialtonePhotosCoverFragment a;
            if (j) {
                a = DialtonePhotosCoverFragment.m21558a(PandoraType.TAGGED, 0, this.f17698d);
            } else {
                a = PandoraTaggedPhotosFragment.m21708a(this.f17700f, this.f17698d, this.f17699e, this.f17701g);
            }
            return a;
        }
        i4 += i3;
        if (i == 3 - i4) {
            return m21670b(j);
        }
        if (i == 4 - i4) {
            return PandoraAlbumsFragment.m21867a(this.f17700f, this.f17698d, false, null, null);
        }
        if (i == 5 - i4) {
            return m21672g();
        }
        return null;
    }

    private Fragment m21670b(boolean z) {
        return z ? DialtonePhotosCoverFragment.m21558a(PandoraType.UPLOADED, 0, this.f17698d) : PandoraUploadedMediaSetFragment.m21719a(this.f17700f, this.f17698d, false, this.f17701g);
    }

    private Fragment m21671e() {
        SimplePickerFragment a = this.f17710p.m3170a(this.f17700f, (SimplePickerLauncherConfiguration) this.f17700f.getParcelable("extra_simple_picker_launcher_configuration"), this.f17702h);
        this.f17711q = new WeakReference(a);
        return a;
    }

    @Nullable
    public final SimplePickerFragment m21677d() {
        if (this.f17711q != null) {
            return (SimplePickerFragment) this.f17711q.get();
        }
        return null;
    }

    private Fragment m21672g() {
        MomentsAppInfo momentsAppInfo;
        Bundle bundle;
        switch (this.f17703i.m21657a(this.f17709o)) {
            case NONE:
                return null;
            case SYNC:
                return new VaultSyncScreenFragment();
            case LOADING:
                return new PandoraSyncTabLoadingFragment();
            case MOMENTS_PROMOTION:
                momentsAppInfo = this.f17709o;
                MomentsAppPromotionFragment momentsAppPromotionFragment = new MomentsAppPromotionFragment();
                bundle = new Bundle();
                bundle.putParcelable("arg_moments_app_info", momentsAppInfo);
                momentsAppPromotionFragment.g(bundle);
                return momentsAppPromotionFragment;
            case MOMENTS_SEGUE:
                momentsAppInfo = this.f17709o;
                MomentsAppSegueFragment momentsAppSegueFragment = new MomentsAppSegueFragment();
                bundle = new Bundle();
                bundle.putParcelable("arg_moments_app_info", momentsAppInfo);
                momentsAppSegueFragment.g(bundle);
                return momentsAppSegueFragment;
            case SYNC_UNSUPPORTED:
                return new VaultSyncNotSupportedFragment();
            default:
                BLog.c(f17695a, "Unknown sync tab state: %s", new Object[]{this.f17703i.m21657a(this.f17709o)});
                return null;
        }
    }

    public final int m21674a(Object obj) {
        PandoraSyncTabState a = this.f17703i.m21657a(this.f17709o);
        if ((obj instanceof VaultSyncScreenFragment) && a != PandoraSyncTabState.SYNC) {
            return -2;
        }
        if ((obj instanceof PandoraSyncTabLoadingFragment) && a != PandoraSyncTabState.LOADING) {
            return -2;
        }
        if ((obj instanceof MomentsAppPromotionFragment) && a != PandoraSyncTabState.MOMENTS_PROMOTION) {
            return -2;
        }
        if ((obj instanceof MomentsAppSegueFragment) && a != PandoraSyncTabState.MOMENTS_SEGUE) {
            return -2;
        }
        if ((!(obj instanceof VaultSyncNotSupportedFragment) || a == PandoraSyncTabState.SYNC_UNSUPPORTED) && !(obj instanceof DialtonePhotosCoverFragment)) {
            return -1;
        }
        return -2;
    }

    public final int m21676b() {
        Object obj;
        int i = 2;
        if (this.f17705k) {
            i = 3;
        }
        if (this.f17706l) {
            i++;
        }
        if (this.f17707m) {
            i++;
        }
        if (this.f17703i.m21657a(this.f17709o) != PandoraSyncTabState.NONE) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null || !m21673i()) {
            return i;
        }
        return i + 1;
    }

    public static String m21669a(String str) {
        return str.toUpperCase(Locale.getDefault());
    }

    private boolean m21673i() {
        return Objects.equal(this.f17697c, this.f17698d);
    }

    public final CharSequence J_(int i) {
        int i2;
        int i3;
        int i4 = this.f17706l ? 0 : 1;
        if (this.f17707m) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.f17705k) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (this.f17707m && this.f17708n) {
            if (i == 0) {
                return m21669a(((Resources) this.f17696b.get()).getString(2131236734));
            }
            if (i == 1 && this.f17706l) {
                return m21669a(((Resources) this.f17696b.get()).getString(2131236733));
            }
        } else if (!this.f17707m || this.f17708n) {
            if (!this.f17707m && i == 0 && this.f17706l) {
                return m21669a(((Resources) this.f17696b.get()).getString(2131236733));
            }
        } else if (i == 0) {
            return m21669a(((Resources) this.f17696b.get()).getString(2131236733));
        } else {
            if (i == 1) {
                return m21669a(((Resources) this.f17696b.get()).getString(2131236734));
            }
        }
        i4 += i2 + 0;
        if (i != 2 - i4 || !this.f17705k) {
            i4 += i3;
            if (i == 3 - i4) {
                return m21669a(((Resources) this.f17696b.get()).getString(2131236736));
            }
            if (i == 4 - i4) {
                return m21669a(((Resources) this.f17696b.get()).getString(2131236737));
            }
            if (i != 5 - i4) {
                return "";
            }
            String str;
            switch (this.f17703i.m21657a(this.f17709o)) {
                case NONE:
                    str = "";
                    break;
                case SYNC:
                case SYNC_UNSUPPORTED:
                    str = m21669a(((Resources) this.f17696b.get()).getString(2131236738));
                    break;
                case LOADING:
                    str = m21669a(((Resources) this.f17696b.get()).getString(2131236739));
                    break;
                case MOMENTS_PROMOTION:
                    if (this.f17709o != null && this.f17709o.d) {
                        str = m21669a(((Resources) this.f17696b.get()).getString(2131236740));
                        break;
                    }
                    str = m21669a(((Resources) this.f17696b.get()).getString(2131236738));
                    break;
                    break;
                case MOMENTS_SEGUE:
                    str = m21669a(((Resources) this.f17696b.get()).getString(2131236740));
                    break;
                default:
                    BLog.c(f17695a, "Unknown sync tab state: %s", new Object[]{this.f17703i.m21657a(this.f17709o)});
                    str = "";
                    break;
            }
            return str;
        } else if (m21673i()) {
            return m21669a(((Resources) this.f17696b.get()).getString(2131236742));
        } else {
            if (Strings.isNullOrEmpty(this.f17699e)) {
                return m21669a(StringFormatUtil.formatStrLocaleSafe(((Resources) this.f17696b.get()).getString(2131236744), ""));
            }
            Object substring;
            if (this.f17699e.indexOf(32) > 0) {
                substring = this.f17699e.substring(0, this.f17699e.indexOf(32));
            } else {
                String str2 = this.f17699e;
            }
            String string = ((Resources) this.f17696b.get()).getString(2131236744);
            if (substring == null) {
                substring = "";
            }
            return m21669a(StringFormatUtil.formatStrLocaleSafe(string, substring));
        }
    }
}
