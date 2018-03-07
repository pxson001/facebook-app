package com.facebook.events.permalink.messagefriends;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.intents.OrcaMessagingIntentUris;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.CreateGroupParams;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.UserFbidIdentifier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@ContextScoped
/* compiled from: birthday_click_selfie_cam_button */
public class EventCreateGroupHandler {
    public static final String f18599a = EventCreateGroupHandler.class.getSimpleName();
    private static EventCreateGroupHandler f18600j;
    private static final Object f18601k = new Object();
    public final Context f18602b;
    public final EventCreateGroupMessageMethod f18603c;
    public final AbstractSingleMethodRunner f18604d;
    public final ExecutorService f18605e;
    public final TasksManager<String> f18606f;
    public final OrcaMessagingIntentUris f18607g;
    public final SecureContextHelper f18608h;
    public DialogFragment f18609i;

    /* compiled from: birthday_click_selfie_cam_button */
    public class C26421 implements Callable<ListenableFuture<ThreadKey>> {
        final /* synthetic */ Set f18592a;
        final /* synthetic */ EventCreateGroupHandler f18593b;

        public C26421(EventCreateGroupHandler eventCreateGroupHandler, Set set) {
            this.f18593b = eventCreateGroupHandler;
            this.f18592a = set;
        }

        public Object call() {
            EventCreateGroupHandler eventCreateGroupHandler = this.f18593b;
            Set<String> set = this.f18592a;
            SettableFuture f = SettableFuture.f();
            Builder builder = ImmutableList.builder();
            for (String userFbidIdentifier : set) {
                builder.c(new UserFbidIdentifier(userFbidIdentifier));
            }
            ExecutorDetour.a(eventCreateGroupHandler.f18605e, new C26443(eventCreateGroupHandler, builder, f), -949446541);
            return f;
        }
    }

    /* compiled from: birthday_click_selfie_cam_button */
    public class C26432 extends AbstractDisposableFutureCallback<ThreadKey> {
        final /* synthetic */ Activity f18594a;
        final /* synthetic */ EventCreateGroupHandler f18595b;

        public C26432(EventCreateGroupHandler eventCreateGroupHandler, Activity activity) {
            this.f18595b = eventCreateGroupHandler;
            this.f18594a = activity;
        }

        protected final void m18920a(Object obj) {
            ThreadKey threadKey = (ThreadKey) obj;
            this.f18595b.f18609i.b();
            EventCreateGroupHandler eventCreateGroupHandler = this.f18595b;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(eventCreateGroupHandler.f18607g.a(threadKey));
            intent.setFlags(268435456);
            eventCreateGroupHandler.f18608h.a(intent, eventCreateGroupHandler.f18602b);
            this.f18594a.finish();
        }

        protected final void m18921a(Throwable th) {
            this.f18595b.f18609i.b();
            Toast.makeText(this.f18595b.f18602b, 2131237248, 0).show();
        }
    }

    /* compiled from: birthday_click_selfie_cam_button */
    public class C26443 implements Runnable {
        final /* synthetic */ Builder f18596a;
        final /* synthetic */ SettableFuture f18597b;
        final /* synthetic */ EventCreateGroupHandler f18598c;

        public C26443(EventCreateGroupHandler eventCreateGroupHandler, Builder builder, SettableFuture settableFuture) {
            this.f18598c = eventCreateGroupHandler;
            this.f18596a = builder;
            this.f18597b = settableFuture;
        }

        public void run() {
            try {
                FutureDetour.a(this.f18597b, ThreadKey.a(Long.parseLong((String) this.f18598c.f18604d.a(this.f18598c.f18603c, CreateGroupParams.a(null, null, this.f18596a.b())))), -1747820767);
            } catch (Throwable e) {
                this.f18597b.a(e);
            }
        }
    }

    private static EventCreateGroupHandler m18923b(InjectorLike injectorLike) {
        return new EventCreateGroupHandler((Context) injectorLike.getInstance(Context.class), EventCreateGroupMessageMethod.m18925a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), (ExecutorService) ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), OrcaMessagingIntentUris.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public EventCreateGroupHandler(Context context, EventCreateGroupMessageMethod eventCreateGroupMessageMethod, AbstractSingleMethodRunner abstractSingleMethodRunner, ExecutorService executorService, TasksManager tasksManager, OrcaMessagingIntentUris orcaMessagingIntentUris, SecureContextHelper secureContextHelper) {
        this.f18602b = context;
        this.f18603c = eventCreateGroupMessageMethod;
        this.f18604d = abstractSingleMethodRunner;
        this.f18605e = executorService;
        this.f18606f = tasksManager;
        this.f18607g = orcaMessagingIntentUris;
        this.f18608h = secureContextHelper;
    }

    public static EventCreateGroupHandler m18922a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventCreateGroupHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18601k) {
                EventCreateGroupHandler eventCreateGroupHandler;
                if (a2 != null) {
                    eventCreateGroupHandler = (EventCreateGroupHandler) a2.a(f18601k);
                } else {
                    eventCreateGroupHandler = f18600j;
                }
                if (eventCreateGroupHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18923b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18601k, b3);
                        } else {
                            f18600j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventCreateGroupHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
