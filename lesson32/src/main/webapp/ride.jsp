<%@ page import="com.tms.model.Horse" %>
<%@ page import="com.tms.model.User" %>
<%@ page import="com.tms.model.Rider" %>
<%@ page import="com.tms.model.Pair" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
    <title>2XBet</title>
</head>
<body>

<style>
   body {
    background: url(https://flomaster.club/uploads/posts/2022-12/1672285712_flomaster-club-p-vsadnik-risunok-dlya-detei-krasivo-1.jpg) no-repeat;
    -moz-background-size: 100%;
    -webkit-background-size: 100%;
    -o-background-size: 100%;
    background-size: 100%;
   }
</style>

<h1>2XBet Rides</h1>

<h2>Your balance: <% out.println(request.getAttribute("balance")); %></h2>

<form id="contacts" method="POST" action="pair">
      <input type="number" name="rider" placeholder="Enter rider number"/>
      <input type="number" name="horse" placeholder="Enter horse number"/>
      <input class="btn btn-dark" type="submit" value="Select pair">
</form>

<form id="contacts" method="POST" action="bet">
      <input type="number" name="pair" placeholder="Enter pair number"/>
      <input type="number" name="bet" placeholder="Enter your bet"/>
      <input class="btn btn-dark" type="submit" value="BET">
</form>

<table class="table table-sm">
   <thead class="table-dark">
    <tr>
      <th scope="col">Rider number</th>
      <th scope="col">Quantity of wins in 2022</th>
    </tr>
  </thead>
   <tbody>
 <%
        List<Rider> riders = (List<Rider>) request.getAttribute("riders");
        for (int i = 0; i < riders.size(); i++) {
            out.println("<tr><td>" + riders.get(i).getNumber() + "</td>");
            out.println("<td>" + riders.get(i).getWin() + "</td></tr>");
        }
%>
      </tbody>
</table>

<table class="table table-sm">
   <thead class="table-dark">
    <tr>
      <th scope="col">Horse number</th>
      <th scope="col">Quantity of wins in 2022</th>
    </tr>
  </thead>
   <tbody>
 <%
        List<Horse> horses = (List<Horse>) request.getAttribute("horses");
        for (int i = 0; i < horses.size(); i++) {
            out.println("<tr><td>" + horses.get(i).getNumber() + "</td>");
            out.println("<td>" + horses.get(i).getWin() + "</td></tr>");
        }
%>
      </tbody>
</table>

<table class="table table-sm">
   <thead class="table-dark">
    <tr>
      <th scope="col">Pair number</th>
      <th scope="col">Horse number</th>
      <th scope="col">Rider number</th>
    </tr>
  </thead>
   <tbody>
 <%
        List<Pair> pairs = (List<Pair>) request.getAttribute("pairs");
        for (int i = 0; i < pairs.size(); i++) {
            out.println("<tr><td>" + pairs.get(i).getNumber() + "</td>");
            out.println("<td>" + pairs.get(i).getHorse().getNumber() + "</td>");
            out.println("<td>" + pairs.get(i).getRider().getNumber() + "</td></tr>");
        }
%>
      </tbody>
</table>

</body>
</html>