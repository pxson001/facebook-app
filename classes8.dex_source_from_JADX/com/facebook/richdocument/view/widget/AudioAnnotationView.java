package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.enums.GraphQLAudioAnnotationPlayMode;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentFragmentLifeCycleSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentFragmentLifeCycleEvent;
import com.facebook.richdocument.model.block.AudioAnnotation;
import com.facebook.richdocument.view.block.AudioAnnotationAware.AudioAnnotationActionCondition;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.sounds.SoundPlayer;
import com.facebook.sounds.SoundPlayer.SoundPlayerListener;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: open_page_map_tap */
public class AudioAnnotationView extends TextAnnotationView<AudioAnnotation> {
    @Inject
    RichDocumentEventBus f7097a;
    @Inject
    SoundPlayer f7098b;
    private Uri f7099f;
    private GraphQLAudioAnnotationPlayMode f7100g;
    public boolean f7101h;
    public boolean f7102i;
    private final RichDocumentFragmentLifeCycleSubscriber f7103j;

    /* compiled from: open_page_map_tap */
    class C08071 extends RichDocumentFragmentLifeCycleSubscriber {
        final /* synthetic */ AudioAnnotationView f7087a;

        C08071(AudioAnnotationView audioAnnotationView) {
            this.f7087a = audioAnnotationView;
        }

        public final void m7394b(FbEvent fbEvent) {
            switch (((RichDocumentFragmentLifeCycleEvent) fbEvent).f5175a) {
                case ON_PAUSE:
                    this.f7087a.f7102i = this.f7087a.f7101h;
                    this.f7087a.m7421g();
                    return;
                case ON_RESUME:
                    if (this.f7087a.f7102i) {
                        this.f7087a.m7420f();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: open_page_map_tap */
    class C08082 implements OnClickListener {
        final /* synthetic */ AudioAnnotationView f7088a;

        C08082(AudioAnnotationView audioAnnotationView) {
            this.f7088a = audioAnnotationView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -745594441);
            this.f7088a.mo444e();
            Logger.a(2, EntryType.UI_INPUT_END, -2037150993, a);
        }
    }

    /* compiled from: open_page_map_tap */
    class C08093 implements SoundPlayerListener {
        final /* synthetic */ AudioAnnotationView f7089a;

        C08093(AudioAnnotationView audioAnnotationView) {
            this.f7089a = audioAnnotationView;
        }

        public final void m7395a(SoundPlayer soundPlayer) {
            AudioAnnotationView.m7415i(this.f7089a);
        }
    }

    private static <T extends View> void m7408a(Class<T> cls, T t) {
        m7409a((Object) t, t.getContext());
    }

    private static void m7409a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AudioAnnotationView) obj).m7407a(RichDocumentEventBus.m5130a(fbInjector), SoundPlayer.b(fbInjector));
    }

    public void setAnnotation(AudioAnnotation audioAnnotation) {
        if (!StringUtil.a(audioAnnotation.f5615a)) {
            super.setAnnotation(audioAnnotation);
            this.f7099f = Uri.parse(audioAnnotation.f5615a);
            this.f7100g = audioAnnotation.f5616b;
            this.f7098b.h = new C08093(this);
        }
    }

    public AudioAnnotationView(Context context) {
        this(context, null);
    }

    public AudioAnnotationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AudioAnnotationView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7102i = false;
        this.f7103j = new C08071(this);
        m7408a(AudioAnnotationView.class, (View) this);
        this.f7101h = false;
        OnClickListener c08082 = new C08082(this);
        setOnClickListener(c08082);
        setTextOnClickListener(c08082);
    }

    protected final void mo443d() {
        super.mo443d();
        m7401a(2130843062, 2131558721, 2131558722);
        setDrawablePaddingResource(2131431825);
        BlockViewUtil.m6919a(getDrawable(), getContext().getResources().getColor(isEnabled() ? 2131363468 : 17170432));
    }

    public final void mo444e() {
        if (this.f7101h) {
            m7421g();
        } else {
            m7420f();
        }
    }

    public final void m7416a(AudioAnnotationActionCondition audioAnnotationActionCondition) {
        switch (audioAnnotationActionCondition) {
            case EXPAND_COLLAPSE_TRIGGERED:
                if (this.f7100g != GraphQLAudioAnnotationPlayMode.ON_EXPAND) {
                    return;
                }
                break;
            case SCROLL_TRIGGERED:
                if (this.f7100g == GraphQLAudioAnnotationPlayMode.AMBIENT) {
                    break;
                }
                return;
            case ENFORCED:
                break;
            default:
                return;
        }
        m7420f();
    }

    public final void m7417b(AudioAnnotationActionCondition audioAnnotationActionCondition) {
        switch (audioAnnotationActionCondition) {
            case EXPAND_COLLAPSE_TRIGGERED:
                if (this.f7100g != GraphQLAudioAnnotationPlayMode.ON_EXPAND) {
                    return;
                }
                break;
            case SCROLL_TRIGGERED:
            case ENFORCED:
                break;
            default:
                return;
        }
        m7421g();
    }

    public final void m7420f() {
        if (!this.f7101h) {
            this.f7098b.a(this.f7099f, 3);
            m7414h();
            this.f7101h = true;
        }
    }

    private void m7414h() {
        m7401a(2130837734, 2131558721, 2131558722);
        ((Animatable) getDrawable()).start();
    }

    public final void m7421g() {
        if (this.f7101h) {
            this.f7098b.a();
            m7415i(this);
            this.f7101h = false;
        }
    }

    public static void m7415i(AudioAnnotationView audioAnnotationView) {
        audioAnnotationView.m7401a(2130843063, 2131558721, 2131558722);
    }

    public static AudioAnnotationView m7406a(Context context, ViewGroup viewGroup, AudioAnnotation audioAnnotation) {
        AudioAnnotationView audioAnnotationView = (AudioAnnotationView) LayoutInflater.from(context).inflate(2130906863, viewGroup, false);
        audioAnnotationView.setAnnotation(audioAnnotation);
        return audioAnnotationView;
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1689775165);
        this.f7097a.a(this.f7103j);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -599497086, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 105818671);
        this.f7097a.b(this.f7103j);
        m7421g();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1084099139, a);
    }

    private void m7407a(RichDocumentEventBus richDocumentEventBus, SoundPlayer soundPlayer) {
        this.f7097a = richDocumentEventBus;
        this.f7098b = soundPlayer;
    }
}
