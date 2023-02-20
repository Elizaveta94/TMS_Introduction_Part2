<%@ page import="com.tms.model.UserRideResult" %>
<%@ page import="com.tms.model.WinStat" %>
<%@ page import="com.tms.model.RideResult" %>
<%@ page import="com.tms.model.PairResult" %>
<%@ page import="com.tms.model.CircleResult" %>
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

<h2>Your <%
 UserRideResult userRideResult = (UserRideResult) request.getAttribute("userRideResult");
 WinStat winStat = userRideResult.getWinStat();
 if(winStat.isYouWin()) {
 out.println("Win: " + winStat.getWinBalance());
 }else{ out.println("Lose!");
 }
 %></h2>

 <h3>Winner: <%
out.println("Pair number: " + winStat.getWinner().getNumber() + ". Rider: " + winStat.getWinner().getRider().getNumber() + ". Horse: " + winStat.getWinner().getRider().getNumber());
  %></h3>

<table class="table table-sm">
   <thead class="table-dark">
    <tr>
      <th scope="col">Circle</th>
      <%
      List<CircleResult> circleResults = userRideResult.getRideResult().getCircleResults();
      for(int i = 1; i <= circleResults.get(0).getPairResults().size(); i++) {
      out.println("<th scope=\"col\">Place " + i + "</th>");
      }
      %>
    </tr>
  </thead>
   <tbody>
 <%
        for(CircleResult circleResult:circleResults){
        out.println("<tr><td>" + circleResult.getCircle() + "</td>");
        for (PairResult pairResult:circleResult.getPairResults()) {
        out.println("<td>pair: " + pairResult.getPair().getNumber() + "</td>");
        }
        out.println("</tr>");
        }
%>
      </tbody>
</table>

</body>
</html>