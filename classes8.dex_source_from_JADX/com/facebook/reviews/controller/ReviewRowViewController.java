package com.facebook.reviews.controller;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.pagesprotocol.DeletePageReviewParams;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.feedback.ui.FeedbackPopoverLauncher;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.ExpandingEllipsizingTextView.ExpandState;
import com.facebook.resources.ui.ExpandingEllipsizingTextView.OnExpandStateChangeListener;
import com.facebook.reviews.analytics.ReviewsClickEventTargets;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.reviews.binder.ReviewFeedRowViewBinder;
import com.facebook.reviews.handler.DeleteReviewHandler;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewBasicFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithCreationFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.ui.ReviewFeedRowView;
import com.facebook.reviews.util.helper.ReviewsGraphQLHelper;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler;
import com.facebook.ufiservices.flyout.FeedbackParams.Builder;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: UNMUTE */
public class ReviewRowViewController {
    public final FbUriIntentHandler f21484a;
    public final FeedbackPopoverLauncher f21485b;
    public final Lazy<DeleteReviewHandler> f21486c;
    public final Provider<String> f21487d;
    private final ReviewFeedRowViewBinder f21488e;
    private final ReviewComposerLauncherAndHandler f21489f;
    public final ReviewsLogger f21490g;

    @Inject
    public ReviewRowViewController(FbUriIntentHandler fbUriIntentHandler, FeedbackPopoverLauncher feedbackPopoverLauncher, Lazy<DeleteReviewHandler> lazy, Provider<String> provider, ReviewFeedRowViewBinder reviewFeedRowViewBinder, ReviewComposerLauncherAndHandler reviewComposerLauncherAndHandler, ReviewsLogger reviewsLogger) {
        this.f21486c = lazy;
        this.f21484a = fbUriIntentHandler;
        this.f21485b = feedbackPopoverLauncher;
        this.f21487d = provider;
        this.f21488e = reviewFeedRowViewBinder;
        this.f21489f = reviewComposerLauncherAndHandler;
        this.f21490g = reviewsLogger;
    }

    public final void m25078a(ReviewFeedRowView reviewFeedRowView, ReviewWithFeedback reviewWithFeedback, String str, String str2, CurationSurface curationSurface, String str3, @Nullable OnExpandStateChangeListener onExpandStateChangeListener, ExpandState expandState) {
        this.f21488e.m25044a(reviewFeedRowView, reviewWithFeedback, str3);
        m25076b(reviewFeedRowView, reviewWithFeedback, str, str2, curationSurface, str3, onExpandStateChangeListener, expandState);
    }

    public final void m25077a(ReviewFeedRowView reviewFeedRowView, ReviewWithFeedback reviewWithFeedback, CharSequence charSequence, String str, String str2, CurationSurface curationSurface, String str3, @Nullable OnExpandStateChangeListener onExpandStateChangeListener, ExpandState expandState) {
        m25078a(reviewFeedRowView, reviewWithFeedback, str, str2, curationSurface, str3, onExpandStateChangeListener, expandState);
        ReviewFeedRowViewBinder.m25037a(reviewFeedRowView, charSequence);
    }

