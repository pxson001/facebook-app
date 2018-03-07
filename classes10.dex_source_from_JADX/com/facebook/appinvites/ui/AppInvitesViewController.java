package com.facebook.appinvites.ui;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.appinvites.adapter.AppInviteContentPagerAdapter;
import com.facebook.appinvites.adapter.AppInviteContentPagerAdapterProvider;
import com.facebook.appinvites.data.AppInvitesDataCluster;
import com.facebook.appinvites.data.AppInvitesGraphqlMutationHelper;
import com.facebook.appinvites.data.InstalledAppsCache;
import com.facebook.appinvites.events.AppInviteEvents.AppInviteApplicationBlockedEvent;
import com.facebook.appinvites.events.AppInviteEvents.AppInviteCollapseAnimationCompleteEvent;
import com.facebook.appinvites.events.AppInviteEvents.AppInviteDeletedEvent;
import com.facebook.appinvites.events.AppInviteEvents.AppInviteUserBlockedEvent;
import com.facebook.appinvites.events.AppInvitesEventBus;
import com.facebook.appinvites.installtracking.AppInvitesInstallTracker;
import com.facebook.appinvites.logging.AppInvitesLoggingHelper;
import com.facebook.appinvites.nux.AppInviteCaretNuxInterstitialController;
import com.facebook.appinvites.nux.AppInvitesNuxSyncController;
import com.facebook.appinvites.protocol.AppInvitesMutations.AppRequestDeleteCoreMutationString;
import com.facebook.appinvites.protocol.FetchAppInvitesListQueryModels.AppInviteFieldsModel;
import com.facebook.appinvites.protocol.FetchAppInvitesListQueryModels.AppInviteFieldsModel.ApplicationModel.OverallStarRatingModel;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ApplicationRequestDeleteInputData;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.animations.BaseAnimatorListener;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: download_postponed */
public class AppInvitesViewController {
    public final Provider<FbUriIntentHandler> f14726a;
    public final AppInvitesInstallTracker f14727b;
    public final AppInvitesEventBus f14728c;
    public final InstalledAppsCache f14729d;
    public final AppInvitesGraphqlMutationHelper f14730e;
    private final AppInviteContentPagerAdapterProvider f14731f;
    public final SecureContextHelper f14732g;
    public final AppInvitesLoggingHelper f14733h;
    private final InterstitialManager f14734i;
    private final AppInvitesNuxSyncController f14735j;
    private final GatekeeperStoreImpl f14736k;

