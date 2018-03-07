package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.common.util.TriState;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RotatableCandidateRegisterEventSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RotatableCandidateRegisterEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RotatableCandidateRegisterEvent.RequestType;
import com.facebook.richdocument.gk.IsMediaLandscapeModeEnabled;
import com.facebook.richdocument.view.transition.motion.OrientationChangeEventListener;
import com.facebook.richdocument.view.transition.motion.OrientationChangeEventListener.DeviceOrientation;
import com.facebook.richdocument.view.transition.motion.RichDocumentOrientationSensor;
import com.facebook.richdocument.view.widget.media.RotatableViewAware;
import com.facebook.richdocument.view.widget.media.plugins.MediaRotationPlugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: offer_notifications */
public class RotatableCandidateSelector extends RecyclerViewChildSelector implements InjectableComponentWithContext, OrientationChangeEventListener {
    @Inject
    @IsMediaLandscapeModeEnabled
    public Provider<TriState> f7402a;
    @Inject
    public RichDocumentEventBus f7403b;
    private final RichDocumentOrientationSensor f7404c;
    private final List<RotatableViewAware> f7405d = new CopyOnWriteArrayList();
    private final RotatableCandidateRegisterEventSubscriber f7406e = new C08431(this);

    /* compiled from: offer_notifications */
    class C08431 extends RotatableCandidateRegisterEventSubscriber {
        final /* synthetic */ RotatableCandidateSelector f7401a;

        C08431(RotatableCandidateSelector rotatableCandidateSelector) {
            this.f7401a = rotatableCandidateSelector;
        }

        public final void m7632b(FbEvent fbEvent) {
            RotatableCandidateRegisterEvent rotatableCandidateRegisterEvent = (RotatableCandidateRegisterEvent) fbEvent;
            RequestType requestType = rotatableCandidateRegisterEvent.f5182b;
            MediaRotationPlugin mediaRotationPlugin = rotatableCandidateRegisterEvent.f5181a;
            if (requestType == RequestType.REGISTER) {
                this.f7401a.m7635a(mediaRotationPlugin);
            } else if (requestType == RequestType.UNREGISTER) {
                this.f7401a.m7637b(mediaRotationPlugin);
            }
        }
    }

    public static void m7633a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RotatableCandidateSelector rotatableCandidateSelector = (RotatableCandidateSelector) obj;
        Provider a = IdBasedProvider.a(fbInjector, 762);
        RichDocumentEventBus a2 = RichDocumentEventBus.m5130a(fbInjector);
        rotatableCandidateSelector.f7402a = a;
        rotatableCandidateSelector.f7403b = a2;
    }

    public Context getContext() {
        return this.f7250a.getContext();
    }

    public RotatableCandidateSelector(RecyclerView recyclerView, RichDocumentOrientationSensor richDocumentOrientationSensor) {
        super(recyclerView, 0.25f, 0.75f);
        Class cls = RotatableCandidateSelector.class;
        m7633a(this, getContext());
        this.f7404c = richDocumentOrientationSensor;
        if (((TriState) this.f7402a.get()).asBoolean(false)) {
            this.f7403b.a(this.f7406e);
        }
    }

    public final synchronized void mo469a(DeviceOrientation deviceOrientation) {
        Collection arrayList = new ArrayList();
        for (MediaRotationPlugin a : this.f7405d) {
            arrayList.add(a.m7950a());
        }
        View a2 = m7517a(arrayList);
        if (a2 != null) {
            for (MediaRotationPlugin a3 : this.f7405d) {
                if (a2 == a3.m7950a()) {
                    a3.mo469a(deviceOrientation);
                }
            }
        }
    }

    public final synchronized void m7635a(MediaRotationPlugin mediaRotationPlugin) {
        if (!this.f7405d.contains(mediaRotationPlugin)) {
            this.f7405d.add(mediaRotationPlugin);
            this.f7404c.m7343a(this);
        }
    }

    public final synchronized void m7637b(MediaRotationPlugin mediaRotationPlugin) {
        this.f7405d.remove(mediaRotationPlugin);
        if (this.f7405d.isEmpty()) {
            this.f7404c.m7344b(this);
        }
    }

    public final synchronized void m7636b() {
        this.f7405d.clear();
        this.f7404c.m7344b(this);
    }
}
