package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.ComposerPublishServiceHelper.PublishLogger;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverListView;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverWindow.OnCancelListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.appspecific.AppGlyphResolver;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.service.cache.PrivacyOptionsCache;
import com.facebook.richdocument.BaseRichDocumentActivity;
import com.facebook.richdocument.RichDocumentConstants;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.config.InstantArticlesXConfig;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentBlocksAppendedSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentIncomingAnimationCompleteSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksAppendedEvent;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.ham.HamViewUtils;
import com.facebook.richdocument.logging.RichDocumentAnalyticsLogger;
import com.facebook.richdocument.utils.BookmarkUtils;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.touch.RichDocumentTouch;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;
import com.facebook.saved.common.protocol.UpdateSavedStateUtils;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.text.BetterTextView;
import com.facebook.xconfig.core.XConfigReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: offer_notif_response */
public class ShareBar extends FbRelativeLayout {
    public String f7451A;
    public String f7452B;
    public ImageView f7453C;
    public BetterTextView f7454D;
    private RichDocumentIncomingAnimationCompleteSubscriber f7455E;
    public boolean f7456F = false;
    public OnCloseClickedListener f7457G;
    private int f7458H;
    public int f7459I;
    @Inject
    Lazy<XConfigReader> f7460a;
    @Inject
    Lazy<RichDocumentAnalyticsLogger> f7461b;
    @Inject
    Lazy<PrivacyOptionsCache> f7462c;
    @Inject
    Lazy<MessengerAppUtils> f7463d;
    @Inject
    Lazy<SendAsMessageUtil> f7464e;
    @Inject
    Lazy<Toaster> f7465f;
    @Inject
    Lazy<LoggedInUserAuthDataStore> f7466g;
    @Inject
    Lazy<ComposerPublishServiceHelper> f7467h;
    @Inject
    Lazy<ComposerLauncher> f7468i;
    @Inject
    Lazy<RichDocumentEventBus> f7469j;
    @Inject
    Lazy<FbSharedPreferences> f7470k;
    @Inject
    Lazy<HamViewUtils> f7471l;
    @Inject
    Lazy<HamDimensions> f7472m;
    @Inject
    Lazy<RichDocumentLayoutDirection> f7473n;
    @Inject
    Lazy<RichDocumentInfo> f7474o;
    @Inject
    Lazy<UpdateSavedStateUtils> f7475p;
    @Inject
    Lazy<SecureContextHelper> f7476q;
    @Inject
    Lazy<BlockViewUtil> f7477r;
    int f7478s;
    int f7479t;
    int f7480u;
    float f7481v;
    int f7482w;
    int f7483x;
    int f7484y;
    private List<String> f7485z;

    /* compiled from: offer_notif_response */
    class C08481 extends RichDocumentIncomingAnimationCompleteSubscriber {
        final /* synthetic */ ShareBar f7426a;

        /* compiled from: offer_notif_response */
        class C08462 implements OnClickListener {
            final /* synthetic */ C08481 f7412a;

            C08462(C08481 c08481) {
                this.f7412a = c08481;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1947021347);
                if (this.f7412a.f7426a.f7457G != null) {
                    this.f7412a.f7426a.f7457G.m7651a();
                }
                Logger.a(2, EntryType.UI_INPUT_END, -2065119155, a);
            }
        }

        /* compiled from: offer_notif_response */
        class C08473 implements OnClickListener {
            final /* synthetic */ C08481 f7413a;

