package com.facebook.crowdsourcing.suggestedits.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.loader.SuggestEditsLoader;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.logging.CrowdsourcingContext;
import com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger;
import com.facebook.crowdsourcing.picker.SuggestEditsPickerLauncher;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel.NodeModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel.NodeModel.Builder;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsHeaderModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsSectionsModel;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldHolder;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsHeaderHolder;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsHeaderState;
import com.facebook.crowdsourcing.suggestedits.fragment.SuggestEditsFragment;
import com.facebook.crowdsourcing.suggestedits.helper.SaveClaimsHelper;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.crowdsourcing.suggestedits.view.controller.PostSuggestEditsUpsellDialog;
import com.facebook.crowdsourcing.suggestedits.view.controller.SuggestEditsViewControllerManager;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.suggestions.common.SuggestPlaceInfoRunner;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.friendselector.CaspianFriendSelectorActivity;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream */
public class SuggestEditsController {
    public static final String f17612a = SuggestEditsController.class.getSimpleName();
    public boolean f17613A;
    public final SuggestEditsPickerLauncher f17614b;
    public final SuggestEditsAnalyticsLogger f17615c;
    public final Context f17616d;
    public final AbstractFbErrorReporter f17617e;
    public final Provider<Boolean> f17618f;
    public final Provider<Boolean> f17619g;
    public final ScreenUtil f17620h;
    public final SecureContextHelper f17621i;
    public final SuggestEditsLoader f17622j;
    private final SuggestPlaceInfoRunner f17623k;
    public final SuggestEditsViewControllerManager f17624l;
    public final Toaster f17625m;
    public final UriIntentMapper f17626n;
    public CrowdsourcingContext f17627o;
    private HasTitleBar f17628p;
    public String f17629q;
    public String f17630r;
    public SuggestEditsFragment f17631s;
    public LinearLayout f17632t;
    public ProgressBar f17633u;
    public SuggestEditsSectionsModel f17634v;
    public SuggestEditsHeaderHolder f17635w;
    public ImmutableList<SuggestEditsFieldHolder> f17636x;
    public PartsMarker f17637y;
    public PartsMarker f17638z;

    /* compiled from: com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream */
    public abstract class PartsMarker {
        private boolean[] f17601a = new boolean[SuggestEditsPart.values().length];

        abstract void mo1367a();

        PartsMarker() {
        }

        public final void m21462a(SuggestEditsPart suggestEditsPart) {
            this.f17601a[suggestEditsPart.ordinal()] = true;
            int i = 0;
            while (i < SuggestEditsPart.values().length) {
                if (this.f17601a[i]) {
                    i++;
                } else {
                    return;
                }
            }
            mo1367a();
        }
    }

    /* compiled from: com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream */
    class C14681 extends PartsMarker {
        final /* synthetic */ SuggestEditsController f17602a;

        C14681(SuggestEditsController suggestEditsController) {
            this.f17602a = suggestEditsController;
        }

        final void mo1367a() {
            this.f17602a.f17625m.b(new ToastBuilder(2131239147));
            this.f17602a.f17631s.m21524b();
        }
    }

    /* compiled from: com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream */
    class C14692 extends PartsMarker {
        final /* synthetic */ SuggestEditsController f17603a;

        C14692(SuggestEditsController suggestEditsController) {
            this.f17603a = suggestEditsController;
        }

        final void mo1367a() {
            this.f17603a.f17615c.b(this.f17603a.f17627o, this.f17603a.f17629q);
        }
    }

    /* compiled from: com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream */
    class C14703 extends OnToolbarButtonListener {
        final /* synthetic */ SuggestEditsController f17604a;

        C14703(SuggestEditsController suggestEditsController) {
            this.f17604a = suggestEditsController;
        }

