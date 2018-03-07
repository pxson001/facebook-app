package com.facebook.notifications.settings.partdefinitions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ContentViewSubtitlePartDefinition;
import com.facebook.multirow.parts.ContentViewThumbnailUriStringPartDefinition;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.notifications.action.NotificationsActionExecutor;
import com.facebook.notifications.logging.NotificationSettingsLogger.Surface;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotifOptionFragmentModel.OptionDisplayModel;
import com.facebook.notifications.settings.NotifOptionNode;
import com.facebook.notifications.settings.partdefinitions.NotificationSettingsSelectorGroupPartDefinition.Props;
import com.facebook.notifications.settings.persistentstate.NotificationSettingsMultiSelectorPersistentState;
import com.facebook.notifications.settings.persistentstate.NotificationSettingsSingleSelectorPersistentState;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: minutiae_taggable_activity_fetch_fail */
public class NotificationSettingsSelectorPartDefinition<E extends HasPersistentState & HasInvalidate & HasContext> extends MultiRowSinglePartDefinition<Props, Void, E, CheckedContentView> {
    public static final ViewType<CheckedContentView> f8796a = ViewType.a(2130905482);
    private static NotificationSettingsSelectorPartDefinition f8797h;
    private static final Object f8798i = new Object();
    public final NotificationsActionExecutor f8799b;
    private final ClickListenerPartDefinition f8800c;
    public final GlyphColorizer f8801d;
    private final ContentViewSubtitlePartDefinition f8802e;
    private final ContentViewThumbnailUriStringPartDefinition f8803f;
    private final ContentViewTitlePartDefinition f8804g;

    private static NotificationSettingsSelectorPartDefinition m10739b(InjectorLike injectorLike) {
        return new NotificationSettingsSelectorPartDefinition(NotificationsActionExecutor.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), GlyphColorizer.a(injectorLike), ContentViewSubtitlePartDefinition.m9512a(injectorLike), ContentViewThumbnailUriStringPartDefinition.m9518a(injectorLike), ContentViewTitlePartDefinition.m9521a(injectorLike));
    }

    public final Object m10741a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        final HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        OptionDisplayModel d = props.f8782a.f8709a.mo462d();
        subParts.a(this.f8804g, d.m10463j().a());
        if (d.m10462g() != null) {
            subParts.a(this.f8802e, d.m10462g().a());
        }
        if (d.m10461d() != null) {
            subParts.a(this.f8803f, d.m10461d().m10448a());
        }
        ClickListenerPartDefinition clickListenerPartDefinition;
        final NotifOptionNode notifOptionNode;
        if (props.f8783b) {
            final NotificationSettingsSingleSelectorPersistentState notificationSettingsSingleSelectorPersistentState = (NotificationSettingsSingleSelectorPersistentState) props.f8784c;
            clickListenerPartDefinition = this.f8800c;
            notifOptionNode = props.f8782a;
            subParts.a(clickListenerPartDefinition, new OnClickListener(this) {
                final /* synthetic */ NotificationSettingsSelectorPartDefinition f8791d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -568596027);
                    String c = notifOptionNode.f8709a.mo461c();
                    if (c.equals(notificationSettingsSingleSelectorPersistentState.f8851a)) {
                        Logger.a(2, EntryType.UI_INPUT_END, 574551609, a);
                        return;
                    }
                    notificationSettingsSingleSelectorPersistentState.f8851a = c;
                    this.f8791d.f8799b.a(((HasContext) hasPersistentState).getContext(), notifOptionNode.f8709a, Surface.SINGLE_SELECTOR);
                    ((HasInvalidate) hasPersistentState).a(new FeedProps[]{FeedProps.c(notifOptionNode)});
                    LogUtils.a(1365282247, a);
                }
            });
        } else {
            final NotificationSettingsMultiSelectorPersistentState notificationSettingsMultiSelectorPersistentState = (NotificationSettingsMultiSelectorPersistentState) props.f8784c;
            clickListenerPartDefinition = this.f8800c;
            notifOptionNode = props.f8782a;
            subParts.a(clickListenerPartDefinition, new OnClickListener(this) {
                final /* synthetic */ NotificationSettingsSelectorPartDefinition f8795d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 514829320);
                    boolean isChecked = ((CheckedContentView) view).isChecked();
                    String c = notifOptionNode.f8709a.mo461c();
                    this.f8795d.f8799b.a(((HasContext) hasPersistentState).getContext(), notifOptionNode.f8709a, Surface.MULTI_SELECTOR);
                    notificationSettingsMultiSelectorPersistentState.m10771a(c, isChecked);
                    ((HasInvalidate) hasPersistentState).a(new FeedProps[]{FeedProps.c(notifOptionNode)});
                    Logger.a(2, EntryType.UI_INPUT_END, 1358153028, a);
                }
            });
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m10742a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 143813450);
        m10738a((Props) obj, (HasPersistentState) anyEnvironment, (CheckedContentView) view);
        Logger.a(8, EntryType.MARK_POP, -1354366405, a);
    }

    public final boolean m10743a(Object obj) {
        Props props = (Props) obj;
        return (props.f8782a.f8709a.mo462d() == null || props.f8782a.f8709a.mo462d().m10463j() == null || Strings.isNullOrEmpty(props.f8782a.f8709a.mo462d().m10463j().a())) ? false : true;
    }

    public static NotificationSettingsSelectorPartDefinition m10737a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationSettingsSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8798i) {
                NotificationSettingsSelectorPartDefinition notificationSettingsSelectorPartDefinition;
                if (a2 != null) {
                    notificationSettingsSelectorPartDefinition = (NotificationSettingsSelectorPartDefinition) a2.a(f8798i);
                } else {
                    notificationSettingsSelectorPartDefinition = f8797h;
                }
                if (notificationSettingsSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10739b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8798i, b3);
                        } else {
                            f8797h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationSettingsSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public NotificationSettingsSelectorPartDefinition(NotificationsActionExecutor notificationsActionExecutor, ClickListenerPartDefinition clickListenerPartDefinition, GlyphColorizer glyphColorizer, ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition, ContentViewThumbnailUriStringPartDefinition contentViewThumbnailUriStringPartDefinition, ContentViewTitlePartDefinition contentViewTitlePartDefinition) {
        this.f8799b = notificationsActionExecutor;
        this.f8800c = clickListenerPartDefinition;
        this.f8801d = glyphColorizer;
        this.f8802e = contentViewSubtitlePartDefinition;
        this.f8803f = contentViewThumbnailUriStringPartDefinition;
        this.f8804g = contentViewTitlePartDefinition;
    }

    public final ViewType<CheckedContentView> m10740a() {
        return f8796a;
    }

    private void m10738a(Props props, E e, CheckedContentView checkedContentView) {
        Drawable a;
        checkedContentView.setThumbnailSize(ThumbnailSize.SMALL);
        String c = props.f8782a.f8709a.mo461c();
        boolean a2 = props.f8784c.mo471a(c);
        checkedContentView.setTag(c);
        checkedContentView.setChecked(a2);
        Context context = ((HasContext) e).getContext();
        if (a2) {
            a = this.f8801d.a(ContextCompat.a(context, 2130839792), ContextCompat.b(context, 2131361924));
        } else {
            a = this.f8801d.a(ContextCompat.a(context, 2130839793), ContextCompat.b(context, 2131361957));
        }
        checkedContentView.setCheckMarkDrawable(a);
    }
}
