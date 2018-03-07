package com.facebook.pages.common.editpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryInterfaces.SectionsCanAddData;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: showsUserLocation */
public class EditPageNavigationUtil {
    public final Context f1568a;
    public final SecureContextHelper f1569b;
    public final UriIntentMapper f1570c;

    public static EditPageNavigationUtil m2255b(InjectorLike injectorLike) {
        return new EditPageNavigationUtil((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public EditPageNavigationUtil(Context context, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f1568a = context;
        this.f1569b = secureContextHelper;
        this.f1570c = uriIntentMapper;
    }

    public static void m2253a(Activity activity, GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        Intent intent = new Intent();
        intent.putExtra("extra_go_to_section_type", graphQLPagePresenceTabType);
        activity.setResult(-1, intent);
        activity.finish();
    }

    public static void m2254a(FragmentManager fragmentManager, int i, long j, SectionsCanAddData sectionsCanAddData) {
        FragmentTransaction a = fragmentManager.a().a(2130968748, 2130968757, 2130968747, 2130968758);
        Preconditions.checkState(j > 0);
        Preconditions.checkNotNull(sectionsCanAddData);
        Bundle bundle = new Bundle();
        bundle.putLong("com.facebook.katana.profile.id", j);
        FlatBufferModelHelper.a(bundle, "sections_can_add_data", sectionsCanAddData);
        AddSectionFragment addSectionFragment = new AddSectionFragment();
        addSectionFragment.g(bundle);
        a.b(i, addSectionFragment).a(null).b();
    }

    public static void m2256b(FragmentManager fragmentManager, int i, long j, SectionsCanAddData sectionsCanAddData) {
        FragmentTransaction a = fragmentManager.a().a(2130968748, 2130968757, 2130968747, 2130968758);
        Preconditions.checkState(j > 0);
        Preconditions.checkNotNull(sectionsCanAddData);
        Bundle bundle = new Bundle();
        bundle.putLong("com.facebook.katana.profile.id", j);
        FlatBufferModelHelper.a(bundle, "sections_can_add_data", sectionsCanAddData);
        AddSectionFragmentV2 addSectionFragmentV2 = new AddSectionFragmentV2();
        addSectionFragmentV2.g(bundle);
        a.b(i, addSectionFragmentV2).a(null).b();
    }
}
