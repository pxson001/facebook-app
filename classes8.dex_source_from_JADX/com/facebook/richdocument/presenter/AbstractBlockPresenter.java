package com.facebook.richdocument.presenter;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentStartupUiTasksCompletedSubscriber;
import com.facebook.richdocument.event.StartupStateMachine;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.view.block.BlockView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: photo_category */
public abstract class AbstractBlockPresenter<V extends BlockView, BLOCKDATA extends BlockData> implements InjectableComponentWithContext {
    @Inject
    public RichDocumentEventBus f6379a;
    @Inject
    public AbstractFbErrorReporter f6380b;
    @Inject
    public StartupStateMachine f6381c;
    public final V f6382d;
    private FbEventSubscriberListManager f6383e;
    public final List<RunOnStartUpTasksCompletedSubscriber> f6384f = new ArrayList();

    /* compiled from: photo_category */
    public class RunOnStartUpTasksCompletedSubscriber extends RichDocumentStartupUiTasksCompletedSubscriber {
        final Runnable f6377a;
        final /* synthetic */ AbstractBlockPresenter f6378b;

        public RunOnStartUpTasksCompletedSubscriber(AbstractBlockPresenter abstractBlockPresenter, Runnable runnable) {
            this.f6378b = abstractBlockPresenter;
            this.f6377a = runnable;
        }

        public final void m6770b(FbEvent fbEvent) {
            this.f6377a.run();
            this.f6378b.f6384f.remove(this);
        }
    }

    public static void m6771a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AbstractBlockPresenter abstractBlockPresenter = (AbstractBlockPresenter) obj;
        RichDocumentEventBus a = RichDocumentEventBus.m5130a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        StartupStateMachine a2 = StartupStateMachine.m5147a(fbInjector);
        abstractBlockPresenter.f6379a = a;
        abstractBlockPresenter.f6380b = abstractFbErrorReporter;
        abstractBlockPresenter.f6381c = a2;
    }

    public abstract void mo366a(BLOCKDATA blockdata);

    public AbstractBlockPresenter(V v) {
        this.f6382d = v;
        this.f6382d.mo376a(this);
        this.f6383e = new FbEventSubscriberListManager();
        Class cls = AbstractBlockPresenter.class;
        m6771a(this, getContext());
    }

    public final V m6772a() {
        return this.f6382d;
    }

    public Context getContext() {
        return this.f6382d.getContext();
    }

    public void mo367a(Bundle bundle) {
        this.f6383e.a(this.f6379a);
        this.f6382d.mo378b(bundle);
    }

    public void mo371b(Bundle bundle) {
        this.f6383e.b(this.f6379a);
        this.f6382d.mo379c(bundle);
    }
}
