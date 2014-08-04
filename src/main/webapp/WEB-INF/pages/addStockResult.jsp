<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Stock Information</h2>
<table>
    <tr>
        <td>Stock Name</td>
        <td>${stock.stockCode}</td>
    </tr>
    <tr>
        <td>Age</td>
        <td>${stock.stockName}</td>
    </tr>
</table>
<a href="/stocker/stock">Add another</>
</body>
</html>