    public static AppInvitesViewController m15104b(InjectorLike injectorLike) {
        return new AppInvitesViewController(AppInvitesEventBus.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 616), AppInvitesInstallTracker.b(injectorLike), InstalledAppsCache.a(injectorLike), AppInvitesGraphqlMutationHelper.m14748a(injectorLike), (AppInviteContentPagerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AppInviteContentPagerAdapterProvider.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), AppInvitesLoggingHelper.m14767b(injectorLike), InterstitialManager.a(injectorLike), AppInvitesNuxSyncController.m14769a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AppInvitesViewController(AppInvitesEventBus appInvitesEventBus, Provider<FbUriIntentHandler> provider, AppInvitesInstallTracker appInvitesInstallTracker, InstalledAppsCache installedAppsCache, AppInvitesGraphqlMutationHelper appInvitesGraphqlMutationHelper, AppInviteContentPagerAdapterProvider appInviteContentPagerAdapterProvider, SecureContextHelper secureContextHelper, AppInvitesLoggingHelper appInvitesLoggingHelper, InterstitialManager interstitialManager, AppInvitesNuxSyncController appInvitesNuxSyncController, GatekeeperStore gatekeeperStore) {
        this.f14728c = appInvitesEventBus;
        this.f14726a = provider;
        this.f14727b = appInvitesInstallTracker;
        this.f14729d = installedAppsCache;
        this.f14730e = appInvitesGraphqlMutationHelper;
        this.f14731f = appInviteContentPagerAdapterProvider;
        this.f14732g = secureContextHelper;
        this.f14733h = appInvitesLoggingHelper;
        this.f14734i = interstitialManager;
        this.f14735j = appInvitesNuxSyncController;
        this.f14736k = gatekeeperStore;
    }

    public final void m15106a(final AppInvitesDataCluster appInvitesDataCluster, final AppInviteView appInviteView) {
        if (appInvitesDataCluster.m14746b() == 0) {
            if (appInviteView.f14700a.getAdapter() != null) {
                appInviteView.f14700a.getAdapter().kR_();
            }
            int measuredHeight = appInviteView.getMeasuredHeight();
            TimeInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{measuredHeight, 1});
            ofInt.setInterpolator(accelerateDecelerateInterpolator);
            ofInt.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ AppInvitesViewController f14722b;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (appInviteView.getLayoutParams() != null) {
                        appInviteView.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        appInviteView.requestLayout();
                    }
                }
            });
            ofInt.addListener(new BaseAnimatorListener(this) {
                final /* synthetic */ AppInvitesViewController f14725b;

                /* compiled from: download_postponed */
                class C20621 implements Runnable {
                    final /* synthetic */ C20637 f14723a;

                    C20621(C20637 c20637) {
                        this.f14723a = c20637;
                    }

                    public void run() {
                        this.f14723a.f14725b.f14728c.a(new AppInviteCollapseAnimationCompleteEvent());
                        appInviteView.getLayoutParams().height = -2;
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    HandlerDetour.a(new Handler(), new C20621(this), 1497850509);
                }
            });
            ofInt.setDuration(300);
            ofInt.start();
            return;
        }
        AppInvitesLoggingHelper appInvitesLoggingHelper = this.f14733h;
        String str = "app_invite_cell_did_show";
        if (appInvitesDataCluster.m14746b() != 0) {
            HoneyClientEvent b = AppInvitesLoggingHelper.m14766b(str);
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = appInvitesDataCluster.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((AppInviteFieldsModel) it.next()).ne_()).append(",");
            }
            b.b("object_ids", stringBuilder.substring(0, stringBuilder.length() - 1).toString());
            b.b("app_id", appInvitesDataCluster.m14747b(0).m15017c().m14991d());
            appInvitesLoggingHelper.f14610a.a(b);
        }
        appInviteView.setSocialContext(appInvitesDataCluster.m14747b(0).m15017c().m14990c());
        appInviteView.f14702c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppInvitesViewController f14705b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -60553907);
                this.f14705b.f14733h.m14768a("app_invite_chevron_button_did_tapped", appInvitesDataCluster.m14747b(appInvitesDataCluster.f14574a));
                AppInvitesViewController.m15103a(this.f14705b, view, appInvitesDataCluster.m14747b(appInvitesDataCluster.f14574a));
                Logger.a(2, EntryType.UI_INPUT_END, -1143055922, a);
            }
        });
        AppInviteContentPagerAdapterProvider appInviteContentPagerAdapterProvider = this.f14731f;
        appInviteView.f14700a.setAdapter(new AppInviteContentPagerAdapter(RecyclableViewPoolManager.a(appInviteContentPagerAdapterProvider), m15104b(appInviteContentPagerAdapterProvider), appInvitesDataCluster));
        appInviteView.f14700a.setOnPageChangeListener(new OnPageChangeListener(this) {
            final /* synthetic */ AppInvitesViewController f14707b;

            public final void m15096a(int i, float f, int i2) {
            }

            public final void e_(int i) {
                AppInvitesDataCluster appInvitesDataCluster = appInvitesDataCluster;
                boolean z = i >= 0 && i < appInvitesDataCluster.f14575b.size();
                Preconditions.checkArgument(z);
                appInvitesDataCluster.f14574a = i;
            }

            public final void m15097b(int i) {
            }
        });
        appInviteView.f14700a.setCurrentItem(appInvitesDataCluster.f14574a);
        m15100a(appInviteView.f14701b, appInvitesDataCluster);
        m15102a(appInviteView);
    }

    public final void m15107a(final AppInviteContentView appInviteContentView, final AppInvitesDataCluster appInvitesDataCluster, final int i) {
        AppInviteFieldsModel b = appInvitesDataCluster.m14747b(i);
        appInviteContentView.setSenderName(b.nf_().m15003c());
        appInviteContentView.setTimestamp(b.m15018d());
        appInviteContentView.setMessage(b.m15020j().a());
        appInviteContentView.setSenderImageURI(Uri.parse(b.nf_().m15004d().b()));
        appInviteContentView.setSenderImageOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppInvitesViewController f14711d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1642760425);
                this.f14711d.f14733h.m14768a("app_invite_sender_did_tapped", appInvitesDataCluster.m14747b(i));
                this.f14711d.f14732g.b(new Intent("android.intent.action.VIEW").setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, appInvitesDataCluster.m14747b(i).nf_().m15002b()))), appInviteContentView.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 954047742, a);
            }
        });
        if (b.m15019g() != null) {
            appInviteContentView.setPreviewImageUri(Uri.parse(b.m15019g().b()));
        } else {
            appInviteContentView.setPreviewImageUri(null);
        }
        appInviteContentView.setPreviewImageOnClickListener(m15099a(appInvitesDataCluster, "app_invite_canvas_tapped"));
        m15101a(appInviteContentView.i, appInvitesDataCluster);
    }

    private void m15100a(AppInviteAppDetailsView appInviteAppDetailsView, AppInvitesDataCluster appInvitesDataCluster) {
        appInviteAppDetailsView.setAppName(appInvitesDataCluster.m14747b(0).m15017c().m14992g());
        if (appInvitesDataCluster.m14747b(0).m15017c().nh_() != null) {
            appInviteAppDetailsView.setAppPictureURI(Uri.parse(appInvitesDataCluster.m14747b(0).m15017c().nh_().b()));
        }
        OverallStarRatingModel ni_ = appInvitesDataCluster.m14747b(0).m15017c().ni_();
        if (ni_ != null) {
            appInviteAppDetailsView.setAppRating((float) ni_.m14976a());
        } else {
            appInviteAppDetailsView.setAppRating(0.0f);
        }
        if (!this.f14729d.a(appInvitesDataCluster.m14747b(0).m15017c().m14989b().m14972a())) {
            appInviteAppDetailsView.setInstallLabel(2131241793);
        } else if (appInvitesDataCluster.m14747b(0).m15017c().ng_()) {
            appInviteAppDetailsView.setInstallLabel(2131241794);
        } else {
            appInviteAppDetailsView.setInstallLabel(2131241795);
        }
        appInviteAppDetailsView.setInstallOnClickListener(m15099a(appInvitesDataCluster, "app_invite_install_button_tapped"));
    }

    private void m15101a(AppInvitePromotionDetailsView appInvitePromotionDetailsView, AppInvitesDataCluster appInvitesDataCluster) {
        if (this.f14736k.a(512, false)) {
            String nd_ = appInvitesDataCluster.m14747b(0).nd_();
            if (nd_ != null && nd_.length() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject(nd_);
                    String str = jSONObject.optString("promo_code").toString();
                    nd_ = jSONObject.optString("promo_text").toString();
                    if (nd_ != null && nd_.length() > 0) {
                        appInvitePromotionDetailsView.setPromotionText(nd_);
                        nd_ = appInvitePromotionDetailsView.getContext().getResources().getString(2131241837);
                        if (str != null && str.length() > 0) {
                            nd_ = String.format(appInvitePromotionDetailsView.getContext().getResources().getString(2131241838), new Object[]{str});
                        }
                        appInvitePromotionDetailsView.setPromotionCodeLine(nd_);
                        appInvitePromotionDetailsView.setVisibility(0);
                        this.f14733h.m14768a("app_invite_promotion_displayed", appInvitesDataCluster.m14747b(appInvitesDataCluster.m14745a()));
                    }
                } catch (JSONException e) {
                    this.f14733h.m14768a("app_invite_promotion_parsing_failed", appInvitesDataCluster.m14747b(appInvitesDataCluster.m14745a()));
                }
            }
        }
    }

    public final void m15105a(Context context, AppInvitesDataCluster appInvitesDataCluster, int i) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(2130903283, null);
        AppInviteContentView appInviteContentView = (AppInviteContentView) viewGroup.findViewById(2131559680);
        m15107a(appInviteContentView, appInvitesDataCluster, i);
        appInviteContentView.setMessageMaxLines(Integer.MAX_VALUE);
        m15100a((AppInviteAppDetailsView) viewGroup.findViewById(2131559666), appInvitesDataCluster);
        int dimension = (int) context.getResources().getDimension(2131427416);
        new Builder(context).a(viewGroup, 0, dimension, 0, dimension).a().show();
    }

    private OnClickListener m15099a(final AppInvitesDataCluster appInvitesDataCluster, final String str) {
        return new OnClickListener(this) {
            final /* synthetic */ AppInvitesViewController f14714c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 740251961);
                this.f14714c.f14733h.m14768a(str, appInvitesDataCluster.m14747b(appInvitesDataCluster.f14574a));
                AppInviteFieldsModel b = appInvitesDataCluster.m14747b(appInvitesDataCluster.f14574a);
                String a2 = b.m15017c().m14989b().m14972a();
                if (!this.f14714c.f14729d.a(a2)) {
                    this.f14714c.f14727b.a(b.ne_(), a2);
                }
                Map hashMap = new HashMap();
                hashMap.put("organic_product", "AppInvites");
                hashMap.put("organic_surface", "AppInvitesList");
                ((FbUriIntentHandler) this.f14714c.f14726a.get()).a(view.getContext(), (String) b.m15016b().get(0), null, hashMap);
                Logger.a(2, EntryType.UI_INPUT_END, -734045357, a);
            }
        };
    }

    public static void m15103a(AppInvitesViewController appInvitesViewController, View view, final AppInviteFieldsModel appInviteFieldsModel) {
        final Context context = view.getContext();
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(context);
        figPopoverMenuWindow.c().a(1, 0, context.getString(2131241801)).setIcon(2130839815);
        figPopoverMenuWindow.c().a(2, 0, context.getString(2131241805, new Object[]{appInviteFieldsModel.nf_().m15003c()})).setIcon(2130839888);
        figPopoverMenuWindow.c().a(3, 0, context.getString(2131241809, new Object[]{appInviteFieldsModel.m15017c().m14992g()})).setIcon(2130839984);
        figPopoverMenuWindow.c().a(4, 0, context.getString(2131241813)).setIcon(2130839920);
        figPopoverMenuWindow.p = new OnMenuItemClickListener(appInvitesViewController) {
            final /* synthetic */ AppInvitesViewController f14720c;

            /* compiled from: download_postponed */
            class C20571 implements DialogInterface.OnClickListener {
                final /* synthetic */ C20605 f14715a;

                C20571(C20605 c20605) {
                    this.f14715a = c20605;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    AppInvitesGraphqlMutationHelper appInvitesGraphqlMutationHelper = this.f14715a.f14720c.f14730e;
                    String ne_ = appInviteFieldsModel.ne_();
                    ApplicationRequestDeleteInputData applicationRequestDeleteInputData = new ApplicationRequestDeleteInputData();
                    String str = "request_ids";
                    applicationRequestDeleteInputData.a(str, Arrays.asList(new String[]{ne_}));
                    appInvitesGraphqlMutationHelper.f14577a.a(GraphQLRequest.a((AppRequestDeleteCoreMutationString) new AppRequestDeleteCoreMutationString().a("input", applicationRequestDeleteInputData)));
                    this.f14715a.f14720c.f14728c.a(new AppInviteDeletedEvent(appInviteFieldsModel));
                }
            }

            /* compiled from: download_postponed */
            class C20582 implements DialogInterface.OnClickListener {
                final /* synthetic */ C20605 f14716a;

                C20582(C20605 c20605) {
                    this.f14716a = c20605;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f14716a.f14720c.f14730e.m14751b(appInviteFieldsModel.m15017c().m14991d());
                    this.f14716a.f14720c.f14728c.a(new AppInviteApplicationBlockedEvent(appInviteFieldsModel.m15017c().m14991d()));
                }
            }

            /* compiled from: download_postponed */
            class C20593 implements DialogInterface.OnClickListener {
                final /* synthetic */ C20605 f14717a;

                C20593(C20605 c20605) {
                    this.f14717a = c20605;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f14717a.f14720c.f14730e.m14750a(appInviteFieldsModel.nf_().m15002b(), appInviteFieldsModel.m15017c().m14991d());
                    this.f14717a.f14720c.f14728c.a(new AppInviteUserBlockedEvent(appInviteFieldsModel.nf_().m15002b()));
                }
            }

            public final boolean m15098a(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case 1:
                        new Builder(context).a(context.getString(2131241802)).b(context.getString(2131241803, new Object[]{appInviteFieldsModel.m15017c().m14992g()})).a(context.getString(2131241804), new C20571(this)).b(2131230727, null).b();
                        return true;
                    case 2:
                        new Builder(context).a(context.getString(2131241806)).b(context.getString(2131241807, new Object[]{appInviteFieldsModel.nf_().m15003c()})).a(context.getString(2131241808), new C20593(this)).b(2131230727, null).b();
                        return true;
                    case 3:
                        new Builder(context).a(context.getString(2131241810)).b(context.getString(2131241811, new Object[]{appInviteFieldsModel.m15017c().m14992g()})).a(context.getString(2131241812), new C20582(this)).b(2131230727, null).b();
                        return true;
                    case 4:
                        ((FbUriIntentHandler) this.f14720c.f14726a.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.cB, appInviteFieldsModel.ne_(), GraphQLNegativeFeedbackActionType.RESOLVE_PROBLEM, NegativeFeedbackExperienceLocation.APP_INVITES_FEED.stringValueOf()));
                        return true;
                    default:
                        return false;
                }
            }
        };
        figPopoverMenuWindow.f(view);
    }

    private void m15102a(AppInviteView appInviteView) {
        if (!this.f14735j.f14613a) {
            AppInviteCaretNuxInterstitialController appInviteCaretNuxInterstitialController = (AppInviteCaretNuxInterstitialController) this.f14734i.a(new InterstitialTrigger(Action.APP_INVITE_CARET), AppInviteCaretNuxInterstitialController.class);
            View findViewById = appInviteView.findViewById(2131559664);
            if (appInviteCaretNuxInterstitialController != null && findViewById != null) {
                if (findViewById != null) {
                    Tooltip tooltip = new Tooltip(findViewById.getContext(), 2);
                    tooltip.t = -1;
                    tooltip.a(2131241814);
                    tooltip.f(findViewById);
                }
                this.f14734i.a().a(appInviteCaretNuxInterstitialController.b());
            }
        }
    }
}
