<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Add a Company</title>
    <style>
        table {
            width: 100%;
        }

        td.input-table-data {
            float: right;
        }

        form {
            background-color: #9CF;
            width: 18%;
            padding: 5px;
            border: 1px solid;
            border-radius: 9px;
            margin-left: auto;
            margin-right: auto;
            box-shadow: 0px 0px 10px #666;
        }

        div {
            background-color: #CCE6FF;
            padding-left: 5px;
            padding-right: 5px;
            padding-top: 2px;
            padding-bottom: 2px;
            border: 1px solid;
            border-radius: 9px;
        }

        input {
            width: 100%;
        }
    </style>
    <script type="text/javascript" type="text/javascript"
            src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body style="background-color: #E6E6E6;">
<a style="float:right;" href="/stocker/logout"> Logout</a>

<h2 style="margin-left: auto; margin-right: auto; width:18%; text-align: center;">Add a Company</h2>
<form:form method="post" modelAttribute="company" accept-charset="utf-8" action="/stocker/company">
    <h3 style="margin-top:0;">General Company Info</h3>

    <div>
        <table>
            <tr>
                <td><form:label path="companyCode">Company Code: </form:label></td>
                <td class="input-table-data"><form:input path="companyCode"/></td>
            </tr>
            <tr>
                <td><form:label path="companyName">Company Name: </form:label></td>
                <td class="input-table-data"><form:input path="companyName"/></td>
            </tr>
        </table>
    </div>
    <h3>Stock Info</h3>

    <div>
        <table>
            <tr>
                <td><form:label path="stock.stockCode">Stock Code: </form:label></td>
                <td class="input-table-data"><form:input path="stock.stockCode"
                                                         value="${company.stock.stockCode}"/></td>
            </tr>
            <tr>
                <td><form:label path="stock.stockName">Stock Name: </form:label></td>
                <td class="input-table-data"><form:input path="stock.stockName"
                                                         value="${company.stock.stockName}"/></td>
            </tr>
            <tr>
                <td><form:label path="stock.stockValue">Stock Value: </form:label></td>
                <td class="input-table-data"><form:input path="stock.stockValue"
                                                         value="${company.stock.stockValue}"/></td>
            </tr>
        </table>
    </div>
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
                    <td><form:label path="employees[${i.index}].firstName">First Name: </form:label></td>
                    <td class="input-table-data"><form:input path="employees[${i.index}].firstName"
                                                             value="${employee.firstName}"/></td>
                </tr>
                <tr>
                    <td><form:label path="employees[${i.index}].lastName">Last Name: </form:label></td>
                    <td class="input-table-data"><form:input path="employees[${i.index}].lastName"
                                                             value="${company.employees[i.index].lastName}"/></td>
                </tr>
                <tr>
                    <td><form:label path="employees[${i.index}].birthDate">Birth Date: </form:label></td>
                    <fmt:formatDate value="${employee.birthDate}" var="dateString" pattern="dd.MM.yyyy"/>
                    <td class="input-table-data"><form:input path="employees[${i.index}].birthDate"
                                                             value="${dateString}"/></td>
                </tr>
                <tr>
                    <td><form:label path="employees[${i.index}].eMail">E-Mail: </form:label></td>
                    <td class="input-table-data"><form:input path="employees[${i.index}].eMail"
                                                             value="${company.employees[i.index].eMail}"/></td>
                </tr>
            </table>
        </div>
    </c:forEach>
    <br>
    <span style="text-decoration:underline; cursor:pointer;"
          onclick="document.getElementById('company').action = '/stocker/company/e'.concat(numberOfEmployees + 1); document.getElementById('company').submit();">
        Add employee
    </span>
    <span style="text-decoration:underline; cursor:pointer; float:right;"
          onclick="document.getElementById('company').action = '/stocker/company/e'.concat(numberOfEmployees - 1); document.getElementById('company').submit();">
        Remove employee
    </span>
    <br>
    <br>
    <input onclick="document.getElementById('company').action = '/stocker/company';" type="submit" value="Submit"/>
</form:form>
</body>
</html>