        public final void m21465a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f17604a.m21478b();
        }
    }

    /* compiled from: com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream */
    class C14736 implements OnClickListener {
        final /* synthetic */ SuggestEditsController f17609a;

        C14736(SuggestEditsController suggestEditsController) {
            this.f17609a = suggestEditsController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f17609a.f17631s.m21524b();
        }
    }

    /* compiled from: com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream */
    public class C14747 implements OnClickListener {
        final /* synthetic */ SuggestEditsController f17610a;

        public C14747(SuggestEditsController suggestEditsController) {
            this.f17610a = suggestEditsController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream */
    public class C14758 implements OnClickListener {
        final /* synthetic */ SuggestEditsController f17611a;

        public C14758(SuggestEditsController suggestEditsController) {
            this.f17611a = suggestEditsController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f17611a.f17631s.m21524b();
        }
    }

    /* compiled from: com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream */
    public enum SuggestEditsPart {
        HEADER,
        SECTIONS
    }

    public static SuggestEditsController m21469b(InjectorLike injectorLike) {
        return new SuggestEditsController((Context) injectorLike.getInstance(Context.class), ScreenUtil.a(injectorLike), SuggestEditsAnalyticsLogger.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 3948), IdBasedProvider.a(injectorLike, 3951), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SuggestEditsLoader.m21337a(injectorLike), SuggestEditsPickerLauncher.m21358a(injectorLike), SuggestPlaceInfoRunner.b(injectorLike), SuggestEditsViewControllerManager.m21665a(injectorLike), Toaster.b(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public SuggestEditsController(Context context, ScreenUtil screenUtil, SuggestEditsAnalyticsLogger suggestEditsAnalyticsLogger, FbErrorReporter fbErrorReporter, Provider<Boolean> provider, Provider<Boolean> provider2, SecureContextHelper secureContextHelper, SuggestEditsLoader suggestEditsLoader, SuggestEditsPickerLauncher suggestEditsPickerLauncher, SuggestPlaceInfoRunner suggestPlaceInfoRunner, SuggestEditsViewControllerManager suggestEditsViewControllerManager, Toaster toaster, UriIntentMapper uriIntentMapper) {
        this.f17615c = suggestEditsAnalyticsLogger;
        this.f17616d = context;
        this.f17620h = screenUtil;
        this.f17617e = fbErrorReporter;
        this.f17618f = provider;
        this.f17619g = provider2;
        this.f17621i = secureContextHelper;
        this.f17622j = suggestEditsLoader;
        this.f17614b = suggestEditsPickerLauncher;
        this.f17623k = suggestPlaceInfoRunner;
        this.f17624l = suggestEditsViewControllerManager;
        this.f17625m = toaster;
        this.f17626n = uriIntentMapper;
    }

    public final void m21475a(Bundle bundle, CrowdsourcingContext crowdsourcingContext, String str, String str2, LinearLayout linearLayout, ProgressBar progressBar, SuggestEditsFragment suggestEditsFragment) {
        this.f17627o = crowdsourcingContext;
        this.f17629q = str;
        this.f17630r = str2;
        this.f17631s = suggestEditsFragment;
        this.f17632t = linearLayout;
        this.f17633u = progressBar;
        this.f17637y = new C14681(this);
        this.f17638z = new C14692(this);
        this.f17614b.f17459e = bundle == null ? null : bundle.getString("state_caller_field_type");
        this.f17613A = false;
    }

    public final void m21474a(Bundle bundle) {
        SuggestEditsHeaderState suggestEditsHeaderState;
        int max = Math.max(this.f17620h.c(), this.f17632t.getResources().getDimensionPixelSize(2131432717));
        if (bundle == null) {
            suggestEditsHeaderState = null;
        } else {
            suggestEditsHeaderState = (SuggestEditsHeaderState) bundle.getParcelable("state_header");
        }
        if (suggestEditsHeaderState == null || !suggestEditsHeaderState.f17671a) {
            SuggestEditsViewControllerManager suggestEditsViewControllerManager = this.f17624l;
            Fragment fragment = this.f17631s;
            LinearLayout linearLayout = this.f17632t;
            String str = this.f17630r;
            Builder builder = new Builder();
            builder.f2414k = str;
            NodeModel a = builder.m2563a();
            EdgesModel.Builder builder2 = new EdgesModel.Builder();
            builder2.f2403a = a;
            EdgesModel a2 = builder2.m2560a();
            UserValuesModel.Builder builder3 = new UserValuesModel.Builder();
            builder3.f2402a = ImmutableList.of(a2);
            UserValuesModel a3 = builder3.m2558a();
            CrowdsourcedFieldModel.Builder builder4 = new CrowdsourcedFieldModel.Builder();
            builder4.f2401b = a3;
            CrowdsourcedFieldModel.Builder builder5 = builder4;
            builder5.f2400a = false;
            CrowdsourcedFieldModel a4 = builder5.m2555a();
            SuggestEditsHeaderModel.Builder builder6 = new SuggestEditsHeaderModel.Builder();
            builder6.f2505a = a4;
            this.f17635w = suggestEditsViewControllerManager.m21669a(fragment, this, linearLayout, new SuggestEditsHeaderState(builder6.m2753a(), false), this.f17629q);
            this.f17622j.m21339a(this.f17629q, max, this);
        } else {
            this.f17635w = this.f17624l.m21669a(this.f17631s, this, this.f17632t, suggestEditsHeaderState, this.f17629q);
            if (!m21470b(this.f17635w.m21511c())) {
                this.f17637y.m21462a(SuggestEditsPart.HEADER);
            }
            this.f17638z.m21462a(SuggestEditsPart.HEADER);
        }
        m21471d(bundle);
    }

    private void m21471d(Bundle bundle) {
        ArrayList arrayList;
        SuggestEditsSectionsModel suggestEditsSectionsModel = bundle == null ? null : (SuggestEditsSectionsModel) FlatBufferModelHelper.a(bundle, "state_original_sections");
        if (bundle == null) {
            arrayList = null;
        } else {
            arrayList = (ArrayList) FlatBufferModelHelper.b(bundle, "state_sections");
        }
        if (suggestEditsSectionsModel == null || arrayList == null) {
            this.f17622j.m21340a(this.f17629q, this);
            return;
        }
        this.f17634v = suggestEditsSectionsModel;
        this.f17636x = this.f17624l.m21670a(this.f17631s, this, this.f17632t, suggestEditsSectionsModel, this.f17629q);
        if (arrayList.size() != this.f17636x.size()) {
            this.f17617e.a(f17612a, "The number of re-created SuggestEditsFieldHolders didn't match the number of savedSuggestEditFields");
        }
        if (this.f17636x.isEmpty()) {
            this.f17637y.m21462a(SuggestEditsPart.SECTIONS);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            ((SuggestEditsFieldHolder) this.f17636x.get(i)).m21487a((SuggestEditsField) arrayList.get(i));
        }
        this.f17633u.setVisibility(8);
        this.f17638z.m21462a(SuggestEditsPart.SECTIONS);
    }

    public final void m21477a(Throwable th) {
        this.f17617e.a(f17612a, "Loading Suggest Edits Header failed: " + th.getMessage());
    }

    public final void m21479b(Throwable th) {
        this.f17633u.setVisibility(8);
        this.f17625m.b(new ToastBuilder(2131239146));
        this.f17631s.m21524b();
        this.f17617e.a(f17612a, "Loading Suggest Edits Sections failed: " + th.getMessage());
    }

    public final void m21476a(HasTitleBar hasTitleBar) {
        this.f17628p = hasTitleBar;
        hasTitleBar.setCustomTitle(null);
        this.f17628p.y_(2131239138);
        this.f17628p.c(true);
        this.f17628p.a(new C14703(this));
        m21472e();
    }

    public final void m21473a() {
        if (!this.f17613A) {
            this.f17613A = true;
            this.f17615c.c(this.f17627o, this.f17629q);
            m21472e();
        }
    }

    public final void m21478b() {
        if (this.f17635w != null && this.f17636x != null) {
            final ProgressDialog a = ProgressDialog.a(this.f17616d, this.f17616d.getString(2131239154), this.f17616d.getString(2131239155), true, false);
            SuggestEditsFieldChangedListener suggestEditsFieldChangedListener = this.f17635w;
            if (suggestEditsFieldChangedListener.f17670f.hasFocus()) {
                suggestEditsFieldChangedListener.f17668d.m21671a(suggestEditsFieldChangedListener.f17670f, suggestEditsFieldChangedListener, SuggestEditsListViewType.PAGE_HEADER, suggestEditsFieldChangedListener);
            }
            int size = this.f17636x.size();
            for (int i = 0; i < size; i++) {
                SuggestEditsFieldHolder suggestEditsFieldHolder = (SuggestEditsFieldHolder) this.f17636x.get(i);
                if (suggestEditsFieldHolder.f17661f.hasFocus()) {
                    suggestEditsFieldHolder.f17656a.m21671a(suggestEditsFieldHolder.f17661f, suggestEditsFieldHolder.f17664i, suggestEditsFieldHolder.f17662g, suggestEditsFieldHolder);
                }
            }
            if (this.f17635w.m21512e()) {
                SaveClaimsHelper.m21548a(this.f17627o, this.f17631s.getContext(), this.f17635w.m21511c(), Long.valueOf(Long.parseLong(this.f17629q)));
            }
            this.f17623k.a(SaveClaimsHelper.m21547a(this.f17627o, this.f17629q, this.f17635w, this.f17636x), new AbstractDisposableFutureCallback<Void>(this) {
                final /* synthetic */ SuggestEditsController f17606b;

                protected final void m21466a(Object obj) {
                    this.f17606b.f17625m.a(new ToastBuilder(2131239156));
                    a.dismiss();
                    if (((Boolean) this.f17606b.f17618f.get()).booleanValue()) {
                        SuggestEditsController.m21468a(this.f17606b, this.f17606b.f17616d.getString(2131239172), this.f17606b.f17616d.getString(2131239173), new Intent(this.f17606b.f17616d, CaspianFriendSelectorActivity.class).putExtra("com.facebook.katana.profile.id", this.f17606b.f17629q).putExtra("title", this.f17606b.f17616d.getString(2131239182)).putExtra("target_fragment", ContentFragmentType.FRIEND_VOTE_INVITE_FRAGMENT.ordinal()));
                    } else if (((Boolean) this.f17606b.f17619g.get()).booleanValue()) {
                        SuggestEditsController.m21468a(this.f17606b, this.f17606b.f17616d.getString(2131239170), this.f17606b.f17616d.getString(2131239171), this.f17606b.f17626n.a(this.f17606b.f17616d, StringFormatUtil.a(FBLinks.dZ, new Object[]{CrowdEntryPoint.POST_SUGGEST_EDITS_UPSELL.getFullName()})));
                    } else {
                        this.f17606b.f17631s.m21524b();
                    }
                }

                protected final void m21467a(Throwable th) {
                    a.dismiss();
                    this.f17606b.f17625m.b(new ToastBuilder(2131239157));
                }
            });
        }
    }

    public static void m21468a(SuggestEditsController suggestEditsController, String str, String str2, final Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(suggestEditsController.f17616d);
        PostSuggestEditsUpsellDialog postSuggestEditsUpsellDialog = new PostSuggestEditsUpsellDialog(suggestEditsController.f17616d);
        postSuggestEditsUpsellDialog.f17734b.setText(str);
        postSuggestEditsUpsellDialog.f17733a.setText(str2);
        postSuggestEditsUpsellDialog.f17733a.setOnClickListener(new View.OnClickListener(suggestEditsController) {
            final /* synthetic */ SuggestEditsController f17608b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -986004761);
                if (intent != null) {
                    this.f17608b.f17631s.m21524b();
                    this.f17608b.f17621i.a(intent, this.f17608b.f17616d);
                } else {
                    this.f17608b.f17617e.a(SuggestEditsController.f17612a, "Could not launch Post Suggest Edits Upsell intent");
                    this.f17608b.f17625m.b(new ToastBuilder(2131230761));
                }
                LogUtils.a(-1876188101, a);
            }
        });
        builder.b(postSuggestEditsUpsellDialog).a(false).c(2131239175, new C14736(suggestEditsController));
        builder.a().show();
        suggestEditsController.f17615c.a(CrowdEntryPoint.POST_SUGGEST_EDITS_UPSELL, Optional.of(suggestEditsController.f17629q));
    }

    private void m21472e() {
        if (this.f17628p != null) {
            HasTitleBar hasTitleBar = this.f17628p;
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.g = this.f17631s.jW_().getString(2131239153);
            a = a;
            a.d = this.f17613A;
            hasTitleBar.a(a.a());
        }
    }

    public static boolean m21470b(SuggestEditsHeaderModel suggestEditsHeaderModel) {
        return suggestEditsHeaderModel != null && ((suggestEditsHeaderModel.m2758a() != null && suggestEditsHeaderModel.m2758a().m2600a()) || (suggestEditsHeaderModel.m2763b() != null && suggestEditsHeaderModel.m2763b().m2600a()));
    }
}
