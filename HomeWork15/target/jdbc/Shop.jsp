<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.step.name.service.UtilsForShop" %>
<%@ page import="com.step.name.model.User" %>

<html lang=\"en\">
<head>
    <meta charset=\"UTF-8\">
    <title>Shop</title>
    <style> ol {
        padding: 0;
        margin-left: 50%;
    }
    </style>
</head>
<body>
<h1 align="center">Hello
    <%=((User) request.getSession().getAttribute("user")).getName()%>!</h1>
<form action="/Shop.jsp" method="post">
    <p align="center">
        <label>
          <select name="select" size="1">
                          <c:forEach var="item" items="${goods}">
                              <option>
                                  <c:out value="${item.getTitle()}"/>
                                  <c:out value="${item.getPrice()}"/>$
                              </option>
                          </c:forEach>
           </select>
            <input type="submit" value="Add item">
          </form>
          <form action="/PayPage.jsp" method="post">
            <h1>   </h1>
             <p align="center"><input type="submit" value="Submit"></p>
          </form>
        <label>

    </p>
</form>
</body>
</html>