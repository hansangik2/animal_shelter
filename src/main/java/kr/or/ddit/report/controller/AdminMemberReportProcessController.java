package kr.or.ddit.report.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.report.service.IReportService;
import kr.or.ddit.report.service.ReportServiceImpl;

@WebServlet("/admin/report/member.do")
public class AdminMemberReportProcessController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        // 관리자 권한 체크
        MemberVO loginUser = (MemberVO) req.getSession().getAttribute("loginUser");
        if (loginUser == null || !"ADMIN".equals(loginUser.getRole())) {
            out.print("{\"success\":false,\"message\":\"권한이 없습니다.\"}");
            return;
        }

        try {
            int    reportId = Integer.parseInt(req.getParameter("reportId"));
            String action   = req.getParameter("action"); // Y=완료, R=기각

            IReportService service = ReportServiceImpl.getservice();
            boolean result = service.updateMemberReportStatus(reportId, action);

            if (result) {
                out.print("{\"success\":true}");
            } else {
                out.print("{\"success\":false,\"message\":\"처리에 실패했습니다.\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"success\":false,\"message\":\"오류가 발생했습니다.\"}");
        }
    }
}