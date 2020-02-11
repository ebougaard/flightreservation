<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>AltHealth</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
    /* Remove the navbar's default margin-bottom and rounded borders */
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }

    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">

        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="index.html">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
            </ul>

        </div>
    </div>
</nav>

<div class="container">
  <h2>Available Appointments:</h2>
  </br>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Airlines</th>
        <th>Departure</th>
        <th>Arrival</th>
        <th>Departure Time</th>
        <th>Departure Time</th>
        <th>Departure Time</th>
        <th>Secure time </th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${appointments}" var="appointments">
      <tr>
        <td>${appointments.locationNumber}</td>
        <td>${appointments.company}</td>
        <td>${appointments.location}</td>
        <td>${appointments.dateOfAppointment}</td>
        <td>${appointments.location}</td>
        <td>${appointments.time}</td>
        <td><a href="showCompleteReservation?appointmentId=${appointments.id}">Select</a></td>
      </tr>
        </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>