    private void m25076b(ReviewFeedRowView reviewFeedRowView, final ReviewWithFeedback reviewWithFeedback, final String str, String str2, CurationSurface curationSurface, final String str3, @Nullable OnExpandStateChangeListener onExpandStateChangeListener, ExpandState expandState) {
        reviewFeedRowView.setProfilePicOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ReviewRowViewController f21444d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2116961047);
                this.f21444d.f21490g.a(str3, str, ReviewsGraphQLHelper.m4914b(reviewWithFeedback), ReviewsClickEventTargets.REVIEW_CREATOR_PROFILE_PICTURE);
                ReviewRowViewController.m25069a(this.f21444d, view.getContext(), reviewWithFeedback);
                Logger.a(2, EntryType.UI_INPUT_END, 1110047568, a);
            }
        });
        reviewFeedRowView.setTitleOnClickListener(m25073b(reviewWithFeedback, str, str3));
        reviewFeedRowView.setSecondaryActionClickListener(m25062a(reviewWithFeedback, str, str2, curationSurface, str3));
        reviewFeedRowView.setReviewTextExpandedState(expandState);
        reviewFeedRowView.setReviewTextOnExpandStateChangeListener(onExpandStateChangeListener);
        m25065a(reviewFeedRowView, reviewWithFeedback, str, str3);
    }

    private OnClickListener m25073b(final ReviewWithFeedback reviewWithFeedback, final String str, final String str2) {
        return new OnClickListener(this) {
            final /* synthetic */ ReviewRowViewController f21448d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -698891606);
                this.f21448d.f21490g.a(str2, str, ReviewsGraphQLHelper.m4914b(reviewWithFeedback), ReviewsClickEventTargets.REVIEW_CREATOR_NAME);
                ReviewRowViewController.m25069a(this.f21448d, view.getContext(), reviewWithFeedback);
                Logger.a(2, EntryType.UI_INPUT_END, -1669884174, a);
            }
        };
    }

    private OnClickListener m25062a(ReviewWithFeedback reviewWithFeedback, String str, String str2, CurationSurface curationSurface, String str3) {
        final ReviewWithFeedback reviewWithFeedback2 = reviewWithFeedback;
        final String str4 = str;
        final String str5 = str2;
        final CurationSurface curationSurface2 = curationSurface;
        final String str6 = str3;
        return new OnClickListener(this) {
            final /* synthetic */ ReviewRowViewController f21454f;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 411320855);
                this.f21454f.m25066a(view, reviewWithFeedback2, str4, str5, curationSurface2, str6);
                Logger.a(2, EntryType.UI_INPUT_END, -1279192443, a);
            }
        };
    }

    private void m25065a(View view, ReviewWithFeedback reviewWithFeedback, String str, String str2) {
        final ReviewWithFeedback reviewWithFeedback2 = reviewWithFeedback;
        final String str3 = str2;
        final String str4 = str;
        final View view2 = view;
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ReviewRowViewController f21459e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -539745735);
                if (reviewWithFeedback2.bO_() != null) {
                    this.f21459e.f21490g.a(str3, str4, ReviewsGraphQLHelper.m4914b(reviewWithFeedback2), ReviewsClickEventTargets.REVIEW_ROW_VIEW);
                    ReviewRowViewController reviewRowViewController = this.f21459e;
                    View view2 = view2;
                    DefaultFeedbackFields bO_ = reviewWithFeedback2.bO_();
                    String str = str3;
                    Builder builder = new Builder();
                    builder.a = DefaultGraphQLConversionHelper.a(bO_);
                    builder = builder;
                    builder.d = bO_.z_();
                    builder = builder;
                    FeedbackLoggingParams.Builder builder2 = new FeedbackLoggingParams.Builder();
                    builder2.c = str;
                    builder.g = builder2.a();
                    reviewRowViewController.f21485b.a(view2.getContext(), builder.a());
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1658741870, a);
            }
        });
    }

    public static void m25069a(ReviewRowViewController reviewRowViewController, Context context, ReviewWithFeedback reviewWithFeedback) {
        String b = ReviewsGraphQLHelper.m4914b((ReviewWithCreationFields) reviewWithFeedback);
        if (!Strings.isNullOrEmpty(b)) {
            reviewRowViewController.f21484a.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, b));
        }
    }

    private void m25066a(View view, ReviewWithFeedback reviewWithFeedback, String str, String str2, CurationSurface curationSurface, String str3) {
        this.f21490g.a(str3, str, ReviewsGraphQLHelper.m4914b((ReviewWithCreationFields) reviewWithFeedback), ReviewsClickEventTargets.REVIEW_CHEVRON);
        if (((String) this.f21487d.get()).equals(ReviewsGraphQLHelper.m4914b((ReviewWithCreationFields) reviewWithFeedback))) {
            m25075b(view, reviewWithFeedback, str, str2, curationSurface, str3);
        } else if (reviewWithFeedback.bO_() != null) {
            m25074b(view, reviewWithFeedback, str, str3);
        }
    }

    private void m25074b(View view, ReviewWithFeedback reviewWithFeedback, String str, String str2) {
        Context context = view.getContext();
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(context);
        final View view2 = view;
        final ReviewWithFeedback reviewWithFeedback2 = reviewWithFeedback;
        final String str3 = str;
        final String str4 = str2;
        figPopoverMenuWindow.c().a(context.getString(2131235344)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReviewRowViewController f21464e;

            public boolean onMenuItemClick(MenuItem menuItem) {
                ReviewRowViewController reviewRowViewController = this.f21464e;
                Context context = view2.getContext();
                ReviewWithCreationFields reviewWithCreationFields = reviewWithFeedback2;
                String str = str3;
                reviewRowViewController.f21490g.a(str4, str, ReviewsGraphQLHelper.m4914b(reviewWithCreationFields), ReviewsClickEventTargets.REVIEW_REPORT_MENU_OPTION);
                reviewRowViewController.f21484a.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.cB, reviewWithCreationFields.bO_().j(), GraphQLNegativeFeedbackActionType.DONT_LIKE, "page_review"));
                return true;
            }
        });
        figPopoverMenuWindow.f(view);
    }

    private void m25075b(View view, ReviewWithFeedback reviewWithFeedback, String str, String str2, CurationSurface curationSurface, String str3) {
        Context context = view.getContext();
        PopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(context);
        m25068a(figPopoverMenuWindow, context, reviewWithFeedback, str, str2, curationSurface, str3);
        m25067a(figPopoverMenuWindow, context, reviewWithFeedback, str, curationSurface, str3);
        figPopoverMenuWindow.f(view);
    }

    private void m25068a(PopoverMenuWindow popoverMenuWindow, Context context, ReviewWithFeedback reviewWithFeedback, String str, String str2, CurationSurface curationSurface, String str3) {
        final Context context2 = context;
        final ReviewWithFeedback reviewWithFeedback2 = reviewWithFeedback;
        final String str4 = str;
        final String str5 = str2;
        final CurationSurface curationSurface2 = curationSurface;
        final String str6 = str3;
        popoverMenuWindow.c().a(context.getString(2131235330)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReviewRowViewController f21471g;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f21471g.m25063a(context2, reviewWithFeedback2, str4, str5, curationSurface2, str6);
                return true;
            }
        });
    }

    private void m25067a(PopoverMenuWindow popoverMenuWindow, Context context, ReviewWithFeedback reviewWithFeedback, String str, CurationSurface curationSurface, String str2) {
        MenuItemImpl a = popoverMenuWindow.c().a(context.getString(2131230732));
        final String b = ReviewsGraphQLHelper.m4914b((ReviewWithCreationFields) reviewWithFeedback);
        final String str3 = str2;
        final String str4 = str;
        final Context context2 = context;
        final CurationSurface curationSurface2 = curationSurface;
        a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReviewRowViewController f21477f;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f21477f.f21490g.a(str3, str4, b, ReviewsClickEventTargets.REVIEW_DELETE_MENU_OPTION);
                this.f21477f.m25064a(context2, str4, b, curationSurface2, str3);
                return true;
            }
        });
    }

    private void m25063a(Context context, ReviewWithFeedback reviewWithFeedback, String str, String str2, CurationSurface curationSurface, String str3) {
        this.f21490g.a(str3, str, ReviewsGraphQLHelper.m4914b((ReviewWithCreationFields) reviewWithFeedback), ReviewsClickEventTargets.REVIEW_EDIT_MENU_OPTION);
        this.f21489f.m4945a(1759, (Activity) context, ComposerSourceType.USER_REVIEWS_LIST, curationSurface, CurationMechanism.EDIT_MENU, ReviewsGraphQLHelper.m4909a((ReviewBasicFields) reviewWithFeedback), Long.parseLong(str), str2, ReviewsGraphQLHelper.m4913b((ReviewBasicFields) reviewWithFeedback), ReviewsGraphQLHelper.m4917c((ReviewBasicFields) reviewWithFeedback), null);
    }

    private void m25064a(Context context, String str, String str2, CurationSurface curationSurface, String str3) {
        final String str4 = str3;
        final String str5 = str;
        final String str6 = str2;
        final Context context2 = context;
        final CurationSurface curationSurface2 = curationSurface;
        new AlertDialog.Builder(context).b(context.getString(2131235332)).a(2131230732, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ ReviewRowViewController f21483f;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f21483f.f21490g.a(str4, str5, str6, ReviewsClickEventTargets.DELETE_DIALOG_CONFIRMATION_BUTTON);
                ((DeleteReviewHandler) this.f21483f.f21486c.get()).m25164a(context2, new DeletePageReviewParams(str5, CurationMechanism.EDIT_MENU, curationSurface2), str4);
            }
        }).b(2131230727, null).b();
    }
}
