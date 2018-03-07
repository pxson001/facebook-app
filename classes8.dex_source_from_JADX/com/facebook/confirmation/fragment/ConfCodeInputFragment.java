package com.facebook.confirmation.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.confirmation.constants.ConfFragmentState;
import com.facebook.confirmation.graphql.FBResendContactpointCodeFragments.FBResendContactpointCodeCoreMutationString;
import com.facebook.confirmation.graphql.FBResendContactpointCodeFragmentsModels.FBResendContactpointCodeCoreMutationFragmentModel;
import com.facebook.confirmation.graphql.FBResendContactpointCodeFragmentsModels.FBResendContactpointCodeCoreMutationFragmentModel.Builder;
import com.facebook.confirmation.protocol.ConfirmContactpointMethod.Params;
import com.facebook.confirmation.protocol.ConfirmationSource;
import com.facebook.confirmation.util.ConfirmationUtil;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.ResendContactpointCodeInputData;
import com.facebook.graphql.calls.ResendContactpointCodeInputData.PromoType;
import com.facebook.graphql.calls.ResendContactpointCodeInputData.Source;
import com.facebook.graphql.error.GraphQLError;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.growth.model.Contactpoint;
import com.facebook.growth.model.ContactpointType;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.util.UserPhoneNumberUtil;
import com.facebook.widget.text.BetterLinkMovementMethod;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.nio.ByteBuffer;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: intro_notifications_ls */
public abstract class ConfCodeInputFragment extends ConfInputFragment {
    public final CallerContext as = CallerContext.a(ConfCodeInputFragment.class);
    private TextView at;
    public EditText au;
    public TextView av;
    public ContentView aw;
    public ContentView ax;
    public ContentView ay;
    @Inject
    public DefaultBlueServiceOperationFactory f10735b;
    @Inject
    Toaster f10736c;
    @Inject
    ConfirmationUtil f10737d;
    @Inject
    UserPhoneNumberUtil f10738e;
    @Inject
    Locales f10739f;
    @Inject
    public GlyphColorizer f10740g;
    @Inject
    BetterLinkMovementMethod f10741h;
    @Inject
    GraphQLQueryExecutor f10742i;

    /* compiled from: intro_notifications_ls */
    class C11451 extends BaseTextWatcher {
        final /* synthetic */ ConfCodeInputFragment f10724a;

        C11451(ConfCodeInputFragment confCodeInputFragment) {
            this.f10724a = confCodeInputFragment;
        }

        public void afterTextChanged(Editable editable) {
            this.f10724a.ap.setEnabled(editable.length() > 0);
            this.f10724a.aq.setVisibility(8);
            this.f10724a.au.getBackground().mutate().clearColorFilter();
        }
    }

    /* compiled from: intro_notifications_ls */
    class C11462 extends OperationResultFutureCallback {
        final /* synthetic */ ConfCodeInputFragment f10725a;

        C11462(ConfCodeInputFragment confCodeInputFragment) {
            this.f10725a = confCodeInputFragment;
        }

        protected final void m12654a(ServiceException serviceException) {
            this.f10725a.au.getBackground().mutate().setColorFilter(this.f10725a.jW_().getColor(2131361918), Mode.SRC_ATOP);
            this.f10725a.m12664a(serviceException);
        }

        protected final void m12655a(Object obj) {
            if (this.f10725a.al.f10778c) {
                this.f10725a.f10736c.a(new ToastBuilder(2131239778));
            } else {
                this.f10725a.f10736c.a(new ToastBuilder(2131239777));
            }
            if (this.f10725a.al.f10777b) {
                this.f10725a.f10737d.m12751a();
            }
            this.f10725a.m12663a(ConfFragmentState.CODE_SUCCESS);
        }
    }

    /* compiled from: intro_notifications_ls */
    public class C11484 extends OperationResultFutureCallback {
        final /* synthetic */ int f10728a;
        final /* synthetic */ ConfCodeInputFragment f10729b;

        public C11484(ConfCodeInputFragment confCodeInputFragment, int i) {
            this.f10729b = confCodeInputFragment;
            this.f10728a = i;
        }

        protected final void m12656a(ServiceException serviceException) {
            CharSequence b = this.f10729b.m12665b(serviceException);
            if (!StringUtil.a(b)) {
                this.f10729b.f10736c.b(new ToastBuilder(b));
            }
        }

        protected final void m12657a(Object obj) {
            if (!this.f10729b.al.f10776a.m17345a()) {
                this.f10729b.m12663a(ConfFragmentState.UPDATE_PHONE);
            }
            this.f10729b.f10736c.b(new ToastBuilder(this.f10728a));
        }
    }

    /* compiled from: intro_notifications_ls */
    class C11495 implements FutureCallback<GraphQLResult<FBResendContactpointCodeCoreMutationFragmentModel>> {
        final /* synthetic */ ConfCodeInputFragment f10730a;

