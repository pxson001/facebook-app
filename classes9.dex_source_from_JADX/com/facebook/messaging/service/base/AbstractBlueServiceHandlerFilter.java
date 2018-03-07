package com.facebook.messaging.service.base;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Filter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;

/* compiled from: mfpsRanges */
public abstract class AbstractBlueServiceHandlerFilter implements Filter {
    private final String f9464a;

    protected abstract OperationResult mo337A(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo338B(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo339C(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo340D(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo341E(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo342F(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo343G(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo344H(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo345I(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo346J(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo347K(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo348L(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo349M(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo350N(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo351O(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo352P(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo353Q(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo354R(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo355b(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo356c(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo357d(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo358e(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo359f(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo360g(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo361h(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo362i(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo363j(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo364k(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo365l(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo366m(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo367n(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo368o(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo369p(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo370q(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo371r(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo372s(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo373t(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo374u(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo375v(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo376w(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo377x(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo378y(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected abstract OperationResult mo379z(OperationParams operationParams, BlueServiceHandler blueServiceHandler);

    protected AbstractBlueServiceHandlerFilter(String str) {
        this.f9464a = str;
    }

    public OperationResult m9966a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        TracerDetour.a("%s_handleOperation_%s", new Object[]{this.f9464a, operationParams.a()}, 1075633965);
        try {
            OperationResult a;
            String a2 = operationParams.a();
            if ("init_threads_queue".equals(a2)) {
                a = OperationResult.a();
            } else if ("fetch_thread_list".equals(a2)) {
                a = mo355b(operationParams, blueServiceHandler);
                TracerDetour.a(10, 1606344992);
            } else if ("fetch_more_threads".equals(a2)) {
                a = mo356c(operationParams, blueServiceHandler);
                TracerDetour.a(10, -125261649);
            } else if ("fetch_thread".equals(a2)) {
                a = mo357d(operationParams, blueServiceHandler);
                TracerDetour.a(10, 525262151);
            } else if ("fetch_thread_by_participants".equals(a2)) {
                a = mo358e(operationParams, blueServiceHandler);
                TracerDetour.a(10, -102759756);
            } else if ("add_members".equals(a2)) {
                a = mo359f(operationParams, blueServiceHandler);
                TracerDetour.a(10, 1598095765);
            } else if ("create_thread".equals(a2)) {
                a = mo361h(operationParams, blueServiceHandler);
                TracerDetour.a(10, -1846013328);
            } else if ("create_group".equals(a2)) {
                a = mo360g(operationParams, blueServiceHandler);
                TracerDetour.a(10, -206099852);
            } else if ("fetch_more_messages".equals(a2)) {
                a = mo362i(operationParams, blueServiceHandler);
                TracerDetour.a(10, -874417816);
            } else if ("remove_member".equals(a2)) {
                a = mo363j(operationParams, blueServiceHandler);
                TracerDetour.a(10, 1529519622);
            } else if ("mark_threads".equals(a2)) {
                a = mo364k(operationParams, blueServiceHandler);
                TracerDetour.a(10, -2092010992);
            } else if ("block_user".equals(a2)) {
                a = mo365l(operationParams, blueServiceHandler);
                TracerDetour.a(10, -2038193837);
            } else if ("delete_threads".equals(a2)) {
                a = mo366m(operationParams, blueServiceHandler);
                TracerDetour.a(10, -1529616166);
            } else if ("delete_all_tincan_threads".equals(a2)) {
                a = mo367n(operationParams, blueServiceHandler);
                TracerDetour.a(10, -1736783666);
            } else if ("delete_messages".equals(a2)) {
                a = mo368o(operationParams, blueServiceHandler);
                TracerDetour.a(10, -20087907);
            } else if ("modify_thread".equals(a2)) {
                a = mo369p(operationParams, blueServiceHandler);
                TracerDetour.a(10, 1318031027);
            } else if ("mark_folder_seen".equals(a2)) {
                a = mo370q(operationParams, blueServiceHandler);
                TracerDetour.a(10, -1109386699);
            } else if ("save_draft".equals(a2)) {
                a = mo371r(operationParams, blueServiceHandler);
                TracerDetour.a(10, -1661880816);
            } else if ("pushed_message".equals(a2)) {
                a = mo372s(operationParams, blueServiceHandler);
                TracerDetour.a(10, -1345711513);
            } else if ("update_user_settings".equals(a2)) {
                a = mo373t(operationParams, blueServiceHandler);
                TracerDetour.a(10, -297388690);
            } else if ("read_receipt".equals(a2)) {
                a = mo374u(operationParams, blueServiceHandler);
                TracerDetour.a(10, 2049686872);
            } else if ("search_thread_name_and_participants".equals(a2)) {
                a = mo375v(operationParams, blueServiceHandler);
                TracerDetour.a(10, -4752056);
            } else if ("fetch_pinned_threads".equals(a2)) {
                a = mo376w(operationParams, blueServiceHandler);
                TracerDetour.a(10, -1996324423);
            } else if ("update_pinned_threads".equals(a2)) {
                a = mo377x(operationParams, blueServiceHandler);
                TracerDetour.a(10, 1880048145);
            } else if ("add_pinned_thread".equals(a2)) {
                a = mo378y(operationParams, blueServiceHandler);
                TracerDetour.a(10, 1929876468);
            } else if ("unpin_thread".equals(a2)) {
                a = mo379z(operationParams, blueServiceHandler);
                TracerDetour.a(10, 280850020);
            } else if ("get_authenticated_attachment_url".equals(a2)) {
                a = mo337A(operationParams, blueServiceHandler);
                TracerDetour.a(10, 1108340939);
            } else if ("fetch_bootstrapping_delivery_receipts".equals(a2)) {
                a = mo338B(operationParams, blueServiceHandler);
                TracerDetour.a(10, 302245552);
            } else if ("update_failed_message".equals(a2)) {
                a = mo339C(operationParams, blueServiceHandler);
                TracerDetour.a(10, -160920139);
            } else if ("add_montage_viewer".equals(a2)) {
                a = mo340D(operationParams, blueServiceHandler);
                TracerDetour.a(10, -1078364106);
            } else if ("remove_montage_viewer".equals(a2)) {
                a = mo341E(operationParams, blueServiceHandler);
                TracerDetour.a(10, -886138277);
            } else if ("message_accept_requests".equals(a2)) {
                a = mo342F(operationParams, blueServiceHandler);
                TracerDetour.a(10, -1490531997);
            } else if ("message_ignore_requests".equals(a2)) {
                a = mo343G(operationParams, blueServiceHandler);
                TracerDetour.a(10, 2048816751);
            } else if ("create_local_admin_message".equals(a2)) {
                a = mo344H(operationParams, blueServiceHandler);
                TracerDetour.a(10, 103255229);
            } else if ("received_sms".equals(a2)) {
                a = mo345I(operationParams, blueServiceHandler);
                TracerDetour.a(10, -1071646335);
            } else if ("group_invite_link".equals(a2)) {
                a = mo346J(operationParams, blueServiceHandler);
                TracerDetour.a(10, -1320771702);
            } else if ("update_folder_counts".equals(a2)) {
                a = mo347K(operationParams, blueServiceHandler);
                TracerDetour.a(10, 479793745);
            } else if ("add_admins_to_group".equals(a2)) {
                a = mo348L(operationParams, blueServiceHandler);
                TracerDetour.a(10, -2104507511);
            } else if ("remove_admins_from_group".equals(a2)) {
                a = mo349M(operationParams, blueServiceHandler);
                TracerDetour.a(10, 922012728);
            } else if ("post_game_score".equals(a2)) {
                a = mo350N(operationParams, blueServiceHandler);
                TracerDetour.a(10, 1042190866);
            } else if ("save_username".equals(a2)) {
                a = mo351O(operationParams, blueServiceHandler);
                TracerDetour.a(10, 1099523964);
            } else if ("fetch_thread_queue_enabled".equals(a2)) {
                a = mo352P(operationParams, blueServiceHandler);
                TracerDetour.a(10, -2026204075);
            } else if ("fetch_event_reminders_members".equals(a2)) {
                a = mo353Q(operationParams, blueServiceHandler);
                TracerDetour.a(10, -2081641117);
            } else if ("fetch_tincan_identity_keys".equals(a2)) {
                a = mo354R(operationParams, blueServiceHandler);
                TracerDetour.a(10, 145722601);
            } else {
                a = blueServiceHandler.a(operationParams);
                TracerDetour.a(10, 1153088025);
            }
            return a;
        } finally {
            TracerDetour.a(10, -1858279873);
        }
    }
}
