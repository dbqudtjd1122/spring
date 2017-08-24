<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<table style="clear: both;">
    <tr>
        <th style="width: 60px">NO</th>
        <th>TITLE</th>
        <th style="width: 84px;">DATE</th>
        <th style="width: 60px;">HIT</th>
    </tr>
    
    <!--  반복 구간 시작 -->
    <c:forEach var="article" items="${list }" varStatus="status">
    <tr>
        <td style="text-align: center;">
            <c:choose>
                <c:when test="${articleno == article.articleno }">
                    <img src="/resources/images/arrow.gif" alt="현재글" />
                </c:when>
                <c:otherwise>
                    ${no - status.index }
                </c:otherwise>
            </c:choose>
        </td>
        <td>
            <a href="javascript:goView('${article.articleno }')">${article.title }</a>
            <c:if test="${article.attachfileNum > 0 }">
                <img src="/resources/images/attach.png" alt="첨부파일" />
            </c:if>
            <c:if test="${article.commentNum > 0 }">
                <span class="bbs-strong">[${article.commentNum }]</span>
            </c:if>
        </td>
        <td style="text-align: center;"><fmt:formatDate pattern="yyyy-MM-dd" value="${article.regdate }" /></td>
        <td style="text-align: center;">${article.hit }</td>
    </tr>
    </c:forEach>
    <!--  반복 구간 끝 -->
</table>
                         
<div id="paging" style="text-align: center;">  
    <c:if test="${totalFirstPage > 0 }">
        <span pageno="${totalFirstPage }">[처음]</span> 
    </c:if>                  
    <c:if test="${prevLink > 0 }">
        <span pageno="${prevLink}">[이전]</span>
    </c:if>
    <c:forEach var="i" items="${pageLinks }" varStatus="stat">
        <c:choose>
            <c:when test="${curPage == i}">
                <span class="bbs-strong">${i }</span>
            </c:when>
            <c:otherwise>
                <span pageno="${i }">${i }</span>
            </c:otherwise>
        </c:choose>
    </c:forEach>    
    <c:if test="${nextLink > 0 }">
        <span pageno="${nextLink }">[다음]</span>
    </c:if> 
    <c:if test="${totalLastPage> 0 }"> 
        <span pageno="${totalLastPage}">[마지막]</span>
    </c:if>                        
</div>

<div id="list-menu" style="text-align:  right;" class="gowrite">
    <input type="button" value="새글쓰기"  />
</div>

<div id="search" style="text-align: center;">
    <form id="searchForm" action="./articlelist" method="get" style="margin: 0;padding: 0;">
        <p style="margin: 0;padding: 0;">
            <input type="hidden" name="boardcd" value="${boardcd }" />
            <input type="text" name="searchWord" size="15" maxlength="30" />
            <input type="submit" value="검색" />
        </p>    
    </form>
</div>