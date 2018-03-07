package com.facebook.notifications.settings;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.fig.listitem.FigListItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FigListItemContentDescriptionPartDefinition;
import com.facebook.multirow.parts.FigListItemMetaTextPartDefinition;
import com.facebook.multirow.parts.FigListItemThumbnailUriPartDefinition;
import com.facebook.multirow.parts.FigListItemTitlePartDefinition;
import com.facebook.multirow.parts.FigListItemTitlePartDefinition.Props;
import com.facebook.notifications.action.NotificationsActionExecutor;
import com.facebook.notifications.logging.NotificationSettingsLogger.Surface;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotifOptionFragmentModel.OptionDisplayModel;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: minutiae_verb_picker_time_to_init */
public class NotificationSettingsPartDefinition<E extends HasContext> extends MultiRowSinglePartDefinition<NotifOptionNode, String, E, FigListItem> {
    public static final ViewType f8739a = new C07041();
    private static NotificationSettingsPartDefinition f8740h;
    private static final Object f8741i = new Object();
    private final ClickListenerPartDefinition f8742b;
    private final FigListItemContentDescriptionPartDefinition f8743c;
    private final FigListItemMetaTextPartDefinition f8744d;
    public final NotificationsActionExecutor f8745e;
    private final FigListItemThumbnailUriPartDefinition f8746f;
    private final FigListItemTitlePartDefinition f8747g;

    /* compiled from: minutiae_verb_picker_time_to_init */
    final class C07041 extends ViewType {
        C07041() {
        }

        public final View m10706a(Context context) {
            return new FigListItem(context);
        }
    }

    private static NotificationSettingsPartDefinition m10709b(InjectorLike injectorLike) {
        return new NotificationSettingsPartDefinition(ClickListenerPartDefinition.a(injectorLike), FigListItemContentDescriptionPartDefinition.m9540a(injectorLike), FigListItemMetaTextPartDefinition.m9543a(injectorLike), NotificationsActionExecutor.a(injectorLike), FigListItemThumbnailUriPartDefinition.m9546a(injectorLike), FigListItemTitlePartDefinition.m9549a(injectorLike));
    }

    public final Object m10711a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final NotifOptionNode notifOptionNode = (NotifOptionNode) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        OptionDisplayModel d = notifOptionNode.f8709a.mo462d();
        Object a = d.m10463j().a();
        String a2 = d.m10462g() == null ? null : d.m10462g().a();
        String a3 = d.gw_() == null ? null : m10708a(d.gw_().a());
        String a4 = d.m10461d() == null ? null : d.m10461d().m10448a();
        subParts.a(this.f8747g, new Props(a, null));
        if (!Strings.isNullOrEmpty(a2)) {
            subParts.a(this.f8744d, new FigListItemMetaTextPartDefinition.Props(a2, null));
        }
        if (!Strings.isNullOrEmpty(a4)) {
            subParts.a(this.f8746f, Uri.parse(a4));
        }
        FigListItemContentDescriptionPartDefinition figListItemContentDescriptionPartDefinition = this.f8743c;
        StringBuilder stringBuilder = new StringBuilder(a);
        if (!Strings.isNullOrEmpty(a2)) {
            stringBuilder.append(" " + a2);
        }
        if (!Strings.isNullOrEmpty(a3)) {
            stringBuilder.append(" " + a3);
        }
        subParts.a(figListItemContentDescriptionPartDefinition, stringBuilder.toString());
        subParts.a(this.f8742b, new OnClickListener(this) {
            final /* synthetic */ NotificationSettingsPartDefinition f8738c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1898834932);
                this.f8738c.f8745e.a(hasContext.getContext(), notifOptionNode.f8709a, Surface.ENTITY_ROW);
                Logger.a(2, EntryType.UI_INPUT_END, 530179015, a);
            }
        });
        return a3;
    }

    public final /* bridge */ /* synthetic */ void m10712a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1991100386);
        String str = (String) obj2;
        FigListItem figListItem = (FigListItem) view;
        figListItem.setThumbnailSizeType(5);
        figListItem.setThumbnailGravity(17);
        figListItem.setActionType(5);
        figListItem.setActionText(str);
        Logger.a(8, EntryType.MARK_POP, 1389050423, a);
    }

    public final boolean m10713a(Object obj) {
        NotifOptionNode notifOptionNode = (NotifOptionNode) obj;
        return (notifOptionNode.f8709a.mo462d() == null || notifOptionNode.f8709a.mo462d().m10463j() == null || Strings.isNullOrEmpty(notifOptionNode.f8709a.mo462d().m10463j().a()) || notifOptionNode.f8709a.mo460b() == null || notifOptionNode.f8709a.mo460b().mo456b() == null) ? false : true;
    }

    public static NotificationSettingsPartDefinition m10707a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationSettingsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8741i) {
                NotificationSettingsPartDefinition notificationSettingsPartDefinition;
                if (a2 != null) {
                    notificationSettingsPartDefinition = (NotificationSettingsPartDefinition) a2.a(f8741i);
                } else {
                    notificationSettingsPartDefinition = f8740h;
                }
                if (notificationSettingsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10709b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8741i, b3);
                        } else {
                            f8740h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationSettingsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public NotificationSettingsPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, FigListItemContentDescriptionPartDefinition figListItemContentDescriptionPartDefinition, FigListItemMetaTextPartDefinition figListItemMetaTextPartDefinition, NotificationsActionExecutor notificationsActionExecutor, FigListItemThumbnailUriPartDefinition figListItemThumbnailUriPartDefinition, FigListItemTitlePartDefinition figListItemTitlePartDefinition) {
        this.f8742b = clickListenerPartDefinition;
        this.f8743c = figListItemContentDescriptionPartDefinition;
        this.f8744d = figListItemMetaTextPartDefinition;
        this.f8745e = notificationsActionExecutor;
        this.f8746f = figListItemThumbnailUriPartDefinition;
        this.f8747g = figListItemTitlePartDefinition;
    }

    public final ViewType m10710a() {
        return f8739a;
    }

    @Nullable
    private static String m10708a(@Nullable String str) {
        if (Strings.isNullOrEmpty(str) || str.length() <= 8) {
            return str;
        }
        return str.substring(0, 8) + '…';
    }
}
