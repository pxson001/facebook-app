package com.facebook.timeline.refresher;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.net.Uri;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.View;
import android.view.animation.Interpolator;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.enums.GraphQLProfileWizardStepType;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineNuxQueryModel;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineRefresherQueryModel;
import com.facebook.timeline.refresher.ui.ProfileRefresherAnimationHelper;
import com.facebook.timeline.refresher.ui.ProfileRefresherStepProgressBar;
import com.facebook.widget.titlebar.TitleBarButtonSpecCache;
import com.facebook.widget.titlebar.TitleBarButtonSpecCacheProvider;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: updateBookmarkUnreadCount */
public class ProfileRefresherBinder {
    public final TitleBarButtonSpecCacheProvider f956a;
    public TitleBarButtonSpecCache f957b;
    public TitleBarButtonSpecCache f958c;
    public ProfileRefresherView f959d;
    public ProfileRefresherAnimationHelper f960e = new ProfileRefresherAnimationHelper();
    public ProfileRefresherStepProgressBar f961f;
    private final Interpolator f962g = PathInterpolatorCompat.a(0.25f, 0.1f, 0.25f, 1.0f);
    public final AnimatorListenerAdapter f963h = new C00901(this);

    /* compiled from: updateBookmarkUnreadCount */
    class C00901 extends AnimatorListenerAdapter {
        final /* synthetic */ ProfileRefresherBinder f951a;

        C00901(ProfileRefresherBinder profileRefresherBinder) {
            this.f951a = profileRefresherBinder;
        }

        public void onAnimationEnd(Animator animator) {
            this.f951a.f959d.f1051k.setVisibility(8);
        }
    }

    @Inject
    public ProfileRefresherBinder(TitleBarButtonSpecCacheProvider titleBarButtonSpecCacheProvider) {
        this.f956a = titleBarButtonSpecCacheProvider;
    }