            C08473(C08481 c08481) {
                this.f7413a = c08481;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1289878016);
                this.f7413a.f7426a.m7681d("share_button_tapped", null);
                this.f7413a.f7426a.f7457G;
                Logger.a(2, EntryType.UI_INPUT_END, 1491017475, a);
            }
        }

        C08481(ShareBar shareBar) {
            this.f7426a = shareBar;
        }

        public final void m7647b(FbEvent fbEvent) {
            int measuredHeight;
            ((RichDocumentEventBus) this.f7426a.f7469j.get()).a(new CanonicalUrlSubscriber(this.f7426a));
            LayoutInflater.from(this.f7426a.getContext()).inflate(2130904825, this.f7426a);
            this.f7426a.f7453C = (ImageView) this.f7426a.findViewById(2131563023);
            final Drawable mutate = this.f7426a.getResources().getDrawable(2130843047).mutate();
            BlockViewUtil.m6919a(mutate, this.f7426a.getResources().getColor(2131363482));
            final Drawable mutate2 = this.f7426a.getResources().getDrawable(2130843047).mutate();
            BlockViewUtil.m6919a(mutate2, this.f7426a.getResources().getColor(2131363481));
            this.f7426a.f7453C.setImageDrawable(mutate);
            this.f7426a.f7453C.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ C08481 f7410c;
                private final RectF f7411d = new RectF();

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    this.f7411d.set((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
                    if (motionEvent.getAction() == 0) {
                        this.f7410c.f7426a.f7453C.setImageDrawable(mutate2);
                    } else if (motionEvent.getAction() == 2 && !this.f7411d.contains(motionEvent.getRawX(), motionEvent.getRawY())) {
                        this.f7410c.f7426a.f7453C.setImageDrawable(mutate);
                    } else if (motionEvent.getAction() == 1) {
                        this.f7410c.f7426a.f7453C.setImageDrawable(mutate);
                    }
                    return false;
                }
            });
            this.f7426a.f7453C.setOnClickListener(new C08462(this));
            this.f7426a.f7454D = (BetterTextView) this.f7426a.findViewById(2131563024);
            if (this.f7426a.getParent() instanceof InstantArticlesCollapsingHeader) {
                ((HamViewUtils) this.f7426a.f7471l.get()).m5281a(this.f7426a, 2131558700, 0, 2131558700, 0);
                ((HamViewUtils) this.f7426a.f7471l.get()).m5280a(this.f7426a.f7453C, 2131558703, 2131558704);
                this.f7426a.f7454D.setTextSize(0, (float) ((HamDimensions) this.f7426a.f7472m.get()).m5276b(2131558704));
                this.f7426a.f7479t = ((HamDimensions) this.f7426a.f7472m.get()).m5276b(2131558702);
                this.f7426a.f7482w = ((HamDimensions) this.f7426a.f7472m.get()).m5276b(2131558701);
                this.f7426a.measure(MeasureSpec.makeMeasureSpec(this.f7426a.getContext().getResources().getDisplayMetrics().widthPixels, 1073741824), MeasureSpec.makeMeasureSpec(this.f7426a.f7459I, 1073741824));
                this.f7426a.f7478s = (int) this.f7426a.f7454D.getTextSize();
                this.f7426a.f7480u = this.f7426a.f7453C.getMeasuredWidth();
                measuredHeight = this.f7426a.f7453C.getMeasuredHeight();
                this.f7426a.f7481v = ((float) this.f7426a.f7480u) / ((float) measuredHeight);
                this.f7426a.f7484y = ((HamDimensions) this.f7426a.f7472m.get()).m5276b(2131558699);
                this.f7426a.f7483x = ((HamDimensions) this.f7426a.f7472m.get()).m5276b(2131558700);
            } else {
                ((HamViewUtils) this.f7426a.f7471l.get()).m5281a(this.f7426a, 2131558699, 0, 2131558699, 0);
                ((HamViewUtils) this.f7426a.f7471l.get()).m5280a(this.f7426a.f7453C, 2131558701, 2131558702);
                this.f7426a.f7454D.setTextSize(0, (float) ((HamDimensions) this.f7426a.f7472m.get()).m5276b(2131558702));
            }
            this.f7426a.f7454D.setOnClickListener(new C08473(this));
            if (((RichDocumentLayoutDirection) this.f7426a.f7473n.get()).m7370b() && RichDocumentLayoutDirection.m7368c()) {
                this.f7426a.setLayoutDirection(1);
                this.f7426a.setTextDirection(4);
                this.f7426a.f7454D.setTextDirection(4);
                this.f7426a.f7453C.setScaleX(-1.0f);
            }
            measuredHeight = this.f7426a.getResources().getDimensionPixelSize(2131431845);
            int dimensionPixelSize = this.f7426a.getResources().getDimensionPixelSize(2131431846);
            RichDocumentTouch.m7189a(this.f7426a.f7453C, Integer.valueOf(dimensionPixelSize), Integer.valueOf(measuredHeight), Integer.valueOf(3));
            RichDocumentTouch.m7189a(this.f7426a.f7454D, Integer.valueOf(dimensionPixelSize), Integer.valueOf(measuredHeight), Integer.valueOf(3));
            this.f7426a.animate().alpha(1.0f).setDuration((long) RichDocumentUIConfig.f6542M).start();
        }
    }

    /* compiled from: offer_notif_response */
    class CanonicalUrlSubscriber extends RichDocumentBlocksAppendedSubscriber {
        final /* synthetic */ ShareBar f7449a;

        public CanonicalUrlSubscriber(ShareBar shareBar) {
            this.f7449a = shareBar;
        }

        public final void m7649b(FbEvent fbEvent) {
            RichDocumentBlocksAppendedEvent richDocumentBlocksAppendedEvent = (RichDocumentBlocksAppendedEvent) fbEvent;
            this.f7449a.f7451A = richDocumentBlocksAppendedEvent.f5167a.f5669b.getString("url");
        }
    }

    /* compiled from: offer_notif_response */
    class DirectionAwarePopoverMenuWindow extends PopoverMenuWindow {
        final /* synthetic */ ShareBar f7450l;

        public DirectionAwarePopoverMenuWindow(ShareBar shareBar, Context context) {
            this(shareBar, context, (byte) 0);
        }

        private DirectionAwarePopoverMenuWindow(ShareBar shareBar, Context context, byte b) {
            this.f7450l = shareBar;
            super(context, 1);
        }

        protected final PopoverListView m7650b() {
            PopoverListView b = super.b();
            b.setMaxRows((float) ((int) ((((double) getContext().getResources().getDisplayMetrics().heightPixels) * 0.8d) / ((double) this.f7450l.getResources().getDimensionPixelSize(2131428375)))));
            b.setVerticalScrollBarEnabled(true);
            b.setScrollbarFadingEnabled(false);
            if (RichDocumentLayoutDirection.m7368c()) {
                if (((RichDocumentLayoutDirection) this.f7450l.f7473n.get()).m7370b()) {
                    b.setLayoutDirection(1);
                } else {
                    b.setLayoutDirection(0);
                }
            }
            return b;
        }
    }

    /* compiled from: offer_notif_response */
    public interface OnCloseClickedListener {
        void m7651a();
    }

    private static <T extends View> void m7662a(Class<T> cls, T t) {
        m7663a((Object) t, t.getContext());
    }

    private static void m7663a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ShareBar) obj).m7658a(IdBasedSingletonScopeProvider.b(fbInjector, 3749), IdBasedLazy.a(fbInjector, 10334), IdBasedSingletonScopeProvider.b(fbInjector, 3117), IdBasedSingletonScopeProvider.b(fbInjector, 2747), IdBasedSingletonScopeProvider.b(fbInjector, 8437), IdBasedLazy.a(fbInjector, 3588), IdBasedSingletonScopeProvider.b(fbInjector, 339), IdBasedLazy.a(fbInjector, 5272), IdBasedSingletonScopeProvider.b(fbInjector, 849), IdBasedLazy.a(fbInjector, 10298), IdBasedSingletonScopeProvider.b(fbInjector, 3078), IdBasedLazy.a(fbInjector, 10330), IdBasedLazy.a(fbInjector, 10329), IdBasedLazy.a(fbInjector, 10359), IdBasedLazy.a(fbInjector, 10295), IdBasedSingletonScopeProvider.b(fbInjector, 10402), IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedLazy.a(fbInjector, 10351));
    }

    private void m7677c(String str, String str2) {
        List<String> a = StringUtil.a(str, ',');
        StringBuilder stringBuilder = new StringBuilder();
        for (String str3 : a) {
            if (!str3.equals(str2)) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(str3);
            }
        }
        ((FbSharedPreferences) this.f7470k.get()).edit().a(RichDocumentConstants.f5037a, stringBuilder.toString()).commit();
    }

    public ShareBar(Context context) {
        super(context);
        m7656a();
    }

    public ShareBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7656a();
    }

    public ShareBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7656a();
    }

    public void setWasCalledBySampleApp(boolean z) {
        this.f7456F = z;
    }

    private void m7656a() {
        m7662a(ShareBar.class, (View) this);
        setClickable(true);
        setAlpha(0.0f);
        this.f7458H = getResources().getDimensionPixelSize(2131431840);
        this.f7459I = getResources().getDimensionPixelSize(2131431841);
        this.f7455E = new C08481(this);
        ((RichDocumentEventBus) this.f7469j.get()).a(this.f7455E);
    }

    private void m7658a(Lazy<XConfigReader> lazy, Lazy<RichDocumentAnalyticsLogger> lazy2, Lazy<PrivacyOptionsCache> lazy3, Lazy<MessengerAppUtils> lazy4, Lazy<SendAsMessageUtil> lazy5, Lazy<Toaster> lazy6, Lazy<LoggedInUserAuthDataStore> lazy7, Lazy<ComposerPublishServiceHelper> lazy8, Lazy<ComposerLauncher> lazy9, Lazy<RichDocumentEventBus> lazy10, Lazy<FbSharedPreferences> lazy11, Lazy<HamViewUtils> lazy12, Lazy<HamDimensions> lazy13, Lazy<RichDocumentLayoutDirection> lazy14, Lazy<RichDocumentInfo> lazy15, Lazy<UpdateSavedStateUtils> lazy16, Lazy<SecureContextHelper> lazy17, Lazy<BlockViewUtil> lazy18) {
        this.f7460a = lazy;
        this.f7461b = lazy2;
        this.f7462c = lazy3;
        this.f7463d = lazy4;
        this.f7464e = lazy5;
        this.f7465f = lazy6;
        this.f7466g = lazy7;
        this.f7467h = lazy8;
        this.f7468i = lazy9;
        this.f7469j = lazy10;
        this.f7470k = lazy11;
        this.f7471l = lazy12;
        this.f7472m = lazy13;
        this.f7473n = lazy14;
        this.f7474o = lazy15;
        this.f7475p = lazy16;
        this.f7476q = lazy17;
        this.f7477r = lazy18;
    }

    public void setOnCloseClickedListener(OnCloseClickedListener onCloseClickedListener) {
        this.f7457G = onCloseClickedListener;
    }

    public void setCanonicalUrl(String str) {
        this.f7451A = str;
    }

    public void setShareUrl(String str) {
        this.f7452B = str;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        throw new UnsupportedOperationException("setOnClickListener not allowed");
    }

    private void m7657a(PopoverMenu popoverMenu, final String str) {
        final GraphQLPrivacyOption a = ((PrivacyOptionsCache) this.f7462c.get()).a();
        if (a != null) {
            GraphQLPrivacyOptionType a2 = PrivacyOptionHelper.a(a);
            if (a2 == GraphQLPrivacyOptionType.EVERYONE || a2 == GraphQLPrivacyOptionType.FRIENDS) {
                MenuItemImpl a3 = popoverMenu.a(2131232714);
                a3.setIcon(2130840082);
                a3.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ ShareBar f7429c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f7429c.m7665a(str, a);
                        return true;
                    }
                });
                if (a2 == GraphQLPrivacyOptionType.EVERYONE) {
                    a3.a(2131232715);
                    m7681d("quick_share_public", str);
                } else if (a2 == GraphQLPrivacyOptionType.FRIENDS) {
                    a3.a(2131232716);
                    m7681d("quick_share_friends", str);
                }
            }
        }
    }

    private void m7670b(PopoverMenu popoverMenu, final String str) {
        if ((getContext() instanceof BaseRichDocumentActivity) && this.f7456F) {
            final String stringExtra = ((BaseRichDocumentActivity) getContext()).getIntent().getStringExtra("extra_instant_articles_id");
            final String a = ((FbSharedPreferences) this.f7470k.get()).a(RichDocumentConstants.f5037a, "");
            if (BookmarkUtils.m6849c(a, stringExtra)) {
                popoverMenu.a(2131237724).setIcon(2130840123).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ ShareBar f7433d;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f7433d.m7666a("menu_item_remove_bookmark", str);
                        this.f7433d.m7677c(a, stringExtra);
                        return true;
                    }
                });
            } else {
                popoverMenu.a(2131237723).setIcon(2130840122).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ ShareBar f7437d;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f7437d.m7666a("menu_item_add_bookmark", str);
                        this.f7437d.m7673b(a, stringExtra);
                        return true;
                    }
                });
            }
        }
    }

    private String getUrlToUse() {
        return StringUtil.c(this.f7452B) ? this.f7451A : this.f7452B;
    }

    public static void m7671b(ShareBar shareBar) {
        if (shareBar.f7485z == null || shareBar.f7485z.isEmpty()) {
            shareBar.f7485z = StringUtil.a(((XConfigReader) shareBar.f7460a.get()).a(InstantArticlesXConfig.c, ""), ',');
        }
        final Object urlToUse = shareBar.getUrlToUse();
        if (!StringUtil.a(urlToUse)) {
            final String uuid = SafeUUIDGenerator.a().toString();
            DirectionAwarePopoverMenuWindow directionAwarePopoverMenuWindow = new DirectionAwarePopoverMenuWindow(shareBar, shareBar.getContext());
            directionAwarePopoverMenuWindow.c(shareBar.f7454D);
            directionAwarePopoverMenuWindow.a(true);
            directionAwarePopoverMenuWindow.a(Position.BELOW);
            directionAwarePopoverMenuWindow.I = new OnCancelListener(shareBar) {
                final /* synthetic */ ShareBar f7439b;

                public final boolean m7648a() {
                    this.f7439b.m7681d("share_menu_dismissed", uuid);
                    return false;
                }
            };
            PopoverMenu c = directionAwarePopoverMenuWindow.c();
            shareBar.m7657a(c, uuid);
            c.a(2131233506).setIcon(2130839809).setOnMenuItemClickListener(new OnMenuItemClickListener(shareBar) {
                final /* synthetic */ ShareBar f7442c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f7442c.m7681d("edit_and_share_tapped", uuid);
                    ((BlockViewUtil) this.f7442c.f7477r.get()).m6923a(this.f7442c.getContext(), (ComposerLauncher) this.f7442c.f7468i.get(), uuid, urlToUse, ((RichDocumentInfo) this.f7442c.f7474o.get()).m5104b(), 1002);
                    return true;
                }
            });
            if (((MessengerAppUtils) shareBar.f7463d.get()).a() && ((MessengerAppUtils) shareBar.f7463d.get()).d()) {
                c.a(2131233507).setIcon(AppGlyphResolver.a()).setOnMenuItemClickListener(new OnMenuItemClickListener(shareBar) {
                    final /* synthetic */ ShareBar f7444b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f7444b.m7681d("send_in_message", uuid);
                        this.f7444b.m7686g();
                        return true;
                    }
                });
            }
            c.a(2131236846).setIcon(2130837858).setOnMenuItemClickListener(new OnMenuItemClickListener(shareBar) {
                final /* synthetic */ ShareBar f7446b;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f7446b.m7681d("share_copied_link", uuid);
                    this.f7446b.m7688h();
                    return true;
                }
            });
            if (((RichDocumentInfo) shareBar.f7474o.get()).f5117e) {
                c.a(2131236851).setIcon(2130837870).setOnMenuItemClickListener(new OnMenuItemClickListener(shareBar) {
                    final /* synthetic */ ShareBar f7448b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f7448b.m7681d("unsave_link", uuid);
                        this.f7448b.m7684f();
                        return true;
                    }
                });
            } else {
                c.a(2131236850).setIcon(2130837870).setOnMenuItemClickListener(new OnMenuItemClickListener(shareBar) {
                    final /* synthetic */ ShareBar f7415b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f7415b.m7681d("share_saved_link", uuid);
                        this.f7415b.m7682e();
                        return true;
                    }
                });
            }
            if (!StringUtil.c(shareBar.f7452B)) {
                c.a(2131237731).setIcon(2130837867).setOnMenuItemClickListener(new OnMenuItemClickListener(shareBar) {
                    final /* synthetic */ ShareBar f7417b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f7417b.m7681d("share_open_browser", uuid);
                        this.f7417b.f7454D;
                        return true;
                    }
                });
            }
            if (!StringUtil.c(shareBar.f7452B)) {
                c.a(2131237732).setIcon(2130839845).setOnMenuItemClickListener(new OnMenuItemClickListener(shareBar) {
                    final /* synthetic */ ShareBar f7419b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f7419b.m7681d("share_in_email", uuid);
                        this.f7419b.f7459I;
                        return true;
                    }
                });
            }
            shareBar.m7670b(c, uuid);
            if (!(shareBar.f7485z == null || StringUtil.a(urlToUse))) {
                PackageManager packageManager = shareBar.getContext().getPackageManager();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", urlToUse);
                for (final String str : shareBar.f7485z) {
                    intent.setPackage(str);
                    List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                    if (!(queryIntentActivities == null || queryIntentActivities.isEmpty())) {
                        ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(0);
                        c.a(resolveInfo.activityInfo.applicationInfo.loadLabel(packageManager)).setIcon(resolveInfo.activityInfo.applicationInfo.loadIcon(packageManager)).setOnMenuItemClickListener(new OnMenuItemClickListener(shareBar) {
                            final /* synthetic */ ShareBar f7422c;

                            public boolean onMenuItemClick(MenuItem menuItem) {
                                this.f7422c.m7664a(str);
                                if (str.contains("twitter")) {
                                    this.f7422c.m7681d("share_to_twitter", uuid);
                                } else if (str.contains("pinterest")) {
                                    this.f7422c.m7681d("share_to_pinterest", uuid);
                                }
                                return true;
                            }
                        });
                    }
                }
            }
            c.a(null);
            directionAwarePopoverMenuWindow.d();
        }
    }

    private void m7666a(String str, String str2) {
        m7667a(str, str2, null);
    }

    private void m7667a(String str, String str2, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap();
        }
        map.put("session_id", str2);
        ((RichDocumentAnalyticsLogger) this.f7461b.get()).m5371c(str, map);
    }

    public static void m7675c(ShareBar shareBar) {
        if (!StringUtil.c(shareBar.f7452B)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(shareBar.f7452B));
            ((SecureContextHelper) shareBar.f7476q.get()).b(intent, shareBar.getContext());
        }
    }

    public static void m7679d(ShareBar shareBar) {
        if (!StringUtil.c(shareBar.f7452B)) {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", shareBar.f7452B);
            intent.setData(Uri.parse("mailto:"));
            ((SecureContextHelper) shareBar.f7476q.get()).b(Intent.createChooser(intent, null), shareBar.getContext());
        }
    }

    private void m7665a(String str, GraphQLPrivacyOption graphQLPrivacyOption) {
        long parseLong = Long.parseLong(((LoggedInUserSessionManager) this.f7466g.get()).c().a);
        Builder builder = new Builder();
        builder.b = parseLong;
        builder = builder;
        builder.j = parseLong;
        Builder builder2 = builder;
        builder2.i = getUrlToUse();
        builder2 = builder2;
        builder2.g = graphQLPrivacyOption.c();
        builder2 = builder2;
        builder2.G = str;
        builder2 = builder2;
        builder2.p = ComposerType.SHARE;
        Builder builder3 = builder2;
        builder3.l = ((RichDocumentInfo) this.f7474o.get()).m5104b();
        PublishPostParams a = builder3.a();
        Intent intent = new Intent();
        intent.putExtra("publishPostParams", a);
        ((ComposerPublishServiceHelper) this.f7467h.get()).a(intent, new PublishLogger(this) {
            final /* synthetic */ ShareBar f7423a;

            {
                this.f7423a = r1;
            }

            public final void m7639a(PublishPostParams publishPostParams) {
            }

            public final void m7642b(PublishPostParams publishPostParams) {
            }

            public final void m7640a(String str, PublishPostParams publishPostParams) {
                Map hashMap = new HashMap();
                hashMap.put("block_media_type", "article");
                hashMap.put("ia_source", "share_button");
                ((RichDocumentAnalyticsLogger) this.f7423a.f7461b.get()).m5363a(-1, "feed_share_action", hashMap);
            }

            public final void m7641a(String str, PublishPostParams publishPostParams, ServiceException serviceException) {
                Map hashMap = new HashMap();
                hashMap.put("error_code", serviceException.errorCode.toString());
                hashMap.put("block_media_type", "article");
                hashMap.put("ia_source", "share_button");
                hashMap.put("share_type", "share_failed");
                ((RichDocumentAnalyticsLogger) this.f7423a.f7461b.get()).m5371c("feed_share_action", hashMap);
            }
        });
        ((Toaster) this.f7465f.get()).b(new ToastBuilder(2131234541));
    }

    private void m7682e() {
        ((UpdateSavedStateUtils) this.f7475p.get()).e(getUrlToUse(), CurationSurface.NATIVE_WEB_VIEW, CurationMechanism.SAVED_ADD, new OperationResultFutureCallback(this) {
            final /* synthetic */ ShareBar f7424a;

            {
                this.f7424a = r1;
            }

            protected final void m7643a(ServiceException serviceException) {
                ((Toaster) this.f7424a.f7465f.get()).b(new ToastBuilder(2131236856));
                ((RichDocumentInfo) this.f7424a.f7474o.get()).f5117e = false;
            }

            protected final void m7644a(Object obj) {
                ((Toaster) this.f7424a.f7465f.get()).b(new ToastBuilder(2131236854));
                ((RichDocumentInfo) this.f7424a.f7474o.get()).f5117e = true;
            }
        });
    }

    private void m7684f() {
        ((UpdateSavedStateUtils) this.f7475p.get()).f(getUrlToUse(), CurationSurface.NATIVE_WEB_VIEW, CurationMechanism.SAVED_ADD, new OperationResultFutureCallback(this) {
            final /* synthetic */ ShareBar f7425a;

            {
                this.f7425a = r1;
            }

            protected final void m7645a(ServiceException serviceException) {
                ((Toaster) this.f7425a.f7465f.get()).b(new ToastBuilder(2131236857));
                ((RichDocumentInfo) this.f7425a.f7474o.get()).f5117e = true;
            }

            protected final void m7646a(Object obj) {
                ((Toaster) this.f7425a.f7465f.get()).b(new ToastBuilder(2131236855));
                ((RichDocumentInfo) this.f7425a.f7474o.get()).f5117e = false;
            }
        });
    }

    private void m7686g() {
        ((SendAsMessageUtil) this.f7464e.get()).a(getContext(), getUrlToUse(), true, true, "browser");
    }

    private void m7688h() {
        ClipboardUtil.a(getContext(), getUrlToUse());
        ((Toaster) this.f7465f.get()).b(new ToastBuilder(2131236853));
    }

    private void m7673b(String str, String str2) {
        ((FbSharedPreferences) this.f7470k.get()).edit().a(RichDocumentConstants.f5037a, BookmarkUtils.m6848a(str, str2)).commit();
    }

    private void m7664a(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setPackage(str);
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", getUrlToUse());
        getContext().startActivity(intent);
    }

    public final void m7693a(int i) {
        if (this.f7454D != null && this.f7453C != null) {
            float f = 1.0f - (((float) (i - this.f7458H)) / ((float) (this.f7459I - this.f7458H)));
            float a = m7652a((float) this.f7478s, (float) this.f7479t, f);
            float a2 = m7652a((float) this.f7480u, (float) this.f7482w, f);
            f = m7652a((float) this.f7483x, (float) this.f7484y, f);
            this.f7454D.setTextSize(0, a);
            int round = Math.round(a2);
            int round2 = Math.round(((float) round) / this.f7481v);
            LayoutParams layoutParams = this.f7453C.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = round;
                layoutParams.height = round2;
            }
            this.f7453C.setLayoutParams(layoutParams);
            setPadding((int) f, 0, (int) f, 0);
        }
    }

    private static float m7652a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    private void m7681d(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("block_media_type", "article");
        hashMap.put("ia_source", "share_button");
        hashMap.put("share_type", str);
        m7667a("feed_share_action", str2, hashMap);
    }
}
