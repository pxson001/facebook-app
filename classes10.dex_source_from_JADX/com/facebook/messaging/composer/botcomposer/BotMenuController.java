package com.facebook.messaging.composer.botcomposer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v7.internal.widget.ViewStubCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction.Type;
import com.facebook.messaging.composer.botcomposer.BotMenuContentAdapter.MenuItemDataWrapper;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: theme_photo_id */
public class BotMenuController {
    private static final Class<?> f1732a = BotMenuController.class;
    public final Context f1733b;
    private final ViewStubHolder<View> f1734c;
    private final BotMenuContentAdapterProvider f1735d;
    public final BotComposerAnalyticsLogger f1736e;
    public BottomSheetDialog f1737f;
    public List<BotMenuItem> f1738g;
    public BotMenuContentAdapter f1739h;
    public String f1740i;

    /* compiled from: theme_photo_id */
    class C02791 implements OnClickListener {
        final /* synthetic */ BotMenuController f1727a;

        C02791(BotMenuController botMenuController) {
            this.f1727a = botMenuController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 243644615);
            BotMenuController.m1718a(this.f1727a);
            Logger.a(2, EntryType.UI_INPUT_END, -672543283, a);
        }
    }

    /* compiled from: theme_photo_id */
    class C02813 implements OnDismissListener {
        final /* synthetic */ BotMenuController f1730a;

        C02813(BotMenuController botMenuController) {
            this.f1730a = botMenuController;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f1730a.f1737f.hide();
            this.f1730a.f1737f = null;
        }
    }

    /* compiled from: theme_photo_id */
    public class C02824 {
        public final /* synthetic */ BotMenuController f1731a;

        public C02824(BotMenuController botMenuController) {
            this.f1731a = botMenuController;
        }
    }

    @Inject
    public BotMenuController(BotMenuContentAdapterProvider botMenuContentAdapterProvider, BotComposerAnalyticsLogger botComposerAnalyticsLogger, @Assisted Context context, @Assisted ViewStubCompat viewStubCompat) {
        this.f1735d = botMenuContentAdapterProvider;
        this.f1736e = botComposerAnalyticsLogger;
        this.f1733b = context;
        this.f1734c = ViewStubHolder.a(viewStubCompat);
        final OnClickListener c02791 = new C02791(this);
        this.f1734c.c = new OnInflateListener<View>(this) {
            final /* synthetic */ BotMenuController f1729b;

            public final void m1717a(View view) {
                view.setOnClickListener(c02791);
            }
        };
    }

    public static void m1718a(BotMenuController botMenuController) {
        if (botMenuController.f1737f == null) {
            if (botMenuController.f1738g == null) {
                botMenuController.f1738g = ImmutableList.of(new BotMenuItem("1", "Option 1", Type.POSTBACK), new BotMenuItem("2", "Option 2", Type.POSTBACK), new BotMenuItem("3", "Option 3", Type.POSTBACK));
            }
            if (botMenuController.f1739h == null) {
                botMenuController.f1739h = new BotMenuContentAdapter(botMenuController.f1733b);
                botMenuController.f1739h.f1726c = new C02824(botMenuController);
                BotMenuContentAdapter botMenuContentAdapter = botMenuController.f1739h;
                List<BotMenuItem> list = botMenuController.f1738g;
                botMenuContentAdapter.clear();
                for (BotMenuItem menuItemDataWrapper : list) {
                    botMenuContentAdapter.b(new MenuItemDataWrapper(botMenuContentAdapter, menuItemDataWrapper));
                }
            }
            botMenuController.f1737f = new BottomSheetDialog(botMenuController.f1733b);
            botMenuController.f1737f.a(botMenuController.f1739h);
            botMenuController.f1737f.c();
            botMenuController.f1737f.setOnDismissListener(new C02813(botMenuController));
            botMenuController.f1737f.show();
            botMenuController.f1736e.m1703b(botMenuController.f1740i, botMenuController.f1739h.size());
        }
    }
}
