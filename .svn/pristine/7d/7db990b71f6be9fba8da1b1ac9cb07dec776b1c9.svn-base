<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>너와 나의 연결고리 - 메인</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctp}/css/common/common.css">
    <link rel="stylesheet" href="${ctp}/css/mainpage.css">
</head>
<body>

<jsp:include page="/view/common/header.jsp" />

<main class="main-page">

    <%-- 1. 히어로 배너 --%>
    <section class="hero-section">
        <div class="hero-bg">
            <img src="${ctp}/images/main-hero.jpg" alt="메인 배너" class="hero-bg__img">
            <div class="hero-bg__overlay"></div>
        </div>
        <div class="layout-container hero-content">
            <div class="hero-text">
                <span class="hero-badge">
                    <span class="material-symbols-outlined">pets</span>
                    ADOPT · VOLUNTEER · DONATE
                </span>
                <h1 class="hero-title">
                    사랑으로 잇는<br>
                    <em>너와 나의</em> 연결고리
                </h1>
                <p class="hero-desc">
                    유기동물에게 따뜻한 가족이 되어주세요.<br>
                    여러분의 작은 관심이 생명을 살리는 기적이 됩니다.
                </p>
                <div class="hero-btns">
                    <a href="${ctp}/animal/animalList.do" class="hero-btn hero-btn--primary">
                        <span class="material-symbols-outlined">pets</span>입양하기
                    </a>
                    <a href="${ctp}/donation/form.do" class="hero-btn hero-btn--ghost">
                        <span class="material-symbols-outlined">favorite</span>후원하기
                    </a>
                </div>
            </div>
            <div class="hero-stats">
                <div class="hero-stat-card">
                    <span class="hero-stat-card__num">${not empty totalAnimalCount ? totalAnimalCount : '0'}</span>
                    <span class="hero-stat-card__label">보호 중인 동물</span>
                </div>
                <div class="hero-stat-card">
                    <span class="hero-stat-card__num">${not empty totalAdoptionCount ? totalAdoptionCount : '0'}</span>
                    <span class="hero-stat-card__label">입양 완료</span>
                </div>
                <div class="hero-stat-card">
                    <span class="hero-stat-card__num">${not empty totalVolunteerCount ? totalVolunteerCount : '0'}</span>
                    <span class="hero-stat-card__label">봉사 참여자</span>
                </div>
            </div>
        </div>
        <div class="hero-scroll-hint">
            <span class="material-symbols-outlined">keyboard_arrow_down</span>
        </div>
    </section>

    <%-- 2. 퀵 내비 바 --%>
    <section class="quick-nav-section">
        <div class="layout-container">
            <div class="quick-nav-grid">
                <a href="${ctp}/animal/animalList.do" class="quick-nav-item">
                    <div class="quick-nav-item__icon quick-nav-item__icon--orange">
                        <span class="material-symbols-outlined">pets</span>
                    </div>
                    <span>입양하기</span>
                </a>
                <a href="${ctp}/volunteer/list.do" class="quick-nav-item">
                    <div class="quick-nav-item__icon quick-nav-item__icon--green">
                        <span class="material-symbols-outlined">volunteer_activism</span>
                    </div>
                    <span>봉사하기</span>
                </a>
                <a href="${ctp}/donation/form.do" class="quick-nav-item">
                    <div class="quick-nav-item__icon quick-nav-item__icon--pink">
                        <span class="material-symbols-outlined">favorite</span>
                    </div>
                    <span>후원하기</span>
                </a>
                <a href="${ctp}/board/free.do" class="quick-nav-item">
                    <div class="quick-nav-item__icon quick-nav-item__icon--blue">
                        <span class="material-symbols-outlined">forum</span>
                    </div>
                    <span>커뮤니티</span>
                </a>
                <a href="${ctp}/animal/guide.do" class="quick-nav-item">
                    <div class="quick-nav-item__icon quick-nav-item__icon--purple">
                        <span class="material-symbols-outlined">menu_book</span>
                    </div>
                    <span>입양가이드</span>
                </a>
            </div>
        </div>
    </section>

    <%-- 3. 인기 동물 슬라이더 (풀width) --%>
    <section class="animal-section">
        <div class="layout-container">
            <div class="section-block__head" style="margin-bottom:20px;">
                <h2 class="section-block__title">
                    <span class="material-symbols-outlined">star</span>
                    이번주 인기 동물
                </h2>
                <a href="${ctp}/animal/animalList.do" class="section-block__more">
                    전체보기<span class="material-symbols-outlined">chevron_right</span>
                </a>
            </div>
            <div class="animal-slider">
                <button class="animal-slider__btn" id="animalPrev">
                    <span class="material-symbols-outlined">chevron_left</span>
                </button>
                <div class="animal-slider__track-wrap">
                    <div class="animal-slider__track" id="animalTrack">
                        <c:choose>
                            <c:when test="${empty popularAnimals}">
                                <div class="slider-empty">
                                    <span class="material-symbols-outlined">pets</span>
                                    <p>등록된 동물이 없습니다.</p>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="animal" items="${popularAnimals}">
                                    <a href="${ctp}/animal/animalDetail.do?animalId=${animal.animalId}" class="animal-card">
                                        <div class="animal-card__img-wrap">
                                            <c:choose>
                                                <c:when test="${not empty animal.mainImage}">
                                                    <img src="${ctp}/animal/image?fileName=${animal.mainImage}" alt="${animal.animalName}">
                                                </c:when>
                                                <c:otherwise>
                                                    <img src="${ctp}/images/default-animal.png" alt="기본 이미지">
                                                </c:otherwise>
                                            </c:choose>
                                            <span class="animal-card__emoji">${animal.animalType eq 'DOG' ? '🐶' : '🐱'}</span>
                                        </div>
                                        <div class="animal-card__info">
                                            <h3>${animal.animalName}</h3>
                                            <p>${animal.breed}</p>
                                            <div class="animal-card__meta">
                                                <span><span class="material-symbols-outlined">visibility</span>${animal.viewCount}</span>
                                                <span><span class="material-symbols-outlined">favorite</span>${animal.favoriteCount}</span>
                                            </div>
                                        </div>
                                    </a>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <button class="animal-slider__btn" id="animalNext">
                    <span class="material-symbols-outlined">chevron_right</span>
                </button>
            </div>
        </div>
    </section>

    <%-- 4. 메인 콘텐츠: 좌(봉사+후원왕) + 우측 sticky 인기글 --%>
    <section class="main-content-section">
        <div class="layout-container main-layout">

            <%-- 좌: 봉사활동 + 후원왕 --%>
            <div class="main-left">

                <%-- 봉사활동 모집 중 --%>
                <div class="section-block">
                    <div class="section-block__head">
                        <h2 class="section-block__title">
                            <span class="material-symbols-outlined">volunteer_activism</span>
                            봉사활동 모집 중
                        </h2>
                        <a href="${ctp}/volunteer/list.do" class="section-block__more">
                            전체보기<span class="material-symbols-outlined">chevron_right</span>
                        </a>
                    </div>
                    <div class="volunteer-list">
                        <c:choose>
                            <c:when test="${empty popularVolunteers}">
                                <div class="list-empty">
                                    <span class="material-symbols-outlined">event_busy</span>
                                    <p>모집 중인 봉사활동이 없습니다.</p>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="vol" items="${popularVolunteers}">
                                    <a href="${ctp}/volunteer/detail.do?recruitId=${vol.recruitId}" class="volunteer-card">
                                        <div class="volunteer-card__thumb">
                                            <c:choose>
                                                <c:when test="${not empty vol.thumbnailImg}">
                                                    <img src="${ctp}/volunteer/image?fileName=${vol.thumbnailImg}" alt="${vol.title}">
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="volunteer-card__thumb-default">
                                                        <span class="material-symbols-outlined">volunteer_activism</span>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="volunteer-card__info">
                                            <span class="volunteer-card__status">모집중</span>
                                            <h3>${vol.title}</h3>
                                            <div class="volunteer-card__meta">
                                                <span><span class="material-symbols-outlined">calendar_today</span>${vol.volunteerDate}</span>
                                                <span><span class="material-symbols-outlined">location_on</span>${vol.location}</span>
                                            </div>
                                        </div>
                                        <span class="material-symbols-outlined volunteer-card__arrow">chevron_right</span>
                                    </a>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>



            <%-- 우: sticky 인기글 사이드바 --%>
            <div class="main-right">
                <div class="sticky-sidebar">
                    <div class="section-block">
                        <div class="section-block__head">
                            <h2 class="section-block__title">
                                <span class="material-symbols-outlined">local_fire_department</span>
                                이번주 인기글
                            </h2>
                            <a href="${ctp}/board/free.do" class="section-block__more">
                                더보기<span class="material-symbols-outlined">chevron_right</span>
                            </a>
                        </div>
                        <div class="popular-board-list">
                            <c:choose>
                                <c:when test="${empty popularBoards}">
                                    <div class="list-empty">
                                        <span class="material-symbols-outlined">article</span>
                                        <p>인기글이 없습니다.</p>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="board" items="${popularBoards}" varStatus="st">
                                        <a href="${ctp}/board/detail.do?boardId=${board.boardId}" class="popular-board-item">
                                            <span class="popular-board-item__rank ${st.index lt 3 ? 'top' : ''}">${st.index + 1}</span>
                                            <div class="popular-board-item__body">
                                                <span class="popular-board-item__type">${board.boardType}</span>
                                                <p class="popular-board-item__title">${board.title}</p>
                                                <div class="popular-board-item__meta">
                                                    <span><span class="material-symbols-outlined">visibility</span>${board.viewCount}</span>
                                                    <span><span class="material-symbols-outlined">thumb_up</span>${board.likeCount}</span>
                                                </div>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>

</main>

<jsp:include page="/view/common/footer.jsp" />

<script>
(function () {
    const track = document.getElementById('animalTrack');
    const prev  = document.getElementById('animalPrev');
    const next  = document.getElementById('animalNext');
    if (!track || !prev || !next) return;
    let idx = 0;
    function cardW() {
        const c = track.querySelector('.animal-card');
        return c ? c.offsetWidth + 16 : 176;
    }
    function maxIdx() {
        const total   = track.querySelectorAll('.animal-card').length;
        const visible = Math.floor(track.parentElement.offsetWidth / cardW());
        return Math.max(0, total - visible);
    }
    function move() { track.style.transform = 'translateX(-' + (idx * cardW()) + 'px)'; }
    prev.addEventListener('click', function () { if (idx > 0)        { idx--; move(); } });
    next.addEventListener('click', function () { if (idx < maxIdx()) { idx++; move(); } });
})();
</script>

</body>
</html>
