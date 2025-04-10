<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset='utf-8' />
  <script src='js/index.global.js'></script>
  <script>
    document.addEventListener('DOMContentLoaded', async function () {
      console.log('1')
      let events = [];
      // ajax call

      console.log('2')
      await fetch(`eventList.do`)
        .then(result => result.json()) // [{title, start, end}]
        .then(result => {
          events = result.map(ev => {
            return {
              title: ev.TITLE,
              start: ev.START_DATE,
              end: ev.END_DATE
            };
          });
        }).catch(err => console.log(err));
      console.log(events);


      var calendarEl = document.getElementById('calendar');

      console.log('3');
      var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },
        initialDate: '2025-04-10',
        navLinks: true, // can click day/week names to navigate views
        selectable: true,
        selectMirror: true,

        select: async function(arg){
          console.log(arg);
        var title = prompt('Event title: ');
        if(title){
          let allDay = arg.allDay;
          let start = allDay ? arg.startStr : arg.startStr.subString(0, 19);
          let end = allDay ? arg.endStr : arg.endStr.subString(0, 19);

          // let r1 = await fetch('addEvent.do?title='+title+'&start='+start+'&end='+end);
          let r1 = await fetch('addEvent.do', {
            method: 'post', 
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            body: 'title='+title+'&start='+start+'&end='+end
          });
          let r2 = await r1.json();
          if(r2.retCode == 'OK')
          calendar.addEvent({
            title: title,
            start: arg.start,
            end: arg.ned,
            allDay: arg.allDay
          })
          else
            alert('등록실패');
        }
        calendar.unselect();
      },
        eventClick: function (arg) {
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