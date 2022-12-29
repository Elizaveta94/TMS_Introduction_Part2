<%@ page import="com.tms.cars.model.Car" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
    <title>CARS</title>
</head>
<body>
<form id="contacts" method="GET" action="search">
      <input type="text" name="id" placeholder="Enter car's id" />
      <input class="btn btn-success" type="submit" value="Search">
</form>
<form id="contacts" method="POST" action="delete">
      <input type="text" name="id" placeholder="Enter car's id" />
      <input class="btn btn-danger" name ="delete" type="submit" value="Delete car">
</form>
<form id="contacts" method="POST" action="create">
      <input type="text" name="id" placeholder="Enter car's id"/>
      <input type="text" name="brand" placeholder="Enter car's brand"/>
      <input type="text" name="model" placeholder="Enter car's model"/>
      <input class="btn btn-primary" type="submit" value="Create car">
</form>

<table class="table table-success table-striped"">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Brand</th>
      <th scope="col">Model</th>
      <th scope="col">Delete this car</th>
    </tr>
  </thead>
   <tbody>
 <%
        List<Car> cars = (List<Car>) request.getAttribute("cars");
        if (cars != null && !cars.isEmpty()) {
            for (Car car : cars) {
                out.println("<tr><td>" + car.getId() + "</td>");
                out.println("<td>" + car.getBrand()+ "</td>");
                out.println("<td>" + car.getModel() + "</td>");
                out.println("<td>" +
                "<form action= \"delete\" method=\"POST\">" +
               "<input class=\"btn btn-danger\" type=\"submit\" name=\"delete\" value=\"Delete\"/>" +
               "<input type=\"hidden\" name=\"id\" value=\"" + car.getId() + "\"/>" +
               "</form></td></tr>");
}
        }
%>
      </tbody>
</table>

</body>
</html>

