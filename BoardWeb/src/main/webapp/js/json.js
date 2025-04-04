/**
 * 제이슨.js
 */
const jsonStr = `[{"id":1,"first_name":"Silvan","last_name":"Copcutt","email":"scopcutt0@springer.com","gender":"Male","salary":6934},
{"id":2,"first_name":"Alick","last_name":"Quincey","email":"aquincey1@vimeo.com","gender":"Male","salary":2243},
{"id":3,"first_name":"Sadella","last_name":"Nowland","email":"snowland2@google.com.au","gender":"Female","salary":2258},
{"id":4,"first_name":"Andy","last_name":"Fencott","email":"afencott3@utexas.edu","gender":"Female","salary":2940},
{"id":5,"first_name":"Nickola","last_name":"Denford","email":"ndenford4@irs.gov","gender":"Male","salary":7644},
{"id":6,"first_name":"Hanson","last_name":"MacArdle","email":"hmacardle5@archive.org","gender":"Male","salary":3981},
{"id":7,"first_name":"Cristine","last_name":"Fruin","email":"cfruin6@wisc.edu","gender":"Female","salary":5147},
{"id":8,"first_name":"Roanna","last_name":"Georgius","email":"rgeorgius7@toplist.cz","gender":"Female","salary":8358},
{"id":9,"first_name":"Burl","last_name":"Matys","email":"bmatys8@biglobe.ne.jp","gender":"Male","salary":3737},
{"id":10,"first_name":"Lora","last_name":"Kubera","email":"lkubera9@goo.gl","gender":"Bigender","salary":9425},
{"id":11,"first_name":"Lucho","last_name":"Widdowes","email":"lwiddowesa@ebay.com","gender":"Male","salary":4893},
{"id":12,"first_name":"Vladimir","last_name":"Skullet","email":"vskulletb@slashdot.org","gender":"Male","salary":4098},
{"id":13,"first_name":"Pincas","last_name":"Bambery","email":"pbamberyc@booking.com","gender":"Male","salary":3748},
{"id":14,"first_name":"Yoshiko","last_name":"Petrus","email":"ypetrusd@techcrunch.com","gender":"Female","salary":2988},
{"id":15,"first_name":"Vania","last_name":"Rhymer","email":"vrhymere@paginegialle.it","gender":"Female","salary":7688}]`;

let obj = JSON.parse(jsonStr); // json 문자열 -> object 변경
let str = JSON.stringify(obj); // object -> json 문자열 변경
console.log(obj[2].last_name);

// 데이터 1건을 매개값으로 tr 생성하는 함수
function makeRow(emp = {id, first_name, last_name, email, gender, salary}) {
	const fields = ['id', 'first_name', 'last_name', 'email'];
	let tr = document.createElement('tr'); // <tr></tr>
	for(let i = 0; i<fields.length; i++){
		let td = document.createElement('td'); // <td></td>
		td.innerHTML = emp[fields[i]];  // <tr><td>1</td></tr>
		tr.appendChild(td);
	}
	return tr;
}

//화면에출력
obj.forEach(function(item, idx, ary){
	let tr = makeRow(item);
	document.querySelector('tbody#target').appendChild(tr);
	});
