<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>gov.jsp</title>
<link href = "css/styles.css" rel="stylesheet" />
</head>
<body>
  <select id = "choice" class = "form-control">
  </select>
  
  <!-- 센터목록테이블 -->
  <table class = "table table-striped">
    <thead>
      <tr>
        <th>ID</th><th>센터명</th><th>연락처</th><th>시도정보</th>
        </tr>
        </thead>
        <tbody id = "centerList"></tbody>
        </table>
<script>
  let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=2kZS3d3whovUk5wiSrdo1yjrjCN2KVq7Gvxsbjr3B2WyAO%2BBn0T%2Be2w2a6Uq00O9Iy2jmYyRhvy%2FEMXXlxwqaw%3D%3D';
  // 센터목록 저장 배열
  let centerList = []; 
  fetch(url)
    .then(result => result.json())
    .then(result => {
		centerList = result.data; // 센터전체
    let sidoAry = []; // 284건의 센터정보
    centerList.forEach(center => {
      if(sidoAry.indexOf(center.sido) == -1){
        sidoAry.push(center.sido); // 중복되지 않은 값만 등록
      } 

    })
    console.log(sidoAry);
    // 시도정보 생성
    sidoAry.forEach(sido => {
      let opt = document.createElement('option');
      opt.innerHTML = sido;
      document.querySelector('#choice').appendChild(opt);
    })
    // 초기목록 출력
		centerList.forEach((center,idx) => {
      if(idx < 10){
        let tr = makeCenter(center); // center 정보활용 tr 생성
        document.querySelector("#centerList").appendChild(tr);
      }
		})
    .catch(err => console.error(err));
  })

    // 이벤트 this 1) 함수 : window
    document.querySelector('#choice').addEventListener('change', function(e){
      let val = this.value;
      document.querySelector("#centerList").innerHTML = ""; // 목록지우기
      centerList
      .filter(center => center.sido == val)
      .forEach((center, idx) => {
        let tr = makeCenter(center); // 
        document.querySelector("#centerList").appendChild(tr);
      });
    });
  
  function makeCenter(center={}){
		let tr = document.createElement('tr');
		tr.addEventListener('click', function(e){
			openWindow(center);
		});
		let fields = ['id', 'centerName', 'phoneNumber', 'sido'];
		// td 생성
		fields.forEach(field => {
			let td = document.createElement('td');
			td.innerHTML = center[field];
			tr.appendChild(td);
	})
	return tr;

    }
  		// tr클릭 이벤트 핸들러 생성
  		function openWindow(center={}){
  			window.open("map.jsp?lat="+center.lat+"&lng="+center.lng);
  		}
  </script>
</body>
</html>