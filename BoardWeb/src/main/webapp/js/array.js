/**
 * 어레이.js
 * push, unshift 추가
 * pop, shift 제거
 * splice 추가, 수정, 삭제
 * forEach()
 */
const ary = [];
// push, unshift
ary.push('홍길동'); // 마지막 위치에 추가
ary.push('봉길동');
ary.unshift('이길동');

//ary.pop(); // 삭제
//ary.shift(); // 삭제

//ary.splice(0, 1); // (첫번째 위치, 크기, 대체할 값) 

ary.forEach(function(item, idx, ary) {
	console.log(`item=>${item}, index=> ${idx}, array=>${ary}`);
});

// 함수
function addElement(elem = "noElem"){
	ary.push(elem);
}

//화면에서 요소 제거하는 함수
function deleteElement(e) {
	alert(`삭제버튼 클릭됨`);
	console.log(e.target.parentElement);
	e.target.parentElement.remove();
}


// 추가버튼에 클릭 이벤트
document.querySelector('button#addBtn').addEventListener('click', function() {
	let val = document.querySelector('input#userInput').value;
	addElement(val); // ary배열에 추가
	// 화면에 출력
	let html = '';
	ary.forEach(function(item, idx, ary){
		html += '<li>'+item + '<button onclick = "deleteElement(event)">삭제</button></li>';
		});
	// ul태그 영역
		document.querySelector('ul#list').innerHTML = html;
	});