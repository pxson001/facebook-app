package com.facebook.places.checkin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.capability.ComposerTagPeopleCapability;
import com.facebook.composer.minutiae.MinutiaeConstants.TargetFragment;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.perf.MinutiaeObjectPickerPerformanceLogger;
import com.facebook.composer.minutiae.util.MinutiaeConfiguration;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.katana.model.GeoRegion.ImplicitLocation;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.places.checkin.analytics.PlacePickerAnalytics;
import com.facebook.places.checkin.composerflows.PeopleToPlaceController;
import com.facebook.places.checkin.composerflows.PlaceToPeopleController;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.utils.FlowLogicTestHelper;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.tagging.conversion.FriendSuggestionsAndSelectorActivity;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: click_blingbar */
public class PlacePickerNavController {
    public PlacePickerFragment f17979a;
    public PlacePickerConfiguration f17980b;
    private ComposerLauncher f17981c;
    public ImplicitLocation f17982d;
    private PlacePickerAnalytics f17983e;
    public String f17984f;
    private PeopleToPlaceController f17985g;
    private PlaceToPeopleController f17986h;
    private ComposerTagPeopleCapability f17987i;
    private Product f17988j;
    private MinutiaeObjectPickerPerformanceLogger f17989k;
    public SearchType f17990l;
    private PerfTestConfig f17991m;
    public CheckinPlaceModel f17992n;
    private Context f17993o;
    private String f17994p;

