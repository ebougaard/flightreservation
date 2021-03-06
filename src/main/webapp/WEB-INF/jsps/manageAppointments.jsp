<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<html>
<head>
  <title>AltHealth</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>
<body>

<div class="navbar">
  <a href="showAddFlight">Home</a>
   <div class="dropdown">
      <button class="dropbtn">Appointments
        <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
        <a href="displayAppointments">Add Appointments</a>
      </div>
    </div>

     <div class="dropdown">
        <button class="dropbtn">Clients
          <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
          <a href="displayLocations">Clients</a>
        </div>
      </div>

       <div class="dropdown">
                <button class="dropbtn">Suppliers
                  <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                  <a href="displayLocation">Suppliers</a>

                </div>
              </div>

                   <div class="dropdown">
                              <button class="dropbtn">Products
                                <i class="fa fa-caret-down"></i>
                              </button>
                              <div class="dropdown-content">
                                <a href="displaySupplements">Supplements</a>
                              </div>
                            </div>
      </div>


<div class="container">
  <h2>Manage Clients</h2>
  <span class="float-right"><a href="dayToDay1" type="button" class="btn btn-primary">Display Weekly Birthdays</a></span>
  <a href="displayNumberOfAppointments" type="button" class="btn btn-primary">Number of Appointments</a>
  <a href="generateReport" type="button" class="btn btn-primary">Reference Report</a>
  <table class="table">
    <thead>
      <tr>

<th>Name</th>
<th>Surname</th>
<th>Address</th>
<th>Code</th>
<th>Tel_Home</th>
<th>Tel_Work</th>
<th>Tel_Cell</th>
<th>E-mail</th>
<th>Reference</th>

</tr>

<c:forEach items="${clientData}" var="clientData">
<tr>
<td>${clientData.name}</td>
<td>${clientData.surname}</td>
<td>${clientData.address}</td>
<td>${clientData.code}</td>
<td>${clientData.tel_home}</td>
<td>${clientData.tel_work}</td>
<td>${clientData.tel_cell}</td>
<td>${clientData.email}</td>
<td>${clientData.reference}</td>
<td><a href="deleteLocation?id=${clientData.clientId}">delete</a></td>
<td><a href="showUpdate?id=${clientData.clientId}">edit</a></td>
</tr>
</c:forEach>

    </tbody>
  </table>
  <a href="showCreate" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">New Client</a>
</div>


</body>
</html>