package com.facebook.notifications.settings.partdefinitions;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
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
import com.facebook.multirow.parts.ContentViewContentDescriptionPartDefinition;
import com.facebook.multirow.parts.ContentViewSubtitlePartDefinition;
import com.facebook.multirow.parts.ContentViewThumbnailUriStringPartDefinition;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.notifications.action.NotificationsActionExecutor;
import com.facebook.notifications.logging.NotificationSettingsLogger.Surface;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotifOptionFragmentModel.OptionDisplayModel;
import com.facebook.notifications.settings.partdefinitions.NotificationSettingsRemovableGroupPartDefinition.Props;
import com.facebook.notifications.settings.persistentstate.NotificationSettingsRemovableRowPersistentState;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: minutiae_tag_picker */
public class NotificationSettingsTextWithButtonPartDefinition<E extends HasContext & HasPersistentState & HasInvalidate> extends MultiRowSinglePartDefinition<Props, State, E, ContentViewWithButton> {
    public static final ViewType f8810a = ViewType.a(2130905483);
    private static NotificationSettingsTextWithButtonPartDefinition f8811g;
    private static final Object f8812h = new Object();
    private final ContentViewContentDescriptionPartDefinition f8813b;
    public final NotificationsActionExecutor f8814c;
    private final ContentViewSubtitlePartDefinition f8815d;
    private final ContentViewThumbnailUriStringPartDefinition f8816e;
    private final ContentViewTitlePartDefinition f8817f;

    /* compiled from: minutiae_tag_picker */
    public class State {
        public final OnClickListener f8808a;
        @Nullable
        public final String f8809b;

        public State(OnClickListener onClickListener, @Nullable String str) {
            this.f8808a = onClickListener;
            this.f8809b = str;
        }
    }

    private static NotificationSettingsTextWithButtonPartDefinition m10745b(InjectorLike injectorLike) {
        return new NotificationSettingsTextWithButtonPartDefinition(ContentViewContentDescriptionPartDefinition.m9506a(injectorLike), NotificationsActionExecutor.a(injectorLike), ContentViewSubtitlePartDefinition.m9512a(injectorLike), ContentViewThumbnailUriStringPartDefinition.m9518a(injectorLike), ContentViewTitlePartDefinition.m9521a(injectorLike));
    }

    public final Object m10747a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        String str = null;
        OptionDisplayModel d = props.f8777a.f8709a.mo462d();
        String a = d.m10463j().a();
        String a2 = d.m10462g() == null ? null : d.m10462g().a();
        if (d.gw_() != null) {
            str = d.gw_().a();
        }
        subParts.a(this.f8817f, a);
        if (a2 != null) {
            subParts.a(this.f8815d, a2);
        }
        if (d.m10461d() != null) {
            subParts.a(this.f8816e, d.m10461d().m10448a());
        }
        ContentViewContentDescriptionPartDefinition contentViewContentDescriptionPartDefinition = this.f8813b;
        StringBuilder stringBuilder = new StringBuilder(a);
        if (!Strings.isNullOrEmpty(a2)) {
            stringBuilder.append(" " + a2);
        }
        if (!Strings.isNullOrEmpty(str)) {
            stringBuilder.append(" " + str);
        }
        subParts.a(contentViewContentDescriptionPartDefinition, stringBuilder.toString());
        return new State(new OnClickListener(this) {
            final /* synthetic */ NotificationSettingsTextWithButtonPartDefinition f8807c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1561790631);
                this.f8807c.f8814c.a(hasContext.getContext(), props.f8777a.f8709a, Surface.ENTITY_ROW);
                NotificationSettingsRemovableRowPersistentState notificationSettingsRemovableRowPersistentState = props.f8778b;
                notificationSettingsRemovableRowPersistentState.f8848a.add(props.f8777a.f8709a.mo461c());
                ((HasInvalidate) hasContext).a(new FeedProps[]{FeedProps.c(props.f8777a)});
                Logger.a(2, EntryType.UI_INPUT_END, -160400465, a);
            }
        }, str);
    }

    public final /* bridge */ /* synthetic */ void m10748a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 168669744);
        State state = (State) obj2;
        ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
        contentViewWithButton.setActionButtonText(state.f8809b);
        contentViewWithButton.setActionButtonOnClickListener(state.f8808a);
        Logger.a(8, EntryType.MARK_POP, 619862280, a);
    }

    public final boolean m10749a(Object obj) {
        Props props = (Props) obj;
        return (props.f8777a.f8709a.mo462d() == null || props.f8777a.f8709a.mo462d().m10463j() == null || Strings.isNullOrEmpty(props.f8777a.f8709a.mo462d().m10463j().a()) || props.f8777a.f8709a.mo460b() == null || props.f8777a.f8709a.mo460b().mo456b() == null) ? false : true;
    }

    public final void m10750b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ContentViewWithButton) view).setActionButtonOnClickListener(null);
    }

    public static NotificationSettingsTextWithButtonPartDefinition m10744a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationSettingsTextWithButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8812h) {
                NotificationSettingsTextWithButtonPartDefinition notificationSettingsTextWithButtonPartDefinition;
                if (a2 != null) {
                    notificationSettingsTextWithButtonPartDefinition = (NotificationSettingsTextWithButtonPartDefinition) a2.a(f8812h);
                } else {
                    notificationSettingsTextWithButtonPartDefinition = f8811g;
                }
                if (notificationSettingsTextWithButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10745b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8812h, b3);
                        } else {
                            f8811g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationSettingsTextWithButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public NotificationSettingsTextWithButtonPartDefinition(ContentViewContentDescriptionPartDefinition contentViewContentDescriptionPartDefinition, NotificationsActionExecutor notificationsActionExecutor, ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition, ContentViewThumbnailUriStringPartDefinition contentViewThumbnailUriStringPartDefinition, ContentViewTitlePartDefinition contentViewTitlePartDefinition) {
        this.f8813b = contentViewContentDescriptionPartDefinition;
        this.f8814c = notificationsActionExecutor;
        this.f8815d = contentViewSubtitlePartDefinition;
        this.f8817f = contentViewTitlePartDefinition;
        this.f8816e = contentViewThumbnailUriStringPartDefinition;
    }

    public final ViewType m10746a() {
        return f8810a;
    }
}
