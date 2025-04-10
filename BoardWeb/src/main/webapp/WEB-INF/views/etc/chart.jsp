<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      async function drawChart() {
		var dataAry = []; // 멤버별로 건수
		dataAry.push(['username', 'Count Per User']);
		
		let r1 = await fetch('chartJson.do');
		let r2 = await r1.json();
		r2.forEach(item => {
			console.log(item);
			dataAry.push([item.username, item.cnt]);
		})
        var data = google.visualization.arrayToDataTable(dataAry);

        var options = {
          title: '사용자별 작성건수',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options); // 
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