    public final void m968b(final ProfileRefresherModel profileRefresherModel) {
        if (profileRefresherModel.m1034q()) {
            this.f959d.f1055o.b();
        } else {
            this.f959d.f1055o.a();
        }
        if (profileRefresherModel.m1034q()) {
            m969c(profileRefresherModel);
            if (m967p(profileRefresherModel)) {
                Object obj;
                final AnimatorListenerAdapter c00912 = new AnimatorListenerAdapter(this) {
                    final /* synthetic */ ProfileRefresherBinder f953b;

                    public void onAnimationEnd(Animator animator) {
                        ProfileRefresherBinder.m961f(this.f953b, profileRefresherModel);
                    }
                };
                AnimatorListener c00923 = new AnimatorListenerAdapter(this) {
                    final /* synthetic */ ProfileRefresherBinder f955b;

                    public void onAnimationEnd(Animator animator) {
                        ProfileRefresherAnimationHelper profileRefresherAnimationHelper = this.f955b.f960e;
                        View view = this.f955b.f959d.f1054n;
                        float f = (float) (-this.f955b.f959d.f1054n.getWidth());
                        view.animate().alpha(0.0f).translationXBy(f).setInterpolator(profileRefresherAnimationHelper.f1101a).setListener(c00912);
                    }
                };
                GraphQLProfileWizardStepType e = profileRefresherModel.m1031e();
                if (e == GraphQLProfileWizardStepType.PROFILE_PICTURE || e == GraphQLProfileWizardStepType.COVER_PHOTO) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null && this.f959d.f1051k.getVisibility() == 0) {
                    this.f960e.m1183b(this.f959d.f1051k, (float) this.f959d.f1051k.getHeight(), this.f963h);
                }
                this.f960e.m1183b(this.f959d.f1052l.m1038b(profileRefresherModel.f1023k).T, 100.0f, c00923);
                return;
            }
            m961f(this, profileRefresherModel);
        }
    }

    public final void m969c(ProfileRefresherModel profileRefresherModel) {
        ProfileRefresherAnimationHelper.m1181a(this.f959d.f1054n);
        if (profileRefresherModel.m1034q()) {
            ProfileRefresherAnimationHelper.m1181a(this.f959d.f1052l.m1038b(profileRefresherModel.m1031e()).T);
            ProfileRefresherAnimationHelper.m1181a(this.f959d.f1052l.m1038b(profileRefresherModel.f1023k).T);
        }
    }

    public static void m961f(ProfileRefresherBinder profileRefresherBinder, ProfileRefresherModel profileRefresherModel) {
        List a;
        if (profileRefresherBinder.m967p(profileRefresherModel)) {
            profileRefresherBinder.f959d.f1052l.a(profileRefresherBinder.f959d.f1053m, profileRefresherBinder.f959d.f1052l.m1035a(profileRefresherModel.f1023k), profileRefresherBinder.f959d.f1052l.m1038b(profileRefresherModel.f1023k));
            profileRefresherBinder.f959d.f1052l.b(profileRefresherBinder.f959d.f1053m);
        }
        if (m966o(profileRefresherModel)) {
            profileRefresherBinder.f959d.f1052l.a(profileRefresherBinder.f959d.f1053m, profileRefresherBinder.f959d.f1052l.m1035a(profileRefresherModel.m1031e()));
            profileRefresherBinder.f959d.f1052l.b(profileRefresherBinder.f959d.f1053m);
            View view = profileRefresherBinder.f959d.f1052l.m1038b(profileRefresherModel.m1031e()).T;
            if (view != null) {
                view.setAlpha(0.0f);
            }
            profileRefresherBinder.f959d.findViewById(2131566403).scrollTo(0, 0);
        }
        profileRefresherBinder.m962g(profileRefresherModel);
        Preconditions.checkArgument(profileRefresherModel != null);
        if (profileRefresherModel.m1031e() == null) {
            if (profileRefresherBinder.f957b == null) {
                profileRefresherBinder.f957b = profileRefresherBinder.f956a.a(2131230752);
            }
            a = profileRefresherBinder.f957b.a();
        } else {
            if (profileRefresherBinder.f958c == null) {
                profileRefresherBinder.f958c = profileRefresherBinder.f956a.a(2131230751);
            }
            a = profileRefresherBinder.f958c.a();
        }
        profileRefresherBinder.f959d.setTitleBarButtonSpecs(a);
        profileRefresherBinder.f959d.setTitleBarButtonListener(profileRefresherBinder.f959d.f1059s);
        Preconditions.checkArgument(profileRefresherModel != null);
        if (profileRefresherModel.m1031e() == GraphQLProfileWizardStepType.COVER_PHOTO) {
            profileRefresherBinder.f959d.m1060a();
        }
        if (profileRefresherModel.m1029c().isEmpty() && profileRefresherModel.m1030d().isEmpty()) {
            profileRefresherBinder.f959d.f1054n.setVisibility(8);
        } else {
            profileRefresherBinder.f959d.f1054n.setVisibility(0);
        }
        profileRefresherBinder.f959d.f1046f.setText(profileRefresherModel.m1029c());
        profileRefresherBinder.f959d.f1047g.setText(profileRefresherModel.m1030d());
        profileRefresherBinder.m963j(profileRefresherModel);
        profileRefresherBinder.m965n(profileRefresherModel);
        profileRefresherBinder.m964k(profileRefresherModel);
        if (m966o(profileRefresherModel)) {
            profileRefresherBinder.f960e.m1182a(profileRefresherModel, profileRefresherBinder.f959d, null, false);
        }
    }

    private void m962g(ProfileRefresherModel profileRefresherModel) {
        Preconditions.checkArgument(profileRefresherModel != null);
        ProfileRefresherHeaderFragment b = m960b(this.f959d);
        if (b != null && b.ao != null) {
            if (profileRefresherModel.m1031e() != GraphQLProfileWizardStepType.PROFILE_PICTURE) {
                b.ao.setAlpha(0.7f);
            } else {
                b.ao.setAlpha(1.0f);
            }
            b.ao.setText(profileRefresherModel.f1013a);
            this.f959d.setName(profileRefresherModel.f1013a);
        }
    }

    private static boolean m966o(ProfileRefresherModel profileRefresherModel) {
        return profileRefresherModel.f1023k != profileRefresherModel.m1031e();
    }

    private void m963j(ProfileRefresherModel profileRefresherModel) {
        Preconditions.checkArgument(profileRefresherModel != null);
        ProfileRefresherHeaderFragment b = m960b(this.f959d);
        if (b != null && b.ap != null) {
            String str;
            if (profileRefresherModel.m1031e() != GraphQLProfileWizardStepType.PROFILE_PICTURE) {
                b.ap.setAlpha(0.4f);
            } else {
                b.ap.setAlpha(1.0f);
            }
            FbDraweeView fbDraweeView = b.an;
            if (profileRefresherModel.f1015c == null) {
                str = "";
            } else {
                str = profileRefresherModel.f1015c;
            }
            fbDraweeView.a(Uri.parse(str), ProfileRefresherView.f1041a);
        }
    }

    @Nullable
    private static ProfileRefresherHeaderFragment m960b(ProfileRefresherView profileRefresherView) {
        return profileRefresherView.f1052l.m1039c(GraphQLProfileWizardStepType.PROFILE_PICTURE) ? (ProfileRefresherHeaderFragment) profileRefresherView.f1052l.m1038b(GraphQLProfileWizardStepType.PROFILE_PICTURE) : null;
    }

    private void m964k(ProfileRefresherModel profileRefresherModel) {
        Preconditions.checkArgument(profileRefresherModel != null);
        ProfileRefresherHeaderFragment b = m960b(this.f959d);
        if (b != null && b.am != null) {
            String str;
            if (profileRefresherModel.m1031e() != GraphQLProfileWizardStepType.COVER_PHOTO) {
                b.am.setAlpha(0.4f);
            } else {
                b.am.setAlpha(1.0f);
            }
            FbDraweeView fbDraweeView = b.am;
            if (profileRefresherModel.f1016d != null) {
                str = profileRefresherModel.f1016d;
            } else {
                String a;
                Preconditions.checkArgument(profileRefresherModel.f1024l != null);
                if (profileRefresherModel.f1018f) {
                    a = ((TimelineRefresherQueryModel) profileRefresherModel.f1024l).m1148a().m1092a().m1087a();
                } else {
                    a = ((TimelineNuxQueryModel) profileRefresherModel.f1024l).m1143a().m1081a().m1076a();
                }
                str = a;
            }
            fbDraweeView.a(Uri.parse(str), ProfileRefresherView.f1041a);
        }
    }

    private void m965n(ProfileRefresherModel profileRefresherModel) {
        Preconditions.checkArgument(profileRefresherModel != null);
        if (this.f961f != null) {
            this.f961f.m1188a(profileRefresherModel.f1020h, profileRefresherModel.f1021i - 1);
        }
    }

    private boolean m967p(ProfileRefresherModel profileRefresherModel) {
        return (!m966o(profileRefresherModel) || profileRefresherModel.f1023k == null || this.f959d.f1052l.m1038b(profileRefresherModel.f1023k).T == null) ? false : true;
    }
}
