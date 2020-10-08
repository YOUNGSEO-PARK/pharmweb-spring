<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charest=EUC-KR" pageEncoding="euc-kr" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>�������_���ver._ȸ������</title>
</head>

<body>
    <table border="1">
        <thead>
            <tr>
                <th>���̵�</th>
                <th>��й�ȣ</th>
                <th>opentime</th>
                <th>closetime</th>
                <th>�౹�̸�</th>
                <th>�ּ�</th>
                <th>����ڵ�Ϲ�ȣ</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pharmacyList}" var="pharmacy">
                <tr>
                    <td>${pharmacy.pharm_id}</td>
                    <td>${pharmacy.pharm_pw}</td>
                    <td>${pharmacy.opentime}</td>
                    <td>${pharmacy.closetime}</td>
                    <td>${pharmacy.pharm_name}</td>
                    <td>${pharmacy.pharm_adr}</td>
                    <td>${pharmacy.regi_no}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>