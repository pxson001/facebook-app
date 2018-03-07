package com.facebook.composer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass58;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.composer.metatext.MetaTextBuilder;
import com.facebook.composer.metatext.MetaTextBuilder.ParamsBuilder;
import com.facebook.composer.metatext.MetaTextBuilder.TagClickListener;
import com.facebook.composer.metatext.MetaTextSpan;
import com.facebook.composer.minutiae.iconpicker.MinutiaeIconPickerIntentHelper;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext.Span;
import com.facebook.platform.opengraph.server.GetRobotextPreviewMethod.Params;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: invalid items in wall  */
public class ComposerMetaTextController {
    public final Context f6170a;
    private final DefaultBlueServiceOperationFactory f6171b;
    private final MetaTextBuilder f6172c;
    public final AnonymousClass58 f6173d;
    private OpenGraphActionRobotext f6174e;
    private long f6175f;
    private ImmutableList<ComposerTaggedUser> f6176g = RegularImmutableList.a;
    private CheckinPlaceModel f6177h;
    private String f6178i;
    private MinutiaeObject f6179j;
    private boolean f6180k;

    /* compiled from: invalid items in wall  */
    class C07681 implements TagClickListener {
        final /* synthetic */ ComposerMetaTextController f6169a;

        C07681(ComposerMetaTextController composerMetaTextController) {
            this.f6169a = composerMetaTextController;
        }

        public final void m7614a(int i) {
            this.f6169a.f6173d.m7503a();
        }

        public final void m7613a() {
            this.f6169a.f6173d.m7503a();
        }

        public final void m7615b() {
            ComposerFragment.bM(this.f6169a.f6173d.f6097a);
        }

        public final void m7616c() {
            ComposerFragment.bT(this.f6169a.f6173d.f6097a);
        }

        public final void m7617d() {
            ComposerFragment composerFragment = this.f6169a.f6173d.f6097a;
            composerFragment.bJ.a(Events.COMPOSER_MINUTIAE_ICON_CLICKED, composerFragment.aS.ab());
            MinutiaeObject l = composerFragment.aS.m7436l();
            Intent a = ((MinutiaeIconPickerIntentHelper) composerFragment.aI.get()).a(composerFragment.getContext(), l, l.b());
            if (a != null) {
                ((SecureContextHelper) composerFragment.bP.get()).a(a, 6, composerFragment);
            }
        }
    }

    public ComposerMetaTextController(Context context, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, MetaTextBuilder metaTextBuilder, AnonymousClass58 anonymousClass58) {
        this.f6170a = context;
        this.f6171b = defaultBlueServiceOperationFactory;
        this.f6172c = metaTextBuilder;
        this.f6173d = anonymousClass58;
    }

