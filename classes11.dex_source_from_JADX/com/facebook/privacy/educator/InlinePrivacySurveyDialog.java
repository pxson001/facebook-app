package com.facebook.privacy.educator;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass28;
import com.facebook.composer.activity.InlinePrivacySurveyController;
import com.facebook.composer.activity.InlinePrivacySurveyController.C07701;
import com.facebook.composer.activity.InlinePrivacySurveyController.C07712;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.Builder;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorType;
import com.facebook.privacy.protocol.ReportInlinePrivacySurveyActionParams.InlinePrivacySurveyEvent;
import com.facebook.resources.ui.EllipsizingTextView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.user.model.User;
import com.facebook.user.module.UserNameUtil;
import com.google.common.base.Preconditions;
import javax.inject.Provider;

/* compiled from: STATUS_CHANGE */
public class InlinePrivacySurveyDialog extends FbDialogFragment {
    public UserNameUtil am;
    public Provider<User> an;
    public C07701 ao;
    public C07712 ap;
    public View aq;
    public FbTextView ar;
    public EllipsizingTextView as;
    public EllipsizingTextView at;
    public EllipsizingTextView au;
    public FbTextView av;

    /* compiled from: STATUS_CHANGE */
    public class C13681 implements OnClickListener {
        final /* synthetic */ InlinePrivacySurveyDialog f11290a;

        public C13681(InlinePrivacySurveyDialog inlinePrivacySurveyDialog) {
            this.f11290a = inlinePrivacySurveyDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1626599544);
            C07712 c07712 = this.f11290a.ap;
            c07712.f6192a.a();
            GraphQLPrivacyOption graphQLPrivacyOption = c07712.f6195d.f6202d.mFirstSurveyOption;
            c07712.f6195d.f6207i.a(InlinePrivacySurveyEvent.CHOSE_FIRST_OPTION, c07712.f6195d.f6202d.mTriggerPrivacyOption, graphQLPrivacyOption, "traditional_composer");
            InlinePrivacySurveyController.m7637a(c07712.f6195d, graphQLPrivacyOption, c07712.f6193b, c07712.f6194c);
            Logger.a(2, EntryType.UI_INPUT_END, 440430587, a);
        }
    }

    /* compiled from: STATUS_CHANGE */
    public class C13692 implements OnClickListener {
        final /* synthetic */ InlinePrivacySurveyDialog f11291a;

        public C13692(InlinePrivacySurveyDialog inlinePrivacySurveyDialog) {
            this.f11291a = inlinePrivacySurveyDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1639549917);
            C07712 c07712 = this.f11291a.ap;
            c07712.f6192a.a();
            GraphQLPrivacyOption graphQLPrivacyOption = c07712.f6195d.f6202d.mSecondSurveyOption;
            c07712.f6195d.f6207i.a(InlinePrivacySurveyEvent.CHOSE_SECOND_OPTION, c07712.f6195d.f6202d.mTriggerPrivacyOption, graphQLPrivacyOption, "traditional_composer");
            InlinePrivacySurveyController.m7637a(c07712.f6195d, graphQLPrivacyOption, c07712.f6193b, c07712.f6194c);
            Logger.a(2, EntryType.UI_INPUT_END, -1924582835, a);
        }
    }

    /* compiled from: STATUS_CHANGE */
    public class C13703 implements OnClickListener {
        final /* synthetic */ InlinePrivacySurveyDialog f11292a;

        public C13703(InlinePrivacySurveyDialog inlinePrivacySurveyDialog) {
            this.f11292a = inlinePrivacySurveyDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1926112067);
            C07712 c07712 = this.f11292a.ap;
            c07712.f6192a.a();
            c07712.f6195d.f6203e = true;
            c07712.f6195d.f6207i.c(c07712.f6195d.f6202d.mTriggerPrivacyOption, "traditional_composer");
            AnonymousClass28 anonymousClass28 = c07712.f6194c;
            Builder a2 = anonymousClass28.f6058a.aS.az().a();
            a2.e = AudienceEducatorType.INLINE_PRIVACY_SURVEY;
            anonymousClass28.f6058a.aU.m7630b(ComposerFragment.cn).m7663a(a2.a()).m7689a();
            ComposerFragment.bd(anonymousClass28.f6058a);
            Logger.a(2, EntryType.UI_INPUT_END, -1673527468, a);
        }
    }

    /* compiled from: STATUS_CHANGE */
    public class C13714 implements OnClickListener {
        final /* synthetic */ InlinePrivacySurveyDialog f11293a;

        public C13714(InlinePrivacySurveyDialog inlinePrivacySurveyDialog) {
            this.f11293a = inlinePrivacySurveyDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1277298664);
            C07712 c07712 = this.f11293a.ap;
            c07712.f6192a.a();
            c07712.f6195d.f6207i.b(c07712.f6195d.f6202d.mTriggerPrivacyOption, "traditional_composer");
            c07712.f6194c.m7463a();
            Logger.a(2, EntryType.UI_INPUT_END, -1106857496, a);
        }
    }

    public static void m11665a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        InlinePrivacySurveyDialog inlinePrivacySurveyDialog = (InlinePrivacySurveyDialog) obj;
        UserNameUtil a = UserNameUtil.a(fbInjector);
        Provider a2 = IdBasedProvider.a(fbInjector, 3595);
        inlinePrivacySurveyDialog.am = a;
        inlinePrivacySurveyDialog.an = a2;
    }

    public final void m11667a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -397243576);
        super.a(bundle);
        Class cls = InlinePrivacySurveyDialog.class;
        m11665a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 988914340, a);
    }

    public final View m11666a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CharSequence b;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -859447285);
        Preconditions.checkNotNull(this.ao);
        Preconditions.checkNotNull(this.ap);
        this.aq = layoutInflater.inflate(2130904906, viewGroup, true);
        if (StringUtil.a(this.am.a((User) this.an.get()))) {
            b = b(2131242447);
        } else {
            Object a2 = a(2131242446, new Object[]{this.am.a((User) this.an.get())});
        }
        this.ar = (FbTextView) this.aq.findViewById(2131563155);
        this.ar.setText(b);
        this.as = (EllipsizingTextView) this.aq.findViewById(2131563157);
        this.as.setText(this.ao.f6191a.f6202d.mFirstSurveyOption.d());
        this.as.setOnClickListener(new C13681(this));
        this.at = (EllipsizingTextView) this.aq.findViewById(2131563158);
        this.at.setText(this.ao.f6191a.f6202d.mSecondSurveyOption.d());
        this.at.setOnClickListener(new C13692(this));
        this.au = (EllipsizingTextView) this.aq.findViewById(2131563159);
        this.au.setOnClickListener(new C13703(this));
        this.av = (FbTextView) this.aq.findViewById(2131563160);
        this.av.setOnClickListener(new C13714(this));
        View view = this.aq;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2083373735, a);
        return view;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2113305594);
        this.as.setOnClickListener(null);
        this.at.setOnClickListener(null);
        this.au.setOnClickListener(null);
        this.av.setOnClickListener(null);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1054678161, a);
    }
}