    public static PlacePickerNavController m21934a(InjectorLike injectorLike) {
        return new PlacePickerNavController((Context) injectorLike.getInstance(Context.class), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), PlacePickerAnalytics.a(injectorLike), PeopleToPlaceController.m3460b(injectorLike), PlaceToPeopleController.m3461b(injectorLike), ComposerTagPeopleCapability.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), MinutiaeObjectPickerPerformanceLogger.a(injectorLike), PerfTestConfig.a(injectorLike));
    }

    @Inject
    public PlacePickerNavController(Context context, ComposerLauncher composerLauncher, PlacePickerAnalytics placePickerAnalytics, PeopleToPlaceController peopleToPlaceController, PlaceToPeopleController placeToPeopleController, ComposerTagPeopleCapability composerTagPeopleCapability, Product product, MinutiaeObjectPickerPerformanceLogger minutiaeObjectPickerPerformanceLogger, PerfTestConfig perfTestConfig) {
        this.f17993o = context;
        this.f17981c = composerLauncher;
        this.f17983e = placePickerAnalytics;
        this.f17985g = peopleToPlaceController;
        this.f17986h = placeToPeopleController;
        this.f17987i = composerTagPeopleCapability;
        this.f17988j = product;
        this.f17989k = minutiaeObjectPickerPerformanceLogger;
        this.f17991m = perfTestConfig;
    }

    public final void m21948a(String str) {
        this.f17994p = str;
        this.f17983e.i = m21941e();
    }

    public final void m21946a(Bundle bundle) {
        if (bundle != null) {
            this.f17992n = (CheckinPlaceModel) FlatBufferModelHelper.a(bundle, "previously_selected_location");
        }
        if (m21945h()) {
            this.f17979a.aq();
            this.f17983e.r();
        } else if (m21944g()) {
            this.f17979a.aq();
            this.f17983e.s();
        }
    }

    public final void m21947a(CheckinPlaceModel checkinPlaceModel) {
        this.f17983e.b(checkinPlaceModel);
        if (m21945h()) {
            this.f17985g.f3526c.m3464a();
            this.f17983e.t();
        } else if (m21944g()) {
            this.f17983e.u();
        }
        Object obj = null;
        if (PerfTestConfigBase.k && !this.f17980b.w && checkinPlaceModel.g() != null && FlowLogicTestHelper.m22091a(checkinPlaceModel, this.f17990l) && !checkinPlaceModel.cf_().equals(this.f17984f) && this.f17980b.s) {
            obj = 1;
        }
        if (obj != null) {
            this.f17984f = checkinPlaceModel.cf_();
            this.f17989k.a();
            this.f17979a.a(m21938c(checkinPlaceModel), 3);
            this.f17983e.h();
            return;
        }
        ComposerConfiguration composerConfiguration = this.f17980b.c;
        boolean z = composerConfiguration != null && ComposerTagPeopleCapability.a(composerConfiguration.getInitialTargetData().targetType, composerConfiguration.isEdit(), composerConfiguration.isEditTagEnabled(), composerConfiguration.getInitialTargetData().actsAsTarget, composerConfiguration.shouldDisableFriendTagging(), null);
        if (this.f17988j == Product.FB4A && (this.f17980b.v || (m21941e() && z))) {
            boolean z2;
            PlaceToPeopleController placeToPeopleController = this.f17986h;
            if (!PerfTestConfigBase.k) {
                z2 = false;
            } else if (placeToPeopleController.f3534d.a()) {
                z2 = true;
            } else {
                z2 = placeToPeopleController.f3533c.m3467c();
            }
            if (z2) {
                Intent f = m21943f(checkinPlaceModel);
                f.putExtra("tag_people_after_checkin_button", true);
                this.f17979a.a(f, 5);
                return;
            }
        }
        m21951b(checkinPlaceModel);
    }

    public final void m21951b(CheckinPlaceModel checkinPlaceModel) {
        if (m21941e()) {
            m21936a(checkinPlaceModel, null, Optional.fromNullable(this.f17980b.m), Absent.INSTANCE);
        } else {
            this.f17979a.m21924a(-1, m21940d(checkinPlaceModel));
        }
    }

    private boolean m21941e() {
        return this.f17980b.i;
    }

    public final boolean m21949a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 3:
                    m21937b(intent);
                    return true;
                case 4:
                    this.f17979a.m21924a(-1, intent);
                    return true;
                case 5:
                    m21939c(intent);
                    return true;
                default:
                    return false;
            }
        } else if (i2 != 0) {
            return false;
        } else {
            switch (i) {
                case 4:
                    Intent intent2 = new Intent();
                    intent2.putExtra("composer_cancelled", true);
                    this.f17979a.m21924a(0, intent2);
                    return true;
                case 5:
                    if (intent != null && intent.hasExtra("extra_place")) {
                        this.f17992n = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place");
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    private void m21936a(@Nullable CheckinPlace checkinPlace, @Nullable String str, Optional<MinutiaeObject> optional, Optional<ImmutableList<ComposerTaggedUser>> optional2) {
        Builder a = ComposerConfiguration.a(this.f17980b.c);
        ComposerLocationInfo.Builder newBuilder = ComposerLocationInfo.newBuilder();
        newBuilder.d = true;
        if (checkinPlace != null) {
            newBuilder.b(checkinPlace);
        }
        if (str != null) {
            newBuilder.a(str);
        }
        a.setInitialLocationInfo(newBuilder.b());
        if (optional.isPresent()) {
            a.setMinutiaeObjectTag((MinutiaeObject) optional.get());
        }
        if (optional2.isPresent()) {
            a.setInitialTaggedUsers((ImmutableList) optional2.get());
        }
        this.f17981c.a(this.f17980b.e, a.a(), 4, this.f17979a);
    }

    private Intent m21938c(CheckinPlaceModel checkinPlaceModel) {
        Context context = this.f17993o;
        String str = this.f17994p;
        MinutiaeConfiguration.Builder a = MinutiaeConfiguration.b().a(checkinPlaceModel);
        a.b = TargetFragment.OBJECT_PICKER;
        a = a;
        a.a = str;
        a = a;
        a.g = false;
        return a.a(context);
    }

    private Intent m21940d(CheckinPlaceModel checkinPlaceModel) {
        Intent intent = new Intent();
        FlatBufferModelHelper.a(intent, "extra_place", checkinPlaceModel);
        if (this.f17982d != null) {
            intent.putExtra("extra_implicit_location", this.f17982d);
        }
        m21935a(intent);
        return intent;
    }

    private Intent m21942f() {
        Intent intent = new Intent();
        m21935a(intent);
        return intent;
    }

    private void m21935a(Intent intent) {
        if (!this.f17980b.q.isEmpty()) {
            Serializable arrayList = new ArrayList();
            ImmutableList immutableList = this.f17980b.q;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ComposerTaggedUser composerTaggedUser = (ComposerTaggedUser) immutableList.get(i);
                arrayList.add(new FacebookProfile(composerTaggedUser.a(), composerTaggedUser.b(), composerTaggedUser.c(), 0));
            }
            intent.putExtra("full_profiles", arrayList);
        }
        if (!this.f17980b.r.isEmpty()) {
            intent.putExtra("profiles", new ArrayList(this.f17980b.r));
        }
        if (this.f17980b.m != null) {
            intent.putExtra("minutiae_object", this.f17980b.m);
        }
        if (this.f17980b.l != null) {
            intent.putExtra("media_id", this.f17980b.l);
        }
        if (this.f17980b.b != null) {
            intent.putExtra("comment_id", this.f17980b.b);
        }
        if (this.f17980b.j != null) {
            intent.putExtra("launcher_type", this.f17980b.j);
        }
    }

    private void m21937b(Intent intent) {
        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place");
        if (m21941e()) {
            m21936a(checkinPlaceModel, null, Optional.fromNullable((MinutiaeObject) intent.getParcelableExtra("minutiae_object")), Absent.INSTANCE);
            return;
        }
        Intent d = m21940d(checkinPlaceModel);
        if (this.f17980b.m != null) {
            d.putExtra("minutiae_object", this.f17980b.m);
        }
        this.f17979a.m21924a(-1, intent);
    }

    private void m21939c(Intent intent) {
        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place");
        if (m21941e()) {
            List<FacebookProfile> parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_tagged_profiles");
            ImmutableList.Builder builder = ImmutableList.builder();
            for (FacebookProfile facebookProfile : parcelableArrayListExtra) {
                ComposerTaggedUser.Builder a = ComposerTaggedUser.a(facebookProfile.mId);
                a.b = facebookProfile.mDisplayName;
                a = a;
                a.c = facebookProfile.mImageUrl;
                builder.c(a.a());
            }
            m21936a(checkinPlaceModel, null, Optional.fromNullable(this.f17980b.m), Optional.fromNullable(builder.b()));
            return;
        }
        m21935a(intent);
        intent.putExtra("tag_people_after_tag_place", true);
        this.f17979a.m21924a(-1, intent);
    }

    public final void m21952b(String str) {
        if (m21941e()) {
            m21936a(null, str, Optional.fromNullable(this.f17980b.m), Absent.INSTANCE);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("text_only_place", str);
        if (this.f17982d != null) {
            intent.putExtra("extra_implicit_location", this.f17982d);
        }
        m21935a(intent);
        this.f17979a.m21924a(-1, intent);
    }

    public final void m21953c(String str) {
        Intent intent = new Intent();
        if (this.f17980b.m != null) {
            intent.putExtra("minutiae_object", this.f17980b.m);
        }
        intent.putExtra("extra_location_text", StringUtil.c(str.trim().toLowerCase()));
        this.f17979a.m21924a(-1, intent);
    }

    public final void m21950b() {
        if (m21945h()) {
            this.f17985g.f3526c.m3466b();
            this.f17983e.v();
        } else if (m21944g()) {
            this.f17983e.w();
        }
        this.f17979a.m21924a(-1, m21942f());
    }

    private Intent m21943f(CheckinPlaceModel checkinPlaceModel) {
        Intent a = FriendSuggestionsAndSelectorActivity.m10811a(this.f17993o, new HashSet());
        FlatBufferModelHelper.a(a, "extra_place", checkinPlaceModel);
        a.putExtra("from_checkin", m21941e());
        if (this.f17980b.m != null) {
            a.putExtra("minutiae_object", this.f17980b.m);
        }
        if (this.f17982d != null) {
            a.putExtra("extra_implicit_location", this.f17982d);
        }
        Collection collection = this.f17980b.n;
        if (collection != null) {
            a.putStringArrayListExtra("people_tagging_metadata", new ArrayList(collection));
        }
        return a;
    }

    public final boolean m21954c() {
        return this.f17980b.x || this.f17980b.w;
    }

    private boolean m21944g() {
        return this.f17980b.w;
    }

    private boolean m21945h() {
        return this.f17980b.x;
    }
}
