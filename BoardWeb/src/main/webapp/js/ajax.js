/**
 *아작스.js 
 */
let dataAry;
 const xhtp = new XMLHttpRequest();
 xhtp.open('get', 'data/MOCK_DATA.json'); // 경로지정
 xhtp.send();
 xhtp.onload = function(){ // load 이벤트 발생
	let obj = JSON.parse(xhtp.responseText);
	console.log(obj);
	dataAry = obj;
	//화면출력
	obj.forEach(function(item, idx, ary){
		let tr = makeRow(item);
		document.querySelector('tbody#target').appendChild(tr);
		});
 }
 
 function makeRow(emp = {id, first_name, last_name, email, gender, salary}) {
 	const fields = ['id', 'first_name', 'last_name', 'gender'];
 	let tr = document.createElement('tr'); // <tr></tr>
	
	// 체크박스
	let tdd = document.createElement('td');
	let ckbox = document.createElement('input');
	ckbox.setAttribute('type', 'checkbox');
	tdd.appendChild(ckbox);
	tr.appendChild(tdd);
	
 	for(let i = 0; i<fields.length; i++){
 		let td = document.createElement('td'); // <td></td>
 		td.innerHTML = emp[fields[i]];  // <tr><td>1</td></tr>
 		tr.appendChild(td);
 	}
	// button 샹송
	let td = document.createElement('td');
    let btn = document.createElement('button');
	btn.setAttribute('class', 'btn btn-danger');
	btn.innerText = '삭제';
	btn.addEventListener('click', deleteRow)
	// 부모자식
	td.appendChild(btn);
	tr.appendChild(td);
 	return tr;
}

	//삭제
	function deleteRow(e){
	console.log(e.target);
	e.target.parentElement.parentElement.remove();
}

	// thead의 체크박스에 이벤트(change)등록
	document.querySelector('thead input[type="checkbox"]').addEventListener('change', function(e) {
		// tbody 영역의 checkbox값 변경
		let checked = e.target.checked; // thead 영역의 checkbox
		document.querySelectorAll('tbody input[type="checkbox"]').forEach(function(item) {
			item.checked = checked;
		})
	})
	
	/* document.addEventListener('DOMContentLoaded', function() {
	           let checkbox = document.querySelector(`thead input[type = "checkbox"]`);
	           checkbox.addEventListener('change', function() {
	               let checkboxes = document.querySelectorAll('tbody#target input[type="checkbox"]');
	               checkboxes.forEach(function(c) {
	                   c.checked = checkbox.checked;
	               });
	           });
	       });
	*/
	
	
	// select의 change 이벤트
	//도와줘 지피티에몽
	
	document.querySelector('select#searchGender').addEventListener('change', function(e){
		console.log(e.target.value);
		let gendervalue = e.target.value;
		// dataAry의 배열을 애용해서 출력	
		// dataAry의 gender 속성을 비교해서 출력하기(출력하기전에 목록을 초기화)
		document.querySelector('tbody#target').innerHTML = "";
		dataAry.forEach(function(item){
			// 같은값만 출력
			if(gendervalue == 'all' || item.gender == gendervalue){
			let tr = makeRow(item);
			document.querySelector('tbody#target').appendChild(tr);
			}
		});
		
	});
	

