package com.facebook.redspace.rows.sharedactivities;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.i18n.BasicDateTimeFormat;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.model.LocationActivitySharing;
import com.facebook.redspace.model.RedSpaceSharedActivities.SharedActivity;
import com.facebook.redspace.rows.RedSpaceEnvironment;
import com.facebook.redspace.rows.sharedactivities.RedSpaceSharedActivitiesContentViewPartDefinition.Props;
import com.facebook.ultralight.Inject;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

@ContextScoped
/* compiled from: PROFILE_FIELD_TEXT_END */
public class RedSpaceSharedActivitiesLocationPartDefinition extends MultiRowSinglePartDefinition<SharedActivity, Void, RedSpaceEnvironment, ContentView> {
    public static final ViewType<ContentView> f12261a = ViewType.a(2130906758);
    private static RedSpaceSharedActivitiesLocationPartDefinition f12262h;
    private static final Object f12263i = new Object();
    private final RedSpaceSharedActivitiesBackgroundPartDefinition f12264b;
    private final Resources f12265c;
    private final RedSpaceSharedActivitiesContentViewPartDefinition f12266d;
    public final BasicDateTimeFormat f12267e;
    private final RedSpaceStrings f12268f;
    public final Clock f12269g;

    private static RedSpaceSharedActivitiesLocationPartDefinition m12711b(InjectorLike injectorLike) {
        return new RedSpaceSharedActivitiesLocationPartDefinition(RedSpaceSharedActivitiesBackgroundPartDefinition.m12692a(injectorLike), RedSpaceSharedActivitiesContentViewPartDefinition.m12696a(injectorLike), BasicDateTimeFormat.a(injectorLike), RedSpaceStrings.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public final Object m12713a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        LocationActivitySharing locationActivitySharing = (LocationActivitySharing) ((SharedActivity) obj);
        subParts.a(this.f12264b, null);
        RedSpaceSharedActivitiesContentViewPartDefinition redSpaceSharedActivitiesContentViewPartDefinition = this.f12266d;
        Props props = new Props();
        props.f12234a = this.f12268f.l();
        props = props;
        props.f12235b = m12710a(locationActivitySharing);
        props = props;
        props.f12241h = this.f12265c.getColor(2131363130);
        props = props;
        props.f12237d = this.f12265c.getDrawable(2130839998);
        subParts.a(redSpaceSharedActivitiesContentViewPartDefinition, props);
        return null;
    }

    public final boolean m12714a(Object obj) {
        SharedActivity sharedActivity = (SharedActivity) obj;
        return (sharedActivity instanceof LocationActivitySharing) && sharedActivity.e();
    }

    @Inject
    private RedSpaceSharedActivitiesLocationPartDefinition(RedSpaceSharedActivitiesBackgroundPartDefinition redSpaceSharedActivitiesBackgroundPartDefinition, RedSpaceSharedActivitiesContentViewPartDefinition redSpaceSharedActivitiesContentViewPartDefinition, BasicDateTimeFormat basicDateTimeFormat, RedSpaceStrings redSpaceStrings, Resources resources, Clock clock) {
        this.f12266d = redSpaceSharedActivitiesContentViewPartDefinition;
        this.f12264b = redSpaceSharedActivitiesBackgroundPartDefinition;
        this.f12268f = redSpaceStrings;
        this.f12267e = basicDateTimeFormat;
        this.f12265c = resources;
        this.f12269g = clock;
    }

    public static RedSpaceSharedActivitiesLocationPartDefinition m12709a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceSharedActivitiesLocationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12263i) {
                RedSpaceSharedActivitiesLocationPartDefinition redSpaceSharedActivitiesLocationPartDefinition;
                if (a2 != null) {
                    redSpaceSharedActivitiesLocationPartDefinition = (RedSpaceSharedActivitiesLocationPartDefinition) a2.a(f12263i);
                } else {
                    redSpaceSharedActivitiesLocationPartDefinition = f12262h;
                }
                if (redSpaceSharedActivitiesLocationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12711b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12263i, b3);
                        } else {
                            f12262h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceSharedActivitiesLocationPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ContentView> m12712a() {
        return f12261a;
    }

    private CharSequence m12710a(LocationActivitySharing locationActivitySharing) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(this.f12268f.b(locationActivitySharing.a));
        Iterable arrayList = new ArrayList();
        if (!TextUtils.isEmpty(locationActivitySharing.c)) {
            String str;
            TimeZone timeZone = TimeZone.getTimeZone(locationActivitySharing.c);
            if (TimeZone.getDefault().getRawOffset() == timeZone.getRawOffset()) {
                str = null;
            } else {
                Date date = new Date(this.f12269g.a());
                DateFormat dateFormat = (DateFormat) this.f12267e.a().clone();
                dateFormat.setTimeZone(timeZone);
                str = dateFormat.format(date);
            }
            String str2 = str;
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
        }
        if (!TextUtils.isEmpty(locationActivitySharing.b)) {
            arrayList.add(locationActivitySharing.b);
        }
        if (!arrayList.isEmpty()) {
            spannableStringBuilder.append("\n");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append(TextUtils.join(" • ", arrayList));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f12265c.getColor(2131361937)), length, spannableStringBuilder.length(), 0);
        }
        return spannableStringBuilder;
    }
}
