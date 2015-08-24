<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ParseLog</title>
    <script src="jquery/jquery-2.1.4.min.js"></script>
    <script>

      function startParse() {
          var tableContainerElement = document.getElementById('tableContainer');
          var htmlText = "<table><thead><tr><td>date</td><td>time</td><td>ip</td><td>manager</td><td>driver</td><td>order</td></thead>";
          $.getJSON("/parselog", function(data) {
              $.each(data, function (key, val ) {
                  htmlText += "<tr><td>" + val.date + "</td>";
                  htmlText += "<td>" + val.time + "</td>";
                  htmlText += "<td>" + val.ip + "</td>";
                  htmlText += "<td>" + val.manager + "</td>";
                  htmlText += "<td>" + val.driver + "</td>";
                  htmlText += "<tr><td>" + val.order + "</td>";
                  htmlText += "</tr>"
              });
              htmlText += "</table>";
              tableContainerElement.innerHTML = htmlText;
          });

      }

    </script>
  </head>
  <body>
  <form>
    <input type="button" value="Start" onclick="startParse()"/>
  </form>

  <div id="tableContainer">

  </div>

  </body>
</html>