        C11495(ConfCodeInputFragment confCodeInputFragment) {
            this.f10730a = confCodeInputFragment;
        }

        public void onSuccess(Object obj) {
            this.f10730a.f10736c.b(new ToastBuilder(2131239753));
        }

        public void onFailure(Throwable th) {
            CharSequence charSequence;
            String str = null;
            if (th instanceof GraphQLException) {
                GraphQLError graphQLError = ((GraphQLException) th).error;
                if (graphQLError != null) {
                    str = graphQLError.description;
                }
                charSequence = str;
            } else {
                charSequence = null;
            }
            this.f10730a.f10736c.b(charSequence == null ? new ToastBuilder(2131230758) : new ToastBuilder(charSequence));
        }
    }

    /* compiled from: intro_notifications_ls */
    public class C11506 implements OnClickListener {
        final /* synthetic */ ConfCodeInputFragment f10731a;

        public C11506(ConfCodeInputFragment confCodeInputFragment) {
            this.f10731a = confCodeInputFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1705684037);
            if (this.f10731a.al.f10778c) {
                ConfCodeInputFragment.aE(this.f10731a);
            } else {
                int i;
                int i2;
                ConfInputFragment confInputFragment = this.f10731a;
                Bundle bundle = new Bundle();
                bundle.putParcelable("confirmationSendConfirmationCodeParams", confInputFragment.al.f10776a);
                if (confInputFragment.al.f10776a.type == ContactpointType.PHONE) {
                    i = 2131239753;
                    i2 = 2131239774;
                } else {
                    i = 2131239752;
                    i2 = 2131239775;
                }
                Futures.a(BlueServiceOperationFactoryDetour.a(confInputFragment.f10735b, "confirmation_send_confirmation_code", bundle, ErrorPropagation.BY_ERROR_CODE, confInputFragment.as, 873782776).a(new DialogBasedProgressIndicator(confInputFragment.getContext(), i2)).a(), new C11484(confInputFragment, i), confInputFragment.am);
            }
            LogUtils.a(790599472, a);
        }
    }

    /* compiled from: intro_notifications_ls */
    public class C11517 implements OnClickListener {
        final /* synthetic */ ConfCodeInputFragment f10732a;

        public C11517(ConfCodeInputFragment confCodeInputFragment) {
            this.f10732a = confCodeInputFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1222476522);
            this.f10732a.m12663a(this.f10732a.aw());
            Logger.a(2, EntryType.UI_INPUT_END, 1075726959, a);
        }
    }

    /* compiled from: intro_notifications_ls */
    public class C11528 implements OnClickListener {
        final /* synthetic */ ConfCodeInputFragment f10733a;

        public C11528(ConfCodeInputFragment confCodeInputFragment) {
            this.f10733a = confCodeInputFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 831524556);
            this.f10733a.m12663a(this.f10733a.ay());
            Logger.a(2, EntryType.UI_INPUT_END, -346824753, a);
        }
    }

    public static void m12670a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ConfCodeInputFragment) obj).m12669a(DefaultBlueServiceOperationFactory.b(fbInjector), Toaster.b(fbInjector), ConfirmationUtil.m12750b(fbInjector), UserPhoneNumberUtil.a(fbInjector), Locales.a(fbInjector), GlyphColorizer.a(fbInjector), BetterLinkMovementMethod.a(fbInjector), GraphQLQueryExecutor.a(fbInjector));
    }

    public abstract int aA();

    public abstract int au();

    public abstract int av();

    protected abstract ConfFragmentState aw();

    public abstract int ax();

    protected abstract ConfFragmentState ay();

    public abstract int az();

    private void m12669a(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Toaster toaster, ConfirmationUtil confirmationUtil, UserPhoneNumberUtil userPhoneNumberUtil, Locales locales, GlyphColorizer glyphColorizer, BetterLinkMovementMethod betterLinkMovementMethod, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f10735b = defaultBlueServiceOperationFactory;
        this.f10736c = toaster;
        this.f10737d = confirmationUtil;
        this.f10738e = userPhoneNumberUtil;
        this.f10739f = locales;
        this.f10740g = glyphColorizer;
        this.f10741h = betterLinkMovementMethod;
        this.f10742i = graphQLQueryExecutor;
    }

    public final void mo755c(Bundle bundle) {
        super.mo755c(bundle);
        Class cls = ConfCodeInputFragment.class;
        m12670a(this, getContext());
    }

    public final void mo754b(View view, Bundle bundle) {
        this.at = (TextView) FindViewUtil.b(view, 2131560628);
        this.au = (EditText) FindViewUtil.b(view, 2131560672);
        this.av = (TextView) FindViewUtil.b(view, 2131560668);
        this.aw = (ContentView) FindViewUtil.b(view, 2131560669);
        this.ax = (ContentView) FindViewUtil.b(view, 2131560670);
        this.ay = (ContentView) FindViewUtil.b(view, 2131560671);
        this.av.setText(au());
        this.aw.setTitleText(av());
        this.aw.setThumbnailDrawable(this.f10740g.a(2130840092, -7235677));
        this.aw.setOnClickListener(new C11506(this));
        this.ax.setTitleText(ax());
        this.ax.setThumbnailDrawable(this.f10740g.a(2130838464, -7235677));
        this.ax.setOnClickListener(new C11517(this));
        if (!this.al.f10778c) {
            this.ay.setTitleText(az());
            this.ay.setThumbnailDrawable(this.f10740g.a(aA(), -7235677));
            this.ay.setOnClickListener(new C11528(this));
        }
        this.ap.setEnabled(false);
        this.au.addTextChangedListener(new C11451(this));
        m12662a(this.au);
        aC();
    }

    protected final int mo756e() {
        return 2130903743;
    }

    protected final int aq() {
        return 2130903742;
    }

    protected final int ar() {
        return this.al.f10778c ? 2131239750 : 2131239749;
    }

    protected final int as() {
        return 2131230729;
    }

    protected final void at() {
        Object obj = this.au.getText().toString();
        if (StringUtil.a(obj)) {
            this.f10736c.a(new ToastBuilder(2131239773));
            return;
        }
        KeyboardUtils.a(o());
        Parcelable params = new Params(this.al.f10776a, obj, ConfirmationSource.ANDROID_DIALOG_API);
        Bundle bundle = new Bundle();
        bundle.putParcelable("confirmationConfirmContactpointParams", params);
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f10735b, "confirmation_confirm_contactpoint", bundle, ErrorPropagation.BY_ERROR_CODE, this.as, -296190839).a(new DialogBasedProgressIndicator(getContext(), 2131239766)).a(), new C11462(this), this.am);
    }

    private void aC() {
        String d;
        String string;
        ConfFragmentState confFragmentState;
        Contactpoint contactpoint = this.al.f10776a;
        Resources jW_ = jW_();
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(jW_);
        if (contactpoint.type == ContactpointType.PHONE) {
            d = this.f10738e.d(contactpoint.normalized);
            string = jW_.getString(2131239789);
            confFragmentState = ConfFragmentState.UPDATE_PHONE;
            Locale a = this.f10739f.a();
            styledStringBuilder.a(StringFormatUtil.formatStrLocaleSafe(jW_.getString(2131239787), "[[contactpoint]]", new Locale(a.getLanguage(), contactpoint.isoCountryCode).getDisplayCountry(a), "[[change_contactpoint]]"));
        } else {
            d = contactpoint.normalized;
            string = jW_.getString(2131239788);
            confFragmentState = ConfFragmentState.UPDATE_EMAIL;
            styledStringBuilder.a(StringFormatUtil.formatStrLocaleSafe(jW_.getString(2131239786), "[[contactpoint]]", "[[change_contactpoint]]"));
        }
        styledStringBuilder.a("[[contactpoint]]", d, new StyleSpan(1), 33).a("[[change_contactpoint]]", string, new ClickableSpan(this) {
            final /* synthetic */ ConfCodeInputFragment f10727b;

            public void onClick(View view) {
                this.f10727b.m12663a(confFragmentState);
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }, 33);
        this.at.setContentDescription(styledStringBuilder.b());
        this.at.setText(styledStringBuilder.b());
        this.at.setTypeface(null, 0);
        this.at.setMovementMethod(this.f10741h);
    }

    public static void aE(ConfCodeInputFragment confCodeInputFragment) {
        ResendContactpointCodeInputData resendContactpointCodeInputData = new ResendContactpointCodeInputData();
        resendContactpointCodeInputData.a("country", confCodeInputFragment.al.f10776a.isoCountryCode);
        GraphQlCallInput graphQlCallInput = resendContactpointCodeInputData;
        graphQlCallInput.a("contact_point", confCodeInputFragment.al.f10776a.normalized);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("source", Source.PHONE_ACQUISITION_PROMO);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("promo_type", PromoType.ACQUISITION);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("qp_id", confCodeInputFragment.al.f10779d);
        graphQlCallInput = graphQlCallInput;
        Builder builder = new Builder();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, builder.f10764a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        Futures.a(confCodeInputFragment.f10742i.a(GraphQLRequest.a((FBResendContactpointCodeCoreMutationString) new FBResendContactpointCodeCoreMutationString().a("input", graphQlCallInput)).a(new FBResendContactpointCodeCoreMutationFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null)))), new C11495(confCodeInputFragment), confCodeInputFragment.am);
    }
}
