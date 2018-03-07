package com.facebook.events.create.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.ipc.media.MediaItem;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Strings;
import java.util.ArrayList;

/* compiled from: confirmation_body_text */
public class EventCreationCoverPhotoView extends CustomRelativeLayout {
    private static final CallerContext f16345e = CallerContext.a(EventCreationCoverPhotoView.class, "event_composer");
    private EventCoverPhotoModel f16346a;
    private FbDraweeView f16347b;
    private ObjectAnimator f16348c;
    private EventsCreationCoverPhotoAnimationController f16349d;

    /* compiled from: confirmation_body_text */
    class C22821 extends AnimatorListenerAdapter {
        final /* synthetic */ EventCreationCoverPhotoView f16344a;

        C22821(EventCreationCoverPhotoView eventCreationCoverPhotoView) {
            this.f16344a = eventCreationCoverPhotoView;
        }

        public void onAnimationEnd(Animator animator) {
            EventCreationCoverPhotoView.m16816b(this.f16344a);
        }

        public void onAnimationCancel(Animator animator) {
            EventCreationCoverPhotoView.m16816b(this.f16344a);
        }
    }

    public EventCreationCoverPhotoView(Context context) {
        this(context, null);
    }

    public EventCreationCoverPhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EventCreationCoverPhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16814a();
    }

    private void m16814a() {
        setContentView(2130904017);
        this.f16347b = (FbDraweeView) a(2131561267);
        this.f16347b.setVisibility(8);
    }

    public final void m16823a(EventCoverPhotoModel eventCoverPhotoModel, EventsCreationCoverPhotoAnimationController eventsCreationCoverPhotoAnimationController) {
        this.f16346a = eventCoverPhotoModel;
        this.f16349d = eventsCreationCoverPhotoAnimationController;
        m16824a(false);
    }

    public static void m16816b(EventCreationCoverPhotoView eventCreationCoverPhotoView) {
        Object obj;
        if (eventCreationCoverPhotoView.f16346a.f16330d != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null || !eventCreationCoverPhotoView.m16820e()) {
            eventCreationCoverPhotoView.f16347b.a(eventCreationCoverPhotoView.f16346a.f16329c, f16345e);
        } else {
            eventCreationCoverPhotoView.f16347b.a(eventCreationCoverPhotoView.f16346a.f16330d, f16345e);
        }
        eventCreationCoverPhotoView.f16347b.setVisibility(eventCreationCoverPhotoView.f16346a.m16809g() ? 0 : 8);
    }

    private boolean m16818c() {
        return this.f16346a.m16809g() != m16819d();
    }

    private boolean m16819d() {
        return this.f16347b.getVisibility() == 0;
    }

    private boolean m16820e() {
        return getContext().getResources().getConfiguration().orientation == 2;
    }

    @TargetApi(11)
    private void m16821f() {
        if (this.f16348c == null) {
            this.f16348c = ObjectAnimator.ofFloat(this.f16347b, "alpha", new float[]{0.0f, 1.0f});
            this.f16348c.setDuration(300);
        }
        this.f16348c.removeAllListeners();
    }

    @TargetApi(11)
    private void m16817b(boolean z) {
        this.f16347b.setVisibility(0);
        m16821f();
        if (z) {
            this.f16348c.addListener(new C22821(this));
            this.f16348c.reverse();
            this.f16349d.m16852b();
            return;
        }
        m16816b(this);
        this.f16348c.start();
        this.f16349d.m16850a();
    }

    public final void m16822a(int i, Intent intent) {
        EventCoverPhotoModel eventCoverPhotoModel = this.f16346a;
        switch (i) {
            case 103:
                if (intent.hasExtra("extra_media_items")) {
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
                    if (!(parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty() || parcelableArrayListExtra.get(0) == null)) {
                        eventCoverPhotoModel.m16806a();
                        eventCoverPhotoModel.f16329c = ((MediaItem) parcelableArrayListExtra.get(0)).f();
                        break;
                    }
                }
                break;
            case 104:
                if (intent.hasExtra("extra_selected_theme_uri") && intent.hasExtra("extra_selected_theme_id")) {
                    String stringExtra = intent.getStringExtra("extra_selected_theme_uri");
                    String stringExtra2 = intent.getStringExtra("extra_selected_theme_id");
                    if (!(Strings.isNullOrEmpty(stringExtra) || Strings.isNullOrEmpty(stringExtra2))) {
                        eventCoverPhotoModel.m16806a();
                        eventCoverPhotoModel.f16328b = stringExtra2;
                        eventCoverPhotoModel.f16329c = Uri.parse(stringExtra);
                        break;
                    }
                }
            case 9913:
                if (intent.hasExtra("photo")) {
                    GraphQLPhoto graphQLPhoto = (GraphQLPhoto) FlatBufferModelHelper.a(intent, "photo");
                    if (!(graphQLPhoto == null || graphQLPhoto.L() == null)) {
                        eventCoverPhotoModel.m16806a();
                        eventCoverPhotoModel.f16327a = graphQLPhoto.K();
                        eventCoverPhotoModel.f16329c = ImageUtil.a(graphQLPhoto.L());
                        break;
                    }
                }
                break;
        }
        m16824a(true);
    }

    public final void m16824a(boolean z) {
        if (!z || !m16818c()) {
            m16816b(this);
        } else if (m16819d()) {
            m16817b(true);
        } else {
            m16817b(false);
        }
    }
}
