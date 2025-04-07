/*
* board.js
* XMLHttpRequest. fetch => 실행순서
*/

	
// 함수선언식 - 함수표현식
function successCallback(result){
		console.log(result);
		result.forEach(item => {
			makeRow2(item);
		});
	}
		
function errorCallback(err){
		console.error(err);
	}
	
	// 삭제함수
function deleteFnc(rno = 21){
	let deleteOK = confirm("삭제하겠습니까")
	if(!deleteOK){
		return;
	}
	svc.removeReply(rno// 삭제할 댓글번호
		, function(result){
			console.log(result);
			if(result.retCode == 'OK'){
				alert("삭제성공");
			}
			document.querySelector(`#rno_${rno}`).remove();
		}
		, errorCallback);
}
	// 이벤트
document.querySelector('button.addReply').addEventListener('click', function(e){
	//등록
	if(replyer == ''){
		alert('로그인이 필요합니다.');
		return;
	}
	// bno, replyer, reply: #reply.value 속성
	let reply = document.querySelector('#reply').value;
	if(reply == ''){
		alert('댓글을 등록하세요.');
		return;
	}
	// console.log(bno, reply, replyer);
	svc.addReply({bno, reply, replyer} // 등록하기위한 첫뻔째 빠라미터)
	,function(result){
		if(result.retCode == 'OK'){
			alert('등록성공');
			let item = result.retVal // 반환결과값 활용
			makeRow2(item);
		} else{
			alert('등록실패');
		}	
		
	},errorCallback);
	
})


	// 목록보여주기
svc.replyList(bno, successCallback, errorCallback);

	// 댓글정보 -> 화면출력
function makeRow2(item){
	let html = `<li data-rno="${item.replyNo}" id = "rno_${item.replyNo}">
	         <span class = "col-sm-2">${item.replyNo}</span>
	         <span class = "col-sm-5">${item.reply}</span>
	         <span class = "col-sm-2">${item.replyer}</span>
	         <span class = "col-sm-2"><button class = "btn btn-primary" onclick = "deleteFnc(${(item.replyNo)})">삭제</button></span>
	       </li>`
	let templ = document.querySelector('div.content>ul');
	templ.insertAdjacentHTML('beforeend', html);
}
	
// 동기, 비동기(Asynchronous Javascript and Xml)
setTimeout(function(){
	console.log('1');	
	setTimeout(function(){
		console.log('2');	
		setTimeout(function(){
			console.log('3');	
		}, 1000);
	}, 1000);
}, 1000);




