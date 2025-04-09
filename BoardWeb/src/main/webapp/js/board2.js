/**
 * 보드2.js
 * 도와줘 지피티에몽
 */
console.log(`replyListDatatable.do?bno=${bno}`)
const table = new DataTable('#example', {
    ajax: 'replyListDatatable.do?bno='+bno,
    columns: [
        { data: 'REPLY_NO' },
        { data: 'REPLY' },
        { data: 'REPLYER' },
        { data: 'REPLY_DATE' }
    ],
	lengthMenu: [
	      [5, 10, 25, 50, -1],
	      [5, 10, 25, 50, 'All']
	  ],
	  order: [[0, 'desc']]
});

// 댓글추가 
function addNewRow() {
	// control 을 통 해서 'db' 한 건 생성
	fetch('addReply.do?bno='+bno+'&replyer='+replyer+'&reply='+addContent.value)
	.then(result => result.json())
	.then(result => {
	  if(result.retCode == 'OK'){
    	table.row
        .add({
            REPLY_NO: result.retVal.replyNo, 
            REPLY: result.retVal.reply,
            REPLYER: result.retVal.replyer,
            REPLY_DATE: result.retVal.replyDate,
        })
        .draw(false);
		}
	})
	.catch(err => console.error(err));	
}

 
document.querySelector('#addRow').addEventListener('click', addNewRow);
 
// 댓글선택
table.on('click', 'tbody tr', (e) => {
	console.log(e);
	
    let classList = e.currentTarget.classList; // class 목록()
 
	// classList에 contains('클래스명'), 제거(remove('클래스명'), 추가(add('클래스명')))
    if (classList.contains('selected')) {
        classList.remove('selected');
    }
    else {
        table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
        classList.add('selected');
    }
});
 
// 댓글삭제
document.querySelector('#delRow').addEventListener('click', function () {
    // 선택된 댓글이 있는지 확인
    const selectedRow = table.row('.selected');
    
    if (selectedRow.length) {
        // 선택된 댓글의 REPLY_NO 값을 가져오기
        const replyNo = selectedRow.data().REPLY_NO;

        // 서버로 삭제 요청 보내기
        fetch('removeReply.do?rno=' + replyNo
        )
        .then(result => result.json())  // 서버의 응답을 JSON으로 파싱
        .then(result => {
            if (result.retCode === 'OK') {
                selectedRow.remove().draw(false);
                alert('댓글이 삭제되었습니다.');
            } else {
                alert('댓글 삭제에 실패했습니다. 다시 시도해주세요.');
            }
        })
        .catch(err => {
            console.error(err);
            alert('댓글 삭제 중 오류가 발생했습니다.');
        });
    } else {
        // 댓글이 선택되지 않았을 경우
        alert('삭제할 댓글을 선택해주세요.');
    }
});

