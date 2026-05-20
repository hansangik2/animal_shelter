package kr.or.ddit.report.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.report.dao.IReportDao;
import kr.or.ddit.report.dao.ReportDaoImpl;
import kr.or.ddit.report.vo.AnimalReportVO;
import kr.or.ddit.report.vo.MemberReportVO;
import kr.or.ddit.util.MybatisUtil;

public class ReportServiceImpl implements IReportService {

    private static IReportService service = new ReportServiceImpl();
    private IReportDao dao;

    private ReportServiceImpl() { dao = ReportDaoImpl.getdao(); }

    public static IReportService getservice() { return service; }

    // ========================= 유기동물 제보 =========================

    @Override
    public int insertAnimalReport(AnimalReportVO vo) {
        int cnt = 0;
        try (SqlSession session = MybatisUtil.getsqlsession(false)) {
            cnt = dao.insertAnimalReport(session, vo);
            if (cnt > 0) session.commit();
            else         session.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnt;
    }

    @Override
    public List<AnimalReportVO> selectAnimalReportList() {
        try (SqlSession session = MybatisUtil.getsqlsession()) {
            return dao.selectAnimalReportList(session);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int selectAnimalReportCount() {
        try (SqlSession session = MybatisUtil.getsqlsession()) {
            return dao.selectAnimalReportCount(session);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int selectAnimalPendingCount() {
        try (SqlSession session = MybatisUtil.getsqlsession()) {
            return dao.selectAnimalPendingCount(session);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean updateAnimalReportProcess(int reportId, String processYn) {
        boolean isSuccess = false;
        try (SqlSession session = MybatisUtil.getsqlsession(false)) {
            int cnt = dao.updateAnimalReportProcess(session, reportId, processYn);
            if (cnt > 0) { session.commit(); isSuccess = true; }
            else           session.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    // ========================= 회원 신고 =========================

    @Override
    public int insertMemberRepor(MemberReportVO vo) {
        int cnt = 0;
        try (SqlSession session = MybatisUtil.getsqlsession(false)) {
            cnt = dao.insertMemberRepor(session, vo);
            if (cnt > 0) session.commit();
            else         session.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnt;
    }

    @Override
    public List<MemberReportVO> selectMemberReportList() {
        try (SqlSession session = MybatisUtil.getsqlsession()) {
            return dao.selectMemberReportList(session);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int selectMemberReportCount() {
        try (SqlSession session = MybatisUtil.getsqlsession()) {
            return dao.selectMemberReportCount(session);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int selectMemberPendingCount() {
        try (SqlSession session = MybatisUtil.getsqlsession()) {
            return dao.selectMemberPendingCount(session);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean updateMemberReportStatus(int reportId, String status) {
        boolean isSuccess = false;
        try (SqlSession session = MybatisUtil.getsqlsession(false)) {
            int cnt = dao.updateMemberReportStatus(session, reportId, status);
            if (cnt > 0) { session.commit(); isSuccess = true; }
            else           session.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}