    public final ListenableFuture<OperationResult> m7622a(String str, String str2, ComposerAppAttribution composerAppAttribution) {
        if (str == null || str2 == null || composerAppAttribution == null) {
            throw new IllegalArgumentException("Failed to generate preview for user due to invalid input");
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("og_action", new Params(str, str2, composerAppAttribution.a(), composerAppAttribution.c()));
        return BlueServiceOperationFactoryDetour.a(this.f6171b, "platform_get_robotext_preview", bundle, -2062836806).a();
    }

    public final void m7624a(OpenGraphActionRobotext openGraphActionRobotext) {
        this.f6174e = openGraphActionRobotext;
        m7620a();
    }

    public final void m7623a(long j, ImmutableList<ComposerTaggedUser> immutableList, CheckinPlace checkinPlace, String str, MinutiaeObject minutiaeObject, boolean z) {
        this.f6175f = j;
        this.f6176g = immutableList;
        this.f6177h = checkinPlace;
        this.f6178i = str;
        this.f6179j = minutiaeObject;
        this.f6180k = z;
        m7620a();
    }

    private void m7620a() {
        boolean z = true;
        AnonymousClass58 anonymousClass58 = this.f6173d;
        SpannedString a = m7618a(true);
        if (this.f6174e == null) {
            z = false;
        }
        anonymousClass58.m7504a(a, z);
    }

    private int m7621b() {
        int size = this.f6176g.size();
        for (int i = 0; i < size; i++) {
            if (((ComposerTaggedUser) this.f6176g.get(i)).a() == this.f6175f) {
                return this.f6176g.size() - 1;
            }
        }
        return this.f6176g.size();
    }

    private ImmutableList<String> m7619a(int i) {
        Builder builder = ImmutableList.builder();
        int size = this.f6176g.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            int i4;
            ComposerTaggedUser composerTaggedUser = (ComposerTaggedUser) this.f6176g.get(i2);
            if (composerTaggedUser.a() != this.f6175f && composerTaggedUser.b() != null) {
                int i5 = i3 + 1;
                if (i3 >= i) {
                    break;
                }
                builder.c(composerTaggedUser.b());
                i4 = i5;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        return builder.b();
    }

    private SpannedString m7618a(boolean z) {
        CharSequence a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int color = this.f6170a.getResources().getColor(2131361916);
        if (this.f6174e != null) {
            String str = this.f6174e.a;
            List<Span> list = this.f6174e.b;
            if (str != null) {
                int length = str.length();
                spannableStringBuilder.append(str);
                spannableStringBuilder.setSpan(new MetaTextSpan(this.f6170a.getResources().getColor(2131362944)), 0, length, 33);
                for (Span span : list) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), span.mOffset, span.b(), 33);
                }
            }
        }
        if (this.f6180k && this.f6174e == null) {
            Object obj = spannableStringBuilder;
        } else {
            ParamsBuilder paramsBuilder = new ParamsBuilder();
            paramsBuilder.f = z;
            paramsBuilder = paramsBuilder;
            paramsBuilder.g = z;
            paramsBuilder = paramsBuilder;
            paramsBuilder.h = spannableStringBuilder;
            paramsBuilder = paramsBuilder;
            paramsBuilder.i = new C07681(this);
            ParamsBuilder paramsBuilder2 = paramsBuilder;
            paramsBuilder2.a = this.f6179j;
            paramsBuilder2.b = this.f6177h;
            paramsBuilder2.c = this.f6178i;
            color = m7621b();
            if (color == 2) {
                paramsBuilder2.a(m7619a(2));
            } else {
                ImmutableList a2 = m7619a(1);
                if (!a2.isEmpty()) {
                    paramsBuilder2.b((String) a2.get(0));
                }
            }
            paramsBuilder2.e = color;
            a = this.f6172c.a(paramsBuilder2.a());
        }
        return new SpannedString(a);
    }

    public final void m7625a(Long l, CheckinPlace checkinPlace, String str, ImmutableList<ComposerTaggedUser> immutableList, MinutiaeObject minutiaeObject) {
        this.f6175f = l.longValue();
        this.f6177h = checkinPlace;
        this.f6178i = str;
        this.f6176g = immutableList;
        this.f6179j = minutiaeObject;
        CharSequence spannedString = m7618a(false).toString();
        if (!StringUtil.a(spannedString)) {
            Object a = this.f6179j != null ? this.f6179j.a() : null;
            AnonymousClass58 anonymousClass58 = this.f6173d;
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            if (spannedString != null) {
                spannableStringBuilder.append(" — ");
                if (a != null) {
                    spannableStringBuilder.append('‌');
                    spannableStringBuilder.append(" ");
                    spannableStringBuilder.setSpan(a, 3, 4, 33);
                }
                spannableStringBuilder.append(spannedString);
            }
            spannableStringBuilder.setSpan(new MetaTextSpan(this.f6170a.getResources().getColor(2131362945)), 0, spannableStringBuilder.length(), 33);
            anonymousClass58.m7504a(new SpannedString(spannableStringBuilder), false);
        }
    }
}
