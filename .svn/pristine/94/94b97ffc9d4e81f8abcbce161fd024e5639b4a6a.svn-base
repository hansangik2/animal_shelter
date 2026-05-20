document.addEventListener("DOMContentLoaded", function () {
    const ctp = document.body.dataset.ctp || "";

    // 신청 행 클릭 시 신청 동기 토글
    document.querySelectorAll(".apply-row").forEach(row => {
        row.addEventListener("click", function (e) {
            if (e.target.closest(".action-btn")) return;
            const detailRow = document.getElementById(this.dataset.target);
            if (detailRow) detailRow.classList.toggle("is-open");
        });
    });

    // 승인 / 반려 버튼 클릭
    document.querySelectorAll(".action-btn").forEach(button => {
        button.addEventListener("click", function (e) {
            e.stopPropagation();

            const volunteerId = this.dataset.id;
            const status      = this.dataset.status;

            // 승인은 기존 GET 방식 그대로
            if (status === "승인") {
                if (!confirm("해당 신청자를 승인하시겠습니까?")) return;
                location.href = ctp + "/admin/volunteer/status.do"
                    + "?volunteerId=" + encodeURIComponent(volunteerId)
                    + "&status="      + encodeURIComponent(status);

            // 반려는 사유 입력 모달 오픈
            } else if (status === "반려") {
                openRejectModal(volunteerId);
            }
        });
    });

    // ── 반려 모달 관련 ──────────────────────────────────
    const rejectModal       = document.getElementById("rejectModal");
    const rejectInput       = document.getElementById("rejectReasonInput");
    const rejectVolunteerId = document.getElementById("rejectVolunteerId");

    // 모달 열기
    function openRejectModal(volunteerId) {
        rejectVolunteerId.value = volunteerId;
        rejectInput.value = "";
        rejectModal.classList.add("active");
    }

    // 모달 닫기
    window.closeRejectModal = function () {
        rejectModal.classList.remove("active");
    };

    // 반려 확인 → POST AJAX
    window.confirmReject = function () {
        const volunteerId  = rejectVolunteerId.value;
        const rejectReason = rejectInput.value.trim();

        if (!rejectReason) {
            alert("반려 사유를 입력해주세요.");
            rejectInput.focus();
            return;
        }

        fetch(ctp + "/admin/volunteer/status.do", {
            method: "POST",
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
            body: "volunteerId="   + encodeURIComponent(volunteerId)
                + "&status="       + encodeURIComponent("반려")
                + "&rejectReason=" + encodeURIComponent(rejectReason)
        })
        .then(res => res.json())
        .then(data => {
            if (data.success) {
                alert("반려 처리되었습니다.");
                closeRejectModal();
                location.reload();
            } else {
                alert("처리 중 오류가 발생했습니다.");
            }
        })
        .catch(err => {
            console.error(err);
            alert("처리 중 오류가 발생했습니다.");
        });
    };
});