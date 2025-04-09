<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='js/index.global.js'></script>
<script>

document.addEventListener('DOMContentLoaded', async function() {
	let events = [];
	await fetch(`eventList.do`)
	  .then(result => result.json())
	  .then(result=> {
		  events = result.map(ev => {
			return{
				title: ev.TITLE,
				start: ev.START_DATE,
				end: ev.END_DATE
				};
		  });
		}).catch(err => console.log(err));
	console.log(events);
	
	
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      initialDate: '2025-04-09',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      
      
      select: async function(arg) {
        var title = prompt('Event Title:');
        if (title) {
         await fetch(`addEvent.do?title=${title}&start=${arg.startStr}&end=${arg.endStr}`)
         .then(result => result.json())
         .then(result => {
			if (result.retVal == "OK")
				alert("추가되었습니다")
			}).catch(err => console.log(err));
         
         	calendar.addEvent({
				title: title,
				start: arg.start,
				end: arg.end,
				allDay: arg.allDay})
          }
        },
      eventClick: function(arg) {
        if (confirm('Are you sure you want to delete this event?')) {
          arg.event.remove()
        }
      },
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: events
    });

    calendar.render();
  });

</script>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 1100px;
    margin: 0 auto;
  }

</style>
</head>
<body>

  <div id='calendar'></div>

</body>
</html>
