package com.facebook.privacy.educator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.audience.AudienceEducatorManager;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorAction;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorPrivacyType;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorType;
import com.facebook.privacy.protocol.ReportAAAOnlyMeActionParams.AudienceAlignmentOnlyMeEvent;
import com.facebook.privacy.protocol.ReportAAATuxActionParams.AudienceAlignmentTuxEvent;
import com.facebook.privacy.protocol.ReportNASActionParams.NewcomerAudienceSelectorEvent;
import com.facebook.user.model.User;
import com.facebook.user.module.UserNameUtil;
import com.facebook.widget.text.SimpleVariableTextLayoutView;
import javax.inject.Provider;

/* compiled from: SUB_ADAPTER_ITEM_BOTTOM */
public final class AudienceEducatorFragment extends FbFragment {
    public AudienceEducatorType f11271a;
    public String f11272b;
    public Provider<User> f11273c;
    public UserNameUtil f11274d;
    public SecureContextHelper f11275e;
    public AudienceEducatorManager f11276f;
    public View f11277g;
    private TextView f11278h;

    /* compiled from: SUB_ADAPTER_ITEM_BOTTOM */
    class C13561 implements OnClickListener {
        final /* synthetic */ AudienceEducatorFragment f11262a;

        C13561(AudienceEducatorFragment audienceEducatorFragment) {
            this.f11262a = audienceEducatorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1400729294);
            AudienceEducatorFragment.m11647a(this.f11262a, ReportedActionType.CHOSE_PUBLIC, this.f11262a.f11272b);
            AudienceEducatorFragment.m11646a(this.f11262a, AudienceEducatorAction.SET_PRIVACY_TO_WIDEST);
            Logger.a(2, EntryType.UI_INPUT_END, 542768547, a);
        }
    }

    /* compiled from: SUB_ADAPTER_ITEM_BOTTOM */
    class C13572 implements OnClickListener {
        final /* synthetic */ AudienceEducatorFragment f11263a;

        C13572(AudienceEducatorFragment audienceEducatorFragment) {
            this.f11263a = audienceEducatorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -917508988);
            AudienceEducatorFragment.m11647a(this.f11263a, ReportedActionType.CHOSE_FRIENDS, this.f11263a.f11272b);
            AudienceEducatorFragment.m11646a(this.f11263a, AudienceEducatorAction.SET_PRIVACY_TO_FRIENDS);
            Logger.a(2, EntryType.UI_INPUT_END, 719518064, a);
        }
    }

    /* compiled from: SUB_ADAPTER_ITEM_BOTTOM */
    class C13583 implements OnClickListener {
        final /* synthetic */ AudienceEducatorFragment f11264a;

        C13583(AudienceEducatorFragment audienceEducatorFragment) {
            this.f11264a = audienceEducatorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1443896901);
            AudienceEducatorFragment.m11647a(this.f11264a, ReportedActionType.CHOSE_ONLY_ME, this.f11264a.f11272b);
            AudienceEducatorFragment.m11646a(this.f11264a, AudienceEducatorAction.SET_PRIVACY_TO_ONLY_ME);
            Logger.a(2, EntryType.UI_INPUT_END, -1222935525, a);
        }
    }

    /* compiled from: SUB_ADAPTER_ITEM_BOTTOM */
    class C13594 implements OnClickListener {
        final /* synthetic */ AudienceEducatorFragment f11265a;

        C13594(AudienceEducatorFragment audienceEducatorFragment) {
            this.f11265a = audienceEducatorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1294732056);
            AudienceEducatorFragment.m11647a(this.f11265a, ReportedActionType.CHOSE_MORE_OPTIONS, this.f11265a.f11272b);
            AudienceEducatorFragment.m11646a(this.f11265a, AudienceEducatorAction.OPEN_MORE_OPTIONS);
            Logger.a(2, EntryType.UI_INPUT_END, 1508936289, a);
        }
    }

    /* compiled from: SUB_ADAPTER_ITEM_BOTTOM */
    class C13605 implements OnClickListener {
        final /* synthetic */ AudienceEducatorFragment f11266a;

        C13605(AudienceEducatorFragment audienceEducatorFragment) {
            this.f11266a = audienceEducatorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1210484240);
            AudienceEducatorFragment.m11647a(this.f11266a, ReportedActionType.CHOSE_SKIP, this.f11266a.f11272b);
            AudienceEducatorFragment.m11646a(this.f11266a, AudienceEducatorAction.SKIPPED_EDUCATOR);
            Logger.a(2, EntryType.UI_INPUT_END, 120363857, a);
        }
    }

    /* compiled from: SUB_ADAPTER_ITEM_BOTTOM */
    class C13616 implements OnClickListener {
        final /* synthetic */ AudienceEducatorFragment f11267a;

        C13616(AudienceEducatorFragment audienceEducatorFragment) {
            this.f11267a = audienceEducatorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 136009638);
            AudienceEducatorFragment.m11647a(this.f11267a, ReportedActionType.LEARN_MORE, this.f11267a.f11272b);
            AudienceEducatorFragment audienceEducatorFragment = this.f11267a;
            Intent intent = new Intent(audienceEducatorFragment.getContext(), AudienceEducatorLearnMoreActivity.class);
            intent.putExtra("extra_audience_educator_type", audienceEducatorFragment.f11271a);
            audienceEducatorFragment.f11275e.a(intent, audienceEducatorFragment.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 1845811215, a);
        }
    }

    /* compiled from: SUB_ADAPTER_ITEM_BOTTOM */
    public class C13627 implements OnPreDrawListener {
        final /* synthetic */ AudienceEducatorFragment f11268a;

        public C13627(AudienceEducatorFragment audienceEducatorFragment) {
            this.f11268a = audienceEducatorFragment;
        }

        public boolean onPreDraw() {
            if (this.f11268a.f11277g.getHeight() < 64) {
                this.f11268a.f11277g.setVisibility(4);
            } else {
                this.f11268a.f11277g.setVisibility(0);
                Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(500);
                scaleAnimation.setInterpolator(new OvershootInterpolator(1.0f));
                this.f11268a.f11277g.startAnimation(scaleAnimation);
            }
            this.f11268a.f11277g.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    /* compiled from: SUB_ADAPTER_ITEM_BOTTOM */
    /* synthetic */ class C13638 {
        static final /* synthetic */ int[] f11269a = new int[AudienceEducatorType.values().length];

        static {
            f11270b = new int[ReportedActionType.values().length];
            try {
                f11270b[ReportedActionType.EXPOSED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11270b[ReportedActionType.NAVIGATED_BACK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11270b[ReportedActionType.CHOSE_PUBLIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11270b[ReportedActionType.CHOSE_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11270b[ReportedActionType.CHOSE_ONLY_ME.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f11270b[ReportedActionType.CHOSE_MORE_OPTIONS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f11270b[ReportedActionType.CHOSE_SKIP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f11270b[ReportedActionType.LEARN_MORE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f11269a[AudienceEducatorType.AUDIENCE_ALIGNMENT_EDUCATOR.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f11269a[AudienceEducatorType.AUDIENCE_ALIGNMENT_ONLY_ME_EDUCATOR.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f11269a[AudienceEducatorType.NEWCOMER_AUDIENCE_EDUCATOR.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* compiled from: SUB_ADAPTER_ITEM_BOTTOM */
    public enum ReportedActionType {
        EXPOSED,
        NAVIGATED_BACK,
        CHOSE_PUBLIC,
        CHOSE_FRIENDS,
        CHOSE_ONLY_ME,
        CHOSE_MORE_OPTIONS,
        CHOSE_SKIP,
        LEARN_MORE
    }

    public static void m11648a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AudienceEducatorFragment audienceEducatorFragment = (AudienceEducatorFragment) obj;
        Provider a = IdBasedProvider.a(fbInjector, 3595);
        UserNameUtil a2 = UserNameUtil.a(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        AudienceEducatorManager a3 = AudienceEducatorManager.a(fbInjector);
        audienceEducatorFragment.f11273c = a;
        audienceEducatorFragment.f11274d = a2;
        audienceEducatorFragment.f11275e = secureContextHelper;
        audienceEducatorFragment.f11276f = a3;
    }

    public final void m11653c(Bundle bundle) {
        super.c(bundle);
        Class cls = AudienceEducatorFragment.class;
        m11648a((Object) this, getContext());
        this.f11271a = (AudienceEducatorType) this.s.getSerializable("extra_audience_educator_type");
        if (this.f11271a == null || this.f11271a == AudienceEducatorType.NONE) {
            this.f11271a = AudienceEducatorType.AUDIENCE_ALIGNMENT_EDUCATOR;
        }
        this.f11272b = this.s.getString("audience_educator_source_extra");
    }

    public final View m11652a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String a;
        int a2 = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1312131955);
        View inflate = layoutInflater.inflate(2130903309, null);
        this.f11278h = (TextView) inflate.findViewById(2131559726);
        String b = b(2131242450);
        User user = (User) this.f11273c.get();
        String str = "";
        if (user != null) {
            a = this.f11274d.a(user);
        } else {
            a = str;
        }
        this.f11278h.setText(StringLocaleUtil.a(b, new Object[]{a}));
        m11650c(inflate);
        m11649b(inflate);
        this.f11277g = inflate.findViewById(2131559728);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1916912431, a2);
        return inflate;
    }

    public final void m11651G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 434302852);
        super.G();
        this.f11277g.getViewTreeObserver().addOnPreDrawListener(new C13627(this));
        this.f11278h.requestFocus();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1978350404, a);
    }

    private void m11649b(View view) {
        CharSequence b;
        Object b2;
        if (ar()) {
            b = b(2131242436);
        } else if (as()) {
            b2 = b(2131242427);
        } else {
            b2 = b(2131242419);
        }
        ((TextView) view.findViewById(2131559727)).setText(b);
        if (ar()) {
            b = b(2131242437);
        } else {
            b2 = b(2131242420);
        }
        ((TextView) view.findViewById(2131559729)).setText(b);
    }

    private void m11650c(View view) {
        SimpleVariableTextLayoutView simpleVariableTextLayoutView = (SimpleVariableTextLayoutView) view.findViewById(2131559731);
        GraphQLPrivacyOption graphQLPrivacyOption = this.f11276f.j;
        if (graphQLPrivacyOption == null || as()) {
            simpleVariableTextLayoutView.setVisibility(8);
        } else {
            simpleVariableTextLayoutView.setOnClickListener(new C13561(this));
            simpleVariableTextLayoutView.setText(graphQLPrivacyOption.d());
            simpleVariableTextLayoutView.setVisibility(0);
        }
        view.findViewById(2131559732).setOnClickListener(new C13572(this));
        View findViewById = view.findViewById(2131559733);
        if (as()) {
            findViewById.setOnClickListener(new C13583(this));
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        view.findViewById(2131559734).setOnClickListener(new C13594(this));
        view.findViewById(2131559736).setOnClickListener(new C13605(this));
        view.findViewById(2131559735).setOnClickListener(new C13616(this));
    }

    public static void m11646a(AudienceEducatorFragment audienceEducatorFragment, AudienceEducatorAction audienceEducatorAction) {
        Intent intent = new Intent();
        intent.putExtra("audience_educator_composer_action", audienceEducatorAction).putExtra("audience_educator_privacy_type_extra", AudienceEducatorPrivacyType.STICKY);
        audienceEducatorFragment.ao().setResult(-1, intent);
        audienceEducatorFragment.ao().finish();
    }

    public static void m11647a(AudienceEducatorFragment audienceEducatorFragment, ReportedActionType reportedActionType, String str) {
        switch (reportedActionType) {
            case EXPOSED:
                switch (C13638.f11269a[audienceEducatorFragment.f11271a.ordinal()]) {
                    case 1:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentTuxEvent.EXPOSED, str);
                        return;
                    case 2:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentOnlyMeEvent.EXPOSED, str);
                        audienceEducatorFragment.f11276f.h = true;
                        return;
                    case 3:
                        audienceEducatorFragment.f11276f.a(NewcomerAudienceSelectorEvent.EXPOSED, str);
                        return;
                    default:
                        return;
                }
            case NAVIGATED_BACK:
                switch (C13638.f11269a[audienceEducatorFragment.f11271a.ordinal()]) {
                    case 1:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentTuxEvent.NAVIGATED_BACK, str);
                        return;
                    case 2:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentOnlyMeEvent.NAVIGATED_BACK, str);
                        audienceEducatorFragment.f11276f.h = false;
                        return;
                    case 3:
                        audienceEducatorFragment.f11276f.a(NewcomerAudienceSelectorEvent.NAVIGATED_BACK, str);
                        return;
                    default:
                        return;
                }
            case CHOSE_PUBLIC:
                switch (C13638.f11269a[audienceEducatorFragment.f11271a.ordinal()]) {
                    case 1:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentTuxEvent.PUBLIC_PRIVACY, str);
                        return;
                    case 2:
                        BLog.c(AudienceEducatorFragment.class, "AAA-only-me chose Public");
                        return;
                    case 3:
                        audienceEducatorFragment.f11276f.a(NewcomerAudienceSelectorEvent.WIDEST_PRIVACY, str);
                        return;
                    default:
                        return;
                }
            case CHOSE_FRIENDS:
                switch (C13638.f11269a[audienceEducatorFragment.f11271a.ordinal()]) {
                    case 1:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentTuxEvent.FRIENDS_PRIVACY, str);
                        return;
                    case 2:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentOnlyMeEvent.FRIENDS_PRIVACY, str);
                        return;
                    case 3:
                        audienceEducatorFragment.f11276f.a(NewcomerAudienceSelectorEvent.FRIENDS_PRIVACY, str);
                        return;
                    default:
                        return;
                }
            case CHOSE_ONLY_ME:
                switch (C13638.f11269a[audienceEducatorFragment.f11271a.ordinal()]) {
                    case 1:
                        BLog.c(AudienceEducatorFragment.class, "AAA (public) chose Only Me");
                        return;
                    case 2:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentOnlyMeEvent.ONLY_ME_PRIVACY, str);
                        return;
                    case 3:
                        BLog.c(AudienceEducatorFragment.class, "NAS chose Only Me");
                        return;
                    default:
                        return;
                }
            case CHOSE_MORE_OPTIONS:
                switch (C13638.f11269a[audienceEducatorFragment.f11271a.ordinal()]) {
                    case 1:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentTuxEvent.MORE_OPTIONS, str);
                        return;
                    case 2:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentOnlyMeEvent.MORE_OPTIONS, str);
                        return;
                    case 3:
                        audienceEducatorFragment.f11276f.a(NewcomerAudienceSelectorEvent.MORE_OPTIONS, str);
                        return;
                    default:
                        return;
                }
            case CHOSE_SKIP:
                switch (C13638.f11269a[audienceEducatorFragment.f11271a.ordinal()]) {
                    case 1:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentTuxEvent.DISMISSED, str);
                        return;
                    case 2:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentOnlyMeEvent.DISMISSED, str);
                        return;
                    case 3:
                        audienceEducatorFragment.f11276f.a(NewcomerAudienceSelectorEvent.SKIPPED, str);
                        return;
                    default:
                        return;
                }
            case LEARN_MORE:
                switch (C13638.f11269a[audienceEducatorFragment.f11271a.ordinal()]) {
                    case 1:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentTuxEvent.LEARN_MORE, str);
                        return;
                    case 2:
                        audienceEducatorFragment.f11276f.a(AudienceAlignmentOnlyMeEvent.LEARN_MORE, str);
                        return;
                    case 3:
                        audienceEducatorFragment.f11276f.a(NewcomerAudienceSelectorEvent.LEARN_MORE, str);
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    private boolean ar() {
        return this.f11271a == AudienceEducatorType.NEWCOMER_AUDIENCE_EDUCATOR;
    }

    private boolean as() {
        return this.f11271a == AudienceEducatorType.AUDIENCE_ALIGNMENT_ONLY_ME_EDUCATOR;
    }
}
