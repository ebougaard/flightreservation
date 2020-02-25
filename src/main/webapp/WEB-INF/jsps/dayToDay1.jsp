<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>

    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>
    <<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </div>
</head>
</html>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </div>

</head>
</html>



</head>
<style></style>
<body>
<table id="birthDay" class="table table-striped table-bordered" style="width:100%">
<thead>
<tr>
<th>Name</th>
<th>Telephone Number</th>
<th>Email</th>
</tr>
</thead>
<tbody>
<c:forEach var="data" items="${clientData}">
<tr>
<td><c:out value="${data.name}"></c:out></td>
<td><c:out value="${data.tel_home}"></c:out></td>
<td><c:out value="${data.email}"></c:out></td>
</tr>
</c:forEach>
</tbody>
<tfoot>
<tr>
<th>Name</th>
<th>Telephone Number</th>
<th>Email</th>
</tr>
</tfoot>
</table>
    <script>
       var $table = $('#birthDay');
       $table.DataTable({
           lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','ALL']],
           pageLength: 5 ,
         ajax: {
           url:"/admin/dayToDay1",
           dataSrc: ''
         },
           columns:[
               {
                   data:'name'
               },
               {
                   data:'tel_home'
               },
               {
                   data:'email'
               },
           ]
       });

    </script>
            </html>