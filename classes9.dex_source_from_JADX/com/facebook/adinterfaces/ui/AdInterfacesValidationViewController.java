package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEvents.AccountValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.BudgetValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CreativeValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ScheduleValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ServerValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ServerValidationEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ServerValidationRequestEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ServerValidationRequestEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.TargetingValidationEvent;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesDataValidation;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentValidationMessageModel;
import com.facebook.adinterfaces.protocol.ValidateCreateBoostedComponentMethod;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.enums.GraphQLBoostedComponentMessageType;
import com.facebook.graphql.enums.GraphQLBoostedComponentSpecElement;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unwrapped Uri is null/empty */
public class AdInterfacesValidationViewController extends BaseAdInterfacesViewController<BetterTextView, AdInterfacesDataModel> {
    public BaseAdInterfacesData f23007a;
    public ValidateCreateBoostedComponentMethod f23008b;
    public BoostedComponentLogger f23009c;
    public BetterTextView f23010d;
    public AdInterfacesErrorReporter f23011e;

    /* compiled from: Unwrapped Uri is null/empty */
    class C26883 extends ServerValidationRequestEventSubscriber {
        final /* synthetic */ AdInterfacesValidationViewController f23002a;

        C26883(AdInterfacesValidationViewController adInterfacesValidationViewController) {
            this.f23002a = adInterfacesValidationViewController;
        }

        public final void m24986b(FbEvent fbEvent) {
            this.f23002a.f22440b.m22431a(AdInterfacesDataValidation.SERVER_VALIDATION_ERROR, true);
            AdInterfacesBoostedComponentDataModel a = AdInterfacesDataHelper.m22791a(this.f23002a.f23007a);
            if (a != null) {
                this.f23002a.f23008b.m24051a(a, this.f23002a.f23010d.getContext(), 0, true);
            } else {
                this.f23002a.f23011e.m22726a(getClass(), "data cannot be null, please add validation support to this data model");
            }
        }
    }

