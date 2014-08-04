<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Add Company Result</title>
</head>
<body>
<h2>Company successfully added</h2>

<div>
    <h3>General Company Info</h3>

    <div>
        <table>
            <tr>
                <td>Company Code:</td>
                <td>${company.companyCode}</td>
            </tr>
            <tr>
                <td>Company Name:</td>
                <td>${company.companyName}</td>
            </tr>
        </table>
    </div>
</div>
<div>
    <h3>Stock Info</h3>

    <div>
        <table>
            <tr>
                <td>Stock Code:</td>
                <td>${company.stock.stockCode}</td>
            </tr>
            <tr>
                <td>Stock Name:</td>
                <td>${company.stock.stockName}</td>
            </tr>
            <tr>
                <td>Stock Value:</td>
                <td>${company.stock.stockValue}</td>
            </tr>
        </table>
    </div>
</div>
<div>
    <script type="text/javascript">
        var numberOfEmployees = 0;

    </script>
    <c:forEach items="${company.employees}" varStatus="i" var="employee">
        <script type="text/javascript">
            numberOfEmployees = numberOfEmployees + 1;

        </script>
        <h3>${i.index + 1}. Employee Info</h3>

        <div>
            <table>
                <tr>
                    <td>First Name:</td>
                    <td>${employee.firstName}</td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td>${employee.lastName}</td>
                </tr>
                <tr>
                    <td>Birth Date:</td>
                    <fmt:formatDate value="${employee.birthDate}" var="dateString" pattern="dd.MM.yyyy"/>
                    <td>${dateString}</td>
                </tr>
                <tr>
                    <td>E-Mail:</td>
                    <td>${employee.eMail}</td>
                </tr>
            </table>
        </div>
    </c:forEach>
</div>
</body>
</html>