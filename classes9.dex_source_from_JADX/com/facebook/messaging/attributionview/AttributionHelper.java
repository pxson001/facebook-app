package com.facebook.messaging.attributionview;

import android.content.Context;
import android.net.Uri;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attribution.AttributionActionType;
import com.facebook.messaging.attributionview.AttributionView.LoggingListener;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.montage.MontageTestHelper;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: other_fbid */
public class AttributionHelper {
    public static final List<Source> f7927a = ImmutableList.of(Source.MEDIA_PICKER, Source.VOICE_CLIP);
    private final Context f7928b;
    public final MontageTestHelper f7929c;
    private final Provider<Boolean> f7930d;
    public final Provider<Boolean> f7931e;
    public final AnalyticsLogger f7932f;

    /* compiled from: other_fbid */
    class C08861 implements LoggingListener {
        final /* synthetic */ AttributionHelper f7925a;

        C08861(AttributionHelper attributionHelper) {
            this.f7925a = attributionHelper;
        }

        public final void mo289a(AttributionViewData attributionViewData, @Nullable AttributionActionType attributionActionType) {
        }

        public final void mo290b(AttributionViewData attributionViewData, @Nullable AttributionActionType attributionActionType) {
            AttributionHelper attributionHelper = this.f7925a;
            attributionHelper.f7932f.a(new HoneyClientEvent("tap_on_internal_attribution_link").b("internal_attribution_type", attributionViewData.mo294b()));
        }
    }

    /* compiled from: other_fbid */
    public /* synthetic */ class C08872 {
        public static final /* synthetic */ int[] f7926a = new int[Source.values().length];

        static {
            try {
                f7926a[Source.MEDIA_PICKER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7926a[Source.VOICE_CLIP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: other_fbid */
    public enum AttributionSource {
        NONE,
        PLATFORM_CONTENT_APP,
        INTERNAL_FEATURE,
        MONTAGE
    }

    public static AttributionHelper m8143b(InjectorLike injectorLike) {
        return new AttributionHelper((Context) injectorLike.getInstance(Context.class), MontageTestHelper.m12872b(injectorLike), IdBasedProvider.a(injectorLike, 4085), IdBasedProvider.a(injectorLike, 4098), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public static AttributionHelper m8142a(InjectorLike injectorLike) {
        return m8143b(injectorLike);
    }

    @Inject
    public AttributionHelper(Context context, MontageTestHelper montageTestHelper, Provider<Boolean> provider, Provider<Boolean> provider2, AnalyticsLogger analyticsLogger) {
        this.f7928b = context;
        this.f7929c = montageTestHelper;
        this.f7930d = provider;
        this.f7931e = provider2;
        this.f7932f = analyticsLogger;
    }

    public final AttributionSource m8144a(Message message, boolean z, boolean z2) {
        if (m8147b(message)) {
            return AttributionSource.PLATFORM_CONTENT_APP;
        }
        Object obj;
        Object obj2;
        int i;
        boolean booleanValue;
        if (!ThreadKey.g(message.b)) {
            int i2;
            if ((message.a().isEmpty() || !((MediaResource) message.a().get(0)).d.equals(Type.PHOTO)) && (message.i.isEmpty() || ((Attachment) message.i.get(0)).g == null)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                obj = 1;
                if (obj == null && z && z2 && this.f7929c.m12878b()) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    return AttributionSource.MONTAGE;
                }
                i = 0;
                if (message.a() != null && message.a().size() == 1) {
                    i = f7927a.contains(((MediaResource) message.a().get(0)).e);
                }
                if (i != 0) {
                    switch (C08872.f7926a[((MediaResource) message.a().get(0)).e.ordinal()]) {
                        case 1:
                            booleanValue = ((Boolean) this.f7931e.get()).booleanValue();
                            break;
                        case 2:
                            booleanValue = ((Boolean) this.f7931e.get()).booleanValue();
                            break;
                        default:
                            booleanValue = false;
                            break;
                    }
                }
                booleanValue = false;
                if (booleanValue) {
                    return AttributionSource.NONE;
                }
                return AttributionSource.INTERNAL_FEATURE;
            }
        }
        obj = null;
        if (obj == null) {
        }
        obj2 = null;
        if (obj2 != null) {
            return AttributionSource.MONTAGE;
        }
        i = 0;
        i = f7927a.contains(((MediaResource) message.a().get(0)).e);
        if (i != 0) {
            switch (C08872.f7926a[((MediaResource) message.a().get(0)).e.ordinal()]) {
                case 1:
                    booleanValue = ((Boolean) this.f7931e.get()).booleanValue();
                    break;
                case 2:
                    booleanValue = ((Boolean) this.f7931e.get()).booleanValue();
                    break;
                default:
                    booleanValue = false;
                    break;
            }
        }
        booleanValue = false;
        if (booleanValue) {
            return AttributionSource.NONE;
        }
        return AttributionSource.INTERNAL_FEATURE;
    }

    public final AttributionViewData m8146a(Message message) {
        int i;
        int i2;
        Preconditions.checkArgument(!message.a().isEmpty());
        switch (C08872.f7926a[((MediaResource) message.a().get(0)).e.ordinal()]) {
            case 1:
                i = 2131240906;
                i2 = 2130841384;
                break;
            case 2:
                i = 2131231616;
                i2 = 2130841459;
                break;
            default:
                throw new IllegalArgumentException("AttributionHelper got an unsupported media resource source");
        }
        return new InternalAttributionViewData(message, this.f7928b.getResources().getString(i), Uri.parse("res:///" + i2));
    }

    public final LoggingListener m8145a() {
        return new C08861(this);
    }

    public final boolean m8147b(Message message) {
        ContentAppAttribution contentAppAttribution = message.F;
        return (!((Boolean) this.f7930d.get()).booleanValue() || contentAppAttribution == null || contentAppAttribution.h.c) ? false : true;
    }
}