    /* compiled from: Unwrapped Uri is null/empty */
    public /* synthetic */ class C26905 {
        public static final /* synthetic */ int[] f23005a = new int[GraphQLBoostedComponentSpecElement.values().length];
        static final /* synthetic */ int[] f23006b = new int[GraphQLBoostedComponentMessageType.values().length];

        static {
            try {
                f23006b[GraphQLBoostedComponentMessageType.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23006b[GraphQLBoostedComponentMessageType.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23006b[GraphQLBoostedComponentMessageType.TIP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23005a[GraphQLBoostedComponentSpecElement.CREATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23005a[GraphQLBoostedComponentSpecElement.TARGETING.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f23005a[GraphQLBoostedComponentSpecElement.BUDGET.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f23005a[GraphQLBoostedComponentSpecElement.SCHEDULE.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f23005a[GraphQLBoostedComponentSpecElement.ACCOUNT.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        BetterTextView betterTextView = (BetterTextView) view;
        super.mo982a(betterTextView, adInterfacesCardLayout);
        this.f23010d = betterTextView;
        final Context context = betterTextView.getContext();
        this.f22440b.m22430a(new C26883(this));
        this.f22440b.m22430a(new ServerValidationEventSubscriber(this) {
            final /* synthetic */ AdInterfacesValidationViewController f23004b;

            public final void m24987b(FbEvent fbEvent) {
                ServerValidationEvent serverValidationEvent = (ServerValidationEvent) fbEvent;
                if (serverValidationEvent.f21677a == null || serverValidationEvent.f21677a.isEmpty()) {
                    this.f23004b.f23010d.setVisibility(8);
                    this.f23004b.f22440b.m22431a(AdInterfacesDataValidation.SERVER_VALIDATION_ERROR, true);
                    return;
                }
                BoostedComponentValidationMessageModel boostedComponentValidationMessageModel = (BoostedComponentValidationMessageModel) serverValidationEvent.f21677a.get(0);
                if (AdInterfacesValidationViewController.m24988a(this.f23004b, boostedComponentValidationMessageModel)) {
                    int a;
                    Drawable a2;
                    GlyphColorizer glyphColorizer = new GlyphColorizer(this.f23004b.f23010d.getResources());
                    switch (C26905.f23006b[boostedComponentValidationMessageModel.m23360a().ordinal()]) {
                        case 1:
                            a = AdInterfacesUiUtil.m25233a(context, 2131362864);
                            a2 = glyphColorizer.a(2130843853, AdInterfacesUiUtil.m25233a(context, 2131361920));
                            this.f23004b.f22440b.m22431a(AdInterfacesDataValidation.SERVER_VALIDATION_ERROR, false);
                            break;
                        case 2:
                            a = AdInterfacesUiUtil.m25233a(context, 2131362867);
                            a2 = glyphColorizer.a(2130843853, AdInterfacesUiUtil.m25233a(context, 2131361920));
                            this.f23004b.f22440b.m22431a(AdInterfacesDataValidation.SERVER_VALIDATION_ERROR, true);
                            break;
                        default:
                            a = AdInterfacesUiUtil.m25233a(context, 2131362870);
                            a2 = glyphColorizer.a(2130843854, AdInterfacesUiUtil.m25233a(context, 2131361920));
                            this.f23004b.f22440b.m22431a(AdInterfacesDataValidation.SERVER_VALIDATION_ERROR, true);
                            break;
                    }
                    this.f23004b.f23010d.setBackgroundColor(a);
                    this.f23004b.f23010d.setCompoundDrawablesWithIntrinsicBounds(a2, null, null, null);
                    this.f23004b.f23010d.setVisibility(0);
                    this.f23004b.f23009c.m22766a(this.f23004b.f23007a, boostedComponentValidationMessageModel.m23363k().a(), boostedComponentValidationMessageModel.m23360a().name());
                }
            }
        });
        this.f22440b.m22429a(new ServerValidationRequestEvent());
    }

    @Inject
    public AdInterfacesValidationViewController(ValidateCreateBoostedComponentMethod validateCreateBoostedComponentMethod, BoostedComponentLogger boostedComponentLogger, AdInterfacesErrorReporter adInterfacesErrorReporter) {
        this.f23008b = validateCreateBoostedComponentMethod;
        this.f23009c = boostedComponentLogger;
        this.f23011e = adInterfacesErrorReporter;
    }

    public static boolean m24988a(AdInterfacesValidationViewController adInterfacesValidationViewController, final BoostedComponentValidationMessageModel boostedComponentValidationMessageModel) {
        if (boostedComponentValidationMessageModel.m23362j() == GraphQLBoostedComponentSpecElement.GENERIC || boostedComponentValidationMessageModel.m23362j() == GraphQLBoostedComponentSpecElement.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            adInterfacesValidationViewController.f23010d.setText(boostedComponentValidationMessageModel.m23363k().a());
            return true;
        } else if (adInterfacesValidationViewController.f23007a.mo962b().getComponentAppEnum() == null) {
            switch (C26905.f23005a[boostedComponentValidationMessageModel.m23362j().ordinal()]) {
                case 1:
                    adInterfacesValidationViewController.f22440b.m22429a(new CreativeValidationEvent(boostedComponentValidationMessageModel));
                    break;
            }
            return false;
        } else {
            String string;
            Resources resources = adInterfacesValidationViewController.f23010d.getResources();
            String string2 = resources.getString(2131234100);
            String string3 = resources.getString(2131234099);
            StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
            CharSequence charSequence = "[[component]]";
            switch (C26905.f23005a[boostedComponentValidationMessageModel.m23362j().ordinal()]) {
                case 1:
                    string = adInterfacesValidationViewController.f23010d.getResources().getString(2131233908);
                    break;
                case 2:
                    string = adInterfacesValidationViewController.f23010d.getResources().getString(2131234022);
                    break;
                default:
                    string = "";
                    break;
            }
            styledStringBuilder.a(string2.replace(charSequence, string));
            final int a = AdInterfacesUiUtil.m25233a(adInterfacesValidationViewController.f23010d.getContext(), 2131361961);
            final ClickableSpan c26861 = new ClickableSpan(adInterfacesValidationViewController) {
                final /* synthetic */ AdInterfacesValidationViewController f22999c;

                public void onClick(View view) {
                    switch (C26905.f23005a[boostedComponentValidationMessageModel.m23362j().ordinal()]) {
                        case 1:
                            this.f22999c.f22440b.m22429a(new CreativeValidationEvent(boostedComponentValidationMessageModel));
                            break;
                        case 2:
                            this.f22999c.f22440b.m22429a(new TargetingValidationEvent(boostedComponentValidationMessageModel));
                            break;
                        case 3:
                            this.f22999c.f22440b.m22429a(new BudgetValidationEvent(boostedComponentValidationMessageModel));
                            break;
                        case 4:
                            this.f22999c.f22440b.m22429a(new ScheduleValidationEvent(boostedComponentValidationMessageModel));
                            break;
                        case 5:
                            this.f22999c.f22440b.m22429a(new AccountValidationEvent(boostedComponentValidationMessageModel));
                            break;
                    }
                    this.f22999c.f23010d.setVisibility(8);
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                    textPaint.setColor(a);
                }
            };
            adInterfacesValidationViewController.f23010d.setOnClickListener(new OnClickListener(adInterfacesValidationViewController) {
                final /* synthetic */ AdInterfacesValidationViewController f23001b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 2126109377);
                    c26861.onClick(view);
                    Logger.a(2, EntryType.UI_INPUT_END, -1713539627, a);
                }
            });
            styledStringBuilder.a("[[tap_to_view]]", string3, c26861, 33);
            adInterfacesValidationViewController.f23010d.setText(styledStringBuilder.b());
            adInterfacesValidationViewController.f23010d.setMovementMethod(LinkMovementMethod.getInstance());
            return true;
        }
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f23007a = baseAdInterfacesData;
    }

    public final void mo981a() {
        super.mo981a();
        this.f23008b.m24050a();
        this.f23010d = null;
        this.f23007a = null;
    }
}
