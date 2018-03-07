package com.facebook.feedback.ui.rows;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.views.CommentAddPlaceInfoAttachmentView;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
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
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration.Builder;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.launcher.PlacePickerLauncher;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_session_finished */
public class CommentAddPlaceInfoAttachmentPartDefinition extends MultiRowSinglePartDefinition<Props, Void, CommentsEnvironment, CommentAddPlaceInfoAttachmentView> {
    public static final ViewType<CommentAddPlaceInfoAttachmentView> f4875a = new C04781();
    private static CommentAddPlaceInfoAttachmentPartDefinition f4876e;
    private static final Object f4877f = new Object();
    private final CommentStylingPartDefinition f4878b;
    private final ClickListenerPartDefinition f4879c;
    public final PlacePickerLauncher f4880d;

    /* compiled from: ridge_session_finished */
    final class C04781 extends ViewType<CommentAddPlaceInfoAttachmentView> {
        C04781() {
        }

        public final View m5405a(Context context) {
            return new CommentAddPlaceInfoAttachmentView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    /* compiled from: ridge_session_finished */
    public class Props {
        public final String f4873a;
        public final CommentRowPadding f4874b;

        public Props(String str, CommentRowPadding commentRowPadding) {
            this.f4873a = str;
            this.f4874b = commentRowPadding;
        }
    }

    private static CommentAddPlaceInfoAttachmentPartDefinition m5407b(InjectorLike injectorLike) {
        return new CommentAddPlaceInfoAttachmentPartDefinition(CommentStylingPartDefinition.m5508a(injectorLike), ClickListenerPartDefinition.a(injectorLike), PlacePickerLauncher.m13011b(injectorLike));
    }

    public final Object m5409a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        subParts.a(this.f4878b, new com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props(props.f4874b));
        subParts.a(this.f4879c, new OnClickListener(this) {
            final /* synthetic */ CommentAddPlaceInfoAttachmentPartDefinition f4872b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2077687250);
                PlacePickerLauncher placePickerLauncher = this.f4872b.f4880d;
                String str = props.f4873a;
                Activity activity = (Activity) ContextUtils.a(view.getContext(), Activity.class);
                Builder a2 = PlacePickerLauncher.m13010a(SearchType.SOCIAL_SEARCH_COMMENT, "add_location_comment_place_info", null);
                a2.b = str;
                ((SecureContextHelper) placePickerLauncher.f11026a.get()).a(CheckinIntentCreator.a(activity, a2.a()), 5002, activity);
                Logger.a(2, EntryType.UI_INPUT_END, -183972488, a);
            }
        });
        return null;
    }

    @Inject
    public CommentAddPlaceInfoAttachmentPartDefinition(CommentStylingPartDefinition commentStylingPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, PlacePickerLauncher placePickerLauncher) {
        this.f4878b = commentStylingPartDefinition;
        this.f4879c = clickListenerPartDefinition;
        this.f4880d = placePickerLauncher;
    }

    public static CommentAddPlaceInfoAttachmentPartDefinition m5406a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentAddPlaceInfoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4877f) {
                CommentAddPlaceInfoAttachmentPartDefinition commentAddPlaceInfoAttachmentPartDefinition;
                if (a2 != null) {
                    commentAddPlaceInfoAttachmentPartDefinition = (CommentAddPlaceInfoAttachmentPartDefinition) a2.a(f4877f);
                } else {
                    commentAddPlaceInfoAttachmentPartDefinition = f4876e;
                }
                if (commentAddPlaceInfoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5407b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4877f, b3);
                        } else {
                            f4876e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentAddPlaceInfoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m5410a(Object obj) {
        return true;
    }

    public final ViewType<CommentAddPlaceInfoAttachmentView> m5408a() {
        return f4875a;
    }
}
