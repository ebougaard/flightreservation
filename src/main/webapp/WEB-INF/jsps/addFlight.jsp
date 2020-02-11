<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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


<h3>AltHealth Information Management </h3>
<p>please use the"Dropdown" for the Administration </p>

</body>
</html>