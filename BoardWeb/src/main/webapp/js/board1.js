/*
* board.js
* XMLHttpRequest. fetch => 실행순서
*/
let page = 1;

// 함수선언식 - 함수표현식
// 목록출력
function successCallback(result) {
	console.log(result);
	//기존목록 지우기
	document.querySelectorAll('div.reply div.content>ul>li').forEach(function(item, idx) {
		if (idx) { // truthy, falsy(0, null, '', undefined)
			item.remove();
		}
	});
	result.forEach(item => {
		makeRow2(item);
	});
}

function errorCallback(err) {
	console.error(err);
}

//페이징 콜백
function pagingCallback(result) {
	let paging = document.querySelector('nav>ul.pagination');
	paging.innerHTML = "";
	console.log(result.totalCnt);
	let totalCnt = result.totalCnt;
	
	// 첫페이지, 마지막펭지, => 현재페이지로 계산
	let startPage, endPage;
	
	
	// 페이지 갯수
	endPage = Math.ceil(page / 10) * 10;
	startPage = endPage - 9;
	let realEnd = Math.ceil(totalCnt / 5);
	endPage = endPage > realEnd ? realEnd : endPage;
	let prev = startPage == 1 ? false : true;
	let next = endPage < realEnd ? true : false;

	

	
	// 이전페이지
	if(!prev){
	let	html = `<li class = "page-item disabled">
					   <span class = "page-link">Previous</span>
					   </li>`;
	let target = document.querySelector(`nav>ul.pagination`);
	target.insertAdjacentHTML('beforeend', html);
	} else{
		let html = 
		`<li class = "page-item">
		 <a class = "page-link" href = "#" data-page = "${startPage-1}">Previous</a>
		 </li>`;
	let target = document.querySelector('nav>ul.pagination');
	target.insertAdjacentHTML('beforeend', html);
	}
	
	
	// 페이징
	for (let p = startPage; p <= endPage; p++) {
		let html = `<li class="page-item"><a class="page-link" href="#" data-page="${p}">${p}</a></li>`;
		if (p == page){
			html = `<li class = "page-item active" aria-current = "page">
			          <span class = "page-link">${p}</span>
					</li>`
		}
		let target = document.querySelector('nav>ul.pagination')
		target.insertAdjacentHTML('beforeend', html);
	}
	
	
	// 다음페이지
	if(!next){
		let	html = `<li class = "page-item disabled">
						   <span class = "page-link">Next</span>
						   </li>`;
		let target = document.querySelector(`nav>ul.pagination`);
		target.insertAdjacentHTML('beforeend', html);
		} else{
			let html = 
			`<li class = "page-item">
			 <a class = "page-link" href = "#" data-page = "${endPage+1}">Next</a>
			 </li>`;
		let target = document.querySelector('nav>ul.pagination');
		target.insertAdjacentHTML('beforeend', html);
		}
	
	
	
	
	// 링크이벤트
	pageLink();
}

// 삭제함수
function deleteFnc(rno = 21) {
	let deleteOK = confirm("삭제하겠습니까")
	if (!deleteOK) {
		return;
	}
	svc.removeReply(rno// 삭제할 댓글번호
		, function(result) {
			console.log(result);
			if (result.retCode == 'OK') {
				alert("삭제성공");
			}
			document.querySelector(`#rno_${rno}`).remove();
		}
		, errorCallback);
}
// 이벤트
document.querySelector('button.addReply').addEventListener('click', function(e) {
	//등록
	if (replyer == '') {
		alert('로그인이 필요합니다.');
		return;
	}
	// bno, replyer, reply: #reply.value 속성
	let reply = document.querySelector('#reply').value;
	if (reply == '') {
		alert('댓글을 등록하세요.');
		return;
	}
	// console.log(bno, reply, replyer);
	svc.addReply({ bno, reply, replyer } // 등록하기위한 첫뻔째 빠라미터)
		, function(result) {
			if (result.retCode == 'OK') {
				alert('등록성공');
				let item = result.retVal // 반환결과값 활용
				makeRow2(item);
			} else {
				alert('등록실패');
			}

		}, errorCallback);

})
// 페이지 링크에 이벤트 등록
function pageLink(){
document.querySelectorAll('div.reply ul a').forEach(function(tag) {
	tag.addEventListener('click', function(e) {
		e.preventDefault(); // 이벤트의 기본기능 차단...........
		page = tag.dataset.page;
		//댓글목록
		svc.replyList({ bno, page }, successCallback, errorCallback);
		//페이징목록
		svc.pagingList(bno, pagingCallback, errorCallback);
	});
});
}

// 목록보여주기
svc.replyList({bno, page}, successCallback, errorCallback);
// 페이징목록 보여주기
svc.pagingList(bno, pagingCallback, errorCallback);

// 댓글정보 -> 화면출력
function makeRow2(item) {
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
setTimeout(function() {
	console.log('1');
	setTimeout(function() {
		console.log('2');
		setTimeout(function() {
			console.log('3');
		}, 1000);
	}, 1000);
}, 1000);
