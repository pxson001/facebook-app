package com.facebook.feedplugins.pymi.rows;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feedplugins.friendingcommon.SmartButtonTextPartDefinition;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.ui.SmartButtonLite;
import com.facebook.graphql.calls.FutureFriendingInputData.Action;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ImageWithTextViewDrawablePartDefinition;
import com.facebook.multirow.parts.ImageWithTextViewDrawablePartDefinition.IconData;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: cluster_tapped_to_zoom_in */
public class FutureFriendingFriendPartDefinition<E extends HasInvalidate & HasPersistentState> extends BaseSinglePartDefinition<Props, Void, E, SmartButtonLite> {
    private static FutureFriendingFriendPartDefinition f8730i;
    private static final Object f8731j = new Object();
    private final AllCapsTransformationMethod f8732a;
    private final ClickListenerPartDefinition f8733b;
    public final FriendingClient f8734c;
    public final Resources f8735d;
    private final SmartButtonTextPartDefinition f8736e;
    public final TasksManager<String> f8737f;
    private final ImageWithTextViewDrawablePartDefinition f8738g;
    public final Toaster f8739h;

    /* compiled from: cluster_tapped_to_zoom_in */
    public class Props {
        public final GraphQLPeopleYouMayInviteFeedUnit f8725a;
        public final GraphQLPeopleYouMayInviteFeedUnitContactsEdge f8726b;
        public final Controller f8727c;
        @Nullable
        public final String f8728d;
        public final boolean f8729e;

        public Props(GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit, GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge, Controller controller, String str, boolean z) {
            this.f8725a = graphQLPeopleYouMayInviteFeedUnit;
            this.f8726b = graphQLPeopleYouMayInviteFeedUnitContactsEdge;
            this.f8727c = controller;
            this.f8728d = str;
            this.f8729e = z;
        }
    }

    private static FutureFriendingFriendPartDefinition m9529b(InjectorLike injectorLike) {
        return new FutureFriendingFriendPartDefinition(AllCapsTransformationMethod.b(injectorLike), ClickListenerPartDefinition.a(injectorLike), FriendingClient.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), SmartButtonTextPartDefinition.a(injectorLike), TasksManager.b(injectorLike), ImageWithTextViewDrawablePartDefinition.a(injectorLike), Toaster.b(injectorLike));
    }

    public final Object m9530a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        final Props props = (Props) obj;
        final HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        subParts.a(this.f8733b, new OnClickListener(this) {
            final /* synthetic */ FutureFriendingFriendPartDefinition f8724c;

            public void onClick(View view) {
                Object obj;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 84386708);
                String g = props.f8726b.g();
                final FutureFriendingPagePartDefinition$FutureFriendingStateKey futureFriendingPagePartDefinition$FutureFriendingStateKey = new FutureFriendingPagePartDefinition$FutureFriendingStateKey(g, false);
                final boolean z = props.f8729e;
                TasksManager tasksManager = this.f8724c.f8737f;
                if (z) {
                    obj = "TASK_CANCEL_REQUEST" + g;
                } else {
                    obj = "TASK_ADD_CONTACT" + g;
                }
                tasksManager.a(obj, new Callable<ListenableFuture<Void>>(this) {
                    final /* synthetic */ C10691 f8718b;

                    public Object call() {
                        return this.f8718b.f8724c.f8734c.a(z ? Action.CANCEL : Action.SEND, props.f8726b.l(), props.f8726b.j(), props.f8728d);
                    }
                }, new AbstractDisposableFutureCallback<Void>(this) {
                    final /* synthetic */ C10691 f8721c;

                    protected final void m9525a(Throwable th) {
                        this.f8721c.f8724c.f8739h.b(new ToastBuilder(2131230758));
                        ((HasPersistentState) hasInvalidate).a(futureFriendingPagePartDefinition$FutureFriendingStateKey, Boolean.valueOf(z));
                        hasInvalidate.a(new Object[]{props.f8725a});
                    }
                });
                if (!z) {
                    props.f8727c.a();
                }
                ((HasPersistentState) hasInvalidate).a(futureFriendingPagePartDefinition$FutureFriendingStateKey, Boolean.valueOf(!z));
                hasInvalidate.a(new Object[]{props.f8725a});
                LogUtils.a(-1452512070, a);
            }
        });
        ImageWithTextViewDrawablePartDefinition imageWithTextViewDrawablePartDefinition = this.f8738g;
        if (props.f8729e) {
            i = 2130839891;
        } else {
            i = 2130840447;
        }
        subParts.a(imageWithTextViewDrawablePartDefinition, new IconData(i, Integer.valueOf(this.f8735d.getColor(2131362107))));
        subParts.a(this.f8736e, m9528b(props.f8729e));
        return null;
    }

    public static FutureFriendingFriendPartDefinition m9526a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FutureFriendingFriendPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8731j) {
                FutureFriendingFriendPartDefinition futureFriendingFriendPartDefinition;
                if (a2 != null) {
                    futureFriendingFriendPartDefinition = (FutureFriendingFriendPartDefinition) a2.a(f8731j);
                } else {
                    futureFriendingFriendPartDefinition = f8730i;
                }
                if (futureFriendingFriendPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9529b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8731j, b3);
                        } else {
                            f8730i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = futureFriendingFriendPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FutureFriendingFriendPartDefinition(AllCapsTransformationMethod allCapsTransformationMethod, ClickListenerPartDefinition clickListenerPartDefinition, FriendingClient friendingClient, Resources resources, SmartButtonTextPartDefinition smartButtonTextPartDefinition, TasksManager tasksManager, ImageWithTextViewDrawablePartDefinition imageWithTextViewDrawablePartDefinition, Toaster toaster) {
        this.f8732a = allCapsTransformationMethod;
        this.f8733b = clickListenerPartDefinition;
        this.f8734c = friendingClient;
        this.f8735d = resources;
        this.f8736e = smartButtonTextPartDefinition;
        this.f8737f = tasksManager;
        this.f8738g = imageWithTextViewDrawablePartDefinition;
        this.f8739h = toaster;
    }

    private com.facebook.feedplugins.friendingcommon.SmartButtonTextPartDefinition.Props m9528b(boolean z) {
        if (z) {
            return new com.facebook.feedplugins.friendingcommon.SmartButtonTextPartDefinition.Props(m9527a(2131233214), m9527a(2131230727));
        }
        return new com.facebook.feedplugins.friendingcommon.SmartButtonTextPartDefinition.Props(m9527a(2131239085), m9527a(2131239086));
    }

    private CharSequence m9527a(@StringRes int i) {
        return this.f8732a.getTransformation(this.f8735d.getString(i), null);
    }
}
